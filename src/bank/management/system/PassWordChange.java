package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PassWordChange extends JFrame implements ActionListener{
    String accountNo,passWord;
    JPasswordField passwordField,passwordField2;
    JTextField textField;
    JButton b1,b2;

    PassWordChange(String accountNo,String passWord){
        this.accountNo = accountNo;
        this.passWord = passWord;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label = new JLabel("Please Enter Your Old Password Below:");
        label.setBounds(150,120,700,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,22));
        l3.add(label);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,180,520,35);
        passwordField.setForeground(Color.BLACK);
        passwordField.setFont(new Font("System",Font.BOLD,22));
        l3.add(passwordField);

        JLabel label2 = new JLabel("Please Enter New Password Below:");
        label2.setBounds(150,300,700,35);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,22));
        l3.add(label2);

        textField = new JTextField();
        textField.setBounds(150,360,520,35);
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("System",Font.BOLD,22));
        l3.add(textField);
        
        JLabel label3 = new JLabel("Re-Enter New Password Below:");
        label3.setBounds(150,420,700,35);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System",Font.BOLD,22));
        l3.add(label3);

        passwordField2 = new JPasswordField();
        passwordField2.setBounds(150,480,520,35);
        passwordField2.setForeground(Color.BLACK);
        passwordField2.setFont(new Font("System",Font.BOLD,22));
        l3.add(passwordField2);

        b1 = new JButton("CHANGE PASSWORD");
        b1.setBounds(150,600,300,35);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("System",Font.BOLD,22));
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(500,600,170,35);
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("System",Font.BOLD,22));
        b2.addActionListener(this);
        l3.add(b2);
        
        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String new_passWord,confrom_passWord;
            new_passWord = textField.getText();
            confrom_passWord= String.valueOf(passwordField2.getPassword());
            if(!new_passWord.equals(confrom_passWord)){
                JOptionPane.showMessageDialog(null, "New Password Doesn't Match With Re-Enter Password");
                return;
            }

            if(e.getSource()==b1){
                if(textField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter new pin");
                    return;
                }else if(passwordField2.getPassword().toString().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new pin");
                    return;
                }

                Conn c = new Conn();
                String q1 = "update bank set pin ='"+new_passWord+"' where pin='"+passWord+"'";
                String q2 = "update login set pin ='"+new_passWord+"' where pin='"+passWord+"'";
                String q3 = "update page3 set pin ='"+new_passWord+"' where pin='"+passWord+"'";
                String q4 = "update balance set pin ='"+new_passWord+"' where pin='"+passWord+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);
                c.statement.executeUpdate(q4);

                JOptionPane.showMessageDialog(null, "Password changed sucessfully");
                new main_class(accountNo, passWord);
                setVisible(false);

            }else if(e.getSource()==b2){
                new main_class(accountNo, new_passWord);
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new PassWordChange("","");
    }
    
}
