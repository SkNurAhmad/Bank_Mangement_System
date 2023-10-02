package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class FastCash extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7;
    String accountNo,passWord,balance;
    FastCash(String accountNo,String passWord){
        this.accountNo = accountNo;
        this.passWord = passWord;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label = new JLabel("Select Withdrawl Amount");
        label.setBounds(550,130,700,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,28));
        l3.add(label);


        b1 = new JButton("Rs. 100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(300,274,350,40);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("Rs. 500");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(850,274,350,40);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("Rs. 1,000");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(300,374,350,40);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("Rs. 2,000");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(850,374,350,40);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("Rs. 5,000");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(300,474,350,40);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("Rs. 10,000");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(850,474,350,40);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("BACK");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65,125,128));
        b7.setBounds(560,574,350,40);
        b7.addActionListener(this);
        l3.add(b7);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }
    public static void main(String[] args) {
        new FastCash("","");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource()==b1){
                String amount = "100";
                Date date = new Date();
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery("select * from balance where account_number = '"+accountNo+"'");
                while(resultSet.next()){
                    balance = resultSet.getString("totalBalance");
                }
                if(Integer.parseInt(balance)<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }
                c.statement.executeUpdate("insert into bank values('"+accountNo+"','"+passWord+"', '"+date+"','Withdrawl', '"+amount+"')");
                int tBalance = Integer.parseInt(balance);
                tBalance = tBalance-Integer.parseInt(amount) ;
                String q1 = "update balance set totalBalance ='"+tBalance+"' where account_number = '"+accountNo+"'";
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
                
                new main_class(accountNo,passWord);
                setVisible(false);

            }else if(e.getSource()==b2){
                String amount = "500";
                Date date = new Date();
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery("select * from balance where account_number = '"+accountNo+"'");
                while(resultSet.next()){
                    balance = resultSet.getString("totalBalance");
                }
                if(Integer.parseInt(balance)<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }
                c.statement.executeUpdate("insert into bank values('"+accountNo+"','"+passWord+"', '"+date+"','Withdrawl', '"+amount+"')");
                int tBalance = Integer.parseInt(balance);
                tBalance = tBalance-Integer.parseInt(amount) ;
                String q1 = "update balance set totalBalance ='"+tBalance+"' where account_number = '"+accountNo+"'";
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
                
                new main_class(accountNo,passWord);
                setVisible(false);

            }else if(e.getSource()==b3){
                String amount = "1000";
                Date date = new Date();
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery("select * from balance where account_number = '"+accountNo+"'");
                while(resultSet.next()){
                    balance = resultSet.getString("totalBalance");
                }
                if(Integer.parseInt(balance)<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }
                c.statement.executeUpdate("insert into bank values('"+accountNo+"','"+passWord+"', '"+date+"','Withdrawl', '"+amount+"')");
                int tBalance = Integer.parseInt(balance);
                tBalance = tBalance-Integer.parseInt(amount) ;
                String q1 = "update balance set totalBalance ='"+tBalance+"' where account_number = '"+accountNo+"'";
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
                
                new main_class(accountNo,passWord);
                setVisible(false);

            }else if(e.getSource()==b4){
                String amount = "2000";
                Date date = new Date();
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery("select * from balance where account_number = '"+accountNo+"'");
                while(resultSet.next()){
                    balance = resultSet.getString("totalBalance");
                }
                if(Integer.parseInt(balance)<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }
                c.statement.executeUpdate("insert into bank values('"+accountNo+"','"+passWord+"', '"+date+"','Withdrawl', '"+amount+"')");
                int tBalance = Integer.parseInt(balance);
                tBalance = tBalance-Integer.parseInt(amount) ;
                String q1 = "update balance set totalBalance ='"+tBalance+"' where account_number = '"+accountNo+"'";
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
                
                new main_class(accountNo,passWord);
                setVisible(false);

            }else if(e.getSource()==b5){
                String amount = "5000";
                Date date = new Date();
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery("select * from balance where account_number = '"+accountNo+"'");
                while(resultSet.next()){
                    balance = resultSet.getString("totalBalance");
                }
                if(Integer.parseInt(balance)<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }
                c.statement.executeUpdate("insert into bank values('"+accountNo+"','"+passWord+"', '"+date+"','Withdrawl', '"+amount+"')");
                int tBalance = Integer.parseInt(balance);
                tBalance = tBalance-Integer.parseInt(amount) ;
                String q1 = "update balance set totalBalance ='"+tBalance+"' where account_number = '"+accountNo+"'";
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
                
                new main_class(accountNo,passWord);
                setVisible(false);

            }else if(e.getSource()==b6){
                String amount = "10000";
                Date date = new Date();
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery("select * from balance where account_number = '"+accountNo+"'");
                while(resultSet.next()){
                    balance = resultSet.getString("totalBalance");
                }
                if(Integer.parseInt(balance)<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }
                c.statement.executeUpdate("insert into bank values('"+accountNo+"','"+passWord+"', '"+date+"','Withdrawl', '"+amount+"')");
                int tBalance = Integer.parseInt(balance);
                tBalance = tBalance-Integer.parseInt(amount) ;
                String q1 = "update balance set totalBalance ='"+tBalance+"' where account_number = '"+accountNo+"'";
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
                
                new main_class(accountNo,passWord);
                setVisible(false);
                
            }else if(e.getSource()==b7){
            new main_class(accountNo,passWord);
            setVisible(false);
        }
        } catch (Exception E) {
            E.printStackTrace();
        }
       
    }
}