DROP DATABASE IF EXISTS `SHOPINGCART`;

CREATE DATABASE `SHOPINGCART`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

USE `SHOPINGCART`;

#
# Structure for the `category` table : 
#

CREATE TABLE `category` (
  `IDCATEGORY` int(11) NOT NULL auto_increment,
  `NAME` varchar(20) default NULL,
  PRIMARY KEY  (`IDCATEGORY`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `item` table : 
#

CREATE TABLE `item` (
  `IDITEM` int(11) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `CATEGORY` varchar(20) NOT NULL,
  `PRICE` decimal(7,2) NOT NULL,
  PRIMARY KEY  (`IDITEM`),
  KEY `CATEGORY` (`CATEGORY`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `orderentry` table : 
#

CREATE TABLE `orderentry` (
  `IDORDER` int(11) NOT NULL,
  `IDITEM` int(11) NOT NULL,
  `QUANTITY` int(11) NOT NULL,
  PRIMARY KEY  (`IDORDER`,`IDITEM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `orders` table : 
#

CREATE TABLE `orders` (
  `IDORDER` int(11) NOT NULL,
  `IDUSER` int(11) NOT NULL,
  PRIMARY KEY  (`IDORDER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `shoppingcartentry` table : 
#

CREATE TABLE `shoppingcartentry` (
  `IDUSER` int(11) NOT NULL,
  `IDITEM` int(11) NOT NULL,
  `QUANTITY` int(11) NOT NULL,
  PRIMARY KEY  (`IDUSER`,`IDITEM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `users` table : 
#

CREATE TABLE `users` (
  `IDUSER` int(11) NOT NULL auto_increment,
  `NICKNAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  PRIMARY KEY  (`IDUSERS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for the `users` table  (LIMIT 0,500)
#

INSERT INTO `users` (`IDUSERS`, `NICKNAME`, `PASSWORD`) VALUES 
  (1,'Guille','12345678'),
  (2,'Fede','123');

COMMIT;