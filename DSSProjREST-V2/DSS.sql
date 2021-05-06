CREATE DATABASE DSS;
USE DSS;

-- CREATE STATEMENT
CREATE TABLE ACTORS(
	ACTOR_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    FIRST_NAME VARCHAR(25),
    LAST_NAME VARCHAR(25),
    GENDER CHAR(1),
    AGE INT
);

CREATE TABLE MOVIES(
 MOVIE_ID INT PRIMARY KEY,
 MOVIE_TITLE VARCHAR(50),
 MOVIE_COST INT,
 MOVIE_YEAR INT
 );
 
 CREATE TABLE CUSTOMERS (
	ID int NOT NULL AUTO_INCREMENT,
	firstName varChar(255),
    lastName varChar(255),
    age int,
    PRIMARY KEY (ID)
);

CREATE TABLE REVIEWS (
    REVIEW_ID INT PRIMARY KEY,
    DATE_POSTED DATETIME,
    DESCRIPTION VARCHAR(50),
    RATING INT
); 
 
-- INSERT STATEMENT
INSERT INTO ACTORS VALUES(1, 'Brad','Pitt','M',44);
INSERT INTO ACTORS VALUES(2, 'Tom','Cruise','M',50);
INSERT INTO ACTORS VALUES(3, 'Chris','Helmsworth','M',22);
INSERT INTO ACTORS VALUES(4, 'Jessica','Biel','F',33);
INSERT INTO ACTORS VALUES(5, 'Angela','Baby','F',18);
INSERT INTO ACTORS VALUES(6, 'Angelina','Jolene','F',45);
INSERT INTO ACTORS VALUES(7, 'Chris','Pratt','F',45);
INSERT INTO MOVIE VALUES(1,"Lord of the rings",19,2006);
INSERT INTO MOVIE VALUES(2,"Fast and Furious 8",14,2018);
INSERT INTO MOVIE VALUES(3,"Nobody",18,2021);
INSERT INTO MOVIE VALUES(4,"Hunger Games",12,2010);
INSERT INTO CUSTOMER VALUES (1, "FIRST", "LAST", 0);
INSERT INTO CUSTOMER VALUES (2, "JOHN", "SMITH", 30);
INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, AGE) VALUES ("PETER", "BROWN", 20);
INSERT INTO REVIEWS VALUES(1, "1970-01-01 00:00:01", "This was a great film! 5-star awesomeness", 5);
INSERT INTO REVIEWS VALUES(2, "2020-05-01 13:00:30", "Pretty average overrall, nothing much...", 3);
