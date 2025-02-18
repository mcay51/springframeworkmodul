-- Test şemasını temizle
DROP SCHEMA IF EXISTS test_schema CASCADE;
CREATE SCHEMA test_schema;

-- Test şemasına geç
SET search_path TO test_schema;

-- Users tablosunu oluştur
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15),
    active BOOLEAN NOT NULL DEFAULT true
);

-- Test verilerini ekle
INSERT INTO users (name, email, phone, active) VALUES
    ('Test User 1', 'test1@example.com', '5551234567', true),
    ('Test User 2', 'test2@example.com', '5552345678', true),
    ('Inactive User', 'inactive@example.com', '5553456789', false); 