use products;
create table product (
id serial primary key,
name varchar(200),
expired_date date,
price float
);

create table type (
id serial primary key,
name varchar(200)
);

create table product_type (
id serial primary key,
product_id int references products(id),
type_id int references type(id)
);

insert into product(name, expired_date, price) values('сыр Костромской', '2021-07-01', 250);
insert into product(name, expired_dare, price) values('колбаса Докторская', '2021-06-08', 200);
insert into product(name, expired_dare, price) values('сыр Ламбер', '2021-05-08', 220.0);
insert into product(name, expired_dare, price) values('сыр Ламбер', '2021-05-08', 220.0);
insert into product(name, expired_dare, price) values('сыр Ламбер', '2021-05-08', 220.0);
insert into product(name, expired_dare, price) values('сыр Ламбер', '2021-05-08', 220.0);
insert into product(name, expired_dare, price) values('сыр Ламбер', '2021-05-08', 220.0);
insert into product(name, expired_dare, price) values('сыр Ламбер', '2021-05-08', 220.0);
insert into product(name, expired_dare, price) values('сыр Ламбер', '2021-05-08', 220.0);
insert into product(name, expired_dare, price) values('сыр Ламбер', '2021-05-08', 220.0);
insert into product(name, expired_dare, price) values('сыр Ламбер', '2021-05-08', 220.0);
insert into product(name, expired_dare, price) values('сыр Ламбер', '2021-05-08', 220.0);
insert into product(name, expired_dare, price) values('сыр Маздам', '2021-06-08', 230.0);
insert into product(name, expired_dare, price) values('сыр Гауда', '2021-06-18', 270.0);
insert into product(name, expired_dare, price) values('колбаса Любительская', '2021-04-08', 290.0);
insert into product(name, expired_dare, price) values('молоко Домик в деревне', '2021-07-18', 90.0);
insert into product(name, expired_dare, price) values('молоко Домик в деревне', '2021-07-18', 90.0);
insert into product(name, expired_dare, price) values('молоко Домик в деревне', '2021-07-18', 90.0);
insert into product(name, expired_dare, price) values('молоко Домик в деревне', '2021-07-18', 90.0);
insert into product(name, expired_dare, price) values('молоко Домик в деревне', '2021-07-18', 90.0);
insert into product(name, expired_dare, price) values('молоко Домик в деревне', '2021-07-18', 90.0);
insert into product(name, expired_dare, price) values('молоко Домик в деревне', '2021-07-18', 90.0);
insert into product(name, expired_dare, price) values('молоко Домик в деревне', '2021-07-18', 90.0);
insert into product(name, expired_dare, price) values('молоко Домик в деревне', '2021-07-18', 90.0);
insert into product(name, expired_dare, price) values('молоко Домик в деревне', '2021-07-18', 90.0);
insert into product(name, expired_dare, price) values('молоко Домик в деревне', '2021-07-18', 90.0);
insert into product(name, expired_dare, price) values('молоко Матроскин', '2021-07-18', 85.0);
insert into product(name, expired_dare, price) values('молоко Матроскин', '2021-07-18', 85.0);
insert into product(name, expired_dare, price) values('молоко Матроскин', '2021-07-18', 85.0);
insert into product(name, expired_dare, price) values('молоко Матроскин', '2021-07-18', 85.0);
insert into product(name, expired_dare, price) values('молоко Матроскин', '2021-07-18', 85.0);
insert into product(name, expired_dare, price) values('молоко Матроскин', '2021-07-18', 85.0);
insert into product(name, expired_dare, price) values('молоко Матроскин', '2021-07-18', 85.0);
insert into product(name, expired_dare, price) values('молоко Parmalat', '2021-07-28', 105.0);
insert into product(name, expired_dare, price) values('мороженое Коровка из кореновки', '2021-05-07', 50.0);
insert into product(name, expired_dare, price) values('мороженое Чистая линия', '2021-08-07', 80.0);
insert into product(name, expired_dare, price) values('мороженое Магнат', '2021-08-18', 65.0);
insert into product(name, expired_dare, price) values('мороженое Магнат', '2021-08-18', 65.0);
insert into product(name, expired_dare, price) values('мороженое Магнат', '2021-08-18', 65.0);
insert into product(name, expired_dare, price) values('мороженое Магнат', '2021-08-18', 65.0);
insert into product(name, expired_dare, price) values('мороженое Магнат', '2021-08-18', 65.0);
insert into product(name, expired_dare, price) values('мороженое Maxibon', '2021-08-05', 100.0);
insert into product(name, expired_dare, price) values('мороженое Чистая линия', '2021-08-06', 80.0);
insert into product(name, expired_dare, price) values('мороженое Чистая линия', '2021-08-07', 80.0);
insert into product(name, expired_dare, price) values('мороженое Maxibon', '2021-08-05', 100.0);
insert into product(name, expired_dare, price) values('мороженое Maxibon', '2021-08-05', 100.0);
insert into product(name, expired_dare, price) values('мороженое Maxibon', '2021-08-05', 100.0);
insert into product(name, expired_dare, price) values('мороженое Maxibon', '2021-08-05', 100.0);


