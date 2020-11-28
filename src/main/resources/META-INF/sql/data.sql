#increment for Heroku
#machines
SET @@auto_increment_increment=1;
INSERT INTO machines (name, serial, type, inst_date, shelves, slots_per_shelf) VALUES ('Rondo', '123456', 'spiralki', '2020-01-01', 6, 8);
INSERT INTO machines (name, serial, type, inst_date, shelves, slots_per_shelf) VALUES ('Eva', '987654', 'drinks', '2019-01-01',1,10);
#users
SET @@auto_increment_increment=1;
INSERT INTO users (email, name, password, active) VALUES ('tom@gmail.com','Tom', '$2a$10$BG4Khz7k/8pS0JyU4WI0CeiDDGeXREmffzAA9xwU91o5Clu9QKNPe', TRUE);
INSERT INTO users (email, name, password, active) VALUES ('tom1@gmail.com','Adam', '$2a$10$BG4Khz7k/8pS0JyU4WI0CeiDDGeXREmffzAA9xwU91o5Clu9QKNPe', TRUE);
INSERT INTO users (email, name, password, active) VALUES ('tom2@gmail.com','Guest', '$2a$10$BG4Khz7k/8pS0JyU4WI0CeiDDGeXREmffzAA9xwU91o5Clu9QKNPe', TRUE);
INSERT INTO users (email, name, password, active) VALUES ('tom3@gmail.com','Józek', '$2a$10$BG4Khz7k/8pS0JyU4WI0CeiDDGeXREmffzAA9xwU91o5Clu9QKNPe', FALSE);
INSERT INTO users (email, name, password, active) VALUES ('admin@admin.com','Admin', '$2a$10$fZN1YKQJNwiGHsAQyiWRfOLlJV8zSr2iKh6u52PKVVyMc7siG.QSG', TRUE);
#possible roles
SET @@auto_increment_increment=1;
INSERT INTO `roles` (`name`) VALUES ('ADMIN');
INSERT INTO `roles` (`name`) VALUES ('USER');
INSERT INTO `roles` (`name`) VALUES ('READER');
#roles for demo only
SET @@auto_increment_increment=1;
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 3);
INSERT INTO users_roles (user_id, role_id) VALUES (3, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (4, 3);
INSERT INTO users_roles (user_id, role_id) VALUES (5, 1);
#possible package shape
SET @@auto_increment_increment=1;
INSERT INTO pack_shape (name) VALUES ('can');
INSERT INTO pack_shape (name) VALUES ('bottle');
INSERT INTO pack_shape (name) VALUES ('pouch');
INSERT INTO pack_shape (name) VALUES ('box');
INSERT INTO pack_shape (name) VALUES ('bar');
INSERT INTO pack_shape (name) VALUES ('cup');
INSERT INTO pack_shape (name) VALUES ('---empty---');
#available products
SET @@auto_increment_increment=1;
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('---empty---', 7,6,0.1);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Paluszki', 3,10,2);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Krakersy', 3,10,2.5);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Chipsy', 3,10,3);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('7Days', 3,10,3);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Nestle', 5,15,1.5);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Lion', 5,15,2);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('3Bit', 5,15,2);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Dropsy', 5,15,2.5);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Góralki', 5,15,2);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Frugo zielone', 2,5,2);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Frugo pomarańczowe', 2,5,2);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Żelki', 3,8,2);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Woda niegazowana', 2,5,2);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Woda gazowana', 2,5,2);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Aquarius napój', 2,5,2.5);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Fuze tea', 2,5,4);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Oshee', 2,5,4);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Coca Cola', 2,5,4);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Słonecznik solony łuskany', 3,8,2.5);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Słonecznik paprykowy łuskany', 3,8,2.5);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Oranżada czerwona', 2,5,2.5);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Oranżada biała', 2,5,2.5);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Tymbark cytrynowy', 2,5,3);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Tymbark brzoskwiniowy', 2,5,3);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Tymbark wiśniowy', 2,5,3);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Tymbark malinowy', 2,5,3);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Powerade', 2,5,3.5);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Mus owocowy', 3,8,2.5);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Woda dla dzieci', 2,8,2);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Tymbark arbuz', 1,8,2.5);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Tymbark pomarańcza', 1,8,2.5);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Tymbark cytryna', 1,8,2.5);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('4Move', 1,8,3);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Engine', 1,8,3);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Black', 1,8,4);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Red Bull', 1,8,5);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Lipton cytryna', 1,8,2.8);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Lipton brzoskwinia', 1,8,2.8);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Lipton green tea', 1,8,2.8);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Pepsi', 1,8,2.8);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Sok owocowy', 4,8,1);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Sok jabłkowy', 4,8,1);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Pusty kubek', 6,1,1.8);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Barszcz', 6,1,1.8);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Herbata cytrynowa', 6,1,1.8);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Herbata Earl Grey', 6,1,1.8);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Mleko', 6,1,1.8);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Espresso', 6,1,1.8);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Kawa czarna', 6,1,1.8);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Kawa czarna z mlekiem', 6,1,1.8);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Czekolada', 6,1,1.8);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Czekolada z mlekiem', 6,1,1.8);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Kawa z czekoladą', 6,1,1.8);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Kawa z czekoladą i mlekiem', 6,1,1.8);
#slot assignment
SET @@auto_increment_increment=1;
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (false, 1,10,1,0);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,11,2,10);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (false, 1,12,1,0);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,13,2,10);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (false, 1,14,1,0);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,15,3,10);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (false, 1,16,1,0);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,17,4,10);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,20,5,15);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,21,6,15);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,22,7,15);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,23,8,15);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,24,9,15);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,25,10,5);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,26,11,5);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,27,12,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,30,13,5);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,31,14,5);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,32,15,5);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,33,16,5);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,34,17,5);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,35,18,5);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,36,19,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,37,20,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,40,21,5);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,41,22,5);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,42,23,5);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,43,24,5);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,44,25,5);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,45,26,5);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,46,27,5);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,47,28,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,50,29,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,51,30,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,52,31,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,53,32,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,54,33,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,55,34,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,56,35,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,57,36,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,60,37,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,61,38,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,62,39,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,63,40,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,64,41,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,65,42,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true, 1,66,43,8);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true,2,1,44,1);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true,2,2,45,1);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true,2,3,46,1);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true,2,4,47,1);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true,2,5,48,1);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true,2,6,49,1);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true,2,7,50,1);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true,2,8,51,1);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true,2,9,52,1);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true,2,10,53,1);
INSERT INTO slot_config (is_active,machine_id, slot_no, product_id, spiral_size) VALUES (true,2,11,54,1);

