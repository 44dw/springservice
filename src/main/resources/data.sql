insert into clients (name, surname, telephone)
values('Дмитрий', 'Ахметшин', '9379951686');

insert into clients (name, surname, telephone)
values('Екатерина', 'Ахметшина', '9277410328');

insert into clients (name, surname, telephone)
values('Наталья', 'Лисянская', '9288542216');

insert into orders (description, create_date, finish_date, cost, status, client_id)
values('перебрать коленвал', '2018-01-25', '2019-04-08', 2500, 'SHEDULED', 1);

insert into orders (description, create_date, finish_date, cost, status, client_id)
values('перетянуть сиденья', '2019-01-14', '2019-04-17', 3000, 'DONE', 2);

insert into orders (description, create_date, finish_date, cost, status, client_id)
values('перебрать сцепление', '2018-12-01', '2019-03-22', 15000, 'SHEDULED', 2);