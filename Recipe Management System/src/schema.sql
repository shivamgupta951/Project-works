create database Recipe_manager_system;
use Recipe_manager_system;
create table if not exists user_information(
Email varchar(50) not null default "Not Set",
Dob Date default null,
Username varchar(40) not null default "Not Set",
Name varchar(30) default "Not Set",
Phone_number int primary key default 0,
RMS_password varchar(50) default "Not Set",
Profession varchar(30) default "Not Set",
State varchar(60) default "Not Set",
Premium_status varchar(10) default "Not Set",
Acc_id varchar(20),
Total_Accounts_Count int default 1000000
);
select * from user_information;
create table if not exists EXT(
counts int default 0,
Acc_id varchar(20) primary key,
Location varchar(40) default "Not Set",
Date_registered date default null,
status varchar(20) default "Not Set",
Phone_number int,
foreign key (Phone_number) REFERENCES user_information(Phone_number)
);
create table if not exists YIN(
counts int,
Acc_id varchar(20) primary key,
Location varchar(40),
Date_registered date,
status varchar(20),
Phone_number int,
foreign key (Phone_number) REFERENCES user_information(Phone_number)
);
create table if not exists SBT(
counts int,
Acc_id varchar(20) primary key,
Location varchar(40),
Date_registered date,
status varchar(20),
Phone_number int,
foreign key (Phone_number) REFERENCES user_information(Phone_number)
);
create table if not exists TRS(
counts int,
Acc_id varchar(20) primary key,
Location varchar(40),
Date_registered date,
status varchar(20),
Phone_number int,
foreign key (Phone_number) REFERENCES user_information(Phone_number)
);
create table if not exists PNT(
counts int,
Acc_id varchar(20) primary key,
Location varchar(40),
Date_registered date,
status varchar(20),
Phone_number int,
foreign key (Phone_number) REFERENCES user_information(Phone_number)
);
create table if not exists bookmarked_recipies_data(
Acc_id varchar(20),
Recipes_id varchar(20),
Recipe_type varchar(20),
Recipe_name varchar(50)
);
create table if not exists Normal_recipes_id(
Recipe_id varchar(20) primary key,
Rating int
);
create table if not exists Premium_recipes_id(
Recipe_id varchar(20) primary key,
Rating int
);
create table if not exists password_storage(
Passwords varchar(50) default "Not Set",
Acc_id varchar(20) default "Not Set",
Email varchar(50) default "Not Set",
Acc_type varchar(20) default "Not Set",
Phone_number int not null
);
create table if not exists personalised_recipes_ids(
Personalised_recipes_id varchar(20) primary key,
Acc_id varchar(20)
);
create table if not exists Personalized_recipes(
Recipe_name varchar(100),
Recipe_Process varchar(10000),
Recipe_ingrediants varchar(5000),
personalised_recipe_id varchar(20) primary key,
original_recipe_id varchar(20),
Acc_id int
);
create table if not exists Normal_recipes(
Recipe_name varchar(100),
Recipe_Process varchar(10000),
Recipe_ingrediants varchar(5000),
recipe_id varchar(20)
);
create table if not exists Premium_recipes(
Recipe_name varchar(100),
Recipe_process varchar(10000),
Recipe_ingrediants varchar(5000),
recipe_id varchar(20)
);
