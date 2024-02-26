import java.util.Scanner;

class BankAcc {
    private double balance;

    public BankAcc(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAcc userAccount;

    public ATM(BankAcc userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction(int option, Scanner scanner) {
        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmt = scanner.nextDouble();
                if (userAccount.withdraw(withdrawAmt)) {
                    System.out.println("Withdrawal successful. Remaining balance: $" + userAccount.getBalance());
                } else {
                    System.out.println("Insufficient funds for withdrawal.");
                }
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmt = scanner.nextDouble();
                userAccount.deposit(depositAmt);
                System.out.println("Deposit successful. New balance: $" + userAccount.getBalance());
                break;
            case 3:
                System.out.println("Current Balance: $" + userAccount.getBalance());
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
        }
    }
}

public class atminterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        BankAcc userAccount = new BankAcc(1000.0);

        
        ATM atm = new ATM(userAccount);

        while (true) {
            
            atm.displayMenu();

            
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            
            atm.performTransaction(option, scanner);
        }
    }
}
