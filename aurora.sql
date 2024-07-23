-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: aurora
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
-- Table structure for table `imagen`
--

DROP TABLE IF EXISTS `imagen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagen` (
  `id` int NOT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  `nombre_imagen` varchar(255) DEFAULT NULL,
  `ruta` varchar(255) DEFAULT NULL,
  `tamano` bigint DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `info_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmsct8vyj2clf84lajn93j5rau` (`info_id`),
  CONSTRAINT `FKmsct8vyj2clf84lajn93j5rau` FOREIGN KEY (`info_id`) REFERENCES `informacion` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagen`
--

LOCK TABLES `imagen` WRITE;
/*!40000 ALTER TABLE `imagen` DISABLE KEYS */;
INSERT INTO `imagen` VALUES (52,'image/jpeg','614SwV0+kSL._AC_SX679_.jpg','src\\main\\resources\\static\\img\\614SwV0+kSL._AC_SX679_.jpg',57470,NULL,NULL),(102,'image/png','logo.png','src\\main\\resources\\static\\img\\logo.png',53903,NULL,52),(103,'image/png','logoGRande.png','src\\main\\resources\\static\\img\\logoGRande.png',97070,NULL,52),(152,'application/octet-stream','','src\\main\\resources\\static\\img',0,NULL,102),(153,'application/octet-stream','','src\\main\\resources\\static\\img',0,NULL,103),(202,'application/octet-stream','','src\\main\\resources\\static\\img',0,NULL,152),(203,'application/octet-stream','','src\\main\\resources\\static\\img',0,NULL,NULL),(205,'image/jpeg','64368194_881722822166751_1104201586034343936_n.jpg','src\\main\\resources\\static\\img\\64368194_881722822166751_1104201586034343936_n.jpg',32897,NULL,NULL),(206,'image/png','indian 3.PNG','src\\main\\resources\\static\\img\\indian 3.PNG',82276,NULL,NULL),(207,'application/octet-stream','','src\\main\\resources\\static\\img',0,NULL,NULL),(252,'image/jpeg','614SwV0+kSL._AC_SX679_.jpg','src\\main\\resources\\static\\img\\614SwV0+kSL._AC_SX679_.jpg',57470,NULL,NULL),(302,'image/jpeg','19427-13867305.jpg','src\\main\\resources\\static\\img\\19427-13867305.jpg',42524,NULL,NULL),(352,'image/png','logo.png','src\\main\\resources\\static\\img\\logo.png',53903,NULL,202),(353,'image/jpeg','WhatsApp Image 2020-11-02 at 8.53.08 PM (2).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2020-11-02 at 8.53.08 PM (2).jpeg',178192,NULL,NULL),(354,'image/jpeg','WhatsApp Image 2020-11-02 at 8.53.08 PM (1).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2020-11-02 at 8.53.08 PM (1).jpeg',188304,NULL,NULL),(355,'image/jpeg','WhatsApp Image 2020-11-02 at 8.53.07 PM.jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2020-11-02 at 8.53.07 PM.jpeg',51916,NULL,NULL),(402,'image/jpeg','Vetiver1.jpg','src\\main\\resources\\static\\img\\Vetiver1.jpg',130876,NULL,252),(403,'application/octet-stream','','src\\main\\resources\\static\\img',0,NULL,253),(404,'image/png','MANTRA (1).png','src\\main\\resources\\static\\img\\MANTRA (1).png',61428,NULL,NULL),(405,'image/png','riot.png','src\\main\\resources\\static\\img\\riot.png',912670,NULL,NULL),(406,'image/jpeg','retrato-normal-verdadero-de-la-persona-22299703.jpg','src\\main\\resources\\static\\img\\retrato-normal-verdadero-de-la-persona-22299703.jpg',82503,NULL,NULL),(452,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.23 PM.jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.23 PM.jpeg',218476,NULL,302),(453,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.22 PM.jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.22 PM.jpeg',198036,NULL,302),(502,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.27 PM (8).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.27 PM (8).jpeg',11085,NULL,302),(503,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.27 PM (7).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.27 PM (7).jpeg',21172,NULL,302),(504,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.27 PM (6).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.27 PM (6).jpeg',11085,NULL,302),(505,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.27 PM (5).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.27 PM (5).jpeg',23432,NULL,302),(506,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.27 PM (4).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.27 PM (4).jpeg',108390,NULL,302),(507,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.27 PM (3).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.27 PM (3).jpeg',72826,NULL,302),(508,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.27 PM (2).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.27 PM (2).jpeg',120441,NULL,302),(509,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.27 PM (1).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.27 PM (1).jpeg',218476,NULL,302),(510,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.27 PM.jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.27 PM.jpeg',142165,NULL,302),(511,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.26 PM (4).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.26 PM (4).jpeg',142969,NULL,302),(512,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.26 PM (3).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.26 PM (3).jpeg',129436,NULL,302),(513,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.26 PM (2).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.26 PM (2).jpeg',140441,NULL,302),(514,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.26 PM (1).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.26 PM (1).jpeg',137181,NULL,302),(515,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.26 PM.jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.26 PM.jpeg',140347,NULL,302),(516,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.23 PM (4).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.23 PM (4).jpeg',48073,NULL,302),(517,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.23 PM (3).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.23 PM (3).jpeg',53232,NULL,302),(518,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.23 PM (2).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.23 PM (2).jpeg',50144,NULL,302),(519,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.23 PM (1).jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.23 PM (1).jpeg',58777,NULL,302),(520,'image/jpeg','WhatsApp Image 2024-06-24 at 5.04.23 PM.jpeg','src\\main\\resources\\static\\img\\WhatsApp Image 2024-06-24 at 5.04.23 PM.jpeg',218476,NULL,302),(552,'image/png','logoArriba.png','src\\main\\resources\\static\\img\\logoArriba.png',101200,NULL,52);
/*!40000 ALTER TABLE `imagen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagen_seq`
--

DROP TABLE IF EXISTS `imagen_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagen_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagen_seq`
--

LOCK TABLES `imagen_seq` WRITE;
/*!40000 ALTER TABLE `imagen_seq` DISABLE KEYS */;
INSERT INTO `imagen_seq` VALUES (651);
/*!40000 ALTER TABLE `imagen_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informacion`
--

DROP TABLE IF EXISTS `informacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `informacion` (
  `id` int NOT NULL,
  `icono_servicio` varchar(255) DEFAULT NULL,
  `seccion` varchar(255) DEFAULT NULL,
  `texto` varchar(2255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacion`
--

LOCK TABLES `informacion` WRITE;
/*!40000 ALTER TABLE `informacion` DISABLE KEYS */;
INSERT INTO `informacion` VALUES (52,'','logo','logo','logo'),(102,'','media','215-552-5120','tel'),(103,'','media','asdasdasd@gmail.com','email'),(104,'fa-brands fa-facebook','social','asdasdasdasd',''),(152,'fa-solid fa-hammer','Service','We offer construction services with a variety of materiales','Construction'),(202,'','logo2','logo2','logo2'),(252,'','WhyUs','We are a great company basedon remodelation projects all over america','Excelence'),(253,'','About','Welcome to Aurora Marble & Granite, discover the beauty and versatility of natural stone with a wide selection of granite slabs in various colors and patterns, we offer endless possibilities for your design projects. Whether you’re looking to add elegance to your kitchen, bathroom, or outdoor spaces, our showroom has the perfect granite options for you.','About us'),(302,'','project','Projects','Project');
/*!40000 ALTER TABLE `informacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informacion_imagen`
--

DROP TABLE IF EXISTS `informacion_imagen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `informacion_imagen` (
  `informacion_id` int NOT NULL,
  `imagen_id` int NOT NULL,
  KEY `FKqk4i98bedrlubgrjp9xf4d3mu` (`imagen_id`),
  KEY `FKv41uj79140xgt6hf8ciadsip` (`informacion_id`),
  CONSTRAINT `FKqk4i98bedrlubgrjp9xf4d3mu` FOREIGN KEY (`imagen_id`) REFERENCES `imagen` (`id`),
  CONSTRAINT `FKv41uj79140xgt6hf8ciadsip` FOREIGN KEY (`informacion_id`) REFERENCES `informacion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacion_imagen`
--

LOCK TABLES `informacion_imagen` WRITE;
/*!40000 ALTER TABLE `informacion_imagen` DISABLE KEYS */;
INSERT INTO `informacion_imagen` VALUES (102,152),(103,153),(152,202),(202,352),(252,402),(253,403),(302,452),(302,453),(302,502),(302,503),(302,504),(302,505),(302,506),(302,507),(302,508),(302,509),(302,510),(302,511),(302,512),(302,513),(302,514),(302,515),(302,516),(302,517),(302,518),(302,519),(52,552);
/*!40000 ALTER TABLE `informacion_imagen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informacion_seq`
--

DROP TABLE IF EXISTS `informacion_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `informacion_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacion_seq`
--

LOCK TABLES `informacion_seq` WRITE;
/*!40000 ALTER TABLE `informacion_seq` DISABLE KEYS */;
INSERT INTO `informacion_seq` VALUES (401);
/*!40000 ALTER TABLE `informacion_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_reset_token`
--

DROP TABLE IF EXISTS `password_reset_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `password_reset_token` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `expiration_time` datetime(6) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `usuario_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK3ydhvlv76ltk8wt0t28u0tr9w` (`usuario_id`),
  CONSTRAINT `FKaehv7qqwsde87cy79hxhy4lke` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_reset_token`
--

LOCK TABLES `password_reset_token` WRITE;
/*!40000 ALTER TABLE `password_reset_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `password_reset_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_reset_token_seq`
--

DROP TABLE IF EXISTS `password_reset_token_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `password_reset_token_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_reset_token_seq`
--

LOCK TABLES `password_reset_token_seq` WRITE;
/*!40000 ALTER TABLE `password_reset_token_seq` DISABLE KEYS */;
INSERT INTO `password_reset_token_seq` VALUES (1);
/*!40000 ALTER TABLE `password_reset_token_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id` int NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,NULL,'user'),(2,NULL,'admin');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_seq`
--

DROP TABLE IF EXISTS `rol_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_seq`
--

LOCK TABLES `rol_seq` WRITE;
/*!40000 ALTER TABLE `rol_seq` DISABLE KEYS */;
INSERT INTO `rol_seq` VALUES (101);
/*!40000 ALTER TABLE `rol_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `rol_id` int DEFAULT NULL,
  `usuario_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK9hfl8tdutsxq1r5er252rnssq` (`rol_id`),
  KEY `FKm4og8sl046ja161csbjefq44i` (`usuario_id`),
  CONSTRAINT `FKm4og8sl046ja161csbjefq44i` FOREIGN KEY (`usuario_id`) REFERENCES `rol` (`id`),
  CONSTRAINT `FKshkwj12wg6vkm6iuwhvcfpct8` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'josedavids123@live.com','usuario','$2a$10$gvlnvJ85iJPVPsuz52gJEeELFBweLD2I5mXCqgwkw7WuJl7ErDkfq','user',1,NULL),(2,'josedavids123@live.com','admin','$2a$10$OeSPEYiNVGCBi6nJpSCudemOYGoqUf0IVvEfI7jsoRoZVQ.xDhrX2','admin',2,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_seq`
--

DROP TABLE IF EXISTS `usuario_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_seq`
--

LOCK TABLES `usuario_seq` WRITE;
/*!40000 ALTER TABLE `usuario_seq` DISABLE KEYS */;
INSERT INTO `usuario_seq` VALUES (101);
/*!40000 ALTER TABLE `usuario_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-03 18:18:14
