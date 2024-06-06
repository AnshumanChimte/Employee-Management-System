package Employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Employee extends JFrame implements ActionListener {
    JTable table;

    Choice choiceEMP;

    JButton backbtn;

    View_Employee(){

        getContentPane().setBackground(new Color(255,131,122));
        JLabel search=new JLabel("Employee Data");
        search.setBounds(310,20,350,40);
        search.setFont(new Font("Times New Roman",Font.BOLD,30));
        add(search);

       choiceEMP=new Choice();


        try{
            connect c=new connect();
            ResultSet resultSet=c.statement.executeQuery("select * from employee");
            while(resultSet.next()){
                choiceEMP.add(resultSet.getString("empID"));
            }
        }catch(Exception e){
           e.printStackTrace();
        }
        table=new JTable();
        try{
            connect c=new connect();
            ResultSet resultSet=c.statement.executeQuery("select * from employee");
            while(resultSet.next()){
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane jp=new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        backbtn=new JButton("Back");
        backbtn.setBounds(20,70,80,20);
        add(backbtn);
        backbtn.addActionListener(this);

        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backbtn){
            setVisible(false);
            new Main_class();

        }
    }

    public static void main(String[] args) {
     new View_Employee();
    }
}
