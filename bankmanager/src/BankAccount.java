public abstract class BankAccount {
    protected int id;
    protected String accountNumber;
    protected String accountHolderName;
    protected String createdDate;

    public BankAccount(int id, String accountNumber, String accountHolderName, String createdDate) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.createdDate = createdDate;
    }

    public abstract void displayAccountInfo();
}

