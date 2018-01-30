package gui.membersView;

import dao.PersonsDao;
import models.Members;
import models.Persons;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MembersViewModel extends AbstractTableModel{

    static String[] columnsNames = {"Name", "Surname", "e-mail", "mobile"};
    static Object[][] data;
    private List<Members> list;

    public MembersViewModel(List<Members> list) {
        this.list = list;
    this.data = new Object[list.size()][columnsNames.length];

        for(int i = 0; i<list.size(); i++){
            data[i][0] = list.get(i).getPerson().getName();
            data[i][1] = list.get(i).getPerson().getSurname();
            data[i][2] = list.get(i).getPerson().getEmail();
            data[i][3] = list.get(i).getPerson().getMobile();
        }
    }

    /*@Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }*/

    public Members getList(int i){
        return list.get(i);
    }

    @Override
    public String getColumnName(int i){
      return columnsNames[i];
    }

    @Override
    public int getRowCount() {
        return list.size();
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
