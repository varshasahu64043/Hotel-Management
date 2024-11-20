package System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class UpdateRoom extends JFrame implements ActionListener {
	Choice ccustomer;
	JTextField tAvailbility, troom, tfstatus;
	JButton back, update, check;

	UpdateRoom() {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel text = new JLabel("Update Room Status");
		text.setFont(new Font("Tohama", Font.PLAIN, 20));
		text.setBounds(90, 20, 250, 30);
		text.setBackground(Color.BLUE);
		add(text);

		JLabel id = new JLabel("Customer Id:");
		id.setBounds(30, 80, 100, 25);
		add(id);

		ccustomer = new Choice();
		ccustomer.setBounds(200, 80, 100, 25);
		add(ccustomer);
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from customerdetails");
			while (rs.next()) {
				ccustomer.add(rs.getString("number"));
			}
		} catch (Exception ae) {
			ae.printStackTrace();
		}
		JLabel room = new JLabel("Room No:");
		room.setBounds(30, 130, 100, 25);
		add(room);
		troom = new JTextField();
		troom.setBounds(200, 130, 100, 25);
		add(troom);
		JLabel Availbility = new JLabel("Availability:");
		Availbility.setBounds(30, 180, 100, 25);
		add(Availbility);
		tAvailbility = new JTextField();
		tAvailbility.setBounds(200, 180, 100, 25);
		add(tAvailbility);

		JLabel checktime = new JLabel("Cleaning Status:");
		checktime.setBounds(30, 230, 100, 25);
		add(checktime);
		tfstatus = new JTextField();
		tfstatus.setBounds(200, 230, 100, 25);
		add(tfstatus);
		check = new JButton("Check");
		check.setBounds(30, 300, 100, 30);
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		check.addActionListener(this);
		add(check);

		update = new JButton("Update");
		update.setBounds(150, 300, 100, 30);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.addActionListener(this);
		add(update);
		back = new JButton("Back");
		back.setBounds(270, 300, 100, 30);
		back.setBackground(Color.BLACK);
		back.addActionListener(this);
		back.setForeground(Color.WHITE);
		add(back);
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/seventh.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 50, 500, 300);
		add(image);

		setBounds(300, 200, 980, 450);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == check) {
			String id = ccustomer.getSelectedItem();
			String query = "select * from customerdetails where number='" + id + "'";
			try {
				Conn c = new Conn();
				ResultSet rs2 = c.s.executeQuery(query);
				while (rs2.next()) {
					troom.setText(rs2.getString("room"));
				}}catch (Exception ae) {
					ae.printStackTrace();
				}
			 String query2 = "select * from roomhelp where roomno='" +troom.getText() + " '";
				try {
					Conn c = new Conn();
					ResultSet rs3 = c.s.executeQuery(query2);
					while (rs3.next()) {
//						troom.setText(rs3.getString("room"));
					tAvailbility.setText(rs3.getString("availibility"));
					tfstatus.setText(rs3.getString("status"));

					}} catch (Exception ae) {
				ae.printStackTrace();
			}
		} else if (e.getSource() == update) {
			// String number=ccustomer.getSelectedItem();
			String room = troom.getText();
			String availibility = tAvailbility.getText();
			String status = tfstatus.getText();

			try {
				Conn con = new Conn();

				con.s.executeUpdate("update roomhelp set  availibility='" + availibility + " ',status='" + status
						+ " 'where roomno='" + room + "' ");
				JOptionPane.showMessageDialog(null, "data is updated");
				setVisible(false);
				new Reception();
			} catch (Exception ae) {
				ae.printStackTrace();
			}
		} else if (e.getSource() == back) {
			setVisible(false);
			new Reception();
		}
	}

	public static void main(String args[]) {
		new UpdateRoom();
	}
}
