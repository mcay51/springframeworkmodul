package tr.com.mustafacay.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import tr.com.mustafacay.data.entity.Product;
import tr.com.mustafacay.data.service.ProductService;
import java.math.BigDecimal;

/**
 * Spring Data Demo uygulamasının başlangıç noktası.
 * JPA ve PostgreSQL entegrasyonunu gösterir.
 */
@SpringBootApplication
public class SpringDataDemoApplication {
    
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataDemoApplication.class, args);
        
        ProductService productService = context.getBean(ProductService.class);
        
        // Örnek ürün oluştur
        Product product = new Product();
        product.setName("Test Ürünü");
        product.setDescription("Test ürün açıklaması");
        product.setPrice(new BigDecimal("99.99"));
        product.setStock(100);
        
        // Ürünü kaydet
        product = productService.saveProduct(product);
        System.out.println("Ürün kaydedildi: " + product.getName());
        
        // Tüm ürünleri listele
        productService.getAllProducts().forEach(p -> 
            System.out.println("Ürün: " + p.getName() + ", Fiyat: " + p.getPrice()));
    }
} 