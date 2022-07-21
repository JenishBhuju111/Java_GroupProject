import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddCustomer {
    static FileWriter myWrite;
    static Scanner sc = new Scanner(System.in);
    private static void createFile(){
        try {
            File file = new File("customer.txt");
            if (!file.exists() && file.createNewFile()) {
                myWrite = new FileWriter("customer.txt", true);
                myWrite.write("FirstName LastName DOB AccountNo Address");
                myWrite.close();
            }
        } catch (IOException e) {
            System.out.println("Error Occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Customer customer = new Customer();



        createFile();


        char ch;
        do {
            System.out.println("Customer Detail");
            System.out.println("1.  Add customer.");
            System.out.println("2.  View customer.");
            System.out.println("3.  Exit");
            System.out.println("4.  Enter your choice: ");
            int choice = sc.nextInt();




            switch (choice) {
                case 1:
                    addCustomer(customer);
                    System.out.println("Customer Added.");
                    break;
                case 2:
                    Display();
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Incorrect input.");
                    break;
            }
            System.out.println("Do you want to continue(y/n) : ");
            ch = sc.next().charAt(0);
        } while(ch == 'y' || ch == 'Y');
    }


    private static void addCustomer(Customer customer) {
        try {
            myWrite = new FileWriter("customer.txt", true);
            System.out.println("Enter first name ");
            customer.FName=sc.next();
            System.out.println("Enter last name ");
            customer.LName=sc.next();
            System.out.println("Enter DOB");
            customer.age=sc.nextInt();
            System.out.println("Enter Account no");
            customer.account=sc.nextInt();
            System.out.println("Enter address");
            customer.address=sc.next();
            myWrite.write("\n" + customer.FName + " " + customer.LName + " " + Integer.toString(customer.age)+ " " + Integer.toString(customer.account)+ " " + customer.address);
            myWrite.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());

        }
    }

    private  static void Display(){
        try{
            File file =new File("customer.txt");
            Scanner reader =new Scanner(file);

            reader.nextLine();
            while(reader.hasNextLine()){
                System.out.println(reader.nextLine());
            }
        } catch(IOException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}

