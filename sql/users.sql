/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : book_manager

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2022-03-20 15:56:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `birthday` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `identity` int(11) DEFAULT NULL,
  `is_admin` int(11) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '上海', 'string', '2020-07-14 19:01:33.863000', 'stu@163.com', '0', '1', '学生', '123', '2', '13576145550', 'stu');
INSERT INTO `users` VALUES ('2', '上海', 'string', '2020-07-14 19:01:33.863000', 'tea@163.com', '1', '1', '教师', '123', '0', 'string', 'tea');
INSERT INTO `users` VALUES ('3', '北京', 'a.jpg', '2020-07-14 19:01:33.863000', 'other@163.com', '2', '1', '社会人士', '123', '3', '15078826452', 'other');
INSERT INTO `users` VALUES ('4', '北京', 'b.jpa', '2020-07-16 16:06:43.000000', 'admin@163.com', '3', '0', '管理员', '123', '4', '17679088880', 'admin');
INSERT INTO `users` VALUES ('8', '北京朝阳', 'b.jpa', '1998-02-12 08:00:00.000000', 'guest01@163.com', '3', '1', '游客1', '123', '10', '13576008880', 'guest01');
INSERT INTO `users` VALUES ('9', '北京', 'b.jpa', '1982-01-01 08:00:00.000000', 'guest02@163.com', '3', '1', '游客2', '123', '10', '1768220000', 'guest02');
