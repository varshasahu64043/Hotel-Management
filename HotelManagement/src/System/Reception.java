package System;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener {
	JButton room, b1, department,pickup,  serchRoom,allemp, managerInfo, allcust, checkout,update,roomstatus;

	Reception() {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setBounds(350, 180, 800, 570);
		b1 = new JButton("New Customer Form");
		b1.setBounds(10, 30, 200, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		room = new JButton("Rooms");
		room.setBounds(10, 70, 200, 30);
		room.setBackground(Color.BLACK);
		room.setForeground(Color.WHITE);
		room.addActionListener(this);
		add(room);
		department = new JButton("Department");
		department.setBounds(10, 110, 200, 30);
		department.setBackground(Color.BLACK);
		department.setForeground(Color.WHITE);
		department.addActionListener(this);
		add(department);

		allemp = new JButton("All Employee");
		allemp.setBounds(10, 150, 200, 30);
		allemp.setBackground(Color.BLACK);
		allemp.setForeground(Color.WHITE);
		allemp.addActionListener(this);
		add(allemp);

		allcust = new JButton("All Customer");
		allcust.setBounds(10, 190, 200, 30);
		allcust.setBackground(Color.BLACK);
		allcust.setForeground(Color.WHITE);
		allcust.addActionListener(this);
		add(allcust);

		managerInfo = new JButton("Manager Information");
		managerInfo.setBounds(10, 230, 200, 30);
		managerInfo.setBackground(Color.BLACK);
		managerInfo.setForeground(Color.WHITE);
		managerInfo.addActionListener(this);
		add(managerInfo);

		checkout = new JButton("Check out");
		checkout.setBounds(10, 270, 200, 30);
		checkout.setBackground(Color.BLACK);
		checkout.setForeground(Color.WHITE);
		checkout.addActionListener(this);
		add(checkout);

		 update = new JButton("Pending Status");
		update.setBounds(10, 310, 200, 30);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.addActionListener(this);
		add(update);
		
		 roomstatus = new JButton("Room Status");
		roomstatus.setBounds(10, 350, 200, 30);
		roomstatus.setBackground(Color.BLACK);
		roomstatus.setForeground(Color.WHITE);
		roomstatus.addActionListener(this);
		add(roomstatus);
		
		 pickup = new JButton("Pickup Service");
		pickup.setBounds(10, 390, 200, 30);
		pickup.setBackground(Color.BLACK);
		pickup.setForeground(Color.WHITE);
		pickup.addActionListener(this);
		add(pickup);
		
		 serchRoom = new JButton("Search Room");
		serchRoom.setBounds(10, 430, 200, 30);
		serchRoom.setBackground(Color.BLACK);
		serchRoom.setForeground(Color.WHITE);
		 serchRoom.addActionListener(this);
		add(serchRoom);
	
		JButton logout = new JButton("Log Out");
		logout.setBounds(10, 470, 200, 30);
		logout.setBackground(Color.BLACK);
		logout.setForeground(Color.WHITE);
		add(logout);

		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/fourth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 470, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(250, 30, 500, 470);
		add(image);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			setVisible(false);
			new NewCustomer();
		} else if (ae.getSource() == room) {
			setVisible(false);
			new Addroom();
		} else if (ae.getSource() == department) {
			setVisible(false);
			new Department();
		} else if (ae.getSource() == allemp) {
			setVisible(false);
			new Allformation();
		} else if (ae.getSource() == managerInfo) {
			setVisible(false);
			new ManagerInfo();
		} else if (ae.getSource() == allcust) {
			setVisible(false);
			new CustomerInfo();
		} else if (ae.getSource() == checkout) {
			setVisible(false);
			new Checkout();
		}else if (ae.getSource() == update) {
			setVisible(false);
			new Update();
		}else if (ae.getSource() == roomstatus) {
			setVisible(false);
			new UpdateRoom();
		}else if (ae.getSource() == serchRoom ) {
			setVisible(false);
			new SearchRoom();
		}else if (ae.getSource() == pickup ) {
			setVisible(false);
			new Adddriver();
		}


	}

	public static void main(String args[]) {
		new Reception();
	}
}
