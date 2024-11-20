package System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class AddEmployee extends JFrame implements ActionListener {
JButton submit;
JTextField tname,tage,tsalary,temail,tphone,tadhar;
JRadioButton male,female;
JComboBox cbjob;
	AddEmployee(){
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setBounds(350,200,800,500);
		JLabel name =new JLabel("NAME");
		name.setBounds(60,30,120,30);
		name.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(name);
		 tname=new JTextField();
		tname.setBounds(200,30,150,30);
		add(tname);
		JLabel age =new JLabel("AGE");
		age.setBounds(60,80,120,30);
		age.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(age);
		 tage=new JTextField();
		tage.setBounds(200,80,150,30);
		add(tage);
		JLabel gender=new JLabel("GENDER");
		gender.setBounds(60,130,120,30);
		gender.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(gender);
		ButtonGroup bg=new ButtonGroup();
		bg.add(male);
		bg.add(female);
		 male=new JRadioButton("Male");
		male.setBounds(200,130,70,30);
		male.setFont(new Font("Tahoma",Font.PLAIN,14));
		male.setBackground(Color.WHITE);
		add(male);
          female=new JRadioButton("Female");
 		female.setBounds(280,130,70,30);
 		female.setFont(new Font("Tahoma",Font.PLAIN,14));
 		female.setBackground(Color.WHITE);
 		add(female);
          JLabel job=new JLabel("JOB");
  		job.setBounds(60,180,120,30);
  		job.setFont(new Font("Tahoma",Font.PLAIN,20));
  		add(job);
  		String str[]={"Front Desk Clerks","Potters","Housekeeping","Kitchen Staff","RoomService",
  				"Chefs","Waiter","Manager","Accountable"};
  		 cbjob=new JComboBox(str);
  		cbjob.setBounds(200,180,150,30);
  		cbjob.setBackground(Color.WHITE);
  		add(cbjob);
  		JLabel salary=new JLabel("SALARY");
		salary.setBounds(60,230,120,30);
		salary.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(salary);
		tsalary=new JTextField();
		tsalary.setBounds(200,230,150,30);
		add(tsalary);
		JLabel phone=new JLabel("PHONE");
		phone.setBounds(60,280,120,30);
		phone.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(phone);
		 tphone=new JTextField();
		tphone.setBounds(200,280,150,30);
	
		add(tphone);
		JLabel email=new JLabel("EMAIL");
		email.setBounds(60,330,120,30);
		email.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(email);
		 temail=new JTextField();
		temail.setBounds(200,330,150,30);
		add(temail);
		
		JLabel aadhar=new JLabel("ADHAR");
	     aadhar.setBounds(60,380,120,30);
		aadhar.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(aadhar);
		 tadhar=new JTextField();
		tadhar.setBounds(200,380,150,30);
		add(tadhar);

		 submit=new JButton("SUBMIT");
		submit.setBounds(200,430,100,30);
	submit.setBackground(Color.BLACK);
	submit.setForeground(Color.WHITE);
	submit.addActionListener(this);
	add(submit);
	ImageIcon i1=new ImageIcon(getClass().getResource("/icons/tenth.jpg"));
	Image i2=i1.getImage().getScaledInstance(450,450, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(380,60,450,370);
    add(image);
setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String name=tname.getText();
		String age=tage.getText();		
		String gender=null;
		if(male.isSelected()){
			gender="Male";
		}else if(female.isSelected()){
			gender="Female";
		}
		String job=(String)cbjob.getSelectedItem();
		String salary=tsalary.getText();
		String email=temail.getText();
		String phone=tphone.getText();
		String aadhar=tadhar.getText();
		

	
		try{
		Conn conn=new Conn();
String query ="insert into hotelEmp values('"+name+"','"+age+" ','"+gender+" ',' "+job+"','"+salary+" ','"+phone+" ','"+email+" ', '"+aadhar+" ')";
		
conn.s.executeUpdate(query);
JOptionPane.showMessageDialog(null, "Employee added Sucessfully");
setVisible(false);
		}catch(Exception e){
			System.out.print(e);
		}
	
	}
	public static void main(String args[]){
		new AddEmployee();
	}
}
