CREATE DATABASE  IF NOT EXISTS `springbootp3.1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `springbootp3.1`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: springbootp3.1
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `fabric`
--

DROP TABLE IF EXISTS `fabric`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fabric` (
  `id` int NOT NULL AUTO_INCREMENT,
  `attachment` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fabric`
--

LOCK TABLES `fabric` WRITE;
/*!40000 ALTER TABLE `fabric` DISABLE KEYS */;
INSERT INTO `fabric` VALUES (1,NULL,'65% Polister, 35% Cotton','Blue mosaic pattern'),(2,NULL,'65% Polister, 35% Cotton','Solid green');
/*!40000 ALTER TABLE `fabric` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `measurement`
--

DROP TABLE IF EXISTS `measurement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `measurement` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `styleid` int DEFAULT NULL,
  `tolerance` varchar(255) DEFAULT NULL,
  `style_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4y4svget7hww2mjujpbejvrk7` (`style_id`),
  CONSTRAINT `FK4y4svget7hww2mjujpbejvrk7` FOREIGN KEY (`style_id`) REFERENCES `style` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measurement`
--

LOCK TABLES `measurement` WRITE;
/*!40000 ALTER TABLE `measurement` DISABLE KEYS */;
INSERT INTO `measurement` VALUES (1,'A','Chest bellow armhole',1,'0.5',1),(2,'B','Bottom hem',NULL,'0.5',1),(3,'C','Body length',NULL,'1',1),(4,'D','Across sholder',NULL,'0.5',1),(5,'E','Sleeve length',NULL,'0.5',1),(6,'F','Sleeve opening',NULL,'0.25',1),(7,'G','Arm hole',NULL,'0.25',1),(8,'H','Neck width',NULL,'0.25',1),(9,'I','Neck drop',NULL,'0.25',1),(10,'J','Neck rib high',NULL,'0.125',1),(11,'K','Neck drop (V Neck)',NULL,'0.125',1),(12,'L','Body length',NULL,'1',2);
/*!40000 ALTER TABLE `measurement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `measurement_attachment`
--

DROP TABLE IF EXISTS `measurement_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `measurement_attachment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `attachment` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `style_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdj71blokfbe8r5v16gxu0eci7` (`style_id`),
  CONSTRAINT `FKdj71blokfbe8r5v16gxu0eci7` FOREIGN KEY (`style_id`) REFERENCES `style` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measurement_attachment`
--

LOCK TABLES `measurement_attachment` WRITE;
/*!40000 ALTER TABLE `measurement_attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `measurement_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `measurement_size`
--

DROP TABLE IF EXISTS `measurement_size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `measurement_size` (
  `id` int NOT NULL AUTO_INCREMENT,
  `measurement` varchar(255) DEFAULT NULL,
  `measurement_id` int DEFAULT NULL,
  `size_id` int DEFAULT NULL,
  `style_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbyeueoic192s177rtj3xwmit3` (`measurement_id`),
  KEY `FK19sdxly71m1mkyr2odj2fifvt` (`size_id`),
  KEY `FKp5q49gxkaoa2g7d30u4cc6m2n` (`style_id`),
  CONSTRAINT `FK19sdxly71m1mkyr2odj2fifvt` FOREIGN KEY (`size_id`) REFERENCES `size` (`id`),
  CONSTRAINT `FKbyeueoic192s177rtj3xwmit3` FOREIGN KEY (`measurement_id`) REFERENCES `measurement` (`id`),
  CONSTRAINT `FKp5q49gxkaoa2g7d30u4cc6m2n` FOREIGN KEY (`style_id`) REFERENCES `style` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measurement_size`
--

LOCK TABLES `measurement_size` WRITE;
/*!40000 ALTER TABLE `measurement_size` DISABLE KEYS */;
INSERT INTO `measurement_size` VALUES (1,'18',1,4,1),(2,'18',2,4,1),(3,'26',3,4,1),(4,'15',4,4,1),(5,'7',5,4,1),(6,'5.5',6,4,1),(7,'8',7,4,1),(8,'6.75',8,4,1),(9,'2.25',9,4,1),(10,'0.75',10,4,1),(11,'4',11,4,1);
/*!40000 ALTER TABLE `measurement_size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raw_material_cat`
--

DROP TABLE IF EXISTS `raw_material_cat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `raw_material_cat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raw_material_cat`
--

LOCK TABLES `raw_material_cat` WRITE;
/*!40000 ALTER TABLE `raw_material_cat` DISABLE KEYS */;
INSERT INTO `raw_material_cat` VALUES (1,'Fabric'),(2,'Trim');
/*!40000 ALTER TABLE `raw_material_cat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size`
--

DROP TABLE IF EXISTS `size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `size` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES (1,'L'),(2,'M'),(3,'S'),(4,'XS');
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `style`
--

DROP TABLE IF EXISTS `style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `style` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `style_cat_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgwidilhdbxllaje3qqcl0l8f3` (`style_cat_id`),
  CONSTRAINT `FKgwidilhdbxllaje3qqcl0l8f3` FOREIGN KEY (`style_cat_id`) REFERENCES `style_categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `style`
--

LOCK TABLES `style` WRITE;
/*!40000 ALTER TABLE `style` DISABLE KEYS */;
INSERT INTO `style` VALUES (1,'2024-01-14 20:49:23.107000','2024-01-14 20:49:23.016000','RT123','Short sleeve shirt',4),(2,'2024-01-14 20:50:00.978000','2024-01-14 20:50:00.961000','RT025','Female dress',2);
/*!40000 ALTER TABLE `style` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `style_attachment`
--

DROP TABLE IF EXISTS `style_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `style_attachment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `attachment` varchar(255) DEFAULT NULL,
  `style_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdk86b2fj5gis6nyl7dw8gkpcp` (`style_id`),
  CONSTRAINT `FKdk86b2fj5gis6nyl7dw8gkpcp` FOREIGN KEY (`style_id`) REFERENCES `style` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `style_attachment`
--

LOCK TABLES `style_attachment` WRITE;
/*!40000 ALTER TABLE `style_attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `style_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `style_categories`
--

DROP TABLE IF EXISTS `style_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `style_categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `style_categories`
--

LOCK TABLES `style_categories` WRITE;
/*!40000 ALTER TABLE `style_categories` DISABLE KEYS */;
INSERT INTO `style_categories` VALUES (1,'Skirts'),(2,'Dress'),(3,'Trouser'),(4,'Shirt');
/*!40000 ALTER TABLE `style_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `style_material_quantity`
--

DROP TABLE IF EXISTS `style_material_quantity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `style_material_quantity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `style_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6dlppsf4mogovyquspbm7k2vl` (`style_id`),
  CONSTRAINT `FK6dlppsf4mogovyquspbm7k2vl` FOREIGN KEY (`style_id`) REFERENCES `style` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `style_material_quantity`
--

LOCK TABLES `style_material_quantity` WRITE;
/*!40000 ALTER TABLE `style_material_quantity` DISABLE KEYS */;
/*!40000 ALTER TABLE `style_material_quantity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `style_size`
--

DROP TABLE IF EXISTS `style_size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `style_size` (
  `id` int NOT NULL AUTO_INCREMENT,
  `size_id` int DEFAULT NULL,
  `style_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8ytkgcxej48tfjkfa7d8cmb43` (`size_id`),
  KEY `FKfhcg8wp7mlkoh4i75fr31h6ro` (`style_id`),
  CONSTRAINT `FK8ytkgcxej48tfjkfa7d8cmb43` FOREIGN KEY (`size_id`) REFERENCES `size` (`id`),
  CONSTRAINT `FKfhcg8wp7mlkoh4i75fr31h6ro` FOREIGN KEY (`style_id`) REFERENCES `style` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `style_size`
--

LOCK TABLES `style_size` WRITE;
/*!40000 ALTER TABLE `style_size` DISABLE KEYS */;
INSERT INTO `style_size` VALUES (1,1,1),(2,4,1),(3,2,1);
/*!40000 ALTER TABLE `style_size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trim`
--

DROP TABLE IF EXISTS `trim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trim` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trim`
--

LOCK TABLES `trim` WRITE;
/*!40000 ALTER TABLE `trim` DISABLE KEYS */;
INSERT INTO `trim` VALUES (1,'Thread'),(2,'Accessory'),(3,'Label'),(4,'Hook'),(5,'Elastic'),(6,'Lace'),(7,'Zipper'),(8,'Button');
/*!40000 ALTER TABLE `trim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uom`
--

DROP TABLE IF EXISTS `uom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uom` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uom`
--

LOCK TABLES `uom` WRITE;
/*!40000 ALTER TABLE `uom` DISABLE KEYS */;
/*!40000 ALTER TABLE `uom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `cell` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `contact_person` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-14 23:37:34
