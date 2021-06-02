
SET REFERENTIAL_INTEGRITY FALSE;


INSERT INTO NEWS (id, subject, content, date_time) VALUES (2, 'Wesołych świąt', 'Wesołych świąt 😊. Plan na tydzień wt. 18.00 czt. 18.00 pt 18.00 boisko w Objezierza, sobota na dzień dzisiejszy mecz ligowy. Proszę o 100% frekwencji. Pozdrawiam do zobaczenia', LOCALTIME);
INSERT INTO NEWS (id, subject, content, date_time) VALUES (3, 'Aktualizacja', 'Tak jak wczoraj Panowie jutro gra kontrolna w Obornikach ze Sparta. Proszę o frekwencję żebyśmy się mocno postawili Sparcie. Żeby się było tak jak ostatnio. Naprawdę czy tak trudno znaleźć czas na 2 godz panowie nie róbmy sobie jaj naprawdę. Mamy wszystko od prezesa przyszły dresy plecaki co jeszcze chcecie? Pozdrawiam', LOCALTIME);
INSERT INTO NEWS (id, subject, content, date_time) VALUES (4, 'Gra kontrolna', 'content', LOCALTIME);
INSERT INTO NEWS (id, subject, content, date_time) VALUES (5, 'Plan', 'Plan na tydzień wt 17.00 czt 17.00 stadion Objezierze bez korzystania sztatni. Proszę o obecność bo ostatnio co nie którzy robią sobie jaja z kolegów którzy napierdal...... Pozdrawiam', LOCALTIME);
INSERT INTO NEWS (id, subject, content, date_time) VALUES (6, 'Kadra', 'Panowie pierwszy mecz u siebie po przerwie zimowej przeciwnikiem Suchary Suchy Las. Zbiórka 14.30 szatnia nr.6 o 14.45 zaczynam odprawę. Jestem tego przekonany, jeśli zagramy tak jak z Meblorzem to 3 pkt zostaną w Objezierzu. Kadra na jutrzejsze spotkanie: Dębniak, Wrzeszcz, Kaźmierczak, Chudziński W, Piszczek, Karasiewicz, Janowiak, Stachowiak F, Matczak H, Piotrowicz, Morka, Wota, Chudziński T, Rybczyński, Wiśniewski, Matczak J, Senger, Garcon, Pyrzowski, Adamczyk. Do zobaczenia.', LOCALTIME);

INSERT INTO TEAM (team_id, name, gp, w, d, l, gs, gl, pts) VALUES (1,'Orkan Objezierze', 2, 0, 3, 5, 6, 0, 6);
INSERT INTO TEAM (team_id, name, gp, w, d, l, gs, gl, pts) VALUES (2,'Real Madrid', 2, 0, 3, 5, 6, 0, 2);
INSERT INTO TEAM (team_id, name, gp, w, d, l, gs, gl, pts) VALUES (3,'Tulisia', 2, 0, 3, 5, 6, 0, 6);
INSERT INTO TEAM (team_id, name, gp, w, d, l, gs, gl, pts) VALUES (4,'Chelsea Londyn', 2, 0, 3, 5, 6, 0, 1);
INSERT INTO TEAM (team_id, name, gp, w, d, l, gs, gl, pts) VALUES (5,'Stal Mielec', 2, 0, 3, 5, 6, 0, 4);
INSERT INTO TEAM (team_id, name, gp, w, d, l, gs, gl, pts) VALUES (6,'Amica Wronki', 2, 0, 3, 5, 6, 0, 3);

INSERT INTO MATCH (id, date, goals_scored, goals_lost, guest, home, result) VALUES (1, LOCALTIME, 2, 1, 'Real Madryt', 'Chelsea', 1);
INSERT INTO MATCH (id, date, goals_scored, goals_lost, guest, home, result) VALUES (2, LOCALTIME, 1, 4, 'Stal Mielec', 'Tulisia', 1);
INSERT INTO MATCH (id, date, goals_scored, goals_lost, guest, home, result) VALUES (3, LOCALTIME, 2, 2, 'Liverpool', 'Man City', 1);
INSERT INTO MATCH (id, date, goals_scored, goals_lost, guest, home, result) VALUES (4, LOCALTIME, 2, 3, 'Legia', 'Lech', 2);
INSERT INTO MATCH (id, date, goals_scored, goals_lost, guest, home, result) VALUES (5, LOCALTIME, 0, 1, 'Orkan', 'Amica', 1);

