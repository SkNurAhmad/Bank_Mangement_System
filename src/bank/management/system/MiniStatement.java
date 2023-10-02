package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener{
    String accountNo,passWord,name;
    JButton b1;
    MiniStatement(String accountNo,String passWord){
        super("Transtion Statement");
        this.accountNo = accountNo;
        this.passWord = passWord;

        JLabel label1 = new JLabel("Account No.: "+accountNo);
        label1.setBounds(50,60,700,35);
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("System",Font.BOLD,20));
        add(label1);

        JLabel label2 = new JLabel();
        label2.setBounds(50,30,700,35);
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("System",Font.BOLD,20));
        add(label2);
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from login where account_number = '"+accountNo+"'");
            while(resultSet.next()){
                name = resultSet.getString("name");
            }
            label2.setText("Name: "+name);

        } catch (Exception e) {
            e.printStackTrace();;
        }

        JLabel label3 = new JLabel("Date: ");
        label3.setBounds(50,110,700,35);
        label3.setForeground(Color.BLACK);
        label3.setFont(new Font("System",Font.BOLD,20));
        add(label3);

        JLabel label31 = new JLabel();
        label31.setBounds(50,160,700,470);
        label31.setForeground(Color.BLACK);
        // label31.setFont(new Font("System",Font.PLAIN,18));
        add(label31);

        JLabel label4 = new JLabel("Type: ");
        label4.setBounds(700,110,700,35);
        label4.setForeground(Color.BLACK);
        label4.setFont(new Font("System",Font.BOLD,20));
        add(label4);

        JLabel label41 = new JLabel();
        label41.setBounds(700,160,700,470);
        label41.setForeground(Color.BLACK);
        // label41.setFont(new Font("System",Font.PLAIN,14));
        add(label41);

        JLabel label5 = new JLabel("Amount: ");
        label5.setBounds(1200,110,700,35);
        label5.setForeground(Color.BLACK);
        label5.setFont(new Font("System",Font.BOLD,20));
        add(label5);

        JLabel label51 = new JLabel();
        label51.setBounds(1200,160,700,470);
        label51.setForeground(Color.BLACK);
        // label51.setFont(new Font("System",Font.PLAIN,18));
        add(label51);
        String t1="",t2="",t3="";
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM (SELECT * FROM bank WHERE account_number = '" + accountNo + "' ORDER BY date DESC LIMIT 10) sub ORDER BY date ASC");
            while(resultSet.next()){
                // label31.setText(label31.getText()+"<html>"+resultSet.getString("date")+"<br><br><br><html>");
                // label41.setText(label41.getText()+"<html>"+resultSet.getString("type")+"<br><br><br><html>");
                // label51.setText(label51.getText()+"<html>"+resultSet.getString("amount")+"<br><br><br><html>");
                t1+="<html>"+resultSet.getString("date")+"<br><br><br><html>";
                t2+="<html>"+resultSet.getString("type")+"<br><br><br><html>";
                t3+="<html>"+resultSet.getString("amount")+"<br><br><br><html>";

            }

            label31.setText(t1);
            label41.setText(t2);
            label51.setText(t3);
            
        }
         catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel label6 = new JLabel("Your Account Current Total Balance is Rs.");
        label6.setBounds(50,650,700,35);
        label6.setForeground(Color.BLACK);
        label6.setFont(new Font("System",Font.BOLD,20));
        add(label6);

        JLabel label7 = new JLabel("");
        label7.setBounds(1200,650,700,35);
        label7.setForeground(Color.BLACK);
        label7.setFont(new Font("System",Font.BOLD,20));
        add(label7);

        try {
            String balance ;
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from balance where account_number = '"+accountNo+"'");
            while(resultSet.next()){
                balance = resultSet.getString("totalBalance");
                label7.setText(""+balance+" /-");
            }

        } catch (Exception e) {
            e.printStackTrace();;
        }

        b1 = new JButton("BACK");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(1200,50,200,40);
        b1.addActionListener(this);
        add(b1);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("","");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new main_class(accountNo, passWord);
        setVisible(false);
    }    
}