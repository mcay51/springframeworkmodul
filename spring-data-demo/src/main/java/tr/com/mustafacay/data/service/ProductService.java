package tr.com.mustafacay.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.mustafacay.data.entity.Product;
import tr.com.mustafacay.data.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.List;

/**
 * Ürün servis sınıfı.
 * İş mantığı ve transaction yönetimi burada gerçekleştirilir.
 */
@Service
public class ProductService {
    
    private final ProductRepository productRepository;
    
    /**
     * Constructor injection ile repository bağımlılığı enjekte edilir
     * @param productRepository ürün repository'si
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    /**
     * Yeni ürün kaydeder
     * @param product kaydedilecek ürün
     * @return kaydedilen ürün
     */
    @Transactional
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    
    /**
     * Stok güncellemesi yapar
     * @param productId ürün ID'si
     * @param newStock yeni stok miktarı
     * @return güncellenen ürün
     */
    @Transactional
    public Product updateStock(Long productId, Integer newStock) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Ürün bulunamadı: " + productId));
        
        product.setStock(newStock);
        return productRepository.save(product);
    }
    
    /**
     * Tüm ürünleri listeler
     * @return ürün listesi
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    /**
     * Fiyat aralığındaki ürünleri bulur
     * @param minPrice minimum fiyat
     * @param maxPrice maksimum fiyat
     * @return fiyat aralığındaki ürünler
     */
    public List<Product> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }
    
    /**
     * Stok limiti altındaki ürünleri bulur
     * @param stockLimit stok limiti
     * @return stok limiti altındaki ürünler
     */
    public List<Product> getLowStockProducts(Integer stockLimit) {
        return productRepository.findByStockLessThan(stockLimit);
    }
} 