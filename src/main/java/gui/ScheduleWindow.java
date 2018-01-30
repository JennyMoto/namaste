package gui;

import gui.shedule.ScheduleViewTable;

import javax.swing.*;

/**
 * Created by Jenny on 27.01.2018.
 */
public class ScheduleWindow extends JPanel {

    public ScheduleWindow(){
           JScrollPane sp = new JScrollPane(new ScheduleViewTable());
           add(sp);
    }
}
