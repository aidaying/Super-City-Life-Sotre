-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema supercitylifestore
-- -----------------------------------------------------
-- Schema used with the super city life store application
DROP SCHEMA IF EXISTS `supercitylifestore` ;

-- -----------------------------------------------------
-- Schema supercitylifestore
--
-- Schema used with the super city life store application
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `supercitylifestore` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `supercitylifestore` ;

-- -----------------------------------------------------
-- Table `supercitylifestore`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supercitylifestore`.`category` ;

CREATE TABLE IF NOT EXISTS `supercitylifestore`.`category` (
  `id` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supercitylifestore`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supercitylifestore`.`customer` ;

CREATE TABLE IF NOT EXISTS `supercitylifestore`.`customer` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `order_id` VARCHAR(19) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supercitylifestore`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supercitylifestore`.`item` ;

CREATE TABLE IF NOT EXISTS `supercitylifestore`.`item` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(5,2) NOT NULL,
  `description` TINYTEXT NULL,
  `quantity` INT NOT NULL,
  `last_update` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `category_id` TINYINT UNSIGNED NOT NULL,
  `type` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_item_category_idx` (`category_id` ASC),
  CONSTRAINT `fk_item_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `supercitylifestore`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supercitylifestore`.`customer_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supercitylifestore`.`customer_order` ;

CREATE TABLE IF NOT EXISTS `supercitylifestore`.`customer_order` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `amount` DECIMAL(6,2) NOT NULL,
  `date_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `confirmation_number` INT NOT NULL,
  `customer_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_customer_order_customer1_idx` (`customer_id` ASC),
  CONSTRAINT `fk_customer_order_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `supercitylifestore`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supercitylifestore`.`ordered_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supercitylifestore`.`ordered_item` ;

CREATE TABLE IF NOT EXISTS `supercitylifestore`.`ordered_item` (
  `item_id` INT UNSIGNED NOT NULL,
  `customer_order_id` INT UNSIGNED NOT NULL,
  `quantity` SMALLINT NOT NULL,
  PRIMARY KEY (`item_id`, `customer_order_id`),
  INDEX `fk_item_has_customer_order_customer_order1_idx` (`customer_order_id` ASC),
  INDEX `fk_item_has_customer_order_item1_idx` (`item_id` ASC),
  CONSTRAINT `fk_item_has_customer_order_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `supercitylifestore`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_has_customer_order_customer_order1`
    FOREIGN KEY (`customer_order_id`)
    REFERENCES `supercitylifestore`.`customer_order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
