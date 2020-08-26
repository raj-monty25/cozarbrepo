CREATE DATABASE  IF NOT EXISTS `cozarbdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cozarbdb`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: server-1    Database: cozarbdb
-- ------------------------------------------------------
-- Server version	5.7.24-log

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
-- Table structure for table ` try_and_buy_categories_choosen`
--

DROP TABLE IF EXISTS ` try_and_buy_categories_choosen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE ` try_and_buy_categories_choosen` (
  ` try_and_buy_category_choosen_id` int(11) NOT NULL AUTO_INCREMENT,
  `try_and_buy_request_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `min_price_range` double NOT NULL,
  `max_price_range` double DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  ` try_and_buy_categories_choosencol` varchar(45) NOT NULL,
  PRIMARY KEY (` try_and_buy_category_choosen_id`),
  KEY `try_and_buy_request_id_idx` (`try_and_buy_request_id`),
  KEY `category_id_idx` (`category_id`),
  CONSTRAINT `category_id_merchant_store_categories` FOREIGN KEY (`category_id`) REFERENCES `merchant_store_categories` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `try_and_buy_request_id_merchant_store_try_and_buy_request` FOREIGN KEY (`try_and_buy_request_id`) REFERENCES `merchant_store_try_and_buy_requests` (`try_and_buy_request_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table ` try_and_buy_categories_choosen`
--

LOCK TABLES ` try_and_buy_categories_choosen` WRITE;
/*!40000 ALTER TABLE ` try_and_buy_categories_choosen` DISABLE KEYS */;
/*!40000 ALTER TABLE ` try_and_buy_categories_choosen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `address_line1` varchar(25) DEFAULT NULL,
  `address_line2` varchar(25) DEFAULT NULL,
  `city` varchar(25) DEFAULT NULL,
  `state` varchar(25) DEFAULT NULL,
  `zip` int(11) DEFAULT NULL,
  `country` varchar(25) DEFAULT NULL,
  `created_by` varchar(25) DEFAULT NULL,
  `created_dt` date DEFAULT NULL,
  `last_modified_by` varchar(25) DEFAULT NULL,
  `last_modified_dt` date DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cities` (
  `cities_id` int(11) NOT NULL,
  `city_nm` varchar(45) NOT NULL,
  `state_id` int(11) NOT NULL,
  `status` varchar(15) NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_date` date NOT NULL,
  `last_modified_by` varchar(45) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`cities_id`),
  KEY `state_fk_idx` (`state_id`),
  CONSTRAINT `state_fk` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'VIJAYAWADA',1,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(2,'ITANAGAR',2,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(3,'PANAJI',3,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(4,'BANGLORE',4,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(5,'KOLLAM',5,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(6,'BHOPAL',6,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(7,'NAGPUR',7,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(8,'AMRITSAR',8,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(9,'UDAIPUR',9,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(10,'CHENNAI',10,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(11,'HYDERABAD',11,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(12,'VARANASI',12,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(13,'AGUASCALIENTES CITY',13,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(14,'MEXICO CITY',14,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16');
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaint`
--

DROP TABLE IF EXISTS `complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaint` (
  `complaint_id` int(11) NOT NULL,
  `complaint_raised_dt` date DEFAULT NULL,
  `customer_id_complaint` int(11) DEFAULT NULL,
  `merchant_store_id_complaint` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(45) NOT NULL,
  `last_modified_dt` date NOT NULL,
  `complaintcol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`complaint_id`),
  UNIQUE KEY `complaintcol_UNIQUE` (`complaintcol`),
  KEY `customer_id_compain_idx` (`customer_id_complaint`),
  KEY `merchant_store_id_complaint_idx` (`merchant_store_id_complaint`),
  CONSTRAINT `customer_id_compain` FOREIGN KEY (`customer_id_complaint`) REFERENCES `merchant_store_try_and_buy_requests` (`try_and_buy_request_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `merchant_store_id_complaint` FOREIGN KEY (`merchant_store_id_complaint`) REFERENCES `merchant_store` (`merchant_store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint`
--

LOCK TABLES `complaint` WRITE;
/*!40000 ALTER TABLE `complaint` DISABLE KEYS */;
/*!40000 ALTER TABLE `complaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_info`
--

DROP TABLE IF EXISTS `contact_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact_info` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_nm` varchar(50) NOT NULL,
  `contact_no` varchar(15) NOT NULL,
  `contact_email_address` varchar(50) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_info`
--

LOCK TABLES `contact_info` WRITE;
/*!40000 ALTER TABLE `contact_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_nm` varchar(50) NOT NULL,
  `status` varchar(15) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`country_id`),
  UNIQUE KEY `country_id_UNIQUE` (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'INDIA','A','SYSTEM','2019-10-14','SYSTEM','2019-10-14'),(2,'FRANCE','A','SYSTEM','2019-10-14','SYSTEM','2019-10-14'),(3,'GERMANY','A','SYSTEM','2019-10-14','SYSTEM','2019-10-14'),(4,'MEXICO','A','SYSTEM','2019-10-14','SYSTEM','2019-10-14'),(5,'UNITED STATES OF AMERICA','A','SYSTEM','2019-10-14','SYSTEM','2019-10-14');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_address`
--

DROP TABLE IF EXISTS `customer_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_address` (
  `customer_id` int(11) NOT NULL,
  `seq_no` int(11) NOT NULL,
  `address_id` int(11) NOT NULL,
  `status` varchar(25) NOT NULL,
  `created_by` varchar(25) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(25) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `add_fk_idx` (`address_id`),
  CONSTRAINT `address_fk` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_tab_fk` FOREIGN KEY (`customer_id`) REFERENCES `system_user` (`system_user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_address`
--

LOCK TABLES `customer_address` WRITE;
/*!40000 ALTER TABLE `customer_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_hawker_request`
--

DROP TABLE IF EXISTS `customer_hawker_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_hawker_request` (
  `customer_hawker_request_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `customer_address_id` int(11) DEFAULT NULL,
  `customer_contact_nm` varchar(50) DEFAULT NULL,
  `customer_contact_nbr` varchar(25) DEFAULT NULL,
  `customer_requested_from_dt` date DEFAULT NULL,
  `customer_requested_end_dt` date DEFAULT NULL,
  `request_accepted_hawker_id` int(11) DEFAULT NULL,
  `hawker_visited_dt` date DEFAULT NULL,
  `hawker_visited_hour` int(11) DEFAULT NULL,
  `time_spent` int(11) DEFAULT NULL,
  `customer_remarks` varchar(250) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `created_dt` date DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_dt` date DEFAULT NULL,
  PRIMARY KEY (`customer_hawker_request_id`),
  KEY `customer_id_customer_hawker_request_idx` (`customer_id`),
  KEY `customer_address_id_customer_hawker_request_idx` (`customer_address_id`),
  KEY `request_accepted_hawker_id_customer_hawker_request_idx` (`request_accepted_hawker_id`),
  CONSTRAINT `customer_address_id_customer_hawker_request` FOREIGN KEY (`customer_address_id`) REFERENCES `customer_address` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `customer_id_customer_hawker_request` FOREIGN KEY (`customer_id`) REFERENCES `system_user` (`system_user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `request_accepted_hawker_id_customer_hawker_request` FOREIGN KEY (`request_accepted_hawker_id`) REFERENCES `hawker` (`hawker_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_hawker_request`
--

LOCK TABLES `customer_hawker_request` WRITE;
/*!40000 ALTER TABLE `customer_hawker_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_hawker_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_hawker_request_leads`
--

DROP TABLE IF EXISTS `customer_hawker_request_leads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_hawker_request_leads` (
  `customer_hawker_request_leads_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_hawker_request_id` int(11) DEFAULT NULL,
  `hawker_id` int(11) DEFAULT NULL,
  `presented_dt` date DEFAULT NULL,
  `email_address` varchar(50) DEFAULT NULL,
  `mobile_nbr` varchar(25) DEFAULT NULL,
  `hawker_remark` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `created_dt` date DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_dt` date DEFAULT NULL,
  PRIMARY KEY (`customer_hawker_request_leads_id`),
  KEY `customer_hawker_request_id_customer_hawker_request_leads_idx` (`customer_hawker_request_id`),
  KEY `hawker_id_customer_hawker_request_leads_idx` (`hawker_id`),
  CONSTRAINT `customer_hawker_request_id_customer_hawker_request_leads` FOREIGN KEY (`customer_hawker_request_id`) REFERENCES `customer_hawker_request` (`customer_hawker_request_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `hawker_id_customer_hawker_request_leads` FOREIGN KEY (`hawker_id`) REFERENCES `hawker` (`hawker_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_hawker_request_leads`
--

LOCK TABLES `customer_hawker_request_leads` WRITE;
/*!40000 ALTER TABLE `customer_hawker_request_leads` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_hawker_request_leads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_hawker_request_product_info`
--

DROP TABLE IF EXISTS `customer_hawker_request_product_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_hawker_request_product_info` (
  `customer_hawker_request_product_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_hawker_request_id` int(11) NOT NULL,
  `product_info_id` int(11) NOT NULL,
  `description` varchar(150) DEFAULT NULL,
  `min_price` double NOT NULL,
  `max_price` double NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`customer_hawker_request_product_info_id`),
  KEY `customer_hawker_request_id.customer_hawker_request_product__idx` (`customer_hawker_request_id`),
  KEY `product_info_id.customer_hawker_request_product_info_idx` (`product_info_id`),
  CONSTRAINT `customer_hawker_request_id.customer_hawker_request_product_info` FOREIGN KEY (`customer_hawker_request_id`) REFERENCES `customer_hawker_request` (`customer_hawker_request_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `product_info_id.customer_hawker_request_product_info` FOREIGN KEY (`product_info_id`) REFERENCES `hawker_product_info` (`hawker_product_info_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_hawker_request_product_info`
--

LOCK TABLES `customer_hawker_request_product_info` WRITE;
/*!40000 ALTER TABLE `customer_hawker_request_product_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_hawker_request_product_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_tracking_line_items`
--

DROP TABLE IF EXISTS `delivery_tracking_line_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_tracking_line_items` (
  `delivery_tracking_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_line_item_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`delivery_tracking_id`),
  KEY `order_line_item_id_delivery_tracking_line_items_idx` (`order_line_item_id`),
  CONSTRAINT `order_line_item_id_delivery_tracking_line_items` FOREIGN KEY (`order_line_item_id`) REFERENCES `order_line_items` (`order_line_item_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_tracking_line_items`
--

LOCK TABLES `delivery_tracking_line_items` WRITE;
/*!40000 ALTER TABLE `delivery_tracking_line_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_tracking_line_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT,
  `system_user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `comments` varchar(256) NOT NULL,
  `ratings` int(11) NOT NULL,
  `status` varchar(25) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_dt` date DEFAULT NULL,
  PRIMARY KEY (`feedback_id`),
  KEY `user_fk_idx` (`system_user_id`),
  KEY `prod_fk_idx` (`product_id`),
  CONSTRAINT `prod_fk` FOREIGN KEY (`product_id`) REFERENCES `merchant_store_product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_fk` FOREIGN KEY (`system_user_id`) REFERENCES `system_user` (`system_user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hawker`
--

DROP TABLE IF EXISTS `hawker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hawker` (
  `hawker_id` int(11) NOT NULL,
  `hawker_nm` varchar(40) NOT NULL,
  `display_nm` varchar(45) NOT NULL,
  `description` varchar(50) NOT NULL,
  `hawker_address_id` int(11) NOT NULL,
  `hawker_contact_info_id` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  `created_by` varchar(40) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(40) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`hawker_id`),
  KEY `fk_hawker_address_id_adress_idx` (`hawker_address_id`),
  KEY `hawker_contact_info_id_contact_info_idx` (`hawker_contact_info_id`),
  CONSTRAINT `hawker_address_id_adress` FOREIGN KEY (`hawker_address_id`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `hawker_contact_info_id_contact_info` FOREIGN KEY (`hawker_contact_info_id`) REFERENCES `contact_info` (`contact_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hawker`
--

LOCK TABLES `hawker` WRITE;
/*!40000 ALTER TABLE `hawker` DISABLE KEYS */;
/*!40000 ALTER TABLE `hawker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hawker_packages`
--

DROP TABLE IF EXISTS `hawker_packages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hawker_packages` (
  `hawker_package_id` int(11) NOT NULL AUTO_INCREMENT,
  `package_nm` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `total_lead_count` int(11) NOT NULL,
  `validity_in_days` int(11) NOT NULL,
  `amount` double NOT NULL,
  `status` varchar(2) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`hawker_package_id`),
  UNIQUE KEY `hawker_package_id_UNIQUE` (`hawker_package_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hawker_packages`
--

LOCK TABLES `hawker_packages` WRITE;
/*!40000 ALTER TABLE `hawker_packages` DISABLE KEYS */;
INSERT INTO `hawker_packages` VALUES (1,'monthly','this package validity is one month only',13,31,100,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(2,'quaterly','this package is validity is 180',50,180,500,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(3,'daypack','this is only for one day ',50,1,35,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(4,'bydays','this is for only 100 sms and valid 5 days',100,5,55,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(5,'mindays','this validityis is 200',52,200,400,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(6,'limidays','this validityis is120 days',63,100,120,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(7,'150days','this validityis is130',54,150,130,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(8,'hulfy','this validityis is 250',25,250,460,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(9,'minyear','this validityis is 180days',52,180,110,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(10,'ysyt','80 days',56,80,40,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16');
/*!40000 ALTER TABLE `hawker_packages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hawker_product_info`
--

DROP TABLE IF EXISTS `hawker_product_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hawker_product_info` (
  `hawker_product_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_info` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `hawker_id` int(11) NOT NULL,
  `status` varchar(15) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`hawker_product_info_id`),
  UNIQUE KEY `hawker_product_info_id_UNIQUE` (`hawker_product_info_id`),
  UNIQUE KEY `hawker_id_UNIQUE` (`hawker_id`),
  CONSTRAINT `hawker_id_hawker` FOREIGN KEY (`hawker_id`) REFERENCES `hawker` (`hawker_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hawker_product_info`
--

LOCK TABLES `hawker_product_info` WRITE;
/*!40000 ALTER TABLE `hawker_product_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `hawker_product_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hawker_service_areas`
--

DROP TABLE IF EXISTS `hawker_service_areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hawker_service_areas` (
  `hawker_service_areas_id` int(11) NOT NULL AUTO_INCREMENT,
  `hawker_id` int(11) NOT NULL,
  `service_area_id` int(11) NOT NULL,
  `availability_from_hour` int(11) NOT NULL,
  `availability_to_hour` int(11) NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(45) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`hawker_service_areas_id`),
  CONSTRAINT `fk_hawker_service_areas_hawker` FOREIGN KEY (`hawker_service_areas_id`) REFERENCES `hawker` (`hawker_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_hawker_service_areas_service_area` FOREIGN KEY (`hawker_service_areas_id`) REFERENCES `service_area` (`service_area_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hawker_service_areas`
--

LOCK TABLES `hawker_service_areas` WRITE;
/*!40000 ALTER TABLE `hawker_service_areas` DISABLE KEYS */;
/*!40000 ALTER TABLE `hawker_service_areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hawker_subscribed_package`
--

DROP TABLE IF EXISTS `hawker_subscribed_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hawker_subscribed_package` (
  `hawker_subscribed_package_id` int(11) NOT NULL AUTO_INCREMENT,
  `package_id` int(11) NOT NULL,
  `hawker_id` int(11) NOT NULL,
  `transaction_id` int(11) NOT NULL,
  `effective_dt` date DEFAULT NULL,
  `expiry_dt` date DEFAULT NULL,
  `leads_per_day` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`hawker_subscribed_package_id`),
  KEY `package_id_hawker_package_id_idx` (`package_id`),
  KEY `hawker_id_hawker_idx` (`hawker_id`),
  KEY `transaction_id_hawker_subscribed_package_idx` (`transaction_id`),
  CONSTRAINT `hawker_id_hawker_subscribed_package` FOREIGN KEY (`hawker_id`) REFERENCES `hawker` (`hawker_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `package_id_hawker_subscribed_package` FOREIGN KEY (`package_id`) REFERENCES `hawker_packages` (`hawker_package_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `transaction_id_hawker_subscribed_package` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hawker_subscribed_package`
--

LOCK TABLES `hawker_subscribed_package` WRITE;
/*!40000 ALTER TABLE `hawker_subscribed_package` DISABLE KEYS */;
/*!40000 ALTER TABLE `hawker_subscribed_package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `identification_type`
--

DROP TABLE IF EXISTS `identification_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `identification_type` (
  `identification_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `identification_type_nm` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `status` varchar(15) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`identification_type_id`),
  UNIQUE KEY `identification_type_id_UNIQUE` (`identification_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `identification_type`
--

LOCK TABLES `identification_type` WRITE;
/*!40000 ALTER TABLE `identification_type` DISABLE KEYS */;
INSERT INTO `identification_type` VALUES (1,'aadhar_card','submit the aadhar_card  as identification ','A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(2,'driving_license','submit the driving_lincense  as identification ','A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(3,'voter_id','submit the voter_id  as identification ','A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(4,'pan_card','submit the pan_card as identification ','A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(5,'passport','submit the passport  as identification ','A','SYSTEM','2019-10-16','SYSTEM','2019-10-16');
/*!40000 ALTER TABLE `identification_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `image_nm` varchar(15) NOT NULL,
  `image_type` tinyblob NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `image_content` longblob NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `created_by` varchar(15) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(15) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_business`
--

DROP TABLE IF EXISTS `merchant_business`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_business` (
  `merchant_business_id_merchant_business` int(11) NOT NULL,
  `business_nm` varchar(45) NOT NULL,
  `business_alias_nm` varchar(45) DEFAULT NULL,
  `business_license_no` varchar(45) NOT NULL,
  `license_issued_authority` varchar(45) NOT NULL,
  `license_issued_dt` date NOT NULL,
  `business_address_id_merchant_business` int(11) NOT NULL,
  `primary_contact_info_id_merchant_business` int(11) NOT NULL,
  `secondary_contact_info_id_merchant_business` int(11) DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(45) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`merchant_business_id_merchant_business`),
  KEY `business_address_id_merchant_business_idx` (`business_address_id_merchant_business`),
  KEY `primary_contact_info_id_merchant_business_idx` (`primary_contact_info_id_merchant_business`),
  KEY `secondary_contact_info_id_merchant_business_idx` (`secondary_contact_info_id_merchant_business`),
  CONSTRAINT `business_address_id_merchant_business` FOREIGN KEY (`business_address_id_merchant_business`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `primary_contact_info_id_merchant_business` FOREIGN KEY (`primary_contact_info_id_merchant_business`) REFERENCES `merchant_store` (`primary_contact_info_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `secondary_contact_info_id_merchant_business` FOREIGN KEY (`secondary_contact_info_id_merchant_business`) REFERENCES `merchant_store` (`secondary_contact_info_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_business`
--

LOCK TABLES `merchant_business` WRITE;
/*!40000 ALTER TABLE `merchant_business` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_business` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_enquiry`
--

DROP TABLE IF EXISTS `merchant_enquiry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_enquiry` (
  `merchant_enquiry_id` int(11) NOT NULL AUTO_INCREMENT,
  `business_nm` varchar(50) NOT NULL,
  `contact_person_nm` varchar(50) DEFAULT NULL,
  `contact_nbr` varchar(50) NOT NULL,
  `contact_email_address` varchar(50) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `business_address_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`merchant_enquiry_id`),
  KEY `merchant_enquiry_business_address_id_idx` (`business_address_id`),
  CONSTRAINT `business_address_id_merchant_enquiry` FOREIGN KEY (`business_address_id`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_enquiry`
--

LOCK TABLES `merchant_enquiry` WRITE;
/*!40000 ALTER TABLE `merchant_enquiry` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_enquiry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_packages`
--

DROP TABLE IF EXISTS `merchant_packages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_packages` (
  `package_id` int(10) NOT NULL,
  `packages_nm` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `stores_allowed` int(11) NOT NULL,
  `total_product_allowed` int(11) NOT NULL,
  `package_amount` double NOT NULL,
  `package_validity_in_days` int(11) NOT NULL,
  `status` varchar(20) NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(45) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`package_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_packages`
--

LOCK TABLES `merchant_packages` WRITE;
/*!40000 ALTER TABLE `merchant_packages` DISABLE KEYS */;
INSERT INTO `merchant_packages` VALUES (1,'1 month','valid till 1 month',1,50,200,30,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(2,'2 months','valid till 2 month',1,70,300,60,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(3,'quarterly','valid till 3 month',2,90,450,90,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(4,'4 months','valid till 4 month',2,120,550,120,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(5,'5 months','valid till 5 month',3,150,700,150,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(6,'half yearly','valid till 6 month',3,180,750,180,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(7,'7 months','valid till 7 month',4,210,900,210,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(8,' 8 months','valid till 8 month',4,230,1050,240,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(9,'9 months','valid till 9 month',5,270,1200,270,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(10,'10 months','valid till 10 month',5,290,1450,300,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(11,'11 months','valid till 11 month',6,300,1600,330,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(12,'yearly','valid till 12 month',6,350,1700,360,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16');
/*!40000 ALTER TABLE `merchant_packages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_store`
--

DROP TABLE IF EXISTS `merchant_store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_store` (
  `merchant_store_id` int(11) NOT NULL AUTO_INCREMENT,
  `merchant_business_id` int(11) NOT NULL,
  `merchant_store_address_id` int(11) NOT NULL,
  `store_contact_info_id` int(11) NOT NULL,
  `primary_contact_info_id` int(11) NOT NULL,
  `secondary_contact_info_id` int(11) NOT NULL,
  `store_opening_time_hours` int(11) NOT NULL,
  `store_opening_time_minutes` int(11) NOT NULL,
  `store_closing_time_hours` int(11) NOT NULL,
  `store_closing_time_minutes` int(11) NOT NULL,
  `status` varchar(45) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(45) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`merchant_store_id`),
  UNIQUE KEY `primary_contact_info_id_UNIQUE` (`primary_contact_info_id`),
  UNIQUE KEY `secondary_contact_info_id_UNIQUE` (`secondary_contact_info_id`),
  KEY `fk_merchant_store_merchant_business_idx` (`merchant_business_id`),
  CONSTRAINT `fk_merchant_store_address` FOREIGN KEY (`merchant_store_id`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_merchant_store_merchant_business` FOREIGN KEY (`merchant_store_id`) REFERENCES `merchant_business` (`merchant_business_id_merchant_business`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_store`
--

LOCK TABLES `merchant_store` WRITE;
/*!40000 ALTER TABLE `merchant_store` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_store_categories`
--

DROP TABLE IF EXISTS `merchant_store_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_store_categories` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `merchant_store_id` int(11) NOT NULL,
  `category_nm` varchar(40) NOT NULL,
  `description` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `created_by` varchar(40) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(40) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`category_id`),
  KEY `merchant_store_id_merchant-store_idx` (`merchant_store_id`),
  CONSTRAINT `merchant_store_id_merchant-store` FOREIGN KEY (`merchant_store_id`) REFERENCES `merchant_store` (`merchant_store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_store_categories`
--

LOCK TABLES `merchant_store_categories` WRITE;
/*!40000 ALTER TABLE `merchant_store_categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_store_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_store_images`
--

DROP TABLE IF EXISTS `merchant_store_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_store_images` (
  `merchant_store_id` int(11) NOT NULL,
  `image_id` int(11) NOT NULL,
  `	status` varchar(50) NOT NULL,
  `	created_by` varchar(50) NOT NULL,
  `	created_dt` date NOT NULL,
  `	last_modified_by` varchar(50) NOT NULL,
  `	last_modified_dt` date NOT NULL,
  PRIMARY KEY (`merchant_store_id`),
  KEY `merchant_store_id_idx` (`merchant_store_id`),
  KEY `fk_image_id_image_idx` (`image_id`),
  CONSTRAINT `fk_image_id_image` FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_store_images`
--

LOCK TABLES `merchant_store_images` WRITE;
/*!40000 ALTER TABLE `merchant_store_images` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_store_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_store_order_delivery_tracking`
--

DROP TABLE IF EXISTS `merchant_store_order_delivery_tracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_store_order_delivery_tracking` (
  `delivery_tracking_id` int(11) NOT NULL,
  `order_id_msort` int(11) DEFAULT NULL,
  `delivery_agent_id_msort` int(11) DEFAULT NULL,
  `delivery_schedule_dt` date DEFAULT NULL,
  `delivery_dt` date DEFAULT NULL,
  `recepient_nm` varchar(45) DEFAULT NULL,
  `recepient_contact_nbr` varchar(45) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `created_dt` date DEFAULT NULL,
  `last_modified_by` varchar(45) DEFAULT NULL,
  `last_modified_dt` date DEFAULT NULL,
  PRIMARY KEY (`delivery_tracking_id`),
  KEY `order_id_msort_idx` (`order_id_msort`),
  KEY `delivery_agent_id_msort_idx` (`delivery_agent_id_msort`),
  CONSTRAINT `delivery_agent_id_msort` FOREIGN KEY (`delivery_agent_id_msort`) REFERENCES `merchant_store_staff` (`staff_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `order_id_msort` FOREIGN KEY (`order_id_msort`) REFERENCES `merchant_store_orders` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_store_order_delivery_tracking`
--

LOCK TABLES `merchant_store_order_delivery_tracking` WRITE;
/*!40000 ALTER TABLE `merchant_store_order_delivery_tracking` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_store_order_delivery_tracking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_store_order_transaction`
--

DROP TABLE IF EXISTS `merchant_store_order_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_store_order_transaction` (
  `order_id` int(11) NOT NULL,
  `transaction_id` int(11) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`order_id`,`transaction_id`),
  KEY `fk_transaction_id_transaction_idx` (`transaction_id`),
  CONSTRAINT `fk_order_id_order` FOREIGN KEY (`order_id`) REFERENCES `merchant_store_orders` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_id_transaction` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_store_order_transaction`
--

LOCK TABLES `merchant_store_order_transaction` WRITE;
/*!40000 ALTER TABLE `merchant_store_order_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_store_order_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_store_orders`
--

DROP TABLE IF EXISTS `merchant_store_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_store_orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `merchant_store_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `order_placed_dt` date DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `delivery_address_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `status` varchar(15) DEFAULT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(45) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `merchant_store_id_idx` (`merchant_store_id`),
  KEY `customer_id_system_user_idx` (`customer_id`),
  CONSTRAINT `customer_id_system_user` FOREIGN KEY (`customer_id`) REFERENCES `system_user` (`system_user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `merchant_store_id_merchant_store` FOREIGN KEY (`merchant_store_id`) REFERENCES `merchant_store` (`merchant_store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_store_orders`
--

LOCK TABLES `merchant_store_orders` WRITE;
/*!40000 ALTER TABLE `merchant_store_orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_store_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_store_product`
--

DROP TABLE IF EXISTS `merchant_store_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_store_product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `merchant_store_id` int(11) NOT NULL,
  `title` varchar(25) NOT NULL,
  `description` varchar(150) DEFAULT NULL,
  `category_id` int(11) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `status` varchar(25) DEFAULT NULL,
  `created_by` varchar(25) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(25) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`product_id`),
  KEY `merchant_store_id.merchant_store_product_idx` (`merchant_store_id`),
  KEY `category_id.merchant_store_product_idx` (`category_id`),
  CONSTRAINT `category_id.merchant_store_product` FOREIGN KEY (`category_id`) REFERENCES `merchant_store_categories` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `merchant_store_id.merchant_store_product` FOREIGN KEY (`merchant_store_id`) REFERENCES `merchant_store` (`merchant_store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_store_product`
--

LOCK TABLES `merchant_store_product` WRITE;
/*!40000 ALTER TABLE `merchant_store_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_store_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_store_service_areas`
--

DROP TABLE IF EXISTS `merchant_store_service_areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_store_service_areas` (
  `merchant_store_id` int(11) NOT NULL,
  `service_area_id` int(11) NOT NULL,
  `status` varchar(25) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_dt` date DEFAULT NULL,
  PRIMARY KEY (`merchant_store_id`,`service_area_id`),
  KEY `service_area_id_merchant_store_service_areas_idx` (`service_area_id`),
  CONSTRAINT `merchant_store_id_fk` FOREIGN KEY (`merchant_store_id`) REFERENCES `merchant_store` (`merchant_store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `service_area_id_merchant_store_service_areas` FOREIGN KEY (`service_area_id`) REFERENCES `service_area` (`service_area_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_store_service_areas`
--

LOCK TABLES `merchant_store_service_areas` WRITE;
/*!40000 ALTER TABLE `merchant_store_service_areas` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_store_service_areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_store_staff`
--

DROP TABLE IF EXISTS `merchant_store_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_store_staff` (
  `staff_id` int(11) NOT NULL,
  `merchant_store_id` int(11) NOT NULL,
  `staff_address_id` int(11) NOT NULL,
  `staff_contact_info_id` int(11) NOT NULL,
  `staff_role_id` int(11) NOT NULL,
  `identification_type_id` int(11) NOT NULL,
  `identification_info` varchar(50) DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`staff_id`),
  KEY `merchant_store_id_merchant_store_staff_idx` (`merchant_store_id`),
  KEY `staff_address_id_merchant_store_staff_idx` (`staff_address_id`),
  KEY `staff_contact_info_id_merchant_store_staff_idx` (`staff_contact_info_id`),
  KEY `staff_staff_role_id_merchant_store_idx` (`staff_role_id`),
  KEY `identification_type_id_merchant_store_staff_idx` (`identification_type_id`),
  CONSTRAINT `identification_type_id_merchant_store_staff` FOREIGN KEY (`identification_type_id`) REFERENCES `identification_type` (`identification_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `merchant_store_id_merchant_store_staff` FOREIGN KEY (`merchant_store_id`) REFERENCES `merchant_store` (`merchant_store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `staff_address_id_merchant_store_staff` FOREIGN KEY (`staff_address_id`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `staff_contact_info_id_merchant_store_staff` FOREIGN KEY (`staff_contact_info_id`) REFERENCES `contact_info` (`contact_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `staff_id_merchant_store_staff` FOREIGN KEY (`staff_id`) REFERENCES `system_user` (`system_user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `staff_staff_role_id_merchant_store` FOREIGN KEY (`staff_role_id`) REFERENCES `user_role` (`user_role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_store_staff`
--

LOCK TABLES `merchant_store_staff` WRITE;
/*!40000 ALTER TABLE `merchant_store_staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_store_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_store_try_and_buy_requests`
--

DROP TABLE IF EXISTS `merchant_store_try_and_buy_requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_store_try_and_buy_requests` (
  `try_and_buy_request_id` int(11) NOT NULL AUTO_INCREMENT,
  `merchant_store_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `try_and_buy_request_placed_dt` date NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `customer_address_id` int(11) NOT NULL,
  `try_and_buy_customer_contact_nm` varchar(50) NOT NULL,
  `try_and_buy_customer_contact_nbr` varchar(25) NOT NULL,
  `store_manager_id_staff_table` int(11) DEFAULT NULL,
  `try_and_buy_store_manager_remarks` varchar(250) DEFAULT NULL,
  `merchant_store_try_and_buy_requestscol` varchar(45) DEFAULT NULL,
  `status` varchar(15) NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(45) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`try_and_buy_request_id`),
  UNIQUE KEY `try_and_buy_request_id_UNIQUE` (`try_and_buy_request_id`),
  KEY `fk_merchant_store_id_idx` (`merchant_store_id`),
  KEY `customer_id_system_user_idx` (`customer_id`),
  KEY `customer_id_merchant_store_try_and_buy_requist_idx` (`customer_id`),
  KEY `_merchant_store_try_and_buy_request_idx` (`customer_address_id`),
  KEY `store_manager_id_merchant_store_try_and_buy_request_idx` (`store_manager_id_staff_table`),
  CONSTRAINT `_merchant_store_try_and_buy_request` FOREIGN KEY (`customer_address_id`) REFERENCES `customer_address` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `customer_id_merchant_store_try_and_buy_requist` FOREIGN KEY (`customer_id`) REFERENCES `system_user` (`system_user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `merchstore_id_merchant_store` FOREIGN KEY (`merchant_store_id`) REFERENCES `merchant_store` (`merchant_store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `store_manager_id_merchant_store_try_and_buy_request` FOREIGN KEY (`store_manager_id_staff_table`) REFERENCES `merchant_store_staff` (`staff_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_store_try_and_buy_requests`
--

LOCK TABLES `merchant_store_try_and_buy_requests` WRITE;
/*!40000 ALTER TABLE `merchant_store_try_and_buy_requests` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_store_try_and_buy_requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_subscribed_packages`
--

DROP TABLE IF EXISTS `merchant_subscribed_packages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_subscribed_packages` (
  `merchant_id` int(11) NOT NULL,
  `package_id` int(11) NOT NULL,
  `transaction_id` int(11) NOT NULL,
  `effective_dt` date NOT NULL,
  `expiry_dt` date NOT NULL,
  `status` varchar(20) NOT NULL,
  `created_by` varchar(15) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(15) NOT NULL,
  `last_modified_dt` date NOT NULL,
  KEY `merchant_id_merchant_subscribed_packages_idx` (`merchant_id`),
  KEY `package_id_merchant_subscribed_packages_idx` (`package_id`),
  KEY `transaction_id_merchant_subscribed_packages_idx` (`transaction_id`),
  CONSTRAINT `merchant_id_merchant_subscribed_packages` FOREIGN KEY (`merchant_id`) REFERENCES `merchant_business` (`merchant_business_id_merchant_business`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `package_id_merchant_subscribed_packages` FOREIGN KEY (`package_id`) REFERENCES `merchant_packages` (`package_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `transaction_id_merchant_subscribed_packages` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_subscribed_packages`
--

LOCK TABLES `merchant_subscribed_packages` WRITE;
/*!40000 ALTER TABLE `merchant_subscribed_packages` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_subscribed_packages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_terms_and_conditions`
--

DROP TABLE IF EXISTS `merchant_terms_and_conditions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_terms_and_conditions` (
  `merchant_terms_and_conditions_id` int(11) NOT NULL AUTO_INCREMENT,
  `merchant_business_id` int(11) NOT NULL,
  `description` varchar(500) NOT NULL,
  `effective_dt` date NOT NULL,
  `expiry_dt` date NOT NULL,
  `joining_fee` double NOT NULL,
  `annual_charges` double NOT NULL,
  `online_purchase_commission_percentage` int(11) NOT NULL,
  `online_purchase_commission_min_amount` double NOT NULL,
  `status` varchar(15) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`merchant_terms_and_conditions_id`),
  KEY `merchant_business_id_merchant_business_idx` (`merchant_business_id`),
  CONSTRAINT `merchant_business_id_merchant_business` FOREIGN KEY (`merchant_business_id`) REFERENCES `merchant_business` (`merchant_business_id_merchant_business`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_terms_and_conditions`
--

LOCK TABLES `merchant_terms_and_conditions` WRITE;
/*!40000 ALTER TABLE `merchant_terms_and_conditions` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_terms_and_conditions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_line_items`
--

DROP TABLE IF EXISTS `order_line_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_line_items` (
  `order_line_item_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `price` double NOT NULL,
  `status` varchar(50) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`order_line_item_id`),
  KEY `order_line_items_order_id_idx` (`order_id`),
  KEY `order_line_items_product_id_idx` (`product_id`),
  CONSTRAINT `order_id_order_line_items` FOREIGN KEY (`order_id`) REFERENCES `merchant_store_orders` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `product_id_order_line_items` FOREIGN KEY (`product_id`) REFERENCES `merchant_store_product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_line_items`
--

LOCK TABLES `order_line_items` WRITE;
/*!40000 ALTER TABLE `order_line_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_line_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_id` int(11) NOT NULL,
  `partner_transaction_id` varchar(50) NOT NULL,
  `bank_tx_id` varchar(50) NOT NULL,
  `bank_name` varchar(45) NOT NULL,
  `gateway_nm` varchar(50) DEFAULT NULL,
  `response_code` varchar(25) DEFAULT NULL,
  `response_msg` varchar(50) DEFAULT NULL,
  `payment_mode` varchar(25) DEFAULT NULL,
  `mid` varchar(25) DEFAULT NULL,
  `amount` double NOT NULL,
  `status` varchar(25) DEFAULT NULL,
  `created_dt` date NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `last_modified_dt` date NOT NULL,
  `last_modified_by` varchar(45) NOT NULL,
  PRIMARY KEY (`payment_info_id`),
  KEY `transaction_id_transaction_idx` (`transaction_id`),
  CONSTRAINT `transaction_id.payment` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_images`
--

DROP TABLE IF EXISTS `product_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_images` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`image_id`),
  KEY `product_id_product_images_idx` (`product_id`),
  CONSTRAINT `product_id_product_images` FOREIGN KEY (`product_id`) REFERENCES `merchant_store_product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_images`
--

LOCK TABLES `product_images` WRITE;
/*!40000 ALTER TABLE `product_images` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_area`
--

DROP TABLE IF EXISTS `service_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_area` (
  `service_area_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_area_nm` varchar(50) NOT NULL,
  `zip_code` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`service_area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_area`
--

LOCK TABLES `service_area` WRITE;
/*!40000 ALTER TABLE `service_area` DISABLE KEYS */;
INSERT INTO `service_area` VALUES (45,'KUKATPALLY',500072,11,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(46,'ERRAGADDA',500018,11,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(47,'KPHB',500072,11,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(48,'MADHAPUR',500081,11,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(49,'HYTECHCITY',500081,11,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(50,'KONDAPUR',500032,11,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(51,'PANJAGUTTA',500082,11,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(52,'SECUNDERABAD',500003,11,'A','SYSTEM','2019-10-16','SYSTEM','2019-10-16');
/*!40000 ALTER TABLE `service_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state` (
  `state_id` int(11) NOT NULL AUTO_INCREMENT,
  `state_name` varchar(45) NOT NULL,
  `country_id` int(11) NOT NULL,
  `status` varchar(45) NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_date` date NOT NULL,
  `last_modified_by` varchar(45) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`state_id`),
  KEY `state_country_id_idx` (`country_id`),
  CONSTRAINT `country_id_state` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='					';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'ANDRA PRADESH',1,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(2,'ARUNACHAL PRADESH',1,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(3,'GOA',1,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(4,'KARNATAKA',1,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(5,'KERALA',1,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(6,'MADYA PRADESH',1,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(7,'MAHARASHTRA',1,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(8,'PUNJAB',1,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(9,'RAJASTHAN',1,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(10,'TAMIL NADU',1,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(11,'TELAGANA',1,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(12,'UTTAR PRADESH',1,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(13,'AGUASCALIENTES',4,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(14,'Mexico City',4,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(15,'BAVARIA',3,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(16,'BERLIN',3,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(17,'CALIFORNIA	',1,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16'),(18,'CALIFORNIA',5,'A','SYSTEM','2019-09-16','SYSTEM','2019-09-16');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user`
--

DROP TABLE IF EXISTS `system_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `system_user` (
  `system_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_role_id` int(11) NOT NULL,
  `email_address` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `mobile_nbr` varchar(25) NOT NULL,
  `email_verification_code` varchar(25) DEFAULT NULL,
  `mobile_nbr_verification_code` varchar(25) DEFAULT NULL,
  `is_email_address_verified` tinyint(10) DEFAULT NULL,
  `is_mobile_nbr_verified` tinyint(10) DEFAULT NULL,
  `email_address_verification_dt` date DEFAULT NULL,
  `mobile_nbr_verification_dt` date DEFAULT NULL,
  `last_logged_in_dt` date DEFAULT NULL,
  `account_status` varchar(25) DEFAULT NULL,
  `created_by` varchar(25) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(25) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`system_user_id`),
  UNIQUE KEY `email_address_UNIQUE` (`email_address`),
  KEY `user_role_id_fk_idx` (`user_role_id`),
  CONSTRAINT `fk_user_role_id` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`user_role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user`
--

LOCK TABLES `system_user` WRITE;
/*!40000 ALTER TABLE `system_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_dt` date DEFAULT NULL,
  `transaction_type_id` int(11) NOT NULL,
  `system_user_id` int(11) DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  `created_dt` date NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `last_modified_dt` date NOT NULL,
  `last_modified_by` varchar(45) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `transaction_type_id_transaction_type_idx` (`transaction_type_id`),
  KEY `system_user_id_system_user_idx` (`system_user_id`),
  CONSTRAINT `system_user_id_system_user` FOREIGN KEY (`system_user_id`) REFERENCES `system_user` (`system_user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `transaction_type_id_transaction_type` FOREIGN KEY (`transaction_type_id`) REFERENCES `transaction_type` (`transaction_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_type`
--

DROP TABLE IF EXISTS `transaction_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_type` (
  `transaction_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_type_name` varchar(45) NOT NULL,
  `description` varchar(500) NOT NULL,
  `created_by` varchar(30) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(45) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`transaction_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_type`
--

LOCK TABLES `transaction_type` WRITE;
/*!40000 ALTER TABLE `transaction_type` DISABLE KEYS */;
INSERT INTO `transaction_type` VALUES (1,'buy_merchant_package_transaction','this is the trnsaction made by the merchant for buying the package from the platform','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(2,'place_order_transaction','ths is the transaction made by the customer for lacing order','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(3,'cancel_order_transaction','this is the transaction made by the customer for canceling the orde','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(4,'buy_hawker_package_transaction','this the transaction made by the hawkers for the buying the package from platform','SYSTEM','2019-10-16','SYSTEM','2019-10-16');
/*!40000 ALTER TABLE `transaction_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `try_and_buy customer time-preference`
--

DROP TABLE IF EXISTS `try_and_buy customer time-preference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `try_and_buy customer time-preference` (
  `try_and_buy_customer_preference_id` int(11) NOT NULL AUTO_INCREMENT,
  `try_and_buy_request_id` int(11) NOT NULL,
  `preferred_dt` date DEFAULT NULL,
  `preferred_time_in_hours` time DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` varchar(50) NOT NULL,
  PRIMARY KEY (`try_and_buy_customer_preference_id`),
  KEY `try_and_buy_request_id_idx` (`try_and_buy_request_id`),
  CONSTRAINT `try_and_buy_request_id_merchant_store_try_and_buy_requests` FOREIGN KEY (`try_and_buy_request_id`) REFERENCES `merchant_store_try_and_buy_requests` (`try_and_buy_request_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `try_and_buy customer time-preference`
--

LOCK TABLES `try_and_buy customer time-preference` WRITE;
/*!40000 ALTER TABLE `try_and_buy customer time-preference` DISABLE KEYS */;
/*!40000 ALTER TABLE `try_and_buy customer time-preference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `try_and_buy_tracking`
--

DROP TABLE IF EXISTS `try_and_buy_tracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `try_and_buy_tracking` (
  `try_and_buy_tracking_id` int(11) NOT NULL,
  `try_and_buy_request_id` int(11) DEFAULT NULL,
  `agent_id` int(11) DEFAULT NULL,
  `store_manager_id` int(11) DEFAULT NULL,
  `preferred_id` int(11) DEFAULT NULL,
  `descreption` varchar(250) DEFAULT NULL,
  `exbhited_dt` date DEFAULT NULL,
  `	exbhited_time_in_hours` int(11) DEFAULT NULL,
  `hours_spent` int(11) DEFAULT NULL,
  `customer_remarks` varchar(250) DEFAULT NULL,
  `status` varchar(25) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(50) NOT NULL,
  `last_modified_dt` varchar(45) NOT NULL,
  PRIMARY KEY (`try_and_buy_tracking_id`),
  KEY `fk_try_and_buy_request_id_merchant_store_try_and_buy_reques_idx` (`try_and_buy_request_id`),
  KEY `fk_store_staff-iid__idx` (`store_manager_id`),
  KEY `fk_preferred_id_try_and_buy_costomer_time_preference_idx` (`preferred_id`),
  CONSTRAINT `fk_agent_id_merchant_staff` FOREIGN KEY (`store_manager_id`) REFERENCES `system_user` (`system_user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_preferred_id_try_and_buy_costomer_time_preference` FOREIGN KEY (`preferred_id`) REFERENCES `try_and_buy customer time-preference` (`try_and_buy_customer_preference_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_store_staff-iid_` FOREIGN KEY (`store_manager_id`) REFERENCES `merchant_store_staff` (`staff_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_try_and_buy_request_id_merchant_store_try_and_buy_request` FOREIGN KEY (`try_and_buy_request_id`) REFERENCES `merchant_store_try_and_buy_requests` (`try_and_buy_request_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `try_and_buy_tracking`
--

LOCK TABLES `try_and_buy_tracking` WRITE;
/*!40000 ALTER TABLE `try_and_buy_tracking` DISABLE KEYS */;
/*!40000 ALTER TABLE `try_and_buy_tracking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_role_nm` varchar(40) NOT NULL,
  `role_cd` varchar(40) NOT NULL,
  `status` varchar(50) NOT NULL,
  `created_by` varchar(40) NOT NULL,
  `created_dt` date NOT NULL,
  `last_modified_by` varchar(40) NOT NULL,
  `last_modified_dt` date NOT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'customer','CUST','who register as a customer','A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(2,'business_administrator','BSA','the owner of the platform','A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(3,'store_manager','STMN','he the manager of the store','A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(4,'delivery_agent','DLAG','he delivers the products to the customer','A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(5,'try_and_by_agent','TBAG','he is try and by agent','A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(6,'customer_service_representative','CSR','the csr can perform some operation','A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(7,'platform_administrator','PLA','the admin add the another admin','A','SYSTEM','2019-10-16','SYSTEM','2019-10-16'),(8,'staff','STAF','this tells the staff of the store','A','SYSTEM','2019-10-16','SYSTEM','2019-10-16');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-16 16:37:08
