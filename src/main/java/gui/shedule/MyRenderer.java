package gui.shedule;

import models.Classes;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;


public class MyRenderer extends DefaultTableCellRenderer {

    Color backgroundColor = getBackground();

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        ScheduleViewModel model = (ScheduleViewModel) table.getModel();

//        if (row == table.getSelectedRow() && column == table.getSelectedColumn()&& column!=0) {
//            c.setBackground(Color.green.darker());
//        } else if (!isSelected) {
//            c.setBackground(backgroundColor);
//        }
        Classes realValue = (Classes) model.getRealValueAt(row, column);
        Color color = null;
        if (realValue != null) {
            color = new Color(realValue.getClassesType().getColor());
        }
        if (row == table.getSelectedRow() && column == table.getSelectedColumn() && column != 0) {
            if (color != null) {
                c.setBackground(color.darker());
            } else {
                c.setBackground(table.getSelectionBackground());
            }
        } else {
            if (color != null) {
                c.setBackground(color);
            } else {
                c.setBackground(table.getBackground());
            }
        }

        if (row % 4 == 0){
            setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
        }
        else if (row%4 == 1 || row%4 == 2 ) {
            setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));
        }
        else {
            setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
        }

        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);

        return c;
    }
}
