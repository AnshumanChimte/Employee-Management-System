package Employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;

    Department(){

        getContentPane().setBackground(new Color(255,131,122));
        JLabel department=new JLabel("Department Data");
        department.setBounds(315,20,350,40);
        department.setFont(new Font("Times New Roman",Font.BOLD,35));
        add(department);

        table=new JTable();
        try{
            connect c=new connect();
            ResultSet resultSet=c.statement.executeQuery("select * from department");
            while(resultSet.next()){
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane jp=new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        back=new JButton("Back");
        back.setBounds(20,70,80,20);
        add(back);
        back.addActionListener(this);

        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);

        }
    }

    public static void main(String[] args) {
        new Department();
    }
}
