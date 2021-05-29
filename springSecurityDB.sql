/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : backlog

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 22/08/2020 23:17:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `id` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES (1, 'v1');
INSERT INTO `role_info` VALUES (2, 'v2');
INSERT INTO `role_info` VALUES (3, 'v3');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `state` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'user1', '用户1', '123', 3);
INSERT INTO `user_info` VALUES (2, 'user2', '用户2', '123', 1);
INSERT INTO `user_info` VALUES (3, 'user3', '用户3', '123', 1);
INSERT INTO `user_info` VALUES (4, 'user4', '用户4', '123', 1);
INSERT INTO `user_info` VALUES (5, 'user5', '用户5', '123', 1);
INSERT INTO `user_info` VALUES (6, 'user6', '用户6', '123', 1);
INSERT INTO `user_info` VALUES (7, 'user7', '用户7', '123', 1);
INSERT INTO `user_info` VALUES (8, 'user8', '用户8', '123', 1);
INSERT INTO `user_info` VALUES (9, 'user9', '用户9', '123', 1);
INSERT INTO `user_info` VALUES (10, 'user10', '用户10', '123', 1);
INSERT INTO `user_info` VALUES (11, 'user11', '用户11', '123', 1);
INSERT INTO `user_info` VALUES (12, 'user12', '用户12', '123', 1);
INSERT INTO `user_info` VALUES (13, 'user13', '用户13', '123', 1);
INSERT INTO `user_info` VALUES (14, 'user14', '用户14', '123', 1);
INSERT INTO `user_info` VALUES (15, 'user15', '用户15', '123', 1);
INSERT INTO `user_info` VALUES (16, 'user16', '用户16', '123', 1);
INSERT INTO `user_info` VALUES (17, 'user17', '用户17', '123', 1);
INSERT INTO `user_info` VALUES (18, 'user18', '用户18', '123', 1);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL,
  `role_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 2);
INSERT INTO `user_role` VALUES (3, 3, 3);
INSERT INTO `user_role` VALUES (4, 4, 1);
INSERT INTO `user_role` VALUES (5, 5, 2);
INSERT INTO `user_role` VALUES (6, 6, 3);
INSERT INTO `user_role` VALUES (7, 7, 1);
INSERT INTO `user_role` VALUES (8, 8, 2);
INSERT INTO `user_role` VALUES (9, 9, 2);
INSERT INTO `user_role` VALUES (10, 10, 2);
INSERT INTO `user_role` VALUES (11, 11, 2);
INSERT INTO `user_role` VALUES (12, 12, 2);
INSERT INTO `user_role` VALUES (13, 13, 2);
INSERT INTO `user_role` VALUES (14, 14, 2);
INSERT INTO `user_role` VALUES (15, 15, 2);
INSERT INTO `user_role` VALUES (16, 16, 2);
INSERT INTO `user_role` VALUES (17, 17, 2);
INSERT INTO `user_role` VALUES (18, 18, 2);
INSERT INTO `user_role` VALUES (19, 1, 2);
INSERT INTO `user_role` VALUES (20, 2, 2);
INSERT INTO `user_role` VALUES (21, 3, 3);
INSERT INTO `user_role` VALUES (22, 4, 4);

SET FOREIGN_KEY_CHECKS = 1;
