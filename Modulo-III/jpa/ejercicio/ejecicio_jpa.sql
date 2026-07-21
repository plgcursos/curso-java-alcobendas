CREATE DATABASE  IF NOT EXISTS `ejercicio_jpa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ejercicio_jpa`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ejercicio_jpa
-- ------------------------------------------------------
-- Server version	8.0.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `idCategoria` int NOT NULL AUTO_INCREMENT,
  `categoria` varchar(255) DEFAULT NULL,
  `salarioConvenio` double NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'PROGRAMADOR JR',1035.5),(2,'PROGRAMADOR SR',1940),(3,'ADMINISTRATIVO',750),(4,'ANALISTA ORGANICO',1940),(5,'ANALISTA FUNCIONAL',2500),(6,'TECNICO SISTEMAS',1035.5),(7,'TECNICO SISTEMAS SR',1940);
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `categoria` varchar(255) DEFAULT NULL,
  `nroCliente` int NOT NULL,
  `id_cliente` int NOT NULL,
  PRIMARY KEY (`id_cliente`),
  CONSTRAINT `fk_clientes_personas` FOREIGN KEY (`id_cliente`) REFERENCES `personas` (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('ESPORADICO',135,3),('VIP',12,4),('HABITUAL',123,7),('VIP',13,8),('HABITUAL',124,10),('ESPORADICO',222,13),('VIP',22,14),('ESPORADICO',10987,19),('VIP',1987,20),('ESPORADICO',1357,36);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes_productos`
--

DROP TABLE IF EXISTS `clientes_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes_productos` (
  `idCliente` int NOT NULL,
  `idProducto` int NOT NULL,
  KEY `FK_fo288cseoqwqdivy6n0h0n9qa` (`idCliente`),
  KEY `FL_cliprod_productos` (`idProducto`),
  CONSTRAINT `FK_fo288cseoqwqdivy6n0h0n9qa` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`id_cliente`),
  CONSTRAINT `FL_cliprod_productos` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes_productos`
--

LOCK TABLES `clientes_productos` WRITE;
/*!40000 ALTER TABLE `clientes_productos` DISABLE KEYS */;
INSERT INTO `clientes_productos` VALUES (3,1),(3,3),(3,5),(3,10),(3,19),(4,19),(4,15),(7,6),(7,11),(7,19),(8,4),(8,18),(10,5),(13,2),(13,6),(13,10),(13,20),(14,20),(14,17),(19,2),(19,6),(19,10),(19,21),(20,21),(20,17);
/*!40000 ALTER TABLE `clientes_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colaboradores`
--

DROP TABLE IF EXISTS `colaboradores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colaboradores` (
  `nroProveedor` int NOT NULL,
  `servicio` varchar(255) DEFAULT NULL,
  `idPersona` int NOT NULL,
  PRIMARY KEY (`idPersona`),
  CONSTRAINT `fk_colaboradores_personas` FOREIGN KEY (`idPersona`) REFERENCES `personas` (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colaboradores`
--

LOCK TABLES `colaboradores` WRITE;
/*!40000 ALTER TABLE `colaboradores` DISABLE KEYS */;
INSERT INTO `colaboradores` VALUES (123456,'Servicio Medico',1),(123456,'Informatica',2),(123321,'Mantenimiento',6),(232323,'Asesor Externo',11),(123456,'Informatica',12),(129898,'Limpieza',16),(232323,'Asesor Externo',17),(123456,'Informatica',18),(129898,'Limpieza',22),(123456,'Servicio Medico',37),(123456,'Informatica',38);
/*!40000 ALTER TABLE `colaboradores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `nroEmpleado` int NOT NULL,
  `idPersona` int NOT NULL,
  `idcategoria` int DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  KEY `FK_hb2ckqvwo1x8cwe6vsixqxo9x` (`idcategoria`),
  CONSTRAINT `fk_empleados_personas` FOREIGN KEY (`idPersona`) REFERENCES `personas` (`idPersona`),
  CONSTRAINT `FK_hb2ckqvwo1x8cwe6vsixqxo9x` FOREIGN KEY (`idcategoria`) REFERENCES `categorias` (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (12345,5,2),(12346,9,5),(12348,15,5),(12349,21,7);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `idPersona` int NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,'Alemano'),(2,'Ayerza'),(3,'Creevy'),(4,'Fernandez Lobbe'),(5,'Galarza'),(6,'Herrera'),(7,'Perez'),(8,'Isa'),(9,'Lavanini'),(10,'Leguizamon'),(11,'Matera'),(12,'Montoya'),(13,'Noguera'),(14,'Ortega Desio'),(15,'Petti Pagadizabal'),(16,'Senatore'),(17,'Tetaz Chaparro'),(18,'Figallo'),(19,'Garcia Botta'),(20,'Agulla'),(21,'Marcos'),(22,'Bosch'),(23,'Cordero'),(24,'Cubelli'),(25,'Carter'),(26,'Hourcade'),(27,'Gomez'),(28,'Pani'),(29,'Bouza'),(30,'Quesada'),(31,'Salvat'),(32,'Pichot'),(33,'Arbizu'),(34,'Contepomi'),(35,'Simon'),(36,'Ramirez'),(37,'Porta'),(38,'Lopez');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `precio` double NOT NULL,
  `producto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,155.8,'Disco externo 1 Tb usb'),(2,12,'Cable HDMI 1.5m.'),(3,1000,'PC X3456'),(4,22.5,'Teclado USB Logitech'),(5,315,'Disco 4Tb usb 3.0'),(6,4.5,'Cable VGA'),(7,17.7,'Pen Drive 32 Gb USB 3.0'),(8,12,'Pen Drive 16 Gb USB 2.0'),(9,3,'Cable alimentacion PC'),(10,205,'Disco externo 2 Tb USB 3.0'),(11,607,'Portatil Toshiba X365B'),(12,550,'Portatil Acer A678'),(13,750.9,'IPad PRO'),(14,300,'Portatil Acer B444'),(15,72,'Disco Seagate SATA3 SS5'),(16,3.3,'Cable USB Impresora'),(17,9.75,'Cable adaptador VGA/HDMI'),(18,39,'Pen Drive 64 Gb USB 3.0'),(19,52.5,'Pen Drive 128 Gb USB 3.0'),(20,15.5,'Raton Logitech LT111'),(21,9.7,'Raton Logitech R456');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-07-21 16:05:22
