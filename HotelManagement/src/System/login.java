package System;
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class login extends JFrame implements ActionListener {
JTextField user1,pass;
JLabel user,pass1;
JButton b1,b2;
	login() {
		getContentPane().setBackground(Color.WHITE);
			this.setBounds(500,200,600,350);
			this.setLayout(null);
		    user = new JLabel("Username:");
	        user.setFont(new Font("Osward",Font.BOLD, 28));
	        user.setBounds(20,50,150,30);
	       add(user);

	        user1=new JTextField();
	        user1.setBounds(200,50,150,30);
	        user1.setFont(new Font("Arial",Font.BOLD,14));
	       user1.addActionListener(this);
	        add(user1);
	        
	        pass1 = new JLabel("Password:");
	        pass1.setFont(new Font("Osward",Font.BOLD, 28));
	        pass1.setBounds(20,120,150,30);
	       add(pass1);
	        
	         pass=new JTextField();
	        pass.setBounds(200,120,150,30);
	        pass.setFont(new Font("Arial",Font.BOLD,14));
	       pass.addActionListener(this);
	        add(pass);
	        ImageIcon i1=new ImageIcon(getClass().getResource("/icons/second.jpg"));
			Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		    ImageIcon i3=new ImageIcon(i2);
		    JLabel image=new JLabel(i3);
		    image.setBounds(350,10,200,200);
		    add(image);
		    b1=new JButton("Cancel");
			b1.setBounds(200,220,100,30);
			b1.setBackground(Color.BLACK);
			b1.setForeground(Color.WHITE);
			b1.addActionListener(this);
	        add(b1);
	        b2=new JButton("Login");
			b2.setBounds(40,220,100,30);
			b2.setBackground(Color.BLACK);
			b2.setForeground(Color.WHITE);
			b2.addActionListener(this);
			add(b2);
		this.setVisible(true);
		this.setLocation(100,100);
		
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==b2){
		String user=user1.getText();
		String password=pass.getText();
		try{
			
			Conn c=new Conn();
			String query = "SELECT * FROM hotelmanagementsystem WHERE username='" + user + "' AND password='" + password + "'";
		ResultSet rs=	c.s.executeQuery(query);

		if(rs.next()){
			setVisible(false);
			new Dashboard();
		}else{
			JOptionPane.showMessageDialog(null, "Invalid username and password");
			setVisible(false);
		}
		}catch(Exception e){
			System.out.print(e);
		}
		}
		
	else if(ae.getSource()==b1)
	{
		setVisible(false);
	}
	}
	public static void main(String args[]) {
		new login();
	}
}
