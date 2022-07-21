import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SearchCustomer extends JFrame implements ActionListener {
    JLabel lbl, lblAccount;
    JTextField txtAccount;
    JButton btnSearch,btnclose;
    Font serifFont = new Font("Serif", 2,30);
    Customer customer= new Customer();

    public SearchCustomer() {
        setTitle("Everest Bank");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500,500);
        setLayout(null);
        setLocationRelativeTo(null);

        Container c =getContentPane();
        c.setBackground(Color.red);


        lbl = new JLabel("Search Cutomer");
        lbl.setBounds(100, 10, 300, 60);
        lbl.setFont(serifFont);
        lbl.setForeground(Color.white);
        lbl.setFont(new Font("Serif", Font.PLAIN, 35));

        lblAccount = new JLabel("Account no: ");
        lblAccount.setBounds(80, 80, 100, 50);
        lblAccount.setFont(serifFont);
        lblAccount.setForeground(Color.white);
        lblAccount.setFont(new Font("Serif", Font.PLAIN, 19));

        txtAccount = new JTextField(20);
        txtAccount.setBounds(195, 95, 160, 25);
        txtAccount.setFont(serifFont);
        txtAccount.setForeground(Color.black);
        txtAccount.setFont(new Font("Serif", Font.PLAIN, 19));

        btnSearch = new JButton("Search");
        btnSearch.setBounds(150, 130, 125, 25);
        btnSearch.setForeground(Color.black);
        btnSearch.setFont(new Font("Serif", Font.PLAIN, 20));

        btnclose = new JButton("Close ");
        btnclose.setBounds(150, 165, 125, 25);
        btnclose.setForeground(Color.black);
        btnclose.setFont(new Font("Serif", Font.PLAIN, 20));
        c.add(lbl);
        c.add(lblAccount);
        c.add(txtAccount);
        c.add(btnSearch);
        c.add(btnclose);
        btnSearch.setBackground(Color.white);
        btnSearch.addActionListener(this);
        btnclose.setBackground(Color.white);
        btnclose.addActionListener(this);

        setVisible(true);
    }
    public static void main(String[] args) {
        new SearchCustomer();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== btnSearch){
            showAccount();
        }
        else{
            new SecondPage();
        }

    }
    private  void showAccount() {
        try {
            String acc =txtAccount.getText();


            File file = new File("customer.txt");
            BufferedReader br = new BufferedReader(new FileReader("customer.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                StringTokenizer stn = new StringTokenizer(line);
                String fname = stn.nextToken();
                String lname = stn.nextToken();
                String age = stn.nextToken();
                String account = stn.nextToken();
                String address=stn.nextToken();
                String balance = stn.nextToken();


                if (account.equals(account)) {
                    JFrame jFrame = new JFrame();
                    JOptionPane.showMessageDialog(jFrame, "First name:" + fname+"\n"+
                            "last name:" + lname+"\n"+
                            "age:"+age+"\n"+"address: ");
                }

            }
            br.close();

        } catch (IOException a) {
            System.out.println(a.getLocalizedMessage());

        }
    }

}