package gui.membersView;

import javax.swing.*;

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


