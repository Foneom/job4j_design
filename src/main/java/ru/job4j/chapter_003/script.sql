create schema job4j;

use job4j;

create table user (
    -> userId int not null auto_increment,
    -> userName varchar(30),
    -> roleId int references role(id),
    -> primary key(userId)
);

create table role (
    -> id int not null auto_increment,
    -> name varchar(30),
    -> primary key(id)
);

 create table rules (
    -> id int not null auto_increment,
    -> name varchar(30),
    -> primary key(id)
);

create table roleRules (
    -> roleId int references role(id),
    -> ruleId int references rules(id),
    -> primary key(roleId, ruleId)
);

 create table item (
    -> id int not null auto_increment,
    -> name varchar(30),
    -> userId int references user(userId),
    -> categoryId int references category(id),
    -> stateId int references state(id),
    -> primary key(id)
);

 create table comments (
    -> id int not null auto_increment,
    -> name varchar(30),
    -> itemId int references item(id),
    -> primary key(id));

create table attachs (
    -> id int not null auto_increment,
    -> name varchar(30),
    -> itemId int references item(id),
    -> primary key(id)
);

create table category (
    -> id int not null auto_increment,
    -> name varchar(30),
    -> primary key(id));

create table state (
    -> id int not null auto_increment,
    -> name varchar(30),
    -> primary key(id)
);

 insert into user(userName, roleId)
    -> values('Alex', 1);

 insert into role(name)
    -> values('editor');

  insert into rule(name)
    -> values('data editing');

   insert into roleRule(roleId, ruleId)
    -> values(1, 1);

    insert into item(name, userId, categoryId, stateId)
    -> values('x001', 1, 1, 1);

 insert into comments(name, itemId)
    -> values('installation of the program', 1);

insert into attaches(name, itemId)
    -> values('msOffice.exe', 1);

insert into category(name)
    -> values('it')

insert into state(name)
    -> values('done')
