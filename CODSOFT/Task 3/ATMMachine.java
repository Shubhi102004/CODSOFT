import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive...!");
        }
    }
    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds for this withdrawal...!");
            return false;
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive...!");
            return false;
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: $" + balance);
            return true;
        }
    }
}
class ATM {
    private BankAccount account;
    public ATM(BankAccount account) {
        this.account = account;
    }
    public void displayMenu() {
        System.out.println("\nWelcome to the ATM...!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    public void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }
    public void deposit(double amount) {
        account.deposit(amount);
    }
    public void withdraw(double amount) {
        account.withdraw(amount);
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            displayMenu();
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM...!");
                    break;
                default:
                    System.out.println("Invalid option. Try again...!");
            }
        }
        scanner.close();
    }
}
public class ATMMachine {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(500.00);
        ATM atm = new ATM(account);
        atm.start();
    }
}
