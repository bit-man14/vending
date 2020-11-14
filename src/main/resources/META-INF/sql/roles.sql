# INSERT INTO roles (role_id, name) VALUES (1, 'ADMIN');
# INSERT INTO roles (role_id, name) VALUES (2, 'USER');
# INSERT INTO roles (role_id, name) VALUES (3, 'READER');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 3);
INSERT INTO users_roles (user_id, role_id) VALUES (3, 3);
INSERT INTO users_roles (user_id, role_id) VALUES (4, 3);
