package System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Dashboard extends JFrame implements ActionListener {
	JLabel b1;
	JMenuItem reception,addDriver,addroom,employee;
	Dashboard() {
		getContentPane().setBackground(Color.WHITE);
			this.setBounds(0,0,1550,1000);
			this.setLayout(null);
			ImageIcon i1=new ImageIcon(getClass().getResource("/icons/third.jpg"));
			Image i2=i1.getImage().getScaledInstance(1550,800, Image.SCALE_DEFAULT);
		    ImageIcon i3=new ImageIcon(i2);
		    JLabel image=new JLabel(i3);
		    image.setBounds(0,0,1550,800);
		    add(image);
			b1=new JLabel("THE TAJ GROUP WELCOME YOU");
			b1.setBounds(400,80,1200,50);
			b1.setForeground(Color.WHITE);
			b1.setBackground(Color.BLACK);
			b1.setFont(new Font("Tahoma",Font.ITALIC,46));
		image.add(b1);
		JMenuBar mb=new JMenuBar();
		mb.setBounds(0,0,1550,30);
		image.add(mb);
		JMenu hotel=new JMenu("HOTEL MANAGEMENT");
	    hotel.setForeground(Color.RED);
		mb.add(hotel);
		 reception=new JMenuItem("RECEPTION");
		reception.addActionListener(this);
		hotel.add(reception);
		 addroom=new JMenuItem("ADD ROOM");
		addroom.addActionListener(this);
		hotel.add(addroom);
		 addDriver=new JMenuItem("ADD DRIVER");
		addDriver.addActionListener(this);
		hotel.add(addDriver);
		JMenu admin=new JMenu("ADMIN");
		admin.setForeground(Color.BLUE);
		mb.add(admin);
		 employee=new JMenuItem("ADD EMPLOYEE");
		employee.addActionListener(this);
		admin.add(employee);
			this.setVisible(true);
//			this.setLocation(100,100);
	}
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("ADD EMPLOYEE")){
			new AddEmployee();
			
		}
		else if(e.getActionCommand().equals("ADD ROOM")){
			new Addroom();	
			}
		else if(e.getActionCommand().equals("ADD DRIVER")){
			new Adddriver();	
			}else if(e.getActionCommand().equals("RECEPTION")){
				new Reception();	
				}


		}
	
	public static void main(String args[]){
		new Dashboard();
	}
}
