CREATE DATABASE  IF NOT EXISTS `rm_e` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `rm_e`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: rm_e
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consulta` (
  `idconsulta` int(11) NOT NULL AUTO_INCREMENT,
  `data` varchar(45) DEFAULT NULL,
  `local` varchar(45) NOT NULL,
  `hora` varchar(45) DEFAULT NULL,
  `usuario_medico` int(11) NOT NULL,
  `usuario_paciente` int(11) NOT NULL,
  PRIMARY KEY (`idconsulta`),
  KEY `fk_consulta_usuario1_idx` (`usuario_medico`),
  KEY `fk_consulta_usuario2_idx` (`usuario_paciente`),
  CONSTRAINT `fk_consulta_usuario1` FOREIGN KEY (`usuario_medico`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_consulta_usuario2` FOREIGN KEY (`usuario_paciente`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exame`
--

DROP TABLE IF EXISTS `exame`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exame` (
  `idexame` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `consulta_idconsulta` int(11) NOT NULL,
  PRIMARY KEY (`idexame`),
  KEY `fk_exame_consulta1_idx` (`consulta_idconsulta`),
  CONSTRAINT `fk_exame_consulta1` FOREIGN KEY (`consulta_idconsulta`) REFERENCES `consulta` (`idconsulta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exame`
--

LOCK TABLES `exame` WRITE;
/*!40000 ALTER TABLE `exame` DISABLE KEYS */;
/*!40000 ALTER TABLE `exame` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicamento` (
  `idmedicamento` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `manipuladoura` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmedicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receita`
--

DROP TABLE IF EXISTS `receita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receita` (
  `idreceita` int(11) NOT NULL AUTO_INCREMENT,
  `usada` tinyint(4) DEFAULT '0',
  `cancelada` tinyint(4) DEFAULT '0',
  `consulta_idconsulta` int(11) NOT NULL,
  `instrucoes_uso` varchar(45) NOT NULL,
  PRIMARY KEY (`idreceita`),
  KEY `fk_receita_consulta1_idx` (`consulta_idconsulta`),
  CONSTRAINT `fk_receita_consulta1` FOREIGN KEY (`consulta_idconsulta`) REFERENCES `consulta` (`idconsulta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receita`
--

LOCK TABLES `receita` WRITE;
/*!40000 ALTER TABLE `receita` DISABLE KEYS */;
/*!40000 ALTER TABLE `receita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receita_has_medicamento`
--

DROP TABLE IF EXISTS `receita_has_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receita_has_medicamento` (
  `receita_idreceita` int(11) NOT NULL,
  `medicamento_idmedicamento` int(11) NOT NULL,
  `vendido` tinyint(4) NOT NULL DEFAULT '0',
  `dataVenda` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`receita_idreceita`,`medicamento_idmedicamento`),
  KEY `fk_receita_has_medicamento_medicamento1_idx` (`medicamento_idmedicamento`),
  KEY `fk_receita_has_medicamento_receita1_idx` (`receita_idreceita`),
  CONSTRAINT `fk_receita_has_medicamento_medicamento1` FOREIGN KEY (`medicamento_idmedicamento`) REFERENCES `medicamento` (`idmedicamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_receita_has_medicamento_receita1` FOREIGN KEY (`receita_idreceita`) REFERENCES `receita` (`idreceita`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receita_has_medicamento`
--

LOCK TABLES `receita_has_medicamento` WRITE;
/*!40000 ALTER TABLE `receita_has_medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `receita_has_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `tipo` int(11) NOT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Admin','123456','admin','admin@admin.com',4,'teste'),(3,'Medico','123456','testeMedico','teste',1,'teste'),(4,'Paciente','123456','testePaciente','teste',3,'teste'),(5,'Farmaceutico','123456','testeFarma','testeFarma',2,'testeFarma');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-23 20:24:48
