/*
Navicat MySQL Data Transfer

Source Server         : 骑战内网
Source Server Version : 50615
Source Host           : 192.168.100.10:3306
Source Database       : db_qz_cfg

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2016-05-30 18:03:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_achieve
-- ----------------------------
DROP TABLE IF EXISTS `t_achieve`;
CREATE TABLE `t_achieve` (
  `achieve_id` int(11) NOT NULL COMMENT '成就编号',
  `name` varchar(50) NOT NULL COMMENT '成就名称',
  `des` varchar(128) NOT NULL COMMENT '描述',
  `type` int(11) NOT NULL COMMENT '类型',
  `ass_id` int(11) NOT NULL COMMENT '关联编号',
  `num` int(11) NOT NULL COMMENT '数量'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_achieve
-- ----------------------------
INSERT INTO `t_achieve` VALUES ('1', '收集石板', '获得1块遗迹石板。', '1', '0', '1');
INSERT INTO `t_achieve` VALUES ('2', '收集石板', '获得3块遗迹石板。', '1', '0', '3');
INSERT INTO `t_achieve` VALUES ('3', '收集石板', '获得5块遗迹石板。', '1', '0', '5');
INSERT INTO `t_achieve` VALUES ('4', '收集石板', '获得7块遗迹石板。', '1', '0', '7');
INSERT INTO `t_achieve` VALUES ('5', '收集石板', '获得10块遗迹石板。', '1', '0', '10');
INSERT INTO `t_achieve` VALUES ('6', '收集石板', '获得15块遗迹石板。', '1', '0', '15');
INSERT INTO `t_achieve` VALUES ('7', '收集石板', '获得20块遗迹石板。', '1', '0', '20');
INSERT INTO `t_achieve` VALUES ('8', '收集石板', '获得25块遗迹石板。', '1', '0', '25');
INSERT INTO `t_achieve` VALUES ('9', '收集石板', '获得30块遗迹石板。', '1', '0', '30');
INSERT INTO `t_achieve` VALUES ('10', '收集石板', '获得35块遗迹石板。', '1', '0', '35');
INSERT INTO `t_achieve` VALUES ('11', '收集石板', '获得40块遗迹石板。', '1', '0', '40');
INSERT INTO `t_achieve` VALUES ('12', '收集石板', '获得45块遗迹石板。', '1', '0', '45');
INSERT INTO `t_achieve` VALUES ('13', '收集石板', '获得50块遗迹石板。', '1', '0', '50');
INSERT INTO `t_achieve` VALUES ('14', '收集石板', '获得55块遗迹石板。', '1', '0', '55');
INSERT INTO `t_achieve` VALUES ('15', '收集石板', '获得60块遗迹石板。', '1', '0', '60');
INSERT INTO `t_achieve` VALUES ('16', '收集石板', '获得65块遗迹石板。', '1', '0', '65');
INSERT INTO `t_achieve` VALUES ('17', '收集石板', '获得70块遗迹石板。', '1', '0', '70');
INSERT INTO `t_achieve` VALUES ('18', '收集石板', '获得75块遗迹石板。', '1', '0', '75');
INSERT INTO `t_achieve` VALUES ('19', '收集石板', '获得80块遗迹石板。', '1', '0', '80');
INSERT INTO `t_achieve` VALUES ('20', '收集石板', '获得85块遗迹石板。', '1', '0', '85');
INSERT INTO `t_achieve` VALUES ('21', '收集石板', '获得90块遗迹石板。', '1', '0', '90');
INSERT INTO `t_achieve` VALUES ('22', '收集石板', '获得95块遗迹石板。', '1', '0', '95');
INSERT INTO `t_achieve` VALUES ('23', '收集石板', '获得100块遗迹石板。', '1', '0', '100');
INSERT INTO `t_achieve` VALUES ('24', '收集石板', '获得150块遗迹石板。', '1', '0', '150');
INSERT INTO `t_achieve` VALUES ('25', '收集石板', '获得200块遗迹石板。', '1', '0', '200');
INSERT INTO `t_achieve` VALUES ('26', '收集石板', '获得250块遗迹石板。', '1', '0', '250');
INSERT INTO `t_achieve` VALUES ('27', '收集石板', '获得300块遗迹石板。', '1', '0', '300');
INSERT INTO `t_achieve` VALUES ('28', '收集石板', '获得350块遗迹石板。', '1', '0', '350');
INSERT INTO `t_achieve` VALUES ('29', '收集石板', '获得400块遗迹石板。', '1', '0', '400');
INSERT INTO `t_achieve` VALUES ('30', '收集石板', '获得450块遗迹石板。', '1', '0', '450');
INSERT INTO `t_achieve` VALUES ('31', '收集石板', '获得500块遗迹石板。', '1', '0', '500');
INSERT INTO `t_achieve` VALUES ('32', '收集石板', '获得550块遗迹石板。', '1', '0', '550');
INSERT INTO `t_achieve` VALUES ('33', '收集石板', '获得600块遗迹石板。', '1', '0', '600');
INSERT INTO `t_achieve` VALUES ('34', '收集石板', '获得650块遗迹石板。', '1', '0', '650');
INSERT INTO `t_achieve` VALUES ('35', '收集石板', '获得700块遗迹石板。', '1', '0', '700');
INSERT INTO `t_achieve` VALUES ('36', '收集石板', '获得750块遗迹石板。', '1', '0', '750');
INSERT INTO `t_achieve` VALUES ('37', '收集石板', '获得800块遗迹石板。', '1', '0', '800');
INSERT INTO `t_achieve` VALUES ('38', '收集石板', '获得850块遗迹石板。', '1', '0', '850');
INSERT INTO `t_achieve` VALUES ('39', '收集石板', '获得900块遗迹石板。', '1', '0', '900');
INSERT INTO `t_achieve` VALUES ('40', '收集石板', '获得950块遗迹石板。', '1', '0', '950');
INSERT INTO `t_achieve` VALUES ('41', '收集石板', '获得999块遗迹石板。', '1', '0', '999');

-- ----------------------------
-- Table structure for t_achieve_award
-- ----------------------------
DROP TABLE IF EXISTS `t_achieve_award`;
CREATE TABLE `t_achieve_award` (
  `achieve_id` int(11) NOT NULL COMMENT '成就编号',
  `goods_id` int(11) NOT NULL COMMENT '奖励对应编号',
  `type` int(11) NOT NULL COMMENT '类型',
  `num` int(11) NOT NULL COMMENT '数量',
  `level` int(11) NOT NULL COMMENT '等级'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_achieve_award
-- ----------------------------
INSERT INTO `t_achieve_award` VALUES ('1', '0', '2', '5000', '0');
INSERT INTO `t_achieve_award` VALUES ('2', '0', '5', '1000', '0');
INSERT INTO `t_achieve_award` VALUES ('3', '8', '4', '1', '0');
INSERT INTO `t_achieve_award` VALUES ('4', '36', '1', '1', '1');
INSERT INTO `t_achieve_award` VALUES ('5', '6', '4', '1', '0');
INSERT INTO `t_achieve_award` VALUES ('6', '0', '2', '10000', '0');
INSERT INTO `t_achieve_award` VALUES ('7', '44', '1', '1', '1');
INSERT INTO `t_achieve_award` VALUES ('8', '45', '1', '1', '1');
INSERT INTO `t_achieve_award` VALUES ('9', '46', '1', '1', '1');
INSERT INTO `t_achieve_award` VALUES ('10', '39', '1', '1', '1');
INSERT INTO `t_achieve_award` VALUES ('11', '38', '1', '1', '1');
INSERT INTO `t_achieve_award` VALUES ('12', '40', '1', '1', '1');
INSERT INTO `t_achieve_award` VALUES ('13', '47', '1', '1', '1');
INSERT INTO `t_achieve_award` VALUES ('14', '42', '1', '1', '1');
INSERT INTO `t_achieve_award` VALUES ('15', '48', '1', '1', '1');
INSERT INTO `t_achieve_award` VALUES ('16', '6', '4', '1', '0');
INSERT INTO `t_achieve_award` VALUES ('17', '42', '1', '1', '1');
INSERT INTO `t_achieve_award` VALUES ('18', '8', '4', '2', '0');
INSERT INTO `t_achieve_award` VALUES ('19', '43', '1', '1', '1');
INSERT INTO `t_achieve_award` VALUES ('20', '6', '4', '3', '0');
INSERT INTO `t_achieve_award` VALUES ('21', '0', '2', '30000', '0');
INSERT INTO `t_achieve_award` VALUES ('22', '3', '4', '1', '0');
INSERT INTO `t_achieve_award` VALUES ('23', '8', '4', '3', '0');
INSERT INTO `t_achieve_award` VALUES ('24', '0', '2', '100000', '0');
INSERT INTO `t_achieve_award` VALUES ('25', '0', '5', '6000', '0');
INSERT INTO `t_achieve_award` VALUES ('26', '6', '4', '5', '0');
INSERT INTO `t_achieve_award` VALUES ('27', '3', '4', '1', '0');
INSERT INTO `t_achieve_award` VALUES ('28', '0', '2', '100000', '0');
INSERT INTO `t_achieve_award` VALUES ('29', '0', '5', '6000', '0');
INSERT INTO `t_achieve_award` VALUES ('30', '6', '4', '5', '0');
INSERT INTO `t_achieve_award` VALUES ('31', '3', '4', '1', '0');
INSERT INTO `t_achieve_award` VALUES ('32', '0', '2', '100000', '0');
INSERT INTO `t_achieve_award` VALUES ('33', '0', '5', '6000', '0');
INSERT INTO `t_achieve_award` VALUES ('34', '6', '4', '5', '0');
INSERT INTO `t_achieve_award` VALUES ('35', '3', '4', '1', '0');
INSERT INTO `t_achieve_award` VALUES ('36', '8', '4', '4', '0');
INSERT INTO `t_achieve_award` VALUES ('37', '0', '2', '100000', '0');
INSERT INTO `t_achieve_award` VALUES ('38', '0', '5', '6000', '0');
INSERT INTO `t_achieve_award` VALUES ('39', '6', '4', '5', '0');
INSERT INTO `t_achieve_award` VALUES ('40', '3', '4', '1', '0');
INSERT INTO `t_achieve_award` VALUES ('41', '8', '4', '5', '0');

-- ----------------------------
-- Table structure for t_activity_zone
-- ----------------------------
DROP TABLE IF EXISTS `t_activity_zone`;
CREATE TABLE `t_activity_zone` (
  `zone_id` int(11) NOT NULL COMMENT '进化id',
  `type` int(11) NOT NULL COMMENT '类型',
  `start_time` varchar(50) NOT NULL COMMENT '开启时间',
  `end_time` varchar(50) NOT NULL COMMENT '关闭时间',
  `num` int(11) NOT NULL COMMENT '每日获胜次数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_activity_zone
-- ----------------------------
INSERT INTO `t_activity_zone` VALUES ('500', '1', '11', '16', '3');
INSERT INTO `t_activity_zone` VALUES ('501', '2', '0', '24', '2');
INSERT INTO `t_activity_zone` VALUES ('502', '0', '2014/7/8 13:00', '2014/8/8 13:00', '0');

-- ----------------------------
-- Table structure for t_arena_award
-- ----------------------------
DROP TABLE IF EXISTS `t_arena_award`;
CREATE TABLE `t_arena_award` (
  `shopping_id` int(11) NOT NULL COMMENT '商店id',
  `goods_id` int(11) NOT NULL COMMENT '物品id',
  `type` int(11) NOT NULL COMMENT '物品类型',
  `num` int(11) NOT NULL COMMENT '数量',
  `level` int(11) NOT NULL COMMENT '物品等级',
  `money` int(11) NOT NULL COMMENT '兑换价格',
  `rate` int(11) NOT NULL COMMENT '出现概率（整数）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_arena_award
-- ----------------------------
INSERT INTO `t_arena_award` VALUES ('1', '5010001', '7', '1', '0', '1', '20');
INSERT INTO `t_arena_award` VALUES ('1', '5010002', '7', '1', '0', '1', '20');
INSERT INTO `t_arena_award` VALUES ('1', '5010003', '7', '1', '0', '1', '20');
INSERT INTO `t_arena_award` VALUES ('1', '5010004', '7', '1', '0', '1', '20');
INSERT INTO `t_arena_award` VALUES ('1', '5010005', '7', '1', '0', '1', '20');
INSERT INTO `t_arena_award` VALUES ('2', '4020001', '4', '5', '0', '1', '50');
INSERT INTO `t_arena_award` VALUES ('2', '4020005', '4', '2', '0', '1', '50');
INSERT INTO `t_arena_award` VALUES ('3', '4020002', '4', '10', '0', '1', '50');
INSERT INTO `t_arena_award` VALUES ('3', '4020003', '4', '2', '0', '1', '50');
INSERT INTO `t_arena_award` VALUES ('4', '82031', '1', '1', '0', '1', '50');
INSERT INTO `t_arena_award` VALUES ('4', '82032', '1', '1', '0', '1', '50');
INSERT INTO `t_arena_award` VALUES ('5', '0', '2', '900000', '0', '1', '50');
INSERT INTO `t_arena_award` VALUES ('5', '0', '2', '900000', '0', '1', '50');
INSERT INTO `t_arena_award` VALUES ('6', '0', '3', '50000', '0', '1', '25');
INSERT INTO `t_arena_award` VALUES ('6', '0', '3', '500', '0', '1', '25');
INSERT INTO `t_arena_award` VALUES ('6', '0', '3', '1000', '0', '1', '25');
INSERT INTO `t_arena_award` VALUES ('6', '0', '3', '2000', '0', '1', '25');

-- ----------------------------
-- Table structure for t_arena_buy
-- ----------------------------
DROP TABLE IF EXISTS `t_arena_buy`;
CREATE TABLE `t_arena_buy` (
  `count` int(11) NOT NULL COMMENT '次数',
  `buy_count` int(11) NOT NULL COMMENT '购买挑战次数的钱',
  `shopping_money` int(11) NOT NULL COMMENT '商城刷新的钱'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_arena_buy
-- ----------------------------
INSERT INTO `t_arena_buy` VALUES ('1', '50', '100');
INSERT INTO `t_arena_buy` VALUES ('2', '100', '200');
INSERT INTO `t_arena_buy` VALUES ('3', '200', '400');
INSERT INTO `t_arena_buy` VALUES ('4', '210', '410');
INSERT INTO `t_arena_buy` VALUES ('5', '220', '420');
INSERT INTO `t_arena_buy` VALUES ('6', '230', '430');
INSERT INTO `t_arena_buy` VALUES ('7', '240', '440');
INSERT INTO `t_arena_buy` VALUES ('8', '250', '450');
INSERT INTO `t_arena_buy` VALUES ('9', '260', '460');
INSERT INTO `t_arena_buy` VALUES ('10', '270', '470');
INSERT INTO `t_arena_buy` VALUES ('11', '280', '480');
INSERT INTO `t_arena_buy` VALUES ('12', '290', '490');
INSERT INTO `t_arena_buy` VALUES ('13', '300', '500');
INSERT INTO `t_arena_buy` VALUES ('14', '310', '510');
INSERT INTO `t_arena_buy` VALUES ('15', '320', '520');
INSERT INTO `t_arena_buy` VALUES ('16', '330', '530');
INSERT INTO `t_arena_buy` VALUES ('17', '340', '540');
INSERT INTO `t_arena_buy` VALUES ('18', '350', '550');
INSERT INTO `t_arena_buy` VALUES ('19', '360', '560');
INSERT INTO `t_arena_buy` VALUES ('20', '370', '570');
INSERT INTO `t_arena_buy` VALUES ('21', '380', '580');
INSERT INTO `t_arena_buy` VALUES ('22', '390', '590');
INSERT INTO `t_arena_buy` VALUES ('23', '400', '600');
INSERT INTO `t_arena_buy` VALUES ('24', '410', '610');
INSERT INTO `t_arena_buy` VALUES ('25', '420', '620');
INSERT INTO `t_arena_buy` VALUES ('26', '430', '630');
INSERT INTO `t_arena_buy` VALUES ('27', '440', '640');
INSERT INTO `t_arena_buy` VALUES ('28', '450', '650');
INSERT INTO `t_arena_buy` VALUES ('29', '460', '660');
INSERT INTO `t_arena_buy` VALUES ('30', '470', '670');
INSERT INTO `t_arena_buy` VALUES ('31', '480', '680');
INSERT INTO `t_arena_buy` VALUES ('32', '490', '690');
INSERT INTO `t_arena_buy` VALUES ('33', '500', '700');
INSERT INTO `t_arena_buy` VALUES ('34', '510', '710');
INSERT INTO `t_arena_buy` VALUES ('35', '520', '720');
INSERT INTO `t_arena_buy` VALUES ('36', '530', '730');
INSERT INTO `t_arena_buy` VALUES ('37', '540', '740');
INSERT INTO `t_arena_buy` VALUES ('38', '550', '750');
INSERT INTO `t_arena_buy` VALUES ('39', '560', '760');
INSERT INTO `t_arena_buy` VALUES ('40', '570', '770');
INSERT INTO `t_arena_buy` VALUES ('41', '580', '780');
INSERT INTO `t_arena_buy` VALUES ('42', '590', '790');
INSERT INTO `t_arena_buy` VALUES ('43', '600', '800');
INSERT INTO `t_arena_buy` VALUES ('44', '610', '810');
INSERT INTO `t_arena_buy` VALUES ('45', '620', '820');
INSERT INTO `t_arena_buy` VALUES ('46', '630', '830');
INSERT INTO `t_arena_buy` VALUES ('47', '640', '840');
INSERT INTO `t_arena_buy` VALUES ('48', '650', '850');
INSERT INTO `t_arena_buy` VALUES ('49', '660', '860');
INSERT INTO `t_arena_buy` VALUES ('50', '670', '870');
INSERT INTO `t_arena_buy` VALUES ('51', '680', '880');
INSERT INTO `t_arena_buy` VALUES ('52', '690', '890');
INSERT INTO `t_arena_buy` VALUES ('53', '700', '900');
INSERT INTO `t_arena_buy` VALUES ('54', '710', '910');
INSERT INTO `t_arena_buy` VALUES ('55', '720', '920');
INSERT INTO `t_arena_buy` VALUES ('56', '730', '930');
INSERT INTO `t_arena_buy` VALUES ('57', '740', '940');
INSERT INTO `t_arena_buy` VALUES ('58', '750', '950');
INSERT INTO `t_arena_buy` VALUES ('59', '760', '960');
INSERT INTO `t_arena_buy` VALUES ('60', '770', '970');

-- ----------------------------
-- Table structure for t_arena_condition
-- ----------------------------
DROP TABLE IF EXISTS `t_arena_condition`;
CREATE TABLE `t_arena_condition` (
  `level_up` int(11) NOT NULL COMMENT '等级上限',
  `level_down` int(11) NOT NULL COMMENT '等级下限',
  `fight_one` int(11) NOT NULL COMMENT '战斗力1',
  `fight_two` int(11) NOT NULL COMMENT '战斗力2',
  `fight_three` int(11) NOT NULL COMMENT '战斗力3'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_arena_condition
-- ----------------------------
INSERT INTO `t_arena_condition` VALUES ('45', '15', '1000', '1000', '1000');
INSERT INTO `t_arena_condition` VALUES ('75', '46', '1000', '1000', '1000');
INSERT INTO `t_arena_condition` VALUES ('100', '76', '1000', '1000', '1000');

-- ----------------------------
-- Table structure for t_arena_exp
-- ----------------------------
DROP TABLE IF EXISTS `t_arena_exp`;
CREATE TABLE `t_arena_exp` (
  `level` int(11) NOT NULL COMMENT '等级',
  `exp` int(11) NOT NULL COMMENT '奖励经验'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_arena_exp
-- ----------------------------
INSERT INTO `t_arena_exp` VALUES ('1', '10');
INSERT INTO `t_arena_exp` VALUES ('2', '20');
INSERT INTO `t_arena_exp` VALUES ('3', '30');
INSERT INTO `t_arena_exp` VALUES ('4', '40');
INSERT INTO `t_arena_exp` VALUES ('5', '50');
INSERT INTO `t_arena_exp` VALUES ('6', '60');
INSERT INTO `t_arena_exp` VALUES ('7', '70');
INSERT INTO `t_arena_exp` VALUES ('8', '80');
INSERT INTO `t_arena_exp` VALUES ('9', '90');
INSERT INTO `t_arena_exp` VALUES ('10', '100');
INSERT INTO `t_arena_exp` VALUES ('11', '110');
INSERT INTO `t_arena_exp` VALUES ('12', '120');
INSERT INTO `t_arena_exp` VALUES ('13', '130');
INSERT INTO `t_arena_exp` VALUES ('14', '140');
INSERT INTO `t_arena_exp` VALUES ('15', '150');
INSERT INTO `t_arena_exp` VALUES ('16', '160');
INSERT INTO `t_arena_exp` VALUES ('17', '170');
INSERT INTO `t_arena_exp` VALUES ('18', '180');
INSERT INTO `t_arena_exp` VALUES ('19', '190');
INSERT INTO `t_arena_exp` VALUES ('20', '200');
INSERT INTO `t_arena_exp` VALUES ('21', '210');
INSERT INTO `t_arena_exp` VALUES ('22', '220');
INSERT INTO `t_arena_exp` VALUES ('23', '230');
INSERT INTO `t_arena_exp` VALUES ('24', '240');
INSERT INTO `t_arena_exp` VALUES ('25', '250');
INSERT INTO `t_arena_exp` VALUES ('26', '260');
INSERT INTO `t_arena_exp` VALUES ('27', '270');
INSERT INTO `t_arena_exp` VALUES ('28', '280');
INSERT INTO `t_arena_exp` VALUES ('29', '290');
INSERT INTO `t_arena_exp` VALUES ('30', '300');
INSERT INTO `t_arena_exp` VALUES ('31', '310');
INSERT INTO `t_arena_exp` VALUES ('32', '320');
INSERT INTO `t_arena_exp` VALUES ('33', '330');
INSERT INTO `t_arena_exp` VALUES ('34', '340');
INSERT INTO `t_arena_exp` VALUES ('35', '350');
INSERT INTO `t_arena_exp` VALUES ('36', '360');
INSERT INTO `t_arena_exp` VALUES ('37', '370');
INSERT INTO `t_arena_exp` VALUES ('38', '380');
INSERT INTO `t_arena_exp` VALUES ('39', '390');
INSERT INTO `t_arena_exp` VALUES ('40', '400');
INSERT INTO `t_arena_exp` VALUES ('41', '410');
INSERT INTO `t_arena_exp` VALUES ('42', '420');
INSERT INTO `t_arena_exp` VALUES ('43', '430');
INSERT INTO `t_arena_exp` VALUES ('44', '440');
INSERT INTO `t_arena_exp` VALUES ('45', '450');
INSERT INTO `t_arena_exp` VALUES ('46', '460');
INSERT INTO `t_arena_exp` VALUES ('47', '470');
INSERT INTO `t_arena_exp` VALUES ('48', '480');
INSERT INTO `t_arena_exp` VALUES ('49', '490');
INSERT INTO `t_arena_exp` VALUES ('50', '500');
INSERT INTO `t_arena_exp` VALUES ('51', '510');
INSERT INTO `t_arena_exp` VALUES ('52', '520');
INSERT INTO `t_arena_exp` VALUES ('53', '530');
INSERT INTO `t_arena_exp` VALUES ('54', '540');
INSERT INTO `t_arena_exp` VALUES ('55', '550');
INSERT INTO `t_arena_exp` VALUES ('56', '560');
INSERT INTO `t_arena_exp` VALUES ('57', '570');
INSERT INTO `t_arena_exp` VALUES ('58', '580');
INSERT INTO `t_arena_exp` VALUES ('59', '590');
INSERT INTO `t_arena_exp` VALUES ('60', '600');
INSERT INTO `t_arena_exp` VALUES ('61', '610');
INSERT INTO `t_arena_exp` VALUES ('62', '620');
INSERT INTO `t_arena_exp` VALUES ('63', '630');
INSERT INTO `t_arena_exp` VALUES ('64', '640');
INSERT INTO `t_arena_exp` VALUES ('65', '650');
INSERT INTO `t_arena_exp` VALUES ('66', '660');
INSERT INTO `t_arena_exp` VALUES ('67', '670');
INSERT INTO `t_arena_exp` VALUES ('68', '680');
INSERT INTO `t_arena_exp` VALUES ('69', '690');
INSERT INTO `t_arena_exp` VALUES ('70', '700');
INSERT INTO `t_arena_exp` VALUES ('71', '710');
INSERT INTO `t_arena_exp` VALUES ('72', '720');
INSERT INTO `t_arena_exp` VALUES ('73', '730');
INSERT INTO `t_arena_exp` VALUES ('74', '740');
INSERT INTO `t_arena_exp` VALUES ('75', '750');
INSERT INTO `t_arena_exp` VALUES ('76', '760');
INSERT INTO `t_arena_exp` VALUES ('77', '770');
INSERT INTO `t_arena_exp` VALUES ('78', '780');
INSERT INTO `t_arena_exp` VALUES ('79', '790');
INSERT INTO `t_arena_exp` VALUES ('80', '800');
INSERT INTO `t_arena_exp` VALUES ('81', '810');
INSERT INTO `t_arena_exp` VALUES ('82', '820');
INSERT INTO `t_arena_exp` VALUES ('83', '830');
INSERT INTO `t_arena_exp` VALUES ('84', '840');
INSERT INTO `t_arena_exp` VALUES ('85', '850');
INSERT INTO `t_arena_exp` VALUES ('86', '860');
INSERT INTO `t_arena_exp` VALUES ('87', '870');
INSERT INTO `t_arena_exp` VALUES ('88', '880');
INSERT INTO `t_arena_exp` VALUES ('89', '890');
INSERT INTO `t_arena_exp` VALUES ('90', '900');
INSERT INTO `t_arena_exp` VALUES ('91', '910');
INSERT INTO `t_arena_exp` VALUES ('92', '920');
INSERT INTO `t_arena_exp` VALUES ('93', '930');
INSERT INTO `t_arena_exp` VALUES ('94', '940');
INSERT INTO `t_arena_exp` VALUES ('95', '950');
INSERT INTO `t_arena_exp` VALUES ('96', '960');
INSERT INTO `t_arena_exp` VALUES ('97', '970');
INSERT INTO `t_arena_exp` VALUES ('98', '980');
INSERT INTO `t_arena_exp` VALUES ('99', '990');
INSERT INTO `t_arena_exp` VALUES ('100', '1000');

-- ----------------------------
-- Table structure for t_blowing_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_blowing_rule`;
CREATE TABLE `t_blowing_rule` (
  `type` int(11) NOT NULL COMMENT '熔炉类型',
  `prop_id` int(11) NOT NULL COMMENT '武魂id',
  `rate` int(11) NOT NULL COMMENT '概率'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_blowing_rule
-- ----------------------------
INSERT INTO `t_blowing_rule` VALUES ('1', '5010001', '4000');
INSERT INTO `t_blowing_rule` VALUES ('1', '5010002', '3000');
INSERT INTO `t_blowing_rule` VALUES ('1', '5010003', '3000');
INSERT INTO `t_blowing_rule` VALUES ('2', '5010004', '6000');
INSERT INTO `t_blowing_rule` VALUES ('2', '5010005', '4000');
INSERT INTO `t_blowing_rule` VALUES ('3', '5010002', '5000');
INSERT INTO `t_blowing_rule` VALUES ('3', '5010003', '3000');
INSERT INTO `t_blowing_rule` VALUES ('3', '5010001', '2000');

-- ----------------------------
-- Table structure for t_bread_store_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_bread_store_rule`;
CREATE TABLE `t_bread_store_rule` (
  `n_levels` varchar(50) NOT NULL COMMENT '等级区间',
  `n_starProbabilitys` varchar(128) NOT NULL COMMENT '星级概率'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bread_store_rule
-- ----------------------------
INSERT INTO `t_bread_store_rule` VALUES ('1_20', '2_8500|3_500|4_500|5_500');
INSERT INTO `t_bread_store_rule` VALUES ('21_40', '2_5500|3_3000|4_1200|5_300');
INSERT INTO `t_bread_store_rule` VALUES ('41_60', '2_2500|3_5500|4_1500|5_500');
INSERT INTO `t_bread_store_rule` VALUES ('61_80', '|2_1000|3_2500|4_5500|5_1000');
INSERT INTO `t_bread_store_rule` VALUES ('81_100', '2_300|3_1200|4_3000|5_5500');

-- ----------------------------
-- Table structure for t_call_hero
-- ----------------------------
DROP TABLE IF EXISTS `t_call_hero`;
CREATE TABLE `t_call_hero` (
  `array_id` int(11) NOT NULL COMMENT '召唤ID',
  `hero_id` int(11) NOT NULL COMMENT '伙伴ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_call_hero
-- ----------------------------
INSERT INTO `t_call_hero` VALUES ('1001', '82001');
INSERT INTO `t_call_hero` VALUES ('1001', '82002');
INSERT INTO `t_call_hero` VALUES ('1001', '82007');
INSERT INTO `t_call_hero` VALUES ('1001', '82023');
INSERT INTO `t_call_hero` VALUES ('1001', '82033');
INSERT INTO `t_call_hero` VALUES ('1001', '82034');
INSERT INTO `t_call_hero` VALUES ('1002', '82015');
INSERT INTO `t_call_hero` VALUES ('1002', '82016');
INSERT INTO `t_call_hero` VALUES ('1002', '82017');
INSERT INTO `t_call_hero` VALUES ('1002', '82020');
INSERT INTO `t_call_hero` VALUES ('1002', '82021');
INSERT INTO `t_call_hero` VALUES ('1002', '82028');
INSERT INTO `t_call_hero` VALUES ('1002', '82029');
INSERT INTO `t_call_hero` VALUES ('1002', '82041');
INSERT INTO `t_call_hero` VALUES ('1002', '82042');
INSERT INTO `t_call_hero` VALUES ('1002', '82043');
INSERT INTO `t_call_hero` VALUES ('1002', '90001');
INSERT INTO `t_call_hero` VALUES ('1002', '90005');
INSERT INTO `t_call_hero` VALUES ('1002', '90009');
INSERT INTO `t_call_hero` VALUES ('1002', '90013');
INSERT INTO `t_call_hero` VALUES ('1002', '90017');
INSERT INTO `t_call_hero` VALUES ('2001', '82001');
INSERT INTO `t_call_hero` VALUES ('2001', '82002');
INSERT INTO `t_call_hero` VALUES ('2001', '82007');
INSERT INTO `t_call_hero` VALUES ('2001', '82023');
INSERT INTO `t_call_hero` VALUES ('2001', '82033');
INSERT INTO `t_call_hero` VALUES ('2001', '82034');
INSERT INTO `t_call_hero` VALUES ('2002', '82015');
INSERT INTO `t_call_hero` VALUES ('2002', '82016');
INSERT INTO `t_call_hero` VALUES ('2002', '82017');
INSERT INTO `t_call_hero` VALUES ('2002', '82020');
INSERT INTO `t_call_hero` VALUES ('2002', '82021');
INSERT INTO `t_call_hero` VALUES ('2002', '82028');
INSERT INTO `t_call_hero` VALUES ('2002', '82041');
INSERT INTO `t_call_hero` VALUES ('2002', '82042');
INSERT INTO `t_call_hero` VALUES ('2002', '82043');
INSERT INTO `t_call_hero` VALUES ('2002', '90001');
INSERT INTO `t_call_hero` VALUES ('2002', '90005');
INSERT INTO `t_call_hero` VALUES ('2002', '90009');
INSERT INTO `t_call_hero` VALUES ('2002', '90013');
INSERT INTO `t_call_hero` VALUES ('2002', '90017');
INSERT INTO `t_call_hero` VALUES ('2003', '82008');
INSERT INTO `t_call_hero` VALUES ('2003', '82011');
INSERT INTO `t_call_hero` VALUES ('2003', '82012');
INSERT INTO `t_call_hero` VALUES ('2003', '82013');
INSERT INTO `t_call_hero` VALUES ('2003', '82014');
INSERT INTO `t_call_hero` VALUES ('2003', '82018');
INSERT INTO `t_call_hero` VALUES ('2003', '82019');
INSERT INTO `t_call_hero` VALUES ('2003', '82027');
INSERT INTO `t_call_hero` VALUES ('2003', '82032');
INSERT INTO `t_call_hero` VALUES ('2003', '82044');
INSERT INTO `t_call_hero` VALUES ('2003', '82045');
INSERT INTO `t_call_hero` VALUES ('2003', '82046');
INSERT INTO `t_call_hero` VALUES ('2003', '82047');
INSERT INTO `t_call_hero` VALUES ('2003', '82048');
INSERT INTO `t_call_hero` VALUES ('2003', '82049');
INSERT INTO `t_call_hero` VALUES ('2003', '82050');
INSERT INTO `t_call_hero` VALUES ('2003', '82051');
INSERT INTO `t_call_hero` VALUES ('2003', '82052');
INSERT INTO `t_call_hero` VALUES ('2003', '82053');
INSERT INTO `t_call_hero` VALUES ('2003', '82054');
INSERT INTO `t_call_hero` VALUES ('2003', '82055');
INSERT INTO `t_call_hero` VALUES ('2003', '82056');
INSERT INTO `t_call_hero` VALUES ('2003', '82057');
INSERT INTO `t_call_hero` VALUES ('2003', '82058');
INSERT INTO `t_call_hero` VALUES ('2003', '82059');
INSERT INTO `t_call_hero` VALUES ('2003', '82060');
INSERT INTO `t_call_hero` VALUES ('2003', '82061');
INSERT INTO `t_call_hero` VALUES ('2003', '82062');
INSERT INTO `t_call_hero` VALUES ('2003', '82063');
INSERT INTO `t_call_hero` VALUES ('2003', '82064');
INSERT INTO `t_call_hero` VALUES ('2003', '82065');
INSERT INTO `t_call_hero` VALUES ('2003', '82066');
INSERT INTO `t_call_hero` VALUES ('2003', '82067');
INSERT INTO `t_call_hero` VALUES ('2003', '82068');
INSERT INTO `t_call_hero` VALUES ('2003', '82069');
INSERT INTO `t_call_hero` VALUES ('2003', '82070');
INSERT INTO `t_call_hero` VALUES ('2003', '82071');
INSERT INTO `t_call_hero` VALUES ('2003', '82072');
INSERT INTO `t_call_hero` VALUES ('2003', '82073');
INSERT INTO `t_call_hero` VALUES ('2003', '82074');
INSERT INTO `t_call_hero` VALUES ('2003', '82075');
INSERT INTO `t_call_hero` VALUES ('2003', '90002');
INSERT INTO `t_call_hero` VALUES ('2003', '90006');
INSERT INTO `t_call_hero` VALUES ('2003', '90010');
INSERT INTO `t_call_hero` VALUES ('2003', '90014');
INSERT INTO `t_call_hero` VALUES ('2003', '90018');
INSERT INTO `t_call_hero` VALUES ('3001', '82015');
INSERT INTO `t_call_hero` VALUES ('3001', '82016');
INSERT INTO `t_call_hero` VALUES ('3001', '82017');
INSERT INTO `t_call_hero` VALUES ('3001', '82020');
INSERT INTO `t_call_hero` VALUES ('3001', '82021');
INSERT INTO `t_call_hero` VALUES ('3001', '82028');
INSERT INTO `t_call_hero` VALUES ('3001', '82029');
INSERT INTO `t_call_hero` VALUES ('3001', '82041');
INSERT INTO `t_call_hero` VALUES ('3001', '82042');
INSERT INTO `t_call_hero` VALUES ('0', '82043');
INSERT INTO `t_call_hero` VALUES ('3001', '90001');
INSERT INTO `t_call_hero` VALUES ('3001', '90005');
INSERT INTO `t_call_hero` VALUES ('3001', '90009');
INSERT INTO `t_call_hero` VALUES ('3001', '90013');
INSERT INTO `t_call_hero` VALUES ('3001', '90017');
INSERT INTO `t_call_hero` VALUES ('3002', '82008');
INSERT INTO `t_call_hero` VALUES ('3002', '82011');
INSERT INTO `t_call_hero` VALUES ('3002', '82012');
INSERT INTO `t_call_hero` VALUES ('3002', '82013');
INSERT INTO `t_call_hero` VALUES ('3002', '82014');
INSERT INTO `t_call_hero` VALUES ('3002', '82018');
INSERT INTO `t_call_hero` VALUES ('3002', '82019');
INSERT INTO `t_call_hero` VALUES ('3002', '82027');
INSERT INTO `t_call_hero` VALUES ('3002', '82032');
INSERT INTO `t_call_hero` VALUES ('3002', '82044');
INSERT INTO `t_call_hero` VALUES ('3002', '82045');
INSERT INTO `t_call_hero` VALUES ('3002', '82046');
INSERT INTO `t_call_hero` VALUES ('3002', '82047');
INSERT INTO `t_call_hero` VALUES ('3002', '82048');
INSERT INTO `t_call_hero` VALUES ('3002', '82049');
INSERT INTO `t_call_hero` VALUES ('3002', '82050');
INSERT INTO `t_call_hero` VALUES ('3002', '82051');
INSERT INTO `t_call_hero` VALUES ('3002', '82052');
INSERT INTO `t_call_hero` VALUES ('3002', '82053');
INSERT INTO `t_call_hero` VALUES ('3002', '82054');
INSERT INTO `t_call_hero` VALUES ('3002', '82055');
INSERT INTO `t_call_hero` VALUES ('3002', '82056');
INSERT INTO `t_call_hero` VALUES ('3002', '82057');
INSERT INTO `t_call_hero` VALUES ('3002', '82058');
INSERT INTO `t_call_hero` VALUES ('3002', '82059');
INSERT INTO `t_call_hero` VALUES ('3002', '82060');
INSERT INTO `t_call_hero` VALUES ('3002', '82061');
INSERT INTO `t_call_hero` VALUES ('3002', '82062');
INSERT INTO `t_call_hero` VALUES ('3002', '82063');
INSERT INTO `t_call_hero` VALUES ('3002', '82064');
INSERT INTO `t_call_hero` VALUES ('3002', '82065');
INSERT INTO `t_call_hero` VALUES ('3002', '82066');
INSERT INTO `t_call_hero` VALUES ('3002', '82067');
INSERT INTO `t_call_hero` VALUES ('3002', '82068');
INSERT INTO `t_call_hero` VALUES ('3002', '82069');
INSERT INTO `t_call_hero` VALUES ('3002', '82070');
INSERT INTO `t_call_hero` VALUES ('3002', '82071');
INSERT INTO `t_call_hero` VALUES ('3002', '82072');
INSERT INTO `t_call_hero` VALUES ('3002', '82073');
INSERT INTO `t_call_hero` VALUES ('3002', '82074');
INSERT INTO `t_call_hero` VALUES ('3002', '82075');
INSERT INTO `t_call_hero` VALUES ('3002', '90002');
INSERT INTO `t_call_hero` VALUES ('3002', '90006');
INSERT INTO `t_call_hero` VALUES ('3002', '90010');
INSERT INTO `t_call_hero` VALUES ('3002', '90014');
INSERT INTO `t_call_hero` VALUES ('3002', '90018');
INSERT INTO `t_call_hero` VALUES ('3003', '82004');
INSERT INTO `t_call_hero` VALUES ('3003', '82006');
INSERT INTO `t_call_hero` VALUES ('3003', '82030');
INSERT INTO `t_call_hero` VALUES ('3003', '82031');
INSERT INTO `t_call_hero` VALUES ('3003', '82035');
INSERT INTO `t_call_hero` VALUES ('3003', '82036');
INSERT INTO `t_call_hero` VALUES ('3003', '82037');
INSERT INTO `t_call_hero` VALUES ('3003', '82038');
INSERT INTO `t_call_hero` VALUES ('3003', '82040');
INSERT INTO `t_call_hero` VALUES ('3003', '90003');
INSERT INTO `t_call_hero` VALUES ('3003', '90007');
INSERT INTO `t_call_hero` VALUES ('3003', '90011');
INSERT INTO `t_call_hero` VALUES ('3003', '90015');
INSERT INTO `t_call_hero` VALUES ('3003', '90019');
INSERT INTO `t_call_hero` VALUES ('3004', '82003');
INSERT INTO `t_call_hero` VALUES ('3004', '82005');
INSERT INTO `t_call_hero` VALUES ('3004', '82009');
INSERT INTO `t_call_hero` VALUES ('3004', '82010');
INSERT INTO `t_call_hero` VALUES ('3004', '82022');
INSERT INTO `t_call_hero` VALUES ('3004', '82024');
INSERT INTO `t_call_hero` VALUES ('3004', '82025');
INSERT INTO `t_call_hero` VALUES ('3004', '82026');
INSERT INTO `t_call_hero` VALUES ('3004', '82039');
INSERT INTO `t_call_hero` VALUES ('3004', '90004');
INSERT INTO `t_call_hero` VALUES ('3004', '90008');
INSERT INTO `t_call_hero` VALUES ('3004', '90012');
INSERT INTO `t_call_hero` VALUES ('3004', '90016');
INSERT INTO `t_call_hero` VALUES ('3004', '90020');
INSERT INTO `t_call_hero` VALUES ('4001', '82008');
INSERT INTO `t_call_hero` VALUES ('4001', '82011');
INSERT INTO `t_call_hero` VALUES ('4001', '82012');
INSERT INTO `t_call_hero` VALUES ('4001', '82013');
INSERT INTO `t_call_hero` VALUES ('4001', '82014');
INSERT INTO `t_call_hero` VALUES ('4001', '82018');
INSERT INTO `t_call_hero` VALUES ('4001', '82019');
INSERT INTO `t_call_hero` VALUES ('4001', '82027');
INSERT INTO `t_call_hero` VALUES ('4001', '82032');
INSERT INTO `t_call_hero` VALUES ('4001', '82044');
INSERT INTO `t_call_hero` VALUES ('4001', '82045');
INSERT INTO `t_call_hero` VALUES ('4001', '82046');
INSERT INTO `t_call_hero` VALUES ('4001', '82047');
INSERT INTO `t_call_hero` VALUES ('4001', '82048');
INSERT INTO `t_call_hero` VALUES ('4001', '82049');
INSERT INTO `t_call_hero` VALUES ('4001', '82050');
INSERT INTO `t_call_hero` VALUES ('4001', '82051');
INSERT INTO `t_call_hero` VALUES ('4001', '82052');
INSERT INTO `t_call_hero` VALUES ('4001', '82053');
INSERT INTO `t_call_hero` VALUES ('4001', '82054');
INSERT INTO `t_call_hero` VALUES ('4001', '82055');
INSERT INTO `t_call_hero` VALUES ('4001', '82056');
INSERT INTO `t_call_hero` VALUES ('4001', '82057');
INSERT INTO `t_call_hero` VALUES ('4001', '82058');
INSERT INTO `t_call_hero` VALUES ('4001', '82059');
INSERT INTO `t_call_hero` VALUES ('4001', '82060');
INSERT INTO `t_call_hero` VALUES ('4001', '82061');
INSERT INTO `t_call_hero` VALUES ('4001', '82062');
INSERT INTO `t_call_hero` VALUES ('4001', '82063');
INSERT INTO `t_call_hero` VALUES ('4001', '82064');
INSERT INTO `t_call_hero` VALUES ('4001', '82065');
INSERT INTO `t_call_hero` VALUES ('4001', '82066');
INSERT INTO `t_call_hero` VALUES ('4001', '82067');
INSERT INTO `t_call_hero` VALUES ('4001', '82068');
INSERT INTO `t_call_hero` VALUES ('4001', '82069');
INSERT INTO `t_call_hero` VALUES ('4001', '82070');
INSERT INTO `t_call_hero` VALUES ('4001', '82071');
INSERT INTO `t_call_hero` VALUES ('4001', '82072');
INSERT INTO `t_call_hero` VALUES ('4001', '82073');
INSERT INTO `t_call_hero` VALUES ('4001', '82074');
INSERT INTO `t_call_hero` VALUES ('4001', '82075');
INSERT INTO `t_call_hero` VALUES ('4001', '90002');
INSERT INTO `t_call_hero` VALUES ('4001', '90006');
INSERT INTO `t_call_hero` VALUES ('4001', '90010');
INSERT INTO `t_call_hero` VALUES ('4001', '90014');
INSERT INTO `t_call_hero` VALUES ('4001', '90018');
INSERT INTO `t_call_hero` VALUES ('4002', '82004');
INSERT INTO `t_call_hero` VALUES ('4002', '82006');
INSERT INTO `t_call_hero` VALUES ('4002', '82030');
INSERT INTO `t_call_hero` VALUES ('4002', '82031');
INSERT INTO `t_call_hero` VALUES ('4002', '82035');
INSERT INTO `t_call_hero` VALUES ('4002', '82036');
INSERT INTO `t_call_hero` VALUES ('4002', '82037');
INSERT INTO `t_call_hero` VALUES ('4002', '82038');
INSERT INTO `t_call_hero` VALUES ('4002', '90003');
INSERT INTO `t_call_hero` VALUES ('4002', '90007');
INSERT INTO `t_call_hero` VALUES ('4002', '90011');
INSERT INTO `t_call_hero` VALUES ('4002', '90015');
INSERT INTO `t_call_hero` VALUES ('4002', '90019');
INSERT INTO `t_call_hero` VALUES ('4003', '82040');
INSERT INTO `t_call_hero` VALUES ('4003', '82003');
INSERT INTO `t_call_hero` VALUES ('4003', '82005');
INSERT INTO `t_call_hero` VALUES ('4003', '82009');
INSERT INTO `t_call_hero` VALUES ('4003', '82010');
INSERT INTO `t_call_hero` VALUES ('4003', '82022');
INSERT INTO `t_call_hero` VALUES ('4003', '82024');
INSERT INTO `t_call_hero` VALUES ('4003', '82025');
INSERT INTO `t_call_hero` VALUES ('4003', '82026');
INSERT INTO `t_call_hero` VALUES ('4003', '82039');
INSERT INTO `t_call_hero` VALUES ('4003', '90004');
INSERT INTO `t_call_hero` VALUES ('4003', '90008');
INSERT INTO `t_call_hero` VALUES ('4003', '90012');
INSERT INTO `t_call_hero` VALUES ('4003', '90016');
INSERT INTO `t_call_hero` VALUES ('4003', '90020');
INSERT INTO `t_call_hero` VALUES ('4004', '82039');

-- ----------------------------
-- Table structure for t_call_hero_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_call_hero_rule`;
CREATE TABLE `t_call_hero_rule` (
  `array_id` int(11) NOT NULL COMMENT '召唤ID',
  `type` int(11) NOT NULL COMMENT '召唤类型',
  `rate` int(11) NOT NULL COMMENT '概率'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_call_hero_rule
-- ----------------------------
INSERT INTO `t_call_hero_rule` VALUES ('1001', '3', '7000');
INSERT INTO `t_call_hero_rule` VALUES ('1002', '3', '3000');
INSERT INTO `t_call_hero_rule` VALUES ('2001', '1', '4500');
INSERT INTO `t_call_hero_rule` VALUES ('2002', '1', '4500');
INSERT INTO `t_call_hero_rule` VALUES ('2003', '1', '1000');
INSERT INTO `t_call_hero_rule` VALUES ('3001', '4', '4500');
INSERT INTO `t_call_hero_rule` VALUES ('3002', '4', '3500');
INSERT INTO `t_call_hero_rule` VALUES ('3003', '4', '1500');
INSERT INTO `t_call_hero_rule` VALUES ('3004', '4', '500');
INSERT INTO `t_call_hero_rule` VALUES ('4001', '2', '4500');
INSERT INTO `t_call_hero_rule` VALUES ('4002', '2', '3500');
INSERT INTO `t_call_hero_rule` VALUES ('4003', '2', '2000');
INSERT INTO `t_call_hero_rule` VALUES ('4004', '2', '0');

-- ----------------------------
-- Table structure for t_common_reward
-- ----------------------------
DROP TABLE IF EXISTS `t_common_reward`;
CREATE TABLE `t_common_reward` (
  `n_id` int(11) NOT NULL COMMENT '自增长id',
  `n_tips` varchar(128) NOT NULL COMMENT '说明',
  `n_gain` int(11) NOT NULL COMMENT '获得方式',
  `n_reset` int(11) NOT NULL COMMENT '是否重置',
  `n_type` int(11) NOT NULL COMMENT '类型',
  `n_group` int(11) NOT NULL COMMENT '分组',
  `n_conditions` varchar(50) NOT NULL COMMENT '条件',
  `n_items` varchar(512) NOT NULL COMMENT '获得道具'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_common_reward
-- ----------------------------
INSERT INTO `t_common_reward` VALUES ('101', 'vip每日获得', '1', '1', '1', '1', '2_1', '4_4020012_1_0');

-- ----------------------------
-- Table structure for t_constant
-- ----------------------------
DROP TABLE IF EXISTS `t_constant`;
CREATE TABLE `t_constant` (
  `n_id` int(11) NOT NULL COMMENT '自增长id',
  `n_module` varchar(50) NOT NULL COMMENT '应用模块',
  `n_name` varchar(128) NOT NULL COMMENT '字段名称',
  `n_value` int(11) NOT NULL COMMENT '数量值',
  `n_tips` varchar(128) NOT NULL COMMENT '描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_constant
-- ----------------------------
INSERT INTO `t_constant` VALUES ('1', '好友', 'FRIEND_MAX_FRIEND_COUNT', '10', '最大好友数');
INSERT INTO `t_constant` VALUES ('2', '公会', 'GUILD_CREATE_GOLD_PRICE', '100000', '金币创建公会消耗');
INSERT INTO `t_constant` VALUES ('3', '公会', 'GUILD_CREATE_DIAMOND_PRICE', '100', '钻石创建公会消耗');
INSERT INTO `t_constant` VALUES ('4', '公会', 'GUILD_AMEND_NAME_DIAMOND', '500', '修改公会名称消耗钻石');
INSERT INTO `t_constant` VALUES ('5', '商店', 'MALL_REFRESH_BLACK_MARKET', '50', '刷新黑市钻石消耗');
INSERT INTO `t_constant` VALUES ('6', '技能', 'SKILL_MAX_LEVEL', '4', '技能最高等级');
INSERT INTO `t_constant` VALUES ('7', '玩家', 'USER_INIT_GOLD', '1000000', '玩家初始金币');
INSERT INTO `t_constant` VALUES ('8', '玩家', 'USER_INIT_DIAMOND', '1000000', '玩家初始钻石');
INSERT INTO `t_constant` VALUES ('9', '玩家', 'USER_INIT_GP', '1000000', '玩家初始灵值');
INSERT INTO `t_constant` VALUES ('10', '玩家', 'USER_INIT_CHARGE_DIAMOND', '10000', '玩家初始累计充值');
INSERT INTO `t_constant` VALUES ('11', '玩家', 'USER_REGAIN_STAMINA_TIME', '360000', '体力恢复所需时间(秒)');
INSERT INTO `t_constant` VALUES ('12', '玩家', 'USER_MIN_LEVEL', '1', '玩家初始等级');
INSERT INTO `t_constant` VALUES ('13', '玩家', 'USER_MAX_LEVEL', '100', '玩家最大等级');
INSERT INTO `t_constant` VALUES ('14', '玩家', 'USER_BUY_GOLD_NUMBER', '50', '可购买金币次数');
INSERT INTO `t_constant` VALUES ('15', '玩家', 'USER_BUY_GOLD_GAIN', '10000', '购买金币获得');
INSERT INTO `t_constant` VALUES ('16', '玩家', 'USER_BUY_GOLD_MAX_DIAMOND', '640', '购买金币消耗钻石上限');
INSERT INTO `t_constant` VALUES ('17', '玩家', 'USER_BUY_STAMINA_NUMBER', '50', '可购买体力次数');
INSERT INTO `t_constant` VALUES ('18', '玩家', 'USER_BUY_STAMINA_GAIN', '120', '购买体力获得');
INSERT INTO `t_constant` VALUES ('19', '玩家', 'USER_BUY_STAMINA_MAX_DIAMOND', '1280', '购买体力消耗钻石上限');
INSERT INTO `t_constant` VALUES ('20', '玩家', 'USER_UP_LEVEL_GAIN_STAMINA', '60', '玩家每升1级获得体力');
INSERT INTO `t_constant` VALUES ('21', '玩家', 'USER_SIGNIN_DIAMOND', '10', '补签消耗钻石');
INSERT INTO `t_constant` VALUES ('22', '玩家', 'USER_CHANGE_NAME_DIAMOND', '10', '改名消耗钻石');
INSERT INTO `t_constant` VALUES ('23', '玩家', 'USER_MAX_HERO_CAPACITY', '80', '最大伙伴容量');
INSERT INTO `t_constant` VALUES ('24', '玩家', 'USER_MAX_EQUIPMENT_CAPACITY', '80', '最大装备容量');
INSERT INTO `t_constant` VALUES ('25', '玩家', 'USER_MAX_ETERNAL_CAPACITY', '80', '最大武魂容量');
INSERT INTO `t_constant` VALUES ('26', '玩家', 'USER_HERO_ADD_CAPACITY_PRICE', '10', '扩充背包容量单次价格(钻石)');
INSERT INTO `t_constant` VALUES ('27', '玩家', 'USER_HERO_ADD_CAPACITY_NUMBER', '5', '扩充背包容量单次格子数');
INSERT INTO `t_constant` VALUES ('28', '玩家', 'USER_BACK_PACK_LIMIT', '60', '背包格子上限');
INSERT INTO `t_constant` VALUES ('29', '副本扫荡', 'ZONE_SWEEP_PRICE', '10', '副本扫荡一次钻石消耗');
INSERT INTO `t_constant` VALUES ('30', '竞技场', 'ARENA_DAILY_NUMBER', '5', '竞技场每日挑战次数');
INSERT INTO `t_constant` VALUES ('31', '竞技场', 'ARENA_BUY_NUMBER_ADD', '5', '购买一次竞技场挑战次数获得数量');
INSERT INTO `t_constant` VALUES ('32', '竞技场', 'ARENA_BUY_NUMBER', '5', '可购买竞技场挑战次数');
INSERT INTO `t_constant` VALUES ('33', '竞技场', 'ARENA_MAX_NUMBER', '99', '竞技场可挑战次数上限');
INSERT INTO `t_constant` VALUES ('34', '竞技场', 'ARENA_MALL_REFRESH_NUMBER', '5', '竞技场商店可刷新次数');
INSERT INTO `t_constant` VALUES ('35', '竞技场', 'ARENA_CLEAR_CD_DIAMOND', '50', '清除冷却CD所需钻石');
INSERT INTO `t_constant` VALUES ('36', '竞技场', 'ARENA_WIN_AWARD_VALOUR', '10', '竞技场获胜获得勇气值');
INSERT INTO `t_constant` VALUES ('37', '竞技场', 'ARENA_OPEN_LEVEL', '15', '竞技场开放等级');
INSERT INTO `t_constant` VALUES ('38', '武道大会', 'MARTIAL_WAY_WIN_SCORE', '15', '武道会胜利积分');
INSERT INTO `t_constant` VALUES ('39', '武道大会', 'MARTIAL_WAY_LOSE_SCORE', '5', '武道会失败积分');
INSERT INTO `t_constant` VALUES ('40', '武道大会', 'MARTIAL_WAY_OPEN_LEVEL', '20', '武道大会开放等级');
INSERT INTO `t_constant` VALUES ('41', '武道大会', 'MARTIAL_WAY_DAILY_NUMBER', '5', '武道大会每日参加次数');
INSERT INTO `t_constant` VALUES ('42', '武道大会', 'MARTIAL_WAY_BUY_GAIN_NUMBER', '5', '武道大会购买获得次数');
INSERT INTO `t_constant` VALUES ('43', '武道大会', 'MARTIAL_WAY_MAX_BUY_NUMBER', '10', '武道大会最大购买次数');
INSERT INTO `t_constant` VALUES ('44', '伙伴', 'HERO_CALL_ONE_GOLD', '10000', '金币召唤一次伙伴消耗');
INSERT INTO `t_constant` VALUES ('45', '伙伴', 'HERO_CALL_TEN_GOLD', '100000', '金币召唤十次伙伴消耗');
INSERT INTO `t_constant` VALUES ('46', '伙伴', 'HERO_CALL_ONE_DIAMOND', '288', '钻石召唤一次伙伴消耗');
INSERT INTO `t_constant` VALUES ('47', '伙伴', 'HERO_CALL_GOLD_FREE', '3', '免费金币召唤次数');
INSERT INTO `t_constant` VALUES ('48', '伙伴', 'HERO_CALL_GOLD_FREE_CD', '1800', '免费金币召唤次数CD(秒)');
INSERT INTO `t_constant` VALUES ('49', '伙伴', 'HERO_CALL_DIAMOND_FREE_CD', '172800', '免费钻石召唤次数CD（秒）');
INSERT INTO `t_constant` VALUES ('50', '伙伴', 'HERO_CALL_TEN_DIAMOND', '2800', '钻石召唤十次伙伴消耗');
INSERT INTO `t_constant` VALUES ('51', '伙伴', 'HERO_FIRST_DIAMOND_CALL_ID', '82008', '首次钻石召唤伙伴id');
INSERT INTO `t_constant` VALUES ('52', '包子铺', 'TRIALS_BREAD_STORE_REFRESH_NUMBER', '5', '包子铺免费刷新次数');
INSERT INTO `t_constant` VALUES ('53', '包子铺', 'TRIALS_BREAD_STORE_DIAMOND_REFRESH_PRICE', '50', '包子铺钻石刷新价格');
INSERT INTO `t_constant` VALUES ('54', '包子铺', 'TRIALS_BREAD_STORE_DIAMOND_ELEMENT_PROBABILITY', '2000', '包子铺元素概率(10000表示100%)');

-- ----------------------------
-- Table structure for t_drop
-- ----------------------------
DROP TABLE IF EXISTS `t_drop`;
CREATE TABLE `t_drop` (
  `monsterId` int(11) NOT NULL COMMENT '怪物ID',
  `dropItems` varchar(5120) NOT NULL COMMENT '掉落物品'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_drop
-- ----------------------------
INSERT INTO `t_drop` VALUES ('2001001', '10000#1#8_0_10_0_9000&5000#1#2_0_50_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001002', '10000#1#4_4023101_5_1_10000');
INSERT INTO `t_drop` VALUES ('2001003', '10000#1#8_0_30_0_9000&5000#1#2_0_150_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001004', '10000#1#8_0_40_0_9000&5000#1#2_0_200_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001005', '10000#1#8_0_50_0_9000&5000#1#2_0_250_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001006', '10000#1#8_0_60_0_9000&5000#1#2_0_300_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001007', '10000#1#8_0_70_0_9000&5000#1#2_0_350_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001008', '10000#1#8_0_80_0_9000&5000#1#2_0_400_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001009', '10000#1#8_0_90_0_9000&5000#1#2_0_450_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001010', '10000#1#8_0_100_0_9000&5000#1#2_0_500_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001011', '10000#1#8_0_110_0_9000&5000#1#2_0_550_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001012', '10000#1#8_0_120_0_9000&5000#1#2_0_600_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001013', '10000#1#8_0_130_0_9000&5000#1#2_0_650_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001014', '10000#1#8_0_140_0_9000&5000#1#2_0_700_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001015', '10000#1#8_0_150_0_9000&5000#1#2_0_750_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001016', '10000#1#8_0_160_0_9000&5000#1#2_0_800_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001017', '10000#1#8_0_170_0_9000&5000#1#2_0_850_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001018', '10000#1#8_0_180_0_9000&5000#1#2_0_900_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001019', '10000#1#8_0_190_0_9000&5000#1#2_0_950_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001020', '10000#1#8_0_200_0_9000&5000#1#2_0_1000_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001021', '10000#1#8_0_210_0_9000&5000#1#2_0_1050_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001022', '10000#1#8_0_220_0_9000&5000#1#2_0_1100_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001023', '10000#1#8_0_230_0_9000&5000#1#2_0_1150_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001024', '10000#1#8_0_240_0_9000&5000#1#2_0_1200_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001025', '10000#1#8_0_250_0_9000&5000#1#2_0_1250_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001026', '10000#1#8_0_260_0_9000&5000#1#2_0_1300_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001027', '10000#1#8_0_270_0_9000&5000#1#2_0_1350_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001028', '10000#1#8_0_280_0_9000&5000#1#2_0_1400_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001029', '10000#1#8_0_290_0_9000&5000#1#2_0_1450_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001030', '10000#1#8_0_300_0_9000&5000#1#2_0_1500_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001031', '10000#1#8_0_310_0_9000&5000#1#2_0_1550_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001032', '10000#1#8_0_320_0_9000&5000#1#2_0_1600_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001033', '10000#1#8_0_330_0_9000&5000#1#2_0_1650_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2001034', '10000#1#8_0_340_0_9000&5000#1#2_0_1700_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002001', '10000#1#8_0_10_0_9000&5000#1#2_0_50_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002002', '10000#1#8_0_20_0_9000&5000#1#2_0_100_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002003', '10000#1#8_0_30_0_9000&5000#1#2_0_150_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002004', '10000#1#8_0_40_0_9000&5000#1#2_0_200_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002005', '10000#1#8_0_50_0_9000&5000#1#2_0_250_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002006', '10000#1#8_0_60_0_9000&5000#1#2_0_300_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002007', '10000#1#8_0_70_0_9000&5000#1#2_0_350_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002008', '10000#1#8_0_80_0_9000&5000#1#2_0_400_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002009', '10000#1#8_0_90_0_9000&5000#1#2_0_450_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002010', '10000#1#8_0_100_0_9000&5000#1#2_0_500_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002011', '10000#1#8_0_110_0_9000&5000#1#2_0_550_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002012', '10000#1#8_0_120_0_9000&5000#1#2_0_600_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002013', '10000#1#8_0_130_0_9000&5000#1#2_0_650_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002014', '10000#1#8_0_140_0_9000&5000#1#2_0_700_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002015', '10000#1#8_0_150_0_9000&5000#1#2_0_750_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002016', '10000#1#8_0_160_0_9000&5000#1#2_0_800_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002017', '10000#1#8_0_170_0_9000&5000#1#2_0_850_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002018', '10000#1#8_0_180_0_9000&5000#1#2_0_900_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002019', '10000#1#8_0_190_0_9000&5000#1#2_0_950_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002020', '10000#1#8_0_200_0_9000&5000#1#2_0_1000_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002021', '10000#1#8_0_210_0_9000&5000#1#2_0_1050_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002022', '10000#1#8_0_220_0_9000&5000#1#2_0_1100_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002023', '10000#1#8_0_230_0_9000&5000#1#2_0_1150_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002024', '10000#1#8_0_240_0_9000&5000#1#2_0_1200_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002025', '10000#1#8_0_250_0_9000&5000#1#2_0_1250_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002026', '10000#1#8_0_260_0_9000&5000#1#2_0_1300_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002027', '10000#1#8_0_270_0_9000&5000#1#2_0_1350_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002028', '10000#1#8_0_280_0_9000&5000#1#2_0_1400_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002029', '10000#1#8_0_290_0_9000&5000#1#2_0_1450_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002030', '10000#1#8_0_300_0_9000&5000#1#2_0_1500_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002031', '10000#1#8_0_310_0_9000&5000#1#2_0_1550_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002032', '10000#1#8_0_320_0_9000&5000#1#2_0_1600_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002033', '10000#1#8_0_330_0_9000&5000#1#2_0_1650_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2002034', '10000#1#8_0_340_0_9000&5000#1#2_0_1700_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003001', '10000#1#8_0_10_0_9000&5000#1#2_0_50_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003002', '10000#1#8_0_20_0_9000&5000#1#2_0_100_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003003', '10000#1#4_4023301_5_1_10000');
INSERT INTO `t_drop` VALUES ('2003004', '10000#1#8_0_40_0_9000&5000#1#2_0_200_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003005', '10000#1#8_0_50_0_9000&5000#1#2_0_250_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003006', '10000#1#8_0_60_0_9000&5000#1#2_0_300_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003007', '10000#1#8_0_70_0_9000&5000#1#2_0_350_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003008', '10000#1#8_0_80_0_9000&5000#1#2_0_400_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003009', '10000#1#8_0_90_0_9000&5000#1#2_0_450_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003010', '10000#1#8_0_100_0_9000&5000#1#2_0_500_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003011', '10000#1#8_0_110_0_9000&5000#1#2_0_550_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003012', '10000#1#8_0_120_0_9000&5000#1#2_0_600_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003013', '10000#1#8_0_130_0_9000&5000#1#2_0_650_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003014', '10000#1#8_0_140_0_9000&5000#1#2_0_700_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003015', '10000#1#8_0_150_0_9000&5000#1#2_0_750_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003016', '10000#1#8_0_160_0_9000&5000#1#2_0_800_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003017', '10000#1#8_0_170_0_9000&5000#1#2_0_850_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003018', '10000#1#8_0_180_0_9000&5000#1#2_0_900_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003019', '10000#1#8_0_190_0_9000&5000#1#2_0_950_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003020', '10000#1#8_0_200_0_9000&5000#1#2_0_1000_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003021', '10000#1#8_0_210_0_9000&5000#1#2_0_1050_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003022', '10000#1#8_0_220_0_9000&5000#1#2_0_1100_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003023', '10000#1#8_0_230_0_9000&5000#1#2_0_1150_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003024', '10000#1#8_0_240_0_9000&5000#1#2_0_1200_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003025', '10000#1#8_0_250_0_9000&5000#1#2_0_1250_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003026', '10000#1#8_0_260_0_9000&5000#1#2_0_1300_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003027', '10000#1#8_0_270_0_9000&5000#1#2_0_1350_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003028', '10000#1#8_0_280_0_9000&5000#1#2_0_1400_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003029', '10000#1#8_0_290_0_9000&5000#1#2_0_1450_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003030', '10000#1#8_0_300_0_9000&5000#1#2_0_1500_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003031', '10000#1#8_0_310_0_9000&5000#1#2_0_1550_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003032', '10000#1#8_0_320_0_9000&5000#1#2_0_1600_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003033', '10000#1#8_0_330_0_9000&5000#1#2_0_1650_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2003034', '10000#1#8_0_340_0_9000&5000#1#2_0_1700_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004001', '10000#1#8_0_10_0_9000&5000#1#2_0_50_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004002', '10000#1#4_4023201_5_1_10000');
INSERT INTO `t_drop` VALUES ('2004003', '10000#1#8_0_30_0_9000&5000#1#2_0_150_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004004', '10000#1#8_0_40_0_9000&5000#1#2_0_200_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004005', '10000#1#8_0_50_0_9000&5000#1#2_0_250_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004006', '10000#1#8_0_60_0_9000&5000#1#2_0_300_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004007', '10000#1#8_0_70_0_9000&5000#1#2_0_350_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004008', '10000#1#8_0_80_0_9000&5000#1#2_0_400_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004009', '10000#1#8_0_90_0_9000&5000#1#2_0_450_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004010', '10000#1#8_0_100_0_9000&5000#1#2_0_500_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004011', '10000#1#8_0_110_0_9000&5000#1#2_0_550_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004012', '10000#1#8_0_120_0_9000&5000#1#2_0_600_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004013', '10000#1#8_0_130_0_9000&5000#1#2_0_650_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004014', '10000#1#8_0_140_0_9000&5000#1#2_0_700_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004015', '10000#1#8_0_150_0_9000&5000#1#2_0_750_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004016', '10000#1#8_0_160_0_9000&5000#1#2_0_800_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004017', '10000#1#8_0_170_0_9000&5000#1#2_0_850_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004018', '10000#1#8_0_180_0_9000&5000#1#2_0_900_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004019', '10000#1#8_0_190_0_9000&5000#1#2_0_950_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004020', '10000#1#8_0_200_0_9000&5000#1#2_0_1000_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004021', '10000#1#8_0_210_0_9000&5000#1#2_0_1050_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004022', '10000#1#8_0_220_0_9000&5000#1#2_0_1100_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004023', '10000#1#8_0_230_0_9000&5000#1#2_0_1150_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004024', '10000#1#8_0_240_0_9000&5000#1#2_0_1200_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004025', '10000#1#8_0_250_0_9000&5000#1#2_0_1250_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004026', '10000#1#8_0_260_0_9000&5000#1#2_0_1300_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004027', '10000#1#8_0_270_0_9000&5000#1#2_0_1350_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004028', '10000#1#8_0_280_0_9000&5000#1#2_0_1400_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004029', '10000#1#8_0_290_0_9000&5000#1#2_0_1450_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004030', '10000#1#8_0_300_0_9000&5000#1#2_0_1500_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004031', '10000#1#8_0_310_0_9000&5000#1#2_0_1550_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004032', '10000#1#8_0_320_0_9000&5000#1#2_0_1600_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004033', '10000#1#8_0_330_0_9000&5000#1#2_0_1650_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2004034', '10000#1#8_0_340_0_9000&5000#1#2_0_1700_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005001', '10000#1#8_0_10_0_9000&5000#1#2_0_50_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005002', '10000#1#8_0_20_0_9000&5000#1#2_0_100_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005003', '10000#1#4_4023401_5_1_10000');
INSERT INTO `t_drop` VALUES ('2005004', '10000#1#8_0_40_0_9000&5000#1#2_0_200_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005005', '10000#1#8_0_50_0_9000&5000#1#2_0_250_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005006', '10000#1#8_0_60_0_9000&5000#1#2_0_300_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005007', '10000#1#8_0_70_0_9000&5000#1#2_0_350_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005008', '10000#1#8_0_80_0_9000&5000#1#2_0_400_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005009', '10000#1#8_0_90_0_9000&5000#1#2_0_450_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005010', '10000#1#8_0_100_0_9000&5000#1#2_0_500_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005011', '10000#1#8_0_110_0_9000&5000#1#2_0_550_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005012', '10000#1#8_0_120_0_9000&5000#1#2_0_600_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005013', '10000#1#8_0_130_0_9000&5000#1#2_0_650_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005014', '10000#1#8_0_140_0_9000&5000#1#2_0_700_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005015', '10000#1#8_0_150_0_9000&5000#1#2_0_750_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005016', '10000#1#8_0_160_0_9000&5000#1#2_0_800_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005017', '10000#1#8_0_170_0_9000&5000#1#2_0_850_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005018', '10000#1#8_0_180_0_9000&5000#1#2_0_900_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005019', '10000#1#8_0_190_0_9000&5000#1#2_0_950_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005020', '10000#1#8_0_200_0_9000&5000#1#2_0_1000_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005021', '10000#1#8_0_210_0_9000&5000#1#2_0_1050_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005022', '10000#1#8_0_220_0_9000&5000#1#2_0_1100_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005023', '10000#1#8_0_230_0_9000&5000#1#2_0_1150_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005024', '10000#1#8_0_240_0_9000&5000#1#2_0_1200_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005025', '10000#1#8_0_250_0_9000&5000#1#2_0_1250_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005026', '10000#1#8_0_260_0_9000&5000#1#2_0_1300_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005027', '10000#1#8_0_270_0_9000&5000#1#2_0_1350_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005028', '10000#1#8_0_280_0_9000&5000#1#2_0_1400_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005029', '10000#1#8_0_290_0_9000&5000#1#2_0_1450_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005030', '10000#1#8_0_300_0_9000&5000#1#2_0_1500_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005031', '10000#1#8_0_310_0_9000&5000#1#2_0_1550_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005032', '10000#1#8_0_320_0_9000&5000#1#2_0_1600_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005033', '10000#1#8_0_330_0_9000&5000#1#2_0_1650_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2005034', '10000#1#8_0_340_0_9000&5000#1#2_0_1700_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006001', '10000#1#8_0_10_0_9000&5000#1#2_0_50_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006002', '10000#1#8_0_20_0_9000&5000#1#2_0_100_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006003', '10000#1#8_0_30_0_9000&5000#1#2_0_150_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006004', '10000#1#8_0_40_0_9000&5000#1#2_0_200_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006005', '10000#1#8_0_50_0_9000&5000#1#2_0_250_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006006', '10000#1#8_0_60_0_9000&5000#1#2_0_300_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006007', '10000#1#8_0_70_0_9000&5000#1#2_0_350_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006008', '10000#1#8_0_80_0_9000&5000#1#2_0_400_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006009', '10000#1#8_0_90_0_9000&5000#1#2_0_450_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006010', '10000#1#8_0_100_0_9000&5000#1#2_0_500_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006011', '10000#1#8_0_110_0_9000&5000#1#2_0_550_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006012', '10000#1#8_0_120_0_9000&5000#1#2_0_600_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006013', '10000#1#8_0_130_0_9000&5000#1#2_0_650_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006014', '10000#1#8_0_140_0_9000&5000#1#2_0_700_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006015', '10000#1#8_0_150_0_9000&5000#1#2_0_750_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006016', '10000#1#8_0_160_0_9000&5000#1#2_0_800_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006017', '10000#1#8_0_170_0_9000&5000#1#2_0_850_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006018', '10000#1#8_0_180_0_9000&5000#1#2_0_900_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006019', '10000#1#8_0_190_0_9000&5000#1#2_0_950_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006020', '10000#1#8_0_200_0_9000&5000#1#2_0_1000_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006021', '10000#1#8_0_210_0_9000&5000#1#2_0_1050_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006022', '10000#1#8_0_220_0_9000&5000#1#2_0_1100_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006023', '10000#1#8_0_230_0_9000&5000#1#2_0_1150_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006024', '10000#1#8_0_240_0_9000&5000#1#2_0_1200_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006025', '10000#1#8_0_250_0_9000&5000#1#2_0_1250_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006026', '10000#1#8_0_260_0_9000&5000#1#2_0_1300_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006027', '10000#1#8_0_270_0_9000&5000#1#2_0_1350_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006028', '10000#1#8_0_280_0_9000&5000#1#2_0_1400_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006029', '10000#1#8_0_290_0_9000&5000#1#2_0_1450_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006030', '10000#1#8_0_300_0_9000&5000#1#2_0_1500_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006031', '10000#1#8_0_310_0_9000&5000#1#2_0_1550_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006032', '10000#1#8_0_320_0_9000&5000#1#2_0_1600_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006033', '10000#1#8_0_330_0_9000&5000#1#2_0_1650_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2006034', '10000#1#8_0_340_0_9000&5000#1#2_0_1700_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007001', '10000#1#8_0_10_0_9000&5000#1#2_0_50_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007002', '10000#1#8_0_20_0_9000&5000#1#2_0_100_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007003', '10000#1#8_0_30_0_9000&5000#1#2_0_150_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007004', '10000#1#8_0_40_0_9000&5000#1#2_0_200_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007005', '10000#1#8_0_50_0_9000&5000#1#2_0_250_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007006', '10000#1#8_0_60_0_9000&5000#1#2_0_300_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007007', '10000#1#8_0_70_0_9000&5000#1#2_0_350_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007008', '10000#1#8_0_80_0_9000&5000#1#2_0_400_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007009', '10000#1#8_0_90_0_9000&5000#1#2_0_450_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007010', '10000#1#8_0_100_0_9000&5000#1#2_0_500_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007011', '10000#1#8_0_110_0_9000&5000#1#2_0_550_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007012', '10000#1#8_0_120_0_9000&5000#1#2_0_600_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007013', '10000#1#8_0_130_0_9000&5000#1#2_0_650_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007014', '10000#1#8_0_140_0_9000&5000#1#2_0_700_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007015', '10000#1#8_0_150_0_9000&5000#1#2_0_750_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007016', '10000#1#8_0_160_0_9000&5000#1#2_0_800_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007017', '10000#1#8_0_170_0_9000&5000#1#2_0_850_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007018', '10000#1#8_0_180_0_9000&5000#1#2_0_900_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007019', '10000#1#8_0_190_0_9000&5000#1#2_0_950_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007020', '10000#1#8_0_200_0_9000&5000#1#2_0_1000_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007021', '10000#1#8_0_210_0_9000&5000#1#2_0_1050_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007022', '10000#1#8_0_220_0_9000&5000#1#2_0_1100_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007023', '10000#1#8_0_230_0_9000&5000#1#2_0_1150_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007024', '10000#1#8_0_240_0_9000&5000#1#2_0_1200_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007025', '10000#1#8_0_250_0_9000&5000#1#2_0_1250_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007026', '10000#1#8_0_260_0_9000&5000#1#2_0_1300_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007027', '10000#1#8_0_270_0_9000&5000#1#2_0_1350_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007028', '10000#1#8_0_280_0_9000&5000#1#2_0_1400_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007029', '10000#1#8_0_290_0_9000&5000#1#2_0_1450_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007030', '10000#1#8_0_300_0_9000&5000#1#2_0_1500_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007031', '10000#1#8_0_310_0_9000&5000#1#2_0_1550_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007032', '10000#1#8_0_320_0_9000&5000#1#2_0_1600_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007033', '10000#1#8_0_330_0_9000&5000#1#2_0_1650_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2007034', '10000#1#8_0_340_0_9000&5000#1#2_0_1700_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008001', '10000#1#8_0_10_0_9000&5000#1#2_0_50_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008002', '10000#1#8_0_20_0_9000&5000#1#2_0_100_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008003', '10000#1#8_0_30_0_9000&5000#1#2_0_150_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008004', '10000#1#8_0_40_0_9000&5000#1#2_0_200_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008005', '10000#1#8_0_50_0_9000&5000#1#2_0_250_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008006', '10000#1#8_0_60_0_9000&5000#1#2_0_300_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008007', '10000#1#8_0_70_0_9000&5000#1#2_0_350_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008008', '10000#1#8_0_80_0_9000&5000#1#2_0_400_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008009', '10000#1#8_0_90_0_9000&5000#1#2_0_450_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008010', '10000#1#8_0_100_0_9000&5000#1#2_0_500_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008011', '10000#1#8_0_110_0_9000&5000#1#2_0_550_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008012', '10000#1#8_0_120_0_9000&5000#1#2_0_600_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008013', '10000#1#8_0_130_0_9000&5000#1#2_0_650_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008014', '10000#1#8_0_140_0_9000&5000#1#2_0_700_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008015', '10000#1#8_0_150_0_9000&5000#1#2_0_750_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008016', '10000#1#8_0_160_0_9000&5000#1#2_0_800_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008017', '10000#1#8_0_170_0_9000&5000#1#2_0_850_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008018', '10000#1#8_0_180_0_9000&5000#1#2_0_900_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008019', '10000#1#8_0_190_0_9000&5000#1#2_0_950_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008020', '10000#1#8_0_200_0_9000&5000#1#2_0_1000_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008021', '10000#1#8_0_210_0_9000&5000#1#2_0_1050_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008022', '10000#1#8_0_220_0_9000&5000#1#2_0_1100_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008023', '10000#1#8_0_230_0_9000&5000#1#2_0_1150_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008024', '10000#1#8_0_240_0_9000&5000#1#2_0_1200_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008025', '10000#1#8_0_250_0_9000&5000#1#2_0_1250_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008026', '10000#1#8_0_260_0_9000&5000#1#2_0_1300_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008027', '10000#1#8_0_270_0_9000&5000#1#2_0_1350_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008028', '10000#1#8_0_280_0_9000&5000#1#2_0_1400_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008029', '10000#1#8_0_290_0_9000&5000#1#2_0_1450_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008030', '10000#1#8_0_300_0_9000&5000#1#2_0_1500_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008031', '10000#1#8_0_310_0_9000&5000#1#2_0_1550_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008032', '10000#1#8_0_320_0_9000&5000#1#2_0_1600_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008033', '10000#1#8_0_330_0_9000&5000#1#2_0_1650_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2008034', '10000#1#8_0_340_0_9000&5000#1#2_0_1700_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009001', '10000#1#8_0_10_0_9000&5000#1#2_0_50_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009002', '10000#1#8_0_20_0_9000&5000#1#2_0_100_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009003', '10000#1#8_0_30_0_9000&5000#1#2_0_150_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009004', '10000#1#8_0_40_0_9000&5000#1#2_0_200_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009005', '10000#1#8_0_50_0_9000&5000#1#2_0_250_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009006', '10000#1#8_0_60_0_9000&5000#1#2_0_300_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009007', '10000#1#8_0_70_0_9000&5000#1#2_0_350_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009008', '10000#1#8_0_80_0_9000&5000#1#2_0_400_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009009', '10000#1#8_0_90_0_9000&5000#1#2_0_450_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009010', '10000#1#8_0_100_0_9000&5000#1#2_0_500_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009011', '10000#1#8_0_110_0_9000&5000#1#2_0_550_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009012', '10000#1#8_0_120_0_9000&5000#1#2_0_600_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009013', '10000#1#8_0_130_0_9000&5000#1#2_0_650_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009014', '10000#1#8_0_140_0_9000&5000#1#2_0_700_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009015', '10000#1#8_0_150_0_9000&5000#1#2_0_750_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009016', '10000#1#8_0_160_0_9000&5000#1#2_0_800_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009017', '10000#1#8_0_170_0_9000&5000#1#2_0_850_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009018', '10000#1#8_0_180_0_9000&5000#1#2_0_900_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009019', '10000#1#8_0_190_0_9000&5000#1#2_0_950_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009020', '10000#1#8_0_200_0_9000&5000#1#2_0_1000_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009021', '10000#1#8_0_210_0_9000&5000#1#2_0_1050_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009022', '10000#1#8_0_220_0_9000&5000#1#2_0_1100_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009023', '10000#1#8_0_230_0_9000&5000#1#2_0_1150_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009024', '10000#1#8_0_240_0_9000&5000#1#2_0_1200_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009025', '10000#1#8_0_250_0_9000&5000#1#2_0_1250_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009026', '10000#1#8_0_260_0_9000&5000#1#2_0_1300_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009027', '10000#1#8_0_270_0_9000&5000#1#2_0_1350_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009028', '10000#1#8_0_280_0_9000&5000#1#2_0_1400_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009029', '10000#1#8_0_290_0_9000&5000#1#2_0_1450_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009030', '10000#1#8_0_300_0_9000&5000#1#2_0_1500_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009031', '10000#1#8_0_310_0_9000&5000#1#2_0_1550_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009032', '10000#1#8_0_320_0_9000&5000#1#2_0_1600_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009033', '10000#1#8_0_330_0_9000&5000#1#2_0_1650_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2009034', '10000#1#8_0_340_0_9000&5000#1#2_0_1700_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010001', '10000#1#8_0_10_0_9000&5000#1#2_0_50_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010002', '10000#1#8_0_20_0_9000&5000#1#2_0_100_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010003', '10000#1#8_0_30_0_9000&5000#1#2_0_150_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010004', '10000#1#8_0_40_0_9000&5000#1#2_0_200_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010005', '10000#1#8_0_50_0_9000&5000#1#2_0_250_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010006', '10000#1#8_0_60_0_9000&5000#1#2_0_300_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010007', '10000#1#8_0_70_0_9000&5000#1#2_0_350_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010008', '10000#1#8_0_80_0_9000&5000#1#2_0_400_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010009', '10000#1#8_0_90_0_9000&5000#1#2_0_450_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010010', '10000#1#8_0_100_0_9000&5000#1#2_0_500_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010011', '10000#1#8_0_110_0_9000&5000#1#2_0_550_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010012', '10000#1#8_0_120_0_9000&5000#1#2_0_600_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010013', '10000#1#8_0_130_0_9000&5000#1#2_0_650_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010014', '10000#1#8_0_140_0_9000&5000#1#2_0_700_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010015', '10000#1#8_0_150_0_9000&5000#1#2_0_750_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010016', '10000#1#8_0_160_0_9000&5000#1#2_0_800_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010017', '10000#1#8_0_170_0_9000&5000#1#2_0_850_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010018', '10000#1#8_0_180_0_9000&5000#1#2_0_900_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010019', '10000#1#8_0_190_0_9000&5000#1#2_0_950_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010020', '10000#1#8_0_200_0_9000&5000#1#2_0_1000_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010021', '10000#1#8_0_210_0_9000&5000#1#2_0_1050_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010022', '10000#1#8_0_220_0_9000&5000#1#2_0_1100_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010023', '10000#1#8_0_230_0_9000&5000#1#2_0_1150_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010024', '10000#1#8_0_240_0_9000&5000#1#2_0_1200_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010025', '10000#1#8_0_250_0_9000&5000#1#2_0_1250_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010026', '10000#1#8_0_260_0_9000&5000#1#2_0_1300_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010027', '10000#1#8_0_270_0_9000&5000#1#2_0_1350_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010028', '10000#1#8_0_280_0_9000&5000#1#2_0_1400_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010029', '10000#1#8_0_290_0_9000&5000#1#2_0_1450_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010030', '10000#1#8_0_300_0_9000&5000#1#2_0_1500_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010031', '10000#1#8_0_310_0_9000&5000#1#2_0_1550_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010032', '10000#1#8_0_320_0_9000&5000#1#2_0_1600_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010033', '10000#1#8_0_330_0_9000&5000#1#2_0_1650_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2010034', '10000#1#8_0_340_0_9000&5000#1#2_0_1700_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011001', '10000#1#8_0_10_0_9000&5000#1#2_0_50_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011002', '10000#1#8_0_20_0_9000&5000#1#2_0_100_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011003', '10000#1#8_0_30_0_9000&5000#1#2_0_150_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011004', '10000#1#8_0_40_0_9000&5000#1#2_0_200_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011005', '10000#1#8_0_50_0_9000&5000#1#2_0_250_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011006', '10000#1#8_0_60_0_9000&5000#1#2_0_300_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011007', '10000#1#8_0_70_0_9000&5000#1#2_0_350_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011008', '10000#1#8_0_80_0_9000&5000#1#2_0_400_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011009', '10000#1#8_0_90_0_9000&5000#1#2_0_450_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011010', '10000#1#8_0_100_0_9000&5000#1#2_0_500_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011011', '10000#1#8_0_110_0_9000&5000#1#2_0_550_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011012', '10000#1#8_0_120_0_9000&5000#1#2_0_600_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011013', '10000#1#8_0_130_0_9000&5000#1#2_0_650_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011014', '10000#1#8_0_140_0_9000&5000#1#2_0_700_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011015', '10000#1#8_0_150_0_9000&5000#1#2_0_750_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011016', '10000#1#8_0_160_0_9000&5000#1#2_0_800_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011017', '10000#1#8_0_170_0_9000&5000#1#2_0_850_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011018', '10000#1#8_0_180_0_9000&5000#1#2_0_900_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011019', '10000#1#8_0_190_0_9000&5000#1#2_0_950_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011020', '10000#1#8_0_200_0_9000&5000#1#2_0_1000_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011021', '10000#1#8_0_210_0_9000&5000#1#2_0_1050_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011022', '10000#1#8_0_220_0_9000&5000#1#2_0_1100_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011023', '10000#1#8_0_230_0_9000&5000#1#2_0_1150_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011024', '10000#1#8_0_240_0_9000&5000#1#2_0_1200_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011025', '10000#1#8_0_250_0_9000&5000#1#2_0_1250_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011026', '10000#1#8_0_260_0_9000&5000#1#2_0_1300_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011027', '10000#1#8_0_270_0_9000&5000#1#2_0_1350_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011028', '10000#1#8_0_280_0_9000&5000#1#2_0_1400_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011029', '10000#1#8_0_290_0_9000&5000#1#2_0_1450_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011030', '10000#1#8_0_300_0_9000&5000#1#2_0_1500_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011031', '10000#1#8_0_310_0_9000&5000#1#2_0_1550_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011032', '10000#1#8_0_320_0_9000&5000#1#2_0_1600_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011033', '10000#1#8_0_330_0_9000&5000#1#2_0_1650_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2011034', '10000#1#8_0_340_0_9000&5000#1#2_0_1700_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012001', '10000#1#8_0_10_0_9000&5000#1#2_0_50_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012002', '10000#1#8_0_20_0_9000&5000#1#2_0_100_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012003', '10000#1#8_0_30_0_9000&5000#1#2_0_150_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012004', '10000#1#8_0_40_0_9000&5000#1#2_0_200_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012005', '10000#1#8_0_50_0_9000&5000#1#2_0_250_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012006', '10000#1#8_0_60_0_9000&5000#1#2_0_300_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012007', '10000#1#8_0_70_0_9000&5000#1#2_0_350_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012008', '10000#1#8_0_80_0_9000&5000#1#2_0_400_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012009', '10000#1#8_0_90_0_9000&5000#1#2_0_450_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012010', '10000#1#8_0_100_0_9000&5000#1#2_0_500_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012011', '10000#1#8_0_110_0_9000&5000#1#2_0_550_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012012', '10000#1#8_0_120_0_9000&5000#1#2_0_600_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012013', '10000#1#8_0_130_0_9000&5000#1#2_0_650_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012014', '10000#1#8_0_140_0_9000&5000#1#2_0_700_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012015', '10000#1#8_0_150_0_9000&5000#1#2_0_750_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012016', '10000#1#8_0_160_0_9000&5000#1#2_0_800_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012017', '10000#1#8_0_170_0_9000&5000#1#2_0_850_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012018', '10000#1#8_0_180_0_9000&5000#1#2_0_900_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012019', '10000#1#8_0_190_0_9000&5000#1#2_0_950_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012020', '10000#1#8_0_200_0_9000&5000#1#2_0_1000_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012021', '10000#1#8_0_210_0_9000&5000#1#2_0_1050_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012022', '10000#1#8_0_220_0_9000&5000#1#2_0_1100_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012023', '10000#1#8_0_230_0_9000&5000#1#2_0_1150_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012024', '10000#1#8_0_240_0_9000&5000#1#2_0_1200_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012025', '10000#1#8_0_250_0_9000&5000#1#2_0_1250_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012026', '10000#1#8_0_260_0_9000&5000#1#2_0_1300_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012027', '10000#1#8_0_270_0_9000&5000#1#2_0_1350_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012028', '10000#1#8_0_280_0_9000&5000#1#2_0_1400_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012029', '10000#1#8_0_290_0_9000&5000#1#2_0_1450_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012030', '10000#1#8_0_300_0_9000&5000#1#2_0_1500_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012031', '10000#1#8_0_310_0_9000&5000#1#2_0_1550_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012032', '10000#1#8_0_320_0_9000&5000#1#2_0_1600_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012033', '10000#1#8_0_330_0_9000&5000#1#2_0_1650_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2012034', '10000#1#8_0_340_0_9000&5000#1#2_0_1700_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013001', '10000#1#8_0_10_0_9000&5000#1#2_0_50_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013002', '10000#1#8_0_20_0_9000&5000#1#2_0_100_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013003', '10000#1#8_0_30_0_9000&5000#1#2_0_150_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013004', '10000#1#8_0_40_0_9000&5000#1#2_0_200_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013005', '10000#1#8_0_50_0_9000&5000#1#2_0_250_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013006', '10000#1#8_0_60_0_9000&5000#1#2_0_300_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013007', '10000#1#8_0_70_0_9000&5000#1#2_0_350_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013008', '10000#1#8_0_80_0_9000&5000#1#2_0_400_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013009', '10000#1#8_0_90_0_9000&5000#1#2_0_450_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013010', '10000#1#8_0_100_0_9000&5000#1#2_0_500_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013011', '10000#1#8_0_110_0_9000&5000#1#2_0_550_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013012', '10000#1#8_0_120_0_9000&5000#1#2_0_600_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013013', '10000#1#8_0_130_0_9000&5000#1#2_0_650_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013014', '10000#1#8_0_140_0_9000&5000#1#2_0_700_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013015', '10000#1#8_0_150_0_9000&5000#1#2_0_750_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013016', '10000#1#8_0_160_0_9000&5000#1#2_0_800_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013017', '10000#1#8_0_170_0_9000&5000#1#2_0_850_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013018', '10000#1#8_0_180_0_9000&5000#1#2_0_900_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013019', '10000#1#8_0_190_0_9000&5000#1#2_0_950_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013020', '10000#1#8_0_200_0_9000&5000#1#2_0_1000_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013021', '10000#1#8_0_210_0_9000&5000#1#2_0_1050_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013022', '10000#1#8_0_220_0_9000&5000#1#2_0_1100_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013023', '10000#1#8_0_230_0_9000&5000#1#2_0_1150_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013024', '10000#1#8_0_240_0_9000&5000#1#2_0_1200_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013025', '10000#1#8_0_250_0_9000&5000#1#2_0_1250_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013026', '10000#1#8_0_260_0_9000&5000#1#2_0_1300_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013027', '10000#1#8_0_270_0_9000&5000#1#2_0_1350_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013028', '10000#1#8_0_280_0_9000&5000#1#2_0_1400_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013029', '10000#1#8_0_290_0_9000&5000#1#2_0_1450_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013030', '10000#1#8_0_300_0_9000&5000#1#2_0_1500_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013031', '10000#1#8_0_310_0_9000&5000#1#2_0_1550_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013032', '10000#1#8_0_320_0_9000&5000#1#2_0_1600_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013033', '10000#1#8_0_330_0_9000&5000#1#2_0_1650_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2013034', '10000#1#8_0_340_0_9000&5000#1#2_0_1700_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100001', '10000#1#8_0_10_0_9000|1_82011_1_1_1000&5000#1#2_0_50_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100002', '10000#1#8_0_20_0_9000|1_82008_1_1_1000&5000#1#2_0_100_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100003', '10000#1#8_0_30_0_9000|1_82009_1_1_1000&5000#1#2_0_150_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100004', '10000#1#8_0_40_0_9000|1_82010_1_1_1000&5000#1#2_0_200_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100005', '10000#1#8_0_50_0_9000|1_82006_1_1_1000&5000#1#2_0_250_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100006', '10000#1#8_0_60_0_9000|1_82005_1_1_1000&5000#1#2_0_300_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100007', '10000#1#8_0_80_0_9000|1_82004_1_1_1000&5000#1#2_0_400_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100008', '10000#1#8_0_90_0_9000|1_82003_1_1_1000&5000#1#2_0_450_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100009', '10000#1#8_0_100_0_9000|1_82012_1_1_1000&5000#1#2_0_500_0_4000|4_4023101_1_1_1000|4_4023201_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100010', '10000#1#8_0_120_0_9000|1_82013_1_1_1000&5000#1#2_0_600_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023301_1_1_1000|4_4023401_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100011', '10000#1#8_0_130_0_9000|1_82031_1_1_1000&5000#1#2_0_650_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100012', '10000#1#8_0_140_0_9000|1_82030_1_1_1000&5000#1#2_0_700_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023501_1_1_1000|4_4023601_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100013', '10000#1#8_0_160_0_9000|1_82032_1_1_1000&5000#1#2_0_800_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100014', '10000#1#8_0_170_0_9000|1_82014_1_1_1000&5000#1#2_0_850_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100015', '10000#1#8_0_180_0_9000|1_82027_1_1_1000&5000#1#2_0_900_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100016', '10000#1#8_0_200_0_9000|1_82018_1_1_1000&5000#1#2_0_1000_0_4000|4_4023102_1_1_1000|4_4023202_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100017', '10000#1#8_0_210_0_9000|1_82038_1_1_1000&5000#1#2_0_1050_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100018', '10000#1#8_0_220_0_9000|1_82025_1_1_1000&5000#1#2_0_1100_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023302_1_1_1000|4_4023402_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100019', '10000#1#8_0_240_0_9000|1_82019_1_1_1000&5000#1#2_0_1200_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023502_1_1_1000|4_4023602_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100020', '10000#1#8_0_250_0_9000|1_82035_1_1_1000&5000#1#2_0_1250_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100021', '10000#1#8_0_260_0_9000|1_82026_1_1_1000&5000#1#2_0_1300_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100022', '10000#1#8_0_280_0_9000|1_82022_1_1_1000&5000#1#2_0_1400_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100023', '10000#1#8_0_290_0_9000|1_82036_1_1_1000&5000#1#2_0_1450_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100024', '10000#1#8_0_300_0_9000|1_82039_1_1_1000&5000#1#2_0_1500_0_4000|4_4023103_1_1_1000|4_4023203_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100025', '10000#1#8_0_320_0_9000|1_82040_1_1_1000&5000#1#2_0_1600_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023303_1_1_1000|4_4023403_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100026', '10000#1#8_0_330_0_9000|1_82037_1_1_1000&5000#1#2_0_1650_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('2100027', '10000#1#8_0_340_0_9000|1_82024_1_1_1000&5000#1#2_0_1700_0_4000|4_4023104_1_1_1000|4_4023204_1_1_1000|4_4023304_1_1_1000|4_4023404_1_1_1000|4_4023503_1_1_1000|4_4023603_1_1_1000');
INSERT INTO `t_drop` VALUES ('3000001', '10000#1#8_0_50_0_9000|1_82011_1_1_1000&5000#1#2_0_250_0_4000');
INSERT INTO `t_drop` VALUES ('3000002', '10000#1#8_0_50_0_9000|1_82008_1_1_1000&5000#1#2_0_250_0_4000');
INSERT INTO `t_drop` VALUES ('3000003', '10000#1#8_0_50_0_9000|1_82009_1_1_1000&5000#1#2_0_250_0_4000');
INSERT INTO `t_drop` VALUES ('3000004', '10000#1#8_0_70_0_9000|1_82010_1_1_1000&5000#1#2_0_350_0_4000');
INSERT INTO `t_drop` VALUES ('3000005', '10000#1#8_0_70_0_9000|1_82006_1_1_1000&5000#1#2_0_350_0_4000');
INSERT INTO `t_drop` VALUES ('3000006', '10000#1#8_0_70_0_9000|1_82005_1_1_1000&5000#1#2_0_350_0_4000');
INSERT INTO `t_drop` VALUES ('3000007', '10000#1#8_0_90_0_9000|1_82004_1_1_1000&5000#1#2_0_450_0_4000');
INSERT INTO `t_drop` VALUES ('3000008', '10000#1#8_0_90_0_9000|1_82003_1_1_1000&5000#1#2_0_450_0_4000');
INSERT INTO `t_drop` VALUES ('3000009', '10000#1#8_0_90_0_9000|1_82012_1_1_1000&5000#1#2_0_450_0_4000');
INSERT INTO `t_drop` VALUES ('3000010', '10000#1#8_0_110_0_9000|1_82013_1_1_1000&5000#1#2_0_550_0_4000');
INSERT INTO `t_drop` VALUES ('3000011', '10000#1#8_0_110_0_9000|1_82031_1_1_1000&5000#1#2_0_550_0_4000');
INSERT INTO `t_drop` VALUES ('3000012', '10000#1#8_0_110_0_9000|1_82030_1_1_1000&5000#1#2_0_550_0_4000');
INSERT INTO `t_drop` VALUES ('3000013', '10000#1#8_0_130_0_9000|1_82032_1_1_1000&5000#1#2_0_650_0_4000');
INSERT INTO `t_drop` VALUES ('3000014', '10000#1#8_0_130_0_9000|1_82014_1_1_1000&5000#1#2_0_650_0_4000');
INSERT INTO `t_drop` VALUES ('3000015', '10000#1#8_0_130_0_9000|1_82027_1_1_1000&5000#1#2_0_650_0_4000');
INSERT INTO `t_drop` VALUES ('3000016', '10000#1#8_0_150_0_9000|1_82018_1_1_1000&5000#1#2_0_750_0_4000');
INSERT INTO `t_drop` VALUES ('3000017', '10000#1#8_0_150_0_9000|1_82038_1_1_1000&5000#1#2_0_750_0_4000');
INSERT INTO `t_drop` VALUES ('3000018', '10000#1#8_0_150_0_9000|1_82025_1_1_1000&5000#1#2_0_750_0_4000');
INSERT INTO `t_drop` VALUES ('3000019', '10000#1#8_0_170_0_9000|1_82019_1_1_1000&5000#1#2_0_850_0_4000');
INSERT INTO `t_drop` VALUES ('3000020', '10000#1#8_0_170_0_9000|1_82035_1_1_1000&5000#1#2_0_850_0_4000');
INSERT INTO `t_drop` VALUES ('3000021', '10000#1#8_0_170_0_9000|1_82026_1_1_1000&5000#1#2_0_850_0_4000');
INSERT INTO `t_drop` VALUES ('3000022', '10000#1#8_0_190_0_9000|1_82022_1_1_1000&5000#1#2_0_950_0_4000');
INSERT INTO `t_drop` VALUES ('3000023', '10000#1#8_0_190_0_9000|1_82036_1_1_1000&5000#1#2_0_950_0_4000');
INSERT INTO `t_drop` VALUES ('3000024', '10000#1#8_0_190_0_9000|1_82039_1_1_1000&5000#1#2_0_950_0_4000');
INSERT INTO `t_drop` VALUES ('3000025', '10000#1#8_0_210_0_9000|1_82040_1_1_1000&5000#1#2_0_1050_0_4000');
INSERT INTO `t_drop` VALUES ('3000026', '10000#1#8_0_210_0_9000|1_82037_1_1_1000&5000#1#2_0_1050_0_4000');
INSERT INTO `t_drop` VALUES ('3000027', '10000#1#8_0_210_0_9000|1_82024_1_1_1000&5000#1#2_0_1050_0_4000');
INSERT INTO `t_drop` VALUES ('9000001', '10000#1#1_82001_1_1_1000');
INSERT INTO `t_drop` VALUES ('9000002', '10000#1#1_82007_1_1_1000');

-- ----------------------------
-- Table structure for t_equipment
-- ----------------------------
DROP TABLE IF EXISTS `t_equipment`;
CREATE TABLE `t_equipment` (
  `equipment_id` int(11) NOT NULL COMMENT '装备编号',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `icon` int(11) NOT NULL COMMENT '图标',
  `type` int(11) NOT NULL COMMENT '装备部位',
  `atk` int(11) NOT NULL COMMENT '攻击',
  `atk_up` float NOT NULL COMMENT '成长值',
  `hp` int(11) NOT NULL COMMENT 'HP',
  `hp_up` float NOT NULL COMMENT '成长值',
  `block_rate` int(11) NOT NULL COMMENT '格挡率',
  `block_rate_up` int(11) NOT NULL COMMENT '成长值',
  `crit_rate` int(11) NOT NULL COMMENT '暴击率',
  `crit_rate_up` int(11) NOT NULL COMMENT '成长值',
  `crit_hit` int(11) NOT NULL COMMENT '暴击伤害',
  `crit_hit_up` int(11) NOT NULL COMMENT '成长值',
  `dodge_rate` int(11) NOT NULL COMMENT '躲闪率',
  `dodge_rate_up` int(11) NOT NULL COMMENT '成长值',
  `eternal_val` int(11) NOT NULL COMMENT '熔炼所得熔炼点',
  `sell_price` int(11) NOT NULL COMMENT '出售价格',
  `des` varchar(128) NOT NULL COMMENT '描述',
  `rarity` int(11) NOT NULL COMMENT '稀有度（1为非稀有，2为稀有）',
  `max_level` int(11) NOT NULL COMMENT '装备最大等级',
  `ele` int(11) NOT NULL COMMENT '属性',
  `quality` int(11) NOT NULL COMMENT '品质'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_equipment
-- ----------------------------
INSERT INTO `t_equipment` VALUES ('3010001', '轩辕剑·铁蚀', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '1000', '100', '0', '0', '0', '0', '2950', '1000', '火属性专用武器', '2', '15', '1', '1');
INSERT INTO `t_equipment` VALUES ('3010002', '轩辕剑·青铜', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '1000', '100', '500', '100', '0', '0', '2950', '1000', '火属性专用武器', '2', '30', '1', '2');
INSERT INTO `t_equipment` VALUES ('3010003', '轩辕剑·白银', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '2000', '100', '500', '100', '0', '0', '2950', '1000', '火属性专用武器', '2', '45', '1', '3');
INSERT INTO `t_equipment` VALUES ('3010004', '百里剑·铁蚀', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '1000', '100', '0', '0', '0', '0', '2950', '1000', '木属性专用武器', '2', '15', '2', '1');
INSERT INTO `t_equipment` VALUES ('3010005', '百里剑·青铜', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '1000', '100', '500', '100', '0', '0', '2950', '1000', '木属性专用武器', '2', '30', '2', '2');
INSERT INTO `t_equipment` VALUES ('3010006', '百里剑·白银', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '2000', '100', '500', '100', '0', '0', '2950', '1000', '木属性专用武器', '2', '45', '2', '3');
INSERT INTO `t_equipment` VALUES ('3010007', '龙鳞刀·铁蚀', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '1000', '100', '0', '0', '0', '0', '2950', '1000', '水属性专用武器', '2', '15', '3', '1');
INSERT INTO `t_equipment` VALUES ('3010008', '龙鳞刀·青铜', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '1000', '100', '500', '100', '0', '0', '2950', '1000', '水属性专用武器', '2', '30', '3', '2');
INSERT INTO `t_equipment` VALUES ('3010009', '青龙偃月刀·铁蚀', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '1000', '100', '0', '0', '0', '0', '2950', '1000', '暗属性专用武器', '1', '15', '4', '1');
INSERT INTO `t_equipment` VALUES ('3010010', '青龙偃月刀·青铜', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '1000', '100', '500', '100', '0', '0', '2950', '1000', '暗属性专用武器', '1', '30', '4', '2');
INSERT INTO `t_equipment` VALUES ('3010011', '青龙偃月刀·白银', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '2000', '100', '500', '100', '0', '0', '2950', '1000', '暗属性专用武器', '1', '45', '4', '3');
INSERT INTO `t_equipment` VALUES ('3010012', '断魂血镰·铁蚀', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '1000', '100', '0', '0', '0', '0', '2950', '1000', '光属性专用武器', '1', '15', '5', '1');
INSERT INTO `t_equipment` VALUES ('3010013', '断魂血镰·青铜', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '1000', '100', '500', '100', '0', '0', '2950', '1000', '光属性专用武器', '1', '30', '5', '2');
INSERT INTO `t_equipment` VALUES ('3010014', '断魂血镰·白银', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '2000', '100', '500', '100', '0', '0', '2950', '1000', '光属性专用武器', '1', '45', '5', '3');
INSERT INTO `t_equipment` VALUES ('3010015', '破邪杖', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用武器', '2', '15', '0', '1');
INSERT INTO `t_equipment` VALUES ('3010016', '灭邪法杖', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '1000', '100', '0', '0', '0', '0', '2950', '1000', '通用武器', '2', '30', '0', '2');
INSERT INTO `t_equipment` VALUES ('3010017', '玄天破邪杖', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '1000', '100', '500', '100', '0', '0', '2950', '1000', '通用武器', '2', '45', '0', '3');
INSERT INTO `t_equipment` VALUES ('3010018', '混沌斧', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用武器', '2', '15', '0', '1');
INSERT INTO `t_equipment` VALUES ('3010019', '开天混沌斧', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '1000', '100', '0', '0', '0', '0', '2950', '1000', '通用武器', '2', '30', '0', '2');
INSERT INTO `t_equipment` VALUES ('3010020', '落月弓', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用武器', '2', '15', '0', '1');
INSERT INTO `t_equipment` VALUES ('3010021', '射日弓', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '1000', '100', '0', '0', '0', '0', '2950', '1000', '通用武器', '2', '30', '0', '2');
INSERT INTO `t_equipment` VALUES ('3010022', '朱雀扇·凡', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用武器', '2', '15', '0', '1');
INSERT INTO `t_equipment` VALUES ('3010023', '朱雀扇·良', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '1000', '100', '0', '0', '0', '0', '2950', '1000', '通用武器', '2', '30', '0', '2');
INSERT INTO `t_equipment` VALUES ('3010024', '龙胆戟', '3030001', '1', '4000', '1300', '0', '0', '0', '0', '2000', '100', '2000', '100', '0', '0', '2950', '1000', '通用武器', '2', '15', '0', '1');
INSERT INTO `t_equipment` VALUES ('3020001', '圣痕盔·上', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '0', '0', '2950', '1000', '火属性专用饰品', '2', '30', '1', '2');
INSERT INTO `t_equipment` VALUES ('3020002', '圣痕盔·精', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '500', '50', '2950', '1000', '火属性专用饰品', '2', '45', '1', '3');
INSERT INTO `t_equipment` VALUES ('3020003', '冥虹盔·凡', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '0', '0', '2950', '1000', '木属性专用饰品', '2', '15', '2', '1');
INSERT INTO `t_equipment` VALUES ('3020004', '冥虹盔·良', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '500', '50', '2950', '1000', '木属性专用饰品', '2', '30', '2', '2');
INSERT INTO `t_equipment` VALUES ('3020005', '九曜御雷盔·上', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '0', '0', '2950', '1000', '水属性专用饰品', '2', '30', '3', '2');
INSERT INTO `t_equipment` VALUES ('3020006', '九曜御雷盔精·精', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '500', '50', '2950', '1000', '水属性专用饰品', '2', '45', '3', '3');
INSERT INTO `t_equipment` VALUES ('3020007', '碧血手镯', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '0', '0', '2950', '1000', '暗属性专用饰品', '1', '15', '4', '1');
INSERT INTO `t_equipment` VALUES ('3020008', '碧血手镯', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '500', '50', '2950', '1000', '暗属性专用饰品', '1', '30', '4', '2');
INSERT INTO `t_equipment` VALUES ('3020009', '辉煌手镯', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '0', '0', '2950', '1000', '光属性专用饰品', '1', '15', '5', '1');
INSERT INTO `t_equipment` VALUES ('3020010', '辉煌手镯', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '500', '50', '2950', '1000', '光属性专用饰品', '1', '30', '5', '2');
INSERT INTO `t_equipment` VALUES ('3020011', '庇佑手镯', '3040001', '2', '0', '0', '3000', '1200', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '15', '0', '1');
INSERT INTO `t_equipment` VALUES ('3020012', '庇佑手镯', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '30', '0', '2');
INSERT INTO `t_equipment` VALUES ('3020013', '守护之铠', '3040001', '2', '0', '0', '3000', '1200', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '15', '0', '1');
INSERT INTO `t_equipment` VALUES ('3020014', '守护之铠', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '30', '0', '2');
INSERT INTO `t_equipment` VALUES ('3020015', '龙鳞铠甲', '3040001', '2', '0', '0', '3000', '1200', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '30', '0', '2');
INSERT INTO `t_equipment` VALUES ('3020016', '龙鳞铠甲', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '45', '0', '3');
INSERT INTO `t_equipment` VALUES ('3020017', '暗血冥袍', '3040001', '2', '0', '0', '3000', '1200', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '30', '0', '2');
INSERT INTO `t_equipment` VALUES ('3020018', '暗血冥袍', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '45', '0', '3');
INSERT INTO `t_equipment` VALUES ('3020019', '真理圣袍', '3040001', '2', '0', '0', '3000', '1200', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '30', '0', '2');
INSERT INTO `t_equipment` VALUES ('3020020', '真理圣袍', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '45', '0', '3');
INSERT INTO `t_equipment` VALUES ('3020021', '神明战靴', '3040001', '2', '0', '0', '3000', '1200', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '30', '0', '2');
INSERT INTO `t_equipment` VALUES ('3020022', '神明战靴', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '45', '0', '3');
INSERT INTO `t_equipment` VALUES ('3020023', '银狼圣靴', '3040001', '2', '0', '0', '3000', '1200', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '45', '0', '3');
INSERT INTO `t_equipment` VALUES ('3020024', '银狼圣靴', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '60', '0', '4');
INSERT INTO `t_equipment` VALUES ('3020025', '疾步幽灵', '3040001', '2', '0', '0', '3000', '1200', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '45', '0', '3');
INSERT INTO `t_equipment` VALUES ('3020026', '疾步幽灵', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '60', '0', '4');
INSERT INTO `t_equipment` VALUES ('3020027', '赤心项链', '3040001', '2', '0', '0', '3000', '1200', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '45', '0', '3');
INSERT INTO `t_equipment` VALUES ('3020028', '赤心项链', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '60', '0', '4');
INSERT INTO `t_equipment` VALUES ('3020029', '混沌之链', '3040001', '2', '0', '0', '3000', '1200', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '45', '0', '3');
INSERT INTO `t_equipment` VALUES ('3020030', '混沌之链', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '60', '0', '4');
INSERT INTO `t_equipment` VALUES ('3020031', '狂暴项链', '3040001', '2', '0', '0', '3000', '1200', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '45', '0', '3');
INSERT INTO `t_equipment` VALUES ('3020032', '狂暴项链', '3040001', '2', '0', '0', '3000', '1200', '1000', '100', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用饰品', '2', '60', '0', '4');
INSERT INTO `t_equipment` VALUES ('3010025', '1星测试武器', '3030001', '1', '1000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用武器', '1', '10', '0', '1');
INSERT INTO `t_equipment` VALUES ('3010026', '2星测试武器', '3030001', '1', '1000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用武器', '1', '20', '0', '2');
INSERT INTO `t_equipment` VALUES ('3010027', '3星测试武器', '3030001', '1', '1000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用武器', '1', '30', '0', '3');
INSERT INTO `t_equipment` VALUES ('3010028', '4星测试武器', '3030001', '1', '1000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用武器', '1', '40', '0', '4');
INSERT INTO `t_equipment` VALUES ('3010029', '5星测试武器', '3030001', '1', '1000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用武器', '1', '50', '0', '5');
INSERT INTO `t_equipment` VALUES ('3010030', '6星测试武器', '3030001', '1', '1000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用武器', '1', '60', '0', '6');
INSERT INTO `t_equipment` VALUES ('3010031', '1稀测试武器', '3030001', '1', '1000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用稀有武器', '2', '10', '0', '1');
INSERT INTO `t_equipment` VALUES ('3010032', '2稀测试武器', '3030001', '1', '1000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用稀有武器', '2', '20', '0', '2');
INSERT INTO `t_equipment` VALUES ('3010033', '3稀测试武器', '3030001', '1', '1000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用稀有武器', '2', '30', '0', '3');
INSERT INTO `t_equipment` VALUES ('3010034', '4稀测试武器', '3030001', '1', '1000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用稀有武器', '2', '40', '0', '4');
INSERT INTO `t_equipment` VALUES ('3010035', '5稀测试武器', '3030001', '1', '1000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用稀有武器', '2', '50', '0', '5');
INSERT INTO `t_equipment` VALUES ('3010036', '6稀测试武器', '3030001', '1', '1000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用稀有武器', '2', '60', '0', '6');
INSERT INTO `t_equipment` VALUES ('3020033', '1星测试防具', '3040001', '2', '0', '0', '500', '20222', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用防具', '1', '10', '0', '1');
INSERT INTO `t_equipment` VALUES ('3020034', '2星测试防具', '3040001', '2', '0', '0', '500', '20222', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用防具', '1', '20', '0', '2');
INSERT INTO `t_equipment` VALUES ('3020035', '3星测试防具', '3040001', '2', '0', '0', '500', '20222', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用防具', '1', '30', '0', '3');
INSERT INTO `t_equipment` VALUES ('3020036', '4星测试防具', '3040001', '2', '0', '0', '500', '20222', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用防具', '1', '40', '0', '4');
INSERT INTO `t_equipment` VALUES ('3020037', '5星测试防具', '3040001', '2', '0', '0', '500', '20222', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用防具', '1', '50', '0', '5');
INSERT INTO `t_equipment` VALUES ('3020038', '6星测试防具', '3040001', '2', '0', '0', '500', '20222', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用防具', '1', '60', '0', '6');
INSERT INTO `t_equipment` VALUES ('3020039', '1稀测试防具', '3040001', '2', '0', '0', '500', '20222', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用稀有防具', '2', '10', '0', '1');
INSERT INTO `t_equipment` VALUES ('3020040', '2稀测试防具', '3040001', '2', '0', '0', '500', '20222', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用稀有防具', '2', '20', '0', '2');
INSERT INTO `t_equipment` VALUES ('3020041', '3稀测试防具', '3040001', '2', '0', '0', '500', '20222', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用稀有防具', '2', '30', '0', '3');
INSERT INTO `t_equipment` VALUES ('3020042', '4稀测试防具', '3040001', '2', '0', '0', '500', '20222', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用稀有防具', '2', '40', '0', '4');
INSERT INTO `t_equipment` VALUES ('3020043', '5稀测试防具', '3040001', '2', '0', '0', '500', '20222', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用稀有防具', '2', '50', '0', '5');
INSERT INTO `t_equipment` VALUES ('3020044', '6稀测试防具', '3040001', '2', '0', '0', '500', '20222', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '通用稀有防具', '2', '60', '0', '6');
INSERT INTO `t_equipment` VALUES ('3030001', '青铜剑·火', '3030001', '1', '1000', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '常用兵器之一，剑身形状像柳树的叶子，寄宿着火之力。', '1', '5', '1', '1');
INSERT INTO `t_equipment` VALUES ('3030002', '青铜剑·木', '3030001', '1', '1000', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '常用兵器之一，剑身形状像柳树的叶子，寄宿着木之力。', '1', '5', '2', '1');
INSERT INTO `t_equipment` VALUES ('3030003', '青铜剑·水', '3030001', '1', '1000', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '常用兵器之一，剑身形状像柳树的叶子，寄宿着水之力。', '1', '5', '3', '1');
INSERT INTO `t_equipment` VALUES ('3030004', '青铜剑·光', '3030001', '1', '1000', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '常用兵器之一，剑身形状像柳树的叶子，寄宿着光之力。', '1', '5', '5', '1');
INSERT INTO `t_equipment` VALUES ('3030005', '青铜剑·暗', '3030001', '1', '1000', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '常用兵器之一，剑身形状像柳树的叶子，寄宿着暗之力。', '1', '5', '4', '1');
INSERT INTO `t_equipment` VALUES ('3030006', '九节鞭·火', '3030006', '1', '1500', '150', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '杀伤力比外表凶猛许多，十分灵活，寄宿着火之力。', '1', '10', '1', '2');
INSERT INTO `t_equipment` VALUES ('3030007', '九节鞭·木', '3030006', '1', '1500', '150', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '杀伤力比外表凶猛许多，十分灵活，寄宿着木之力。', '1', '10', '2', '2');
INSERT INTO `t_equipment` VALUES ('3030008', '九节鞭·水', '3030006', '1', '1500', '150', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '杀伤力比外表凶猛许多，十分灵活，寄宿着水之力。', '1', '10', '3', '2');
INSERT INTO `t_equipment` VALUES ('3030009', '九节鞭·光', '3030006', '1', '1500', '150', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '杀伤力比外表凶猛许多，十分灵活，寄宿着光之力。', '1', '10', '5', '2');
INSERT INTO `t_equipment` VALUES ('3030010', '九节鞭·暗', '3030006', '1', '1500', '150', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '杀伤力比外表凶猛许多，十分灵活，寄宿着暗之力。', '1', '10', '4', '2');
INSERT INTO `t_equipment` VALUES ('3030011', '白羽扇·火', '3030011', '1', '2000', '200', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '古代军中常用于作战指挥的白色羽毛扇，寄宿着火之力。', '1', '15', '1', '3');
INSERT INTO `t_equipment` VALUES ('3030012', '白羽扇·木', '3030011', '1', '2000', '200', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '古代军中常用于作战指挥的白色羽毛扇，寄宿着木之力。', '1', '15', '2', '3');
INSERT INTO `t_equipment` VALUES ('3030013', '白羽扇·水', '3030011', '1', '2000', '200', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '古代军中常用于作战指挥的白色羽毛扇，寄宿着水之力。', '1', '15', '3', '3');
INSERT INTO `t_equipment` VALUES ('3030014', '白羽扇·光', '3030011', '1', '2000', '200', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '古代军中常用于作战指挥的白色羽毛扇，寄宿着光之力。', '1', '15', '5', '3');
INSERT INTO `t_equipment` VALUES ('3030015', '白羽扇·暗', '3030011', '1', '2000', '200', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '古代军中常用于作战指挥的白色羽毛扇，寄宿着暗之力。', '1', '15', '4', '3');
INSERT INTO `t_equipment` VALUES ('3030016', '流星锤·火', '3030016', '1', '2500', '250', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '极重，臂力出众之人才能运用得当的武器，寄宿着火之力。', '1', '25', '1', '4');
INSERT INTO `t_equipment` VALUES ('3030017', '流星锤·木', '3030016', '1', '2500', '250', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '极重，臂力出众之人才能运用得当的武器，寄宿着木之力。', '1', '25', '2', '4');
INSERT INTO `t_equipment` VALUES ('3030018', '流星锤·水', '3030016', '1', '2500', '250', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '极重，臂力出众之人才能运用得当的武器，寄宿着水之力。', '1', '25', '3', '4');
INSERT INTO `t_equipment` VALUES ('3030019', '流星锤·光', '3030016', '1', '2500', '250', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '极重，臂力出众之人才能运用得当的武器，寄宿着光之力。', '1', '25', '5', '4');
INSERT INTO `t_equipment` VALUES ('3030020', '流星锤·暗', '3030016', '1', '2500', '250', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '极重，臂力出众之人才能运用得当的武器，寄宿着暗之力。', '1', '25', '4', '4');
INSERT INTO `t_equipment` VALUES ('3030021', '炽炎龙胆枪', '3030021', '1', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '右手亮银枪，跨下白龙马，如此猛将乃常山赵子龙是也！寄宿着火之力。', '1', '30', '1', '4');
INSERT INTO `t_equipment` VALUES ('3030022', '盘木龙胆枪', '3030021', '1', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '右手亮银枪，跨下白龙马，如此猛将乃常山赵子龙是也！寄宿着木之力。', '1', '30', '2', '4');
INSERT INTO `t_equipment` VALUES ('3030023', '冰牙龙胆枪', '3030021', '1', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '右手亮银枪，跨下白龙马，如此猛将乃常山赵子龙是也！寄宿着水之力。', '1', '30', '3', '4');
INSERT INTO `t_equipment` VALUES ('3030024', '乾坤龙胆枪', '3030021', '1', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '右手亮银枪，跨下白龙马，如此猛将乃常山赵子龙是也！寄宿着光之力。', '1', '30', '5', '4');
INSERT INTO `t_equipment` VALUES ('3030025', '修罗龙胆枪', '3030021', '1', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '右手亮银枪，跨下白龙马，如此猛将乃常山赵子龙是也！寄宿着暗之力。', '1', '30', '4', '4');
INSERT INTO `t_equipment` VALUES ('3030026', '红渊青龙刀', '3030026', '1', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '三国名将关羽所用战刀，身经百战，所向披靡。寄宿着火之力。', '1', '35', '1', '4');
INSERT INTO `t_equipment` VALUES ('3030027', '翡翠青龙刀', '3030026', '1', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '三国名将关羽所用战刀，身经百战，所向披靡。寄宿着木之力。', '1', '35', '2', '4');
INSERT INTO `t_equipment` VALUES ('3030028', '冰刃青龙刀', '3030026', '1', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '三国名将关羽所用战刀，身经百战，所向披靡。寄宿着水之力。', '1', '35', '3', '4');
INSERT INTO `t_equipment` VALUES ('3030029', '日月青龙刀', '3030026', '1', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '三国名将关羽所用战刀，身经百战，所向披靡。寄宿着光之力。', '1', '35', '5', '4');
INSERT INTO `t_equipment` VALUES ('3030030', '鬼神青龙刀', '3030026', '1', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '三国名将关羽所用战刀，身经百战，所向披靡。寄宿着暗之力。', '1', '35', '4', '4');
INSERT INTO `t_equipment` VALUES ('3030031', '炽炎龙胆枪·极', '3030021', '1', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '右手亮银枪，跨下白龙马，如此猛将乃常山赵子龙是也！寄宿着火之力。', '2', '30', '1', '4');
INSERT INTO `t_equipment` VALUES ('3030032', '盘木龙胆枪·极', '3030021', '1', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '右手亮银枪，跨下白龙马，如此猛将乃常山赵子龙是也！寄宿着木之力。', '2', '30', '2', '4');
INSERT INTO `t_equipment` VALUES ('3030033', '冰牙龙胆枪·极', '3030021', '1', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '右手亮银枪，跨下白龙马，如此猛将乃常山赵子龙是也！寄宿着水之力。', '2', '30', '3', '4');
INSERT INTO `t_equipment` VALUES ('3030034', '乾坤龙胆枪·极', '3030021', '1', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '右手亮银枪，跨下白龙马，如此猛将乃常山赵子龙是也！寄宿着光之力。', '2', '30', '5', '4');
INSERT INTO `t_equipment` VALUES ('3030035', '修罗龙胆枪·极', '3030021', '1', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '右手亮银枪，跨下白龙马，如此猛将乃常山赵子龙是也！寄宿着暗之力。', '2', '30', '4', '4');
INSERT INTO `t_equipment` VALUES ('3030036', '红渊青龙刀·极', '3030026', '1', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '三国名将关羽所用战刀，身经百战，所向披靡。寄宿着火之力。', '2', '35', '1', '4');
INSERT INTO `t_equipment` VALUES ('3030037', '翡翠青龙刀·极', '3030026', '1', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '三国名将关羽所用战刀，身经百战，所向披靡。寄宿着木之力。', '2', '35', '2', '4');
INSERT INTO `t_equipment` VALUES ('3030038', '冰刃青龙刀·极', '3030026', '1', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '三国名将关羽所用战刀，身经百战，所向披靡。寄宿着水之力。', '2', '35', '3', '4');
INSERT INTO `t_equipment` VALUES ('3030039', '日月青龙刀·极', '3030026', '1', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '三国名将关羽所用战刀，身经百战，所向披靡。寄宿着光之力。', '2', '35', '5', '4');
INSERT INTO `t_equipment` VALUES ('3030040', '鬼神青龙刀·极', '3030026', '1', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '三国名将关羽所用战刀，身经百战，所向披靡。寄宿着暗之力。', '2', '35', '4', '4');
INSERT INTO `t_equipment` VALUES ('3040001', '布袍·火', '3040001', '2', '0', '0', '1000', '100', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '常见的布制长袍，能提供基本的防护力，寄宿着火之力。', '1', '5', '1', '1');
INSERT INTO `t_equipment` VALUES ('3040002', '布袍·木', '3040001', '2', '0', '0', '1000', '100', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '常见的布制长袍，能提供基本的防护力，寄宿着木之力。', '1', '5', '2', '1');
INSERT INTO `t_equipment` VALUES ('3040003', '布袍·水', '3040001', '2', '0', '0', '1000', '100', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '常见的布制长袍，能提供基本的防护力，寄宿着水之力。', '1', '5', '3', '1');
INSERT INTO `t_equipment` VALUES ('3040004', '布袍·光', '3040001', '2', '0', '0', '1000', '100', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '常见的布制长袍，能提供基本的防护力，寄宿着光之力。', '1', '5', '5', '1');
INSERT INTO `t_equipment` VALUES ('3040005', '布袍·暗', '3040001', '2', '0', '0', '1000', '100', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '常见的布制长袍，能提供基本的防护力，寄宿着暗之力。', '1', '5', '4', '1');
INSERT INTO `t_equipment` VALUES ('3040006', '连环甲·火', '3040006', '2', '0', '0', '1500', '150', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '环片相扣的盔甲，防护力不俗，寄宿着火之力。', '1', '10', '1', '2');
INSERT INTO `t_equipment` VALUES ('3040007', '连环甲·木', '3040006', '2', '0', '0', '1500', '150', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '环片相扣的盔甲，防护力不俗，寄宿着木之力。', '1', '10', '2', '2');
INSERT INTO `t_equipment` VALUES ('3040008', '连环甲·水', '3040006', '2', '0', '0', '1500', '150', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '环片相扣的盔甲，防护力不俗，寄宿着水之力。', '1', '10', '3', '2');
INSERT INTO `t_equipment` VALUES ('3040009', '连环甲·光', '3040006', '2', '0', '0', '1500', '150', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '环片相扣的盔甲，防护力不俗，寄宿着光之力。', '1', '10', '5', '2');
INSERT INTO `t_equipment` VALUES ('3040010', '连环甲·暗', '3040006', '2', '0', '0', '1500', '150', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '环片相扣的盔甲，防护力不俗，寄宿着暗之力。', '1', '10', '4', '2');
INSERT INTO `t_equipment` VALUES ('3040011', '金丝甲·火', '3040011', '2', '0', '0', '2000', '200', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '与一般盔甲有所区别，用昂贵的金线穿制而成，寄宿着火之力。', '1', '15', '1', '3');
INSERT INTO `t_equipment` VALUES ('3040012', '金丝甲·木', '3040011', '2', '0', '0', '2000', '200', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '与一般盔甲有所区别，用昂贵的金线穿制而成，寄宿着木之力。', '1', '15', '2', '3');
INSERT INTO `t_equipment` VALUES ('3040013', '金丝甲·水', '3040011', '2', '0', '0', '2000', '200', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '与一般盔甲有所区别，用昂贵的金线穿制而成，寄宿着水之力。', '1', '15', '3', '3');
INSERT INTO `t_equipment` VALUES ('3040014', '金丝甲·光', '3040011', '2', '0', '0', '2000', '200', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '与一般盔甲有所区别，用昂贵的金线穿制而成，寄宿着光之力。', '1', '15', '5', '3');
INSERT INTO `t_equipment` VALUES ('3040015', '金丝甲·暗', '3040011', '2', '0', '0', '2000', '200', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '与一般盔甲有所区别，用昂贵的金线穿制而成，寄宿着暗之力。', '1', '15', '4', '3');
INSERT INTO `t_equipment` VALUES ('3040016', '聚灵袍·火', '3040016', '2', '0', '0', '2500', '250', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '汇聚了灵力的法袍，防护能力不低于铠甲，寄宿着火之力。', '1', '25', '1', '4');
INSERT INTO `t_equipment` VALUES ('3040017', '聚灵袍·木', '3040016', '2', '0', '0', '2500', '250', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '汇聚了灵力的法袍，防护能力不低于铠甲，寄宿着木之力。', '1', '25', '2', '4');
INSERT INTO `t_equipment` VALUES ('3040018', '聚灵袍·水', '3040016', '2', '0', '0', '2500', '250', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '汇聚了灵力的法袍，防护能力不低于铠甲，寄宿着水之力。', '1', '25', '3', '4');
INSERT INTO `t_equipment` VALUES ('3040019', '聚灵袍·光', '3040016', '2', '0', '0', '2500', '250', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '汇聚了灵力的法袍，防护能力不低于铠甲，寄宿着光之力。', '1', '25', '5', '4');
INSERT INTO `t_equipment` VALUES ('3040020', '聚灵袍·暗', '3040016', '2', '0', '0', '2500', '250', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '汇聚了灵力的法袍，防护能力不低于铠甲，寄宿着暗之力。', '1', '25', '4', '4');
INSERT INTO `t_equipment` VALUES ('3040021', '流火织锦服', '3040021', '2', '0', '0', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '用罕见的锦缎织就的长袍，刀枪不入。寄宿着火之力。', '1', '30', '1', '4');
INSERT INTO `t_equipment` VALUES ('3040022', '落英织锦服', '3040021', '2', '0', '0', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '用罕见的锦缎织就的长袍，刀枪不入。寄宿着木之力。', '1', '30', '2', '4');
INSERT INTO `t_equipment` VALUES ('3040023', '飞瀑织锦服', '3040021', '2', '0', '0', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '用罕见的锦缎织就的长袍，刀枪不入。寄宿着水之力。', '1', '30', '3', '4');
INSERT INTO `t_equipment` VALUES ('3040024', '流光织锦服', '3040021', '2', '0', '0', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '用罕见的锦缎织就的长袍，刀枪不入。寄宿着光之力。', '1', '30', '5', '4');
INSERT INTO `t_equipment` VALUES ('3040025', '暗咏织锦服', '3040021', '2', '0', '0', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '用罕见的锦缎织就的长袍，刀枪不入。寄宿着暗之力。', '1', '30', '4', '4');
INSERT INTO `t_equipment` VALUES ('3040026', '炽羽金缕衣', '3040026', '2', '0', '0', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '极其稀有的铠甲，世人难得其一。寄宿着火之力。', '1', '35', '1', '4');
INSERT INTO `t_equipment` VALUES ('3040027', '碎玉金缕衣', '3040026', '2', '0', '0', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '极其稀有的铠甲，世人难得其一。寄宿着木之力。', '1', '35', '2', '4');
INSERT INTO `t_equipment` VALUES ('3040028', '玄冰金缕衣', '3040026', '2', '0', '0', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '极其稀有的铠甲，世人难得其一。寄宿着水之力。', '1', '35', '3', '4');
INSERT INTO `t_equipment` VALUES ('3040029', '天谕金缕衣', '3040026', '2', '0', '0', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '极其稀有的铠甲，世人难得其一。寄宿着光之力。', '1', '35', '5', '4');
INSERT INTO `t_equipment` VALUES ('3040030', '鬼邪金缕衣', '3040026', '2', '0', '0', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '极其稀有的铠甲，世人难得其一。寄宿着暗之力。', '1', '35', '4', '4');
INSERT INTO `t_equipment` VALUES ('3040031', '流火织锦服·极', '3040021', '2', '0', '0', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '用罕见的锦缎织就的长袍，刀枪不入。寄宿着火之力。', '2', '30', '1', '4');
INSERT INTO `t_equipment` VALUES ('3040032', '落英织锦服·极', '3040021', '2', '0', '0', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '用罕见的锦缎织就的长袍，刀枪不入。寄宿着木之力。', '2', '30', '2', '4');
INSERT INTO `t_equipment` VALUES ('3040033', '飞瀑织锦服·极', '3040021', '2', '0', '0', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '用罕见的锦缎织就的长袍，刀枪不入。寄宿着水之力。', '2', '30', '3', '4');
INSERT INTO `t_equipment` VALUES ('3040034', '流光织锦服·极', '3040021', '2', '0', '0', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '用罕见的锦缎织就的长袍，刀枪不入。寄宿着光之力。', '2', '30', '5', '4');
INSERT INTO `t_equipment` VALUES ('3040035', '暗咏织锦服·极', '3040021', '2', '0', '0', '3000', '300', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '用罕见的锦缎织就的长袍，刀枪不入。寄宿着暗之力。', '2', '30', '4', '4');
INSERT INTO `t_equipment` VALUES ('3040036', '炽羽金缕衣·极', '3040026', '2', '0', '0', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '极其稀有的铠甲，世人难得其一。寄宿着火之力。', '2', '35', '1', '4');
INSERT INTO `t_equipment` VALUES ('3040037', '碎玉金缕衣·极', '3040026', '2', '0', '0', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '极其稀有的铠甲，世人难得其一。寄宿着木之力。', '2', '35', '2', '4');
INSERT INTO `t_equipment` VALUES ('3040038', '玄冰金缕衣·极', '3040026', '2', '0', '0', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '极其稀有的铠甲，世人难得其一。寄宿着水之力。', '2', '35', '3', '4');
INSERT INTO `t_equipment` VALUES ('3040039', '天谕金缕衣·极', '3040026', '2', '0', '0', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '极其稀有的铠甲，世人难得其一。寄宿着光之力。', '2', '35', '5', '4');
INSERT INTO `t_equipment` VALUES ('3040040', '鬼邪金缕衣·极', '3040026', '2', '0', '0', '3500', '350', '0', '0', '0', '0', '0', '0', '0', '0', '2950', '1000', '极其稀有的铠甲，世人难得其一。寄宿着暗之力。', '2', '35', '4', '4');

-- ----------------------------
-- Table structure for t_equipment_property
-- ----------------------------
DROP TABLE IF EXISTS `t_equipment_property`;
CREATE TABLE `t_equipment_property` (
  `quality` int(11) NOT NULL COMMENT '品质',
  `skill_type` int(11) NOT NULL COMMENT '属性类型',
  `skill_rate` double NOT NULL COMMENT '该属性出现的概率',
  `start_num` double NOT NULL COMMENT '起始数值',
  `end_num` double NOT NULL COMMENT '结束数值'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_equipment_property
-- ----------------------------
INSERT INTO `t_equipment_property` VALUES ('1', '1', '0.3', '0.01', '0.02');
INSERT INTO `t_equipment_property` VALUES ('1', '2', '0.3', '0.01', '0.02');
INSERT INTO `t_equipment_property` VALUES ('1', '3', '0.2', '0.01', '0.02');
INSERT INTO `t_equipment_property` VALUES ('1', '4', '0.2', '0.02', '0.04');
INSERT INTO `t_equipment_property` VALUES ('1', '5', '0', '0.01', '0.02');
INSERT INTO `t_equipment_property` VALUES ('1', '6', '0', '0.02', '0.04');
INSERT INTO `t_equipment_property` VALUES ('1', '7', '0', '0.01', '0.02');
INSERT INTO `t_equipment_property` VALUES ('2', '1', '0.25', '0.02', '0.04');
INSERT INTO `t_equipment_property` VALUES ('2', '2', '0.25', '0.02', '0.04');
INSERT INTO `t_equipment_property` VALUES ('2', '3', '0.1', '0.02', '0.04');
INSERT INTO `t_equipment_property` VALUES ('2', '4', '0.1', '0.04', '0.08');
INSERT INTO `t_equipment_property` VALUES ('2', '5', '0.1', '0.02', '0.04');
INSERT INTO `t_equipment_property` VALUES ('2', '6', '0.1', '0.04', '0.08');
INSERT INTO `t_equipment_property` VALUES ('2', '7', '0.1', '0.02', '0.04');
INSERT INTO `t_equipment_property` VALUES ('3', '1', '0.25', '0.03', '0.06');
INSERT INTO `t_equipment_property` VALUES ('3', '2', '0.25', '0.03', '0.06');
INSERT INTO `t_equipment_property` VALUES ('3', '3', '0.1', '0.03', '0.06');
INSERT INTO `t_equipment_property` VALUES ('3', '4', '0.1', '0.06', '0.12');
INSERT INTO `t_equipment_property` VALUES ('3', '5', '0.1', '0.03', '0.06');
INSERT INTO `t_equipment_property` VALUES ('3', '6', '0.1', '0.06', '0.12');
INSERT INTO `t_equipment_property` VALUES ('3', '7', '0.1', '0.03', '0.06');
INSERT INTO `t_equipment_property` VALUES ('4', '1', '0.25', '0.04', '0.08');
INSERT INTO `t_equipment_property` VALUES ('4', '2', '0.25', '0.04', '0.08');
INSERT INTO `t_equipment_property` VALUES ('4', '3', '0.1', '0.04', '0.08');
INSERT INTO `t_equipment_property` VALUES ('4', '4', '0.1', '0.08', '0.16');
INSERT INTO `t_equipment_property` VALUES ('4', '5', '0.1', '0.04', '0.08');
INSERT INTO `t_equipment_property` VALUES ('4', '6', '0.1', '0.08', '0.16');
INSERT INTO `t_equipment_property` VALUES ('4', '7', '0.1', '0.04', '0.08');
INSERT INTO `t_equipment_property` VALUES ('5', '1', '0.25', '0.05', '0.1');
INSERT INTO `t_equipment_property` VALUES ('5', '2', '0.25', '0.05', '0.1');
INSERT INTO `t_equipment_property` VALUES ('5', '3', '0.1', '0.05', '0.1');
INSERT INTO `t_equipment_property` VALUES ('5', '4', '0.1', '0.1', '0.2');
INSERT INTO `t_equipment_property` VALUES ('5', '5', '0.1', '0.05', '0.1');
INSERT INTO `t_equipment_property` VALUES ('5', '6', '0.1', '0.1', '0.2');
INSERT INTO `t_equipment_property` VALUES ('5', '7', '0.1', '0.05', '0.1');
INSERT INTO `t_equipment_property` VALUES ('6', '1', '0.25', '0.060000000000000005', '0.12000000000000001');
INSERT INTO `t_equipment_property` VALUES ('6', '2', '0.25', '0.060000000000000005', '0.12000000000000001');
INSERT INTO `t_equipment_property` VALUES ('6', '3', '0.1', '0.060000000000000005', '0.12000000000000001');
INSERT INTO `t_equipment_property` VALUES ('6', '4', '0.1', '0.12000000000000001', '0.24000000000000002');
INSERT INTO `t_equipment_property` VALUES ('6', '5', '0.1', '0.060000000000000005', '0.12000000000000001');
INSERT INTO `t_equipment_property` VALUES ('6', '6', '0.1', '0.12000000000000001', '0.24000000000000002');
INSERT INTO `t_equipment_property` VALUES ('6', '7', '0.1', '0.060000000000000005', '0.12000000000000001');
INSERT INTO `t_equipment_property` VALUES ('7', '1', '0.25', '0.07', '0.14');
INSERT INTO `t_equipment_property` VALUES ('7', '2', '0.25', '0.07', '0.14');
INSERT INTO `t_equipment_property` VALUES ('7', '3', '0.1', '0.07', '0.14');
INSERT INTO `t_equipment_property` VALUES ('7', '4', '0.1', '0.14', '0.28');
INSERT INTO `t_equipment_property` VALUES ('7', '5', '0.1', '0.07', '0.14');
INSERT INTO `t_equipment_property` VALUES ('7', '6', '0.1', '0.14', '0.28');
INSERT INTO `t_equipment_property` VALUES ('7', '7', '0.1', '0.07', '0.14');
INSERT INTO `t_equipment_property` VALUES ('8', '1', '0.25', '0.08', '0.16');
INSERT INTO `t_equipment_property` VALUES ('8', '2', '0.25', '0.08', '0.16');
INSERT INTO `t_equipment_property` VALUES ('8', '3', '0.1', '0.08', '0.16');
INSERT INTO `t_equipment_property` VALUES ('8', '4', '0.1', '0.16', '0.32');
INSERT INTO `t_equipment_property` VALUES ('8', '5', '0.1', '0.08', '0.16');
INSERT INTO `t_equipment_property` VALUES ('8', '6', '0.1', '0.16', '0.32');
INSERT INTO `t_equipment_property` VALUES ('8', '7', '0.1', '0.08', '0.16');
INSERT INTO `t_equipment_property` VALUES ('9', '1', '0.25', '0.09', '0.18');
INSERT INTO `t_equipment_property` VALUES ('9', '2', '0.25', '0.09', '0.18');
INSERT INTO `t_equipment_property` VALUES ('9', '3', '0.1', '0.09', '0.18');
INSERT INTO `t_equipment_property` VALUES ('9', '4', '0.1', '0.18', '0.36');
INSERT INTO `t_equipment_property` VALUES ('9', '5', '0.1', '0.09', '0.18');
INSERT INTO `t_equipment_property` VALUES ('9', '6', '0.1', '0.18', '0.36');
INSERT INTO `t_equipment_property` VALUES ('9', '7', '0.1', '0.09', '0.18');
INSERT INTO `t_equipment_property` VALUES ('10', '1', '0.25', '0.09999999999999999', '0.19999999999999998');
INSERT INTO `t_equipment_property` VALUES ('10', '2', '0.25', '0.09999999999999999', '0.19999999999999998');
INSERT INTO `t_equipment_property` VALUES ('10', '3', '0.1', '0.09999999999999999', '0.19999999999999998');
INSERT INTO `t_equipment_property` VALUES ('10', '4', '0.1', '0.19999999999999998', '0.39999999999999997');
INSERT INTO `t_equipment_property` VALUES ('10', '5', '0.1', '0.09999999999999999', '0.19999999999999998');
INSERT INTO `t_equipment_property` VALUES ('10', '6', '0.1', '0.19999999999999998', '0.39999999999999997');
INSERT INTO `t_equipment_property` VALUES ('10', '7', '0.1', '0.09999999999999999', '0.19999999999999998');

-- ----------------------------
-- Table structure for t_equipment_up
-- ----------------------------
DROP TABLE IF EXISTS `t_equipment_up`;
CREATE TABLE `t_equipment_up` (
  `id` int(11) NOT NULL COMMENT '主键',
  `equipment_level` int(11) NOT NULL COMMENT '装备等级',
  `ass_id` int(11) NOT NULL COMMENT '关联id',
  `type` int(11) NOT NULL COMMENT '物品类型',
  `num` int(11) NOT NULL COMMENT '数量'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_equipment_up
-- ----------------------------
INSERT INTO `t_equipment_up` VALUES ('1', '1', '0', '2', '100');
INSERT INTO `t_equipment_up` VALUES ('2', '1', '0', '9', '10');
INSERT INTO `t_equipment_up` VALUES ('3', '2', '0', '2', '200');
INSERT INTO `t_equipment_up` VALUES ('4', '2', '0', '9', '20');
INSERT INTO `t_equipment_up` VALUES ('5', '3', '0', '2', '300');
INSERT INTO `t_equipment_up` VALUES ('6', '3', '0', '9', '30');
INSERT INTO `t_equipment_up` VALUES ('7', '4', '0', '2', '400');
INSERT INTO `t_equipment_up` VALUES ('8', '4', '0', '9', '40');
INSERT INTO `t_equipment_up` VALUES ('9', '5', '0', '2', '500');
INSERT INTO `t_equipment_up` VALUES ('10', '5', '0', '9', '50');
INSERT INTO `t_equipment_up` VALUES ('11', '6', '0', '2', '600');
INSERT INTO `t_equipment_up` VALUES ('12', '6', '0', '9', '60');
INSERT INTO `t_equipment_up` VALUES ('13', '7', '0', '2', '700');
INSERT INTO `t_equipment_up` VALUES ('14', '7', '0', '9', '70');
INSERT INTO `t_equipment_up` VALUES ('15', '8', '0', '2', '800');
INSERT INTO `t_equipment_up` VALUES ('16', '8', '0', '9', '80');
INSERT INTO `t_equipment_up` VALUES ('17', '9', '0', '2', '900');
INSERT INTO `t_equipment_up` VALUES ('18', '9', '0', '9', '90');
INSERT INTO `t_equipment_up` VALUES ('19', '10', '0', '2', '1000');
INSERT INTO `t_equipment_up` VALUES ('20', '10', '0', '9', '100');
INSERT INTO `t_equipment_up` VALUES ('21', '11', '0', '2', '1100');
INSERT INTO `t_equipment_up` VALUES ('22', '11', '0', '9', '110');
INSERT INTO `t_equipment_up` VALUES ('23', '12', '0', '2', '1200');
INSERT INTO `t_equipment_up` VALUES ('24', '12', '0', '9', '120');
INSERT INTO `t_equipment_up` VALUES ('25', '13', '0', '2', '1300');
INSERT INTO `t_equipment_up` VALUES ('26', '13', '0', '9', '130');
INSERT INTO `t_equipment_up` VALUES ('27', '14', '0', '2', '1400');
INSERT INTO `t_equipment_up` VALUES ('28', '14', '0', '9', '140');
INSERT INTO `t_equipment_up` VALUES ('29', '15', '0', '2', '1500');
INSERT INTO `t_equipment_up` VALUES ('30', '15', '0', '9', '150');
INSERT INTO `t_equipment_up` VALUES ('31', '16', '0', '2', '1600');
INSERT INTO `t_equipment_up` VALUES ('32', '16', '0', '9', '160');
INSERT INTO `t_equipment_up` VALUES ('33', '17', '0', '2', '1700');
INSERT INTO `t_equipment_up` VALUES ('34', '17', '0', '9', '170');
INSERT INTO `t_equipment_up` VALUES ('35', '18', '0', '2', '1800');
INSERT INTO `t_equipment_up` VALUES ('36', '18', '0', '9', '180');
INSERT INTO `t_equipment_up` VALUES ('37', '19', '0', '2', '1900');
INSERT INTO `t_equipment_up` VALUES ('38', '19', '0', '9', '190');
INSERT INTO `t_equipment_up` VALUES ('39', '20', '0', '2', '2000');
INSERT INTO `t_equipment_up` VALUES ('40', '20', '0', '9', '200');
INSERT INTO `t_equipment_up` VALUES ('41', '21', '0', '2', '2100');
INSERT INTO `t_equipment_up` VALUES ('42', '21', '0', '9', '210');
INSERT INTO `t_equipment_up` VALUES ('43', '22', '0', '2', '2200');
INSERT INTO `t_equipment_up` VALUES ('44', '22', '0', '9', '220');
INSERT INTO `t_equipment_up` VALUES ('45', '23', '0', '2', '2300');
INSERT INTO `t_equipment_up` VALUES ('46', '23', '0', '9', '230');
INSERT INTO `t_equipment_up` VALUES ('47', '24', '0', '2', '2400');
INSERT INTO `t_equipment_up` VALUES ('48', '24', '0', '9', '240');
INSERT INTO `t_equipment_up` VALUES ('49', '25', '0', '2', '2500');
INSERT INTO `t_equipment_up` VALUES ('50', '25', '0', '9', '250');
INSERT INTO `t_equipment_up` VALUES ('51', '26', '0', '2', '2600');
INSERT INTO `t_equipment_up` VALUES ('52', '26', '0', '9', '260');
INSERT INTO `t_equipment_up` VALUES ('53', '27', '0', '2', '2700');
INSERT INTO `t_equipment_up` VALUES ('54', '27', '0', '9', '270');
INSERT INTO `t_equipment_up` VALUES ('55', '28', '0', '2', '2800');
INSERT INTO `t_equipment_up` VALUES ('56', '28', '0', '9', '280');
INSERT INTO `t_equipment_up` VALUES ('57', '29', '0', '2', '2900');
INSERT INTO `t_equipment_up` VALUES ('58', '29', '0', '9', '290');
INSERT INTO `t_equipment_up` VALUES ('59', '30', '0', '2', '3000');
INSERT INTO `t_equipment_up` VALUES ('60', '30', '0', '9', '300');
INSERT INTO `t_equipment_up` VALUES ('61', '31', '0', '2', '3100');
INSERT INTO `t_equipment_up` VALUES ('62', '31', '0', '9', '310');
INSERT INTO `t_equipment_up` VALUES ('63', '32', '0', '2', '3200');
INSERT INTO `t_equipment_up` VALUES ('64', '32', '0', '9', '320');
INSERT INTO `t_equipment_up` VALUES ('65', '33', '0', '2', '3300');
INSERT INTO `t_equipment_up` VALUES ('66', '33', '0', '9', '330');
INSERT INTO `t_equipment_up` VALUES ('67', '34', '0', '2', '3400');
INSERT INTO `t_equipment_up` VALUES ('68', '34', '0', '9', '340');
INSERT INTO `t_equipment_up` VALUES ('69', '35', '0', '2', '3500');
INSERT INTO `t_equipment_up` VALUES ('70', '35', '0', '9', '350');
INSERT INTO `t_equipment_up` VALUES ('71', '36', '0', '2', '3600');
INSERT INTO `t_equipment_up` VALUES ('72', '36', '0', '9', '360');
INSERT INTO `t_equipment_up` VALUES ('73', '37', '0', '2', '3700');
INSERT INTO `t_equipment_up` VALUES ('74', '37', '0', '9', '370');
INSERT INTO `t_equipment_up` VALUES ('75', '38', '0', '2', '3800');
INSERT INTO `t_equipment_up` VALUES ('76', '38', '0', '9', '380');
INSERT INTO `t_equipment_up` VALUES ('77', '39', '0', '2', '3900');
INSERT INTO `t_equipment_up` VALUES ('78', '39', '0', '9', '390');
INSERT INTO `t_equipment_up` VALUES ('79', '40', '0', '2', '4000');
INSERT INTO `t_equipment_up` VALUES ('80', '40', '0', '9', '400');
INSERT INTO `t_equipment_up` VALUES ('81', '41', '0', '2', '4100');
INSERT INTO `t_equipment_up` VALUES ('82', '41', '0', '9', '410');
INSERT INTO `t_equipment_up` VALUES ('83', '42', '0', '2', '4200');
INSERT INTO `t_equipment_up` VALUES ('84', '42', '0', '9', '420');
INSERT INTO `t_equipment_up` VALUES ('85', '43', '0', '2', '4300');
INSERT INTO `t_equipment_up` VALUES ('86', '43', '0', '9', '430');
INSERT INTO `t_equipment_up` VALUES ('87', '44', '0', '2', '4400');
INSERT INTO `t_equipment_up` VALUES ('88', '44', '0', '9', '440');
INSERT INTO `t_equipment_up` VALUES ('89', '45', '0', '2', '4500');
INSERT INTO `t_equipment_up` VALUES ('90', '45', '0', '9', '450');
INSERT INTO `t_equipment_up` VALUES ('91', '46', '0', '2', '4600');
INSERT INTO `t_equipment_up` VALUES ('92', '46', '0', '9', '460');
INSERT INTO `t_equipment_up` VALUES ('93', '47', '0', '2', '4700');
INSERT INTO `t_equipment_up` VALUES ('94', '47', '0', '9', '470');
INSERT INTO `t_equipment_up` VALUES ('95', '48', '0', '2', '4800');
INSERT INTO `t_equipment_up` VALUES ('96', '48', '0', '9', '480');
INSERT INTO `t_equipment_up` VALUES ('97', '49', '0', '2', '4900');
INSERT INTO `t_equipment_up` VALUES ('98', '49', '0', '9', '490');
INSERT INTO `t_equipment_up` VALUES ('99', '50', '0', '2', '5000');
INSERT INTO `t_equipment_up` VALUES ('100', '50', '0', '9', '500');
INSERT INTO `t_equipment_up` VALUES ('101', '51', '0', '2', '5100');
INSERT INTO `t_equipment_up` VALUES ('102', '51', '0', '9', '510');
INSERT INTO `t_equipment_up` VALUES ('103', '52', '0', '2', '5200');
INSERT INTO `t_equipment_up` VALUES ('104', '52', '0', '9', '520');
INSERT INTO `t_equipment_up` VALUES ('105', '53', '0', '2', '5300');
INSERT INTO `t_equipment_up` VALUES ('106', '53', '0', '9', '530');
INSERT INTO `t_equipment_up` VALUES ('107', '54', '0', '2', '5400');
INSERT INTO `t_equipment_up` VALUES ('108', '54', '0', '9', '540');
INSERT INTO `t_equipment_up` VALUES ('109', '55', '0', '2', '5500');
INSERT INTO `t_equipment_up` VALUES ('110', '55', '0', '9', '550');
INSERT INTO `t_equipment_up` VALUES ('111', '56', '0', '2', '5600');
INSERT INTO `t_equipment_up` VALUES ('112', '56', '0', '9', '560');
INSERT INTO `t_equipment_up` VALUES ('113', '57', '0', '2', '5700');
INSERT INTO `t_equipment_up` VALUES ('114', '57', '0', '9', '570');
INSERT INTO `t_equipment_up` VALUES ('115', '58', '0', '2', '5800');
INSERT INTO `t_equipment_up` VALUES ('116', '58', '0', '9', '580');
INSERT INTO `t_equipment_up` VALUES ('117', '59', '0', '2', '5900');
INSERT INTO `t_equipment_up` VALUES ('118', '59', '0', '9', '590');
INSERT INTO `t_equipment_up` VALUES ('119', '60', '0', '2', '6000');
INSERT INTO `t_equipment_up` VALUES ('120', '60', '0', '9', '600');
INSERT INTO `t_equipment_up` VALUES ('121', '61', '0', '2', '6100');
INSERT INTO `t_equipment_up` VALUES ('122', '61', '0', '9', '610');
INSERT INTO `t_equipment_up` VALUES ('123', '62', '0', '2', '6200');
INSERT INTO `t_equipment_up` VALUES ('124', '62', '0', '9', '620');
INSERT INTO `t_equipment_up` VALUES ('125', '63', '0', '2', '6300');
INSERT INTO `t_equipment_up` VALUES ('126', '63', '0', '9', '630');
INSERT INTO `t_equipment_up` VALUES ('127', '64', '0', '2', '6400');
INSERT INTO `t_equipment_up` VALUES ('128', '64', '0', '9', '640');
INSERT INTO `t_equipment_up` VALUES ('129', '65', '0', '2', '6500');
INSERT INTO `t_equipment_up` VALUES ('130', '65', '0', '9', '650');
INSERT INTO `t_equipment_up` VALUES ('131', '66', '0', '2', '6600');
INSERT INTO `t_equipment_up` VALUES ('132', '66', '0', '9', '660');
INSERT INTO `t_equipment_up` VALUES ('133', '67', '0', '2', '6700');
INSERT INTO `t_equipment_up` VALUES ('134', '67', '0', '9', '670');
INSERT INTO `t_equipment_up` VALUES ('135', '68', '0', '2', '6800');
INSERT INTO `t_equipment_up` VALUES ('136', '68', '0', '9', '680');
INSERT INTO `t_equipment_up` VALUES ('137', '69', '0', '2', '6900');
INSERT INTO `t_equipment_up` VALUES ('138', '69', '0', '9', '690');
INSERT INTO `t_equipment_up` VALUES ('139', '70', '0', '2', '7000');
INSERT INTO `t_equipment_up` VALUES ('140', '70', '0', '9', '700');
INSERT INTO `t_equipment_up` VALUES ('141', '71', '0', '2', '7100');
INSERT INTO `t_equipment_up` VALUES ('142', '71', '0', '9', '710');
INSERT INTO `t_equipment_up` VALUES ('143', '72', '0', '2', '7200');
INSERT INTO `t_equipment_up` VALUES ('144', '72', '0', '9', '720');
INSERT INTO `t_equipment_up` VALUES ('145', '73', '0', '2', '7300');
INSERT INTO `t_equipment_up` VALUES ('146', '73', '0', '9', '730');
INSERT INTO `t_equipment_up` VALUES ('147', '74', '0', '2', '7400');
INSERT INTO `t_equipment_up` VALUES ('148', '74', '0', '9', '740');
INSERT INTO `t_equipment_up` VALUES ('149', '75', '0', '2', '7500');
INSERT INTO `t_equipment_up` VALUES ('150', '75', '0', '9', '750');
INSERT INTO `t_equipment_up` VALUES ('151', '76', '0', '2', '7600');
INSERT INTO `t_equipment_up` VALUES ('152', '76', '0', '9', '760');
INSERT INTO `t_equipment_up` VALUES ('153', '77', '0', '2', '7700');
INSERT INTO `t_equipment_up` VALUES ('154', '77', '0', '9', '770');
INSERT INTO `t_equipment_up` VALUES ('155', '78', '0', '2', '7800');
INSERT INTO `t_equipment_up` VALUES ('156', '78', '0', '9', '780');
INSERT INTO `t_equipment_up` VALUES ('157', '79', '0', '2', '7900');
INSERT INTO `t_equipment_up` VALUES ('158', '79', '0', '9', '790');
INSERT INTO `t_equipment_up` VALUES ('159', '80', '0', '2', '8000');
INSERT INTO `t_equipment_up` VALUES ('160', '80', '0', '9', '800');
INSERT INTO `t_equipment_up` VALUES ('161', '81', '0', '2', '8100');
INSERT INTO `t_equipment_up` VALUES ('162', '81', '0', '9', '810');
INSERT INTO `t_equipment_up` VALUES ('163', '82', '0', '2', '8200');
INSERT INTO `t_equipment_up` VALUES ('164', '82', '0', '9', '820');
INSERT INTO `t_equipment_up` VALUES ('165', '83', '0', '2', '8300');
INSERT INTO `t_equipment_up` VALUES ('166', '83', '0', '9', '830');
INSERT INTO `t_equipment_up` VALUES ('167', '84', '0', '2', '8400');
INSERT INTO `t_equipment_up` VALUES ('168', '84', '0', '9', '840');
INSERT INTO `t_equipment_up` VALUES ('169', '85', '0', '2', '8500');
INSERT INTO `t_equipment_up` VALUES ('170', '85', '0', '9', '850');
INSERT INTO `t_equipment_up` VALUES ('171', '86', '0', '2', '8600');
INSERT INTO `t_equipment_up` VALUES ('172', '86', '0', '9', '860');
INSERT INTO `t_equipment_up` VALUES ('173', '87', '0', '2', '8700');
INSERT INTO `t_equipment_up` VALUES ('174', '87', '0', '9', '870');
INSERT INTO `t_equipment_up` VALUES ('175', '88', '0', '2', '8800');
INSERT INTO `t_equipment_up` VALUES ('176', '88', '0', '9', '880');
INSERT INTO `t_equipment_up` VALUES ('177', '89', '0', '2', '8900');
INSERT INTO `t_equipment_up` VALUES ('178', '89', '0', '9', '890');
INSERT INTO `t_equipment_up` VALUES ('179', '90', '0', '2', '9000');
INSERT INTO `t_equipment_up` VALUES ('180', '90', '0', '9', '900');
INSERT INTO `t_equipment_up` VALUES ('181', '91', '0', '2', '9100');
INSERT INTO `t_equipment_up` VALUES ('182', '91', '0', '9', '910');
INSERT INTO `t_equipment_up` VALUES ('183', '92', '0', '2', '9200');
INSERT INTO `t_equipment_up` VALUES ('184', '92', '0', '9', '920');
INSERT INTO `t_equipment_up` VALUES ('185', '93', '0', '2', '9300');
INSERT INTO `t_equipment_up` VALUES ('186', '93', '0', '9', '930');
INSERT INTO `t_equipment_up` VALUES ('187', '94', '0', '2', '9400');
INSERT INTO `t_equipment_up` VALUES ('188', '94', '0', '9', '940');
INSERT INTO `t_equipment_up` VALUES ('189', '95', '0', '2', '9500');
INSERT INTO `t_equipment_up` VALUES ('190', '95', '0', '9', '950');
INSERT INTO `t_equipment_up` VALUES ('191', '96', '0', '2', '9600');
INSERT INTO `t_equipment_up` VALUES ('192', '96', '0', '9', '960');
INSERT INTO `t_equipment_up` VALUES ('193', '97', '0', '2', '9700');
INSERT INTO `t_equipment_up` VALUES ('194', '97', '0', '9', '970');
INSERT INTO `t_equipment_up` VALUES ('195', '98', '0', '2', '9800');
INSERT INTO `t_equipment_up` VALUES ('196', '98', '0', '9', '980');
INSERT INTO `t_equipment_up` VALUES ('197', '99', '0', '2', '9900');
INSERT INTO `t_equipment_up` VALUES ('198', '99', '0', '9', '990');
INSERT INTO `t_equipment_up` VALUES ('199', '100', '0', '2', '10000');
INSERT INTO `t_equipment_up` VALUES ('200', '100', '0', '9', '1000');
INSERT INTO `t_equipment_up` VALUES ('201', '101', '0', '2', '10100');
INSERT INTO `t_equipment_up` VALUES ('202', '101', '0', '9', '1010');
INSERT INTO `t_equipment_up` VALUES ('203', '102', '0', '2', '10200');
INSERT INTO `t_equipment_up` VALUES ('204', '102', '0', '9', '1020');
INSERT INTO `t_equipment_up` VALUES ('205', '103', '0', '2', '10300');
INSERT INTO `t_equipment_up` VALUES ('206', '103', '0', '9', '1030');
INSERT INTO `t_equipment_up` VALUES ('207', '104', '0', '2', '10400');
INSERT INTO `t_equipment_up` VALUES ('208', '104', '0', '9', '1040');
INSERT INTO `t_equipment_up` VALUES ('209', '105', '0', '2', '10500');
INSERT INTO `t_equipment_up` VALUES ('210', '105', '0', '9', '1050');
INSERT INTO `t_equipment_up` VALUES ('211', '106', '0', '2', '10600');
INSERT INTO `t_equipment_up` VALUES ('212', '106', '0', '9', '1060');
INSERT INTO `t_equipment_up` VALUES ('213', '107', '0', '2', '10700');
INSERT INTO `t_equipment_up` VALUES ('214', '107', '0', '9', '1070');
INSERT INTO `t_equipment_up` VALUES ('215', '108', '0', '2', '10800');
INSERT INTO `t_equipment_up` VALUES ('216', '108', '0', '9', '1080');
INSERT INTO `t_equipment_up` VALUES ('217', '109', '0', '2', '10900');
INSERT INTO `t_equipment_up` VALUES ('218', '109', '0', '9', '1090');
INSERT INTO `t_equipment_up` VALUES ('219', '110', '0', '2', '11000');
INSERT INTO `t_equipment_up` VALUES ('220', '110', '0', '9', '1100');
INSERT INTO `t_equipment_up` VALUES ('221', '111', '0', '2', '11100');
INSERT INTO `t_equipment_up` VALUES ('222', '111', '0', '9', '1110');
INSERT INTO `t_equipment_up` VALUES ('223', '112', '0', '2', '11200');
INSERT INTO `t_equipment_up` VALUES ('224', '112', '0', '9', '1120');
INSERT INTO `t_equipment_up` VALUES ('225', '113', '0', '2', '11300');
INSERT INTO `t_equipment_up` VALUES ('226', '113', '0', '9', '1130');
INSERT INTO `t_equipment_up` VALUES ('227', '114', '0', '2', '11400');
INSERT INTO `t_equipment_up` VALUES ('228', '114', '0', '9', '1140');
INSERT INTO `t_equipment_up` VALUES ('229', '115', '0', '2', '11500');
INSERT INTO `t_equipment_up` VALUES ('230', '115', '0', '9', '1150');
INSERT INTO `t_equipment_up` VALUES ('231', '116', '0', '2', '11600');
INSERT INTO `t_equipment_up` VALUES ('232', '116', '0', '9', '1160');
INSERT INTO `t_equipment_up` VALUES ('233', '117', '0', '2', '11700');
INSERT INTO `t_equipment_up` VALUES ('234', '117', '0', '9', '1170');
INSERT INTO `t_equipment_up` VALUES ('235', '118', '0', '2', '11800');
INSERT INTO `t_equipment_up` VALUES ('236', '118', '0', '9', '1180');
INSERT INTO `t_equipment_up` VALUES ('237', '119', '0', '2', '11900');
INSERT INTO `t_equipment_up` VALUES ('238', '119', '0', '9', '1190');
INSERT INTO `t_equipment_up` VALUES ('239', '120', '0', '2', '12000');
INSERT INTO `t_equipment_up` VALUES ('240', '120', '0', '9', '1200');
INSERT INTO `t_equipment_up` VALUES ('241', '121', '0', '2', '12100');
INSERT INTO `t_equipment_up` VALUES ('242', '121', '0', '9', '1210');
INSERT INTO `t_equipment_up` VALUES ('243', '122', '0', '2', '12200');
INSERT INTO `t_equipment_up` VALUES ('244', '122', '0', '9', '1220');
INSERT INTO `t_equipment_up` VALUES ('245', '123', '0', '2', '12300');
INSERT INTO `t_equipment_up` VALUES ('246', '123', '0', '9', '1230');
INSERT INTO `t_equipment_up` VALUES ('247', '124', '0', '2', '12400');
INSERT INTO `t_equipment_up` VALUES ('248', '124', '0', '9', '1240');
INSERT INTO `t_equipment_up` VALUES ('249', '125', '0', '2', '12500');
INSERT INTO `t_equipment_up` VALUES ('250', '125', '0', '9', '1250');
INSERT INTO `t_equipment_up` VALUES ('251', '126', '0', '2', '12600');
INSERT INTO `t_equipment_up` VALUES ('252', '126', '0', '9', '1260');
INSERT INTO `t_equipment_up` VALUES ('253', '127', '0', '2', '12700');
INSERT INTO `t_equipment_up` VALUES ('254', '127', '0', '9', '1270');
INSERT INTO `t_equipment_up` VALUES ('255', '128', '0', '2', '12800');
INSERT INTO `t_equipment_up` VALUES ('256', '128', '0', '9', '1280');
INSERT INTO `t_equipment_up` VALUES ('257', '129', '0', '2', '12900');
INSERT INTO `t_equipment_up` VALUES ('258', '129', '0', '9', '1290');
INSERT INTO `t_equipment_up` VALUES ('259', '130', '0', '2', '13000');
INSERT INTO `t_equipment_up` VALUES ('260', '130', '0', '9', '1300');
INSERT INTO `t_equipment_up` VALUES ('261', '131', '0', '2', '13100');
INSERT INTO `t_equipment_up` VALUES ('262', '131', '0', '9', '1310');
INSERT INTO `t_equipment_up` VALUES ('263', '132', '0', '2', '13200');
INSERT INTO `t_equipment_up` VALUES ('264', '132', '0', '9', '1320');
INSERT INTO `t_equipment_up` VALUES ('265', '133', '0', '2', '13300');
INSERT INTO `t_equipment_up` VALUES ('266', '133', '0', '9', '1330');
INSERT INTO `t_equipment_up` VALUES ('267', '134', '0', '2', '13400');
INSERT INTO `t_equipment_up` VALUES ('268', '134', '0', '9', '1340');
INSERT INTO `t_equipment_up` VALUES ('269', '135', '0', '2', '13500');
INSERT INTO `t_equipment_up` VALUES ('270', '135', '0', '9', '1350');
INSERT INTO `t_equipment_up` VALUES ('271', '136', '0', '2', '13600');
INSERT INTO `t_equipment_up` VALUES ('272', '136', '0', '9', '1360');
INSERT INTO `t_equipment_up` VALUES ('273', '137', '0', '2', '13700');
INSERT INTO `t_equipment_up` VALUES ('274', '137', '0', '9', '1370');
INSERT INTO `t_equipment_up` VALUES ('275', '138', '0', '2', '13800');
INSERT INTO `t_equipment_up` VALUES ('276', '138', '0', '9', '1380');
INSERT INTO `t_equipment_up` VALUES ('277', '139', '0', '2', '13900');
INSERT INTO `t_equipment_up` VALUES ('278', '139', '0', '9', '1390');
INSERT INTO `t_equipment_up` VALUES ('279', '140', '0', '2', '14000');
INSERT INTO `t_equipment_up` VALUES ('280', '140', '0', '9', '1400');
INSERT INTO `t_equipment_up` VALUES ('281', '141', '0', '2', '14100');
INSERT INTO `t_equipment_up` VALUES ('282', '141', '0', '9', '1410');
INSERT INTO `t_equipment_up` VALUES ('283', '142', '0', '2', '14200');
INSERT INTO `t_equipment_up` VALUES ('284', '142', '0', '9', '1420');
INSERT INTO `t_equipment_up` VALUES ('285', '143', '0', '2', '14300');
INSERT INTO `t_equipment_up` VALUES ('286', '143', '0', '9', '1430');
INSERT INTO `t_equipment_up` VALUES ('287', '144', '0', '2', '14400');
INSERT INTO `t_equipment_up` VALUES ('288', '144', '0', '9', '1440');
INSERT INTO `t_equipment_up` VALUES ('289', '145', '0', '2', '14500');
INSERT INTO `t_equipment_up` VALUES ('290', '145', '0', '9', '1450');
INSERT INTO `t_equipment_up` VALUES ('291', '146', '0', '2', '14600');
INSERT INTO `t_equipment_up` VALUES ('292', '146', '0', '9', '1460');
INSERT INTO `t_equipment_up` VALUES ('293', '147', '0', '2', '14700');
INSERT INTO `t_equipment_up` VALUES ('294', '147', '0', '9', '1470');
INSERT INTO `t_equipment_up` VALUES ('295', '148', '0', '2', '14800');
INSERT INTO `t_equipment_up` VALUES ('296', '148', '0', '9', '1480');
INSERT INTO `t_equipment_up` VALUES ('297', '149', '0', '2', '14900');
INSERT INTO `t_equipment_up` VALUES ('298', '149', '0', '9', '1490');
INSERT INTO `t_equipment_up` VALUES ('299', '150', '0', '2', '15000');
INSERT INTO `t_equipment_up` VALUES ('300', '150', '0', '9', '1500');
INSERT INTO `t_equipment_up` VALUES ('301', '151', '0', '2', '15100');
INSERT INTO `t_equipment_up` VALUES ('302', '151', '0', '9', '1510');
INSERT INTO `t_equipment_up` VALUES ('303', '152', '0', '2', '15200');
INSERT INTO `t_equipment_up` VALUES ('304', '152', '0', '9', '1520');
INSERT INTO `t_equipment_up` VALUES ('305', '153', '0', '2', '15300');
INSERT INTO `t_equipment_up` VALUES ('306', '153', '0', '9', '1530');
INSERT INTO `t_equipment_up` VALUES ('307', '154', '0', '2', '15400');
INSERT INTO `t_equipment_up` VALUES ('308', '154', '0', '9', '1540');
INSERT INTO `t_equipment_up` VALUES ('309', '155', '0', '2', '15500');
INSERT INTO `t_equipment_up` VALUES ('310', '155', '0', '9', '1550');
INSERT INTO `t_equipment_up` VALUES ('311', '156', '0', '2', '15600');
INSERT INTO `t_equipment_up` VALUES ('312', '156', '0', '9', '1560');
INSERT INTO `t_equipment_up` VALUES ('313', '157', '0', '2', '15700');
INSERT INTO `t_equipment_up` VALUES ('314', '157', '0', '9', '1570');
INSERT INTO `t_equipment_up` VALUES ('315', '158', '0', '2', '15800');
INSERT INTO `t_equipment_up` VALUES ('316', '158', '0', '9', '1580');
INSERT INTO `t_equipment_up` VALUES ('317', '159', '0', '2', '15900');
INSERT INTO `t_equipment_up` VALUES ('318', '159', '0', '9', '1590');
INSERT INTO `t_equipment_up` VALUES ('319', '160', '0', '2', '16000');
INSERT INTO `t_equipment_up` VALUES ('320', '160', '0', '9', '1600');
INSERT INTO `t_equipment_up` VALUES ('321', '161', '0', '2', '16100');
INSERT INTO `t_equipment_up` VALUES ('322', '161', '0', '9', '1610');
INSERT INTO `t_equipment_up` VALUES ('323', '162', '0', '2', '16200');
INSERT INTO `t_equipment_up` VALUES ('324', '162', '0', '9', '1620');
INSERT INTO `t_equipment_up` VALUES ('325', '163', '0', '2', '16300');
INSERT INTO `t_equipment_up` VALUES ('326', '163', '0', '9', '1630');
INSERT INTO `t_equipment_up` VALUES ('327', '164', '0', '2', '16400');
INSERT INTO `t_equipment_up` VALUES ('328', '164', '0', '9', '1640');
INSERT INTO `t_equipment_up` VALUES ('329', '165', '0', '2', '16500');
INSERT INTO `t_equipment_up` VALUES ('330', '165', '0', '9', '1650');
INSERT INTO `t_equipment_up` VALUES ('331', '166', '0', '2', '16600');
INSERT INTO `t_equipment_up` VALUES ('332', '166', '0', '9', '1660');
INSERT INTO `t_equipment_up` VALUES ('333', '167', '0', '2', '16700');
INSERT INTO `t_equipment_up` VALUES ('334', '167', '0', '9', '1670');
INSERT INTO `t_equipment_up` VALUES ('335', '168', '0', '2', '16800');
INSERT INTO `t_equipment_up` VALUES ('336', '168', '0', '9', '1680');
INSERT INTO `t_equipment_up` VALUES ('337', '169', '0', '2', '16900');
INSERT INTO `t_equipment_up` VALUES ('338', '169', '0', '9', '1690');
INSERT INTO `t_equipment_up` VALUES ('339', '170', '0', '2', '17000');
INSERT INTO `t_equipment_up` VALUES ('340', '170', '0', '9', '1700');
INSERT INTO `t_equipment_up` VALUES ('341', '171', '0', '2', '17100');
INSERT INTO `t_equipment_up` VALUES ('342', '171', '0', '9', '1710');
INSERT INTO `t_equipment_up` VALUES ('343', '172', '0', '2', '17200');
INSERT INTO `t_equipment_up` VALUES ('344', '172', '0', '9', '1720');
INSERT INTO `t_equipment_up` VALUES ('345', '173', '0', '2', '17300');
INSERT INTO `t_equipment_up` VALUES ('346', '173', '0', '9', '1730');
INSERT INTO `t_equipment_up` VALUES ('347', '174', '0', '2', '17400');
INSERT INTO `t_equipment_up` VALUES ('348', '174', '0', '9', '1740');
INSERT INTO `t_equipment_up` VALUES ('349', '175', '0', '2', '17500');
INSERT INTO `t_equipment_up` VALUES ('350', '175', '0', '9', '1750');
INSERT INTO `t_equipment_up` VALUES ('351', '176', '0', '2', '17600');
INSERT INTO `t_equipment_up` VALUES ('352', '176', '0', '9', '1760');
INSERT INTO `t_equipment_up` VALUES ('353', '177', '0', '2', '17700');
INSERT INTO `t_equipment_up` VALUES ('354', '177', '0', '9', '1770');
INSERT INTO `t_equipment_up` VALUES ('355', '178', '0', '2', '17800');
INSERT INTO `t_equipment_up` VALUES ('356', '178', '0', '9', '1780');
INSERT INTO `t_equipment_up` VALUES ('357', '179', '0', '2', '17900');
INSERT INTO `t_equipment_up` VALUES ('358', '179', '0', '9', '1790');
INSERT INTO `t_equipment_up` VALUES ('359', '180', '0', '2', '18000');
INSERT INTO `t_equipment_up` VALUES ('360', '180', '0', '9', '1800');
INSERT INTO `t_equipment_up` VALUES ('361', '181', '0', '2', '18100');
INSERT INTO `t_equipment_up` VALUES ('362', '181', '0', '9', '1810');
INSERT INTO `t_equipment_up` VALUES ('363', '182', '0', '2', '18200');
INSERT INTO `t_equipment_up` VALUES ('364', '182', '0', '9', '1820');
INSERT INTO `t_equipment_up` VALUES ('365', '183', '0', '2', '18300');
INSERT INTO `t_equipment_up` VALUES ('366', '183', '0', '9', '1830');
INSERT INTO `t_equipment_up` VALUES ('367', '184', '0', '2', '18400');
INSERT INTO `t_equipment_up` VALUES ('368', '184', '0', '9', '1840');
INSERT INTO `t_equipment_up` VALUES ('369', '185', '0', '2', '18500');
INSERT INTO `t_equipment_up` VALUES ('370', '185', '0', '9', '1850');
INSERT INTO `t_equipment_up` VALUES ('371', '186', '0', '2', '18600');
INSERT INTO `t_equipment_up` VALUES ('372', '186', '0', '9', '1860');
INSERT INTO `t_equipment_up` VALUES ('373', '187', '0', '2', '18700');
INSERT INTO `t_equipment_up` VALUES ('374', '187', '0', '9', '1870');
INSERT INTO `t_equipment_up` VALUES ('375', '188', '0', '2', '18800');
INSERT INTO `t_equipment_up` VALUES ('376', '188', '0', '9', '1880');
INSERT INTO `t_equipment_up` VALUES ('377', '189', '0', '2', '18900');
INSERT INTO `t_equipment_up` VALUES ('378', '189', '0', '9', '1890');
INSERT INTO `t_equipment_up` VALUES ('379', '190', '0', '2', '19000');
INSERT INTO `t_equipment_up` VALUES ('380', '190', '0', '9', '1900');
INSERT INTO `t_equipment_up` VALUES ('381', '191', '0', '2', '19100');
INSERT INTO `t_equipment_up` VALUES ('382', '191', '0', '9', '1910');
INSERT INTO `t_equipment_up` VALUES ('383', '192', '0', '2', '19200');
INSERT INTO `t_equipment_up` VALUES ('384', '192', '0', '9', '1920');
INSERT INTO `t_equipment_up` VALUES ('385', '193', '0', '2', '19300');
INSERT INTO `t_equipment_up` VALUES ('386', '193', '0', '9', '1930');
INSERT INTO `t_equipment_up` VALUES ('387', '194', '0', '2', '19400');
INSERT INTO `t_equipment_up` VALUES ('388', '194', '0', '9', '1940');
INSERT INTO `t_equipment_up` VALUES ('389', '195', '0', '2', '19500');
INSERT INTO `t_equipment_up` VALUES ('390', '195', '0', '9', '1950');

-- ----------------------------
-- Table structure for t_equipment_up_rate
-- ----------------------------
DROP TABLE IF EXISTS `t_equipment_up_rate`;
CREATE TABLE `t_equipment_up_rate` (
  `level` int(11) NOT NULL COMMENT '等级',
  `success_rate` double NOT NULL COMMENT '成功概率',
  `max_success_rate` double NOT NULL COMMENT '大成功概率',
  `super_success_rate` double NOT NULL COMMENT '超大成功概率',
  `lose_rate` double NOT NULL COMMENT '失败概率'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_equipment_up_rate
-- ----------------------------
INSERT INTO `t_equipment_up_rate` VALUES ('1', '0', '0.5', '0.5', '0');
INSERT INTO `t_equipment_up_rate` VALUES ('2', '0', '0.5', '0.5', '0');
INSERT INTO `t_equipment_up_rate` VALUES ('3', '0', '0.5', '0.5', '0');
INSERT INTO `t_equipment_up_rate` VALUES ('4', '0', '0.5', '0.5', '0');
INSERT INTO `t_equipment_up_rate` VALUES ('5', '0', '0.5', '0.5', '0');
INSERT INTO `t_equipment_up_rate` VALUES ('6', '0', '0.5', '0.5', '0');
INSERT INTO `t_equipment_up_rate` VALUES ('7', '0', '0.5', '0.5', '0');
INSERT INTO `t_equipment_up_rate` VALUES ('8', '0', '0.5', '0.5', '0');
INSERT INTO `t_equipment_up_rate` VALUES ('9', '0', '0.5', '0.5', '0');
INSERT INTO `t_equipment_up_rate` VALUES ('10', '0', '0.5', '0.5', '0');
INSERT INTO `t_equipment_up_rate` VALUES ('11', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('12', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('13', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('14', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('15', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('16', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('17', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('18', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('19', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('20', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('21', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('22', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('23', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('24', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('25', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('26', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('27', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('28', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('29', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('30', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('31', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('32', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('33', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('34', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('35', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('36', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('37', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('38', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('39', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('40', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('41', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('42', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('43', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('44', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('45', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('46', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('47', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('48', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('49', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('50', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('51', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('52', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('53', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('54', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('55', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('56', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('57', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('58', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('59', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('60', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('61', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('62', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('63', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('64', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('65', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('66', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('67', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('68', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('69', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('70', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('71', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('72', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('73', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('74', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('75', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('76', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('77', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('78', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('79', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('80', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('81', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('82', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('83', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('84', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('85', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('86', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('87', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('88', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('89', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('90', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('91', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('92', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('93', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('94', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('95', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('96', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('97', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('98', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('99', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('100', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('101', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('102', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('103', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('104', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('105', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('106', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('107', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('108', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('109', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('110', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('111', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('112', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('113', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('114', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('115', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('116', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('117', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('118', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('119', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('120', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('121', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('122', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('123', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('124', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('125', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('126', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('127', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('128', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('129', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('130', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('131', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('132', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('133', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('134', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('135', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('136', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('137', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('138', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('139', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('140', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('141', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('142', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('143', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('144', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('145', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('146', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('147', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('148', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('149', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('150', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('151', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('152', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('153', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('154', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('155', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('156', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('157', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('158', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('159', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('160', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('161', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('162', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('163', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('164', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('165', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('166', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('167', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('168', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('169', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('170', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('171', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('172', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('173', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('174', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('175', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('176', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('177', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('178', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('179', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('180', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('181', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('182', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('183', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('184', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('185', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('186', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('187', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('188', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('189', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('190', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('191', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('192', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('193', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('194', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('195', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('196', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('197', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('198', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('199', '0.3', '0.1', '0.1', '0.5');
INSERT INTO `t_equipment_up_rate` VALUES ('200', '0.3', '0.1', '0.1', '0.5');

-- ----------------------------
-- Table structure for t_eternal
-- ----------------------------
DROP TABLE IF EXISTS `t_eternal`;
CREATE TABLE `t_eternal` (
  `eternal_id` int(11) NOT NULL COMMENT '武魂编号',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `icon` int(11) NOT NULL COMMENT '图标',
  `ele` int(11) NOT NULL COMMENT '属性',
  `quality` int(11) NOT NULL COMMENT '品质',
  `eternal_val` int(11) NOT NULL COMMENT '熔炼所得熔炼点',
  `sell_price` int(11) NOT NULL COMMENT '出售价格',
  `des` varchar(128) NOT NULL COMMENT '描述',
  `rarity` int(11) NOT NULL COMMENT '稀有类型',
  `skill_id` int(11) NOT NULL COMMENT '技能ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_eternal
-- ----------------------------
INSERT INTO `t_eternal` VALUES ('5010001', '强击之魂·↖', '5020007', '0', '1', '1950', '10', '增加左上方攻击方向', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010002', '强击之魂·↗', '5020008', '0', '1', '1950', '10', '增加右上方攻击方向', '1', '0');
INSERT INTO `t_eternal` VALUES ('5010003', '强击之魂·→', '5020009', '0', '1', '1950', '10', '增加右方攻击方向', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010004', '强击之魂·↘', '5020010', '0', '1', '1950', '10', '增加右下方攻击方向', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010005', '强击之魂·↙', '5020011', '0', '1', '1950', '10', '增加左下方攻击方向', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010006', '强击之魂·←', '5020012', '0', '1', '1950', '10', '增加左方攻击方向', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010007', '攻击次数', '5020001', '0', '1', '1950', '10', '攻击次数加1', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010008', '移动范围', '5020001', '0', '1', '1950', '10', '移动范围+1', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010009', '陷阱免疫', '5020001', '0', '1', '1950', '10', '免疫陷阱', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010010', 'debuff免疫', '5020001', '0', '1', '1950', '10', '免疫debuff', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010011', '属性免疫', '5020001', '0', '1', '1950', '10', '免疫对克制属性的百分比伤害', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010012', '技能免疫', '5020001', '0', '1', '1950', '10', '免疫敌方技能伤害', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010013', '飞行', '5020001', '0', '1', '1950', '10', '使佩戴者拥有飞行能力', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010014', '团队', '5020001', '0', '1', '1950', '10', '是佩戴者拥有团队能力', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010015', '弹射', '5020001', '0', '1', '1950', '10', '为伙伴增肌弹射能力', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010016', '炎之魂·凡', '5020001', '1', '1', '1950', '10', '将伙伴的火属性变为炎属性', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010017', '炎之魂·良', '5020001', '1', '2', '1950', '10', '增加格挡率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010018', '炎之魂·上', '5020001', '1', '3', '1950', '10', '延续绿色格挡率，增强格挡效果', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010019', '炎之魂·精', '5020001', '1', '4', '1950', '10', '延续绿色格挡率，延续蓝色格挡效果，增加暴击率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010020', '炎之魂·极', '5020001', '1', '5', '1950', '10', '延续绿色格挡率，延续蓝色格挡效果，延续紫色暴击率，增加暴击伤害', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010021', '炼之魂·凡', '5020001', '1', '1', '1950', '10', '将伙伴的火属性变为炼属性，增加格挡率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010022', '炼之魂·良', '5020001', '1', '2', '1950', '10', '将伙伴的火属性变为炼属性，延续白色格挡率，增强格挡效果', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010023', '炼之魂·上', '5020001', '1', '3', '1950', '10', '将伙伴的火属性变为炼属性，延续白色格挡率，延续绿色格挡效果，增加暴击率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010024', '炼之魂·精', '5020001', '1', '4', '1950', '10', '将伙伴的火属性变为炼属性，延续白色格挡率，延续绿色格挡效果，延续蓝色暴击率，强加暴击伤害', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010025', '炼之魂·极', '5020001', '1', '5', '1950', '10', '将伙伴的火属性变为炼属性，延续白色格挡率，延续绿色格挡效果，延续蓝色暴击率，延续紫色暴击伤害，增加闪避率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010026', '林之魂·凡', '5020001', '2', '1', '1950', '10', '将伙伴的木属性变为林属性', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010027', '林之魂·良', '5020001', '2', '2', '1950', '10', '增加格挡率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010028', '林之魂·上', '5020001', '2', '3', '1950', '10', '延续绿色格挡率，增强格挡效果', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010029', '林之魂·精', '5020001', '2', '4', '1950', '10', '延续绿色格挡率，延续蓝色格挡效果，增加暴击率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010030', '林之魂·极', '5020001', '2', '5', '1950', '10', '延续绿色格挡率，延续蓝色格挡效果，延续紫色暴击率，增加暴击伤害', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010031', '森之魂·凡', '5020001', '2', '1', '1950', '10', '将伙伴的木属性变为森属性，增加格挡率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010032', '森之魂·良', '5020001', '2', '2', '1950', '10', '将伙伴的木属性变为森属性，延续白色格挡率，增强格挡效果', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010033', '森之魂·上', '5020001', '2', '3', '1950', '10', '将伙伴的木属性变为森属性，延续白色格挡率，延续绿色格挡效果，增加暴击率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010034', '森之魂·精', '5020001', '2', '4', '1950', '10', '将伙伴的木属性变为森属性，延续白色格挡率，延续绿色格挡效果，延续蓝色暴击率，强加暴击伤害', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010035', '森之魂·极', '5020001', '2', '5', '1950', '10', '将伙伴的木属性变为森属性，延续白色格挡率，延续绿色格挡效果，延续蓝色暴击率，延续紫色暴击伤害，增加闪避率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010036', '波之魂·凡', '5020001', '3', '1', '1950', '10', '将伙伴的水属性变为波属性', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010037', '波之魂·良', '5020001', '3', '2', '1950', '10', '增加格挡率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010038', '波之魂·上', '5020001', '3', '3', '1950', '10', '延续绿色格挡率，增强格挡效果', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010039', '波之魂·精', '5020001', '3', '4', '1950', '10', '延续绿色格挡率，延续蓝色格挡效果，增加暴击率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010040', '波之魂·极', '5020001', '3', '5', '1950', '10', '延续绿色格挡率，延续蓝色格挡效果，延续紫色暴击率，增加暴击伤害', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010041', '渺之魂·凡', '5020001', '3', '1', '1950', '10', '将伙伴的水属性变为渺属性，增加格挡率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010042', '渺之魂·良', '5020001', '3', '2', '1950', '10', '将伙伴的水属性变为渺属性，延续白色格挡率，增强格挡效果', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010043', '渺之魂·上', '5020001', '3', '3', '1950', '10', '将伙伴的水属性变为渺属性，延续白色格挡率，延续绿色格挡效果，增加暴击率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010044', '渺之魂·精', '5020001', '3', '4', '1950', '10', '将伙伴的水属性变为渺属性，延续白色格挡率，延续绿色格挡效果，延续蓝色暴击率，强加暴击伤害', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010045', '渺之魂·极', '5020001', '3', '5', '1950', '10', '将伙伴的水属性变为渺属性，延续白色格挡率，延续绿色格挡效果，延续蓝色暴击率，延续紫色暴击伤害，增加闪避率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010046', '闪之魂·凡', '5020001', '5', '1', '1950', '10', '将伙伴的光属性变为闪属性', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010047', '闪之魂·良', '5020001', '5', '2', '1950', '10', '增加格挡率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010048', '闪之魂·上', '5020001', '5', '3', '1950', '10', '延续绿色格挡率，增强格挡效果', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010049', '闪之魂·精', '5020001', '5', '4', '1950', '10', '延续绿色格挡率，延续蓝色格挡效果，增加暴击率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010050', '闪之魂·极', '5020001', '5', '5', '1950', '10', '延续绿色格挡率，延续蓝色格挡效果，延续紫色暴击率，增加暴击伤害', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010051', '耀之魂·凡', '5020001', '5', '1', '1950', '10', '将伙伴的光属性变为耀属性，增加格挡率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010052', '耀之魂·良', '5020001', '5', '2', '1950', '10', '将伙伴的光属性变为耀属性，延续白色格挡率，增强格挡效果', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010053', '耀之魂·上', '5020001', '5', '3', '1950', '10', '将伙伴的光属性变为耀属性，延续白色格挡率，延续绿色格挡效果，增加暴击率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010054', '耀之魂·精', '5020001', '5', '4', '1950', '10', '将伙伴的光属性变为耀属性，延续白色格挡率，延续绿色格挡效果，延续蓝色暴击率，强加暴击伤害', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010055', '耀之魂·极', '5020001', '5', '5', '1950', '10', '将伙伴的光属性变为耀属性，延续白色格挡率，延续绿色格挡效果，延续蓝色暴击率，延续紫色暴击伤害，增加闪避率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010056', '阎之魂·凡', '5020001', '4', '1', '1950', '10', '将伙伴的暗属性变为阎属性', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010057', '阎之魂·良', '5020001', '4', '2', '1950', '10', '增加格挡率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010058', '阎之魂·上', '5020001', '4', '3', '1950', '10', '延续绿色格挡率，增强格挡效果', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010059', '阎之魂·精', '5020001', '4', '4', '1950', '10', '延续绿色格挡率，延续蓝色格挡效果，增加暴击率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010060', '阎之魂·极', '5020001', '4', '4', '1950', '10', '延续绿色格挡率，延续蓝色格挡效果，延续紫色暴击率，增加暴击伤害', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010061', '冥之魂·凡', '5020001', '4', '1', '1950', '10', '将伙伴的暗属性变为冥属性，增加格挡率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010062', '冥之魂·良', '5020001', '4', '2', '1950', '10', '将伙伴的暗属性变为冥属性，延续白色格挡率，增强格挡效果', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010063', '冥之魂·上', '5020001', '4', '3', '1950', '10', '将伙伴的暗属性变为冥属性，延续白色格挡率，延续绿色格挡效果，增加暴击率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010064', '冥之魂·精', '5020001', '4', '4', '1950', '10', '将伙伴的暗属性变为冥属性，延续白色格挡率，延续绿色格挡效果，延续蓝色暴击率，强加暴击伤害', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010065', '冥之魂·极', '5020001', '4', '5', '1950', '10', '将伙伴的暗属性变为冥属性，延续白色格挡率，延续绿色格挡效果，延续蓝色暴击率，延续紫色暴击伤害，增加闪避率', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010066', '测试武魂1星', '5020001', '0', '1', '1950', '10', '1基础，无附加', '1', '0');
INSERT INTO `t_eternal` VALUES ('5010067', '测试武魂2星', '5020001', '0', '2', '1950', '10', '1基础，无附加', '1', '0');
INSERT INTO `t_eternal` VALUES ('5010068', '测试武魂3星', '5020001', '0', '3', '1950', '10', '1基础，1附加', '1', '0');
INSERT INTO `t_eternal` VALUES ('5010069', '测试武魂4星', '5020001', '0', '4', '1950', '10', '2基础，2附加', '1', '0');
INSERT INTO `t_eternal` VALUES ('5010070', '测试武魂5星', '5020001', '0', '5', '1950', '10', '2基础，2附加', '1', '0');
INSERT INTO `t_eternal` VALUES ('5010071', '测试武魂6星', '5020001', '0', '6', '1950', '10', '2基础，2附加', '1', '0');
INSERT INTO `t_eternal` VALUES ('5010072', '测试武魂1稀', '5020001', '0', '1', '1950', '10', '1基础，无附加', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010073', '测试武魂2稀', '5020001', '0', '2', '1950', '10', '1基础，无附加', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010074', '测试武魂3稀', '5020001', '0', '3', '1950', '10', '1基础，1附加', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010075', '测试武魂4稀', '5020001', '0', '4', '1950', '10', '2基础，2附加', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010076', '测试武魂5稀', '5020001', '0', '5', '1950', '10', '2基础，2附加', '2', '0');
INSERT INTO `t_eternal` VALUES ('5010077', '测试武魂6稀', '5020001', '0', '6', '1950', '10', '2基础，2附加', '2', '0');
INSERT INTO `t_eternal` VALUES ('5020001', '烛火之魂', '5020001', '0', '1', '1950', '10', '附着烛火之力的魂魄，能够增强战力。', '1', '0');
INSERT INTO `t_eternal` VALUES ('5020002', '火焰之魂', '5020002', '0', '2', '1950', '10', '附着火焰之力的魂魄，能够增强战力。', '1', '0');
INSERT INTO `t_eternal` VALUES ('5020003', '赤炎之魂', '5020003', '0', '3', '1950', '10', '附着赤炎之力的魂魄，能够增强战力。', '1', '0');
INSERT INTO `t_eternal` VALUES ('5020004', '火狼之魂', '5020004', '0', '4', '1950', '10', '附着火狼之力的魂魄，能够增强战力。', '1', '0');
INSERT INTO `t_eternal` VALUES ('5020005', '红莲之魂', '5020005', '0', '5', '1950', '10', '附着红莲之力的魂魄，能够增强战力。', '1', '0');
INSERT INTO `t_eternal` VALUES ('5020006', '绯炎之魂', '5020006', '0', '6', '1950', '10', '附着绯炎之力的魂魄，能够增强战力。', '1', '0');
INSERT INTO `t_eternal` VALUES ('5020007', '天狗之魂·↖', '5020007', '0', '1', '1950', '10', '蕴含天狗之力的魂魄，能够增加攻击方向。', '2', '70001');
INSERT INTO `t_eternal` VALUES ('5020008', '天狗之魂·↗', '5020008', '0', '1', '1950', '10', '蕴含天狗之力的魂魄，能够增加攻击方向。', '2', '70002');
INSERT INTO `t_eternal` VALUES ('5020009', '天狗之魂·→', '5020009', '0', '1', '1950', '10', '蕴含天狗之力的魂魄，能够增加攻击方向。', '2', '70003');
INSERT INTO `t_eternal` VALUES ('5020010', '天狗之魂·↘', '5020010', '0', '1', '1950', '10', '蕴含天狗之力的魂魄，能够增加攻击方向。', '2', '70004');
INSERT INTO `t_eternal` VALUES ('5020011', '天狗之魂·↙', '5020011', '0', '1', '1950', '10', '蕴含天狗之力的魂魄，能够增加攻击方向。', '2', '70005');
INSERT INTO `t_eternal` VALUES ('5020012', '天狗之魂·←', '5020012', '0', '1', '1950', '10', '蕴含天狗之力的魂魄，能够增加攻击方向。', '2', '70006');
INSERT INTO `t_eternal` VALUES ('5020013', '青鸟之魂', '5020013', '0', '2', '1950', '10', '蕴含青鸟之力的魂魄，能够增加飞行能力。', '2', '70007');
INSERT INTO `t_eternal` VALUES ('5020014', '句芒之魂', '5020014', '0', '2', '1950', '10', '蕴含句芒之力的魂魄，能够增加弹射能力。', '2', '70008');
INSERT INTO `t_eternal` VALUES ('5020015', '鲲鹏之魂', '5020015', '0', '2', '1950', '10', '蕴含鲲鹏之力的魂魄，能够增加换位能力。', '2', '70009');
INSERT INTO `t_eternal` VALUES ('5020016', '白泽之魂', '5020016', '0', '2', '1950', '10', '蕴含鲲鹏之力的魂魄，能够使道具全体化。', '2', '70010');
INSERT INTO `t_eternal` VALUES ('5020017', '毕方之魂·火', '5020017', '1', '3', '1950', '10', '蕴含毕方之力的魂魄，能够增加火属性的伤害。', '2', '70011');
INSERT INTO `t_eternal` VALUES ('5020018', '毕方之魂·木', '5020017', '2', '3', '1950', '10', '蕴含毕方之力的魂魄，能够增加木属性的伤害。', '2', '70012');
INSERT INTO `t_eternal` VALUES ('5020019', '毕方之魂·水', '5020017', '3', '3', '1950', '10', '蕴含毕方之力的魂魄，能够增加水属性的伤害。', '2', '70013');
INSERT INTO `t_eternal` VALUES ('5020020', '毕方之魂·光', '5020017', '5', '3', '1950', '10', '蕴含毕方之力的魂魄，能够增加光属性的伤害。', '2', '70014');
INSERT INTO `t_eternal` VALUES ('5020021', '毕方之魂·暗', '5020017', '4', '3', '1950', '10', '蕴含毕方之力的魂魄，能够增加暗属性的伤害。', '2', '70015');
INSERT INTO `t_eternal` VALUES ('5020022', '旋龟之魂·火', '5020022', '1', '3', '1950', '10', '蕴含旋龟之力的魂魄，能够减少受到的火属性的伤害。', '2', '70016');
INSERT INTO `t_eternal` VALUES ('5020023', '旋龟之魂·木', '5020022', '2', '3', '1950', '10', '蕴含旋龟之力的魂魄，能够减少受到的木属性的伤害。', '2', '70017');
INSERT INTO `t_eternal` VALUES ('5020024', '旋龟之魂·水', '5020022', '3', '3', '1950', '10', '蕴含旋龟之力的魂魄，能够减少受到的水属性的伤害。', '2', '70018');
INSERT INTO `t_eternal` VALUES ('5020025', '旋龟之魂·光', '5020022', '5', '3', '1950', '10', '蕴含旋龟之力的魂魄，能够减少受到的光属性的伤害。', '2', '70019');
INSERT INTO `t_eternal` VALUES ('5020026', '旋龟之魂·暗', '5020022', '4', '3', '1950', '10', '蕴含旋龟之力的魂魄，能够减少受到的暗属性的伤害。', '2', '70020');
INSERT INTO `t_eternal` VALUES ('5020027', '夸父之魂·火', '5020027', '1', '4', '1950', '10', '蕴含夸父之力的魂魄，当移动距离等于2时，造成的攻击增加。', '2', '70021');
INSERT INTO `t_eternal` VALUES ('5020028', '夸父之魂·木', '5020027', '2', '4', '1950', '10', '蕴含夸父之力的魂魄，当移动距离等于2时，造成的攻击增加。', '2', '70021');
INSERT INTO `t_eternal` VALUES ('5020029', '夸父之魂·水', '5020027', '3', '4', '1950', '10', '蕴含夸父之力的魂魄，当移动距离等于2时，造成的攻击增加。', '2', '70021');
INSERT INTO `t_eternal` VALUES ('5020030', '夸父之魂·光', '5020027', '5', '4', '1950', '10', '蕴含夸父之力的魂魄，当移动距离等于2时，造成的攻击增加。', '2', '70021');
INSERT INTO `t_eternal` VALUES ('5020031', '夸父之魂·暗', '5020027', '4', '4', '1950', '10', '蕴含夸父之力的魂魄，当移动距离等于2时，造成的攻击增加。', '2', '70021');
INSERT INTO `t_eternal` VALUES ('5020032', '陆吾之魂·火', '5020032', '1', '4', '1950', '10', '蕴含陆吾之力的魂魄，本回合不进行移动时能够减伤。', '2', '70022');
INSERT INTO `t_eternal` VALUES ('5020033', '陆吾之魂·木', '5020032', '2', '4', '1950', '10', '蕴含陆吾之力的魂魄，本回合不进行移动时能够减伤。', '2', '70022');
INSERT INTO `t_eternal` VALUES ('5020034', '陆吾之魂·水', '5020032', '3', '4', '1950', '10', '蕴含陆吾之力的魂魄，本回合不进行移动时能够减伤。', '2', '70022');
INSERT INTO `t_eternal` VALUES ('5020035', '陆吾之魂·光', '5020032', '5', '4', '1950', '10', '蕴含陆吾之力的魂魄，本回合不进行移动时能够减伤。', '2', '70022');
INSERT INTO `t_eternal` VALUES ('5020036', '陆吾之魂·暗', '5020032', '4', '4', '1950', '10', '蕴含陆吾之力的魂魄，本回合不进行移动时能够减伤。', '2', '70022');
INSERT INTO `t_eternal` VALUES ('5020037', '英招之魂·火', '5020037', '1', '4', '1950', '10', '蕴含英招之力的魂魄，移动力提升。', '2', '70023');
INSERT INTO `t_eternal` VALUES ('5020038', '英招之魂·木', '5020037', '2', '4', '1950', '10', '蕴含英招之力的魂魄，移动力提升。', '2', '70023');
INSERT INTO `t_eternal` VALUES ('5020039', '英招之魂·水', '5020037', '3', '4', '1950', '10', '蕴含英招之力的魂魄，移动力提升。', '2', '70023');
INSERT INTO `t_eternal` VALUES ('5020040', '英招之魂·光', '5020037', '5', '4', '1950', '10', '蕴含英招之力的魂魄，移动力提升。', '2', '70023');
INSERT INTO `t_eternal` VALUES ('5020041', '英招之魂·暗', '5020037', '4', '4', '1950', '10', '蕴含英招之力的魂魄，移动力提升。', '2', '70023');
INSERT INTO `t_eternal` VALUES ('5020042', '相柳之魂·火', '5020042', '1', '5', '1950', '10', '蕴含相柳之力的魂魄，战斗前3回合，受到的伤害降低。', '2', '70024');
INSERT INTO `t_eternal` VALUES ('5020043', '相柳之魂·木', '5020042', '2', '5', '1950', '10', '蕴含相柳之力的魂魄，战斗前3回合，受到的伤害降低。', '2', '70024');
INSERT INTO `t_eternal` VALUES ('5020044', '相柳之魂·水', '5020042', '3', '5', '1950', '10', '蕴含相柳之力的魂魄，战斗前3回合，受到的伤害降低。', '2', '70024');
INSERT INTO `t_eternal` VALUES ('5020045', '相柳之魂·光', '5020042', '5', '5', '1950', '10', '蕴含相柳之力的魂魄，战斗前3回合，受到的伤害降低。', '2', '70024');
INSERT INTO `t_eternal` VALUES ('5020046', '相柳之魂·暗', '5020042', '4', '5', '1950', '10', '蕴含相柳之力的魂魄，战斗前3回合，受到的伤害降低。', '2', '70024');
INSERT INTO `t_eternal` VALUES ('5020047', '魍魉之魂·火', '5020047', '1', '5', '1950', '10', '蕴含魍魉之力的魂魄，只攻击一个目标时，攻击提升。', '2', '70025');
INSERT INTO `t_eternal` VALUES ('5020048', '魍魉之魂·木', '5020047', '2', '5', '1950', '10', '蕴含魍魉之力的魂魄，只攻击一个目标时，攻击提升。', '2', '70025');
INSERT INTO `t_eternal` VALUES ('5020049', '魍魉之魂·水', '5020047', '3', '5', '1950', '10', '蕴含魍魉之力的魂魄，只攻击一个目标时，攻击提升。', '2', '70025');
INSERT INTO `t_eternal` VALUES ('5020050', '魍魉之魂·光', '5020047', '5', '5', '1950', '10', '蕴含魍魉之力的魂魄，只攻击一个目标时，攻击提升。', '2', '70025');
INSERT INTO `t_eternal` VALUES ('5020051', '魍魉之魂·暗', '5020047', '4', '5', '1950', '10', '蕴含魍魉之力的魂魄，只攻击一个目标时，攻击提升。', '2', '70025');
INSERT INTO `t_eternal` VALUES ('5020052', '女娲之魂·火', '5020052', '1', '6', '1950', '10', '蕴含女娲之力的魂魄，免疫所有状态效果，包括增益和减益。', '2', '70026');
INSERT INTO `t_eternal` VALUES ('5020053', '女娲之魂·木', '5020052', '2', '6', '1950', '10', '蕴含女娲之力的魂魄，免疫所有状态效果，包括增益和减益。', '2', '70026');
INSERT INTO `t_eternal` VALUES ('5020054', '女娲之魂·水', '5020052', '3', '6', '1950', '10', '蕴含女娲之力的魂魄，免疫所有状态效果，包括增益和减益。', '2', '70026');
INSERT INTO `t_eternal` VALUES ('5020055', '女娲之魂·光', '5020052', '5', '6', '1950', '10', '蕴含女娲之力的魂魄，免疫所有状态效果，包括增益和减益。', '2', '70026');
INSERT INTO `t_eternal` VALUES ('5020056', '女娲之魂·暗', '5020052', '4', '6', '1950', '10', '蕴含女娲之力的魂魄，免疫所有状态效果，包括增益和减益。', '2', '70026');
INSERT INTO `t_eternal` VALUES ('5020057', '穷奇之魂·火', '5020057', '1', '6', '1950', '10', '蕴含穷奇之力的魂魄，连续两回合未造成伤害时，下一回合伤害提升。', '2', '70027');
INSERT INTO `t_eternal` VALUES ('5020058', '穷奇之魂·木', '5020057', '2', '6', '1950', '10', '蕴含穷奇之力的魂魄，连续两回合未造成伤害时，下一回合伤害提升。', '2', '70027');
INSERT INTO `t_eternal` VALUES ('5020059', '穷奇之魂·水', '5020057', '3', '6', '1950', '10', '蕴含穷奇之力的魂魄，连续两回合未造成伤害时，下一回合伤害提升。', '2', '70027');
INSERT INTO `t_eternal` VALUES ('5020060', '穷奇之魂·光', '5020057', '5', '6', '1950', '10', '蕴含穷奇之力的魂魄，连续两回合未造成伤害时，下一回合伤害提升。', '2', '70027');
INSERT INTO `t_eternal` VALUES ('5020061', '穷奇之魂·暗', '5020057', '4', '6', '1950', '10', '蕴含穷奇之力的魂魄，连续两回合未造成伤害时，下一回合伤害提升。', '2', '70027');
INSERT INTO `t_eternal` VALUES ('5020062', '重明之魂·火', '5020062', '1', '6', '1950', '10', '蕴含重明之力的魂魄，攻击次数增加2次。', '2', '70028');
INSERT INTO `t_eternal` VALUES ('5020063', '重明之魂·木', '5020062', '2', '6', '1950', '10', '蕴含重明之力的魂魄，攻击次数增加2次。', '2', '70028');
INSERT INTO `t_eternal` VALUES ('5020064', '重明之魂·水', '5020062', '3', '6', '1950', '10', '蕴含重明之力的魂魄，攻击次数增加2次。', '2', '70028');
INSERT INTO `t_eternal` VALUES ('5020065', '重明之魂·光', '5020062', '5', '6', '1950', '10', '蕴含重明之力的魂魄，攻击次数增加2次。', '2', '70028');
INSERT INTO `t_eternal` VALUES ('5020066', '重明之魂·暗', '5020062', '4', '6', '1950', '10', '蕴含重明之力的魂魄，攻击次数增加2次。', '2', '70028');

-- ----------------------------
-- Table structure for t_eternal_effect
-- ----------------------------
DROP TABLE IF EXISTS `t_eternal_effect`;
CREATE TABLE `t_eternal_effect` (
  `eternal_id` int(11) NOT NULL COMMENT '武魂标号',
  `effect_type` int(11) NOT NULL COMMENT '效果类型',
  `score` int(11) NOT NULL COMMENT '分数',
  `cons` int(11) NOT NULL COMMENT '实数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_eternal_effect
-- ----------------------------
INSERT INTO `t_eternal_effect` VALUES ('5010001', '19', '0', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010002', '21', '0', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010003', '22', '0', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010004', '23', '0', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010005', '25', '0', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010006', '26', '0', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010007', '10', '0', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010008', '11', '0', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010009', '27', '0', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010010', '28', '0', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010011', '29', '0', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010012', '30', '0', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010013', '31', '0', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010014', '32', '0', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010015', '33', '0', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010016', '12', '0', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010017', '12', '0', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010017', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010018', '12', '0', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010018', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010018', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010019', '12', '0', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010019', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010019', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010019', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010020', '12', '0', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010020', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010020', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010020', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010020', '37', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010021', '12', '0', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010021', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010022', '12', '0', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010022', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010022', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010023', '12', '0', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010023', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010023', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010023', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010024', '12', '0', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010024', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010024', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010024', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010024', '37', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010025', '12', '0', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010025', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010025', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010025', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010025', '37', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010025', '38', '0', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010026', '13', '1000', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010027', '13', '0', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010027', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010028', '13', '2000', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010028', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010028', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010029', '13', '2000', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010029', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010029', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010029', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010030', '13', '2000', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010030', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010030', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010030', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010030', '37', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010031', '13', '2000', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010031', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010032', '13', '2000', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010032', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010032', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010033', '13', '0', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010033', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010033', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010033', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010034', '13', '1000', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010034', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010034', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010034', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010034', '37', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010035', '13', '2000', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010035', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010035', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010035', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010035', '37', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010035', '38', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010036', '14', '1000', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010037', '14', '2000', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010037', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010038', '14', '1000', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010038', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010038', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010039', '14', '2000', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010039', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010039', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010039', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010040', '14', '1000', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010040', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010040', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010040', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010040', '37', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010041', '14', '2000', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010041', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010042', '14', '1000', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010042', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010042', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010043', '14', '2000', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010043', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010043', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010043', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010044', '14', '1000', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010044', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010044', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010044', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010044', '37', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010045', '14', '1000', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010045', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010045', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010045', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010045', '37', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010045', '38', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010046', '15', '0', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010047', '15', '1000', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010047', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010048', '15', '1000', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010048', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010048', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010049', '15', '1000', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010049', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010049', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010049', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010050', '15', '0', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010050', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010050', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010050', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010050', '37', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010051', '15', '1000', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010051', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010052', '15', '1000', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010052', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010052', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010053', '15', '1000', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010053', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010053', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010053', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010054', '15', '0', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010054', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010054', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010054', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010054', '37', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010055', '15', '0', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010055', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010055', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010055', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010055', '37', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010055', '38', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010056', '16', '2000', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010057', '16', '1000', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010057', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010058', '16', '0', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010058', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010058', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010059', '16', '1000', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010059', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010059', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010059', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010060', '16', '0', '1');
INSERT INTO `t_eternal_effect` VALUES ('5010060', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010060', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010060', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010060', '37', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010061', '16', '2000', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010061', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010062', '16', '0', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010062', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010062', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010063', '16', '1000', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010063', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010063', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010063', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010064', '16', '2000', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010064', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010064', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010064', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010064', '37', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010065', '16', '0', '2');
INSERT INTO `t_eternal_effect` VALUES ('5010065', '34', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010065', '35', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010065', '36', '1000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010065', '37', '2000', '0');
INSERT INTO `t_eternal_effect` VALUES ('5010065', '38', '2000', '0');

-- ----------------------------
-- Table structure for t_eternal_property
-- ----------------------------
DROP TABLE IF EXISTS `t_eternal_property`;
CREATE TABLE `t_eternal_property` (
  `quality` int(11) NOT NULL COMMENT '星级',
  `skill_type` int(11) NOT NULL COMMENT '属性类型',
  `skill_rate` double NOT NULL COMMENT '出现的概率',
  `start_num` double NOT NULL COMMENT '起始数',
  `end_num` double NOT NULL COMMENT '结尾数',
  `atk_mode` varchar(50) NOT NULL COMMENT '攻击方向',
  `type` int(11) NOT NULL COMMENT '属性类别'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_eternal_property
-- ----------------------------
INSERT INTO `t_eternal_property` VALUES ('1', '100', '0.2', '50', '100', '', '1');
INSERT INTO `t_eternal_property` VALUES ('1', '101', '0.2', '0.2', '0.4', '', '1');
INSERT INTO `t_eternal_property` VALUES ('1', '102', '0.2', '200', '400', '', '1');
INSERT INTO `t_eternal_property` VALUES ('1', '103', '0.2', '0.2', '0.4', '', '1');
INSERT INTO `t_eternal_property` VALUES ('1', '105', '0.2', '1', '0', '', '1');
INSERT INTO `t_eternal_property` VALUES ('1', '1000', '0.1', '0.05', '0.1', '', '2');
INSERT INTO `t_eternal_property` VALUES ('1', '1001', '0.2', '0.1', '0.2', '', '2');
INSERT INTO `t_eternal_property` VALUES ('1', '1002', '0.1', '0.05', '0.1', '', '2');
INSERT INTO `t_eternal_property` VALUES ('1', '1003', '0.2', '0.1', '0.2', '', '2');
INSERT INTO `t_eternal_property` VALUES ('1', '1004', '0.4', '0.02', '0.05', '', '2');
INSERT INTO `t_eternal_property` VALUES ('2', '100', '0.2', '100', '200', '', '1');
INSERT INTO `t_eternal_property` VALUES ('2', '101', '0.2', '0.4', '0.8', '', '1');
INSERT INTO `t_eternal_property` VALUES ('2', '102', '0.2', '400', '800', '', '1');
INSERT INTO `t_eternal_property` VALUES ('2', '103', '0.2', '0.4', '0.8', '', '1');
INSERT INTO `t_eternal_property` VALUES ('2', '105', '0.2', '1', '0', '', '1');
INSERT INTO `t_eternal_property` VALUES ('2', '1000', '0.1', '0.1', '0.2', '', '2');
INSERT INTO `t_eternal_property` VALUES ('2', '1001', '0.2', '0.2', '0.4', '', '2');
INSERT INTO `t_eternal_property` VALUES ('2', '1002', '0.1', '0.1', '0.2', '', '2');
INSERT INTO `t_eternal_property` VALUES ('2', '1003', '0.2', '0.2', '0.4', '', '2');
INSERT INTO `t_eternal_property` VALUES ('2', '1004', '0.4', '0.04', '0.1', '', '2');
INSERT INTO `t_eternal_property` VALUES ('3', '100', '0.2', '150', '300', '', '1');
INSERT INTO `t_eternal_property` VALUES ('3', '101', '0.2', '0.6000000000000001', '1.2000000000000002', '', '1');
INSERT INTO `t_eternal_property` VALUES ('3', '102', '0.2', '600', '1200', '', '1');
INSERT INTO `t_eternal_property` VALUES ('3', '103', '0.2', '0.6000000000000001', '1.2000000000000002', '', '1');
INSERT INTO `t_eternal_property` VALUES ('3', '105', '0.2', '1', '0', '', '1');
INSERT INTO `t_eternal_property` VALUES ('3', '1000', '0.1', '0.15000000000000002', '0.30000000000000004', '', '2');
INSERT INTO `t_eternal_property` VALUES ('3', '1001', '0.2', '0.30000000000000004', '0.6000000000000001', '', '2');
INSERT INTO `t_eternal_property` VALUES ('3', '1002', '0.1', '0.15000000000000002', '0.30000000000000004', '', '2');
INSERT INTO `t_eternal_property` VALUES ('3', '1003', '0.2', '0.30000000000000004', '0.6000000000000001', '', '2');
INSERT INTO `t_eternal_property` VALUES ('3', '1004', '0.4', '0.06', '0.15000000000000002', '', '2');
INSERT INTO `t_eternal_property` VALUES ('4', '100', '0.2', '200', '400', '', '1');
INSERT INTO `t_eternal_property` VALUES ('4', '101', '0.2', '0.8', '1.6', '', '1');
INSERT INTO `t_eternal_property` VALUES ('4', '102', '0.2', '800', '1600', '', '1');
INSERT INTO `t_eternal_property` VALUES ('4', '103', '0.2', '0.8', '1.6', '', '1');
INSERT INTO `t_eternal_property` VALUES ('4', '105', '0.2', '1', '0', '', '1');
INSERT INTO `t_eternal_property` VALUES ('4', '1000', '0.1', '0.2', '0.4', '', '2');
INSERT INTO `t_eternal_property` VALUES ('4', '1001', '0.2', '0.4', '0.8', '', '2');
INSERT INTO `t_eternal_property` VALUES ('4', '1002', '0.1', '0.2', '0.4', '', '2');
INSERT INTO `t_eternal_property` VALUES ('4', '1003', '0.2', '0.4', '0.8', '', '2');
INSERT INTO `t_eternal_property` VALUES ('4', '1004', '0.4', '0.08', '0.2', '', '2');
INSERT INTO `t_eternal_property` VALUES ('5', '100', '0.2', '250', '500', '', '1');
INSERT INTO `t_eternal_property` VALUES ('5', '101', '0.2', '1', '2', '', '1');
INSERT INTO `t_eternal_property` VALUES ('5', '102', '0.2', '1000', '2000', '', '1');
INSERT INTO `t_eternal_property` VALUES ('5', '103', '0.2', '1', '2', '', '1');
INSERT INTO `t_eternal_property` VALUES ('5', '105', '0.2', '1', '0', '', '1');
INSERT INTO `t_eternal_property` VALUES ('5', '1000', '0.1', '0.25', '0.5', '', '2');
INSERT INTO `t_eternal_property` VALUES ('5', '1001', '0.2', '0.5', '1', '', '2');
INSERT INTO `t_eternal_property` VALUES ('5', '1002', '0.1', '0.25', '0.5', '', '2');
INSERT INTO `t_eternal_property` VALUES ('5', '1003', '0.2', '0.5', '1', '', '2');
INSERT INTO `t_eternal_property` VALUES ('5', '1004', '0.4', '0.1', '0.25', '', '2');
INSERT INTO `t_eternal_property` VALUES ('6', '100', '0.2', '300', '600', '', '1');
INSERT INTO `t_eternal_property` VALUES ('6', '101', '0.2', '1.2', '2.4', '', '1');
INSERT INTO `t_eternal_property` VALUES ('6', '102', '0.2', '1200', '2400', '', '1');
INSERT INTO `t_eternal_property` VALUES ('6', '103', '0.2', '1.2', '2.4', '', '1');
INSERT INTO `t_eternal_property` VALUES ('6', '105', '0.2', '1', '0', '', '1');
INSERT INTO `t_eternal_property` VALUES ('6', '1000', '0.1', '0.3', '0.6', '', '2');
INSERT INTO `t_eternal_property` VALUES ('6', '1001', '0.2', '0.6', '1.2', '', '2');
INSERT INTO `t_eternal_property` VALUES ('6', '1002', '0.1', '0.3', '0.6', '', '2');
INSERT INTO `t_eternal_property` VALUES ('6', '1003', '0.2', '0.6', '1.2', '', '2');
INSERT INTO `t_eternal_property` VALUES ('6', '1004', '0.4', '0.12000000000000001', '0.3', '', '2');
INSERT INTO `t_eternal_property` VALUES ('7', '100', '0.2', '350', '700', '', '1');
INSERT INTO `t_eternal_property` VALUES ('7', '101', '0.2', '1.4', '2.8', '', '1');
INSERT INTO `t_eternal_property` VALUES ('7', '102', '0.2', '1400', '2800', '', '1');
INSERT INTO `t_eternal_property` VALUES ('7', '103', '0.2', '1.4', '2.8', '', '1');
INSERT INTO `t_eternal_property` VALUES ('7', '105', '0.2', '1', '0', '', '1');
INSERT INTO `t_eternal_property` VALUES ('7', '1000', '0.1', '0.35', '0.7', '', '2');
INSERT INTO `t_eternal_property` VALUES ('7', '1001', '0.2', '0.7', '1.4', '', '2');
INSERT INTO `t_eternal_property` VALUES ('7', '1002', '0.1', '0.35', '0.7', '', '2');
INSERT INTO `t_eternal_property` VALUES ('7', '1003', '0.2', '0.7', '1.4', '', '2');
INSERT INTO `t_eternal_property` VALUES ('7', '1004', '0.4', '0.14', '0.35', '', '2');
INSERT INTO `t_eternal_property` VALUES ('8', '100', '0.2', '400', '800', '', '1');
INSERT INTO `t_eternal_property` VALUES ('8', '101', '0.2', '1.5999999999999999', '3.1999999999999997', '', '1');
INSERT INTO `t_eternal_property` VALUES ('8', '102', '0.2', '1600', '3200', '', '1');
INSERT INTO `t_eternal_property` VALUES ('8', '103', '0.2', '1.5999999999999999', '3.1999999999999997', '', '1');
INSERT INTO `t_eternal_property` VALUES ('8', '105', '0.2', '1', '0', '', '1');
INSERT INTO `t_eternal_property` VALUES ('8', '1000', '0.1', '0.39999999999999997', '0.7999999999999999', '', '2');
INSERT INTO `t_eternal_property` VALUES ('8', '1001', '0.2', '0.7999999999999999', '1.5999999999999999', '', '2');
INSERT INTO `t_eternal_property` VALUES ('8', '1002', '0.1', '0.39999999999999997', '0.7999999999999999', '', '2');
INSERT INTO `t_eternal_property` VALUES ('8', '1003', '0.2', '0.7999999999999999', '1.5999999999999999', '', '2');
INSERT INTO `t_eternal_property` VALUES ('8', '1004', '0.4', '0.16', '0.39999999999999997', '', '2');
INSERT INTO `t_eternal_property` VALUES ('9', '100', '0.2', '450', '900', '', '1');
INSERT INTO `t_eternal_property` VALUES ('9', '101', '0.2', '1.7999999999999998', '3.5999999999999996', '', '1');
INSERT INTO `t_eternal_property` VALUES ('9', '102', '0.2', '1800', '3600', '', '1');
INSERT INTO `t_eternal_property` VALUES ('9', '103', '0.2', '1.7999999999999998', '3.5999999999999996', '', '1');
INSERT INTO `t_eternal_property` VALUES ('9', '105', '0.2', '1', '0', '', '1');
INSERT INTO `t_eternal_property` VALUES ('9', '1000', '0.1', '0.44999999999999996', '0.8999999999999999', '', '2');
INSERT INTO `t_eternal_property` VALUES ('9', '1001', '0.2', '0.8999999999999999', '1.7999999999999998', '', '2');
INSERT INTO `t_eternal_property` VALUES ('9', '1002', '0.1', '0.44999999999999996', '0.8999999999999999', '', '2');
INSERT INTO `t_eternal_property` VALUES ('9', '1003', '0.2', '0.8999999999999999', '1.7999999999999998', '', '2');
INSERT INTO `t_eternal_property` VALUES ('9', '1004', '0.4', '0.18', '0.44999999999999996', '', '2');
INSERT INTO `t_eternal_property` VALUES ('10', '100', '0.2', '500', '1000', '', '1');
INSERT INTO `t_eternal_property` VALUES ('10', '101', '0.2', '1.9999999999999998', '3.9999999999999996', '', '1');
INSERT INTO `t_eternal_property` VALUES ('10', '102', '0.2', '2000', '4000', '', '1');
INSERT INTO `t_eternal_property` VALUES ('10', '103', '0.2', '1.9999999999999998', '3.9999999999999996', '', '1');
INSERT INTO `t_eternal_property` VALUES ('10', '105', '0.2', '1', '0', '', '1');
INSERT INTO `t_eternal_property` VALUES ('10', '1000', '0.1', '0.49999999999999994', '0.9999999999999999', '', '2');
INSERT INTO `t_eternal_property` VALUES ('10', '1001', '0.2', '0.9999999999999999', '1.9999999999999998', '', '2');
INSERT INTO `t_eternal_property` VALUES ('10', '1002', '0.1', '0.49999999999999994', '0.9999999999999999', '', '2');
INSERT INTO `t_eternal_property` VALUES ('10', '1003', '0.2', '0.9999999999999999', '1.9999999999999998', '', '2');
INSERT INTO `t_eternal_property` VALUES ('10', '1004', '0.4', '0.19999999999999998', '0.49999999999999994', '', '2');

-- ----------------------------
-- Table structure for t_explore_award
-- ----------------------------
DROP TABLE IF EXISTS `t_explore_award`;
CREATE TABLE `t_explore_award` (
  `array_id` int(11) NOT NULL COMMENT '数组编号',
  `goods_id` int(11) NOT NULL COMMENT '物品编号',
  `type` int(11) NOT NULL COMMENT '类型',
  `num` int(11) NOT NULL COMMENT '数量',
  `level` int(11) NOT NULL COMMENT '等级',
  `rate` int(11) NOT NULL COMMENT '概率'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_explore_award
-- ----------------------------
INSERT INTO `t_explore_award` VALUES ('1', '1', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '3', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '5', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '2', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '4', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '6', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '7', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '8', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '9', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '10', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '12', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '15', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '16', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '17', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '20', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '21', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '22', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '31', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '33', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '37', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('1', '0', '2', '1000', '0', '1500');
INSERT INTO `t_explore_award` VALUES ('1', '0', '2', '2000', '0', '500');
INSERT INTO `t_explore_award` VALUES ('1', '0', '5', '20', '0', '1000');
INSERT INTO `t_explore_award` VALUES ('1', '1', '4', '1', '0', '500');
INSERT INTO `t_explore_award` VALUES ('2', '1', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '3', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '5', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '2', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '4', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '6', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '7', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '8', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '9', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '10', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '12', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '15', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '16', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '17', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '20', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '21', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '22', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '31', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '33', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '37', '1', '1', '1', '325');
INSERT INTO `t_explore_award` VALUES ('2', '0', '2', '1000', '0', '500');
INSERT INTO `t_explore_award` VALUES ('2', '0', '2', '2000', '0', '1500');
INSERT INTO `t_explore_award` VALUES ('2', '0', '5', '40', '0', '1000');
INSERT INTO `t_explore_award` VALUES ('2', '1', '4', '1', '0', '200');
INSERT INTO `t_explore_award` VALUES ('2', '4', '4', '1', '0', '300');
INSERT INTO `t_explore_award` VALUES ('3', '1', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '3', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '5', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '2', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '4', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '6', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '7', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '8', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '9', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '10', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '12', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '15', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '16', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '17', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '20', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '21', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '22', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '31', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '33', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '37', '1', '1', '1', '215');
INSERT INTO `t_explore_award` VALUES ('3', '11', '1', '1', '1', '220');
INSERT INTO `t_explore_award` VALUES ('3', '13', '1', '1', '1', '220');
INSERT INTO `t_explore_award` VALUES ('3', '18', '1', '1', '1', '220');
INSERT INTO `t_explore_award` VALUES ('3', '24', '1', '1', '1', '220');
INSERT INTO `t_explore_award` VALUES ('3', '25', '1', '1', '1', '220');
INSERT INTO `t_explore_award` VALUES ('3', '26', '1', '1', '1', '220');
INSERT INTO `t_explore_award` VALUES ('3', '27', '1', '1', '1', '220');
INSERT INTO `t_explore_award` VALUES ('3', '28', '1', '1', '1', '220');
INSERT INTO `t_explore_award` VALUES ('3', '29', '1', '1', '1', '220');
INSERT INTO `t_explore_award` VALUES ('3', '32', '1', '1', '1', '220');
INSERT INTO `t_explore_award` VALUES ('3', '0', '2', '2000', '0', '1500');
INSERT INTO `t_explore_award` VALUES ('3', '0', '5', '100', '0', '1000');
INSERT INTO `t_explore_award` VALUES ('3', '1', '4', '1', '0', '400');
INSERT INTO `t_explore_award` VALUES ('3', '4', '4', '1', '0', '300');
INSERT INTO `t_explore_award` VALUES ('3', '5', '4', '1', '0', '300');
INSERT INTO `t_explore_award` VALUES ('101', '12', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('101', '15', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('101', '16', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('101', '17', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('101', '20', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('101', '21', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('101', '22', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('101', '31', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('101', '33', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('101', '37', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('102', '12', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('102', '15', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('102', '16', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('102', '17', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('102', '20', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('102', '21', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('102', '22', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('102', '31', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('102', '33', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('102', '37', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('103', '12', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('103', '15', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('103', '16', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('103', '17', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('103', '20', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('103', '21', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('103', '22', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('103', '31', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('103', '33', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('103', '37', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('104', '12', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('104', '15', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('104', '16', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('104', '17', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('104', '20', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('104', '21', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('104', '22', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('104', '31', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('104', '33', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('104', '37', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('105', '11', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('105', '13', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('105', '18', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('105', '24', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('105', '25', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('105', '26', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('105', '27', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('105', '28', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('105', '29', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('105', '32', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('106', '11', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('106', '13', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('106', '18', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('106', '24', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('106', '25', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('106', '26', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('106', '27', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('106', '28', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('106', '29', '1', '1', '1', '1000');
INSERT INTO `t_explore_award` VALUES ('106', '32', '1', '1', '1', '1000');

-- ----------------------------
-- Table structure for t_fame
-- ----------------------------
DROP TABLE IF EXISTS `t_fame`;
CREATE TABLE `t_fame` (
  `fame_level` int(11) NOT NULL COMMENT '名望等级',
  `name` varchar(50) NOT NULL COMMENT '名望名称',
  `slate` int(11) NOT NULL COMMENT '所需石板'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_fame
-- ----------------------------
INSERT INTO `t_fame` VALUES ('1', '名望1阶', '100');
INSERT INTO `t_fame` VALUES ('2', '名望2阶', '200');
INSERT INTO `t_fame` VALUES ('3', '名望3阶', '300');
INSERT INTO `t_fame` VALUES ('4', '名望4阶', '400');
INSERT INTO `t_fame` VALUES ('5', '名望5阶', '500');
INSERT INTO `t_fame` VALUES ('6', '名望6阶', '600');
INSERT INTO `t_fame` VALUES ('7', '名望7阶', '700');
INSERT INTO `t_fame` VALUES ('8', '名望8阶', '800');
INSERT INTO `t_fame` VALUES ('9', '名望9阶', '900');
INSERT INTO `t_fame` VALUES ('10', '名望10阶', '1000');
INSERT INTO `t_fame` VALUES ('11', '名望11阶', '1100');
INSERT INTO `t_fame` VALUES ('12', '名望12阶', '1200');
INSERT INTO `t_fame` VALUES ('13', '名望13阶', '1300');
INSERT INTO `t_fame` VALUES ('14', '名望14阶', '1400');
INSERT INTO `t_fame` VALUES ('15', '名望15阶', '1500');
INSERT INTO `t_fame` VALUES ('16', '名望16阶', '1600');
INSERT INTO `t_fame` VALUES ('17', '名望17阶', '1700');
INSERT INTO `t_fame` VALUES ('18', '名望18阶', '1800');
INSERT INTO `t_fame` VALUES ('19', '名望19阶', '1900');
INSERT INTO `t_fame` VALUES ('20', '名望20阶', '2000');

-- ----------------------------
-- Table structure for t_fame_award
-- ----------------------------
DROP TABLE IF EXISTS `t_fame_award`;
CREATE TABLE `t_fame_award` (
  `fame_level` int(11) NOT NULL COMMENT '名望等级',
  `goods_id` int(11) NOT NULL COMMENT '奖励ID',
  `type` int(11) NOT NULL COMMENT '物品类型',
  `num` int(11) NOT NULL COMMENT '数量',
  `level` int(11) NOT NULL COMMENT '等级'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_fame_award
-- ----------------------------
INSERT INTO `t_fame_award` VALUES ('1', '5020007', '7', '1', '1');
INSERT INTO `t_fame_award` VALUES ('1', '3030003', '6', '1', '1');
INSERT INTO `t_fame_award` VALUES ('1', '4020001', '4', '5', '1');
INSERT INTO `t_fame_award` VALUES ('1', '0', '3', '12345', '1');
INSERT INTO `t_fame_award` VALUES ('1', '0', '2', '1234', '1');
INSERT INTO `t_fame_award` VALUES ('1', '82005', '1', '1', '40');
INSERT INTO `t_fame_award` VALUES ('1', '82003', '1', '1', '40');
INSERT INTO `t_fame_award` VALUES ('2', '5020008', '7', '1', '0');
INSERT INTO `t_fame_award` VALUES ('2', '3030006', '6', '1', '1');
INSERT INTO `t_fame_award` VALUES ('2', '4020008', '4', '2', '1');
INSERT INTO `t_fame_award` VALUES ('2', '0', '3', '999999', '1');
INSERT INTO `t_fame_award` VALUES ('2', '0', '2', '999999', '1');
INSERT INTO `t_fame_award` VALUES ('2', '90004', '1', '1', '1');
INSERT INTO `t_fame_award` VALUES ('3', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('4', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('5', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('6', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('7', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('8', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('9', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('10', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('11', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('12', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('13', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('14', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('15', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('16', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('17', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('18', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('19', '0', '3', '999', '1');
INSERT INTO `t_fame_award` VALUES ('20', '0', '3', '999', '1');

-- ----------------------------
-- Table structure for t_fame_buff
-- ----------------------------
DROP TABLE IF EXISTS `t_fame_buff`;
CREATE TABLE `t_fame_buff` (
  `fame_level` int(11) NOT NULL COMMENT '名望等级',
  `effect_id` int(11) NOT NULL COMMENT '属性类型',
  `score` int(11) NOT NULL COMMENT '万分比',
  `cons` int(11) NOT NULL COMMENT '值'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_fame_buff
-- ----------------------------
INSERT INTO `t_fame_buff` VALUES ('1', '3', '1000', '0');
INSERT INTO `t_fame_buff` VALUES ('1', '27', '1000', '0');
INSERT INTO `t_fame_buff` VALUES ('2', '3', '1200', '0');
INSERT INTO `t_fame_buff` VALUES ('2', '27', '1200', '0');
INSERT INTO `t_fame_buff` VALUES ('3', '3', '1400', '0');
INSERT INTO `t_fame_buff` VALUES ('3', '27', '1400', '0');
INSERT INTO `t_fame_buff` VALUES ('4', '3', '1600', '0');
INSERT INTO `t_fame_buff` VALUES ('4', '27', '1600', '0');
INSERT INTO `t_fame_buff` VALUES ('5', '3', '1800', '0');
INSERT INTO `t_fame_buff` VALUES ('5', '27', '1800', '0');
INSERT INTO `t_fame_buff` VALUES ('6', '3', '2000', '0');
INSERT INTO `t_fame_buff` VALUES ('6', '27', '2000', '0');
INSERT INTO `t_fame_buff` VALUES ('7', '3', '2200', '0');
INSERT INTO `t_fame_buff` VALUES ('7', '27', '2200', '0');
INSERT INTO `t_fame_buff` VALUES ('8', '3', '2400', '0');
INSERT INTO `t_fame_buff` VALUES ('8', '27', '2400', '0');
INSERT INTO `t_fame_buff` VALUES ('9', '3', '2600', '0');
INSERT INTO `t_fame_buff` VALUES ('9', '27', '2600', '0');
INSERT INTO `t_fame_buff` VALUES ('10', '3', '2800', '0');
INSERT INTO `t_fame_buff` VALUES ('10', '27', '2800', '0');
INSERT INTO `t_fame_buff` VALUES ('11', '3', '3000', '0');
INSERT INTO `t_fame_buff` VALUES ('11', '27', '3000', '0');
INSERT INTO `t_fame_buff` VALUES ('12', '3', '3200', '0');
INSERT INTO `t_fame_buff` VALUES ('12', '27', '3200', '0');
INSERT INTO `t_fame_buff` VALUES ('13', '3', '3400', '0');
INSERT INTO `t_fame_buff` VALUES ('13', '27', '3400', '0');
INSERT INTO `t_fame_buff` VALUES ('14', '3', '3600', '0');
INSERT INTO `t_fame_buff` VALUES ('14', '27', '3600', '0');
INSERT INTO `t_fame_buff` VALUES ('15', '3', '3800', '0');
INSERT INTO `t_fame_buff` VALUES ('15', '27', '3800', '0');
INSERT INTO `t_fame_buff` VALUES ('16', '3', '4000', '0');
INSERT INTO `t_fame_buff` VALUES ('16', '27', '4000', '0');
INSERT INTO `t_fame_buff` VALUES ('17', '3', '4200', '0');
INSERT INTO `t_fame_buff` VALUES ('17', '27', '4200', '0');
INSERT INTO `t_fame_buff` VALUES ('18', '3', '4400', '0');
INSERT INTO `t_fame_buff` VALUES ('18', '27', '4400', '0');
INSERT INTO `t_fame_buff` VALUES ('19', '3', '4600', '0');
INSERT INTO `t_fame_buff` VALUES ('19', '27', '4600', '0');
INSERT INTO `t_fame_buff` VALUES ('20', '3', '4800', '0');
INSERT INTO `t_fame_buff` VALUES ('20', '27', '4800', '0');

-- ----------------------------
-- Table structure for t_guild_rank_award
-- ----------------------------
DROP TABLE IF EXISTS `t_guild_rank_award`;
CREATE TABLE `t_guild_rank_award` (
  `rank` int(11) NOT NULL COMMENT '排名',
  `goods_id` int(11) NOT NULL COMMENT '物品编号',
  `type` int(11) NOT NULL COMMENT '类型',
  `num` int(11) NOT NULL COMMENT '数量',
  `level` int(11) NOT NULL COMMENT '等级'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_guild_rank_award
-- ----------------------------
INSERT INTO `t_guild_rank_award` VALUES ('1', '39', '1', '1', '1');
INSERT INTO `t_guild_rank_award` VALUES ('1', '40', '1', '1', '1');
INSERT INTO `t_guild_rank_award` VALUES ('1', '41', '1', '1', '1');
INSERT INTO `t_guild_rank_award` VALUES ('1', '42', '1', '1', '1');
INSERT INTO `t_guild_rank_award` VALUES ('1', '43', '1', '1', '1');
INSERT INTO `t_guild_rank_award` VALUES ('1', '3', '4', '1', '0');
INSERT INTO `t_guild_rank_award` VALUES ('1', '6', '4', '1', '0');
INSERT INTO `t_guild_rank_award` VALUES ('1', '4', '4', '1', '0');
INSERT INTO `t_guild_rank_award` VALUES ('1', '5', '4', '1', '0');
INSERT INTO `t_guild_rank_award` VALUES ('2', '39', '1', '1', '1');
INSERT INTO `t_guild_rank_award` VALUES ('2', '40', '1', '1', '1');
INSERT INTO `t_guild_rank_award` VALUES ('2', '41', '1', '1', '1');
INSERT INTO `t_guild_rank_award` VALUES ('2', '42', '1', '1', '1');
INSERT INTO `t_guild_rank_award` VALUES ('2', '3', '4', '1', '0');
INSERT INTO `t_guild_rank_award` VALUES ('2', '4', '4', '1', '0');
INSERT INTO `t_guild_rank_award` VALUES ('3', '39', '1', '1', '1');
INSERT INTO `t_guild_rank_award` VALUES ('3', '40', '1', '1', '1');
INSERT INTO `t_guild_rank_award` VALUES ('3', '41', '1', '1', '1');
INSERT INTO `t_guild_rank_award` VALUES ('3', '3', '4', '1', '0');

-- ----------------------------
-- Table structure for t_hero
-- ----------------------------
DROP TABLE IF EXISTS `t_hero`;
CREATE TABLE `t_hero` (
  `hero_id` int(11) NOT NULL COMMENT 'Index',
  `card_id` int(11) NOT NULL COMMENT '图鉴编号',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `description` varchar(128) NOT NULL COMMENT '描述',
  `img` varchar(20) NOT NULL COMMENT '对应资源',
  `icon` varchar(20) NOT NULL COMMENT '头像',
  `quality` int(11) NOT NULL COMMENT '品质',
  `rare_degree` int(11) NOT NULL COMMENT '稀有度',
  `cost` int(11) NOT NULL COMMENT '领导力',
  `ele` int(11) NOT NULL COMMENT '属性',
  `ability` int(11) NOT NULL COMMENT '能力',
  `max_level` int(11) NOT NULL COMMENT '最高等级',
  `hp` double NOT NULL COMMENT '基础血量',
  `hp_up` double NOT NULL COMMENT 'HP成长值',
  `atk` double NOT NULL COMMENT '基础攻击力',
  `atk_up` double NOT NULL COMMENT '攻击力成长值',
  `atk_count` int(11) NOT NULL COMMENT '攻击次数',
  `atk_mode` varchar(50) NOT NULL COMMENT '攻击范围',
  `move_mode` varchar(50) NOT NULL COMMENT '移动方式',
  `block_rate` int(11) NOT NULL COMMENT '格挡率',
  `block_hit` int(11) NOT NULL COMMENT '格挡效果',
  `crit_rate` int(11) NOT NULL COMMENT '暴击率',
  `crit_hit` int(11) NOT NULL COMMENT '暴击伤害',
  `dodge_rate` int(11) NOT NULL COMMENT '躲闪率',
  `skill_id` int(11) NOT NULL COMMENT '技能编号',
  `cap_skill_id` int(11) NOT NULL COMMENT '队长技能编号',
  `passive_skills` varchar(50) NOT NULL COMMENT '被动技能',
  `sell_price` int(11) NOT NULL COMMENT '售价',
  `give_exp` int(11) NOT NULL COMMENT '1级产出经验',
  `hurt_effect` int(11) NOT NULL COMMENT '打击特效',
  `remark_1` int(11) NOT NULL COMMENT '伙伴特点',
  `hurt_type` int(11) NOT NULL COMMENT '普通攻击类型',
  `breakGroup` int(11) NOT NULL COMMENT '突破消耗组id',
  `breakAttrGroup` int(11) NOT NULL COMMENT '突破属性增加组id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hero
-- ----------------------------
INSERT INTO `t_hero` VALUES ('82001', '401', '山贼', '此路是我开！此树是我栽！', '1001001L', '1001001', '1', '1', '5', '1', '0', '20', '36', '12', '13', '4.3', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '100', '100', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82002', '402', '阴兵', '有我在此，谁敢进半步！', '1001003L', '1001003', '1', '1', '5', '4', '0', '20', '36', '12', '13', '4.3', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40002', '0', '', '100', '100', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82003', '403', '吕布', '吾乃九原吕奉先，谁敢一战', '1001005L', '1001005', '3', '1', '20', '1', '0', '100', '72', '24', '26', '8.6', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '900010', '60021', '50021', '500', '500', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82004', '404', '张角', '天公将军在此，八州三十六方教众何在？', '1001008L', '1001008', '3', '1', '20', '5', '0', '80', '90', '30', '7', '2.4', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40004', '60006', '50015', '400', '400', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82005', '405', '赵云', '末将常山赵子龙，何人与我七进七出', '1001011L', '1001011', '3', '1', '20', '3', '0', '100', '72', '24', '26', '8.6', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '900012', '60026', '50026', '500', '500', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82006', '406', '太史慈', '大丈夫生于乱世，当带三尺剑立不世之功；今所志未遂，奈何死乎！', '1001014L', '1001014', '3', '1', '20', '5', '0', '80', '72', '24', '26', '8.6', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '900009', '60004', '50003', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82007', '407', '士官', '虎痴许仲康，赤膊战马超', '1001016L', '1001016', '1', '1', '5', '2', '0', '20', '54', '18', '7', '2.4', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40007', '0', '', '100', '100', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82008', '408', '貂蝉', '妾身貂蝉，这厢有礼了', '1001018L', '1001018', '3', '1', '20', '2', '0', '60', '90', '30', '7', '2.4', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40008', '60006', '50007', '300', '300', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82009', '409', '孙尚香', '你看到玄德哥哥了吗？', '1001020L', '1001020', '3', '1', '20', '4', '0', '100', '72', '24', '26', '8.6', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40009', '60024', '50028', '500', '500', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82010', '410', '华佗', '惜哉医术不传，死于贼手', '1001023L', '1001023', '3', '1', '20', '5', '0', '100', '90', '30', '7', '2.4', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40010', '60025', '50025', '500', '500', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82011', '411', '仙女', '何人擅闯天庭？', '1001025L', '1001025', '2', '1', '15', '2', '0', '60', '68', '22.5', '5', '1.8', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '900020', '60006', '50006', '300', '300', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82012', '412', '董卓', '顺我者昌，逆我者亡', '1001027L', '1001027', '3', '1', '20', '1', '0', '60', '108', '36', '14', '4.8', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40012', '60002', '50002', '300', '300', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82013', '413', '白骨精', '太上老君是谁？芭蕉扇是怎么来的？你以为我会告诉你们吗？', '1001029L', '1001029', '4', '1', '25', '4', '0', '60', '90', '30', '32', '10.8', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40013', '60009', '50009', '300', '300', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82014', '414', '混沌', '天地广阔，不过一吞', '1001031L', '1001031', '6', '1', '35', '4', '0', '60', '189', '63', '25', '8.4', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40014', '60001', '50001', '300', '300', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82015', '415', '鸟精', '守护是我们终生的宿命', '1001034L', '1001034', '1', '1', '5', '5', '0', '40', '36', '12', '13', '4.3', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '900019', '0', '50029', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82016', '416', '火凤', '非晨露不饮，非嫩竹不食，非千年梧桐不栖', '1001036L', '1001036', '4', '1', '25', '1', '0', '40', '113', '37.5', '9', '3', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '900003', '0', '', '200', '200', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82017', '417', '冰凰', '凰生傲羽，当掌九天', '1001038L', '1001038', '4', '1', '25', '3', '0', '40', '113', '37.5', '9', '3', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '900018', '0', '', '200', '200', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82018', '418', '蛇精', '青竹蛇儿口，黄蜂尾上针', '1001040L', '1001040', '1', '1', '5', '2', '0', '60', '36', '12', '13', '4.3', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40018', '60008', '50008', '300', '300', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82019', '419', '狐妖', '以我绝世芳华，谱写一曲倾城之恋', '1001043L', '1001043', '1', '1', '5', '4', '0', '60', '36', '12', '13', '4.3', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40019', '60003', '50003', '300', '300', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82020', '420', '鬼将', '你修你的佛，我炼我的魔，井水不犯河水', '1001045L', '1001045', '1', '1', '5', '4', '0', '40', '54', '18', '7', '2.4', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '900002', '0', '', '200', '200', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82021', '421', '寒冰蟾', '所有的坚持只为有一天重回月宫', '1001047L', '1001047', '2', '1', '15', '3', '0', '40', '81', '27', '11', '3.6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40021', '0', '', '200', '200', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82022', '422', '烛龙', '千万年的不食不饮，不眠不休，我只是想静静，虽然我也不知道静静是谁', '1001049L', '1001049', '6', '1', '35', '5', '0', '100', '158', '52.5', '13', '4.2', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '900013', '60021', '50021', '500', '500', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82023', '423', '蝎子精', '山顶上的我，在等待着夕阳西下', '1001052L', '1001052', '1', '1', '5', '1', '0', '20', '36', '12', '13', '4.3', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40023', '0', '', '100', '100', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82024', '424', '蚩尤', '不死的我，即使被分尸镇压，终有一天将重新君临天下', '1001054L', '1001054', '6', '1', '35', '4', '0', '100', '158', '52.5', '13', '4.2', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40024', '60022', '50022', '500', '500', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82025', '425', '共工', '上古水神，与祝融争斗，战败之下怒触不周山', '1001057L', '1001057', '6', '1', '35', '3', '0', '100', '126', '42', '45', '15.1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40025', '60019', '50019', '500', '500', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82026', '426', '祝融', '上古火神，与共工争斗，打败共工，致使共工羞愤怒触不周山', '1001059L', '1001059', '6', '1', '35', '1', '0', '100', '126', '42', '45', '15.1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40026', '60020', '50020', '500', '500', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82027', '427', '刑天', '上古战神，端断首之后乃以乳为目，以脐为口，操干戚以舞', '1001061L', '1001061', '6', '1', '35', '5', '0', '60', '126', '42', '45', '15.1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40027', '60005', '50005', '300', '300', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82028', '428', '龙女', '得找个机会下凡跟凡人生萌萌哒的小猴子', '1001064L', '1001064', '2', '1', '15', '3', '0', '40', '68', '22.5', '5', '1.8', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40028', '0', '', '200', '200', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82029', '429', '仙童', '专心打杂，为下凡做山大王而奋斗', '1001066L', '1001066', '2', '1', '15', '5', '0', '40', '68', '22.5', '5', '1.8', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '900017', '0', '', '200', '200', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82030', '430', '孙悟空', '呔，俺乃五百年前大闹天宫的齐天大圣', '1001068L', '1001068', '5', '1', '30', '1', '0', '80', '108', '36', '39', '13', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '900008', '60003', '50013', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82031', '431', '猪八戒', '趁早散伙！分东西！俺回俺的高老庄！', '1001071L', '1001071', '5', '1', '30', '2', '0', '80', '162', '54', '22', '7.2', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40031', '60010', '50010', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82032', '432', '孟婆', '小倩，你在哪里？', '1001074L', '1001074', '2', '1', '15', '4', '0', '60', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '900005', '60004', '50004', '300', '300', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82033', '433', '天兵', '我是百万大军里的一个小透明，再看我搓死你。', '1001076L', '1001076', '2', '1', '15', '5', '0', '20', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '900015', '0', '', '100', '100', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82034', '434', '天将', '什么时候才能升官发财，赢取白富美，走向人生巅峰呢？', '1001078L', '1001078', '2', '1', '15', '5', '0', '20', '81', '27', '11', '3.6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40034', '0', '', '100', '100', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82035', '435', '朱雀', '五方神兽中守护南方的朱雀陵光神君', '1001080L', '1001080', '6', '1', '35', '1', '0', '80', '158', '52.5', '13', '4.2', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40035', '60017', '50017', '400', '400', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82036', '436', '白虎', '五方神兽中守护西方的白虎监兵神君', '1001083L', '1001083', '6', '1', '35', '5', '0', '80', '189', '63', '25', '8.4', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '900007', '60004', '50004', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82037', '437', '青龙', '五方神兽中守护东方的青龙孟章神君', '1001086L', '1001086', '6', '1', '35', '2', '0', '80', '158', '52.5', '13', '4.2', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40037', '60018', '50007', '400', '400', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82038', '438', '玄武', '五方神兽中守护北方的玄武执名神君', '1001089L', '1001089', '6', '1', '35', '3', '0', '80', '189', '63', '25', '8.4', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40038', '60016', '50016', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82039', '439', '饕餮', '龙之九子第五，羊身人面，贪婪好食', '1001092L', '1001092', '6', '1', '35', '4', '0', '100', '126', '42', '45', '15.1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40039', '60023', '50023', '500', '500', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82040', '440', '火麒麟', '龙之九子第二，好刀兵，一饭之德必偿，睚眦之怨必报', '1001094L', '1001094', '6', '1', '35', '1', '0', '80', '189', '63', '25', '8.4', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40040', '60001', '50011', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82041', '441', '小白龙', '诶，你看到我的主人了吗？', '1001095L', '1001095', '3', '1', '20', '3', '0', '40', '90', '30', '7', '2.4', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40040', '0', '', '200', '200', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82042', '442', '九尾狐', '人家的尾巴毛茸茸的很软呢。', '1001103L', '1001103', '3', '1', '20', '1', '0', '40', '90', '30', '7', '2.4', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40040', '0', '', '200', '200', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82043', '443', '关羽', '看吾的青龙刀！', '1001099L', '1001099', '3', '1', '20', '2', '0', '40', '90', '30', '7', '2.4', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40040', '0', '', '200', '200', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82044', '444', '孙权', '龙盘虎踞阻江流，割据由来起仲谋。', '1001107L', '1001107', '3', '1', '20', '1', '0', '40', '90', '30', '7', '2.4', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82045', '445', '刘备', '正道不灭，大义永存。', '1001108L', '1001108', '3', '1', '20', '2', '0', '40', '90', '30', '7', '2.4', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82046', '446', '曹操', '今日的无名之辈，来日必将名震天下！', '1001109L', '1001109', '3', '1', '20', '3', '0', '40', '72', '24', '26', '8.6', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82047', '447', '山大王', '此山是我……栽！此树是我……开！咦哪里不对？', '1001110L', '1001110', '2', '1', '15', '1', '0', '40', '81', '27', '11', '3.6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82048', '448', '山匪', '大王叫我~来巡山呀~来呀么来巡山~', '1001111L', '1001111', '1', '1', '5', '1', '0', '40', '54', '18', '7', '2.4', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82049', '449', '蜀国步兵', '我以前和你一样也是个冒险家，直到我的膝盖中了一箭。', '1001112L', '1001112', '1', '1', '5', '2', '0', '40', '36', '12', '13', '4.3', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82050', '450', '魏国军师', '主公！放着我来！', '1001113L', '1001113', '1', '1', '5', '3', '0', '40', '45', '15', '4', '1.2', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82051', '451', '黄巾兵', '苍天已死，黄天当立！', '1001114L', '1001114', '1', '1', '5', '5', '0', '40', '36', '12', '13', '4.3', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82052', '452', '黄巾大汉', '岁在甲子，天下大吉！', '1001115L', '1001115', '1', '1', '5', '5', '0', '40', '54', '18', '7', '2.4', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82053', '453', '蜈蚣精', '你是猴子派来的救兵吗？', '1001116L', '1001116', '1', '1', '5', '1', '0', '40', '36', '12', '13', '4.3', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82054', '454', '花妖', '我要保护树精爷爷~', '1001117L', '1001117', '1', '1', '5', '2', '0', '40', '45', '15', '4', '1.2', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82055', '455', '树精', '天干物燥，小心火烛啊……', '1001118L', '1001118', '1', '1', '5', '2', '0', '40', '54', '18', '7', '2.4', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82056', '456', '虾兵', '打完这一战，我就回老家结婚。', '1001119L', '1001119', '1', '1', '5', '3', '0', '40', '36', '12', '13', '4.3', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82057', '457', '蟹将', '赢了这一场，我就回老家抱娃。', '1001120L', '1001120', '1', '1', '5', '3', '0', '40', '54', '18', '7', '2.4', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82058', '458', '蝙蝠精', '血的香味……', '1001121L', '1001121', '1', '1', '5', '4', '0', '40', '36', '12', '13', '4.3', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82059', '459', '红孩儿', '看啥看？想吃我的三味真火？！', '1001122L', '1001122', '4', '1', '25', '1', '0', '40', '90', '30', '32', '10.8', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82060', '460', '九头虫', '你们这是自寻死路！', '1001123L', '1001123', '4', '1', '25', '3', '0', '40', '113', '37.5', '9', '3', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82061', '461', '白象精', '我知道暴力不能解决问题，但暴力可以解决你。', '1001124L', '1001124', '4', '1', '25', '2', '0', '40', '135', '45', '18', '6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82062', '462', '黄袍怪', '皇帝轮流做，今年轮到我！', '1001125L', '1001125', '4', '1', '25', '5', '0', '40', '90', '30', '32', '10.8', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82063', '463', '猴仙', '大圣为何还不回花果山？', '1001126L', '1001126', '2', '1', '15', '1', '0', '40', '68', '22.5', '5', '1.8', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82064', '464', '火猴', '吃俺老孙……噢不对，吃俺小孙一棒！', '1001127L', '1001127', '2', '1', '15', '1', '0', '40', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82065', '465', '散仙', '渡个天劫不容易啊，我整整洗了九九八十一天的澡。', '1001128L', '1001128', '2', '1', '15', '2', '0', '40', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82066', '466', '土地公', '小猫走失，夫妻吵架，全是我要管的事，唉，忙啊！', '1001129L', '1001129', '2', '1', '15', '2', '0', '40', '81', '27', '11', '3.6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82067', '467', '龙子', '何人胆敢与龙宫为敌？', '1001130L', '1001130', '2', '1', '15', '3', '0', '40', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82068', '468', '龟丞相', '老夫乃东海龙宫丞相，你可以称老夫为九千岁。', '1001131L', '1001131', '2', '1', '15', '3', '0', '40', '81', '27', '11', '3.6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82069', '469', '马面', '莫再挣扎了，生死有命。', '1001132L', '1001132', '2', '1', '15', '4', '0', '40', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82070', '470', '牛头', '罪人，哪里跑！', '1001133L', '1001133', '2', '1', '15', '4', '0', '40', '81', '27', '11', '3.6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82071', '471', '沙悟净', '师父，小心，有妖气！', '1001134L', '1001134', '5', '1', '30', '3', '0', '40', '162', '54', '22', '7.2', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('82072', '472', '太白金星', '无名天地之始，有名万物之母。', '1001135L', '1001135', '5', '1', '30', '5', '0', '40', '135', '45', '11', '3.6', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('82073', '473', '崔判官', '生死簿在此，还不给本官跪下！', '1001136L', '1001136', '5', '1', '30', '4', '0', '40', '108', '36', '39', '13', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82074', '474', '二郎真君', '赤城昭惠英灵圣，显化无边号二郎。', '1001137L', '1001137', '6', '1', '35', '5', '0', '40', '126', '42', '45', '15.1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('82075', '475', '牛魔王', '夫人，我错了……不要用铁扇扇我了！哎哟，疼！', '1001138L', '1001138', '5', '1', '30', '5', '0', '40', '162', '54', '22', '7.2', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83001', '476', '山贼', '此路是我开！此树是我栽！', '1001001L', '1001001', '2', '1', '15', '1', '0', '40', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83002', '477', '阴兵', '有我在此，谁敢进半步！', '1001003L', '1001003', '2', '1', '15', '4', '0', '40', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40002', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83003', '478', '吕布', '吾乃九原吕奉先，谁敢一战', '1001005L', '1001005', '4', '1', '25', '1', '0', '120', '90', '30', '32', '10.8', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '900010', '60021', '50021', '600', '600', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83004', '479', '张角', '天公将军在此，八州三十六方教众何在？', '1001008L', '1001008', '4', '1', '25', '5', '0', '100', '113', '37.5', '9', '3', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40004', '60006', '50015', '500', '500', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83005', '480', '赵云', '末将常山赵子龙，何人与我七进七出', '1001011L', '1001011', '4', '1', '25', '3', '0', '120', '90', '30', '32', '10.8', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '900012', '60026', '50026', '600', '600', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83006', '481', '太史慈', '大丈夫生于乱世，当带三尺剑立不世之功；今所志未遂，奈何死乎！', '1001014L', '1001014', '4', '1', '25', '5', '0', '100', '90', '30', '32', '10.8', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '900009', '60004', '50003', '500', '500', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83007', '482', '士官', '虎痴许仲康，赤膊战马超', '1001016L', '1001016', '2', '1', '15', '2', '0', '40', '81', '27', '11', '3.6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40007', '0', '', '200', '200', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83008', '483', '貂蝉', '妾身貂蝉，这厢有礼了', '1001018L', '1001018', '4', '1', '25', '2', '0', '80', '113', '37.5', '9', '3', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40008', '60006', '50007', '400', '400', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83009', '484', '孙尚香', '你看到玄德哥哥了吗？', '1001020L', '1001020', '4', '1', '25', '4', '0', '120', '90', '30', '32', '10.8', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40009', '60024', '50024', '600', '600', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83010', '485', '华佗', '惜哉医术不传，死于贼手', '1001023L', '1001023', '4', '1', '25', '5', '0', '120', '113', '37.5', '9', '3', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40010', '60025', '50025', '600', '600', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83011', '486', '仙女', '何人擅闯天庭？', '1001025L', '1001025', '3', '1', '20', '2', '0', '80', '90', '30', '7', '2.4', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '900020', '60006', '50006', '400', '400', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83012', '487', '董卓', '顺我者昌，逆我者亡', '1001027L', '1001027', '4', '1', '25', '1', '0', '80', '135', '45', '18', '6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40012', '60002', '50002', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83013', '488', '白骨精', '太上老君是谁？芭蕉扇是怎么来的？你以为我会告诉你们吗？', '1001029L', '1001029', '5', '1', '30', '4', '0', '80', '108', '36', '39', '13', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40013', '60009', '50009', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83014', '489', '混沌', '天地广阔，不过一吞', '1001031L', '1001031', '7', '1', '40', '4', '0', '80', '216', '72', '29', '9.6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40014', '60001', '50001', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83015', '490', '鸟精', '守护是我们终生的宿命', '1001034L', '1001034', '2', '1', '15', '5', '0', '60', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '900019', '0', '', '300', '300', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83016', '491', '火凤', '非晨露不饮，非嫩竹不食，非千年梧桐不栖', '1001036L', '1001036', '5', '1', '30', '1', '0', '60', '135', '45', '11', '3.6', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '900003', '0', '', '300', '300', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83017', '492', '冰凰', '凰生傲羽，当掌九天', '1001038L', '1001038', '5', '1', '30', '3', '0', '60', '135', '45', '11', '3.6', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '900018', '0', '', '300', '300', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83018', '493', '蛇精', '青竹蛇儿口，黄蜂尾上针', '1001040L', '1001040', '2', '1', '15', '2', '0', '80', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40018', '60008', '50008', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83019', '494', '狐妖', '以我绝世芳华，谱写一曲倾城之恋', '1001043L', '1001043', '2', '1', '15', '4', '0', '80', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40019', '60003', '50003', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83020', '495', '鬼将', '你修你的佛，我炼我的魔，井水不犯河水', '1001045L', '1001045', '2', '1', '15', '4', '0', '60', '81', '27', '11', '3.6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '900002', '0', '', '300', '300', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83021', '496', '寒冰蟾', '所有的坚持只为有一天重回月宫', '1001047L', '1001047', '3', '1', '20', '3', '0', '60', '108', '36', '14', '4.8', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40021', '0', '', '300', '300', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83022', '497', '烛龙', '千万年的不食不饮，不眠不休，我只是想静静，虽然我也不知道静静是谁', '1001049L', '1001049', '7', '1', '40', '5', '0', '120', '180', '60', '14', '4.8', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '900013', '60021', '50021', '600', '600', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83023', '498', '蝎子精', '山顶上的我，在等待着夕阳西下', '1001052L', '1001052', '2', '1', '15', '1', '0', '40', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40023', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83024', '499', '蚩尤', '不死的我，即使被分尸镇压，终有一天将重新君临天下', '1001054L', '1001054', '7', '1', '40', '4', '0', '120', '180', '60', '14', '4.8', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40024', '60022', '50022', '600', '600', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83025', '500', '共工', '上古水神，与祝融争斗，战败之下怒触不周山', '1001057L', '1001057', '7', '1', '40', '3', '0', '120', '144', '48', '52', '17.3', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40025', '60019', '50019', '600', '600', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83026', '501', '祝融', '上古火神，与共工争斗，打败共工，致使共工羞愤怒触不周山', '1001059L', '1001059', '7', '1', '40', '1', '0', '120', '144', '48', '52', '17.3', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40026', '60020', '50020', '600', '600', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83027', '502', '刑天', '上古战神，端断首之后乃以乳为目，以脐为口，操干戚以舞', '1001061L', '1001061', '7', '1', '40', '5', '0', '80', '144', '48', '52', '17.3', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40027', '60005', '50005', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83028', '503', '龙女', '得找个机会下凡跟凡人生萌萌哒的小猴子', '1001064L', '1001064', '3', '1', '20', '3', '0', '60', '90', '30', '7', '2.4', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40028', '0', '', '300', '300', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83029', '504', '仙童', '专心打杂，为下凡做山大王而奋斗', '1001066L', '1001066', '3', '1', '20', '5', '0', '60', '90', '30', '7', '2.4', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '900017', '0', '', '300', '300', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83030', '505', '孙悟空', '呔，俺乃五百年前大闹天宫的齐天大圣', '1001068L', '1001068', '6', '1', '35', '1', '0', '100', '126', '42', '45', '15.1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '900008', '60003', '50013', '500', '500', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83031', '506', '猪八戒', '趁早散伙！分东西！俺回俺的高老庄！', '1001071L', '1001071', '6', '1', '35', '2', '0', '100', '189', '63', '25', '8.4', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40031', '60010', '50010', '500', '500', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83032', '507', '孟婆', '小倩，你在哪里？', '1001074L', '1001074', '3', '1', '20', '4', '0', '80', '72', '24', '26', '8.6', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '900005', '60004', '50004', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83033', '508', '天兵', '我是百万大军里的一个小透明，再看我搓死你。', '1001076L', '1001076', '3', '1', '20', '5', '0', '40', '72', '24', '26', '8.6', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '900015', '0', '', '200', '200', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83034', '509', '天将', '什么时候才能升官发财，赢取白富美，走向人生巅峰呢？', '1001078L', '1001078', '3', '1', '20', '5', '0', '40', '108', '36', '14', '4.8', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40034', '0', '', '200', '200', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83035', '510', '朱雀', '五方神兽中守护南方的朱雀陵光神君', '1001080L', '1001080', '7', '1', '40', '1', '0', '100', '180', '60', '14', '4.8', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40035', '60017', '50017', '500', '500', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83036', '511', '白虎', '五方神兽中守护西方的白虎监兵神君', '1001083L', '1001083', '7', '1', '40', '5', '0', '100', '216', '72', '29', '9.6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '900007', '60004', '50004', '500', '500', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83037', '512', '青龙', '五方神兽中守护东方的青龙孟章神君', '1001086L', '1001086', '7', '1', '40', '2', '0', '100', '180', '60', '14', '4.8', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40037', '60018', '50007', '500', '500', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83038', '513', '玄武', '五方神兽中守护北方的玄武执名神君', '1001089L', '1001089', '7', '1', '40', '3', '0', '100', '216', '72', '29', '9.6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40038', '60016', '50016', '500', '500', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83039', '514', '饕餮', '龙之九子第五，羊身人面，贪婪好食', '1001092L', '1001092', '7', '1', '40', '4', '0', '120', '144', '48', '52', '17.3', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40039', '60023', '50023', '600', '600', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83040', '515', '火麒麟', '龙之九子第二，好刀兵，一饭之德必偿，睚眦之怨必报', '1001094L', '1001094', '7', '1', '40', '1', '0', '100', '216', '72', '29', '9.6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40040', '60001', '50011', '500', '500', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83041', '516', '小白龙', '诶，你看到我的主人了吗？', '1001096L', '1001096', '4', '1', '25', '3', '0', '80', '113', '37.5', '9', '3', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40040', '60001', '50011', '400', '400', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83042', '517', '九尾狐', '人家的尾巴毛茸茸的很软呢。', '1001104L', '1001104', '4', '1', '25', '1', '0', '80', '113', '37.5', '9', '3', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40040', '60001', '50011', '400', '400', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83043', '518', '关羽', '看吾的青龙刀！', '1001100L', '1001100', '4', '1', '25', '2', '0', '80', '113', '37.5', '9', '3', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40040', '60001', '50011', '400', '400', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83044', '519', '孙权', '龙盘虎踞阻江流，割据由来起仲谋。', '1001107L', '1001107', '4', '1', '25', '1', '0', '60', '113', '37.5', '9', '3', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83045', '520', '刘备', '正道不灭，大义永存。', '1001108L', '1001108', '4', '1', '25', '2', '0', '60', '113', '37.5', '9', '3', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83046', '521', '曹操', '今日的无名之辈，来日必将名震天下！', '1001109L', '1001109', '4', '1', '25', '3', '0', '60', '90', '30', '32', '10.8', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83047', '522', '山大王', '此山是我……栽！此树是我……开！咦哪里不对？', '1001110L', '1001110', '3', '1', '20', '1', '0', '60', '108', '36', '14', '4.8', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83048', '523', '山匪', '大王叫我~来巡山呀~来呀么来巡山~', '1001111L', '1001111', '2', '1', '15', '1', '0', '60', '81', '27', '11', '3.6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83049', '524', '蜀国步兵', '我以前和你一样也是个冒险家，直到我的膝盖中了一箭。', '1001112L', '1001112', '2', '1', '15', '2', '0', '60', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83050', '525', '魏国军师', '主公！放着我来！', '1001113L', '1001113', '2', '1', '15', '3', '0', '60', '68', '22.5', '5', '1.8', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83051', '526', '黄巾兵', '苍天已死，黄天当立！', '1001114L', '1001114', '2', '1', '15', '5', '0', '60', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83052', '527', '黄巾大汉', '岁在甲子，天下大吉！', '1001115L', '1001115', '2', '1', '15', '5', '0', '60', '81', '27', '11', '3.6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83053', '528', '蜈蚣精', '你是猴子派来的救兵吗？', '1001116L', '1001116', '2', '1', '15', '1', '0', '60', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83054', '529', '花妖', '我要保护树精爷爷~', '1001117L', '1001117', '2', '1', '15', '2', '0', '60', '68', '22.5', '5', '1.8', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83055', '530', '树精', '天干物燥，小心火烛啊……', '1001118L', '1001118', '2', '1', '15', '2', '0', '60', '81', '27', '11', '3.6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83056', '531', '虾兵', '打完这一战，我就回老家结婚。', '1001119L', '1001119', '2', '1', '15', '3', '0', '60', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83057', '532', '蟹将', '赢了这一场，我就回老家抱娃。', '1001120L', '1001120', '2', '1', '15', '3', '0', '60', '81', '27', '11', '3.6', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83058', '533', '蝙蝠精', '血的香味……', '1001121L', '1001121', '2', '1', '15', '4', '0', '60', '54', '18', '19', '6.5', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83059', '534', '红孩儿', '看啥看？想吃我的三味真火？！', '1001122L', '1001122', '5', '1', '30', '1', '0', '60', '108', '36', '39', '13', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83060', '535', '九头虫', '你们这是自寻死路！', '1001123L', '1001123', '5', '1', '30', '3', '0', '60', '135', '45', '11', '3.6', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83061', '536', '白象精', '我知道暴力不能解决问题，但暴力可以解决你。', '1001124L', '1001124', '5', '1', '30', '2', '0', '60', '162', '54', '22', '7.2', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83062', '537', '黄袍怪', '皇帝轮流做，今年轮到我！', '1001125L', '1001125', '5', '1', '30', '5', '0', '60', '108', '36', '39', '13', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83063', '538', '猴仙', '大圣为何还不回花果山？', '1001126L', '1001126', '3', '1', '20', '1', '0', '60', '90', '30', '7', '2.4', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83064', '539', '火猴', '吃俺老孙……噢不对，吃俺小孙一棒！', '1001127L', '1001127', '3', '1', '20', '1', '0', '60', '72', '24', '26', '8.6', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83065', '540', '散仙', '渡个天劫不容易啊，我整整洗了九九八十一天的澡。', '1001128L', '1001128', '3', '1', '20', '2', '0', '60', '72', '24', '26', '8.6', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83066', '541', '土地公', '小猫走失，夫妻吵架，全是我要管的事，唉，忙啊！', '1001129L', '1001129', '3', '1', '20', '2', '0', '60', '108', '36', '14', '4.8', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83067', '542', '龙子', '何人胆敢与龙宫为敌？', '1001130L', '1001130', '3', '1', '20', '3', '0', '60', '72', '24', '26', '8.6', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83068', '543', '龟丞相', '老夫乃东海龙宫丞相，你可以称老夫为九千岁。', '1001131L', '1001131', '3', '1', '20', '3', '0', '60', '108', '36', '14', '4.8', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83069', '544', '马面', '不要再挣扎了，生死有命。', '1001132L', '1001132', '3', '1', '20', '4', '0', '60', '72', '24', '26', '8.6', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83070', '545', '牛头', '罪人，哪里跑！', '1001133L', '1001133', '3', '1', '20', '4', '0', '60', '108', '36', '14', '4.8', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83071', '546', '沙悟净', '师父，小心，有妖气！', '1001134L', '1001134', '6', '1', '35', '3', '0', '60', '189', '63', '25', '8.4', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('83072', '547', '太白金星', '无名天地之始，有名万物之母。', '1001135L', '1001135', '6', '1', '35', '5', '0', '60', '158', '52.5', '13', '4.2', '2', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '2', '2');
INSERT INTO `t_hero` VALUES ('83073', '548', '崔判官', '生死簿在此，还不给本官跪下！', '1001136L', '1001136', '6', '1', '35', '4', '0', '60', '126', '42', '45', '15.1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83074', '549', '二郎真君', '赤城昭惠英灵圣，显化无边号二郎。', '1001137L', '1001137', '7', '1', '40', '5', '0', '60', '144', '48', '52', '17.3', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '3', '3');
INSERT INTO `t_hero` VALUES ('83075', '550', '牛魔王', '夫人，我错了……不要用铁扇扇我了！哎哟，疼！', '1001138L', '1001138', '6', '1', '35', '5', '0', '60', '189', '63', '25', '8.4', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40001', '0', '', '400', '400', '8031001', '0', '0', '1', '1');
INSERT INTO `t_hero` VALUES ('90001', '551', '二星火焰包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002001L', '1002001', '2', '1', '15', '1', '0', '1', '50', '1', '15', '1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40001', '0', '', '100', '100', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90002', '552', '三星火焰包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002002L', '1002002', '3', '1', '20', '1', '0', '1', '100', '1', '30', '1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40002', '0', '', '100', '100', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90003', '553', '四星火焰包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002003L', '1002003', '4', '1', '25', '1', '0', '1', '200', '1', '45', '1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40003', '0', '', '500', '500', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90004', '554', '五星火焰包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002004L', '1002004', '5', '1', '30', '1', '0', '1', '250', '1', '60', '1', '1', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40004', '0', '', '400', '400', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90005', '555', '二星木灵包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002005L', '1002005', '2', '1', '15', '2', '0', '1', '50', '1', '15', '1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40005', '0', '', '500', '500', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90006', '556', '三星木灵包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002006L', '1002006', '3', '1', '20', '2', '0', '1', '100', '1', '30', '1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40006', '0', '', '400', '400', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90007', '557', '四星木灵包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002007L', '1002007', '4', '1', '25', '2', '0', '1', '200', '1', '45', '1', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40007', '0', '', '100', '100', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90008', '558', '五星木灵包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002008L', '1002008', '5', '1', '30', '2', '0', '1', '250', '1', '60', '1', '1', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40008', '0', '', '300', '300', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90009', '559', '二星冰霜包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002009L', '1002009', '2', '1', '15', '3', '0', '1', '50', '1', '15', '1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40009', '0', '', '500', '500', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90010', '560', '三星冰霜包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002010L', '1002010', '3', '1', '20', '3', '0', '1', '100', '1', '30', '1', '1', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40010', '0', '', '500', '500', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90011', '561', '四星冰霜包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002011L', '1002011', '4', '1', '25', '3', '0', '1', '200', '1', '45', '1', '1', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40011', '0', '', '300', '300', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90012', '562', '五星冰霜包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002012L', '1002012', '5', '1', '30', '3', '0', '1', '250', '1', '60', '1', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40012', '0', '', '300', '300', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90013', '563', '二星光明包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002013L', '1002013', '2', '1', '15', '5', '0', '1', '50', '1', '15', '1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40013', '0', '', '300', '300', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90014', '564', '三星光明包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002014L', '1002014', '3', '1', '20', '5', '0', '1', '100', '1', '30', '1', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40014', '0', '', '300', '300', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90015', '565', '四星光明包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002015L', '1002015', '4', '1', '25', '5', '0', '1', '200', '1', '45', '1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40015', '0', '', '200', '200', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90016', '566', '五星光明包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002016L', '1002016', '5', '1', '30', '5', '0', '1', '250', '1', '60', '1', '1', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40016', '0', '', '200', '200', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90017', '567', '二星黑暗包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002017L', '1002017', '2', '1', '15', '4', '0', '1', '50', '1', '15', '1', '1', '10101010', '30333033', '0', '3000', '0', '12540', '0', '40017', '0', '', '200', '200', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90018', '568', '三星黑暗包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002018L', '1002018', '3', '1', '20', '4', '0', '1', '100', '1', '30', '1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40018', '0', '', '300', '300', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90019', '569', '四星黑暗包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002019L', '1002019', '4', '1', '25', '4', '0', '1', '200', '1', '45', '1', '1', '10010011', '10111011', '0', '3000', '0', '12540', '0', '40019', '0', '', '300', '300', '8031001', '0', '0', '999', '999');
INSERT INTO `t_hero` VALUES ('90020', '570', '五星黑暗包子', '包子是没有什么战斗力的，不要指望我能拯救世界！', '1002020L', '1002020', '5', '1', '30', '4', '0', '1', '250', '1', '60', '1', '1', '00111001', '20222022', '0', '3000', '0', '12540', '0', '40020', '0', '', '200', '200', '8031001', '0', '0', '999', '999');

-- ----------------------------
-- Table structure for t_hero_break_attr_setting
-- ----------------------------
DROP TABLE IF EXISTS `t_hero_break_attr_setting`;
CREATE TABLE `t_hero_break_attr_setting` (
  `groupId` int(11) NOT NULL COMMENT '组id',
  `breakLevel` int(11) NOT NULL COMMENT '突破等级',
  `slot` int(11) NOT NULL COMMENT '灵元槽位',
  `hp` int(11) NOT NULL COMMENT '增加血量',
  `atk` int(11) NOT NULL COMMENT '增加攻击力'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hero_break_attr_setting
-- ----------------------------
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '1', '0', '16', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '1', '1', '11', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '1', '2', '11', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '1', '3', '16', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '1', '4', '16', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '1', '5', '36', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '1', '6', '0', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '2', '0', '16', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '2', '1', '11', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '2', '2', '11', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '2', '3', '16', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '2', '4', '16', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '2', '5', '36', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '2', '6', '0', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '3', '0', '27', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '3', '1', '23', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '3', '2', '23', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '3', '3', '32', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '3', '4', '32', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '3', '5', '72', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '3', '6', '0', '10');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '4', '0', '27', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '4', '1', '23', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '4', '2', '23', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '4', '3', '32', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '4', '4', '32', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '4', '5', '72', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '4', '6', '0', '10');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '5', '0', '39', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '5', '1', '34', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '5', '2', '34', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '5', '3', '47', '6');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '5', '4', '47', '6');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '5', '5', '108', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '5', '6', '0', '14');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '6', '0', '39', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '6', '1', '34', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '6', '2', '34', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '6', '3', '47', '6');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '6', '4', '47', '6');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '6', '5', '108', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '6', '6', '0', '14');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '7', '0', '54', '7');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '7', '1', '45', '6');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '7', '2', '45', '6');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '7', '3', '63', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '7', '4', '63', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '7', '5', '144', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '7', '6', '0', '19');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '8', '0', '54', '7');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '8', '1', '45', '6');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '8', '2', '45', '6');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '8', '3', '63', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '8', '4', '63', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '8', '5', '144', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '8', '6', '0', '19');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '9', '0', '66', '9');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '9', '1', '56', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '9', '2', '56', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '9', '3', '79', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '9', '4', '79', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '9', '5', '180', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '9', '6', '0', '24');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '10', '0', '66', '9');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '10', '1', '56', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '10', '2', '56', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '10', '3', '79', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '10', '4', '79', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '10', '5', '180', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '10', '6', '0', '24');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '11', '0', '81', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '11', '1', '68', '9');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '11', '2', '68', '9');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '11', '3', '95', '13');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '11', '4', '95', '13');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '11', '5', '216', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '11', '6', '0', '29');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '12', '0', '81', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '12', '1', '68', '9');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '12', '2', '68', '9');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '12', '3', '95', '13');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '12', '4', '95', '13');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '12', '5', '216', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '12', '6', '0', '29');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '13', '0', '93', '13');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '13', '1', '79', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '13', '2', '79', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '13', '3', '110', '15');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '13', '4', '110', '15');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '13', '5', '252', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '13', '6', '0', '34');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '14', '0', '93', '13');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '14', '1', '79', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '14', '2', '79', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '14', '3', '110', '15');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '14', '4', '110', '15');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '14', '5', '252', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('1', '14', '6', '0', '34');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '1', '0', '11', '1');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '1', '1', '9', '1');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '1', '2', '9', '1');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '1', '3', '13', '1');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '1', '4', '13', '1');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '1', '5', '30', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '1', '6', '0', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '2', '0', '11', '1');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '2', '1', '9', '1');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '2', '2', '9', '1');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '2', '3', '13', '1');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '2', '4', '13', '1');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '2', '5', '30', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '2', '6', '0', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '3', '0', '21', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '3', '1', '19', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '3', '2', '19', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '3', '3', '26', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '3', '4', '26', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '3', '5', '60', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '3', '6', '0', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '4', '0', '21', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '4', '1', '19', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '4', '2', '19', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '4', '3', '26', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '4', '4', '26', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '4', '5', '60', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '4', '6', '0', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '5', '0', '32', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '5', '1', '28', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '5', '2', '28', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '5', '3', '39', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '5', '4', '39', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '5', '5', '90', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '5', '6', '0', '7');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '6', '0', '32', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '6', '1', '28', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '6', '2', '28', '2');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '6', '3', '39', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '6', '4', '39', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '6', '5', '90', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '6', '6', '0', '7');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '7', '0', '45', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '7', '1', '38', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '7', '2', '38', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '7', '3', '53', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '7', '4', '53', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '7', '5', '120', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '7', '6', '0', '10');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '8', '0', '45', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '8', '1', '38', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '8', '2', '38', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '8', '3', '53', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '8', '4', '53', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '8', '5', '120', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '8', '6', '0', '10');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '9', '0', '56', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '9', '1', '47', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '9', '2', '47', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '9', '3', '66', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '9', '4', '66', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '9', '5', '150', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '9', '6', '0', '12');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '10', '0', '56', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '10', '1', '47', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '10', '2', '47', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '10', '3', '66', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '10', '4', '66', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '10', '5', '150', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '10', '6', '0', '12');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '11', '0', '66', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '11', '1', '56', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '11', '2', '56', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '11', '3', '79', '6');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '11', '4', '79', '6');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '11', '5', '180', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '11', '6', '0', '14');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '12', '0', '66', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '12', '1', '56', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '12', '2', '56', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '12', '3', '79', '6');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '12', '4', '79', '6');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '12', '5', '180', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '12', '6', '0', '14');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '13', '0', '77', '7');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '13', '1', '66', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '13', '2', '66', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '13', '3', '92', '7');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '13', '4', '92', '7');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '13', '5', '210', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '13', '6', '0', '17');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '14', '0', '77', '7');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '14', '1', '66', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '14', '2', '66', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '14', '3', '92', '7');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '14', '4', '92', '7');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '14', '5', '210', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('2', '14', '6', '0', '17');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '1', '0', '10', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '1', '1', '8', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '1', '2', '8', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '1', '3', '11', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '1', '4', '11', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '1', '5', '24', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '1', '6', '0', '9');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '2', '0', '10', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '2', '1', '8', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '2', '2', '8', '3');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '2', '3', '11', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '2', '4', '11', '4');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '2', '5', '24', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '2', '6', '0', '9');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '3', '0', '18', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '3', '1', '15', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '3', '2', '15', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '3', '3', '21', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '3', '4', '21', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '3', '5', '48', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '3', '6', '0', '17');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '4', '0', '18', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '4', '1', '15', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '4', '2', '15', '5');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '4', '3', '21', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '4', '4', '21', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '4', '5', '48', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '4', '6', '0', '17');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '5', '0', '27', '10');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '5', '1', '23', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '5', '2', '23', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '5', '3', '32', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '5', '4', '32', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '5', '5', '72', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '5', '6', '0', '26');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '6', '0', '27', '10');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '6', '1', '23', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '6', '2', '23', '8');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '6', '3', '32', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '6', '4', '32', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '6', '5', '72', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '6', '6', '0', '26');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '7', '0', '36', '12');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '7', '1', '30', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '7', '2', '30', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '7', '3', '42', '15');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '7', '4', '42', '15');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '7', '5', '96', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '7', '6', '0', '35');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '8', '0', '36', '12');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '8', '1', '30', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '8', '2', '30', '11');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '8', '3', '42', '15');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '8', '4', '42', '15');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '8', '5', '96', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '8', '6', '0', '35');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '9', '0', '45', '16');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '9', '1', '38', '14');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '9', '2', '38', '14');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '9', '3', '53', '19');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '9', '4', '53', '19');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '9', '5', '120', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '9', '6', '0', '43');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '10', '0', '45', '16');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '10', '1', '38', '14');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '10', '2', '38', '14');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '10', '3', '53', '19');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '10', '4', '53', '19');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '10', '5', '120', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '10', '6', '0', '43');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '11', '0', '54', '21');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '11', '1', '45', '16');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '11', '2', '45', '16');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '11', '3', '63', '23');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '11', '4', '63', '23');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '11', '5', '144', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '11', '6', '0', '52');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '12', '0', '54', '21');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '12', '1', '45', '16');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '12', '2', '45', '16');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '12', '3', '63', '23');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '12', '4', '63', '23');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '12', '5', '144', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '12', '6', '0', '52');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '13', '0', '63', '22');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '13', '1', '53', '19');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '13', '2', '53', '19');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '13', '3', '74', '26');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '13', '4', '74', '26');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '13', '5', '168', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '13', '6', '0', '60');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '14', '0', '63', '22');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '14', '1', '53', '19');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '14', '2', '53', '19');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '14', '3', '74', '26');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '14', '4', '74', '26');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '14', '5', '168', '0');
INSERT INTO `t_hero_break_attr_setting` VALUES ('3', '14', '6', '0', '60');

-- ----------------------------
-- Table structure for t_hero_break_setting
-- ----------------------------
DROP TABLE IF EXISTS `t_hero_break_setting`;
CREATE TABLE `t_hero_break_setting` (
  `groupId` int(11) NOT NULL COMMENT '组id',
  `breakLevel` int(11) NOT NULL COMMENT '突破等级',
  `slot` int(11) NOT NULL COMMENT '灵元槽位',
  `needLevel` int(11) NOT NULL COMMENT '激活需要英雄等级',
  `type` int(11) NOT NULL COMMENT '消耗的道具类型',
  `goods_id` int(11) NOT NULL COMMENT '物品id',
  `num` int(11) NOT NULL COMMENT '数量',
  `dropBattleID` varchar(128) NOT NULL COMMENT '掉落战场ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hero_break_setting
-- ----------------------------
INSERT INTO `t_hero_break_setting` VALUES ('1', '1', '1', '1', '4', '4023101', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('1', '1', '2', '1', '4', '4023201', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('1', '1', '3', '3', '4', '4023301', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('1', '1', '4', '3', '4', '4023401', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('1', '1', '5', '5', '4', '4023501', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('1', '1', '6', '5', '4', '4023601', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('1', '2', '1', '6', '4', '4023101', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('1', '2', '2', '6', '4', '4023201', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('1', '2', '3', '8', '4', '4023301', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('1', '2', '4', '8', '4', '4023401', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('1', '2', '5', '10', '4', '4023501', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('1', '2', '6', '10', '4', '4023601', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('1', '3', '1', '11', '4', '4023102', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '3', '2', '11', '4', '4023202', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '3', '3', '13', '4', '4023302', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '3', '4', '13', '4', '4023402', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '3', '5', '15', '4', '4023502', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '3', '6', '15', '4', '4023602', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '4', '1', '16', '4', '4023102', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '4', '2', '16', '4', '4023202', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '4', '3', '18', '4', '4023302', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '4', '4', '18', '4', '4023402', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '4', '5', '20', '4', '4023502', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '4', '6', '20', '4', '4023602', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '5', '1', '21', '4', '4023103', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '5', '2', '21', '4', '4023203', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '5', '3', '23', '4', '4023303', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '5', '4', '23', '4', '4023403', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '5', '5', '25', '4', '4023503', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '5', '6', '25', '4', '4023603', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '6', '1', '26', '4', '4023103', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '6', '2', '26', '4', '4023203', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '6', '3', '28', '4', '4023303', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '6', '4', '28', '4', '4023403', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '6', '5', '30', '4', '4023503', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '6', '6', '30', '4', '4023603', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '7', '1', '31', '4', '4023104', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '7', '2', '31', '4', '4023204', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '7', '3', '33', '4', '4023304', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '7', '4', '33', '4', '4023404', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '7', '5', '35', '4', '4023504', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '7', '6', '35', '4', '4023604', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '8', '1', '36', '4', '4023104', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '8', '2', '36', '4', '4023204', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '8', '3', '38', '4', '4023304', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '8', '4', '38', '4', '4023404', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '8', '5', '40', '4', '4023504', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '8', '6', '40', '4', '4023604', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '9', '1', '41', '4', '4023105', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '9', '2', '41', '4', '4023205', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '9', '3', '43', '4', '4023305', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '9', '4', '43', '4', '4023405', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '9', '5', '45', '4', '4023505', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '9', '6', '45', '4', '4023605', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '10', '1', '46', '4', '4023105', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '10', '2', '46', '4', '4023205', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '10', '3', '48', '4', '4023305', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '10', '4', '48', '4', '4023405', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '10', '5', '50', '4', '4023505', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '10', '6', '50', '4', '4023605', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '11', '1', '51', '4', '4023106', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '11', '2', '51', '4', '4023206', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '11', '3', '53', '4', '4023306', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '11', '4', '53', '4', '4023406', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '11', '5', '55', '4', '4023506', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '11', '6', '55', '4', '4023606', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '12', '1', '56', '4', '4023106', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '12', '2', '56', '4', '4023206', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '12', '3', '58', '4', '4023306', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '12', '4', '58', '4', '4023406', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '12', '5', '60', '4', '4023506', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '12', '6', '60', '4', '4023606', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '13', '1', '61', '4', '4023107', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '13', '2', '61', '4', '4023207', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '13', '3', '63', '4', '4023307', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '13', '4', '63', '4', '4023407', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '13', '5', '65', '4', '4023507', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '13', '6', '65', '4', '4023607', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '14', '1', '66', '4', '4023107', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '14', '2', '66', '4', '4023207', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '14', '3', '68', '4', '4023307', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '14', '4', '68', '4', '4023407', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '14', '5', '70', '4', '4023507', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('1', '14', '6', '70', '4', '4023607', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '1', '1', '1', '4', '4023101', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('2', '1', '2', '1', '4', '4023201', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('2', '1', '3', '3', '4', '4023301', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('2', '1', '4', '3', '4', '4023401', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('2', '1', '5', '5', '4', '4023501', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('2', '1', '6', '5', '4', '4023601', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('2', '2', '1', '6', '4', '4023101', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('2', '2', '2', '6', '4', '4023201', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('2', '2', '3', '8', '4', '4023301', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('2', '2', '4', '8', '4', '4023401', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('2', '2', '5', '10', '4', '4023501', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('2', '2', '6', '10', '4', '4023601', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('2', '3', '1', '11', '4', '4023102', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '3', '2', '11', '4', '4023202', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '3', '3', '13', '4', '4023302', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '3', '4', '13', '4', '4023402', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '3', '5', '15', '4', '4023502', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '3', '6', '15', '4', '4023602', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '4', '1', '16', '4', '4023102', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '4', '2', '16', '4', '4023202', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '4', '3', '18', '4', '4023302', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '4', '4', '18', '4', '4023402', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '4', '5', '20', '4', '4023502', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '4', '6', '20', '4', '4023602', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '5', '1', '21', '4', '4023103', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '5', '2', '21', '4', '4023203', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '5', '3', '23', '4', '4023303', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '5', '4', '23', '4', '4023403', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '5', '5', '25', '4', '4023503', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '5', '6', '25', '4', '4023603', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '6', '1', '26', '4', '4023103', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '6', '2', '26', '4', '4023203', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '6', '3', '28', '4', '4023303', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '6', '4', '28', '4', '4023403', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '6', '5', '30', '4', '4023503', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '6', '6', '30', '4', '4023603', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '7', '1', '31', '4', '4023104', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '7', '2', '31', '4', '4023204', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '7', '3', '33', '4', '4023304', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '7', '4', '33', '4', '4023404', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '7', '5', '35', '4', '4023504', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '7', '6', '35', '4', '4023604', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '8', '1', '36', '4', '4023104', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '8', '2', '36', '4', '4023204', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '8', '3', '38', '4', '4023304', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '8', '4', '38', '4', '4023404', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '8', '5', '40', '4', '4023504', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '8', '6', '40', '4', '4023604', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '9', '1', '41', '4', '4023105', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '9', '2', '41', '4', '4023205', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '9', '3', '43', '4', '4023305', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '9', '4', '43', '4', '4023405', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '9', '5', '45', '4', '4023505', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '9', '6', '45', '4', '4023605', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '10', '1', '46', '4', '4023105', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '10', '2', '46', '4', '4023205', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '10', '3', '48', '4', '4023305', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '10', '4', '48', '4', '4023405', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '10', '5', '50', '4', '4023505', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '10', '6', '50', '4', '4023605', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '11', '1', '51', '4', '4023106', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '11', '2', '51', '4', '4023206', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '11', '3', '53', '4', '4023306', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '11', '4', '53', '4', '4023406', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '11', '5', '55', '4', '4023506', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '11', '6', '55', '4', '4023606', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '12', '1', '56', '4', '4023106', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '12', '2', '56', '4', '4023206', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '12', '3', '58', '4', '4023306', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '12', '4', '58', '4', '4023406', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '12', '5', '60', '4', '4023506', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '12', '6', '60', '4', '4023606', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '13', '1', '61', '4', '4023107', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '13', '2', '61', '4', '4023207', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '13', '3', '63', '4', '4023307', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '13', '4', '63', '4', '4023407', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '13', '5', '65', '4', '4023507', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '13', '6', '65', '4', '4023607', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '14', '1', '66', '4', '4023107', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '14', '2', '66', '4', '4023207', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '14', '3', '68', '4', '4023307', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '14', '4', '68', '4', '4023407', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '14', '5', '70', '4', '4023507', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('2', '14', '6', '70', '4', '4023607', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '1', '1', '1', '4', '4023101', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('3', '1', '2', '1', '4', '4023201', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('3', '1', '3', '3', '4', '4023301', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('3', '1', '4', '3', '4', '4023401', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('3', '1', '5', '5', '4', '4023501', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('3', '1', '6', '5', '4', '4023601', '5', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('3', '2', '1', '6', '4', '4023101', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('3', '2', '2', '6', '4', '4023201', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('3', '2', '3', '8', '4', '4023301', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('3', '2', '4', '8', '4', '4023401', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('3', '2', '5', '10', '4', '4023501', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('3', '2', '6', '10', '4', '4023601', '10', '71001003,71001006,71001009');
INSERT INTO `t_hero_break_setting` VALUES ('3', '3', '1', '11', '4', '4023102', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '3', '2', '11', '4', '4023202', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '3', '3', '13', '4', '4023302', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '3', '4', '13', '4', '4023402', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '3', '5', '15', '4', '4023502', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '3', '6', '15', '4', '4023602', '15', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '4', '1', '16', '4', '4023102', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '4', '2', '16', '4', '4023202', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '4', '3', '18', '4', '4023302', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '4', '4', '18', '4', '4023402', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '4', '5', '20', '4', '4023502', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '4', '6', '20', '4', '4023602', '20', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '5', '1', '21', '4', '4023103', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '5', '2', '21', '4', '4023203', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '5', '3', '23', '4', '4023303', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '5', '4', '23', '4', '4023403', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '5', '5', '25', '4', '4023503', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '5', '6', '25', '4', '4023603', '25', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '6', '1', '26', '4', '4023103', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '6', '2', '26', '4', '4023203', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '6', '3', '28', '4', '4023303', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '6', '4', '28', '4', '4023403', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '6', '5', '30', '4', '4023503', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '6', '6', '30', '4', '4023603', '30', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '7', '1', '31', '4', '4023104', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '7', '2', '31', '4', '4023204', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '7', '3', '33', '4', '4023304', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '7', '4', '33', '4', '4023404', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '7', '5', '35', '4', '4023504', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '7', '6', '35', '4', '4023604', '35', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '8', '1', '36', '4', '4023104', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '8', '2', '36', '4', '4023204', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '8', '3', '38', '4', '4023304', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '8', '4', '38', '4', '4023404', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '8', '5', '40', '4', '4023504', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '8', '6', '40', '4', '4023604', '40', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '9', '1', '41', '4', '4023105', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '9', '2', '41', '4', '4023205', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '9', '3', '43', '4', '4023305', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '9', '4', '43', '4', '4023405', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '9', '5', '45', '4', '4023505', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '9', '6', '45', '4', '4023605', '45', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '10', '1', '46', '4', '4023105', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '10', '2', '46', '4', '4023205', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '10', '3', '48', '4', '4023305', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '10', '4', '48', '4', '4023405', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '10', '5', '50', '4', '4023505', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '10', '6', '50', '4', '4023605', '50', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '11', '1', '51', '4', '4023106', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '11', '2', '51', '4', '4023206', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '11', '3', '53', '4', '4023306', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '11', '4', '53', '4', '4023406', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '11', '5', '55', '4', '4023506', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '11', '6', '55', '4', '4023606', '55', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '12', '1', '56', '4', '4023106', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '12', '2', '56', '4', '4023206', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '12', '3', '58', '4', '4023306', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '12', '4', '58', '4', '4023406', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '12', '5', '60', '4', '4023506', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '12', '6', '60', '4', '4023606', '60', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '13', '1', '61', '4', '4023107', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '13', '2', '61', '4', '4023207', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '13', '3', '63', '4', '4023307', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '13', '4', '63', '4', '4023407', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '13', '5', '65', '4', '4023507', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '13', '6', '65', '4', '4023607', '65', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '14', '1', '66', '4', '4023107', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '14', '2', '66', '4', '4023207', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '14', '3', '68', '4', '4023307', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '14', '4', '68', '4', '4023407', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '14', '5', '70', '4', '4023507', '70', '71001003');
INSERT INTO `t_hero_break_setting` VALUES ('3', '14', '6', '70', '4', '4023607', '70', '71001003');

-- ----------------------------
-- Table structure for t_hero_evo
-- ----------------------------
DROP TABLE IF EXISTS `t_hero_evo`;
CREATE TABLE `t_hero_evo` (
  `evo_id` int(11) NOT NULL COMMENT '进化id',
  `hero_id` int(11) NOT NULL COMMENT '进化前的伙伴Id',
  `evo_hero_id` int(11) NOT NULL COMMENT '进化后的伙伴Id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hero_evo
-- ----------------------------
INSERT INTO `t_hero_evo` VALUES ('1', '82001', '83001');
INSERT INTO `t_hero_evo` VALUES ('2', '82002', '83002');
INSERT INTO `t_hero_evo` VALUES ('3', '82003', '83003');
INSERT INTO `t_hero_evo` VALUES ('4', '82004', '83004');
INSERT INTO `t_hero_evo` VALUES ('5', '82005', '83005');
INSERT INTO `t_hero_evo` VALUES ('6', '82006', '83006');
INSERT INTO `t_hero_evo` VALUES ('7', '82007', '83007');
INSERT INTO `t_hero_evo` VALUES ('8', '82008', '83008');
INSERT INTO `t_hero_evo` VALUES ('9', '82009', '83009');
INSERT INTO `t_hero_evo` VALUES ('10', '82010', '83010');
INSERT INTO `t_hero_evo` VALUES ('11', '82011', '83011');
INSERT INTO `t_hero_evo` VALUES ('12', '82012', '83012');
INSERT INTO `t_hero_evo` VALUES ('13', '82013', '83013');
INSERT INTO `t_hero_evo` VALUES ('14', '82014', '83014');
INSERT INTO `t_hero_evo` VALUES ('15', '82015', '83015');
INSERT INTO `t_hero_evo` VALUES ('16', '82016', '83016');
INSERT INTO `t_hero_evo` VALUES ('17', '82017', '83017');
INSERT INTO `t_hero_evo` VALUES ('18', '82018', '83018');
INSERT INTO `t_hero_evo` VALUES ('19', '82019', '83019');
INSERT INTO `t_hero_evo` VALUES ('20', '82020', '83020');
INSERT INTO `t_hero_evo` VALUES ('21', '82021', '83021');
INSERT INTO `t_hero_evo` VALUES ('22', '82022', '83022');
INSERT INTO `t_hero_evo` VALUES ('23', '82023', '83023');
INSERT INTO `t_hero_evo` VALUES ('24', '82024', '83024');
INSERT INTO `t_hero_evo` VALUES ('25', '82025', '83025');
INSERT INTO `t_hero_evo` VALUES ('26', '82026', '83026');
INSERT INTO `t_hero_evo` VALUES ('27', '82027', '83027');
INSERT INTO `t_hero_evo` VALUES ('28', '82028', '83028');
INSERT INTO `t_hero_evo` VALUES ('29', '82029', '83029');
INSERT INTO `t_hero_evo` VALUES ('30', '82030', '83030');
INSERT INTO `t_hero_evo` VALUES ('31', '82031', '83031');
INSERT INTO `t_hero_evo` VALUES ('32', '82032', '83032');
INSERT INTO `t_hero_evo` VALUES ('33', '82033', '83033');
INSERT INTO `t_hero_evo` VALUES ('34', '82034', '83034');
INSERT INTO `t_hero_evo` VALUES ('35', '82035', '83035');
INSERT INTO `t_hero_evo` VALUES ('36', '82036', '83036');
INSERT INTO `t_hero_evo` VALUES ('37', '82037', '83037');
INSERT INTO `t_hero_evo` VALUES ('38', '82038', '83038');
INSERT INTO `t_hero_evo` VALUES ('39', '82039', '83039');
INSERT INTO `t_hero_evo` VALUES ('40', '82040', '83040');
INSERT INTO `t_hero_evo` VALUES ('41', '82041', '83041');
INSERT INTO `t_hero_evo` VALUES ('42', '82042', '83042');
INSERT INTO `t_hero_evo` VALUES ('43', '82043', '83043');
INSERT INTO `t_hero_evo` VALUES ('44', '82044', '83044');
INSERT INTO `t_hero_evo` VALUES ('45', '82045', '83045');
INSERT INTO `t_hero_evo` VALUES ('46', '82046', '83046');
INSERT INTO `t_hero_evo` VALUES ('47', '82047', '83047');
INSERT INTO `t_hero_evo` VALUES ('48', '82048', '83048');
INSERT INTO `t_hero_evo` VALUES ('49', '82049', '83049');
INSERT INTO `t_hero_evo` VALUES ('50', '82050', '83050');
INSERT INTO `t_hero_evo` VALUES ('51', '82051', '83051');
INSERT INTO `t_hero_evo` VALUES ('52', '82052', '83052');
INSERT INTO `t_hero_evo` VALUES ('53', '82053', '83053');
INSERT INTO `t_hero_evo` VALUES ('54', '82054', '83054');
INSERT INTO `t_hero_evo` VALUES ('55', '82055', '83055');
INSERT INTO `t_hero_evo` VALUES ('56', '82056', '83056');
INSERT INTO `t_hero_evo` VALUES ('57', '82057', '83057');
INSERT INTO `t_hero_evo` VALUES ('58', '82058', '83058');
INSERT INTO `t_hero_evo` VALUES ('59', '82059', '83059');
INSERT INTO `t_hero_evo` VALUES ('60', '82060', '83060');
INSERT INTO `t_hero_evo` VALUES ('61', '82061', '83061');
INSERT INTO `t_hero_evo` VALUES ('62', '82062', '83062');
INSERT INTO `t_hero_evo` VALUES ('63', '82063', '83063');
INSERT INTO `t_hero_evo` VALUES ('64', '82064', '83064');
INSERT INTO `t_hero_evo` VALUES ('65', '82065', '83065');
INSERT INTO `t_hero_evo` VALUES ('66', '82066', '83066');
INSERT INTO `t_hero_evo` VALUES ('67', '82067', '83067');
INSERT INTO `t_hero_evo` VALUES ('68', '82068', '83068');
INSERT INTO `t_hero_evo` VALUES ('69', '82069', '83069');
INSERT INTO `t_hero_evo` VALUES ('70', '82070', '83070');
INSERT INTO `t_hero_evo` VALUES ('71', '82071', '83071');
INSERT INTO `t_hero_evo` VALUES ('72', '82072', '83072');
INSERT INTO `t_hero_evo` VALUES ('73', '82073', '83073');
INSERT INTO `t_hero_evo` VALUES ('74', '82074', '83074');
INSERT INTO `t_hero_evo` VALUES ('75', '82075', '83075');

-- ----------------------------
-- Table structure for t_hero_evo_material
-- ----------------------------
DROP TABLE IF EXISTS `t_hero_evo_material`;
CREATE TABLE `t_hero_evo_material` (
  `evo_id` int(11) NOT NULL COMMENT '进化编号',
  `type` int(11) NOT NULL COMMENT '类型',
  `ass_id` int(11) NOT NULL COMMENT '对应编号',
  `num` int(11) NOT NULL COMMENT '数量'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hero_evo_material
-- ----------------------------
INSERT INTO `t_hero_evo_material` VALUES ('1', '1', '90001', '1');
INSERT INTO `t_hero_evo_material` VALUES ('1', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('2', '1', '90017', '1');
INSERT INTO `t_hero_evo_material` VALUES ('2', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('3', '1', '90002', '1');
INSERT INTO `t_hero_evo_material` VALUES ('3', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('4', '1', '90014', '1');
INSERT INTO `t_hero_evo_material` VALUES ('4', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('5', '1', '90010', '1');
INSERT INTO `t_hero_evo_material` VALUES ('5', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('6', '1', '90014', '1');
INSERT INTO `t_hero_evo_material` VALUES ('6', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('7', '1', '90005', '1');
INSERT INTO `t_hero_evo_material` VALUES ('7', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('8', '1', '90006', '1');
INSERT INTO `t_hero_evo_material` VALUES ('8', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('9', '1', '90018', '1');
INSERT INTO `t_hero_evo_material` VALUES ('9', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('10', '1', '90016', '1');
INSERT INTO `t_hero_evo_material` VALUES ('10', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('11', '1', '90005', '1');
INSERT INTO `t_hero_evo_material` VALUES ('11', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('12', '1', '90002', '1');
INSERT INTO `t_hero_evo_material` VALUES ('12', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('13', '1', '90019', '1');
INSERT INTO `t_hero_evo_material` VALUES ('13', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('14', '1', '90020', '1');
INSERT INTO `t_hero_evo_material` VALUES ('14', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('15', '1', '90014', '1');
INSERT INTO `t_hero_evo_material` VALUES ('15', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('16', '1', '90003', '1');
INSERT INTO `t_hero_evo_material` VALUES ('16', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('17', '1', '90011', '1');
INSERT INTO `t_hero_evo_material` VALUES ('17', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('18', '1', '90005', '1');
INSERT INTO `t_hero_evo_material` VALUES ('18', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('19', '1', '90017', '1');
INSERT INTO `t_hero_evo_material` VALUES ('19', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('20', '1', '90017', '1');
INSERT INTO `t_hero_evo_material` VALUES ('20', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('21', '1', '90009', '1');
INSERT INTO `t_hero_evo_material` VALUES ('21', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('22', '1', '90016', '1');
INSERT INTO `t_hero_evo_material` VALUES ('22', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('23', '1', '90001', '1');
INSERT INTO `t_hero_evo_material` VALUES ('23', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('24', '1', '90020', '1');
INSERT INTO `t_hero_evo_material` VALUES ('24', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('25', '1', '90012', '1');
INSERT INTO `t_hero_evo_material` VALUES ('25', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('26', '1', '90004', '1');
INSERT INTO `t_hero_evo_material` VALUES ('26', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('27', '1', '90016', '1');
INSERT INTO `t_hero_evo_material` VALUES ('27', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('28', '1', '90005', '1');
INSERT INTO `t_hero_evo_material` VALUES ('28', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('29', '1', '90013', '1');
INSERT INTO `t_hero_evo_material` VALUES ('29', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('30', '1', '90004', '1');
INSERT INTO `t_hero_evo_material` VALUES ('30', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('31', '1', '90008', '1');
INSERT INTO `t_hero_evo_material` VALUES ('31', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('32', '1', '90017', '1');
INSERT INTO `t_hero_evo_material` VALUES ('32', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('33', '1', '90013', '1');
INSERT INTO `t_hero_evo_material` VALUES ('33', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('34', '1', '90013', '1');
INSERT INTO `t_hero_evo_material` VALUES ('34', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('35', '1', '90004', '1');
INSERT INTO `t_hero_evo_material` VALUES ('35', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('36', '1', '90016', '1');
INSERT INTO `t_hero_evo_material` VALUES ('36', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('37', '1', '90008', '1');
INSERT INTO `t_hero_evo_material` VALUES ('37', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('38', '1', '90012', '1');
INSERT INTO `t_hero_evo_material` VALUES ('38', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('39', '1', '90020', '1');
INSERT INTO `t_hero_evo_material` VALUES ('39', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('40', '1', '90004', '1');
INSERT INTO `t_hero_evo_material` VALUES ('40', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('41', '1', '90010', '1');
INSERT INTO `t_hero_evo_material` VALUES ('41', '2', '0', '500');
INSERT INTO `t_hero_evo_material` VALUES ('42', '1', '90002', '1');
INSERT INTO `t_hero_evo_material` VALUES ('42', '2', '0', '500');
INSERT INTO `t_hero_evo_material` VALUES ('43', '1', '90006', '1');
INSERT INTO `t_hero_evo_material` VALUES ('43', '2', '0', '500');
INSERT INTO `t_hero_evo_material` VALUES ('44', '1', '90002', '1');
INSERT INTO `t_hero_evo_material` VALUES ('44', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('45', '1', '90006', '1');
INSERT INTO `t_hero_evo_material` VALUES ('45', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('46', '1', '90010', '1');
INSERT INTO `t_hero_evo_material` VALUES ('46', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('47', '1', '90001', '1');
INSERT INTO `t_hero_evo_material` VALUES ('47', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('48', '1', '90001', '1');
INSERT INTO `t_hero_evo_material` VALUES ('48', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('49', '1', '90005', '1');
INSERT INTO `t_hero_evo_material` VALUES ('49', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('50', '1', '90009', '1');
INSERT INTO `t_hero_evo_material` VALUES ('50', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('51', '1', '90013', '1');
INSERT INTO `t_hero_evo_material` VALUES ('51', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('52', '1', '90013', '1');
INSERT INTO `t_hero_evo_material` VALUES ('52', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('53', '1', '90001', '1');
INSERT INTO `t_hero_evo_material` VALUES ('53', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('54', '1', '90005', '1');
INSERT INTO `t_hero_evo_material` VALUES ('54', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('55', '1', '90005', '1');
INSERT INTO `t_hero_evo_material` VALUES ('55', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('56', '1', '90009', '1');
INSERT INTO `t_hero_evo_material` VALUES ('56', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('57', '1', '90009', '1');
INSERT INTO `t_hero_evo_material` VALUES ('57', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('58', '1', '90017', '1');
INSERT INTO `t_hero_evo_material` VALUES ('58', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('59', '1', '90003', '1');
INSERT INTO `t_hero_evo_material` VALUES ('59', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('60', '1', '90011', '1');
INSERT INTO `t_hero_evo_material` VALUES ('60', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('61', '1', '90007', '1');
INSERT INTO `t_hero_evo_material` VALUES ('61', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('62', '1', '90015', '1');
INSERT INTO `t_hero_evo_material` VALUES ('62', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('63', '1', '90001', '1');
INSERT INTO `t_hero_evo_material` VALUES ('63', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('64', '1', '90001', '1');
INSERT INTO `t_hero_evo_material` VALUES ('64', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('65', '1', '90005', '1');
INSERT INTO `t_hero_evo_material` VALUES ('65', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('66', '1', '90005', '1');
INSERT INTO `t_hero_evo_material` VALUES ('66', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('67', '1', '90009', '1');
INSERT INTO `t_hero_evo_material` VALUES ('67', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('68', '1', '90009', '1');
INSERT INTO `t_hero_evo_material` VALUES ('68', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('69', '1', '90017', '1');
INSERT INTO `t_hero_evo_material` VALUES ('69', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('70', '1', '90017', '1');
INSERT INTO `t_hero_evo_material` VALUES ('70', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('71', '1', '90012', '1');
INSERT INTO `t_hero_evo_material` VALUES ('71', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('72', '1', '90016', '1');
INSERT INTO `t_hero_evo_material` VALUES ('72', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('73', '1', '90020', '1');
INSERT INTO `t_hero_evo_material` VALUES ('73', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('74', '1', '90016', '1');
INSERT INTO `t_hero_evo_material` VALUES ('74', '2', '0', '1000');
INSERT INTO `t_hero_evo_material` VALUES ('75', '1', '90016', '1');
INSERT INTO `t_hero_evo_material` VALUES ('75', '2', '0', '1000');

-- ----------------------------
-- Table structure for t_hero_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_hero_relation`;
CREATE TABLE `t_hero_relation` (
  `ass_hero` varchar(50) NOT NULL COMMENT '英雄',
  `skill_id` int(11) NOT NULL COMMENT '技能id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hero_relation
-- ----------------------------
INSERT INTO `t_hero_relation` VALUES ('1,2', '3000');
INSERT INTO `t_hero_relation` VALUES ('3,4,5', '3001');
INSERT INTO `t_hero_relation` VALUES ('6,7,8,9', '3002');

-- ----------------------------
-- Table structure for t_hero_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_hero_rule`;
CREATE TABLE `t_hero_rule` (
  `level` int(11) NOT NULL COMMENT '伙伴等级',
  `next_exp` int(11) NOT NULL COMMENT '升级所需经验',
  `money` int(11) NOT NULL COMMENT '升级消耗金钱',
  `rong_lian_exp` int(11) NOT NULL COMMENT '熔炼所得熔炼点',
  `fen_jie_exp` int(11) NOT NULL COMMENT '分解所得经验点'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hero_rule
-- ----------------------------
INSERT INTO `t_hero_rule` VALUES ('1', '20', '20', '0', '0');
INSERT INTO `t_hero_rule` VALUES ('2', '40', '40', '1', '100');
INSERT INTO `t_hero_rule` VALUES ('3', '60', '60', '3', '300');
INSERT INTO `t_hero_rule` VALUES ('4', '80', '80', '6', '600');
INSERT INTO `t_hero_rule` VALUES ('5', '100', '100', '10', '1000');
INSERT INTO `t_hero_rule` VALUES ('6', '120', '120', '15', '1500');
INSERT INTO `t_hero_rule` VALUES ('7', '140', '140', '21', '2100');
INSERT INTO `t_hero_rule` VALUES ('8', '160', '160', '28', '2800');
INSERT INTO `t_hero_rule` VALUES ('9', '180', '180', '36', '3600');
INSERT INTO `t_hero_rule` VALUES ('10', '200', '200', '45', '4500');
INSERT INTO `t_hero_rule` VALUES ('11', '220', '220', '55', '5500');
INSERT INTO `t_hero_rule` VALUES ('12', '240', '240', '67', '6700');
INSERT INTO `t_hero_rule` VALUES ('13', '260', '260', '81', '8100');
INSERT INTO `t_hero_rule` VALUES ('14', '280', '280', '97', '9700');
INSERT INTO `t_hero_rule` VALUES ('15', '300', '300', '115', '11500');
INSERT INTO `t_hero_rule` VALUES ('16', '320', '320', '135', '13500');
INSERT INTO `t_hero_rule` VALUES ('17', '340', '340', '157', '15700');
INSERT INTO `t_hero_rule` VALUES ('18', '360', '360', '181', '18100');
INSERT INTO `t_hero_rule` VALUES ('19', '380', '380', '207', '20700');
INSERT INTO `t_hero_rule` VALUES ('20', '400', '400', '235', '23500');
INSERT INTO `t_hero_rule` VALUES ('21', '420', '420', '265', '26500');
INSERT INTO `t_hero_rule` VALUES ('22', '440', '440', '329', '32900');
INSERT INTO `t_hero_rule` VALUES ('23', '460', '460', '397', '39700');
INSERT INTO `t_hero_rule` VALUES ('24', '480', '480', '469', '46900');
INSERT INTO `t_hero_rule` VALUES ('25', '500', '500', '545', '54500');
INSERT INTO `t_hero_rule` VALUES ('26', '520', '520', '625', '62500');
INSERT INTO `t_hero_rule` VALUES ('27', '540', '540', '709', '70900');
INSERT INTO `t_hero_rule` VALUES ('28', '560', '560', '797', '79700');
INSERT INTO `t_hero_rule` VALUES ('29', '580', '580', '889', '88900');
INSERT INTO `t_hero_rule` VALUES ('30', '600', '600', '985', '98500');
INSERT INTO `t_hero_rule` VALUES ('31', '620', '620', '1085', '108500');
INSERT INTO `t_hero_rule` VALUES ('32', '640', '640', '1191', '119100');
INSERT INTO `t_hero_rule` VALUES ('33', '660', '660', '1303', '130300');
INSERT INTO `t_hero_rule` VALUES ('34', '680', '680', '1421', '142100');
INSERT INTO `t_hero_rule` VALUES ('35', '700', '700', '1545', '154500');
INSERT INTO `t_hero_rule` VALUES ('36', '720', '720', '1675', '167500');
INSERT INTO `t_hero_rule` VALUES ('37', '740', '740', '1811', '181100');
INSERT INTO `t_hero_rule` VALUES ('38', '760', '760', '1953', '195300');
INSERT INTO `t_hero_rule` VALUES ('39', '780', '780', '2101', '210100');
INSERT INTO `t_hero_rule` VALUES ('40', '800', '800', '2255', '225500');
INSERT INTO `t_hero_rule` VALUES ('41', '820', '820', '2415', '241500');
INSERT INTO `t_hero_rule` VALUES ('42', '840', '840', '2581', '258100');
INSERT INTO `t_hero_rule` VALUES ('43', '860', '860', '2753', '275300');
INSERT INTO `t_hero_rule` VALUES ('44', '880', '880', '2931', '293100');
INSERT INTO `t_hero_rule` VALUES ('45', '900', '900', '3115', '311500');
INSERT INTO `t_hero_rule` VALUES ('46', '920', '920', '3305', '330500');
INSERT INTO `t_hero_rule` VALUES ('47', '940', '940', '3501', '350100');
INSERT INTO `t_hero_rule` VALUES ('48', '960', '960', '3703', '370300');
INSERT INTO `t_hero_rule` VALUES ('49', '980', '980', '3911', '391100');
INSERT INTO `t_hero_rule` VALUES ('50', '1000', '1000', '4125', '412500');
INSERT INTO `t_hero_rule` VALUES ('51', '1020', '1020', '4345', '434500');
INSERT INTO `t_hero_rule` VALUES ('52', '1040', '1040', '4571', '457100');
INSERT INTO `t_hero_rule` VALUES ('53', '1060', '1060', '4803', '480300');
INSERT INTO `t_hero_rule` VALUES ('54', '1080', '1080', '5041', '504100');
INSERT INTO `t_hero_rule` VALUES ('55', '1100', '1100', '5285', '528500');
INSERT INTO `t_hero_rule` VALUES ('56', '1120', '1120', '5535', '553500');
INSERT INTO `t_hero_rule` VALUES ('57', '1140', '1140', '5791', '579100');
INSERT INTO `t_hero_rule` VALUES ('58', '1160', '1160', '6053', '605300');
INSERT INTO `t_hero_rule` VALUES ('59', '1180', '1180', '6321', '632100');
INSERT INTO `t_hero_rule` VALUES ('60', '1200', '1200', '6595', '659500');
INSERT INTO `t_hero_rule` VALUES ('61', '1220', '1220', '6875', '687500');
INSERT INTO `t_hero_rule` VALUES ('62', '1240', '1240', '7161', '716100');
INSERT INTO `t_hero_rule` VALUES ('63', '1260', '1260', '7453', '745300');
INSERT INTO `t_hero_rule` VALUES ('64', '1280', '1280', '7751', '775100');
INSERT INTO `t_hero_rule` VALUES ('65', '1300', '1300', '8055', '805500');
INSERT INTO `t_hero_rule` VALUES ('66', '1320', '1320', '8365', '836500');
INSERT INTO `t_hero_rule` VALUES ('67', '1340', '1340', '8681', '868100');
INSERT INTO `t_hero_rule` VALUES ('68', '1360', '1360', '9003', '900300');
INSERT INTO `t_hero_rule` VALUES ('69', '1380', '1380', '9331', '933100');
INSERT INTO `t_hero_rule` VALUES ('70', '1400', '1400', '9665', '966500');
INSERT INTO `t_hero_rule` VALUES ('71', '1420', '1420', '10005', '1000500');
INSERT INTO `t_hero_rule` VALUES ('72', '1440', '1440', '10353', '1035300');
INSERT INTO `t_hero_rule` VALUES ('73', '1460', '1460', '10709', '1070900');
INSERT INTO `t_hero_rule` VALUES ('74', '1480', '1480', '11073', '1107300');
INSERT INTO `t_hero_rule` VALUES ('75', '1500', '1500', '11445', '1144500');
INSERT INTO `t_hero_rule` VALUES ('76', '1520', '1520', '11825', '1182500');
INSERT INTO `t_hero_rule` VALUES ('77', '1540', '1540', '12213', '1221300');
INSERT INTO `t_hero_rule` VALUES ('78', '1560', '1560', '12609', '1260900');
INSERT INTO `t_hero_rule` VALUES ('79', '1580', '1580', '13013', '1301300');
INSERT INTO `t_hero_rule` VALUES ('80', '1600', '1600', '13425', '1342500');
INSERT INTO `t_hero_rule` VALUES ('81', '1620', '1620', '13845', '1384500');
INSERT INTO `t_hero_rule` VALUES ('82', '1640', '1640', '14273', '1427300');
INSERT INTO `t_hero_rule` VALUES ('83', '1660', '1660', '14709', '1470900');
INSERT INTO `t_hero_rule` VALUES ('84', '1680', '1680', '15153', '1515300');
INSERT INTO `t_hero_rule` VALUES ('85', '1700', '1700', '15605', '1560500');
INSERT INTO `t_hero_rule` VALUES ('86', '1720', '1720', '16065', '1606500');
INSERT INTO `t_hero_rule` VALUES ('87', '1740', '1740', '16533', '1653300');
INSERT INTO `t_hero_rule` VALUES ('88', '1760', '1760', '17009', '1700900');
INSERT INTO `t_hero_rule` VALUES ('89', '1780', '1780', '17493', '1749300');
INSERT INTO `t_hero_rule` VALUES ('90', '1800', '1800', '17985', '1798500');
INSERT INTO `t_hero_rule` VALUES ('91', '1820', '1820', '18485', '1848500');
INSERT INTO `t_hero_rule` VALUES ('92', '1840', '1840', '18995', '1899500');
INSERT INTO `t_hero_rule` VALUES ('93', '1860', '1860', '19515', '1951500');
INSERT INTO `t_hero_rule` VALUES ('94', '1880', '1880', '20045', '2004500');
INSERT INTO `t_hero_rule` VALUES ('95', '1900', '1900', '20585', '2058500');
INSERT INTO `t_hero_rule` VALUES ('96', '1920', '1920', '21135', '2113500');
INSERT INTO `t_hero_rule` VALUES ('97', '1940', '1940', '21695', '2169500');
INSERT INTO `t_hero_rule` VALUES ('98', '1960', '1960', '22265', '2226500');
INSERT INTO `t_hero_rule` VALUES ('99', '1980', '1980', '22845', '2284500');
INSERT INTO `t_hero_rule` VALUES ('100', '2000', '2000', '23435', '2343500');
INSERT INTO `t_hero_rule` VALUES ('0', '0', '0', '0', '0');
INSERT INTO `t_hero_rule` VALUES ('0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for t_mall
-- ----------------------------
DROP TABLE IF EXISTS `t_mall`;
CREATE TABLE `t_mall` (
  `id` int(11) NOT NULL COMMENT '编号',
  `name` varchar(50) NOT NULL COMMENT '商品名称',
  `icon` varchar(50) NOT NULL COMMENT '商品图片',
  `des` varchar(128) NOT NULL COMMENT '商品描述',
  `type` int(11) NOT NULL COMMENT '商店类型',
  `vip` int(11) NOT NULL COMMENT 'vip限购',
  `state` int(11) NOT NULL COMMENT '状态',
  `money_type` int(11) NOT NULL COMMENT '金钱类型',
  `original_money` int(11) NOT NULL COMMENT '原价',
  `money` int(11) NOT NULL COMMENT '金钱数量',
  `buy_count` int(11) NOT NULL COMMENT '每日最大购买次数',
  `tole_count` int(11) NOT NULL COMMENT '终身限购次数',
  `shelves_time` timestamp NULL DEFAULT NULL COMMENT '下架时间',
  `putaway_time` timestamp NULL DEFAULT NULL COMMENT '上架时间',
  `pool_id` int(11) NOT NULL COMMENT '池子id',
  `rate` int(11) NOT NULL COMMENT '概率'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mall
-- ----------------------------
INSERT INTO `t_mall` VALUES ('1', '', '', '', '2', '0', '0', '2', '0', '10', '0', '0', null, null, '1', '20');
INSERT INTO `t_mall` VALUES ('2', '', '', '', '2', '0', '0', '1', '0', '1000', '0', '0', null, null, '1', '20');
INSERT INTO `t_mall` VALUES ('3', '', '', '', '2', '0', '0', '2', '0', '20', '0', '0', null, null, '1', '20');
INSERT INTO `t_mall` VALUES ('4', '', '', '', '2', '0', '0', '1', '0', '1000', '0', '0', null, null, '1', '20');
INSERT INTO `t_mall` VALUES ('5', '', '', '', '2', '0', '0', '1', '0', '1000', '0', '0', null, null, '1', '20');
INSERT INTO `t_mall` VALUES ('6', '', '', '', '2', '0', '0', '2', '0', '500000', '0', '0', null, null, '2', '50');
INSERT INTO `t_mall` VALUES ('7', '', '', '', '2', '0', '0', '2', '0', '100000', '0', '0', null, null, '2', '50');
INSERT INTO `t_mall` VALUES ('8', '', '', '', '2', '0', '0', '2', '0', '500000', '0', '0', null, null, '3', '50');
INSERT INTO `t_mall` VALUES ('9', '', '', '', '2', '0', '0', '1', '0', '100000', '0', '0', null, null, '3', '50');
INSERT INTO `t_mall` VALUES ('10', '', '', '', '2', '0', '0', '1', '0', '1000', '0', '0', null, null, '4', '50');
INSERT INTO `t_mall` VALUES ('11', '', '', '', '2', '0', '0', '2', '0', '20', '0', '0', null, null, '4', '50');
INSERT INTO `t_mall` VALUES ('12', '', '', '', '2', '0', '0', '2', '0', '10000', '0', '0', null, null, '5', '50');
INSERT INTO `t_mall` VALUES ('13', '', '', '', '2', '0', '0', '1', '0', '1000', '0', '0', null, null, '5', '50');
INSERT INTO `t_mall` VALUES ('14', '', '', '', '2', '0', '0', '2', '0', '2000', '0', '0', null, null, '6', '25');
INSERT INTO `t_mall` VALUES ('15', '', '', '', '2', '0', '0', '2', '0', '1000', '0', '0', null, null, '6', '25');
INSERT INTO `t_mall` VALUES ('16', '', '', '', '2', '0', '0', '1', '0', '2000', '0', '0', null, null, '6', '25');
INSERT INTO `t_mall` VALUES ('17', '', '', '', '2', '0', '0', '1', '0', '2000', '0', '0', null, null, '6', '25');
INSERT INTO `t_mall` VALUES ('18', 'VIP1超值礼包', '4020005', '可以获得大量钻石和金币以及经验药水', '1', '1', '1', '1', '99999', '99', '0', '1', '2016-07-25 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('19', 'VIP2超值礼包', '4020005', '可以获得大量钻石和金币以及经验药水', '1', '2', '1', '1', '99999', '99', '0', '1', '2016-07-25 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('20', 'VIP3超值礼包', '4020005', '可以获得大量钻石和金币以及经验药水', '1', '3', '1', '1', '99999', '99', '0', '1', '2016-07-25 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('21', 'VIP4超值礼包', '4020005', '可以获得大量钻石和金币以及经验药水', '1', '4', '1', '1', '99999', '99', '0', '1', '2016-07-25 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('22', 'VIP5超值礼包', '4020005', '可以获得大量钻石和金币以及经验药水', '1', '5', '1', '1', '99999', '99', '0', '1', '2016-07-25 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('23', 'VIP6超值礼包', '4020005', '可以获得大量钻石和金币以及经验药水', '1', '6', '1', '1', '99999', '99', '0', '1', '2016-07-25 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('24', 'VIP7超值礼包', '4020005', '可以获得大量钻石和金币以及经验药水', '1', '7', '1', '1', '99999', '99', '0', '1', '2016-07-25 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('25', 'VIP8超值礼包', '4020005', '可以获得大量钻石和金币以及经验药水', '1', '8', '1', '1', '99999', '99', '0', '1', '2016-07-25 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('26', 'VIP9超值礼包', '4020005', '可以获得大量钻石和金币以及经验药水', '1', '9', '1', '1', '99999', '99', '0', '1', '2016-07-25 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('27', 'VIP10超值礼包', '4020005', '可以获得大量钻石和金币以及经验药水', '1', '10', '1', '1', '99999', '99', '0', '1', '2016-07-25 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('28', 'VIP11超值礼包', '4020005', '可以获得大量钻石和金币以及经验药水', '1', '11', '1', '1', '99999', '99', '0', '1', '2016-07-25 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('29', 'VIP12超值礼包', '4020005', '可以获得大量钻石和金币以及经验药水', '1', '12', '1', '1', '99999', '99', '0', '1', '2016-07-25 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('30', 'VIP13超值礼包', '4020005', '可以获得大量钻石和金币以及经验药水', '1', '13', '1', '1', '99999', '99', '0', '1', '2016-07-25 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('31', 'VIP14超值礼包', '4020005', '可以获得大量钻石和金币以及经验药水', '1', '14', '1', '1', '99999', '99', '0', '1', '2016-07-25 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('32', 'VIP15超值礼包', '4020005', '可以获得大量钻石和金币以及经验药水', '1', '15', '1', '1', '99999', '99', '0', '1', '2016-07-25 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('33', '秘银棒促销', '4020008', '一大包秘银棒', '1', '0', '1', '2', '999', '9', '3', '0', '2016-07-26 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('34', '元气石促销', '4020009', '一大包元气石', '1', '0', '2', '1', '12345', '123', '5', '0', '2016-07-26 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('35', '能量石促销', '4020009', '一大包能量石', '1', '0', '2', '1', '12345', '123', '5', '0', '2016-07-27 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('36', '补签卡促销', '4020011', '一大包补签卡', '1', '0', '2', '1', '12345', '123', '5', '0', '2016-07-28 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('37', '扫荡券促销', '4020011', '一大包扫荡券', '1', '0', '2', '1', '12345', '123', '5', '0', '2016-07-29 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('38', '分解吕布一只', '1001005', '40级吕布一个', '1', '0', '1', '1', '2', '222', '10', '0', '2016-07-28 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('39', '熔炼武器一把', '4020008', '满级武器熔炼用', '1', '0', '1', '1', '5', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('40', '上古石板100个', 'shiban2', '上古石板100个', '1', '0', '1', '1', '8', '333', '100', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('41', '上古石板1000个', 'shiban2', '上古石板1000个', '1', '0', '1', '1', '9', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('42', '旧伙伴40个', '4030003', '全伙伴大礼包', '1', '0', '2', '1', '13', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('43', '新伙伴32个', '4030003', '全伙伴大礼包', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('44', '各级火焰包子', '1002004', '2-3-4-5星包子各4个', '1', '0', '2', '1', '11', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('45', '各级木灵包子', '1002008', '2-3-4-5星包子各4个', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('46', '各级冰霜包子', '1002012', '2-3-4-5星包子各4个', '1', '0', '2', '1', '11', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('47', '各级光明包子', '1002016', '2-3-4-5星包子各4个', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('48', '各级黑暗包子', '1002020', '2-3-4-5星包子各4个', '1', '0', '2', '1', '11', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('49', '1星装备包', '3030001', '1星武器和防具', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('50', '2星装备包', '3030006', '2星武器和防具', '1', '0', '2', '1', '11', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('51', '3星装备包', '3030011', '3星武器和防具', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('52', '4星装备包', '3030016', '4星武器和防具', '1', '0', '2', '1', '11', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('53', '5星装备包', '3030021', '5星武器和防具', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('54', '6星装备包', '3030026', '6星武器和防具', '1', '0', '2', '1', '11', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('55', '5星稀有装备包', '3030021', '5星稀有武器和防具', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('56', '6星稀有装备包', '3030026', '6星稀有武器和防具', '1', '0', '2', '1', '11', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('57', '普通武魂包', '6020001', '普通武魂包', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('58', '天狗武魂包', '6020007', '天狗武魂包', '1', '0', '2', '1', '11', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('59', '特殊武魂包', '6020013', '特殊武魂包', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('60', '毕方旋龟武魂包', '6020017', '毕方旋龟武魂包', '1', '0', '2', '1', '11', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('61', '夸父陆吾武魂包', '6020027', '夸父陆吾武魂包', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('62', '英招相柳武魂包', '6020037', '英招相柳武魂包', '1', '0', '2', '1', '11', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('63', '魍魉女娲武魂包', '6020047', '魍魉女娲武魂包', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('64', '穷奇重明武魂包', '6020057', '穷奇重明武魂包', '1', '0', '2', '1', '11', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('65', '下品突破石', '4023101', '下品突破石', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('66', '中品突破石', '4023102', '中品突破石', '1', '0', '2', '1', '11', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('67', '上品突破石', '4023103', '上品突破石', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('68', '精品突破石', '4023104', '精品突破石', '1', '0', '2', '1', '11', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('69', '极品突破石', '4023105', '极品突破石', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('70', '仙品突破石', '4023106', '仙品突破石', '1', '0', '2', '1', '11', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('71', '圣品突破石', '4023107', '圣品突破石', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('72', '进化道具测试宝箱', '4023601', '进化道具测试宝箱', '1', '0', '2', '1', '11', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('73', '金钥匙和金宝箱', '4040003', '测试用金钥匙和金宝箱', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('74', '银钥匙和银宝箱', '4040002', '测试用银钥匙和银宝箱', '1', '0', '2', '1', '11', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-26 18:00:00', '0', '0');
INSERT INTO `t_mall` VALUES ('75', '铜钥匙和铜宝箱', '4040001', '测试用铜钥匙和铜宝箱', '1', '0', '2', '1', '10', '333', '50', '0', '2016-07-31 18:00:00', '2015-07-25 18:00:00', '0', '0');

-- ----------------------------
-- Table structure for t_mall_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_mall_goods`;
CREATE TABLE `t_mall_goods` (
  `id` int(11) NOT NULL COMMENT '流水号',
  `mall_id` int(11) NOT NULL COMMENT '商城编号',
  `goods_id` int(11) NOT NULL COMMENT '物品编号',
  `type` int(11) NOT NULL COMMENT '物品类型',
  `num` int(11) NOT NULL COMMENT '数量',
  `level` int(11) NOT NULL COMMENT '等级'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mall_goods
-- ----------------------------
INSERT INTO `t_mall_goods` VALUES ('1', '1', '5020007', '7', '1', '0');
INSERT INTO `t_mall_goods` VALUES ('2', '2', '5020008', '7', '1', '0');
INSERT INTO `t_mall_goods` VALUES ('3', '3', '5020009', '7', '1', '0');
INSERT INTO `t_mall_goods` VALUES ('4', '4', '5020010', '7', '1', '0');
INSERT INTO `t_mall_goods` VALUES ('5', '5', '5020011', '7', '1', '0');
INSERT INTO `t_mall_goods` VALUES ('6', '6', '4020001', '4', '5', '0');
INSERT INTO `t_mall_goods` VALUES ('7', '7', '4020008', '4', '2', '0');
INSERT INTO `t_mall_goods` VALUES ('8', '8', '4020002', '4', '10', '0');
INSERT INTO `t_mall_goods` VALUES ('9', '9', '4020003', '4', '2', '0');
INSERT INTO `t_mall_goods` VALUES ('10', '10', '82007', '1', '1', '0');
INSERT INTO `t_mall_goods` VALUES ('11', '11', '82008', '1', '1', '0');
INSERT INTO `t_mall_goods` VALUES ('12', '12', '0', '2', '900000', '0');
INSERT INTO `t_mall_goods` VALUES ('13', '13', '0', '2', '900000', '0');
INSERT INTO `t_mall_goods` VALUES ('14', '14', '0', '3', '50000', '0');
INSERT INTO `t_mall_goods` VALUES ('15', '15', '0', '3', '500', '0');
INSERT INTO `t_mall_goods` VALUES ('16', '16', '0', '3', '1000', '0');
INSERT INTO `t_mall_goods` VALUES ('17', '17', '0', '3', '2000', '0');
INSERT INTO `t_mall_goods` VALUES ('18', '18', '0', '2', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('19', '18', '0', '3', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('20', '18', '4020001', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('21', '19', '0', '2', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('22', '19', '0', '3', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('23', '19', '4020001', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('24', '20', '0', '2', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('25', '20', '0', '3', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('26', '20', '4020001', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('27', '21', '0', '2', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('28', '21', '0', '3', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('29', '21', '4020001', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('30', '22', '0', '2', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('31', '22', '0', '3', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('32', '22', '4020001', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('33', '23', '0', '2', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('34', '23', '0', '3', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('35', '23', '4020001', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('36', '24', '0', '2', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('37', '24', '0', '3', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('38', '24', '4020001', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('39', '25', '0', '2', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('40', '25', '0', '3', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('41', '25', '4020001', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('42', '26', '0', '2', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('43', '26', '0', '3', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('44', '26', '4020001', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('45', '27', '0', '2', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('46', '27', '0', '3', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('47', '27', '4020001', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('48', '28', '0', '2', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('49', '28', '0', '3', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('50', '28', '4020001', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('51', '29', '0', '2', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('52', '29', '0', '3', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('53', '29', '4020001', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('54', '30', '0', '2', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('55', '30', '0', '3', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('56', '30', '4020001', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('57', '31', '0', '2', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('58', '31', '0', '3', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('59', '31', '4020001', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('60', '32', '0', '2', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('61', '32', '0', '3', '9000000', '0');
INSERT INTO `t_mall_goods` VALUES ('62', '32', '4020001', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('63', '33', '4020008', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('64', '34', '4020009', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('65', '35', '4020010', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('66', '36', '4020011', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('67', '37', '4020012', '4', '20', '0');
INSERT INTO `t_mall_goods` VALUES ('68', '38', '82003', '1', '1', '40');
INSERT INTO `t_mall_goods` VALUES ('69', '39', '3010017', '6', '1', '45');
INSERT INTO `t_mall_goods` VALUES ('70', '40', '0', '10', '100', '0');
INSERT INTO `t_mall_goods` VALUES ('71', '41', '0', '10', '1000', '0');
INSERT INTO `t_mall_goods` VALUES ('72', '42', '82001', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('73', '42', '82002', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('74', '42', '82003', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('75', '42', '82004', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('76', '42', '82005', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('77', '42', '82006', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('78', '42', '82007', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('79', '42', '82008', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('80', '42', '82009', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('81', '42', '82010', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('82', '42', '82011', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('83', '42', '82012', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('84', '42', '82013', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('85', '42', '82014', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('86', '42', '82015', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('87', '42', '82016', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('88', '42', '82017', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('89', '42', '82018', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('90', '42', '82019', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('91', '42', '82020', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('92', '42', '82021', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('93', '42', '82022', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('94', '42', '82023', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('95', '42', '82024', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('96', '42', '82025', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('97', '42', '82026', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('98', '42', '82027', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('99', '42', '82028', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('100', '42', '82029', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('101', '42', '82030', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('102', '42', '82031', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('103', '42', '82032', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('104', '42', '82033', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('105', '42', '82034', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('106', '42', '82035', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('107', '42', '82036', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('108', '42', '82037', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('109', '42', '82038', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('110', '42', '82039', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('111', '42', '82040', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('112', '43', '82044', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('113', '43', '82045', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('114', '43', '82046', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('115', '43', '82047', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('116', '43', '82048', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('117', '43', '82049', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('118', '43', '82050', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('119', '43', '82051', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('120', '43', '82052', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('121', '43', '82053', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('122', '43', '82054', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('123', '43', '82055', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('124', '43', '82056', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('125', '43', '82057', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('126', '43', '82058', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('127', '43', '82059', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('128', '43', '82060', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('129', '43', '82061', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('130', '43', '82062', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('131', '43', '82063', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('132', '43', '82064', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('133', '43', '82065', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('134', '43', '82066', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('135', '43', '82067', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('136', '43', '82068', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('137', '43', '82069', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('138', '43', '82070', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('139', '43', '82071', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('140', '43', '82072', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('141', '43', '82073', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('142', '43', '82074', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('143', '43', '82075', '1', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('144', '44', '90001', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('145', '44', '90002', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('146', '44', '90003', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('147', '44', '90004', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('148', '45', '90005', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('149', '45', '90006', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('150', '45', '90007', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('151', '45', '90008', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('152', '46', '90009', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('153', '46', '90010', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('154', '46', '90011', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('155', '46', '90012', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('156', '47', '90013', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('157', '47', '90014', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('158', '47', '90015', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('159', '47', '90016', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('160', '48', '90017', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('161', '48', '90018', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('162', '48', '90019', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('163', '48', '90020', '1', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('164', '49', '3030001', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('165', '49', '3030002', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('166', '49', '3030003', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('167', '49', '3030004', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('168', '49', '3030005', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('169', '49', '3040001', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('170', '49', '3040002', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('171', '49', '3040003', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('172', '49', '3040004', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('173', '49', '3040005', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('174', '50', '3030006', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('175', '50', '3030007', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('176', '50', '3030008', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('177', '50', '3030009', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('178', '50', '3030010', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('179', '50', '3040006', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('180', '50', '3040007', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('181', '50', '3040008', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('182', '50', '3040009', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('183', '50', '3040010', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('184', '51', '3030011', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('185', '51', '3030012', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('186', '51', '3030013', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('187', '51', '3030014', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('188', '51', '3030015', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('189', '51', '3040011', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('190', '51', '3040012', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('191', '51', '3040013', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('192', '51', '3040014', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('193', '51', '3040015', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('194', '52', '3030016', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('195', '52', '3030017', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('196', '52', '3030018', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('197', '52', '3030019', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('198', '52', '3030020', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('199', '52', '3040016', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('200', '52', '3040017', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('201', '52', '3040018', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('202', '52', '3040019', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('203', '52', '3040020', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('204', '53', '3030021', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('205', '53', '3030022', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('206', '53', '3030023', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('207', '53', '3030024', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('208', '53', '3030025', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('209', '53', '3040021', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('210', '53', '3040022', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('211', '53', '3040023', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('212', '53', '3040024', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('213', '53', '3040025', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('214', '54', '3030026', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('215', '54', '3030027', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('216', '54', '3030028', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('217', '54', '3030029', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('218', '54', '3030030', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('219', '54', '3040026', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('220', '54', '3040027', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('221', '54', '3040028', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('222', '54', '3040029', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('223', '54', '3040030', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('224', '55', '3030031', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('225', '55', '3030032', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('226', '55', '3030033', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('227', '55', '3030034', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('228', '55', '3030035', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('229', '55', '3040031', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('230', '55', '3040032', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('231', '55', '3040033', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('232', '55', '3040034', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('233', '55', '3040035', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('234', '56', '3030036', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('235', '56', '3030037', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('236', '56', '3030038', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('237', '56', '3030039', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('238', '56', '3030040', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('239', '56', '3040036', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('240', '56', '3040037', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('241', '56', '3040038', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('242', '56', '3040039', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('243', '56', '3040040', '6', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('244', '57', '5020001', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('245', '57', '5020002', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('246', '57', '5020003', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('247', '57', '5020004', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('248', '57', '5020005', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('249', '57', '5020006', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('250', '58', '5020007', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('251', '58', '5020008', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('252', '58', '5020009', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('253', '58', '5020010', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('254', '58', '5020011', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('255', '58', '5020012', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('256', '59', '5020013', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('257', '59', '5020014', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('258', '59', '5020015', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('259', '59', '5020016', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('260', '60', '5020017', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('261', '60', '5020018', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('262', '60', '5020019', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('263', '60', '5020020', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('264', '60', '5020021', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('265', '60', '5020022', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('266', '60', '5020023', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('267', '60', '5020024', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('268', '60', '5020025', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('269', '60', '5020026', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('270', '61', '5020027', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('271', '61', '5020028', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('272', '61', '5020029', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('273', '61', '5020030', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('274', '61', '5020031', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('275', '61', '5020032', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('276', '61', '5020033', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('277', '61', '5020034', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('278', '61', '5020035', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('279', '61', '5020036', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('280', '62', '5020037', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('281', '62', '5020038', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('282', '62', '5020039', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('283', '62', '5020040', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('284', '62', '5020041', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('285', '62', '5020042', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('286', '62', '5020043', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('287', '62', '5020044', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('288', '62', '5020045', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('289', '62', '5020046', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('290', '63', '5020047', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('291', '63', '5020048', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('292', '63', '5020049', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('293', '63', '5020050', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('294', '63', '5020051', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('295', '63', '5020052', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('296', '63', '5020053', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('297', '63', '5020054', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('298', '63', '5020055', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('299', '63', '5020056', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('300', '64', '5020057', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('301', '64', '5020058', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('302', '64', '5020059', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('303', '64', '5020060', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('304', '64', '5020061', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('305', '64', '5020062', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('306', '64', '5020063', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('307', '64', '5020064', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('308', '64', '5020065', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('309', '64', '5020066', '7', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('310', '65', '4023101', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('311', '65', '4023201', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('312', '65', '4023301', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('313', '65', '4023401', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('314', '65', '4023501', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('315', '65', '4023601', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('316', '66', '4023102', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('317', '66', '4023202', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('318', '66', '4023302', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('319', '66', '4023402', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('320', '66', '4023502', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('321', '66', '4023602', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('322', '67', '4023103', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('323', '67', '4023203', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('324', '67', '4023303', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('325', '67', '4023403', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('326', '67', '4023503', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('327', '67', '4023603', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('328', '68', '4023104', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('329', '68', '4023204', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('330', '68', '4023304', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('331', '68', '4023404', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('332', '68', '4023504', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('333', '68', '4023604', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('334', '69', '4023105', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('335', '69', '4023205', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('336', '69', '4023305', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('337', '69', '4023405', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('338', '69', '4023505', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('339', '69', '4023605', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('340', '70', '4023106', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('341', '70', '4023206', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('342', '70', '4023306', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('343', '70', '4023406', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('344', '70', '4023506', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('345', '70', '4023606', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('346', '71', '4023107', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('347', '71', '4023207', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('348', '71', '4023307', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('349', '71', '4023407', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('350', '71', '4023507', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('351', '71', '4023607', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('352', '72', '4021001', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('353', '72', '4021004', '4', '5', '1');
INSERT INTO `t_mall_goods` VALUES ('354', '73', '4020013', '4', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('355', '73', '4020016', '4', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('356', '74', '4020014', '4', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('357', '74', '4020017', '4', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('358', '75', '4020015', '4', '1', '1');
INSERT INTO `t_mall_goods` VALUES ('359', '75', '4020018', '4', '1', '1');

-- ----------------------------
-- Table structure for t_martial_way_award
-- ----------------------------
DROP TABLE IF EXISTS `t_martial_way_award`;
CREATE TABLE `t_martial_way_award` (
  `min_rank` int(11) NOT NULL COMMENT '排名最低值',
  `max_rank` int(11) NOT NULL COMMENT '排名最高值',
  `goods_id` int(11) NOT NULL COMMENT '物品ID',
  `type` int(11) NOT NULL COMMENT '物品类型',
  `num` int(11) NOT NULL COMMENT '物品数量',
  `level` int(11) NOT NULL COMMENT '物品等级'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_martial_way_award
-- ----------------------------
INSERT INTO `t_martial_way_award` VALUES ('1', '1', '0', '3', '1000', '0');
INSERT INTO `t_martial_way_award` VALUES ('1', '1', '0', '2', '10000', '0');
INSERT INTO `t_martial_way_award` VALUES ('2', '2', '0', '3', '500', '0');
INSERT INTO `t_martial_way_award` VALUES ('2', '2', '0', '2', '9000', '0');
INSERT INTO `t_martial_way_award` VALUES ('3', '3', '0', '3', '100', '0');
INSERT INTO `t_martial_way_award` VALUES ('3', '3', '0', '2', '8000', '0');
INSERT INTO `t_martial_way_award` VALUES ('4', '5', '0', '2', '7000', '0');
INSERT INTO `t_martial_way_award` VALUES ('6', '10', '0', '2', '6000', '0');
INSERT INTO `t_martial_way_award` VALUES ('11', '20', '0', '2', '5000', '0');
INSERT INTO `t_martial_way_award` VALUES ('21', '50', '0', '2', '4000', '0');
INSERT INTO `t_martial_way_award` VALUES ('51', '100', '0', '2', '3000', '0');
INSERT INTO `t_martial_way_award` VALUES ('101', '200', '0', '2', '2000', '0');
INSERT INTO `t_martial_way_award` VALUES ('201', '500', '0', '2', '1000', '0');
INSERT INTO `t_martial_way_award` VALUES ('501', '1000', '0', '2', '500', '0');
INSERT INTO `t_martial_way_award` VALUES ('1001', '100000', '0', '2', '100', '0');

-- ----------------------------
-- Table structure for t_martial_way_exp
-- ----------------------------
DROP TABLE IF EXISTS `t_martial_way_exp`;
CREATE TABLE `t_martial_way_exp` (
  `level` int(11) NOT NULL COMMENT '等级',
  `exp` int(11) NOT NULL COMMENT '奖励经验'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_martial_way_exp
-- ----------------------------
INSERT INTO `t_martial_way_exp` VALUES ('1', '20');
INSERT INTO `t_martial_way_exp` VALUES ('2', '30');
INSERT INTO `t_martial_way_exp` VALUES ('3', '40');
INSERT INTO `t_martial_way_exp` VALUES ('4', '50');
INSERT INTO `t_martial_way_exp` VALUES ('5', '60');
INSERT INTO `t_martial_way_exp` VALUES ('6', '70');
INSERT INTO `t_martial_way_exp` VALUES ('7', '80');
INSERT INTO `t_martial_way_exp` VALUES ('8', '90');
INSERT INTO `t_martial_way_exp` VALUES ('9', '100');
INSERT INTO `t_martial_way_exp` VALUES ('10', '110');
INSERT INTO `t_martial_way_exp` VALUES ('11', '120');
INSERT INTO `t_martial_way_exp` VALUES ('12', '130');
INSERT INTO `t_martial_way_exp` VALUES ('13', '140');
INSERT INTO `t_martial_way_exp` VALUES ('14', '150');
INSERT INTO `t_martial_way_exp` VALUES ('15', '160');
INSERT INTO `t_martial_way_exp` VALUES ('16', '170');
INSERT INTO `t_martial_way_exp` VALUES ('17', '180');
INSERT INTO `t_martial_way_exp` VALUES ('18', '190');
INSERT INTO `t_martial_way_exp` VALUES ('19', '200');
INSERT INTO `t_martial_way_exp` VALUES ('20', '210');
INSERT INTO `t_martial_way_exp` VALUES ('21', '220');
INSERT INTO `t_martial_way_exp` VALUES ('22', '230');
INSERT INTO `t_martial_way_exp` VALUES ('23', '240');
INSERT INTO `t_martial_way_exp` VALUES ('24', '250');
INSERT INTO `t_martial_way_exp` VALUES ('25', '260');
INSERT INTO `t_martial_way_exp` VALUES ('26', '270');
INSERT INTO `t_martial_way_exp` VALUES ('27', '280');
INSERT INTO `t_martial_way_exp` VALUES ('28', '290');
INSERT INTO `t_martial_way_exp` VALUES ('29', '300');
INSERT INTO `t_martial_way_exp` VALUES ('30', '310');
INSERT INTO `t_martial_way_exp` VALUES ('31', '320');
INSERT INTO `t_martial_way_exp` VALUES ('32', '330');
INSERT INTO `t_martial_way_exp` VALUES ('33', '340');
INSERT INTO `t_martial_way_exp` VALUES ('34', '350');
INSERT INTO `t_martial_way_exp` VALUES ('35', '360');
INSERT INTO `t_martial_way_exp` VALUES ('36', '370');
INSERT INTO `t_martial_way_exp` VALUES ('37', '380');
INSERT INTO `t_martial_way_exp` VALUES ('38', '390');
INSERT INTO `t_martial_way_exp` VALUES ('39', '400');
INSERT INTO `t_martial_way_exp` VALUES ('40', '410');
INSERT INTO `t_martial_way_exp` VALUES ('41', '420');
INSERT INTO `t_martial_way_exp` VALUES ('42', '430');
INSERT INTO `t_martial_way_exp` VALUES ('43', '440');
INSERT INTO `t_martial_way_exp` VALUES ('44', '450');
INSERT INTO `t_martial_way_exp` VALUES ('45', '460');
INSERT INTO `t_martial_way_exp` VALUES ('46', '470');
INSERT INTO `t_martial_way_exp` VALUES ('47', '480');
INSERT INTO `t_martial_way_exp` VALUES ('48', '490');
INSERT INTO `t_martial_way_exp` VALUES ('49', '500');
INSERT INTO `t_martial_way_exp` VALUES ('50', '510');
INSERT INTO `t_martial_way_exp` VALUES ('51', '520');
INSERT INTO `t_martial_way_exp` VALUES ('52', '530');
INSERT INTO `t_martial_way_exp` VALUES ('53', '540');
INSERT INTO `t_martial_way_exp` VALUES ('54', '550');
INSERT INTO `t_martial_way_exp` VALUES ('55', '560');
INSERT INTO `t_martial_way_exp` VALUES ('56', '570');
INSERT INTO `t_martial_way_exp` VALUES ('57', '580');
INSERT INTO `t_martial_way_exp` VALUES ('58', '590');
INSERT INTO `t_martial_way_exp` VALUES ('59', '600');
INSERT INTO `t_martial_way_exp` VALUES ('60', '610');
INSERT INTO `t_martial_way_exp` VALUES ('61', '620');
INSERT INTO `t_martial_way_exp` VALUES ('62', '630');
INSERT INTO `t_martial_way_exp` VALUES ('63', '640');
INSERT INTO `t_martial_way_exp` VALUES ('64', '650');
INSERT INTO `t_martial_way_exp` VALUES ('65', '660');
INSERT INTO `t_martial_way_exp` VALUES ('66', '670');
INSERT INTO `t_martial_way_exp` VALUES ('67', '680');
INSERT INTO `t_martial_way_exp` VALUES ('68', '690');
INSERT INTO `t_martial_way_exp` VALUES ('69', '700');
INSERT INTO `t_martial_way_exp` VALUES ('70', '710');
INSERT INTO `t_martial_way_exp` VALUES ('71', '720');
INSERT INTO `t_martial_way_exp` VALUES ('72', '730');
INSERT INTO `t_martial_way_exp` VALUES ('73', '740');
INSERT INTO `t_martial_way_exp` VALUES ('74', '750');
INSERT INTO `t_martial_way_exp` VALUES ('75', '760');
INSERT INTO `t_martial_way_exp` VALUES ('76', '770');
INSERT INTO `t_martial_way_exp` VALUES ('77', '780');
INSERT INTO `t_martial_way_exp` VALUES ('78', '790');
INSERT INTO `t_martial_way_exp` VALUES ('79', '800');
INSERT INTO `t_martial_way_exp` VALUES ('80', '810');
INSERT INTO `t_martial_way_exp` VALUES ('81', '820');
INSERT INTO `t_martial_way_exp` VALUES ('82', '830');
INSERT INTO `t_martial_way_exp` VALUES ('83', '840');
INSERT INTO `t_martial_way_exp` VALUES ('84', '850');
INSERT INTO `t_martial_way_exp` VALUES ('85', '860');
INSERT INTO `t_martial_way_exp` VALUES ('86', '870');
INSERT INTO `t_martial_way_exp` VALUES ('87', '880');
INSERT INTO `t_martial_way_exp` VALUES ('88', '890');
INSERT INTO `t_martial_way_exp` VALUES ('89', '900');
INSERT INTO `t_martial_way_exp` VALUES ('90', '910');
INSERT INTO `t_martial_way_exp` VALUES ('91', '920');
INSERT INTO `t_martial_way_exp` VALUES ('92', '930');
INSERT INTO `t_martial_way_exp` VALUES ('93', '940');
INSERT INTO `t_martial_way_exp` VALUES ('94', '950');
INSERT INTO `t_martial_way_exp` VALUES ('95', '960');
INSERT INTO `t_martial_way_exp` VALUES ('96', '970');
INSERT INTO `t_martial_way_exp` VALUES ('97', '980');
INSERT INTO `t_martial_way_exp` VALUES ('98', '990');
INSERT INTO `t_martial_way_exp` VALUES ('99', '1000');
INSERT INTO `t_martial_way_exp` VALUES ('100', '1010');

-- ----------------------------
-- Table structure for t_monster
-- ----------------------------
DROP TABLE IF EXISTS `t_monster`;
CREATE TABLE `t_monster` (
  `monster_id` int(11) NOT NULL COMMENT 'Index',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `lv` int(11) NOT NULL COMMENT '等级',
  `star_lv` int(11) NOT NULL COMMENT '星级',
  `description` varchar(128) NOT NULL COMMENT '描述',
  `img` varchar(50) NOT NULL COMMENT '对应资源',
  `ele` int(11) NOT NULL COMMENT '属性',
  `ele_lv` int(11) NOT NULL COMMENT '属性等级',
  `ability` int(11) NOT NULL COMMENT '能力',
  `hp` int(11) NOT NULL COMMENT '血量',
  `atk` int(11) NOT NULL COMMENT '攻击力',
  `atk_count` int(11) NOT NULL COMMENT '攻击次数',
  `block_rate` int(11) NOT NULL COMMENT '格挡率',
  `crit_rate` int(11) NOT NULL COMMENT '暴击率',
  `crit_hit` int(11) NOT NULL COMMENT '暴击伤害',
  `dodge_rate` int(11) NOT NULL COMMENT '躲闪率',
  `skill_id` int(11) NOT NULL COMMENT '前端用（BOSS技能）',
  `passive_skills` int(11) NOT NULL COMMENT '被动技能编号',
  `body_type` int(11) NOT NULL COMMENT '体型',
  `hurt_effect` int(11) NOT NULL COMMENT '打击特效'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_monster
-- ----------------------------
INSERT INTO `t_monster` VALUES ('2001001', '士兵', '1', '1', '', '1001001', '1', '1', '0', '26', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001002', '士兵', '2', '1', '', '1001001', '1', '1', '0', '26', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001003', '士兵', '3', '1', '', '1001001', '1', '1', '0', '26', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001004', '士兵', '4', '1', '', '1001001', '1', '1', '0', '35', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001005', '士兵', '5', '1', '', '1001001', '1', '1', '0', '35', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001006', '士兵', '6', '1', '', '1001001', '1', '1', '0', '35', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001007', '士兵', '7', '1', '', '1001001', '1', '1', '0', '60', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001008', '士兵', '8', '1', '', '1001001', '1', '1', '0', '60', '20', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001009', '士兵', '9', '1', '', '1001001', '1', '1', '0', '60', '20', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001010', '士兵', '10', '1', '', '1001001', '1', '1', '0', '86', '28', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001011', '士兵', '11', '1', '', '1001001', '1', '1', '0', '86', '28', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001012', '士兵', '12', '1', '', '1001001', '1', '1', '0', '86', '28', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001013', '士兵', '13', '1', '', '1001001', '1', '1', '0', '121', '40', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001014', '士兵', '14', '1', '', '1001001', '1', '1', '0', '121', '40', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001015', '士兵', '15', '1', '', '1001001', '1', '1', '0', '121', '40', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001016', '士兵', '16', '1', '', '1001001', '1', '1', '0', '147', '48', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001017', '士兵', '17', '1', '', '1001001', '1', '1', '0', '147', '48', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001018', '士兵', '18', '1', '', '1001001', '1', '1', '0', '147', '48', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001019', '士兵', '19', '1', '', '1001001', '1', '1', '0', '173', '57', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001020', '士兵', '20', '1', '', '1001001', '1', '1', '0', '173', '57', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001021', '士兵', '21', '1', '', '1001001', '1', '1', '0', '259', '85', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001022', '士兵', '22', '1', '', '1001001', '1', '1', '0', '298', '98', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001023', '士兵', '23', '1', '', '1001001', '1', '1', '0', '298', '98', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001024', '士兵', '24', '1', '', '1001001', '1', '1', '0', '298', '98', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001025', '士兵', '25', '1', '', '1001001', '1', '1', '0', '350', '115', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001026', '士兵', '26', '1', '', '1001001', '1', '1', '0', '363', '80', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001027', '士兵', '27', '1', '', '1001001', '1', '1', '0', '376', '82', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001028', '士兵', '28', '1', '', '1001001', '1', '1', '0', '389', '85', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001029', '士兵', '29', '1', '', '1001001', '1', '1', '0', '402', '88', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001030', '士兵', '30', '1', '', '1001001', '1', '1', '0', '415', '91', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001031', '士兵', '31', '1', '', '1001001', '1', '1', '0', '428', '94', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001032', '士兵', '32', '1', '', '1001001', '1', '1', '0', '441', '97', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001033', '士兵', '33', '1', '', '1001001', '1', '1', '0', '454', '99', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001034', '士兵', '34', '1', '', '1001001', '1', '1', '0', '467', '102', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001035', '士兵', '35', '1', '', '1001001', '1', '1', '0', '480', '105', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001036', '士兵', '36', '1', '', '1001001', '1', '1', '0', '492', '108', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001037', '士兵', '37', '1', '', '1001001', '1', '1', '0', '505', '111', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001038', '士兵', '38', '1', '', '1001001', '1', '1', '0', '518', '114', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001039', '士兵', '39', '1', '', '1001001', '1', '1', '0', '531', '117', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001040', '士兵', '40', '1', '', '1001001', '1', '1', '0', '544', '119', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001041', '士兵', '41', '1', '', '1001001', '1', '1', '0', '743', '163', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001042', '士兵', '42', '1', '', '1001001', '1', '1', '0', '760', '167', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2001043', '士兵', '43', '1', '', '1001001', '1', '1', '0', '778', '171', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2002001', '士官', '1', '1', '', '1001016', '2', '1', '0', '39', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002002', '士官', '2', '1', '', '1001016', '2', '1', '0', '39', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002003', '士官', '3', '1', '', '1001016', '2', '1', '0', '39', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002004', '士官', '4', '1', '', '1001016', '2', '1', '0', '52', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002005', '士官', '5', '1', '', '1001016', '2', '1', '0', '52', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002006', '士官', '6', '1', '', '1001016', '2', '1', '0', '52', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002007', '士官', '7', '1', '', '1001016', '2', '1', '0', '91', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002008', '士官', '8', '1', '', '1001016', '2', '1', '0', '91', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002009', '士官', '9', '1', '', '1001016', '2', '1', '0', '91', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002010', '士官', '10', '1', '', '1001016', '2', '1', '0', '130', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002011', '士官', '11', '1', '', '1001016', '2', '1', '0', '130', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002012', '士官', '12', '1', '', '1001016', '2', '1', '0', '130', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002013', '士官', '13', '1', '', '1001016', '2', '1', '0', '181', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002014', '士官', '14', '1', '', '1001016', '2', '1', '0', '181', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002015', '士官', '15', '1', '', '1001016', '2', '1', '0', '181', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002016', '士官', '16', '1', '', '1001016', '2', '1', '0', '220', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002017', '士官', '17', '1', '', '1001016', '2', '1', '0', '220', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002018', '士官', '18', '1', '', '1001016', '2', '1', '0', '220', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002019', '士官', '19', '1', '', '1001016', '2', '1', '0', '259', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002020', '士官', '20', '1', '', '1001016', '2', '1', '0', '259', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002021', '士官', '21', '1', '', '1001016', '2', '1', '0', '389', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002022', '士官', '22', '1', '', '1001016', '2', '1', '0', '447', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002023', '士官', '23', '1', '', '1001016', '2', '1', '0', '447', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002024', '士官', '24', '1', '', '1001016', '2', '1', '0', '447', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002025', '士官', '25', '1', '', '1001016', '2', '1', '0', '525', '64', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002026', '士官', '26', '1', '', '1001016', '2', '1', '0', '544', '44', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002027', '士官', '27', '1', '', '1001016', '2', '1', '0', '564', '46', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002028', '士官', '28', '1', '', '1001016', '2', '1', '0', '583', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002029', '士官', '29', '1', '', '1001016', '2', '1', '0', '603', '49', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002030', '士官', '30', '1', '', '1001016', '2', '1', '0', '622', '51', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002031', '士官', '31', '1', '', '1001016', '2', '1', '0', '642', '52', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002032', '士官', '32', '1', '', '1001016', '2', '1', '0', '661', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002033', '士官', '33', '1', '', '1001016', '2', '1', '0', '680', '55', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002034', '士官', '34', '1', '', '1001016', '2', '1', '0', '700', '57', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002035', '士官', '35', '1', '', '1001016', '2', '1', '0', '719', '58', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002036', '士官', '36', '1', '', '1001016', '2', '1', '0', '739', '60', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002037', '士官', '37', '1', '', '1001016', '2', '1', '0', '758', '62', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002038', '士官', '38', '1', '', '1001016', '2', '1', '0', '778', '63', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002039', '士官', '39', '1', '', '1001016', '2', '1', '0', '797', '65', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002040', '士官', '40', '1', '', '1001016', '2', '1', '0', '816', '66', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002041', '士官', '41', '1', '', '1001016', '2', '1', '0', '1115', '91', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002042', '士官', '42', '1', '', '1001016', '2', '1', '0', '1140', '93', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2002043', '士官', '43', '1', '', '1001016', '2', '1', '0', '1166', '95', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2003001', '禁卫', '1', '1', '', '1001003', '4', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003002', '禁卫', '2', '1', '', '1001003', '4', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003003', '禁卫', '3', '1', '', '1001003', '4', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003004', '禁卫', '4', '1', '', '1001003', '4', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003005', '禁卫', '5', '1', '', '1001003', '4', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003006', '禁卫', '6', '1', '', '1001003', '4', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003007', '禁卫', '7', '1', '', '1001003', '4', '1', '0', '76', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003008', '禁卫', '8', '1', '', '1001003', '4', '1', '0', '76', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003009', '禁卫', '9', '1', '', '1001003', '4', '1', '0', '76', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003010', '禁卫', '10', '1', '', '1001003', '4', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003011', '禁卫', '11', '1', '', '1001003', '4', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003012', '禁卫', '12', '1', '', '1001003', '4', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003013', '禁卫', '13', '1', '', '1001003', '4', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003014', '禁卫', '14', '1', '', '1001003', '4', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003015', '禁卫', '15', '1', '', '1001003', '4', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003016', '禁卫', '16', '1', '', '1001003', '4', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003017', '禁卫', '17', '1', '', '1001003', '4', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003018', '禁卫', '18', '1', '', '1001003', '4', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003019', '禁卫', '19', '1', '', '1001003', '4', '1', '0', '216', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003020', '禁卫', '20', '1', '', '1001003', '4', '1', '0', '216', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003021', '禁卫', '21', '1', '', '1001003', '4', '1', '0', '324', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003022', '禁卫', '22', '1', '', '1001003', '4', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003023', '禁卫', '23', '1', '', '1001003', '4', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003024', '禁卫', '24', '1', '', '1001003', '4', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003025', '禁卫', '25', '1', '', '1001003', '4', '1', '0', '437', '64', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003026', '禁卫', '26', '1', '', '1001003', '4', '1', '0', '454', '44', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003027', '禁卫', '27', '1', '', '1001003', '4', '1', '0', '470', '46', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003028', '禁卫', '28', '1', '', '1001003', '4', '1', '0', '486', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003029', '禁卫', '29', '1', '', '1001003', '4', '1', '0', '502', '49', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003030', '禁卫', '30', '1', '', '1001003', '4', '1', '0', '518', '51', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003031', '禁卫', '31', '1', '', '1001003', '4', '1', '0', '535', '52', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003032', '禁卫', '32', '1', '', '1001003', '4', '1', '0', '551', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003033', '禁卫', '33', '1', '', '1001003', '4', '1', '0', '567', '55', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003034', '禁卫', '34', '1', '', '1001003', '4', '1', '0', '583', '57', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003035', '禁卫', '35', '1', '', '1001003', '4', '1', '0', '599', '58', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003036', '禁卫', '36', '1', '', '1001003', '4', '1', '0', '616', '60', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003037', '禁卫', '37', '1', '', '1001003', '4', '1', '0', '632', '62', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003038', '禁卫', '38', '1', '', '1001003', '4', '1', '0', '648', '63', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003039', '禁卫', '39', '1', '', '1001003', '4', '1', '0', '664', '65', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003040', '禁卫', '40', '1', '', '1001003', '4', '1', '0', '680', '66', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003041', '禁卫', '41', '1', '', '1001003', '4', '1', '0', '929', '91', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003042', '禁卫', '42', '1', '', '1001003', '4', '1', '0', '950', '93', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2003043', '禁卫', '43', '1', '', '1001003', '4', '1', '0', '972', '95', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2004001', '枪兵', '1', '1', '', '1001076', '5', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004002', '枪兵', '2', '1', '', '1001076', '5', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004003', '枪兵', '3', '1', '', '1001076', '5', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004004', '枪兵', '4', '1', '', '1001076', '5', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004005', '枪兵', '5', '1', '', '1001076', '5', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004006', '枪兵', '6', '1', '', '1001076', '5', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004007', '枪兵', '7', '1', '', '1001076', '5', '1', '0', '76', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004008', '枪兵', '8', '1', '', '1001076', '5', '1', '0', '76', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004009', '枪兵', '9', '1', '', '1001076', '5', '1', '0', '76', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004010', '枪兵', '10', '1', '', '1001076', '5', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004011', '枪兵', '11', '1', '', '1001076', '5', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004012', '枪兵', '12', '1', '', '1001076', '5', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004013', '枪兵', '13', '1', '', '1001076', '5', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004014', '枪兵', '14', '1', '', '1001076', '5', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004015', '枪兵', '15', '1', '', '1001076', '5', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004016', '枪兵', '16', '1', '', '1001076', '5', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004017', '枪兵', '17', '1', '', '1001076', '5', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004018', '枪兵', '18', '1', '', '1001076', '5', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004019', '枪兵', '19', '1', '', '1001076', '5', '1', '0', '216', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004020', '枪兵', '20', '1', '', '1001076', '5', '1', '0', '216', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004021', '枪兵', '21', '1', '', '1001076', '5', '1', '0', '324', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004022', '枪兵', '22', '1', '', '1001076', '5', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004023', '枪兵', '23', '1', '', '1001076', '5', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004024', '枪兵', '24', '1', '', '1001076', '5', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004025', '枪兵', '25', '1', '', '1001076', '5', '1', '0', '437', '64', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004026', '枪兵', '26', '1', '', '1001076', '5', '1', '0', '454', '44', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004027', '枪兵', '27', '1', '', '1001076', '5', '1', '0', '470', '46', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004028', '枪兵', '28', '1', '', '1001076', '5', '1', '0', '486', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004029', '枪兵', '29', '1', '', '1001076', '5', '1', '0', '502', '49', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004030', '枪兵', '30', '1', '', '1001076', '5', '1', '0', '518', '51', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004031', '枪兵', '31', '1', '', '1001076', '5', '1', '0', '535', '52', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004032', '枪兵', '32', '1', '', '1001076', '5', '1', '0', '551', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004033', '枪兵', '33', '1', '', '1001076', '5', '1', '0', '567', '55', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004034', '枪兵', '34', '1', '', '1001076', '5', '1', '0', '583', '57', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004035', '枪兵', '35', '1', '', '1001076', '5', '1', '0', '599', '58', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004036', '枪兵', '36', '1', '', '1001076', '5', '1', '0', '616', '60', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004037', '枪兵', '37', '1', '', '1001076', '5', '1', '0', '632', '62', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004038', '枪兵', '38', '1', '', '1001076', '5', '1', '0', '648', '63', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004039', '枪兵', '39', '1', '', '1001076', '5', '1', '0', '664', '65', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004040', '枪兵', '40', '1', '', '1001076', '5', '1', '0', '680', '66', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004041', '枪兵', '41', '1', '', '1001076', '5', '1', '0', '929', '91', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004042', '枪兵', '42', '1', '', '1001076', '5', '1', '0', '950', '93', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2004043', '枪兵', '43', '1', '', '1001076', '5', '1', '0', '972', '95', '1', '0', '0', '12500', '0', '0', '0', '0', '8032002');
INSERT INTO `t_monster` VALUES ('2005001', '兵长', '1', '1', '', '1001078', '5', '1', '0', '39', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005002', '兵长', '2', '1', '', '1001078', '5', '1', '0', '39', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005003', '兵长', '3', '1', '', '1001078', '5', '1', '0', '39', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005004', '兵长', '4', '1', '', '1001078', '5', '1', '0', '52', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005005', '兵长', '5', '1', '', '1001078', '5', '1', '0', '52', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005006', '兵长', '6', '1', '', '1001078', '5', '1', '0', '52', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005007', '兵长', '7', '1', '', '1001078', '5', '1', '0', '91', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005008', '兵长', '8', '1', '', '1001078', '5', '1', '0', '91', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005009', '兵长', '9', '1', '', '1001078', '5', '1', '0', '91', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005010', '兵长', '10', '1', '', '1001078', '5', '1', '0', '130', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005011', '兵长', '11', '1', '', '1001078', '5', '1', '0', '130', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005012', '兵长', '12', '1', '', '1001078', '5', '1', '0', '130', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005013', '兵长', '13', '1', '', '1001078', '5', '1', '0', '181', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005014', '兵长', '14', '1', '', '1001078', '5', '1', '0', '181', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005015', '兵长', '15', '1', '', '1001078', '5', '1', '0', '181', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005016', '兵长', '16', '1', '', '1001078', '5', '1', '0', '220', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005017', '兵长', '17', '1', '', '1001078', '5', '1', '0', '220', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005018', '兵长', '18', '1', '', '1001078', '5', '1', '0', '220', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005019', '兵长', '19', '1', '', '1001078', '5', '1', '0', '259', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005020', '兵长', '20', '1', '', '1001078', '5', '1', '0', '259', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005021', '兵长', '21', '1', '', '1001078', '5', '1', '0', '389', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005022', '兵长', '22', '1', '', '1001078', '5', '1', '0', '447', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005023', '兵长', '23', '1', '', '1001078', '5', '1', '0', '447', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005024', '兵长', '24', '1', '', '1001078', '5', '1', '0', '447', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005025', '兵长', '25', '1', '', '1001078', '5', '1', '0', '525', '64', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005026', '兵长', '26', '1', '', '1001078', '5', '1', '0', '544', '44', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005027', '兵长', '27', '1', '', '1001078', '5', '1', '0', '564', '46', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005028', '兵长', '28', '1', '', '1001078', '5', '1', '0', '583', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005029', '兵长', '29', '1', '', '1001078', '5', '1', '0', '603', '49', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005030', '兵长', '30', '1', '', '1001078', '5', '1', '0', '622', '51', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005031', '兵长', '31', '1', '', '1001078', '5', '1', '0', '642', '52', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005032', '兵长', '32', '1', '', '1001078', '5', '1', '0', '661', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005033', '兵长', '33', '1', '', '1001078', '5', '1', '0', '680', '55', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005034', '兵长', '34', '1', '', '1001078', '5', '1', '0', '700', '57', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005035', '兵长', '35', '1', '', '1001078', '5', '1', '0', '719', '58', '1', '1', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005036', '兵长', '36', '1', '', '1001078', '5', '1', '0', '739', '60', '1', '2', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005037', '兵长', '37', '1', '', '1001078', '5', '1', '0', '758', '62', '1', '3', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005038', '兵长', '38', '1', '', '1001078', '5', '1', '0', '778', '63', '1', '4', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005039', '兵长', '39', '1', '', '1001078', '5', '1', '0', '797', '65', '1', '5', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005040', '兵长', '40', '1', '', '1001078', '5', '1', '0', '816', '66', '1', '6', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005041', '兵长', '41', '1', '', '1001078', '5', '1', '0', '1115', '91', '1', '7', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005042', '兵长', '42', '1', '', '1001078', '5', '1', '0', '1140', '93', '1', '8', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2005043', '兵长', '43', '1', '', '1001078', '5', '1', '0', '1166', '95', '1', '9', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('2006001', '蝎子精', '1', '1', '', '1001052', '1', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006002', '蝎子精', '2', '1', '', '1001052', '1', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006003', '蝎子精', '3', '1', '', '1001052', '1', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006004', '蝎子精', '4', '1', '', '1001052', '1', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006005', '蝎子精', '5', '1', '', '1001052', '1', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006006', '蝎子精', '6', '1', '', '1001052', '1', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006007', '蝎子精', '7', '1', '', '1001052', '1', '1', '0', '76', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006008', '蝎子精', '8', '1', '', '1001052', '1', '1', '0', '76', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006009', '蝎子精', '9', '1', '', '1001052', '1', '1', '0', '76', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006010', '蝎子精', '10', '1', '', '1001052', '1', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006011', '蝎子精', '11', '1', '', '1001052', '1', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006012', '蝎子精', '12', '1', '', '1001052', '1', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006013', '蝎子精', '13', '1', '', '1001052', '1', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006014', '蝎子精', '14', '1', '', '1001052', '1', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006015', '蝎子精', '15', '1', '', '1001052', '1', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006016', '蝎子精', '16', '1', '', '1001052', '1', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006017', '蝎子精', '17', '1', '', '1001052', '1', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006018', '蝎子精', '18', '1', '', '1001052', '1', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006019', '蝎子精', '19', '1', '', '1001052', '1', '1', '0', '216', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006020', '蝎子精', '20', '1', '', '1001052', '1', '1', '0', '216', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006021', '蝎子精', '21', '1', '', '1001052', '1', '1', '0', '324', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006022', '蝎子精', '22', '1', '', '1001052', '1', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006023', '蝎子精', '23', '1', '', '1001052', '1', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006024', '蝎子精', '24', '1', '', '1001052', '1', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006025', '蝎子精', '25', '1', '', '1001052', '1', '1', '0', '437', '64', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006026', '蝎子精', '26', '1', '', '1001052', '1', '1', '0', '454', '44', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006027', '蝎子精', '27', '1', '', '1001052', '1', '1', '0', '470', '46', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006028', '蝎子精', '28', '1', '', '1001052', '1', '1', '0', '486', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006029', '蝎子精', '29', '1', '', '1001052', '1', '1', '0', '502', '49', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006030', '蝎子精', '30', '1', '', '1001052', '1', '1', '0', '518', '51', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006031', '蝎子精', '31', '1', '', '1001052', '1', '1', '0', '535', '52', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006032', '蝎子精', '32', '1', '', '1001052', '1', '1', '0', '551', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006033', '蝎子精', '33', '1', '', '1001052', '1', '1', '0', '567', '55', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006034', '蝎子精', '34', '1', '', '1001052', '1', '1', '0', '583', '57', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006035', '蝎子精', '35', '1', '', '1001052', '1', '1', '0', '599', '58', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006036', '蝎子精', '36', '1', '', '1001052', '1', '1', '0', '616', '60', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006037', '蝎子精', '37', '1', '', '1001052', '1', '1', '0', '632', '62', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006038', '蝎子精', '38', '1', '', '1001052', '1', '1', '0', '648', '63', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006039', '蝎子精', '39', '1', '', '1001052', '1', '1', '0', '664', '65', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006040', '蝎子精', '40', '1', '', '1001052', '1', '1', '0', '680', '66', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006041', '蝎子精', '41', '1', '', '1001052', '1', '1', '0', '929', '91', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006042', '蝎子精', '42', '1', '', '1001052', '1', '1', '0', '950', '93', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2006043', '蝎子精', '43', '1', '', '1001052', '1', '1', '0', '972', '95', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007001', '仙童', '1', '1', '', '1001066', '5', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007002', '仙童', '2', '1', '', '1001066', '5', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007003', '仙童', '3', '1', '', '1001066', '5', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007004', '仙童', '4', '1', '', '1001066', '5', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007005', '仙童', '5', '1', '', '1001066', '5', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007006', '仙童', '6', '1', '', '1001066', '5', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007007', '仙童', '7', '1', '', '1001066', '5', '1', '0', '76', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007008', '仙童', '8', '1', '', '1001066', '5', '1', '0', '76', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007009', '仙童', '9', '1', '', '1001066', '5', '1', '0', '76', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007010', '仙童', '10', '1', '', '1001066', '5', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007011', '仙童', '11', '1', '', '1001066', '5', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007012', '仙童', '12', '1', '', '1001066', '5', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007013', '仙童', '13', '1', '', '1001066', '5', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007014', '仙童', '14', '1', '', '1001066', '5', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007015', '仙童', '15', '1', '', '1001066', '5', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007016', '仙童', '16', '1', '', '1001066', '5', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007017', '仙童', '17', '1', '', '1001066', '5', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007018', '仙童', '18', '1', '', '1001066', '5', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007019', '仙童', '19', '1', '', '1001066', '5', '1', '0', '216', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007020', '仙童', '20', '1', '', '1001066', '5', '1', '0', '216', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007021', '仙童', '21', '1', '', '1001066', '5', '1', '0', '324', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007022', '仙童', '22', '1', '', '1001066', '5', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007023', '仙童', '23', '1', '', '1001066', '5', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007024', '仙童', '24', '1', '', '1001066', '5', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007025', '仙童', '25', '1', '', '1001066', '5', '1', '0', '437', '64', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007026', '仙童', '26', '1', '', '1001066', '5', '1', '0', '454', '44', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007027', '仙童', '27', '1', '', '1001066', '5', '1', '0', '470', '46', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007028', '仙童', '28', '1', '', '1001066', '5', '1', '0', '486', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007029', '仙童', '29', '1', '', '1001066', '5', '1', '0', '502', '49', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007030', '仙童', '30', '1', '', '1001066', '5', '1', '0', '518', '51', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007031', '仙童', '31', '1', '', '1001066', '5', '1', '0', '535', '52', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007032', '仙童', '32', '1', '', '1001066', '5', '1', '0', '551', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007033', '仙童', '33', '1', '', '1001066', '5', '1', '0', '567', '55', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007034', '仙童', '34', '1', '', '1001066', '5', '1', '0', '583', '57', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007035', '仙童', '35', '1', '', '1001066', '5', '1', '0', '599', '58', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007036', '仙童', '36', '1', '', '1001066', '5', '1', '0', '616', '60', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007037', '仙童', '37', '1', '', '1001066', '5', '1', '0', '632', '62', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007038', '仙童', '38', '1', '', '1001066', '5', '1', '0', '648', '63', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007039', '仙童', '39', '1', '', '1001066', '5', '1', '0', '664', '65', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007040', '仙童', '40', '1', '', '1001066', '5', '1', '0', '680', '66', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007041', '仙童', '41', '1', '', '1001066', '5', '1', '0', '929', '91', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007042', '仙童', '42', '1', '', '1001066', '5', '1', '0', '950', '93', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2007043', '仙童', '43', '1', '', '1001066', '5', '1', '0', '972', '95', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008001', '鬼将', '1', '1', '', '1001045', '1', '1', '0', '26', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008002', '鬼将', '2', '1', '', '1001045', '1', '1', '0', '26', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008003', '鬼将', '3', '1', '', '1001045', '1', '1', '0', '26', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008004', '鬼将', '4', '1', '', '1001045', '1', '1', '0', '35', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008005', '鬼将', '5', '1', '', '1001045', '1', '1', '0', '35', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008006', '鬼将', '6', '1', '', '1001045', '1', '1', '0', '35', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008007', '鬼将', '7', '1', '', '1001045', '1', '1', '0', '60', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008008', '鬼将', '8', '1', '', '1001045', '1', '1', '0', '60', '20', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008009', '鬼将', '9', '1', '', '1001045', '1', '1', '0', '60', '20', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008010', '鬼将', '10', '1', '', '1001045', '1', '1', '0', '86', '28', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008011', '鬼将', '11', '1', '', '1001045', '1', '1', '0', '86', '28', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008012', '鬼将', '12', '1', '', '1001045', '1', '1', '0', '86', '28', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008013', '鬼将', '13', '1', '', '1001045', '1', '1', '0', '121', '40', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008014', '鬼将', '14', '1', '', '1001045', '1', '1', '0', '121', '40', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008015', '鬼将', '15', '1', '', '1001045', '1', '1', '0', '121', '40', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008016', '鬼将', '16', '1', '', '1001045', '1', '1', '0', '147', '48', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008017', '鬼将', '17', '1', '', '1001045', '1', '1', '0', '147', '48', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008018', '鬼将', '18', '1', '', '1001045', '1', '1', '0', '147', '48', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008019', '鬼将', '19', '1', '', '1001045', '1', '1', '0', '173', '57', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008020', '鬼将', '20', '1', '', '1001045', '1', '1', '0', '173', '57', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008021', '鬼将', '21', '1', '', '1001045', '1', '1', '0', '259', '85', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008022', '鬼将', '22', '1', '', '1001045', '1', '1', '0', '298', '98', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008023', '鬼将', '23', '1', '', '1001045', '1', '1', '0', '298', '98', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008024', '鬼将', '24', '1', '', '1001045', '1', '1', '0', '298', '98', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008025', '鬼将', '25', '1', '', '1001045', '1', '1', '0', '350', '115', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008026', '鬼将', '26', '1', '', '1001045', '1', '1', '0', '363', '80', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008027', '鬼将', '27', '1', '', '1001045', '1', '1', '0', '376', '82', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008028', '鬼将', '28', '1', '', '1001045', '1', '1', '0', '389', '85', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008029', '鬼将', '29', '1', '', '1001045', '1', '1', '0', '402', '88', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008030', '鬼将', '30', '1', '', '1001045', '1', '1', '0', '415', '91', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008031', '鬼将', '31', '1', '', '1001045', '1', '1', '0', '428', '94', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008032', '鬼将', '32', '1', '', '1001045', '1', '1', '0', '441', '97', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008033', '鬼将', '33', '1', '', '1001045', '1', '1', '0', '454', '99', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008034', '鬼将', '34', '1', '', '1001045', '1', '1', '0', '467', '102', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008035', '鬼将', '35', '1', '', '1001045', '1', '1', '0', '480', '105', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008036', '鬼将', '36', '1', '', '1001045', '1', '1', '0', '492', '108', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008037', '鬼将', '37', '1', '', '1001045', '1', '1', '0', '505', '111', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008038', '鬼将', '38', '1', '', '1001045', '1', '1', '0', '518', '114', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008039', '鬼将', '39', '1', '', '1001045', '1', '1', '0', '531', '117', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008040', '鬼将', '40', '1', '', '1001045', '1', '1', '0', '544', '119', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008041', '鬼将', '41', '1', '', '1001045', '1', '1', '0', '743', '163', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008042', '鬼将', '42', '1', '', '1001045', '1', '1', '0', '760', '167', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2008043', '鬼将', '43', '1', '', '1001045', '1', '1', '0', '778', '171', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2009001', '寒冰蟾', '1', '1', '', '1001047', '1', '1', '0', '39', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009002', '寒冰蟾', '2', '1', '', '1001047', '3', '1', '0', '39', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009003', '寒冰蟾', '3', '1', '', '1001047', '3', '1', '0', '39', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009004', '寒冰蟾', '4', '1', '', '1001047', '3', '1', '0', '52', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009005', '寒冰蟾', '5', '1', '', '1001047', '3', '1', '0', '52', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009006', '寒冰蟾', '6', '1', '', '1001047', '3', '1', '0', '52', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009007', '寒冰蟾', '7', '1', '', '1001047', '3', '1', '0', '91', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009008', '寒冰蟾', '8', '1', '', '1001047', '3', '1', '0', '91', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009009', '寒冰蟾', '9', '1', '', '1001047', '3', '1', '0', '91', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009010', '寒冰蟾', '10', '1', '', '1001047', '3', '1', '0', '130', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009011', '寒冰蟾', '11', '1', '', '1001047', '3', '1', '0', '130', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009012', '寒冰蟾', '12', '1', '', '1001047', '3', '1', '0', '130', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009013', '寒冰蟾', '13', '1', '', '1001047', '3', '1', '0', '181', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009014', '寒冰蟾', '14', '1', '', '1001047', '3', '1', '0', '181', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009015', '寒冰蟾', '15', '1', '', '1001047', '3', '1', '0', '181', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009016', '寒冰蟾', '16', '1', '', '1001047', '3', '1', '0', '220', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009017', '寒冰蟾', '17', '1', '', '1001047', '3', '1', '0', '220', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009018', '寒冰蟾', '18', '1', '', '1001047', '3', '1', '0', '220', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009019', '寒冰蟾', '19', '1', '', '1001047', '3', '1', '0', '259', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009020', '寒冰蟾', '20', '1', '', '1001047', '3', '1', '0', '259', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009021', '寒冰蟾', '21', '1', '', '1001047', '3', '1', '0', '389', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009022', '寒冰蟾', '22', '1', '', '1001047', '3', '1', '0', '447', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009023', '寒冰蟾', '23', '1', '', '1001047', '3', '1', '0', '447', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009024', '寒冰蟾', '24', '1', '', '1001047', '3', '1', '0', '447', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009025', '寒冰蟾', '25', '1', '', '1001047', '3', '1', '0', '525', '64', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009026', '寒冰蟾', '26', '1', '', '1001047', '3', '1', '0', '544', '44', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009027', '寒冰蟾', '27', '1', '', '1001047', '3', '1', '0', '564', '46', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009028', '寒冰蟾', '28', '1', '', '1001047', '3', '1', '0', '583', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009029', '寒冰蟾', '29', '1', '', '1001047', '3', '1', '0', '603', '49', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009030', '寒冰蟾', '30', '1', '', '1001047', '3', '1', '0', '622', '51', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009031', '寒冰蟾', '31', '1', '', '1001047', '3', '1', '0', '642', '52', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009032', '寒冰蟾', '32', '1', '', '1001047', '3', '1', '0', '661', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009033', '寒冰蟾', '33', '1', '', '1001047', '3', '1', '0', '680', '55', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009034', '寒冰蟾', '34', '1', '', '1001047', '3', '1', '0', '700', '57', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009035', '寒冰蟾', '35', '1', '', '1001047', '3', '1', '0', '719', '58', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009036', '寒冰蟾', '36', '1', '', '1001047', '3', '1', '0', '739', '60', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009037', '寒冰蟾', '37', '1', '', '1001047', '3', '1', '0', '758', '62', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009038', '寒冰蟾', '38', '1', '', '1001047', '3', '1', '0', '778', '63', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009039', '寒冰蟾', '39', '1', '', '1001047', '3', '1', '0', '797', '65', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009040', '寒冰蟾', '40', '1', '', '1001047', '3', '1', '0', '816', '66', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009041', '寒冰蟾', '41', '1', '', '1001047', '3', '1', '0', '1115', '91', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009042', '寒冰蟾', '42', '1', '', '1001047', '3', '1', '0', '1140', '93', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2009043', '寒冰蟾', '43', '1', '', '1001047', '3', '1', '0', '1166', '95', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2010001', '火凤', '1', '1', '', '1001036', '1', '1', '0', '26', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010002', '火凤', '2', '1', '', '1001036', '1', '1', '0', '26', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010003', '火凤', '3', '1', '', '1001036', '1', '1', '0', '26', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010004', '火凤', '4', '1', '', '1001036', '1', '1', '0', '35', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010005', '火凤', '5', '1', '', '1001036', '1', '1', '0', '35', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010006', '火凤', '6', '1', '', '1001036', '1', '1', '0', '35', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010007', '火凤', '7', '1', '', '1001036', '1', '1', '0', '60', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010008', '火凤', '8', '1', '', '1001036', '1', '1', '0', '60', '20', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010009', '火凤', '9', '1', '', '1001036', '1', '1', '0', '60', '20', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010010', '火凤', '10', '1', '', '1001036', '1', '1', '0', '86', '28', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010011', '火凤', '11', '1', '', '1001036', '1', '1', '0', '86', '28', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010012', '火凤', '12', '1', '', '1001036', '1', '1', '0', '86', '28', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010013', '火凤', '13', '1', '', '1001036', '1', '1', '0', '121', '40', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010014', '火凤', '14', '1', '', '1001036', '1', '1', '0', '121', '40', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010015', '火凤', '15', '1', '', '1001036', '1', '1', '0', '121', '40', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010016', '火凤', '16', '1', '', '1001036', '1', '1', '0', '147', '48', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010017', '火凤', '17', '1', '', '1001036', '1', '1', '0', '147', '48', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010018', '火凤', '18', '1', '', '1001036', '1', '1', '0', '147', '48', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010019', '火凤', '19', '1', '', '1001036', '1', '1', '0', '173', '57', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010020', '火凤', '20', '1', '', '1001036', '1', '1', '0', '173', '57', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010021', '火凤', '21', '1', '', '1001036', '1', '1', '0', '259', '85', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010022', '火凤', '22', '1', '', '1001036', '1', '1', '0', '298', '98', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010023', '火凤', '23', '1', '', '1001036', '1', '1', '0', '298', '98', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010024', '火凤', '24', '1', '', '1001036', '1', '1', '0', '298', '98', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010025', '火凤', '25', '1', '', '1001036', '1', '1', '0', '350', '115', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010026', '火凤', '26', '1', '', '1001036', '1', '1', '0', '363', '80', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010027', '火凤', '27', '1', '', '1001036', '1', '1', '0', '376', '82', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010028', '火凤', '28', '1', '', '1001036', '1', '1', '0', '389', '85', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010029', '火凤', '29', '1', '', '1001036', '1', '1', '0', '402', '88', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010030', '火凤', '30', '1', '', '1001036', '1', '1', '0', '415', '91', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010031', '火凤', '31', '1', '', '1001036', '1', '1', '0', '428', '94', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010032', '火凤', '32', '1', '', '1001036', '1', '1', '0', '441', '97', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010033', '火凤', '33', '1', '', '1001036', '1', '1', '0', '454', '99', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010034', '火凤', '34', '1', '', '1001036', '1', '1', '0', '467', '102', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010035', '火凤', '35', '1', '', '1001036', '1', '1', '0', '480', '105', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010036', '火凤', '36', '1', '', '1001036', '1', '1', '0', '492', '108', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010037', '火凤', '37', '1', '', '1001036', '1', '1', '0', '505', '111', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010038', '火凤', '38', '1', '', '1001036', '1', '1', '0', '518', '114', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010039', '火凤', '39', '1', '', '1001036', '1', '1', '0', '531', '117', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010040', '火凤', '40', '1', '', '1001036', '1', '1', '0', '544', '119', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010041', '火凤', '41', '1', '', '1001036', '1', '1', '0', '743', '163', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010042', '火凤', '42', '1', '', '1001036', '1', '1', '0', '760', '167', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2010043', '火凤', '43', '1', '', '1001036', '1', '1', '0', '778', '171', '1', '0', '0', '12500', '0', '0', '0', '0', '8033004');
INSERT INTO `t_monster` VALUES ('2011001', '冰凤', '1', '1', '', '1001038', '3', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011002', '冰凤', '2', '1', '', '1001038', '3', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011003', '冰凤', '3', '1', '', '1001038', '3', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011004', '冰凤', '4', '1', '', '1001038', '3', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011005', '冰凤', '5', '1', '', '1001038', '3', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011006', '冰凤', '6', '1', '', '1001038', '3', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011007', '冰凤', '7', '1', '', '1001038', '3', '1', '0', '76', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011008', '冰凤', '8', '1', '', '1001038', '3', '1', '0', '76', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011009', '冰凤', '9', '1', '', '1001038', '3', '1', '0', '76', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011010', '冰凤', '10', '1', '', '1001038', '3', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011011', '冰凤', '11', '1', '', '1001038', '3', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011012', '冰凤', '12', '1', '', '1001038', '3', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011013', '冰凤', '13', '1', '', '1001038', '3', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011014', '冰凤', '14', '1', '', '1001038', '3', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011015', '冰凤', '15', '1', '', '1001038', '3', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011016', '冰凤', '16', '1', '', '1001038', '3', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011017', '冰凤', '17', '1', '', '1001038', '3', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011018', '冰凤', '18', '1', '', '1001038', '3', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011019', '冰凤', '19', '1', '', '1001038', '3', '1', '0', '216', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011020', '冰凤', '20', '1', '', '1001038', '3', '1', '0', '216', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011021', '冰凤', '21', '1', '', '1001038', '3', '1', '0', '324', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011022', '冰凤', '22', '1', '', '1001038', '3', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011023', '冰凤', '23', '1', '', '1001038', '3', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011024', '冰凤', '24', '1', '', '1001038', '3', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011025', '冰凤', '25', '1', '', '1001038', '3', '1', '0', '437', '64', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011026', '冰凤', '26', '1', '', '1001038', '3', '1', '0', '454', '44', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011027', '冰凤', '27', '1', '', '1001038', '3', '1', '0', '470', '46', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011028', '冰凤', '28', '1', '', '1001038', '3', '1', '0', '486', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011029', '冰凤', '29', '1', '', '1001038', '3', '1', '0', '502', '49', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011030', '冰凤', '30', '1', '', '1001038', '3', '1', '0', '518', '51', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011031', '冰凤', '31', '1', '', '1001038', '3', '1', '0', '535', '52', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011032', '冰凤', '32', '1', '', '1001038', '3', '1', '0', '551', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011033', '冰凤', '33', '1', '', '1001038', '3', '1', '0', '567', '55', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011034', '冰凤', '34', '1', '', '1001038', '3', '1', '0', '583', '57', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011035', '冰凤', '35', '1', '', '1001038', '3', '1', '0', '599', '58', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011036', '冰凤', '36', '1', '', '1001038', '3', '1', '0', '616', '60', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011037', '冰凤', '37', '1', '', '1001038', '3', '1', '0', '632', '62', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011038', '冰凤', '38', '1', '', '1001038', '3', '1', '0', '648', '63', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011039', '冰凤', '39', '1', '', '1001038', '3', '1', '0', '664', '65', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011040', '冰凤', '40', '1', '', '1001038', '3', '1', '0', '680', '66', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011041', '冰凤', '41', '1', '', '1001038', '3', '1', '0', '929', '91', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011042', '冰凤', '42', '1', '', '1001038', '3', '1', '0', '950', '93', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2011043', '冰凤', '43', '1', '', '1001038', '3', '1', '0', '972', '95', '1', '0', '0', '12500', '0', '0', '0', '0', '8035004');
INSERT INTO `t_monster` VALUES ('2012001', '仙鸟卫士', '1', '1', '', '1001034', '5', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012002', '仙鸟卫士', '2', '1', '', '1001034', '5', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012003', '仙鸟卫士', '3', '1', '', '1001034', '5', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012004', '仙鸟卫士', '4', '1', '', '1001034', '5', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012005', '仙鸟卫士', '5', '1', '', '1001034', '5', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012006', '仙鸟卫士', '6', '1', '', '1001034', '5', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012007', '仙鸟卫士', '7', '1', '', '1001034', '5', '1', '0', '76', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012008', '仙鸟卫士', '8', '1', '', '1001034', '5', '1', '0', '76', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012009', '仙鸟卫士', '9', '1', '', '1001034', '5', '1', '0', '76', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012010', '仙鸟卫士', '10', '1', '', '1001034', '5', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012011', '仙鸟卫士', '11', '1', '', '1001034', '5', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012012', '仙鸟卫士', '12', '1', '', '1001034', '5', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012013', '仙鸟卫士', '13', '1', '', '1001034', '5', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012014', '仙鸟卫士', '14', '1', '', '1001034', '5', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012015', '仙鸟卫士', '15', '1', '', '1001034', '5', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012016', '仙鸟卫士', '16', '1', '', '1001034', '5', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012017', '仙鸟卫士', '17', '1', '', '1001034', '5', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012018', '仙鸟卫士', '18', '1', '', '1001034', '5', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012019', '仙鸟卫士', '19', '1', '', '1001034', '5', '1', '0', '216', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012020', '仙鸟卫士', '20', '1', '', '1001034', '5', '1', '0', '216', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012021', '仙鸟卫士', '21', '1', '', '1001034', '5', '1', '0', '324', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012022', '仙鸟卫士', '22', '1', '', '1001034', '5', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012023', '仙鸟卫士', '23', '1', '', '1001034', '5', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012024', '仙鸟卫士', '24', '1', '', '1001034', '5', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012025', '仙鸟卫士', '25', '1', '', '1001034', '5', '1', '0', '437', '64', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012026', '仙鸟卫士', '26', '1', '', '1001034', '5', '1', '0', '454', '44', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012027', '仙鸟卫士', '27', '1', '', '1001034', '5', '1', '0', '470', '46', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012028', '仙鸟卫士', '28', '1', '', '1001034', '5', '1', '0', '486', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012029', '仙鸟卫士', '29', '1', '', '1001034', '5', '1', '0', '502', '49', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012030', '仙鸟卫士', '30', '1', '', '1001034', '5', '1', '0', '518', '51', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012031', '仙鸟卫士', '31', '1', '', '1001034', '5', '1', '0', '535', '52', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012032', '仙鸟卫士', '32', '1', '', '1001034', '5', '1', '0', '551', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012033', '仙鸟卫士', '33', '1', '', '1001034', '5', '1', '0', '567', '55', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012034', '仙鸟卫士', '34', '1', '', '1001034', '5', '1', '0', '583', '57', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012035', '仙鸟卫士', '35', '1', '', '1001034', '5', '1', '0', '599', '58', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012036', '仙鸟卫士', '36', '1', '', '1001034', '5', '1', '0', '616', '60', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012037', '仙鸟卫士', '37', '1', '', '1001034', '5', '1', '0', '632', '62', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012038', '仙鸟卫士', '38', '1', '', '1001034', '5', '1', '0', '648', '63', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012039', '仙鸟卫士', '39', '1', '', '1001034', '5', '1', '0', '664', '65', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012040', '仙鸟卫士', '40', '1', '', '1001034', '5', '1', '0', '680', '66', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012041', '仙鸟卫士', '41', '1', '', '1001034', '5', '1', '0', '929', '91', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012042', '仙鸟卫士', '42', '1', '', '1001034', '5', '1', '0', '950', '93', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2012043', '仙鸟卫士', '43', '1', '', '1001034', '5', '1', '0', '972', '95', '1', '0', '0', '12500', '0', '0', '0', '0', '8034001');
INSERT INTO `t_monster` VALUES ('2013001', '仙女', '1', '1', '', '1001064', '5', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013002', '仙女', '2', '1', '', '1001064', '5', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013003', '仙女', '3', '1', '', '1001064', '5', '1', '0', '32', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013004', '仙女', '4', '1', '', '1001064', '5', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013005', '仙女', '5', '1', '', '1001064', '5', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013006', '仙女', '6', '1', '', '1001064', '5', '1', '0', '43', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013007', '仙女', '7', '1', '', '1001064', '5', '1', '0', '76', '1', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013008', '仙女', '8', '1', '', '1001064', '5', '1', '0', '76', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013009', '仙女', '9', '1', '', '1001064', '5', '1', '0', '76', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013010', '仙女', '10', '1', '', '1001064', '5', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013011', '仙女', '11', '1', '', '1001064', '5', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013012', '仙女', '12', '1', '', '1001064', '5', '1', '0', '108', '16', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013013', '仙女', '13', '1', '', '1001064', '5', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013014', '仙女', '14', '1', '', '1001064', '5', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013015', '仙女', '15', '1', '', '1001064', '5', '1', '0', '151', '22', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013016', '仙女', '16', '1', '', '1001064', '5', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013017', '仙女', '17', '1', '', '1001064', '5', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013018', '仙女', '18', '1', '', '1001064', '5', '1', '0', '184', '27', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013019', '仙女', '19', '1', '', '1001064', '5', '1', '0', '216', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013020', '仙女', '20', '1', '', '1001064', '5', '1', '0', '216', '32', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013021', '仙女', '21', '1', '', '1001064', '5', '1', '0', '324', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013022', '仙女', '22', '1', '', '1001064', '5', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013023', '仙女', '23', '1', '', '1001064', '5', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013024', '仙女', '24', '1', '', '1001064', '5', '1', '0', '373', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013025', '仙女', '25', '1', '', '1001064', '5', '1', '0', '437', '64', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013026', '仙女', '26', '1', '', '1001064', '5', '1', '0', '454', '44', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013027', '仙女', '27', '1', '', '1001064', '5', '1', '0', '470', '46', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013028', '仙女', '28', '1', '', '1001064', '5', '1', '0', '486', '47', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013029', '仙女', '29', '1', '', '1001064', '5', '1', '0', '502', '49', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013030', '仙女', '30', '1', '', '1001064', '5', '1', '0', '518', '51', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013031', '仙女', '31', '1', '', '1001064', '5', '1', '0', '535', '52', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013032', '仙女', '32', '1', '', '1001064', '5', '1', '0', '551', '54', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013033', '仙女', '33', '1', '', '1001064', '5', '1', '0', '567', '55', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013034', '仙女', '34', '1', '', '1001064', '5', '1', '0', '583', '57', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013035', '仙女', '35', '1', '', '1001064', '5', '1', '0', '599', '58', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013036', '仙女', '36', '1', '', '1001064', '5', '1', '0', '616', '60', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013037', '仙女', '37', '1', '', '1001064', '5', '1', '0', '632', '62', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013038', '仙女', '38', '1', '', '1001064', '5', '1', '0', '648', '63', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013039', '仙女', '39', '1', '', '1001064', '5', '1', '0', '664', '65', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013040', '仙女', '40', '1', '', '1001064', '5', '1', '0', '680', '66', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013041', '仙女', '41', '1', '', '1001064', '5', '1', '0', '929', '91', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013042', '仙女', '42', '1', '', '1001064', '5', '1', '0', '950', '93', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2013043', '仙女', '43', '1', '', '1001064', '5', '1', '0', '972', '95', '1', '0', '0', '12500', '0', '0', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2100001', '小乔', '2', '3', '', '1001025', '2', '1', '0', '72', '2', '1', '0', '0', '12500', '0', '100001', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2100002', '大乔', '4', '3', '', '1001018', '2', '1', '0', '97', '2', '1', '0', '0', '12500', '0', '100002', '0', '0', '8033003');
INSERT INTO `t_monster` VALUES ('2100003', '甄姬', '7', '3', '', '1001020', '4', '1', '0', '169', '2', '1', '0', '0', '12500', '0', '100003', '0', '0', '8035002');
INSERT INTO `t_monster` VALUES ('2100004', '华佗', '10', '3', '', '1001023', '5', '1', '0', '242', '19', '1', '0', '0', '12500', '0', '100004', '0', '0', '8035002');
INSERT INTO `t_monster` VALUES ('2100005', '太史慈', '13', '3', '', '1001014', '5', '1', '0', '270', '47', '1', '0', '0', '12500', '0', '100005', '0', '0', '8031003');
INSERT INTO `t_monster` VALUES ('2100006', '赵云', '16', '3', '', '1001011', '3', '1', '0', '328', '57', '1', '0', '0', '12500', '0', '100006', '0', '0', '8031003');
INSERT INTO `t_monster` VALUES ('2100007', '张角', '19', '3', '', '1001008', '5', '1', '0', '483', '38', '1', '0', '0', '12500', '0', '100007', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2100008', '吕布', '22', '3', '', '1001005', '1', '1', '0', '667', '116', '1', '0', '0', '12500', '0', '100008', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2100009', '董卓', '25', '3', '', '1001027', '1', '1', '0', '1174', '76', '1', '0', '0', '12500', '0', '100009', '0', '0', '8031003');
INSERT INTO `t_monster` VALUES ('2100010', '白骨精', '26', '3', '', '1001029', '4', '1', '0', '1014', '53', '1', '0', '0', '12500', '0', '100010', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2100011', '猪八戒', '27', '3', '', '1001071', '2', '1', '0', '1261', '54', '1', '0', '0', '12500', '0', '100011', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2100012', '孙悟空', '28', '3', '', '1001068', '1', '1', '0', '869', '101', '1', '0', '0', '12500', '0', '100012', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2100013', '孟婆', '29', '3', '', '1001074', '4', '1', '0', '898', '105', '1', '0', '0', '12500', '0', '100013', '0', '0', '8035003');
INSERT INTO `t_monster` VALUES ('2100014', '混沌', '30', '3', '', '1001031', '4', '1', '0', '1391', '60', '1', '0', '0', '12500', '0', '100014', '0', '0', '8033003');
INSERT INTO `t_monster` VALUES ('2100015', '刑天', '31', '3', '', '1001061', '5', '1', '0', '956', '111', '1', '0', '0', '12500', '0', '100015', '0', '0', '8035003');
INSERT INTO `t_monster` VALUES ('2100016', '朋蛇', '32', '3', '', '1001040', '2', '1', '0', '1232', '64', '1', '0', '0', '12500', '0', '100016', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2100017', '玄武', '33', '3', '', '1001089', '3', '1', '0', '1268', '66', '1', '0', '0', '12500', '0', '100017', '0', '0', '8031003');
INSERT INTO `t_monster` VALUES ('2100018', '共工', '34', '3', '', '1001057', '3', '1', '0', '1565', '68', '1', '0', '0', '12500', '0', '100018', '0', '0', '8035003');
INSERT INTO `t_monster` VALUES ('2100019', '九尾狐', '35', '3', '', '1001043', '4', '1', '0', '1072', '125', '1', '0', '0', '12500', '0', '100019', '0', '0', '8031003');
INSERT INTO `t_monster` VALUES ('2100020', '朱雀', '36', '3', '', '1001080', '1', '1', '0', '1377', '71', '1', '0', '0', '12500', '0', '100020', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2100021', '祝融', '37', '3', '', '1001059', '1', '1', '0', '1695', '73', '1', '0', '0', '12500', '0', '100021', '0', '0', '8035003');
INSERT INTO `t_monster` VALUES ('2100022', '烛龙', '38', '3', '', '1001049', '5', '1', '0', '1159', '135', '1', '0', '0', '12500', '0', '100022', '0', '0', '8031003');
INSERT INTO `t_monster` VALUES ('2100023', '白虎', '39', '3', '', '1001083', '5', '1', '0', '1188', '138', '1', '0', '0', '12500', '0', '100023', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('2100024', '饕餮', '40', '3', '', '1001092', '4', '1', '0', '1217', '142', '1', '0', '0', '12500', '0', '100024', '0', '0', '8033003');
INSERT INTO `t_monster` VALUES ('2100025', '麒麟', '41', '3', '', '1001094', '1', '1', '0', '2492', '108', '1', '0', '0', '12500', '0', '100025', '0', '0', '8035003');
INSERT INTO `t_monster` VALUES ('2100026', '青龙', '42', '3', '', '1001086', '2', '1', '0', '2125', '110', '1', '0', '0', '12500', '0', '100026', '0', '0', '8035003');
INSERT INTO `t_monster` VALUES ('2100027', '蚩尤', '43', '3', '', '1001054', '4', '1', '0', '2174', '113', '1', '0', '0', '12500', '0', '100027', '0', '0', '8035003');
INSERT INTO `t_monster` VALUES ('3000001', '极·小乔', '7', '5', '', '1001025', '2', '1', '0', '198', '16', '1', '0', '0', '12500', '0', '100001', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('3000002', '极·大乔', '7', '5', '', '1001018', '2', '1', '0', '198', '16', '1', '0', '0', '12500', '0', '100002', '0', '0', '8033003');
INSERT INTO `t_monster` VALUES ('3000003', '极·甄姬', '7', '5', '', '1001020', '4', '1', '0', '198', '16', '1', '0', '0', '12500', '0', '100003', '0', '0', '8035002');
INSERT INTO `t_monster` VALUES ('3000004', '极·华佗', '16', '5', '', '1001023', '5', '1', '0', '482', '38', '1', '0', '0', '12500', '0', '100004', '0', '0', '8035002');
INSERT INTO `t_monster` VALUES ('3000005', '极·太史慈', '16', '5', '', '1001014', '5', '1', '0', '386', '68', '1', '0', '0', '12500', '0', '100005', '0', '0', '8031003');
INSERT INTO `t_monster` VALUES ('3000006', '极·赵云', '16', '5', '', '1001011', '3', '1', '0', '386', '68', '1', '0', '0', '12500', '0', '100006', '0', '0', '8031003');
INSERT INTO `t_monster` VALUES ('3000007', '极·张角', '25', '5', '', '1001008', '5', '1', '0', '1148', '90', '1', '0', '0', '12500', '0', '100007', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('3000008', '极·吕布', '25', '5', '', '1001005', '1', '1', '0', '919', '162', '1', '0', '0', '12500', '0', '100008', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('3000009', '极·董卓', '25', '5', '', '1001027', '1', '1', '0', '1378', '90', '1', '0', '0', '12500', '0', '100009', '0', '0', '8031003');
INSERT INTO `t_monster` VALUES ('3000010', '极·白骨精', '28', '5', '', '1001029', '4', '1', '0', '1276', '67', '1', '0', '0', '12500', '0', '100010', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('3000011', '极·猪八戒', '28', '5', '', '1001071', '2', '1', '0', '1531', '67', '1', '0', '0', '12500', '0', '100011', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('3000012', '极·孙悟空', '28', '5', '', '1001068', '1', '1', '0', '1021', '120', '1', '0', '0', '12500', '0', '100012', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('3000013', '极·孟婆', '31', '5', '', '1001074', '4', '1', '0', '1123', '132', '1', '0', '0', '12500', '0', '100013', '0', '0', '8035003');
INSERT INTO `t_monster` VALUES ('3000014', '极·混沌', '31', '5', '', '1001031', '4', '1', '0', '1684', '73', '1', '0', '0', '12500', '0', '100014', '0', '0', '8033003');
INSERT INTO `t_monster` VALUES ('3000015', '极·刑天', '31', '5', '', '1001061', '5', '1', '0', '1123', '132', '1', '0', '0', '12500', '0', '100015', '0', '0', '8035003');
INSERT INTO `t_monster` VALUES ('3000016', '极·朋蛇', '34', '5', '', '1001040', '2', '1', '0', '1531', '80', '1', '0', '0', '12500', '0', '100016', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('3000017', '极·玄武', '34', '5', '', '1001089', '3', '1', '0', '1531', '80', '1', '0', '0', '12500', '0', '100017', '0', '0', '8031003');
INSERT INTO `t_monster` VALUES ('3000018', '极·共工', '34', '5', '', '1001057', '3', '1', '0', '1837', '80', '1', '0', '0', '12500', '0', '100018', '0', '0', '8035003');
INSERT INTO `t_monster` VALUES ('3000019', '极·九尾狐', '37', '5', '', '1001043', '4', '1', '0', '1327', '156', '1', '0', '0', '12500', '0', '100019', '0', '0', '8031003');
INSERT INTO `t_monster` VALUES ('3000020', '极·朱雀', '37', '5', '', '1001080', '1', '1', '0', '1658', '87', '1', '0', '0', '12500', '0', '100020', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('3000021', '极·祝融', '37', '5', '', '1001059', '1', '1', '0', '1990', '87', '1', '0', '0', '12500', '0', '100021', '0', '0', '8035003');
INSERT INTO `t_monster` VALUES ('3000022', '极·烛龙', '40', '5', '', '1001049', '5', '1', '0', '1429', '168', '1', '0', '0', '12500', '0', '100022', '0', '0', '8031003');
INSERT INTO `t_monster` VALUES ('3000023', '极·白虎', '40', '5', '', '1001083', '5', '1', '0', '1429', '168', '1', '0', '0', '12500', '0', '100023', '0', '0', '8032003');
INSERT INTO `t_monster` VALUES ('3000024', '极·饕餮', '40', '5', '', '1001092', '4', '1', '0', '1429', '168', '1', '0', '0', '12500', '0', '100024', '0', '0', '8033003');
INSERT INTO `t_monster` VALUES ('3000025', '极·麒麟', '43', '5', '', '1001094', '1', '1', '0', '3062', '133', '1', '0', '0', '12500', '0', '100025', '0', '0', '8035003');
INSERT INTO `t_monster` VALUES ('3000026', '极·青龙', '43', '5', '', '1001086', '2', '1', '0', '2552', '133', '1', '0', '0', '12500', '0', '100026', '0', '0', '8035003');
INSERT INTO `t_monster` VALUES ('3000027', '极·蚩尤', '43', '5', '', '1001054', '4', '1', '0', '2552', '133', '1', '0', '0', '12500', '0', '100027', '0', '0', '8035003');
INSERT INTO `t_monster` VALUES ('9000001', '新1士兵', '1', '1', '', '1001001', '5', '1', '0', '10', '5', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('9000002', '教官', '1', '1', '', '1001016', '5', '1', '0', '10', '5', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('9000003', '烛龙幻像', '1', '1', '', '1001049', '5', '1', '0', '75', '11', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('9000004', '新2士兵', '1', '1', '', '1001001', '5', '1', '0', '10', '5', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('9000005', '新2士官', '1', '1', '', '1001016', '5', '1', '0', '10', '5', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100001', '士兵前锋', '7', '1', '', '1001001', '1', '1', '0', '81', '24', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100002', '突击士官', '7', '1', '', '1001016', '2', '1', '0', '121', '14', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100003', '精英禁卫', '16', '1', '', '1001003', '4', '1', '0', '245', '33', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100004', '枪兵首领', '16', '1', '', '1001076', '5', '1', '0', '245', '33', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100005', '精锐兵长', '25', '1', '', '1001078', '5', '1', '0', '700', '78', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100006', '士兵英豪', '25', '1', '', '1001001', '1', '1', '0', '467', '141', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100007', '剧毒蝎精', '28', '1', '', '1001052', '1', '1', '0', '648', '58', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100008', '月宫冰蟾', '28', '1', '', '1001047', '3', '1', '0', '778', '58', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100009', '寿桃仙童', '31', '1', '', '1001066', '5', '1', '0', '713', '64', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100010', '幽冥鬼将', '31', '1', '', '1001045', '1', '1', '0', '570', '115', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100011', '妙音仙女', '34', '1', '', '1001064', '5', '1', '0', '778', '70', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100012', '炙焰火凤', '34', '1', '', '1001036', '1', '1', '0', '622', '125', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100013', '凛然冰凤', '37', '1', '', '1001038', '3', '1', '0', '842', '75', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100014', '仙鸟卫士', '37', '1', '', '1001034', '5', '1', '0', '842', '75', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100015', '金蟾仙童', '40', '1', '', '1001066', '5', '1', '0', '907', '81', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100016', '玄冥鬼将', '40', '1', '', '1001045', '1', '1', '0', '726', '146', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100017', '碧霞仙女', '43', '1', '', '1001064', '5', '1', '0', '1296', '116', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');
INSERT INTO `t_monster` VALUES ('3100018', '极寒冰凤', '43', '1', '', '1001038', '3', '1', '0', '1296', '116', '1', '0', '0', '12500', '0', '0', '0', '0', '8031002');

-- ----------------------------
-- Table structure for t_monster_atk_mode
-- ----------------------------
DROP TABLE IF EXISTS `t_monster_atk_mode`;
CREATE TABLE `t_monster_atk_mode` (
  `id` int(11) NOT NULL COMMENT 'Index排序',
  `monster_id` int(11) NOT NULL COMMENT '怪物Id',
  `atk_mode` varchar(50) NOT NULL COMMENT '攻击方式',
  `move_mode` varchar(50) NOT NULL COMMENT '移动方式',
  `skill_id` int(11) NOT NULL COMMENT '技能编号',
  `cd` int(11) NOT NULL COMMENT '持续回合',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `job` varchar(50) NOT NULL COMMENT '职业'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_monster_atk_mode
-- ----------------------------
INSERT INTO `t_monster_atk_mode` VALUES ('1', '2001001', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('2', '2001002', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('3', '2001003', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('4', '2001004', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('5', '2001005', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('6', '2001006', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('7', '2001007', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('8', '2001008', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('9', '2001009', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('10', '2001010', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('11', '2001011', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('12', '2001012', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('13', '2001013', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('14', '2001014', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('15', '2001015', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('16', '2001016', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('17', '2001017', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('18', '2001018', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('19', '2001019', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('20', '2001020', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('21', '2001021', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('22', '2001022', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('23', '2001023', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('24', '2001024', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('25', '2001025', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('26', '2001026', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('27', '2001027', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('28', '2001028', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('29', '2001029', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('30', '2001030', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('31', '2001031', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('32', '2001032', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('33', '2001033', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('34', '2001034', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('35', '2001035', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('36', '2001036', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('37', '2001037', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('38', '2001038', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('39', '2001039', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('40', '2001040', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('41', '2001041', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('42', '2001042', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('43', '2001043', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('44', '2002001', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('45', '2002002', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('46', '2002003', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('47', '2002004', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('48', '2002005', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('49', '2002006', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('50', '2002007', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('51', '2002008', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('52', '2002009', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('53', '2002010', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('54', '2002011', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('55', '2002012', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('56', '2002013', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('57', '2002014', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('58', '2002015', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('59', '2002016', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('60', '2002017', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('61', '2002018', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('62', '2002019', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('63', '2002020', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('64', '2002021', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('65', '2002022', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('66', '2002023', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('67', '2002024', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('68', '2002025', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('69', '2002026', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('70', '2002027', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('71', '2002028', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('72', '2002029', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('73', '2002030', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('74', '2002031', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('75', '2002032', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('76', '2002033', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('77', '2002034', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('78', '2002035', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('79', '2002036', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('80', '2002037', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('81', '2002038', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('82', '2002039', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('83', '2002040', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('84', '2002041', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('85', '2002042', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('86', '2002043', '10010011', '20222022', '0', '0', '士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('87', '2003001', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('88', '2003002', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('89', '2003003', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('90', '2003004', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('91', '2003005', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('92', '2003006', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('93', '2003007', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('94', '2003008', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('95', '2003009', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('96', '2003010', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('97', '2003011', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('98', '2003012', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('99', '2003013', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('100', '2003014', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('101', '2003015', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('102', '2003016', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('103', '2003017', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('104', '2003018', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('105', '2003019', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('106', '2003020', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('107', '2003021', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('108', '2003022', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('109', '2003023', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('110', '2003024', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('111', '2003025', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('112', '2003026', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('113', '2003027', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('114', '2003028', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('115', '2003029', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('116', '2003030', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('117', '2003031', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('118', '2003032', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('119', '2003033', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('120', '2003034', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('121', '2003035', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('122', '2003036', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('123', '2003037', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('124', '2003038', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('125', '2003039', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('126', '2003040', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('127', '2003041', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('128', '2003042', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('129', '2003043', '10101010', '30333033', '0', '0', '禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('130', '2004001', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('131', '2004002', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('132', '2004003', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('133', '2004004', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('134', '2004005', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('135', '2004006', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('136', '2004007', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('137', '2004008', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('138', '2004009', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('139', '2004010', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('140', '2004011', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('141', '2004012', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('142', '2004013', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('143', '2004014', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('144', '2004015', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('145', '2004016', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('146', '2004017', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('147', '2004018', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('148', '2004019', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('149', '2004020', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('150', '2004021', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('151', '2004022', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('152', '2004023', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('153', '2004024', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('154', '2004025', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('155', '2004026', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('156', '2004027', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('157', '2004028', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('158', '2004029', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('159', '2004030', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('160', '2004031', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('161', '2004032', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('162', '2004033', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('163', '2004034', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('164', '2004035', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('165', '2004036', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('166', '2004037', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('167', '2004038', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('168', '2004039', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('169', '2004040', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('170', '2004041', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('171', '2004042', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('172', '2004043', '10101010', '30333033', '0', '0', '枪兵', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('173', '2005001', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('174', '2005002', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('175', '2005003', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('176', '2005004', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('177', '2005005', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('178', '2005006', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('179', '2005007', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('180', '2005008', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('181', '2005009', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('182', '2005010', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('183', '2005011', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('184', '2005012', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('185', '2005013', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('186', '2005014', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('187', '2005015', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('188', '2005016', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('189', '2005017', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('190', '2005018', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('191', '2005019', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('192', '2005020', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('193', '2005021', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('194', '2005022', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('195', '2005023', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('196', '2005024', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('197', '2005025', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('198', '2005026', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('199', '2005027', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('200', '2005028', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('201', '2005029', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('202', '2005030', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('203', '2005031', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('204', '2005032', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('205', '2005033', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('206', '2005034', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('207', '2005035', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('208', '2005036', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('209', '2005037', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('210', '2005038', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('211', '2005039', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('212', '2005040', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('213', '2005041', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('214', '2005042', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('215', '2005043', '10010011', '20222022', '0', '0', '兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('216', '2006001', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('217', '2006002', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('218', '2006003', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('219', '2006004', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('220', '2006005', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('221', '2006006', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('222', '2006007', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('223', '2006008', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('224', '2006009', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('225', '2006010', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('226', '2006011', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('227', '2006012', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('228', '2006013', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('229', '2006014', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('230', '2006015', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('231', '2006016', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('232', '2006017', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('233', '2006018', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('234', '2006019', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('235', '2006020', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('236', '2006021', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('237', '2006022', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('238', '2006023', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('239', '2006024', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('240', '2006025', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('241', '2006026', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('242', '2006027', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('243', '2006028', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('244', '2006029', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('245', '2006030', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('246', '2006031', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('247', '2006032', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('248', '2006033', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('249', '2006034', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('250', '2006035', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('251', '2006036', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('252', '2006037', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('253', '2006038', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('254', '2006039', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('255', '2006040', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('256', '2006041', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('257', '2006042', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('258', '2006043', '10101010', '30333033', '0', '0', '蝎子精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('259', '2007001', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('260', '2007002', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('261', '2007003', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('262', '2007004', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('263', '2007005', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('264', '2007006', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('265', '2007007', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('266', '2007008', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('267', '2007009', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('268', '2007010', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('269', '2007011', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('270', '2007012', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('271', '2007013', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('272', '2007014', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('273', '2007015', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('274', '2007016', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('275', '2007017', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('276', '2007018', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('277', '2007019', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('278', '2007020', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('279', '2007021', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('280', '2007022', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('281', '2007023', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('282', '2007024', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('283', '2007025', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('284', '2007026', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('285', '2007027', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('286', '2007028', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('287', '2007029', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('288', '2007030', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('289', '2007031', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('290', '2007032', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('291', '2007033', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('292', '2007034', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('293', '2007035', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('294', '2007036', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('295', '2007037', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('296', '2007038', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('297', '2007039', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('298', '2007040', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('299', '2007041', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('300', '2007042', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('301', '2007043', '10101010', '30333033', '0', '0', '仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('302', '2008001', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('303', '2008002', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('304', '2008003', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('305', '2008004', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('306', '2008005', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('307', '2008006', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('308', '2008007', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('309', '2008008', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('310', '2008009', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('311', '2008010', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('312', '2008011', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('313', '2008012', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('314', '2008013', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('315', '2008014', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('316', '2008015', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('317', '2008016', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('318', '2008017', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('319', '2008018', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('320', '2008019', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('321', '2008020', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('322', '2008021', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('323', '2008022', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('324', '2008023', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('325', '2008024', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('326', '2008025', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('327', '2008026', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('328', '2008027', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('329', '2008028', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('330', '2008029', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('331', '2008030', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('332', '2008031', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('333', '2008032', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('334', '2008033', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('335', '2008034', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('336', '2008035', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('337', '2008036', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('338', '2008037', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('339', '2008038', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('340', '2008039', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('341', '2008040', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('342', '2008041', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('343', '2008042', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('344', '2008043', '00111001', '10111011', '0', '0', '鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('345', '2009001', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('346', '2009002', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('347', '2009003', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('348', '2009004', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('349', '2009005', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('350', '2009006', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('351', '2009007', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('352', '2009008', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('353', '2009009', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('354', '2009010', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('355', '2009011', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('356', '2009012', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('357', '2009013', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('358', '2009014', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('359', '2009015', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('360', '2009016', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('361', '2009017', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('362', '2009018', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('363', '2009019', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('364', '2009020', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('365', '2009021', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('366', '2009022', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('367', '2009023', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('368', '2009024', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('369', '2009025', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('370', '2009026', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('371', '2009027', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('372', '2009028', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('373', '2009029', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('374', '2009030', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('375', '2009031', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('376', '2009032', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('377', '2009033', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('378', '2009034', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('379', '2009035', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('380', '2009036', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('381', '2009037', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('382', '2009038', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('383', '2009039', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('384', '2009040', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('385', '2009041', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('386', '2009042', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('387', '2009043', '10010011', '20222022', '0', '0', '寒冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('388', '2010001', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('389', '2010002', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('390', '2010003', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('391', '2010004', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('392', '2010005', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('393', '2010006', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('394', '2010007', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('395', '2010008', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('396', '2010009', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('397', '2010010', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('398', '2010011', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('399', '2010012', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('400', '2010013', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('401', '2010014', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('402', '2010015', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('403', '2010016', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('404', '2010017', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('405', '2010018', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('406', '2010019', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('407', '2010020', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('408', '2010021', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('409', '2010022', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('410', '2010023', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('411', '2010024', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('412', '2010025', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('413', '2010026', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('414', '2010027', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('415', '2010028', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('416', '2010029', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('417', '2010030', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('418', '2010031', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('419', '2010032', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('420', '2010033', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('421', '2010034', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('422', '2010035', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('423', '2010036', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('424', '2010037', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('425', '2010038', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('426', '2010039', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('427', '2010040', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('428', '2010041', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('429', '2010042', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('430', '2010043', '00111001', '10111011', '0', '0', '火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('431', '2011001', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('432', '2011002', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('433', '2011003', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('434', '2011004', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('435', '2011005', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('436', '2011006', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('437', '2011007', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('438', '2011008', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('439', '2011009', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('440', '2011010', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('441', '2011011', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('442', '2011012', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('443', '2011013', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('444', '2011014', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('445', '2011015', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('446', '2011016', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('447', '2011017', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('448', '2011018', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('449', '2011019', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('450', '2011020', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('451', '2011021', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('452', '2011022', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('453', '2011023', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('454', '2011024', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('455', '2011025', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('456', '2011026', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('457', '2011027', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('458', '2011028', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('459', '2011029', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('460', '2011030', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('461', '2011031', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('462', '2011032', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('463', '2011033', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('464', '2011034', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('465', '2011035', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('466', '2011036', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('467', '2011037', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('468', '2011038', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('469', '2011039', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('470', '2011040', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('471', '2011041', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('472', '2011042', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('473', '2011043', '10101010', '30333033', '0', '0', '冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('474', '2012001', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('475', '2012002', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('476', '2012003', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('477', '2012004', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('478', '2012005', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('479', '2012006', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('480', '2012007', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('481', '2012008', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('482', '2012009', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('483', '2012010', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('484', '2012011', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('485', '2012012', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('486', '2012013', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('487', '2012014', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('488', '2012015', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('489', '2012016', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('490', '2012017', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('491', '2012018', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('492', '2012019', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('493', '2012020', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('494', '2012021', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('495', '2012022', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('496', '2012023', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('497', '2012024', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('498', '2012025', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('499', '2012026', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('500', '2012027', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('501', '2012028', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('502', '2012029', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('503', '2012030', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('504', '2012031', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('505', '2012032', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('506', '2012033', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('507', '2012034', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('508', '2012035', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('509', '2012036', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('510', '2012037', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('511', '2012038', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('512', '2012039', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('513', '2012040', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('514', '2012041', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('515', '2012042', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('516', '2012043', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('517', '2013001', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('518', '2013002', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('519', '2013003', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('520', '2013004', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('521', '2013005', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('522', '2013006', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('523', '2013007', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('524', '2013008', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('525', '2013009', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('526', '2013010', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('527', '2013011', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('528', '2013012', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('529', '2013013', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('530', '2013014', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('531', '2013015', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('532', '2013016', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('533', '2013017', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('534', '2013018', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('535', '2013019', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('536', '2013020', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('537', '2013021', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('538', '2013022', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('539', '2013023', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('540', '2013024', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('541', '2013025', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('542', '2013026', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('543', '2013027', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('544', '2013028', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('545', '2013029', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('546', '2013030', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('547', '2013031', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('548', '2013032', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('549', '2013033', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('550', '2013034', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('551', '2013035', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('552', '2013036', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('553', '2013037', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('554', '2013038', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('555', '2013039', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('556', '2013040', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('557', '2013041', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('558', '2013042', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('559', '2013043', '10101010', '30333033', '0', '0', '仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('560', '2100001', '10101010', '30333033', '100001', '0', '小乔', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('561', '2100002', '10101010', '30333033', '100002', '0', '大乔', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('562', '2100003', '10101010', '30333033', '100003', '0', '甄姬', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('563', '2100004', '10101010', '30333033', '100004', '0', '华佗', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('564', '2100005', '00111001', '10111011', '100005', '0', '太史慈', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('565', '2100006', '00111001', '10111011', '100006', '0', '赵云', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('566', '2100007', '10101010', '30333033', '100007', '0', '张角', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('567', '2100008', '00111001', '10111011', '100008', '0', '吕布', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('568', '2100009', '10010011', '20222022', '100009', '0', '董卓', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('569', '2100010', '10101010', '30333033', '100010', '0', '白骨精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('570', '2100011', '10010011', '20222022', '100011', '0', '猪八戒', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('571', '2100012', '00111001', '10111011', '100012', '0', '孙悟空', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('572', '2100013', '00111001', '10111011', '100013', '0', '孟婆', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('573', '2100014', '10010011', '20222022', '100014', '0', '混沌', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('574', '2100015', '00111001', '10111011', '100015', '0', '刑天', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('575', '2100016', '10101010', '30333033', '100016', '0', '朋蛇', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('576', '2100017', '10101010', '30333033', '100017', '0', '玄武', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('577', '2100018', '10010011', '20222022', '100018', '0', '共工', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('578', '2100019', '00111001', '10111011', '100019', '0', '九尾狐', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('579', '2100020', '10101010', '30333033', '100020', '0', '朱雀', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('580', '2100021', '10010011', '20222022', '100021', '0', '祝融', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('581', '2100022', '00111001', '10111011', '100022', '0', '烛龙', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('582', '2100023', '00111001', '10111011', '100023', '0', '白虎', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('583', '2100024', '00111001', '10111011', '100024', '0', '饕餮', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('584', '2100025', '10010011', '20222022', '100025', '0', '麒麟', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('585', '2100026', '10101010', '30333033', '100026', '0', '青龙', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('586', '2100027', '10101010', '30333033', '100027', '0', '蚩尤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('587', '3000001', '10101010', '30333033', '100001', '0', '极·小乔', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('588', '3000002', '10101010', '30333033', '100002', '0', '极·大乔', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('589', '3000003', '10101010', '30333033', '100003', '0', '极·甄姬', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('590', '3000004', '10101010', '30333033', '100004', '0', '极·华佗', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('591', '3000005', '00111001', '10111011', '100005', '0', '极·太史慈', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('592', '3000006', '00111001', '10111011', '100006', '0', '极·赵云', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('593', '3000007', '10101010', '30333033', '100007', '0', '极·张角', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('594', '3000008', '00111001', '10111011', '100008', '0', '极·吕布', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('595', '3000009', '10010011', '20222022', '100009', '0', '极·董卓', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('596', '3000010', '10101010', '30333033', '100010', '0', '极·白骨精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('597', '3000011', '10010011', '20222022', '100011', '0', '极·猪八戒', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('598', '3000012', '00111001', '10111011', '100012', '0', '极·孙悟空', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('599', '3000013', '00111001', '10111011', '100013', '0', '极·孟婆', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('600', '3000014', '10010011', '20222022', '100014', '0', '极·混沌', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('601', '3000015', '00111001', '10111011', '100015', '0', '极·刑天', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('602', '3000016', '10101010', '30333033', '100016', '0', '极·朋蛇', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('603', '3000017', '10101010', '30333033', '100017', '0', '极·玄武', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('604', '3000018', '10010011', '20222022', '100018', '0', '极·共工', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('605', '3000019', '00111001', '10111011', '100019', '0', '极·九尾狐', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('606', '3000020', '10101010', '30333033', '100020', '0', '极·朱雀', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('607', '3000021', '10010011', '20222022', '100021', '0', '极·祝融', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('608', '3000022', '00111001', '10111011', '100022', '0', '极·烛龙', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('609', '3000023', '00111001', '10111011', '100023', '0', '极·白虎', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('610', '3000024', '00111001', '10111011', '100024', '0', '极·饕餮', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('611', '3000025', '10010011', '20222022', '100025', '0', '极·麒麟', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('612', '3000026', '10101010', '30333033', '100026', '0', '极·青龙', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('613', '3000027', '10101010', '30333033', '100027', '0', '极·蚩尤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('614', '9000001', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('615', '9000002', '00111001', '10111011', '0', '0', '士官', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('616', '9000003', '00111000', '00003000', '0', '0', '烛龙', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('617', '9000004', '00111001', '10111011', '0', '0', '士兵', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('618', '9000005', '00111001', '10111011', '0', '0', '士官', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('619', '3100001', '00111001', '10111011', '0', '0', '士兵前锋', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('620', '3100002', '10010011', '20222022', '0', '0', '突击士官', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('621', '3100003', '10101010', '30333033', '0', '0', '精英禁卫', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('622', '3100004', '10101010', '30333033', '0', '0', '枪兵首领', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('623', '3100005', '10010011', '20222022', '0', '0', '精锐兵长', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('624', '3100006', '00111001', '10111011', '0', '0', '士兵英豪', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('625', '3100007', '10101010', '30333033', '0', '0', '剧毒蝎精', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('626', '3100008', '10010011', '20222022', '0', '0', '月宫冰蟾', '防御');
INSERT INTO `t_monster_atk_mode` VALUES ('627', '3100009', '10101010', '30333033', '0', '0', '寿桃仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('628', '3100010', '00111001', '10111011', '0', '0', '幽冥鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('629', '3100011', '10101010', '30333033', '0', '0', '妙音仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('630', '3100012', '00111001', '10111011', '0', '0', '炙焰火凤', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('631', '3100013', '10101010', '30333033', '0', '0', '凛然冰凤', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('632', '3100014', '10101010', '30333033', '0', '0', '仙鸟卫士', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('633', '3100015', '10101010', '30333033', '0', '0', '金蟾仙童', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('634', '3100016', '00111001', '10111011', '0', '0', '玄冥鬼将', '攻击');
INSERT INTO `t_monster_atk_mode` VALUES ('635', '3100017', '10101010', '30333033', '0', '0', '碧霞仙女', '领袖');
INSERT INTO `t_monster_atk_mode` VALUES ('636', '3100018', '10101010', '30333033', '0', '0', '极寒冰凤', '领袖');

-- ----------------------------
-- Table structure for t_passive_skill
-- ----------------------------
DROP TABLE IF EXISTS `t_passive_skill`;
CREATE TABLE `t_passive_skill` (
  `passive_skill_id` int(11) NOT NULL COMMENT '技能编号',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `des` varchar(128) NOT NULL COMMENT '描述',
  `leader` int(11) NOT NULL COMMENT '队长技能',
  `icon` varchar(20) NOT NULL COMMENT '图标',
  `level` int(11) NOT NULL COMMENT '等级',
  `cd` int(11) NOT NULL COMMENT '冷却cd',
  `res_state` int(11) NOT NULL COMMENT '触发限制',
  `activation` int(11) NOT NULL COMMENT '死亡后是否生效',
  `take_effect` varchar(50) NOT NULL COMMENT '生效条件',
  `arg0` varchar(50) NOT NULL COMMENT '生效参数1',
  `arg1` varchar(50) NOT NULL COMMENT '生效参数2',
  `skill_type` int(11) NOT NULL COMMENT '特效类型',
  `ground` int(11) NOT NULL COMMENT '地板特效',
  `hit_delay` int(11) NOT NULL COMMENT '反馈延迟',
  `img` int(11) NOT NULL COMMENT '特效资源'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_passive_skill
-- ----------------------------
INSERT INTO `t_passive_skill` VALUES ('50001', '不屈·一', '自身血量小于等于40%时，自身减伤', '0', 'huoshuxingmianyi', '1', '3', '1', '0', '1', '4000', '', '2', '0', '500', '0');
INSERT INTO `t_passive_skill` VALUES ('50002', '据守·一', '被合击次数大于等于3时，自身减伤', '0', 'huoshuxingmianyi', '1', '3', '1', '0', '11', '3', '', '2', '0', '500', '0');
INSERT INTO `t_passive_skill` VALUES ('50003', '背水·一', '自身血量小于等于40%时，自身攻击上升', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '1', '4000', '', '2', '0', '500', '0');
INSERT INTO `t_passive_skill` VALUES ('50004', '斩杀·一', '攻击的敌方单体血量小于25%时，自身攻击上升', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '10', '2500', '', '2', '0', '500', '0');
INSERT INTO `t_passive_skill` VALUES ('50005', '休整·一', '连续2个回合没有攻击，则此回合血量回复', '0', 'huoshuxingmianyi', '1', '3', '1', '0', '9', '2', '', '2', '0', '500', '5050031');
INSERT INTO `t_passive_skill` VALUES ('50006', '救援·一', '我方血量少于30%时，给予全体我方护盾效果', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '2', '3000', '', '3', '0', '500', '5030013');
INSERT INTO `t_passive_skill` VALUES ('50007', '甘霖·一', '我方血量少于30%时，回复全体我方5.56%血量', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '2', '3000', '', '3', '0', '500', '5050031');
INSERT INTO `t_passive_skill` VALUES ('50008', '追击·一', '敌方血量少于25%时，立刻追加攻击', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '10', '2500', '', '2', '0', '500', '5030011');
INSERT INTO `t_passive_skill` VALUES ('50009', '连袭·一', '敌方人数少于等于3时，给予敌方全体流血效果', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '12', '3', '', '3', '0', '500', '5030043');
INSERT INTO `t_passive_skill` VALUES ('50010', '新生·一', '自身血量小于等于40%时，回复16.67%血量', '0', 'huoshuxingmianyi', '1', '3', '1', '0', '1', '4000', '', '2', '0', '500', '5050031');
INSERT INTO `t_passive_skill` VALUES ('50011', '魅步·一', '被合击次数大于等于3时，自身闪避提升', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '11', '3', '', '2', '0', '500', '0');
INSERT INTO `t_passive_skill` VALUES ('50012', '斩杀·一', '攻击的敌方单体血量小于25%时，自身攻击上升', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '10', '2500', '', '2', '0', '500', '0');
INSERT INTO `t_passive_skill` VALUES ('50013', '冲刺·一', '移动距离等于2时，自身攻击上升', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '6', '2', '', '2', '0', '500', '0');
INSERT INTO `t_passive_skill` VALUES ('50014', '背水·一', '自身血量小于等于40%时，自身攻击上升', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '1', '4000', '', '2', '0', '500', '0');
INSERT INTO `t_passive_skill` VALUES ('50015', '破军·一', '敌方人数少于等于3时，给予敌方全体虚弱效果', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '12', '3', '', '3', '0', '500', '5020023');
INSERT INTO `t_passive_skill` VALUES ('50016', '绝境·一', '我方人数少于等于3时，给予我方减伤效果', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '13', '3', '', '3', '0', '500', '5030013');
INSERT INTO `t_passive_skill` VALUES ('50017', '强袭·一', '敌方血量少于25%时，给予其易伤效果', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '10', '2500', '', '2', '0', '500', '5020081');
INSERT INTO `t_passive_skill` VALUES ('50018', '甘霖·一', '我方血量少于30%时，回复全体我方5.56%血量', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '2', '3000', '', '3', '0', '500', '5050031');
INSERT INTO `t_passive_skill` VALUES ('50019', '奋勇·二', '被合击次数大于等于4时，自身格挡和格挡值提升', '0', 'huoshuxingmianyi', '1', '3', '1', '0', '11', '4', '', '2', '0', '500', '0');
INSERT INTO `t_passive_skill` VALUES ('50020', '据守·二', '被合击次数大于等于4时，自身减伤', '0', 'huoshuxingmianyi', '1', '3', '1', '0', '11', '4', '', '2', '0', '500', '0');
INSERT INTO `t_passive_skill` VALUES ('50021', '斩杀·二', '攻击的敌方单体血量小于20%时，自身攻击上升', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '10', '2000', '', '2', '0', '500', '0');
INSERT INTO `t_passive_skill` VALUES ('50022', '激励·二', '敌方人数少于等于2时，我方攻击上升', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '12', '2', '', '3', '0', '500', '5020071');
INSERT INTO `t_passive_skill` VALUES ('50023', '背水·二', '自身血量小于等于40%时，自身攻击上升', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '1', '4000', '', '2', '0', '500', '0');
INSERT INTO `t_passive_skill` VALUES ('50024', '逆袭·二', '我方人数少于等于2时，我方攻击上升', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '13', '2', '', '3', '0', '500', '5020071');
INSERT INTO `t_passive_skill` VALUES ('50025', '甘霖·二', '我方血量少于25%时，回复我方全体11.11%血量', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '2', '2500', '', '3', '0', '500', '5050031');
INSERT INTO `t_passive_skill` VALUES ('50026', '蓄力·二', '连续3个回合没有攻击，则此回合攻击上升', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '9', '3', '', '2', '0', '500', '0');
INSERT INTO `t_passive_skill` VALUES ('50027', '斩杀·二', '攻击的敌方单体血量小于20%时，自身攻击上升', '0', 'huoshuxingmianyi', '1', '3', '0', '0', '10', '2000', '', '2', '0', '500', '0');
INSERT INTO `t_passive_skill` VALUES ('50028', '弹射', '弹射效果', '0', 'huoshuxingmianyi', '1', '1', '0', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('50029', '飞行', '飞行效果', '0', 'huoshuxingmianyi', '1', '1', '0', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60001', '防御强化·一', '我方全体所受伤害减少', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60002', '闪避强化·一', '我方全体闪避提升', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60003', '暴伤强化·一', '我方全体暴击伤害上升', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60004', '攻击强化·一', '我方全体攻击上升', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60005', '暴击强化·一', '我方全体暴击上升', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60006', '合击强化·一', '我方合击数大于等于2时，提升伤害', '1', 'huoshuxingmianyi', '1', '0', '1', '1', '5', '2', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60007', '合击强化·一', '我方合击数大于等于2时，提升伤害', '1', 'huoshuxingmianyi', '1', '0', '1', '1', '5', '2', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60008', '攻击强化·木·一', '木属性我方攻击上升', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60009', '防御强化·阴·一', '阴属性我方减伤', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60010', '格挡强化·一', '我方全体格挡和格挡值提升', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60011', '防御强化·一', '我方全体所受伤害减少', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60012', '攻击强化·一', '我方全体攻击上升', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60013', '暴伤强化·一', '我方全体暴击伤害上升', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60014', '攻击强化·一', '我方全体攻击上升', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60015', '合击强化·一', '我方合击数大于等于2时，提升伤害', '1', 'huoshuxingmianyi', '1', '0', '1', '1', '5', '2', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60016', '攻击强化·水·一', '水属性我方攻击上升', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60017', '攻击强化·火·一', '火属性我方攻击上升', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60018', '防御强化·木·一', '木属性我方所受伤害减少', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60019', '防御强化·水·二', '水属性我方所受伤害减少', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60020', '防御强化·火·二', '火属性我方所受伤害减少', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60021', '攻击强化·二', '我方全体攻击上升', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60022', '攻击强化·阴·二', '阴属性我方攻击上升', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60023', '暴击强化·二', '我方全体暴击上升', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60024', '合击强化·二', '我方合击数大于等于3时，提升伤害', '1', 'huoshuxingmianyi', '1', '0', '1', '1', '5', '3', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60025', '回春·阳·二', '阳属性我方每回合血量回复', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '1', '110', '', '3', '0', '0', '5050031');
INSERT INTO `t_passive_skill` VALUES ('60026', '暴伤强化·二', '我方全体暴击伤害上升', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('60027', '攻击强化·二', '我方全体攻击上升', '1', 'huoshuxingmianyi', '1', '1', '1', '1', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70001', '天狗之魂·↖', '蕴含天狗之力的魂魄，能够增加攻击方向。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70002', '天狗之魂·↗', '蕴含天狗之力的魂魄，能够增加攻击方向。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70003', '天狗之魂·→', '蕴含天狗之力的魂魄，能够增加攻击方向。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70004', '天狗之魂·↘', '蕴含天狗之力的魂魄，能够增加攻击方向。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70005', '天狗之魂·↙', '蕴含天狗之力的魂魄，能够增加攻击方向。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70006', '天狗之魂·←', '蕴含天狗之力的魂魄，能够增加攻击方向。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70007', '青鸟之魂', '蕴含青鸟之力的魂魄，能够增加飞行能力。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70008', '句芒之魂', '蕴含句芒之力的魂魄，能够增加弹射能力。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70009', '鲲鹏之魂', '蕴含鲲鹏之力的魂魄，能够增加换位能力。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70010', '白泽之魂', '蕴含鲲鹏之力的魂魄，能够使道具全体化。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70011', '毕方之魂·火', '蕴含毕方之力的魂魄，能够增加火属性的伤害。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70012', '毕方之魂·木', '蕴含毕方之力的魂魄，能够增加木属性的伤害。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70013', '毕方之魂·水', '蕴含毕方之力的魂魄，能够增加水属性的伤害。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70014', '毕方之魂·光', '蕴含毕方之力的魂魄，能够增加光属性的伤害。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70015', '毕方之魂·暗', '蕴含毕方之力的魂魄，能够增加暗属性的伤害。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70016', '旋龟之魂·火', '蕴含旋龟之力的魂魄，能够减少受到的火属性的伤害。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70017', '旋龟之魂·木', '蕴含旋龟之力的魂魄，能够减少受到的木属性的伤害。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70018', '旋龟之魂·水', '蕴含旋龟之力的魂魄，能够减少受到的水属性的伤害。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70019', '旋龟之魂·光', '蕴含旋龟之力的魂魄，能够减少受到的光属性的伤害。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70020', '旋龟之魂·暗', '蕴含旋龟之力的魂魄，能够减少受到的暗属性的伤害。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70021', '夸父之魂·火', '蕴含夸父之力的魂魄，当移动距离等于2时，造成的攻击增加。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '6', '2', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70022', '陆吾之魂·火', '蕴含陆吾之力的魂魄，本回合不进行移动时能够减伤。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '6', '0', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70023', '英招之魂·火', '蕴含英招之力的魂魄，移动力提升。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70024', '相柳之魂·火', '蕴含相柳之力的魂魄，战斗前3回合，受到的伤害降低。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70025', '魍魉之魂·火', '蕴含魍魉之力的魂魄，只攻击一个目标时，攻击提升。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '8', '1', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70026', '女娲之魂·火', '蕴含女娲之力的魂魄，免疫所有状态效果，包括增益和减益。', '1', 'huoshuxingmianyi', '1', '8', '1', '0', '1', '10001', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70027', '穷奇之魂·火', '蕴含穷奇之力的魂魄，连续两回合未造成伤害时，下一回合伤害提升。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '9', '2', '', '3', '0', '0', '0');
INSERT INTO `t_passive_skill` VALUES ('70028', '重明之魂·火', '蕴含重明之力的魂魄，攻击次数增加2次。', '1', 'huoshuxingmianyi', '1', '1', '1', '0', '7', '', '', '3', '0', '0', '0');

-- ----------------------------
-- Table structure for t_pay_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_pay_goods`;
CREATE TABLE `t_pay_goods` (
  `id` int(11) NOT NULL COMMENT '物品id',
  `money` int(11) NOT NULL COMMENT '物品价格(rmb)',
  `type` int(11) NOT NULL COMMENT '物品类型',
  `name` varchar(50) NOT NULL COMMENT '物品名称',
  `icon` varchar(20) NOT NULL COMMENT '物品图片',
  `state` int(11) NOT NULL COMMENT '任务图标',
  `taskIcon` varchar(20) NOT NULL COMMENT '任务图标',
  `items` varchar(128) NOT NULL COMMENT '获得物品',
  `firstItems` varchar(128) NOT NULL COMMENT '首次额外获得',
  `extraItems` varchar(128) NOT NULL COMMENT '额外获得',
  `gainDay` int(11) NOT NULL COMMENT '返还天数',
  `buyCD` int(11) NOT NULL COMMENT '购买CD',
  `dayItems` varchar(255) NOT NULL COMMENT '每天获得'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pay_goods
-- ----------------------------
INSERT INTO `t_pay_goods` VALUES ('1', '6', '1', '60钻石', 'baoshi1', '1', '', '3_0_60_0', '3_0_60_0', '', '0', '0', '');
INSERT INTO `t_pay_goods` VALUES ('2', '12', '1', '120钻石', 'baoshi2', '0', '', '3_0_120_0', '3_0_120_0', '3_0_60_0', '0', '0', '');
INSERT INTO `t_pay_goods` VALUES ('3', '30', '1', '300钻石', 'baoshi3', '0', '', '3_0_300_0', '3_0_300_0', '3_0_120_0', '0', '0', '');
INSERT INTO `t_pay_goods` VALUES ('4', '60', '1', '600钻石', 'baoshi4', '0', '', '3_0_600_0', '3_0_600_0', '3_0_300_0', '0', '0', '');
INSERT INTO `t_pay_goods` VALUES ('5', '90', '1', '900钻石', 'baoshi5', '0', '', '3_0_900_0', '3_0_900_0', '3_0_600_0', '0', '0', '');
INSERT INTO `t_pay_goods` VALUES ('6', '120', '1', '1200钻石', 'baoshi6', '1', '', '3_0_1200_0', '3_0_1200_0', '3_0_900_0', '0', '0', '');
INSERT INTO `t_pay_goods` VALUES ('7', '3000', '2', '600钻石月卡', 'yueka_datubiao', '1', 'yueka_tubiao', '3_0_600_0', '', '', '30', '25', '3_0_120_0');
INSERT INTO `t_pay_goods` VALUES ('8', '700', '2', '120钻石周卡', 'yueka_datubiao', '1', 'yueka_tubiao', '3_0_120_0', '', '', '7', '2', '3_0_80_0');

-- ----------------------------
-- Table structure for t_period_activity_time
-- ----------------------------
DROP TABLE IF EXISTS `t_period_activity_time`;
CREATE TABLE `t_period_activity_time` (
  `n_id` int(11) NOT NULL COMMENT '自增长id',
  `n_type` int(11) NOT NULL COMMENT '活动类型',
  `n_tips` varchar(128) NOT NULL COMMENT '说明',
  `n_openTimes` varchar(128) NOT NULL COMMENT '开启时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_period_activity_time
-- ----------------------------
INSERT INTO `t_period_activity_time` VALUES ('1', '1', '财神殿开启时间', '1=00_00|23_59&3=00_00|23_59&5=00_00|23_59&7=00_00|23_59');
INSERT INTO `t_period_activity_time` VALUES ('2', '2', '灵气殿开启时间', '2=00_00|23_59&4=00_00|23_59&6=00_00|23_59&7=00_00|23_59');
INSERT INTO `t_period_activity_time` VALUES ('3', '3', '包子铺双倍时间', '0=12_00|14_00');
INSERT INTO `t_period_activity_time` VALUES ('4', '4', '财神殿双倍时间', '0=12_00|14_00');
INSERT INTO `t_period_activity_time` VALUES ('5', '5', '灵气殿双倍时间', '0=12_00|14_00');

-- ----------------------------
-- Table structure for t_prop
-- ----------------------------
DROP TABLE IF EXISTS `t_prop`;
CREATE TABLE `t_prop` (
  `prop_id` int(11) NOT NULL COMMENT '道具编号',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `icon` int(11) NOT NULL COMMENT '图标',
  `type` int(11) NOT NULL COMMENT '类型',
  `sell` tinyint(1) NOT NULL DEFAULT '0' COMMENT '可否出售',
  `sell_price` int(11) NOT NULL COMMENT '出售价格',
  `des` varchar(128) NOT NULL COMMENT '描述',
  `use` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可以使用',
  `expendItems` varchar(128) NOT NULL COMMENT '消耗',
  `gainItems` varchar(512) NOT NULL COMMENT '获得'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_prop
-- ----------------------------
INSERT INTO `t_prop` VALUES ('4020001', '经验药水', '4020001', '1', '1', '10', '使用后主角会获得50000点经验。', '1', '', '');
INSERT INTO `t_prop` VALUES ('4020002', '小体力药水', '4020002', '1', '1', '10', '使用后会获得10点体力。', '1', '', '');
INSERT INTO `t_prop` VALUES ('4020003', '体力药水', '4020003', '1', '1', '10', '使用后，会将当前体力回复到最大值。', '1', '', '');
INSERT INTO `t_prop` VALUES ('4020004', '金钱卡', '4020004', '1', '1', '10', '使用后，在接下来的30场战斗中会获得20%的金钱收获加成。', '1', '', '');
INSERT INTO `t_prop` VALUES ('4020005', '经验卡', '4020005', '1', '1', '10', '使用后，在接下来的30场战斗中会获得20%的经验收获加成。', '1', '', '');
INSERT INTO `t_prop` VALUES ('4020006', '背包扩充卡', '4020005', '1', '1', '10', '使用后，会获得1个额外的背包栏位。', '1', '', '');
INSERT INTO `t_prop` VALUES ('4020007', '复活药水', '4020007', '1', '1', '10', '无法在背包中使用，当战斗死亡后，会弹出道具使用提示，是否要使用复活药水复活。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4020008', '秘银棒', '4020008', '1', '1', '10', '有了秘银棒，武魂被拆再也不会被摧毁了。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4020009', '元气石', '4020009', '1', '1', '10', '可以用于提高经验池的上限，单个提升1000点。', '1', '', '');
INSERT INTO `t_prop` VALUES ('4020010', '能量石', '4020009', '1', '1', '10', '可以用于提高熔炼池的上限，单个提升1000点。', '1', '', '');
INSERT INTO `t_prop` VALUES ('4020011', '补签卡', '4020011', '1', '1', '10', '可以用于月签到中的补签。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4020012', '扫荡券', '4020011', '1', '1', '10', '可以用于关卡扫荡', '0', '', '');
INSERT INTO `t_prop` VALUES ('4020013', '金钥匙', '4040003', '1', '1', '10', '含着它出生必定大富大贵金钥匙，可以用于开启金宝箱！', '0', '', '');
INSERT INTO `t_prop` VALUES ('4020014', '银钥匙', '4040002', '1', '1', '10', '银光闪烁的银饰钥匙，可以用于开启银宝箱！', '0', '', '');
INSERT INTO `t_prop` VALUES ('4020015', '铜钥匙', '4040001', '1', '1', '10', '简单通用的铜制钥匙，可以用于开启铜宝箱！', '0', '', '');
INSERT INTO `t_prop` VALUES ('4020016', '金宝箱', '4030003', '2', '1', '10', '传说中的金制宝箱，打开后可能获得大量钻石，金币，伙伴，武魂，装备，石板等，需要用金钥匙打开。', '1', '4_4020013_1_0', '10000#1#3_0_100_0_5000|2_0_100_0_5000&10000#-1#4_4020009_1_0_5000|4_4020010_1_0_5000');
INSERT INTO `t_prop` VALUES ('4020017', '银宝箱', '4030002', '2', '1', '10', '传说中的银制宝箱，打开后可能获得中等钻石，金币，伙伴，武魂，装备，石板等，需要用金钥匙打开。', '1', '4_4020014_1_0', '10000#-1#3_0_100_0_10000|2_0_100_0_10000');
INSERT INTO `t_prop` VALUES ('4020018', '铜宝箱', '4030001', '2', '1', '10', '传说中的铜制宝箱，打开后可能获得少量钻石，金币，伙伴，武魂，装备，石板等，需要用金钥匙打开。', '1', '4_4020015_1_0', '10000#-1#3_0_100_0_5000|2_0_100_0_5000');
INSERT INTO `t_prop` VALUES ('4021001', '魂灵碎片', '4021001', '1', '1', '99', '散发着淡淡的光芒，是1-2星伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021002', '魂灵精萃', '4021002', '1', '1', '99', '散发着温暖的光芒，是3-4星伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021003', '魂灵宝珠', '4021003', '1', '1', '99', '散发着明亮的光芒，是5-6星伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021004', '火灵碎片', '4021004', '1', '1', '99', '散发着淡淡的红色光芒，是1-2星火属性伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021005', '火灵精萃', '4021005', '1', '1', '99', '散发着温暖的红色光芒，是3-4星火属性伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021006', '火灵宝珠', '4021006', '1', '1', '99', '散发着明亮的红色光芒，是5-6星火属性伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021007', '木灵碎片', '4021007', '1', '1', '99', '散发着淡淡的绿色光芒，是1-2星木属性伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021008', '木灵精萃', '4021008', '1', '1', '99', '散发着温暖的绿色光芒，是3-4星木属性伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021009', '木灵宝珠', '4021009', '1', '1', '99', '散发着明亮的绿色光芒，是5-6星木属性伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021010', '水灵碎片', '4021010', '1', '1', '99', '散发着淡淡的蓝色光芒，是1-2星水属性伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021011', '水灵精萃', '4021011', '1', '1', '99', '散发着温暖的蓝色光芒，是3-4星水属性伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021012', '水灵宝珠', '4021012', '1', '1', '99', '散发着明亮的蓝色光芒，是5-6星水属性伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021013', '光灵碎片', '4021013', '1', '1', '99', '散发着淡淡的金色光芒，是1-2星光属性伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021014', '光灵精萃', '4021014', '1', '1', '99', '散发着温暖的金色光芒，是3-4星光属性伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021015', '光灵宝珠', '4021015', '1', '1', '99', '散发着明亮的金色光芒，是5-6星光属性伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021016', '暗灵碎片', '4021016', '1', '1', '99', '散发着淡淡的紫色光芒，是1-2星暗属性伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021017', '暗灵精萃', '4021017', '1', '1', '99', '散发着温暖的紫色光芒，是3-4星暗属性伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4021018', '暗灵宝珠', '4021018', '1', '1', '99', '散发着明亮的紫色光芒，是5-6星暗属性伙伴通用的进化材料。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4022001', '部位一灵石', '4023101', '1', '1', '99', '伙伴突破所需部位一灵石', '0', '', '');
INSERT INTO `t_prop` VALUES ('4022002', '部位二灵石', '4023101', '1', '1', '99', '伙伴突破所需部位二灵石', '0', '', '');
INSERT INTO `t_prop` VALUES ('4022003', '部位三灵石', '4023101', '1', '1', '99', '伙伴突破所需部位三灵石', '0', '', '');
INSERT INTO `t_prop` VALUES ('4022004', '部位四灵石', '4023101', '1', '1', '99', '伙伴突破所需部位四灵石', '0', '', '');
INSERT INTO `t_prop` VALUES ('4022005', '部位五灵石', '4023101', '1', '1', '99', '伙伴突破所需部位五灵石', '0', '', '');
INSERT INTO `t_prop` VALUES ('4022006', '部位六灵石', '4023101', '1', '1', '99', '伙伴突破所需部位六灵石', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023101', '下品挽月石', '4023101', '1', '1', '99', '月形的灵石，此为下品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023102', '中品挽月石', '4023102', '1', '1', '99', '月形的灵石，此为中品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023103', '上品挽月石', '4023103', '1', '1', '99', '月形的灵石，此为上品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023104', '精品挽月石', '4023104', '1', '1', '99', '月形的灵石，此为精品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023105', '极品挽月石', '4023105', '1', '1', '99', '月形的灵石，此为极品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023106', '仙品挽月石', '4023106', '1', '1', '99', '月形的灵石，此为仙品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023107', '圣品挽月石', '4023107', '1', '1', '99', '月形的灵石，此为升品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023201', '下品摘星石', '4023201', '1', '1', '99', '星形的灵石，此为下品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023202', '中品摘星石', '4023202', '1', '1', '99', '星形的灵石，此为中品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023203', '上品摘星石', '4023203', '1', '1', '99', '星形的灵石，此为上品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023204', '精品摘星石', '4023204', '1', '1', '99', '星形的灵石，此为精品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023205', '极品摘星石', '4023205', '1', '1', '99', '星形的灵石，此为极品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023206', '仙品摘星石', '4023206', '1', '1', '99', '星形的灵石，此为仙品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023207', '圣品摘星石', '4023207', '1', '1', '99', '星形的灵石，此为升品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023301', '下品地方石', '4023301', '1', '1', '99', '方形的灵石，此为下品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023302', '中品地方石', '4023302', '1', '1', '99', '方形的灵石，此为中品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023303', '上品地方石', '4023303', '1', '1', '99', '方形的灵石，此为上品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023304', '精品地方石', '4023304', '1', '1', '99', '方形的灵石，此为精品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023305', '极品地方石', '4023305', '1', '1', '99', '方形的灵石，此为极品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023306', '仙品地方石', '4023306', '1', '1', '99', '方形的灵石，此为仙品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023307', '圣品地方石', '4023307', '1', '1', '99', '方形的灵石，此为升品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023401', '下品天圆石', '4023401', '1', '1', '99', '圆形的灵石，此为下品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023402', '中品天圆石', '4023402', '1', '1', '99', '圆形的灵石，此为中品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023403', '上品天圆石', '4023403', '1', '1', '99', '圆形的灵石，此为上品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023404', '精品天圆石', '4023404', '1', '1', '99', '圆形的灵石，此为精品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023405', '极品天圆石', '4023405', '1', '1', '99', '圆形的灵石，此为极品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023406', '仙品天圆石', '4023406', '1', '1', '99', '圆形的灵石，此为仙品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023407', '圣品天圆石', '4023407', '1', '1', '99', '圆形的灵石，此为升品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023501', '下品伏虎石', '4023501', '1', '1', '99', '猛虎形状的灵石，此为下品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023502', '中品伏虎石', '4023502', '1', '1', '99', '猛虎形状的灵石，此为中品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023503', '上品伏虎石', '4023503', '1', '1', '99', '猛虎形状的灵石，此为上品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023504', '精品伏虎石', '4023504', '1', '1', '99', '猛虎形状的灵石，此为精品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023505', '极品伏虎石', '4023505', '1', '1', '99', '猛虎形状的灵石，此为极品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023506', '仙品伏虎石', '4023506', '1', '1', '99', '猛虎形状的灵石，此为仙品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023507', '圣品伏虎石', '4023507', '1', '1', '99', '猛虎形状的灵石，此为升品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023601', '下品降龙石', '4023601', '1', '1', '99', '腾龙形状的灵石，此为下品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023602', '中品降龙石', '4023602', '1', '1', '99', '腾龙形状的灵石，此为中品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023603', '上品降龙石', '4023603', '1', '1', '99', '腾龙形状的灵石，此为上品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023604', '精品降龙石', '4023604', '1', '1', '99', '腾龙形状的灵石，此为精品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023605', '极品降龙石', '4023605', '1', '1', '99', '腾龙形状的灵石，此为极品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023606', '仙品降龙石', '4023606', '1', '1', '99', '腾龙形状的灵石，此为仙品。', '0', '', '');
INSERT INTO `t_prop` VALUES ('4023607', '圣品降龙石', '4023607', '1', '1', '99', '腾龙形状的灵石，此为升品。', '0', '', '');

-- ----------------------------
-- Table structure for t_prop_effect
-- ----------------------------
DROP TABLE IF EXISTS `t_prop_effect`;
CREATE TABLE `t_prop_effect` (
  `prop_id` int(11) NOT NULL COMMENT '道具编号',
  `effect_id` int(11) NOT NULL COMMENT '类型ID',
  `val` int(11) NOT NULL COMMENT '值',
  `cd` int(11) NOT NULL COMMENT '持续时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_prop_effect
-- ----------------------------
INSERT INTO `t_prop_effect` VALUES ('4020001', '1', '50000', '0');
INSERT INTO `t_prop_effect` VALUES ('4020002', '2', '10', '0');
INSERT INTO `t_prop_effect` VALUES ('4020003', '3', '0', '0');
INSERT INTO `t_prop_effect` VALUES ('4020004', '4', '2000', '30');
INSERT INTO `t_prop_effect` VALUES ('4020005', '5', '2000', '30');
INSERT INTO `t_prop_effect` VALUES ('4020006', '6', '1', '0');
INSERT INTO `t_prop_effect` VALUES ('4020007', '7', '1', '0');
INSERT INTO `t_prop_effect` VALUES ('4020009', '9', '1000', '0');
INSERT INTO `t_prop_effect` VALUES ('4020010', '10', '1000', '0');

-- ----------------------------
-- Table structure for t_signin
-- ----------------------------
DROP TABLE IF EXISTS `t_signin`;
CREATE TABLE `t_signin` (
  `day` int(11) NOT NULL COMMENT '天',
  `goods_id` int(11) NOT NULL COMMENT '物品id',
  `type` int(11) NOT NULL COMMENT '物品类型',
  `num` int(11) NOT NULL COMMENT '数量',
  `level` int(11) NOT NULL COMMENT '物品等级'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_signin
-- ----------------------------
INSERT INTO `t_signin` VALUES ('1', '0', '2', '2000', '0');
INSERT INTO `t_signin` VALUES ('2', '0', '3', '20', '0');
INSERT INTO `t_signin` VALUES ('3', '4020001', '4', '1', '0');
INSERT INTO `t_signin` VALUES ('4', '82003', '1', '1', '0');
INSERT INTO `t_signin` VALUES ('5', '4020009', '4', '1', '0');
INSERT INTO `t_signin` VALUES ('6', '0', '2', '4000', '0');
INSERT INTO `t_signin` VALUES ('7', '0', '3', '40', '0');
INSERT INTO `t_signin` VALUES ('8', '4020001', '4', '2', '0');
INSERT INTO `t_signin` VALUES ('9', '82003', '1', '1', '0');
INSERT INTO `t_signin` VALUES ('10', '4020009', '4', '3', '0');
INSERT INTO `t_signin` VALUES ('11', '0', '2', '6000', '0');
INSERT INTO `t_signin` VALUES ('12', '0', '3', '60', '0');
INSERT INTO `t_signin` VALUES ('13', '4020001', '4', '3', '0');
INSERT INTO `t_signin` VALUES ('14', '82003', '1', '2', '0');
INSERT INTO `t_signin` VALUES ('15', '4020009', '4', '6', '0');
INSERT INTO `t_signin` VALUES ('16', '0', '2', '8000', '0');
INSERT INTO `t_signin` VALUES ('17', '0', '3', '80', '0');
INSERT INTO `t_signin` VALUES ('18', '4020001', '4', '4', '0');
INSERT INTO `t_signin` VALUES ('19', '82003', '1', '2', '0');
INSERT INTO `t_signin` VALUES ('20', '4020010', '4', '1', '0');
INSERT INTO `t_signin` VALUES ('21', '0', '2', '12000', '0');
INSERT INTO `t_signin` VALUES ('22', '0', '3', '120', '0');
INSERT INTO `t_signin` VALUES ('23', '4020001', '4', '5', '0');
INSERT INTO `t_signin` VALUES ('24', '82003', '1', '3', '0');
INSERT INTO `t_signin` VALUES ('25', '4020010', '4', '3', '0');
INSERT INTO `t_signin` VALUES ('26', '0', '2', '15000', '0');
INSERT INTO `t_signin` VALUES ('27', '0', '3', '150', '0');
INSERT INTO `t_signin` VALUES ('28', '4020001', '4', '6', '0');
INSERT INTO `t_signin` VALUES ('29', '82003', '1', '4', '0');
INSERT INTO `t_signin` VALUES ('30', '4020010', '4', '6', '0');
INSERT INTO `t_signin` VALUES ('31', '0', '2', '20000', '0');

-- ----------------------------
-- Table structure for t_skill
-- ----------------------------
DROP TABLE IF EXISTS `t_skill`;
CREATE TABLE `t_skill` (
  `skill_id` int(11) NOT NULL COMMENT 'Index',
  `ground` int(11) NOT NULL COMMENT '地板特效',
  `img` varchar(50) NOT NULL COMMENT '特效资源',
  `hit_delay` int(11) NOT NULL COMMENT '反馈延迟',
  `skill_type` int(11) NOT NULL COMMENT '特效类型',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `lv` int(11) NOT NULL COMMENT '等级',
  `des` varchar(128) NOT NULL COMMENT '技能描述',
  `delay` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否延时释放',
  `target` int(11) NOT NULL COMMENT '目标',
  `isrdm` int(11) NOT NULL COMMENT '是否随机',
  `range` int(11) NOT NULL COMMENT '影响范围',
  `cd` int(11) NOT NULL COMMENT '冷却时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_skill
-- ----------------------------
INSERT INTO `t_skill` VALUES ('40001', '1', '5020062', '400', '2', '斩击', '1', '随机单体攻击', '0', '1', '1', '0', '1');
INSERT INTO `t_skill` VALUES ('40002', '0', '5060061', '500', '2', '突袭', '1', '随机攻击两个敌方单位', '0', '1', '1', '0', '3');
INSERT INTO `t_skill` VALUES ('40003', '0', '5020051', '500', '2', '天下无双', '1', '给予自身炎怒效果（暴击+暴伤）', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40004', '0', '5020023', '500', '2', '黄天当立', '1', '攻击并给予敌方全体灼伤效果（易伤+流血）', '0', '1', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40005', '0', '5040061', '500', '1', '横扫千军', '1', '攻击周围所有敌人', '0', '5', '0', '10111011', '3');
INSERT INTO `t_skill` VALUES ('40006', '0', '5050011', '1000', '2', '雷霆一击', '1', '攻击左方目标并附带灼伤效果（流血+易伤）', '0', '5', '0', '1', '3');
INSERT INTO `t_skill` VALUES ('40007', '0', '5030013', '500', '2', '御敌', '1', '自身减伤', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40008', '0', '5030061', '500', '2', '锦上添花', '1', '我方全体攻击提升', '0', '2', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40009', '0', '5060071', '500', '2', '魅影相随', '1', '给予我方全体罗刹效果（移动+回避）', '0', '2', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40010', '0', '5050031', '500', '2', '妙手回春', '1', '我方全体生命上限增加并且回复生命', '0', '2', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40011', '0', '5050031', '500', '2', '元灵归心', '1', '我方全体生命回复', '0', '2', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40012', '0', '5050031', '500', '2', '酒池肉林', '1', '自身血量回复', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40013', '0', '5060023', '500', '2', '幽冥之息', '1', '攻击给予敌方全体沉默效果', '0', '1', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40014', '0', '5060083', '500', '2', '吞天噬地', '1', '攻击左方一个角色并回复自身血量', '0', '5', '0', '1', '3');
INSERT INTO `t_skill` VALUES ('40015', '0', '5050083', '500', '2', '光盾', '1', '给予我方随机单体生命上限增加', '0', '2', '1', '0', '3');
INSERT INTO `t_skill` VALUES ('40016', '0', '5020051', '1500', '2', '炙炎', '1', '自身周围任一单体攻击', '0', '1', '1', '10111011', '3');
INSERT INTO `t_skill` VALUES ('40017', '0', '5040053', '1000', '2', '玄冰', '1', '自身周围群体攻击', '0', '5', '0', '10111011', '3');
INSERT INTO `t_skill` VALUES ('40018', '0', '5030043', '500', '2', '万蚁噬心', '1', '给予敌方全体中毒效果', '0', '1', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40019', '0', '5060011', '500', '2', '幻影移形', '1', '增加自身闪避', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40020', '0', '5060043', '700', '2', '搏杀', '1', '左方单体攻击', '0', '5', '0', '1', '3');
INSERT INTO `t_skill` VALUES ('40021', '0', '5030013', '500', '2', '铁骨', '1', '自身减伤', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40022', '0', '5050051', '500', '2', '天照之叹', '1', '攻击左下、右下敌方并带目盲效果（缴械+定身）', '0', '5', '0', '1010', '3');
INSERT INTO `t_skill` VALUES ('40023', '0', '5020063', '500', '2', '撕裂', '1', '给予左方目标流血效果', '0', '5', '0', '1', '3');
INSERT INTO `t_skill` VALUES ('40024', '0', '5060031', '1000', '2', '丧魂夺魄', '1', '攻击并给予左下敌方单体梦魇效果（眩晕+易伤）', '0', '5', '0', '10', '3');
INSERT INTO `t_skill` VALUES ('40025', '0', '5040021', '500', '2', '固若金汤', '1', '给予自己冰壁效果（格挡+格挡值）', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40026', '0', '5030013', '500', '2', '铜墙铁壁', '1', '自身减伤', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40027', '0', '5050091', '200', '2', '嗜血狂斧', '1', '攻击左上方敌人并带束缚效果', '0', '5', '1', '10000000', '3');
INSERT INTO `t_skill` VALUES ('40028', '0', '5050031', '500', '2', '甘露', '1', '我方随机两个单位生命回复', '0', '2', '1', '0', '3');
INSERT INTO `t_skill` VALUES ('40029', '0', '5050031', '500', '2', '玉泉', '1', '左方单体生命回复', '0', '5', '0', '1', '3');
INSERT INTO `t_skill` VALUES ('40030', '0', '5050081', '500', '2', '筋斗之云', '1', '给予自己专注效果（攻击次数+攻击方向）', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40031', '0', '5030011', '500', '1', '倒打一耙', '1', '击退周围所有敌方并造成伤害', '0', '5', '0', '10111011', '3');
INSERT INTO `t_skill` VALUES ('40032', '1', '5060053', '500', '2', '彼岸黄泉', '1', '随机攻击三个敌方单位', '0', '1', '1', '0', '3');
INSERT INTO `t_skill` VALUES ('40033', '0', '5020071', '500', '2', '鼓舞', '1', '随机增加我方一个单位的攻击', '0', '2', '1', '0', '3');
INSERT INTO `t_skill` VALUES ('40034', '0', '5050031', '500', '2', '归元', '1', '自身血量回复', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40035', '0', '5020081', '500', '2', '三昧真火', '1', '给予敌方全体焚心效果（减生命上限+易伤）', '0', '1', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40036', '4', '5020042', '500', '3', '破邪之击', '1', '攻击左方的群体角色，攻击范围为四格', '0', '5', '0', '4', '3');
INSERT INTO `t_skill` VALUES ('40037', '0', '5050031', '500', '2', '生生不息', '1', '给予我方全体守护效果（减伤+恢复）', '0', '2', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('40038', '0', '5040043', '500', '2', '透骨寒冰', '1', '给予右上方敌方单体冰棺效果（眩晕+流血）', '0', '5', '0', '100000', '3');
INSERT INTO `t_skill` VALUES ('40039', '0', '5060031', '500', '2', '腐蚀诅咒', '1', '攻击并给予左上敌方单体并附带诅咒效果（流血+降攻）', '0', '5', '0', '10000000', '3');
INSERT INTO `t_skill` VALUES ('40040', '0', '5030013', '500', '2', '坚如磐石', '1', '自身减伤', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('100001', '0', '5020062', '500', '2', '元灵之击', '1', '攻击右上、右下的敌人', '0', '5', '0', '101000', '3');
INSERT INTO `t_skill` VALUES ('100002', '0', '5020071', '500', '2', '锦上添花', '1', '给予自身攻击提升BUFF', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('100003', '0', '5060031', '500', '2', '魅影之鞭', '1', '攻击右上、右、右下的敌人', '0', '5', '0', '111000', '3');
INSERT INTO `t_skill` VALUES ('100004', '0', '5050081', '500', '2', '逆天改命', '1', '给予自身无敌效果', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('100005', '0', '5050011', '500', '2', '雷霆一击', '1', '攻击右方单体并给予其灼伤BUFF（流血+易伤）', '0', '5', '0', '10000', '3');
INSERT INTO `t_skill` VALUES ('100006', '0', '5020023', '500', '2', '横扫千军', '1', '攻击右上、右下、左上、左下的敌人', '0', '5', '0', '10101010', '3');
INSERT INTO `t_skill` VALUES ('100007', '0', '5020023', '500', '2', '黄天当立', '1', '攻击敌方全体', '0', '1', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('100008', '0', '5020051', '500', '2', '天下无双', '1', '给予自身炎怒效果（暴击+暴伤）', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('100009', '0', '5030013', '500', '2', '酒池肉林', '1', '给予自身减伤', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('100010', '0', '5060023', '500', '2', '幽冥之息', '1', '攻击右、右下、右下的敌人并附带沉默效果', '0', '5', '0', '111000', '3');
INSERT INTO `t_skill` VALUES ('100011', '0', '5030011', '500', '2', '倒打一耙', '1', '击退周身一格所有敌方并造成伤害', '0', '5', '0', '10111011', '3');
INSERT INTO `t_skill` VALUES ('100012', '0', '5050081', '500', '2', '筋斗之云', '1', '给予自身专注BUFF（攻击次数+攻击方向）', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('100013', '0', '5060053', '500', '2', '彼岸黄泉', '1', '攻击右上、右、右下两格的敌人', '0', '5', '0', '222000', '3');
INSERT INTO `t_skill` VALUES ('100014', '0', '5060083', '500', '2', '吞天噬地', '1', '攻击周身一格所有敌人并回复自身血量', '0', '5', '0', '10111011', '3');
INSERT INTO `t_skill` VALUES ('100015', '0', '5050091', '500', '2', '嗜血狂斧', '1', '攻击右下敌方并带萎缩效果', '0', '5', '0', '1000', '3');
INSERT INTO `t_skill` VALUES ('100016', '0', '5060053', '500', '2', '万蚁噬心', '1', '攻击右上、右下、左上、左下的敌人并带流血效果', '0', '5', '0', '10101010', '3');
INSERT INTO `t_skill` VALUES ('100017', '0', '5040043', '500', '2', '透骨寒冰', '1', '给予敌方单体晕眩效果', '0', '1', '1', '0', '3');
INSERT INTO `t_skill` VALUES ('100018', '0', '5040021', '500', '2', '固若金汤', '1', '给予自己冰壁效果（护盾+格挡+格挡值）', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('100019', '0', '5060011', '500', '2', '幻影移形', '1', '提升自身闪避', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('100020', '0', '5060083', '500', '2', '三昧真火', '1', '攻击敌方全体', '0', '1', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('100021', '0', '5030013', '500', '2', '铜墙铁壁', '1', '给予自身护盾', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('100022', '0', '5020023', '500', '2', '天照之叹', '1', '攻击周围任一敌方', '0', '5', '1', '10111011', '3');
INSERT INTO `t_skill` VALUES ('100023', '0', '5050041', '500', '2', '破邪之击', '1', '攻击右上、右下、左上、左下两格的敌人', '0', '5', '0', '20202020', '3');
INSERT INTO `t_skill` VALUES ('100024', '0', '5060031', '500', '2', '腐蚀诅咒', '1', '右方单体攻击并附带诅咒效果（流血+降攻）', '0', '5', '0', '10000', '3');
INSERT INTO `t_skill` VALUES ('100025', '0', '5030013', '500', '2', '坚如磐石', '1', '给予自身减伤效果', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('100026', '0', '5050031', '500', '2', '生生不息', '1', '给予自身守护效果（减伤+恢复）', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('100027', '0', '5060031', '500', '2', '丧魂夺魄', '1', '攻击右上、右、右下两格的敌人并附带梦魇效果（眩晕+易伤）', '0', '5', '0', '222000', '3');
INSERT INTO `t_skill` VALUES ('900001', '0', '', '500', '0', '斩击', '1', '攻击左边1格', '0', '5', '0', '1', '3');
INSERT INTO `t_skill` VALUES ('900002', '0', '5100004', '500', '2', '鬼手', '1', '攻击左边1格', '0', '5', '0', '1', '3');
INSERT INTO `t_skill` VALUES ('900003', '0', '5100005', '500', '2', '旋火', '1', '攻击左边1格', '0', '5', '0', '1', '3');
INSERT INTO `t_skill` VALUES ('900004', '0', '', '500', '0', '鬼火', '1', '攻击←↖↙3个方向', '0', '5', '0', '10000011', '3');
INSERT INTO `t_skill` VALUES ('900005', '0', '5100008', '500', '1', '亡者突袭', '1', '攻击周边格子', '0', '5', '0', '10111011', '3');
INSERT INTO `t_skill` VALUES ('900006', '0', '', '500', '0', '巨灵斧斩', '1', '攻击←↖↙3个方向', '0', '5', '0', '10000011', '3');
INSERT INTO `t_skill` VALUES ('900007', '0', '5100001', '500', '2', '凄煌烈光', '1', '攻击←↖↙3个方向，距离为2格', '0', '5', '0', '20000022', '3');
INSERT INTO `t_skill` VALUES ('900008', '0', '5100010', '500', '1', '定海神针', '1', '攻击←↖↙3个方向，并给予焚心效果', '0', '5', '0', '10000011', '3');
INSERT INTO `t_skill` VALUES ('900009', '0', '5100011', '500', '1', '勇定千军', '1', '攻击周边格子', '0', '5', '0', '10111011', '3');
INSERT INTO `t_skill` VALUES ('900010', '0', '5100007', '500', '2', '天下无双', '1', '增加自身的暴击和暴伤', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('900011', '0', '', '500', '0', '吞天噬地', '1', '攻击周边格子，并给予诅咒效果', '0', '5', '0', '10111011', '3');
INSERT INTO `t_skill` VALUES ('900012', '0', '5100016', '500', '1', '龙吟怒涛', '1', '攻击左边3个方向，并给予窒息效果', '0', '5', '0', '10000011', '3');
INSERT INTO `t_skill` VALUES ('900013', '0', '5100017', '500', '1', '彼岸花开', '1', '攻击←↖↙三个方向，距离为3格', '0', '5', '0', '30000033', '3');
INSERT INTO `t_skill` VALUES ('900014', '0', '', '500', '0', '突袭', '1', '随机攻击两个敌方单位', '0', '1', '1', '0', '3');
INSERT INTO `t_skill` VALUES ('900015', '0', '5100009', '500', '2', '鼓舞', '1', '随机增加我方一个单位的攻击', '0', '4', '1', '0', '3');
INSERT INTO `t_skill` VALUES ('900016', '0', '', '500', '0', '蝎针', '1', '攻击周围任一单位', '0', '5', '1', '10111011', '3');
INSERT INTO `t_skill` VALUES ('900017', '0', '5100014', '500', '2', '治愈', '1', '周围任一单体生命回复', '0', '5', '1', '10111011', '3');
INSERT INTO `t_skill` VALUES ('900018', '0', '5100002', '500', '2', '玄冰', '1', '左上、左下、右上、右下群体攻击', '0', '5', '0', '10101010', '3');
INSERT INTO `t_skill` VALUES ('900019', '0', '5100012', '500', '2', '光盾', '1', '给予我方随机单体生命上限增加', '0', '2', '1', '0', '3');
INSERT INTO `t_skill` VALUES ('900020', '0', '5100013', '500', '2', '润心', '1', '我方随机两个单位生命回复', '0', '2', '1', '0', '3');
INSERT INTO `t_skill` VALUES ('900021', '0', '', '500', '0', '锦上添花', '1', '我方单体造成伤害增加', '0', '2', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('900022', '0', '', '500', '0', '元灵归心', '1', '我方全体生命回复', '0', '2', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('900023', '0', '', '500', '0', '异兽毒牙', '1', '攻击周围所有敌方角色并附带中毒效果', '0', '5', '0', '10111011', '3');
INSERT INTO `t_skill` VALUES ('900024', '0', '', '500', '0', '蚀骨之术', '1', '任一单体攻击并附带诅咒效果', '0', '1', '1', '0', '3');
INSERT INTO `t_skill` VALUES ('900025', '0', '', '500', '0', '黄天当立', '1', '给予敌方全体灼伤效果', '0', '1', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('900026', '0', '', '500', '0', '透骨寒冰', '1', '给予左上、左下、右上、右下的敌人伤害', '0', '5', '0', '10101010', '3');
INSERT INTO `t_skill` VALUES ('900027', '0', '', '500', '0', '三昧真火', '1', '攻击敌方全体', '0', '1', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('900028', '0', '', '500', '0', '生生不息', '1', '我方单体减伤并生命恢复', '0', '2', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('900029', '0', '', '500', '0', '暗裔死镰', '1', '全体攻击并诅咒效果', '0', '1', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('900030', '0', '', '500', '0', '魅鞭夺魂', '1', '周围任一单体攻击并梦魇效果', '0', '5', '1', '10111011', '3');
INSERT INTO `t_skill` VALUES ('900031', '0', '', '500', '0', '悬壶济世', '1', '我方全体生命回复', '0', '2', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('900032', '0', '5100015', '500', '1', '惊涛狂澜', '1', '攻击所有敌人', '0', '1', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('900033', '0', '5100006', '500', '1', '红莲烈焰', '1', '攻击所有敌人', '0', '1', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('900034', '0', '5100003', '500', '1', '青龙偃月', '1', '攻击所有敌人', '0', '1', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('900035', '0', '', '500', '0', '重锤', '1', '随机单体攻击', '0', '1', '1', '0', '3');
INSERT INTO `t_skill` VALUES ('900036', '0', '', '500', '0', '归元', '1', '自身血量回复', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('900037', '0', '', '500', '0', '冰甲', '1', '自身减伤', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('900038', '0', '', '500', '0', '无尽魇食', '1', '攻击左方一个角色并回复自身血量', '0', '5', '0', '1', '3');
INSERT INTO `t_skill` VALUES ('900039', '0', '', '500', '0', '酒池肉林', '1', '自身血量回复，同时提升自身攻击力', '0', '3', '0', '0', '3');
INSERT INTO `t_skill` VALUES ('900040', '0', '', '500', '0', '倒打一耙', '1', '击退周围所有敌方并造成伤害', '0', '5', '0', '10111011', '3');
INSERT INTO `t_skill` VALUES ('900041', '0', '', '500', '0', '熔岩铁甲', '1', '自身减伤，同时对周边群体造成伤害', '0', '5', '0', '10111011', '3');
INSERT INTO `t_skill` VALUES ('900042', '0', '', '500', '0', '霜寒冰壁', '1', '给予自己冰壁效果（格挡+格挡值），同时随机对周边1个单位造成冰棺效果。', '0', '5', '1', '10111011', '3');
INSERT INTO `t_skill` VALUES ('900043', '0', '', '500', '0', '火神之怒', '1', '自身减伤，同时对周边群体造成伤害', '0', '5', '0', '10111011', '3');

-- ----------------------------
-- Table structure for t_skill_effect
-- ----------------------------
DROP TABLE IF EXISTS `t_skill_effect`;
CREATE TABLE `t_skill_effect` (
  `skill_id` int(11) NOT NULL COMMENT '技能编号',
  `id` int(11) NOT NULL COMMENT '索引ID',
  `lv` int(11) NOT NULL COMMENT '技能等级',
  `effect_id` int(11) NOT NULL COMMENT '技能效果0',
  `score` int(11) NOT NULL COMMENT '效果值0a',
  `cons` int(11) NOT NULL COMMENT '效果值0b',
  `round` int(11) NOT NULL COMMENT '回合',
  `img` int(11) NOT NULL COMMENT '状态特效',
  `tips` varchar(255) NOT NULL COMMENT '状态提示',
  `state` int(11) NOT NULL COMMENT '状态类型',
  `target` int(11) NOT NULL COMMENT '目标',
  `random` int(11) NOT NULL COMMENT '随机数',
  `range` varchar(20) NOT NULL COMMENT '影响范围'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_skill_effect
-- ----------------------------
INSERT INTO `t_skill_effect` VALUES ('40001', '1', '1', '1', '12000', '0', '0', '0', '', '0', '8', '1', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40002', '2', '1', '1', '23077', '0', '0', '0', '', '0', '8', '2', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40003', '3', '1', '4', '8000', '0', '2', '511004', 'tips_037', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40003', '4', '1', '26', '17500', '0', '2', '0', 'tips_023', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40004', '5', '1', '1', '20000', '0', '0', '0', '', '0', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40004', '6', '1', '8', '-3333', '0', '2', '511003', 'tips_020', '2', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40004', '7', '1', '2', '27800', '0', '2', '0', '', '2', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40005', '8', '1', '1', '16667', '0', '0', '0', '', '0', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('40006', '9', '1', '1', '18000', '0', '0', '0', '', '0', '520', '0', '00000001');
INSERT INTO `t_skill_effect` VALUES ('40006', '10', '1', '2', '6000', '0', '2', '511003', '', '2', '520', '0', '00000001');
INSERT INTO `t_skill_effect` VALUES ('40006', '11', '1', '8', '-5000', '0', '2', '0', 'tips_020', '2', '520', '0', '00000001');
INSERT INTO `t_skill_effect` VALUES ('40007', '12', '1', '8', '10000', '0', '2', '511013', 'tips_001', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40008', '13', '1', '3', '2170', '0', '2', '511002', 'tips_029', '2', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40009', '14', '1', '6', '0', '2', '2', '511005', 'tips_028', '2', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40009', '15', '1', '5', '2174', '0', '2', '0', 'tips_027', '2', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40010', '16', '1', '27', '1043', '0', '2', '511012', 'tips_026', '2', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40010', '17', '1', '10', '1565', '0', '0', '0', '', '0', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40011', '18', '1', '10', '2609', '0', '2', '0', '', '0', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40012', '19', '1', '10', '6000', '0', '0', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40013', '20', '1', '1', '15652', '0', '0', '0', '', '0', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40013', '21', '1', '14', '0', '0', '2', '511011', 'tips_002', '2', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40014', '22', '1', '1', '18000', '0', '0', '0', '', '0', '520', '0', '00000001');
INSERT INTO `t_skill_effect` VALUES ('40014', '23', '1', '10', '3600', '0', '0', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40015', '24', '1', '27', '2400', '0', '2', '511012', 'tips_026', '2', '3', '1', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40016', '25', '1', '1', '30000', '0', '0', '0', '', '0', '520', '1', '10111011');
INSERT INTO `t_skill_effect` VALUES ('40017', '26', '1', '1', '33333', '0', '0', '0', '', '0', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('40018', '27', '1', '2', '16667', '0', '2', '513001', '', '2', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40018', '28', '1', '4', '1778', '0', '2', '0', 'tips_037', '2', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40018', '29', '1', '26', '-3889', '0', '2', '0', 'tips_016', '2', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40019', '30', '1', '5', '2000', '0', '2', '511006', 'tips_027', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40020', '31', '1', '1', '30000', '0', '0', '0', '', '0', '520', '0', '00000001');
INSERT INTO `t_skill_effect` VALUES ('40021', '32', '1', '8', '10000', '0', '2', '511013', 'tips_035', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40022', '33', '1', '1', '13846', '0', '0', '0', '', '0', '520', '0', '00001010');
INSERT INTO `t_skill_effect` VALUES ('40022', '34', '1', '13', '0', '0', '2', '511014', 'tips_003', '2', '520', '0', '00001010');
INSERT INTO `t_skill_effect` VALUES ('40022', '35', '1', '6', '0', '-10', '2', '0', 'tips_014', '2', '520', '0', '00001010');
INSERT INTO `t_skill_effect` VALUES ('40023', '36', '1', '2', '30000', '0', '2', '511001', '', '2', '520', '0', '00000001');
INSERT INTO `t_skill_effect` VALUES ('40024', '37', '1', '1', '36000', '0', '0', '0', '', '0', '520', '0', '00000010');
INSERT INTO `t_skill_effect` VALUES ('40024', '38', '1', '15', '0', '0', '2', '516001', 'tips_021', '1', '520', '0', '00000010');
INSERT INTO `t_skill_effect` VALUES ('40024', '39', '1', '8', '-5000', '0', '2', '0', 'tips_020', '2', '520', '0', '00000010');
INSERT INTO `t_skill_effect` VALUES ('40025', '40', '1', '28', '5000', '0', '2', '514002', 'tips_038', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40025', '41', '1', '18', '5000', '0', '2', '0', 'tips_022', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40026', '42', '1', '8', '10000', '0', '2', '511013', 'tips_035', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40027', '43', '1', '1', '18000', '0', '0', '0', '', '0', '520', '0', '10000000');
INSERT INTO `t_skill_effect` VALUES ('40027', '44', '1', '6', '0', '-10', '2', '513002', 'tips_014', '2', '520', '0', '10000000');
INSERT INTO `t_skill_effect` VALUES ('40028', '45', '1', '10', '4615', '0', '0', '0', '', '0', '3', '2', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40029', '46', '1', '10', '6000', '0', '0', '0', '', '0', '514', '0', '00000001');
INSERT INTO `t_skill_effect` VALUES ('40030', '47', '1', '9', '0', '2', '2', '515001', 'tips_025', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40030', '48', '1', '12', '0', '187', '2', '0', 'tips_024', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40031', '49', '1', '1', '10000', '0', '0', '0', '', '0', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('40031', '50', '1', '17', '0', '1', '0', '0', '', '0', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('40032', '51', '1', '1', '16667', '0', '0', '0', '', '0', '8', '3', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40033', '52', '1', '3', '10000', '0', '2', '511002', 'tips_029', '2', '3', '1', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40034', '53', '1', '10', '6000', '0', '0', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40035', '54', '1', '27', '-2609', '0', '2', '512001', 'tips_019', '2', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40035', '55', '1', '8', '-4348', '0', '2', '0', 'tips_020', '2', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40036', '56', '1', '1', '16667', '0', '0', '0', '', '0', '520', '0', '00000004');
INSERT INTO `t_skill_effect` VALUES ('40037', '57', '1', '10', '1565', '0', '0', '0', '', '0', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40037', '58', '1', '8', '2170', '0', '2', '511013', 'tips_001', '2', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('40038', '59', '1', '2', '12000', '0', '2', '514002', '', '1', '520', '0', '00100000');
INSERT INTO `t_skill_effect` VALUES ('40038', '60', '1', '15', '0', '0', '2', '0', 'tips_021', '1', '520', '0', '00100000');
INSERT INTO `t_skill_effect` VALUES ('40039', '61', '1', '1', '18000', '0', '0', '0', '', '0', '520', '0', '10000000');
INSERT INTO `t_skill_effect` VALUES ('40039', '62', '1', '2', '6000', '0', '2', '516001', '', '2', '520', '0', '10000000');
INSERT INTO `t_skill_effect` VALUES ('40039', '63', '1', '3', '-5000', '0', '2', '0', 'tips_012', '2', '520', '0', '10000000');
INSERT INTO `t_skill_effect` VALUES ('40040', '64', '1', '8', '10000', '0', '2', '511013', 'tips_035', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50001', '65', '1', '8', '6400', '0', '1', '511013', 'tips_001', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50002', '66', '1', '8', '6400', '0', '1', '511013', 'tips_001', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50003', '67', '1', '3', '8000', '0', '1', '511002', 'tips_029', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50004', '68', '1', '3', '8000', '0', '1', '0', 'tips_029', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50005', '69', '1', '10', '4800', '0', '0', '0', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50006', '70', '1', '16', '2090', '0', '2', '511007', 'tips_036', '2', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50007', '71', '1', '10', '2090', '0', '0', '0', '', '0', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50008', '72', '1', '1', '48000', '0', '0', '0', '', '3', '12', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50009', '73', '1', '2', '10440', '0', '1', '511001', '', '2', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50010', '74', '1', '10', '4800', '0', '0', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50011', '75', '1', '5', '4000', '0', '1', '511006', 'tips_027', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50012', '76', '1', '3', '8000', '0', '1', '0', 'tips_029', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50013', '77', '1', '3', '8000', '0', '1', '511002', 'tips_029', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50014', '78', '1', '3', '8000', '0', '1', '511002', 'tips_029', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50015', '79', '1', '3', '-3480', '0', '1', '511010', 'tips_012', '2', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50016', '80', '1', '8', '3480', '0', '1', '511013', 'tips_001', '2', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50017', '81', '1', '8', '-3480', '0', '1', '512001', 'tips_020', '2', '12', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50018', '82', '1', '10', '2090', '0', '0', '0', '', '0', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50019', '83', '1', '28', '4000', '0', '1', '0', 'tips_038', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50019', '84', '1', '18', '4000', '0', '1', '514002', 'tips_022', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50020', '85', '1', '8', '10000', '0', '1', '511013', 'tips_035', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50021', '86', '1', '3', '10000', '0', '1', '0', 'tips_029', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50022', '87', '1', '3', '4348', '0', '1', '511002', 'tips_029', '2', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50023', '88', '1', '3', '10000', '0', '1', '511002', 'tips_029', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50024', '89', '1', '3', '4348', '0', '1', '511002', 'tips_029', '2', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50025', '90', '1', '10', '2609', '0', '0', '0', '', '0', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50026', '91', '1', '3', '10000', '0', '1', '511002', 'tips_029', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50027', '92', '1', '3', '10000', '0', '1', '0', 'tips_029', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50028', '93', '1', '20', '0', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('50029', '94', '1', '7', '0', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60001', '95', '1', '8', '560', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60002', '96', '1', '5', '350', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60003', '97', '1', '4', '560', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60003', '98', '1', '26', '1220', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60004', '99', '1', '3', '700', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60005', '100', '1', '4', '560', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60005', '101', '1', '26', '1220', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60006', '102', '1', '19', '4444', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60007', '103', '1', '19', '4444', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60008', '104', '1', '3', '835', '0', '1', '0', '', '0', '33', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60009', '105', '1', '8', '670', '0', '1', '0', '', '0', '257', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60010', '106', '1', '28', '350', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60010', '107', '1', '18', '350', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60011', '108', '1', '8', '560', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60012', '109', '1', '3', '700', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60013', '110', '1', '4', '560', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60013', '111', '1', '26', '1220', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60014', '112', '1', '3', '700', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60015', '113', '1', '19', '4444', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60016', '114', '1', '3', '835', '0', '1', '0', '', '0', '65', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60017', '115', '1', '3', '835', '0', '1', '0', '', '0', '17', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60018', '116', '1', '8', '670', '0', '1', '0', '', '0', '33', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60019', '117', '1', '8', '830', '0', '1', '0', '', '0', '65', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60020', '118', '1', '8', '830', '0', '1', '0', '', '0', '17', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60021', '119', '1', '3', '870', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60022', '120', '1', '3', '1043', '0', '1', '0', '', '0', '257', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60023', '121', '1', '4', '696', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60023', '122', '1', '26', '1522', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60024', '123', '1', '19', '5553', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60025', '124', '1', '10', '3130', '0', '1', '0', '', '0', '131', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60026', '125', '1', '4', '696', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60026', '126', '1', '26', '1522', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('60027', '127', '1', '3', '700', '0', '1', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70001', '128', '1', '12', '0', '128', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70002', '129', '1', '12', '0', '32', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70003', '130', '1', '12', '0', '16', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70004', '131', '1', '12', '0', '8', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70005', '132', '1', '12', '0', '2', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70006', '133', '1', '12', '0', '1', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70007', '134', '1', '7', '0', '0', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70008', '135', '1', '20', '0', '0', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70009', '136', '1', '7', '0', '0', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70010', '137', '1', '22', '0', '0', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70011', '138', '1', '3', '1600', '0', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70012', '139', '1', '3', '1600', '0', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70013', '140', '1', '3', '1600', '0', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70014', '141', '1', '3', '1600', '0', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70015', '142', '1', '3', '1600', '0', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70016', '143', '1', '8', '1600', '1', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70017', '144', '1', '8', '1600', '2', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70018', '145', '1', '8', '1600', '3', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70019', '146', '1', '8', '1600', '5', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70020', '147', '1', '8', '1600', '4', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70021', '148', '1', '3', '1600', '0', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70022', '149', '1', '8', '1600', '0', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70023', '150', '1', '6', '0', '2', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70024', '151', '1', '8', '2000', '0', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70025', '152', '1', '3', '2000', '0', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70026', '153', '1', '8', '0', '0', '9', '0', '', '1', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70027', '154', '1', '3', '2000', '0', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('70028', '155', '1', '9', '0', '2', '1', '0', '', '3', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100001', '156', '1', '1', '33333', '0', '0', '0', '', '0', '520', '0', '00101000');
INSERT INTO `t_skill_effect` VALUES ('100002', '157', '1', '3', '10000', '0', '2', '511002', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100003', '158', '1', '1', '33333', '0', '0', '0', '', '0', '520', '0', '00111000');
INSERT INTO `t_skill_effect` VALUES ('100004', '159', '1', '8', '10000', '0', '2', '511012', '', '1', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100005', '160', '1', '1', '18000', '0', '0', '0', '', '0', '520', '0', '00010000');
INSERT INTO `t_skill_effect` VALUES ('100005', '161', '1', '2', '6000', '0', '2', '511003', '', '2', '520', '0', '00010000');
INSERT INTO `t_skill_effect` VALUES ('100005', '162', '1', '8', '-5000', '0', '2', '0', '', '2', '520', '0', '00010000');
INSERT INTO `t_skill_effect` VALUES ('100006', '163', '1', '1', '16667', '0', '0', '0', '', '0', '520', '0', '10101010');
INSERT INTO `t_skill_effect` VALUES ('100007', '164', '1', '1', '13043', '0', '0', '0', '', '0', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100008', '165', '1', '4', '8000', '0', '2', '511004', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100008', '166', '1', '26', '17500', '0', '2', '0', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100009', '167', '1', '8', '10000', '0', '2', '511013', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100010', '168', '1', '1', '20000', '0', '0', '0', '', '0', '520', '0', '00111000');
INSERT INTO `t_skill_effect` VALUES ('100010', '169', '1', '14', '0', '0', '2', '511003', '', '2', '520', '0', '00111000');
INSERT INTO `t_skill_effect` VALUES ('100011', '170', '1', '17', '0', '1', '0', '0', '', '0', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('100011', '171', '1', '1', '27273', '0', '0', '0', '', '0', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('100012', '172', '1', '9', '0', '2', '2', '515001', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100012', '173', '1', '12', '0', '187', '2', '0', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100013', '174', '1', '1', '16667', '0', '0', '0', '', '0', '520', '0', '00222000');
INSERT INTO `t_skill_effect` VALUES ('100014', '175', '1', '1', '10000', '0', '0', '0', '', '0', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('100014', '176', '1', '10', '2000', '0', '0', '0', '', '0', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('100015', '177', '1', '1', '18000', '0', '0', '0', '', '0', '520', '0', '00001000');
INSERT INTO `t_skill_effect` VALUES ('100015', '178', '1', '27', '-2400', '0', '2', '513002', '', '2', '520', '0', '00001000');
INSERT INTO `t_skill_effect` VALUES ('100016', '179', '1', '1', '20000', '0', '0', '0', '', '0', '520', '0', '10101010');
INSERT INTO `t_skill_effect` VALUES ('100016', '180', '1', '2', '6666', '0', '2', '511001', '', '2', '520', '0', '10101010');
INSERT INTO `t_skill_effect` VALUES ('100017', '181', '1', '15', '0', '0', '2', '514002', '', '1', '8', '1', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100018', '182', '1', '16', '2400', '0', '2', '514002', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100018', '183', '1', '28', '2000', '0', '2', '0', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100018', '184', '1', '18', '2000', '0', '2', '0', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100019', '185', '1', '5', '5000', '0', '2', '511006', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100020', '186', '1', '1', '26086', '0', '0', '0', '', '0', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100021', '187', '1', '16', '2400', '0', '2', '511013', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100022', '188', '1', '1', '30000', '0', '0', '0', '', '0', '520', '1', '10111011');
INSERT INTO `t_skill_effect` VALUES ('100023', '189', '1', '1', '16667', '0', '0', '0', '', '0', '520', '0', '20202020');
INSERT INTO `t_skill_effect` VALUES ('100024', '190', '1', '1', '18000', '0', '0', '0', '', '0', '520', '0', '00010000');
INSERT INTO `t_skill_effect` VALUES ('100024', '191', '1', '2', '6000', '0', '2', '516001', '', '2', '520', '0', '00010000');
INSERT INTO `t_skill_effect` VALUES ('100024', '192', '1', '3', '-5000', '0', '2', '0', '', '2', '520', '0', '00010000');
INSERT INTO `t_skill_effect` VALUES ('100025', '193', '1', '8', '10000', '0', '2', '511013', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100026', '194', '1', '8', '5000', '0', '2', '511013', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100026', '195', '1', '11', '1200', '0', '2', '0', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('100027', '196', '1', '1', '20000', '0', '0', '0', '', '0', '520', '0', '00222000');
INSERT INTO `t_skill_effect` VALUES ('100027', '197', '1', '15', '0', '0', '2', '516001', '', '1', '0', '0', '');
INSERT INTO `t_skill_effect` VALUES ('100027', '198', '1', '8', '-2780', '0', '0', '0', '', '2', '0', '0', '');
INSERT INTO `t_skill_effect` VALUES ('900001', '199', '1', '1', '0', '0', '0', '0', '', '0', '520', '0', '00000001');
INSERT INTO `t_skill_effect` VALUES ('900002', '200', '1', '1', '30000', '0', '0', '0', '', '0', '520', '0', '00000001');
INSERT INTO `t_skill_effect` VALUES ('900003', '201', '1', '1', '30000', '0', '0', '0', '', '0', '520', '0', '00000001');
INSERT INTO `t_skill_effect` VALUES ('900004', '202', '1', '1', '0', '0', '0', '0', '', '0', '520', '0', '10000011');
INSERT INTO `t_skill_effect` VALUES ('900005', '203', '1', '1', '16667', '0', '0', '0', '', '0', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900006', '204', '1', '1', '0', '0', '0', '0', '', '0', '520', '0', '10000011');
INSERT INTO `t_skill_effect` VALUES ('900007', '205', '1', '1', '16667', '0', '0', '0', '', '0', '520', '0', '20000022');
INSERT INTO `t_skill_effect` VALUES ('900008', '206', '1', '1', '10000', '0', '0', '0', '', '0', '520', '0', '10000011');
INSERT INTO `t_skill_effect` VALUES ('900008', '207', '1', '27', '-1333', '0', '2', '511001', 'tips_019', '2', '520', '0', '10000011');
INSERT INTO `t_skill_effect` VALUES ('900008', '208', '1', '8', '-1780', '0', '2', '0', 'tips_020', '2', '520', '0', '10000011');
INSERT INTO `t_skill_effect` VALUES ('900009', '209', '1', '1', '16667', '0', '0', '0', '', '0', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900010', '210', '1', '4', '8000', '0', '2', '511004', 'tips_037', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900010', '211', '1', '26', '17500', '0', '2', '0', 'tips_023', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900011', '212', '1', '1', '0', '0', '0', '0', '', '0', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900011', '213', '1', '2', '0', '0', '2', '0', '', '2', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900011', '214', '1', '3', '0', '0', '2', '0', '', '2', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900012', '215', '1', '1', '10000', '0', '0', '0', '', '0', '520', '0', '10000011');
INSERT INTO `t_skill_effect` VALUES ('900012', '216', '1', '2', '3333', '0', '2', '514002', '', '2', '520', '0', '10000011');
INSERT INTO `t_skill_effect` VALUES ('900012', '217', '1', '5', '-1111', '0', '2', '0', 'tips_009', '2', '520', '0', '10000011');
INSERT INTO `t_skill_effect` VALUES ('900013', '218', '1', '1', '16667', '0', '0', '0', '', '0', '520', '0', '30000033');
INSERT INTO `t_skill_effect` VALUES ('900014', '219', '1', '1', '0', '0', '0', '0', '', '0', '8', '2', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900015', '220', '1', '3', '5000', '0', '2', '511002', 'tips_029', '2', '3', '1', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900016', '221', '1', '1', '0', '0', '0', '0', '', '0', '520', '1', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900017', '222', '1', '10', '6000', '0', '0', '0', '', '0', '515', '1', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900018', '223', '1', '1', '1667', '0', '0', '0', '', '0', '520', '0', '10101010');
INSERT INTO `t_skill_effect` VALUES ('900019', '224', '1', '27', '6000', '0', '2', '511007', 'tips_026', '2', '3', '1', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900020', '225', '1', '10', '4615', '0', '0', '0', '', '0', '3', '2', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900021', '226', '1', '19', '0', '0', '2', '0', '', '2', '3', '1', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900022', '227', '1', '10', '0', '0', '0', '0', '', '0', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900023', '228', '1', '1', '0', '0', '0', '0', '', '0', '8', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900023', '229', '1', '2', '0', '0', '2', '0', '', '2', '8', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900024', '230', '1', '1', '0', '0', '0', '0', '', '0', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900024', '231', '1', '2', '0', '0', '2', '0', '', '2', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900024', '232', '1', '3', '0', '0', '2', '0', '', '2', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900025', '233', '1', '2', '0', '0', '2', '0', '', '2', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900025', '234', '1', '8', '0', '0', '2', '0', '', '2', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900026', '235', '1', '1', '0', '0', '0', '0', '', '0', '520', '0', '10101010');
INSERT INTO `t_skill_effect` VALUES ('900027', '236', '1', '1', '0', '0', '0', '0', '', '0', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900028', '237', '1', '8', '0', '0', '2', '0', '', '2', '3', '1', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900028', '238', '1', '10', '0', '0', '0', '0', '', '0', '3', '1', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900029', '239', '1', '1', '0', '0', '0', '0', '', '0', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900029', '240', '1', '2', '0', '0', '2', '0', '', '2', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900029', '241', '1', '3', '0', '0', '2', '0', '', '2', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900030', '242', '1', '1', '0', '0', '0', '0', '', '0', '520', '1', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900030', '243', '1', '8', '0', '0', '2', '0', '', '2', '520', '1', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900030', '244', '1', '15', '0', '0', '2', '0', '', '2', '520', '1', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900031', '245', '1', '10', '0', '0', '0', '0', '', '0', '3', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900032', '246', '1', '1', '13043', '0', '0', '0', '', '0', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900033', '247', '1', '1', '13043', '0', '0', '0', '', '0', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900034', '248', '1', '1', '13043', '0', '0', '0', '', '0', '8', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900035', '249', '1', '1', '0', '0', '0', '0', '', '0', '8', '1', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900036', '250', '1', '10', '0', '0', '0', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900037', '251', '1', '8', '0', '0', '2', '0', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900038', '252', '1', '1', '0', '0', '0', '0', '', '0', '520', '0', '00000001');
INSERT INTO `t_skill_effect` VALUES ('900038', '253', '1', '10', '0', '0', '0', '0', '', '0', '513', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900039', '254', '1', '3', '0', '0', '2', '0', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900039', '255', '1', '10', '0', '0', '0', '0', '', '0', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900040', '256', '1', '1', '0', '0', '0', '0', '', '0', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900040', '257', '1', '17', '0', '1', '0', '0', '', '0', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900041', '258', '1', '1', '0', '0', '0', '0', '', '0', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900041', '259', '1', '8', '0', '0', '2', '0', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900042', '260', '1', '2', '0', '0', '2', '0', '', '2', '520', '1', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900042', '261', '1', '15', '0', '0', '2', '0', '', '2', '520', '1', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900042', '262', '1', '18', '0', '0', '2', '0', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900042', '263', '1', '28', '0', '0', '2', '0', '', '2', '1', '0', '00000000');
INSERT INTO `t_skill_effect` VALUES ('900043', '264', '1', '1', '0', '0', '0', '0', '', '0', '520', '0', '10111011');
INSERT INTO `t_skill_effect` VALUES ('900043', '265', '1', '8', '0', '0', '2', '0', '', '2', '1', '0', '00000000');

-- ----------------------------
-- Table structure for t_sum_signin
-- ----------------------------
DROP TABLE IF EXISTS `t_sum_signin`;
CREATE TABLE `t_sum_signin` (
  `day_num` int(11) NOT NULL COMMENT '累计天数',
  `goods_id` int(11) NOT NULL COMMENT '物品id',
  `type` int(11) NOT NULL COMMENT '物品类型',
  `num` int(11) NOT NULL COMMENT '数量',
  `level` int(11) NOT NULL COMMENT '物品等级'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sum_signin
-- ----------------------------
INSERT INTO `t_sum_signin` VALUES ('7', '82005', '1', '1', '0');
INSERT INTO `t_sum_signin` VALUES ('7', '0', '2', '5000', '0');
INSERT INTO `t_sum_signin` VALUES ('7', '0', '3', '50', '0');
INSERT INTO `t_sum_signin` VALUES ('14', '82005', '1', '1', '0');
INSERT INTO `t_sum_signin` VALUES ('14', '0', '2', '10000', '0');
INSERT INTO `t_sum_signin` VALUES ('14', '0', '3', '100', '0');
INSERT INTO `t_sum_signin` VALUES ('21', '82005', '1', '1', '0');
INSERT INTO `t_sum_signin` VALUES ('21', '0', '2', '15000', '0');
INSERT INTO `t_sum_signin` VALUES ('21', '0', '3', '150', '0');
INSERT INTO `t_sum_signin` VALUES ('28', '82005', '1', '1', '0');
INSERT INTO `t_sum_signin` VALUES ('28', '0', '2', '20000', '0');
INSERT INTO `t_sum_signin` VALUES ('28', '0', '3', '200', '0');

-- ----------------------------
-- Table structure for t_task_action_setting
-- ----------------------------
DROP TABLE IF EXISTS `t_task_action_setting`;
CREATE TABLE `t_task_action_setting` (
  `id` varchar(50) NOT NULL COMMENT '行为id',
  `description` varchar(50) NOT NULL COMMENT '描述',
  `goalValue` varchar(50) NOT NULL COMMENT '目标值',
  `teskName` varchar(50) NOT NULL COMMENT '提示框标题',
  `event` varchar(50) NOT NULL COMMENT '感兴趣的事件',
  `eventCondition` varchar(50) NOT NULL COMMENT '事件筛选',
  `prepareMethod` varchar(50) NOT NULL COMMENT '执行一个方法获取变化值(优先级一)',
  `methodParams` varchar(50) NOT NULL COMMENT '方法参数',
  `field` varchar(50) NOT NULL COMMENT '取事件中的值作为变化值(优先级二)',
  `dealautValue` varchar(50) NOT NULL COMMENT '收到事件后默认变化值(优先级三)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task_action_setting
-- ----------------------------
INSERT INTO `t_task_action_setting` VALUES ('1', '升级英雄5次', '5', '升级英雄', 'HERO_LEVELUP', '', '', '[]', 'count', '1');
INSERT INTO `t_task_action_setting` VALUES ('2', '通关普通关卡10次', '10', '通关关卡', 'PASS_BATTLE', 'zoneType==1', '', '[]', 'count', '1');
INSERT INTO `t_task_action_setting` VALUES ('3', '参与竞技场3次', '3', '参与竞技场', 'ARENA_FIGHT', '', '', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('4', '参与武道大会1次', '1', '参与武道大会', 'MARTIALWAY_FIGHT', '', '', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('5', '升级装备5次', '5', '升级装备', 'LEVELUP_EQUIP', '', '', '[]', 'count', '1');
INSERT INTO `t_task_action_setting` VALUES ('6', '金币召唤3次', '3', '金币召唤', 'CALL_HERO', 'type==1||type==3', '', '[]', 'count', '1');
INSERT INTO `t_task_action_setting` VALUES ('7', '钻石召唤1次', '1', '钻石召唤', 'CALL_HERO', 'type==2||type==4', '', '[]', 'count', '1');
INSERT INTO `t_task_action_setting` VALUES ('8', '提升队伍等级1级', '1', '提升队伍', 'PLAYER_UPLEVEL', '', '', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('9', '获得任意3个英雄', '3', '获得英雄', 'REWARD_HERO', '', '', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('10', '获得任意5个道具', '5', '获得道具', 'ADD_ITEM', '', '', '[]', 'num', '1');
INSERT INTO `t_task_action_setting` VALUES ('11', '通关第一章第一小关1次', '1', '通关关卡', 'PASS_BATTLE', 'battleId==71001001||zoneType==1', '', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('12', '通关第一章第三大关1次', '1', '通关关卡', 'PASS_BATTLE', 'battleId==71001003||zoneType==1', '', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('13', '第一章获得总计3星', '3', '通关关卡', 'PASS_BATTLE', 'zoneType==1', 'GET_ZONE_STAR', '[1001]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('14', '第一章获得总计6星', '6', '通关关卡', 'PASS_BATTLE', 'zoneType==1', 'GET_ZONE_STAR', '[1001]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('15', '在竞技场累积战斗5次', '5', '参与竞技场', 'ARENA_FIGHT', '', 'ARENAFIGHT_COUNT', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('16', '在武道大会累积比武5次', '5', '参与武道大会', 'MARTIALWAY_FIGHT', '', 'MARTIALWAY_FIGHTCOUNT', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('17', '强化任意1件装备达到10级', '1', '升级装备', 'LEVELUP_EQUIP', 'level>=10', '', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('18', '强化装备累积达到20次', '20', '升级装备', 'LEVELUP_EQUIP', '', 'EQUIP_LEVELUP_TIMES', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('19', '提升队伍等级达到10级', '10', '提升队伍', 'PLAYER_UPLEVEL', '', 'GET_PLAYERLEVEL', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('20', '提升任意伙伴等级达到20级', '1', '提升伙伴', 'HERO_LEVELUP', 'level>=20', '', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('21', '拥有2星伙伴数量达到5个', '5', '获得伙伴', 'REWARD_HERO', '', 'GET_HERO_BYQUALITY', '[2]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('22', '拥有3星伙伴数量达到5个', '5', '获得伙伴', 'REWARD_HERO', '', 'GET_HERO_BYQUALITY', '[3]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('23', '拥有4星伙伴数量达到5个', '5', '获得伙伴', 'REWARD_HERO', '', 'GET_HERO_BYQUALITY', '[4]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('24', '拥有5星伙伴数量达到5个', '5', '获得伙伴', 'REWARD_HERO', '', 'GET_HERO_BYQUALITY', '[5]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('25', '获得道具累积达到5件', '5', '获得道具', 'ADD_ITEM', '', 'ADDITEM_COUNT', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('26', '通关第一章第四小关1次', '1', '通关关卡', 'PASS_BATTLE', 'battleId==71001004||zoneType==1', '', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('27', '通关第一章第六大关1次', '1', '通关关卡', 'PASS_BATTLE', 'battleId==71001006||zoneType==1', '', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('28', '第一章获得总计9星', '9', '通关关卡', 'PASS_BATTLE', 'zoneType==1', 'GET_ZONE_STAR', '[1001]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('29', '第二章获得总计3星', '3', '通关关卡', 'PASS_BATTLE', 'zoneType==1', 'GET_ZONE_STAR', '[1002]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('30', '在竞技场累积战斗10次', '10', '参与竞技场', 'ARENA_FIGHT', '', 'ARENAFIGHT_COUNT', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('31', '在武道大会累积比武10次', '10', '参与武道大会', 'MARTIALWAY_FIGHT', '', 'MARTIALWAY_FIGHTCOUNT', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('32', '强化任意1件装备达到20级', '1', '升级装备', 'LEVELUP_EQUIP', 'level>=20', '', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('33', '强化装备累积达到30次', '20', '升级装备', 'LEVELUP_EQUIP', '', 'EQUIP_LEVELUP_TIMES', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('34', '提升队伍等级达到22级', '22', '提升队伍', 'PLAYER_UPLEVEL', '', 'GET_PLAYERLEVEL', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('35', '提升任意伙伴等级达到25级', '1', '提升伙伴', 'HERO_LEVELUP', 'level>=25', '', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('36', '拥有2星伙伴数量达到10个', '10', '获得伙伴', 'REWARD_HERO', '', 'GET_HERO_BYQUALITY', '[2]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('37', '拥有3星伙伴数量达到10个', '10', '获得伙伴', 'REWARD_HERO', '', 'GET_HERO_BYQUALITY', '[3]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('38', '拥有4星伙伴数量达到10个', '10', '获得伙伴', 'REWARD_HERO', '', 'GET_HERO_BYQUALITY', '[4]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('39', '拥有5星伙伴数量达到10个', '10', '获得伙伴', 'REWARD_HERO', '', 'GET_HERO_BYQUALITY', '[5]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('40', '获得道具累积达到10件', '10', '获得道具', 'ADD_ITEM', '', 'ADDITEM_COUNT', '[]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('41', 'vip1特权:领取扫荡券', '1', '领取扫荡券', 'VIPLEVEL_UP', '', 'IS_VIPUSER', '[1]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('42', 'vip2特权:领取扫荡券', '1', '领取扫荡券', 'VIPLEVEL_UP', '', 'IS_VIPUSER', '[2]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('43', 'vip3特权:领取扫荡券', '1', '领取扫荡券', 'VIPLEVEL_UP', '', 'IS_VIPUSER', '[3]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('44', 'vip4特权:领取扫荡券', '1', '领取扫荡券', 'VIPLEVEL_UP', '', 'IS_VIPUSER', '[4]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('45', 'vip5特权:领取扫荡券', '1', '领取扫荡券', 'VIPLEVEL_UP', '', 'IS_VIPUSER', '[5]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('46', 'vip6特权:领取扫荡券', '1', '领取扫荡券', 'VIPLEVEL_UP', '', 'IS_VIPUSER', '[6]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('47', 'vip7特权:领取扫荡券', '1', '领取扫荡券', 'VIPLEVEL_UP', '', 'IS_VIPUSER', '[7]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('48', 'vip8特权:领取扫荡券', '1', '领取扫荡券', 'VIPLEVEL_UP', '', 'IS_VIPUSER', '[8]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('49', 'vip9特权:领取扫荡券', '1', '领取扫荡券', 'VIPLEVEL_UP', '', 'IS_VIPUSER', '[9]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('50', 'vip10特权:领取扫荡券', '1', '领取扫荡券', 'VIPLEVEL_UP', '', 'IS_VIPUSER', '[10]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('51', 'vip11特权:领取扫荡券', '1', '领取扫荡券', 'VIPLEVEL_UP', '', 'IS_VIPUSER', '[11]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('52', 'vip12特权:领取扫荡券', '1', '领取扫荡券', 'VIPLEVEL_UP', '', 'IS_VIPUSER', '[12]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('53', 'vip13特权:领取扫荡券', '1', '领取扫荡券', 'VIPLEVEL_UP', '', 'IS_VIPUSER', '[13]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('54', 'vip14特权:领取扫荡券', '1', '领取扫荡券', 'VIPLEVEL_UP', '', 'IS_VIPUSER', '[14]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('55', 'vip15特权:领取扫荡券', '1', '领取扫荡券', 'VIPLEVEL_UP', '', 'IS_VIPUSER', '[15]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('56', '购买月卡，每天领取大量钻石', '1', '领取月卡奖励', 'BUY_CYCLECARD', '', 'IS_CYCLECARDUSER', '[7]', '', '1');
INSERT INTO `t_task_action_setting` VALUES ('57', '购买周卡，每天领取少量钻石', '1', '领取周卡奖励', 'BUY_CYCLECARD', '', 'IS_CYCLECARDUSER', '[8]', '', '1');

-- ----------------------------
-- Table structure for t_task_box_reward
-- ----------------------------
DROP TABLE IF EXISTS `t_task_box_reward`;
CREATE TABLE `t_task_box_reward` (
  `id` varchar(50) NOT NULL COMMENT '主键id',
  `active` varchar(50) NOT NULL COMMENT '需要活跃度',
  `goods_id` varchar(50) NOT NULL COMMENT '物品id',
  `type` varchar(50) NOT NULL COMMENT '类型',
  `num` varchar(50) NOT NULL COMMENT '数量',
  `level` varchar(50) NOT NULL COMMENT '等级'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task_box_reward
-- ----------------------------
INSERT INTO `t_task_box_reward` VALUES ('1', '30', '82005', '1', '1', '0');
INSERT INTO `t_task_box_reward` VALUES ('2', '30', '0', '2', '5000', '0');
INSERT INTO `t_task_box_reward` VALUES ('3', '30', '0', '3', '50', '0');
INSERT INTO `t_task_box_reward` VALUES ('4', '60', '82005', '1', '1', '0');
INSERT INTO `t_task_box_reward` VALUES ('5', '60', '0', '2', '10000', '0');
INSERT INTO `t_task_box_reward` VALUES ('6', '60', '0', '3', '100', '0');
INSERT INTO `t_task_box_reward` VALUES ('7', '90', '82005', '1', '1', '0');
INSERT INTO `t_task_box_reward` VALUES ('8', '90', '0', '2', '15000', '0');
INSERT INTO `t_task_box_reward` VALUES ('9', '90', '0', '3', '150', '0');
INSERT INTO `t_task_box_reward` VALUES ('10', '120', '82005', '1', '1', '0');
INSERT INTO `t_task_box_reward` VALUES ('11', '120', '0', '2', '20000', '0');
INSERT INTO `t_task_box_reward` VALUES ('12', '120', '0', '3', '200', '0');
INSERT INTO `t_task_box_reward` VALUES ('13', '150', '82005', '1', '1', '0');
INSERT INTO `t_task_box_reward` VALUES ('14', '150', '0', '2', '40000', '0');
INSERT INTO `t_task_box_reward` VALUES ('15', '150', '0', '3', '400', '0');

-- ----------------------------
-- Table structure for t_task_reward
-- ----------------------------
DROP TABLE IF EXISTS `t_task_reward`;
CREATE TABLE `t_task_reward` (
  `id` varchar(50) NOT NULL COMMENT '主键id',
  `taskId` varchar(50) NOT NULL COMMENT '任务id',
  `goods_id` varchar(50) NOT NULL COMMENT '物品id',
  `type` varchar(50) NOT NULL COMMENT '类型',
  `num` varchar(50) NOT NULL COMMENT '数量',
  `level` varchar(50) NOT NULL COMMENT '等级'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task_reward
-- ----------------------------
INSERT INTO `t_task_reward` VALUES ('1', '1001', '0', '2', '900', '0');
INSERT INTO `t_task_reward` VALUES ('2', '1001', '0', '3', '900', '0');
INSERT INTO `t_task_reward` VALUES ('3', '1002', '82003', '1', '1', '1');
INSERT INTO `t_task_reward` VALUES ('4', '1002', '0', '2', '900', '0');
INSERT INTO `t_task_reward` VALUES ('5', '1003', '82003', '1', '1', '1');
INSERT INTO `t_task_reward` VALUES ('6', '1003', '0', '3', '900', '0');
INSERT INTO `t_task_reward` VALUES ('7', '1004', '82005', '1', '1', '1');
INSERT INTO `t_task_reward` VALUES ('8', '1004', '82003', '1', '1', '1');
INSERT INTO `t_task_reward` VALUES ('9', '1005', '82005', '1', '1', '1');
INSERT INTO `t_task_reward` VALUES ('10', '1005', '82003', '1', '1', '0');
INSERT INTO `t_task_reward` VALUES ('11', '1006', '0', '8', '99999', '0');
INSERT INTO `t_task_reward` VALUES ('12', '1007', '0', '9', '99999', '0');
INSERT INTO `t_task_reward` VALUES ('13', '1008', '82004', '1', '1', '1');
INSERT INTO `t_task_reward` VALUES ('14', '1009', '82003', '1', '1', '1');
INSERT INTO `t_task_reward` VALUES ('15', '1010', '82003', '1', '1', '0');
INSERT INTO `t_task_reward` VALUES ('16', '1011', '0', '10', '6', '0');
INSERT INTO `t_task_reward` VALUES ('17', '1012', '0', '10', '6', '0');
INSERT INTO `t_task_reward` VALUES ('18', '1013', '0', '10', '6', '0');
INSERT INTO `t_task_reward` VALUES ('19', '1014', '0', '10', '6', '0');
INSERT INTO `t_task_reward` VALUES ('20', '1015', '0', '10', '6', '0');
INSERT INTO `t_task_reward` VALUES ('21', '1016', '0', '10', '6', '0');
INSERT INTO `t_task_reward` VALUES ('22', '1017', '0', '10', '6', '0');
INSERT INTO `t_task_reward` VALUES ('23', '1018', '0', '10', '6', '0');
INSERT INTO `t_task_reward` VALUES ('24', '1019', '0', '10', '6', '0');
INSERT INTO `t_task_reward` VALUES ('25', '1020', '0', '10', '6', '0');
INSERT INTO `t_task_reward` VALUES ('26', '1021', '0', '10', '6', '0');
INSERT INTO `t_task_reward` VALUES ('27', '1022', '0', '10', '6', '0');
INSERT INTO `t_task_reward` VALUES ('28', '1023', '0', '10', '6', '0');
INSERT INTO `t_task_reward` VALUES ('29', '1024', '0', '10', '6', '0');
INSERT INTO `t_task_reward` VALUES ('30', '1025', '0', '10', '6', '0');
INSERT INTO `t_task_reward` VALUES ('31', '1026', '0', '10', '13', '0');
INSERT INTO `t_task_reward` VALUES ('32', '1027', '0', '10', '13', '0');
INSERT INTO `t_task_reward` VALUES ('33', '1028', '0', '10', '13', '0');
INSERT INTO `t_task_reward` VALUES ('34', '1029', '0', '10', '13', '0');
INSERT INTO `t_task_reward` VALUES ('35', '1030', '0', '10', '13', '0');
INSERT INTO `t_task_reward` VALUES ('36', '1031', '0', '10', '13', '0');
INSERT INTO `t_task_reward` VALUES ('37', '1032', '0', '10', '13', '0');
INSERT INTO `t_task_reward` VALUES ('38', '1033', '0', '10', '13', '0');
INSERT INTO `t_task_reward` VALUES ('39', '1034', '0', '10', '13', '0');
INSERT INTO `t_task_reward` VALUES ('40', '1035', '0', '10', '13', '0');
INSERT INTO `t_task_reward` VALUES ('41', '1036', '0', '10', '13', '0');
INSERT INTO `t_task_reward` VALUES ('42', '1037', '0', '10', '13', '0');
INSERT INTO `t_task_reward` VALUES ('43', '1038', '0', '10', '13', '0');
INSERT INTO `t_task_reward` VALUES ('44', '1039', '0', '10', '13', '0');
INSERT INTO `t_task_reward` VALUES ('45', '1040', '0', '10', '999999', '0');
INSERT INTO `t_task_reward` VALUES ('46', '1041', '4020012', '4', '10', '0');
INSERT INTO `t_task_reward` VALUES ('47', '1042', '4020012', '4', '20', '0');
INSERT INTO `t_task_reward` VALUES ('48', '1043', '4020012', '4', '30', '0');
INSERT INTO `t_task_reward` VALUES ('49', '1044', '4020012', '4', '40', '0');
INSERT INTO `t_task_reward` VALUES ('50', '1045', '4020012', '4', '50', '0');
INSERT INTO `t_task_reward` VALUES ('51', '1046', '4020012', '4', '60', '0');
INSERT INTO `t_task_reward` VALUES ('52', '1047', '4020012', '4', '70', '0');
INSERT INTO `t_task_reward` VALUES ('53', '1048', '4020012', '4', '80', '0');
INSERT INTO `t_task_reward` VALUES ('54', '1049', '4020012', '4', '90', '0');
INSERT INTO `t_task_reward` VALUES ('55', '1050', '4020012', '4', '100', '0');
INSERT INTO `t_task_reward` VALUES ('56', '1051', '4020012', '4', '110', '0');
INSERT INTO `t_task_reward` VALUES ('57', '1052', '4020012', '4', '120', '0');
INSERT INTO `t_task_reward` VALUES ('58', '1053', '4020012', '4', '130', '0');
INSERT INTO `t_task_reward` VALUES ('59', '1054', '4020012', '4', '140', '0');
INSERT INTO `t_task_reward` VALUES ('60', '1055', '4020012', '4', '150', '0');
INSERT INTO `t_task_reward` VALUES ('61', '1056', '0', '3', '120', '0');
INSERT INTO `t_task_reward` VALUES ('62', '1057', '0', '3', '80', '0');

-- ----------------------------
-- Table structure for t_task_setting
-- ----------------------------
DROP TABLE IF EXISTS `t_task_setting`;
CREATE TABLE `t_task_setting` (
  `id` varchar(50) NOT NULL COMMENT '任务id',
  `taskType` varchar(50) NOT NULL COMMENT '任务类型',
  `leadTaskId` varchar(50) NOT NULL COMMENT '前置任务(-1表示默认领取)',
  `taskActionList` varchar(50) NOT NULL COMMENT '任务具体行为',
  `distinctId` int(11) NOT NULL COMMENT '排他Id',
  `conditions` varchar(50) NOT NULL COMMENT '领取条件',
  `needPlayerLevel` varchar(50) NOT NULL COMMENT '任务需要玩家等级',
  `needFame` varchar(50) NOT NULL COMMENT '需要名望',
  `rewardActive` varchar(50) NOT NULL COMMENT '奖励活跃度(日常任务特有奖励)',
  `module` varchar(50) NOT NULL COMMENT '前往按钮索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task_setting
-- ----------------------------
INSERT INTO `t_task_setting` VALUES ('1001', 'DAILY_TASK', '-1', '[1]', '0', '', '10', '0', '20', 'UpGrade');
INSERT INTO `t_task_setting` VALUES ('1002', 'DAILY_TASK', '-1', '[2]', '0', '', '10', '0', '20', 'Zone');
INSERT INTO `t_task_setting` VALUES ('1003', 'DAILY_TASK', '-1', '[3]', '0', '', '10', '0', '20', 'Athletics');
INSERT INTO `t_task_setting` VALUES ('1004', 'DAILY_TASK', '-1', '[4]', '0', '', '10', '0', '20', 'Athletics');
INSERT INTO `t_task_setting` VALUES ('1005', 'DAILY_TASK', '-1', '[5]', '0', '', '10', '0', '20', 'Equip');
INSERT INTO `t_task_setting` VALUES ('1006', 'DAILY_TASK', '-1', '[6]', '0', '', '20', '0', '10', 'Summon');
INSERT INTO `t_task_setting` VALUES ('1007', 'DAILY_TASK', '-1', '[7]', '0', '', '20', '0', '10', 'Summon');
INSERT INTO `t_task_setting` VALUES ('1008', 'DAILY_TASK', '-1', '[8]', '0', '', '20', '0', '10', 'Zone');
INSERT INTO `t_task_setting` VALUES ('1009', 'DAILY_TASK', '-1', '[9]', '0', '', '20', '0', '10', 'Summon');
INSERT INTO `t_task_setting` VALUES ('1010', 'DAILY_TASK', '-1', '[10]', '0', '', '20', '0', '10', 'Zone');
INSERT INTO `t_task_setting` VALUES ('1011', 'RENOWN_TASK', '-1', '[11]', '0', '', '0', '0', '0', 'Zone');
INSERT INTO `t_task_setting` VALUES ('1012', 'RENOWN_TASK', '-1', '[12]', '0', '', '0', '0', '0', 'Zone');
INSERT INTO `t_task_setting` VALUES ('1013', 'RENOWN_TASK', '-1', '[13]', '0', '', '0', '0', '0', 'Zone');
INSERT INTO `t_task_setting` VALUES ('1014', 'RENOWN_TASK', '-1', '[14]', '0', '', '0', '0', '0', 'Zone');
INSERT INTO `t_task_setting` VALUES ('1015', 'RENOWN_TASK', '-1', '[15]', '0', '', '0', '0', '0', 'Athletics');
INSERT INTO `t_task_setting` VALUES ('1016', 'RENOWN_TASK', '-1', '[16]', '0', '', '0', '0', '0', 'Athletics');
INSERT INTO `t_task_setting` VALUES ('1017', 'RENOWN_TASK', '-1', '[17]', '0', '', '0', '0', '0', 'Equip');
INSERT INTO `t_task_setting` VALUES ('1018', 'RENOWN_TASK', '-1', '[18]', '0', '', '0', '0', '0', 'Equip');
INSERT INTO `t_task_setting` VALUES ('1019', 'RENOWN_TASK', '-1', '[19]', '0', '', '0', '0', '0', 'Zone');
INSERT INTO `t_task_setting` VALUES ('1020', 'RENOWN_TASK', '-1', '[20]', '0', '', '0', '0', '0', 'UpGrade');
INSERT INTO `t_task_setting` VALUES ('1021', 'RENOWN_TASK', '-1', '[21]', '0', '', '0', '0', '0', 'Evo');
INSERT INTO `t_task_setting` VALUES ('1022', 'RENOWN_TASK', '-1', '[22]', '0', '', '0', '0', '0', 'Evo');
INSERT INTO `t_task_setting` VALUES ('1023', 'RENOWN_TASK', '-1', '[23]', '0', '', '0', '0', '0', 'Evo');
INSERT INTO `t_task_setting` VALUES ('1024', 'RENOWN_TASK', '-1', '[24]', '0', '', '0', '0', '0', 'Evo');
INSERT INTO `t_task_setting` VALUES ('1025', 'RENOWN_TASK', '-1', '[25]', '0', '', '0', '0', '0', 'Zone');
INSERT INTO `t_task_setting` VALUES ('1026', 'RENOWN_TASK', '1011', '[26]', '0', '', '0', '1', '0', 'Zone');
INSERT INTO `t_task_setting` VALUES ('1027', 'RENOWN_TASK', '1012', '[27]', '0', '', '0', '1', '0', 'Zone');
INSERT INTO `t_task_setting` VALUES ('1028', 'RENOWN_TASK', '1013', '[28]', '0', '', '0', '1', '0', 'Zone');
INSERT INTO `t_task_setting` VALUES ('1029', 'RENOWN_TASK', '1014', '[29]', '0', '', '0', '1', '0', 'Zone');
INSERT INTO `t_task_setting` VALUES ('1030', 'RENOWN_TASK', '1015', '[30]', '0', '', '0', '1', '0', 'Athletics');
INSERT INTO `t_task_setting` VALUES ('1031', 'RENOWN_TASK', '1016', '[31]', '0', '', '0', '1', '0', 'Athletics');
INSERT INTO `t_task_setting` VALUES ('1032', 'RENOWN_TASK', '1017', '[32]', '0', '', '0', '1', '0', 'Equip');
INSERT INTO `t_task_setting` VALUES ('1033', 'RENOWN_TASK', '1018', '[33]', '0', '', '0', '1', '0', 'Equip');
INSERT INTO `t_task_setting` VALUES ('1034', 'RENOWN_TASK', '1019', '[34]', '0', '', '0', '1', '0', 'Zone');
INSERT INTO `t_task_setting` VALUES ('1035', 'RENOWN_TASK', '1020', '[35]', '0', '', '0', '1', '0', 'UpGrade');
INSERT INTO `t_task_setting` VALUES ('1036', 'RENOWN_TASK', '1021', '[36]', '0', '', '0', '1', '0', 'Evo');
INSERT INTO `t_task_setting` VALUES ('1037', 'RENOWN_TASK', '1022', '[37]', '0', '', '0', '1', '0', 'Evo');
INSERT INTO `t_task_setting` VALUES ('1038', 'RENOWN_TASK', '1023', '[38]', '0', '', '0', '1', '0', 'Evo');
INSERT INTO `t_task_setting` VALUES ('1039', 'RENOWN_TASK', '1024', '[39]', '0', '', '0', '1', '0', 'Evo');
INSERT INTO `t_task_setting` VALUES ('1040', 'RENOWN_TASK', '1025', '[40]', '0', '', '0', '1', '0', 'Zone');
INSERT INTO `t_task_setting` VALUES ('1041', 'DAILY_TASK', '-1', '[41]', '1', 'vipLevel==1', '10', '0', '0', '');
INSERT INTO `t_task_setting` VALUES ('1042', 'DAILY_TASK', '-1', '[42]', '1', 'vipLevel==2', '10', '0', '0', '');
INSERT INTO `t_task_setting` VALUES ('1043', 'DAILY_TASK', '-1', '[43]', '1', 'vipLevel==3', '10', '0', '0', '');
INSERT INTO `t_task_setting` VALUES ('1044', 'DAILY_TASK', '-1', '[44]', '1', 'vipLevel==4', '10', '0', '0', '');
INSERT INTO `t_task_setting` VALUES ('1045', 'DAILY_TASK', '-1', '[45]', '1', 'vipLevel==5', '10', '0', '0', '');
INSERT INTO `t_task_setting` VALUES ('1046', 'DAILY_TASK', '-1', '[46]', '1', 'vipLevel==6', '10', '0', '0', '');
INSERT INTO `t_task_setting` VALUES ('1047', 'DAILY_TASK', '-1', '[47]', '1', 'vipLevel==7', '10', '0', '0', '');
INSERT INTO `t_task_setting` VALUES ('1048', 'DAILY_TASK', '-1', '[48]', '1', 'vipLevel==8', '10', '0', '0', '');
INSERT INTO `t_task_setting` VALUES ('1049', 'DAILY_TASK', '-1', '[49]', '1', 'vipLevel==9', '10', '0', '0', '');
INSERT INTO `t_task_setting` VALUES ('1050', 'DAILY_TASK', '-1', '[50]', '1', 'vipLevel==10', '10', '0', '0', '');
INSERT INTO `t_task_setting` VALUES ('1051', 'DAILY_TASK', '-1', '[51]', '1', 'vipLevel==11', '10', '0', '0', '');
INSERT INTO `t_task_setting` VALUES ('1052', 'DAILY_TASK', '-1', '[52]', '1', 'vipLevel==12', '10', '0', '0', '');
INSERT INTO `t_task_setting` VALUES ('1053', 'DAILY_TASK', '-1', '[53]', '1', 'vipLevel==13', '10', '0', '0', '');
INSERT INTO `t_task_setting` VALUES ('1054', 'DAILY_TASK', '-1', '[54]', '1', 'vipLevel==14', '10', '0', '0', '');
INSERT INTO `t_task_setting` VALUES ('1055', 'DAILY_TASK', '-1', '[55]', '1', 'vipLevel==15', '10', '0', '0', '');
INSERT INTO `t_task_setting` VALUES ('1056', 'DAILY_TASK', '-1', '[56]', '0', '', '10', '0', '0', 'Recharge');
INSERT INTO `t_task_setting` VALUES ('1057', 'DAILY_TASK', '-1', '[57]', '0', '', '10', '0', '0', 'Recharge');

-- ----------------------------
-- Table structure for t_user_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_user_rule`;
CREATE TABLE `t_user_rule` (
  `level` int(11) NOT NULL COMMENT '等级',
  `next_exp` int(11) NOT NULL COMMENT '下一级经验',
  `cost` int(11) NOT NULL COMMENT '领导力',
  `stamina` int(11) NOT NULL COMMENT '精力上限',
  `exp_pool` int(11) NOT NULL COMMENT '经验池上限',
  `eternal_val` int(11) NOT NULL COMMENT '熔炼池上限',
  `equipment_capacity` int(11) NOT NULL COMMENT '装备格子数',
  `hero_capacity` int(11) NOT NULL COMMENT '伙伴格子数',
  `eternal_capacity` int(11) NOT NULL COMMENT '武魂格子数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_rule
-- ----------------------------
INSERT INTO `t_user_rule` VALUES ('1', '50', '50', '100', '310', '11000', '20', '20', '20');
INSERT INTO `t_user_rule` VALUES ('2', '50', '51', '100', '320000', '12000', '20', '20', '20');
INSERT INTO `t_user_rule` VALUES ('3', '50', '52', '100', '330000', '13000', '20', '20', '20');
INSERT INTO `t_user_rule` VALUES ('4', '50', '53', '100', '340000', '14000', '20', '20', '20');
INSERT INTO `t_user_rule` VALUES ('5', '50', '54', '100', '350000', '15000', '25', '25', '25');
INSERT INTO `t_user_rule` VALUES ('6', '50', '55', '100', '360000', '16000', '25', '25', '25');
INSERT INTO `t_user_rule` VALUES ('7', '50', '56', '100', '370000', '17000', '25', '25', '25');
INSERT INTO `t_user_rule` VALUES ('8', '50', '57', '100', '380000', '18000', '25', '25', '25');
INSERT INTO `t_user_rule` VALUES ('9', '50', '58', '100', '390000', '19000', '25', '25', '25');
INSERT INTO `t_user_rule` VALUES ('10', '100', '59', '100', '400000', '20000', '30', '30', '30');
INSERT INTO `t_user_rule` VALUES ('11', '100', '60', '100', '410000', '21000', '30', '30', '30');
INSERT INTO `t_user_rule` VALUES ('12', '100', '61', '100', '420000', '22000', '30', '30', '30');
INSERT INTO `t_user_rule` VALUES ('13', '100', '62', '100', '430000', '23000', '30', '30', '30');
INSERT INTO `t_user_rule` VALUES ('14', '100', '63', '100', '440000', '24000', '30', '30', '30');
INSERT INTO `t_user_rule` VALUES ('15', '100', '64', '100', '450000', '25000', '30', '30', '30');
INSERT INTO `t_user_rule` VALUES ('16', '100', '65', '100', '460000', '26000', '30', '30', '30');
INSERT INTO `t_user_rule` VALUES ('17', '100', '66', '100', '470000', '27000', '30', '30', '30');
INSERT INTO `t_user_rule` VALUES ('18', '100', '67', '100', '480000', '28000', '30', '30', '30');
INSERT INTO `t_user_rule` VALUES ('19', '550', '68', '100', '490000', '29000', '30', '30', '30');
INSERT INTO `t_user_rule` VALUES ('20', '550', '69', '100', '500000', '30000', '35', '35', '35');
INSERT INTO `t_user_rule` VALUES ('21', '550', '70', '100', '510000', '510000', '35', '35', '35');
INSERT INTO `t_user_rule` VALUES ('22', '550', '71', '100', '520000', '520000', '35', '35', '35');
INSERT INTO `t_user_rule` VALUES ('23', '550', '72', '100', '530000', '530000', '35', '35', '35');
INSERT INTO `t_user_rule` VALUES ('24', '550', '73', '100', '540000', '540000', '35', '35', '35');
INSERT INTO `t_user_rule` VALUES ('25', '550', '74', '100', '550000', '550000', '35', '35', '35');
INSERT INTO `t_user_rule` VALUES ('26', '550', '75', '100', '560000', '560000', '35', '35', '35');
INSERT INTO `t_user_rule` VALUES ('27', '550', '76', '100', '570000', '570000', '35', '35', '35');
INSERT INTO `t_user_rule` VALUES ('28', '1050', '77', '100', '580000', '580000', '35', '35', '35');
INSERT INTO `t_user_rule` VALUES ('29', '1050', '78', '100', '590000', '590000', '35', '35', '35');
INSERT INTO `t_user_rule` VALUES ('30', '1050', '79', '100', '600000', '600000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('31', '1050', '80', '100', '610000', '610000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('32', '1050', '80', '100', '620000', '620000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('33', '1050', '80', '100', '630000', '630000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('34', '2100', '80', '100', '640000', '640000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('35', '2100', '80', '100', '650000', '650000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('36', '2100', '80', '100', '660000', '660000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('37', '2100', '81', '100', '670000', '670000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('38', '2100', '82', '100', '680000', '680000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('39', '3000', '83', '100', '690000', '690000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('40', '3000', '84', '100', '700000', '700000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('41', '3000', '85', '100', '710000', '710000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('42', '3000', '86', '100', '720000', '720000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('43', '3000', '87', '100', '730000', '730000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('44', '3000', '88', '100', '740000', '740000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('45', '3000', '89', '100', '750000', '750000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('46', '3000', '90', '100', '760000', '760000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('47', '3000', '91', '100', '770000', '770000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('48', '3000', '92', '100', '780000', '780000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('49', '9000', '93', '100', '790000', '790000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('50', '14400', '94', '100', '800000', '800000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('51', '14400', '95', '100', '810000', '810000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('52', '14400', '95', '100', '820000', '820000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('53', '14400', '95', '100', '830000', '830000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('54', '14400', '95', '100', '840000', '840000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('55', '14400', '95', '100', '850000', '850000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('56', '14400', '95', '100', '860000', '860000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('57', '14400', '97', '100', '870000', '870000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('58', '14400', '99', '100', '880000', '880000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('59', '14400', '101', '100', '890000', '890000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('60', '14400', '103', '100', '900000', '900000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('61', '14400', '105', '100', '910000', '910000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('62', '14400', '106', '100', '920000', '920000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('63', '14400', '107', '100', '930000', '930000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('64', '14400', '108', '100', '940000', '940000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('65', '14400', '109', '100', '950000', '950000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('66', '14400', '110', '100', '960000', '960000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('67', '14400', '111', '100', '970000', '970000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('68', '14400', '112', '100', '980000', '980000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('69', '14400', '113', '100', '990000', '990000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('70', '28800', '114', '100', '1000000', '1000000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('71', '28800', '115', '100', '1010000', '1010000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('72', '28800', '115', '100', '1020000', '1020000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('73', '28800', '115', '100', '1030000', '1030000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('74', '28800', '115', '100', '1040000', '1040000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('75', '28800', '115', '100', '1050000', '1050000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('76', '28800', '115', '100', '1060000', '1060000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('77', '28800', '117', '100', '1070000', '1070000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('78', '28800', '119', '100', '1080000', '1080000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('79', '28800', '121', '100', '1090000', '1090000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('80', '28800', '123', '100', '1100000', '1100000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('81', '28800', '125', '100', '1110000', '1110000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('82', '28800', '126', '100', '1120000', '1120000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('83', '28800', '127', '100', '1130000', '1130000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('84', '28800', '128', '100', '1140000', '1140000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('85', '28800', '129', '100', '1150000', '1150000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('86', '28800', '130', '100', '1160000', '1160000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('87', '28800', '131', '100', '1170000', '1170000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('88', '28800', '132', '100', '1180000', '1180000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('89', '28800', '133', '100', '1190000', '1190000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('90', '28800', '134', '100', '1200000', '1200000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('91', '57600', '135', '100', '1210000', '1210000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('92', '57600', '135', '100', '1220000', '1220000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('93', '57600', '135', '100', '1230000', '1230000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('94', '57600', '135', '100', '1240000', '1240000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('95', '57600', '135', '100', '1250000', '1250000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('96', '57600', '135', '100', '1260000', '1260000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('97', '57600', '137', '100', '1270000', '1270000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('98', '57600', '139', '100', '1280000', '1280000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('99', '57600', '141', '100', '1290000', '1290000', '40', '40', '40');
INSERT INTO `t_user_rule` VALUES ('100', '57600', '143', '100', '1300000', '1300000', '40', '40', '40');

-- ----------------------------
-- Table structure for t_vip_config
-- ----------------------------
DROP TABLE IF EXISTS `t_vip_config`;
CREATE TABLE `t_vip_config` (
  `n_vipLevel` int(11) NOT NULL COMMENT 'vip等级',
  `n_money` int(11) NOT NULL COMMENT '充值钻石',
  `n_privileges` varchar(512) NOT NULL COMMENT '特权',
  `n_tips` varchar(1024) NOT NULL COMMENT '描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_vip_config
-- ----------------------------
INSERT INTO `t_vip_config` VALUES ('0', '0', '1=2&2=3&3=0&4=0&5=0&6=0&7=0&8=0&9=5&10=0&11=2&12=2&13=2&14=5&15=1&16=0&17=0', '');
INSERT INTO `t_vip_config` VALUES ('1', '60', '1=3&2=5&3=0&4=0&5=0&6=0&7=1000&8=1000&9=5&10=7&11=3&12=3&13=3&14=6&15=1&16=4020012_10&17=0', '10&,1,2,7,8,16');
INSERT INTO `t_vip_config` VALUES ('2', '300', '1=4&2=7&3=0&4=0&5=0&6=5&7=5000&8=5000&9=5&10=7&11=4&12=4&13=4&14=7&15=1&16=4020012_20&17=1', '17&,1,2,6,7,8,16');
INSERT INTO `t_vip_config` VALUES ('3', '600', '1=5&2=9&3=1&4=1&5=1&6=10&7=10000&8=10000&9=5&10=14&11=5&12=5&13=5&14=8&15=1&16=4020012_30&17=1', '10&,1,2,3,4,5,6,7,8,16');
INSERT INTO `t_vip_config` VALUES ('4', '1000', '1=6&2=12&3=2&4=2&5=2&6=15&7=15000&8=15000&9=5&10=14&11=6&12=6&13=6&14=9&15=1&16=4020012_40&17=1', '1,2,3,4,5,6,7,8,16');
INSERT INTO `t_vip_config` VALUES ('5', '2000', '1=7&2=16&3=3&4=3&5=3&6=20&7=20000&8=20000&9=10&10=21&11=7&12=7&13=7&14=10&15=5&16=4020012_50&17=1', '10&,1,2,3,4,5,6,7,8,9,15,16');
INSERT INTO `t_vip_config` VALUES ('6', '5000', '1=8&2=20&3=4&4=4&5=4&6=25&7=30000&8=30000&9=11&10=21&11=8&12=8&13=8&14=11&15=6&16=4020012_60&17=1', '1,2,3,4,5,6,7,8,9,15,16');
INSERT INTO `t_vip_config` VALUES ('7', '7000', '1=9&2=25&3=5&4=5&5=5&6=30&7=50000&8=50000&9=12&10=30&11=9&12=9&13=9&14=12&15=7&16=4020012_70&17=1', '10&,1,2,3,4,5,6,7,8,9,15,16');
INSERT INTO `t_vip_config` VALUES ('8', '10000', '1=10&2=30&3=6&4=6&5=6&6=35&7=70000&8=70000&9=13&10=30&11=10&12=10&13=10&14=13&15=8&16=4020012_80&17=1', '1,2,3,4,5,6,7,8,9,15,16');
INSERT INTO `t_vip_config` VALUES ('9', '20000', '1=11&2=35&3=7&4=7&5=7&6=40&7=100000&8=100000&9=14&10=30&11=11&12=11&13=11&14=14&15=9&16=4020012_90&17=1', '1,2,3,4,5,6,7,8,9,15,16');
INSERT INTO `t_vip_config` VALUES ('10', '50000', '1=12&2=40&3=8&4=8&5=8&6=45&7=200000&8=200000&9=15&10=30&11=12&12=12&13=12&14=15&15=10&16=4020012_100&17=1', '1,2,3,4,5,6,7,8,9,15,16');
INSERT INTO `t_vip_config` VALUES ('11', '70000', '1=13&2=50&3=9&4=9&5=9&6=50&7=300000&8=300000&9=16&10=30&11=13&12=13&13=13&14=16&15=11&16=4020012_110&17=1', '1,2,3,4,5,6,7,8,9,15,16');
INSERT INTO `t_vip_config` VALUES ('12', '140000', '1=14&2=60&3=10&4=10&5=10&6=60&7=400000&8=400000&9=17&10=30&11=14&12=14&13=14&14=17&15=12&16=4020012_120&17=1', '1,2,3,4,5,6,7,8,9,15,16');
INSERT INTO `t_vip_config` VALUES ('13', '200000', '1=15&2=80&3=11&4=11&5=11&6=70&7=500000&8=500000&9=18&10=30&11=15&12=15&13=15&14=18&15=13&16=4020012_130&17=1', '1,2,3,4,5,6,7,8,9,15,16');
INSERT INTO `t_vip_config` VALUES ('14', '300000', '1=16&2=100&3=12&4=12&5=12&6=80&7=700000&8=700000&9=19&10=30&11=16&12=16&13=16&14=19&15=14&16=4020012_140&17=1', '1,2,3,4,5,6,7,8,9,15,16');
INSERT INTO `t_vip_config` VALUES ('15', '500000', '1=17&2=160&3=15&4=15&5=15&6=100&7=1000000&8=1000000&9=20&10=30&11=17&12=17&13=17&14=20&15=15&16=4020012_150&17=1', '1,2,3,4,5,6,7,8,9,15,16');

-- ----------------------------
-- Table structure for t_zone
-- ----------------------------
DROP TABLE IF EXISTS `t_zone`;
CREATE TABLE `t_zone` (
  `zone_id` int(11) NOT NULL COMMENT '副本编号',
  `type` int(11) NOT NULL COMMENT '类型',
  `level` int(11) NOT NULL COMMENT '开放等级',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `des` varchar(128) NOT NULL COMMENT '描述',
  `icon` varchar(50) NOT NULL COMMENT '章节图标',
  `bone_bg` int(11) NOT NULL COMMENT '标签底图',
  `enter_mc` int(11) NOT NULL COMMENT '进入动画ID',
  `over_mc` int(11) NOT NULL COMMENT '通关动画ID',
  `zone_map` int(11) NOT NULL COMMENT '章节底图ID',
  `pev_zone` int(11) NOT NULL COMMENT '前置编号',
  `next_zone` int(11) NOT NULL COMMENT '后置编号',
  `boss_id` int(11) NOT NULL COMMENT '章节BOSS'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_zone
-- ----------------------------
INSERT INTO `t_zone` VALUES ('1001', '1', '1', '绝代红颜', '绝代红颜', '1001001', '1', '0', '0', '0', '0', '1002', '2100003');
INSERT INTO `t_zone` VALUES ('1002', '1', '10', '乱世英杰', '乱世英杰', '1001003', '2', '0', '0', '0', '1001', '1003', '2100006');
INSERT INTO `t_zone` VALUES ('1003', '1', '19', '罪孽难逃', '罪孽难逃', '1001005', '3', '0', '0', '0', '1002', '1004', '2100009');
INSERT INTO `t_zone` VALUES ('1004', '1', '28', '西游乱入', '西游乱入', '1001008', '4', '900022', '0', '0', '1003', '1005', '2100012');
INSERT INTO `t_zone` VALUES ('1005', '1', '31', '误闯地府', '误闯地府', '1001011', '5', '900026', '0', '0', '1004', '1006', '2100015');
INSERT INTO `t_zone` VALUES ('1006', '1', '34', '水神共工', '水神共工', '1001014', '1', '0', '0', '0', '1005', '1007', '2100018');
INSERT INTO `t_zone` VALUES ('1007', '1', '37', '火神祝融', '火神祝融', '1001016', '2', '0', '0', '0', '1006', '1008', '2100021');
INSERT INTO `t_zone` VALUES ('1008', '1', '40', '贪神饕餮', '贪神饕餮', '1001018', '3', '900036', '0', '0', '1007', '1009', '2100024');
INSERT INTO `t_zone` VALUES ('1009', '1', '43', '战神蚩尤', '战神蚩尤', '1001020', '4', '0', '0', '0', '1008', '0', '2100027');
INSERT INTO `t_zone` VALUES ('2001', '2', '1', '新手试炼', '乱世三国', '1001023', '1', '0', '0', '0', '0', '2002', '0');
INSERT INTO `t_zone` VALUES ('2002', '2', '1', '三国之丧', '天庭之行', '1001025', '2', '0', '0', '0', '2001', '2003', '0');
INSERT INTO `t_zone` VALUES ('2003', '2', '1', '仙履奇缘', '仙履奇缘', '1001027', '3', '0', '0', '0', '2002', '0', '0');
INSERT INTO `t_zone` VALUES ('3001', '3', '25', '包子铺', '包子铺', '1002004L', '1', '0', '0', '0', '0', '0', '0');
INSERT INTO `t_zone` VALUES ('3002', '3', '10', '财神殿', '财神殿', 'item_4020004', '2', '0', '0', '0', '0', '0', '0');
INSERT INTO `t_zone` VALUES ('3003', '3', '15', '灵气殿', '灵气殿', 'item_4020005', '3', '0', '0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for t_zone_award
-- ----------------------------
DROP TABLE IF EXISTS `t_zone_award`;
CREATE TABLE `t_zone_award` (
  `zone_id` int(11) NOT NULL COMMENT '副本编号',
  `star` int(11) NOT NULL COMMENT '星数',
  `type` int(11) NOT NULL COMMENT '物品类型',
  `goods_id` int(11) NOT NULL COMMENT '物品id',
  `num` int(11) NOT NULL COMMENT '数量',
  `level` int(11) NOT NULL COMMENT '物品等级'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_zone_award
-- ----------------------------
INSERT INTO `t_zone_award` VALUES ('1001', '3', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1001', '3', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1001', '3', '8', '0', '1650', '1');
INSERT INTO `t_zone_award` VALUES ('1001', '6', '4', '4023501', '5', '1');
INSERT INTO `t_zone_award` VALUES ('1001', '6', '4', '4023601', '5', '1');
INSERT INTO `t_zone_award` VALUES ('1001', '6', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1001', '9', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1001', '9', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1001', '9', '1', '82029', '1', '1');
INSERT INTO `t_zone_award` VALUES ('1002', '3', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1002', '3', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1002', '6', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1002', '6', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1002', '9', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1002', '9', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1002', '9', '1', '82029', '1', '1');
INSERT INTO `t_zone_award` VALUES ('1003', '3', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1003', '3', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1003', '6', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1003', '6', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1003', '9', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1003', '9', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1003', '9', '1', '82029', '1', '1');
INSERT INTO `t_zone_award` VALUES ('1004', '3', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1004', '3', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1004', '6', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1004', '6', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1004', '9', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1004', '9', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1004', '9', '1', '82029', '1', '1');
INSERT INTO `t_zone_award` VALUES ('1005', '3', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1005', '3', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1005', '6', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1005', '6', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1005', '9', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1005', '9', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1005', '9', '1', '82029', '1', '1');
INSERT INTO `t_zone_award` VALUES ('1006', '3', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1006', '3', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1006', '6', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1006', '6', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1006', '9', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1006', '9', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1006', '9', '1', '82029', '1', '1');
INSERT INTO `t_zone_award` VALUES ('1007', '3', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1007', '3', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1007', '6', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1007', '6', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1007', '9', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1007', '9', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1007', '9', '1', '82029', '1', '1');
INSERT INTO `t_zone_award` VALUES ('1008', '3', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1008', '3', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1008', '6', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1008', '6', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1008', '9', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1008', '9', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1008', '9', '1', '82029', '1', '1');
INSERT INTO `t_zone_award` VALUES ('1009', '3', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1009', '3', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1009', '6', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1009', '6', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1009', '9', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('1009', '9', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('1009', '9', '1', '82029', '1', '1');
INSERT INTO `t_zone_award` VALUES ('2001', '3', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('2001', '3', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('2001', '3', '6', '3030014', '1', '1');
INSERT INTO `t_zone_award` VALUES ('2001', '6', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('2001', '6', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('2001', '6', '7', '5010070', '1', '1');
INSERT INTO `t_zone_award` VALUES ('2001', '9', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('2001', '9', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('2001', '9', '1', '82029', '1', '1');
INSERT INTO `t_zone_award` VALUES ('2002', '3', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('2002', '3', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('2002', '3', '6', '3030014', '1', '1');
INSERT INTO `t_zone_award` VALUES ('2002', '6', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('2002', '6', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('2002', '6', '7', '5020001', '1', '1');
INSERT INTO `t_zone_award` VALUES ('2002', '9', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('2002', '9', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('2002', '9', '1', '82029', '1', '1');
INSERT INTO `t_zone_award` VALUES ('2003', '3', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('2003', '3', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('2003', '3', '6', '3030014', '1', '1');
INSERT INTO `t_zone_award` VALUES ('2003', '6', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('2003', '6', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('2003', '6', '7', '5020002', '1', '1');
INSERT INTO `t_zone_award` VALUES ('2003', '9', '2', '0', '1000', '1');
INSERT INTO `t_zone_award` VALUES ('2003', '9', '3', '0', '10', '1');
INSERT INTO `t_zone_award` VALUES ('2003', '9', '1', '82029', '1', '1');

-- ----------------------------
-- Table structure for t_zone_battle
-- ----------------------------
DROP TABLE IF EXISTS `t_zone_battle`;
CREATE TABLE `t_zone_battle` (
  `battle_id` int(11) NOT NULL COMMENT '战场编号',
  `zone_id` int(11) NOT NULL COMMENT '对应副本ID',
  `battle_type` int(11) NOT NULL COMMENT '战场类型',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `icon` varchar(20) NOT NULL COMMENT 'BOSS立绘',
  `fall_icon` varchar(20) NOT NULL COMMENT '掉落类型图标',
  `show_off` varchar(128) NOT NULL COMMENT '展示掉落',
  `des` varchar(128) NOT NULL COMMENT '描述',
  `map_id` varchar(50) NOT NULL COMMENT '对应战场地图',
  `sp` int(11) NOT NULL COMMENT '消耗精力',
  `exp` int(11) NOT NULL COMMENT '关卡经验',
  `first_exp` int(11) NOT NULL COMMENT '第一次关卡奖励',
  `gold` int(11) NOT NULL COMMENT '金钱',
  `first_gold` int(11) NOT NULL COMMENT '第一次金钱',
  `round` int(11) NOT NULL COMMENT '总波次数',
  `pev_battle` int(11) NOT NULL COMMENT '前置战场',
  `next_battle` int(11) NOT NULL COMMENT '后置战场',
  `dis_rate` int(11) NOT NULL COMMENT '乱入概率',
  `dis_monster` varchar(128) NOT NULL COMMENT '乱入怪物',
  `item_rate` int(11) NOT NULL COMMENT '关卡道具概率',
  `slate_rate` int(11) NOT NULL COMMENT '石板概率',
  `events` varchar(128) NOT NULL COMMENT '战斗对白',
  `hinder` varchar(50) NOT NULL COMMENT '障碍物出现位置',
  `group` int(11) NOT NULL COMMENT '分组',
  `subGroup` int(11) NOT NULL COMMENT '子分组',
  `conditions` varchar(50) NOT NULL COMMENT '开放条件'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_zone_battle
-- ----------------------------
INSERT INTO `t_zone_battle` VALUES ('71001001', '1001', '1', '绝代红颜', '', '', '0,2|82001,1|82007,1|82033,1', '', 'mu', '5', '50', '50', '250', '2500', '2', '0', '71001002', '0', '', '500', '1000', '1', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71001002', '1001', '1', '绝代红颜', '', '', '0,2|82001,1|82007,1|82033,1', '', 'mu', '5', '50', '50', '250', '2500', '2', '71001001', '71001003', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71001003', '1001', '2', '绝代红颜1', '', '', '0,2|82011,1', '', 'mu', '5', '50', '50', '250', '2500', '1', '71001002', '71001004', '0', '', '500', '10000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71001004', '1001', '1', '绝代红颜', '', '', '0,2|82001,1|82007,1|82033,1', '', 'huo', '5', '50', '50', '250', '2500', '1', '71001003', '71001005', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71001005', '1001', '1', '绝代红颜', '', '', '0,2|82001,1|82007,1|82033,1', '', 'huo', '5', '50', '50', '250', '2500', '1', '71001004', '71001006', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71001006', '1001', '2', '绝代红颜2', '', '', '0,2|82008,1', '', 'huo', '5', '50', '50', '250', '2500', '2', '71001005', '71001007', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71001007', '1001', '1', '绝代红颜', '', '', '0,2|82001,1|82007,1|82033,1', '', 'huo', '5', '50', '50', '250', '2500', '1', '71001006', '71001008', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71001008', '1001', '1', '绝代红颜', '', '', '0,2|82001,1|82007,1|82033,1', '', 'huo', '5', '50', '50', '250', '2500', '1', '71001007', '71001009', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71001009', '1001', '2', '绝代红颜3', '', '', '0,2|82009,1', '', 'zhan', '5', '50', '50', '250', '2500', '2', '71001008', '71002001', '0', '', '500', '1000', '2', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71002001', '1002', '1', '乱世英杰', '', '', '0,2|82033,1|82034,1|82002,1', '', 'zhan', '5', '50', '50', '250', '2500', '1', '71001009', '71002002', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71002002', '1002', '1', '乱世英杰', '', '', '0,2|82033,1|82034,1|82002,1', '', 'zhan', '5', '50', '50', '250', '2500', '1', '71002001', '71002003', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71002003', '1002', '2', '乱世英杰1', '', '', '0,2|82010,1', '', 'zhan', '5', '50', '50', '250', '2500', '2', '71002002', '71002004', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71002004', '1002', '1', '乱世英杰', '', '', '0,2|82033,1|82034,1|82002,1', '', 'zhan', '5', '50', '50', '250', '2500', '1', '71002003', '71002005', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71002005', '1002', '1', '乱世英杰', '', '', '0,2|82033,1|82034,1|82002,1', '', 'zhan', '5', '50', '50', '250', '2500', '1', '71002004', '71002006', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71002006', '1002', '2', '乱世英杰2', '', '', '0,2|82006,1', '', 'zhan', '5', '50', '50', '250', '2500', '2', '71002005', '71002007', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71002007', '1002', '1', '乱世英杰', '', '', '0,2|82033,1|82034,1|82002,1', '', 'zhan', '5', '50', '50', '250', '2500', '1', '71002006', '71002008', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71002008', '1002', '1', '乱世英杰', '', '', '0,2|82033,1|82034,1|82002,1', '', 'zhan', '5', '50', '50', '250', '2500', '1', '71002007', '71002009', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71002009', '1002', '2', '乱世英杰3', '', '', '0,2|82005,1', '', 'zhan', '5', '50', '50', '250', '2500', '2', '71002008', '71003001', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71003001', '1003', '1', '罪孽难逃', '', '', '0,2|82020,1|82007,1|82001,1', '', 'zhan', '5', '50', '50', '250', '2500', '1', '71002009', '71003002', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71003002', '1003', '1', '罪孽难逃', '', '', '0,2|82020,1|82007,1|82001,1', '', 'zhan', '5', '50', '50', '250', '2500', '1', '71003001', '71003003', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71003003', '1003', '2', '罪孽难逃1', '', '', '0,2|82004,1', '', 'zhan', '5', '50', '50', '250', '2500', '2', '71003002', '71003004', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71003004', '1003', '1', '罪孽难逃', '', '', '0,2|82020,1|82007,1|82001,1', '', 'an', '5', '50', '50', '250', '2500', '1', '71003003', '71003005', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71003005', '1003', '1', '罪孽难逃', '', '', '0,2|82020,1|82007,1|82001,1', '', 'an', '5', '50', '50', '250', '2500', '1', '71003004', '71003006', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71003006', '1003', '2', '罪孽难逃2', '', '', '0,2|82003,1', '', 'an', '5', '50', '50', '250', '2500', '2', '71003005', '71003007', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71003007', '1003', '1', '罪孽难逃', '', '', '0,2|82020,1|82007,1|82001,1', '', 'an', '5', '50', '50', '250', '2500', '1', '71003006', '71003008', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71003008', '1003', '1', '罪孽难逃', '', '', '0,2|82020,1|82007,1|82001,1', '', 'an', '5', '50', '50', '250', '2500', '1', '71003007', '71003009', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71003009', '1003', '2', '罪孽难逃3', '', '', '0,2|82012,1', '', 'an', '5', '50', '50', '250', '2500', '2', '71003008', '71004001', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71004001', '1004', '1', '西游乱入', '', '', '0,2|82023,1|82021,1|82029,1', '', 'an', '5', '50', '50', '250', '2500', '2', '71003009', '71004002', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71004002', '1004', '1', '西游乱入', '', '', '0,2|82023,1|82021,1|82029,1', '', 'an', '5', '50', '50', '250', '2500', '2', '71004001', '71004003', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71004003', '1004', '2', '西游乱入1', '', '', '0,2|82013,1', '', 'huo', '5', '50', '50', '250', '2500', '2', '71004002', '71004004', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71004004', '1004', '1', '西游乱入', '', '', '0,2|82023,1|82021,1|82029,1', '', 'huo', '5', '50', '50', '250', '2500', '2', '71004003', '71004005', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71004005', '1004', '1', '西游乱入', '', '', '0,2|82023,1|82021,1|82029,1', '', 'huo', '5', '50', '50', '250', '2500', '2', '71004004', '71004006', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71004006', '1004', '2', '西游乱入2', '', '', '0,2|82031,1', '', 'huo', '5', '50', '50', '250', '2500', '2', '71004005', '71004007', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71004007', '1004', '1', '西游乱入', '', '', '0,2|82023,1|82021,1|82029,1', '', 'huo', '5', '50', '50', '250', '2500', '2', '71004006', '71004008', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71004008', '1004', '1', '西游乱入', '', '', '0,2|82023,1|82021,1|82029,1', '', 'huo', '5', '50', '50', '250', '2500', '2', '71004007', '71004009', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71004009', '1004', '2', '西游乱入3', '', '', '0,2|82030,1', '', 'huo', '5', '50', '50', '250', '2500', '3', '71004008', '71005001', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71005001', '1005', '1', '误闯地府', '', '', '0,2|82002,1|82020,1|82017,1', '', 'huo', '5', '50', '50', '250', '2500', '2', '71004009', '71005002', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71005002', '1005', '1', '误闯地府', '', '', '0,2|82002,1|82020,1|82017,1', '', 'huo', '5', '50', '50', '250', '2500', '2', '71005001', '71005003', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71005003', '1005', '2', '误闯地府1', '', '', '0,2|82032,1', '', 'huo', '5', '50', '50', '250', '2500', '2', '71005002', '71005004', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71005004', '1005', '1', '误闯地府', '', '', '0,2|82002,1|82020,1|82017,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71005003', '71005005', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71005005', '1005', '1', '误闯地府', '', '', '0,2|82002,1|82020,1|82017,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71005004', '71005006', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71005006', '1005', '2', '误闯地府2', '', '', '0,2|82014,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71005005', '71005007', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71005007', '1005', '1', '误闯地府', '', '', '0,2|82002,1|82020,1|82017,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71005006', '71005008', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71005008', '1005', '1', '误闯地府', '', '', '0,2|82002,1|82020,1|82017,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71005007', '71005009', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71005009', '1005', '2', '误闯地府3', '', '', '0,2|82027,1', '', 'guang', '5', '50', '50', '250', '2500', '3', '71005008', '71006001', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71006001', '1006', '1', '水神共工', '', '', '0,2|82033,1|82028,1|82016,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71005009', '71006002', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71006002', '1006', '1', '水神共工', '', '', '0,2|82033,1|82028,1|82016,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71006001', '71006003', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71006003', '1006', '2', '水神共工1', '', '', '0,2|82018,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71006002', '71006004', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71006004', '1006', '1', '水神共工', '', '', '0,2|82033,1|82028,1|82016,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71006003', '71006005', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71006005', '1006', '1', '水神共工', '', '', '0,2|82033,1|82028,1|82016,1', '', 'zhan', '5', '50', '50', '250', '2500', '2', '71006004', '71006006', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71006006', '1006', '2', '水神共工2', '', '', '0,2|82038,1', '', 'zhan', '5', '50', '50', '250', '2500', '2', '71006005', '71006007', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71006007', '1006', '1', '水神共工', '', '', '0,2|82033,1|82028,1|82016,1', '', 'zhan', '5', '50', '50', '250', '2500', '2', '71006006', '71006008', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71006008', '1006', '1', '水神共工', '', '', '0,2|82033,1|82028,1|82016,1', '', 'zhan', '5', '50', '50', '250', '2500', '2', '71006007', '71006009', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71006009', '1006', '2', '水神共工3', '', '', '0,2|82025,1', '', 'zhan', '5', '50', '50', '250', '2500', '3', '71006008', '71007001', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71007001', '1007', '1', '火神祝融', '', '', '0,2|82034,1|82028,1|82029,1', '', 'zhan', '5', '50', '50', '250', '2500', '2', '71006009', '71007002', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71007002', '1007', '1', '火神祝融', '', '', '0,2|82034,1|82028,1|82029,1', '', 'zhan', '5', '50', '50', '250', '2500', '2', '71007001', '71007003', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71007003', '1007', '2', '火神祝融1', '', '', '0,2|82019,1', '', 'zhan', '5', '50', '50', '250', '2500', '2', '71007002', '71007004', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71007004', '1007', '1', '火神祝融', '', '', '0,2|82034,1|82028,1|82029,1', '', 'zhan', '5', '50', '50', '250', '2500', '2', '71007003', '71007005', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71007005', '1007', '1', '火神祝融', '', '', '0,2|82034,1|82028,1|82029,1', '', 'zhan', '5', '50', '50', '250', '2500', '2', '71007004', '71007006', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71007006', '1007', '2', '火神祝融2', '', '', '0,2|82035,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71007005', '71007007', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71007007', '1007', '1', '火神祝融', '', '', '0,2|82034,1|82028,1|82029,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71007006', '71007008', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71007008', '1007', '1', '火神祝融', '', '', '0,2|82034,1|82028,1|82029,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71007007', '71007009', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71007009', '1007', '2', '火神祝融3', '', '', '0,2|82026,1', '', 'guang', '5', '50', '50', '250', '2500', '3', '71007008', '71008001', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71008001', '1008', '1', '贪神饕餮', '', '', '0,2|82033,1|82020,1|82016,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71007009', '71008002', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71008002', '1008', '1', '贪神饕餮', '', '', '0,2|82033,1|82020,1|82016,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71008001', '71008003', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71008003', '1008', '2', '贪神饕餮1', '', '', '0,2|82022,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71008002', '71008004', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71008004', '1008', '1', '贪神饕餮', '', '', '0,2|82033,1|82020,1|82016,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71008003', '71008005', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71008005', '1008', '1', '贪神饕餮', '', '', '0,2|82033,1|82020,1|82016,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71008004', '71008006', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71008006', '1008', '2', '贪神饕餮2', '', '', '0,2|82036,1', '', 'guang', '5', '50', '50', '250', '2500', '2', '71008005', '71008007', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71008007', '1008', '1', '贪神饕餮', '', '', '0,2|82033,1|82020,1|82016,1', '', 'an', '5', '50', '50', '250', '2500', '2', '71008006', '71008008', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71008008', '1008', '1', '贪神饕餮', '', '', '0,2|82033,1|82020,1|82016,1', '', 'an', '5', '50', '50', '250', '2500', '2', '71008007', '71008009', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71008009', '1008', '2', '贪神饕餮3', '', '', '0,2|82039,1', '', 'an', '5', '50', '50', '250', '2500', '3', '71008008', '71009001', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71009001', '1009', '1', '战神蚩尤', '', '', '0,2|82016,1|82020,1|82028,1', '', 'an', '5', '50', '50', '250', '2500', '2', '71008009', '71009002', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71009002', '1009', '1', '战神蚩尤', '', '', '0,2|82016,1|82020,1|82028,1', '', 'an', '5', '50', '50', '250', '2500', '2', '71009001', '71009003', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71009003', '1009', '2', '战神蚩尤1', '', '', '0,2|82040,1', '', 'an', '5', '50', '50', '250', '2500', '2', '71009002', '71009004', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71009004', '1009', '1', '战神蚩尤', '', '', '0,2|82016,1|82020,1|82028,1', '', 'an', '5', '50', '50', '250', '2500', '2', '71009003', '71009005', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71009005', '1009', '1', '战神蚩尤', '', '', '0,2|82016,1|82020,1|82028,1', '', 'an', '5', '50', '50', '250', '2500', '2', '71009004', '71009006', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71009006', '1009', '2', '战神蚩尤2', '', '', '0,2|82037,1', '', 'an', '5', '50', '50', '250', '2500', '2', '71009005', '71009007', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71009007', '1009', '1', '战神蚩尤', '', '', '0,2|82016,1|82020,1|82028,1', '', 'an', '5', '50', '50', '250', '2500', '2', '71009006', '71009008', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71009008', '1009', '1', '战神蚩尤', '', '', '0,2|82016,1|82020,1|82028,1', '', 'an', '5', '50', '50', '250', '2500', '2', '71009007', '71009009', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('71009009', '1009', '2', '战神蚩尤3', '', '', '0,2|82024,1', '', 'an', '5', '50', '50', '250', '2500', '3', '71009008', '72001001', '0', '', '500', '1000', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('72001001', '2001', '2', '乱世三国', '2100003', '2', '0,3|82027,1|3010014,6', '', 'an', '10', '100', '100', '500', '5000', '3', '71001001', '72001002', '0', '', '0', '0', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('72001002', '2001', '2', '乱世三国', '2100006', '3', '0,3|82027,1|3010014,6', '', 'an', '10', '100', '100', '500', '5000', '3', '72001001', '72001003', '0', '', '0', '0', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('72001003', '2001', '2', '乱世三国', '2100009', '1', '0,3|82027,1|3010014,6', '', 'an', '10', '100', '100', '500', '5000', '3', '72001002', '72002001', '0', '', '0', '0', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('72002001', '2002', '2', '天庭之行', '2100012', '2', '0,3|82027,1|3010014,6', '', 'an', '10', '100', '100', '500', '5000', '3', '71006009', '72002002', '0', '', '0', '0', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('72002002', '2002', '2', '天庭之行', '2100015', '3', '0,3|82027,1|3010014,6', '', 'an', '10', '100', '100', '500', '5000', '3', '72002001', '72002003', '0', '', '0', '0', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('72002003', '2002', '2', '天庭之行', '2100018', '1', '0,3|82027,1|3010014,6', '', 'an', '10', '100', '100', '500', '5000', '3', '72002002', '72003001', '0', '', '0', '0', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('72003001', '2003', '2', '仙履奇缘', '2100021', '2', '0,3|82027,1|3010014,6', '', 'an', '10', '100', '100', '500', '5000', '3', '71009009', '72003002', '0', '', '0', '0', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('72003002', '2003', '2', '仙履奇缘', '2100024', '3', '0,3|82027,1|3010014,6', '', 'an', '10', '100', '100', '500', '5000', '3', '72003001', '72003003', '0', '', '0', '0', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('72003003', '2003', '2', '仙履奇缘', '2100027', '1', '0,3|82027,1|3010014,6', '', 'an', '10', '100', '100', '500', '5000', '3', '72003002', '0', '0', '', '0', '0', '', '', '0', '0', '');
INSERT INTO `t_zone_battle` VALUES ('73001001', '3001', '0', '火焰包子2星', '90001', '', '90001,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '1', '2', '');
INSERT INTO `t_zone_battle` VALUES ('73001002', '3001', '0', '火焰包子3星', '90002', '', '90002,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '1', '3', '');
INSERT INTO `t_zone_battle` VALUES ('73001003', '3001', '0', '火焰包子4星', '90003', '', '90003,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '1', '4', '');
INSERT INTO `t_zone_battle` VALUES ('73001004', '3001', '0', '火焰包子5星', '90004', '', '90004,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '1', '5', '');
INSERT INTO `t_zone_battle` VALUES ('73001005', '3001', '0', '木灵包子2星', '90005', '', '90005,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '2', '2', '');
INSERT INTO `t_zone_battle` VALUES ('73001006', '3001', '0', '木灵包子3星', '90006', '', '90006,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '2', '3', '');
INSERT INTO `t_zone_battle` VALUES ('73001007', '3001', '0', '木灵包子4星', '90007', '', '90007,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '2', '4', '');
INSERT INTO `t_zone_battle` VALUES ('73001008', '3001', '0', '木灵包子5星', '90008', '', '90008,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '2', '5', '');
INSERT INTO `t_zone_battle` VALUES ('73001009', '3001', '0', '冰霜包子2星', '90009', '', '90009,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '3', '2', '');
INSERT INTO `t_zone_battle` VALUES ('73001010', '3001', '0', '冰霜包子3星', '90010', '', '90010,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '3', '3', '');
INSERT INTO `t_zone_battle` VALUES ('73001011', '3001', '0', '冰霜包子4星', '90011', '', '90011,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '3', '4', '');
INSERT INTO `t_zone_battle` VALUES ('73001012', '3001', '0', '冰霜包子5星', '90012', '', '90012,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '3', '5', '');
INSERT INTO `t_zone_battle` VALUES ('73001013', '3001', '0', '光明包子2星', '90013', '', '90013,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '4', '2', '');
INSERT INTO `t_zone_battle` VALUES ('73001014', '3001', '0', '光明包子3星', '90014', '', '90014,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '4', '3', '');
INSERT INTO `t_zone_battle` VALUES ('73001015', '3001', '0', '光明包子4星', '90015', '', '90015,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '4', '4', '');
INSERT INTO `t_zone_battle` VALUES ('73001016', '3001', '0', '光明包子5星', '90016', '', '90016,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '4', '5', '');
INSERT INTO `t_zone_battle` VALUES ('73001017', '3001', '0', '黑暗包子2星', '90017', '', '90017,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '5', '2', '');
INSERT INTO `t_zone_battle` VALUES ('73001018', '3001', '0', '黑暗包子3星', '90018', '', '90018,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '5', '3', '');
INSERT INTO `t_zone_battle` VALUES ('73001019', '3001', '0', '黑暗包子4星', '90019', '', '90019,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '5', '4', '');
INSERT INTO `t_zone_battle` VALUES ('73001020', '3001', '0', '黑暗包子5星', '90020', '', '90020,1', '', '', '10', '100', '100', '500', '5000', '3', '0', '0', '0', '', '0', '0', '', '', '5', '5', '');
INSERT INTO `t_zone_battle` VALUES ('73002001', '3002', '0', '财神殿简单', '', '', '0,2', '', '', '20', '200', '200', '1000', '10000', '3', '0', '0', '0', '', '0', '0', '', '', '1', '0', '1_10');
INSERT INTO `t_zone_battle` VALUES ('73002002', '3002', '0', '财神殿普通', '', '', '0,2', '', '', '20', '200', '200', '1000', '10000', '3', '0', '0', '0', '', '0', '0', '', '', '2', '0', '1_25');
INSERT INTO `t_zone_battle` VALUES ('73002003', '3002', '0', '财神殿困难', '', '', '0,2', '', '', '20', '200', '200', '1000', '10000', '3', '0', '0', '0', '', '0', '0', '', '', '3', '0', '1_40');
INSERT INTO `t_zone_battle` VALUES ('73002004', '3002', '0', '财神殿艰难', '', '', '0,2', '', '', '20', '200', '200', '1000', '10000', '3', '0', '0', '0', '', '0', '0', '', '', '4', '0', '1_60');
INSERT INTO `t_zone_battle` VALUES ('73003001', '3003', '0', '灵气殿简单', '', '', '0,8', '', '', '20', '200', '200', '1000', '10000', '3', '0', '0', '0', '', '0', '0', '', '', '1', '0', '1_15');
INSERT INTO `t_zone_battle` VALUES ('73003002', '3003', '0', '灵气殿普通', '', '', '0,8', '', '', '20', '200', '200', '1000', '10000', '3', '0', '0', '0', '', '0', '0', '', '', '2', '0', '1_30');
INSERT INTO `t_zone_battle` VALUES ('73003003', '3003', '0', '灵气殿困难', '', '', '0,8', '', '', '20', '200', '200', '1000', '10000', '3', '0', '0', '0', '', '0', '0', '', '', '3', '0', '1_45');
INSERT INTO `t_zone_battle` VALUES ('73003004', '3003', '0', '灵气殿艰难', '', '', '0,8', '', '', '20', '200', '200', '1000', '10000', '3', '0', '0', '0', '', '0', '0', '', '', '4', '0', '1_65');

-- ----------------------------
-- Table structure for t_zone_battle_round
-- ----------------------------
DROP TABLE IF EXISTS `t_zone_battle_round`;
CREATE TABLE `t_zone_battle_round` (
  `battle_id` int(11) NOT NULL COMMENT '战场编号',
  `round_id` int(11) NOT NULL COMMENT '波数',
  `boss_round` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否BOSS波',
  `boss_id` int(11) NOT NULL COMMENT '章节BOSS',
  `enter_mc` int(11) NOT NULL COMMENT '进入动画ID',
  `over_mc` int(11) NOT NULL COMMENT '通关动画ID',
  `monsters` varchar(128) NOT NULL COMMENT '怪物配置'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_zone_battle_round
-- ----------------------------
INSERT INTO `t_zone_battle_round` VALUES ('71001001', '1', '0', '0', '0', '0', '0,9000004,9000001,0');
INSERT INTO `t_zone_battle_round` VALUES ('71001001', '2', '1', '9000002', '0', '0', '9000002,0,9000005,9000005');
INSERT INTO `t_zone_battle_round` VALUES ('71001002', '1', '1', '9000003', '0', '0', '0,0,0,9000003');
INSERT INTO `t_zone_battle_round` VALUES ('71001003', '1', '1', '2100001', '900013', '0', '0,2003002,2002002,2100001');
INSERT INTO `t_zone_battle_round` VALUES ('71001004', '1', '0', '0', '0', '0', '2003002,2004002,2002002,2001002');
INSERT INTO `t_zone_battle_round` VALUES ('71001005', '1', '0', '0', '0', '0', '2001003,2003003,2001003,2005003');
INSERT INTO `t_zone_battle_round` VALUES ('71001006', '1', '0', '0', '0', '0', '2001004,2003004,2001004,2005004');
INSERT INTO `t_zone_battle_round` VALUES ('71001006', '2', '1', '2100002', '900014', '0', '0,2001004,2003004,2100002');
INSERT INTO `t_zone_battle_round` VALUES ('71001007', '1', '0', '0', '0', '0', '2004005,2004005,2003005,2002005');
INSERT INTO `t_zone_battle_round` VALUES ('71001008', '1', '0', '0', '0', '0', '2001006,2004006,2005006,2003006');
INSERT INTO `t_zone_battle_round` VALUES ('71001009', '1', '0', '0', '0', '0', '2001007,2001007,2003007,2002007');
INSERT INTO `t_zone_battle_round` VALUES ('71001009', '2', '1', '2100003', '900015', '0', '0,2003007,2002007,2100003');
INSERT INTO `t_zone_battle_round` VALUES ('71002001', '1', '0', '0', '0', '0', '2003008,2001008,2004008,2002008');
INSERT INTO `t_zone_battle_round` VALUES ('71002002', '1', '0', '0', '0', '0', '2005009,2001009,2002009,2003009');
INSERT INTO `t_zone_battle_round` VALUES ('71002003', '1', '0', '0', '0', '0', '2002010,2004010,2003010,2004010');
INSERT INTO `t_zone_battle_round` VALUES ('71002003', '2', '1', '2100004', '900016', '0', '0,2002010,2004010,2100004');
INSERT INTO `t_zone_battle_round` VALUES ('71002004', '1', '0', '0', '0', '0', '2002011,2004011,2003011,2005011');
INSERT INTO `t_zone_battle_round` VALUES ('71002005', '1', '0', '0', '0', '0', '2001012,2003012,2001012,2005012');
INSERT INTO `t_zone_battle_round` VALUES ('71002006', '1', '0', '0', '0', '0', '2003005,2004005,2002005,2001013');
INSERT INTO `t_zone_battle_round` VALUES ('71002006', '2', '1', '2100005', '900017', '0', '0,2004005,2002005,2100005');
INSERT INTO `t_zone_battle_round` VALUES ('71002007', '1', '0', '0', '0', '0', '2003014,2004014,2002014,2001014');
INSERT INTO `t_zone_battle_round` VALUES ('71002008', '1', '0', '0', '0', '0', '2001015,2004015,2005015,2003015');
INSERT INTO `t_zone_battle_round` VALUES ('71002009', '1', '0', '0', '0', '0', '2003016,2004016,2002016,2001016');
INSERT INTO `t_zone_battle_round` VALUES ('71002009', '2', '1', '2100006', '900018', '0', '0,2002016,2001016,2100006');
INSERT INTO `t_zone_battle_round` VALUES ('71003001', '1', '0', '0', '0', '0', '2003017,2001017,2002017,2004017');
INSERT INTO `t_zone_battle_round` VALUES ('71003002', '1', '0', '0', '0', '0', '2001018,2003018,2001018,2005018');
INSERT INTO `t_zone_battle_round` VALUES ('71003003', '1', '0', '0', '0', '0', '2005019,2004019,2003019,2004019');
INSERT INTO `t_zone_battle_round` VALUES ('71003003', '2', '1', '2100007', '900019', '0', '0,2005019,2004019,2100007');
INSERT INTO `t_zone_battle_round` VALUES ('71003004', '1', '0', '0', '0', '0', '2008020,2004020,2005020,2001020');
INSERT INTO `t_zone_battle_round` VALUES ('71003005', '1', '0', '0', '0', '0', '2003021,2004021,2002021,2008021');
INSERT INTO `t_zone_battle_round` VALUES ('71003006', '1', '0', '0', '0', '0', '2008022,2003022,2001022,2005022');
INSERT INTO `t_zone_battle_round` VALUES ('71003006', '2', '1', '2100008', '900020', '0', '0,2001022,2005022,2100008');
INSERT INTO `t_zone_battle_round` VALUES ('71003007', '1', '0', '0', '0', '0', '2001023,2004023,2003023,2002023');
INSERT INTO `t_zone_battle_round` VALUES ('71003008', '1', '0', '0', '0', '0', '2008024,2001024,2002024,2003024');
INSERT INTO `t_zone_battle_round` VALUES ('71003009', '1', '0', '0', '0', '0', '2008025,2004025,2005025,2003025');
INSERT INTO `t_zone_battle_round` VALUES ('71003009', '2', '1', '2100009', '900021', '0', '0,2004025,2005025,2100009');
INSERT INTO `t_zone_battle_round` VALUES ('71004001', '1', '0', '0', '0', '0', '2008025,2007025,2009025,2006025');
INSERT INTO `t_zone_battle_round` VALUES ('71004001', '2', '0', '0', '0', '0', '2010025,2012025,2007025,2009025');
INSERT INTO `t_zone_battle_round` VALUES ('71004002', '1', '0', '0', '0', '0', '2010025,2012025,2009025,2008025');
INSERT INTO `t_zone_battle_round` VALUES ('71004002', '2', '0', '0', '0', '0', '2006025,2009025,2008025,2007025');
INSERT INTO `t_zone_battle_round` VALUES ('71004003', '1', '0', '0', '0', '0', '2008026,2007026,2006026,2010026');
INSERT INTO `t_zone_battle_round` VALUES ('71004003', '2', '1', '2100010', '900023', '0', '0,2008026,2007026,2100010');
INSERT INTO `t_zone_battle_round` VALUES ('71004004', '1', '0', '0', '0', '0', '2006026,2010026,2008026,2007026');
INSERT INTO `t_zone_battle_round` VALUES ('71004004', '2', '0', '0', '0', '0', '2010026,2012026,2009026,2008026');
INSERT INTO `t_zone_battle_round` VALUES ('71004005', '1', '0', '0', '0', '0', '2008026,2007026,2006026,2010026');
INSERT INTO `t_zone_battle_round` VALUES ('71004005', '2', '0', '0', '0', '0', '2006026,2009026,2008026,2007026');
INSERT INTO `t_zone_battle_round` VALUES ('71004006', '1', '0', '0', '0', '0', '2010027,2012027,2007027,2009027');
INSERT INTO `t_zone_battle_round` VALUES ('71004006', '2', '1', '210011', '900024', '0', '0,2007027,2009027,2100011');
INSERT INTO `t_zone_battle_round` VALUES ('71004007', '1', '0', '0', '0', '0', '2008027,2007027,2006027,2010027');
INSERT INTO `t_zone_battle_round` VALUES ('71004007', '2', '0', '0', '0', '0', '2006027,2010027,2008027,2007027');
INSERT INTO `t_zone_battle_round` VALUES ('71004008', '1', '0', '0', '0', '0', '2010027,2012027,2007027,2009027');
INSERT INTO `t_zone_battle_round` VALUES ('71004008', '2', '0', '0', '0', '0', '2010027,2012027,2009027,2008027');
INSERT INTO `t_zone_battle_round` VALUES ('71004009', '1', '0', '0', '0', '0', '2006028,2010028,2008028,2007028');
INSERT INTO `t_zone_battle_round` VALUES ('71004009', '2', '0', '0', '0', '0', '2008028,2006028,2012028,2006028');
INSERT INTO `t_zone_battle_round` VALUES ('71004009', '3', '1', '2100012', '900025', '0', '0,2006028,2012028,2100012');
INSERT INTO `t_zone_battle_round` VALUES ('71005001', '1', '0', '0', '0', '0', '2009028,2008028,2003028,2006028');
INSERT INTO `t_zone_battle_round` VALUES ('71005001', '2', '0', '0', '0', '0', '2002028,2009028,2008028,2003028');
INSERT INTO `t_zone_battle_round` VALUES ('71005002', '1', '0', '0', '0', '0', '2002028,2003028,2002028,2009028');
INSERT INTO `t_zone_battle_round` VALUES ('71005002', '2', '0', '0', '0', '0', '2003028,2006028,2011028,2002028');
INSERT INTO `t_zone_battle_round` VALUES ('71005003', '1', '0', '0', '0', '0', '2006029,2011029,2002029,2009029');
INSERT INTO `t_zone_battle_round` VALUES ('71005003', '2', '1', '2100013', '900027', '0', '0,2002029,2009029,2100013');
INSERT INTO `t_zone_battle_round` VALUES ('71005004', '1', '0', '0', '0', '0', '2011029,2002029,2003029,2006029');
INSERT INTO `t_zone_battle_round` VALUES ('71005004', '2', '0', '0', '0', '0', '2009029,2008029,2009029,2006029');
INSERT INTO `t_zone_battle_round` VALUES ('71005005', '1', '0', '0', '0', '0', '2009029,2003029,2006029,2008029');
INSERT INTO `t_zone_battle_round` VALUES ('71005005', '2', '0', '0', '0', '0', '2003029,2006029,2011029,2002029');
INSERT INTO `t_zone_battle_round` VALUES ('71005006', '1', '0', '0', '0', '0', '2002030,2009030,2006030,2011030');
INSERT INTO `t_zone_battle_round` VALUES ('71005006', '2', '1', '2100014', '900028', '0', '0,2002030,2009030,2100014');
INSERT INTO `t_zone_battle_round` VALUES ('71005007', '1', '0', '0', '0', '0', '2011030,2002030,2009030,2008030');
INSERT INTO `t_zone_battle_round` VALUES ('71005007', '2', '0', '0', '0', '0', '2008030,2011030,2003030,2006030');
INSERT INTO `t_zone_battle_round` VALUES ('71005008', '1', '0', '0', '0', '0', '2002030,2003030,2008030,2003030');
INSERT INTO `t_zone_battle_round` VALUES ('71005008', '2', '0', '0', '0', '0', '2009030,2008030,2009030,2006030');
INSERT INTO `t_zone_battle_round` VALUES ('71005009', '1', '0', '0', '0', '0', '2002031,2008031,2009031,2003031');
INSERT INTO `t_zone_battle_round` VALUES ('71005009', '2', '0', '0', '0', '0', '2009031,2008031,2003031,2006031');
INSERT INTO `t_zone_battle_round` VALUES ('71005009', '3', '1', '2100015', '900029', '0', '0,2003031,2006031,2100015');
INSERT INTO `t_zone_battle_round` VALUES ('71006001', '1', '0', '0', '0', '0', '2011031,2013031,2005031,2004031');
INSERT INTO `t_zone_battle_round` VALUES ('71006001', '2', '0', '0', '0', '0', '2013031,2005031,2013031,2011031');
INSERT INTO `t_zone_battle_round` VALUES ('71006002', '1', '0', '0', '0', '0', '2011031,2007031,2007031,2013031');
INSERT INTO `t_zone_battle_round` VALUES ('71006002', '2', '0', '0', '0', '0', '2005031,2004031,2011031,2007031');
INSERT INTO `t_zone_battle_round` VALUES ('71006003', '1', '0', '0', '900030', '0', '2013032,2005032,2011032,2011032');
INSERT INTO `t_zone_battle_round` VALUES ('71006003', '2', '1', '2100016', '0', '0', '0,2005032,2011032,2100016');
INSERT INTO `t_zone_battle_round` VALUES ('71006004', '1', '0', '0', '0', '0', '2007032,2011032,2013032,2005032');
INSERT INTO `t_zone_battle_round` VALUES ('71006004', '2', '0', '0', '0', '0', '2011032,2007032,2007032,2013032');
INSERT INTO `t_zone_battle_round` VALUES ('71006005', '1', '0', '0', '0', '0', '2011032,2013032,2011032,2011032');
INSERT INTO `t_zone_battle_round` VALUES ('71006005', '2', '0', '0', '0', '0', '2011032,2013032,2005032,2004032');
INSERT INTO `t_zone_battle_round` VALUES ('71006006', '1', '0', '0', '0', '0', '2013033,2005033,2011033,2011033');
INSERT INTO `t_zone_battle_round` VALUES ('71006006', '2', '1', '2100017', '900031', '0', '0,2005033,2011033,2100017');
INSERT INTO `t_zone_battle_round` VALUES ('71006007', '1', '0', '0', '0', '0', '2013033,2005033,2011033,2011033');
INSERT INTO `t_zone_battle_round` VALUES ('71006007', '2', '0', '0', '0', '0', '2005033,2004033,2011033,2007033');
INSERT INTO `t_zone_battle_round` VALUES ('71006008', '1', '0', '0', '0', '0', '2005033,2004033,2011033,2007033');
INSERT INTO `t_zone_battle_round` VALUES ('71006008', '2', '0', '0', '0', '0', '2011033,2007033,2011033,2013033');
INSERT INTO `t_zone_battle_round` VALUES ('71006009', '1', '0', '0', '0', '0', '2013034,2005034,2013034,2011034');
INSERT INTO `t_zone_battle_round` VALUES ('71006009', '2', '0', '0', '0', '0', '2011034,2007034,2007034,2013034');
INSERT INTO `t_zone_battle_round` VALUES ('71006009', '3', '1', '2100018', '900032', '0', '0,2013034,2005034,2100018');
INSERT INTO `t_zone_battle_round` VALUES ('71007001', '1', '0', '0', '0', '0', '2005034,2011034,2013034,2005034');
INSERT INTO `t_zone_battle_round` VALUES ('71007001', '2', '0', '0', '0', '0', '2011034,2005034,2012034,2007034');
INSERT INTO `t_zone_battle_round` VALUES ('71007002', '1', '0', '0', '0', '0', '2005034,2011034,2012034,2012034');
INSERT INTO `t_zone_battle_round` VALUES ('71007002', '2', '0', '0', '0', '0', '2011034,2012034,2013034,2007034');
INSERT INTO `t_zone_battle_round` VALUES ('71007003', '1', '0', '0', '0', '0', '2005035,2012035,2011035,2007035');
INSERT INTO `t_zone_battle_round` VALUES ('71007003', '2', '1', '2100019', '900033', '0', '0,2005035,2012035,2100019');
INSERT INTO `t_zone_battle_round` VALUES ('71007004', '1', '0', '0', '0', '0', '2007035,2011035,2013035,2005035');
INSERT INTO `t_zone_battle_round` VALUES ('71007004', '2', '0', '0', '0', '0', '2011035,2007035,2007035,2013035');
INSERT INTO `t_zone_battle_round` VALUES ('71007005', '1', '0', '0', '0', '0', '2011035,2013035,2011035,2011035');
INSERT INTO `t_zone_battle_round` VALUES ('71007005', '2', '0', '0', '0', '0', '2011035,2013035,2005035,2012035');
INSERT INTO `t_zone_battle_round` VALUES ('71007006', '1', '0', '0', '0', '0', '2013036,2005036,2011036,2011036');
INSERT INTO `t_zone_battle_round` VALUES ('71007006', '2', '1', '2100020', '900034', '0', '0,2013036,2005036,2100020');
INSERT INTO `t_zone_battle_round` VALUES ('71007007', '1', '0', '0', '0', '0', '2005036,2011036,2012036,2012036');
INSERT INTO `t_zone_battle_round` VALUES ('71007007', '2', '0', '0', '0', '0', '2011036,2012036,2013036,2007036');
INSERT INTO `t_zone_battle_round` VALUES ('71007008', '1', '0', '0', '0', '0', '2007036,2011036,2013036,2005036');
INSERT INTO `t_zone_battle_round` VALUES ('71007008', '2', '0', '0', '0', '0', '2011036,2007036,2007036,2013036');
INSERT INTO `t_zone_battle_round` VALUES ('71007009', '1', '0', '0', '0', '0', '2011037,2013037,2011037,2011037');
INSERT INTO `t_zone_battle_round` VALUES ('71007009', '2', '0', '0', '0', '0', '2011037,2013037,2005037,2012037');
INSERT INTO `t_zone_battle_round` VALUES ('71007009', '3', '1', '2100021', '900035', '0', '0,2013037,2005037,2100021');
INSERT INTO `t_zone_battle_round` VALUES ('71008001', '1', '0', '0', '0', '0', '2008037,2013037,2002037,2004037');
INSERT INTO `t_zone_battle_round` VALUES ('71008001', '2', '0', '0', '0', '0', '2011037,2005037,2008037,2013037');
INSERT INTO `t_zone_battle_round` VALUES ('71008002', '1', '0', '0', '0', '0', '2004037,2011037,2005037,2008037');
INSERT INTO `t_zone_battle_round` VALUES ('71008002', '2', '0', '0', '0', '0', '2013037,2002037,2004037,2011037');
INSERT INTO `t_zone_battle_round` VALUES ('71008003', '1', '0', '0', '0', '0', '2013038,2013038,2004038,2011038');
INSERT INTO `t_zone_battle_round` VALUES ('71008003', '2', '1', '2100022', '900037', '0', '0,2004038,2011038,2100022');
INSERT INTO `t_zone_battle_round` VALUES ('71008004', '1', '0', '0', '0', '0', '2005038,2008038,2013038,2002038');
INSERT INTO `t_zone_battle_round` VALUES ('71008004', '2', '0', '0', '0', '0', '2013038,2013038,2004038,2011038');
INSERT INTO `t_zone_battle_round` VALUES ('71008005', '1', '0', '0', '0', '0', '2005038,2008038,2013038,2013038');
INSERT INTO `t_zone_battle_round` VALUES ('71008005', '2', '0', '0', '0', '0', '2013038,2002038,2004038,2011038');
INSERT INTO `t_zone_battle_round` VALUES ('71008006', '1', '0', '0', '0', '0', '2008039,2013039,2002039,2004039');
INSERT INTO `t_zone_battle_round` VALUES ('71008006', '2', '1', '2100023', '900038', '0', '0,2013039,2002039,2100023');
INSERT INTO `t_zone_battle_round` VALUES ('71008007', '1', '0', '0', '0', '0', '2011039,2005039,2008039,2013039');
INSERT INTO `t_zone_battle_round` VALUES ('71008007', '2', '0', '0', '0', '0', '2005039,2008039,2013039,2005039');
INSERT INTO `t_zone_battle_round` VALUES ('71008008', '1', '0', '0', '0', '0', '2002039,2002039,2004039,2011039');
INSERT INTO `t_zone_battle_round` VALUES ('71008008', '2', '0', '0', '0', '0', '2002039,2004039,2011039,2005039');
INSERT INTO `t_zone_battle_round` VALUES ('71008009', '1', '0', '0', '0', '0', '2005040,2008040,2013040,2002040');
INSERT INTO `t_zone_battle_round` VALUES ('71008009', '2', '0', '0', '0', '0', '2008040,2013040,2002040,2004040');
INSERT INTO `t_zone_battle_round` VALUES ('71008009', '3', '1', '2100024', '900039', '0', '0,2008040,2013040,2100024');
INSERT INTO `t_zone_battle_round` VALUES ('71009001', '1', '0', '0', '0', '0', '2008040,2011040,2013040,2011040');
INSERT INTO `t_zone_battle_round` VALUES ('71009001', '2', '0', '0', '0', '0', '2011040,2002040,2003040,2008040');
INSERT INTO `t_zone_battle_round` VALUES ('71009002', '1', '0', '0', '0', '0', '2013040,2011040,2002040,2011040');
INSERT INTO `t_zone_battle_round` VALUES ('71009002', '2', '0', '0', '0', '0', '2011040,2013040,2011040,2002040');
INSERT INTO `t_zone_battle_round` VALUES ('71009003', '1', '0', '0', '0', '0', '2011041,2002041,2008041,2008041');
INSERT INTO `t_zone_battle_round` VALUES ('71009003', '2', '1', '2100025', '900040', '0', '0,2002041,2008041,2100025');
INSERT INTO `t_zone_battle_round` VALUES ('71009004', '1', '0', '0', '0', '0', '2003041,2008041,2011041,2013041');
INSERT INTO `t_zone_battle_round` VALUES ('71009004', '2', '0', '0', '0', '0', '2013041,2011041,2002041,2003041');
INSERT INTO `t_zone_battle_round` VALUES ('71009005', '1', '0', '0', '0', '0', '2002041,2003041,2011041,2011041');
INSERT INTO `t_zone_battle_round` VALUES ('71009005', '2', '0', '0', '0', '0', '2011041,2002041,2008041,2008041');
INSERT INTO `t_zone_battle_round` VALUES ('71009006', '1', '0', '0', '0', '0', '2008042,2011042,2013042,2011042');
INSERT INTO `t_zone_battle_round` VALUES ('71009006', '2', '1', '2100026', '900041', '0', '0,2011042,2013042,2100026');
INSERT INTO `t_zone_battle_round` VALUES ('71009007', '1', '0', '0', '0', '0', '2002042,2003042,2008042,2011042');
INSERT INTO `t_zone_battle_round` VALUES ('71009007', '2', '0', '0', '0', '0', '2011042,2013042,2011042,2002042');
INSERT INTO `t_zone_battle_round` VALUES ('71009008', '1', '0', '0', '0', '0', '2008042,2013042,2013042,2011042');
INSERT INTO `t_zone_battle_round` VALUES ('71009008', '2', '0', '0', '0', '0', '2003042,2002042,2011042,2003042');
INSERT INTO `t_zone_battle_round` VALUES ('71009009', '1', '0', '0', '0', '0', '2002043,2003043,2011043,2011043');
INSERT INTO `t_zone_battle_round` VALUES ('71009009', '2', '0', '0', '0', '0', '2011043,2002043,2008043,2008043');
INSERT INTO `t_zone_battle_round` VALUES ('71009009', '3', '1', '2100027', '900042', '0', '0,2011043,2002043,2100027');
INSERT INTO `t_zone_battle_round` VALUES ('72001001', '1', '1', '3000001', '0', '0', '0,0,0,3000001');
INSERT INTO `t_zone_battle_round` VALUES ('72001001', '2', '1', '3000002', '0', '0', '0,0,0,3000002');
INSERT INTO `t_zone_battle_round` VALUES ('72001001', '3', '1', '3000003', '0', '0', '0,3100002,3100001,3000003');
INSERT INTO `t_zone_battle_round` VALUES ('72001002', '1', '1', '3000004', '0', '0', '0,0,0,3000004');
INSERT INTO `t_zone_battle_round` VALUES ('72001002', '2', '1', '3000005', '0', '0', '0,0,0,3000005');
INSERT INTO `t_zone_battle_round` VALUES ('72001002', '3', '1', '3000006', '0', '0', '0,3100004,3100003,3000006');
INSERT INTO `t_zone_battle_round` VALUES ('72001003', '1', '1', '3000007', '0', '0', '0,0,0,3000007');
INSERT INTO `t_zone_battle_round` VALUES ('72001003', '2', '1', '3000008', '0', '0', '0,0,0,3000008');
INSERT INTO `t_zone_battle_round` VALUES ('72001003', '3', '1', '3000009', '0', '0', '0,3100006,3100005,3000009');
INSERT INTO `t_zone_battle_round` VALUES ('72002001', '1', '1', '3000010', '0', '0', '0,0,0,3000010');
INSERT INTO `t_zone_battle_round` VALUES ('72002001', '2', '1', '3000011', '0', '0', '0,0,0,3000011');
INSERT INTO `t_zone_battle_round` VALUES ('72002001', '3', '1', '3000012', '0', '0', '0,3100008,3100007,3000012');
INSERT INTO `t_zone_battle_round` VALUES ('72002002', '1', '1', '3000013', '0', '0', '0,0,0,3000013');
INSERT INTO `t_zone_battle_round` VALUES ('72002002', '2', '1', '3000014', '0', '0', '0,0,0,3000014');
INSERT INTO `t_zone_battle_round` VALUES ('72002002', '3', '1', '3000015', '0', '0', '0,3100010,3100009,3000015');
INSERT INTO `t_zone_battle_round` VALUES ('72002003', '1', '1', '3000016', '0', '0', '0,0,0,3000016');
INSERT INTO `t_zone_battle_round` VALUES ('72002003', '2', '1', '3000017', '0', '0', '0,0,0,3000017');
INSERT INTO `t_zone_battle_round` VALUES ('72002003', '3', '1', '3000018', '0', '0', '0,3100012,3100011,3000018');
INSERT INTO `t_zone_battle_round` VALUES ('72003001', '1', '1', '3000019', '0', '0', '0,0,0,3000019');
INSERT INTO `t_zone_battle_round` VALUES ('72003001', '2', '1', '3000020', '0', '0', '0,0,0,3000020');
INSERT INTO `t_zone_battle_round` VALUES ('72003001', '3', '1', '3000021', '0', '0', '0,2012037,3100013,3000021');
INSERT INTO `t_zone_battle_round` VALUES ('72003002', '1', '1', '3000022', '0', '0', '0,0,0,3000022');
INSERT INTO `t_zone_battle_round` VALUES ('72003002', '2', '1', '3000023', '0', '0', '0,0,0,3000023');
INSERT INTO `t_zone_battle_round` VALUES ('72003002', '3', '1', '3000024', '0', '0', '0,3100016,3100015,3000024');
INSERT INTO `t_zone_battle_round` VALUES ('72003003', '1', '1', '3000025', '0', '0', '0,0,0,3000025');
INSERT INTO `t_zone_battle_round` VALUES ('72003003', '2', '1', '3000026', '0', '0', '0,0,0,3000026');
INSERT INTO `t_zone_battle_round` VALUES ('72003003', '3', '1', '3000027', '0', '0', '0,3100018,3100017,3000027');
INSERT INTO `t_zone_battle_round` VALUES ('73001001', '1', '1', '3000001', '0', '0', '0,0,0,3000001');
INSERT INTO `t_zone_battle_round` VALUES ('73001002', '1', '1', '3000002', '0', '0', '0,0,0,3000002');
INSERT INTO `t_zone_battle_round` VALUES ('73001003', '1', '1', '3000003', '0', '0', '0,3100002,3100001,3000003');
INSERT INTO `t_zone_battle_round` VALUES ('73001004', '1', '1', '3000004', '0', '0', '0,0,0,3000004');
INSERT INTO `t_zone_battle_round` VALUES ('73001005', '1', '1', '3000005', '0', '0', '0,0,0,3000005');
INSERT INTO `t_zone_battle_round` VALUES ('73001006', '1', '1', '3000006', '0', '0', '0,3100004,3100003,3000006');
INSERT INTO `t_zone_battle_round` VALUES ('73001007', '1', '1', '3000007', '0', '0', '0,0,0,3000007');
INSERT INTO `t_zone_battle_round` VALUES ('73001008', '1', '1', '3000008', '0', '0', '0,0,0,3000008');
INSERT INTO `t_zone_battle_round` VALUES ('73001009', '1', '1', '3000009', '0', '0', '0,3100006,3100005,3000009');
INSERT INTO `t_zone_battle_round` VALUES ('73001010', '1', '1', '3000010', '0', '0', '0,0,0,3000010');
INSERT INTO `t_zone_battle_round` VALUES ('73001011', '1', '1', '3000011', '0', '0', '0,0,0,3000011');
INSERT INTO `t_zone_battle_round` VALUES ('73001012', '1', '1', '3000012', '0', '0', '0,3100008,3100007,3000012');
INSERT INTO `t_zone_battle_round` VALUES ('73001013', '1', '1', '3000013', '0', '0', '0,0,0,3000013');
INSERT INTO `t_zone_battle_round` VALUES ('73001014', '1', '1', '3000014', '0', '0', '0,0,0,3000014');
INSERT INTO `t_zone_battle_round` VALUES ('73001015', '1', '1', '3000015', '0', '0', '0,3100010,3100009,3000015');
INSERT INTO `t_zone_battle_round` VALUES ('73001016', '1', '1', '3000016', '0', '0', '0,0,0,3000016');
INSERT INTO `t_zone_battle_round` VALUES ('73001017', '1', '1', '3000017', '0', '0', '0,0,0,3000017');
INSERT INTO `t_zone_battle_round` VALUES ('73001018', '1', '1', '3000018', '0', '0', '0,3100012,3100011,3000018');
INSERT INTO `t_zone_battle_round` VALUES ('73001019', '1', '1', '3000019', '0', '0', '0,0,0,3000019');
INSERT INTO `t_zone_battle_round` VALUES ('73001020', '1', '1', '3000020', '0', '0', '0,0,0,3000020');
INSERT INTO `t_zone_battle_round` VALUES ('73002001', '1', '1', '3000021', '0', '0', '0,2012037,3100013,3000021');
INSERT INTO `t_zone_battle_round` VALUES ('73002002', '1', '1', '3000022', '0', '0', '0,0,0,3000022');
INSERT INTO `t_zone_battle_round` VALUES ('73002003', '1', '1', '3000023', '0', '0', '0,0,0,3000023');
INSERT INTO `t_zone_battle_round` VALUES ('73002004', '1', '1', '3000024', '0', '0', '0,3100016,3100015,3000024');
INSERT INTO `t_zone_battle_round` VALUES ('73003001', '1', '1', '3000025', '0', '0', '0,0,0,3000025');
INSERT INTO `t_zone_battle_round` VALUES ('73003002', '1', '1', '3000026', '0', '0', '0,0,0,3000026');
INSERT INTO `t_zone_battle_round` VALUES ('73003003', '1', '1', '3000027', '0', '0', '0,3100018,3100017,3000027');
INSERT INTO `t_zone_battle_round` VALUES ('73003004', '1', '1', '3000027', '0', '0', '0,3100018,3100017,3000027');
