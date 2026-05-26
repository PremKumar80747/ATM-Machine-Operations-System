import java.util.HashMap;
import java.util.Scanner;

class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // HashMap for Account Number and Password
        HashMap<Integer, String> accounts = new HashMap<>();

        // Predefined Accounts
        accounts.put(1001, "1001");
        accounts.put(1002, "1002");
        accounts.put(1003, "1003");

        // Balances
        HashMap<Integer, Double> balances = new HashMap<>();
        balances.put(1001, 10000.0);
        balances.put(1002, 20000.0);
        balances.put(1003, 15000.0);

        System.out.println("===== ATM MACHINE =====");

        // Account Type
        System.out.println("Select Account Type:");
        System.out.println("1. Saving Account");
        System.out.println("2. Current Account");
        System.out.print("Enter Choice: ");

        int typeChoice = sc.nextInt();
        String accountType = "";

        if (typeChoice == 1) {
            accountType = "Saving";
        } else if (typeChoice == 2) {
            accountType = "Current";
        } else {
            System.out.println("Invalid Account Type!");
            return;
        }

        // Login
        System.out.print("\nEnter Account Number: ");
        int accountNumber = sc.nextInt();

        sc.nextLine(); // Clear buffer

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        // Authentication
        if (accounts.containsKey(accountNumber)
                && accounts.get(accountNumber).equals(password)) {

            System.out.println("\nLogin Successful!");
            System.out.println("Welcome to " + accountType + " Account");

            int choice;

            do {
                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Enter Your Choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("Current Balance: $"
                                + balances.get(accountNumber));
                        break;

                    case 2:

                        System.out.print("Enter Deposit Amount: $");
                        double deposit = sc.nextDouble();

                        if (deposit > 0) {

                            double currentBalance =
                                    balances.get(accountNumber);

                            currentBalance += deposit;

                            balances.put(accountNumber, currentBalance);

                            System.out.println(
                                    "Amount Deposited Successfully!");
                            System.out.println(
                                    "Updated Balance: $"
                                            + currentBalance);

                        } else {
                            System.out.println("Invalid Amount!");
                        }

                        break;

                    case 3:

                        System.out.print("Enter Withdraw Amount: $");
                        double withdraw = sc.nextDouble();

                        double currentBalance =
                                balances.get(accountNumber);

                        if (withdraw > 0
                                && withdraw <= currentBalance) {

                            currentBalance -= withdraw;

                            balances.put(accountNumber,
                                    currentBalance);

                            System.out.println(
                                    "Amount Withdrawn Successfully!");
                            System.out.println(
                                    "Remaining Balance: $"
                                            + currentBalance);

                        } else {
                            System.out.println(
                                    "Insufficient Balance or Invalid Amount!");
                        }

                        break;

                    case 4:
                        System.out.println(
                                "Thank You for Using ATM!");
                        break;

                    default:
                        System.out.println(
                                "Invalid Choice! Please Try Again.");
                }

            } while (choice != 4);

        } else {

            System.out.println("\nInvalid Account Number or Password!");
        }

        sc.close();
    }
}