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
# Server version 5.5.15

#
# Source for table conteudo
#

DROP TABLE IF EXISTS `conteudo`;
CREATE TABLE `conteudo` (
  `referencia` varchar(50) NOT NULL DEFAULT '',
  `tituloTexto` varchar(100) DEFAULT NULL,
  `texto` varchar(3000) DEFAULT NULL,
  `paginaLocalizado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`referencia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table conteudo
#

LOCK TABLES `conteudo` WRITE;
/*!40000 ALTER TABLE `conteudo` DISABLE KEYS */;
/*!40000 ALTER TABLE `conteudo` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `pacientes` VALUES (1,1,25,'C:/imagem.png');
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
  `senha` varchar(20) DEFAULT NULL,
  `login` varchar(25) DEFAULT NULL,
  `justificativa` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`RG`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table usuario
#

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('','','','',0,NULL,NULL,NULL);
INSERT INTO `usuario` VALUES ('123','Cleriston Sampaio','Uefs','cleriston@com',0,NULL,NULL,NULL);
INSERT INTO `usuario` VALUES ('1234','igor','231321','321321',0,NULL,NULL,NULL);
INSERT INTO `usuario` VALUES ('2131312','Cleriston de Oliveira Sampaio','321321','321321321',0,NULL,NULL,NULL);
INSERT INTO `usuario` VALUES ('213141213','cleriston','uefs','cleirston@uefs',0,NULL,NULL,NULL);
INSERT INTO `usuario` VALUES ('22','22','22','22',0,NULL,NULL,NULL);
INSERT INTO `usuario` VALUES ('234243','22','222','22',0,NULL,NULL,NULL);
INSERT INTO `usuario` VALUES ('53','Usuario Qualquerf','UNEBf','qualquer@gmail.comf',0,NULL,NULL,NULL);
INSERT INTO `usuario` VALUES ('dadad','cleuahsu','dadad','adad',0,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
