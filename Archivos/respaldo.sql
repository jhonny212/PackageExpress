-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: PACKAGE_EXPRESS
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `cui` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `nit` int(11) DEFAULT NULL,
  `direccion` varchar(30) NOT NULL,
  PRIMARY KEY (`cui`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (101010101,'cliente5',10101010,'quetzaltenango zona 4 av 3'),(1010101010,'cliente4',101010101,'quetzaltenango zona 4 av 3'),(1111111111,'cliente1',111111111,'quetzaltenango zona 4 ave 3'),(1234567890,'cliente2',222222222,'retalhuleu zona 3'),(2020202020,'cliente3',202020202,'quetzaltenango zona 4 av 3');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `controlPoint`
--

DROP TABLE IF EXISTS `controlPoint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `controlPoint` (
  `id_pc` int(11) NOT NULL AUTO_INCREMENT,
  `precioPc` int(11) NOT NULL,
  `direccion_rta` varchar(30) NOT NULL,
  `estadoPc` varchar(15) NOT NULL,
  `tamaño` int(11) NOT NULL,
  PRIMARY KEY (`id_pc`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controlPoint`
--

LOCK TABLES `controlPoint` WRITE;
/*!40000 ALTER TABLE `controlPoint` DISABLE KEYS */;
INSERT INTO `controlPoint` VALUES (6,3,'10','Operador1',5),(7,4,'10','Operador1',7),(8,3,'10','Operador1',7),(9,5,'10','Operador1',7),(10,5,'11','Operador1',10),(11,4,'11','Operador1',10),(12,4,'11','Operador1',8),(13,4,'11','Operador1',7),(14,4,'12','Operador2',7),(15,4,'12','Operador2',10),(16,5,'12','Operador2',10),(17,5,'12','Operador2',5),(18,3,'13','Operador2',5),(19,3,'13','Operador2',8),(20,3,'13','Operador2',4),(21,3,'13','Operador2',4),(22,3,'14','Operador4',4),(23,4,'14','Operador4',4),(24,4,'14','Operador4',5),(25,4,'14','Operador4',5);
/*!40000 ALTER TABLE `controlPoint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos`
--

DROP TABLE IF EXISTS `datos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datos` (
  `precioLibra` int(11) NOT NULL,
  `precioEnvio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos`
--

LOCK TABLES `datos` WRITE;
/*!40000 ALTER TABLE `datos` DISABLE KEYS */;
INSERT INTO `datos` VALUES (11,2);
/*!40000 ALTER TABLE `datos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ganancia`
--

DROP TABLE IF EXISTS `ganancia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ganancia` (
  `id_ganancia` int(11) NOT NULL AUTO_INCREMENT,
  `id_ruta` int(11) NOT NULL,
  `id_paquete` int(11) NOT NULL,
  `cui` int(11) NOT NULL,
  `ganancia` int(11) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id_ganancia`),
  KEY `FK_CUI` (`cui`),
  KEY `FK_PAQUETE` (`id_paquete`),
  KEY `FK_ruta` (`id_ruta`),
  CONSTRAINT `FK_CUI` FOREIGN KEY (`cui`) REFERENCES `cliente` (`cui`),
  CONSTRAINT `FK_PAQUETE` FOREIGN KEY (`id_paquete`) REFERENCES `paquete` (`id_paquete`),
  CONSTRAINT `FK_ruta` FOREIGN KEY (`id_ruta`) REFERENCES `ruta` (`id_ruta`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ganancia`
--

LOCK TABLES `ganancia` WRITE;
/*!40000 ALTER TABLE `ganancia` DISABLE KEYS */;
INSERT INTO `ganancia` VALUES (1,10,1,1234567890,32,'2019-08-01'),(2,10,2,1234567890,43,'2019-08-01'),(3,10,3,1234567890,32,'2019-08-01'),(4,11,4,1234567890,37,'2019-08-01'),(5,11,5,1234567890,37,'2019-08-01'),(6,14,6,1010101010,42,'2019-08-01'),(7,14,7,1010101010,42,'2019-08-01'),(8,14,8,1010101010,42,'2019-08-01'),(9,14,9,1010101010,42,'2019-08-01'),(10,14,10,1010101010,42,'2019-08-01'),(11,13,11,2020202020,42,'2019-08-01'),(12,13,12,2020202020,53,'2019-08-01'),(13,13,13,2020202020,53,'2019-08-01'),(14,13,14,2020202020,53,'2019-08-01'),(15,13,15,2020202020,53,'2019-08-01'),(16,12,16,101010101,37,'2019-08-01'),(17,12,17,101010101,37,'2019-08-01'),(18,12,18,101010101,37,'2019-08-01'),(19,12,19,101010101,37,'2019-08-01'),(20,12,20,101010101,37,'2019-08-01'),(21,11,21,101010101,37,'2019-08-01'),(22,11,22,101010101,37,'2019-08-01'),(23,11,23,101010101,37,'2019-08-01'),(24,11,24,101010101,37,'2019-08-01'),(25,11,25,101010101,37,'2019-08-01'),(26,10,26,101010101,43,'2019-08-01'),(27,11,27,101010101,48,'2019-08-01'),(28,11,28,101010101,48,'2019-08-01'),(29,14,29,1010101010,42,'2019-08-01'),(30,14,30,1010101010,42,'2019-08-01'),(31,14,31,1010101010,42,'2019-08-01'),(32,13,32,1111111111,42,'2019-08-01'),(33,13,33,1111111111,42,'2019-08-01'),(34,13,34,1111111111,42,'2019-08-01'),(35,12,35,1234567890,59,'2019-08-01'),(36,12,36,1234567890,59,'2019-08-01'),(37,12,37,1234567890,59,'2019-08-01'),(38,10,38,2020202020,32,'2019-08-01'),(39,10,39,2020202020,32,'2019-08-01'),(40,10,40,2020202020,32,'2019-08-01');
/*!40000 ALTER TABLE `ganancia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paquete`
--

DROP TABLE IF EXISTS `paquete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paquete` (
  `id_paquete` int(11) NOT NULL AUTO_INCREMENT,
  `peso` int(11) NOT NULL,
  `id_ruta` int(11) DEFAULT NULL,
  `estado` varchar(15) NOT NULL,
  `precio` int(11) NOT NULL,
  `prioridad` varchar(15) NOT NULL,
  `cui` int(11) NOT NULL,
  `id_pc` int(11) DEFAULT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id_paquete`),
  KEY `FK_CLIENTE_CUI` (`cui`),
  KEY `FK_RUTA_idrta` (`id_ruta`),
  CONSTRAINT `FK_CLIENTE_CUI` FOREIGN KEY (`cui`) REFERENCES `cliente` (`cui`),
  CONSTRAINT `FK_RUTA_idrta` FOREIGN KEY (`id_ruta`) REFERENCES `ruta` (`id_ruta`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paquete`
--

LOCK TABLES `paquete` WRITE;
/*!40000 ALTER TABLE `paquete` DISABLE KEYS */;
INSERT INTO `paquete` VALUES (1,2,10,'destino',8,'Sin prioridad',1234567890,-1,'2019-08-01'),(2,3,10,'destino',12,'Sin prioridad',1234567890,-1,'2019-08-01'),(3,2,10,'destino',8,'Sin prioridad',1234567890,-1,'2019-08-01'),(4,2,11,'destino',10,'Sin prioridad',1234567890,-1,'2019-08-01'),(5,2,11,'destino',10,'Sin prioridad',1234567890,-1,'2019-08-01'),(6,2,14,'destino',8,'Sin prioridad',1010101010,-1,'2019-08-01'),(7,2,14,'destino',8,'Sin prioridad',1010101010,-1,'2019-08-01'),(8,2,14,'destino',8,'Sin prioridad',1010101010,-1,'2019-08-01'),(9,2,14,'destino',8,'Sin prioridad',1010101010,-1,'2019-08-01'),(10,2,14,'destino',8,'Sin prioridad',1010101010,-1,'2019-08-01'),(11,2,13,'destino',8,'Sin prioridad',2020202020,-1,'2019-08-01'),(12,3,13,'destino',12,'Sin prioridad',2020202020,-1,'2019-08-01'),(13,3,13,'destino',12,'Sin prioridad',2020202020,-1,'2019-08-01'),(14,3,13,'destino',12,'Sin prioridad',2020202020,-1,'2019-08-01'),(15,3,13,'destino',12,'Sin prioridad',2020202020,-1,'2019-08-01'),(16,2,12,'destino',10,'Sin prioridad',101010101,-1,'2019-08-01'),(17,2,12,'destino',10,'Sin prioridad',101010101,-1,'2019-08-01'),(18,2,12,'destino',8,'Sin prioridad',101010101,-1,'2019-08-01'),(19,2,12,'destino',8,'Sin prioridad',101010101,-1,'2019-08-01'),(20,2,12,'destino',8,'Sin prioridad',101010101,-1,'2019-08-01'),(21,2,11,'destino',8,'Sin prioridad',101010101,-1,'2019-08-01'),(22,2,11,'destino',8,'Sin prioridad',101010101,-1,'2019-08-01'),(23,2,11,'destino',8,'Sin prioridad',101010101,-1,'2019-08-01'),(24,2,11,'destino',8,'Sin prioridad',101010101,-1,'2019-08-01'),(25,2,11,'destino',8,'Sin prioridad',101010101,-1,'2019-08-01'),(26,3,10,'by way',0,'Prioridad',101010101,6,'2019-08-01'),(27,3,11,'by way',0,'Prioridad',101010101,10,'2019-08-01'),(28,3,11,'by way',0,'Prioridad',101010101,10,'2019-08-01'),(29,2,14,'by way',0,'Prioridad',1010101010,22,'2019-08-01'),(30,2,14,'by way',0,'Prioridad',1010101010,22,'2019-08-01'),(31,2,14,'by way',0,'Prioridad',1010101010,22,'2019-08-01'),(32,2,13,'by way',0,'Sin prioridad',1111111111,18,'2019-08-01'),(33,2,13,'by way',0,'Sin prioridad',1111111111,18,'2019-08-01'),(34,2,13,'by way',0,'Sin prioridad',1111111111,18,'2019-08-01'),(35,4,12,'by way',0,'Sin prioridad',1234567890,14,'2019-08-01'),(36,4,12,'by way',0,'Sin prioridad',1234567890,14,'2019-08-01'),(37,4,12,'by way',0,'Sin prioridad',1234567890,14,'2019-08-01'),(38,2,10,'by way',0,'Sin prioridad',2020202020,6,'2019-08-01'),(39,2,10,'by way',0,'Sin prioridad',2020202020,6,'2019-08-01'),(40,2,10,'by way',0,'Sin prioridad',2020202020,6,'2019-08-01');
/*!40000 ALTER TABLE `paquete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruta`
--

DROP TABLE IF EXISTS `ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruta` (
  `id_ruta` int(11) NOT NULL AUTO_INCREMENT,
  `precio_rta` int(11) NOT NULL,
  `direccion_rta` varchar(30) DEFAULT NULL,
  `estado` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_ruta`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruta`
--

LOCK TABLES `ruta` WRITE;
/*!40000 ALTER TABLE `ruta` DISABLE KEYS */;
INSERT INTO `ruta` VALUES (10,10,'xela','activo'),(11,15,'guatemala','activo'),(12,15,'peten','activo'),(13,20,'izabal','activo'),(14,20,'coatepeque','activo');
/*!40000 ALTER TABLE `ruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `username` varchar(15) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `contraseña` varchar(15) NOT NULL,
  `tipoUser` varchar(15) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('Admin1','administrador','Admin1','Administrador'),('Admin2','administrador','Admin2','Administrador'),('Admin3','administrador','Admin3','Administrador'),('Operador1','operador','Operador','Operador'),('Operador2','operador','Operador2','Operador'),('Operador4','operador','Operador4','Operador'),('Recepcionista1','Recepcionista','Recepcionista','Recepcionista'),('Recepcionista2','Recepcionista','Recepcionista2','Recepcionista'),('Recepcionista3','Recepcionista','Recepcionista3','Recepcionista');
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

-- Dump completed on 2019-08-26 10:01:11
