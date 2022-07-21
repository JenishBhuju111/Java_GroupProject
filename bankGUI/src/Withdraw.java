import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Withdraw extends JFrame implements ActionListener {
    JLabel laco, lamt;
    JTextField txtaco, txtwidral;
    Font serifFont = new Font("Serif", 2, 30);

    JButton bwitdral, bdeposite, close;

    public Withdraw() {
        setTitle("Everest Bank");
        setLayout(null);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        setLocationRelativeTo(null);
        c.setBackground(Color.red);
        laco = new JLabel("Account no: ");
        laco.setBounds(130, 10, 170, 25);
        laco.setFont(serifFont);
        laco.setForeground(Color.white);
        laco.setFont(new Font("Serif", Font.PLAIN, 21));

        txtaco = new JTextField(20);
        txtaco.setBounds(310, 10, 130, 25);

        lamt = new JLabel("Amount: ");
        lamt.setBounds(130, 45, 170, 25);
        lamt.setFont(serifFont);
        lamt.setForeground(Color.white);
        lamt.setFont(new Font("Serif", Font.PLAIN, 21));

        txtwidral = new JTextField();
        txtwidral.setBounds(310, 45, 130, 25);


        bwitdral = new JButton("Withdrawal ");
        bwitdral.setBounds(150, 80, 100, 25);

        bdeposite = new JButton("Deposite ");
        bdeposite.setBounds(150, 110, 100, 25);

        c.add(laco);
        c.add(txtaco);
        c.add(lamt);
        c.add(txtwidral);

        c.add(bwitdral);
        c.add(bdeposite);
        bwitdral.setBackground(Color.white);
        bdeposite.setBackground(Color.white);
        bwitdral.addActionListener(this);
        bdeposite.addActionListener(this);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Withdraw();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bwitdral) {
            draw();
        }
        else if(e.getSource() == bdeposite){
            draww();
        }

    }

    private void draw() {
        try {
            String acc = txtaco.getText();
            int amount = Integer.parseInt(txtwidral.getText());


            File file = new File("customer.txt");
            BufferedReader br = new BufferedReader(new FileReader("customer.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                StringTokenizer stn = new StringTokenizer(line);
                String Fname = stn.nextToken();
                String Lname = stn.nextToken();
                String age = stn.nextToken();
                String account = stn.nextToken();
                int balance = 0;


                if (acc.equals(account)) {
                    JFrame jFrame = new JFrame();

                    int withdraw = balance - amount;
                    JOptionPane.showMessageDialog(jFrame, "balance was " + balance + "/n" + "balance  " + withdraw);
                }

            }


        } catch (IOException a) {
            System.out.println(a.getLocalizedMessage());

        }
    }

    private void draww() {
        try {
            String acc = txtaco.getText();
            int amount = Integer.parseInt(txtwidral.getText());


            File file = new File("customer.txt");
            BufferedReader br = new BufferedReader(new FileReader("customer.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                StringTokenizer stn = new StringTokenizer(line);
                String Fname = stn.nextToken();
                String Lname = stn.nextToken();
                String age = stn.nextToken();
                String account = stn.nextToken();
                int balance = 0;


                if (acc.equals(account)) {
                    JFrame jFrame = new JFrame();

                    int deposite = balance + amount;
                    JOptionPane.showMessageDialog(jFrame, "balance was " + balance + "/n" + "balance  " + deposite);
                }

            }


        } catch (IOException a) {
            System.out.println(a.getLocalizedMessage());

        }
    }
}