insert into type(name) values('Сыр');
insert into type(name) values('Колбаса');
insert into type(name) values('Мороженое');
insert into type(name) values('Молоко');

insert into product_type(product_id, type_id) values(1, 1);
insert into product_type(product_id, type_id) values(2, 2);
insert into product_type(product_id, type_id) values(3, 1);
insert into product_type(product_id, type_id) values(4, 1);
insert into product_type(product_id, type_id) values(5, 1);
insert into product_type(product_id, type_id) values(6, 1);
insert into product_type(product_id, type_id) values(7, 1);
insert into product_type(product_id, type_id) values(8, 1);
insert into product_type(product_id, type_id) values(9, 1);
insert into product_type(product_id, type_id) values(10, 1);
insert into product_type(product_id, type_id) values(11, 1);
insert into product_type(product_id, type_id) values(12, 1);
insert into product_type(product_id, type_id) values(13, 2);
insert into product_type(product_id, type_id) values(14, 4);
insert into product_type(product_id, type_id) values(15, 4);
insert into product_type(product_id, type_id) values(16, 4);
insert into product_type(product_id, type_id) values(17, 4);
insert into product_type(product_id, type_id) values(18, 4);
insert into product_type(product_id, type_id) values(19, 4);
insert into product_type(product_id, type_id) values(20, 4);
insert into product_type(product_id, type_id) values(21, 4);
insert into product_type(product_id, type_id) values(22, 4);
insert into product_type(product_id, type_id) values(23, 4);
insert into product_type(product_id, type_id) values(24, 4);
insert into product_type(product_id, type_id) values(25, 4);
insert into product_type(product_id, type_id) values(26, 4);
insert into product_type(product_id, type_id) values(27, 4);
insert into product_type(product_id, type_id) values(28, 4);
insert into product_type(product_id, type_id) values(29, 4);
insert into product_type(product_id, type_id) values(30, 4);
insert into product_type(product_id, type_id) values(31, 4);
insert into product_type(product_id, type_id) values(32, 4);
insert into product_type(product_id, type_id) values(33, 3);
insert into product_type(product_id, type_id) values(34, 3);
insert into product_type(product_id, type_id) values(35, 3);
insert into product_type(product_id, type_id) values(36, 3);
insert into product_type(product_id, type_id) values(37, 3);
insert into product_type(product_id, type_id) values(38, 3);
insert into product_type(product_id, type_id) values(39, 3);
insert into product_type(product_id, type_id) values(40, 3);
insert into product_type(product_id, type_id) values(41, 3);
insert into product_type(product_id, type_id) values(42, 3);
insert into product_type(product_id, type_id) values(43, 3);
insert into product_type(product_id, type_id) values(44, 3);
insert into product_type(product_id, type_id) values(45, 3);


----------------------------------------------------------------------------

