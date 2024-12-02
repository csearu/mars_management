CREATE TABLE RESOURCE (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255),
    quantity DOUBLE,
    consumption_rate DOUBLE,
    unit VARCHAR(255)
);