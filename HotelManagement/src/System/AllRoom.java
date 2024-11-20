package System;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.*;
import javax.swing.*;
import java.awt.*;
public class AllRoom extends JFrame implements ActionListener {
	JTable t1;
	JButton back;
AllRoom(){
   setLayout(null);
	getContentPane().setBackground(Color.WHITE);
	setBounds(300,200,1050,600);
	ImageIcon i1=new ImageIcon(getClass().getResource("/icons/eight.jpg"));
	Image i2=i1.getImage().getScaledInstance(500,500, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(500,0,500,500);
    add(image);
    JLabel l1=new JLabel("Room NO");
    l1.setBounds(10, 10, 100, 20);
    add(l1);
    JLabel l2=new JLabel("Avalibility");
    l2.setBounds(120, 10, 100, 20);
    add(l2);
    JLabel l3=new JLabel("Status");
    l3.setBounds(230, 10, 100, 20);
    add(l3);
    JLabel l4=new JLabel("Price");
    l4.setBounds(330, 10, 100, 20);
    add(l4);
    JLabel l5=new JLabel("Bed Type");
    l5.setBounds(410, 10, 100, 20);
    add(l5);

    t1=new JTable();
    t1.setBounds(0,40,500,400);
    add(t1);
     back =new JButton ("Back");
     back.setBounds(200,500,120,30);
     back.setBackground(Color.BLACK);
     back.setForeground(Color.WHITE);
     back.addActionListener(this);
     add( back);

    try{
    	Conn conn=new Conn();
    	ResultSet rs=conn.s.executeQuery("select * from roomhelp");
    	t1.setModel(DbUtils.resultSetToTableModel(rs));
    }catch(Exception e){
    	e.printStackTrace();
    }
    setVisible(true);
	}
public void actionPerformed(ActionEvent ae){
	setVisible(false);
	new Reception();
}
public static void main(String args[]){
	new AllRoom();
}
}
