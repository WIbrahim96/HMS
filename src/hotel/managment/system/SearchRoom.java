package hotel.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class SearchRoom extends JFrame implements ActionListener
{
    JTable table;
    JButton back, submit;
    JLabel l1, l2, l3, l4, l5;
    JComboBox bedType;
    JCheckBox available;
    SearchRoom()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Search for Room");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);
        
        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(10, 100, 100, 20);
        add(lblbed);
        
        bedType = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        bedType.setBounds(150, 100, 150, 25);
        bedType.setBackground(Color.BLACK);
        bedType.setBackground(Color.WHITE);
        add(bedType);
        
        available = new JCheckBox("Only display Available");
        available.setBounds(560, 100, 150, 25);
        available.setBackground(Color.WHITE);
        add(available);
        
        l1 = new JLabel("Room Number");
        l1.setBounds(50, 160, 100, 20);
        add(l1);
        
        l2 = new JLabel("Availibilty");
        l2.setBounds(270, 160, 100, 20);
        add(l2);
        
        l3 = new JLabel("Cleaning Status");
        l3.setBounds(450, 160, 100, 20);
        add(l3);
        
        l4 = new JLabel("Price");
        l4.setBounds(670, 160, 100, 20);
        add(l4);
        
        l5 = new JLabel("Bed Type");
        l5.setBounds(870, 160, 100, 20);
        add(l5);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300 );
        add(table);
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
                  e.printStackTrace();
        }
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300, 520, 120, 30);
        add(submit);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(500, 520, 120, 30);
        add(back);
        
        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) 
    {
        try 
        {
            String query = "select * from room where bed_type = '" + bedType.getSelectedItem() + "'";
            String queryAvailable = "select * from room where availability = 'Available' AND bed_type = '" + bedType.getSelectedItem() + "'";

            Conn conn = new Conn();
            ResultSet rs;
            
            if (available.isSelected()) 
            {
                rs = conn.s.executeQuery(queryAvailable);
            } 
            else 
            {
                rs = conn.s.executeQuery(query);
            }

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    } 
    else if (ae.getSource() == back) 
    {
        setVisible(false);
        new Reception();
    }
}

     
    public static void main(String[] args)
    {
        new SearchRoom();
    }
}
