package Employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Project extends JFrame implements ActionListener {
    JTable table;
    JButton back;

    Project()
    {

        getContentPane().setBackground(Color.LIGHT_GRAY);
        JLabel Project=new JLabel("Project  Data");
        Project.setBounds(315,20,350,40);
        Project.setFont(new Font("Times New Roman",Font.BOLD,35));
        add(Project);

        table=new JTable();
        try{
            connect c=new connect();
            ResultSet resultSet=c.statement.executeQuery("select * from project");
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

        new Project();
    }
}
