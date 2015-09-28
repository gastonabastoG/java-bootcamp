CREATE DATABASE IF NOT EXISTS `high-schoolDB`;
USE `high-schoolDB`;

CREATE TABLE IF NOT EXISTS `Schedule` (
  `idSchedule` INT(11) NOT NULL AUTO_INCREMENT,
  `HourStart` datetime NOT NULL,
  `HourEnd` datetime NOT NULL,
  PRIMARY KEY (`idSchedule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `Student` (
  `firstName` varchar(60) NOT NULL,
  `lastName` varchar(60) NOT NULL,
  `registrationNumber` INT(11) NOT NULL AUTO_INCREMENT,
  `dateOfBirth` date NOT NULL,
  PRIMARY KEY (`registrationNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `Teacher` (
  `firstName` varchar(60) NOT NULL,
  `lastName` varchar(60) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `Course` (
  `idCourse` INT(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `idAssignedTeacher` int(11) NOT NULL,
  `hoursByWeek` int(11) NOT NULL,
  `idSchedule` INT(11) NOT NULL,
  PRIMARY KEY (`idCourse`),
  KEY `idTeacherAssigned_idx` (`idAssignedTeacher`),
  KEY `Schedule_idx` (`idSchedule`),
  CONSTRAINT `Schedule` FOREIGN KEY (`idSchedule`) REFERENCES `Schedule` (`idSchedule`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Teacher` FOREIGN KEY (`idAssignedTeacher`) REFERENCES `Teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `Notas` (
  `idStudent` INT(11) NOT NULL,
  `idCourse` INT(11) NOT NULL,
  `year` year(4) NOT NULL,
  `partialNote1` decimal(10,0) unsigned DEFAULT NULL,
  `partialNote2` decimal(10,0) DEFAULT NULL,
  `partialNote3` decimal(10,0) DEFAULT NULL,
  `finalNote` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`idStudent`,`idCourse`,`year`),
  KEY `Course_idx` (`idCourse`),
  CONSTRAINT `Course` FOREIGN KEY (`idCourse`) REFERENCES `Course` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Student` FOREIGN KEY (`idStudent`) REFERENCES `Student` (`registrationNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT IGNORE INTO `high-schoolDB`.`Student` 
(`firstName`, `lastName`, `registrationNumber`, `dateOfBirth`)
VALUES    ('Marcelo', 'Tinelli', '1', '2015-01-05'),
          ('Patricio','De Luca','2','2015-01-07'),
          ('Silvia','Santa','3','2015-06-08'),
          ('Felipe','Pinti','4','2015-05-05'),
          ('Yari','Holzer','5','2015-10-10'),
          ('Maria','Ferreira','6','2015-12-11'),
          ('Camila','Virla','7','2015-03-02'),
          ('Eliel','Madero','8','2015-02-05'),
          ('Juan Pablo','Camino','9','2015-01-10'),
          ('Joaquin','Burs','10','0002-04-10'),
          ('Carla','Menna','11','2015-04-10'),
          ('Ines','Blanco','12','2001-01-05'),
          ('Fernando','Blanco','13','2001-01-05'),
          ('Javier','Casal','14','1999-03-03'),
          ('Delfina','Presce','15','2004-01-05'),
          ('Lucas','Toni','16','2015-01-05'),
          ('Tomas','Bonamin','17','2002-01-05'),
          ('Segundo','Goni','18','1998-01-05'),
          ('Martin','Abella','19','2001-01-05'),
          ('Hernan','Abella','20','1997-01-05');

INSERT IGNORE INTO `high-schoolDB`.`Schedule` 
(`idSchedule`,`HourStart`,`HourEnd`)
VALUES    ('1','2015-02-02 09:00:00','2015-02-02 10:00:00'),
          ('2','2015-02-03 10:00:00','2015-02-03 11:00:00'),
          ('3','2015-02-04 20:00:00','2015-02-04 22:00:00'),
          ('4','2015-02-05 13:00:00','2015-02-05 15:00:00'),
          ('5','2015-02-06 17:00:00','2015-02-06 18:00:00');

INSERT IGNORE INTO `high-schoolDB`.`Teacher` 
(`firstName`,`lastName`,`dateOfBirth`,`id`)
VALUES    ('Laura','Conforte','1980-01-05','1'),
          ('Fernando','Dente','1981-01-05','2'),
          ('Silvia','Guerrero','1970-01-05','3');

INSERT IGNORE INTO `high-schoolDB`.`Course` 
(`idCourse`,`name`,`idAssignedTeacher`,`hoursByWeek`,`idSchedule`)
VALUES    ('1','Lengua','1','2','1'),
          ('2','Matematica','2','2','2'),
          ('3','Biologia','3','2','3'),
          ('4','Ingles','3','2','4'),
          ('5','Literatura','2','2','5');


INSERT IGNORE INTO `high-schoolDB`.`Notas` 
(`idStudent`, `idCourse`, `year`, `partialNote1`, `partialNote2`, `partialNote3`, `finalNote`)
VALUES     ('1', '1', 2015, '5', '6', '7', '6'),
           ('2', '1', 2015, '6', '7', '8', '7'),
           ('3', '1', 2015, '8', '8', '8', '8'),
           ('4', '1', 2015, '5', '5', '5', '5'),
           ('5', '1', 2015, '8', '8', '8', '8'),
           ('6', '1', 2015, '9', '9', '9', '9'),
           ('7', '1', 2015, '10', '10', '10', '10'),
           ('8', '1', 2015, '8', '8', '8', '8'),
           ('9', '1', 2015, '10', '10', '10', '10'),
           ('10', '1', 2015, '8', '8', '8', '8'),
           ('11', '1', 2015, '4', '4', '4', '4'),
           ('12', '1', 2015, '8', '8', '8', '8'),
           ('13', '1', 2015, '4', '4', '4', '4'),
           ('14', '1', 2015, '8', '8', '8', '8'),
           ('15', '1', 2015, '5', '5', '5', '5'),
           ('16', '1', 2015, '10', '10', '10', '10'),
           ('17', '1', 2015, '9', '9', '9', '9'),
           ('18', '1', 2015, '4', '4', '4', '4'),
           ('19', '1', 2015, '5', '5', '5', '5'),
           ('20', '1', 2015, '10', '10', '10', '10'),

           ('1', '2', 2015, '5', '6', '7', '6'),
           ('2', '2', 2015, '6', '7', '8', '7'),
           ('3', '2', 2015, '8', '8', '8', '8'),
           ('4', '2', 2015, '5', '5', '5', '5'),
           ('5', '2', 2015, '8', '8', '8', '8'),
           ('6', '2', 2015, '9', '9', '9', '9'),
           ('7', '2', 2015, '10', '10', '10', '10'),
           ('8', '2', 2015, '8', '8', '8', '8'),
           ('9', '2', 2015, '10', '10', '10', '10'),
           ('10', '2', 2015, '8', '8', '8', '8'),
           ('11', '2', 2015, '4', '4', '4', '4'),
           ('12', '2', 2015, '8', '8', '8', '8'),
           ('13', '2', 2015, '4', '4', '4', '4'),
           ('14', '2', 2015, '8', '8', '8', '8'),
           ('15', '2', 2015, '5', '5', '5', '5'),
           ('16', '2', 2015, '10', '10', '10', '10'),
           ('17', '2', 2015, '9', '9', '9', '9'),
           ('18', '2', 2015, '4', '4', '4', '4'),
           ('19', '2', 2015, '5', '5', '5', '5'),
           ('20', '2', 2015, '10', '10', '10', '10'),

           ('1', '3', 2015, '5', '6', '7', '6'),
           ('2', '3', 2015, '6', '7', '8', '7'),
           ('3', '3', 2015, '8', '8', '8', '8'),
           ('4', '3', 2015, '5', '5', '5', '5'),
           ('5', '3', 2015, '8', '8', '8', '8'),
           ('6', '3', 2015, '9', '9', '9', '9'),
           ('7', '3', 2015, '10', '10', '10', '10'),
           ('8', '3', 2015, '8', '8', '8', '8'),
           ('9', '3', 2015, '10', '10', '10', '10'),
           ('10', '3', 2015, '8', '8', '8', '8'),
           ('11', '3', 2015, '4', '4', '4', '4'),
           ('12', '3', 2015, '8', '8', '8', '8'),
           ('13', '3', 2015, '4', '4', '4', '4'),
           ('14', '3', 2015, '8', '8', '8', '8'),
           ('15', '3', 2015, '5', '5', '5', '5'),
           ('16', '3', 2015, '10', '10', '10', '10'),
           ('17', '3', 2015, '9', '9', '9', '9'),
           ('18', '3', 2015, '4', '4', '4', '4'),
           ('19', '3', 2015, '5', '5', '5', '5'),
           ('20', '3', 2015, '10', '10', '10', '10');



