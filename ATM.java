import java.util.HashMap;
import java.util.Scanner;

//class representing the ATM Machine
public class ATM {
    public static void main(String args[]){
        // created an instance of ATM operations class to start the ATM
        ATMoperations obj = new ATMoperations();
    }
    
}

// class representing the user's BankAccount
class BankAccount{
    float Balance;// account balance
   }

//class representing the ATM operations
class ATMoperations{
    float Balance;
     Scanner sc = new Scanner(System.in);
     HashMap<Integer,BankAccount> map = new HashMap<>();// Hashmap to store user's account using PIN as a key
     // constructor - starting point of ATM operations
    ATMoperations(){
        System.out.println("Welcome to our ATM ####################################");
        performoperations();
    }


// method to perform ATM operations
    public void performoperations(){
        System.out.print("Enter your PIN: ");
        int pin = sc.nextInt();
        if (map.containsKey(pin)== true){ // check if the user with the entered PIN already exists or not in Hashmap
            BankAccount obj = map.get(pin);
            displaymenu(obj);
        }
        else {
            System.out.println("Please create your account first.\nEnter your PIN: ");
            int newPin = sc.nextInt();
            BankAccount obj = new BankAccount();
            map.put(newPin,obj);
            displaymenu(obj);// Display the main menu for the new account
        }
    }


    // Method to display the main menu
    public void displaymenu(BankAccount obj){
        System.out.println("\nSelect any options below: ");
        System.out.println("\n1. Check A/C balance? ");
        System.out.println("2. Withdraw ");
        System.out.println("3. Deposit ");
        System.out.println("4. Check another A/C ");
        System.out.println("5. Exit ? ");
        System.out.print("\nEnter your choice: ");
        Scanner sc = new Scanner (System.in);
        int choice= sc.nextInt();

        if(choice == 1){
            checkBalance(obj);
        }
        else if (choice == 2){
            withdraw(obj);
        }
        else if (choice == 3){
            deposit(obj);
        }
        else if (choice == 4){
            performoperations();
        }
        else if (choice == 5){
        System.out.println("Exited the Application.\n Thankyou for using the ATM Machine.************************* ");
        }
        else {
            System.out.println("Enter a valid choice. ");
            displaymenu(obj);
        }
    }

// Method to check account balance
    public void checkBalance(BankAccount obj){
        System.out.println("Your A/C balance is : " + obj.Balance);
        displaymenu(obj);
    }


// Method to withdraw money from the account
    public void withdraw(BankAccount obj){
        System.out.println("Enter amount to withdaw : ");
        Scanner sc = new Scanner (System.in);
        float amount = sc.nextFloat();
        if (amount>obj.Balance){
            System.out.println("Insufficent balance. ");
        }
        else {
            obj.Balance = obj.Balance - amount;
            System.out.println("Money withdrawn successfully! ");
        }
            displaymenu(obj);
        }

        
// Method to deposit money into the account
    public void deposit(BankAccount obj){
        System.out.println("Enter amount to deposit : ");
        Scanner sc = new Scanner (System.in);
        float amount = sc.nextFloat();
        obj.Balance = obj.Balance + amount;
        System.out.println("Money deposited successfully! ");
        displaymenu(obj);
    }

}
