package System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Update extends JFrame implements ActionListener{
	Choice ccustomer;
	JTextField tname, troom, tcheckintime, tDeposite, tpending;
	JButton back, update, check;

	Update() {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel text = new JLabel("Update Status");
		text.setFont(new Font("Tohama", Font.PLAIN, 20));
		text.setBounds(90, 20, 200, 30);
		text.setBackground(Color.BLUE);
		add(text);

		JLabel id = new JLabel("Customer Id:");
		// text.setFont(new Font("Tohama",Font.PLAIN,20));
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
		room.setBounds(30, 120, 100, 25);
		add(room);
		troom = new JTextField();
		troom.setBounds(200, 120, 100, 25);
		add(troom);
		JLabel name = new JLabel("Name");
		name.setBounds(30, 160, 100, 25);
		add(name);
		tname = new JTextField();
		tname.setBounds(200, 160, 100, 25);
		add(tname);

		JLabel checktime = new JLabel("Checkintime:");
		checktime.setBounds(30, 200, 100, 25);
		add(checktime);
		tcheckintime = new JTextField();
		tcheckintime.setBounds(200, 200, 150, 25);
		add(tcheckintime);
		JLabel Deposite = new JLabel("Amount Paid:");
		Deposite.setBounds(30, 240, 100, 25);
		add(Deposite);
		tDeposite = new JTextField();
		tDeposite.setBounds(200, 240, 150, 25);
		add(tDeposite);
		JLabel pending = new JLabel("Pending Amount:");
		pending.setBounds(30, 280, 100, 25);
		add(pending);
		tpending = new JTextField();
		tpending.setBounds(200, 280, 100, 25);
		add(tpending);
		check = new JButton("Check");
		check.setBounds(30, 340, 100, 30);
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		check.addActionListener(this);
		add(check);

		update = new JButton("Update");
		update.setBounds(150, 340, 100, 30);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.addActionListener(this);
		add(update);
		back = new JButton("Back");
		back.setBounds(270, 340, 100, 30);
		back.setBackground(Color.BLACK);
		back.addActionListener(this);
		back.setForeground(Color.WHITE);
		add(back);
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/nine.jpg"));
//		Image i2 = i1.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT);
//		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i1);
		image.setBounds(400, 50, 500, 300);
		add(image);

		setBounds(300, 200, 900, 500);
		setVisible(true);

	}
public void actionPerformed(ActionEvent e){
	if(e.getSource()==check){
		String id=ccustomer.getSelectedItem();
		String query="select * from customerdetails where number='"+id+"'";
		try{
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next()){
				troom.setText(rs.getString("room"));
				tname.setText(rs.getString("name"));
				tcheckintime.setText(rs.getString("checkintime"));
				 tDeposite.setText(rs.getString("deposite"));
			}
			
	ResultSet rs2=c.s.executeQuery("select * from roomhelp where roomno='"+troom.getText()+"'");
	System.out.print("hii");
	while(rs2.next())
		{
			String price=rs2.getString("price");
			int amountpaid=Integer.parseInt(price)-Integer.parseInt(tDeposite.getText());
			tpending.setText(""+amountpaid);
//			System.out.print("hii");
		}
		}catch(Exception ae){
			ae.printStackTrace();
		}
	}else if(e.getSource()==update){
		String number=ccustomer.getSelectedItem();
		String room=troom.getText();
		String name=tname.getText();
		String checkintime=tcheckintime.getText();
		String deposite=tDeposite.getText();
		try{
		Conn con=new Conn();
		
	con.s.executeUpdate("update customerdetails set room='"+room+" ',name='"+name+" ',checkintime='"+checkintime+"',deposite=' "+deposite+"' ");
	JOptionPane.showMessageDialog(null, "data is updated");
	setVisible(false);
	new Reception();
		}catch(Exception ae){
			ae.printStackTrace();
		}
	}else if(e.getSource()==back){
		setVisible(false);
		new Reception();
	}
}
	public static void main(String args[]) {
		new Update();
	}
}
