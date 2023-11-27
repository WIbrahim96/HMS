
package hotel.managment.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class HotelManagmentSystem extends JFrame implements ActionListener {

    //constructor
   HotelManagmentSystem(){
      // setSize(648, 469);
       //setLocation(100, 100);
       setBounds(100, 100, 1366, 565);
       setLayout(null);
       
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
       JLabel image = new JLabel(i1);
       image.setBounds(0, 0, 1366, 565);
       add(image);
       
       
       JLabel text = new JLabel("HOTEL MANAGMENT SYSTEM");
       text.setBounds(20, 430, 1000, 90);
       text.setForeground(Color.CYAN);
       text.setFont(new Font("serif", Font.PLAIN, 50));
       image.add(text);
       
       JButton next = new JButton("Next");
       next.setBounds(1150, 450, 150, 50);
       next.setBackground(Color.BLACK);
       next.setForeground(Color.CYAN);
       next.addActionListener(this);
       next.setFont(new Font("serif", Font.PLAIN, 18));
       image.add(next);
       
       setVisible(true);
       
       
   }
   
   public void actionPerformed(ActionEvent ae)
   {
       setVisible(false);
       Login login = new Login();
       
   }
   
    public static void main(String[] args) {
        new HotelManagmentSystem() {};
    }
    
}
