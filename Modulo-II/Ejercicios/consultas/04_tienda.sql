CREATE DATABASE  IF NOT EXISTS `04_tienda` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `04_tienda`;
-- MySQL dump 10.13  Distrib 5.7.25, for Win64 (x86_64)
--
-- Host: localhost    Database: 0_tienda
-- ------------------------------------------------------
-- Server version	5.7.25-log

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
-- Table structure for table `fabricantes`
--

DROP TABLE IF EXISTS `fabricantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fabricantes` (
  `id_fabricante` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fabricante` varchar(100) NOT NULL,
  PRIMARY KEY (`id_fabricante`),
  UNIQUE KEY `id_fabricante` (`id_fabricante`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fabricantes`
--

LOCK TABLES `fabricantes` WRITE;
/*!40000 ALTER TABLE `fabricantes` DISABLE KEYS */;
INSERT INTO `fabricantes` VALUES (1,'Asus'),(2,'Lenovo'),(3,'Hewlett-Packard'),(4,'Samsung'),(5,'Seagate'),(6,'Crucial'),(7,'Gigabyte'),(8,'Huawei'),(9,'Xiaomi');
/*!40000 ALTER TABLE `fabricantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `id_producto` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `producto` varchar(100) NOT NULL,
  `precio` double NOT NULL,
  `fk_fabricante` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  UNIQUE KEY `id_producto` (`id_producto`),
  KEY `fk_fabricante` (`fk_fabricante`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`fk_fabricante`) REFERENCES `fabricantes` (`id_fabricante`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Disco duro SATA3 1TB',86.99,5),(2,'Memoria RAM DDR4 8GB',120,6),(3,'Disco SSD 1 TB',150.99,4),(4,'GeForce GTX 1050Ti',185,7),(5,'GeForce GTX 1080 Xtreme',755,6),(6,'Monitor 24 LED Full HD',202,1),(7,'Monitor 27 LED Full HD',245.99,1),(8,'Portátil Yoga 520',559,2),(9,'Portátil Ideapd 320',444,2),(10,'Impresora HP Deskjet 3720',59.99,3),(11,'Impresora HP Laserjet Pro M26nw',180,3);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventas` (
  `id_venta` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cantidad` int(10) unsigned NOT NULL,
  `precio_unidad` decimal(7,2) NOT NULL,
  PRIMARY KEY (`id_venta`),
  UNIQUE KEY `id_venta` (`id_venta`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,2,1.50),(2,5,1.75),(3,7,2.00),(4,9,3.50),(5,6,9.99);
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-13  1:13:44
