package view;

import model.NotFoundBankAccountException;

public class Main {
    public static void main(String[] args) throws NotFoundBankAccountException {
        new BankAccountView().showMenu();
    }
}
