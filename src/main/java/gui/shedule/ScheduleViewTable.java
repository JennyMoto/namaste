package gui.shedule;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScheduleViewTable extends JTable {

    public ScheduleViewTable() {
        setModel(new ScheduleViewModel());
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        setRowSelectionAllowed(false);

        getColumnModel().getColumn(0).setMaxWidth(50);

        for(int i=0;i<getColumnCount();i++){
            setDefaultRenderer(getColumnClass(i), new MyRenderer());
        }

        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                //System.out.println("KLIK "+"Rzad: "+getSelectedRow() +" Kolumna: "+ getSelectedColumn());

            }
        });

    }





}


