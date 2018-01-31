package gui.membersView;

import dao.MembersDao;
import dao.PersonsDao;
import models.Members;
import models.Persons;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MembersViewModel extends AbstractTableModel{

    static String[] columnsNames = {"Name", "Surname", "e-mail", "mobile"};
    private Object[][] data;
    private List<Members> list;

    public MembersViewModel() {
        loadMembersFromDB();
    }

    /*@Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }*/

    private void loadMembersFromDB() {
        Session memberSess = HibernateUtil.openSession();
        MembersDao memberD = new MembersDao(memberSess);

        this.list = memberD.findAll();
        prepareDataForView();

        memberSess.close();
        fireTableDataChanged();
    }

    private void prepareDataForView() {
        this.data = new Object[list.size()][columnsNames.length];

        for(int i = 0; i<list.size(); i++){
            data[i][0] = list.get(i).getPerson().getName();
            data[i][1] = list.get(i).getPerson().getSurname();
            data[i][2] = list.get(i).getPerson().getEmail();
            data[i][3] = list.get(i).getPerson().getMobile();
        }
    }

    public Members addMember(Members member) {
        try {
                Session ses = HibernateUtil.openSession();
                org.hibernate.Transaction tx = ses.beginTransaction();

                ses.persist(member.getPerson());
                ses.persist(member);
                tx.commit();
                ses.close();
                loadMembersFromDB();
                fireTableDataChanged();
                return member;
        } catch (Exception e) {};
        return null;
    }

    public void removeMember(int rowNumber) {
        Session ses = HibernateUtil.openSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        ses.delete(list.get(rowNumber));
        tx.commit();
        ses.close();
        loadMembersFromDB();
    }

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
