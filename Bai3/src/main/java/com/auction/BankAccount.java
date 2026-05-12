package com.auction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccount {
    private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);

    private final String accountNumber;
    private final String ownerName;
    private double balance;

    public BankAccount(final String accountNumber, final String ownerName,
                       final double initialBalance) {

        logger.info("Yêu cầu tạo tài khoản cho: {}", ownerName);

        if (accountNumber == null || accountNumber.isBlank()) {
            logger.error("Thất bại: Số tài khoản bị trống.");
            throw new IllegalArgumentException("Số tài khoản không được trống");
        }
        if (ownerName == null || ownerName.isBlank()) {
            logger.error("Thất bại: Tên chủ tài khoản bị trống.");
            throw new IllegalArgumentException("Tên chủ tài khoản không được trống");
        }
        if (initialBalance < 0) {
            logger.error("Thất bại: Số dư khởi tạo âm ({})", initialBalance);
            throw new IllegalArgumentException("Số dư ban đầu không được âm");
        }

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;

        logger.info("Tài khoản {} đã được tạo thành công với số dư {}",
                accountNumber, initialBalance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("BankAccount{no='%s', owner='%s', balance=%.2f}",
                accountNumber, ownerName, balance);
    }
}
