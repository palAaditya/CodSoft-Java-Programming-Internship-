import java.util.Scanner;

// yha pr  bank account hai...
interface BankAccount {
    void withdraw(double amount);
    void deposit(double amount);
    double checkBalance();
}

// yha pr User ka bank account hai...
class UserAccount implements BankAccount {
    private double balance;

    // Constructor to initialize the balance
    public UserAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to withdraw money from the account override the interface of bank account
    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        }
    }

    // Method to deposit money into the account override the interface of bank account
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    // Method to check the balance override the interface of bank account
    @Override
    public double checkBalance() {
        return balance;
    }
}

//Create a Class representing the ATM machine
public class atm {
    private BankAccount userAccount;

    // Constructor to initialize the user's bank account
    public atm(BankAccount account) {
        this.userAccount = account;
    }

    // Method to display the ATM menu
    public void displayMenu() {
        System.out.println("Welcome to the ATM.");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    // Method to handle user input and perform actions accordingly
    public void handleInput() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + userAccount.checkBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Aapka Ka din sub ho!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    public static void main(String[] args) {

        // Create a bank account object(Reference to User Account) for the user Link with user account....
        BankAccount userAccount = new UserAccount(1000.0);

        // Create an ATM object
        atm Atm = new atm(userAccount);

        // Handle user interactions
        Atm.handleInput();
    }
}
