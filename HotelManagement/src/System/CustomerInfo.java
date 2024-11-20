
	package System;
	import java.awt.event.*;
	import java.sql.ResultSet;
	import net.proteanit.sql.*;
	import javax.swing.*;
	import java.awt.*;
	public class CustomerInfo extends JFrame implements ActionListener {
		JTable t1;
		JButton back;
	CustomerInfo(){
	   setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
	    JLabel l1=new JLabel("Id");
	    l1.setBounds(40, 10, 100, 20);
	    add(l1);
	    JLabel l2=new JLabel("Number");
	    l2.setBounds(170, 10, 100, 20);
	    add(l2);
	    JLabel l3=new JLabel("Name");
	    l3.setBounds(290, 10, 100, 20);
	    add(l3);
	    JLabel l4=new JLabel("Gender");
	    l4.setBounds(400, 10, 100, 20);
	    add(l4);
	    JLabel l5=new JLabel("Country");
	    l5.setBounds(540, 10, 100, 20);
	    add(l5);
	    JLabel l6=new JLabel("Room");
	    l6.setBounds(670, 10, 100, 20);
	    add(l6);
	    JLabel l7=new JLabel("CheckinTime");
	    l7.setBounds(790, 10, 100, 20);
	    add(l7);
	    JLabel l8=new JLabel("Deposite");
	    l8.setBounds(890, 10, 100, 20);
	    add(l8);
	    t1=new JTable();
	    t1.setBounds(0,40,1000,300);
	    add(t1);

	    try{
	    	Conn conn=new Conn();
	    	ResultSet rs=conn.s.executeQuery("select * from customerdetails");
	    	t1.setModel(DbUtils.resultSetToTableModel(rs));
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    back =new JButton("Back");
	     back.setBounds(400,410,120,30);
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
		new CustomerInfo();
	}
	}




