SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
drop database if exists `demo`;
CREATE DATABASE `demo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci; 
use demo;
-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `status` int NULL DEFAULT NULL COMMENT '状态',
  `time` datetime NULL DEFAULT NULL COMMENT '实践',
  `pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, '水逆的一天', '深林之王', 1, '2022-07-31 14:07:52', '图片', 'http://www.desktx.com/d/file/wallpaper/scenery/20170209/c2accfe637f86fb6f11949cb8651a09b.jpg');
INSERT INTO `account` VALUES (2, '美女', '美女', 1, '2022-07-31 14:07:52', '美女', 'https://weibo.com/u/2803730820');
INSERT INTO `account` VALUES (3, '技术分享', NULL, NULL, '2022-07-31 14:10:22', '技术', 'https://www.csdn.net/');

SET FOREIGN_KEY_CHECKS = 1;
