public class SavingsAccount extends BankAccount {
    private double depositAmount;
    private String depositDate;
    private double interestRate;
    private int interestPeriod;

    public SavingsAccount(int id, String accountNumber, String accountHolderName, String creationDate,
                          double depositAmount, String depositDate, double interestRate, int interestPeriod) {
        super(id, accountNumber, accountHolderName, creationDate);
        this.depositAmount = depositAmount;
        this.depositDate = depositDate;
        this.interestRate = interestRate;
        this.interestPeriod = interestPeriod;
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("Số tài khoản: " + accountNumber);
        System.out.println("Tên chủ tài khoản: " + accountHolderName);
        System.out.println("Ngày tạo tài khoản: " + creationDate);
        System.out.println("Số tiền gửi: " + depositAmount);
        System.out.println("Ngày gửi: " + depositDate);
        System.out.println("Lãi suất: " + interestRate + "%");
        System.out.println("Kỳ hạn: " + interestPeriod + " tháng");
    }
}
