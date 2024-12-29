import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.00); // Initial balance
        ATM atm = new ATM (account);
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            atm.displayMenu();
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                System.out.println("Invalid option. Please try again.");
            }
        }
        
        scanner.close();
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }
    
    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Chack Balance");
        System.out.println("4. Exit");
    }
    
    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Please take your cash.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    
    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful.");
    }
   
    public void checkBalance() {
        System.out.println("Current balance:" + account.getBalance());
    }
}

class BankAccount {
    private double balance;
    
    public BankAccount (double initialBalance) {
        this.balance = initialBalance;
    }
    
    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
            } else {
                balance -= amount;
                return true;
            }
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
}