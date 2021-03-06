-- MySQL Script generated by MySQL Workbench
-- Sun Sep 13 20:48:35 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gameshop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gameshop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gameshop` DEFAULT CHARACTER SET utf8 ;
USE `gameshop` ;

-- -----------------------------------------------------
-- Table `gameshop`.`desarrolladora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gameshop`.`desarrolladora` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gameshop`.`Videojuego`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gameshop`.`Videojuego` (
  `idVideojuego` INT NOT NULL AUTO_INCREMENT,
  `desarrolladora` VARCHAR(45) NOT NULL,
  `desarrolladora_id` INT NOT NULL,
  PRIMARY KEY (`idVideojuego`, `desarrolladora_id`),
  INDEX `fk_Videojuego_desarrolladora1_idx` (`desarrolladora_id` ASC) ,
  CONSTRAINT `fk_Videojuego_desarrolladora1`
    FOREIGN KEY (`desarrolladora_id`)
    REFERENCES `gameshop`.`desarrolladora` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gameshop`.`compania`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gameshop`.`compania` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gameshop`.`consola`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gameshop`.`consola` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `compania` INT NOT NULL,
  `compania_id` INT NOT NULL,
  PRIMARY KEY (`id`, `compania_id`),
  INDEX `fk_consola_compania_idx` (`compania_id` ASC) ,
  CONSTRAINT `fk_consola_compania`
    FOREIGN KEY (`compania_id`)
    REFERENCES `gameshop`.`compania` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gameshop`.`publicacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gameshop`.`publicacion` (
  `id` INT NOT NULL,
  `videoguego` INT NOT NULL,
  `consola` INT NOT NULL,
  `consola_id` INT NOT NULL,
  `Videojuego_idVideojuego` INT NOT NULL,
  PRIMARY KEY (`id`, `consola_id`, `Videojuego_idVideojuego`),
  INDEX `fk_publicacion_consola1_idx` (`consola_id` ASC) ,
  INDEX `fk_publicacion_Videojuego1_idx` (`Videojuego_idVideojuego` ASC) ,
  CONSTRAINT `fk_publicacion_consola1`
    FOREIGN KEY (`consola_id`)
    REFERENCES `gameshop`.`consola` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_publicacion_Videojuego1`
    FOREIGN KEY (`Videojuego_idVideojuego`)
    REFERENCES `gameshop`.`Videojuego` (`idVideojuego`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
