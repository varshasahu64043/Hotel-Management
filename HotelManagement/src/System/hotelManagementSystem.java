package System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class hotelManagementSystem extends JFrame implements ActionListener {
	JLabel b1;

	JButton b2;

	hotelManagementSystem() {

		this.setSize(1360, 565);
		this.setTitle("Hotel Management");

		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/first.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1360, 560, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1360, 560);
		add(image);

		b1 = new JLabel("Hotel Management System");
		b1.setBounds(20, 430, 1000, 90);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.setFont(new Font("serif", Font.ITALIC, 70));
		image.add(b1);

		b2 = new JButton("Next");
		b2.setBounds(1150, 430, 150, 50);
		b2.setForeground(Color.MAGENTA);
		b2.setBackground(Color.BLACK);
		b2.setFont(new Font("serif", Font.PLAIN, 30));
		b2.addActionListener(this);
		image.add(b2);
		this.setVisible(true);
	    this.setLayout(null);
          
		while(true){
			b1.setVisible(false);
		try{
			Thread.sleep(500);
		}catch(Exception e){
			e.printStackTrace();
		}
		b1.setVisible(true);
		try{
			Thread.sleep(500);
		}catch(Exception e){
			e.printStackTrace();
		}

		}
	}

	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new login();
	}

	public static void main(String args[]) {
		new hotelManagementSystem();

	}
}
