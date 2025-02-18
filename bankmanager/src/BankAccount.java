public abstract class BankAccount {
    protected int id;
    protected String accountNumber;
    protected String accountHolderName;
    protected String creationDate;

    public BankAccount(int id, String accountNumber, String accountHolderName, String creationDate) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.creationDate = creationDate;
    }

    public abstract void displayAccountInfo();
}
