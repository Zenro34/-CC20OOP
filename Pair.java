import java.util.Scanner;

// 1. ABSTRACTION: Abstract class defining what a BankAccount must do

abstract class BankAccount {
    private String accountHolder; // 2. ENCAPSULATION: Private field
    protected double balance;     // Protected for subclasses to access

    public BankAccount(String accountHolder, double initialBalance) {

        this.accountHolder = accountHolder;
        this.balance = initialBalance;

    }
    // ENCAPSULATION: Public getter
    public String getAccountHolder() {
        return accountHolder;
    }

    // ABSTRACTION: Abstract methods (must be implemented by subclasses)
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    // Concrete method
    public void checkBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: $" + balance);
    }
}
// 3. INHERITANCE: SavingsAccount inherits from BankAccount
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountHolder, double initialBalance) {
        super(accountHolder, initialBalance);
    }
    // 4. POLYMORPHISM: Implementing abstract methods in a specific way
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid amount! Deposit failed.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else {
            System.out.println("Invalid amount or insufficient funds! Withdrawal failed.");
        }
    }
}

public class Pair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create a savings account
        BankAccount account = new SavingsAccount("John Benedict", 100.0);
        int choice;
        do {
            System.out.println("\n--- Simple Bank System ---");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            choice = scanner.nextInt();
            switch(choice) {
                  case 1:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for banking with us!");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1-4.");
            }
        } while(choice != 4);
        scanner.close();
    }
}