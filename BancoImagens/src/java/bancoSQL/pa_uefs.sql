﻿# Host: localhost  (Version: 5.5.25)
# Date: 2012-07-05 15:40:05
# Generator: MySQL-Front 5.2  (Build 3.3)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

DROP DATABASE IF EXISTS `pa_uefs`;
CREATE DATABASE `pa_uefs` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pa_uefs`;

#
# Source for table "conteudo"
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
# Data for table "conteudo"
#

/*!40000 ALTER TABLE `conteudo` DISABLE KEYS */;
INSERT INTO `conteudo` VALUES ('1','Titulo','ifaghifdagfiagfiagkdjagdjkagdjaghifgaidgaidg','gsdgsdgs'),('sgsgsg','gfswgdsg','sgsgsg','sgsgdg'),('texto01','Imagens Cefalometricas','Hoje fizemos mais uma tarefa: Que ótimo!','home.xhtml');
/*!40000 ALTER TABLE `conteudo` ENABLE KEYS */;

#
# Source for table "pacientes"
#

DROP TABLE IF EXISTS `pacientes`;
CREATE TABLE `pacientes` (
  `Id` bigint(10) NOT NULL AUTO_INCREMENT,
  `sexo` int(1) NOT NULL DEFAULT '1',
  `idade` int(2) NOT NULL DEFAULT '1',
  `urlImagem` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `raca` int(1) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

#
# Data for table "pacientes"
#

/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;

#
# Source for table "paginas"
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
# Data for table "paginas"
#

/*!40000 ALTER TABLE `paginas` DISABLE KEYS */;
INSERT INTO `paginas` VALUES ('home','<p align=\"justify\"><b>Cefalometria</b> é a <a href=\"http://pt.wikipedia.org/wiki/Ci%C3%AAncia\" title=\"Ciência\">ciência</a> que, metodologicamente, estuda as dimensões das estruturas do <a href=\"http://pt.wikipedia.org/wiki/Cr%C3%A2nio\" title=\"Crânio\">crânio</a> e da <a href=\"http://pt.wikipedia.org/wiki/Face\" title=\"Face\">face</a>. Em <a href=\"http://pt.wikipedia.org/wiki/Odontologia\" title=\"Odontologia\">odontologia</a>, refere-se a certa combinação de medidas angulares e lineares desenvolvidas para o traçado de <a href=\"http://pt.wikipedia.org/wiki/Radiografia\" title=\"Radiografia\">radiografias</a>\r\n laterais e frontais do complexo craniofacial. É utilizada para avaliar o\r\n crescimento e o desenvolvimento craniofaciais de forma longitudinal, \r\nbem como auxiliar imesamente na determinação da natureza da resposta ao \r\ntratamento <a href=\"http://pt.wikipedia.org/wiki/Ortodontia\" title=\"Ortodontia\">ortodôntico</a>.</p><div align=\"justify\">\r\n</div><p align=\"justify\"><br>\r\nCefalo<u><i>metria é o conjunto de técnicas </i></u>que estuda as dimensões das \r\nestruturas anatomicas do crânio e da face Utilizadas, preferentemente na\r\n odontologia, para diagnósticos, planejamentos e acompanhamento das \r\nmodificações das dimensões das estruturas do crânio e da face. As \r\nmodidficações podem ser atraves de movimentação, adequaçao ortodontica \r\nou ato cirurgico É documentação de alguns tratamentos odontologicos . \r\n(Bonacin Filho 2009)</p>','Com este software você pode marcar pontos anatômicos sobre a imagem \r\ndigital da radiografia na tela. A partir daí ele confecciona \r\nautomaticamente as análises cefalométricas completas, incluindo \r\ncefalogramas e lista de fatores. As imagens das radiografias são obtidas\r\n de um scanner, câmera digital ou diretamente de um aparelho de Raio-X \r\ndigital. As vantagens de se trabalhar com imagens digitais são inúmeras.','James A McNamara, Jr., <a href=\"http://en.wikipedia.org/wiki/DDS\" title=\"DDS\">DDS</a> <a href=\"http://en.wikipedia.org/wiki/PhD\" title=\"PhD\" class=\"mw-redirect\">PhD</a> is a graduate of the <a href=\"http://en.wikipedia.org/wiki/University_of_California,_Berkeley\" title=\"University of California, Berkeley\">University of California, Berkeley</a>. He attended dental school at the <a href=\"http://en.wikipedia.org/wiki/University_of_California,_San_Francisco\" title=\"University of California, San Francisco\">University of California, San Francisco</a>, and continued on to a postgraduate residency in <a href=\"http://en.wikipedia.org/wiki/Orthodontics\" title=\"Orthodontics\">orthodontics</a> at the same institution. He then attended the <a href=\"http://en.wikipedia.org/wiki/University_of_Michigan\" title=\"University of Michigan\">University of Michigan</a>, where he received a doctorate is in <a href=\"http://en.wikipedia.org/wiki/Anatomy\" title=\"Anatomy\">anatomy</a> in <a href=\"http://en.wikipedia.org/wiki/1972\" title=\"1972\">1972</a>.<sup id=\"cite_ref-A_1-1\" class=\"reference\"><a href=\"http://en.wikipedia.org/wiki/James_A._McNamara#cite_note-A-1\"><span>[</span>2<span>]</span></a></sup>','teste campo4            '),('principaisanalises','a','b','c','d'),('principaisteoricos','<div align=\"justify\">Dr. Steiner nasceu e cresceu em uma fazenda em Kokomo, \r\nIndiana. Ele freqüentou a escola de odontologia em Indiana e era um \r\nestudante determinado em ortodontia na Universidade de Illinois então \r\nsob a direção de Dr. Allan G. Brodie. Ele também serviu como tenente na \r\nmarinha dos Estados Unidos. Dr. Ricketts recebeu incontáveis prêmios \r\nnacionais e internacionais foi um perito e uma autoridade na ciência do \r\ndesenvolvimento craniofacial humano. Teve um papel ativo e influenciou o\r\n processo educacional ortodôntico no EUA  e em diversas universidades \r\ninternacionais. Ele foi o fundador do <span style=\"font-style: italic;\">American Institute of Bioprogressive Education</span> ecolaborou para  instituir a <span style=\"font-style: italic;\">Foundation for Orthodontic Research (FOR)</span>.\r\n Foi um dos fundadores da terapia bioprogressiva e um dos maiores \r\nincentivadores no desenvolvimento de diagnósticos com ajuda do \r\ncomputador. Dr. Ricketts desenvolveu uma variedade de produtos ortodônticos inovadores que são usados em todo o mundo.<br>\r\n</div>\r\n','Dr. Harvold nasceu e cresceu em uma fazenda em Kokomo, \r\nIndiana. Ele freqüentou a escola de odontologia em Indiana e era um \r\nestudante determinado em ortodontia na Universidade de Illinois então \r\nsob a direção de Dr. Allan G. Brodie. Ele também serviu como tenente na \r\nmarinha dos Estados Unidos. Dr. Ricketts recebeu incontáveis prêmios \r\nnacionais e internacionais foi um perito e uma autoridade na ciência do \r\ndesenvolvimento craniofacial humano. Teve um papel ativo e influenciou o\r\n processo educacional ortodôntico no EUA  e em diversas universidades \r\ninternacionais. Ele foi o fundador do <span style=\"font-style: italic;\">American Institute of Bioprogressive Education</span> ecolaborou para  instituir a <span style=\"font-style: italic;\">Foundation for Orthodontic Research (FOR)</span>.\r\n Foi um dos fundadores da terapia bioprogressiva e um dos maiores \r\nincentivadores no desenvolvimento de diagnósticos com ajuda do \r\ncomputador. Dr. Ricketts desenvolveu uma variedade de produtos ortodônticos inovadores que são usados em todo o mundo.<br>','<div align=\"justify\">Dr. Robert M. Ricketts nasceu e cresceu em uma fazenda em Kokomo, \r\nIndiana. Ele freqüentou a escola de odontologia em Indiana e era um \r\nestudante determinado em ortodontia na Universidade de Illinois então \r\nsob a direção de Dr. Allan G. Brodie. Ele também serviu como tenente na \r\nmarinha dos Estados Unidos. Dr. Ricketts recebeu incontáveis prêmios \r\nnacionais e internacionais foi um perito e uma autoridade na ciência do \r\ndesenvolvimento craniofacial humano. Teve um papel ativo e influenciou o\r\n processo educacional ortodôntico no EUA  e em diversas universidades \r\ninternacionais. Ele foi o fundador do <span style=\"font-style: italic;\">American Institute of Bioprogressive Education</span> ecolaborou para  instituir a <span style=\"font-style: italic;\">Foundation for Orthodontic Research (FOR)</span>.\r\n Foi um dos fundadores da terapia bioprogressiva e um dos maiores \r\nincentivadores no desenvolvimento de diagnósticos com ajuda do \r\ncomputador. Dr. Ricketts desenvolveu uma variedade de produtos ortodônticos inovadores que são usados em todo o mundo.<br>\r\n</div>\r\n','vvvvv    ');
/*!40000 ALTER TABLE `paginas` ENABLE KEYS */;

#
# Source for table "questionario"
#

DROP TABLE IF EXISTS `questionario`;
CREATE TABLE `questionario` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) DEFAULT NULL,
  `formacao` varchar(30) DEFAULT NULL,
  `experienciaArea` int(2) DEFAULT '0',
  `experienciaSofts` int(2) DEFAULT '0',
  `avaliacao` int(2) DEFAULT '0',
  `sugestoescriticas` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "questionario"
#

/*!40000 ALTER TABLE `questionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `questionario` ENABLE KEYS */;

#
# Source for table "usuario"
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
# Data for table "usuario"
#

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('','','','',0,NULL,NULL,NULL),('1234','igor','231321','321321',2,'1234','igorcrexito','a');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
