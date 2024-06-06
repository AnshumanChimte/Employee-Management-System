package Employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProject extends JFrame implements ActionListener {
    JTextField jprojectID,jprojectName,jstartDate,jendDate;
    JButton add,back;
    public AddProject() {
        getContentPane().setBackground(Color.white);
        JLabel heading = new JLabel("Add Project Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel pID=new JLabel("Project ID:");
        pID.setBounds(50,150,150,30);
        pID.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(pID);

        jprojectID=new JTextField();
        jprojectID.setBounds(200,150,150,30);
        jprojectID.setBackground(Color.LIGHT_GRAY);
        add(jprojectID);

        JLabel pname=new JLabel("Project Name:");
        pname.setBounds(400,150,150,30);
        pname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(pname);

        jprojectName=new JTextField();
        jprojectName.setBounds(600,150,150,30);
        jprojectName.setBackground(Color.LIGHT_GRAY);
        add(jprojectName);

        JLabel sdate=new JLabel("Start Date:");
        sdate.setBounds(50,200,150,30);
        sdate.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(sdate);

        jstartDate=new JTextField();
        jstartDate.setBounds(200,200,150,30);
        jstartDate.setBackground(Color.LIGHT_GRAY);
        add(jstartDate);

        JLabel edate=new JLabel("End Date:");
        edate.setBounds(400,200,150,30);
        edate.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(edate);

        jendDate=new JTextField();
        jendDate.setBounds(600,200,150,30);
        jendDate.setBackground(Color.LIGHT_GRAY);
        add(jendDate);


        add=new JButton("ADD");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back=new JButton("BACK");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String projectID=jprojectID.getText();
            String projectName=jprojectName.getText();
            String startDate=jstartDate.getText();
            String endDate=jendDate.getText();

            try{
                connect c=new connect();
                String query="insert into project values('"+projectID+"','"+projectName+"','"+startDate+"','"+endDate+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
                setVisible(false);


            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else {
            setVisible(false);

        }
    }

    public static void main(String[] args) {
        new AddProject();

    }
}
