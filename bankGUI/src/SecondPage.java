import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondPage extends JFrame implements ActionListener {
    JLabel lblname;
    JButton btncreate, btndisplay, btnwithdraw, btnsearch, btncheck;
    JPanel panel1;
    public SecondPage(){
        setTitle("Everest Bank");
        setLayout(null);
        Container c =getContentPane();
        c.setBackground(Color.white);
        c.setLayout( new GridLayout(0,1));
        c.setSize(150,50);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font f=new Font(Font.SERIF,Font.BOLD,80);



        btncreate =new JButton("Create Account");
        btncreate.setSize(100,30);
        btncreate.setForeground(Color.white);
        btncreate.setFont(new Font("Serif", Font.PLAIN, 29));

        btndisplay =new JButton("Display Customer");
        btndisplay.setSize(100,30);
        btndisplay.setForeground(Color.white);
        btndisplay.setFont(new Font("Serif", Font.PLAIN, 29));


        btnsearch =new JButton("Search Customer");
        btnsearch.setSize(100,30);
        btnsearch.setForeground(Color.white);
        btnsearch.setFont(new Font("Serif", Font.PLAIN, 29));

        btncheck =new JButton("Check Balance");
        btncheck.setSize(100,30);
        btncheck.setForeground(Color.white);
        btncheck.setFont(new Font("Serif", Font.PLAIN, 29));


        btnwithdraw =new JButton("Withdraw or Deposite");
        btnwithdraw.setSize(100,30);
        btnwithdraw.setForeground(Color.white);
        btnwithdraw.setFont(new Font("Serif", Font.PLAIN, 29));



        c.add(btncreate);
        c.add(btndisplay);
        c.add(btnsearch);
        c.add(btncheck);
        c.add(btnwithdraw);



        btncreate.setBackground(Color.red);
        btndisplay.setBackground(Color.red);
        btnsearch.setBackground(Color.red);
        btncheck.setBackground(Color.red);
        btnwithdraw.setBackground(Color.red);
        btncreate.addActionListener(this);
        btndisplay.addActionListener(this);
        btnsearch.addActionListener(this);
        btncheck.addActionListener(this);
        btnwithdraw.addActionListener(this);

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new SecondPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if
        (e.getSource()==this.btncreate){
            new CustomerGUI();

        }
        else if(e.getSource()==btndisplay){
        new DisplayCustomer();
        }
        else if(e.getSource()==btncheck){
            new CheckBalance();
        }
        else if(e.getSource()==btnsearch){
            new SearchCustomer();
        }
        else if(e.getSource()==btnwithdraw){
            new Withdraw();
        }

    }
}