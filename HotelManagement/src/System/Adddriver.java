package System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Adddriver extends JFrame implements ActionListener {
	JTextField tname,tcompany,tage,tmodel,tlocation;
	JButton add,cancel;
	JComboBox agecombo,availablecombo,lcleancombo;
Adddriver(){
	setLayout(null);
	getContentPane().setBackground(Color.WHITE);
	setBounds(200,150,980,540);
	JLabel name =new JLabel("Add Driver");
	name.setBounds(60,30,120,30);
	name.setFont(new Font("Tahoma",Font.BOLD,20));
	add(name);
	JLabel roomno =new JLabel("Name:");
	roomno.setBounds(60,80,120,30);
	roomno.setFont(new Font("Tahoma",Font.PLAIN,16));
	add(roomno);
	 tname=new JTextField();
		tname.setBounds(200,80,150,30);
		add(tname);
		JLabel avlaible =new JLabel("Age:");
		avlaible.setBounds(60,130,120,30);
		avlaible.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(avlaible);
		tage=new JTextField();
		tage.setBounds(200,130,150,30);
		add(tage);
   	JLabel gender =new JLabel("Gender:");
   	gender.setBounds(60,180,120,30);
   	gender.setFont(new Font("Tahoma",Font.PLAIN,16));
	add(gender);
	String ageoption[]={"Male","Female"};
      agecombo=new JComboBox(ageoption);
      agecombo.setBounds(200,180,150,30);
      agecombo.setBackground(Color.WHITE);
   add(agecombo);
	JLabel lprice=new JLabel("Car company:");
	lprice.setBounds(60,230,120,30);
	lprice.setFont(new Font("Tahoma",Font.PLAIN,16));
	add(lprice);
	tcompany=new JTextField();
	tcompany.setBounds(200,230,150,30);
	add(tcompany);	
	JLabel lclean =new JLabel("Car Model:");
   	lclean.setBounds(60,280,120,30);
   	lclean.setFont(new Font("Tahoma",Font.PLAIN,16));
	add(lclean);
	tmodel=new JTextField();
	tmodel.setBounds(200,280,150,30);
	add(tmodel);
	JLabel lav =new JLabel("Avlaibility:");
   	lav.setBounds(60,330,120,30);
   	lav.setFont(new Font("Tahoma",Font.PLAIN,16));
	add(lav);
	String driveroption[]={"Occupied","Busy"};
	availablecombo=new JComboBox(driveroption);
    availablecombo.setBounds(200,330,150,30);
    availablecombo.setBackground(Color.WHITE);
 add(availablecombo);
 JLabel location =new JLabel("Location:");
	location.setBounds(60,380,120,30);
	location.setFont(new Font("Tahoma",Font.PLAIN,16));
	add(location);
	tlocation=new JTextField();
	tlocation.setBounds(200,380,150,30);
	add(tlocation);
   add=new JButton("Add");
	add.setBounds(60,430,100,30);
add.setBackground(Color.BLACK);
add.setForeground(Color.WHITE);
add.addActionListener(this);
add(add);	
cancel=new JButton("Cancel");
cancel.setBounds(200,430,100,30);
cancel.setBackground(Color.BLACK);
cancel.setForeground(Color.WHITE);
cancel.addActionListener(this);
add(cancel);
ImageIcon i1=new ImageIcon(getClass().getResource("/icons/eleven.jpg"));
Image i2=i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel image=new JLabel(i3);
image.setBounds(400,80,500,300);
add(image);

		setVisible(true);
}
public void actionPerformed(ActionEvent e){
	if(e.getSource()==add){
	String name=tname.getText();
	String age=tage.getText();
	String gender=(String)agecombo.getSelectedItem();
	String company=tcompany.getText();
	String brand=tmodel.getText();
	String available=(String)availablecombo.getSelectedItem();
	String location=tlocation.getText();

	try{
	Conn conn=new Conn();
	 
String str="insert into hoteldriver values(' "+name+" ',' "+age+" ',' "+gender+" ',' "+company+" ',' "+brand+"',' "+available+"',' "+location+"')";
	conn.s.executeUpdate(str);
	JOptionPane.showMessageDialog(null," Driver added sucessfully");
	}catch (Exception ae){
		System.out.println(ae);
	}
	}else{
		setVisible(false);
	}
}
public static void main(String args[]){
	new Adddriver();	
}}