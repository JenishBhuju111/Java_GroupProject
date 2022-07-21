import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Index extends JFrame implements ActionListener {

    JLabel lblEverest,l1;
    JButton btnContinue;
    JButton btnClose;
    Font serifFont = new Font("Serif", 2,30);
    Container c=getContentPane();
    public Index(){
       setTitle("Everest Bank");
       setLayout(null);
       c.setBackground(Color.red);
        setSize(500,500);

        lblEverest = new JLabel("Welcome to Everest Bank");
        lblEverest.setBounds(100,100,350,50);
        lblEverest.setFont(serifFont);
        lblEverest.setForeground(Color.white);
        lblEverest.setFont(new Font("Serif", Font.PLAIN, 33));

        btnContinue = new JButton("Continue");
        btnContinue.setBounds(120,200,250,50);
        btnContinue.setFont(serifFont);
        btnContinue.setBackground(Color.white);

        btnClose = new JButton("Exit");
        btnClose.setBounds(120,280,250,50);
        btnClose.setFont(serifFont);
        btnClose.setBackground(Color.white);


        c.add(lblEverest);
        c.add(btnContinue);
        c.add(btnClose);
        setSize(500,500);
        btnContinue.addActionListener(this);
        btnClose.addActionListener(this);
        c.setFont(this.serifFont);


        setVisible(true);
       setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if
        (e.getSource()==this.btnContinue){
            new SecondPage();

        }else if (e.getSource()==btnClose){
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new Index();
    }
}
