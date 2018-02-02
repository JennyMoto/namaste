package gui.shedule;

import dao.ClassesDao;
import models.Classes;
import org.hibernate.Session;
import util.DateUtil;
import util.HibernateUtil;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ScheduleViewModel extends AbstractTableModel{

    static String[] columnsNames = {"Time", "Monday", "Tuesday", "Wednesday","Thursday","Friday","Saturday","Sunday"};
    Object[][] data = new Object [13*4][8];
    Object[][] data2 = new Object[13*4][7];
    private List<List<Classes>> classes = new ArrayList<>();
    private Calendar currentDate;

    public ScheduleViewModel() {
        currentDate = Calendar.getInstance();

        int tmp = 8;
        for (int i = 0; i <this.getRowCount(); i++) {
            for (int j =0;j<columnsNames.length ;j++){
                if (j==0&&i%4==0) {
                    this.data[i][j] = String.valueOf(tmp)+".00";
                }
                else if (j==0&&i%4==1) {
                    this.data[i][j] = String.valueOf(tmp)+".15";
                }
                else if (j==0&&i%4==2) {
                    this.data[i][j] = String.valueOf(tmp)+".30";
                }
                else if (j==0&&i%4==3) {
                    this.data[i][j] = String.valueOf(tmp)+".45";
                    tmp++;
                }
                else {
                    this.data[i][j] = "";
                }
            }
        }

        getClassesForWeek();
    }

    /*@Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }*/

    private int convertTimeToRowNumber(int hour, int minutes) {
        if (hour < 8 || hour > 21) return -1;
        int rowNumber = (hour - 8) * 4 + (minutes / 15);
        return rowNumber;
    }

    public void getClassesForWeek() {
        Calendar monday = DateUtil.getNearestMondayToDate(currentDate);
        monday.set(Calendar.HOUR_OF_DAY, 0);
        monday.set(Calendar.MINUTE, 0);
        monday.set(Calendar.SECOND, 0);

        Session session = HibernateUtil.openSession();
        ClassesDao classesDao = new ClassesDao(session);
        classes.clear();
        for (int i = 0; i < 7; i++) {
            List<Classes> classesForDay = classesDao.findByStartDate(DateUtil.getTimestampFromCalendar(monday));
            for (Classes cls: classesForDay) {
                Calendar startDate = DateUtil.getCalendarFromTimestamp(cls.getStartDate());
                int startHour = startDate.get(Calendar.HOUR_OF_DAY);
                int startMinutes = startDate.get(Calendar.MINUTE);
                Integer duration = cls.getClassesType().getDuration();
                int startRow = convertTimeToRowNumber(startHour, startMinutes);

                Calendar stopDate = (Calendar) startDate.clone();
                stopDate.add(Calendar.MINUTE, Math.toIntExact(duration));
                int stopHour = stopDate.get(Calendar.HOUR_OF_DAY);
                int stopMinutes = stopDate.get(Calendar.MINUTE);
                int stopRow = convertTimeToRowNumber(stopHour, stopMinutes);

                System.out.printf("%d %d %d %s %d %d \n",
                        startHour, startMinutes, duration, cls.getClassesType().getName(),
                        startRow, stopRow);

                for (int j = startRow; j <= stopRow; j++) {
                    if (j >= 0 && j < 51) {
                        setValueAt(cls.getClassesType().getName(), j, 1 + i);
                        data2[j][i] = cls;
                    }
                }
            }

            classes.add(classesForDay);
            monday.add(Calendar.DATE, 1);
        }
        session.close();
    }

    @Override
    public String getColumnName(int i){
      return columnsNames[i];
    }

    @Override
    public int getRowCount() {
        return 13*4;
    }

    @Override
    public int getColumnCount() {
        return columnsNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    public Object getRealValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) return null;
        return data2[rowIndex][columnIndex - 1];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex]=aValue;
    }


}
