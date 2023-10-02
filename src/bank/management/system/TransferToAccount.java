package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.ResultSet;

public class TransferToAccount extends JFrame implements ActionListener{
    String accountNo,passWord,balance,reciverAccount,ammount,reciverName,tempName,reciverTotalBalance,reciverPassword;
    JTextField textField,textField2,textField3;
    JButton b1,b2;
    TransferToAccount(String accountNo,String passWord){
        super("Transfer Money Account To Account");

        this.accountNo = accountNo;
        this.passWord = passWord;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label = new JLabel("-: Transfer Money Account To Account :-");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 30));
        label.setBounds(400,100,590,60);
        l3.add(label);

        JLabel label1 = new JLabel("Enter Receiver Account No.:");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 20));
        label1.setBounds(250,220,500,60);
        l3.add(label1);

        textField = new JTextField();
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("System", Font.BOLD, 20));
        textField.setBounds(650,236,500,30);
        l3.add(textField);

        JLabel label2 = new JLabel("Receiver Full Name As in Bank Database:");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 20));
        label2.setBounds(250,320,500,60);
        l3.add(label2);

        textField2 = new JTextField();
        textField2.setForeground(Color.BLACK);
        textField2.setFont(new Font("System", Font.BOLD, 20));
        textField2.setBounds(650,336,500,30);
        l3.add(textField2);

        JLabel label3 = new JLabel("Enter Ammount In Number (Ex: 1000):");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", Font.BOLD, 20));
        label3.setBounds(250,420,500,60);
        l3.add(label3);

        textField3 = new JTextField();
        textField3.setForeground(Color.BLACK);
        textField3.setFont(new Font("System", Font.BOLD, 20));
        textField3.setBounds(650,436,500,30);
        l3.add(textField3);

        b1 = new JButton("Transfer Money");
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("System", Font.BOLD, 20));
        b1.setBounds(250,550,450,50);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("CANCEL TRANSATION");
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("System", Font.BOLD, 20));
        b2.setBounds(800,550,350,50);
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
            if(e.getSource()==b1){
                reciverAccount = textField.getText();
                reciverName = textField2.getText();
                ammount = textField3.getText();
                Date date = new Date();
                if(reciverAccount.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter Account No. of Reciver");
                    return;
                }else if(reciverName.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter Name of the Reciver");
                    return;
                }else if(ammount.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter Ammount");
                    return;
                }

                Conn c = new Conn();
                ResultSet resultSet1 = c.statement.executeQuery("Select * from balance where account_number = '"+accountNo+"'");
                while(resultSet1.next()){
                    balance = resultSet1.getString("totalBalance");
                }

                if(Integer.parseInt(balance)<Integer.parseInt(ammount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance.");
                    return;
                }

                ResultSet resultSet2 = c.statement.executeQuery("Select * from balance where account_number = '"+reciverAccount+"'");
                while(resultSet2.next()){
                    tempName = resultSet2.getString("name");
                    reciverTotalBalance = resultSet2.getString("totalBalance");
                    reciverPassword = resultSet2.getString("pin");
                }
                if(tempName.equals(reciverName)){
                    c.statement.executeUpdate("insert into bank values('"+accountNo+"','"+passWord+"', '"+date+"','Transfer to "+reciverAccount+"', '"+ammount+"')");
                    c.statement.executeUpdate("insert into bank values('"+reciverAccount+"','"+reciverPassword+"', '"+date+"','Recive from "+accountNo+"', '"+ammount+"')");

                    int tBalance=0;
                    // if(balance!=null)
                    tBalance = Integer.parseInt(balance)-Integer.parseInt(ammount) ;
                    String q1 = "update balance set totalBalance ='"+tBalance+"' where account_number = '"+accountNo+"'";
                    c.statement.executeUpdate(q1);

                    //Receiver Account Update
                    tBalance=0;
                    // if(!(reciverTotalBalance==null))
                    tBalance = Integer.parseInt(reciverTotalBalance)+Integer.parseInt(ammount);
                    String q2 = "update balance set totalBalance ='"+tBalance+"' where account_number = '"+reciverAccount+"'";
                    c.statement.executeUpdate(q2);

                    JOptionPane.showMessageDialog(null,"Rs. "+ammount+"/- Transfered Successfully to Account No. "+reciverAccount);
                    
                    new main_class(accountNo,passWord);
                    setVisible(false);
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Account No. or Name Doesn't Match");
                    return;
                }

                
            }else if(e.getSource()==b2){
            new main_class(accountNo, passWord);
            setVisible(false);
        }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
    //     if(e.getSource()==b1){
    //         try {
    //             reciverAccount = textField.getText();
    //             reciverName = textField2.getText();
    //             ammount = textField3.getText();
    //             Date date = new Date();

    //             Conn c = new Conn();
    //             ResultSet resultSet1 = c.statement.executeQuery("Select * from balance where account_number = '"+accountNo+"'");
    //             ResultSet resultSet2 = c.statement.executeQuery("Select * from balance where account_number = '"+reciverAccount+"'");

    //             if(!resultSet2.getString("name").equals(reciverName)){
    //                 JOptionPane.showMessageDialog(null,"Account No. or Name Doesn't Match");
    //                 return;
    //             }
    //             while(resultSet1.next()){
    //                 balance = resultSet1.getString("totalBalance");
    //             }
    //             if(Integer.parseInt(balance)<Integer.parseInt(ammount)){
    //                 JOptionPane.showConfirmDialog(null,"Insufficient Balance.");
    //                 return;
    //             }
    //             c.statement.executeUpdate("insert into bank values('"+accountNo+"','"+passWord+"', '"+date+"','Transfer to "+reciverAccount+"', '"+ammount+"')");
    //             int tBalance=0;
    //             tBalance = Integer.parseInt(balance)-Integer.parseInt(ammount) ;
    //             String q1 = "update balance set totalBalance ='"+tBalance+"' where account_number = '"+accountNo+"'";
    //             c.statement.executeUpdate(q1);

    //             //Receiver Account Update
    //             c.statement.executeUpdate("insert into bank values('"+reciverAccount+"','"+passWord+"', '"+date+"','Recive from "+accountNo+"', '"+ammount+"')");
    //             while(resultSet2.next()){
    //                 balance = resultSet2.getString("totalBalance");
    //             }
    //             tBalance=0;
    //             tBalance = Integer.parseInt(balance)+Integer.parseInt(ammount);
    //             String q2 = "update balance set totalBalance ='"+tBalance+"' where account_number = '"+reciverAccount+"'";
    //             c.statement.executeUpdate(q2);

    //             JOptionPane.showMessageDialog(null,"Rs. "+ammount+"Transfered Successfully to Account No. "+reciverAccount);
                
    //             new main_class(accountNo,passWord);
    //             setVisible(false);

    //         } catch (Exception E) {
    //             E.printStackTrace();
    //         }
            
    //     }else if(e.getSource()==b2){
    //         new main_class(accountNo, passWord);
    //         setVisible(false);
    //     }
    // }

    public static void main(String[] args) {
        new TransferToAccount("","");
    }
    
}
