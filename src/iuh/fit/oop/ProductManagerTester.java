package iuh.fit.oop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTester {

    private ProductManager manager;

    @BeforeEach
    void setUp() {
        manager = new ProductManager();
    }

    @Test
    void testAddProduct() {
        Product p = new Product("P01", "Milk", 25.0, 10, ProductType.FOOD);
        manager.Add(p);

        Product found = manager.findById("P01");
        assertNotNull(found, "Product should be found after adding");
        assertEquals("Milk", found.getName());
        assertEquals(25.0, found.getPrice());
        assertEquals(10, found.getQuantity());
        assertEquals(ProductType.FOOD, found.getType());
    }

    @Test
    void testFindByIdNotFound() {
        Product found = manager.findById("PX");
        assertNull(found, "Should return null when product not found");
    }

    @Test
    void testRemoveByIdSuccess() {
        Product p = new Product("P02", "T-Shirt", 150.0, 20, ProductType.CLOTHING);
        manager.Add(p);

        boolean removed = manager.removeById("P02");
        assertTrue(removed, "Should return true when removed successfully");
        assertNull(manager.findById("P02"), "Product should not exist after removal");
    }

    @Test
    void testRemoveByIdNotFound() {
        boolean removed = manager.removeById("P99");
        assertFalse(removed, "Should return false when removing non-existing product");
    }

    @Test
    void testEnsureCapacityAutomaticallyExpands() {
        // Thêm hơn 5 sản phẩm để ép mảng tự tăng kích thước
        for (int i = 0; i < 7; i++) {
            manager.Add(new Product("P" + i, "Prod" + i, 10.0 + i, 2 + i, ProductType.OTHER));
        }
        Product found = manager.findById("P6");
        assertNotNull(found);
        assertEquals("Prod6", found.getName());
        assertEquals(ProductType.OTHER, found.getType());
    }

    @Test
    void testInvalidIdThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Product("", "Sugar", 10.0, 5, ProductType.FOOD);
        });
        assertEquals("Product's id must not be empty", ex.getMessage());
    }

    @Test
    void testInvalidNameThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Product("P03", "", 10.0, 5, ProductType.FOOD);
        });
        assertEquals("Name must not be empty", ex.getMessage());
    }

    @Test
    void testInvalidPriceThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Product("P04", "Rice", 0, 5, ProductType.FOOD);
        });
        assertEquals("price must be greater than 0", ex.getMessage());
    }

    @Test
    void testInvalidQuantityThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Product("P05", "Cake", 15.0, -1, ProductType.BOOKS);
        });
        assertEquals("quantity must not be less than 0", ex.getMessage());
    }

    @Test
    void testInvalidTypeThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Product("P06", "Candy", 10.0, 2, null);
        });
        assertEquals("invalid product type", ex.getMessage());
    }
}