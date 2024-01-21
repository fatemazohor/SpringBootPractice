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
-- Table structure for table `buyers`
--

DROP TABLE IF EXISTS `buyers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buyers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `contact_person` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `organization` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyers`
--

LOCK TABLES `buyers` WRITE;
/*!40000 ALTER TABLE `buyers` DISABLE KEYS */;
INSERT INTO `buyers` VALUES (1,'andmere Ln, Edwalton Village Ward, Nottinghams','Amanda Hallock','UK','quantumclothing@gmail.com','Quantum Clothing Group','+44 1623447200'),(2,'79 Wells St, London, Greater London, W1T 3QN','Shahid MIa','UK','dck@gmail.com','DCK Group','+44 1277844437'),(3,'165 Howard St, Glasgow, Glasgow, G1 4HF','Jackie Papson','UK','slaters@gmail.com','Slater Menswear','+44 3303636071');
/*!40000 ALTER TABLE `buyers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Pattern & Cutting'),(2,'	Sewing'),(3,'Ironing & Packing');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Table structure for table `labor_cost`
--

DROP TABLE IF EXISTS `labor_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `labor_cost` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hour` double NOT NULL,
  `unit_cost` double NOT NULL,
  `department_id_id` int DEFAULT NULL,
  `style_id_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6h36iv21v5ycilexoa1dau85s` (`department_id_id`),
  KEY `FK56s77lgnduiuqlw3ahawg0n0n` (`style_id_id`),
  CONSTRAINT `FK56s77lgnduiuqlw3ahawg0n0n` FOREIGN KEY (`style_id_id`) REFERENCES `style` (`id`),
  CONSTRAINT `FK6h36iv21v5ycilexoa1dau85s` FOREIGN KEY (`department_id_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `labor_cost`
--

LOCK TABLES `labor_cost` WRITE;
/*!40000 ALTER TABLE `labor_cost` DISABLE KEYS */;
INSERT INTO `labor_cost` VALUES (1,0.1,40,1,1),(2,0.1,40,1,2),(3,1.2,120,2,2),(4,0.5,40,3,2);
/*!40000 ALTER TABLE `labor_cost` ENABLE KEYS */;
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
INSERT INTO `measurement` VALUES (1,'A','Chest bellow armhole',1,'0.5',1),(2,'B','Bottom hem',1,'0.5',1),(3,'C','Body length',1,'1',1),(4,'D','Across sholder',1,'0.5',1),(5,'E','Sleeve length',1,'0.5',1),(6,'F','Sleeve opening',1,'0.25',1),(7,'G','Arm hole',1,'0.25',1),(8,'H','Neck width',1,'0.25',1),(9,'I','Neck drop',1,'0.25',1),(10,'J','Neck rib high',1,'0.125',1),(11,'K','Neck drop (V Neck)',1,'0.125',1),(12,'L','Body length',2,'1',2);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measurement_attachment`
--

LOCK TABLES `measurement_attachment` WRITE;
/*!40000 ALTER TABLE `measurement_attachment` DISABLE KEYS */;
INSERT INTO `measurement_attachment` VALUES (1,'measurement_att_1705598896585.JPG','Front',2),(2,'measurement_att_1705598928656.JPG','Back',2),(3,'measurement_att_1705598968193.JPG','Stich',2);
/*!40000 ALTER TABLE `measurement_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `measurement_details`
--

DROP TABLE IF EXISTS `measurement_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `measurement_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `large` varchar(255) DEFAULT NULL,
  `medium` varchar(255) DEFAULT NULL,
  `small` varchar(255) DEFAULT NULL,
  `tolerance` varchar(255) DEFAULT NULL,
  `style_id_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjp48ukxm0ck846mvm9nwocb4e` (`style_id_id`),
  CONSTRAINT `FKjp48ukxm0ck846mvm9nwocb4e` FOREIGN KEY (`style_id_id`) REFERENCES `style` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measurement_details`
--

LOCK TABLES `measurement_details` WRITE;
/*!40000 ALTER TABLE `measurement_details` DISABLE KEYS */;
INSERT INTO `measurement_details` VALUES (1,'Chest bellow armhole','21','20','18','0.5',1),(2,'Bottom hem','21','20','18','0.5',1),(3,'Body length','29','28','26','1',1),(4,'Across sholder','18','17','15','0.5',1),(5,'Sleeve length','8.5','8','7','0.5',1),(6,'Sleeve opening','6.25','6','5.5','0.25',1),(7,'Arm hole','9.5','9','8','0.25',1),(8,'Neck width','7','7','6.75','0.25',1),(9,'Neck drop','2.75','2.5','2.25','0.25',1),(10,'Neck rib high','0.75','0.75','0.75','0.125',1),(11,'Neck drop (V Neck)','4.25','4.25','4','0.125',1),(12,'Chest','39','37','35','0.25',2),(13,'Length of the Garment','44','43','42','0.25',2),(14,'Waist','32','30','28','0.25',2),(15,'Hip','48','46','44','0.25',2),(16,'Armhole','10','9.5','9.1','0.125',2),(17,'Neck Depth','7','7','7','0.125',2),(18,'Shoulder Width','4','3.5','3','0.125',2),(19,'Sleeve Length','6','5.5','5','0.25',2),(20,'Sleeve Curve','10.3','9.6','9.3','0.125',2),(21,'Ruffle Width','5','5','5','0.125',2),(22,'Waistband Length','38','36','34','0.125',2),(23,'Waistband Width','2','2','2','0.125',2);
/*!40000 ALTER TABLE `measurement_details` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measurement_size`
--

