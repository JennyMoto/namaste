package gui.membersView;

import dao.PersonsDao;
import models.Members;
import models.Persons;

import javax.swing.*;
import java.util.List;

public class MembersViewTable extends JTable {

    private MembersViewModel mvm;

    public MembersViewTable() {
        mvm = new MembersViewModel();
       setModel(mvm);
       setAutoCreateRowSorter(true);
    }

    @Override
    public MembersViewModel getModel(){
        return mvm;
    }



}


