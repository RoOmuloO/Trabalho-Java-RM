-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema rm_e
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema rm_e
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rm_e` DEFAULT CHARACTER SET utf8 ;
USE `rm_e` ;

-- -----------------------------------------------------
-- Table `rm_e`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rm_e`.`usuario` (
  `idusuario` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `tipo` INT(11) NOT NULL,
  `cpf` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_e`.`consulta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rm_e`.`consulta` (
  `idconsulta` INT(11) NOT NULL AUTO_INCREMENT,
  `data` VARCHAR(45) NULL DEFAULT NULL,
  `local` VARCHAR(45) NOT NULL,
  `hora` VARCHAR(45) NULL DEFAULT NULL,
  `usuario_medico` INT(11) NOT NULL,
  `usuario_paciente` INT(11) NOT NULL,
  PRIMARY KEY (`idconsulta`),
  INDEX `fk_consulta_usuario1_idx` (`usuario_medico` ASC),
  INDEX `fk_consulta_usuario2_idx` (`usuario_paciente` ASC),
  CONSTRAINT `fk_consulta_usuario1`
    FOREIGN KEY (`usuario_medico`)
    REFERENCES `rm_e`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_consulta_usuario2`
    FOREIGN KEY (`usuario_paciente`)
    REFERENCES `rm_e`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_e`.`exame`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rm_e`.`exame` (
  `idexame` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `consulta_idconsulta` INT(11) NOT NULL,
  PRIMARY KEY (`idexame`),
  INDEX `fk_exame_consulta1_idx` (`consulta_idconsulta` ASC),
  CONSTRAINT `fk_exame_consulta1`
    FOREIGN KEY (`consulta_idconsulta`)
    REFERENCES `rm_e`.`consulta` (`idconsulta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_e`.`medicamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rm_e`.`medicamento` (
  `idmedicamento` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NULL DEFAULT NULL,
  `tipo` VARCHAR(45) NULL DEFAULT NULL,
  `manipuladoura` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idmedicamento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_e`.`receita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rm_e`.`receita` (
  `idreceita` INT(11) NOT NULL AUTO_INCREMENT,
  `usada` TINYINT(4) NULL DEFAULT '0',
  `cancelada` TINYINT(4) NULL DEFAULT '0',
  `consulta_idconsulta` INT(11) NOT NULL,
  `hora` VARCHAR(45) NOT NULL,
  `data` VARCHAR(45) NOT NULL,
  `instrucoes_uso` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idreceita`),
  INDEX `fk_receita_consulta1_idx` (`consulta_idconsulta` ASC),
  CONSTRAINT `fk_receita_consulta1`
    FOREIGN KEY (`consulta_idconsulta`)
    REFERENCES `rm_e`.`consulta` (`idconsulta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rm_e`.`receita_has_medicamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rm_e`.`receita_has_medicamento` (
  `receita_idreceita` INT(11) NOT NULL,
  `medicamento_idmedicamento` INT(11) NOT NULL,
  `vendido` TINYINT(4) NOT NULL DEFAULT '0',
  `instrucoes_uso` VARCHAR(45) NULL DEFAULT NULL,
  `dataVenda` VARCHAR(45) NULL DEFAULT NULL,
  `horaVenda` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`receita_idreceita`, `medicamento_idmedicamento`),
  INDEX `fk_receita_has_medicamento_medicamento1_idx` (`medicamento_idmedicamento` ASC),
  INDEX `fk_receita_has_medicamento_receita1_idx` (`receita_idreceita` ASC),
  CONSTRAINT `fk_receita_has_medicamento_medicamento1`
    FOREIGN KEY (`medicamento_idmedicamento`)
    REFERENCES `rm_e`.`medicamento` (`idmedicamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_receita_has_medicamento_receita1`
    FOREIGN KEY (`receita_idreceita`)
    REFERENCES `rm_e`.`receita` (`idreceita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
