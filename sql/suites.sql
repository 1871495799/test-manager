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

 Date: 27/03/2022 18:40:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for suites
-- ----------------------------
DROP TABLE IF EXISTS `suites`;
CREATE TABLE `suites`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '测试计划名称',
  `author` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '作者',
  `project` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目名',
  `create_time` datetime(6) DEFAULT NULL COMMENT '创建时间',
  `case_id` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '关联的用例',
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `update_time` datetime(6) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
