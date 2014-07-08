/*
Navicat MySQL Data Transfer

Source Server         : test1
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : movieadvisor

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2014-06-27 12:29:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `friend`
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `friendId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7DEAF6BE9999BD4` (`userId`),
  CONSTRAINT `FK7DEAF6BE9999BD4` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES ('1', '6', '1');
INSERT INTO `friend` VALUES ('2', '3', '1');
INSERT INTO `friend` VALUES ('3', '4', '1');
INSERT INTO `friend` VALUES ('4', '1', '7');
INSERT INTO `friend` VALUES ('5', '3', '7');
INSERT INTO `friend` VALUES ('6', '7', '1');

-- ----------------------------
-- Table structure for `movie`
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `movieId` int(11) NOT NULL,
  `rating` tinyint(4) DEFAULT NULL,
  `userId` bigint(20) NOT NULL,
  `isInWatchlist` tinyint(1) DEFAULT NULL,
  `viewTime` datetime DEFAULT NULL,
  PRIMARY KEY (`movieId`,`userId`),
  KEY `FK4714F109999BD4` (`userId`),
  KEY `userId` (`userId`),
  KEY `movieId` (`movieId`),
  CONSTRAINT `FK4714F109999BD4` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES ('200', '6', '1', '0', null);
INSERT INTO `movie` VALUES ('200', '6', '3', '0', null);
INSERT INTO `movie` VALUES ('200', '0', '4', '0', null);
INSERT INTO `movie` VALUES ('200', '3', '6', '0', null);
INSERT INTO `movie` VALUES ('201', '5', '1', '0', null);
INSERT INTO `movie` VALUES ('201', '5', '3', '0', null);
INSERT INTO `movie` VALUES ('201', '5', '4', '0', null);
INSERT INTO `movie` VALUES ('201', '3', '6', '0', null);
INSERT INTO `movie` VALUES ('202', '1', '1', '0', null);
INSERT INTO `movie` VALUES ('203', '6', '1', '0', null);
INSERT INTO `movie` VALUES ('203', '4', '3', '0', null);
INSERT INTO `movie` VALUES ('203', '1', '4', '0', null);
INSERT INTO `movie` VALUES ('203', '7', '6', '0', null);
INSERT INTO `movie` VALUES ('204', '1', '1', '0', null);
INSERT INTO `movie` VALUES ('204', '4', '3', '0', null);
INSERT INTO `movie` VALUES ('204', '1', '4', '0', null);
INSERT INTO `movie` VALUES ('204', '2', '6', '0', null);
INSERT INTO `movie` VALUES ('205', '2', '1', '0', null);
INSERT INTO `movie` VALUES ('205', '5', '3', '0', null);
INSERT INTO `movie` VALUES ('205', '5', '4', '0', null);
INSERT INTO `movie` VALUES ('205', '4', '6', '0', null);
INSERT INTO `movie` VALUES ('206', '4', '1', '0', null);
INSERT INTO `movie` VALUES ('206', '7', '3', '0', null);
INSERT INTO `movie` VALUES ('206', '6', '4', '0', null);
INSERT INTO `movie` VALUES ('206', '6', '6', '0', null);
INSERT INTO `movie` VALUES ('207', '0', '1', '0', null);
INSERT INTO `movie` VALUES ('207', '5', '3', '0', null);
INSERT INTO `movie` VALUES ('207', '3', '4', '0', null);
INSERT INTO `movie` VALUES ('208', '4', '1', '0', null);
INSERT INTO `movie` VALUES ('211', '3', '1', '0', null);
INSERT INTO `movie` VALUES ('211', '3', '3', '0', null);
INSERT INTO `movie` VALUES ('211', '1', '4', '0', null);
INSERT INTO `movie` VALUES ('211', '8', '6', '0', null);
INSERT INTO `movie` VALUES ('212', '4', '1', '0', null);
INSERT INTO `movie` VALUES ('212', '5', '3', '0', null);
INSERT INTO `movie` VALUES ('212', '5', '6', '0', null);
INSERT INTO `movie` VALUES ('213', '6', '1', '0', null);
INSERT INTO `movie` VALUES ('213', '8', '3', '0', null);
INSERT INTO `movie` VALUES ('213', '4', '4', '0', null);
INSERT INTO `movie` VALUES ('213', '0', '6', '0', null);
INSERT INTO `movie` VALUES ('214', '4', '1', '0', null);
INSERT INTO `movie` VALUES ('214', '8', '3', '0', null);
INSERT INTO `movie` VALUES ('214', '4', '4', '0', null);
INSERT INTO `movie` VALUES ('214', '1', '6', '0', null);
INSERT INTO `movie` VALUES ('215', null, '1', '0', '2014-06-25 00:28:09');
INSERT INTO `movie` VALUES ('215', '6', '3', '0', null);
INSERT INTO `movie` VALUES ('215', '3', '4', '0', null);
INSERT INTO `movie` VALUES ('215', '7', '6', '0', null);
INSERT INTO `movie` VALUES ('216', '3', '1', '0', null);
INSERT INTO `movie` VALUES ('216', '5', '3', '0', null);
INSERT INTO `movie` VALUES ('216', '3', '4', '0', null);
INSERT INTO `movie` VALUES ('216', '4', '6', '0', null);
INSERT INTO `movie` VALUES ('217', '8', '1', '0', null);
INSERT INTO `movie` VALUES ('217', '6', '3', '0', null);
INSERT INTO `movie` VALUES ('217', '7', '4', '0', null);
INSERT INTO `movie` VALUES ('217', '9', '6', '0', null);
INSERT INTO `movie` VALUES ('217', null, '7', '0', '2014-06-25 12:47:51');
INSERT INTO `movie` VALUES ('218', '4', '1', '0', null);
INSERT INTO `movie` VALUES ('218', '7', '3', '0', null);
INSERT INTO `movie` VALUES ('218', '8', '4', '0', null);
INSERT INTO `movie` VALUES ('218', '7', '6', '0', null);
INSERT INTO `movie` VALUES ('219', '9', '1', '0', null);
INSERT INTO `movie` VALUES ('219', '0', '3', '0', null);
INSERT INTO `movie` VALUES ('219', '6', '4', '0', null);
INSERT INTO `movie` VALUES ('219', '0', '6', '0', null);
INSERT INTO `movie` VALUES ('238', '10', '1', '0', '2014-06-24 20:36:59');
INSERT INTO `movie` VALUES ('238', '9', '3', '0', null);
INSERT INTO `movie` VALUES ('238', '7', '6', null, null);
INSERT INTO `movie` VALUES ('238', '6', '7', '1', '2014-06-25 16:51:16');
INSERT INTO `movie` VALUES ('240', '9', '1', '1', '2014-06-26 12:37:52');
INSERT INTO `movie` VALUES ('240', '8', '3', '0', null);
INSERT INTO `movie` VALUES ('240', '7', '4', '0', null);
INSERT INTO `movie` VALUES ('240', '7', '7', '1', null);
INSERT INTO `movie` VALUES ('278', '8', '1', '1', '2014-06-25 22:25:46');
INSERT INTO `movie` VALUES ('278', '10', '3', '0', '2014-06-25 18:39:27');
INSERT INTO `movie` VALUES ('278', '8', '4', '0', null);
INSERT INTO `movie` VALUES ('278', '8', '6', '0', null);
INSERT INTO `movie` VALUES ('278', '8', '7', '0', null);
INSERT INTO `movie` VALUES ('379', '10', '1', '1', '2014-06-25 01:33:45');
INSERT INTO `movie` VALUES ('379', '7', '6', '0', null);
INSERT INTO `movie` VALUES ('389', '10', '1', '1', '2014-06-25 22:40:38');
INSERT INTO `movie` VALUES ('389', '10', '7', '0', null);
INSERT INTO `movie` VALUES ('548', '7', '1', '1', null);
INSERT INTO `movie` VALUES ('548', '5', '7', '0', null);
INSERT INTO `movie` VALUES ('599', '6', '1', '0', '2014-06-25 01:57:57');
INSERT INTO `movie` VALUES ('599', '8', '7', '0', null);
INSERT INTO `movie` VALUES ('832', null, '1', '0', '2014-06-25 01:38:12');
INSERT INTO `movie` VALUES ('832', '4', '3', '0', null);
INSERT INTO `movie` VALUES ('832', '8', '4', '0', null);
INSERT INTO `movie` VALUES ('832', '4', '6', '0', null);
INSERT INTO `movie` VALUES ('1955', '9', '1', '0', null);
INSERT INTO `movie` VALUES ('3082', '7', '1', '0', '2014-06-23 19:49:17');
INSERT INTO `movie` VALUES ('3082', '6', '3', '0', null);
INSERT INTO `movie` VALUES ('13345', '5', '1', null, null);
INSERT INTO `movie` VALUES ('13345', '7', '3', '0', null);
INSERT INTO `movie` VALUES ('13345', '7', '6', null, null);
INSERT INTO `movie` VALUES ('13345', '8', '7', '0', null);
INSERT INTO `movie` VALUES ('49047', '10', '1', '1', '2014-06-25 22:40:04');
INSERT INTO `movie` VALUES ('49047', '10', '3', '0', null);
INSERT INTO `movie` VALUES ('49047', '10', '4', '0', null);
INSERT INTO `movie` VALUES ('49047', '10', '6', '0', null);
INSERT INTO `movie` VALUES ('49047', '5', '7', '0', null);
INSERT INTO `movie` VALUES ('82702', null, '1', '1', '2014-06-26 15:27:11');
INSERT INTO `movie` VALUES ('82702', null, '3', '0', '2014-06-25 18:23:00');
INSERT INTO `movie` VALUES ('96721', '6', '7', '0', null);
INSERT INTO `movie` VALUES ('106646', null, '1', '1', null);
INSERT INTO `movie` VALUES ('106646', '8', '7', '0', null);
INSERT INTO `movie` VALUES ('109424', '7', '7', '0', null);
INSERT INTO `movie` VALUES ('120467', '8', '7', '1', null);
INSERT INTO `movie` VALUES ('152601', null, '1', '0', '2014-06-25 00:51:41');
INSERT INTO `movie` VALUES ('152601', '7', '3', '0', null);
INSERT INTO `movie` VALUES ('152601', '9', '7', '0', null);
INSERT INTO `movie` VALUES ('184098', null, '1', '1', '2014-06-26 15:43:17');
INSERT INTO `movie` VALUES ('209451', null, '1', '1', '2014-06-25 23:37:15');
INSERT INTO `movie` VALUES ('244536', null, '1', '0', '2014-06-25 22:41:02');
INSERT INTO `movie` VALUES ('275619', null, '1', '0', '2014-06-26 12:38:23');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `fullName` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'vitalii.oleksiv@gmail.com', 'Vitalii Oleksiv', '111111', 'vita1ity');
INSERT INTO `user` VALUES ('3', 'olya.stalskaya@gmail.com', 'Olya Stalska', 'olyalya', 'olya');
INSERT INTO `user` VALUES ('4', 'liubko.qwert@gmail.com', 'Luibomyr Mychalchenko', '111111', 'sobaka_balabaka');
INSERT INTO `user` VALUES ('6', 'johnny@gmail.com', 'Little Johnny', '222222', 'johnny');
INSERT INTO `user` VALUES ('7', 'lesya@gmail.com', 'Lesya Stryzko', '000000', 'leska');
INSERT INTO `user` VALUES ('17', 'natusinkagavrilova@gmail.com', 'Natalya Gavrilova', '123456', 'natalya');
