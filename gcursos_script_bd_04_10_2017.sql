-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.17-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema gcursos
--

CREATE DATABASE IF NOT EXISTS gcursos;
USE gcursos;

--
-- Definition of table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
CREATE TABLE `aluno` (
  `id_aluno` int(11) NOT NULL AUTO_INCREMENT,
  `primeiro_nome_aluno` varchar(100) DEFAULT NULL,
  `segundo_nome_aluno` varchar(100) DEFAULT NULL,
  `sobrenome_aluno` varchar(100) DEFAULT NULL,
  `data_nascimento_aluno` date DEFAULT NULL,
  `sexo_aluno` char(45) DEFAULT NULL,
  `telefone_principal` varchar(45) DEFAULT NULL,
  `telefone_alternativo` varchar(45) DEFAULT NULL,
  `email_aluno` varchar(45) DEFAULT NULL,
  `facebook_aluno` varchar(45) DEFAULT NULL,
  `foto_aluno` longblob,
  `url_foto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_aluno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `aluno`
--

/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;


--
-- Definition of table `boletin_notas`
--

DROP TABLE IF EXISTS `boletin_notas`;
CREATE TABLE `boletin_notas` (
  `id_boletin_notas` int(11) NOT NULL AUTO_INCREMENT,
  `id_aluno` int(11) DEFAULT NULL,
  `id_curso` int(11) DEFAULT NULL,
  `primeira_prova` double DEFAULT NULL,
  `segunda_prova` double DEFAULT NULL,
  `exame` double DEFAULT NULL,
  PRIMARY KEY (`id_boletin_notas`),
  KEY `fk_boletin_notas_curso1_idx` (`id_curso`),
  KEY `fk_boletin_notas_aluno1_idx` (`id_aluno`),
  CONSTRAINT `fk_boletin_notas_aluno1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_boletin_notas_curso1` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `boletin_notas`
--

/*!40000 ALTER TABLE `boletin_notas` DISABLE KEYS */;
/*!40000 ALTER TABLE `boletin_notas` ENABLE KEYS */;


--
-- Definition of table `categoria_curso`
--

DROP TABLE IF EXISTS `categoria_curso`;
CREATE TABLE `categoria_curso` (
  `id_categoria_curso` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_curso` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_categoria_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categoria_curso`
--

/*!40000 ALTER TABLE `categoria_curso` DISABLE KEYS */;
INSERT INTO `categoria_curso` (`id_categoria_curso`,`categoria_curso`) VALUES 
 (1,'D'),
 (2,'FD');
/*!40000 ALTER TABLE `categoria_curso` ENABLE KEYS */;


--
-- Definition of table `certificado`
--

DROP TABLE IF EXISTS `certificado`;
CREATE TABLE `certificado` (
  `id_certificado` int(11) NOT NULL AUTO_INCREMENT,
  `data_emissao` date DEFAULT NULL,
  `local_emissao` varchar(45) DEFAULT NULL,
  `id_aluno` int(11) NOT NULL,
  `id_boletin_notas` int(11) NOT NULL,
  PRIMARY KEY (`id_certificado`),
  KEY `fk_certificado_aluno1_idx` (`id_aluno`),
  KEY `fk_certificado_boletin_notas1_idx` (`id_boletin_notas`),
  CONSTRAINT `fk_certificado_aluno1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_certificado_boletin_notas1` FOREIGN KEY (`id_boletin_notas`) REFERENCES `boletin_notas` (`id_boletin_notas`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `certificado`
--

/*!40000 ALTER TABLE `certificado` DISABLE KEYS */;
/*!40000 ALTER TABLE `certificado` ENABLE KEYS */;


--
-- Definition of table `curso`
--

DROP TABLE IF EXISTS `curso`;
CREATE TABLE `curso` (
  `id_curso` int(11) NOT NULL AUTO_INCREMENT,
  `nome_curso` varchar(45) DEFAULT NULL,
  `requisito_curso` varchar(255) DEFAULT NULL,
  `conteudo_curso` varchar(255) DEFAULT NULL,
  `carga_horaria_curso` int(11) DEFAULT NULL,
  `preco_curso` double DEFAULT NULL,
  `id_categoria_curso` int(11) NOT NULL,
  PRIMARY KEY (`id_curso`),
  KEY `fk_curso_categoria_curso1_idx` (`id_categoria_curso`),
  CONSTRAINT `fk_curso_categoria_curso1` FOREIGN KEY (`id_categoria_curso`) REFERENCES `categoria_curso` (`id_categoria_curso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `curso`
--

/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` (`id_curso`,`nome_curso`,`requisito_curso`,`conteudo_curso`,`carga_horaria_curso`,`preco_curso`,`id_categoria_curso`) VALUES 
 (1,'Teste','232323','23232',23,34,2),
 (2,'Teste','232323','23232',23,34,2);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;


--
-- Definition of table `detalhes_matricula`
--

DROP TABLE IF EXISTS `detalhes_matricula`;
CREATE TABLE `detalhes_matricula` (
  `id_matricula` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL,
  `id_instrutor` int(11) NOT NULL,
  `preco_curso` double DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  PRIMARY KEY (`id_matricula`,`id_curso`),
  KEY `fk_detalhes_matricula_matricula1_idx` (`id_matricula`),
  KEY `fk_detalhes_matricula_instrutor1_idx` (`id_instrutor`),
  KEY `fk_detalhes_matricula_curso1_idx` (`id_curso`),
  CONSTRAINT `fk_detalhes_matricula_curso1` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalhes_matricula_instrutor1` FOREIGN KEY (`id_instrutor`) REFERENCES `instrutor` (`id_instrutor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalhes_matricula_matricula1` FOREIGN KEY (`id_matricula`) REFERENCES `matricula` (`id_matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `detalhes_matricula`
--

/*!40000 ALTER TABLE `detalhes_matricula` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalhes_matricula` ENABLE KEYS */;


--
-- Definition of table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE `funcionario` (
  `id_funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `primeiro_nome_funcionario` varchar(100) DEFAULT NULL,
  `segundo_nome_funcionario` varchar(100) DEFAULT NULL,
  `sobrenome_funcionario` varchar(100) DEFAULT NULL,
  `data_nascimento_funcionario` date DEFAULT NULL,
  `sexo_funcionario` char(45) DEFAULT NULL,
  `telefone_principal` varchar(45) DEFAULT NULL,
  `telefone_alternativo` varchar(45) DEFAULT NULL,
  `email_funcionario` varchar(45) DEFAULT NULL,
  `facebook_funcionario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `funcionario`
--

/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`id_funcionario`,`primeiro_nome_funcionario`,`segundo_nome_funcionario`,`sobrenome_funcionario`,`data_nascimento_funcionario`,`sexo_funcionario`,`telefone_principal`,`telefone_alternativo`,`email_funcionario`,`facebook_funcionario`) VALUES 
 (1,'Luzia','Lussinga','Hangalo','2016-01-01','F','55556666','5555666666','luzia@gmail.com','luzia'),
 (2,'Rosa','Adelaide','Hangalo','2017-10-03','F','77778888','5555666','rosa@gmail.com','rosa');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;


--
-- Definition of table `instrutor`
--

DROP TABLE IF EXISTS `instrutor`;
CREATE TABLE `instrutor` (
  `id_instrutor` int(11) NOT NULL AUTO_INCREMENT,
  `primeiro_nome_instrutor` varchar(100) DEFAULT NULL,
  `segundo_nome_instrutor` varchar(100) DEFAULT NULL,
  `sobrenome_instrutor` varchar(100) DEFAULT NULL,
  `data_nascimento_instrutor` date DEFAULT NULL,
  `sexo_instrutor` char(45) DEFAULT NULL,
  `telefone_princiapl` varchar(45) DEFAULT NULL,
  `telefone_alternativo` varchar(45) DEFAULT NULL,
  `email_instrutor` varchar(45) DEFAULT NULL,
  `facebook_instrutor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_instrutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `instrutor`
--

/*!40000 ALTER TABLE `instrutor` DISABLE KEYS */;
/*!40000 ALTER TABLE `instrutor` ENABLE KEYS */;


--
-- Definition of table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
CREATE TABLE `matricula` (
  `id_matricula` int(11) NOT NULL AUTO_INCREMENT,
  `id_aluno` int(11) NOT NULL,
  `id_turma` int(11) NOT NULL,
  `id_funcionario` int(11) NOT NULL,
  `data_matricula` date DEFAULT NULL,
  PRIMARY KEY (`id_matricula`),
  KEY `fk_matricula_aluno_idx` (`id_aluno`),
  KEY `fk_matricula_turma1_idx` (`id_turma`),
  KEY `fk_matricula_funcionario1_idx` (`id_funcionario`),
  CONSTRAINT `fk_matricula_aluno` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_funcionario1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_turma1` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id_turma`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `matricula`
--

/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;


--
-- Definition of table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
CREATE TABLE `pagamento` (
  `id_parcelas` int(11) NOT NULL AUTO_INCREMENT,
  `id_matricula` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `id_funcionario` int(11) NOT NULL,
  `valor_parcela` decimal(10,0) DEFAULT NULL,
  `data_apamento` date DEFAULT NULL,
  `valor_desconto` decimal(10,0) DEFAULT NULL,
  `valor_multa` decimal(10,0) DEFAULT NULL,
  `valor_pago` decimal(10,0) DEFAULT NULL,
  `pago` tinyint(4) DEFAULT NULL,
  `observacoes` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_parcelas`),
  KEY `fk_parcelas_matricula1_idx` (`id_matricula`),
  KEY `fk_parcelas_funcionario1_idx` (`id_funcionario`),
  KEY `fk_pagamento_aluno1_idx` (`id_aluno`),
  CONSTRAINT `fk_pagamento_aluno1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id_aluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_parcelas_funcionario1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_parcelas_matricula1` FOREIGN KEY (`id_matricula`) REFERENCES `matricula` (`id_matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pagamento`
--

/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;


--
-- Definition of table `turma`
--

DROP TABLE IF EXISTS `turma`;
CREATE TABLE `turma` (
  `id_turma` int(11) NOT NULL AUTO_INCREMENT,
  `turma` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_turma`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `turma`
--

/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` (`id_turma`,`turma`) VALUES 
 (1,'D'),
 (2,'JP'),
 (3,'D'),
 (5,'D'),
 (6,'D'),
 (7,'D'),
 (8,'D'),
 (9,'D'),
 (10,'D'),
 (11,'D'),
 (12,'D'),
 (13,'D'),
 (14,'D'),
 (15,'D'),
 (16,'D');
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
