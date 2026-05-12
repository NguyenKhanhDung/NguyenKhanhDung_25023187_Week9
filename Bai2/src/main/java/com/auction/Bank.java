package com.auction;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bank {

    private static final Logger logger = LoggerFactory.getLogger(Bank.class);
    private static final String ID_PATTERN = "\\d{9}";

    private List<Customer> customerList;

    public Bank() {
        this.customerList = new ArrayList<>();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        if (customerList == null) {
            this.customerList = new ArrayList<>();
        } else {
            this.customerList = customerList;
        }
    }

    public void readCustomerList(InputStream inputStream) {
        logger.debug("Bat dau doc du lieu...");
        if (inputStream == null) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            Customer current = null;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                int last = line.lastIndexOf(' ');
                if (last <= 0) {
                    continue;
                }

                String token = line.substring(last + 1).trim();
                if (token.matches(ID_PATTERN)) {
                    String name = line.substring(0, last).trim();
                    current = new Customer(Long.parseLong(token), name);
                    customerList.add(current);
                    logger.info("Them khach hang {}", name);
                } else if (current != null) {
                    String[] parts = line.split("\\s+");
                    if (parts.length >= 3) {
                        long num = Long.parseLong(parts[0]);
                        double bal = Double.parseDouble(parts[2]);
                        if (Account.CHECKING_TYPE.equals(parts[1])) {
                            current.addAccount(new CheckingAccount(num, bal));
                        } else if (Account.SAVINGS_TYPE.equals(parts[1])) {
                            current.addAccount(new SavingsAccount(num, bal));
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Loi khi doc du lieu khach hang: {}", e.getMessage());
        }
    }

    public String getCustomersInfoByIdOrder() {
        customerList.sort((o1, o2) -> Long.compare(o1.getIdNumber(), o2.getIdNumber()));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < customerList.size(); i++) {
            res.append(customerList.get(i).getCustomerInfo());
            if (i < customerList.size() - 1) {
                res.append("\n");
            }
        }
        return res.toString();
    }

    public String getCustomersInfoByNameOrder() {
        List<Customer> copy = new ArrayList<>(customerList);
        copy.sort((c1, c2) -> {
            int nameCompare = c1.getFullName().compareTo(c2.getFullName());
            return nameCompare != 0 ? nameCompare : Long.compare(c1.getIdNumber(), c2.getIdNumber());
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < copy.size(); i++) {
            sb.append(copy.get(i).getCustomerInfo());
            if (i < copy.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}