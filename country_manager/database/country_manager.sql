/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.40 : Database - country_manager
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`country_manager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `country_manager`;

/*Table structure for table `activity_manage` */

DROP TABLE IF EXISTS `activity_manage`;

CREATE TABLE `activity_manage` (
  `activity_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `activity_type` varchar(12) DEFAULT NULL COMMENT '活动类型',
  `activity_content` varchar(20) DEFAULT NULL COMMENT '活动内容',
  `activity_start_time` date DEFAULT NULL COMMENT '活动开始时间',
  `activity_end_time` date DEFAULT NULL COMMENT '活动结束时间',
  `activity_organ_id` int(12) DEFAULT NULL COMMENT '活动发起机构id',
  `activity_person` varchar(12) DEFAULT NULL COMMENT '活动针对人群',
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `activity_manage` */

insert  into `activity_manage`(`activity_id`,`activity_type`,`activity_content`,`activity_start_time`,`activity_end_time`,`activity_organ_id`,`activity_person`) values (1,'医','检查身体','2021-01-31','2021-02-26',1,'群众'),(2,'农','芬迪','2021-03-02','2021-03-02',1,'群众'),(7,'搜索','大队','2021-02-28','2021-03-28',3,'大队'),(8,'生','解决接','2021-03-02','2021-03-16',1,'解决接');

/*Table structure for table `file_manage` */

DROP TABLE IF EXISTS `file_manage`;

