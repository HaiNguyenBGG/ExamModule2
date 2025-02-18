package model;

public class SavingsAccount extends BankAccount {
    private double depositAmount;
    private String depositDate;
    private double interestRate;
    private int interestPeriod;

    public SavingsAccount(String accountNumber, String accountHolderName, String creationDate,
                          double depositAmount, String depositDate, double interestRate, int interestPeriod) {
        super(accountNumber, accountHolderName, creationDate);
        this.depositAmount = depositAmount;
        this.depositDate = depositDate;
        this.interestRate = interestRate;
        this.interestPeriod = interestPeriod;
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("\n===== TÀI KHOẢN TIẾT KIỆM =====");
        System.out.println("ID tài khoản: " + id);
        System.out.println("Số tài khoản: " + accountNumber);
        System.out.println("Tên chủ tài khoản: " + accountHolderName);
        System.out.println("Ngày tạo tài khoản: " + creationDate);
        System.out.println("Số tiền gửi tiết kiệm: " + depositAmount);
        System.out.println("Ngày gửi tiết kiệm: " + depositDate);
        System.out.println("Lãi suất: " + interestRate + "%");
        System.out.println("Kỳ hạn: " + interestPeriod + " tháng");
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + depositAmount + "," + depositDate + "," + interestRate + "," + interestPeriod;
    }
}
