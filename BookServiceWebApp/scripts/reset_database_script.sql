USE `bookservice`;

-- -----------------------------------------------------
-- Table `bookservice`.`tb_author_has_tb_book`
-- -----------------------------------------------------
DELETE FROM `bookservice`.`tb_author_has_tb_book` WHERE tb_author_id != 1000000;


-- -----------------------------------------------------
-- Table `bookservice`.`tb_book`
-- -----------------------------------------------------
DELETE FROM `bookservice`.`tb_book` WHERE id != 1000000;



-- -----------------------------------------------------
-- Table `bookservice`.`tb_publisher`
-- -----------------------------------------------------
DELETE FROM `bookservice`.`tb_publisher` WHERE id != 1000000;



-- -----------------------------------------------------
-- Table `bookservice`.`tb_author`
-- -----------------------------------------------------
DELETE FROM `bookservice`.`tb_author` WHERE id != 1000000;









