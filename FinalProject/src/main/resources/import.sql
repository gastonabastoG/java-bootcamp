INSERT INTO category (description, name) VALUES('Smartphones, etc', 'Celulares');
INSERT INTO category (description, name) VALUES('Smart TV, LCD, Plasma, etc', 'Televisores');
INSERT INTO category (description, name) VALUES('Mouse, Teclados, etc', 'Perifericos');

INSERT INTO product (description, name, price, quantity, category_id) VALUES('Nuevo IPhone', 'IPhone 6', 499.99, 10, 1);
INSERT INTO product (description, name, price, quantity, category_id) VALUES('Smart Samsung 46 pulgadas', 'Smart TV Samsung 6810', 1249.99, 5, 2);
INSERT INTO product (description, name, price, quantity, category_id) VALUES('Keyboard Wireless', 'Alienware', 39.99, 50, 3);

INSERT INTO user (address, firstname, lastname, mail, password, username) VALUES ('Calle Falsa 1234', 'James', 'Bond', 'james@007.com', 'licensetokill', 'James007');
INSERT INTO user (address, firstname, lastname, mail, password, username) VALUES ('123 Washington Street', 'Lebron', 'James', 'lebron@nba.com', 'Slamdunk', 'LebronNBA');
INSERT INTO user (address, firstname, lastname, mail, password, username) VALUES ('47 Otra calle falsa', 'Bart', 'Simpson', 'elbarto@springfield.com', 'elbarto', 'milhouse');

INSERT INTO creditcard (bank, brand, expdate, number, ownername,user_id) VALUES('ICBC', 'VISA', '2014-11-11', '4444-4444-4444-4444', 'Charles Barkley',1);
INSERT INTO creditcard (bank, brand, expdate, number, ownername,user_id) VALUES('Banco Frances', 'Master', '1987-10-11', '4444-4444-4444-4444', 'Patrick Ewing',2);
INSERT INTO creditcard (bank, brand, expdate, number, ownername,user_id) VALUES('Santander Rio', 'VISA', '2015-09-11', '4444-4444-4444-4444', 'Larry Bird',3);


INSERT INTO shoppingcart (user_id) VALUES(1);
INSERT INTO shoppingcart (user_id) VALUES(2);


INSERT INTO product_line (quantity, subtotal, product_id, shoppingcart_id) VALUES(2, 999.98, 1, 1);
