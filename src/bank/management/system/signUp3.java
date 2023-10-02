package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.sql.ResultSet;
import java.util.Random;

public class signUp3 extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton s,c;
    String formno,name;
    public signUp3(String formno,String name){
        super("APPLICATION FORM");

        this.formno = formno;
        this.name = name;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,5,100,100);
        add(image);

        JLabel l1 = new JLabel("Page 3 :-");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(580, 40, 400, 40);
        add(l1);

        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 25));
        l2.setBounds(580, 70, 400, 40);
        add(l2);

        JLabel l3 = new JLabel("Account Type* :");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        l3.setBounds(400, 140, 200, 30);
        add(l3);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 18));
        r1.setBounds(400, 180, 200, 30);
        r1.setBackground(new Color(215, 252, 252));
        add(r1);
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 18));
        r2.setBounds(650, 180, 300, 30);
        r2.setBackground(new Color(215, 252, 252));
        add(r2);
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 18));
        r3.setBackground(new Color(215, 252, 252));
        r3.setBounds(400, 220, 200, 30);
        add(r3);
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 18));
        r4.setBackground(new Color(215, 252, 252));
        r4.setBounds(650, 220, 300, 30);
        add(r4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        JLabel l4 = new JLabel("Account Number:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        l4.setBounds(400, 300, 200, 30);
        add(l4);

        JLabel l5 = new JLabel("(Your 16-digit Account Number:)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        l5.setBounds(400, 330, 200, 20);
        add(l5);

        JLabel l6 = new JLabel("XXXX-XXXX-XXXX-XXXX");
        l6.setFont(new Font("Raleway", Font.BOLD, 14));
        l6.setBounds(630, 300, 250, 30);
        add(l6);

        JLabel l7 = new JLabel("(It would appear on atm card/cheque Book and Statements)");
        l7.setFont(new Font("Raleway", Font.BOLD, 14));
        l7.setBounds(630, 330, 500, 20);
        add(l7);

        JLabel l8 = new JLabel("PASSWORD:");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        l8.setBounds(400, 370, 200, 30);
        add(l8);

        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
        l9.setBounds(630, 370, 200, 30);
        add(l9);

        JLabel l10 = new JLabel("(4-digit Password)");
        l10.setFont(new Font("Raleway", Font.BOLD, 14));
        l10.setBounds(400, 400, 200, 20);
        add(l10);

        JLabel l11 = new JLabel("Services Required:");
        l11.setFont(new Font("Raleway", Font.BOLD, 20));
        l11.setBounds(400, 450, 200, 20);
        add(l11);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(new Color(215, 252, 252));
        c1.setFont(new Font("Raleway", Font.BOLD, 18));
        c1.setBounds(400, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(215, 252, 252));
        c2.setFont(new Font("Raleway", Font.BOLD, 18));
        c2.setBounds(650, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(215, 252, 252));
        c3.setFont(new Font("Raleway", Font.BOLD, 18));
        c3.setBounds(400, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email Alerts");
        c4.setBackground(new Color(215, 252, 252));
        c4.setFont(new Font("Raleway", Font.BOLD, 18));
        c4.setBounds(650, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(new Color(215, 252, 252));
        c5.setFont(new Font("Raleway", Font.BOLD, 18));
        c5.setBounds(400, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(new Color(215, 252, 252));
        c6.setFont(new Font("Raleway", Font.BOLD, 18));
        c6.setBounds(650, 600, 200, 30);
        add(c6);

        JCheckBox c7 = new JCheckBox("I here by decleares that the above entered details correct to the best of my knowledge.",true);
        c7.setBackground(new Color(215, 252, 252));
        c7.setFont(new Font("Raleway", Font.BOLD, 18));
        c7.setBounds(400, 650, 900, 30);
        add(c7);

        JLabel l12 = new JLabel("Form No : ");
        l12.setFont(new Font("Raleway", Font.BOLD,18));
        l12.setBounds(1300,10,100,30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD,18));
        l13.setBounds(1365,10,60,30);
        add(l13);

        s = new JButton("submit");
        s.setFont(new Font("Raleway", Font.BOLD,20));
        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        s.setBounds(720,720,200,40);
        s.addActionListener(this);
        add(s);

        c = new JButton("Cancel");
        c.setFont(new Font("Raleway", Font.BOLD,20));
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);
        c.setBounds(400,720,200,40);
        c.addActionListener(this);
        add(c);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        getContentPane().setBackground(new Color(215, 252, 252));
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String atype = null;
        if (r1.isSelected()){
            atype = "Saving Account";
        } else if (r2.isSelected()) {
            atype ="Fixed Deposit Account";
        }else if (r3.isSelected()){
            atype ="Current Account";
        }else if (r4.isSelected()){
            atype = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
        String accountNo = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L)+ 1000L;
        String pin = "" + Math.abs(first3);

        String fac = "";
        if(c1.isSelected()){
            fac = fac+"ATM CARD ";
        } else if (c2.isSelected()) {
            fac = fac+"Internet Banking";
        } else if (c3.isSelected()) {
            fac = fac+"Mobile Banking";
        } else if (c4.isSelected()) {
            fac = fac+"EMAIL Alerts";
        } else if (c5.isSelected()) {
            fac=fac+"Cheque Book";
        } else if (c6.isSelected()) {
            fac=fac+"E-Statement";
        }

        try {
            if (e.getSource()==s){
                if (atype==null){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                    return;
                }else {
                    Conn Con3 = new Conn();
                    String q1 = "insert into page3 values('"+formno+"', '"+atype+"','"+accountNo+"','"+pin+"','"+fac+"')";
                    String q2 = "insert into login values('"+formno+"','"+name+"','"+accountNo+"','"+pin+"')";
                    Con3.statement.executeUpdate(q1);
                    Con3.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Account Number : "+accountNo+"\n PassWord : "+pin );
                    int balance = 0;
                    Con3.statement.executeUpdate("insert into balance values('"+accountNo+"','"+name+"','"+pin+"','"+balance+"')");

                    new Deposit(accountNo,pin,name);
                    setVisible(false);
                }
            } else if (e.getSource()==c) {
                new login();
            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new signUp3("","");
    }
    
}
