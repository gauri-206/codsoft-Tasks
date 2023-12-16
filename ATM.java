import java.util.Scanner;

public class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int option, Scanner s) {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit(s);
                break;
            case 3:
                withdraw(s);
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }

    private void checkBalance() {
        double balance = bankAccount.getBalance();
        System.out.println("Current Balance: $" + balance);
    }

    private void deposit(Scanner s) {
        System.out.print("Enter deposit amount: $");
        double depositAmount = getValidAmount(s);

        bankAccount.deposit(depositAmount);
        System.out.println("Deposit successful. Updated balance: $" + bankAccount.getBalance());
    }

    private void withdraw(Scanner s) {
        System.out.print("Enter withdrawal amount: $");
        double withdrawalAmount = getValidAmount(s);

        boolean success = bankAccount.withdraw(withdrawalAmount);
        if (success) {
            System.out.println("Withdrawal successful. Updated balance: $" + bankAccount.getBalance());
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    private double getValidAmount(Scanner s) {
        while (true) {
            if (s.hasNextDouble()) {
                double amount = s.nextDouble();
                if (amount >= 0) {
                    return amount;
                }
                else {
                    System.out.println("Invalid amount. Please enter a non-negative value.");
                }
            } 
            else {
                System.out.println("Invalid input. Please enter a valid number.");
                s.next(); // Consume the invalid input
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter initial account balance: $");
        double initialBalance = s.nextDouble();
        BankAccount userAccount = new BankAccount(initialBalance);

        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();

            atm.performTransaction(choice, s);
        }
    }
}

