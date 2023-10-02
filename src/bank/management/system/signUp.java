package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import com.toedter.calendar.JDateChooser;



public class signUp extends JFrame implements ActionListener{

    JTextField textName,textFname,textEmail,textAdd,textCity,textPin,textState;
    JDateChooser dateChooser;
    JRadioButton r1,r2,r3,ms1,ms2,ms3;
    JButton next,back;

    Random ran = new Random();
    long first4 = (ran.nextLong()%9000L)+1000L;
    String first = " " + Math.abs(first4);

    signUp(){
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(325,10,100,100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO."+first);
        label1.setBounds(460, 20, 600, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(700, 70, 600, 30);
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label2);

        JLabel label3 = new JLabel("personal Details");
        label3.setBounds(650, 90, 600, 30);
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label3);

        JLabel label4 = new JLabel("Name* :");
        label4.setBounds(400, 190, 100, 30);
        label4.setFont(new Font("Raleway", Font.BOLD, 20));
        add(label4);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(600, 190, 400, 30);
        add(textName);

        JLabel label5 = new JLabel("Father's Name :");
        label5.setBounds(400, 240, 200, 30);
        label5.setFont(new Font("Raleway", Font.BOLD, 20));
        add(label5);

        textFname = new JTextField();
        textFname.setFont(new Font("Raleway", Font.BOLD, 14));
        textFname.setBounds(600, 240, 400, 30);
        add(textFname);

        JLabel label6 = new JLabel("Date of Birth :");
        label6.setBounds(400, 340, 200, 30);
        label6.setFont(new Font("Raleway", Font.BOLD, 20));
        add(label6);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(600, 340, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel label7 = new JLabel("Gender :");
        label7.setBounds(400, 290, 200, 30);
        label7.setFont(new Font("Raleway", Font.BOLD, 20));
        add(label7);

        r1 = new JRadioButton("Male");
        r1.setBounds(600, 290, 60, 30);
        r1.setBackground(new Color(222, 255, 228));
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(750, 290, 90, 30);
        r2.setBackground(new Color(222, 255, 228));
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(r2);

        r3 = new JRadioButton("Other");
        r3.setBounds(930, 290, 70, 30);
        r3.setBackground(new Color(222, 255, 228));
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        add(r3);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel label8 = new JLabel("Email address* :");
        label8.setBounds(400, 390, 200, 30);
        label8.setFont(new Font("Raleway", Font.BOLD, 20));
        add(label8);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway", Font.BOLD, 14));
        textEmail.setBounds(600, 390, 400, 30);
        add(textEmail);

        JLabel label9 = new JLabel("Marital Status :");
        label9.setBounds(400, 440, 200, 30);
        label9.setFont(new Font("Raleway", Font.BOLD, 20));
        add(label9);

        ms1 = new JRadioButton("Married");
        ms1.setBounds(600, 440, 80, 30);
        ms1.setBackground(new Color(222, 255, 228));
        ms1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(ms1);

        ms2 = new JRadioButton("UnMarried");
        ms2.setBounds(750, 440, 100, 30);
        ms2.setBackground(new Color(222, 255, 228));
        ms2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(ms2);

        ms3 = new JRadioButton("Other");
        ms3.setBounds(930, 440, 70, 30);
        ms3.setBackground(new Color(222, 255, 228));
        ms3.setFont(new Font("Raleway", Font.BOLD, 14));
        add(ms3);
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(ms1);
        maritalGroup.add(ms2);
        maritalGroup.add(ms3);

        JLabel label10 = new JLabel("Address :");
        label10.setBounds(400, 490, 200, 30);
        label10.setFont(new Font("Raleway", Font.BOLD, 20));
        add(label10);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway", Font.BOLD, 14));
        textAdd.setBounds(600, 490, 400, 30);
        add(textAdd);

        JLabel label11 = new JLabel("Vill/City :");
        label11.setBounds(400, 540, 200, 30);
        label11.setFont(new Font("Raleway", Font.BOLD, 20));
        add(label11);

        textCity = new JTextField();
        textCity.setFont(new Font("Raleway", Font.BOLD, 14));
        textCity.setBounds(600, 540, 400, 30);
        add(textCity);

        JLabel label12 = new JLabel("Pin Code :");
        label12.setBounds(400, 590, 200, 30);
        label12.setFont(new Font("Raleway", Font.BOLD, 20));
        add(label12);

        textPin = new JTextField();
        textPin.setFont(new Font("Raleway", Font.BOLD, 14));
        textPin.setBounds(600, 590, 400, 30);
        add(textPin);

        JLabel label13 = new JLabel("State :");
        label13.setBounds(400, 640, 200, 30);
        label13.setFont(new Font("Raleway", Font.BOLD, 20));
        add(label13);

        textState = new JTextField();
        textState.setFont(new Font("Raleway", Font.BOLD, 14));
        textState.setBounds(600, 640, 400, 30);
        add(textState);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 18));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(800, 710, 200, 40);
        next.addActionListener(this);
        add(next);

        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 18));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(400, 710, 200, 40);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String formNo = first;
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }else if(r2.isSelected()){
            gender = "Female";
        }else if(r3.isSelected()){
            gender = "Other";
        }
        String email = textEmail.getText();
        String marital = null;
        if(ms1.isSelected()){
            marital = "Married";
        }else if(ms2.isSelected()){
            marital = "UnMarried";
        }else if(ms3.isSelected()){
            marital = "Other";
        }
        String address = textAdd.getText();
        String city = textCity.getText();
        String pin = textPin.getText();
        String state = textState.getText();

        try {
            if(e.getSource()==next){
                if( textName.getText().equals("") ||
                // textFname.getText().equals("") ||
                // gender.equals("") ||
                // ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().equals("") ||
                textEmail.getText().equals("")
                // marital.equals(null) ||
                // textAdd.getText().equals("") ||
                // textCity.getText().equals("") ||
                // textPin.getText().equals("") ||
                // textState.getText().equals("")
                ){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }else{
                    Conn con1 = new Conn();
                    String q = "insert into nur values('"+formNo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                    con1.statement.executeUpdate(q);
                    new signUp2(first,textName.getText());
                    setVisible(false);
                }
            }else if(e.getSource()==back){
                new login();
                setVisible(false);
            }
            
        } catch (Exception E) {
            E.printStackTrace();
        }

    }
    
    public static void main(String[] args) {
        new signUp();
    }
}