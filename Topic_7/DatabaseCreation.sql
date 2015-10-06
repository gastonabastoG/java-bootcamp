CREATE DATABASE IF NOT EXISTS highschool;
USE highschool;

CREATE TABLE IF NOT EXISTS Student(
REGISTRATIONNUMBER INT NOT NULL AUTO_INCREMENT,
FIRSTNAME VARCHAR(50) NOT NULL,
LASTNAME VARCHAR(50) NOT NULL,
BIRTHDATE DATE NOT NULL,
PRIMARY KEY (REGISTRATIONNUMBER));

CREATE TABLE IF NOT EXISTS Teacher(
idTEACHER INT NOT NULL AUTO_INCREMENT,
FIRSTNAME VARCHAR(50) NOT NULL,
LASTNAME VARCHAR(50) NOT NULL,
BIRTHDATE DATE NOT NULL,
PRIMARY KEY(idTEACHER));

CREATE TABLE IF NOT EXISTS Course(
idCOURSE INT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(100) NOT NULL,
ASSIGNEDTEACHER INT NOT NULL,
HOURSBYWEEK INT,
STARTTIME DATE,
ENDTIME DATE,
PRIMARY KEY(idCOURSE),
CONSTRAINT Teacher FOREIGN KEY (ASSIGNEDTEACHER) REFERENCES Teacher(idTEACHER) ON DELETE NO ACTION ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS Registrations(
REGISTRATIONNUMBER INT NOT NULL,
idCOURSE INT NOT NULL,
REGISTRATIONYEAR INT(4) NOT NULL,
NOTE1 INT(2),
NOTE2 INT(2),
NOTE3 INT(2),
FINALNOTE INT(2),
PRIMARY KEY (REGISTRATIONNUMBER,idCOURSE,REGISTRATIONYEAR),
CONSTRAINT Student FOREIGN KEY (REGISTRATIONNUMBER) REFERENCES Student(REGISTRATIONNUMBER) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT Course FOREIGN KEY (idCOURSE) REFERENCES Course(idCOURSE) ON DELETE NO ACTION ON UPDATE NO ACTION);

INSERT IGNORE INTO Teacher VALUES 
	(default,'Viviana','Ferragine','1962-11-25'),
	(default,'Laura','Rivero','1955-8-5'),
	(default,'Luis','Berdun','1981-1-12'),
	(default,'Hernan','Cobo','1964-4-22'),
	(default,'Hugo','Curti','1975-10-5');

INSERT IGNORE INTO Course (idCOURSE,NAME,ASSIGNEDTEACHER) VALUES
	(default,'Introduccion a la Programacion I',4),
	(default,'Introduccion a la Programacion II',4),
	(default,'Programacion Orientada a Objetos',3),
	(default,'Introduccion a la Arquitectura de Computadoras',5),
	(default,'Bases de Datos I',2);
	
INSERT IGNORE INTO Student VALUES
	(default,'Mariano','Martinez','1991-12-02'),
	(default,'Martin','Ditz','1990-12-02'),
	(default,'Pedro','Steffan','1987-12-02'),
	(default,'Jose','Echeverria','1989-12-02'),
	(default,'Tato','Bores','1990-12-02'),
	(default,'Juan','Perez','1991-12-02'),
	(default,'Marcelo','Tinelli','1988-12-02'),
	(default,'Julian','Bianchi','1991-12-02'),
	(default,'Facundo','Andrade','1991-11-14'),
	(default,'Esteban','Andrade','1987-12-8'),
	(default,'Sebastian','Alessio','1990-02-04'),
	(default,'Nicolas','Grosso','1991-12-02'),
	(default,'Agustin','Molpeceres','1991-12-02'),
	(default,'Ezequiel','Avellaneda','1991-12-02'),
	(default,'Lucas','Hadad','1991-12-02'),
	(default,'Miguel','Gonzalez','1991-12-02'),
	(default,'Juan Cruz','Caso','1991-12-02'),
	(default,'Juan Pablo','Caso','1991-12-02'),
	(default,'Maximiliano','Cassola','1991-12-02'),
	(default,'Santiago','Carliski','1991-12-02');
	
INSERT IGNORE INTO Registrations VALUES
	(1,1,2015,8,7,9,8),
	(2,1,2015,7,7,7,7),
	(3,1,2015,7,7,10,8),
	(4,1,2015,8,10,9,9),
	(5,1,2015,5,4,6,5),
	(6,1,2015,1,10,4,5),
	(7,1,2015,8,2,8,6),
	(8,1,2015,4,4,4,4),
	(9,1,2015,10,10,10,10),
	(10,1,2015,8,7,9,8),
	(11,1,2015,4,2,2,2),
	(12,1,2015,8,7,9,8),
	(13,1,2015,8,7,9,8),
	(14,1,2015,8,7,9,8),
	(15,1,2015,8,7,9,8),
	(16,1,2015,8,7,9,8),
	(9,2,2015,8,10,9,9),
	(9,3,2015,4,10,10,8);