CREATE TABLE `products`.`type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `products`.`product` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL,
    `type_id` INT NOT NULL,
    `expired_date` DATE NOT NULL,
    `price` VARCHAR(45) NULL,
    PRIMARY KEY (`id`));


 insert into `products`.`type`(name)
   values ('Сыр');
    insert into `products`.`type`(name)
   values ('Колбаса');
   insert into `products`.`type`(name)
   values ('Мороженое');
   insert into `products`.`type`(name)
   values ('Молоко');

insert into `products`.`product`(name, type_id, expired_date, price)
values ('сыр Костромской', '1', '2021-07-01', '250.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('сыр Костромской', '1', '2021-05-01', '250.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('сыр Костромской', '1', '2021-09-01', '250.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('сыр Костромской', '1', '2021-10-01', '250.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('сыр Костромской', '1', '2021-04-01', '250.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('сыр Ламберт', '1', '2021-09-01', '290.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('сыр Ламберт', '1', '2021-04-01', '290.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('сыр Ламберт', '1', '2021-02-01', '290.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('сыр Ламберт', '1', '2021-01-01', '290.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('сыр Ламберт', '1', '2021-06-01', '290.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('колбаса Любительская', '2', '2021-04-01', '190.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('колбаса Любительская', '2', '2021-08-01', '190.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('колбаса Любительская', '2', '2021-08-01', '190.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('колбаса Любительская', '2', '2021-08-01', '190.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('колбаса Любительская', '2', '2021-10-01', '190.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('колбаса Любительская', '2', '2021-04-01', '190.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('колбаса Любительская', '2', '2021-04-01', '190.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('колбаса Докторская', '2', '2021-04-01', '250.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('колбаса Докторская', '2', '2021-04-01', '250.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('колбаса Докторская', '2', '2021-09-01', '250.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('колбаса Докторская', '2', '2021-07-01', '250.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('колбаса Докторская', '2', '2021-03-01', '250.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('мороженое Чистая линия', '3', '2021-09-01', '50.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('мороженое Чистая линия', '3', '2021-09-01', '50.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('мороженое Чистая линия', '3', '2021-09-01', '50.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('мороженое Чистая линия', '3', '2021-06-01', '50.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('мороженое Чистая линия', '3', '2021-09-01', '50.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('мороженое Чистая линия', '3', '2021-04-01', '50.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('мороженое Чистая линия', '3', '2021-03-01', '50.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('мороженое Чистая линия', '3', '2021-08-01', '50.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('мороженое Коровка', '3', '2021-10-01', '90.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('мороженое Коровка', '3', '2021-09-01', '90.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('мороженое Коровка', '3', '2021-04-01', '90.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('мороженое Коровка', '3', '2021-05-01', '90.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('мороженое Коровка', '3', '2021-06-01', '90.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('мороженое Коровка', '3', '2021-07-01', '90.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('молоко Домик в деревне', '4', '2021-11-01', '80.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('молоко Домик в деревне', '4', '2021-11-01', '80.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('молоко Домик в деревне', '4', '2021-07-01', '80.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('молоко Домик в деревне', '4', '2021-11-01', '80.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('молоко Домик в деревне', '4', '2021-04-01', '80.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('молоко Домик в деревне', '4', '2021-05-01', '80.00');
insert into `products`.`product`(name, type_id, expired_date, price)
values ('молоко Домик в деревне', '4', '2021-06-01', '80.00');

--сыр
SELECT p.id, p.name as 'Наименование', t.name as 'Тип' from products.product as p
join products.type as t on p.type_id = t.id
where  t.name like 'Сыр'


--истек срок годности
SELECT * FROM products.product
where expired_date < CURRENT_DATE();

--самый дорогой продукт
SELECT * FROM products.product
where price = (SELECT Max(price) FROM products.product);

--сыр и молоко
SELECT p.id, p.name as 'Наименование', t.name as 'Тип' from products.product as p
join products.type as t on p.type_id = t.id
where  t.name in ('Сыр', 'Молоко')


--содержит слово мороженое
SELECT * FROM products.product
where name like '%м%о%р%о%ж%е%н%о%е%';

--выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество
SELECT  t.name as 'Тип продукта', COUNT(*) as 'Количество' FROM products.product as p
join products.type as t on t.id = p.type_id
group by t.name;

--выводит тип продуктов, которых осталось меньше 10 штук
SELECT type_id, count(type_id) FROM products.product
group by type_id
having count(type_id) < 10;

--Вывести все продукты и их тип
SELECT p.id as 'id', p.name as 'название продукта', t.name as 'тип продукта' FROM products.product as p
join products.type as t on  t.id = p.type_id
group by p.id;