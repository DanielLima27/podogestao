CREATE TABLE patient(
    id serial PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cpf VARCHAR(15) NOT NULL UNIQUE,
    phone VARCHAR(15) NOT NULL,
    email VARCHAR(100),
    date_of_birth DATE NOT NULL,
    marital_status VARCHAR(20) NOT NULL,
    occupation VARCHAR(50),
    address VARCHAR(150),
    neighborhood VARCHAR(50),
    city VARCHAR(50),
    zip_code VARCHAR(10)
);