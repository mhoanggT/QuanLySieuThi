package iuh.fit.oop.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iuh.fit.oop.entity.Employee;
import iuh.fit.oop.entity.Gender;
import iuh.fit.oop.entity.Role;
import iuh.fit.oop.manager.EmployeeManager;

public class EmployeeManagerTester {

    private EmployeeManager manager;

    @BeforeEach
    void setUp() {
        manager = new EmployeeManager();
    }

    @Test
    void testAddEmployee() {
        Employee e = new Employee("E01", "Nguyen Van A", Role.MANAGER, Gender.MALE);
        manager.Add(e);

        Employee found = manager.findById("E01");
        assertNotNull(found, "Employee should be found after adding");
        assertEquals("Nguyen Van A", found.getName());
        assertEquals(Role.MANAGER, found.getRole());
        assertEquals(Gender.MALE, found.getGender());
    }

    @Test
    void testFindByIdNotFound() {
        Employee found = manager.findById("E99");
        assertNull(found, "Should return null when employee not found");
    }

    @Test
    void testRemoveByIdSuccess() {
        Employee e = new Employee("E02", "Tran Thi B", Role.STAFF, Gender.FEMALE);
        manager.Add(e);

        boolean removed = manager.removeById("E02");
        assertTrue(removed, "Should return true when removed successfully");
        assertNull(manager.findById("E02"), "Employee should not exist after removal");
    }

    @Test
    void testRemoveByIdNotFound() {
        boolean removed = manager.removeById("E99");
        assertFalse(removed, "Should return false when trying to remove non-existing employee");
    }

    @Test
    void testEnsureCapacityAutomaticallyExpands() {
        // Thêm nhiều hơn 5 nhân viên để test tăng mảng
        for (int i = 0; i < 7; i++) {
            manager.Add(new Employee("E" + i, "Emp " + i, Role.STAFF, Gender.MALE));
        }
        assertNotNull(manager.findById("E6"));
        assertEquals("Emp 6", manager.findById("E6").getName());
    }

    @Test
    void testSetInvalidEmployeeNameThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Employee("E03", "", Role.MANAGER, Gender.FEMALE);
        });
        assertEquals("Name must not be empty", ex.getMessage());
    }

    @Test
    void testSetInvalidEmployeeRoleThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Employee("E04", "Le Van C", null, Gender.MALE);
        });
        assertEquals("Invalid role", ex.getMessage());
    }

    @Test
    void testSetInvalidEmployeeGenderThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Employee("E05", "Le Thi D", Role.STAFF, null);
        });
        assertEquals("Invalid gender", ex.getMessage());
    }
}
