package com.auction;

import java.util.Locale;

public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 1;
    public static final int TYPE_WITHDRAW_CHECKING = 2;
    public static final int TYPE_DEPOSIT_SAVINGS = 3;
    public static final int TYPE_WITHDRAW_SAVINGS = 4;

    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;


    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }


    public int getType() {
        return type;
    }


    public void setType(int type) {
        this.type = type;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }


    public double getFinalBalance() {
        return finalBalance;
    }


    public void setFinalBalance(double finalBalance) {
        this.finalBalance = finalBalance;
    }


    public static String getTypeString(int transactionType) {
        switch (transactionType) {
            case TYPE_DEPOSIT_CHECKING:
                return "Nap tien vang lai";
            case TYPE_WITHDRAW_CHECKING:
                return "Rut tien vang lai";
            case TYPE_DEPOSIT_SAVINGS:
                return "Nap tien tiet kiem";
            case TYPE_WITHDRAW_SAVINGS:
                return "Rut tien tiet kiem";
            default:
                return "Khong ro";
        }
    }

    public String getTransactionSummary() {
        String typeStr = getTypeString(type);
        String initialStr = String.format(Locale.US, "%.2f", initialBalance);
        String amountStr = String.format(Locale.US, "%.2f", amount);
        String finalStr = String.format(Locale.US, "%.2f", finalBalance);
        return "- Kieu giao dich: " + typeStr
                + ". So du ban dau: $" + initialStr
                + ". So tien: $" + amountStr
                + ". So du cuoi: $" + finalStr + ".";
    }
}
