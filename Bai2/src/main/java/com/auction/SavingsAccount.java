package com.auction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SavingsAccount extends Account {
    private static final Logger logger = LoggerFactory.getLogger(SavingsAccount.class);
    private static final double max_withdraw = 1000.0;
    private static final double min_balance = 5000.0;


    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        double initialBalance = getBalance();
        try {
            doDepositing(amount);
            double finalBalance = getBalance();
            Transaction t = new Transaction(
                    Transaction.TYPE_DEPOSIT_SAVINGS,
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
            if (amount > max_withdraw) {
                throw new InvalidFundingAmountException(amount);
            }
            if (initialBalance - amount < min_balance) {
                throw new InsufficientFundsException(amount);
            }
            doWithdrawing(amount);
            double finalBalance = getBalance();
            Transaction t = new Transaction(
                    Transaction.TYPE_WITHDRAW_SAVINGS,
                    amount,
                    initialBalance,
                    finalBalance);
            addTransaction(t);
            logger.info("Rut tien thanh cong: {} tu tai khoan {}", amount, getAccountNumber());
        } catch (BankException e) {
            logger.warn("Giao dich rut tien bi tu choi: {}", e.getMessage());
        } catch (Exception e) {
            logger.error("Loi he thong khi rut tien", e);
        }
    }
}
