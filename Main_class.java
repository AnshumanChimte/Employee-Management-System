package Employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {

    Main_class(){
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/homepage.png"));
            Image i2=i1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel img=new JLabel(i3);
            img.setBounds(0,0,1120,630);
            add(img);

            JLabel heading=new JLabel("Employee Management System");
            heading.setBounds(340,30,900,50);
            heading.setFont(new Font("Raleway",Font.BOLD,30));
            heading.setForeground(Color.white);
            img.add(heading);

            JButton add=new JButton("Add Employee");
            add.setBounds(265,150,150,40);
            add.setForeground(Color.WHITE);
            add.setBackground(Color.black);
            add.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                 new AddEmployee();
                 setVisible(false);
                }
            });
            img.add(add);

        JButton view=new JButton("View Employee");
        view.setBounds(665,150,150,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new View_Employee();
                setVisible(false);
            }
        });
        img.add(view);


        JButton rem=new JButton("Remove Employee");
        rem.setBounds(265,250,150,40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.black);
        rem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
             new RemoveEmployee();
            }
        });
        img.add(rem);

        JButton dept=new JButton("Department Detail");
        dept.setBounds(665,250,150,40);
        dept.setForeground(Color.WHITE);
        dept.setBackground(Color.black);
        dept.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Department();
            }
        });
        img.add(dept);

        JButton project=new JButton("Project Detail");
        project.setBounds(665,350,150,40);
        project.setForeground(Color.WHITE);
        project.setBackground(Color.black);
        project.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Project();
            }
        });
        img.add(project);

        JButton rproject=new JButton("Remove Project");
        rproject.setBounds(265,450,150,40);
        rproject.setForeground(Color.WHITE);
        rproject.setBackground(Color.black);
        rproject.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Remove_Project();
            }
        });
        img.add(rproject);


        JButton padd=new JButton(" Add Project ");
        padd.setBounds(265,350,150,40);
        padd.setForeground(Color.WHITE);
        padd.setBackground(Color.black);
        padd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new AddProject();
            }
        });
        img.add(padd);



            setSize(1120,630);
            setLocation(250,100);
            setLayout(null);
            setVisible(true);


    }
    public static void main(String[] args) {

            new Main_class();
    }
}
