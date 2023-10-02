package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signUp2 extends JFrame implements ActionListener {
    JComboBox<String> comboBox,comboBox2,comboBox3,comboBox4,comboBox5;
    JTextField textPan,textAadhar;
    JRadioButton r1,r2, e1,e2;
    JButton next,back;
    String formno,name;
    signUp2(String formno,String name){
        super("APPLICATION FORM");

        this.formno = formno;
        this.name = name;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,5,100,100);
        add(image);

        JLabel l1 = new JLabel("Page 2 :-");
        l1.setFont(new Font("Raleway", Font.BOLD,22));
        l1.setBounds(580,30,600,40);
        add(l1);

        JLabel l2 = new JLabel("Additonal Details");
        l2.setFont(new Font("Raleway", Font.BOLD,22));
        l2.setBounds(580,60,600,40);
        add(l2);

        JLabel l3 = new JLabel("Religion :");
        l3.setFont(new Font("Raleway", Font.BOLD,18));
        l3.setBounds(400,120,100,30);
        add(l3);

        String religion[] = {"Hindu","Muslim","Sikh", "Christian", "Other"};
        comboBox = new JComboBox<>(religion);
        comboBox.setBackground(new Color(252,208,76));
        comboBox.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox.setBounds(650,120,320,30);
        add(comboBox);

        JLabel l4 = new JLabel("Category : ");
        l4.setFont(new Font("Raleway", Font.BOLD,18));
        l4.setBounds(400,170,100,30);
        add(l4);

        String Category [] = {"General","OBC","SC", "ST", "Other"};
        comboBox2 = new JComboBox<>(Category);
        comboBox2.setBackground(new Color(252,208,76));
        comboBox2.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox2.setBounds(650,170,320,30);
        add(comboBox2);

        JLabel l5 = new JLabel("Income : ");
        l5.setFont(new Font("Raleway", Font.BOLD,18));
        l5.setBounds(400,220,100,30);
        add(l5);

        String income [] = {"Null","<1,50,000","<2,50,000", "5,00,000", "Uptp 10,00,000","Above 10,00,000"};
        comboBox3 = new JComboBox<>(income);
        comboBox3.setBackground(new Color(252,208,76));
        comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox3.setBounds(650,220,320,30);
        add(comboBox3);

        JLabel l6 = new JLabel("Educational : ");
        l6.setFont(new Font("Raleway", Font.BOLD,18));
        l6.setBounds(400,270,150,30);
        add(l6);

        String educational [] = {"Non-Graduate","Graduate","Post-Graduate", "Doctrate", "Others"};
        comboBox4 = new JComboBox<>(educational);
        comboBox4.setBackground(new Color(252,208,76));
        comboBox4.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox4.setBounds(650,270,320,30);
        add(comboBox4);


        JLabel l7 = new JLabel("Occupation : ");
        l7.setFont(new Font("Raleway", Font.BOLD,18));
        l7.setBounds(400,340,150,30);
        add(l7);

        String Occupation [] = {"Salaried","Self-Employed","Business", "Student", "Retired", "Other"};
        comboBox5 = new JComboBox<>(Occupation);
        comboBox5.setBackground(new Color(252,208,76));
        comboBox5.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox5.setBounds(650,340,320,30);
        add(comboBox5);

        JLabel l8 = new JLabel("PAN Number* : ");
        l8.setFont(new Font("Raleway", Font.BOLD,18));
        l8.setBounds(400,390,150,30);
        add(l8);

        textPan = new JTextField();
        textPan.setFont(new Font("Raleway", Font.BOLD,18));
        textPan.setBounds(650,390,320,30);
        add(textPan);

        JLabel l9 = new JLabel("Aadhar Number* : ");
        l9.setFont(new Font("Raleway", Font.BOLD,18));
        l9.setBounds(400,440,180,30);
        add(l9);

        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Raleway", Font.BOLD,18));
        textAadhar.setBounds(650,440,320,30);
        add(textAadhar);


        JLabel l10 = new JLabel("Senior Citizen : ");
        l10.setFont(new Font("Raleway", Font.BOLD,18));
        l10.setBounds(400,490,180,30);
        add(l10);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD,14));
        r1.setBackground(new Color(252,208,76));
        r1.setBounds(650,490,100,30);
        add(r1);
        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD,14));
        r2.setBackground(new Color(252,208,76));
        r2.setBounds(860,490,100,30);
        add(r2);

        JLabel l11 = new JLabel("Existing Account : ");
        l11.setFont(new Font("Raleway", Font.BOLD,18));
        l11.setBounds(400,540,180,30);
        add(l11);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway", Font.BOLD,14));
        e1.setBackground(new Color(252,208,76));
        e1.setBounds(650,540,100,30);
        add(e1);
        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway", Font.BOLD,14));
        e2.setBackground(new Color(252,208,76));
        e2.setBounds(860,540,100,30);
        add(e2);

        JLabel l12 = new JLabel("Form No : ");
        l12.setFont(new Font("Raleway", Font.BOLD,20));
        l12.setBounds(1300,10,100,30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD,20));
        l13.setBounds(1365,10,60,30);
        add(l13);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(770,640,200,40);
        next.addActionListener(this);
        add(next);

        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 18));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(400, 640, 200, 40);
        back.addActionListener(this);
        add(back);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        getContentPane().setBackground(new Color(252, 208, 76));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) comboBox.getSelectedItem();
        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();

        String pan = textPan.getText();
        String addhar = textAadhar.getText();

        String scitizen = " ";
        if ((r1.isSelected())){
            scitizen = "Yes";
        } else if (r2.isSelected()) {
            scitizen ="No";
        }
        String eAccount = " ";
        if ((r1.isSelected())){
            eAccount = "Yes";
        } else if (r2.isSelected()) {
            eAccount ="No";
        }

        try{
            if(e.getSource()==next){
                if (textPan.getText().equals("") || textAadhar.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }else {
                    Conn Con2 = new Conn();
                    String q = "insert into page2 values('"+formno+"', '"+rel+"', '"+cate+"','"+inc+"','"+edu+"','"+occ+"','"+pan+"','"+addhar+"','"+scitizen+"','"+eAccount+"')";
                    Con2.statement.executeUpdate(q);
                    new signUp3(formno,name);
                    setVisible(false);
                }   
            }else if(e.getSource()==back){
                new signUp();
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new signUp2("","");
    }
}