import java.util.Scanner;

// Bank Account class
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited successfully: $" + amount);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn successfully: $" + amount);
            return true;
        }
    }
}

// ATM class
public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("\n========== ATM Menu ==========");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.println("==============================");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount))
                        System.out.println("Remaining balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("New balance: $" + account.getBalance());
                    break;
                case 3:
                    System.out.println("Your balance is: $" + account.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        System.out.println("\nWelcome to the ATM Machine!");
        BankAccount userAccount = new BankAccount(1000); // Starting balance of $1000
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
