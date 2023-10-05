package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Admin_login extends JFrame implements ActionListener{
    JTextField textField1;
    JPasswordField passwordField1;
    JButton b1,b2;
    String login_id,passWord;
    
    Admin_login(){
        super("Admin Log In");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(675,100,100,100);
        add(image);

        JLabel labe1 = new JLabel("<html><u>Welcome To Admin Log In Page<br><u><br><html>");
        labe1.setFont(new Font("Ralway", Font.BOLD, 28));
        labe1.setForeground(Color.BLACK);
        labe1.setBounds(520,200,800,60);
        add(labe1);

        JLabel labe2 = new JLabel("Admin Id: ");
        labe2.setFont(new Font("Ralway", Font.BOLD, 28));
        labe2.setForeground(Color.BLACK);
        labe2.setBounds(500,300,375,30);
        add(labe2);

        textField1 = new JTextField(15);
        textField1.setBounds(730,300,230,30);
        textField1.setFont(new Font("Arial", Font.BOLD,14));
        add(textField1);

        JLabel labe3 = new JLabel("Password: ");
        labe3.setFont(new Font("Ralway", Font.BOLD, 28));
        labe3.setForeground(Color.BLACK);
        labe3.setBounds(500,350,375,30);
        add(labe3);

        passwordField1 = new JPasswordField(15);
        passwordField1.setBounds(730,350,230,30);
        passwordField1.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField1);

        b1 = new JButton("Log In");
        b1.setFont(new Font("Ralway", Font.BOLD, 28));
        b1.setForeground(Color.BLACK);
        b1.setBounds(500,500,200,40);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("BACK");
        b2.setFont(new Font("Ralway", Font.BOLD, 28));
        b2.setForeground(Color.BLACK);
        b2.setBounds(760,500,200,40);
        b2.addActionListener(this);
        add(b2);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(1550,1080,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,1550,1080);
        add(iiimage);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Admin_login();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource()==b1){
                login_id = textField1.getText();
                passWord = String.valueOf(passwordField1.getPassword());
                Conn c = new Conn();
                String q1 = "select * from admin_login where login_id = '"+login_id+"' and  passWord = '"+passWord+"'";
                ResultSet resultSet = c.statement.executeQuery(q1);
                if (resultSet.next()){
                    new Admin_Main(login_id,passWord);
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect User Id or Password");
                }
            }else if(e.getSource()==b2){
                new login();
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
}