LOCK TABLES `measurement_size` WRITE;
/*!40000 ALTER TABLE `measurement_size` DISABLE KEYS */;
INSERT INTO `measurement_size` VALUES (1,'18',1,4,1),(2,'18',2,4,1),(3,'26',3,4,1),(4,'15',4,4,1),(5,'7',5,4,1),(6,'5.5',6,4,1),(7,'8',7,4,1),(8,'6.75',8,4,1),(9,'2.25',9,4,1),(10,'0.75',10,4,1),(11,'4',11,4,1),(12,'18',12,1,2),(13,'18',1,2,1),(14,'20',1,1,1);
/*!40000 ALTER TABLE `measurement_size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_amount`
--

DROP TABLE IF EXISTS `order_amount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_amount` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_amount`
--

LOCK TABLES `order_amount` WRITE;
/*!40000 ALTER TABLE `order_amount` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_amount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `delivery_date` date DEFAULT NULL,
  `oder_date` date DEFAULT NULL,
  `l_amount` double NOT NULL,
  `m_amount` double NOT NULL,
  `order_uni_id` varchar(255) DEFAULT NULL,
  `paid` double NOT NULL,
  `s_amount` double NOT NULL,
  `shipping_date` varchar(255) DEFAULT NULL,
  `total_amount` double NOT NULL,
  `buyers_id_id` int DEFAULT NULL,
  `or_status_id_id` int DEFAULT NULL,
  `style_id_id` int DEFAULT NULL,
  `shipping_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmcrs12i81xsmtv0ytg31hca00` (`buyers_id_id`),
  KEY `FKg9x15j7e7g04cgjr4xte28od1` (`or_status_id_id`),
  KEY `FK443dun3htm2bjja5tu58y12il` (`style_id_id`),
  CONSTRAINT `FK443dun3htm2bjja5tu58y12il` FOREIGN KEY (`style_id_id`) REFERENCES `style` (`id`),
  CONSTRAINT `FKg9x15j7e7g04cgjr4xte28od1` FOREIGN KEY (`or_status_id_id`) REFERENCES `order_status` (`id`),
  CONSTRAINT `FKmcrs12i81xsmtv0ytg31hca00` FOREIGN KEY (`buyers_id_id`) REFERENCES `buyers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
INSERT INTO `order_details` VALUES (1,'2024-01-21','2024-01-01',10,10,NULL,300,10,NULL,300,1,1,1,'UK'),(2,'2024-01-22','2024-01-02',0,0,NULL,3000.02,0,NULL,3000.02,2,1,1,'UK');
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_status`
--

DROP TABLE IF EXISTS `order_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_status`
--

LOCK TABLES `order_status` WRITE;
/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
INSERT INTO `order_status` VALUES (1,'Invoiced'),(2,'Processing'),(3,'Shifted'),(4,'Delivered');
/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raw_material`
--

DROP TABLE IF EXISTS `raw_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `raw_material` (
  `id` int NOT NULL AUTO_INCREMENT,
  `attachment` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `unit_price` double NOT NULL,
  `raw_material_cat_id` int DEFAULT NULL,
  `style_id` int DEFAULT NULL,
  `uom_id` int DEFAULT NULL,
  `vendor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrj2h8libq3wj8k8fyw91njspc` (`raw_material_cat_id`),
  KEY `FKoexb0fyhgkp2wgdygbnashyq4` (`style_id`),
  KEY `FKj6u92lrcx0fwa8wo36ukouorg` (`uom_id`),
  KEY `FKklvm1khdl6tlh9bplm46xxljr` (`vendor_id`),
  CONSTRAINT `FK1aw80id49yggquwhhb00u697` FOREIGN KEY (`vendor_id`) REFERENCES `vendors` (`id`),
  CONSTRAINT `FKj6u92lrcx0fwa8wo36ukouorg` FOREIGN KEY (`uom_id`) REFERENCES `uom` (`id`),
  CONSTRAINT `FKklvm1khdl6tlh9bplm46xxljr` FOREIGN KEY (`vendor_id`) REFERENCES `uom` (`id`),
  CONSTRAINT `FKoexb0fyhgkp2wgdygbnashyq4` FOREIGN KEY (`style_id`) REFERENCES `style` (`id`),
  CONSTRAINT `FKrj2h8libq3wj8k8fyw91njspc` FOREIGN KEY (`raw_material_cat_id`) REFERENCES `raw_material_cat` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raw_material`
--

LOCK TABLES `raw_material` WRITE;
/*!40000 ALTER TABLE `raw_material` DISABLE KEYS */;
INSERT INTO `raw_material` VALUES (1,NULL,'65% Polister, 35% Cotton','Blue mosaic pattern',55,1,1,1,1),(2,NULL,'Brand and wash care label','Brand label',1.5,2,1,3,3),(3,NULL,'65% Polister, 35% Cotton','Solid green',45,1,1,1,2),(4,'material_att_1705608331248.JPG','70%Modal 30%Cupro','Jersey Knit fabric - Polka Dot  Print',58,1,2,1,1),(5,'material_att_1705608470104.JPG','Single sided satin Weave Swift Tack through side seam','Wash Care Label',45,2,2,3,5),(6,'material_att_1705608540308.JPG','knitted interlining fabric, Woven, 45 gsm, 100%  Polyester','Fabric Fusing',55,1,2,1,1),(7,'material_att_1705608603157.JPG','Good Quality Coats Sewing Thread','Sewing Thread',18,2,2,7,4),(8,'material_att_1705608660955.JPG','Eco friendly sustainable hand tag - with a natural twine  to attach','Hang Tag',1.5,2,1,3,1),(9,'material_att_1705608746129.JPG','Screen Printed Brand Logo Woven Label','Main Label',1.5,2,2,3,3),(10,'material_att_1705608775661.JPG','Bio-degradable Packaging Plastic Bag Non-woven Bag','Poly Bag',0.5,2,2,3,1);
/*!40000 ALTER TABLE `raw_material` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `style_attachment`
--

LOCK TABLES `style_attachment` WRITE;
/*!40000 ALTER TABLE `style_attachment` DISABLE KEYS */;
INSERT INTO `style_attachment` VALUES (1,'style_att_1705643096760.JPG',2),(2,'style_att_1705728483604.jpg',1);
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
  `quantity` double NOT NULL,
  `raw_material_id` int DEFAULT NULL,
  `size_id` int DEFAULT NULL,
  `style_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmsagjajeh3rh6sqyr5gpne0w0` (`raw_material_id`),
  KEY `FKgv4qj4spn6nh62ra855ipawg7` (`size_id`),
  KEY `FK6dlppsf4mogovyquspbm7k2vl` (`style_id`),
  CONSTRAINT `FK6dlppsf4mogovyquspbm7k2vl` FOREIGN KEY (`style_id`) REFERENCES `style` (`id`),
  CONSTRAINT `FKgv4qj4spn6nh62ra855ipawg7` FOREIGN KEY (`size_id`) REFERENCES `size` (`id`),
  CONSTRAINT `FKmsagjajeh3rh6sqyr5gpne0w0` FOREIGN KEY (`raw_material_id`) REFERENCES `raw_material` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `style_material_quantity`
