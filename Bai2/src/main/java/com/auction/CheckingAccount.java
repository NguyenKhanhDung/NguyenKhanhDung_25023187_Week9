package com.auction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckingAccount extends Account {

    private static final Logger logger = LoggerFactory.getLogger(CheckingAccount.class);

    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        double initialBalance = getBalance();
        try {
            doDepositing(amount);
            double finalBalance = getBalance();
            Transaction t = new Transaction(
                    Transaction.TYPE_DEPOSIT_CHECKING,
                    amount,
                    initialBalance,
                    finalBalance);
            addTransaction(t);
            logger.info("Nap tien thanh cong: {} vao tai khoan {}", amount, getAccountNumber());
        } catch (BankException e) {
            logger.error("Loi khi nap tien: {}", e.getMessage());
        }
    }

    @Override
    public void withdraw(double amount) {
        double initialBalance = getBalance();
        try {
            doWithdrawing(amount);
            double finalBalance = getBalance();
            Transaction t = new Transaction(
                    Transaction.TYPE_WITHDRAW_CHECKING,
                    amount,
                    initialBalance,
                    finalBalance);
            addTransaction(t);
            logger.info("Rut tien thanh cong: {} tu tai khoan {}", amount, getAccountNumber());
        } catch (BankException e) {
            logger.warn("Giao dich rut tien bi tu choi: {}", e.getMessage());
        } catch (Exception e) {
            logger.error("Loi he thong khong xac dinh khi rut tien", e);
            throw new RuntimeException("Loi he thong", e);
        }
    }
}