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


INSERT INTO meals (datetime, description, calories, user_Id) VALUES
  ('2015-06-02 14:00', 'Юзер ланч', 510, 100000),
  ('2015-06-03 14:00', 'Юзер ланч 2', 510, 100000),
  ('2015-06-01 14:00', 'Админ ланч', 110, 100001);