--

LOCK TABLES `style_material_quantity` WRITE;
/*!40000 ALTER TABLE `style_material_quantity` DISABLE KEYS */;
INSERT INTO `style_material_quantity` VALUES (1,28,4,3,2),(2,5,6,3,2),(3,1,7,3,2),(4,1,8,3,2),(5,1,10,3,2),(6,1,9,3,2),(7,1,5,3,2),(8,30,4,2,2),(9,5,6,2,2),(10,1,7,2,2),(11,1,8,2,2),(12,1,10,2,2),(13,1,9,2,2),(14,1,5,2,2),(15,32,4,1,2),(16,6,6,1,2),(17,1,7,1,2),(18,1,8,1,2),(19,1,10,1,2),(20,1,9,1,2),(21,1,5,1,2);
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
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'Confirmation of order'),(2,'Release raw material PO'),(3,'Raw material in store'),(4,'PP meeting'),(5,'Production planning'),(6,'Cutting'),(7,'Sewing'),(8,'Embroidery'),(9,'Re-cutting'),(10,'Washing');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_action`
--

DROP TABLE IF EXISTS `time_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_action` (
  `id` int NOT NULL,
  `actual_end_date` date DEFAULT NULL,
  `actual_start_date` date DEFAULT NULL,
  `expected_end_date` date DEFAULT NULL,
  `expected_start_date` date DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `order_id_id` int DEFAULT NULL,
  `task_id_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh0exxc7qcdc1jywc1157k89ip` (`order_id_id`),
  KEY `FK95ion5cygoo3vwo4d9ufq9xg` (`task_id_id`),
  CONSTRAINT `FK95ion5cygoo3vwo4d9ufq9xg` FOREIGN KEY (`task_id_id`) REFERENCES `task` (`id`),
  CONSTRAINT `FKh0exxc7qcdc1jywc1157k89ip` FOREIGN KEY (`order_id_id`) REFERENCES `order_details` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_action`
