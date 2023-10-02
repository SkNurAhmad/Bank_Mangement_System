package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
// import java.util.*;


public class BalanceEnquiry extends JFrame implements ActionListener{
    String passWord,accountNo;
    JLabel label2;
    JButton b1;
    BalanceEnquiry(String accountNo,String pin){
        this.passWord = pin;
        this.accountNo = accountNo;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("Your Current Balance is Rs");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 20));
        label1.setBounds(200,120,500,60);
        l3.add(label1);

        label2 = new JLabel();
        label2.setBackground(new Color(65,125,128));
        label2.setForeground(Color.WHITE);
        label2.setBounds(200,180,900,45);
        label2.setFont(new Font("Raleway", Font.BOLD,30));
        l3.add(label2);

        b1 = new JButton("BACK");
        b1.setBounds(200,412,400,45);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        String balance = "0";
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from balance where account_number = '"+accountNo+"'");
            while(resultSet.next()){
                balance = resultSet.getString("totalBalance");
                label2.setText(""+balance+" /-");
            }

        } catch (Exception e) {
            e.printStackTrace();;
        }
        
        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("","");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new main_class(accountNo,passWord);
        setVisible(false);
    }
}