INSERt INTO  CLUB (club_id, name, coach_id, manager_id) VALUES (1, 'orkan', 1, 1);
INSERT INTO  MANAGER (username, password) VALUES ('man', '123');
INSERT INTO COACH (username, password, club_id) VALUES ('coach', 123, 1);

INSERT INTO PLAYER (player_id, name, surname, age, weight, height, sprint60m, vertical_jump, beep_test, push_ups_in_row, last_test_date,
                    goals_scored, assists, pass_percentage, interceptions, yellow_cards, red_cards, games_played, position, is_injured, is_suspended, rating)
VALUES (1, 'Tomasz', 'Kunica', 21, 80, 180, 12, 130, 16, 2, {ts '2012-09-17 18:47:52.69'}, 2, 4, 80, 4, 1, 0, 2, 'rb', false, false, 8);

INSERT INTO PLAYER (player_id, name, surname, age, weight, height, sprint60m, vertical_jump, beep_test, push_ups_in_row, last_test_date,
                    goals_scored, assists, pass_percentage, interceptions, yellow_cards, red_cards, games_played, position, is_injured, is_suspended, rating, username, password, club_id)
VALUES (2, 'Stefan', 'Lysy', 21, 80, 180, 12, 130, 16, 2, {ts '2012-09-17 18:47:52.69'}, 5, 6, 81, 2, 10, 3, 12, 'cb1', false, false, 7.3, 'stef', '123', 1);

INSERT INTO PLAYER (player_id, name, surname, age, weight, height, sprint60m, vertical_jump, beep_test, push_ups_in_row, last_test_date,
                    goals_scored, assists, pass_percentage, interceptions, yellow_cards, red_cards, games_played, position, is_injured, is_suspended, rating)
VALUES (3, 'Frank', 'Spinacchi', 21, 93, 188, 10, 131, 13, 100, {ts '2012-09-17 18:47:52.69'}, 0, 14, 82, 10, 1, 10, 2, 'cb2', false, false, 9.3);

INSERT INTO PLAYER (player_id, name, surname, age, weight, height, sprint60m, vertical_jump, beep_test, push_ups_in_row, last_test_date,
                    goals_scored, assists, pass_percentage, interceptions, yellow_cards, red_cards, games_played, position, is_injured, is_suspended, rating)
VALUES (4, 'Jarosław', 'Fojut', 34, 90, 180, 2, 155, 10, 12, {ts '2012-09-17 18:47:52.69'}, 3, 2, 71, 4, 1, 0, 2, 'lb', false, false, 6.5);

INSERT INTO PLAYER (player_id, name, surname, age, weight, height, sprint60m, vertical_jump, beep_test, push_ups_in_row, last_test_date,
                    goals_scored, assists, pass_percentage, interceptions, yellow_cards, red_cards, games_played, position, is_injured, is_suspended, rating)
VALUES (5, 'Lech', 'Roch Pawlak', 34, 90, 180, 2, 155, 10, 12, {ts '2012-09-17 18:47:52.69'}, 3, 2, 71, 4, 1, 0, 2, 'lm', false, false, 6.5);

INSERT INTO PLAYER (player_id, name, surname, age, weight, height, sprint60m, vertical_jump, beep_test, push_ups_in_row, last_test_date,
                    goals_scored, assists, pass_percentage, interceptions, yellow_cards, red_cards, games_played, position, is_injured, is_suspended, rating)
VALUES (6, 'Lech', 'Wałęsa', 34, 90, 180, 2, 155, 10, 12, {ts '2012-09-17 18:47:52.69'}, 3, 2, 71, 4, 1, 0, 2, 'cm1', false, false, 6.5);

