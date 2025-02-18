package controller;

import model.*;
import service.BankAccountService;

import java.util.List;

public class BankAccountController {
    private BankAccountService service = new BankAccountService();

    public void addSavingsAccount(String accountNumber, String accountHolderName, String creationDate,
                                  double depositAmount, String depositDate, double interestRate, int interestPeriod) {
        SavingsAccount acc = new SavingsAccount(accountNumber, accountHolderName, creationDate,
                depositAmount, depositDate, interestRate, interestPeriod);
        service.addAccount(acc);
    }

    public void addCheckingAccount(String accountNumber, String accountHolderName, String creationDate,
                                   String cardNumber, double accountBalance) {
        CheckingAccount acc = new CheckingAccount(accountNumber, accountHolderName, creationDate,
                cardNumber, accountBalance);
        service.addAccount(acc);
    }

    public void deleteAccount(String accountNumber) throws NotFoundBankAccountException {
        service.deleteAccount(accountNumber);
    }
    public void displayAllAccounts() {
        service.displayAllAccounts();
    }
    public void searchAccount(String keyword) {
        List<BankAccount> results = service.searchAccounts(keyword);
        if (results.isEmpty()) {
            System.out.println("Không tìm thấy tài khoản nào chứa từ khóa: " + keyword);
        } else {
            System.out.println("\nKết quả tìm kiếm:");
            for (BankAccount acc : results) {
                acc.displayAccountInfo();
            }
        }
    }
}
