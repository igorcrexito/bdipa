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
CREATE DATABASE `pa_uefs` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pa_uefs`;

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
INSERT INTO `conteudo` VALUES ('1','Titulo','ifaghifdagfiagfiagkdjagdjkagdjaghifgaidgaidg','gsdgsdgs');
INSERT INTO `conteudo` VALUES ('sgsgsg','gfswgdsg','sgsgsg','sgsgdg');
INSERT INTO `conteudo` VALUES ('texto01','Imagens Cefalometricas','Hoje fizemos mais uma tarefa: Que ótimo!','home.xhtml');
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
# Source for table paginas
#

DROP TABLE IF EXISTS `paginas`;
CREATE TABLE `paginas` (
  `Nome` varchar(30) NOT NULL DEFAULT 'pag',
  `campo1` varchar(6000) DEFAULT NULL,
  `campo2` varchar(6000) DEFAULT NULL,
  `campo3` varchar(6000) DEFAULT NULL,
  `campo4` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table paginas
#

LOCK TABLES `paginas` WRITE;
/*!40000 ALTER TABLE `paginas` DISABLE KEYS */;
INSERT INTO `paginas` VALUES ('home','<p><b>Cefalometria</b> é a <a href=\"http://pt.wikipedia.org/wiki/Ci%C3%AAncia\" title=\"Ciência\">ciência</a> que, metodologicamente, estuda as dimensões das estruturas do <a href=\"http://pt.wikipedia.org/wiki/Cr%C3%A2nio\" title=\"Crânio\">crânio</a> e da <a href=\"http://pt.wikipedia.org/wiki/Face\" title=\"Face\">face</a>. Em <a href=\"http://pt.wikipedia.org/wiki/Odontologia\" title=\"Odontologia\">odontologia</a>, refere-se a certa combinação de medidas angulares e lineares desenvolvidas para o traçado de <a href=\"http://pt.wikipedia.org/wiki/Radiografia\" title=\"Radiografia\">radiografias</a>\r\n laterais e frontais do complexo craniofacial. É utilizada para avaliar o\r\n crescimento e o desenvolvimento craniofaciais de forma longitudinal, \r\nbem como auxiliar imesamente na determinação da natureza da resposta ao \r\ntratamento <a href=\"http://pt.wikipedia.org/wiki/Ortodontia\" title=\"Ortodontia\">ortodôntico</a>.</p>\r\n<p><br>\r\nCefalometria é o conjunto de técnicas que estuda as dimensões das \r\nestruturas anatomicas do crânio e da face Utilizadas, preferentemente na\r\n odontologia, para diagnósticos, planejamentos e acompanhamento das \r\nmodificações das dimensões das estruturas do crânio e da face. As \r\nmodidficações podem ser atraves de movimentação, adequaçao ortodontica \r\nou ato cirurgico É documentação de alguns tratamentos odontologicos . \r\n(Bonacin Filho 2009)</p>','Com este software você pode marcar pontos anatômicos sobre a imagem \r\ndigital da radiografia na tela. A partir daí ele confecciona \r\nautomaticamente as análises cefalométricas completas, incluindo \r\ncefalogramas e lista de fatores. As imagens das radiografias são obtidas\r\n de um scanner, câmera digital ou diretamente de um aparelho de Raio-X \r\ndigital. As vantagens de se trabalhar com imagens digitais são inúmeras.','James A McNamara, Jr., <a href=\"http://en.wikipedia.org/wiki/DDS\" title=\"DDS\">DDS</a> <a href=\"http://en.wikipedia.org/wiki/PhD\" title=\"PhD\" class=\"mw-redirect\">PhD</a> is a graduate of the <a href=\"http://en.wikipedia.org/wiki/University_of_California,_Berkeley\" title=\"University of California, Berkeley\">University of California, Berkeley</a>. He attended dental school at the <a href=\"http://en.wikipedia.org/wiki/University_of_California,_San_Francisco\" title=\"University of California, San Francisco\">University of California, San Francisco</a>, and continued on to a postgraduate residency in <a href=\"http://en.wikipedia.org/wiki/Orthodontics\" title=\"Orthodontics\">orthodontics</a> at the same institution. He then attended the <a href=\"http://en.wikipedia.org/wiki/University_of_Michigan\" title=\"University of Michigan\">University of Michigan</a>, where he received a doctorate is in <a href=\"http://en.wikipedia.org/wiki/Anatomy\" title=\"Anatomy\">anatomy</a> in <a href=\"http://en.wikipedia.org/wiki/1972\" title=\"1972\">1972</a>.<sup id=\"cite_ref-A_1-1\" class=\"reference\"><a href=\"http://en.wikipedia.org/wiki/James_A._McNamara#cite_note-A-1\"><span>[</span>2<span>]</span></a></sup>','teste campo4         ');
INSERT INTO `paginas` VALUES ('principaisteoricos','aaaa','eeee','2222','vvvvv');
/*!40000 ALTER TABLE `paginas` ENABLE KEYS */;
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
INSERT INTO `usuario` VALUES ('uh','uh','u','hu',0,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
