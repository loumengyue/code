-- MySQL dump 10.13  Distrib 5.7.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: country_manager
-- ------------------------------------------------------
-- Server version	5.7.30-log

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
-- Table structure for table `activity_manage`
--

DROP TABLE IF EXISTS `activity_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_manage` (
  `activity_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `activity_type` varchar(12) DEFAULT NULL COMMENT '活动类型',
  `activity_content` varchar(20) DEFAULT NULL COMMENT '活动内容',
  `activity_start_time` datetime DEFAULT NULL COMMENT '活动开始时间',
  `activity_end_time` datetime DEFAULT NULL COMMENT '活动结束时间',
  `activity_organ_id` int(12) DEFAULT NULL COMMENT '活动发起机构id',
  `activity_person` varchar(12) DEFAULT NULL COMMENT '活动针对人群',
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_manage`
--

LOCK TABLES `activity_manage` WRITE;
/*!40000 ALTER TABLE `activity_manage` DISABLE KEYS */;
INSERT INTO `activity_manage` VALUES (2,'农','体检','2021-03-02 00:00:00','2021-03-02 00:00:00',1,'群众'),(3,'搜索','开会','2021-02-28 00:00:00','2021-03-28 00:00:00',3,'大队'),(4,'开会','开会','2021-03-02 00:00:00','2021-03-16 00:00:00',1,'群众'),(5,'开会','开会','2021-05-02 00:00:00','2021-05-03 00:00:00',1,'群众'),(6,'开会','开会','2021-05-05 00:00:00','2021-05-05 00:00:00',1,'群众'),(7,'开会','开会','2021-05-03 00:00:00','2021-05-06 00:00:00',1,'群众'),(8,'开会','开会','2021-05-02 00:00:00','2021-05-04 00:00:00',1,'群众'),(9,'体检','体检','2021-05-03 00:00:00','2021-05-04 00:00:00',1,'群众'),(10,'体检','体检','2021-05-03 00:00:00','2021-05-03 00:00:00',1,'群众'),(11,'体检','体检','2021-05-03 00:00:00','2021-05-04 00:00:00',2,'群众'),(12,'体检','体检','2021-05-06 00:00:00','2021-05-07 00:00:00',2,'大队'),(13,'体检','体检','2021-05-04 00:00:00','2021-05-06 00:00:00',2,'大队'),(14,'体检','体检','2021-05-03 00:00:00','2021-05-06 00:00:00',2,'大队'),(15,'体检','体检','2021-05-02 00:00:00','2021-05-02 00:00:00',2,'大队'),(16,'体检','体检','2021-05-06 00:00:00','2021-05-08 00:00:00',2,'大队'),(17,'体检','体检','2021-05-03 00:00:00','2021-05-08 00:00:00',2,'大队'),(18,'开会','开会','2021-05-16 00:00:00','2021-05-12 00:00:00',2,'大队'),(19,'开会','开会','2021-05-03 00:00:00','2021-05-08 00:00:00',2,'大队'),(20,'开会','开会','2021-05-04 00:00:00','2021-05-06 00:00:00',2,'大队'),(21,'开会','开会','2021-05-05 00:00:00','2021-05-07 00:00:00',2,'大队'),(22,'2','222','2021-05-03 00:00:00','2021-05-05 00:00:00',0,'22'),(24,'芳芳','芳芳','2021-05-17 18:49:08','2021-05-17 18:49:10',0,'的'),(25,'22','体检','2021-05-17 19:02:03','2021-05-17 19:02:05',1,'群众');
/*!40000 ALTER TABLE `activity_manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file_manage`
--

DROP TABLE IF EXISTS `file_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file_manage` (
  `file_id` int(12) NOT NULL COMMENT '文件id',
  `file_name` varchar(120) DEFAULT NULL COMMENT '文件名称',
  `file_route` varchar(120) DEFAULT NULL COMMENT '文件上传路径',
  `file_type` varchar(6) DEFAULT NULL COMMENT '文件类型',
  `file_brief` varchar(255) DEFAULT NULL COMMENT '文件简介',
  `file_up_time` datetime DEFAULT NULL COMMENT '文件上传时间',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_manage`
--

LOCK TABLES `file_manage` WRITE;
/*!40000 ALTER TABLE `file_manage` DISABLE KEYS */;
INSERT INTO `file_manage` VALUES (0,'a.jpg','D:\\tangyuan\\a.jpg','.jpg','加油','2021-05-05 23:12:37'),(1,'哈','111','.doc','加油','2021-03-09 00:00:00');
/*!40000 ALTER TABLE `file_manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `helper_manage`
--

DROP TABLE IF EXISTS `helper_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `helper_manage` (
  `helper_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '帮扶id',
  `helper_population_id` varchar(36) DEFAULT NULL COMMENT '帮扶对象id',
  `helper_type` varchar(10) DEFAULT NULL COMMENT '帮扶类型',
  `helper_time` datetime DEFAULT NULL COMMENT '帮扶时间',
  `helper_executed` varchar(12) DEFAULT NULL COMMENT '帮扶的执行者',
  `helper_village_id` int(12) DEFAULT NULL COMMENT '帮扶对象所属村委id',
  `helper_status` int(4) DEFAULT NULL COMMENT '帮扶对象所处状态 0 未帮扶  1 帮扶中  2  帮扶结束',
  PRIMARY KEY (`helper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `helper_manage`
--

LOCK TABLES `helper_manage` WRITE;
/*!40000 ALTER TABLE `helper_manage` DISABLE KEYS */;
INSERT INTO `helper_manage` VALUES (1,'0001','低保户','2021-03-10 00:00:00','乡长',1,1),(3,'0002','残疾人','2021-05-10 16:55:01','大队',1,3),(4,'0003','残疾人','2021-03-16 00:00:00','大队',1,1),(5,'0004','残疾人','2021-03-16 00:00:00','大队',1,3),(6,'0005','残疾人','2021-03-16 00:00:00','大队',1,3),(7,'0006','低保户','2021-05-04 00:00:00','大队',1,2),(8,'0007','低保户','2021-05-06 00:00:00','大队',1,2),(9,'0009','低保户','2021-05-08 00:00:00','大队',1,2),(10,'0011','低保户','2021-05-14 00:00:00','大队',1,2),(11,'0010','低保户','2021-05-14 00:00:00','大队',1,2),(14,'0008','低保户','2021-05-19 00:00:00','乡长',1,3),(17,'0012','低保户','2021-05-10 16:39:56','乡长',2,2),(18,'0013','孤儿','2021-05-10 16:55:01','乡长',2,2),(19,'0016','孤儿','2021-05-10 16:55:01','乡长',9,2),(20,'0014','孤儿','2021-05-12 20:28:10','乡长',9,1),(27,'0018','低保户','2021-05-17 19:06:28','大队',18,1),(28,'0018','低保户','2021-05-17 19:11:00','大队',1,1);
/*!40000 ALTER TABLE `helper_manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `house_manage`
--

DROP TABLE IF EXISTS `house_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `house_manage` (
  `house_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '宅基地id',
  `house_address` varchar(20) DEFAULT NULL COMMENT '宅基地地址',
  `house_population_id` varchar(20) DEFAULT NULL COMMENT '宅基地拥者id',
  `house_apply_time` datetime DEFAULT NULL COMMENT '宅基地申请时间',
  `house_status` int(11) DEFAULT NULL COMMENT '宅基地状态（0拥有1申请中2暂无申请）',
  `house_area` int(11) DEFAULT NULL COMMENT '宅基地面积',
  `house_village_id` int(12) DEFAULT NULL,
  `house_desc` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`house_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `house_manage`
--

LOCK TABLES `house_manage` WRITE;
/*!40000 ALTER TABLE `house_manage` DISABLE KEYS */;
INSERT INTO `house_manage` VALUES (1,'湖南省娄底市新化县维山乡维山村','0001','2021-02-04 00:00:00',2,1000,1,'申请人：陆齐，女，汉族，农民，身份证号:410255687963214520\r\n联系电话：114523652432\r\n申请事项：申请农村宅基地以新建住房。\r\n事实和理由：这些年来，党的政策越来越好，我们农民的收入也一年比一年增加，我通过多年的辛苦劳动，不断积攒，已基本上攒够了建新房（建成砖滋水泥房）的费用，只须上级一批准，我就能马上动工，不是过年过节都没有一个安全的家，加上小孩已大，现在的住房问题是我第一个愿望，请上级能批准我的申请为谢。特此申请，敬请贵村委会核实情况，审核批准为盼。'),(2,'湖南省娄底市新化县维山乡维山村','0002','2021-02-05 00:00:00',2,120,1,'申请人：陆齐，女，汉族，农民，身份证号:410255687963214520\r\n联系电话：114523652432\r\n申请事项：申请农村宅基地以新建住房。\r\n事实和理由：这些年来，党的政策越来越好，我们农民的收入也一年比一年增加，我通过多年的辛苦劳动，不断积攒，已基本上攒够了建新房（建成砖滋水泥房）的费用，只须上级一批准，我就能马上动工，不是过年过节都没有一个安全的家，加上小孩已大，现在的住房问题是我第一个愿望，请上级能批准我的申请为谢。特此申请，敬请贵村委会核实情况，审核批准为盼。'),(3,'湖南省娄底市新化县维山乡维山村','0003','2021-02-02 00:00:00',2,120,1,'申请人：陆齐，女，汉族，农民，身份证号:410255687963214520\r\n联系电话：114523652432\r\n申请事项：申请农村宅基地以新建住房。\r\n事实和理由：这些年来，党的政策越来越好，我们农民的收入也一年比一年增加，我通过多年的辛苦劳动，不断积攒，已基本上攒够了建新房（建成砖滋水泥房）的费用，只须上级一批准，我就能马上动工，不是过年过节都没有一个安全的家，加上小孩已大，现在的住房问题是我第一个愿望，请上级能批准我的申请为谢。特此申请，敬请贵村委会核实情况，审核批准为盼。'),(4,'湖南省娄底市新化县维山乡维山村','0004','2021-02-02 00:00:00',2,120,1,'申请人：陆齐，女，汉族，农民，身份证号:410255687963214520\r\n联系电话：114523652432\r\n申请事项：申请农村宅基地以新建住房。\r\n事实和理由：这些年来，党的政策越来越好，我们农民的收入也一年比一年增加，我通过多年的辛苦劳动，不断积攒，已基本上攒够了建新房（建成砖滋水泥房）的费用，只须上级一批准，我就能马上动工，不是过年过节都没有一个安全的家，加上小孩已大，现在的住房问题是我第一个愿望，请上级能批准我的申请为谢。特此申请，敬请贵村委会核实情况，审核批准为盼。'),(5,'湖南省娄底市新化县维山乡维山村','0005','2021-02-02 00:00:00',2,120,1,'申请人：陆齐，女，汉族，农民，身份证号:410255687963214520\r\n联系电话：114523652432\r\n申请事项：申请农村宅基地以新建住房。\r\n事实和理由：这些年来，党的政策越来越好，我们农民的收入也一年比一年增加，我通过多年的辛苦劳动，不断积攒，已基本上攒够了建新房（建成砖滋水泥房）的费用，只须上级一批准，我就能马上动工，不是过年过节都没有一个安全的家，加上小孩已大，现在的住房问题是我第一个愿望，请上级能批准我的申请为谢。特此申请，敬请贵村委会核实情况，审核批准为盼。'),(6,'湖南省娄底市新化县维山乡维山村','0006','2021-02-02 00:00:00',2,120,1,'申请人：陆齐，女，汉族，农民，身份证号:410255687963214520\r\n联系电话：114523652432\r\n申请事项：申请农村宅基地以新建住房。\r\n事实和理由：这些年来，党的政策越来越好，我们农民的收入也一年比一年增加，我通过多年的辛苦劳动，不断积攒，已基本上攒够了建新房（建成砖滋水泥房）的费用，只须上级一批准，我就能马上动工，不是过年过节都没有一个安全的家，加上小孩已大，现在的住房问题是我第一个愿望，请上级能批准我的申请为谢。特此申请，敬请贵村委会核实情况，审核批准为盼。'),(7,'湖南省娄底市新化县维山乡维山村','0007','2021-02-02 00:00:00',2,120,1,'申请人：陆齐，女，汉族，农民，身份证号:410255687963214520\r\n联系电话：114523652432\r\n申请事项：申请农村宅基地以新建住房。\r\n事实和理由：这些年来，党的政策越来越好，我们农民的收入也一年比一年增加，我通过多年的辛苦劳动，不断积攒，已基本上攒够了建新房（建成砖滋水泥房）的费用，只须上级一批准，我就能马上动工，不是过年过节都没有一个安全的家，加上小孩已大，现在的住房问题是我第一个愿望，请上级能批准我的申请为谢。特此申请，敬请贵村委会核实情况，审核批准为盼。'),(8,'湖南省娄底市新化县维山乡维山村','0008','2021-02-02 00:00:00',3,120,1,'申请人：陆齐，女，汉族，农民，身份证号:410255687963214520\r\n联系电话：114523652432\r\n申请事项：申请农村宅基地以新建住房。\r\n事实和理由：这些年来，党的政策越来越好，我们农民的收入也一年比一年增加，我通过多年的辛苦劳动，不断积攒，已基本上攒够了建新房（建成砖滋水泥房）的费用，只须上级一批准，我就能马上动工，不是过年过节都没有一个安全的家，加上小孩已大，现在的住房问题是我第一个愿望，请上级能批准我的申请为谢。特此申请，敬请贵村委会核实情况，审核批准为盼。'),(9,'湖南省娄底市新化县维山乡维山村','0009','2021-02-02 00:00:00',1,120,1,'申请人：陆齐，女，汉族，农民，身份证号:410255687963214520\r\n联系电话：114523652432\r\n申请事项：申请农村宅基地以新建住房。\r\n事实和理由：这些年来，党的政策越来越好，我们农民的收入也一年比一年增加，我通过多年的辛苦劳动，不断积攒，已基本上攒够了建新房（建成砖滋水泥房）的费用，只须上级一批准，我就能马上动工，不是过年过节都没有一个安全的家，加上小孩已大，现在的住房问题是我第一个愿望，请上级能批准我的申请为谢。特此申请，敬请贵村委会核实情况，审核批准为盼。'),(10,'湖南省娄底市新化县维山乡维山村','0010','2021-02-02 00:00:00',2,120,1,'申请人：陆齐，女，汉族，农民，身份证号:410255687963214520\r\n联系电话：114523652432\r\n申请事项：申请农村宅基地以新建住房。\r\n事实和理由：这些年来，党的政策越来越好，我们农民的收入也一年比一年增加，我通过多年的辛苦劳动，不断积攒，已基本上攒够了建新房（建成砖滋水泥房）的费用，只须上级一批准，我就能马上动工，不是过年过节都没有一个安全的家，加上小孩已大，现在的住房问题是我第一个愿望，请上级能批准我的申请为谢。特此申请，敬请贵村委会核实情况，审核批准为盼。'),(11,'湖南省娄底市新化县维山乡维山村','0011','2021-03-10 00:00:00',2,200,1,'申请人：陆齐，女，汉族，农民，身份证号:410255687963214520\r\n联系电话：114523652432\r\n申请事项：申请农村宅基地以新建住房。\r\n事实和理由：这些年来，党的政策越来越好，我们农民的收入也一年比一年增加，我通过多年的辛苦劳动，不断积攒，已基本上攒够了建新房（建成砖滋水泥房）的费用，只须上级一批准，我就能马上动工，不是过年过节都没有一个安全的家，加上小孩已大，现在的住房问题是我第一个愿望，请上级能批准我的申请为谢。特此申请，敬请贵村委会核实情况，审核批准为盼。'),(12,'湖南省娄底市新化县维山乡双井村','0012','2021-05-10 20:26:10',2,123,2,'申请人：陆齐，女，汉族，农民，身份证号:410255687963214520\r\n联系电话：114523652432\r\n申请事项：申请农村宅基地以新建住房。\r\n事实和理由：这些年来，党的政策越来越好，我们农民的收入也一年比一年增加，我通过多年的辛苦劳动，不断积攒，已基本上攒够了建新房（建成砖滋水泥房）的费用，只须上级一批准，我就能马上动工，不是过年过节都没有一个安全的家，加上小孩已大，现在的住房问题是我第一个愿望，请上级能批准我的申请为谢。特此申请，敬请贵村委会核实情况，审核批准为盼。'),(13,'湖南省娄底市新化县维山乡双井村','0013','2021-05-12 23:15:44',1,111,2,'申请人：陆齐，女，汉族，农民，身份证号:410255687963214520\r\n联系电话：114523652432\r\n申请事项：申请农村宅基地以新建住房。\r\n事实和理由：这些年来，党的政策越来越好，我们农民的收入也一年比一年增加，我通过多年的辛苦劳动，不断积攒，已基本上攒够了建新房（建成砖滋水泥房）的费用，只须上级一批准，我就能马上动工，不是过年过节都没有一个安全的家，加上小孩已大，现在的住房问题是我第一个愿望，请上级能批准我的申请为谢。特此申请，敬请贵村委会核实情况，审核批准为盼。'),(14,'湖南省娄底市新化县维山乡三联洞村','0014','2021-05-12 23:15:44',3,444,9,'申请人：陆齐，女，汉族，农民，身份证号:410255687963214520\r\n联系电话：114523652432\r\n申请事项：申请农村宅基地以新建住房。\r\n事实和理由：这些年来，党的政策越来越好，我们农民的收入也一年比一年增加，我通过多年的辛苦劳动，不断积攒，已基本上攒够了建新房（建成砖滋水泥房）的费用，只须上级一批准，我就能马上动工，不是过年过节都没有一个安全的家，加上小孩已大，现在的住房问题是我第一个愿望，请上级能批准我的申请为谢。特此申请，敬请贵村委会核实情况，审核批准为盼。'),(15,'湖南省娄底市新化县维山乡维山村','0017','2021-05-13 12:26:35',1,133,1,'申请人：陆齐，女，汉族，农民，身份证号:410255687963214520\r\n联系电话：114523652432\r\n申请事项：申请农村宅基地以新建住房。\r\n事实和理由：这些年来，党的政策越来越好，我们农民的收入也一年比一年增加，我通过多年的辛苦劳动，不断积攒，已基本上攒够了建新房（建成砖滋水泥房）的费用，只须上级一批准，我就能马上动工，不是过年过节都没有一个安全的家，加上小孩已大，现在的住房问题是我第一个愿望，请上级能批准我的申请为谢。特此申请，敬请贵村委会核实情况，审核批准为盼。'),(17,'湖南省娄底市新化县维山乡维山村','0018','2021-05-17 19:03:57',1,111,0,''),(18,'湖南省娄底市新化县维山乡维山村','0018','2021-05-17 19:03:57',2,111,0,''),(21,'湖南省娄底市新化县维山乡维山村','0019','2021-05-17 20:20:07',1,123,1,'发发发');
/*!40000 ALTER TABLE `house_manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_manage`
--

DROP TABLE IF EXISTS `member_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_manage` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `member_id` int(12) DEFAULT NULL COMMENT '党员编号',
  `member_name` varchar(12) DEFAULT NULL COMMENT '党员名字',
  `member_status` int(6) DEFAULT NULL COMMENT '党员状态（0在档1，离党）',
  `member_identity` int(6) DEFAULT NULL COMMENT '人员身份（0党员 1积极分子）',
  `member_start_time` datetime DEFAULT NULL COMMENT '入党时间',
  `member_end_time` datetime DEFAULT NULL COMMENT '脱党时间',
  `member_active_time` datetime DEFAULT NULL COMMENT '成为积极积极分子时间',
  `member_party_id` int(6) DEFAULT NULL COMMENT '党员所在组织',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_manage`
--

LOCK TABLES `member_manage` WRITE;
/*!40000 ALTER TABLE `member_manage` DISABLE KEYS */;
INSERT INTO `member_manage` VALUES (1,1,'岐神',0,0,'2021-02-01 00:00:00','2021-03-18 00:00:00','2021-02-01 00:00:00',1);
/*!40000 ALTER TABLE `member_manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_manage`
--

DROP TABLE IF EXISTS `menu_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_manage` (
  `menu_id` int(12) NOT NULL AUTO_INCREMENT COMMENT 'menu编号',
  `menu_name` varchar(12) DEFAULT NULL COMMENT 'menu名称',
  `menu_path` varchar(20) DEFAULT NULL COMMENT 'menu路径',
  `menu_role_id` int(12) DEFAULT NULL COMMENT 'menu拥有的角色id',
  `menu_type` int(5) DEFAULT NULL COMMENT 'menu分级',
  `menu_list` int(5) DEFAULT NULL COMMENT 'menu分属列表',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_manage`
--

LOCK TABLES `menu_manage` WRITE;
/*!40000 ALTER TABLE `menu_manage` DISABLE KEYS */;
INSERT INTO `menu_manage` VALUES (1,'首页','/shouye',2,1,1),(2,'个人中心','/massage',2,1,2),(3,'个人资料','/massage',2,2,2),(4,'修改密码','/massage',2,2,2),(5,'党建管理','/party',1,1,5),(6,'党员信息','/party',1,2,5),(7,'党建活动','/party',1,2,5),(8,'首页','/shouyes',1,1,8);
/*!40000 ALTER TABLE `menu_manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news_manage`
--

DROP TABLE IF EXISTS `news_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news_manage` (
  `new_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '通知id',
  `new_title` varchar(12) DEFAULT NULL COMMENT '通知标题',
  `new_content` varchar(255) DEFAULT NULL COMMENT '通知内容',
  `new_time` datetime DEFAULT NULL COMMENT '通知时间',
  `new_person` varchar(12) DEFAULT NULL COMMENT '通知人',
  `new_priority` int(2) DEFAULT NULL COMMENT '通知是否置顶（0不置顶1置顶）',
  PRIMARY KEY (`new_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news_manage`
--

LOCK TABLES `news_manage` WRITE;
/*!40000 ALTER TABLE `news_manage` DISABLE KEYS */;
INSERT INTO `news_manage` VALUES (1,'通知1','维山村书记李强同志，4月1号开会，准时到场','2021-02-02 00:00:00','刘军',1),(2,'通知2','宅基地登记请维山村干事在本月7号前完成','2021-04-06 00:00:00','刘军',1),(3,'通知3','请各村村委于本月7号前按时提交宅基地登记表。及时做好各村的体检动员，鼓励村民积极参与。请各村村委于本月7号前按时提交宅基地登记表。及时做好各村的体检动员，鼓励村民积极参与。','2021-04-15 00:00:00','刘军',1),(4,'通知4','维山村书记李强同志，4月1号开会，准时到场','2021-05-01 00:00:00','刘军',1),(5,'通知5','维山村书记李强同志，4月1号开会，准时到场','2021-05-01 00:00:00','张三',1),(6,'通知6','维山村书记李强同志，4月1号开会，准时到场','2021-05-02 00:00:00','张三',1),(7,'通知7','维山村书记李强同志，4月1号开会，准时到场','2021-05-02 00:00:00','张三',1),(8,'通知8','维山村书记李强同志，4月1号开会，准时到场','2021-05-03 00:00:00','张三',1),(9,'通知9','维山村书记李强同志，4月1号开会，准时到场','2021-05-04 00:00:00','张三',1),(10,'通知10','维山村书记李强同志，4月1号开会，准时到场','2021-05-06 00:00:00','张三',1),(11,'通知11','维山村书记李强同志，4月1号开会，准时到场','2021-05-12 00:00:00','张三',1),(12,'通知12','维山村书记李强同志，4月1号开会，准时到场','2021-05-13 00:00:00','张三',1);
/*!40000 ALTER TABLE `news_manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organ_manage`
--

DROP TABLE IF EXISTS `organ_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organ_manage` (
  `organ_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '机构id',
  `organ_name` varchar(12) DEFAULT NULL COMMENT '机构名称',
  `organ_duty` varchar(15) DEFAULT NULL COMMENT '机构职责',
  `organ_leader` varchar(12) DEFAULT NULL COMMENT '机构负责人',
  `organ_phone` varchar(15) DEFAULT NULL COMMENT '办公电话',
  `organ_leader_phone` varchar(15) DEFAULT NULL COMMENT '机构负责人电话',
  `organ_time` datetime DEFAULT NULL COMMENT '机构成立时间',
  `organ_village_id` int(12) DEFAULT NULL COMMENT '所属村委id',
  PRIMARY KEY (`organ_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organ_manage`
--

LOCK TABLES `organ_manage` WRITE;
/*!40000 ALTER TABLE `organ_manage` DISABLE KEYS */;
INSERT INTO `organ_manage` VALUES (1,'卫生所','管理卫生','张三','12354879525','14256323545','2021-02-02 00:00:00',1),(2,'卫生所','管理卫生','李四','14256323547','15619845632','2021-02-01 00:00:00',8),(3,'财务所','管理财务','万古','15619845632','14256323547','2021-02-23 00:00:00',2),(4,'财务所','管理财务','万古','14256323547','15619845632','2021-05-03 00:00:00',1),(5,'财务所','管理财务','万古','14256323547','15619845632','2021-05-05 00:00:00',1),(6,'财务所','管理财务','万古','15619845632','15619845632','2021-05-06 00:00:00',4),(7,'财务所','管理财务','万古','14256323547','15619845632','2021-05-07 00:00:00',1),(8,'财务所','管理财务','万古','15619845632','15619845632','2021-05-08 00:00:00',11),(9,'财务所','管理财务','万古','14256323547','15619845632','2021-05-19 00:00:00',1),(10,'财务所','管理财务','万古','15619845632','15619845632','2021-05-14 00:00:00',5),(11,'财务所','管理财务','万古','14256323547','15619845632','2021-05-28 00:00:00',7);
/*!40000 ALTER TABLE `organ_manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party_manage`
--

DROP TABLE IF EXISTS `party_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `party_manage` (
  `party_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '党组织编号',
  `party_name` varchar(12) DEFAULT NULL COMMENT '党组织名称',
  `parent_party` int(12) DEFAULT NULL COMMENT '党组织所属组织',
  `party_start_time` datetime DEFAULT NULL COMMENT '党组成立时间',
  PRIMARY KEY (`party_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party_manage`
--

LOCK TABLES `party_manage` WRITE;
/*!40000 ALTER TABLE `party_manage` DISABLE KEYS */;
INSERT INTO `party_manage` VALUES (1,'岐岐',2,'2021-02-02 00:00:00'),(2,'山支',NULL,'2021-02-02 00:00:00');
/*!40000 ALTER TABLE `party_manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `population_manage`
--

DROP TABLE IF EXISTS `population_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `population_manage` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '表id',
  `population_id` varchar(36) DEFAULT NULL COMMENT '人口编号',
  `population_name` varchar(12) DEFAULT NULL COMMENT '人口姓名',
  `population_age` int(12) DEFAULT NULL COMMENT '人口年龄',
  `population_address` varchar(20) DEFAULT NULL COMMENT '人口所在地址',
  `population_type` int(6) DEFAULT NULL COMMENT '人口类型(0属于本地1属于外地)',
  `population_local_type` int(6) DEFAULT NULL COMMENT '本地人口类型（0是常住1是外出）',
  `population_village_id` int(12) DEFAULT NULL COMMENT '人口所属村委',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `population_manage`
--

LOCK TABLES `population_manage` WRITE;
/*!40000 ALTER TABLE `population_manage` DISABLE KEYS */;
INSERT INTO `population_manage` VALUES (1,'0001','张三',23,'湖南省娄底市新化县维山乡维山村',0,0,1),(2,'0002','李四',23,'湖南省娄底市新化县维山乡维山村',0,0,1),(4,'0003','张军',55,'湖南省娄底市新化县维山乡维山村',0,1,1),(5,'0004','吴老狗',65,'湖南省娄底市新化县维山乡维山村',0,0,1),(6,'0005','吴小狗',43,'湖南省娄底市新化县维山乡维山村',0,1,1),(7,'0006','萨瓦',22,'湖南省娄底市新化县维山乡维山村',1,1,1),(8,'0007','王五',44,'湖南省娄底市新化县维山乡维山村',1,1,1),(9,'0008','赵乐乐',55,'湖南省娄底市新化县维山乡维山村',1,0,1),(10,'0009','李强国',33,'湖南省娄底市新化县维山乡维山村',0,0,1),(11,'0010','王栓',7,'湖南省娄底市新化县维山乡维山村',0,1,1),(12,'0011','陈国鹏',88,'湖南省娄底市新化县维山乡维山村',1,1,1),(13,'0012','王晓',34,'湖南省娄底市新化县维山乡双井村',1,1,2),(14,'0013','李达',44,'湖南省娄底市新化县维山乡双井村',0,0,2),(15,'0014','张宏',34,'湖南省娄底市新化县维山乡三联洞村',0,0,9),(16,'0015','王晓丽',33,'湖南省娄底市新化县维山乡三联洞村',1,1,9),(18,'0016','张振',33,'湖南省娄底市新化县维山乡三联洞村',0,0,9),(19,'0017','张晓芳',22,'湖南省娄底市新化县维山乡维山村',0,0,1),(20,'0018','宋明明',21,'湖南省娄底市新化县维山乡维山村',0,0,1);
/*!40000 ALTER TABLE `population_manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_manage`
--

DROP TABLE IF EXISTS `role_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_manage` (
  `role_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(12) DEFAULT NULL COMMENT '角色名称',
  `role_code` int(12) DEFAULT NULL COMMENT '角色编码',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_manage`
--

LOCK TABLES `role_manage` WRITE;
/*!40000 ALTER TABLE `role_manage` DISABLE KEYS */;
INSERT INTO `role_manage` VALUES (1,'管理员',1),(2,'普通人员',2);
/*!40000 ALTER TABLE `role_manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_manage`
--

DROP TABLE IF EXISTS `user_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_manage` (
  `user_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '村委人事编号',
  `user_name` varchar(12) DEFAULT NULL COMMENT '村委人事账号',
  `password` varchar(12) DEFAULT NULL COMMENT '村委人事密码',
  `gender` varchar(6) DEFAULT NULL COMMENT '村委性别',
  `user_phone` varchar(12) DEFAULT NULL COMMENT '村委人事电话',
  `nick_name` varchar(12) DEFAULT NULL COMMENT '村委人事姓名',
  `user_role_id` int(12) DEFAULT NULL COMMENT '村委人事拥有的角色id',
  `user_village_id` int(12) DEFAULT NULL COMMENT '村委人事所属村委id',
  `user_status` varchar(12) DEFAULT NULL COMMENT '村委人事状态',
  `user_post` varchar(12) DEFAULT NULL COMMENT '村委人事职务',
  `user_desc` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_manage`
--

LOCK TABLES `user_manage` WRITE;
/*!40000 ALTER TABLE `user_manage` DISABLE KEYS */;
INSERT INTO `user_manage` VALUES (1,'admin001','123456','男','13547856322','李强',1,100,'alive','乡长',NULL),(2,'admin002','123456','男','15630227456','张伟',2,1,'apply','村委','换行哈哈'),(3,'admin003','123456','女','15489623357','李军',2,2,'alive','村委','敬爱的党支部：在1999年我光荣的成为了中国共产党党员，在镇党委和xx村党支部的正确领导下和亲切的关怀下，使我逐步成长，更加感到党的温暖。在参加工作之际，我干对了，组织上支持我，干错了，组织上帮助我，党员同志们关心我。我深刻的理解党组织的关心和爱护，党员同志们的亲切关怀，是对我极大地鼓舞和鞭策。我只能说一声谢谢党组织，谢谢全体党员同志们。近几年，由于我年事以高，真所谓耳聋眼花，力不从心，我想辞去党员同志们交给我的委员会书记一职。希望大家能够理解我，支持我。'),(4,'admin004','123456','女','17896542301','张彩霞',2,3,'alive','村委','敬爱的党支部：在1999年我光荣的成为了中国共产党党员，在镇党委和xx村党支部的正确领导下和亲切的关怀下，使我逐步成长，更加感到党的温暖。在参加工作之际，我干对了，组织上支持我，干错了，组织上帮助我，党员同志们关心我。我深刻的理解党组织的关心和爱护，党员同志们的亲切关怀，是对我极大地鼓舞和鞭策。我只能说一声谢谢党组织，谢谢全体党员同志们。近几年，由于我年事以高，真所谓耳聋眼花，力不从心，我想辞去党员同志们交给我的委员会书记一职。希望大家能够理解我，支持我。'),(5,'admin005','123456','男','19563248201','张建国',2,4,'alive','村委',NULL),(6,'admin006','123456','男','15634288745','吴有志',2,5,'alive','村委',NULL),(7,'admin007','123456','男','15623847952','张远山',2,6,'alive','村委',NULL),(8,'admin008','123456','男','14752306599','江未眠',2,7,'alive','村委',NULL),(9,'admin009','123456','男','13658793369','刘涵山',2,8,'alive','村委',NULL),(10,'admin010','123456','男','15874620347','刘军',2,9,'alive','村委',NULL),(11,'admin011','123456','男','17856234025','肖建国',2,10,'alive','村委',NULL),(12,'admin012','123456','男','15963248523','孟伟',2,11,'alive','村委',NULL),(13,'admin013','123456','女','13548796520','赵伟民',2,12,'alive','村委',NULL),(16,'admin014','123456','女','14523588622','冯丽丽',2,13,'alive','村委',NULL),(19,'admin015','112333','男',NULL,'淡淡的',2,1,'leave','村委',NULL);
/*!40000 ALTER TABLE `user_manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `village_manage`
--

DROP TABLE IF EXISTS `village_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `village_manage` (
  `village_id` int(12) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `village_num` int(12) DEFAULT NULL COMMENT '村委编号',
  `village_name` varchar(12) DEFAULT NULL COMMENT '村委名称',
  `village_address` varchar(20) DEFAULT NULL COMMENT '村委地址',
  `village_leading` varchar(10) DEFAULT NULL COMMENT '村委负责人',
  `village_phone` varchar(20) DEFAULT NULL COMMENT '村委负责人电话',
  PRIMARY KEY (`village_id`),
  UNIQUE KEY `VILLAGE_NUM_INDEX_UNIQUE` (`village_num`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `village_manage`
--

LOCK TABLES `village_manage` WRITE;
/*!40000 ALTER TABLE `village_manage` DISABLE KEYS */;
INSERT INTO `village_manage` VALUES (1,1,'维山村','湖南省娄底市新化县维山乡维山村','张伟','15630227456'),(2,2,'双井村','湖南省娄底市新化县维山乡双井村','李军','15489623357'),(3,3,'林屋村','湖南省娄底市新化县维山乡林屋村','张彩霞','17896542301'),(4,4,'芦家桥村','湖南省娄底市新化县维山乡芦家桥村','张建国','19563248201'),(5,5,'水口村','湖南省娄底市新化县维山乡水口村','吴有志','15634288745'),(6,6,'石屋村','湖南省娄底市新化县维山乡石屋村','张远山','15623847952'),(7,7,'官庄村','湖南省娄底市新化县维山乡官庄村','江未眠','14752306599'),(8,8,'碧水村','湖南省娄底市新化县维山乡碧水村','刘涵山','13658793369'),(9,9,'三联洞村','湖南省娄底市新化县维山乡三联洞村','刘军','15874620347'),(10,10,'茶园村','湖南省娄底市新化县维山乡茶园村','肖建国','17856234025'),(11,11,'青树村','湖南省娄底市新化县维山乡青树村','孟伟','15963248523'),(12,12,'四都村','湖南省娄底市新化县维山乡四都村','赵伟民','13548796520'),(13,13,'黄古村','湖南省娄底市新化县维山乡黄古村','冯丽丽','13956423879');
/*!40000 ALTER TABLE `village_manage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-25 19:00:07
