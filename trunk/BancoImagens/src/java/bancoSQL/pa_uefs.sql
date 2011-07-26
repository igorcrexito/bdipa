# SQL-Front 5.1  (Build 4.16)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: pa_uefs
# ------------------------------------------------------
# Server version 5.5.10

DROP DATABASE IF EXISTS `pa_uefs`;
CREATE DATABASE `pa_uefs` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pa_uefs`;

#
# Source for table pacientes
#

DROP TABLE IF EXISTS `pacientes`;
CREATE TABLE `pacientes` (
  `Id` bigint(10) NOT NULL AUTO_INCREMENT,
  `sexo` int(1) NOT NULL DEFAULT '1',
  `idade` int(2) NOT NULL DEFAULT '1',
  `urlImagem` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Dumping data for table pacientes
#

LOCK TABLES `pacientes` WRITE;
/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
INSERT INTO `pacientes` VALUES (1,1,1,'C:/imagem.png');
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table usuario
#

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `RG` varchar(10) NOT NULL DEFAULT '',
  `nome` varchar(50) DEFAULT '',
  `instituicao` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `nivelAcesso` int(1) NOT NULL DEFAULT '0',
  `senha` varchar(20) DEFAULT '',
  PRIMARY KEY (`RG`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table usuario
#

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('01010101','Zeh','UEFS','ze@gmail.com',0,'senha1');
INSERT INTO `usuario` VALUES ('111','Renato Russo','Legião Urbana','rrusso@legiao.com.br',0,'papapop');
INSERT INTO `usuario` VALUES ('12132','Marcelo Bonfá','Legião Urbana','mbonfa@legiao.com.br',0,'uiui');
INSERT INTO `usuario` VALUES ('123','Zeh','UFBA','zehzeh@gmail.com',1,'ventando');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table usuariospacientes
#

DROP TABLE IF EXISTS `usuariospacientes`;
CREATE TABLE `usuariospacientes` (
  `Id` bigint(10) NOT NULL AUTO_INCREMENT,
  `RG` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id`,`RG`),
  KEY `RG` (`RG`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Dumping data for table usuariospacientes
#

LOCK TABLES `usuariospacientes` WRITE;
/*!40000 ALTER TABLE `usuariospacientes` DISABLE KEYS */;
INSERT INTO `usuariospacientes` VALUES (1,'01010101');
/*!40000 ALTER TABLE `usuariospacientes` ENABLE KEYS */;
UNLOCK TABLES;

#
#  Foreign keys for table usuariospacientes
#

ALTER TABLE `usuariospacientes`
ADD CONSTRAINT `id` FOREIGN KEY (`Id`) REFERENCES `pacientes` (`Id`),
ADD CONSTRAINT `RG` FOREIGN KEY (`RG`) REFERENCES `usuario` (`RG`);


/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
