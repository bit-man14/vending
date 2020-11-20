INSERT INTO users (email, name, password, active) VALUES ('tom@gmail.com','Tom', '$2a$10$BG4Khz7k/8pS0JyU4WI0CeiDDGeXREmffzAA9xwU91o5Clu9QKNPe', TRUE);
INSERT INTO users (email, name, password, active) VALUES ('tom1@gmail.com','Adam', '$2a$10$BG4Khz7k/8pS0JyU4WI0CeiDDGeXREmffzAA9xwU91o5Clu9QKNPe', TRUE);
INSERT INTO users (email, name, password, active) VALUES ('tom2@gmail.com','Guest', '$2a$10$BG4Khz7k/8pS0JyU4WI0CeiDDGeXREmffzAA9xwU91o5Clu9QKNPe', TRUE);
INSERT INTO users (email, name, password, active) VALUES ('tom3@gmail.com','Józek', '$2a$10$BG4Khz7k/8pS0JyU4WI0CeiDDGeXREmffzAA9xwU91o5Clu9QKNPe', FALSE);
INSERT INTO `roles` (`name`) VALUES ('ADMIN');
INSERT INTO `roles` (`name`) VALUES ('EDITOR');
INSERT INTO `roles` (`name`) VALUES ('READER');
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 3);
INSERT INTO users_roles (user_id, role_id) VALUES (3, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (4, 3);
INSERT INTO pack_shape (name) VALUES ('can');
INSERT INTO pack_shape (name) VALUES ('bottle');
INSERT INTO pack_shape (name) VALUES ('pouch');
INSERT INTO pack_shape (name) VALUES ('box');
INSERT INTO pack_shape (name) VALUES ('bar');
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Pepsi', 1,5,2.50);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Fanta', 1,5,2.50);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Sprite', 1,5,2.50);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Pepsi', 2,5,2.50);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Red Bull', 1,5,2.50);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Sok jabłkowy', 4,8,1.00);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Sok owocowy', 4,8,1.00);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Słonecznik', 3,8,2.50);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('3Bit', 5,8,1.50);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('4move', 2,5,2.50);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Black', 1,5,2.50);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Sprite', 1,5,2.50);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Pepsi', 2,5,2.50);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Red Bull', 2,5,2.50);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Sok pomarańczowy', 4,8,1.00);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Sok wiśniowy', 4,8,1.00);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Słonecznik łuskany', 3,8,2.50);
INSERT INTO products (name, packshape_id, for_spiral_size,price) VALUES ('Mars', 5,8,1.50);