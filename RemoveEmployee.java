package Employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice choiceEMPID;
    JButton delete,back;


    RemoveEmployee(){

        JLabel label = new JLabel("Employee ID");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("tahoma",Font.BOLD,15));
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200,50,150,30);
        add(choiceEMPID);

        try{
            connect con = new connect();
            ResultSet resultSet= con.statement.executeQuery("select * from employee");
            while(resultSet.next()){
                choiceEMPID.addItem(resultSet.getString("empID"));
            }

        } catch (Exception e) {
           e.printStackTrace();
        }

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        labelname.setFont(new Font("tahoma",Font.BOLD,15));
        add(labelname);

        JLabel textname = new JLabel();
        textname.setBounds(200,100,100,30);
        add(textname);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
        labelphone.setFont(new Font("tahoma",Font.BOLD,15));
        add(labelphone);

        JLabel textphone = new JLabel();
        textphone.setBounds(200,150,100,30);
        add(textphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        labelemail.setFont(new Font("tahoma",Font.BOLD,15));
        add(labelemail);

        JLabel textemail = new JLabel();
        textemail.setBounds(200,200,100,30);
        add(textemail);

        try{

            connect con = new connect();
            ResultSet resultSet= con.statement.executeQuery("select * from employee where empID='"+choiceEMPID.getSelectedItem()+"'");

            while(resultSet.next()){
                textname.setText(resultSet.getString("name"));
                textphone.setText(resultSet.getString("phone"));
                textemail.setText(resultSet.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    connect con = new connect();
                    ResultSet resultSet= con.statement.executeQuery("select * from employee where empID='"+choiceEMPID.getSelectedItem()+"'");

                    while(resultSet.next()){
                        textname.setText(resultSet.getString("name"));
                        textphone.setText(resultSet.getString("phone"));
                        textemail.setText(resultSet.getString("email"));
                    }
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        delete=new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==delete){
       try{
           connect con = new connect();
           String query="delete from employee where empID='"+choiceEMPID.getSelectedItem()+"'";
           con.statement.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"Employee deleted successfully");
           setVisible(false);

       }catch (Exception e1){
           e1.printStackTrace();
       }
      }else {
          setVisible(false);
      }

    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
