package gui;

import gui.shedule.ScheduleViewTable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jenny on 27.01.2018.
 */
public class ScheduleWindow extends JPanel {

    public ScheduleWindow() {
        setLayout(new BorderLayout());
        JScrollPane sp = new JScrollPane(new ScheduleViewTable());
        add(sp, BorderLayout.CENTER);
    }
}
