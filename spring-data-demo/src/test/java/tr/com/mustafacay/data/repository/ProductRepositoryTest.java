package tr.com.mustafacay.data.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import tr.com.mustafacay.data.entity.Product;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ProductRepository için repository katmanı testleri.
 * @DataJpaTest ile sadece JPA bileşenleri test edilir.
 */
@DataJpaTest
@Sql(scripts = "classpath:init-test-schema.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    /**
     * findByNameContainingIgnoreCase metodunu test eder
     */
    @Test
    void testFindByNameContainingIgnoreCase() {
        // Given: Test ürünü oluştur ve kaydet
        Product product = new Product();
        product.setName("iPhone 13");
        product.setPrice(new BigDecimal("999.99"));
        product.setStock(50);
        productRepository.save(product);

        // When: İsme göre arama yapıldığında
        List<Product> products = productRepository.findByNameContainingIgnoreCase("iphone");

        // Then: Case-insensitive olarak ürün bulunmalı
        assertFalse(products.isEmpty());
        assertEquals(1, products.size());
        assertEquals("iPhone 13", products.get(0).getName());
    }

    /**
     * findTopExpensiveProducts metodunu test eder
     */
    @Test
    void testFindTopExpensiveProducts() {
        // Given: Farklı fiyatlarda ürünler kaydet
        Product product1 = new Product();
        product1.setName("Ürün 1");
        product1.setPrice(new BigDecimal("100.00"));
        product1.setStock(10);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Ürün 2");
        product2.setPrice(new BigDecimal("200.00"));
        product2.setStock(20);
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setName("Ürün 3");
        product3.setPrice(new BigDecimal("300.00"));
        product3.setStock(30);
        productRepository.save(product3);

        // When: En pahalı 2 ürün sorgulandığında
        List<Product> expensiveProducts = productRepository.findTopExpensiveProducts(2);

        // Then: Fiyata göre sıralı ilk 2 ürün gelmeli
        assertEquals(2, expensiveProducts.size());
        assertEquals("Ürün 3", expensiveProducts.get(0).getName());
        assertEquals("Ürün 2", expensiveProducts.get(1).getName());
    }
} 