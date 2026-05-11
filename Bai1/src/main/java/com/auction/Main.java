package com.auction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("1. QUAN LY DEPENDENCY: Da cap nhat file pom.xml de tu dong tai cac thu vien.");

        LOGGER.info("2. LOGGING: Thay the System.out.println bang Logback Classic 1.4.11.");
        LOGGER.info("   Loi ich: Giup quan ly log theo cap do (INFO, ERROR) va ghi lai thoi gian thuc.");

        LOGGER.info("3. TEST FRAMEWORK: Chuyen toan bo sang JUnit Jupiter 5.9.2.");
        LOGGER.info("   Loi ich: Dong nhat cong cu kiem thu, ho tro cac tinh nang moi cua Java 17.");

        LOGGER.info("4. DATABASE: Them Hibernate Core 6.2.0.Final.");
        LOGGER.info("   Loi ich: San sang cho viec ket noi va quan ly co so du lieu trong tuong lai.");

        LOGGER.info("5. CI/CD: Su dung GitHub Actions (file .yml) de tu dong kiem tra build.");
        LOGGER.info("   Loi ich: Dam bao code luon chay dung tren moi moi truong.");
    }
}
