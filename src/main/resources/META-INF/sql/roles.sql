INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');
INSERT INTO roles (name) VALUES ('READER');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 3);
INSERT INTO users_roles (user_id, role_id) VALUES (3, 3);
INSERT INTO users_roles (user_id, role_id) VALUES (4, 3);
