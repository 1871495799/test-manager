/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : test_manager

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 27/03/2022 18:39:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `birthday` datetime(6) DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `identity` int(11) DEFAULT NULL,
  `is_admin` int(11) DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '上海', 'string', '2020-07-14 19:01:33.863000', 'stu@163.com', 0, 1, '普通测试', '123', '13576145550', 'test');
INSERT INTO `users` VALUES (2, '上海', 'string', '2020-07-14 19:01:33.863000', 'tea@163.com', 1, 1, 'leader', '123', 'string', 'leader');
INSERT INTO `users` VALUES (3, '北京', 'a.jpg', '2020-07-14 19:01:33.863000', 'other@163.com', 2, 1, '经理', '123', '15078826452', 'manager');
INSERT INTO `users` VALUES (4, '北京', 'b.jpa', '2020-07-16 16:06:43.000000', 'admin@163.com', 3, 0, '管理员', '123', '17679088880', 'admin');
INSERT INTO `users` VALUES (8, '北京朝阳', 'b.jpa', '1998-02-12 08:00:00.000000', 'guest01@163.com', 3, 1, '游客1', '123', '13576008880', 'guest01');
INSERT INTO `users` VALUES (9, '北京', 'b.jpa', '1982-01-01 08:00:00.000000', 'guest02@163.com', 3, 1, '游客2', '123', '1768220000', 'guest02');

SET FOREIGN_KEY_CHECKS = 1;