INSERT INTO PLAYER (player_id, name, surname, age, weight, height, sprint60m, vertical_jump, beep_test, push_ups_in_row, last_test_date,
                    goals_scored, assists, pass_percentage, interceptions, yellow_cards, red_cards, games_played, position, is_injured, is_suspended, rating)
VALUES (7, 'Abraham', 'Lincoln', 34, 90, 180, 2, 155, 10, 12, {ts '2012-09-17 18:47:52.69'}, 3, 2, 71, 4, 1, 0, 2, 'cm2', false, false, 6.5);

INSERT INTO PLAYER (player_id, name, surname, age, weight, height, sprint60m, vertical_jump, beep_test, push_ups_in_row, last_test_date,
                    goals_scored, assists, pass_percentage, interceptions, yellow_cards, red_cards, games_played, position, is_injured, is_suspended, rating)
VALUES (8, 'John', 'Kennedy', 34, 90, 180, 2, 155, 10, 12, {ts '2012-09-17 18:47:52.69'}, 3, 2, 71, 4, 1, 0, 2, 'rm', false, false, 6.5);

INSERT INTO PLAYER (player_id, name, surname, age, weight, height, sprint60m, vertical_jump, beep_test, push_ups_in_row, last_test_date,
                    goals_scored, assists, pass_percentage, interceptions, yellow_cards, red_cards, games_played, position, is_injured, is_suspended, rating)
VALUES (9, 'Tommy', 'Shelby', 34, 90, 180, 2, 155, 10, 12, {ts '2012-09-17 18:47:52.69'}, 3, 2, 71, 4, 1, 0, 2, 'st1', false, false, 6.5);

INSERT INTO PLAYER (player_id, name, surname, age, weight, height, sprint60m, vertical_jump, beep_test, push_ups_in_row, last_test_date,
                    goals_scored, assists, pass_percentage, interceptions, yellow_cards, red_cards, games_played, position, is_injured, is_suspended, rating)
VALUES (10, 'Some', 'One', 34, 90, 180, 2, 155, 10, 12, {ts '2012-09-17 18:47:52.69'}, 3, 2, 71, 4, 1, 0, 2, 'st2', false, false, 6.5);

INSERT INTO PLAYER (player_id, name, surname, age, weight, height, sprint60m, vertical_jump, beep_test, push_ups_in_row, last_test_date,
                    goals_scored, assists, pass_percentage, interceptions, yellow_cards, red_cards, games_played, position, is_injured, is_suspended, rating)
VALUES (11, 'John', 'Doe', 34, 90, 180, 2, 155, 10, 12, {ts '2012-09-17 18:47:52.69'}, 3, 2, 71, 4, 1, 0, 2, 'gk', false, false, 6.5);

INSERT INTO PLAYER (player_id, name, surname, age, weight, height, sprint60m, vertical_jump, beep_test, push_ups_in_row, last_test_date,
                    goals_scored, assists, pass_percentage, interceptions, yellow_cards, red_cards, games_played, position, is_injured, is_suspended, rating)
VALUES (12, 'Ktoś', 'Tam', 34, 90, 180, 2, 155, 10, 12, {ts '2012-09-17 18:47:52.69'}, 3, 2, 71, 4, 1, 0, 2, 'bench', false, false, 6.5);

INSERT INTO PLAYER (player_id, name, surname, age, weight, height, sprint60m, vertical_jump, beep_test, push_ups_in_row, last_test_date,
                    goals_scored, assists, pass_percentage, interceptions, yellow_cards, red_cards, games_played, position, is_injured, is_suspended, rating)
VALUES (13, 'Jakaś', 'Osoba', 34, 90, 180, 2, 155, 10, 12, {ts '2012-09-17 18:47:52.69'}, 3, 2, 71, 4, 1, 0, 2, 'bench', false, false, 6.5);

