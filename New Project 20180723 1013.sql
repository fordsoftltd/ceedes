-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bolatifedb
--

CREATE DATABASE IF NOT EXISTS bolatifedb;
USE bolatifedb;

--
-- Definition of table `applogs`
--

DROP TABLE IF EXISTS `applogs`;
CREATE TABLE `applogs` (
  `id` int(11) NOT NULL auto_increment,
  `description` text,
  `actionby` varchar(60) default NULL,
  `category` varchar(20) default NULL,
  `datelog` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `applogs`
--

/*!40000 ALTER TABLE `applogs` DISABLE KEYS */;
INSERT INTO `applogs` (`id`,`description`,`actionby`,`category`,`datelog`) VALUES 
 (1,'Employee created',NULL,NULL,'2018-07-21 19:00:36'),
 (2,'Employee created',NULL,NULL,'2018-07-21 19:13:01'),
 (3,'Vendor created',NULL,NULL,'2018-07-21 22:08:17'),
 (4,'Vendor created',NULL,NULL,'2018-07-21 22:09:19'),
 (5,'Employee Deleted',NULL,NULL,'2018-07-21 23:23:02'),
 (6,'Employee created',NULL,NULL,'2018-07-21 23:28:59'),
 (7,'Employee created',NULL,NULL,'2018-07-21 23:29:48'),
 (8,'Vendor Record Deleted',NULL,NULL,'2018-07-21 23:39:10'),
 (9,'Vendor Record Deleted',NULL,NULL,'2018-07-21 23:43:12'),
 (10,'Vendor created',NULL,NULL,'2018-07-21 23:44:13'),
 (11,'Role created',NULL,NULL,'2018-07-22 08:23:15'),
 (12,'Role created',NULL,NULL,'2018-07-22 08:25:37'),
 (13,'Role created',NULL,NULL,'2018-07-22 08:29:58'),
 (14,'Role  Deleted',NULL,NULL,'2018-07-22 08:30:06'),
 (15,'Role created',NULL,NULL,'2018-07-22 09:47:51'),
 (16,'Role created',NULL,NULL,'2018-07-22 09:50:45'),
 (17,'Role  Deleted',NULL,NULL,'2018-07-22 09:52:38'),
 (18,'Role  Deleted',NULL,NULL,'2018-07-22 09:52:55'),
 (19,'GBranch created',NULL,NULL,'2018-07-22 10:26:12'),
 (20,'Branch  Deleted',NULL,NULL,'2018-07-22 10:28:51'),
 (21,'GBranch created',NULL,NULL,'2018-07-22 10:31:56'),
 (22,'Transaction created',NULL,NULL,'2018-07-22 15:44:49'),
 (23,'Transaction created',NULL,NULL,'2018-07-22 15:45:38'),
 (24,'Role  Deleted',NULL,NULL,'2018-07-22 15:46:55'),
 (25,'Role created',NULL,NULL,'2018-07-22 17:02:19'),
 (26,'Role created',NULL,NULL,'2018-07-22 17:07:21'),
 (27,'Product Created',NULL,NULL,'2018-07-22 17:41:08'),
 (28,'Role created',NULL,NULL,'2018-07-22 17:48:31'),
 (29,'Role created',NULL,NULL,'2018-07-22 18:01:42'),
 (30,'Customer created',NULL,NULL,'2018-07-22 21:49:16'),
 (31,'Customer Record  Deleted',NULL,NULL,'2018-07-22 22:00:31'),
 (32,'Customer created',NULL,NULL,'2018-07-22 22:05:33'),
 (33,'Role created',NULL,NULL,'2018-07-23 08:08:27'),
 (34,'Customer created',NULL,NULL,'2018-07-23 09:40:29'),
 (35,'Asset created',NULL,NULL,'2018-07-23 09:40:29'),
 (36,'Customer created',NULL,NULL,'2018-07-23 09:48:56'),
 (37,'Asset created',NULL,NULL,'2018-07-23 09:48:56'),
 (38,'Assetrepair created',NULL,NULL,'2018-07-23 09:59:44'),
 (39,'Assetrepair created',NULL,NULL,'2018-07-23 09:59:44');
/*!40000 ALTER TABLE `applogs` ENABLE KEYS */;


--
-- Definition of table `asset`
--

DROP TABLE IF EXISTS `asset`;
CREATE TABLE `asset` (
  `id` int(11) NOT NULL auto_increment,
  `brand_name` varchar(50) default NULL,
  `modelno` varchar(20) default NULL,
  `description` text,
  `type` varchar(30) default NULL,
  `barcode` varchar(20) default NULL,
  `valuecost` double default NULL,
  `datepurchased` date default NULL,
  `datecreated` timestamp NULL default NULL,
  `institutionid` int(11) default NULL,
  `vendorid` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_asset_1` (`vendorid`),
  CONSTRAINT `FK_asset_1` FOREIGN KEY (`vendorid`) REFERENCES `vendor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `asset`
--

/*!40000 ALTER TABLE `asset` DISABLE KEYS */;
INSERT INTO `asset` (`id`,`brand_name`,`modelno`,`description`,`type`,`barcode`,`valuecost`,`datepurchased`,`datecreated`,`institutionid`,`vendorid`) VALUES 
 (1,'camry','1234','car','l2','23456',30000,NULL,NULL,NULL,NULL),
 (2,'camry','7888','looo','car','23456',300000,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;


--
-- Definition of table `assetissuance`
--

DROP TABLE IF EXISTS `assetissuance`;
CREATE TABLE `assetissuance` (
  `id` int(11) NOT NULL auto_increment,
  `dateissued` datetime default NULL,
  `issuedby` int(11) default NULL,
  `issuedto` int(11) default NULL,
  `assetid` int(11) default NULL,
  `description` varchar(200) default NULL,
  PRIMARY KEY  (`id`),
  KEY `fkassetissuedbyid` (`issuedby`),
  KEY `fkassetissuedtoid` (`issuedto`),
  KEY `fkassetissuancedid` (`assetid`),
  CONSTRAINT `fkassetissuancedid` FOREIGN KEY (`assetid`) REFERENCES `asset` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkassetissuedbyid` FOREIGN KEY (`issuedby`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkassetissuedtoid` FOREIGN KEY (`issuedto`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assetissuance`
--

/*!40000 ALTER TABLE `assetissuance` DISABLE KEYS */;
/*!40000 ALTER TABLE `assetissuance` ENABLE KEYS */;


--
-- Definition of table `assetrepair`
--

DROP TABLE IF EXISTS `assetrepair`;
CREATE TABLE `assetrepair` (
  `id` int(11) NOT NULL auto_increment,
  `lastrepaired` date default NULL,
  `moneyissued` double default NULL,
  `moneyissuedby` int(11) default NULL,
  `moneyreceivedby` int(11) default NULL,
  `assetid` int(11) default NULL,
  `datecreated` timestamp NULL default NULL,
  `description` varchar(200) default NULL,
  PRIMARY KEY  (`id`),
  KEY `moneyreceivedby` (`moneyreceivedby`),
  KEY `moneyissuedby` (`moneyissuedby`),
  KEY `assetrepairdassetid` (`assetid`),
  CONSTRAINT `assetrepairdassetid` FOREIGN KEY (`assetid`) REFERENCES `asset` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `moneyissuedby` FOREIGN KEY (`moneyissuedby`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `moneyreceivedby` FOREIGN KEY (`moneyreceivedby`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assetrepair`
--

/*!40000 ALTER TABLE `assetrepair` DISABLE KEYS */;
INSERT INTO `assetrepair` (`id`,`lastrepaired`,`moneyissued`,`moneyissuedby`,`moneyreceivedby`,`assetid`,`datecreated`,`description`) VALUES 
 (1,'2018-07-09',250000,NULL,NULL,NULL,NULL,'errr');
/*!40000 ALTER TABLE `assetrepair` ENABLE KEYS */;


--
-- Definition of table `banktransaction`
--

DROP TABLE IF EXISTS `banktransaction`;
CREATE TABLE `banktransaction` (
  `id` int(11) NOT NULL auto_increment,
  `description` varchar(45) default NULL,
  `depositorname` varchar(45) default NULL,
  `staff` int(11) default NULL,
  `accountno` varchar(45) default NULL,
  `bank` varchar(35) default NULL,
  `amountdeposit` double default NULL,
  `trandate` timestamp NULL default NULL,
  `datecreated` timestamp NULL default NULL,
  `category` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `banktransaction`
--

/*!40000 ALTER TABLE `banktransaction` DISABLE KEYS */;
INSERT INTO `banktransaction` (`id`,`description`,`depositorname`,`staff`,`accountno`,`bank`,`amountdeposit`,`trandate`,`datecreated`,`category`) VALUES 
 (1,'Daily Transaction','Yusuff Adediran',NULL,'0987678999','UBA',200000,'2018-07-23 00:00:00',NULL,NULL);
/*!40000 ALTER TABLE `banktransaction` ENABLE KEYS */;


--
-- Definition of table `branch`
--

DROP TABLE IF EXISTS `branch`;
CREATE TABLE `branch` (
  `id` int(11) NOT NULL auto_increment,
  `branchname` varchar(45) default NULL,
  `location` varchar(45) default NULL,
  `stockcapacity` int(11) default NULL,
  `datecreated` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch`
--

/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` (`id`,`branchname`,`location`,`stockcapacity`,`datecreated`) VALUES 
 (2,'Ajakuta Store','Kogi',30000,NULL);
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;


--
-- Definition of table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(45) default NULL,
  `contactaddress` varchar(45) default NULL,
  `phone` varchar(15) default NULL,
  `email` varchar(45) default NULL,
  `datecreated` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`,`name`,`contactaddress`,`phone`,`email`,`datecreated`) VALUES 
 (2,'Yusuff Adediran','Airport road ilorin','08060003318','me@mymail.com',NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


--
-- Definition of table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(45) default NULL,
  `contactaddress` varchar(50) default NULL,
  `email` varchar(40) default NULL,
  `phone` varchar(13) default NULL,
  `branch` int(11) default NULL,
  `passport` varchar(100) default NULL,
  `datecreated` timestamp NULL default NULL,
  `username` varchar(45) default NULL,
  `password` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`,`name`,`contactaddress`,`email`,`phone`,`branch`,`passport`,`datecreated`,`username`,`password`) VALUES 
 (2,'Odofin Oyejide','No 2 Muniratu cook st.','odofinTimothy@gmail.com','09039348473',NULL,NULL,'2018-07-21 23:28:58','jendxor','4444jidex'),
 (3,'Yusuff Adediran','Ibadan','us@ourmail.com','07060003318',NULL,NULL,'2018-07-21 23:29:48','me','11111');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


--
-- Definition of table `gass`
--

DROP TABLE IF EXISTS `gass`;
CREATE TABLE `gass` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `Volumes` int(10) unsigned default NULL,
  `vendor` int(10) unsigned default NULL,
  `datepurchased` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gass`
--

/*!40000 ALTER TABLE `gass` DISABLE KEYS */;
/*!40000 ALTER TABLE `gass` ENABLE KEYS */;


--
-- Definition of table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL auto_increment,
  `customer` int(11) default NULL,
  `staff` int(11) default NULL,
  `invoice` varchar(20) default NULL,
  `branchid` int(11) default NULL,
  `product` int(11) default NULL,
  `orderdate` datetime default NULL,
  `deliverydate` datetime default NULL,
  `discount` double default NULL,
  `VAT` double default NULL,
  `tax` double default NULL,
  `purchasedprice` double default NULL,
  `unitprice` double default NULL,
  `amountpaid` double default NULL,
  `notes` int(11) default NULL,
  `changegiven` double default NULL,
  `status` varchar(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `orderscustomerck` (`customer`),
  KEY `ordersstaffck` (`staff`),
  KEY `orderproductck` (`product`),
  CONSTRAINT `orderproductck` FOREIGN KEY (`product`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orderscustomerck` FOREIGN KEY (`customer`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ordersstaffck` FOREIGN KEY (`staff`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL auto_increment,
  `retailprice` double default NULL,
  `wholesalesprice` double default NULL,
  `category` varchar(50) default NULL,
  `purchasedprice` double default NULL,
  `datepurchased` timestamp NULL default NULL,
  `datecreated` timestamp NULL default NULL,
  `vendor` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `productvendorck` (`vendor`),
  CONSTRAINT `productvendorck` FOREIGN KEY (`vendor`) REFERENCES `vendor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`,`retailprice`,`wholesalesprice`,`category`,`purchasedprice`,`datepurchased`,`datecreated`,`vendor`) VALUES 
 (1,200,230,'2',150,'2018-07-19 00:00:00','2018-07-22 17:41:08',3);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `refunds`
--

DROP TABLE IF EXISTS `refunds`;
CREATE TABLE `refunds` (
  `id` int(11) NOT NULL auto_increment,
  `invoiceno` varchar(20) default NULL,
  `paymenttype` varchar(30) default NULL,
  `ordersid` int(11) default NULL,
  `amountpaid` double default NULL,
  `description` text,
  PRIMARY KEY  (`id`),
  KEY `orderidsck` (`ordersid`),
  CONSTRAINT `orderidsck` FOREIGN KEY (`ordersid`) REFERENCES `orders` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `refunds`
--

/*!40000 ALTER TABLE `refunds` DISABLE KEYS */;
/*!40000 ALTER TABLE `refunds` ENABLE KEYS */;


--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL auto_increment,
  `type` varchar(45) default NULL,
  `description` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`,`type`,`description`) VALUES 
 (6,NULL,NULL),
 (2,'Admin','adding deleting and editing'),
 (3,'User','Adding and editing'),
 (7,NULL,NULL),
 (8,NULL,NULL),
 (9,NULL,NULL),
 (10,NULL,NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `stafftb`
--

DROP TABLE IF EXISTS `stafftb`;
CREATE TABLE `stafftb` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(20) default NULL,
  `password` varchar(128) default NULL,
  `datecreated` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stafftb`
--

/*!40000 ALTER TABLE `stafftb` DISABLE KEYS */;
/*!40000 ALTER TABLE `stafftb` ENABLE KEYS */;


--
-- Definition of table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
CREATE TABLE `vendor` (
  `id` int(11) NOT NULL auto_increment,
  `companyname` varchar(45) default NULL,
  `product` varchar(45) default NULL,
  `contactaddress` varchar(50) default NULL,
  `phone` varchar(15) default NULL,
  `email` varchar(45) default NULL,
  `datecreated` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vendor`
--

/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` (`id`,`companyname`,`product`,`contactaddress`,`phone`,`email`,`datecreated`) VALUES 
 (3,'Adediran Yusuff','Cooking Gas','Ibadan','08060003318','me@mymail.com','2018-07-21 23:44:13');
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
