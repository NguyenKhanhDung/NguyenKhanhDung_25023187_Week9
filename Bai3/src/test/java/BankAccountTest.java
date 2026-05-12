

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.auction.BankAccount;
import org.junit.jupiter.api.Test;

/**
 * Kiểm thử đơn vị cho lớp BankAccount.
 */

class BankAccountTest {

    @Test
    void testValidAccountCreation() {
        BankAccount account = new BankAccount("123456", "Nguyen Van A", 1000.0);
        assertEquals("123456", account.getAccountNumber());
        assertEquals("Nguyen Van A", account.getOwnerName());
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void testInvalidAccountNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount("", "Nguyen Van A", 1000.0);
        });
    }

    @Test
    void testInvalidOwnerName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount("123456", null, 1000.0);
        });
    }

    @Test
    void testNegativeBalance() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount("123456", "Nguyen Van A", -50.0);
        });
    }

    @Test
    void testToStringFormat() {
        BankAccount account = new BankAccount("123", "User", 50.0);
        String expected = "BankAccount{no='123', owner='User', balance=50.00}";
        assertEquals(expected, account.toString());
    }
}