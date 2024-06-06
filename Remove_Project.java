package Employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Remove_Project extends JFrame implements ActionListener{
    Choice choicePid;
    JButton delete,back;
    public Remove_Project() {
        JLabel label = new JLabel("Employee ID");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("tahoma",Font.BOLD,15));
        add(label);

        choicePid = new Choice();
        choicePid.setBounds(200,50,150,30);
        add(choicePid);

        try{
            connect con = new connect();
            ResultSet resultSet= con.statement.executeQuery("select * from project");
            while(resultSet.next()){
                choicePid.addItem(resultSet.getString("projectID"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelid = new JLabel("projectID");
        labelid.setBounds(50,100,100,30);
        labelid.setFont(new Font("tahoma",Font.BOLD,15));
        add(labelid);

        JLabel textid = new JLabel();
        textid.setBounds(200,100,100,30);
        add(textid);

        JLabel labelname = new JLabel("P.Name");
        labelname.setBounds(50,150,100,30);
        labelname.setFont(new Font("tahoma",Font.BOLD,15));
        add(labelname);

        JLabel textname = new JLabel();
        textname.setBounds(200,150,200,30);
        add(textname);

        try{

            connect con = new connect();
            ResultSet resultSet= con.statement.executeQuery("select * from project where projectID='"+choicePid.getSelectedItem()+"'");

            while(resultSet.next()){
                textid.setText(resultSet.getString("projectID"));
                textname.setText(resultSet.getString("project_name"));

            }
        }catch(Exception e){
            e.printStackTrace();
        }

        choicePid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    connect con = new connect();
                    ResultSet resultSet= con.statement.executeQuery("select * from project where projectID='"+choicePid.getSelectedItem()+"'");

                    while(resultSet.next()){
                        textid.setText(resultSet.getString("projectID"));
                        textname.setText(resultSet.getString("project_name"));

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
                String query="delete from project where projectID='"+choicePid.getSelectedItem()+"'";
                con.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Poject deleted successfully");
                setVisible(false);

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Remove_Project();
    }
}
