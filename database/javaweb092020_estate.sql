-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: javawweb92020_excercise3
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `account` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `staff_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `staffid2` (`staff_id`),
  CONSTRAINT `staffid2` FOREIGN KEY (`staff_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `building` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `building_name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `district_id` int(11) NOT NULL,
  `subdistrict` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `street` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `number_of_basement` int(11) DEFAULT NULL,
  `structure` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `gross_area` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `direction` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `class` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `net_area` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `area_description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rent_cost` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rentcost_description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `service_fee` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `car_fee` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mobike_fee` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `overtime_fee` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `electric_fee` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `deposit` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `payment` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rent_period` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `decorate_time` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `manager_name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `manager_phone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `brokerage` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category_id` int(11) NOT NULL,
  `staff_id` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `staffid3` (`staff_id`),
  KEY `district1` (`district_id`),
  KEY `category2` (`category_id`),
  CONSTRAINT `category2` FOREIGN KEY (`category_id`) REFERENCES `building_category` (`id`),
  CONSTRAINT `district1` FOREIGN KEY (`district_id`) REFERENCES `district` (`id`),
  CONSTRAINT `staffid3` FOREIGN KEY (`staff_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
/*!40000 ALTER TABLE `building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `building_category`
--

DROP TABLE IF EXISTS `building_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `building_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building_category`
--

LOCK TABLES `building_category` WRITE;
/*!40000 ALTER TABLE `building_category` DISABLE KEYS */;
INSERT INTO `building_category` VALUES (1,'Tầng trệt'),(2,'Nguyên căn'),(3,'Nội thất');
/*!40000 ALTER TABLE `building_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `needs` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `note` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `input_date` date NOT NULL,
  `inputed_person_name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `staff_id` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `staffid1` (`staff_id`),
  CONSTRAINT `staffid1` FOREIGN KEY (`staff_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `district` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `district` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES (1,'Hoàng Mai'),(2,'Hoàn Kiếm'),(3,'Hai Bà Trưng'),(4,'Ba Đình'),(5,'Bắc Từ Liêm'),(6,'Cầu Giấy'),(7,'Đống Đa'),(8,'Long Biên'),(9,'Nam Từ Liêm'),(10,'Tây Hồ'),(11,'Thanh Xuân');
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transaction` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `category_id` int(11) NOT NULL,
  `transaction_date` date NOT NULL,
  `note` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `staff_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customerid` (`customer_id`),
  KEY `staffid4` (`staff_id`),
  KEY `category1` (`category_id`),
  CONSTRAINT `category1` FOREIGN KEY (`category_id`) REFERENCES `transaction_category` (`id`),
  CONSTRAINT `customerid` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `staffid4` FOREIGN KEY (`staff_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_category`
--

DROP TABLE IF EXISTS `transaction_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transaction_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_category`
--

LOCK TABLES `transaction_category` WRITE;
/*!40000 ALTER TABLE `transaction_category` DISABLE KEYS */;
INSERT INTO `transaction_category` VALUES (1,'CSKH'),(2,'Dẫn đi xem');
/*!40000 ALTER TABLE `transaction_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-24  2:17:12
