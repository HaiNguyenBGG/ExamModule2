import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccountManager accountManager = new BankAccountManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("-- BANK ACCOUNT MANAGEMENT PROGRAM --");
            System.out.println("1. Add new account");
            System.out.println("2. Delete account");
            System.out.println("3. View all accounts");
            System.out.println("4. Search for an account");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter account type (1 - Savings, 2 - Checking): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter account holder's name: ");
                    String accountHolderName = scanner.nextLine();
                    System.out.print("Enter creation date: ");
                    String creationDate = scanner.nextLine();

                    if (type == 1) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter deposit date: ");
                        String depositDate = scanner.nextLine();
                        System.out.print("Enter interest rate: ");
                        double interestRate = scanner.nextDouble();
                        System.out.print("Enter term (months): ");
                        int termMonths = scanner.nextInt();

                        SavingsAccount savingsAccount = new SavingsAccount(1, accountNumber, accountHolderName, creationDate, depositAmount, depositDate, interestRate, termMonths);
                        accountManager.addAccount(savingsAccount);
                    } else {
                        System.out.print("Enter card number: ");
                        String cardNumber = scanner.nextLine();
                        System.out.print("Enter account balance: ");
                        double accountBalance = scanner.nextDouble();

                        CheckingAccount checkingAccount = new CheckingAccount(1, accountNumber, accountHolderName, creationDate, cardNumber, accountBalance);
                        accountManager.addAccount(checkingAccount);
                    }
                    break;
                case 2:
                    System.out.print("Enter account number to delete: ");
                    String deleteAccountNumber = scanner.nextLine();
                    accountManager.deleteAccount(deleteAccountNumber);
                    break;
                case 3:
                    accountManager.displayAllAccounts();
                    break;
                case 4:
                    System.out.print("Enter account number to search: ");
                    String searchAccountNumber = scanner.nextLine();
                    BankAccount foundAccount = accountManager.findAccount(searchAccountNumber);
                    if (foundAccount != null) {
                        foundAccount.displayAccountInfo();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting program!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}