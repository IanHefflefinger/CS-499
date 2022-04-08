
-- INSTRUCTIONS - launch using the following command in the MySQL shell:
-- source /Users/ianhefflefinger/Desktop/SNHU SCHOOLWORK/CS-499-T4546 Computer Science Capstone 22EW4/SQL_Commands.sql

CREATE DATABASE messaging;

USE messaging;

-- ****** START CREATE TABLES ******

-- create image table
CREATE TABLE image (
    image_id int(8) NOT NULL AUTO_INCREMENT,
    image_name varchar(50) NOT NULL,
    image_location varchar(250) NOT NULL,
    PRIMARY KEY (image_id)
);

-- create message table
CREATE TABLE message (
    message_id int(8) NOT NULL AUTO_INCREMENT,
    sender_id int(8) NOT NULL,
    receiver_id int(8) NOT NULL,
    message varchar(255) NOT NULL,
    send_datetime datetime NOT NULL,
    PRIMARY KEY (message_id)
);

-- create person table
CREATE TABLE person (
    person_id int(8) NOT NULL AUTO_INCREMENT,
    first_name varchar(50) NOT NULL,
    last_name varchar(70) NOT NULL,
    PRIMARY KEY (person_id)
);

-- ****** END CREATE TABLES ******


-- ****** START SEED TABLES WITH INITIAL DATA ******

-- insert values into person table
INSERT INTO person (first_name, last_name) VALUES ('Micheal', 'Phelps');
INSERT INTO person (first_name, last_name) VALUES ('Katie', 'Ledecky');
INSERT INTO person (first_name, last_name) VALUES ('Usain', 'Bolt');
INSERT INTO person (first_name, last_name) VALUES ('Allyson', 'Felix');
INSERT INTO person (first_name, last_name) VALUES ('Kevin', 'Durant');
INSERT INTO person (first_name, last_name) VALUES ('Diana', 'Taurasi');

-- insert values into image table
INSERT INTO image (image_name, image_location) VALUES ('Sunset', 'California');
INSERT INTO image (image_name, image_location) VALUES ('Waterfall', 'Oregon');
INSERT INTO image (image_name, image_location) VALUES ('Mountain', 'Colorado');
INSERT INTO image (image_name, image_location) VALUES ('River', 'New Hampshire');
INSERT INTO image (image_name, image_location) VALUES ('Beach', 'Hawaii');

-- insert into message table
INSERT INTO message (sender_id, receiver_id, message, send_datetime) VALUES (1, 2, 'You''re not a very good athlete.', '2020-03-22 23:01:54');
INSERT INTO message (sender_id, receiver_id, message, send_datetime) VALUES (6, 3, 'You cheated.', '2017-12-12 03:13:58');
INSERT INTO message (sender_id, receiver_id, message, send_datetime) VALUES (4, 5, 'Sup, slowpoke?', '2000-08-13 13:21:32');
INSERT INTO message (sender_id, receiver_id, message, send_datetime) VALUES (2, 6, 'You couldn''t hit water if you fell out of a boat.', '2013-07-08 20:08:44');
INSERT INTO message (sender_id, receiver_id, message, send_datetime) VALUES (3, 4, 'Hurts. Don''t it?', '2021-09-27 06:17:32');
INSERT INTO message (sender_id, receiver_id, message, send_datetime) VALUES (5, 1, 'Only losers earn Bronze, buddy.', '2022-03-12 10:31:27');

-- ****** END SEED TABLES WITH INITIAL DATA ******


-- USEFUL QUERIES:

-- SELECT * FROM image;
-- SELECT * FROM message;
-- SELECT * FROM person;

-- DESC image;
-- DESC message;
-- DESC person;