-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: progetto_finale
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `pattern`
--

DROP TABLE IF EXISTS `pattern`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pattern` (
  `user_pattern` varchar(50) NOT NULL,
  `country` varchar(2) DEFAULT NULL,
  `algorithm` varchar(50) DEFAULT NULL,
  `approved` int DEFAULT NULL,
  PRIMARY KEY (`user_pattern`),
  KEY `pattern_ibfk_1` (`country`),
  CONSTRAINT `pattern_ibfk_1` FOREIGN KEY (`country`) REFERENCES `country` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pattern`
--

LOCK TABLES `pattern` WRITE;
/*!40000 ALTER TABLE `pattern` DISABLE KEYS */;
INSERT INTO `pattern` VALUES ('a','AD','Contains',1),('afs',NULL,NULL,0),('agna','ES','Contains',0),('Arancia','FR','Levenshtein',1),('as','BF','Contains',0),('bania','AL','Contains',0),('belgio','BE','Levenshtein',0),('birmania',NULL,NULL,0),('bnv',NULL,NULL,0),('burkina',NULL,NULL,0),('cina','CN','Levenshtein',1),('citta del vaticano',NULL,NULL,0),('dorra','AD','Contains',0),('e','AG','Contains',1),('faafas',NULL,NULL,0),('faso',NULL,NULL,0),('francia','FR','Levenshtein',1),('g','AF','Contains',0),('giappone','JP','Levenshtein',1),('Ialia','IT','Levenshtein',1),('igna',NULL,NULL,0),('infsafas',NULL,NULL,1),('irlanda','IE','Levenshtein',1),('isa',NULL,NULL,0),('islanda','IS','Levenshtein',1),('ita','IO','Contains',0),('Itaia','IT','Levenshtein',1),('Itali','IT','Contains',1),('italia','IT','Levenshtein',1),('Ittalia','IT','Levenshtein',1),('k','BF','Contains',0),('kosovo',NULL,NULL,0),('nia','AL','Contains',0),('ogo','TG','Contains',1),('olanda',NULL,NULL,0),('olando',NULL,NULL,0),('oni','EE','Contains',0),('orlanda','IE','Levenshtein',1),('pogo','TG','Levenshtein',1),('porcogallo',NULL,NULL,0),('Portogallo','PT','Contains',1),('rogo','TG','Levenshtein',1),('Romania','RO','Contains',1),('russia','BY','Contains',1),('sandokan',NULL,NULL,0),('spagna','ES','Levenshtein',1),('t','AE','Contains',1),('talia','IT','Contains',1),('togo','TG','Levenshtein',1),('uilu',NULL,NULL,1),('ungheria','HU','Levenshtein',1),('usa',NULL,NULL,0),('uss','BY','Contains',1),('w','BW','Contains',0),('x',NULL,NULL,0),('zimba',NULL,NULL,0),('Zimbawe','ZW','Levenshtein',1);
/*!40000 ALTER TABLE `pattern` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-15 17:29:14
