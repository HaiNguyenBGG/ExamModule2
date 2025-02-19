package service;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BankAccountService {
    private static final String FILE_PATH = "data/bank_accounts.csv";
    private List<BankAccount> accounts = new ArrayList<>();

    public BankAccountService() {
        loadAccountsFromCSV();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        saveToFile();
    }

    public BankAccount findAccount(String accountNumber) throws NotFoundBankAccountException {
        return accounts.stream()
                .filter(acc -> acc.accountNumber.trim().equals(accountNumber.trim()))
                .findFirst()
                .orElseThrow(() -> new NotFoundBankAccountException("Account not found: " + accountNumber));
    }

    public void deleteAccount(String accountNumber) throws NotFoundBankAccountException {
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            throw new NotFoundBankAccountException("Tài khoản không tồn tại. Vui lòng nhập lại!");
        }
        accounts.remove(account);
        saveToFile();
        System.out.println("Tài khoản " + accountNumber + " đã bị xóa.");
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("Không có tài khoản nào để hiển thị.");
        } else {
            accounts.forEach(account -> account.displayAccountInfo());
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (BankAccount acc : accounts) {
                writer.write(acc.toCSV());
                writer.newLine();
            }
            System.out.println("Dữ liệu đã được lưu vào file bank_accounts.csv");
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu dữ liệu vào file!");
        }
    }

    public List<BankAccount> searchAccounts(String keyword) {
        List<BankAccount> results = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) {
                    int id = Integer.parseInt(data[0]);
                    String accountNumber = data[1].trim();
                    String accountHolderName = data[2];
                    String creationDate = data[3];

                    if (accountNumber.contains(keyword.trim()) || accountHolderName.toLowerCase().contains(keyword.toLowerCase())) {
                        if (data.length == 8) {
                            double depositAmount = Double.parseDouble(data[4]);
                            String depositDate = data[5];
                            double interestRate = Double.parseDouble(data[6]);
                            int interestPeriod = Integer.parseInt(data[7]);
                            results.add(new SavingsAccount(accountNumber, accountHolderName, creationDate,
                                    depositAmount, depositDate, interestRate, interestPeriod));
                        } else if (data.length == 6) {
                            String cardNumber = data[4];
                            double accountBalance = Double.parseDouble(data[5]);
                            results.add(new CheckingAccount(accountNumber, accountHolderName, creationDate,
                                    cardNumber, accountBalance));
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file dữ liệu!");
        }
        return results;
    }

    public void loadAccountsFromCSV() {
        accounts.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int maxId = 0;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) {
                    int id = Integer.parseInt(data[0]);
                    maxId = Math.max(maxId, id);
                    String accountNumber = data[1].trim();
                    String accountHolderName = data[2];
                    String creationDate = data[3];

                    if (data.length == 8) {
                        double depositAmount = Double.parseDouble(data[4]);
                        String depositDate = data[5];
                        double interestRate = Double.parseDouble(data[6]);
                        int interestPeriod = Integer.parseInt(data[7]);
                        accounts.add(new SavingsAccount(accountNumber, accountHolderName, creationDate,
                                depositAmount, depositDate, interestRate, interestPeriod));
                    } else if (data.length == 6) {
                        String cardNumber = data[4];
                        double accountBalance = Double.parseDouble(data[5]);
                        accounts.add(new CheckingAccount(accountNumber, accountHolderName, creationDate,
                                cardNumber, accountBalance));
                    }
                }
            }
            BankAccount.currentId = maxId + 1;
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file dữ liệu!");
        }
    }
}
