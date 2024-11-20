
	package System;
	import java.awt.event.*;
	import java.sql.ResultSet;
	import net.proteanit.sql.*;
	import javax.swing.*;
	import java.awt.*;
	public class ManagerInfo extends JFrame implements ActionListener {
		JTable t1;
		JButton back;
	ManagerInfo(){
	   setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
	    JLabel l1=new JLabel("Name");
	    l1.setBounds(40, 10, 100, 20);
	    add(l1);
	    JLabel l2=new JLabel("Age");
	    l2.setBounds(170, 10, 100, 20);
	    add(l2);
	    JLabel l3=new JLabel("Gender");
	    l3.setBounds(290, 10, 100, 20);
	    add(l3);
	    JLabel l4=new JLabel("Job");
	    l4.setBounds(400, 10, 100, 20);
	    add(l4);
	    JLabel l5=new JLabel("Salary");
	    l5.setBounds(540, 10, 100, 20);
	    add(l5);
	    JLabel l6=new JLabel("Phone");
	    l6.setBounds(670, 10, 100, 20);
	    add(l6);
	    JLabel l7=new JLabel("Email");
	    l7.setBounds(790, 10, 100, 20);
	    add(l7);
	    JLabel l8=new JLabel("Aadhar Card");
	    l8.setBounds(910, 10, 100, 20);
	    add(l8);

	    t1=new JTable();
	    t1.setBounds(0,40,1000,400);
	    add(t1);

	    try{
	    	Conn conn=new Conn();
	    	ResultSet rs=conn.s.executeQuery("select * from hotelEmp ");
	    	t1.setModel(DbUtils.resultSetToTableModel(rs));
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    back =new JButton("Back");
	     back.setBounds(120,440,120,30);
	     back.setBackground(Color.BLACK);
	     back.setForeground(Color.WHITE);
	     back.addActionListener(this);
	     add( back);
	     setBounds(300,200,1000,600);

	    setVisible(true);
		}
	public void actionPerformed(ActionEvent ae){
		setVisible(false);
		new Reception();
	}
	public static void main(String args[]){
		new ManagerInfo();
	}
	}




