package System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Addroom extends JFrame implements ActionListener {
	JTextField tRoom,tprice;
	JButton add,cancel;
	JComboBox cleancombo,availablecombo,lcleancombo;
Addroom(){
	setLayout(null);
	getContentPane().setBackground(Color.WHITE);
	setBounds(350,200,850,540);
	JLabel name =new JLabel("Add Room");
	name.setBounds(60,30,120,30);
	name.setFont(new Font("Tahoma",Font.BOLD,20));
	add(name);
	JLabel roomno =new JLabel("Room No:");
	roomno.setBounds(60,80,120,30);
	roomno.setFont(new Font("Tahoma",Font.PLAIN,16));
	add(roomno);
	 tRoom=new JTextField();
		tRoom.setBounds(200,80,150,30);
		add(tRoom);
		JLabel avlaible =new JLabel("Available:");
		avlaible.setBounds(60,130,120,30);
		avlaible.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(avlaible);
		String availableOption[]={"Available","Occuptied"};
          availablecombo=new JComboBox(availableOption);
         availablecombo.setBounds(200,130,150,30);
         availablecombo.setBackground(Color.WHITE);
       add(availablecombo);
   	JLabel cleansystem =new JLabel("Clean Status:");
   	cleansystem.setBounds(60,180,120,30);
   	cleansystem.setFont(new Font("Tahoma",Font.PLAIN,16));
	add(cleansystem);
	String cleanoptions[]={"Cleaned","Dirty"};
      cleancombo=new JComboBox(cleanoptions);
     cleancombo.setBounds(200,180,150,30);
     cleancombo.setBackground(Color.WHITE);
   add(cleancombo);
	JLabel lprice=new JLabel("Price:");
	lprice.setBounds(60,230,120,30);
	lprice.setFont(new Font("Tahoma",Font.PLAIN,16));
	add(lprice);
	tprice=new JTextField();
	tprice.setBounds(200,230,150,30);
	add(tprice);	
	JLabel lclean =new JLabel("BedType:");
   	lclean.setBounds(60,280,120,30);
   	lclean.setFont(new Font("Tahoma",Font.PLAIN,16));
	add(lclean);
	String lcleanoptions[]={"Single Bed","Double Bed"};
      lcleancombo=new JComboBox(lcleanoptions);
     lcleancombo.setBounds(200,280,150,30);
     lcleancombo.setBackground(Color.WHITE);
   add(lcleancombo);	
   add=new JButton("Add");
	add.setBounds(60,330,100,30);
add.setBackground(Color.BLACK);
add.setForeground(Color.WHITE);
add.addActionListener(this);
add(add);	
cancel=new JButton("Cancel");
cancel.setBounds(200,330,100,30);
cancel.setBackground(Color.BLACK);
cancel.setForeground(Color.WHITE);
cancel.addActionListener(this);
add(cancel);
ImageIcon i1=new ImageIcon(getClass().getResource("/icons/twelve.jpg"));
Image i2=i1.getImage().getScaledInstance(450,450, Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel image=new JLabel(i3);
image.setBounds(380,60,450,370);
add(image);

		setVisible(true);
}
public void actionPerformed(ActionEvent e){
	if(e.getSource()==add){
	String roomnumber=tRoom.getText();
	String availibility=(String)availablecombo.getSelectedItem();
	String status=(String)cleancombo.getSelectedItem();
	String price=tprice.getText();
	String type=(String)lcleancombo.getSelectedItem();
	try{
	Conn conn=new Conn();
	String str="insert into roomhelp values(' "+roomnumber+" ',' "+availibility+" ',' "+status+" ',' "+price+" ',' "+type+" ')";
	conn.s.executeUpdate(str);
	JOptionPane.showMessageDialog(null," New room added sucessfully");
	}catch (Exception ae){
		System.out.println(ae);
	}
	}else{
		setVisible(false);
		new Reception();
	}
}
public static void main(String args[]){
	new Addroom();	
}}