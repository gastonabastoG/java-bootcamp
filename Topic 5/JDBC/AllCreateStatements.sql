CREATE DATABASE `high-school` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;

CREATE TABLE `courseresults` (
  `idcourse` int(11) NOT NULL,
  `idstudent` int(11) NOT NULL,
  `examnr` int(11) NOT NULL,
  `result` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `isfinal` bit(1) NOT NULL,
  PRIMARY KEY (`idcourse`,`idstudent`,`examnr`),
  KEY `studentfk_idx` (`idstudent`),
  CONSTRAINT `coursestudentfk` FOREIGN KEY (`idcourse`, `idstudent`) REFERENCES `coursestudents` (`idcourse`, `idstudent`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `courses` (
  `idcourse` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `assignedteacher` int(11) NOT NULL,
  `hoursperweek` int(11) NOT NULL,
  PRIMARY KEY (`idcourse`),
  KEY `teacherfk_idx` (`assignedteacher`),
  CONSTRAINT `teacherfk` FOREIGN KEY (`assignedteacher`) REFERENCES `teachers` (`idteacher`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `coursestudents` (
  `idcourse` int(11) NOT NULL,
  `idstudent` int(11) NOT NULL,
  PRIMARY KEY (`idcourse`,`idstudent`),
  KEY `csstudentfk_idx` (`idstudent`),
  CONSTRAINT `cscoursefk` FOREIGN KEY (`idcourse`) REFERENCES `courses` (`idcourse`) ON UPDATE CASCADE,
  CONSTRAINT `csstudentfk` FOREIGN KEY (`idstudent`) REFERENCES `students` (`idstudent`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `schedules` (
  `idcourse` int(11) NOT NULL,
  `scheduledata` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idcourse`),
  CONSTRAINT `coursefk` FOREIGN KEY (`idcourse`) REFERENCES `courses` (`idcourse`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `students` (
  `idstudent` int(11) NOT NULL,
  `firstname` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `lastname` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `dateofbirth` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idstudent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE `teachers` (
  `idteacher` int(11) NOT NULL,
  `firstname` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `lastname` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `dateofbirth` date NOT NULL,
  PRIMARY KEY (`idteacher`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

