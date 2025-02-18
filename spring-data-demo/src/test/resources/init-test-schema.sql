-- Test şemasını oluştur (eğer yoksa)
CREATE SCHEMA IF NOT EXISTS test_schema;

-- Test şemasına geç
SET search_path TO test_schema;

-- Varolan tabloları temizle
DROP TABLE IF EXISTS products;

-- Products tablosunu oluştur
CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500),
    price NUMERIC NOT NULL,
    stock INTEGER NOT NULL DEFAULT 0
); 