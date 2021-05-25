create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values('samsung galaxy s9', 75000.0);
insert into devices(name, price) values('samsung galaxy s10', 90120.0);
insert into devices(name, price) values('samsung galaxy note', 110190.0);
insert into devices(name, price) values('apple iphone 11', 115230.0);
insert into devices(name, price) values('nokia 3310', 1110.0);

insert into people(name) values('Ivan');
insert into people(name) values('Petr');
insert into people(name) values('Konstantin');
insert into people(name) values('Sergey');
insert into people(name) values('Alex');
insert into people(name) values('Nikolay');
insert into people(name) values('Georgy');

insert into devices_people(device_id, people_id) values(1, 3);
insert into devices_people(device_id, people_id) values(2, 2);
insert into devices_people(device_id, people_id) values(3, 1);
insert into devices_people(device_id, people_id) values(4, 6);
insert into devices_people(device_id, people_id) values(5, 7);

select avg(price) from devices
having avg(price) > 5000;