--

LOCK TABLES `time_action` WRITE;
/*!40000 ALTER TABLE `time_action` DISABLE KEYS */;
INSERT INTO `time_action` VALUES (1,'2024-01-02','2024-01-02','2024-01-01','2024-01-01','Start',1,1),(2,'2024-01-03','2024-01-03','2024-01-02','2024-01-02','',1,2),(3,'2024-01-04','2024-01-04','2024-01-04','2024-01-04','',1,3),(4,'2024-01-05','2024-01-05','2024-01-05','2024-01-05','',1,4),(5,'2024-01-06','2024-01-06','2024-01-06','2024-01-06','',1,5),(6,'2024-01-10','2024-01-08','2024-01-09','2024-01-07','',1,6),(7,'2024-01-13','2024-01-11','2024-01-12','2024-01-10','',1,7),(8,'2024-01-17','2024-01-15','2024-01-16','2024-01-14','',1,8),(9,'2024-01-19','2024-01-17','2024-01-18','2024-01-16','',1,9),(10,'2024-01-24','2024-01-20','2024-01-21','2024-01-19','',1,10);
/*!40000 ALTER TABLE `time_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_action_seq`
--

DROP TABLE IF EXISTS `time_action_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_action_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_action_seq`
--

LOCK TABLES `time_action_seq` WRITE;
/*!40000 ALTER TABLE `time_action_seq` DISABLE KEYS */;
INSERT INTO `time_action_seq` VALUES (101);
/*!40000 ALTER TABLE `time_action_seq` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uom`
--

LOCK TABLES `uom` WRITE;
/*!40000 ALTER TABLE `uom` DISABLE KEYS */;
INSERT INTO `uom` VALUES (1,'Yard'),(2,'Mitter'),(3,'Piece'),(4,'Box'),(5,'Roll'),(7,'Cone');
/*!40000 ALTER TABLE `uom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendors`
--

DROP TABLE IF EXISTS `vendors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `cell` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `contact_person` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendors`
--

LOCK TABLES `vendors` WRITE;
/*!40000 ALTER TABLE `vendors` DISABLE KEYS */;
INSERT INTO `vendors` VALUES (1,'Khagan, Birulia (Ashulia), Savar Dhaka-1341, Bangladesh.','8801955577607','Simtex Industries Limited ','Hanif Haque','info@simtexgroup.com'),(2,'Horindhara, Tannery Road, Hemayetpur, Savar, Dhaka.','01713043259','AKH Packaging & Accessories Ltd','Md. Firoz Uddin Hawlader','firoz@akhfashions.com'),(3,'387 (South), Tejgaon Industrial Area, Dhaka-1208, Bangladesh','880-2-8170592','Ha-meem group','Mr. A. K. Azad','delwar@hameemgroup.com'),(4,'350 Beximco Industrial Park Sarabo, Kashimpur Gazipur Bangladesh','880-2-58611891','Beximco Textile Division Limited','Mr. Sohail F. Rahman','enquiry@beximtex.com'),(5,'Adamjee Court Main Building (5th, 4th, 3rd Floor), 115-120, Motijheel C/A, Dhaka 1000, Bangladesh','(+88 02) 7176207-8','Noman Group','Mr. A. K. Azad','demo@nttml.com');
/*!40000 ALTER TABLE `vendors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-22  2:53:37