INSERT INTO PLAYER (player_id, name, surname, age, weight, height, sprint60m, vertical_jump, beep_test, push_ups_in_row, last_test_date,
                    goals_scored, assists, pass_percentage, interceptions, yellow_cards, red_cards, games_played, position, is_injured, is_suspended, rating)
VALUES (14, 'Leo', 'Messi', 34, 90, 180, 2, 155, 10, 12, {ts '2012-09-17 18:47:52.69'}, 3, 2, 71, 4, 1, 0, 2, 'bench', false, false, 6.5);

INSERT INTO PLAYER (player_id, name, surname, age, weight, height, sprint60m, vertical_jump, beep_test, push_ups_in_row, last_test_date,
                    goals_scored, assists, pass_percentage, interceptions, yellow_cards, red_cards, games_played, position, is_injured, is_suspended, rating)
VALUES (15, 'Zinedine', 'Zidane', 34, 90, 180, 2, 155, 10, 12, {ts '2012-09-17 18:47:52.69'}, 3, 2, 71, 4, 1, 0, 2, 'bench', false, false, 6.5);

INSERT INTO PLAYER (player_id, name, surname, age, weight, height, sprint60m, vertical_jump, beep_test, push_ups_in_row, last_test_date,
                    goals_scored, assists, pass_percentage, interceptions, yellow_cards, red_cards, games_played, position, is_injured, is_suspended, rating)
VALUES (16, 'Cristiano', 'Ronaldo', 34, 90, 180, 2, 155, 10, 12, {ts '2012-09-17 18:47:52.69'}, 3, 2, 71, 4, 1, 0, 2, 'bench', false, false, 6.5);

INSERT INTO CLUB_PLAYER_LIST VALUES (1, 2);

INSERT INTO TRAINING (training_id, date, type) VALUES (1,{ts '2021-05-17 18:47:52.69'}, 'Strength');
INSERT INTO TRAINING (training_id, date, type) VALUES (2,{ts '2021-05-18 18:47:52.69'}, 'Tactics');
INSERT INTO TRAINING (training_id, date, type) VALUES (3,{ts '2021-05-19 18:47:52.69'}, 'Running');
INSERT INTO TRAINING (training_id, date, type) VALUES (4,{ts '2021-05-20 18:47:52.69'}, 'Cardiovascular');

INSERT INTO TRAINING_PLAYERS VALUES (1, 1);
INSERT INTO TRAINING_PLAYERS VALUES (2, 1);
INSERT INTO TRAINING_PLAYERS VALUES (3, 1);
INSERT INTO TRAINING_PLAYERS VALUES (1, 2);
INSERT INTO TRAINING_PLAYERS VALUES (2, 2);
INSERT INTO TRAINING_PLAYERS VALUES (3, 2);
INSERT INTO TRAINING_PLAYERS VALUES (4, 1);
INSERT INTO TRAINING_PLAYERS VALUES (3, 11);
INSERT INTO TRAINING_PLAYERS VALUES (2, 1);
INSERT INTO TRAINING_PLAYERS VALUES (1, 5);
INSERT INTO TRAINING_PLAYERS VALUES (1, 6);
INSERT INTO TRAINING_PLAYERS VALUES (1, 7);
INSERT INTO TRAINING_PLAYERS VALUES (1, 8);
INSERT INTO TRAINING_PLAYERS VALUES (1, 9);
INSERT INTO TRAINING_PLAYERS VALUES (2, 11);
INSERT INTO TRAINING_PLAYERS VALUES (2, 12);
INSERT INTO TRAINING_PLAYERS VALUES (2, 13);
INSERT INTO TRAINING_PLAYERS VALUES (2, 15);
INSERT INTO TRAINING_PLAYERS VALUES (2, 16);
INSERT INTO TRAINING_PLAYERS VALUES (3, 4);
INSERT INTO TRAINING_PLAYERS VALUES (3, 14);
INSERT INTO TRAINING_PLAYERS VALUES (2, 14);
INSERT INTO TRAINING_PLAYERS VALUES (1, 16);

SET REFERENTIAL_INTEGRITY TRUE;
