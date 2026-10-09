CREATE TABLE product
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    code        VARCHAR(20) NOT NULL,
    description VARCHAR     NOT NULL,
    price       FLOAT       NOT NULL
);


CREATE TABLE subsidiary
(
    id   INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR NOT NULL
);


CREATE TABLE orders
(
    id            INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    subsidiary_id INTEGER REFERENCES subsidiary NOT NULL,
    created_at    DATE                          NOT NULL,
    total         FLOAT                         NOT NULL

);

CREATE TABLE order_product
(
    id         INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    order_id   INTEGER REFERENCES orders  NOT NULL,
    product_id INTEGER REFERENCES product NOT NULL

)