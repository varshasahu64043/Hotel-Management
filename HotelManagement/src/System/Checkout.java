package System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;

public class Checkout extends JFrame implements ActionListener {
	Choice ccustomer;
	JLabel   lblroomno,lblcheck,lblcheckout;
	JButton  Jcheckout,back;
     Checkout(){
	 setLayout(null);
		getContentPane().setBackground(Color.WHITE);
	setBounds(300,200,800,400);
	JLabel heading=new JLabel("Checkout");
	heading.setBounds(100,20,200,30);
	heading.setForeground(Color.BLUE);
	heading.setFont(new Font("Tohema",Font.PLAIN,25));
	add(heading);
	JLabel lblid=new JLabel("Customer id");
	lblid.setBounds(30,80,100,30);
	add(lblid);
	ccustomer = new Choice();
	ccustomer.setBounds(150, 80, 100, 25);
	add(ccustomer);
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/tick.png"));
	Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);
	JLabel image = new JLabel(i3);
	image.setBounds(280, 80, 20, 20);
	add(image);
	JLabel lblroom=new JLabel("Room No:");
	lblroom.setBounds(30,130,100,30);
	add(lblroom);
	
    lblroomno=new JLabel();
	lblroomno.setBounds(150,130,100,30);
	add(lblroomno);
	
	JLabel checkintime=new JLabel("Checkintime:");
	checkintime.setBounds(30,180,100,30);
	add(checkintime);
	
    lblcheck=new JLabel();
	lblcheck.setBounds(150,180,100,30);
	add(lblcheck);

	JLabel checkout=new JLabel("Checkoutime:");
	checkout.setBounds(30,230,100,30);
	add(checkout);
	  
    Date date=new Date();
	lblcheckout=new JLabel(""+date);
	lblcheckout.setBounds(150,230,100,30);
	add(lblcheckout);
	
	Jcheckout =new JButton("Checkout");
	Jcheckout.setBackground(Color.BLACK);
	Jcheckout.setForeground(Color.WHITE);
	Jcheckout.addActionListener(this);
	Jcheckout.setBounds(30,280,100,30);
	add(Jcheckout);
	  
	back =new JButton("Back");
	back.setBackground(Color.BLACK);
	back.setForeground(Color.WHITE);
	back.addActionListener(this);
	back.setBounds(170,280,100,30);
	add(back);
	try {
		Conn conn = new Conn();
		ResultSet rs = conn.s.executeQuery("select * from customerdetails");
		while (rs.next()) {
			ccustomer.add(rs.getString("number"));
			lblroomno.setText(rs.getString("room"));
			lblcheck.setText(rs.getString("checkintime"));
	} }catch (Exception ae) {
		ae.printStackTrace();
	}

	ImageIcon i4 = new ImageIcon(getClass().getResource("/icons/sixth.jpg"));
	Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
	ImageIcon i6 = new ImageIcon(i5);
	JLabel images = new JLabel(i6);
	images.setBounds(350, 50, 400, 250);
	add(images);

    setVisible(true);
}
     public void actionPerformed(ActionEvent e) {
    	    if (e.getSource() == Jcheckout) {
    	        String query1 = "SELECT * FROM customerdetails WHERE number='" + ccustomer.getSelectedItem() + "'";
    	        String query2 = "UPDATE roomhelp SET availibility='Available' WHERE roomno='" + lblroomno.getText() + "'";
    	        try {
    	            Conn con = new Conn();
    	            // Use executeQuery for SELECT statements
    	            ResultSet rs = con.s.executeQuery(query1);
    	            // You might want to process the ResultSet here if needed

    	            // Use executeUpdate for UPDATE statements
    	            con.s.executeUpdate(query2);
    	            JOptionPane.showMessageDialog(null, "Checkout done");
    	            setVisible(false);
    	            new Reception();
    	        } catch (Exception ae) {
    	            ae.printStackTrace();
    	        }
    	    }
    	}

 public static void main(String args[]){
	 new Checkout();
 }

}
