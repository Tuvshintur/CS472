-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: fos
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addresses` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(100) NOT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `postal` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foods`
--

DROP TABLE IF EXISTS `foods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foods` (
  `food_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `type` varchar(45) NOT NULL,
  `description` varchar(250) NOT NULL,
  `created` datetime NOT NULL,
  `price` double NOT NULL,
  `calories` int(11) NOT NULL,
  `image_id` int(11) NOT NULL,
  `order_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`food_id`),
  KEY `fk_foods_images1_idx` (`image_id`),
  CONSTRAINT `fk_foods_images1` FOREIGN KEY (`image_id`) REFERENCES `images` (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foods`
--

LOCK TABLES `foods` WRITE;
/*!40000 ALTER TABLE `foods` DISABLE KEYS */;
/*!40000 ALTER TABLE `foods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `images` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(100) NOT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `totalAmount` double NOT NULL,
  `created` datetime NOT NULL,
  `status` enum('ordered','delivered','cancelled','shipping') NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_orders_users1_idx` (`user_id`),
  CONSTRAINT `fk_orders_users1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_has_foods`
--

DROP TABLE IF EXISTS `orders_has_foods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_has_foods` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `food_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`,`food_id`),
  KEY `fk_orders_has_foods_foods1_idx` (`food_id`),
  KEY `fk_orders_has_foods_orders1_idx` (`order_id`),
  CONSTRAINT `fk_orders_has_foods_foods1` FOREIGN KEY (`food_id`) REFERENCES `foods` (`food_id`),
  CONSTRAINT `fk_orders_has_foods_orders1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_has_foods`
--

LOCK TABLES `orders_has_foods` WRITE;
/*!40000 ALTER TABLE `orders_has_foods` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders_has_foods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `password` varchar(250) NOT NULL,
  `email` varchar(45) NOT NULL,
  `role` enum('admin','client') NOT NULL DEFAULT 'client',
  `created` datetime DEFAULT NULL,
  `image_id` int(11) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_users_images_idx` (`image_id`),
  KEY `fk_users_addresses1_idx` (`address_id`),
  CONSTRAINT `fk_users_addresses1` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`),
  CONSTRAINT `fk_users_images` FOREIGN KEY (`image_id`) REFERENCES `images` (`image_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Abc',NULL,'password','abv@gmail.com','client',NULL,NULL,NULL,NULL),(2,'Discover',NULL,'123456','admin@discovermongolia.mn','client',NULL,NULL,NULL,NULL),(3,'Discover',NULL,'123456','admin@discovermongolia.mn','client',NULL,NULL,NULL,NULL),(4,'MM',NULL,'password','mmm@gmail.com','client',NULL,NULL,NULL,NULL),(5,'Name',NULL,'123','email@gamil.com','client',NULL,NULL,NULL,NULL),(6,'New',NULL,'e10adc3949ba59abbe56e057f20f883e','new@gmail.com','client',NULL,NULL,NULL,NULL),(7,'namuun',NULL,'202cb962ac59075b964b07152d234b70','s.namuun88@gmail.com','client',NULL,NULL,NULL,NULL),(8,'',NULL,'d41d8cd98f00b204e9800998ecf8427e','','client',NULL,NULL,NULL,NULL),(9,'',NULL,'d41d8cd98f00b204e9800998ecf8427e','','client',NULL,NULL,NULL,NULL),(10,'sfsdf',NULL,'d9729feb74992cc3482b350163a1a010','sdf@gmail.com','client',NULL,NULL,NULL,NULL),(11,'DAVAABAYAR',NULL,'633bd287609b5b5854509b614ef5bee0','busdavaabayar@gmail.com','client',NULL,NULL,NULL,NULL),(12,'sdg',NULL,'827ccb0eea8a706c4c34a16891f84e7b','asdf@gmail.com','client',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-19 20:48:44
