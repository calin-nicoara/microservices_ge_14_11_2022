CREATE TABLE product_inventory
(
    id           bigint NOT NULL PRIMARY KEY,
    product_code varchar(255),
    price        numeric(12, 4),
    stock        bigint
);

INSERT INTO product_inventory (id, product_code, price, stock)
VALUES (-1, 'PR_1', 7.50, 10);
INSERT INTO product_inventory (id, product_code, price, stock)
VALUES (-2, 'PR_2', 10, 20);
INSERT INTO product_inventory (id, product_code, price, stock)
VALUES (-3, 'PR_3', 3.50, 30);
