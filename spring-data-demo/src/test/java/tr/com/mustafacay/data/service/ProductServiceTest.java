package tr.com.mustafacay.data.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tr.com.mustafacay.data.entity.Product;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ProductService sınıfı için entegrasyon testleri.
 * @Transactional annotasyonu ile her test sonrası rollback yapılır.
 */
@SpringBootTest
@Transactional
@Sql(scripts = "classpath:init-test-schema.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    private Product testProduct;

    /**
     * Her test öncesi çalışacak hazırlık metodu
     */
    @BeforeEach
    void setUp() {
        testProduct = new Product();
        testProduct.setName("Test Ürünü");
        testProduct.setDescription("Test Açıklaması");
        testProduct.setPrice(new BigDecimal("99.99"));
        testProduct.setStock(100);
    }

    /**
     * Ürün kaydetme işlemini test eder
     */
    @Test
    void testSaveProduct() {
        // When: Ürün kaydedildiğinde
        Product savedProduct = productService.saveProduct(testProduct);

        // Then: Kaydedilen ürün null olmamalı ve ID'si olmalı
        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getId());
        assertEquals("Test Ürünü", savedProduct.getName());
        assertEquals(new BigDecimal("99.99"), savedProduct.getPrice());
    }

    /**
     * Stok güncelleme işlemini test eder
     */
    @Test
    void testUpdateStock() {
        // Given: Önce ürün kaydedilir
        Product savedProduct = productService.saveProduct(testProduct);

        // When: Stok güncellendiğinde
        Product updatedProduct = productService.updateStock(savedProduct.getId(), 50);

        // Then: Stok miktarı güncellenmiş olmalı
        assertEquals(50, updatedProduct.getStock());
    }

    /**
     * Fiyat aralığına göre ürün bulma işlemini test eder
     */
    @Test
    void testGetProductsByPriceRange() {
        // Given: Test ürünleri kaydedilir
        productService.saveProduct(testProduct);

        Product expensiveProduct = new Product();
        expensiveProduct.setName("Pahalı Ürün");
        expensiveProduct.setPrice(new BigDecimal("199.99"));
        expensiveProduct.setStock(50);
        productService.saveProduct(expensiveProduct);

        // When: Fiyat aralığındaki ürünler sorgulandığında
        List<Product> products = productService.getProductsByPriceRange(
            new BigDecimal("90.00"), 
            new BigDecimal("150.00")
        );

        // Then: Sadece fiyatı aralıkta olan ürünler gelmeli
        assertEquals(1, products.size());
        assertEquals("Test Ürünü", products.get(0).getName());
    }

    /**
     * Düşük stoklu ürünleri bulma işlemini test eder
     */
    @Test
    void testGetLowStockProducts() {
        // Given: Farklı stok miktarlarıyla ürünler kaydedilir
        productService.saveProduct(testProduct); // stock: 100

        Product lowStockProduct = new Product();
        lowStockProduct.setName("Az Stoklu Ürün");
        lowStockProduct.setPrice(new BigDecimal("149.99"));
        lowStockProduct.setStock(10);
        productService.saveProduct(lowStockProduct);

        // When: Stok limiti 50'nin altındaki ürünler sorgulandığında
        List<Product> lowStockProducts = productService.getLowStockProducts(50);

        // Then: Sadece düşük stoklu ürünler gelmeli
        assertEquals(1, lowStockProducts.size());
        assertEquals("Az Stoklu Ürün", lowStockProducts.get(0).getName());
    }
} 