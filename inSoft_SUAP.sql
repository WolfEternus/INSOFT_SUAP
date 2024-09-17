CREATE DATABASE  IF NOT EXISTS `ds-examen` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ds-examen`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: ds-examen
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor` (
  `idProfesor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `RFC` varchar(13) NOT NULL,
  PRIMARY KEY (`idProfesor`),
  UNIQUE KEY `RFC` (`RFC`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'andre','garcia','GAGH010401RFC'),(2,'Alonso','Ruiz de Chavez','QWER123456RFC'),(3,'ALBERTO','SILVA','ASDF123456RFC'),(4,'ADAN','SERVIN','FFFF123456RFC'),(5,'DANIA','RODRIGUEZ','DFGG123456RFC'),(9,'ALEJANDRO','PEREZ','PEAL123456RFC');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor_tiene_unidad_de_aprendizaje`
--

DROP TABLE IF EXISTS `profesor_tiene_unidad_de_aprendizaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor_tiene_unidad_de_aprendizaje` (
  `idProfesor` int(11) NOT NULL,
  `idUnidadAprendizaje` int(11) NOT NULL,
  PRIMARY KEY (`idProfesor`,`idUnidadAprendizaje`),
  KEY `idUnidadAprendizaje` (`idUnidadAprendizaje`),
  CONSTRAINT `profesor_tiene_unidad_de_aprendizaje_ibfk_1` FOREIGN KEY (`idProfesor`) REFERENCES `profesor` (`idProfesor`),
  CONSTRAINT `profesor_tiene_unidad_de_aprendizaje_ibfk_2` FOREIGN KEY (`idUnidadAprendizaje`) REFERENCES `unidad_de_aprendizaje` (`idUnidadAprendizaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor_tiene_unidad_de_aprendizaje`
--

LOCK TABLES `profesor_tiene_unidad_de_aprendizaje` WRITE;
/*!40000 ALTER TABLE `profesor_tiene_unidad_de_aprendizaje` DISABLE KEYS */;
INSERT INTO `profesor_tiene_unidad_de_aprendizaje` VALUES (1,1);
/*!40000 ALTER TABLE `profesor_tiene_unidad_de_aprendizaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad_de_aprendizaje`
--

DROP TABLE IF EXISTS `unidad_de_aprendizaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidad_de_aprendizaje` (
  `idUnidadAprendizaje` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `horario` varchar(50) DEFAULT NULL,
  `horasClase` int(11) NOT NULL,
  `horasTaller` int(11) NOT NULL,
  `horasLaboratorio` int(11) NOT NULL,
  PRIMARY KEY (`idUnidadAprendizaje`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad_de_aprendizaje`
--

LOCK TABLES `unidad_de_aprendizaje` WRITE;
/*!40000 ALTER TABLE `unidad_de_aprendizaje` DISABLE KEYS */;
INSERT INTO `unidad_de_aprendizaje` VALUES (1,'Algoritmos','5 a 7',3,1,2);
/*!40000 ALTER TABLE `unidad_de_aprendizaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `idProfesor` int(11) DEFAULT NULL,
  `correo` varchar(100) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `correo` (`correo`),
  KEY `idProfesor` (`idProfesor`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idProfesor`) REFERENCES `profesor` (`idProfesor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,'andre.garcia23','AL01168113','profesor');
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

-- Dump completed on 2024-09-17  2:43:26
