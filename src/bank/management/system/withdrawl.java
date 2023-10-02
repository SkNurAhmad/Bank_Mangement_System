package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class withdrawl extends JFrame implements ActionListener{
    String passWord,accountNo,balance;
    TextField textField;
    JButton b1, b2;
    withdrawl(String accountNo,String pin){
        this.accountNo = accountNo;
        this.passWord = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAWL");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 20));
        label1.setBounds(580,120,500,60);
        l3.add(label1);

        textField = new TextField("0");
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(580,280,400,45);
        textField.setFont(new Font("Raleway", Font.BOLD,30));
        l3.add(textField);

        b1 = new JButton("WITHDRAWL");
        b1.setBounds(580,412,400,45);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(580,476,400,45);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
           try {
            String amount = textField.getText();
            Date date = new Date();
            if(textField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
            }else{
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
                }
            }catch (Exception E) {
                E.printStackTrace();
            }
        }else if(e.getSource()==b2){
            new main_class(accountNo,passWord);
            setVisible(false);
        }
        
    }

    public static void main(String[] args) {
        new withdrawl("","");
    }
    
}
