package tr.com.mustafacay.data.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Ürün entity sınıfı.
 * Veritabanındaki products tablosunu temsil eder.
 */
@Entity
@Table(name = "products")
public class Product {
    
    /**
     * Ürün ID'si
     * Otomatik artan primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Ürün adı
     * Boş olamaz, minimum 2 karakter
     */
    @Column(nullable = false, length = 100)
    private String name;
    
    /**
     * Ürün açıklaması
     */
    @Column(length = 500)
    private String description;
    
    /**
     * Ürün fiyatı
     * Boş olamaz, 0'dan büyük olmalı
     */
    @Column(nullable = false)
    private BigDecimal price;
    
    /**
     * Stok miktarı
     * Varsayılan değer 0
     */
    @Column(nullable = false)
    private Integer stock = 0;

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
} 