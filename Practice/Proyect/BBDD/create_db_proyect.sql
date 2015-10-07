-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Source Schemata: db_proyect
-- Created: Wed Oct 07 18:10:10 2015
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;;

-- ----------------------------------------------------------------------------
-- Schema db_proyect
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `db_proyect` ;
CREATE SCHEMA IF NOT EXISTS `db_proyect` ;

-- ----------------------------------------------------------------------------
-- Table db_proyect.account
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyect`.`account` (
  `username` VARCHAR(15) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  `fk_rol` INT(1) NOT NULL,
  PRIMARY KEY (`username`),
  INDEX `account_rol_idx` (`fk_rol` ASC),
  CONSTRAINT `account_rol`
    FOREIGN KEY (`fk_rol`)
    REFERENCES `db_proyect`.`rol` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table db_proyect.rol
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyect`.`rol` (
  `id` INT(1) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table db_proyect.cart
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyect`.`cart` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `creation_date` DATETIME NOT NULL,
  `fk_user` INT(11) NOT NULL,
  `total` DECIMAL(8,2) NOT NULL,
  `closed` BIT(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_cart_idx` (`fk_user` ASC),
  CONSTRAINT `cart_user`
    FOREIGN KEY (`fk_user`)
    REFERENCES `db_proyect`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table db_proyect.user
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyect`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(15) NOT NULL,
  `last_name` VARCHAR(15) NOT NULL,
  `email` VARCHAR(25) NOT NULL,
  `fk_account` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_account_idx` (`fk_account` ASC),
  CONSTRAINT `user_account`
    FOREIGN KEY (`fk_account`)
    REFERENCES `db_proyect`.`account` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table db_proyect.item
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyect`.`item` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_category` INT(3) NOT NULL,
  `name` VARCHAR(25) NOT NULL,
  `price` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `item_category_idx` (`fk_category` ASC),
  CONSTRAINT `item_category`
    FOREIGN KEY (`fk_category`)
    REFERENCES `db_proyect`.`item_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 102
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table db_proyect.item_category
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyect`.`item_category` (
  `id` INT(3) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 25
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table db_proyect.line_item
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_proyect`.`line_item` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_cart` INT(11) NOT NULL,
  `fk_item` INT(11) NOT NULL,
  `quantity` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `line_item_cart_idx` (`fk_cart` ASC),
  INDEX `line_item_item_idx` (`fk_item` ASC),
  CONSTRAINT `line_item_cart`
    FOREIGN KEY (`fk_cart`)
    REFERENCES `db_proyect`.`cart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `line_item_item`
    FOREIGN KEY (`fk_item`)
    REFERENCES `db_proyect`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;
SET FOREIGN_KEY_CHECKS = 1;;
