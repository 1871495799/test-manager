/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : book_manager

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2022-03-20 15:56:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `end_time` datetime(6) DEFAULT NULL,
  `ret` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('14', '24', '2020-07-28 08:00:00.000000', '2020-07-29 08:00:00.000000', '4', '2020-07-29 08:00:00.000000', '1');
