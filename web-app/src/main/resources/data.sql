insert into products (id, name, quilograms, deliver_date, price) values('prod1', 'taronges', 10, VALUES(TO_DATE('17/12/2015', 'DD/MM/YYYY'), 20.2);
insert into products (id, name, quilograms, deliver_date, price) values('prod2', 'patates', 20, VALUES(TO_DATE('17/12/2015', 'DD/MM/YYYY'), 10.2);
insert into products (id, name, quilograms, deliver_date, price) values('prod3', 'pomes', 30, VALUES(TO_DATE('17/12/2015', 'DD/MM/YYYY'), 30.2);
insert into products (id, name, quilograms, deliver_date, price) values('prod4', 'maduixes', 40, VALUES(TO_DATE('17/12/2015', 'DD/MM/YYYY'), 80.2);



insert into consumers (id, name, address, email, dni) values('cons1', 'Restaurant TecnoCampus', 'Parc TecnoCampus Mataró-Maresme, Carrer dErnest Lluch, 32, 08302 Mataró, Barcelona', 'restauranttecnocampus@correupersonal.cat', '99999999A');
insert into consumers (id, name, address, email, dni) values('cons2', 'Restaurant Mataró', 'Parc TecnoCampus Mataró-Maresme, Carrer dErnest Lluch, 32, 08302 Mataró, Barcelona', 'restaurantmataro@correupersonal.cat', '99999999A');

insert into farmers (id, name, address, email, dni) values('farm1', 'Granjer Cinc Sénies', 'Parc TecnoCampus Mataró-Maresme, Carrer dErnest Lluch, 32, 08302 Mataró, Barcelona', 'granjercincsenies@correupersonal.cat', '99999999A');
insert into farmers (id, name, address, email, dni) values('farm2', 'Granjer Can Puça', 'Camí de Les Cinc Sénies, 08302 Mataró, Barcelona', 'granjercanpuca@correupersonal.cat', '99999999A');



insert into organic_lots (id, quilograms, deliver_date, done_date, state) values('org1', 10, VALUES(TO_DATE('17/12/2015', 'DD/MM/YYYY'), VALUES(TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'delivered');

insert into organic_lots (id, quilograms, deliver_date, done_date, state) values('org1', 10, VALUES(TO_DATE('17/12/2015', 'DD/MM/YYYY'), VALUES(TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'started_compostage');

insert into organic_lots (id, quilograms, deliver_date, done_date, state) values('org1', 10, VALUES(TO_DATE('17/12/2015', 'DD/MM/YYYY'), VALUES(TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'finished_compostage');

insert into organic_lots (id, quilograms, deliver_date, done_date, state) values('org1', 10, VALUES(TO_DATE('17/12/2015', 'DD/MM/YYYY'), VALUES(TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'product_finished');