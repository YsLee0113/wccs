/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50727 (5.7.27)
 Source Host           : localhost:3306
 Source Schema         : abc

 Target Server Type    : MySQL
 Target Server Version : 50727 (5.7.27)
 File Encoding         : 65001

 Date: 23/06/2024 12:09:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admininfo
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo`  (
  `adminid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `adminname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户用户名',
  `adminpwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户角色',
  `headimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `admincreatetime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `islock` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户状态',
  PRIMARY KEY (`adminid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of admininfo
-- ----------------------------
INSERT INTO `admininfo` VALUES (1, 'admin', '123456', '系统管理员', 'http://www.javalm.cn/file/head2.png', '2024-02-27 15:30:24', '可用');
INSERT INTO `admininfo` VALUES (2, 'admin2', '123456', '系统管理员', 'http://www.javalm.cn/file/head3.png', '2024-02-27 15:30:24', '可用');
INSERT INTO `admininfo` VALUES (4, 'admin3', '123456', '系统管理员', 'http://www.javalm.cn/file/head4.png', '2024-02-27 15:30:24', '禁用');

-- ----------------------------
-- Table structure for carousel
-- ----------------------------
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `picurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '轮播图' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of carousel
-- ----------------------------
INSERT INTO `carousel` VALUES (1, '轮播图01', 'http://img.netbian.com/file/2021/0310/f90a3491340393e924ca2d9ee4f85d2e.jpg');
INSERT INTO `carousel` VALUES (2, '轮播图02', 'http://img.netbian.com/file/2021/0314/90d1c7657a694816e344912feddf040f.jpg');
INSERT INTO `carousel` VALUES (3, '轮播图02', 'https://img2.a0bi.com/upload/ttq/20150713/1436756859971.jpg');

-- ----------------------------
-- Table structure for datainfo
-- ----------------------------
DROP TABLE IF EXISTS `datainfo`;
CREATE TABLE `datainfo`  (
  `dataid` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `dataname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `datacontent` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `dataurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `datauser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户',
  `dataintro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `dataremarker` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `datatype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类',
  `dataaddtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`dataid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '视频信息' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of datainfo
-- ----------------------------
INSERT INTO `datainfo` VALUES (1, 'java基础学习-1', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/2.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/5fd19237092ae17b05400304.png', '147', '计算机-Java基础', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (7, 'java基础学习-2', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/3.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/6059a92e09bd086a05400304.png', '2', '计算机-Java基础', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (8, 'java基础学习-3', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/4.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/603627fd09f5c40f05400304.png', '169', '计算机-Java基础', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (9, 'java基础学习-4', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/2.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/5fd19237092ae17b05400304.png', '39', '计算机-Java基础', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (10, 'java基础学习-5', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/2.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/5fd19237092ae17b05400304.png', '86', '计算机-Java基础', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (11, 'java基础学习-6', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/2.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/6059a92e09bd086a05400304.png', '112', '计算机-Java基础', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (12, 'java进阶学习-1', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/2.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/5fd19237092ae17b05400304.png', '103', '计算机-Java进阶', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (13, 'java进阶学习-2', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/3.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/6059a92e09bd086a05400304.png', '181', '计算机-Java进阶', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (14, 'java进阶学习-3', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/4.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/603627fd09f5c40f05400304.png', '194', '计算机-Java进阶', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (15, 'java进阶学习-4', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/2.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/5fd19237092ae17b05400304.png', '26', '计算机-Java进阶', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (16, 'java进阶学习-5', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/2.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/5fd19237092ae17b05400304.png', '150', '计算机-Java进阶', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (17, 'java进阶学习-6', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/2.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/6059a92e09bd086a05400304.png', '70', '计算机-Java进阶', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (18, 'java高级学习-11', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/2.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/5fd19237092ae17b05400304.png', '101', '计算机-Java高级', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (19, 'java高级学习-222', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/3.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/6059a92e09bd086a05400304.png', '95', '计算机-Java高级', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (20, 'java高级学习-33', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/4.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/603627fd09f5c40f05400304.png', '171', '计算机-Java高级', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (21, 'java高级学习-44', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/2.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/5fd19237092ae17b05400304.png', '170', '计算机-Java高级', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (22, 'java高级学习-555', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/2.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/5fd19237092ae17b05400304.png', '135', '计算机-Java高级', '2024-02-27 15:30:24');
INSERT INTO `datainfo` VALUES (23, 'java高级学习-666', 'Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。  本教程通过简单的实例将让大家更好的了解 Java 编程语言。  移动操作系统 Android 大部分的代码采用 Java 编程语言编程。', 'http://www.javalm.cn/file/2.mp4', '李煜松', 'http://localhost:8088/study_system/uploads/6059a92e09bd086a05400304.png', '168', '计算机-Java高级', '2024-02-27 15:30:24');

-- ----------------------------
-- Table structure for def
-- ----------------------------
DROP TABLE IF EXISTS `def`;
CREATE TABLE `def`  (
  `A` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `V` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `C` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of def
-- ----------------------------
INSERT INTO `def` VALUES ('1', '2', '3');
INSERT INTO `def` VALUES ('4', '5', '6');

-- ----------------------------
-- Table structure for examinfo
-- ----------------------------
DROP TABLE IF EXISTS `examinfo`;
CREATE TABLE `examinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目',
  `fenshu` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分数',
  `xuanxiang` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '答案',
  `tid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属id',
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `addtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 160 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '题目' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of examinfo
-- ----------------------------
INSERT INTO `examinfo` VALUES (1, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '1', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (2, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '1', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (3, '您觉得这个系统还需要完善那些地方？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.精美酷炫', 'C', '1', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (4, '这个网站的给你的用户体验如何？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.简洁大方2', 'D', '1', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (5, '你了解几家和这个网站功能类似网站？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.好看', 'A', '1', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (6, '你更多时间在什么平台上使用该网站？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.简洁大方', 'C', '1', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (7, '您认为现在的这个网站有什么问题？()', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.好看', 'A', '1', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (8, '您认为目前这个系统市场存在的最大隐患是什么 ( )', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.好看', 'C', '1', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (9, '请问您一般通过什么途径了解到这个系统的？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.好看', 'D', '1', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (10, '您通常会在什么情况下使用这个系统?1111', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.好看', 'A', '1', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (11, '您通常会在什么情况下使用这个系统?2222', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.好看', 'E', '1', '', '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (12, '您通常会在什么情况下使用这个系统?333', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.好看', 'E', '1', '', '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (13, '您通常会在什么情况下使用这个系统?4444', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.好看', 'E', '1', '', '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (14, '您通常会在什么情况下使用这个系统?555', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.好看', 'E', '1', '', '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (15, '您通常会在什么情况下使用这个系统?6666', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.简洁大方', 'E', '1', '', '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (16, '您通常会在什么情况下使用这个系统?7777', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.简洁大方', 'E', '1', '', '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (17, '您通常会在什么情况下使用这个系统?8888', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.好看', 'E', '1', '', '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (18, '您通常会在什么情况下使用这个系统?9999', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.简洁大方', 'E', '1', '', '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (19, '您通常会在什么情况下使用这个系统?aaa', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.简洁大方', 'E', '1', '', '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (20, '您通常会在什么情况下使用这个系统?bbb', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.简洁大方', 'E', '1', '', '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (21, '您通常会在什么情况下使用这个系统?ccc', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.简洁大方', 'E', '1', '', '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (22, '您通常会在什么情况下使用这个系统?ddd', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.简洁大方', 'E', '1', '', '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (23, '测试一下考试题目，请选择java是什么语言', '5', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.简洁大方', 'A', '1', '无', '23424');
INSERT INTO `examinfo` VALUES (24, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (25, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (26, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (27, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (28, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (29, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (30, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (31, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (32, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (33, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (34, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (35, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (36, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (37, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (38, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (39, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (40, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (41, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (42, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (43, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (44, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (45, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (46, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (47, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (48, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (49, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (50, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (51, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (52, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (53, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (54, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (55, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '2', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (56, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (57, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (58, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (59, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (60, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (61, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (62, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (63, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (64, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (65, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (66, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (67, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (68, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (69, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (70, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (71, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (72, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (73, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (74, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (75, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '3', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (76, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (77, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (78, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (79, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (80, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (81, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (82, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (83, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (84, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (85, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (86, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (87, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (88, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (89, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (90, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (91, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (92, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (93, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (94, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (95, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (96, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (97, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (98, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (99, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (100, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (101, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (102, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (103, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (104, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (105, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '4', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (106, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (107, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (108, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (109, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (110, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (111, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (112, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (113, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (114, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (115, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (116, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (117, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (118, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (119, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (120, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (121, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (122, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (123, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (124, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (125, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (126, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (127, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (128, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (129, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (130, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (131, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (132, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (133, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (134, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (135, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '5', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (136, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (137, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (138, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (139, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (140, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (141, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (142, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (143, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (144, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (145, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (146, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (147, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (148, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (149, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (150, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (151, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (152, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (153, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (154, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (155, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (156, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (157, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (158, '你选择此种类型网站优先考虑？（）', '10', 'A.好看##B.美观##C.新颖##D.酷炫', 'A', '6', NULL, '2024-02-27 15:30:24');
INSERT INTO `examinfo` VALUES (159, '这个系统你觉得最吸引你的地方是哪里？（）', '10', 'A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.优雅', 'B', '6', NULL, '2024-02-27 15:30:24');

-- ----------------------------
-- Table structure for filesinfo
-- ----------------------------
DROP TABLE IF EXISTS `filesinfo`;
CREATE TABLE `filesinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `picurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '附件文件' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of filesinfo
-- ----------------------------
INSERT INTO `filesinfo` VALUES (1, 'java学习jdk安装', 'http://localhost:8088/study_system/uploads/1713342996600_8.doc', 'java学习jdk安装，使用教程');
INSERT INTO `filesinfo` VALUES (2, 'MySQL基本增删改查学习', 'http://localhost:8088/study_system/uploads/1713343021674_3.doc', 'MySQL基本增删改查学习教程');

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework`  (
  `swid` int(11) NOT NULL AUTO_INCREMENT COMMENT '作业编号',
  `swname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作业名称',
  `swcontent` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '作业内容',
  `swscore` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作业分数',
  `swintro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作业备注',
  `swuser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提交用户',
  `swtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提交时间',
  PRIMARY KEY (`swid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '作业信息' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of homework
-- ----------------------------
INSERT INTO `homework` VALUES (1, '学会搭建java环境', '<p>一、学习前的准备工作</p><p><br></p><p><br></p><p><br></p><p>java语言一般用于大型的服务器程序开发，所有有必要了解如下内容：Unix开发环境Unix系统原理、Unix开发环境、Unix常用命令。熟练掌握Unix常用命令；熟练构建下的Java开发环境。</p><p><br></p><p><br></p><p><br></p><p>二、Java语言基础的学习阶段学习</p><p><br></p><p><br></p><p><br></p><p>任何一门语言都要打好基础，曾经学过高级程序语言（C，C++等）来说，java语言基础有自己的特点，但是基本规律都是相通的，如：算法基础、常用数据结构、企业编程规范。掌握常见的数据结构和实用算法；培养良好的企业级编程习惯。</p><p><br></p><p><br></p><p><br></p><p>三、面向对象语言的共性</p><p><br></p><p><br></p><p><br></p><p>Java面向对象面向对象特性：封装、继承、多态等。掌握面向对象的基本原则以及在编程实践中的意义；掌握Java面向对象编程基本实现原理。</p><p><br></p>', '88', '非常不错', 'test', '2024-02-27 15:30:24');
INSERT INTO `homework` VALUES (11, '学会搭建java环境', '3534535', NULL, '34535354435', 'test', '2024-04-17 15:13:39');
INSERT INTO `homework` VALUES (12, '学会搭建java环境8888', '686786867868', NULL, '6786867867868', 'test', '2024-04-17 15:35:02');

-- ----------------------------
-- Table structure for msginfo
-- ----------------------------
DROP TABLE IF EXISTS `msginfo`;
CREATE TABLE `msginfo`  (
  `msgid` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `msguser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论用户',
  `msgcontent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `tid` int(11) NULL DEFAULT NULL COMMENT '评论音乐',
  `msgaddtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`msgid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论信息' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of msginfo
-- ----------------------------
INSERT INTO `msginfo` VALUES (3, 'test', '非常不错，经典值得推荐', 1, '2024-02-27 15:30:24');
INSERT INTO `msginfo` VALUES (4, 'test', '们静静聆听这份美好的视听享受，人生别计较太多，也许没有结果是最好的结局。', 1, '2024-02-27 15:30:24');
INSERT INTO `msginfo` VALUES (5, 'test', '我来测试评论', 1, '2024-02-27 15:30:24');
INSERT INTO `msginfo` VALUES (12, 'test', '维吾尔温热设计费都开始剪发卡23424', 1, '2024-04-17 15:34:32');
INSERT INTO `msginfo` VALUES (13, 'test', '3534543534', 1, '2024-04-17 15:34:38');

-- ----------------------------
-- Table structure for noticeinfo
-- ----------------------------
DROP TABLE IF EXISTS `noticeinfo`;
CREATE TABLE `noticeinfo`  (
  `noticeid` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告编号',
  `noticetitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告标题',
  `noticecontent` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告内容',
  `noticeaddtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布时间',
  `noticeremarker` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告备注',
  PRIMARY KEY (`noticeid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公告信息' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of noticeinfo
-- ----------------------------
INSERT INTO `noticeinfo` VALUES (1, '关于调整人工客服服务时间的公告', '尊敬的开金中心用户：  从2021年3月15日起，开金中心4006216021服务热线及在线客服的人工服务时间调整为法定工作日周一至周五的9:00至22:00。  在客服非人工服务时间，您也可以给我们留言，我们将在下一个工作日给您回复，留言操作方式：  1、开金中心官网-登录后点击在线客服，在服务时间提示点击“确定”后，系统会自动跳转中留言页面。  2、开金中心APP-登陆后依次点击【我的】-【在线客服】，在服务时间提示点击“确定”后，在点击“留言”。  3、4006216021：在提示音播报完毕后，按1号键。', '2024-02-27 15:30:24', '无');
INSERT INTO `noticeinfo` VALUES (2, '关于恢复客服电话和在线客服原人工服务时间的公告', '当前疫情防控形势趋于稳定，为了给客户提供更优质的服务，我司决定自2020年7月6日起将 客服电话（95105828、020-83936999）和在线客服人工服务时间从周一至周五8:30-17:00恢 复至周一至周五8:30-21:00；周六日上午8:30-12:00，下午13:30-17:00（节假日除外）。', '2024-02-27 15:30:24', '');

-- ----------------------------
-- Table structure for scoreinfo
-- ----------------------------
DROP TABLE IF EXISTS `scoreinfo`;
CREATE TABLE `scoreinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '结果',
  `score` int(11) NULL DEFAULT NULL COMMENT '分数',
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `createtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '结果' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of scoreinfo
-- ----------------------------
INSERT INTO `scoreinfo` VALUES (3, 'test', '12===E###19===E###20===E###14===E###9===E###5===D###4===D###1===E###2===D###13===E', 60, NULL, '2024-02-27 15:30:24');
INSERT INTO `scoreinfo` VALUES (4, 'test', '4===D###19===E###5===D###1===E###16===E###12===E###20===E###9===E###8===D###3===D', 50, NULL, '2024-02-27 15:30:24');
INSERT INTO `scoreinfo` VALUES (5, 'test', '7===D###5===C###11===E###15===E###21===E###12===E###18===E###2===E###20===E###13===E', 70, NULL, '2024-04-17 15:28:05');
INSERT INTO `scoreinfo` VALUES (6, 'test', '1===D###19===D###9===D###5===E###18===E###22===E###12===E###6===E###17===E###15===E', 60, NULL, '2024-04-17 15:35:55');
INSERT INTO `scoreinfo` VALUES (7, 'test', '16===E###7===D###19===E###10===D###4===E###17===E###12===D###13===D###1===D###2===E', 30, NULL, '2024-04-17 16:43:36');

-- ----------------------------
-- Table structure for sortinfo
-- ----------------------------
DROP TABLE IF EXISTS `sortinfo`;
CREATE TABLE `sortinfo`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类编号',
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `scontent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类内容',
  `sremarker` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类备注',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分类信息' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sortinfo
-- ----------------------------
INSERT INTO `sortinfo` VALUES (1, '计算机-Java基础', 'Java是一种简单的，面向对象的，分布式的，解释型的，健壮安全的，结构中立的，可移植的，性能优异、多线程的动态语言。\r\n\r\nJava语言使用国际字符集（Unicode）。Unicode字符集定义了一套国际标准字符集。通常的ASCII码是8位的，而Unicode字符集中的每个字符占16位，即2个字节。', '计算机类');
INSERT INTO `sortinfo` VALUES (2, '计算机-Java进阶', '编程学习-java学习-java进阶', '计算机类');
INSERT INTO `sortinfo` VALUES (3, '计算机-Java高级', '编程学习-java学习-web基础', '计算机类');
INSERT INTO `sortinfo` VALUES (4, '理工-分类01', '分类简单介绍', '理工类');
INSERT INTO `sortinfo` VALUES (5, '理工-分类02', '分类简单介绍', '理工类');
INSERT INTO `sortinfo` VALUES (6, '理工-分类013', '分类简单介绍', '理工类');
INSERT INTO `sortinfo` VALUES (7, '音乐-古典音乐', '分类简单介绍', '音乐类');
INSERT INTO `sortinfo` VALUES (8, '文学-现代文分类', '分类简单介绍', '文学类');

-- ----------------------------
-- Table structure for studyinfo
-- ----------------------------
DROP TABLE IF EXISTS `studyinfo`;
CREATE TABLE `studyinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `tid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程编号',
  `tname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `addtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学习时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学习记录' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of studyinfo
-- ----------------------------
INSERT INTO `studyinfo` VALUES (1, '李煜松', '1', 'java基础学习-1', '2024-02-27 15:30:24');
INSERT INTO `studyinfo` VALUES (2, '张煜松', '1', 'java基础学习-1', '2024-02-27 15:30:24');
INSERT INTO `studyinfo` VALUES (3, '王煜松', '1', 'java基础学习-1', '2024-02-27 15:30:24');
INSERT INTO `studyinfo` VALUES (4, '赵煜松', '1', 'java基础学习-1', '2024-02-27 15:30:24');
INSERT INTO `studyinfo` VALUES (5, '孙煜松', '1', 'java基础学习-1', '2024-02-27 15:30:24');
INSERT INTO `studyinfo` VALUES (6, '吕一凡', '1', 'java基础学习-1', '2024-02-27 15:30:24');
INSERT INTO `studyinfo` VALUES (7, '李一凡', '1', 'java基础学习-1', '2024-02-27 15:30:24');
INSERT INTO `studyinfo` VALUES (8, '王一凡', '1', 'java基础学习-1', '2024-02-27 15:30:24');
INSERT INTO `studyinfo` VALUES (9, '李伟', '1', 'java基础学习-1', '2024-02-27 15:30:24');
INSERT INTO `studyinfo` VALUES (10, '王伟', '1', 'java基础学习-1', '2024-02-27 15:30:24');
INSERT INTO `studyinfo` VALUES (11, '张伟', '2', 'java基础学习-2', '2024-02-27 15:30:24');
INSERT INTO `studyinfo` VALUES (12, '孙伟', '1', 'java基础学习-1', '2024-02-27 15:30:24');
INSERT INTO `studyinfo` VALUES (13, '赵伟', '3', 'java基础学习-3', '2024-02-27 15:30:24');
INSERT INTO `studyinfo` VALUES (14, '古娜拉', '1', 'java基础学习-1', '2024-02-27 15:30:24');
INSERT INTO `studyinfo` VALUES (15, '鲁路修', '1', 'java基础学习-1', '2024-02-27 16:30:23');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `picurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, 'test', '18314463515', 'http://www.javalm.cn/file/head.jpg', 'test555@qq.com', '学生', '男', '123456', NULL);
INSERT INTO `userinfo` VALUES (2, '王琪', '18314463788', 'http://www.javalm.cn/file/head1.png', 'zhagnsan@qq.com', '教师', '女', '123456', NULL);
INSERT INTO `userinfo` VALUES (3, '纸飞机', '18314469999', 'http://www.javalm.cn/file/head1.png', '123456@qq.com', '学生', '男', '123456', NULL);
INSERT INTO `userinfo` VALUES (4, '小明', '18314463886', 'http://www.javalm.cn/file/head1.png', 'xiaoming@qq.com', '学生', '男', '123456', NULL);
INSERT INTO `userinfo` VALUES (7, '金雨潭', '18314463888', 'http://www.javalm.cn/file/head1.png', 'xiaoming01@qq.com', '教师', '男', '123456', NULL);
INSERT INTO `userinfo` VALUES (8, '李煜松', '13299995623', 'http://www.javalm.cn/file/head1.png', '1270695047@qq.com', '教师', '女', '123456', '');

-- ----------------------------
-- Table structure for workinfo
-- ----------------------------
DROP TABLE IF EXISTS `workinfo`;
CREATE TABLE `workinfo`  (
  `wid` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务编号',
  `wname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务名称',
  `wcontent` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务内容',
  `wuser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布教师',
  `waddtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`wid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '任务信息' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of workinfo
-- ----------------------------
INSERT INTO `workinfo` VALUES (1, '学会搭建java环境', '学会搭建java环境 记录每个步骤', '王琪', '2024-02-27 15:30:24');

SET FOREIGN_KEY_CHECKS = 1;
