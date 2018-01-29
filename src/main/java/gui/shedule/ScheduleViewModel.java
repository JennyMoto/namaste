package gui.shedule;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class ScheduleViewModel extends AbstractTableModel{

    static String[] columnsNames = {"Time", "Monday", "Tuesday", "Wednesday","Thursday","Friday","Saturday","Sunday"};
    static Object[][] data = new Object [13*4][8];

    public ScheduleViewModel() {

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
                else
                    this.data[i][j] = "";
            }

        }
    }

    /*@Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }*/


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

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex]=aValue;
    }


}
