DROP DATABASE customer;
CREATE DATABASE DSS;
USE DSS;

CREATE TABLE CUSTOMER (
	ID int NOT NULL AUTO_INCREMENT,
	firstName varChar(255),
    lastName varChar(255),
    age int,
    PRIMARY KEY (ID)
);

INSERT INTO CUSTOMER VALUES (1, "FIRST", "LAST", 0);
INSERT INTO CUSTOMER VALUES (2, "JOHN", "SMITH", 30);
INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, AGE) VALUES ("PETER", "BROWN", 20);

SELECT * FROM CUSTOMER;
