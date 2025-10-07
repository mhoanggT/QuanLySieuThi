package iuh.fit.oop.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iuh.fit.oop.entity.Customer;
import iuh.fit.oop.entity.Gender;
import iuh.fit.oop.manager.CustomerManager;

public class CustomerManagerTester {

    private CustomerManager manager;

    @BeforeEach
    void setUp() {
        manager = new CustomerManager();
    }

    @Test
    void testAddCustomer() {
        Customer c = new Customer("C01", "Alice", Gender.FEMALE, "0912345678", LocalDate.of(2000, 5, 10));
        manager.Add(c);

        Customer found = manager.findById("C01");
        assertNotNull(found, "Customer should be found after adding");
        assertEquals("Alice", found.getName());
        assertEquals(Gender.FEMALE, found.getGender());
        assertEquals("0912345678", found.getPhone());
        assertEquals(LocalDate.of(2000, 5, 10), found.getBirthday());
    }

    @Test
    void testFindByIdNotFound() {
        Customer found = manager.findById("C99");
        assertNull(found, "Should return null when not found");
    }

    @Test
    void testRemoveByIdSuccess() {
        Customer c = new Customer("C02", "Bob", Gender.MALE, "0987654321", LocalDate.of(1999, 12, 1));
        manager.Add(c);

        boolean removed = manager.removeById("C02");
        assertTrue(removed, "Should return true when removed successfully");
        assertNull(manager.findById("C02"), "Customer should not exist after removal");
    }

    @Test
    void testRemoveByIdNotFound() {
        boolean removed = manager.removeById("C99");
        assertFalse(removed, "Should return false when removing non-existing customer");
    }

    @Test
    void testEnsureCapacityExpandsAutomatically() {
        for (int i = 0; i < 7; i++) {
            manager.Add(new Customer("C" + i, "Name" + i, Gender.MALE, "090000000" + i, LocalDate.of(1990, 1, 1)));
        }
        Customer found = manager.findById("C6");
        assertNotNull(found);
        assertEquals("Name6", found.getName());
    }

    // --- Exception tests ---

    @Test
    void testInvalidIdThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Customer("", "Alice", Gender.FEMALE, "0912345678", LocalDate.of(2000, 1, 1));
        });
        assertEquals("Product's id must not be empty", ex.getMessage());
    }

    @Test
    void testInvalidNameThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Customer("C03", "", Gender.MALE, "0912345678", LocalDate.of(2000, 1, 1));
        });
        assertEquals("Name must not be empty", ex.getMessage());
    }

    @Test
    void testInvalidGenderThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Customer("C04", "Charlie", null, "0912345678", LocalDate.of(2000, 1, 1));
        });
        assertEquals("Invalid gender", ex.getMessage());
    }

    @Test
    void testInvalidPhoneThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Customer("C05", "David", Gender.MALE, "12345", LocalDate.of(2000, 1, 1));
        });
        assertEquals("Phone number must have 10 digits,starting with 0", ex.getMessage());
    }

    @Test
    void testInvalidBirthdayThrowsException_Null() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Customer("C06", "Eve", Gender.FEMALE, "0909999999", null);
        });
        assertEquals("Invalid birthday", ex.getMessage());
    }

    @Test
    void testInvalidBirthdayThrowsException_Future() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Customer("C07", "Frank", Gender.MALE, "0909999999", LocalDate.now().plusDays(1));
        });
        assertEquals("Invalid birthday", ex.getMessage());
    }
}
