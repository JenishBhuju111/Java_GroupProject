import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DisplayCustomer extends JFrame implements ActionListener {
    JTable table;
    JLabel lbl;
    JButton  close;
    Container c;

    private DefaultTableModel model;


    static FileWriter CustomerWriter;
    String[] columnNames = {"First Name", "Last Name", "DOB", "Account NO", "Address"};
    String data[][];
    Font serifFont = new Font("Serif", 2,30);
JButton view;
    public DisplayCustomer() {
        setTitle("Everest Bank");
        setSize(500, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setBackground(Color.red);

        lbl = new JLabel("Customer Details");
        lbl.setBounds(100, 10, 300, 60);
        lbl.setFont(serifFont);
        lbl.setForeground(Color.white);
        lbl.setFont(new Font("Serif", Font.PLAIN, 35));

        view = new JButton("view ");
        view.setBounds(150, 72, 100, 25);

        model = new DefaultTableModel(columnNames, 0);
        model.addRow(columnNames);
        table = new JTable(model);
        table.setBounds(40, 100, 420, 300);


        close= new JButton("Close");
        close.setBounds(400,415,80,30);
        close.setBackground(Color.white);

        c.add(lbl);
        c.add(view);
        c.add(table);
        c.add(close);
        view.setBackground(Color.white);
        view.addActionListener(this);
        close.addActionListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==view){
    viewCustomer();
}
        else if (e.getSource() == close) {

            new SecondPage();
        }
    }

    public static void main(String[] args) {
        new DisplayCustomer();
    }

    public void viewCustomer() {
        try {
            File file = new File("customer.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNext()) {
                String line = reader.nextLine();
                model.addRow(line.split(" "));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}
