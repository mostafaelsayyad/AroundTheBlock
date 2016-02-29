-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: aroundtheblock
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `Comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `User_Sim_Card_id` varchar(15) NOT NULL,
  `Service_id` int(11) NOT NULL,
  `Comment` longtext,
  `Comment_Upvote_Count` int(11) DEFAULT NULL,
  `Comment_Date` date NOT NULL,
  PRIMARY KEY (`Comment_id`),
  KEY `User_Sim_Card_id` (`User_Sim_Card_id`),
  KEY `Service_id` (`Service_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`User_Sim_Card_id`) REFERENCES `users` (`Sim_Card_id`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`Service_id`) REFERENCES `services` (`Service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments_upvotes`
--

DROP TABLE IF EXISTS `comments_upvotes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments_upvotes` (
  `Comments_Upvote_id` int(11) NOT NULL AUTO_INCREMENT,
  `Comment_id` int(11) NOT NULL,
  `User_Sim_Card_id` varchar(15) NOT NULL,
  PRIMARY KEY (`Comments_Upvote_id`),
  KEY `comments_upvotes_ibfk_1_idx` (`Comment_id`),
  KEY `comments_upvotes_ibfk_2_idx` (`User_Sim_Card_id`),
  CONSTRAINT `comments_upvotes_ibfk_1` FOREIGN KEY (`Comment_id`) REFERENCES `comments` (`Comment_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `comments_upvotes_ibfk_2` FOREIGN KEY (`User_Sim_Card_id`) REFERENCES `users` (`Sim_Card_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments_upvotes`
--

LOCK TABLES `comments_upvotes` WRITE;
/*!40000 ALTER TABLE `comments_upvotes` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments_upvotes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `services` (
  `Service_id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(25) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `Phone_Number` varchar(45) DEFAULT NULL,
  `Latitude` decimal(65,10) DEFAULT NULL,
  `Longitude` decimal(65,10) DEFAULT NULL,
  `Category` varchar(45) DEFAULT NULL,
  `Speciality` varchar(25) DEFAULT NULL,
  `Website` varchar(25) DEFAULT NULL,
  `Email` varchar(25) DEFAULT NULL,
  `Prices` varchar(25) DEFAULT '0',
  `App_Rating` varchar(25) DEFAULT '0',
  `Sum_of_User_Ratings` decimal(65,1) DEFAULT '0.0',
  `Count_of_User_Ratings` int(30) DEFAULT '0',
  `User_Rating` decimal(65,1) GENERATED ALWAYS AS ((`Sum_of_User_Ratings` / `Count_of_User_Ratings`)) VIRTUAL,
  `Logo` blob,
  PRIMARY KEY (`Service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` (`Service_id`, `Name`, `Address`, `Phone_Number`, `Latitude`, `Longitude`, `Category`, `Speciality`, `Website`, `Email`, `Prices`, `App_Rating`, `Sum_of_User_Ratings`, `Count_of_User_Ratings`, `Logo`) VALUES (1,'Wakishop','2 taha hussein st.','null',30.0638000000,31.2205000000,'women clothes',NULL,'theshelter-art.com','elalfy@theshelter-art.com','2.5','2.5',25.0,10,NULL),(2,'Wafflicious','2 taha hussein st.','1000979435',30.0637000000,31.2205000000,'restaurant','waffles',NULL,NULL,'3','4',0.0,NULL,NULL),(3,'Yamama Kiosk ','2 taha hussein st.','null ',30.0638000000,31.2206000000,'kiosk','cigarette',NULL,NULL,'standard','standard',0.0,NULL,NULL),(4,'NBK','2 taha hussein st.','null',30.0639000000,31.2205000000,'bank',NULL,NULL,NULL,'standard','standard',0.0,NULL,NULL),(5,'Pet Zone','2 taha hussein st.','1025376944',30.0639000000,31.2205000000,'pet shop & clinic',NULL,NULL,NULL,'3.5','4',0.0,NULL,NULL),(6,'Yamama Centre','3 taha hussein st.','null',30.0636000000,31.2207000000,'mall',NULL,NULL,NULL,'2','2',0.0,NULL,NULL),(7,'Yamama Centre Garage','3 taha hussein st.','null',30.0636000000,31.2207000000,'garage',NULL,NULL,NULL,'3.5','4',0.0,NULL,NULL),(8,'Rigoletto','3 taha hussein st. outside yamama centre','27358684',30.0636000000,31.2207000000,'restaurant','icecream','rigolettoicecream.com',NULL,'3','4',0.0,NULL,NULL),(9,'Buffalo Burger','3 taha hussein st. outside yamama centre','19914',30.0636000000,31.2207000000,'restaurant','burger','thebuffaloburger.com',NULL,'3','4',0.0,NULL,NULL),(10,'Dandasha','3 taha hussein st. yamama centre ground floor','27366316',30.0636000000,31.2207000000,'women clothes',NULL,NULL,NULL,'2','2.5',0.0,NULL,NULL),(11,'Akher Elankood','3 taha hussein st. yamama centre ground floor','27363431',30.0636000000,31.2207000000,'home &  various accessories',NULL,NULL,NULL,'2','2',0.0,NULL,NULL),(12,'2,5','3 taha hussein st. yamama centre ground floor','27363431',30.0636000000,31.2207000000,'home &  various accessories',NULL,NULL,NULL,'2','2',0.0,NULL,NULL),(13,'The Four Fat Ladies','3 taha hussein st. yamama centre ground floor','27371922, 01270011701',30.0636000000,31.2207000000,'restaurant (dessert)',NULL,NULL,NULL,'4',NULL,0.0,NULL,NULL),(14,'Genuine','3 taha hussein st. yamama centre ground floor','null',30.0636000000,31.2207000000,'women clothes','Bags & Shoes',NULL,NULL,'2','2',0.0,NULL,NULL),(15,'Dixis','3 taha hussein st. yamama centre ground floor','null',30.0636000000,31.2207000000,'women clothes',NULL,NULL,NULL,'2.5','2.5',0.0,NULL,NULL),(16,'Monkeys','3 taha hussein st. yamama centre ground floor','null',30.0636000000,31.2207000000,'toys',NULL,NULL,NULL,'2.5','2.5',0.0,NULL,NULL),(17,'Madrid','3 taha hussein st. yamama centre ground floor','null',30.0636000000,31.2207000000,'women clothes','Bags & Shoes',NULL,NULL,'2','2.5',0.0,NULL,NULL),(18,'Islam Thabet','3 taha hussein st. yamama centre ground floor','check',30.0636000000,31.2207000000,'jewellery',NULL,NULL,NULL,'check','check',0.0,NULL,NULL),(19,'Set Elkol','3 taha hussein st. yamama centre 1st floor','27363431, 01014145679',30.0636000000,31.2207000000,'home accessories',NULL,NULL,NULL,'2','2.5',0.0,NULL,NULL),(20,'Hello','3 taha hussein st. yamama centre 1st floor','1005342540, 0111532217',30.0636000000,31.2207000000,'women clothes','Bags & Shoes',NULL,NULL,'1.5','1.5',0.0,NULL,NULL),(21,'The Shelter','3 taha hussein st. yamama centre 1st floor','1222133716',30.0636000000,31.2207000000,'art & photography gallery',NULL,NULL,NULL,'3','3',0.0,NULL,NULL),(22,'Jacques Moréno','3 taha hussein st. yamama centre 1st floor','27358214, 27358215',30.0636000000,31.2207000000,'beauty centre',NULL,'jacques-moreno.com','info@jacques-moreno.com','check','check',0.0,NULL,NULL),(23,'Drake Store','3 taha hussein st. yamama centre 1st floor','null',30.0636000000,31.2207000000,'women clothes','Bags & Shoes',NULL,NULL,'1','1',0.0,NULL,NULL),(24,'FDA','3 taha hussein st. yamama centre','check',30.0636000000,31.2207000000,'gym',NULL,NULL,NULL,'check','check',0.0,NULL,NULL),(25,'Munch & Bagel','2 taha hussein st.','27354392, 01096155559',30.0640000000,31.2205000000,'restaurant','bagels',NULL,NULL,'3.5','3.5',0.0,NULL,NULL),(26,'Joe\'s Chocolate Bar','2 taha hussein st.','null',30.0640000000,31.2205000000,'restaurant','chocolate',NULL,NULL,'null','null',0.0,NULL,NULL),(27,'Alnomrosy','2 taha hussein st.','27382504',30.0641000000,31.2204000000,'knitting kits & accessories',NULL,NULL,NULL,'3','4',0.0,NULL,NULL),(28,'Power','2 taha hussein st.','check',30.0641000000,31.2204000000,'air conditioning shop',NULL,NULL,NULL,'check','check',0.0,NULL,NULL),(29,'Elhammam','2 taha hussein st.','check',30.0642000000,31.2203000000,'check',NULL,NULL,NULL,'check','check',0.0,NULL,NULL),(30,'Abdallah','2 taha hussein st.','27381988',30.0642000000,31.2203000000,'pharmacy',NULL,NULL,NULL,'standard','standard',0.0,NULL,NULL),(31,'Elfahd','2 taha hussein st.','27353700',30.0643000000,31.2203000000,'spice dealer',NULL,NULL,NULL,'3.5','4',0.0,NULL,NULL),(32,'Botros Bibawi','2 taha hussein st.','check',30.0643000000,31.2203000000,'check',NULL,NULL,NULL,'check','check',0.0,NULL,NULL),(33,'Alex Top','2 taha hussein st.','27357601',30.0643000000,31.2203000000,'restaurant','koshary',NULL,NULL,'3.5','3.5',0.0,NULL,NULL),(34,'Mohamed Amin','5 taha hussein st.','null',30.0640000000,31.2205000000,'jewellery',NULL,NULL,NULL,'standard','2.5',0.0,NULL,NULL),(35,'Yamama Mini Market','5 taha hussein st.','27369797',30.0642000000,31.2205000000,'mini market',NULL,NULL,NULL,'2.5','2.5',0.0,NULL,NULL),(36,'Touch of Flower','5 taha hussein st.','27369007, 01220001001',30.0643000000,31.2207000000,'flower shop',NULL,'touchflower.com','info@touchflower.com','3','4',0.0,NULL,NULL),(37,'Elgalla','15 taha hussein st.','check',30.0653000000,31.2203000000,'jewellery',NULL,NULL,NULL,'check','check',0.0,NULL,NULL),(38,'Rassem','15 taha hussein st.','27363531, 27382486',30.0653000000,31.2203000000,'pharmacy',NULL,NULL,NULL,'standard','standard',0.0,NULL,NULL),(39,'A Touch of Glass','15a taha hussein st.','27371488',30.0654000000,31.2203000000,'home accessories',NULL,NULL,'moharat@yahoo.com','3','4',0.0,NULL,NULL),(40,'Zafir','15b taha hussein st.','check',30.0654000000,31.2203000000,'check',NULL,NULL,NULL,'check','check',0.0,NULL,NULL),(41,'Munchies','15b taha hussein st.','27353370',30.0655000000,31.2203000000,'restaurant','waffles & crepe & pancake',NULL,NULL,'4','3.5',0.0,NULL,NULL),(42,'Saladero','15b taha hussein st.','1099751166',30.0655000000,31.2203000000,'restaurant','salad',NULL,NULL,'4','4',0.0,NULL,NULL),(43,'Abu Auf Nuts','15b taha hussein st.','27377968',30.0656000000,31.2202000000,'nuts shop',NULL,NULL,NULL,'4','4',0.0,NULL,NULL),(44,'Azza Fahmy','15c taha hussein st.','1066642365',30.0658000000,31.2202000000,'jewellery',NULL,'azzafahmy.com',NULL,'4','4.5',0.0,NULL,NULL),(45,'Zen','11b elmarashly st.','null',30.0658000000,31.2204000000,'art gallery & furniture',NULL,NULL,NULL,'null','4',0.0,NULL,NULL),(46,'Caravanserai','14 maraashly st.','27371399, 27350517',30.0660000000,31.2202000000,'furniture',NULL,'caravanseraifurniture.com','h.messallam@gmail.com','3.5','4',0.0,NULL,NULL),(47,'Mit Rehan','13 maraashly st.','27354378, 27365531, 27381447',30.0658000000,31.2204000000,'furniture',NULL,'mitrehan.com','support@mitrehan.com','3.5','3.5',0.0,NULL,NULL),(48,'K','16 elmarashly st.','null',30.0659000000,31.2205000000,'plumbing and electrical services',NULL,NULL,NULL,'null','null',0.0,NULL,NULL),(49,'Talaat','16 elmarashly st.','27350851, 0105173258',30.0659000000,31.2205000000,'electrical services',NULL,NULL,NULL,'3','3.5',0.0,NULL,NULL),(50,'Eden','16 elmarashly st.','check',30.0658000000,31.2205000000,'real estate  office',NULL,NULL,NULL,'check','check',0.0,NULL,NULL),(51,'La Trattoria','13 elmarashly st.','27350470',30.0655000000,31.2211000000,'restaurant',NULL,NULL,NULL,'3.5','4',0.0,NULL,NULL),(52,'Palace','18 elmarashly st.','27360560',30.0655000000,31.2211000000,'pharmacy',NULL,NULL,NULL,'standard','standard',0.0,NULL,NULL),(53,'69,','18b elmarashly st.','27365250',30.0654000000,31.2212000000,'women clothes shop',NULL,NULL,NULL,'4','4',0.0,NULL,NULL),(54,'Alrahma','18b elmarashly st.','null',30.0653000000,31.2214000000,'mosque',NULL,NULL,NULL,'null','null',0.0,NULL,NULL),(55,'Mince','13 ahmed heshmat st.','16885',30.0655000000,31.2214000000,'restaurant','burger','minceburgers.com',NULL,'3','4',0.0,NULL,NULL),(56,'Elramly','13 ahmed heshmat st.','check',30.0654000000,31.2214000000,'beauty centre',NULL,NULL,NULL,'2.5','2.5',0.0,NULL,NULL),(57,'Rashed','13 ahmed heshmat st.','27351762',30.0654000000,31.2214000000,'men\'s salon',NULL,NULL,NULL,'2.5','2.5',0.0,NULL,NULL),(58,'Jeff De Bruges','13 ahmed heshmat st.','27357982',30.0654000000,31.2215000000,'chocolate shop',NULL,NULL,NULL,'4.5','4.5',0.0,NULL,NULL),(59,'New Electric','20 elmarashly st.','27363793, 01001572803',30.0654000000,31.2215000000,'electrical services shop',NULL,NULL,NULL,'3.5','4',0.0,NULL,NULL),(60,'Seoudi','20 elmarashly st.','check',30.0654000000,31.2216000000,'supermarket',NULL,NULL,NULL,'3.5','4',0.0,NULL,NULL),(61,'Costa Coffee','21 elmarashly st.','16460',30.0653000000,31.2215000000,'café',NULL,NULL,NULL,'3.5','4',0.0,NULL,NULL),(62,'Rose Land','18a ahmed heshmat st.','27380354',30.0653000000,31.2214000000,'flower shop',NULL,NULL,NULL,'3.5','4',0.0,NULL,NULL),(63,'Burg Lab','21 elmarashly st.','19911',30.0653000000,31.2215000000,'health check up laboratory',NULL,NULL,NULL,'3','4.5',0.0,NULL,NULL),(64,'Alsharif Beaute','15 elmarashly st.','1000367060',30.0652000000,31.2215000000,'cosmetics & Perfumes',NULL,NULL,NULL,'3','3.5',0.0,NULL,NULL),(65,'Alaska','11 ahmed heshmat st.','27356904',30.0651000000,31.2215000000,'dry clean',NULL,NULL,NULL,'3','3.5',0.0,NULL,NULL),(66,'Auntie Loulou','11 ahmed heshmat st.','27352514, 01211311313',30.0649000000,31.2216000000,'restaurant & catering services',NULL,NULL,NULL,'3','3.5',0.0,NULL,NULL),(67,'Don Quichotte','9 ahmed heshmat st.','check',30.0649000000,31.2216000000,'bar',NULL,NULL,NULL,'4','4',0.0,NULL,NULL),(68,'Paradise','check','check',30.0635000000,31.2217000000,'travel agency',NULL,NULL,NULL,'check','check',0.0,NULL,NULL),(69,'La Maison De Mireille T.','7 ahmed heshmat st.','27351925, 27359698, 01224003830',30.0633000000,31.2219000000,'home decor',NULL,NULL,NULL,'3.5','4',0.0,NULL,NULL),(70,'Mondial','2 ahmed heshmat st.','27383453, 27361180',30.0631000000,31.2218000000,'pharmacy',NULL,NULL,NULL,'standard','standard',0.0,NULL,NULL),(71,'Abou Simble','2 ahmed heshmat st.','1119561834',30.0631000000,31.2218000000,'mini market',NULL,NULL,NULL,'standard','2',0.0,NULL,NULL);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `Sim_Card_id` varchar(15) NOT NULL,
  `Phone_Number` varchar(15) DEFAULT NULL,
  `Name` varchar(40) DEFAULT NULL,
  `Address` text,
  `Date_Of_Birth` date DEFAULT NULL,
  `Gender` bit(1) DEFAULT NULL,
  `Connected_To_Facebook` bit(1) DEFAULT NULL,
  PRIMARY KEY (`Sim_Card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_ratings`
--

DROP TABLE IF EXISTS `users_ratings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_ratings` (
  `User_Sim_Card_id` varchar(15) NOT NULL,
  `Service_id` int(11) NOT NULL,
  `User_Rating` decimal(65,1) NOT NULL,
  KEY `User_Sim_Card_id` (`User_Sim_Card_id`),
  KEY `Service_id` (`Service_id`),
  CONSTRAINT `users_ratings_ibfk_1` FOREIGN KEY (`User_Sim_Card_id`) REFERENCES `users` (`Sim_Card_id`),
  CONSTRAINT `users_ratings_ibfk_2` FOREIGN KEY (`Service_id`) REFERENCES `services` (`Service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_ratings`
--

LOCK TABLES `users_ratings` WRITE;
/*!40000 ALTER TABLE `users_ratings` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_ratings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-29 21:10:35
