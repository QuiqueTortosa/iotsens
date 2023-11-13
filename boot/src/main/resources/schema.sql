CREATE TABLE IF NOT EXISTS PRICES (
	brand_id int8 NOT NULL,
	start_date timestamp NOT NULL,
	end_date timestamp NOT NULL,
    price_list int8 AUTO_INCREMENT PRIMARY KEY,
	product_id int8 NOT NULL,
	priority int8 NOT NULL,
	price DOUBLE NOT NULL,
	curr varchar(255) NOT NULL
	);