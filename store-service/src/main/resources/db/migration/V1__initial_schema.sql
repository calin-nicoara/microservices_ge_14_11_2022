CREATE TABLE category
(
    id            bigint NOT NULL PRIMARY KEY,
    code          varchar(255),
    category_name varchar(255)
);


INSERT INTO category (id, code, category_name)
VALUES (-1, 'Bev', 'Beverages');
INSERT INTO category (id, code, category_name)
VALUES (-2, 'Det', 'Detergent');


CREATE TABLE product
(
    id           bigint NOT NULL PRIMARY KEY,
    code         varchar(255),
    product_name varchar(255),
    description  varchar(255),
    category_id  bigint,
    FOREIGN KEY (category_id) REFERENCES category (id)
);


INSERT INTO product (id, code, product_name, description, category_id)
VALUES (-1, 'PR_1', 'Coca-Cola', '2L bottle', -1);
INSERT INTO product (id, code, product_name, description, category_id)
VALUES (-2, 'PR_2', 'Fanta', '2L bottle', -1);
INSERT INTO product (id, code, product_name, description, category_id)
VALUES (-3, 'PR_3', 'Dero', '1bag', -2);
