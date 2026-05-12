package com.auction;

import java.util.Locale;

public class InsufficientFundsException  extends BankException {
    public InsufficientFundsException(double amount) {
        super("So du tai khoan khong du $" + String.format(Locale.US, "%.2f", amount)
                + " de thuc hien giao dich");
    }
}
