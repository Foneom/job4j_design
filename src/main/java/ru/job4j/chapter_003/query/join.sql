create table breed (
id serial primary key,
name varchar(2555),
color varchar(2555)
);

create table dogs (
id serial primary key,
name varchar(2550),
breed_id int references breed(id)
);

insert into breed(name, color) values ('Ovcharka', 'brown');
insert into breed(name, color) values ('Pit-Bull', 'black');
insert into breed(name, color) values ('Chihua - hua', 'white');
insert into breed(name, color) values ('Buldog', 'grey');

insert into dogs(name, breed_id) values ('Ramzes', 3);
insert into dogs(name, breed_id) values ('Dik', 1);
insert into dogs(name, breed_id) values ('Sharik', 4);
insert into dogs(name, breed_id) values ('Jack', 2);
insert into dogs(name) values ('Jhony');
insert into dogs(name) values ('Dona');


select p.id 'id', p.name 'Кличка', ps.id 'id', ps.name 'Порода', ps.color 'Цвет'
from dogs p
inner join breed ps on ps.id = p.breed_id;


select p.id 'id', p.name 'Кличка', ps.id 'id', ps.name 'Порода', ps.color 'Цвет'
from dogs p
left outer join breed ps on ps.id = p.breed_id;


select p.id 'id', p.name 'Кличка', ps.id 'id', ps.name 'Порода', ps.color 'Цвет'
from dogs p
right outer join breed ps on ps.id = p.breed_id;