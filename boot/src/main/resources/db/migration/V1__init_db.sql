CREATE table prices (
    brand_id int8 NOT NULL,
    start_date timestamp NOT NULL,
    end_date timestamp NOT NULL,
    price_list SERIAL PRIMARY KEY,
    product_id int8 NOT NULL,
    priority int8 NOT NULL,
    price float8 NOT NULL,
    curr varchar(255) NOT NULL
);
INSERT INTO prices
(brand_id, start_date, end_date, product_id, priority, price, curr)
VALUES
(1,'2020-06-14 00:00:00.000','2020-12-31 23:59:59.000',35455,0,35.50,'EUR'),
(1,'2020-06-14 15:00:00.000','2020-06-14 18:30:00.000',35455,1,25.45,'EUR'),
(1,'2020-06-15 00:00:00.000','2020-06-15 11:00:00.000',35455,1,30.50,'EUR'),
(1,'2020-06-15 16:00:00.000','2020-12-31 23:59:59.000',35455,1,38.95,'EUR');
