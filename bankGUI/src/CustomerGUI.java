import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class CustomerGUI extends JFrame implements ActionListener {

    JTextField txtFName, txtLName, txtAge,txtAddress,txtAccount;
    JLabel lblFName, lblRName, lblAge,lblAddress,lblAccount;
    JButton addCus,  close;
    Container c;
    Font serifFont = new Font("Serif", 2,30);
    static FileWriter myWrite;
    Customer customer =new Customer();

    private ActionEvent e;


    private static void createFile(){
        try {
            File file = new File("customer.txt");
            if (!file.exists() && file.createNewFile()) {
                myWrite = new FileWriter("customer.txt", true);
                myWrite.write("FirstName LastName DOB AccountNo Address");
                myWrite.close();
            }
            else {
                System.out.println("file already exist");
            }
        } catch (IOException e) {
            System.out.println("Error Occurred.");
            e.printStackTrace();
        }
    }



    public CustomerGUI(){
        setTitle("Everest Bank");
        setSize(500,500);
        setLayout(null);
        setLocationRelativeTo(null);

        c =getContentPane();
        c.setBackground(Color.red);

        String[] columnNames = {"First Name", "Last Name", "DOB","Account NO", "Address"};

        lblFName = new JLabel("Enter first name");
        lblFName.setBounds(20, 20, 200, 30);
        lblFName.setFont(serifFont);
        lblFName.setForeground(Color.white);
        lblFName.setFont(new Font("Serif", Font.PLAIN, 21));
        txtFName = new JTextField();
        txtFName.setBounds(230, 20, 150, 30);

        lblRName = new JLabel("Enter last name");
        lblRName.setBounds(20, 60, 200, 30);
        lblRName.setFont(serifFont);
        lblRName.setForeground(Color.white);
        lblRName.setFont(new Font("Serif", Font.PLAIN, 21));
        txtLName = new JTextField();
        txtLName.setBounds(230, 60, 150, 30);

        lblAge = new JLabel("Enter Date of Birth");
        lblAge.setBounds(20, 100, 200, 30);
        lblAge.setFont(serifFont);
        lblAge.setForeground(Color.white);
        lblAge.setFont(new Font("Serif", Font.PLAIN, 21));
        txtAge = new JTextField();
        txtAge.setBounds(230, 100, 150, 30);

        lblAccount = new JLabel("Enter Account No");
        lblAccount.setBounds(20, 140, 200, 30);
        lblAccount.setFont(serifFont);
        lblAccount.setForeground(Color.white);
        lblAccount.setFont(new Font("Serif", Font.PLAIN, 21));
        txtAccount = new JTextField();
        txtAccount.setBounds(230, 140, 150, 30);


        lblAddress = new JLabel("Enter Address");
        lblAddress.setBounds(20, 180, 200, 30);
        lblAddress.setFont(serifFont);
        lblAddress.setForeground(Color.white);
        lblAddress.setFont(new Font("Serif", Font.PLAIN, 21));
        txtAddress = new JTextField();
        txtAddress.setBounds(230, 180, 150, 30);




        setVisible(true);


        addCus = new JButton("Add");
        addCus.setBounds(20,220,100,50);

        addCus.setBackground(Color.white);


        close= new JButton("Close");
        close.setBounds(130,220,100,50);

        close.setBackground(Color.white);

        c.add(lblFName);
        c.add(txtFName);
        c.add(lblRName);
        c.add(txtLName);
        c.add(lblAge);
        c.add(txtAge);
        c.add(lblAccount);
        c.add(txtAccount);
        c.add(lblAddress);
        c.add(txtAddress);
        c.add(addCus);
        c.add(close);


        addCus.addActionListener(this);
        close.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addCus) {

            customer.FName= txtFName.getText();
            customer.LName=txtLName.getText();
            customer.age=Integer.parseInt(txtAge.getText());
            customer.account=Integer.parseInt(txtAccount.getText());
            customer.address=txtAddress.getText();

            AddStudentThread add=new AddStudentThread(customer);
            add.start();
        }
        else{
            new SecondPage();
        }


    }


    public static void main(String[] args) {
        createFile();
        new CustomerGUI();
    }
}

class AddStudentThread extends Thread{
    Customer customer;
    private FileWriter myWrite;

    public  AddStudentThread (Customer student){
        this.customer=student;
    }
    @Override
    public void run(){
        try {
            myWrite = new FileWriter("customer.txt", true);
            JOptionPane.showMessageDialog(null, " Customer Added.... ");
            myWrite.write("\n" + customer.FName + " " + customer.LName + " " + Integer.toString(customer.age)+ " " +  Integer.toString(customer.account)+ " " + customer.address);
            myWrite.close();

        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());

        }

    }
}



