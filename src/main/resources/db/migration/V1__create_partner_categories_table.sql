CREATE TABLE partner_categories (
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    slug        VARCHAR(100),
    description VARCHAR(100),
    created_by  VARCHAR(100) NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    delete_at   TIMESTAMP DEFAULT,
);