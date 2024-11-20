package System;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener {
	JTable t1;
	JButton back,submit;
	JComboBox<String> bedtype;
	JCheckBox available;

	SearchRoom(){
	
		 setLayout(null);
			getContentPane().setBackground(Color.WHITE);
			setBounds(300,200,1000,600);
				
		    JLabel text=new JLabel("Search for Room ");
		    text.setFont(new Font("Tahoma",Font.PLAIN,20))
;		    text.setBounds(400, 30, 200, 20);
		    add(text);
		    
		   JLabel lbedtype=new JLabel("Bed Type: ");
		    lbedtype.setFont(new Font("Tahoma",Font.PLAIN,20))
;		   lbedtype.setBounds(50, 100, 200, 20);
		    add(lbedtype);

		    bedtype=new JComboBox(new String[]{"Sigle Bed","Double Bed"});
		    bedtype.setBounds(150,100,150,25);
		    bedtype.setBackground(Color.WHITE);
//		    bedtype.addActionListener(this);
		    add(bedtype);
		   
		    available =new JCheckBox("Only display availble");
		   available.setBounds(650,100,150,25);
		    available.setBackground(Color.WHITE);
//		    available.addActionListener(this);
		add(available);
		    
		JLabel l1=new JLabel("Room NO");
	    l1.setBounds(50, 160, 100, 20);
	    add(l1);
	    JLabel l2=new JLabel("Avalibility");
	    l2.setBounds(270, 160, 100, 20);
	    add(l2);
	    JLabel l3=new JLabel("Status");
	    l3.setBounds(450, 160, 100, 20);
	    add(l3);
	    JLabel l4=new JLabel("Price");
	    l4.setBounds(670, 160, 100, 20);
	    add(l4);
	    JLabel l5=new JLabel("Bed Type");
	    l5.setBounds(870, 160, 100, 20);
	    add(l5);
		    t1=new JTable();
		    t1.setBounds(0,200,1000,300);
		    add(t1);

		    try{
		    	Conn conn=new Conn();
		    	ResultSet rs=conn.s.executeQuery("select * from roomhelp");
		    	t1.setModel(DbUtils.resultSetToTableModel(rs));
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
    
		    back=new JButton("Back");
		    back.setBounds(400,500,100,30);
		    back.setBackground(Color.BLACK);
		    back.setForeground(Color.WHITE);
		    back.addActionListener(this);
		   	add(back);
		   	submit=new JButton("Submit");
		   	submit.setBounds(550,500,100,30);
		   	submit.setBackground(Color.BLACK);
		   	submit.setForeground(Color.WHITE);
		   	submit.addActionListener(this);
		   	add(submit);
		    setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit){
			try{
			String query1 ="select * from roomhelp where type='"+bedtype.getSelectedItem()+" ' ";
			String query2="select * from roomhelp where availibility='available'AND '"+bedtype.getSelectedItem()+" ' ";
			Conn conn=new Conn();
			ResultSet rs;
			if(available.isSelected()){
				rs=conn.s.executeQuery(query2);
				
			}else{
				rs=conn.s.executeQuery(query1);
			}
			t1.setModel(DbUtils.resultSetToTableModel(rs));
			System.out.println("done");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	else{
		setVisible(false);
		new Reception();
	}
	}
	public static void main(String args[]) {
		new SearchRoom();
	}
}