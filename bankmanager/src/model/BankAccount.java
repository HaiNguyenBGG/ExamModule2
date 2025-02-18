package model;

import java.io.*;

public abstract class BankAccount implements Serializable {
    private static final String ID_FILE_PATH = "data/bank_account.csv";
    protected static int currentId = loadLastId();
    protected int id;
    public String accountNumber;
    protected String accountHolderName;
    protected String creationDate;

    public BankAccount(String accountNumber, String accountHolderName, String creationDate) {
        this.id = currentId++;
        saveLastId();
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.creationDate = creationDate;
    }

    public abstract void displayAccountInfo();

    public String toCSV() {
        return id + "," + accountNumber + "," + accountHolderName + "," + creationDate;
    }

    private static int loadLastId() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ID_FILE_PATH))) {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            return 1;
        }
    }
    private static void saveLastId() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ID_FILE_PATH))) {
            writer.write(String.valueOf(currentId));
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu ID vào file!");
        }
    }
}
