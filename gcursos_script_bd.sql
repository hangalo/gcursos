-- MySQL Script generated by MySQL Workbench
-- 02/26/17 02:08:15
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema gcursos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gcursos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gcursos` DEFAULT CHARACTER SET utf8 ;
USE `gcursos` ;

-- -----------------------------------------------------
-- Table `gcursos`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gcursos`.`aluno` (
  `id_aluno` INT(11) NOT NULL AUTO_INCREMENT,
  `primeiro_nome_aluno` VARCHAR(100) NULL DEFAULT NULL,
  `segundo_nome_aluno` VARCHAR(100) NULL DEFAULT NULL,
  `sobrenome_aluno` VARCHAR(100) NULL DEFAULT NULL,
  `data_nascimento_aluno` DATE NULL DEFAULT NULL,
  `sexo_aluno` CHAR(45) NULL DEFAULT NULL,
  `telefone_fixo_aluno` VARCHAR(45) NULL DEFAULT NULL,
  `telefone_unitel_aluno` VARCHAR(45) NULL DEFAULT NULL,
  `telefone_movicel_aluno` VARCHAR(45) NULL DEFAULT NULL,
  `email_aluno` VARCHAR(45) NULL DEFAULT NULL,
  `facebook_aluno` VARCHAR(100) NULL DEFAULT NULL,
  `foto_aluno` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id_aluno`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gcursos`.`categoria_curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gcursos`.`categoria_curso` (
  `id_categoria_curso` INT(11) NOT NULL AUTO_INCREMENT,
  `categoria_curso` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_categoria_curso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gcursos`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gcursos`.`curso` (
  `id_curso` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_curso` VARCHAR(45) NULL DEFAULT NULL,
  `requisito_curso` VARCHAR(255) NULL DEFAULT NULL,
  `conteudo_curso` VARCHAR(255) NULL DEFAULT NULL,
  `carga_horaria_curso` INT(11) NULL DEFAULT NULL,
  `preco_curso` DOUBLE NULL DEFAULT NULL,
  `id_categoria_curso` INT(11) NOT NULL,
  PRIMARY KEY (`id_curso`),
  INDEX `fk_curso_categoria_curso1_idx` (`id_categoria_curso` ASC),
  CONSTRAINT `fk_curso_categoria_curso1`
    FOREIGN KEY (`id_categoria_curso`)
    REFERENCES `gcursos`.`categoria_curso` (`id_categoria_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gcursos`.`instrutor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gcursos`.`instrutor` (
  `id_instrutor` INT(11) NOT NULL AUTO_INCREMENT,
  `primeiro_nome_instrutor` VARCHAR(100) NULL DEFAULT NULL,
  `segundo_nome_instrutor` VARCHAR(100) NULL DEFAULT NULL,
  `sobrenome_instrutor` VARCHAR(100) NULL DEFAULT NULL,
  `data_nascimento_instrutor` DATE NULL DEFAULT NULL,
  `sexo_aluno` CHAR(45) NULL DEFAULT NULL,
  `telefone_fixo_instrutor` VARCHAR(45) NULL DEFAULT NULL,
  `telefone_unitel_instrutor` VARCHAR(45) NULL DEFAULT NULL,
  `telefone_movicel_aluno` VARCHAR(45) NULL DEFAULT NULL,
  `email_instrutor` VARCHAR(45) NULL DEFAULT NULL,
  `facebook_instrutor` VARCHAR(45) NULL DEFAULT NULL,
  `foto_instrutor` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id_instrutor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gcursos`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gcursos`.`funcionario` (
  `id_funcionario` INT(11) NOT NULL AUTO_INCREMENT,
  `primeiro_nome_funcionario` VARCHAR(100) NULL DEFAULT NULL,
  `segundo_nome_funcionario` VARCHAR(100) NULL DEFAULT NULL,
  `sobrenome_funcionario` VARCHAR(100) NULL DEFAULT NULL,
  `data_nascimento_funcionario` DATE NULL DEFAULT NULL,
  `sexo_funcionario` CHAR(45) NULL DEFAULT NULL,
  `telefone_fixo_funcionario` VARCHAR(45) NULL DEFAULT NULL,
  `telefone_unitel_funcionario` VARCHAR(45) NULL DEFAULT NULL,
  `telefone_movicel_funcionario` VARCHAR(45) NULL DEFAULT NULL,
  `email_funcionario` VARCHAR(45) NULL DEFAULT NULL,
  `facebook_funcionario` VARCHAR(45) NULL DEFAULT NULL,
  `foto_funcionario` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id_funcionario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gcursos`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gcursos`.`turma` (
  `id_turma` INT(11) NOT NULL AUTO_INCREMENT,
  `turma` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_turma`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gcursos`.`matricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gcursos`.`matricula` (
  `id_matricula` INT(11) NOT NULL AUTO_INCREMENT,
  `id_aluno` INT(11) NOT NULL,
  `id_turma` INT(11) NOT NULL,
  `id_funcionario` INT(11) NOT NULL,
  `data_matricula` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_matricula`),
  INDEX `fk_matricula_aluno_idx` (`id_aluno` ASC),
  INDEX `fk_matricula_turma1_idx` (`id_turma` ASC),
  INDEX `fk_matricula_funcionario1_idx` (`id_funcionario` ASC),
  CONSTRAINT `fk_matricula_aluno`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `gcursos`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_funcionario1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `gcursos`.`funcionario` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_turma1`
    FOREIGN KEY (`id_turma`)
    REFERENCES `gcursos`.`turma` (`id_turma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gcursos`.`detalhes_matricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gcursos`.`detalhes_matricula` (
  `id_matricula` INT(11) NOT NULL,
  `id_curso` INT(11) NOT NULL,
  `id_instrutor` INT(11) NOT NULL,
  `preco_curso` DOUBLE NULL DEFAULT NULL,
  `data_inicio` DATE NULL DEFAULT NULL,
  `data_fim` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_matricula`, `id_curso`),
  INDEX `fk_detalhes_matricula_matricula1_idx` (`id_matricula` ASC),
  INDEX `fk_detalhes_matricula_instrutor1_idx` (`id_instrutor` ASC),
  INDEX `fk_detalhes_matricula_curso1_idx` (`id_curso` ASC),
  CONSTRAINT `fk_detalhes_matricula_curso1`
    FOREIGN KEY (`id_curso`)
    REFERENCES `gcursos`.`curso` (`id_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalhes_matricula_instrutor1`
    FOREIGN KEY (`id_instrutor`)
    REFERENCES `gcursos`.`instrutor` (`id_instrutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalhes_matricula_matricula1`
    FOREIGN KEY (`id_matricula`)
    REFERENCES `gcursos`.`matricula` (`id_matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gcursos`.`pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gcursos`.`pagamento` (
  `id_parcelas` INT(11) NOT NULL AUTO_INCREMENT,
  `id_matricula` INT(11) NOT NULL,
  `id_funcionario` INT(11) NOT NULL,
  `valor_parcela` DECIMAL(10,0) NULL DEFAULT NULL,
  `data_apamento` DATE NULL DEFAULT NULL,
  `valor_desconto` DECIMAL(10,0) NULL DEFAULT NULL,
  `valor_multa` DECIMAL(10,0) NULL DEFAULT NULL,
  `valor_pago` DECIMAL(10,0) NULL DEFAULT NULL,
  `pago` TINYINT(4) NULL DEFAULT NULL,
  `observacoes` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id_parcelas`),
  INDEX `fk_parcelas_matricula1_idx` (`id_matricula` ASC),
  INDEX `fk_parcelas_funcionario1_idx` (`id_funcionario` ASC),
  CONSTRAINT `fk_parcelas_funcionario1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `gcursos`.`funcionario` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parcelas_matricula1`
    FOREIGN KEY (`id_matricula`)
    REFERENCES `gcursos`.`matricula` (`id_matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
