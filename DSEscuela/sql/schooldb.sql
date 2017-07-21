CREATE DATABASE dsschool;
USE dsschool;

CREATE TABLE students (
	id_student INTEGER NOT NULL AUTO_INCREMENT,
	regtag VARCHAR(45) NOT NULL,
	groupa VARCHAR(45) NOT NULL,
	name VARCHAR(45) NOT NULL,
	last_name VARCHAR(45) NOT NULL,
	ml_name VARCHAR(45) NOT NULL,
	address VARCHAR(45) NOT NULL,
	Hphone INT NOT NULL,
	email VARCHAR(45) NOT NULL,
	birthdate DATE NOT NULL,
	sex VARCHAR(45) NOT NULL,
	regdate TIMESTAMP NOT NULL,
	PRIMARY KEY(id_student)
);