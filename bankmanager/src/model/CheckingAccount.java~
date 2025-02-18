package model;

public class CheckingAccount extends BankAccount {
    private String cardNumber;
    private double accountBalance;

    public CheckingAccount(String accountNumber, String accountHolderName, String creationDate,
                           String cardNumber, double accountBalance) {
        super(accountNumber, accountHolderName, creationDate);
        this.cardNumber = cardNumber;
        this.accountBalance = accountBalance;
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("\n===== TÀI KHOẢN THANH TOÁN =====");
        System.out.println("ID tài khoản: " + id);
        System.out.println("Số tài khoản: " + accountNumber);
        System.out.println("Tên chủ tài khoản: " + accountHolderName);
        System.out.println("Ngày tạo tài khoản: " + creationDate);
        System.out.println("Số thẻ: " + cardNumber);
        System.out.println("Số tiền trong tài khoản: " + accountBalance);
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + cardNumber + "," + accountBalance;
    }
}
