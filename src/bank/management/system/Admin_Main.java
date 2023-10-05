package bank.management.system;

import javax.swing.JFrame;

public class Admin_Main extends JFrame{
    String id,passWord;
    Admin_Main(String id,String passWord){
        super("Admin Main Page");
        this.id = id;
        this.passWord = passWord;

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Admin_Main("","");
    }
}
