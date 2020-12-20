/*
 Navicat Premium Data Transfer

 Source Server         : 本机MySQL
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : eshop

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 20/12/2020 17:36:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '管理员id标识，主键，自增',
  `name` varchar(16) DEFAULT NULL COMMENT '管理员姓名',
  `pwd` varchar(50) DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for functions
-- ----------------------------
DROP TABLE IF EXISTS `functions`;
CREATE TABLE `functions` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '系统功能id，主键，自增',
  `name` varchar(20) DEFAULT NULL COMMENT '功能菜单名称',
  `parentid` int DEFAULT NULL COMMENT '父节点id',
  `url` varchar(50) DEFAULT NULL COMMENT '功能页面',
  `isleaf` bit(1) DEFAULT NULL COMMENT '是否叶子节点',
  `nodeorder` int DEFAULT NULL COMMENT '节点顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of functions
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '订单明细id，主键，自增',
  `oid` int DEFAULT NULL COMMENT '订单id',
  `pid` int DEFAULT NULL COMMENT '商品id',
  `num` int DEFAULT NULL COMMENT '购买数量',
  PRIMARY KEY (`id`),
  KEY `oid` (`oid`),
  KEY `pid` (`pid`),
  CONSTRAINT `oid` FOREIGN KEY (`oid`) REFERENCES `order_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pid` FOREIGN KEY (`pid`) REFERENCES `product_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '订单id，主键，自增',
  `uid` int DEFAULT NULL COMMENT '客户id',
  `status` varchar(16) DEFAULT NULL COMMENT '订单状态',
  `ordertime` datetime DEFAULT NULL COMMENT '订单下单时间',
  `orderprice` decimal(10,2) DEFAULT NULL COMMENT '订单金额',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for powers
-- ----------------------------
DROP TABLE IF EXISTS `powers`;
CREATE TABLE `powers` (
  `aid` int NOT NULL COMMENT '管理员id',
  `fid` int NOT NULL COMMENT '系统功能id',
  PRIMARY KEY (`aid`,`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of powers
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '商品id标识，主键，自增',
  `code` varchar(16) DEFAULT NULL COMMENT '商品编号',
  `name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `tid` int DEFAULT NULL COMMENT '商品类别id',
  `brand` varchar(20) DEFAULT NULL COMMENT '品牌',
  `pic` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `num` int DEFAULT NULL COMMENT '商品数量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `intro` longtext COMMENT '商品描述',
  `status` int DEFAULT NULL COMMENT '商品状态',
  PRIMARY KEY (`id`),
  KEY `tid` (`tid`),
  CONSTRAINT `tid` FOREIGN KEY (`tid`) REFERENCES `type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '类型id标识，主键，自鞥',
  `name` varchar(20) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '客户id标识，主键，自增',
  `userName` varchar(16) DEFAULT NULL COMMENT '登录名',
  `password` varchar(16) DEFAULT NULL COMMENT '登录密码',
  `realName` varchar(8) DEFAULT NULL COMMENT '真实姓名',
  `sex` varchar(4) DEFAULT NULL COMMENT '性别',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `email` varchar(50) DEFAULT NULL COMMENT '邮件地址',
  `regDate` datetime DEFAULT NULL COMMENT '注册时间',
  `status` int DEFAULT NULL COMMENT '客户状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
