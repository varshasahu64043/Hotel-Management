package System;

	import java.awt.event.*;
	import java.sql.ResultSet;
	import net.proteanit.sql.*;
	import javax.swing.*;
	import java.awt.*;
	public class Department  extends JFrame implements ActionListener {
		JTable t1;
		JButton back;
	Department(){
	   setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setBounds(300,200,700,500);
		
	    JLabel l1=new JLabel("Department");
	    l1.setBounds(60, 10, 100, 20);
	    add(l1);
	    JLabel l2=new JLabel("Budget");
	    l2.setBounds(250, 10, 100, 20);
	    add(l2);
	    
	    t1=new JTable();
	    t1.setBounds(0,40,700,330);
	    add(t1);
	    
	    back =new JButton ("Back");
	     back.setBounds(220,380,120,30);
	     back.setBackground(Color.BLACK);
	     back.setForeground(Color.WHITE);
	     back.addActionListener(this);
	     add( back);

	    try{
	    	Conn conn=new Conn();
	    	ResultSet rs=conn.s.executeQuery("select * from department");
	    	t1.setModel(DbUtils.resultSetToTableModel(rs));
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    setVisible(true);
		}
	public void actionPerformed(ActionEvent ae){
		setVisible(false);
		new Reception();
	}
	public static void main(String args[]){
		new Department();
	}
	}


