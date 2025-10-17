CREATE TABLE patients (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_date DATE,
    address VARCHAR(255),
    neighborhood VARCHAR(100),
    city VARCHAR(100),
    zip_code VARCHAR(20),
    marital_status VARCHAR(50),
    email VARCHAR(255),
    phone VARCHAR(30),
    occupation VARCHAR(100)
);
