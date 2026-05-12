package com.auction;

import java.util.Locale;

public class InvalidFundingAmountException extends BankException {

    public InvalidFundingAmountException(double amount) {
        super("So tien khong hop le: $" + String.format(Locale.US, "%.2f", amount));
    }
}