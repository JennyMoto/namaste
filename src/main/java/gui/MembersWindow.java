package gui;


import gui.membersView.MembersViewTable;
import models.Members;
import models.Persons;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jenny on 27.01.2018.
 */
public class MembersWindow extends JPanel implements ActionListener {

    private JButton addMember = new JButton("Add Member");
    private JButton remMember = new JButton("Remove Member");
    private JButton find = new JButton("Find");
    private JButton showAll = new JButton("Show All");
    private MembersViewTable table;

    public MembersWindow() {

        table = new MembersViewTable();
        JScrollPane sp = new JScrollPane(table);

//        this.setLocationRelativeTo(null);
//        this.setModal(true);
        this.setPreferredSize(new Dimension(500, 500));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        addMember.addActionListener(this);
        remMember.addActionListener(this);
        find.addActionListener(this);
        showAll.addActionListener(this);

        showAll.setBackground(Color.lightGray);
        showAll.setFont(new Font("Arial", Font.BOLD, 18));
        showAll.setForeground(Color.darkGray);

        find.setBackground(Color.lightGray);
        find.setFont(new Font("Arial", Font.BOLD, 18));
        find.setForeground(Color.darkGray);

        addMember.setBackground(Color.lightGray);
        addMember.setFont(new Font("Arial", Font.BOLD, 18));
        addMember.setForeground(Color.darkGray);

        remMember.setBackground(Color.lightGray);
        remMember.setFont(new Font("Arial", Font.BOLD, 18));
        remMember.setForeground(Color.darkGray);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));
        panel.add(addMember);
        panel.add(remMember);
        panel.add(find);
        panel.add(showAll);

        add(sp);
        add(panel);


        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == addMember) {
            new DataSaver();
        } else if (source == remMember) {
            table.getModel().removeMember(table.getSelectedRow());
        }
        else if (source == find){
            String regex = JOptionPane.showInputDialog("Regex:");

            if (regex != null) {
                TableRowSorter sorter = new TableRowSorter<>(table.getModel());
                sorter.setRowFilter(RowFilter.regexFilter(regex));
                table.setRowSorter(sorter);

            }

        }
        else table.setRowSorter(null);
    }


    class DataSaver extends JPanel implements ActionListener {

        private JLabel name = new JLabel("Name: ", null, SwingConstants.RIGHT);
        private JLabel surname = new JLabel("Surname: ", null, SwingConstants.RIGHT);
        private JLabel email = new JLabel("E-mail: ", null, SwingConstants.RIGHT);
        private JLabel mobile = new JLabel("Mobile: ", null, SwingConstants.RIGHT);

        private JTextArea nameTxt = new JTextArea();
        private JTextArea surnameTxt = new JTextArea();
        private JTextArea emailTxt = new JTextArea();
        private JTextArea mobileTxt = new JTextArea();


        private JButton save = new JButton("Save");
        private JButton clearData = new JButton("Clear");


        private JFrame frameDataSever;


        public DataSaver() {


            setLayout(new GridLayout(5, 2));
            JComponent[] tableOfComp = {name, nameTxt, surname, surnameTxt, email, emailTxt, mobile, mobileTxt};
            for (JComponent c : tableOfComp) {
                c.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                add(c);
            }

            add(save);
            clearData.setToolTipText("Clear all cells");
            save.addActionListener(this);
            add(clearData);
            clearData.addActionListener(this);

            frameDataSever = new JFrame("Set data");
            frameDataSever.add(this);
            frameDataSever.setSize(500, 500);
            frameDataSever.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameDataSever.setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if (source == save) {

                Persons person = new Persons();
                person.setName(nameTxt.getText());
                person.setSurname(surnameTxt.getText());
                person.setEmail(emailTxt.getText());
                person.setMobile(mobileTxt.getText());

                Members member = new Members();
                member.setPerson(person);

                table.getModel().addMember(member);

                int i = JOptionPane.showConfirmDialog(frameDataSever, "Do You want add next Member?",
                        null, JOptionPane.YES_NO_OPTION);

                if (i == 1) {
                    frameDataSever.dispose();
                } else clearInfo();

            } else if (source == clearData) {
                clearInfo();
            }
        }

        private void clearInfo() {
            nameTxt.setText("");
            surnameTxt.setText("");
            emailTxt.setText("");
            mobileTxt.setText("");
        }
    }

}


