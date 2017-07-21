CREATE DATABASE personaldashboard

CREATE TABLE address 
(
    id INT NOT NULL AUTO_INCREMENT,
    house_number INT NOT NULL,
    street VARCHAR(200) NOT NULL,    
    zip_code VARCHAR(100),
    city VARCHAR(100) NOT NULL,
	country VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user
(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    birthday DATE,
    gender VARCHAR(30),
    role VARCHAR(30),
    address_id INT,
    PRIMARY KEY (id), 
    FOREIGN KEY (address_id) REFERENCES address(id)
);