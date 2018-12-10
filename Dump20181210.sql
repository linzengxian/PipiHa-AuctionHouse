-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: mysql4.cs.stonybrook.edu    Database: zenlin
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `Account`
--

DROP TABLE IF EXISTS `Account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Account` (
  `Email` char(40) NOT NULL,
  `Password` char(20) NOT NULL,
  `Role` char(30) DEFAULT 'customer',
  PRIMARY KEY (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Account`
--

LOCK TABLES `Account` WRITE;
/*!40000 ALTER TABLE `Account` DISABLE KEYS */;
INSERT INTO `Account` VALUES ('can@gamil.com','123456','customer'),('linda@gmail.com','123123','customer'),('peilin.zhu@stonybrook.edu','123123','manager'),('tom@gmail.com','123456','customerRepresentative'),('zengxian.lin@stonybrook.edu','123456','manager');
/*!40000 ALTER TABLE `Account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Auction`
--

DROP TABLE IF EXISTS `Auction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Auction` (
  `AuctionID` int(7) NOT NULL,
  `BidIncrement` double DEFAULT NULL,
  `MinimuBid` double DEFAULT NULL,
  `Copies_Sold` int(11) DEFAULT NULL,
  `Monitor` int(9) NOT NULL,
  `ItemID` int(7) NOT NULL,
  `Reserve` double DEFAULT NULL,
  PRIMARY KEY (`AuctionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Auction`
--

LOCK TABLES `Auction` WRITE;
/*!40000 ALTER TABLE `Auction` DISABLE KEYS */;
INSERT INTO `Auction` VALUES (1,10,10,1,123456789,1,20),(2,5,20,1,123456789,2,25),(3,20,30,1,123456789,3,50),(4,20,30,1,123456789,4,60);
/*!40000 ALTER TABLE `Auction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AuctionHistory`
--

DROP TABLE IF EXISTS `AuctionHistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `AuctionHistory` (
  `AuctionID` int(7) NOT NULL,
  `ItemID` int(7) DEFAULT NULL,
  `SellerID` int(9) DEFAULT NULL,
  `BuyerID` int(9) DEFAULT NULL,
  `EmployeeID` int(9) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  `BidingPrice` double DEFAULT NULL,
  PRIMARY KEY (`AuctionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AuctionHistory`
--

LOCK TABLES `AuctionHistory` WRITE;
/*!40000 ALTER TABLE `AuctionHistory` DISABLE KEYS */;
INSERT INTO `AuctionHistory` VALUES (1,1,111111111,999883333,123456789,'2018-01-22 00:00:00',50),(5,4,222333222,999883333,123456789,'2018-01-22 00:00:00',70),(200,6,999883333,222333222,123456789,'2018-01-22 00:00:00',80);
/*!40000 ALTER TABLE `AuctionHistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Bid`
--

DROP TABLE IF EXISTS `Bid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Bid` (
  `CustomerID` int(9) NOT NULL,
  `AuctionID` int(7) DEFAULT NULL,
  `ItemID` int(7) NOT NULL,
  `BidTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `BidPrice` double DEFAULT NULL,
  `CurrentHighBid` double DEFAULT NULL,
  `CurrentBid` double DEFAULT NULL,
  PRIMARY KEY (`CustomerID`,`ItemID`,`BidTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bid`
--

LOCK TABLES `Bid` WRITE;
/*!40000 ALTER TABLE `Bid` DISABLE KEYS */;
INSERT INTO `Bid` VALUES (222333222,3,3,'2018-12-10 15:39:09',120,120,500),(222333222,3,3,'2018-12-10 15:39:16',500,500,500),(222333222,3,3,'2018-12-10 15:39:31',520,520,555),(222333222,3,3,'2018-12-10 15:39:39',555,555,555),(222333222,3,3,'2018-12-10 15:40:16',575,575,666),(222333222,3,3,'2018-12-10 15:40:53',686,686,700),(222333222,5,4,'2018-12-02 00:00:00',50,50,60),(222333222,3,6,'2018-12-10 15:40:20',666,666,666),(999883333,1,1,'2018-01-22 00:00:00',70,70,110),(999883333,2,2,'2018-01-10 00:00:00',60,60,80),(999883333,2,2,'2018-12-10 15:26:55',55,55,80),(999883333,2,2,'2018-12-10 15:28:21',55,55,80),(999883333,2,2,'2018-12-10 15:33:36',55,55,80),(999883333,2,2,'2018-12-10 15:34:50',65,65,80),(999883333,2,2,'2018-12-10 15:38:17',65,65,80),(999883333,3,3,'2018-12-02 00:00:00',50,50,100);
/*!40000 ALTER TABLE `Bid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Customer` (
  `Rating` int(11) DEFAULT NULL,
  `CreditCardNum` char(19) DEFAULT NULL,
  `CustomerID` int(9) NOT NULL,
  PRIMARY KEY (`CustomerID`),
  CONSTRAINT `cusID` FOREIGN KEY (`CustomerID`) REFERENCES `Person` (`SSN`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES (5,'1234222233334444',222333222),(5,'5555555555555555',444332222);
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Employee` (
  `StartDate` char(20) DEFAULT NULL,
  `HourlyRate` float DEFAULT NULL,
  `Level` char(30) DEFAULT NULL,
  `EmployeeID` int(9) NOT NULL,
  PRIMARY KEY (`EmployeeID`),
  CONSTRAINT `foreId` FOREIGN KEY (`EmployeeID`) REFERENCES `Person` (`SSN`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES ('1/1/17',1,'manager',110306362),('1/1/18',155,'customerRepresentative',123456789),('1/1/17',10000,'manager',872201479);
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Item`
--

DROP TABLE IF EXISTS `Item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Item` (
  `ItemID` int(7) NOT NULL,
  `Description` text,
  `Name` char(255) DEFAULT NULL,
  `Type` char(6) DEFAULT NULL,
  `NumCopies` int(11) DEFAULT NULL,
  PRIMARY KEY (`ItemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Item`
--

LOCK TABLES `Item` WRITE;
/*!40000 ALTER TABLE `Item` DISABLE KEYS */;
INSERT INTO `Item` VALUES (1,'book','Dream','book',1),(2,'dvd','Light','DVD',1),(3,'food','latiao','food',1),(4,'fish','Ball','ball',2),(5,'fire','fire ball','magic',1),(6,'water','water gun','magic',3);
/*!40000 ALTER TABLE `Item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Person` (
  `SSN` int(9) NOT NULL,
  `LastName` char(20) NOT NULL,
  `FirstName` char(20) NOT NULL,
  `Address` char(255) DEFAULT NULL,
  `City` char(20) DEFAULT NULL,
  `State` char(20) DEFAULT NULL,
  `ZipCode` int(11) DEFAULT NULL,
  `Telephone` char(15) DEFAULT NULL,
  `Email` char(40) NOT NULL,
  PRIMARY KEY (`SSN`),
  UNIQUE KEY `Email_UNIQUE` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` VALUES (110306362,'Zhu','Peilin','14704 cherry','ny','ny',11355,'8324200000','peilin.zhu@stonybrook.edu'),(123456789,'Tom','Cat','1234  4th Ave','NY','NY',12345,'1234567890','tom@gmail.com'),(222333222,'chen','andy','1234 7th','ny','ny',12345,'1233221232','can@gamil.com'),(444332222,'lin','da','123xxx','flushing','ny',11355,'4443332222','linda@gmail.com'),(872201479,'lin','zengxian','41-11 parsons','NY','NY',11355,'6464097950','zengxian.lin@stonybrook.edu');
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Post`
--

DROP TABLE IF EXISTS `Post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Post` (
  `ExpireDate` datetime DEFAULT NULL,
  `PostDate` datetime DEFAULT NULL,
  `CustomerID` int(9) NOT NULL,
  `AuctionID` int(7) NOT NULL,
  PRIMARY KEY (`CustomerID`,`AuctionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Post`
--

LOCK TABLES `Post` WRITE;
/*!40000 ALTER TABLE `Post` DISABLE KEYS */;
INSERT INTO `Post` VALUES ('2018-01-22 00:00:00','2018-01-20 00:00:00',111111111,1),('2018-01-11 00:00:00','2018-01-09 00:00:00',111111111,2),('2018-12-28 00:00:00','2018-12-01 00:00:00',111111111,3),('2018-12-28 00:00:00','2018-12-01 00:00:55',222333222,4);
/*!40000 ALTER TABLE `Post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `best_seller_items`
--

DROP TABLE IF EXISTS `best_seller_items`;
/*!50001 DROP VIEW IF EXISTS `best_seller_items`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `best_seller_items` AS SELECT 
 1 AS `ItemID`,
 1 AS `Total_Sold`,
 1 AS `Name`,
 1 AS `Type`,
 1 AS `Description`,
 1 AS `NumCopies`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `customermailinglist`
--

DROP TABLE IF EXISTS `customermailinglist`;
/*!50001 DROP VIEW IF EXISTS `customermailinglist`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `customermailinglist` AS SELECT 
 1 AS `CustomerID`,
 1 AS `LastName`,
 1 AS `FirstName`,
 1 AS `Address`,
 1 AS `City`,
 1 AS `State`,
 1 AS `ZipCode`,
 1 AS `Telephone`,
 1 AS `Email`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `best_seller_items`
--

/*!50001 DROP VIEW IF EXISTS `best_seller_items`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`zenlin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `best_seller_items` AS select `t`.`ItemID` AS `ItemID`,sum(`a`.`Copies_Sold`) AS `Total_Sold`,`i`.`Name` AS `Name`,`i`.`Type` AS `Type`,`i`.`Description` AS `Description`,`i`.`NumCopies` AS `NumCopies` from ((`auctionhistory` `t` join `auction` `a`) join `item` `i`) where ((`t`.`AuctionID` = `a`.`AuctionID`) and (`t`.`ItemID` = `i`.`ItemID`)) group by `t`.`ItemID` order by `a`.`Copies_Sold` desc limit 10 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `customermailinglist`
--

/*!50001 DROP VIEW IF EXISTS `customermailinglist`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`zenlin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `customermailinglist` AS select `p`.`SSN` AS `CustomerID`,`p`.`LastName` AS `LastName`,`p`.`FirstName` AS `FirstName`,`p`.`Address` AS `Address`,`p`.`City` AS `City`,`p`.`State` AS `State`,`p`.`ZipCode` AS `ZipCode`,`p`.`Telephone` AS `Telephone`,`p`.`Email` AS `Email` from `person` `p` where `p`.`SSN` in (select `customer`.`CustomerID` from `customer`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-10 16:15:53
