INSERT INTO client(id, name) VALUES (1000, 'John Terry');
INSERT INTO client(id, name) VALUES (2000, 'Barry More');
INSERT INTO client(id, name) VALUES (3000, 'Thomas Great');

INSERT INTO hotel(id, name) VALUES (1000, 'Kapama River Lodge');
INSERT INTO hotel(id, name) VALUES (2000, 'South Beach Camps Bay Boutique Hotel');
INSERT INTO hotel(id, name) VALUES (3000, 'Akademie Street Boutique Hotel');
INSERT INTO hotel(id, name) VALUES (4000, 'Blackheath Lodge');
INSERT INTO hotel(id, name) VALUES (5000, 'Derwent House Boutique Hotel');

INSERT INTO RESERVATION (id, room, price, rooms, persons, children, open_Buffet, arrival_Date, departure_Date, stay_Days, client_id) VALUES (1000, 'S50', 250, 2, 2, 2, 'Y', '2023-04-09', '2023-04-16', 7, 1000);
INSERT INTO RESERVATION (id, room, price, rooms, persons, children, open_Buffet, arrival_Date, departure_Date, stay_Days, client_id) VALUES (2000, 'S51', 250, 1, 1, 2, 'N', '2023-04-19', '2023-04-25', 6, 1000);
INSERT INTO RESERVATION (id, room, price, rooms, persons, children, open_Buffet, arrival_Date, departure_Date, stay_Days, client_id) VALUES (3000, 'S53', 150, 1, 1, 0, 'N', '2023-04-30', '2023-05-14', 14, 2000);
