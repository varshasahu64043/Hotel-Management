package System;

import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.*;
//import javax.swing.JLabel;
//import javax.swing.JTextField;''

public class NewCustomer extends JFrame implements ActionListener {

	JComboBox proof, scountry;
	JTextField tnumber, tname, troom, tdeposite, tcountry;
	JRadioButton rmale, rfemale;
	Choice croom;
	JLabel checktime;
	JButton add, cancel;

	NewCustomer() {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		this.setBounds(300, 200, 850, 500);

		JLabel b1 = new JLabel("NEW CUSTOMER FORM");
		b1.setBounds(100, 20, 400, 30);
		b1.setFont(new Font("Raleway", Font.ITALIC, 30));
		add(b1);

		JLabel ID = new JLabel("ID:");
		ID.setBounds(10, 80, 100, 20);
		ID.setFont(new Font("Raleway", Font.BOLD, 20));
		add(ID);
		String availableOption[] = { "Adhar Card", "Passport", "Driving License", "Voter Id", "Rashan Card" };
		proof = new JComboBox(availableOption);
		proof.setBounds(200, 80, 150, 30);
		proof.setBackground(Color.WHITE);
		add(proof);

		JLabel number = new JLabel("Number:");
		number.setBounds(10, 120, 300, 20);
		number.setFont(new Font("Raleway", Font.BOLD, 20));
		add(number);
		tnumber = new JTextField();
		tnumber.setBounds(200, 120, 150, 30);
		add(tnumber);
		JLabel lname = new JLabel("Name:");
		lname.setBounds(10, 170, 300, 20);
		lname.setFont(new Font("Raleway", Font.BOLD, 20));
		add(lname);
		tname = new JTextField();
		tname.setBounds(200, 170, 150, 30);
		add(tname);

		JLabel gender = new JLabel("Gender:");
		gender.setBounds(10, 210, 300, 20);
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		add(gender);

		rmale = new JRadioButton("Male");
		rmale.setBounds(200, 210, 70, 20);
		rmale.setForeground(Color.WHITE);
		rmale.setBackground(Color.BLACK);
		rmale.setFont(new Font("Raleway", Font.ITALIC, 10));
		add(rmale);
		rfemale = new JRadioButton("Female");
		rfemale.setBounds(280, 210, 70, 20);
		rfemale.setForeground(Color.WHITE);
		rfemale.setBackground(Color.BLACK);
		rfemale.setFont(new Font("Raleway", Font.ITALIC, 10));
		add(rfemale);
		JLabel Country = new JLabel("Country:");
		Country.setBounds(10, 250, 300, 20);
		Country.setFont(new Font("Raleway", Font.BOLD, 20));
		add(Country);

		tcountry = new JTextField();
		tcountry.setBounds(200, 250, 150, 30);
		add(tcountry);

		JLabel Allocated = new JLabel("Room Number:");
		Allocated.setBounds(10, 290, 170, 20);
		Allocated.setFont(new Font("Raleway", Font.BOLD, 20));
		add(Allocated);
		croom = new Choice();
		try {
			Conn conn = new Conn();
			String query = "select * from roomhelp";
			ResultSet rs = conn.s.executeQuery(query);
			while (rs.next()) {
				croom.add(rs.getString("roomno"));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		croom.setBounds(200, 290, 150, 25);
		croom.setFont(new Font("Raleway", Font.BOLD, 20));
		add(croom);
		JLabel ltime = new JLabel("Check Time:");
		ltime.setBounds(10, 330, 300, 20);
		ltime.setFont(new Font("Raleway", Font.BOLD, 20));
		add(ltime);
		Date date = new Date();

		checktime = new JLabel("" + date);
		checktime.setBounds(200, 330, 300, 20);
		checktime.setFont(new Font("Raleway", Font.BOLD, 14));
		add(checktime);

		JLabel deposite = new JLabel("Deposite:");
		deposite.setBounds(10, 370, 300, 20);
		deposite.setFont(new Font("Raleway", Font.BOLD, 20));
		add(deposite);
		tdeposite = new JTextField();
		tdeposite.setBounds(200, 370, 100, 30);
		add(tdeposite);
		add = new JButton("Add");
		add.setBounds(60, 410, 100, 30);
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.addActionListener(this);
		add(add);
		cancel = new JButton("Back");
		cancel.setBounds(200, 410, 100, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/fifth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(380, 60, 300, 350);
		add(image);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == add) {
			String id = (String) proof.getSelectedItem();
			String number = tnumber.getText();
			String name = tname.getText();
			String gender = null;
			if (rmale.isSelected()) {
				gender = "Male";

			} else {
				gender = "Female";
			}

			String country = tcountry.getText();

			String room = croom.getSelectedItem();
			String checkintime = checktime.getText();
			String deposite = tdeposite.getText();
			try {
				String query = "insert into customerdetails values('" + id + " ','" + number + " ','" + name + " ','"
						+ gender + " ','" + country + " ','" + room + " ','" + checkintime + " ','" + deposite + " ')";
				String query2 = "update  roomhelp set availibility='Occupied' where roomno=' " + room + " '";
				Conn conn = new Conn();
				conn.s.executeUpdate(query);
				// conn.s.executeUpdate(query2);

				JOptionPane.showMessageDialog(null, "New customer Added");
				setVisible(false);
				new Reception();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (ae.getSource() == cancel) {
			setVisible(false);
			new Reception();
		}
	}

	public static void main(String args[]) {
		new NewCustomer();

	}
}
