package gui;


import dao.MembersDao;
import gui.membersView.MembersViewTable;
import models.Members;
import models.Persons;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jenny on 27.01.2018.
 */
public class MembersWindow extends JPanel implements ActionListener {

    JButton addMember = new JButton("Add Member");
    JButton remMember = new JButton("Remove Member");
    JTextArea searchMember = new JTextArea("Wyszukaj...");
    private MembersViewTable table;

    public MembersWindow() {

        Session memberSess = HibernateUtil.openSession();
        MembersDao memberD = new MembersDao(memberSess);
        table = new MembersViewTable(memberD.findAll());
        JScrollPane sp = new JScrollPane(table);
        memberSess.close();

//        this.setLocationRelativeTo(null);
//        this.setModal(true);
        this.setSize(500, 500);
        this.setLayout(new GridLayout(0, 1));

        addMember.addActionListener(this);
        remMember.addActionListener(this);

        addMember.setBackground(Color.lightGray);
        addMember.setFont(new Font("Arial", Font.BOLD, 18));
        addMember.setForeground(Color.darkGray);

        remMember.setBackground(Color.lightGray);
        remMember.setFont(new Font("Arial", Font.BOLD, 18));
        remMember.setForeground(Color.darkGray);

        searchMember.setFont(new Font("Arial", Font.BOLD, 18));
        searchMember.setForeground(Color.darkGray);

        JPanel panel = new JPanel();
        panel.add(addMember);
        panel.add(remMember);
        panel.setPreferredSize(new Dimension(500, 50));
        add(sp);
        add(panel);
        add(searchMember);

        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == addMember) {
            new DataSaver();
        } else if (source == remMember) {
            Members member = table.getModel().getList(table.getSelectedRow());

            Session ses = HibernateUtil.openSession();
            org.hibernate.Transaction tx = ses.beginTransaction();
            ses.delete(member);
            tx.commit();
            ses.close();
        }


//        if (source == addMember) {
//            new DataSaver();
//        } else if (source == remMember) {
//            Members member = table.getModel().getList(table.getSelectedRow());
//
//            Session ses = HibernateUtil.openSession();
//                org.hibernate.Transaction tx = ses.beginTransaction();
//                ses.delete(member);
//                tx.commit();
//                ses.close();
//
//            } else if (source == cancel) {
//                clearInfo();
//
//
//            }
        }

        





    class DataSaver extends JPanel implements ActionListener {
        JLabel name = new JLabel("Name:");
        JLabel surname = new JLabel("Surname:");
        JLabel email = new JLabel("E-mail:");
        JLabel mobile = new JLabel("Mobile:");
        JTextArea nameTxt = new JTextArea();
        JTextArea surnameTxt = new JTextArea();
        JTextArea emailTxt = new JTextArea();
        JTextArea mobileTxt = new JTextArea();
        JButton save = new JButton("Save");
        JButton cancel = new JButton("Cancel");
        private Persons person;
        private Members member;
        private JFrame frame;




        public DataSaver() {

            setLayout(new GridLayout(5, 2));

            add(name);
            add(nameTxt);
            add(surname);
            add(surnameTxt);
            add(email);
            add(emailTxt);
            add(mobile);
            add(mobileTxt);

            add(save);
            save.addActionListener(this);
            add(cancel);
            cancel.addActionListener(this);

            frame = new JFrame("Set data");
            frame.add(this);
            frame.setSize(500, 500);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if (source == save) {

                person = new Persons();
                person.setName(nameTxt.getText());
                person.setSurname(surnameTxt.getText());
                person.setEmail(emailTxt.getText());
                person.setMobile(mobileTxt.getText());

                member = new Members();
                member.setPerson(person);

                /*Session ses = HibernateUtil.openSession();
                org.hibernate.Transaction tx = ses.beginTransaction();

                ses.persist(person);
                ses.persist(member);
                tx.commit();
                ses.close();*/
                clearInfo();

                int i =  JOptionPane.showConfirmDialog(null, "Do You want add next Member?",
                        null, JOptionPane.YES_NO_OPTION);

                if(i==1){
                    frame.dispose();
                }

            } else if (source == cancel) {
                clearInfo();


            }
        }

        private void clearInfo(){
            nameTxt.setText("");
            surnameTxt.setText("");
            emailTxt.setText("");
            mobileTxt.setText("");
        }
    }

}


