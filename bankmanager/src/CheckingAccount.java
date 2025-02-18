public class CheckingAccount extends BankAccount {
    private String cardNumber;
    private double accountBalance;

    public CheckingAccount(int id, String accountNumber, String accountHolderName, String creationDate,
                           String cardNumber, double accountBalance) {
        super(id, accountNumber, accountHolderName, creationDate);
        this.cardNumber = cardNumber;
        this.accountBalance = accountBalance;
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("Số tài khoản: " + accountNumber);
        System.out.println("Tên chủ tài khoản: " + accountHolderName);
        System.out.println("Ngày tạo tài khoản: " + creationDate);
        System.out.println("Số thẻ " + cardNumber);
        System.out.println("Số tiền tài khoản: " + accountBalance);
    }
}
