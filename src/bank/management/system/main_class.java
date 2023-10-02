package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class main_class extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    String accountNo,passWord,fromNo,name;
    // String accountNo ;
    JLabel label2,label3;
    main_class(String accountNo,String passWord){
        this.passWord = passWord;
        this.accountNo = accountNo;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(550,130,700,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,28));
        l3.add(label);

        label2 = new JLabel("Account No.: "+accountNo);
        label2.setBounds(100,100,700,35);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,20));
        l3.add(label2);

        label3 = new JLabel();
        label3.setBounds(100,60,700,35);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System",Font.BOLD,20));
        l3.add(label3);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from login where account_number = '"+accountNo+"'");
            // resultSet = c.statement.executeQuery("Select * from login where pin = '"+passWord+"'");
            while(resultSet.next()){
                // accountNo = resultSet.getString("account_number");
                name = resultSet.getString("name");
            }
                
            // label2.setText();
            label3.setText("Name: "+name);
            // resultSet = c.statement.executeQuery("Select * from login where pin = '"+passWord+"'");
            // while(resultSet.next())
            //     fromNo = resultSet.getString("form_no");
            
            // resultSet = c.statement.executeQuery("Select * from login where form_no = '"+fromNo+"'");
            // while(resultSet.next())
            //     name = resultSet.getString("name");
            // label3.setText("Name: "+name);

        } catch (Exception e) {
            e.printStackTrace();;
        }
        b8 = new JButton("Log Out");
        b8.setForeground(Color.WHITE);
        b8.setBackground(new Color(65,125,128));
        b8.setBounds(1300,50,200,40);
        b8.addActionListener(this);
        l3.add(b8);

        b1 = new JButton("DEPOSIT");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(300,274,350,40);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("CASH WITHDRAWL");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(850,274,350,40);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(300,374,350,40);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(850,374,350,40);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("PASSWORD CHANGE");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(300,474,350,40);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(850,474,350,40);
        b6.addActionListener(this);
        l3.add(b6);

        b9 = new JButton("TRANSFER TO ACCOUNT");
        b9.setForeground(Color.WHITE);
        b9.setBackground(new Color(65,125,128));
        b9.setBounds(300,574,350,40);
        b9.addActionListener(this);
        l3.add(b9);

        b7 = new JButton("EXIT");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65,125,128));
        b7.setBounds(850,574,350,40);
        b7.addActionListener(this);
        l3.add(b7);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            new Deposit(accountNo,passWord,name);
            setVisible(false);
         }else if (e.getSource()==b7){
            System.exit(0);
         } else if (e.getSource()==b2) {
            new withdrawl(accountNo,passWord);
            setVisible(false);
         } else if (e.getSource()==b6) {
            new BalanceEnquiry(accountNo,passWord);
            setVisible(false);
         } else if (e.getSource()==b3) {
            new FastCash(accountNo,passWord);
            setVisible(false);
         } else if (e.getSource()==b5) {
            new PassWordChange(accountNo, passWord);
            setVisible(false);
         } else if (e.getSource()==b4) {
            new MiniStatement(accountNo, passWord);
            setVisible(false);
         } else if (e.getSource()==b9) {
            new TransferToAccount(accountNo, passWord);
            setVisible(false);
         }else if (e.getSource()==b8) {
            setVisible(false);
            new login();
         }
    }

    public static void main(String[] args) {
        new main_class("","");
    }

    
}
