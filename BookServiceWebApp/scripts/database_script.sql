SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `bookservice` ;
CREATE SCHEMA IF NOT EXISTS `bookservice` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `bookservice` ;

-- -----------------------------------------------------
-- Table `bookservice`.`tb_author`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookservice`.`tb_author` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `birthday` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookservice`.`tb_publisher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookservice`.`tb_publisher` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `publishername` VARCHAR(45) NOT NULL,
  `postcode` VARCHAR(45) NOT NULL,
  `countrycode` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookservice`.`tb_book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookservice`.`tb_book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tb_publisher_id` INT NOT NULL,
  `isbn` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `subtitle` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `pages` INT NOT NULL,
  `language` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `tb_publisher_id`),
  INDEX `fk_tb_book_tb_publisher1_idx` (`tb_publisher_id` ASC),
  CONSTRAINT `fk_tb_book_tb_publisher1`
    FOREIGN KEY (`tb_publisher_id`)
    REFERENCES `bookservice`.`tb_publisher` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookservice`.`tb_author_has_tb_book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookservice`.`tb_author_has_tb_book` (
  `tb_author_id` INT NOT NULL,
  `tb_book_id` INT NOT NULL,
  PRIMARY KEY (`tb_author_id`, `tb_book_id`),
  INDEX `fk_tb_author_has_tb_book_tb_book1_idx` (`tb_book_id` ASC),
  INDEX `fk_tb_author_has_tb_book_tb_author_idx` (`tb_author_id` ASC),
  CONSTRAINT `fk_tb_author_has_tb_book_tb_author`
    FOREIGN KEY (`tb_author_id`)
    REFERENCES `bookservice`.`tb_author` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_author_has_tb_book_tb_book1`
    FOREIGN KEY (`tb_book_id`)
    REFERENCES `bookservice`.`tb_book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
