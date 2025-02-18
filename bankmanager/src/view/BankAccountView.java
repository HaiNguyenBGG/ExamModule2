package view;

import controller.BankAccountController;
import model.NotFoundBankAccountException;

import java.util.Scanner;

public class BankAccountView {
    private BankAccountController controller = new BankAccountController();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() throws NotFoundBankAccountException {
        while (true) {
            System.out.println("\n===== QUẢN LÝ TÀI KHOẢN NGÂN HÀNG =====");
            System.out.println("1. Thêm mới tài khoản");
            System.out.println("2. Xóa tài khoản");
            System.out.println("3. Xem danh sách tài khoản");
            System.out.println("4. Tìm kiếm tài khoản");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = validateIntegerInput();

            switch (choice) {
                case 1:
                    addNewAccount();
                    break;
                case 2:
                    deleteAccount();
                    break;
                case 3:
                    controller.displayAllAccounts();
                    break;
                case 4:
                    searchAccount();
                    break;
                case 5:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    private void addNewAccount() {
        System.out.println("\nChọn loại tài khoản:");
        System.out.println("1. Tài khoản Tiết Kiệm");
        System.out.println("2. Tài khoản Thanh Toán");
        System.out.print("Nhập lựa chọn: ");

        int type = validateIntegerInput();

        System.out.print("Nhập số tài khoản: ");
        String accountNumber = validateStringInput();

        System.out.print("Nhập tên chủ tài khoản: ");
        String accountHolderName = validateStringInput();

        System.out.print("Nhập ngày tạo (YYYY-MM-DD): ");
        String creationDate = validateStringInput();

        if (type == 1) {
            System.out.print("Nhập số tiền gửi: ");
            double depositAmount = validatePositiveDouble();

            System.out.print("Nhập ngày gửi (YYYY-MM-DD): ");
            String depositDate = validateStringInput();

            System.out.print("Nhập lãi suất (%): ");
            double interestRate = validatePositiveDouble();

            System.out.print("Nhập kỳ hạn (tháng): ");
            int interestPeriod = validatePositiveInteger();

            controller.addSavingsAccount(accountNumber, accountHolderName, creationDate,
                    depositAmount, depositDate, interestRate, interestPeriod);
            System.out.println("Tài khoản tiết kiệm đã được thêm thành công!");
        } else if (type == 2) {
            System.out.print("Nhập số thẻ: ");
            String cardNumber = validateStringInput();

            System.out.print("Nhập số dư tài khoản: ");
            double accountBalance = validatePositiveDouble();

            controller.addCheckingAccount(accountNumber, accountHolderName, creationDate,
                    cardNumber, accountBalance);
            System.out.println("Tài khoản thanh toán đã được thêm thành công!");
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private void deleteAccount() throws NotFoundBankAccountException {
        while (true) {
            System.out.print("Nhập số tài khoản cần xóa (Nhấn Enter để quay lại): ");
            String accountNumber = scanner.nextLine().trim();
            if (accountNumber.isEmpty()) {
                System.out.println("🔙 Quay lại menu chính.");
                return;
            }
            controller.searchAccount(accountNumber);
            System.out.print("Bạn có chắc muốn xóa tài khoản này? (Y/N): ");
            String confirm = scanner.nextLine().trim().toUpperCase();
            if (confirm.equals("Y")) {
                controller.deleteAccount(accountNumber);
                System.out.println("Tài khoản " + accountNumber + " đã bị xóa.");
                return;
            } else if (confirm.equals("N")) {
                System.out.println("Hủy xóa tài khoản.");
                return;
            } else {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    private void searchAccount() {
        System.out.print("Nhập từ khóa để tìm kiếm tài khoản: ");
        String keyword = scanner.nextLine().trim();
        if (keyword.isEmpty()) {
            System.out.println("Vui lòng nhập từ khóa hợp lệ!");
            return;
        }
        controller.searchAccount(keyword);
    }


    private int validateIntegerInput() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Lỗi: Vui lòng nhập một số nguyên hợp lệ! Nhập lại: ");
            }
        }
    }

    private int validatePositiveInteger() {
        while (true) {
            int value = validateIntegerInput();
            if (value > 0) return value;
            System.out.print("Lỗi: Giá trị phải lớn hơn 0! Nhập lại: ");
        }
    }

    private double validatePositiveDouble() {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value > 0) return value;
                System.out.print("Lỗi: Giá trị phải lớn hơn 0! Nhập lại: ");
            } catch (NumberFormatException e) {
                System.out.print("Lỗi: Vui lòng nhập một số hợp lệ! Nhập lại: ");
            }
        }
    }

    private String validateStringInput() {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.print("Lỗi: Trường này không được để trống! Nhập lại: ");
        }
    }
}
