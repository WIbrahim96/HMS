package hotel.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class CustomerInfo extends JFrame implements ActionListener
{
    JTable table;
    JButton back;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    CustomerInfo()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        l1 = new JLabel("Document Type");
        l1.setBounds(25, 10, 100, 20);
        add(l1);
        
        l2 = new JLabel("Phone Number");
        l2.setBounds(140, 10, 100, 20);
        add(l2);
        
        l3 = new JLabel("Name");
        l3.setBounds(280, 10, 100, 20);
        add(l3);
        
        l4 = new JLabel("Gender");
        l4.setBounds(390, 10, 100, 20);
        add(l4);
        
        l5 = new JLabel("Country");
        l5.setBounds(530, 10, 100, 20);
        add(l5);
        
        l6 = new JLabel("Room Number");
        l6.setBounds(645, 10, 100, 20);
        add(l6);
        
        l7 = new JLabel("Checkin Time");
        l7.setBounds(780, 10, 100, 20);
        add(l7);
        
        l8 = new JLabel("Deposit");
        l8.setBounds(895, 10, 100, 20);
        add(l8);
        
        table = new JTable();
        table.setBounds(0, 40, 1000, 400 );
        add(table);
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
                  e.printStackTrace();
        }
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420, 500, 120, 30);
        add(back);
        
        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args)
    {
        new CustomerInfo();
    }
}
