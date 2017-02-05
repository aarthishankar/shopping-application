-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: shopping_db
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `order_description`
--

DROP TABLE IF EXISTS `order_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_description` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `customer_name` varchar(80) DEFAULT NULL,
  `customer_address` varchar(500) DEFAULT NULL,
  `customer_phone_number` int(11) DEFAULT NULL,
  `customer_email_id` varchar(200) DEFAULT NULL,
  `product_ids` varchar(1000) DEFAULT NULL,
  `product_quantities` varchar(600) DEFAULT NULL,
  `total_quantity` int(11) DEFAULT NULL,
  `total_cost` int(11) DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_description`
--

LOCK TABLES `order_description` WRITE;
/*!40000 ALTER TABLE `order_description` DISABLE KEYS */;
INSERT INTO `order_description` VALUES (2,'somil','somil','delhi',1234567890,'somil@gmail.com','_L004_L005','_3_2',5,90069,'2016-08-19 14:25:46'),(3,'somil','demo2','chennai',1234567890,'demo@gmail.com','_L003_L004','_2_3',5,87179,'2016-08-19 14:37:26'),(7,'somil','bubble','chennai',987654345,'bubbu@gmail.com','_L003','_5',5,217775,'2016-08-19 16:00:42');
/*!40000 ALTER TABLE `order_description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `product_id` varchar(45) NOT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `product_price` int(11) DEFAULT NULL,
  `product_quantity` int(11) DEFAULT NULL,
  `product_image` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('L003','HP NEW LAPTOP',43555,43,'C:\\Users\\somils\\workspace2\\OnlineShopProject\\src\\main\\webapp\\Image Resources\\Product Images\\code_L003.jpg'),('L004','HP LAPTOP',23,12,'C:\\Users\\somils\\workspace2\\OnlineShopProject\\src\\main\\webapp\\Image Resources\\Product Images\\code_L004.jpg'),('L005','Lappy',34000,9,'C:\\Users\\somils\\workspace2\\OnlineShopProject\\src\\main\\webapp\\Image Resources\\Product Images\\code_L005.jpg'),('T001','TV ONE',3456,40,'C:\\Users\\somils\\workspace2\\OnlineShopProject\\src\\main\\webapp\\Image Resources\\Product Images\\code_T001.jpg');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products_cart`
--

DROP TABLE IF EXISTS `products_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products_cart` (
  `product_id` varchar(45) NOT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `product_price` int(11) DEFAULT NULL,
  `product_quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products_cart`
--

LOCK TABLES `products_cart` WRITE;
/*!40000 ALTER TABLE `products_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `products_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_accounts`
--

DROP TABLE IF EXISTS `user_accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_accounts` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_accounts`
--

LOCK TABLES `user_accounts` WRITE;
/*!40000 ALTER TABLE `user_accounts` DISABLE KEYS */;
INSERT INTO `user_accounts` VALUES (1,'admin','123','admin'),(2,'somil','123','customer'),(3,'aarthi','123','customer'),(4,'user1','123','customer'),(6,'user2','123','customer'),(7,'hp123','qwe','Customer');
/*!40000 ALTER TABLE `user_accounts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-19 19:59:25
