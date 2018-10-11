CREATE DATABASE  IF NOT EXISTS `spring` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `spring`;
-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: spring
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_bin NOT NULL,
  `contents` varchar(255) COLLATE utf8_bin NOT NULL,
  `author` varchar(45) COLLATE utf8_bin NOT NULL,
  `file` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `register_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'게시판입니다.','게시판입니다.','관리자',NULL,'2018-10-04 00:00:00'),(2,'으음','어쩌누','관리자',NULL,'2018-10-10 12:21:43'),(3,'Whatever','Who cares?\r\n','관리자',NULL,'2018-10-10 12:22:23'),(4,'수정이 됩니다!','꺄륵!','관리자',NULL,'2018-10-11 09:35:19'),(5,'Hmm','Like u know, AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH It\'s fucking suck.\r\nHow can do like that?\r\nSuck I wish I do speak more fluency.\r\nMy Eng is so suck. Ugh.','관리자',NULL,'2018-10-11 10:46:05'),(6,'오오','이제 작성자가 사용자의 아이디를 따라갑니다!','관리자',NULL,'2018-10-11 11:52:52'),(7,'Ah','I\'m fuckin bored.\r\nlalala\r\nOh, suck.\r\nI can see everywhere, what I do. I can SEE everywhere.\r\nIt\'s fuckin insane.\r\nyes. looooooooooooooooooooooooooooool\r\nI think I should admit that. LMAO','관리자',NULL,'2018-10-11 11:55:34'),(8,'야이 새키들앜ㅋㅋㅋㅋ','테러좀 고만해ㅋㅋㅋ','관리자',NULL,'2018-10-11 12:14:22'),(9,'30개가 넘어써','그만써','관리자',NULL,'2018-10-11 12:14:30'),(10,'마지막꺼는 뭔소린지도 모르겠음','어디 개그코드냐','관리자',NULL,'2018-10-11 12:14:43'),(11,'노래 추천 안해줘도되','그만','관리자',NULL,'2018-10-11 12:14:53'),(12,'방구','방귀','관리자',NULL,'2018-10-11 12:15:02'),(13,'그만해','나도한다','관리자',NULL,'2018-10-11 12:15:11'),(14,'배그 안함','총게임 이제 못함ㅋㅋ','관리자',NULL,'2018-10-11 12:15:25'),(15,'나 간다','ㅂㅂ','관리자',NULL,'2018-10-11 12:15:35'),(16,'음 이젠 작성자의 이름이 로그인 한 아이디로 나온다고 합니다','실환가','asd',NULL,'2018-10-11 12:18:48'),(17,'hmm','I really don\'t get how can u already okay now.','asd',NULL,'2018-10-11 14:36:46');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-11 16:17:27
