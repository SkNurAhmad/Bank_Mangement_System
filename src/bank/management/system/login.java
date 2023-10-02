package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener{

    JLabel label1,labe2,labe3;
    JTextField textField1;
    JPasswordField passwordField1;
    JButton button1,button2,button3,button4,button5;

    login(){
        super("Bank Management System");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(765,100,100,100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(1330,700,100,100);
        add(iimage);

        label1 = new JLabel("WELCOME TO BANK");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 40));
        label1.setBounds(600,200,450,40);
        add(label1);

        button4 = new JButton("Admin Log In");
        button4.setFont(new Font("Arial", Font.BOLD, 22));
        button4.setForeground(Color.WHITE);
        button4.setBackground(Color.BLACK);
        button4.setBounds(1300,30,180, 50);
        button4.addActionListener(this);
        add(button4);

        button5 = new JButton("CLOSE");
        button5.setFont(new Font("Arial", Font.BOLD, 22));
        button5.setForeground(Color.WHITE);
        button5.setBackground(Color.BLACK);
        button5.setBounds(1300,100,180, 50);
        button5.addActionListener(this);
        add(button5);

        labe2 = new JLabel("Account No. :");
        labe2.setFont(new Font("Ralway", Font.BOLD, 28));
        labe2.setForeground(Color.WHITE);
        labe2.setBounds(530,300,375,30);
        add(labe2);

        textField1 = new JTextField(15);
        textField1.setBounds(750,300,300,30);
        textField1.setFont(new Font("Arial", Font.BOLD,20));
        add(textField1);


        labe3 = new JLabel("Password : ");
        labe3.setFont(new Font("Ralway", Font.BOLD, 28));
        labe3.setForeground(Color.WHITE);
        labe3.setBounds(530,400,375,30);
        add(labe3);

        passwordField1 = new JPasswordField(15);
        passwordField1.setBounds(750,400,300,30);
        passwordField1.setFont(new Font("Arial", Font.BOLD, 20));
        add(passwordField1);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 18));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(530,500,220, 40);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 18));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(830,500,220, 40);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 18));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(530,600,520, 40);
        button3.addActionListener(this);
        add(button3);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(1550,1080,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,1550,1080);
        add(iiimage);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(false);
        setVisible(true);

        textField1.requestFocusInWindow();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource()==button1){
                Conn log = new Conn();
                String accountNo = textField1.getText();
                // char[] pin = passwordField1.getPassword();
                String passWord = String.valueOf(passwordField1.getPassword());
                String q = "select * from login where account_number = '"+accountNo+"' and  pin = '"+passWord+"'";
                ResultSet resultSet = log.statement.executeQuery(q);
                if (resultSet.next()){
                    setVisible(false);
                    new main_class(accountNo,passWord);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Account Number or Password");
                }
            }else if(e.getSource()==button2){
                textField1.setText("");
                passwordField1.setText("");

            }else if(e.getSource()==button3){
                new signUp();
                setVisible(false);

            }else if(e.getSource()==button4){
                new Admin_login();
                setVisible(false);

            }else if(e.getSource()==button5){
                System.exit(0);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String args[]){
        new login();
    }
    
}
