CREATE TABLE client
(
    id           bigint NOT NULL PRIMARY KEY,
    name         varchar(255),
    credit varchar(255),
    number_of_orders  bigint
);

INSERT INTO client (id, name, credit, number_of_orders) VALUES (-1, 'John Smith', 100, 2);
