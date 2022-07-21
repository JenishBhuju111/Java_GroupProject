import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CheckBalance extends JFrame implements ActionListener {
    JLabel lbl, lblAccount;
    JTextField txtAccount;
    JButton btnCheck,btnclose;
    Font serifFont = new Font("Serif", 2,30);
    private DefaultTableModel model;


    static FileWriter CustomerWrite;

    String[] columnNames = {"First Name", "Last Name", "DOB","Account NO", "Address"};
    String data[][];

    Customer customer= new Customer();


    public CheckBalance() {
        setTitle("Everest Bank");
        setLayout(null);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setBackground(Color.red);
        lbl = new JLabel("Check Balance");
        lbl.setBounds(100, 10, 150, 50);
        lbl.setFont(serifFont);
        lbl.setForeground(Color.white);
        lbl.setFont(new Font("Serif", Font.PLAIN, 25));


        lblAccount = new JLabel("Account no: ");
        lblAccount.setBounds(80, 60, 100, 50);
        lblAccount.setFont(serifFont);
        lblAccount.setForeground(Color.white);
        lblAccount.setFont(new Font("Serif", Font.PLAIN, 19));

        txtAccount = new JTextField();
        txtAccount.setBounds(220, 70, 160, 30);
        txtAccount.setFont(serifFont);
        txtAccount.setForeground(Color.black);
        txtAccount.setFont(new Font("Serif", Font.PLAIN, 19));

        btnCheck = new JButton("CHECK");
        btnCheck.setBounds(190, 140, 125, 40);
        btnCheck.setForeground(Color.black);
        btnCheck.setFont(new Font("Serif", Font.PLAIN, 20));

        btnclose = new JButton("Close");
        btnclose.setBounds(190, 190, 125, 40);
        btnclose.setForeground(Color.black);
        btnclose.setFont(new Font("Serif", Font.PLAIN, 20));

        c.add(lbl);
        c.add(lblAccount);
        c.add(txtAccount);
        c.add(btnCheck);
        c.add(btnclose);
        btnCheck.setBackground(Color.white);
        btnCheck.addActionListener(this);
        btnclose.setBackground(Color.white);
        btnclose.addActionListener(this);

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new CheckBalance();

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()== btnCheck){
            check();

        }
        else{
            new SecondPage();
        }
    }

    private  void check() {
        try {
            String acc =txtAccount.getText();


            File file = new File("customer.txt");
            BufferedReader br = new BufferedReader(new FileReader("customer.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                StringTokenizer stn = new StringTokenizer(line);
                String Fname = stn.nextToken();
                String Lname = stn.nextToken();
                String age = stn.nextToken();
                String account = stn.nextToken();
                String balance = stn.nextToken();


                if (acc.equals(account)) {
                    JFrame jFrame = new JFrame();
                    JOptionPane.showMessageDialog(jFrame, "balance is " + balance);
                }

            }
            br.close();

        } catch (IOException a) {
            System.out.println(a.getLocalizedMessage());

        }
    }
}