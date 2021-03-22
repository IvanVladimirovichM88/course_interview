-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: cinema
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cashier_tbl`
--

DROP TABLE IF EXISTS `cashier_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cashier_tbl` (
  `cashier_id` int(11) NOT NULL AUTO_INCREMENT,
  `description_fld` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cashier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cashier_tbl`
--

LOCK TABLES `cashier_tbl` WRITE;
/*!40000 ALTER TABLE `cashier_tbl` DISABLE KEYS */;
INSERT INTO `cashier_tbl` VALUES (1,'#1'),(2,'#2');
/*!40000 ALTER TABLE `cashier_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film_tbl`
--

DROP TABLE IF EXISTS `film_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `film_tbl` (
  `film_id` int(11) NOT NULL AUTO_INCREMENT,
  `name_fld` varchar(45) NOT NULL,
  `duration` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`film_id`),
  UNIQUE KEY `name_fld_UNIQUE` (`name_fld`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film_tbl`
--

LOCK TABLES `film_tbl` WRITE;
/*!40000 ALTER TABLE `film_tbl` DISABLE KEYS */;
INSERT INTO `film_tbl` VALUES (1,'film 1',90),(2,'film 2',120),(3,'film 3',90),(4,'film 4',120);
/*!40000 ALTER TABLE `film_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_tbl`
--

DROP TABLE IF EXISTS `price_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `price_tbl` (
  `price_id` int(11) NOT NULL AUTO_INCREMENT,
  `price_fld` decimal(5,2) unsigned NOT NULL,
  PRIMARY KEY (`price_id`),
  UNIQUE KEY `price_fld_UNIQUE` (`price_fld`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_tbl`
--

LOCK TABLES `price_tbl` WRITE;
/*!40000 ALTER TABLE `price_tbl` DISABLE KEYS */;
INSERT INTO `price_tbl` VALUES (1,120.00),(2,200.00),(3,350.00),(4,500.00);
/*!40000 ALTER TABLE `price_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seance_tbl`
--

DROP TABLE IF EXISTS `seance_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `seance_tbl` (
  `seance_id` int(11) NOT NULL AUTO_INCREMENT,
  `start_time_fld` timestamp NOT NULL,
  `film_id` int(11) NOT NULL,
  `price_id` int(11) NOT NULL,
  PRIMARY KEY (`seance_id`),
  UNIQUE KEY `start_time_fld_UNIQUE` (`start_time_fld`),
  KEY `fk_seance_film_idx` (`film_id`),
  KEY `fk_seance_price_idx` (`price_id`),
  CONSTRAINT `fk_seance_film` FOREIGN KEY (`film_id`) REFERENCES `film_tbl` (`film_id`),
  CONSTRAINT `fk_seance_price` FOREIGN KEY (`price_id`) REFERENCES `price_tbl` (`price_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seance_tbl`
--

LOCK TABLES `seance_tbl` WRITE;
/*!40000 ALTER TABLE `seance_tbl` DISABLE KEYS */;
INSERT INTO `seance_tbl` VALUES (1,'2020-10-10 07:00:00',1,1),(2,'2020-10-10 09:00:00',1,2),(3,'2020-10-10 11:00:00',1,3),(4,'2020-10-10 14:00:00',3,4);
/*!40000 ALTER TABLE `seance_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_tbl`
--

DROP TABLE IF EXISTS `ticket_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ticket_tbl` (
  `ticket_id` int(11) NOT NULL AUTO_INCREMENT,
  `seance_id` int(11) NOT NULL,
  `cashier_id` int(11) NOT NULL,
  PRIMARY KEY (`ticket_id`),
  KEY `fk_ticket_seance_idx` (`seance_id`),
  KEY `fk_ticket_cashier_idx` (`cashier_id`),
  CONSTRAINT `fk_ticket_cashier` FOREIGN KEY (`cashier_id`) REFERENCES `cashier_tbl` (`cashier_id`),
  CONSTRAINT `fk_ticket_seance` FOREIGN KEY (`seance_id`) REFERENCES `seance_tbl` (`seance_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_tbl`
--

LOCK TABLES `ticket_tbl` WRITE;
/*!40000 ALTER TABLE `ticket_tbl` DISABLE KEYS */;
INSERT INTO `ticket_tbl` VALUES (1,1,2),(2,1,2),(3,1,1),(4,2,1),(5,2,1),(6,2,2);
/*!40000 ALTER TABLE `ticket_tbl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-16  1:57:12
