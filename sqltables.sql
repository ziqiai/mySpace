Database: myshoppingcart
Tables & Classes:
 - products
 - users
 - cart
 - wishlist
 - items (only class - for user-select products, not products in store)

create table products (
	id int primary key auto_increment,
	name varchar(30),
	price double,
	image varchar(30)
);

create table users (
	id int primary key auto_increment,
	username varchar(30),
	password varchar(30)
);

create table cart (
	uid int,
	pid int,
	quantity int,
	image varchar(30)
);

create table wishlist (
	uid int,
	pid int,
	image varchar(30)
);

-- create table items (
-- 	pid int,
-- 	quantity int,
-- 	image varchar(50)
-- );

