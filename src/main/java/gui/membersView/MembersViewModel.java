package gui.membersView;

import dao.MembersDao;
import models.Members;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MembersViewModel extends AbstractTableModel{

    static String[] columnsNames = {"Name", "Surname", "e-mail", "mobile"};
    private List<Members> list;

    public MembersViewModel() {

        loadMembersFromDB();
    }

    private void loadMembersFromDB() {
        Session memberSess = HibernateUtil.openSession();
        MembersDao memberD = new MembersDao(memberSess);

        this.list = memberD.findAll();

        memberSess.close();
        fireTableDataChanged();
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
      Members member = list.get(rowIndex);
      switch (columnIndex){
          case 0: return member.getPerson().getName();
          case 1: return member.getPerson().getSurname();
          case 2: return member.getPerson().getEmail();
          case 3: return member.getPerson().getMobile();
      }
        return null;
    }


    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Members member = list.get(rowIndex);
        switch (columnIndex){
            case 0: member.getPerson().setName((String) aValue); break;
            case 1: member.getPerson().setSurname((String)aValue); break;
            case 2: member.getPerson().setEmail((String)aValue); break;
            case 3: member.getPerson().setMobile((String)aValue); break;
        }
        Session ses = HibernateUtil.openSession();
        org.hibernate.Transaction tx = ses.beginTransaction();

        ses.update(member.getPerson());
        tx.commit();
        ses.close();
        loadMembersFromDB();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

}