CREATE TABLE `file_manage` (
  `file_id` int(12) NOT NULL COMMENT '文件id',
  `file_name` varchar(120) DEFAULT NULL COMMENT '文件名称',
  `file_route` varchar(120) DEFAULT NULL COMMENT '文件上传路径',
  `file_type` varchar(6) DEFAULT NULL COMMENT '文件类型',
  `file_brief` varchar(255) DEFAULT NULL COMMENT '文件简介',
  `file_up_time` date DEFAULT NULL COMMENT '文件上传时间',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `file_manage` */

insert  into `file_manage`(`file_id`,`file_name`,`file_route`,`file_type`,`file_brief`,`file_up_time`) values (0,'a.jpg','D:\\tangyuan\\a.jpg','.jpg',NULL,NULL),(1,'哈','111','.doc','加油','2021-03-09');

/*Table structure for table `helper_manage` */

DROP TABLE IF EXISTS `helper_manage`;

CREATE TABLE `helper_manage` (
  `helper_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '帮扶id',
  `helper_population_id` varchar(36) DEFAULT NULL COMMENT '帮扶对象id',
  `helper_type` varchar(10) DEFAULT NULL COMMENT '帮扶类型',
  `helper_time` date DEFAULT NULL COMMENT '帮扶时间',
  `helper_executed` varchar(12) DEFAULT NULL COMMENT '帮扶的执行者',
  `helper_village_id` int(12) DEFAULT NULL COMMENT '帮扶对象所属村委id',
  `helper_status` int(4) DEFAULT NULL COMMENT '帮扶对象所处状态 0 未帮扶  1 帮扶中  2  帮扶结束',
  PRIMARY KEY (`helper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `helper_manage` */

insert  into `helper_manage`(`helper_id`,`helper_population_id`,`helper_type`,`helper_time`,`helper_executed`,`helper_village_id`,`helper_status`) values (1,'0001','1','2021-03-10','hah',1,1),(2,'0002','1','2021-03-10','大队',1,1),(3,'0003','dd','2021-03-09','ddddd',1,1),(4,'0001','说说','2021-03-16','打的断电',1,0),(5,'0001','说说','2021-03-16','打的断电',1,2),(6,'0001','说说','2021-03-16','打的断电',1,2);

/*Table structure for table `house_manage` */

DROP TABLE IF EXISTS `house_manage`;

CREATE TABLE `house_manage` (
  `house_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '宅基地id',
  `house_address` varchar(20) DEFAULT NULL COMMENT '宅基地地址',
  `house_population_id` int(12) DEFAULT NULL COMMENT '宅基地拥者id',
  `house_apply_time` date DEFAULT NULL COMMENT '宅基地申请时间',
  `house_status` int(11) DEFAULT NULL COMMENT '宅基地状态（0拥有1申请中2暂无申请）',
  `house_area` int(11) DEFAULT NULL COMMENT '宅基地面积',
  PRIMARY KEY (`house_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `house_manage` */

insert  into `house_manage`(`house_id`,`house_address`,`house_population_id`,`house_apply_time`,`house_status`,`house_area`) values (1,'上海',1,'2021-02-02',0,120);

/*Table structure for table `member_manage` */

DROP TABLE IF EXISTS `member_manage`;

CREATE TABLE `member_manage` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `member_id` int(12) DEFAULT NULL COMMENT '党员编号',
  `member_name` varchar(12) DEFAULT NULL COMMENT '党员名字',
  `member_status` int(6) DEFAULT NULL COMMENT '党员状态（0在档1，离党）',
  `member_identity` int(6) DEFAULT NULL COMMENT '人员身份（0党员 1积极分子）',
  `member_start_time` date DEFAULT NULL COMMENT '入党时间',
  `member_end_time` date DEFAULT NULL COMMENT '脱党时间',
  `member_active_time` date DEFAULT NULL COMMENT '成为积极积极分子时间',
  `member_party_id` int(6) DEFAULT NULL COMMENT '党员所在组织',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `member_manage` */

insert  into `member_manage`(`id`,`member_id`,`member_name`,`member_status`,`member_identity`,`member_start_time`,`member_end_time`,`member_active_time`,`member_party_id`) values (1,1,'岐神',0,0,'2021-02-01','2021-03-18','2021-02-01',1);

/*Table structure for table `news_manage` */

DROP TABLE IF EXISTS `news_manage`;

CREATE TABLE `news_manage` (
  `new_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '通知id',
  `new_title` varchar(12) DEFAULT NULL COMMENT '通知标题',
  `new_content` varchar(255) DEFAULT NULL COMMENT '通知内容',
  `new_time` date DEFAULT NULL COMMENT '通知时间',
  `new_person` varchar(12) DEFAULT NULL COMMENT '通知人',
  `new_priority` int(2) DEFAULT NULL COMMENT '通知是否置顶（0不置顶1置顶）',
  PRIMARY KEY (`new_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `news_manage` */

insert  into `news_manage`(`new_id`,`new_title`,`new_content`,`new_time`,`new_person`,`new_priority`) values (1,'哈哈','工作加油，年薪50万','2021-02-02','党员',1);

/*Table structure for table `organ_manage` */

DROP TABLE IF EXISTS `organ_manage`;

CREATE TABLE `organ_manage` (
  `organ_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '机构id',
  `organ_name` varchar(12) DEFAULT NULL COMMENT '机构名称',
  `organ_duty` varchar(15) DEFAULT NULL COMMENT '机构职责',
  `organ_leader` varchar(12) DEFAULT NULL COMMENT '机构负责人',
  `organ_phone` varchar(15) DEFAULT NULL COMMENT '办公电话',
  `organ_leader_phone` varchar(15) DEFAULT NULL COMMENT '机构负责人电话',
  `organ_time` date DEFAULT NULL COMMENT '机构成立时间',
  `organ_village_id` int(12) DEFAULT NULL COMMENT '所属村委id',
  PRIMARY KEY (`organ_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `organ_manage` */

insert  into `organ_manage`(`organ_id`,`organ_name`,`organ_duty`,`organ_leader`,`organ_phone`,`organ_leader_phone`,`organ_time`,`organ_village_id`) values (1,'卫生所','管理卫生','张三','12222','22222','2021-02-02',1),(2,'卫生所','管理卫生','李四','12223','33333','2021-02-01',1),(3,'财务所','管理财务','万古','122233','43342','2021-02-23',2),(4,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `party_manage` */

DROP TABLE IF EXISTS `party_manage`;

CREATE TABLE `party_manage` (
  `party_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '党组织编号',
  `party_name` varchar(12) DEFAULT NULL COMMENT '党组织名称',
  `parent_party` int(12) DEFAULT NULL COMMENT '党组织所属组织',
  `party_start_time` date DEFAULT NULL COMMENT '党组成立时间',
  PRIMARY KEY (`party_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `party_manage` */

insert  into `party_manage`(`party_id`,`party_name`,`parent_party`,`party_start_time`) values (1,'岐岐',2,'2021-02-02'),(2,'山支',NULL,'2021-02-02');

/*Table structure for table `population_manage` */

DROP TABLE IF EXISTS `population_manage`;

CREATE TABLE `population_manage` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '表id',
  `population_id` varchar(36) DEFAULT NULL COMMENT '人口编号',
  `population_name` varchar(12) DEFAULT NULL COMMENT '人口姓名',
  `population_age` int(12) DEFAULT NULL COMMENT '人口年龄',
  `population_address` varchar(12) DEFAULT NULL COMMENT '人口所在地址',
  `population_type` int(6) DEFAULT NULL COMMENT '人口类型(0属于本地1属于外地)',
  `population_local_type` int(6) DEFAULT NULL COMMENT '本地人口类型（0是常住1是外出）',
  `population_village_id` int(12) DEFAULT NULL COMMENT '人口所属村委',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `population_manage` */

insert  into `population_manage`(`id`,`population_id`,`population_name`,`population_age`,`population_address`,`population_type`,`population_local_type`,`population_village_id`) values (1,'0001','张三',12,'上海',0,1,1),(2,'0002','lsii',23,'ddd',0,1,1),(3,'0003','dddd',23,'ddddd',1,1,1);

/*Table structure for table `role_manage` */

DROP TABLE IF EXISTS `role_manage`;

CREATE TABLE `role_manage` (
  `role_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(12) DEFAULT NULL COMMENT '角色名称',
  `role_code` int(12) DEFAULT NULL COMMENT '角色编码',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `role_manage` */

insert  into `role_manage`(`role_id`,`role_name`,`role_code`) values (1,'添加',1),(2,'修改',2);

/*Table structure for table `user_manage` */

DROP TABLE IF EXISTS `user_manage`;

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
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user_manage` */

insert  into `user_manage`(`user_id`,`user_name`,`password`,`gender`,`user_phone`,`nick_name`,`user_role_id`,`user_village_id`,`user_status`,`user_post`) values (1,'二万五','123','女','1222','星星',1,1,'0','账房'),(2,'多对对',NULL,'女','233','大队',2,5,'alive','多对对');

/*Table structure for table `village_manage` */

DROP TABLE IF EXISTS `village_manage`;

CREATE TABLE `village_manage` (
  `village_id` int(12) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `village_num` int(12) DEFAULT NULL COMMENT '村委编号',
  `village_name` varchar(12) DEFAULT NULL COMMENT '村委名称',
  `village_address` varchar(12) DEFAULT NULL COMMENT '村委地址',
  `village_leading` varchar(10) DEFAULT NULL COMMENT '村委负责人',
  `village_phone` varchar(20) DEFAULT NULL COMMENT '村委负责人电话',
  PRIMARY KEY (`village_id`),
  UNIQUE KEY `VILLAGE_NUM_INDEX_UNIQUE` (`village_num`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `village_manage` */

insert  into `village_manage`(`village_id`,`village_num`,`village_name`,`village_address`,`village_leading`,`village_phone`) values (1,12,'大队','大队','多对对','1233'),(2,1,'怪眼','中国','呵呵呵','111'),(3,2,'测试','韩国','哈哈哈','222'),(4,3,'岐岐','山支大山','美岐','111111'),(5,4,'没事','山支大队','汤圆','11111'),(6,5,'哈哈哈','哈哈哈','也一样','7777'),(7,6,'哈哈哈','哈哈哈','也一样','7777'),(8,7,'哈哈哈','哈哈哈','也一样','7777'),(9,8,'哈哈哈','哈哈哈','也一样','7777'),(10,9,'哈哈哈','哈哈哈','也一样','7777'),(11,10,'哈哈哈','哈哈哈','也一样','7777'),(12,11,NULL,NULL,NULL,NULL),(13,33,'ddd','ddd','ddd','111');
