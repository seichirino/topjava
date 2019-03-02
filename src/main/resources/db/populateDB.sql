DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (description, date_time, calories, user_id) VALUES
('dinnah', '2019-03-10 19:10:25', 500, 100000),
('suppah', '2019-03-10 20:10:25', 1500, 100000),
('ah yes, the DESERT', '2019-03-10 21:10:25', 3000, 100000),
('KING dinnah', '2019-03-10 19:10:25', 500, 100001),
('KING suppah', '2019-03-10 20:10:25', 1500, 100001),
('ah yes, the KING DESERT', '2019-03-10 21:10:25', 3000, 100001)