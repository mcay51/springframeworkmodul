package tr.com.mustafacay.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tr.com.mustafacay.data.entity.Product;
import java.math.BigDecimal;
import java.util.List;

/**
 * Ürün repository sınıfı.
 * Spring Data JPA'nın sağladığı temel CRUD operasyonlarını ve özel sorguları içerir.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    /**
     * Verilen fiyat aralığındaki ürünleri bulur
     * @param minPrice minimum fiyat
     * @param maxPrice maksimum fiyat
     * @return fiyat aralığındaki ürünler
     */
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    
    /**
     * Stok miktarı verilen değerden az olan ürünleri bulur
     * @param stockLimit stok limiti
     * @return stok miktarı limit altında olan ürünler
     */
    List<Product> findByStockLessThan(Integer stockLimit);
    
    /**
     * İsmi verilen metni içeren ürünleri bulur (case-insensitive)
     * @param name aranacak isim
     * @return ismi aranan metni içeren ürünler
     */
    List<Product> findByNameContainingIgnoreCase(String name);
    
    /**
     * En pahalı N ürünü bulur
     * @param limit ürün sayısı
     * @return en pahalı ürünler
     */
    @Query("SELECT p FROM Product p ORDER BY p.price DESC LIMIT ?1")
    List<Product> findTopExpensiveProducts(int limit);
} 