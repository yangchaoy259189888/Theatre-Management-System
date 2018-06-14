/*
Navicat MySQL Data Transfer

Source Server         : TTMS
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : movie_manage

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2018-06-12 16:04:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `emp_id` int(7) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(20) NOT NULL,
  `emp_password` varchar(16) NOT NULL,
  `emp_position` varchar(20) NOT NULL,
  `emp_tel_num` char(11) DEFAULT NULL,
  `emp_addr` varchar(50) DEFAULT NULL,
  `emp_email` varchar(50) DEFAULT NULL,
  `emp_age` tinyint(3) DEFAULT NULL,
  `emp_sex` char(255) DEFAULT '',
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4163152 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('4163142', '杨朝阳', '123456', '经理', '17792035609', '陕西省西安市高陵区', '17792035609@163.com', '21', '男');
INSERT INTO `employee` VALUES ('4163151', '李杰', '123456', '售票员', null, null, null, null, '');

-- ----------------------------
-- Table structure for `play`
-- ----------------------------
DROP TABLE IF EXISTS `play`;
CREATE TABLE `play` (
  `play_id` int(11) NOT NULL AUTO_INCREMENT,
  `play_type` varchar(11) DEFAULT NULL,
  `play_lang` varchar(11) DEFAULT NULL,
  `play_name` varchar(100) DEFAULT NULL,
  `play_introduction` varchar(400) DEFAULT NULL,
  `play_length` char(4) DEFAULT NULL,
  `play_ticket_price` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`play_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of play
-- ----------------------------
INSERT INTO `play` VALUES ('1', '爱情片', '国语', '21克拉', '迪丽热巴主演', '121', '28.5');
INSERT INTO `play` VALUES ('2', '科幻片', '英语', '复仇者联盟3', '漫威的电影', '124', '29.9');
INSERT INTO `play` VALUES ('3', '惊悚片', '英语', '怪形', '会易容的异形', '89', '21.9');

-- ----------------------------
-- Table structure for `schedule`
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `studio_id` char(11) DEFAULT NULL,
  `play_name` char(11) DEFAULT NULL,
  `play_showTime` char(11) DEFAULT NULL,
  `play_time` char(11) DEFAULT NULL,
  `play_ticketPrice` char(11) DEFAULT NULL,
  PRIMARY KEY (`schedule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('1', '1', '21克拉', '2018-3-14', '121', '28.5');
INSERT INTO `schedule` VALUES ('2', '2', '复仇者联盟3', '2018-5-11', '124', '29.9');
INSERT INTO `schedule` VALUES ('3', '1', '刘耀武是瓜皮', '2018-6-11', '212', '23.5');

-- ----------------------------
-- Table structure for `studio`
-- ----------------------------
DROP TABLE IF EXISTS `studio`;
CREATE TABLE `studio` (
  `studio_id` int(11) NOT NULL AUTO_INCREMENT,
  `studio_name` varchar(50) NOT NULL,
  `studio_row_count` char(11) NOT NULL,
  `studio_col_count` char(11) NOT NULL,
  `studio_introduction` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`studio_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studio
-- ----------------------------
INSERT INTO `studio` VALUES ('1', '一号演出厅', '10', '8', '一号演出厅的简介');
INSERT INTO `studio` VALUES ('2', '二号演出厅', '11', '13', '二号演出厅的简介！！！');
