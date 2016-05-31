/*
Navicat MySQL Data Transfer

Source Server         : 骑战内网
Source Server Version : 50615
Source Host           : 192.168.100.10:3306
Source Database       : db_qz_admin

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2016-05-30 17:22:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_gamebillinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_gamebillinfo`;
CREATE TABLE `t_gamebillinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_partner` int(11) NOT NULL COMMENT '平台编号',
  `n_serverId` varchar(50) NOT NULL COMMENT '服务器id',
  `n_userId` int(11) NOT NULL COMMENT '玩家id',
  `n_username` varchar(50) NOT NULL COMMENT '帐号',
  `n_playerName` varchar(50) NOT NULL COMMENT '玩家昵称',
  `n_level` int(11) NOT NULL COMMENT '玩家等级',
  `n_payGoodsId` int(11) NOT NULL COMMENT '支付商品编号',
  `n_bill` varchar(50) NOT NULL COMMENT '订单编号',
  `n_state` int(11) NOT NULL COMMENT '发货状态',
  `n_money` int(11) NOT NULL COMMENT '商品价格',
  `n_time` int(11) NOT NULL COMMENT '订单创建时间',
  `n_confirmTime` int(11) NOT NULL COMMENT '确认订单时间',
  `n_completeTime` int(11) NOT NULL COMMENT '完成发货时间',
  `n_receiptDatas` varchar(1024) NOT NULL DEFAULT '' COMMENT '支付凭证',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=967 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gamebillinfo
-- ----------------------------
INSERT INTO `t_gamebillinfo` VALUES ('70', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '1', '1', '7a73b4bd-fb20-4f6b-9c2f-5455d51de5a3', '2', '6', '1457920350', '1457920351', '1457920351', '');
INSERT INTO `t_gamebillinfo` VALUES ('71', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '1', '1', 'a8f5f480-cdc2-48ff-aa34-c5f7e901989c', '2', '6', '1457920352', '1457920352', '1457920353', '');
INSERT INTO `t_gamebillinfo` VALUES ('72', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '1', '2', 'b55f3db9-c207-433c-bd64-2a572c024e7e', '2', '12', '1457920356', '1457920356', '1457920356', '');
INSERT INTO `t_gamebillinfo` VALUES ('73', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '1', '1', '5d823bfc-70d5-442e-8d19-bea6e06c63b1', '2', '6', '1457920361', '1457920362', '1457920362', '');
INSERT INTO `t_gamebillinfo` VALUES ('74', '1', 'qz_test_5', '1394', 'six', 'six', '48', '3', 'dbb2a36d-24c7-4aad-bf79-376fb5848a63', '2', '30', '1457920536', '1457920536', '1457920536', '');
INSERT INTO `t_gamebillinfo` VALUES ('75', '1', 'qz_test_5', '1394', 'six', 'six', '48', '3', 'a02f0765-e5e8-4896-bd26-127396ea288b', '2', '30', '1457920546', '1457920547', '1457920547', '');
INSERT INTO `t_gamebillinfo` VALUES ('76', '1', 'qz_test_5', '1394', 'six', 'six', '48', '3', '971f9236-89c8-495c-af98-94492f1e772e', '2', '30', '1457920548', '1457920551', '1457920551', '');
INSERT INTO `t_gamebillinfo` VALUES ('77', '1', 'qz_test_5', '1394', 'six', 'six', '48', '4', 'fac02f4e-7b92-41dc-9e26-9f2795c45a81', '2', '60', '1457920565', '1457920566', '1457920566', '');
INSERT INTO `t_gamebillinfo` VALUES ('78', '1', 'qz_test_5', '1394', 'six', 'six', '48', '4', '7195ba34-f083-40ed-ab66-1c34bfa0ecc1', '2', '60', '1457920588', '1457920588', '1457920589', '');
INSERT INTO `t_gamebillinfo` VALUES ('79', '1', 'qz_test_5', '1394', 'six', 'six', '48', '4', '620e1c0f-c5ec-48b2-8443-38cdae64094c', '2', '60', '1457920590', '1457920591', '1457920591', '');
INSERT INTO `t_gamebillinfo` VALUES ('80', '1', 'qz_test_5', '1394', 'six', 'six', '48', '4', '6ff37322-c9b2-46bc-914c-302a4834ac93', '2', '60', '1457920602', '1457920602', '1457920602', '');
INSERT INTO `t_gamebillinfo` VALUES ('81', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '2', '1da9cccf-5bef-4664-b464-ca753056dee1', '2', '12', '1457921000', '1457921000', '1457921000', '');
INSERT INTO `t_gamebillinfo` VALUES ('82', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '1', 'c0fcd2a5-3d9b-45a6-8873-19f9163e39af', '2', '6', '1457921001', '1457921001', '1457921002', '');
INSERT INTO `t_gamebillinfo` VALUES ('83', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '98061774-fd15-49e7-b6dd-673040657629', '2', '30', '1457921003', '1457921003', '1457921003', '');
INSERT INTO `t_gamebillinfo` VALUES ('84', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '26616b8a-2afb-4a15-b3cc-d4472ee43097', '2', '30', '1457921004', '1457921004', '1457921004', '');
INSERT INTO `t_gamebillinfo` VALUES ('85', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '53c5d779-39ba-4d75-b68c-cefd60c3fd8e', '2', '30', '1457921004', '1457921004', '1457921004', '');
INSERT INTO `t_gamebillinfo` VALUES ('86', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '4de54082-98de-41e6-a76f-d6b3b2b0dc04', '2', '30', '1457921005', '1457921005', '1457921005', '');
INSERT INTO `t_gamebillinfo` VALUES ('87', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', 'bf46680e-879c-4ae7-95d3-2218e44e1b02', '2', '30', '1457921006', '1457921006', '1457921006', '');
INSERT INTO `t_gamebillinfo` VALUES ('88', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '2', '0e20f3bd-59c0-4b8a-bb60-45967493f89e', '2', '12', '1457921006', '1457921006', '1457921007', '');
INSERT INTO `t_gamebillinfo` VALUES ('89', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '1', '5cab2c52-7e0c-48a3-830a-c34c8ec0af65', '2', '6', '1457921007', '1457921007', '1457921007', '');
INSERT INTO `t_gamebillinfo` VALUES ('90', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '1', '9c5d3bba-3915-4ecd-89f0-828f414a94f1', '2', '6', '1457921008', '1457921008', '1457921008', '');
INSERT INTO `t_gamebillinfo` VALUES ('91', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '1', '2143e935-2a68-4aa5-8240-67505e375841', '2', '6', '1457921008', '1457921009', '1457921009', '');
INSERT INTO `t_gamebillinfo` VALUES ('92', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '2', '7e80a8c0-6f92-4725-9bfb-f1326edfb5a2', '2', '12', '1457921009', '1457921009', '1457921009', '');
INSERT INTO `t_gamebillinfo` VALUES ('93', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '33599f20-fff9-4866-9402-982387d55282', '2', '30', '1457921010', '1457921010', '1457921010', '');
INSERT INTO `t_gamebillinfo` VALUES ('94', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', 'ea192403-ce68-41f8-a153-2a3d0c9c875d', '2', '30', '1457921011', '1457921011', '1457921011', '');
INSERT INTO `t_gamebillinfo` VALUES ('95', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '3a39efdc-4a6d-4de8-85f4-d59bf438ee25', '2', '30', '1457921012', '1457921012', '1457921012', '');
INSERT INTO `t_gamebillinfo` VALUES ('96', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '9c4fb031-ef3c-486d-9e34-1d8f127da09c', '2', '30', '1457921012', '1457921012', '1457921012', '');
INSERT INTO `t_gamebillinfo` VALUES ('97', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '615ad6ce-1159-4212-8be3-84dffdc5ab5a', '2', '30', '1457921013', '1457921013', '1457921013', '');
INSERT INTO `t_gamebillinfo` VALUES ('98', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', 'c3aa0f93-4f6c-4df2-8ba4-5a4de4e676c3', '2', '30', '1457921013', '1457921013', '1457921014', '');
INSERT INTO `t_gamebillinfo` VALUES ('99', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '2', '9ae03fc6-b377-4679-b50f-28308d69fa5f', '2', '12', '1457921039', '1457921039', '1457921039', '');
INSERT INTO `t_gamebillinfo` VALUES ('100', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '2', '5455c66a-ae7b-4317-ba54-ac4a7ade424e', '2', '12', '1457921040', '1457921040', '1457921040', '');
INSERT INTO `t_gamebillinfo` VALUES ('101', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', 'af4a86d8-4acc-428e-bc96-49ae16720021', '2', '30', '1457921042', '1457921042', '1457921042', '');
INSERT INTO `t_gamebillinfo` VALUES ('102', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '108ca905-40d0-4a74-8be9-272b6be4f04d', '2', '30', '1457921042', '1457921042', '1457921042', '');
INSERT INTO `t_gamebillinfo` VALUES ('103', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '301a71de-427f-4acb-b9e8-cbcedc266214', '2', '30', '1457921043', '1457921043', '1457921044', '');
INSERT INTO `t_gamebillinfo` VALUES ('104', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', 'cd0614b7-edab-4c41-83d7-a119aca6fdff', '2', '30', '1457921044', '1457921044', '1457921044', '');
INSERT INTO `t_gamebillinfo` VALUES ('105', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '2f44c565-7f45-4354-ae1a-392b341da40a', '2', '30', '1457921045', '1457921045', '1457921045', '');
INSERT INTO `t_gamebillinfo` VALUES ('106', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '42754a78-2af2-4ee5-8eed-6b964d927a77', '2', '30', '1457921046', '1457921046', '1457921046', '');
INSERT INTO `t_gamebillinfo` VALUES ('107', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '1ecfad88-d9a7-4da7-8eba-c472e22ad656', '2', '30', '1457921047', '1457921047', '1457921047', '');
INSERT INTO `t_gamebillinfo` VALUES ('108', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', 'ccb51958-a6be-41e2-ba39-790c3631f63b', '2', '30', '1457921047', '1457921047', '1457921048', '');
INSERT INTO `t_gamebillinfo` VALUES ('109', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '210f2787-b656-4d18-9b84-2e2e1bd32577', '2', '30', '1457921048', '1457921048', '1457921048', '');
INSERT INTO `t_gamebillinfo` VALUES ('110', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '49c2a68e-e577-4618-bf46-5feab276b4d5', '2', '30', '1457921049', '1457921049', '1457921049', '');
INSERT INTO `t_gamebillinfo` VALUES ('111', '1', 'qz_test_5', '1394', 'six', 'six', '52', '3', '359cd4a9-1e86-4441-87a0-b311704d1323', '2', '30', '1457921073', '1457921073', '1457921073', '');
INSERT INTO `t_gamebillinfo` VALUES ('112', '1', 'qz_test_5', '1394', 'six', 'six', '52', '3', '4250748b-9e5f-437a-9ec5-7a796a668f51', '2', '30', '1457921074', '1457921075', '1457921075', '');
INSERT INTO `t_gamebillinfo` VALUES ('113', '1', 'qz_test_5', '1394', 'six', 'six', '52', '2', '8f3207c0-389e-49f2-9668-ab0f507630ba', '2', '12', '1457921079', '1457921080', '1457921080', '');
INSERT INTO `t_gamebillinfo` VALUES ('114', '1', 'qz_test_5', '1394', 'six', 'six', '52', '2', '66ef4a9a-7190-45fb-9829-659c6c9e3281', '2', '12', '1457921081', '1457921081', '1457921082', '');
INSERT INTO `t_gamebillinfo` VALUES ('115', '1', 'qz_test_5', '1394', 'six', 'six', '52', '2', '107f0b53-a24b-4061-866c-4046d541acd5', '2', '12', '1457921083', '1457921083', '1457921083', '');
INSERT INTO `t_gamebillinfo` VALUES ('116', '1', 'qz_test_5', '1394', 'six', 'six', '52', '2', '884cf4a6-4efd-4ce8-a689-fc61473cbf05', '2', '12', '1457921084', '1457921084', '1457921084', '');
INSERT INTO `t_gamebillinfo` VALUES ('117', '1', 'qz_test_5', '1394', 'six', 'six', '52', '2', '9ed14f23-3bd6-4648-b90d-d1ba3db86532', '2', '12', '1457921085', '1457921085', '1457921085', '');
INSERT INTO `t_gamebillinfo` VALUES ('118', '1', 'qz_test_5', '1394', 'six', 'six', '52', '3', '9fb74a8b-ead7-4790-aacf-6e6abbc84b9c', '2', '30', '1457921088', '1457921088', '1457921088', '');
INSERT INTO `t_gamebillinfo` VALUES ('119', '1', 'qz_test_5', '1394', 'six', 'six', '52', '3', '3479dfce-9061-4754-8048-151c7afee9b8', '2', '30', '1457921090', '1457921091', '1457921091', '');
INSERT INTO `t_gamebillinfo` VALUES ('120', '1', 'qz_test_5', '1394', 'six', 'six', '52', '3', 'c28fdd74-2f68-4eee-b228-4cadfcef88c9', '2', '30', '1457921091', '1457921093', '1457921093', '');
INSERT INTO `t_gamebillinfo` VALUES ('121', '1', 'qz_test_5', '1394', 'six', 'six', '52', '2', '3e186b28-d86b-4105-b45f-122277457c17', '2', '12', '1457921095', '1457921095', '1457921095', '');
INSERT INTO `t_gamebillinfo` VALUES ('122', '1', 'qz_test_5', '1394', 'six', 'six', '52', '2', 'b752772c-dbed-4b05-8e8f-f00e49e5cba4', '2', '12', '1457921099', '1457921099', '1457921099', '');
INSERT INTO `t_gamebillinfo` VALUES ('123', '1', 'qz_test_5', '1394', 'six', 'six', '52', '3', '188b296f-2fed-4d48-b051-448e797d802a', '2', '30', '1457921105', '1457921105', '1457921105', '');
INSERT INTO `t_gamebillinfo` VALUES ('124', '1', 'qz_test_5', '1394', 'six', 'six', '52', '3', '3debdd7d-5e53-473a-a2a5-942908198cc0', '2', '30', '1457921108', '1457921109', '1457921109', '');
INSERT INTO `t_gamebillinfo` VALUES ('125', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '2', 'b299ff60-5696-4091-a719-c59d7ea09c7b', '2', '12', '1457921122', '1457921122', '1457921122', '');
INSERT INTO `t_gamebillinfo` VALUES ('126', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '4b855910-81eb-4b24-b645-5d506be71612', '2', '30', '1457921124', '1457921124', '1457921124', '');
INSERT INTO `t_gamebillinfo` VALUES ('127', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '24167f45-96c1-47ef-aab8-72a47cfd868b', '2', '30', '1457921125', '1457921125', '1457921125', '');
INSERT INTO `t_gamebillinfo` VALUES ('128', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', 'aadefd96-90fc-423f-a6dd-4501bd41868c', '2', '30', '1457921125', '1457921125', '1457921125', '');
INSERT INTO `t_gamebillinfo` VALUES ('129', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '4c7701b2-1f7f-430a-9185-3eae62918a7e', '2', '30', '1457921127', '1457921127', '1457921127', '');
INSERT INTO `t_gamebillinfo` VALUES ('130', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', 'db7c810e-5cf7-49ec-ba79-7092bcc9553d', '2', '30', '1457921127', '1457921127', '1457921127', '');
INSERT INTO `t_gamebillinfo` VALUES ('131', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', 'e0f6c7f9-b2e4-473f-b711-4dcfc53c04b7', '2', '30', '1457921128', '1457921128', '1457921128', '');
INSERT INTO `t_gamebillinfo` VALUES ('132', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '0ee84af9-e104-446c-8826-860f26adb470', '2', '30', '1457921129', '1457921129', '1457921129', '');
INSERT INTO `t_gamebillinfo` VALUES ('133', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '70316997-405a-4a70-ac28-d73fbd88217b', '2', '30', '1457921130', '1457921130', '1457921130', '');
INSERT INTO `t_gamebillinfo` VALUES ('134', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '89a62bb1-ceda-4ace-b46d-913edbc86166', '2', '30', '1457921130', '1457921130', '1457921131', '');
INSERT INTO `t_gamebillinfo` VALUES ('135', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '21c86308-dd51-4ec7-b309-2065bb3da487', '2', '30', '1457921133', '1457921133', '1457921133', '');
INSERT INTO `t_gamebillinfo` VALUES ('136', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '2', '4640bce1-37fb-4e53-a8f8-2124ccbeb533', '2', '12', '1457921322', '1457921322', '1457921322', '');
INSERT INTO `t_gamebillinfo` VALUES ('137', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '2', 'ab7873c1-8373-488d-8936-8f62bf83a826', '2', '12', '1457921323', '1457921323', '1457921323', '');
INSERT INTO `t_gamebillinfo` VALUES ('138', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '2', 'd63b297c-9b77-41b8-9fe8-8a3f07ce79bb', '2', '12', '1457921323', '1457921324', '1457921324', '');
INSERT INTO `t_gamebillinfo` VALUES ('139', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '3c0b053b-e15e-48e4-a309-decf8b153a60', '2', '30', '1457921490', '1457921491', '1457921491', '');
INSERT INTO `t_gamebillinfo` VALUES ('140', '1', 'qz_test_5', '1230', 'mmm', '念泽宇ll', '7', '3', '4813eec3-405c-40dd-8083-32b8baa3759f', '2', '30', '1457921491', '1457921491', '1457921491', '');
INSERT INTO `t_gamebillinfo` VALUES ('141', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', 'adfa5fa3-586c-42dc-a697-a1571d172bc1', '2', '30', '1457926807', '1457926808', '1457926808', '');
INSERT INTO `t_gamebillinfo` VALUES ('142', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '578153c0-ea29-41a2-b7d7-c68a7bd3af94', '2', '30', '1457926808', '1457926808', '1457926808', '');
INSERT INTO `t_gamebillinfo` VALUES ('143', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', 'f518c11e-9fcf-40e0-b9b4-eadb3845771d', '2', '30', '1457926808', '1457926808', '1457926808', '');
INSERT INTO `t_gamebillinfo` VALUES ('144', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '21afe1b3-ace5-49da-a836-39d7aece5ff6', '2', '30', '1457926809', '1457926809', '1457926809', '');
INSERT INTO `t_gamebillinfo` VALUES ('145', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', 'f0cad943-2972-4849-bb7c-633842f21e50', '2', '30', '1457926809', '1457926809', '1457926809', '');
INSERT INTO `t_gamebillinfo` VALUES ('146', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', 'f2d926f6-ee9f-4b91-b38f-7a20765f8bb2', '2', '30', '1457926809', '1457926809', '1457926809', '');
INSERT INTO `t_gamebillinfo` VALUES ('147', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '8f2e4ca6-3b18-41b3-b699-4b07c41bffdd', '2', '30', '1457926811', '1457926812', '1457926812', '');
INSERT INTO `t_gamebillinfo` VALUES ('148', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '96bd16e0-a25b-4e70-b96a-2b7d38682a88', '2', '30', '1457926812', '1457926812', '1457926812', '');
INSERT INTO `t_gamebillinfo` VALUES ('149', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '75e1ffbb-407c-478c-91a2-f5feb3c9f71e', '2', '30', '1457926814', '1457926814', '1457926814', '');
INSERT INTO `t_gamebillinfo` VALUES ('150', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', 'd1d2544c-2a63-4d3a-a0c9-795d9b465c44', '2', '30', '1457926814', '1457926814', '1457926814', '');
INSERT INTO `t_gamebillinfo` VALUES ('151', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '61e09850-94c2-4fe1-bba2-f622cb910b5d', '2', '30', '1457926814', '1457926814', '1457926814', '');
INSERT INTO `t_gamebillinfo` VALUES ('152', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '8aa6a590-096a-4c5e-99c1-8697ffa456f7', '2', '30', '1457926814', '1457926815', '1457926815', '');
INSERT INTO `t_gamebillinfo` VALUES ('153', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', 'dd25325d-3bda-4219-a237-e789299fada2', '2', '30', '1457926815', '1457926815', '1457926815', '');
INSERT INTO `t_gamebillinfo` VALUES ('154', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', 'dc882411-a522-4c0e-afde-39bc53e24d05', '2', '30', '1457926815', '1457926815', '1457926815', '');
INSERT INTO `t_gamebillinfo` VALUES ('155', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', 'a575ba9b-be60-416a-8554-30bb250f4d6b', '2', '30', '1457926815', '1457926816', '1457926816', '');
INSERT INTO `t_gamebillinfo` VALUES ('156', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '29a344ae-6563-4009-be5a-6371a471467c', '2', '30', '1457926816', '1457926816', '1457926816', '');
INSERT INTO `t_gamebillinfo` VALUES ('157', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '6f30a682-62a7-45c8-bbfe-d194976e7547', '2', '30', '1457926816', '1457926817', '1457926817', '');
INSERT INTO `t_gamebillinfo` VALUES ('158', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '01908afc-0583-430f-ae25-ec1a9eba86fe', '2', '30', '1457926817', '1457926817', '1457926817', '');
INSERT INTO `t_gamebillinfo` VALUES ('159', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '7fecfd76-b056-4018-8572-f50b335d8375', '2', '30', '1457926819', '1457926819', '1457926820', '');
INSERT INTO `t_gamebillinfo` VALUES ('160', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', 'ce91c009-9818-429e-a732-5eead3d89880', '2', '30', '1457926819', '1457926820', '1457926820', '');
INSERT INTO `t_gamebillinfo` VALUES ('161', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '3785b677-31d0-4eb4-971a-b70ff51151ea', '2', '30', '1457926820', '1457926820', '1457926821', '');
INSERT INTO `t_gamebillinfo` VALUES ('162', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', 'c2ec100d-13f3-4510-a05d-d8600d982e0d', '2', '30', '1457926820', '1457926821', '1457926821', '');
INSERT INTO `t_gamebillinfo` VALUES ('163', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '7cc9e972-9fac-4bb2-affa-6f512091edec', '2', '30', '1457926820', '1457926821', '1457926821', '');
INSERT INTO `t_gamebillinfo` VALUES ('164', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', 'fbba747c-6b7b-4e45-82da-623fc78c6bf4', '2', '30', '1457926821', '1457926821', '1457926821', '');
INSERT INTO `t_gamebillinfo` VALUES ('165', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '3b8e84eb-40e6-44be-b73c-9c31e83cdafc', '2', '30', '1457926821', '1457926821', '1457926822', '');
INSERT INTO `t_gamebillinfo` VALUES ('166', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', 'c8d0eabf-3599-448c-b521-bf9f06f3e5dc', '2', '30', '1457926821', '1457926822', '1457926823', '');
INSERT INTO `t_gamebillinfo` VALUES ('167', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '18ac7a48-70ab-4fea-8721-60f5e40af2ab', '2', '30', '1457926822', '1457926822', '1457926823', '');
INSERT INTO `t_gamebillinfo` VALUES ('168', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '78194a30-ac00-4aec-a184-7e2888a13838', '2', '30', '1457926822', '1457926822', '1457926822', '');
INSERT INTO `t_gamebillinfo` VALUES ('169', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '9f6950a9-bcba-4802-a7ca-bc5ef26acc0d', '2', '30', '1457926822', '1457926822', '1457926823', '');
INSERT INTO `t_gamebillinfo` VALUES ('170', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', 'b8bc695a-dfb0-4db8-b4fc-ce2ac1241266', '2', '30', '1457926822', '1457926823', '1457926823', '');
INSERT INTO `t_gamebillinfo` VALUES ('171', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', 'fb783c92-9821-4faa-888a-8e030297404f', '2', '30', '1457926822', '1457926823', '1457926823', '');
INSERT INTO `t_gamebillinfo` VALUES ('172', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '6873f3c9-d447-4ca5-b5b5-df4f1d57931e', '2', '30', '1457926823', '1457926823', '1457926823', '');
INSERT INTO `t_gamebillinfo` VALUES ('173', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '021b6d2a-c702-4549-9c27-1fbd4f3c9a9d', '2', '30', '1457926823', '1457926823', '1457926823', '');
INSERT INTO `t_gamebillinfo` VALUES ('174', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', 'e7bb8468-0aa9-47ce-9bb3-7b6fe09e3674', '2', '30', '1457926823', '1457926824', '1457926824', '');
INSERT INTO `t_gamebillinfo` VALUES ('175', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', 'd63dd3d0-fbcc-491e-918b-016ecff36e99', '2', '30', '1457926823', '1457926824', '1457926824', '');
INSERT INTO `t_gamebillinfo` VALUES ('176', '1', 'qz_test_5', '1424', 'v1', '端滨海', '1', '3', '1dd608b9-79e5-4832-82b0-106a3ce5cb6b', '2', '30', '1457926824', '1457926824', '1457926824', '');
INSERT INTO `t_gamebillinfo` VALUES ('177', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'c3f070f4-fb7c-418c-b0bd-5bbf73e08b84', '2', '30', '1457936150', '1457936150', '1457936150', '');
INSERT INTO `t_gamebillinfo` VALUES ('178', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'abf6b9bb-2e4c-414c-b573-3eed68b50320', '2', '30', '1457936150', '1457936151', '1457936151', '');
INSERT INTO `t_gamebillinfo` VALUES ('179', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'ac6a0331-5eba-4a90-9e80-37b70ca5851d', '2', '30', '1457936151', '1457936152', '1457936152', '');
INSERT INTO `t_gamebillinfo` VALUES ('180', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'e257c41a-524b-45d0-aa79-454464b45c16', '2', '30', '1457936152', '1457936152', '1457936153', '');
INSERT INTO `t_gamebillinfo` VALUES ('181', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '255060b3-f23b-4d05-bba2-6e01a9062e69', '2', '30', '1457936154', '1457936154', '1457936154', '');
INSERT INTO `t_gamebillinfo` VALUES ('182', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '140bfb0c-b4a5-4c5f-9ff5-00fc711f0583', '2', '30', '1457936156', '1457936156', '1457936156', '');
INSERT INTO `t_gamebillinfo` VALUES ('183', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '40709280-6aed-4e12-8f9d-97a6bd4f6f4e', '2', '30', '1457936156', '1457936156', '1457936156', '');
INSERT INTO `t_gamebillinfo` VALUES ('184', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'f820a2b4-37a1-447d-8281-de43dea90356', '2', '30', '1457936156', '1457936157', '1457936157', '');
INSERT INTO `t_gamebillinfo` VALUES ('185', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'a197fb62-d0a8-4910-b688-2ad067c8dae1', '2', '30', '1457936157', '1457936157', '1457936158', '');
INSERT INTO `t_gamebillinfo` VALUES ('186', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '967aed5b-a48e-4e82-a670-a84c572d843d', '2', '30', '1457936157', '1457936158', '1457936158', '');
INSERT INTO `t_gamebillinfo` VALUES ('187', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '7d972c27-14a8-4ecf-a7af-e20600e9c4fc', '2', '30', '1457936158', '1457936158', '1457936158', '');
INSERT INTO `t_gamebillinfo` VALUES ('188', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '4431663c-e667-4efc-83af-461a868d79b7', '2', '30', '1457936158', '1457936158', '1457936158', '');
INSERT INTO `t_gamebillinfo` VALUES ('189', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '8794c19c-29b7-4c31-b63d-a7e31a3cee5e', '2', '30', '1457936158', '1457936158', '1457936159', '');
INSERT INTO `t_gamebillinfo` VALUES ('190', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'ea9f3954-6825-4fd4-8405-ecf6eefde917', '2', '30', '1457936158', '1457936159', '1457936159', '');
INSERT INTO `t_gamebillinfo` VALUES ('191', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'adb0a24e-b08d-42df-9584-54872dde88a1', '2', '30', '1457936159', '1457936159', '1457936159', '');
INSERT INTO `t_gamebillinfo` VALUES ('192', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '45fca142-afdb-45e1-9cc3-b83c56cda1f7', '2', '30', '1457936159', '1457936161', '1457936162', '');
INSERT INTO `t_gamebillinfo` VALUES ('193', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '5a9e3839-5241-4af6-9be7-8ef69526cf3c', '2', '30', '1457936162', '1457936163', '1457936163', '');
INSERT INTO `t_gamebillinfo` VALUES ('194', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'd2c73132-c40e-45cc-bfa2-1dfbdf4867bc', '2', '30', '1457936163', '1457936163', '1457936164', '');
INSERT INTO `t_gamebillinfo` VALUES ('195', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'dc8b0959-f1e1-4954-a437-2637152d3956', '2', '30', '1457936164', '1457936164', '1457936164', '');
INSERT INTO `t_gamebillinfo` VALUES ('196', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '2c8b4f30-0d00-40b7-af16-42bb9af747f7', '2', '30', '1457936164', '1457936165', '1457936165', '');
INSERT INTO `t_gamebillinfo` VALUES ('197', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'da3f2b48-7cf9-4735-bc25-e49b2661f9aa', '2', '30', '1457936164', '1457936165', '1457936165', '');
INSERT INTO `t_gamebillinfo` VALUES ('198', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'f07ba5ed-b61d-4598-b174-fb2fa7105abd', '2', '30', '1457936165', '1457936165', '1457936165', '');
INSERT INTO `t_gamebillinfo` VALUES ('199', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '813d16d4-e1ae-4b34-985e-f605bc67ace9', '2', '30', '1457936165', '1457936165', '1457936165', '');
INSERT INTO `t_gamebillinfo` VALUES ('200', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'cc2d66ae-e716-4699-bb8c-10dfdde0073e', '2', '30', '1457936165', '1457936166', '1457936166', '');
INSERT INTO `t_gamebillinfo` VALUES ('201', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'e4656efd-551e-4f60-8492-8ffa998d80fb', '2', '30', '1457936166', '1457936166', '1457936166', '');
INSERT INTO `t_gamebillinfo` VALUES ('202', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '3a0b8729-710a-432d-833f-01211af62c78', '2', '30', '1457936166', '1457936166', '1457936166', '');
INSERT INTO `t_gamebillinfo` VALUES ('203', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '31d639f3-6c44-430b-a7c7-f0abf904630b', '2', '30', '1457936166', '1457936166', '1457936166', '');
INSERT INTO `t_gamebillinfo` VALUES ('204', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '590f8edc-1c7d-442e-9b1c-76ac0d406465', '2', '30', '1457936166', '1457936166', '1457936167', '');
INSERT INTO `t_gamebillinfo` VALUES ('205', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '28addd86-e25b-42f1-9e51-9bbaa054a2b9', '2', '30', '1457936166', '1457936167', '1457936167', '');
INSERT INTO `t_gamebillinfo` VALUES ('206', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'fa067bfd-70fa-4c62-b968-e07b20850e27', '2', '30', '1457936167', '1457936167', '1457936167', '');
INSERT INTO `t_gamebillinfo` VALUES ('207', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'bb3df8b5-2cd8-46ad-a7d6-e975d5977fa0', '2', '30', '1457936167', '1457936167', '1457936167', '');
INSERT INTO `t_gamebillinfo` VALUES ('208', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '34a3007e-4293-4454-97c9-39ba917d306d', '2', '30', '1457936167', '1457936167', '1457936168', '');
INSERT INTO `t_gamebillinfo` VALUES ('209', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '2878ce84-b0fa-4f62-8246-d9f1bfcf86e3', '2', '30', '1457936168', '1457936168', '1457936168', '');
INSERT INTO `t_gamebillinfo` VALUES ('210', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '01c5d4f4-24c5-4349-a9c7-71ef8d6cde5f', '2', '30', '1457936168', '1457936168', '1457936168', '');
INSERT INTO `t_gamebillinfo` VALUES ('211', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '2b38de20-108d-45ea-8720-5dcdd34d7e65', '2', '30', '1457936168', '1457936169', '1457936169', '');
INSERT INTO `t_gamebillinfo` VALUES ('212', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '4e39733b-4740-4a63-9adc-73fe9f83d8d7', '2', '30', '1457936169', '1457936169', '1457936169', '');
INSERT INTO `t_gamebillinfo` VALUES ('213', '1', 'qz_test_5', '12', '0629', '0629', '56', '1', '8cef6bb9-cc78-4931-bda3-4faf683ad64f', '2', '6', '1457936635', '1457936635', '1457936635', '');
INSERT INTO `t_gamebillinfo` VALUES ('214', '1', 'qz_test_5', '12', '0629', '0629', '56', '1', 'cdcaf49f-3757-4fb4-a73e-f084a5ad0567', '2', '6', '1457936636', '1457936636', '1457936636', '');
INSERT INTO `t_gamebillinfo` VALUES ('215', '1', 'qz_test_5', '12', '0629', '0629', '56', '1', '0e0db8b7-1fd2-4d18-bcc1-bbd47029c035', '2', '6', '1457936636', '1457936636', '1457936636', '');
INSERT INTO `t_gamebillinfo` VALUES ('216', '1', 'qz_test_5', '12', '0629', '0629', '56', '1', '7d1f6dcb-7c0d-41af-8865-205486db0a67', '2', '6', '1457936636', '1457936637', '1457936637', '');
INSERT INTO `t_gamebillinfo` VALUES ('217', '1', 'qz_test_5', '12', '0629', '0629', '56', '1', '51e42d4c-eb6c-44d6-bfa4-deeab63cee27', '2', '6', '1457936637', '1457936637', '1457936637', '');
INSERT INTO `t_gamebillinfo` VALUES ('218', '1', 'qz_test_5', '12', '0629', '0629', '56', '1', '9fc88854-e357-45f6-a7b8-b68df0b2fdd4', '2', '6', '1457936637', '1457936637', '1457936637', '');
INSERT INTO `t_gamebillinfo` VALUES ('219', '1', 'qz_test_5', '12', '0629', '0629', '56', '1', '4e5e4056-b9d3-4b37-bbaa-d4a521350a7c', '2', '6', '1457936637', '1457936637', '1457936637', '');
INSERT INTO `t_gamebillinfo` VALUES ('220', '1', 'qz_test_5', '12', '0629', '0629', '56', '1', 'edaa583a-7433-46a5-a667-0205f6350d0f', '2', '6', '1457936638', '1457936638', '1457936638', '');
INSERT INTO `t_gamebillinfo` VALUES ('221', '1', 'qz_test_5', '12', '0629', '0629', '56', '1', 'e933369f-ae4f-4ecb-ae56-004cc3af8943', '2', '6', '1457936638', '1457936638', '1457936638', '');
INSERT INTO `t_gamebillinfo` VALUES ('222', '1', 'qz_test_5', '12', '0629', '0629', '56', '1', '9d695465-5191-40d5-bfab-231fb8d1bef8', '2', '6', '1457936638', '1457936638', '1457936638', '');
INSERT INTO `t_gamebillinfo` VALUES ('223', '1', 'qz_test_5', '12', '0629', '0629', '56', '2', '457b2205-2868-4deb-ba4a-f453d1b1f8af', '2', '12', '1457936639', '1457936639', '1457936640', '');
INSERT INTO `t_gamebillinfo` VALUES ('224', '1', 'qz_test_5', '12', '0629', '0629', '56', '2', '67b24428-416f-4334-9476-70bcc02e59f9', '2', '12', '1457936640', '1457936640', '1457936640', '');
INSERT INTO `t_gamebillinfo` VALUES ('225', '1', 'qz_test_5', '12', '0629', '0629', '56', '2', 'aef85329-6187-4531-8151-addb4a5ba1f4', '2', '12', '1457936640', '1457936640', '1457936640', '');
INSERT INTO `t_gamebillinfo` VALUES ('226', '1', 'qz_test_5', '12', '0629', '0629', '56', '2', '8056c89b-03b5-4027-ae7f-b9df3420e63f', '2', '12', '1457936640', '1457936640', '1457936641', '');
INSERT INTO `t_gamebillinfo` VALUES ('227', '1', 'qz_test_5', '1424', 'v1', '端滨海', '48', '1', '14429da8-778a-4ac4-9ee3-4ce9146f6544', '2', '6', '1457940683', '1457940684', '1457940684', '');
INSERT INTO `t_gamebillinfo` VALUES ('228', '1', 'qz_test_5', '1424', 'v1', '端滨海', '48', '2', '28430124-668a-47f1-b458-55877a15d432', '2', '12', '1457940685', '1457940685', '1457940685', '');
INSERT INTO `t_gamebillinfo` VALUES ('229', '1', 'qz_test_5', '1424', 'v1', '端滨海', '48', '2', '2d909c0a-3ae7-4e02-b4c2-8a05de7ad3fd', '2', '12', '1457940686', '1457940686', '1457940686', '');
INSERT INTO `t_gamebillinfo` VALUES ('230', '1', 'qz_test_5', '1424', 'v1', '端滨海', '48', '2', '276b106f-280c-4852-99b8-27ba229b1557', '2', '12', '1457940687', '1457940687', '1457940687', '');
INSERT INTO `t_gamebillinfo` VALUES ('231', '1', 'qz_test_5', '1424', 'v1', '端滨海', '48', '2', 'c5ea7dc7-236b-4a1a-82c4-1f318a2a67e4', '2', '12', '1457940688', '1457940688', '1457940688', '');
INSERT INTO `t_gamebillinfo` VALUES ('232', '1', 'qz_test_5', '1424', 'v1', '端滨海', '48', '2', 'b3eedda6-d919-400f-8556-c5dfdfba50c2', '2', '12', '1457940689', '1457940689', '1457940689', '');
INSERT INTO `t_gamebillinfo` VALUES ('233', '1', 'qz_test_5', '1424', 'v1', '端滨海', '48', '2', '30ab3b0d-23a8-4649-9c83-72ea3cdf8817', '2', '12', '1457940753', '1457940753', '1457940753', '');
INSERT INTO `t_gamebillinfo` VALUES ('234', '1', 'qz_test_5', '1424', 'v1', '端滨海', '48', '2', '3aa373cb-4736-4893-8d64-67f68f638b4c', '2', '12', '1457940754', '1457940754', '1457940754', '');
INSERT INTO `t_gamebillinfo` VALUES ('235', '1', 'qz_test_5', '1424', 'v1', '端滨海', '48', '3', '80aa5291-19cc-42f7-a629-1d182cbf85f6', '2', '30', '1457940754', '1457940754', '1457940755', '');
INSERT INTO `t_gamebillinfo` VALUES ('236', '1', 'qz_test_5', '1424', 'v1', '端滨海', '48', '3', '3c2f497c-4062-457d-8410-63b5620cef5a', '2', '30', '1457940755', '1457940755', '1457940755', '');
INSERT INTO `t_gamebillinfo` VALUES ('237', '1', 'qz_test_5', '4', 'www', '123456', '56', '2', 'cafc6f61-554d-4e29-81a0-519ae89c2290', '2', '12', '1457940999', '1457940999', '1457940999', '');
INSERT INTO `t_gamebillinfo` VALUES ('238', '1', 'qz_test_5', '4', 'www', '123456', '56', '1', 'dd7e719c-db36-4add-ac2a-d1f47e18af5f', '2', '6', '1457941000', '1457941000', '1457941000', '');
INSERT INTO `t_gamebillinfo` VALUES ('239', '1', 'qz_test_5', '1424', 'v1', '端滨海', '48', '3', 'd16de217-dfd5-4836-a93f-892b0c056c6f', '2', '30', '1457941121', '1457941121', '1457941121', '');
INSERT INTO `t_gamebillinfo` VALUES ('240', '1', 'qz_test_5', '1424', 'v1', '端滨海', '48', '3', '5a2a2936-f026-4444-9d26-9732541df595', '2', '30', '1457941123', '1457941124', '1457941124', '');
INSERT INTO `t_gamebillinfo` VALUES ('241', '1', 'qz_test_5', '1424', 'v1', '端滨海', '48', '3', '8bf7b87f-521f-4f1e-8fb6-1b182b3e21b9', '2', '30', '1457941127', '1457941128', '1457941128', '');
INSERT INTO `t_gamebillinfo` VALUES ('242', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '1', 'ade3640a-e7d4-4164-b438-f364ec6f152e', '2', '6', '1457941957', '1457941958', '1457941958', '');
INSERT INTO `t_gamebillinfo` VALUES ('243', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '2', '9d1492c2-c5cf-48b1-94f5-69abc7bc5585', '2', '12', '1457941959', '1457941959', '1457941959', '');
INSERT INTO `t_gamebillinfo` VALUES ('244', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', 'db835749-e0f3-4bd2-a35e-341865eeb9e0', '2', '30', '1457941961', '1457941961', '1457941961', '');
INSERT INTO `t_gamebillinfo` VALUES ('245', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '1', '86b613a6-e4c2-412c-a521-2131f9aad7fe', '2', '6', '1457941962', '1457941962', '1457941962', '');
INSERT INTO `t_gamebillinfo` VALUES ('246', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '2', 'bb49a32b-fb5d-4265-934b-81a89b940b3d', '2', '12', '1457941963', '1457941963', '1457941963', '');
INSERT INTO `t_gamebillinfo` VALUES ('247', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '8d15bfcc-fbfa-46d7-b988-c158c1cec695', '2', '30', '1457941964', '1457941964', '1457941964', '');
INSERT INTO `t_gamebillinfo` VALUES ('248', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '4', 'c5c349c1-d459-4e9b-bac1-c62bb23b7bd9', '2', '60', '1457941968', '1457941968', '1457941968', '');
INSERT INTO `t_gamebillinfo` VALUES ('249', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '4', 'd8de5adb-8013-4e4b-870b-4fefc4b531e6', '2', '60', '1457941968', '1457941969', '1457941969', '');
INSERT INTO `t_gamebillinfo` VALUES ('250', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '3', '7beda627-e6ac-44da-b0b5-8c5e338ebcf0', '2', '30', '1457941969', '1457941970', '1457941970', '');
INSERT INTO `t_gamebillinfo` VALUES ('251', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '4', 'fd840f30-e806-4a30-bf59-753d9fc91789', '2', '60', '1457941970', '1457941970', '1457941970', '');
INSERT INTO `t_gamebillinfo` VALUES ('252', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '4', '6c034bb0-7a9e-43a2-b834-d835bb69305c', '2', '60', '1457941971', '1457941971', '1457941971', '');
INSERT INTO `t_gamebillinfo` VALUES ('253', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '5', '859e4173-3a20-42d4-beb7-f8e3ae91e1f8', '2', '90', '1457941973', '1457941974', '1457941974', '');
INSERT INTO `t_gamebillinfo` VALUES ('254', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '6', 'e6a8e8d3-04da-4b87-a72b-572220317501', '2', '120', '1457941975', '1457941975', '1457941976', '');
INSERT INTO `t_gamebillinfo` VALUES ('255', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '6', 'aba8b5d1-aa30-4f72-9ded-25826eac6abe', '2', '120', '1457941976', '1457941976', '1457941977', '');
INSERT INTO `t_gamebillinfo` VALUES ('256', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '8', 'cec33401-6a4d-4763-8b78-e6d821000642', '2', '700', '1457941979', '1457941979', '1457941979', '');
INSERT INTO `t_gamebillinfo` VALUES ('257', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '6', '52d5bec4-5cd0-43b3-ac6a-6821c4ceec0e', '2', '120', '1457941980', '1457941980', '1457941980', '');
INSERT INTO `t_gamebillinfo` VALUES ('258', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '3', '3de6998a-c2d4-46f6-b722-60fd52e0991c', '2', '30', '1457941988', '1457941988', '1457941988', '');
INSERT INTO `t_gamebillinfo` VALUES ('259', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '3', '1c9f9246-e526-4be6-89f6-adb54d8a0ef3', '2', '30', '1457941989', '1457941989', '1457941989', '');
INSERT INTO `t_gamebillinfo` VALUES ('260', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '3', '54109a88-1004-4639-ae2d-89e73999425a', '2', '30', '1457941990', '1457941991', '1457941991', '');
INSERT INTO `t_gamebillinfo` VALUES ('261', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '3', '2cb0cc50-1d34-4e1b-a39d-599a9e72b644', '2', '30', '1457941996', '1457941996', '1457941996', '');
INSERT INTO `t_gamebillinfo` VALUES ('262', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '3', '2c0294e9-8a33-45f5-a64d-4a8794e5d2af', '2', '30', '1457941997', '1457941997', '1457941997', '');
INSERT INTO `t_gamebillinfo` VALUES ('263', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '3', 'ad67e1a8-1213-4910-a3ed-130f9c25c6e2', '2', '30', '1457941998', '1457941999', '1457941999', '');
INSERT INTO `t_gamebillinfo` VALUES ('264', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '1', 'a35d8e08-5b1f-42de-9a42-b59b53a90431', '2', '6', '1457942031', '1457942032', '1457942032', '');
INSERT INTO `t_gamebillinfo` VALUES ('265', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '1', 'f39e5bf1-6624-40c1-9950-4ad80d8082a6', '2', '6', '1457942037', '1457942037', '1457942037', '');
INSERT INTO `t_gamebillinfo` VALUES ('266', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '1', '97f6bb53-257d-46be-b381-0040543a1308', '2', '6', '1457942115', '1457942116', '1457942116', '');
INSERT INTO `t_gamebillinfo` VALUES ('267', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '1', '417c6024-bc1c-465e-b3b0-7f891cfe3137', '2', '6', '1457942117', '1457942117', '1457942117', '');
INSERT INTO `t_gamebillinfo` VALUES ('268', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '1', 'e3f8342a-b020-4c9f-934a-b5f75e4dadd8', '2', '6', '1457942117', '1457942117', '1457942117', '');
INSERT INTO `t_gamebillinfo` VALUES ('269', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '1', '4668492a-89b3-468d-8c94-8dba7abf689f', '2', '6', '1457942117', '1457942117', '1457942118', '');
INSERT INTO `t_gamebillinfo` VALUES ('270', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '1', '4932fc0c-2f05-4909-b331-546c8d85ec27', '2', '6', '1457942117', '1457942118', '1457942118', '');
INSERT INTO `t_gamebillinfo` VALUES ('271', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '1', '65cc4aec-458e-462b-9a12-795ea30268ff', '2', '6', '1457942118', '1457942118', '1457942118', '');
INSERT INTO `t_gamebillinfo` VALUES ('272', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '1', '35a96fb8-31dd-49af-be0d-286a1bf73987', '2', '6', '1457942118', '1457942118', '1457942118', '');
INSERT INTO `t_gamebillinfo` VALUES ('273', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '1', '3e95f9eb-12c9-49c0-8222-a7c1cde16ee9', '2', '6', '1457942118', '1457942118', '1457942118', '');
INSERT INTO `t_gamebillinfo` VALUES ('274', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '1', 'e43f6163-66f6-4070-9d7d-f42ed9150284', '2', '6', '1457942118', '1457942119', '1457942119', '');
INSERT INTO `t_gamebillinfo` VALUES ('275', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '1', 'e2a02edd-4df2-43e9-9992-0a3c7e80ff5e', '2', '6', '1457942119', '1457942119', '1457942119', '');
INSERT INTO `t_gamebillinfo` VALUES ('276', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '1', 'c162034d-3d98-4d96-b115-67725cdad1b8', '2', '6', '1457942119', '1457942119', '1457942119', '');
INSERT INTO `t_gamebillinfo` VALUES ('277', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '1', '6efa7ab5-bd20-4f92-84db-6c170c517448', '2', '6', '1457942119', '1457942120', '1457942120', '');
INSERT INTO `t_gamebillinfo` VALUES ('278', '1', 'qz_test_5', '1404', 'siz', 'siz', '11', '2', 'c6d77c62-69ab-4832-8ecc-ca0463e8e19b', '2', '12', '1457942359', '1457942359', '1457942359', '');
INSERT INTO `t_gamebillinfo` VALUES ('279', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', 'e123bcb9-8faa-4a71-accc-1dd2b6576659', '2', '6', '1457942563', '1457942563', '1457942563', '');
INSERT INTO `t_gamebillinfo` VALUES ('280', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', '14124ff8-cba9-434b-8a56-b154ca1ec36a', '2', '6', '1457942563', '1457942563', '1457942563', '');
INSERT INTO `t_gamebillinfo` VALUES ('281', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', '59346aa6-51a2-4bf0-a50c-dfa18a2d04c0', '2', '6', '1457942563', '1457942564', '1457942564', '');
INSERT INTO `t_gamebillinfo` VALUES ('282', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', 'd97cd221-8f0c-4b6c-bb27-5f65ebe46c79', '2', '6', '1457942564', '1457942564', '1457942564', '');
INSERT INTO `t_gamebillinfo` VALUES ('283', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', 'ef2fc620-2cd0-4f91-9edb-a5cfbc627a48', '2', '6', '1457942564', '1457942565', '1457942565', '');
INSERT INTO `t_gamebillinfo` VALUES ('284', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', '8f4f95a9-ddf0-4bdd-9cf8-85c0dfef3796', '2', '6', '1457942565', '1457942565', '1457942565', '');
INSERT INTO `t_gamebillinfo` VALUES ('285', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', 'c7f4f232-8e17-4cd9-b95b-461aa9bf9b8d', '2', '6', '1457942565', '1457942565', '1457942566', '');
INSERT INTO `t_gamebillinfo` VALUES ('286', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', '8e5bfd86-cdd3-43a3-8500-d610154f4164', '2', '6', '1457942565', '1457942565', '1457942566', '');
INSERT INTO `t_gamebillinfo` VALUES ('287', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', '083bac0f-b88b-4669-852e-d5117a9c9475', '2', '6', '1457942565', '1457942566', '1457942566', '');
INSERT INTO `t_gamebillinfo` VALUES ('288', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', '9287a631-2677-42e2-b0a7-32d480d08376', '2', '6', '1457942566', '1457942566', '1457942566', '');
INSERT INTO `t_gamebillinfo` VALUES ('289', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', '583e01c9-9386-4985-9955-b69ca397512c', '2', '6', '1457942566', '1457942567', '1457942567', '');
INSERT INTO `t_gamebillinfo` VALUES ('290', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', '24b24d67-e101-40f7-8a10-ccfc2cf559fb', '2', '6', '1457942567', '1457942567', '1457942567', '');
INSERT INTO `t_gamebillinfo` VALUES ('291', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', 'de0a6e5b-078f-4ec4-9754-855836376e76', '2', '6', '1457942567', '1457942567', '1457942567', '');
INSERT INTO `t_gamebillinfo` VALUES ('292', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', '7c270b0f-dc54-4edc-93c0-e39ac99295a7', '2', '6', '1457942567', '1457942567', '1457942568', '');
INSERT INTO `t_gamebillinfo` VALUES ('293', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', '3e06194c-c5a9-4970-9a75-15408a9ee8c3', '2', '6', '1457942568', '1457942568', '1457942568', '');
INSERT INTO `t_gamebillinfo` VALUES ('294', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', '9e24b66b-f4d5-435c-88c9-9feeabbddf5b', '2', '6', '1457942569', '1457942569', '1457942569', '');
INSERT INTO `t_gamebillinfo` VALUES ('295', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', '8eb5143f-e965-474d-8838-866126703c97', '2', '6', '1457942569', '1457942569', '1457942569', '');
INSERT INTO `t_gamebillinfo` VALUES ('296', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', 'ed50461a-5a05-4626-8f74-d790533893b9', '2', '6', '1457942569', '1457942569', '1457942570', '');
INSERT INTO `t_gamebillinfo` VALUES ('297', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '3', '5dfc701c-4ee4-4ab2-ac7e-3946c68c75ce', '2', '30', '1457942570', '1457942570', '1457942570', '');
INSERT INTO `t_gamebillinfo` VALUES ('298', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '3', 'b545a476-a10f-489f-aac9-4cc8bb5af993', '2', '30', '1457942570', '1457942570', '1457942571', '');
INSERT INTO `t_gamebillinfo` VALUES ('299', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '3', '24572c2f-eccb-4c19-9b5a-875b10a75c85', '2', '30', '1457942571', '1457942571', '1457942571', '');
INSERT INTO `t_gamebillinfo` VALUES ('300', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '3', '92482705-6846-44e0-ae54-2fac0353a98f', '2', '30', '1457942571', '1457942571', '1457942571', '');
INSERT INTO `t_gamebillinfo` VALUES ('301', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '2', '566cdac5-5e0b-4807-a04b-9e6631df7d3d', '2', '12', '1457942571', '1457942572', '1457942572', '');
INSERT INTO `t_gamebillinfo` VALUES ('302', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '2', '77018293-d42e-48b4-b325-0776116d27f3', '2', '12', '1457942572', '1457942572', '1457942572', '');
INSERT INTO `t_gamebillinfo` VALUES ('303', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '2', '225aaefc-21bb-48d3-a58b-382b36e62126', '2', '12', '1457942572', '1457942572', '1457942572', '');
INSERT INTO `t_gamebillinfo` VALUES ('304', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '2', '18e12c81-dfad-4cbc-915e-81d8b3120264', '2', '12', '1457942572', '1457942572', '1457942572', '');
INSERT INTO `t_gamebillinfo` VALUES ('305', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '2', 'b98ff95a-9907-41ce-a245-2826c72eae78', '2', '12', '1457942572', '1457942573', '1457942573', '');
INSERT INTO `t_gamebillinfo` VALUES ('306', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', 'cae5e35d-a12b-466d-8021-e7a0e68e1010', '2', '6', '1457942573', '1457942574', '1457942574', '');
INSERT INTO `t_gamebillinfo` VALUES ('307', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', 'f5d9b085-49e2-44e2-bb43-184a59709736', '2', '6', '1457942573', '1457942574', '1457942574', '');
INSERT INTO `t_gamebillinfo` VALUES ('308', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', '3374eb87-265f-4005-8a18-d6fd0a5f3bab', '2', '6', '1457942574', '1457942574', '1457942574', '');
INSERT INTO `t_gamebillinfo` VALUES ('309', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '3', '8cc4a9fd-50bc-48bb-b6c6-cf5b68c42bb8', '2', '30', '1457942575', '1457942575', '1457942575', '');
INSERT INTO `t_gamebillinfo` VALUES ('310', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '3', 'bcf79fee-bb5d-4eed-8922-f90204ebcd43', '2', '30', '1457942575', '1457942575', '1457942575', '');
INSERT INTO `t_gamebillinfo` VALUES ('311', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '3', '83d34b21-5e29-4342-b7ca-3bf8181638dd', '2', '30', '1457942575', '1457942576', '1457942576', '');
INSERT INTO `t_gamebillinfo` VALUES ('312', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '3', 'ee4a8926-6128-4efa-a500-31b435d0d227', '2', '30', '1457942576', '1457942576', '1457942576', '');
INSERT INTO `t_gamebillinfo` VALUES ('313', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '3', 'a2b21922-2109-45a8-9c21-8134826f790c', '2', '30', '1457942576', '1457942576', '1457942576', '');
INSERT INTO `t_gamebillinfo` VALUES ('314', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '3', '06db2266-58fd-414a-9623-1c309333452e', '2', '30', '1457942576', '1457942576', '1457942576', '');
INSERT INTO `t_gamebillinfo` VALUES ('315', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '3', '3f212039-9418-43c1-baa5-64850f112af7', '2', '30', '1457942576', '1457942576', '1457942576', '');
INSERT INTO `t_gamebillinfo` VALUES ('316', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '3', '466b7a4b-d90e-4a99-baf0-d06789726380', '2', '30', '1457942576', '1457942577', '1457942577', '');
INSERT INTO `t_gamebillinfo` VALUES ('317', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '3', '7705f849-14fa-44c9-bf18-f9be620d5ca7', '2', '30', '1457942577', '1457942577', '1457942577', '');
INSERT INTO `t_gamebillinfo` VALUES ('318', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '3', 'dcd8c383-629d-40ef-81bc-c308d8590659', '2', '30', '1457942577', '1457942577', '1457942577', '');
INSERT INTO `t_gamebillinfo` VALUES ('319', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', 'e0374e08-5530-4ee3-9b09-64ce05e6ea05', '2', '6', '1457942577', '1457942578', '1457942578', '');
INSERT INTO `t_gamebillinfo` VALUES ('320', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', '3dfe76df-2274-404d-ae7f-44bfdc2f765c', '2', '6', '1457942578', '1457942578', '1457942578', '');
INSERT INTO `t_gamebillinfo` VALUES ('321', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '1', 'b70536ed-9e82-4e11-b13a-bb317b99325e', '2', '6', '1457942759', '1457942759', '1457942759', '');
INSERT INTO `t_gamebillinfo` VALUES ('322', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '2', '597a23d6-b15f-4a46-a188-c6b9cb070477', '2', '12', '1457942760', '1457942760', '1457942760', '');
INSERT INTO `t_gamebillinfo` VALUES ('323', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '3', '86aa6546-0b03-4aa1-b0cc-3c1d7a7c8aa3', '2', '30', '1457942761', '1457942761', '1457942761', '');
INSERT INTO `t_gamebillinfo` VALUES ('324', '1', 'qz_test_5', '1395', 'sasa', '东方飞白', '56', '3', '18626f91-a051-471f-9cb0-0db3b84755dc', '2', '30', '1457942761', '1457942762', '1457942762', '');
INSERT INTO `t_gamebillinfo` VALUES ('325', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '1', 'b90064ee-6e9a-4658-865f-8154ddf0fb8c', '2', '6', '1457943373', '1457943373', '1457943373', '');
INSERT INTO `t_gamebillinfo` VALUES ('326', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '1', '6bee5b2d-8986-4c0a-a581-6b99f3181894', '2', '6', '1457943374', '1457943374', '1457943374', '');
INSERT INTO `t_gamebillinfo` VALUES ('327', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '1', '87dafd98-b38f-459f-afdd-30b2a2f67596', '2', '6', '1457943375', '1457943375', '1457943375', '');
INSERT INTO `t_gamebillinfo` VALUES ('328', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '1', '27396aba-f753-4637-bbde-1eb7a37ba609', '2', '6', '1457943376', '1457943376', '1457943377', '');
INSERT INTO `t_gamebillinfo` VALUES ('329', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '1', '07ea3f45-c14a-4d64-9617-7b5a7623ab42', '2', '6', '1457943377', '1457943378', '1457943378', '');
INSERT INTO `t_gamebillinfo` VALUES ('330', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '1', 'b4957125-f4f3-454f-8e4f-7f1f3f3fb6d3', '2', '6', '1457943381', '1457943381', '1457943382', '');
INSERT INTO `t_gamebillinfo` VALUES ('331', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '1', '19c03ea1-6564-4361-a18a-d62f4b9eef87', '2', '6', '1457943383', '1457943383', '1457943383', '');
INSERT INTO `t_gamebillinfo` VALUES ('332', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '1', '5ad9f8d7-46f9-4513-8f1f-cdbdf37c6150', '2', '6', '1457943384', '1457943384', '1457943384', '');
INSERT INTO `t_gamebillinfo` VALUES ('333', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '1', '7be1361f-76b3-470e-be04-2ebc20ae46bd', '2', '6', '1457943386', '1457943386', '1457943386', '');
INSERT INTO `t_gamebillinfo` VALUES ('334', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '1', '12555fc1-720c-4e76-b49d-b8b0db96e146', '2', '6', '1457943387', '1457943388', '1457943388', '');
INSERT INTO `t_gamebillinfo` VALUES ('335', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '2', '3a4b98a3-190a-4aae-8e69-ee96e5ab253f', '2', '12', '1457943389', '1457943389', '1457943389', '');
INSERT INTO `t_gamebillinfo` VALUES ('336', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '2', 'd5b84925-7d05-4973-89e9-134c79deae4a', '2', '12', '1457943390', '1457943390', '1457943390', '');
INSERT INTO `t_gamebillinfo` VALUES ('337', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '2', '62d1967f-1a7f-4454-ae4c-0d1f6d346c73', '2', '12', '1457943392', '1457943392', '1457943392', '');
INSERT INTO `t_gamebillinfo` VALUES ('338', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '2', '7ac4fb64-0739-46ab-9b59-1390481a302e', '2', '12', '1457943393', '1457943394', '1457943394', '');
INSERT INTO `t_gamebillinfo` VALUES ('339', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '2', 'be9a7348-9053-4082-bba6-ffbaf98c18f2', '2', '12', '1457943395', '1457943395', '1457943395', '');
INSERT INTO `t_gamebillinfo` VALUES ('340', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '2', 'df352e0c-2ccb-44d8-bdc5-28a335d09291', '2', '12', '1457943399', '1457943399', '1457943399', '');
INSERT INTO `t_gamebillinfo` VALUES ('341', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '2', '982823d5-968a-40c3-8c74-3c8163b9d925', '2', '12', '1457943401', '1457943401', '1457943402', '');
INSERT INTO `t_gamebillinfo` VALUES ('342', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '48', '2', '26a2069a-c6ec-46dc-bc33-948714946ea9', '2', '12', '1457943404', '1457943404', '1457943404', '');
INSERT INTO `t_gamebillinfo` VALUES ('343', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', 'a812e1b9-7876-4ffe-a604-7278c568e90f', '2', '30', '1457944184', '1457944185', '1457944185', '');
INSERT INTO `t_gamebillinfo` VALUES ('344', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', 'c6d444de-d1fe-4cf4-a652-a7759bd83085', '2', '30', '1457944185', '1457944185', '1457944185', '');
INSERT INTO `t_gamebillinfo` VALUES ('345', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '32299c98-41d8-4530-9c53-e6c71b553a35', '2', '30', '1457944185', '1457944186', '1457944186', '');
INSERT INTO `t_gamebillinfo` VALUES ('346', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '97c5fad6-7071-434e-877c-2f11dc2425a3', '2', '30', '1457944186', '1457944186', '1457944187', '');
INSERT INTO `t_gamebillinfo` VALUES ('347', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', 'b8282ffe-b08c-4b9a-9e1d-71fa4ddecb30', '2', '30', '1457944186', '1457944187', '1457944187', '');
INSERT INTO `t_gamebillinfo` VALUES ('348', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '1f53f249-9301-4f40-8bc8-c34a27a1c8de', '2', '30', '1457944187', '1457944187', '1457944187', '');
INSERT INTO `t_gamebillinfo` VALUES ('349', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '007fc583-ed3b-4c02-9f0a-4d6b747045ea', '2', '30', '1457944187', '1457944188', '1457944188', '');
INSERT INTO `t_gamebillinfo` VALUES ('350', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', 'db01a6ed-1d25-4f88-a16e-f4eca540972f', '2', '30', '1457944188', '1457944188', '1457944188', '');
INSERT INTO `t_gamebillinfo` VALUES ('351', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '4fcfd0fe-db87-4b42-afd9-8eb22ba40e39', '2', '30', '1457944188', '1457944188', '1457944189', '');
INSERT INTO `t_gamebillinfo` VALUES ('352', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '9831e115-fae0-4082-8744-4efc048328af', '2', '30', '1457944188', '1457944189', '1457944189', '');
INSERT INTO `t_gamebillinfo` VALUES ('353', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '6a466c5f-b317-447b-a8f2-1c70651176a4', '2', '30', '1457944188', '1457944189', '1457944189', '');
INSERT INTO `t_gamebillinfo` VALUES ('354', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '0f824d46-234b-41bb-b09e-7e3986e72811', '2', '30', '1457944189', '1457944189', '1457944189', '');
INSERT INTO `t_gamebillinfo` VALUES ('355', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '6f0fbbd0-f2ef-4987-996a-e3a66a295b54', '2', '30', '1457944190', '1457944193', '1457944193', '');
INSERT INTO `t_gamebillinfo` VALUES ('356', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '91bbdee6-8fcc-43fa-9501-35c1ac63dac1', '2', '30', '1457944191', '1457944196', '1457944196', '');
INSERT INTO `t_gamebillinfo` VALUES ('357', '1', 'qz_test_5', '4', 'www', '123456', '56', '8', '49ffc70d-04f4-4e87-95cf-4f931bb20944', '2', '700', '1457944208', '1457944208', '1457944208', '');
INSERT INTO `t_gamebillinfo` VALUES ('358', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '1c52dbe7-3205-4e02-a118-f45fcd99091f', '2', '120', '1457944217', '1457944218', '1457944218', '');
INSERT INTO `t_gamebillinfo` VALUES ('359', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '650633c8-fec4-47fd-aba8-8bec8c83817c', '2', '120', '1457944218', '1457944218', '1457944218', '');
INSERT INTO `t_gamebillinfo` VALUES ('360', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '07aac89f-76d6-4b56-a5b7-c51eb3df62bc', '2', '120', '1457944219', '1457944220', '1457944220', '');
INSERT INTO `t_gamebillinfo` VALUES ('361', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '3a696db4-dc61-498e-b527-a34bef91238f', '2', '120', '1457944220', '1457944220', '1457944220', '');
INSERT INTO `t_gamebillinfo` VALUES ('362', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '1abe4be7-e087-4bd1-8a42-624326b0a71d', '2', '120', '1457944220', '1457944221', '1457944221', '');
INSERT INTO `t_gamebillinfo` VALUES ('363', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '069f78a7-9cb3-4edb-9496-82c958a68308', '2', '120', '1457944221', '1457944221', '1457944221', '');
INSERT INTO `t_gamebillinfo` VALUES ('364', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'd238e1cf-8834-42f4-b5b2-ea589b93e16a', '2', '120', '1457944221', '1457944221', '1457944221', '');
INSERT INTO `t_gamebillinfo` VALUES ('365', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '25255dee-d0c6-488a-8ae2-40d9742bf475', '2', '120', '1457944221', '1457944222', '1457944222', '');
INSERT INTO `t_gamebillinfo` VALUES ('366', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '08f64339-8008-48b7-818d-043758b0b6e3', '2', '120', '1457944222', '1457944222', '1457944222', '');
INSERT INTO `t_gamebillinfo` VALUES ('367', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '3403b36d-0a7c-42c2-87d6-870dfd93a79a', '2', '120', '1457944222', '1457944222', '1457944222', '');
INSERT INTO `t_gamebillinfo` VALUES ('368', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'f1e47c9c-fbc1-4c19-bff9-376ef35b8b55', '2', '120', '1457944222', '1457944222', '1457944223', '');
INSERT INTO `t_gamebillinfo` VALUES ('369', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '2bc519b4-292e-48f6-b320-700fc30143e3', '2', '120', '1457944222', '1457944223', '1457944223', '');
INSERT INTO `t_gamebillinfo` VALUES ('370', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'e7d9e6c5-a6e4-429d-8f7b-4ae35823bced', '2', '120', '1457944223', '1457944223', '1457944223', '');
INSERT INTO `t_gamebillinfo` VALUES ('371', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'ec2b26a2-94b7-4777-84dd-40e8f4d262f2', '2', '120', '1457944223', '1457944224', '1457944224', '');
INSERT INTO `t_gamebillinfo` VALUES ('372', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '35261d75-f2ad-46fc-8e68-234bea92b100', '2', '120', '1457944223', '1457944224', '1457944224', '');
INSERT INTO `t_gamebillinfo` VALUES ('373', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'eb423453-340c-4231-8fe7-ffbb5c70de73', '2', '120', '1457944224', '1457944224', '1457944224', '');
INSERT INTO `t_gamebillinfo` VALUES ('374', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '635a90a7-ada9-4347-a79c-7b3819902467', '2', '120', '1457944228', '1457944228', '1457944228', '');
INSERT INTO `t_gamebillinfo` VALUES ('375', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'fdda1cb1-4a87-4fab-8a12-8fe6bad50825', '2', '120', '1457944228', '1457944228', '1457944228', '');
INSERT INTO `t_gamebillinfo` VALUES ('376', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '6714a92f-ad65-4998-8d4a-13cac7448e19', '2', '120', '1457944229', '1457944229', '1457944229', '');
INSERT INTO `t_gamebillinfo` VALUES ('377', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'b81ee2f6-3b21-4940-9bbe-8be5d44e7372', '2', '120', '1457944229', '1457944229', '1457944229', '');
INSERT INTO `t_gamebillinfo` VALUES ('378', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '90187ef7-2f82-4bcd-934b-42e55ac33644', '2', '120', '1457944229', '1457944229', '1457944229', '');
INSERT INTO `t_gamebillinfo` VALUES ('379', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'df8e719f-0a91-4f6b-a2d4-0f169c0048de', '2', '120', '1457944229', '1457944230', '1457944230', '');
INSERT INTO `t_gamebillinfo` VALUES ('380', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '8302b560-f6df-468a-805a-c7f0024b70f6', '2', '120', '1457944230', '1457944230', '1457944230', '');
INSERT INTO `t_gamebillinfo` VALUES ('381', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '236d3de1-1c83-420a-85c9-9c1f8fd6e36c', '2', '120', '1457944233', '1457944233', '1457944233', '');
INSERT INTO `t_gamebillinfo` VALUES ('382', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '345e2753-46aa-4c99-bb45-4177a0204bca', '2', '120', '1457944233', '1457944233', '1457944233', '');
INSERT INTO `t_gamebillinfo` VALUES ('383', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'fafb05a3-2858-4d08-89b3-475929cb107e', '2', '120', '1457944233', '1457944233', '1457944233', '');
INSERT INTO `t_gamebillinfo` VALUES ('384', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '4388cc19-bcfc-452f-ac62-09ce087eadae', '2', '120', '1457944233', '1457944234', '1457944234', '');
INSERT INTO `t_gamebillinfo` VALUES ('385', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '58431ae1-91b2-4081-8deb-ed4a90a3519b', '2', '120', '1457944234', '1457944234', '1457944234', '');
INSERT INTO `t_gamebillinfo` VALUES ('386', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '4ee7c243-9002-4c19-89a3-f6bffa29b6f1', '2', '120', '1457944234', '1457944234', '1457944234', '');
INSERT INTO `t_gamebillinfo` VALUES ('387', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'de14191e-1f20-436c-a629-fc6465b85a66', '2', '120', '1457944234', '1457944235', '1457944235', '');
INSERT INTO `t_gamebillinfo` VALUES ('388', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'fee00277-729d-4117-81ee-da4b011ab0eb', '2', '120', '1457944235', '1457944235', '1457944235', '');
INSERT INTO `t_gamebillinfo` VALUES ('389', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'aec7bdbc-8f07-4c5a-865c-7503dc6079dd', '2', '120', '1457944235', '1457944235', '1457944235', '');
INSERT INTO `t_gamebillinfo` VALUES ('390', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'b1b33709-6d9a-479d-9b04-392352e3abeb', '2', '120', '1457944235', '1457944236', '1457944236', '');
INSERT INTO `t_gamebillinfo` VALUES ('391', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '8cd6b7c4-c8cd-4747-a1c4-4256cb57d886', '2', '120', '1457944235', '1457944236', '1457944236', '');
INSERT INTO `t_gamebillinfo` VALUES ('392', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '77ed2f32-63b2-4910-91df-536031fb1bbc', '2', '120', '1457944237', '1457944238', '1457944238', '');
INSERT INTO `t_gamebillinfo` VALUES ('393', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '802ebe97-5a7f-4da5-b898-543dfcdf35e4', '2', '120', '1457944238', '1457944238', '1457944238', '');
INSERT INTO `t_gamebillinfo` VALUES ('394', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'bc9eb455-59b8-4564-b3cd-22314ff2af89', '2', '120', '1457944238', '1457944238', '1457944238', '');
INSERT INTO `t_gamebillinfo` VALUES ('395', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'f4a1d125-cc42-4e56-a160-b4be55162aad', '2', '120', '1457944241', '1457944241', '1457944241', '');
INSERT INTO `t_gamebillinfo` VALUES ('396', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '5661dfa8-ad4c-4c36-89e3-a189d3c5d4b8', '2', '120', '1457944246', '1457944246', '1457944247', '');
INSERT INTO `t_gamebillinfo` VALUES ('397', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'd7030665-2a82-454a-bca6-6d646b59fb3f', '2', '120', '1457944247', '1457944247', '1457944247', '');
INSERT INTO `t_gamebillinfo` VALUES ('398', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'b25c667d-2635-4a0d-8273-533913aed475', '2', '120', '1457944247', '1457944248', '1457944248', '');
INSERT INTO `t_gamebillinfo` VALUES ('399', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '421891d0-a747-49c8-ac04-2fd256dc1745', '2', '120', '1457944248', '1457944248', '1457944248', '');
INSERT INTO `t_gamebillinfo` VALUES ('400', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'c813f346-7c0c-4d30-a976-2a78cdb24772', '2', '120', '1457944248', '1457944249', '1457944249', '');
INSERT INTO `t_gamebillinfo` VALUES ('401', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'aa2ad67b-f1a9-44ba-a00c-0bb3e76aaeac', '2', '120', '1457944249', '1457944249', '1457944249', '');
INSERT INTO `t_gamebillinfo` VALUES ('402', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'c07a1505-0b58-439b-9364-a52b7251cbe4', '2', '120', '1457944249', '1457944249', '1457944249', '');
INSERT INTO `t_gamebillinfo` VALUES ('403', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '8109741d-2a8b-4a3f-9f88-c5c23b9b916b', '2', '120', '1457944249', '1457944249', '1457944250', '');
INSERT INTO `t_gamebillinfo` VALUES ('404', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'afa34877-3bc3-4f7c-b06a-50098c2724f0', '2', '120', '1457944249', '1457944250', '1457944250', '');
INSERT INTO `t_gamebillinfo` VALUES ('405', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '409e307b-89fb-42cf-b44d-6ba279888362', '2', '120', '1457944249', '1457944250', '1457944250', '');
INSERT INTO `t_gamebillinfo` VALUES ('406', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '4df0d1b2-0b1a-424a-8221-cc60698bf027', '2', '120', '1457944250', '1457944250', '1457944251', '');
INSERT INTO `t_gamebillinfo` VALUES ('407', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '99fc43a5-3996-464f-a899-9bc2887bd4dc', '2', '120', '1457944250', '1457944250', '1457944251', '');
INSERT INTO `t_gamebillinfo` VALUES ('408', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'ac74417d-5eb1-45a1-a204-5bc419e366a8', '2', '120', '1457944250', '1457944251', '1457944251', '');
INSERT INTO `t_gamebillinfo` VALUES ('409', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'fe3e5570-2fba-449c-b2d1-aaac79ec19ee', '2', '120', '1457944251', '1457944251', '1457944251', '');
INSERT INTO `t_gamebillinfo` VALUES ('410', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '50df2188-9a26-4bbf-8d76-b29083bbd5a3', '2', '120', '1457944251', '1457944251', '1457944251', '');
INSERT INTO `t_gamebillinfo` VALUES ('411', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'f707a625-30dc-4838-8a9a-476a808684a9', '2', '120', '1457944251', '1457944253', '1457944253', '');
INSERT INTO `t_gamebillinfo` VALUES ('412', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'af6938af-f8c9-414e-9b0f-d091d312058e', '2', '120', '1457944253', '1457944253', '1457944253', '');
INSERT INTO `t_gamebillinfo` VALUES ('413', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '63342838-ea07-4e58-8847-7378f909e5fc', '2', '120', '1457944253', '1457944254', '1457944254', '');
INSERT INTO `t_gamebillinfo` VALUES ('414', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '5b723ba2-3e62-452c-b5b8-be98211bc789', '2', '120', '1457944254', '1457944254', '1457944254', '');
INSERT INTO `t_gamebillinfo` VALUES ('415', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '8612b763-e080-4b7e-b646-74184bc04b73', '2', '30', '1457944275', '1457944275', '1457944275', '');
INSERT INTO `t_gamebillinfo` VALUES ('416', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '7d29d1f1-533e-4292-9be0-d346da4eecf1', '2', '30', '1457944275', '1457944275', '1457944276', '');
INSERT INTO `t_gamebillinfo` VALUES ('417', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'ddbad36c-097a-430f-95a1-01a97af660b6', '2', '120', '1457944278', '1457944278', '1457944278', '');
INSERT INTO `t_gamebillinfo` VALUES ('418', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '8e33473f-c6c8-48c9-8a87-f4198d05edc8', '2', '120', '1457944278', '1457944278', '1457944278', '');
INSERT INTO `t_gamebillinfo` VALUES ('419', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '190b0b85-bb5d-468d-9c46-8b58d3d10979', '2', '120', '1457944279', '1457944279', '1457944279', '');
INSERT INTO `t_gamebillinfo` VALUES ('420', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'b87283c6-af10-46a7-9d54-5d9f11c63a0c', '2', '120', '1457944279', '1457944279', '1457944279', '');
INSERT INTO `t_gamebillinfo` VALUES ('421', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '79b213b2-3252-4486-bb48-7aa76be8f363', '2', '120', '1457944279', '1457944279', '1457944279', '');
INSERT INTO `t_gamebillinfo` VALUES ('422', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '276ad6a4-a36d-4d0a-8f20-cf66cbd1eb53', '2', '120', '1457944279', '1457944280', '1457944280', '');
INSERT INTO `t_gamebillinfo` VALUES ('423', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '77431052-ba49-46ad-bf9c-e8eff1a232a0', '2', '120', '1457944280', '1457944280', '1457944280', '');
INSERT INTO `t_gamebillinfo` VALUES ('424', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '5003bb15-2cc1-4e8c-b944-a7271ce92a2f', '2', '120', '1457944280', '1457944280', '1457944281', '');
INSERT INTO `t_gamebillinfo` VALUES ('425', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '146f8135-9148-4631-a558-e4ed8fd794e9', '2', '120', '1457944280', '1457944281', '1457944281', '');
INSERT INTO `t_gamebillinfo` VALUES ('426', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '0761ced0-d9ed-40de-9bbc-6699fc490137', '2', '120', '1457944280', '1457944281', '1457944281', '');
INSERT INTO `t_gamebillinfo` VALUES ('427', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '2ef383f1-e0c8-4283-824c-d826b6b40a59', '2', '120', '1457944281', '1457944281', '1457944281', '');
INSERT INTO `t_gamebillinfo` VALUES ('428', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'c3713048-fc9a-4418-b7a9-4bf6dcc43193', '2', '120', '1457944281', '1457944282', '1457944282', '');
INSERT INTO `t_gamebillinfo` VALUES ('429', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '3b660d4b-a84b-491b-8ecf-a42384363f34', '2', '120', '1457944281', '1457944282', '1457944282', '');
INSERT INTO `t_gamebillinfo` VALUES ('430', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '5f089eac-2dae-4a9b-9afd-b718c26ef9aa', '2', '120', '1457944282', '1457944282', '1457944282', '');
INSERT INTO `t_gamebillinfo` VALUES ('431', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'c9314086-0351-4681-990e-e6a6e31eb055', '2', '120', '1457944282', '1457944283', '1457944283', '');
INSERT INTO `t_gamebillinfo` VALUES ('432', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', 'b47abef5-e62e-4d5e-9035-5d83e80a0f23', '2', '120', '1457944283', '1457944283', '1457944283', '');
INSERT INTO `t_gamebillinfo` VALUES ('433', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '35b1f892-cb2d-4808-b924-ca018ea4bc88', '2', '120', '1457944284', '1457944285', '1457944285', '');
INSERT INTO `t_gamebillinfo` VALUES ('434', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '6ef25f23-831d-4583-9dbe-6e194e54cc92', '2', '120', '1457944284', '1457944285', '1457944285', '');
INSERT INTO `t_gamebillinfo` VALUES ('435', '1', 'qz_test_5', '4', 'www', '123456', '56', '6', '41ea31ca-4674-4bde-a97a-95c53b535efb', '2', '120', '1457944285', '1457944285', '1457944285', '');
INSERT INTO `t_gamebillinfo` VALUES ('436', '1', 'qz_test_5', '4', 'www', '123456', '56', '2', '53c18018-f0b0-4eed-8aa9-c9ad29e7ceeb', '2', '12', '1457944614', '1457944614', '1457944614', '');
INSERT INTO `t_gamebillinfo` VALUES ('437', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', 'acc7f32d-abeb-4c50-b977-f4551b14e4ea', '2', '30', '1457944615', '1457944615', '1457944615', '');
INSERT INTO `t_gamebillinfo` VALUES ('438', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '2e1a8f01-c49d-4949-9c30-329a2d054bbc', '2', '30', '1457944615', '1457944615', '1457944615', '');
INSERT INTO `t_gamebillinfo` VALUES ('439', '1', 'qz_test_5', '4', 'www', '123456', '56', '2', '14a09c1f-1e4c-42db-b517-186d82397376', '2', '12', '1457944616', '1457944616', '1457944616', '');
INSERT INTO `t_gamebillinfo` VALUES ('440', '1', 'qz_test_5', '4', 'www', '123456', '56', '1', '9ac9d92d-0e8c-4893-a802-5c54c5b6a0ec', '2', '6', '1457944617', '1457944617', '1457944617', '');
INSERT INTO `t_gamebillinfo` VALUES ('441', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '63ff72d2-eab3-4053-859f-8f917b3122d8', '2', '30', '1457944873', '1457944873', '1457944873', '');
INSERT INTO `t_gamebillinfo` VALUES ('442', '1', 'qz_test_5', '4', 'www', '123456', '56', '2', '88f715e3-9554-416a-9ded-c2d764b3c0ad', '2', '12', '1457944874', '1457944874', '1457944874', '');
INSERT INTO `t_gamebillinfo` VALUES ('443', '1', 'qz_test_5', '4', 'www', '123456', '56', '1', '877b505d-3e7a-4381-98c5-71e7e4ecc3da', '2', '6', '1457944878', '1457944878', '1457944878', '');
INSERT INTO `t_gamebillinfo` VALUES ('444', '1', 'qz_test_5', '4', 'www', '123456', '56', '1', '0e998574-92ca-47f4-b0d2-493b14142626', '2', '6', '1457944878', '1457944879', '1457944879', '');
INSERT INTO `t_gamebillinfo` VALUES ('445', '1', 'qz_test_5', '4', 'www', '123456', '56', '2', '346602e5-9abb-4480-9371-c1147f00582c', '2', '12', '1457944932', '1457944932', '1457944932', '');
INSERT INTO `t_gamebillinfo` VALUES ('446', '1', 'qz_test_5', '4', 'www', '123456', '56', '2', '5c00773b-3d55-4fed-ba23-50c5d0542797', '2', '12', '1457945018', '1457945018', '1457945018', '');
INSERT INTO `t_gamebillinfo` VALUES ('447', '1', 'qz_test_5', '4', 'www', '123456', '56', '2', '880467d8-b692-4201-8c9c-b5567b9a1de6', '2', '12', '1457945019', '1457945019', '1457945019', '');
INSERT INTO `t_gamebillinfo` VALUES ('448', '1', 'qz_test_5', '4', 'www', '123456', '56', '2', '980e144d-0de9-48db-93ef-6c54ed8049fa', '2', '12', '1457945019', '1457945019', '1457945020', '');
INSERT INTO `t_gamebillinfo` VALUES ('449', '1', 'qz_test_5', '4', 'www', '123456', '56', '1', '789f1934-711d-4078-8f1b-2ffa7c1366e6', '2', '6', '1457945021', '1457945021', '1457945021', '');
INSERT INTO `t_gamebillinfo` VALUES ('450', '1', 'qz_test_5', '4', 'www', '123456', '56', '1', '10273675-9b13-464f-a02e-110483fed8f2', '2', '6', '1457945021', '1457945021', '1457945021', '');
INSERT INTO `t_gamebillinfo` VALUES ('451', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '96429715-6d25-4d25-b334-704343ac16a9', '2', '30', '1457945022', '1457945022', '1457945022', '');
INSERT INTO `t_gamebillinfo` VALUES ('452', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '9c4950c5-7355-4f4a-82fd-bfc9abad404f', '2', '30', '1457945023', '1457945023', '1457945023', '');
INSERT INTO `t_gamebillinfo` VALUES ('453', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', 'a08b5791-9ecf-48c0-adcf-334fcf19f257', '2', '30', '1457945023', '1457945023', '1457945023', '');
INSERT INTO `t_gamebillinfo` VALUES ('454', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '445614e7-359d-41b1-b741-93d4e9962be1', '2', '30', '1457945024', '1457945024', '1457945024', '');
INSERT INTO `t_gamebillinfo` VALUES ('455', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', 'cc0fa61a-2c27-45d0-be24-fb9dc329401a', '2', '30', '1457945024', '1457945024', '1457945024', '');
INSERT INTO `t_gamebillinfo` VALUES ('456', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '557ca0ee-a27f-45e6-97a0-738b6aa99f69', '2', '30', '1457945025', '1457945025', '1457945025', '');
INSERT INTO `t_gamebillinfo` VALUES ('457', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', 'f1a531b6-b3cb-4ffc-91b6-26c73cfe530a', '2', '30', '1457945026', '1457945026', '1457945026', '');
INSERT INTO `t_gamebillinfo` VALUES ('458', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', 'd99c6d7e-3a38-434b-a705-0e0899a1316b', '2', '30', '1457945027', '1457945027', '1457945027', '');
INSERT INTO `t_gamebillinfo` VALUES ('459', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', '14dc4b71-9331-4d34-acaf-04a8b906ef7c', '2', '30', '1457945027', '1457945027', '1457945027', '');
INSERT INTO `t_gamebillinfo` VALUES ('460', '1', 'qz_test_5', '4', 'www', '123456', '56', '3', 'ac36d393-1af7-47aa-b475-10e0c70da43e', '2', '30', '1457945028', '1457945028', '1457945028', '');
INSERT INTO `t_gamebillinfo` VALUES ('461', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '2', 'b25286cf-5ece-4d24-b33f-90e14876123b', '2', '12', '1457945077', '1457945078', '1457945078', '');
INSERT INTO `t_gamebillinfo` VALUES ('462', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '2', 'f77a8b54-379c-4b88-a22d-fe61950ae416', '2', '12', '1457945079', '1457945079', '1457945079', '');
INSERT INTO `t_gamebillinfo` VALUES ('463', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '2', 'd802b294-06f6-4eee-b67a-66391f2b34b7', '2', '12', '1457945984', '1457945984', '1457945984', '');
INSERT INTO `t_gamebillinfo` VALUES ('464', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '2', 'c1748fca-f4e8-4643-bb94-4e2bfced3cca', '2', '12', '1457945985', '1457945985', '1457945985', '');
INSERT INTO `t_gamebillinfo` VALUES ('465', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '2', 'b70b5490-b561-4997-9824-6e363fefb20e', '2', '12', '1457945986', '1457945986', '1457945987', '');
INSERT INTO `t_gamebillinfo` VALUES ('466', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '1', '57fa9247-6dd6-4a32-b47a-c59951712412', '2', '6', '1457945987', '1457945988', '1457945988', '');
INSERT INTO `t_gamebillinfo` VALUES ('467', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '3', '6a53f93d-46f8-4441-b110-04dca5a88734', '2', '30', '1457945988', '1457945988', '1457945988', '');
INSERT INTO `t_gamebillinfo` VALUES ('468', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '2', '441454aa-deaa-4449-93cb-ff328dace1dd', '2', '12', '1457945989', '1457945989', '1457945989', '');
INSERT INTO `t_gamebillinfo` VALUES ('469', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '3', '4b09ddf3-1c59-41aa-b44f-febe651b5907', '2', '30', '1457945993', '1457945994', '1457945994', '');
INSERT INTO `t_gamebillinfo` VALUES ('470', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '3', '8424454e-475c-4b4d-b92a-5b7662ed3501', '2', '30', '1457945994', '1457945994', '1457945994', '');
INSERT INTO `t_gamebillinfo` VALUES ('471', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '3', 'f7de63bb-ab8e-4ec1-b07e-70ac1eaffe58', '2', '30', '1457945995', '1457945995', '1457945996', '');
INSERT INTO `t_gamebillinfo` VALUES ('472', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '2', 'ab821170-65f7-4245-92a1-d3a62fe2d1c0', '2', '12', '1457945996', '1457945997', '1457945997', '');
INSERT INTO `t_gamebillinfo` VALUES ('473', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '3', 'ac4f6c86-dbc1-49ce-9842-a3eb9d968815', '2', '30', '1457945997', '1457945998', '1457945998', '');
INSERT INTO `t_gamebillinfo` VALUES ('474', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '2', 'd455bd2e-0af2-4e44-bdfc-c4f843f68029', '2', '12', '1457945999', '1457945999', '1457945999', '');
INSERT INTO `t_gamebillinfo` VALUES ('475', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '1', 'e294e877-45f5-4542-9d48-3821648a6451', '2', '6', '1457946002', '1457946003', '1457946003', '');
INSERT INTO `t_gamebillinfo` VALUES ('476', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '1', 'afe7797e-cba4-4ed5-a9b4-ff46d97eaaee', '2', '6', '1457946004', '1457946004', '1457946004', '');
INSERT INTO `t_gamebillinfo` VALUES ('477', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '3', '000ea158-bc37-4234-b639-8e9be906edc4', '2', '30', '1457946006', '1457946006', '1457946007', '');
INSERT INTO `t_gamebillinfo` VALUES ('478', '1', 'qz_test_5', '4', 'www', '123456', '56', '2', '6411980f-3460-4dfa-a0aa-d9ecd09675ab', '2', '12', '1457946094', '1457946094', '1457946094', '');
INSERT INTO `t_gamebillinfo` VALUES ('479', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '2', '437d9d5c-3371-4f2d-8f5e-fcaea45a586a', '2', '12', '1457946570', '1457946571', '1457946571', '');
INSERT INTO `t_gamebillinfo` VALUES ('480', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '2', '2f984b14-26f4-4b41-83c4-f44156ba0e54', '2', '12', '1457946571', '1457946571', '1457946571', '');
INSERT INTO `t_gamebillinfo` VALUES ('481', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '56', '3', '4317be84-d665-41d4-98e1-5d84621962c2', '2', '30', '1457946573', '1457946573', '1457946573', '');
INSERT INTO `t_gamebillinfo` VALUES ('482', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '1', '6d5b65dd-3682-4c16-907a-9ca9c48ab00b', '2', '6', '1457946665', '1457946666', '1457946666', '');
INSERT INTO `t_gamebillinfo` VALUES ('483', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '1', '58ec9caa-c298-465b-8d59-263cff0219d7', '2', '6', '1457946667', '1457946667', '1457946667', '');
INSERT INTO `t_gamebillinfo` VALUES ('484', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '3', '9ae91376-8182-486c-92c4-4d0c26d53f91', '2', '30', '1457946950', '1457946951', '1457946951', '');
INSERT INTO `t_gamebillinfo` VALUES ('485', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '3', '3ff7b042-43f5-472f-b45b-5b893864de66', '2', '30', '1457946951', '1457946951', '1457946952', '');
INSERT INTO `t_gamebillinfo` VALUES ('486', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '3', 'c39e6384-59fb-4834-925c-9aadac9fc7c9', '2', '30', '1457946951', '1457946952', '1457946952', '');
INSERT INTO `t_gamebillinfo` VALUES ('487', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '3', 'ea23076a-f40e-42d7-b167-7a844e586e29', '2', '30', '1457946952', '1457946952', '1457946952', '');
INSERT INTO `t_gamebillinfo` VALUES ('488', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '3', '8430e920-9279-41da-8780-b1d5a5b5da90', '2', '30', '1457946952', '1457946953', '1457946953', '');
INSERT INTO `t_gamebillinfo` VALUES ('489', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '3', 'b58f3ac8-2b38-4486-bb9b-5f78d0ff8b3f', '2', '30', '1457946953', '1457946953', '1457946953', '');
INSERT INTO `t_gamebillinfo` VALUES ('490', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '3', '664095f7-a2a5-457d-ad44-0585ff8177a9', '2', '30', '1457946953', '1457946953', '1457946954', '');
INSERT INTO `t_gamebillinfo` VALUES ('491', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '3', 'e2254e62-92bc-4fff-80b3-a9c60705b0d9', '2', '30', '1457946953', '1457946954', '1457946954', '');
INSERT INTO `t_gamebillinfo` VALUES ('492', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '3', '02503ad9-387c-434d-b46c-cb095eb9d501', '2', '30', '1457946954', '1457946954', '1457946954', '');
INSERT INTO `t_gamebillinfo` VALUES ('493', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '3', '0ff566f0-a156-461a-bd85-723b730142da', '2', '30', '1457946954', '1457946955', '1457946955', '');
INSERT INTO `t_gamebillinfo` VALUES ('494', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '2', '5a66f061-e081-44a3-bee8-47c1b65cbbb6', '2', '12', '1457946972', '1457946972', '1457946972', '');
INSERT INTO `t_gamebillinfo` VALUES ('495', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '2', 'b3f577aa-d563-465e-baa4-b6e94708d88e', '2', '12', '1457946973', '1457946973', '1457946973', '');
INSERT INTO `t_gamebillinfo` VALUES ('496', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '2', '15bed868-46b8-4d3c-8940-8d27bda0a29d', '2', '12', '1457946974', '1457946974', '1457946974', '');
INSERT INTO `t_gamebillinfo` VALUES ('497', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '2', '95785983-2211-4381-a6c9-2dde709f5f0c', '2', '12', '1457946974', '1457946975', '1457946975', '');
INSERT INTO `t_gamebillinfo` VALUES ('498', '1', 'qz_test_5', '1127', 'xxll', '飞信然rr', '63', '2', '20b388f4-e8bb-4e5a-81f0-fe2714c98b5a', '2', '12', '1457946975', '1457946976', '1457946976', '');
INSERT INTO `t_gamebillinfo` VALUES ('499', '1', 'qz_test_5', '1453', 'siv', 'siv', '48', '1', '1f78ca27-faa6-4872-a34a-55037f40e35e', '2', '6', '1458184006', '1458184007', '1458184007', '');
INSERT INTO `t_gamebillinfo` VALUES ('500', '1', 'qz_test_5', '1453', 'siv', 'siv', '48', '1', 'b5557149-f190-4a55-95eb-c60022f50345', '2', '6', '1458184008', '1458184008', '1458184008', '');
INSERT INTO `t_gamebillinfo` VALUES ('501', '1', 'qz_test_5', '1453', 'siv', 'siv', '48', '7', '5b971f59-98d4-4b9f-ad29-d2467e2b33a7', '2', '3000', '1458184011', '1458184011', '1458184011', '');
INSERT INTO `t_gamebillinfo` VALUES ('502', '1', 'qz_test_5', '1453', 'siv', 'siv', '48', '8', '9f4cfef8-2be0-4d6e-b265-fe2de611e76e', '2', '700', '1458184012', '1458184012', '1458184013', '');
INSERT INTO `t_gamebillinfo` VALUES ('503', '1', 'qz_test_5', '446', 'z2', '运泰初', '54', '1', '4d3c7e5b-72e4-4fff-adc7-95f6b5b45d55', '2', '6', '1458520702', '1458520702', '1458520704', '');
INSERT INTO `t_gamebillinfo` VALUES ('504', '1', 'qz_test_5', '1474', '99270', '库流彩99270', '48', '5', 'f53307ad-e909-48ef-af18-c4ecbb72af84', '2', '90', '1458530807', '1458530807', '1458530807', '');
INSERT INTO `t_gamebillinfo` VALUES ('505', '1', 'qz_test_5', '1474', '99270', '库流彩99270', '48', '5', '74838ef6-4df9-4f8d-a8b2-789e1ea247fa', '2', '90', '1458530808', '1458530808', '1458530808', '');
INSERT INTO `t_gamebillinfo` VALUES ('506', '1', 'qz_test_5', '1474', '99270', '库流彩99270', '48', '5', 'ff1f6e00-7261-4efe-8ddf-a47aa501370b', '2', '90', '1458530808', '1458530808', '1458530809', '');
INSERT INTO `t_gamebillinfo` VALUES ('507', '1', 'qz_test_5', '1474', '99270', '库流彩99270', '48', '5', 'eb5da64a-bcf6-4c23-8d9e-8f6a70203bda', '2', '90', '1458530808', '1458530808', '1458530809', '');
INSERT INTO `t_gamebillinfo` VALUES ('508', '1', 'qz_test_5', '1474', '99270', '库流彩99270', '48', '5', '452ebb84-06d1-467f-9e7f-a9d455909149', '2', '90', '1458530808', '1458530809', '1458530810', '');
INSERT INTO `t_gamebillinfo` VALUES ('509', '1', 'qz_test_5', '1474', '99270', '库流彩99270', '48', '5', 'aa54710b-d44f-4527-88e0-4b0f2f120948', '2', '90', '1458530808', '1458530809', '1458530810', '');
INSERT INTO `t_gamebillinfo` VALUES ('510', '1', 'qz_test_5', '1474', '99270', '库流彩99270', '48', '5', 'f9b3ff9e-a551-4096-9ec4-97501274f59f', '2', '90', '1458530809', '1458530810', '1458530810', '');
INSERT INTO `t_gamebillinfo` VALUES ('511', '1', 'qz_test_5', '1474', '99270', '库流彩99270', '48', '5', '32a91cd8-19db-4321-8b3e-638b00fa1703', '2', '90', '1458530809', '1458530810', '1458530811', '');
INSERT INTO `t_gamebillinfo` VALUES ('512', '1', 'qz_test_5', '1474', '99270', '库流彩99270', '48', '5', 'f02c300f-5164-4457-9bbd-8d0a064162f8', '2', '90', '1458530809', '1458530810', '1458530811', '');
INSERT INTO `t_gamebillinfo` VALUES ('513', '1', 'qz_test_5', '1474', '99270', '库流彩99270', '48', '5', 'b79f9a37-35e2-4c91-97d0-48b5835cffae', '2', '90', '1458530809', '1458530811', '1458530811', '');
INSERT INTO `t_gamebillinfo` VALUES ('514', '1', 'qz_test_5', '1474', '99270', '库流彩99270', '48', '5', '6a8e32dc-9841-4587-bf43-e31cc3273878', '2', '90', '1458530810', '1458530811', '1458530811', '');
INSERT INTO `t_gamebillinfo` VALUES ('515', '1', 'qz_test_5', '1474', '99270', '库流彩99270', '48', '5', 'ffcc7fc8-6821-4dc0-ad7e-353fdbb25e4c', '2', '90', '1458530810', '1458530811', '1458530812', '');
INSERT INTO `t_gamebillinfo` VALUES ('516', '1', 'qz_test_5', '1474', '99270', '库流彩99270', '48', '5', '850ffe22-cb70-42fc-874c-52b837dc41b5', '2', '90', '1458530811', '1458530811', '1458530812', '');
INSERT INTO `t_gamebillinfo` VALUES ('517', '1', 'qz_test_5', '1474', '99270', '库流彩99270', '48', '5', 'd393579c-b948-4823-a681-9e9b54459345', '2', '90', '1458530811', '1458530812', '1458530812', '');
INSERT INTO `t_gamebillinfo` VALUES ('518', '1', 'qz_test_5', '1474', '99270', '库流彩99270', '48', '5', 'a4726aba-32da-4cb6-94d2-19630b5b29d8', '2', '90', '1458530811', '1458530812', '1458530812', '');
INSERT INTO `t_gamebillinfo` VALUES ('519', '1', 'qz_test_5', '1480', 'Qaeda', '韶英锐', '48', '8', '87a4beef-7d7a-4b6d-99e8-ed0df52aa89f', '2', '700', '1458541579', '1458541579', '1458541579', '');
INSERT INTO `t_gamebillinfo` VALUES ('520', '1', 'qz_test_5', '1480', 'Qaeda', '韶英锐', '48', '7', '1cae80b9-06f3-47f7-89c5-e2fd6c728a54', '2', '3000', '1458541581', '1458541581', '1458541581', '');
INSERT INTO `t_gamebillinfo` VALUES ('521', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '3', 'fdb6f870-987b-4681-b789-3a50e96a8c05', '2', '30', '1458546456', '1458546456', '1458546458', '');
INSERT INTO `t_gamebillinfo` VALUES ('522', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '3', 'c19d3352-f95c-4d43-be96-241662560710', '2', '30', '1458546457', '1458546457', '1458546458', '');
INSERT INTO `t_gamebillinfo` VALUES ('523', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '3', '34bf8aae-83cf-4539-8e24-a3ecc071f22e', '2', '30', '1458546458', '1458546458', '1458546458', '');
INSERT INTO `t_gamebillinfo` VALUES ('524', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '3', 'db39d66f-8f3a-4b8c-8ebb-9721a369ca02', '2', '30', '1458546458', '1458546459', '1458546459', '');
INSERT INTO `t_gamebillinfo` VALUES ('525', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '3', 'c79a5bad-6261-44b6-9b4c-d12b16488f5a', '2', '30', '1458546459', '1458546459', '1458546459', '');
INSERT INTO `t_gamebillinfo` VALUES ('526', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '3', 'ff24ee99-09b4-4497-b8b8-bf45877d6ba0', '2', '30', '1458546460', '1458546460', '1458546460', '');
INSERT INTO `t_gamebillinfo` VALUES ('527', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '3', 'c9ad8467-d4b2-4210-806b-12e6a6ac2b29', '2', '30', '1458546460', '1458546460', '1458546460', '');
INSERT INTO `t_gamebillinfo` VALUES ('528', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '3', '9d6140fd-0ba4-4a64-8206-7bd5e1bf095d', '2', '30', '1458546461', '1458546462', '1458546462', '');
INSERT INTO `t_gamebillinfo` VALUES ('529', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '7', '25ef3c01-1136-4982-886b-3b5eb1c8c799', '2', '3000', '1458546538', '1458546538', '1458546538', '');
INSERT INTO `t_gamebillinfo` VALUES ('530', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '4fb6db87-0fd4-48be-9eb5-b2898e835248', '2', '120', '1458546540', '1458546540', '1458546540', '');
INSERT INTO `t_gamebillinfo` VALUES ('531', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'f5ded56c-7ca2-4537-b262-93fec4d0bcd5', '2', '120', '1458546540', '1458546541', '1458546541', '');
INSERT INTO `t_gamebillinfo` VALUES ('532', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '8', '7e3f4548-aae6-4e63-a744-af9400258b86', '2', '700', '1458546545', '1458546545', '1458546545', '');
INSERT INTO `t_gamebillinfo` VALUES ('533', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e312b772-6296-4936-a403-d4da39ef68c5', '2', '120', '1458546550', '1458546550', '1458546550', '');
INSERT INTO `t_gamebillinfo` VALUES ('534', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '932f1a56-d91e-4d55-a968-5111adb0454c', '2', '120', '1458546550', '1458546551', '1458546551', '');
INSERT INTO `t_gamebillinfo` VALUES ('535', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'bf9adac3-7c64-49e1-a847-a4cf40e4f2c1', '2', '120', '1458546557', '1458546557', '1458546558', '');
INSERT INTO `t_gamebillinfo` VALUES ('536', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '9f829535-8369-4418-a5cc-b94fc66cc095', '2', '120', '1458546558', '1458546558', '1458546559', '');
INSERT INTO `t_gamebillinfo` VALUES ('537', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'fed693d6-1d19-4d68-b3ab-0d761eccbd91', '2', '120', '1458546559', '1458546560', '1458546560', '');
INSERT INTO `t_gamebillinfo` VALUES ('538', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '4af1f61a-2a98-4b08-94fc-d421979b9585', '2', '120', '1458546560', '1458546561', '1458546561', '');
INSERT INTO `t_gamebillinfo` VALUES ('539', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '55db7150-fae9-408d-870e-44f36b36544a', '2', '120', '1458546563', '1458546563', '1458546563', '');
INSERT INTO `t_gamebillinfo` VALUES ('540', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '517939dd-1014-467b-b77a-8d03d407529a', '2', '120', '1458546564', '1458546564', '1458546564', '');
INSERT INTO `t_gamebillinfo` VALUES ('541', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b91c0682-978a-49b7-b530-25117f32d112', '2', '120', '1458546565', '1458546566', '1458546566', '');
INSERT INTO `t_gamebillinfo` VALUES ('542', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e17c5dad-1e83-4c4a-89ea-c41dc2d2a7b8', '2', '120', '1458546566', '1458546567', '1458546567', '');
INSERT INTO `t_gamebillinfo` VALUES ('543', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'bc32b4e4-45b5-402b-89de-ed995e55c509', '2', '120', '1458546568', '1458546568', '1458546568', '');
INSERT INTO `t_gamebillinfo` VALUES ('544', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'bebd0b22-f4ce-4eb8-917c-b51219d70931', '2', '120', '1458546569', '1458546569', '1458546569', '');
INSERT INTO `t_gamebillinfo` VALUES ('545', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b3e2f41d-fb26-497c-aaa8-9c4690fc1665', '2', '120', '1458546570', '1458546571', '1458546572', '');
INSERT INTO `t_gamebillinfo` VALUES ('546', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2ad1ee1b-3eb0-4862-a921-7f8a16801474', '2', '120', '1458546574', '1458546574', '1458546574', '');
INSERT INTO `t_gamebillinfo` VALUES ('547', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '780572b5-bfba-4c37-9261-5b5370143581', '2', '120', '1458546575', '1458546575', '1458546575', '');
INSERT INTO `t_gamebillinfo` VALUES ('548', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'fac9d5ea-e6d3-474b-a1f2-e67ae9abb9c6', '2', '120', '1458546580', '1458546580', '1458546580', '');
INSERT INTO `t_gamebillinfo` VALUES ('549', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '7d5184c3-0856-4537-8c4f-0a9160af1ffa', '2', '120', '1458546580', '1458546581', '1458546581', '');
INSERT INTO `t_gamebillinfo` VALUES ('550', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'f0053dd7-9cfd-4b26-abd2-6799fbaed0df', '2', '120', '1458546583', '1458546583', '1458546583', '');
INSERT INTO `t_gamebillinfo` VALUES ('551', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6c5f980f-d494-45a8-9b0f-a882d8ff7c4e', '2', '120', '1458546584', '1458546584', '1458546584', '');
INSERT INTO `t_gamebillinfo` VALUES ('552', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '622c20bf-07c4-49f2-bfdb-b9b2ce8b8cd1', '2', '120', '1458546585', '1458546585', '1458546585', '');
INSERT INTO `t_gamebillinfo` VALUES ('553', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '3982de1e-e4ca-464f-8c7c-fec26a082ac7', '2', '120', '1458546586', '1458546587', '1458546587', '');
INSERT INTO `t_gamebillinfo` VALUES ('554', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '79daf990-4099-4fd3-a8ff-afbf4310476c', '2', '120', '1458546587', '1458546587', '1458546588', '');
INSERT INTO `t_gamebillinfo` VALUES ('555', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '0d0b4b6f-f94c-4d7b-98b8-fffb36089c7f', '2', '120', '1458546588', '1458546589', '1458546589', '');
INSERT INTO `t_gamebillinfo` VALUES ('556', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'd4ff19a9-c067-42ae-9cc3-99a2ad098104', '2', '120', '1458546590', '1458546591', '1458546591', '');
INSERT INTO `t_gamebillinfo` VALUES ('557', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '4e0f410d-0581-4f69-a81b-a02f6e3fade5', '2', '120', '1458546592', '1458546592', '1458546592', '');
INSERT INTO `t_gamebillinfo` VALUES ('558', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6f8af602-0718-4f15-85ff-18ef0965fa33', '2', '120', '1458546593', '1458546593', '1458546593', '');
INSERT INTO `t_gamebillinfo` VALUES ('559', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'eb686f6f-c4f2-4e46-bc93-e50d8d638a72', '2', '120', '1458546595', '1458546595', '1458546595', '');
INSERT INTO `t_gamebillinfo` VALUES ('560', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '96b1758e-847f-4a1d-9ff9-c07ade98948a', '2', '120', '1458546596', '1458546596', '1458546596', '');
INSERT INTO `t_gamebillinfo` VALUES ('561', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '34122f90-766d-45e9-a7da-54fd30373f3d', '2', '120', '1458546596', '1458546597', '1458546597', '');
INSERT INTO `t_gamebillinfo` VALUES ('562', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'de4d2954-5f3c-4c0c-bda6-7184db1fd165', '2', '120', '1458546597', '1458546597', '1458546598', '');
INSERT INTO `t_gamebillinfo` VALUES ('563', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '7ba146ca-7c28-4c6e-a443-91d812b1059a', '2', '120', '1458546600', '1458546600', '1458546600', '');
INSERT INTO `t_gamebillinfo` VALUES ('564', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '208e5ae3-c3b6-4fd3-a645-242e669ac5a4', '2', '120', '1458546602', '1458546602', '1458546602', '');
INSERT INTO `t_gamebillinfo` VALUES ('565', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '81302b14-4554-4313-8e9e-90be25bebc63', '2', '120', '1458546602', '1458546602', '1458546603', '');
INSERT INTO `t_gamebillinfo` VALUES ('566', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '54c46123-8efe-4103-98c2-bc3e8da2cb71', '2', '120', '1458546603', '1458546603', '1458546603', '');
INSERT INTO `t_gamebillinfo` VALUES ('567', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '79bf0d8e-7121-47e9-9740-e57a30cc1d63', '2', '120', '1458546604', '1458546604', '1458546604', '');
INSERT INTO `t_gamebillinfo` VALUES ('568', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c2bdd7bb-1c75-427f-91ae-13a6b2b860fa', '2', '120', '1458546604', '1458546604', '1458546604', '');
INSERT INTO `t_gamebillinfo` VALUES ('569', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '7081dc74-580e-434d-b946-794a6b2a41db', '2', '120', '1458546605', '1458546605', '1458546605', '');
INSERT INTO `t_gamebillinfo` VALUES ('570', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '7383e9d8-0b66-4de5-a8f5-292cd735bebe', '2', '120', '1458546605', '1458546605', '1458546606', '');
INSERT INTO `t_gamebillinfo` VALUES ('571', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '5d7c2b35-9dde-443d-9f3f-40f4dd24e91c', '2', '120', '1458546606', '1458546606', '1458546606', '');
INSERT INTO `t_gamebillinfo` VALUES ('572', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'a596a685-7d5f-4695-a55b-ebd839033a04', '2', '120', '1458546607', '1458546607', '1458546607', '');
INSERT INTO `t_gamebillinfo` VALUES ('573', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'f114ca1a-167c-481c-89af-6ab05982e78b', '2', '120', '1458546607', '1458546607', '1458546608', '');
INSERT INTO `t_gamebillinfo` VALUES ('574', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e390ae32-b996-4395-ac44-f6d70d7fc957', '2', '120', '1458546607', '1458546608', '1458546608', '');
INSERT INTO `t_gamebillinfo` VALUES ('575', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'bcd44467-4767-4a52-90a0-55a641aea3e4', '2', '120', '1458546608', '1458546608', '1458546608', '');
INSERT INTO `t_gamebillinfo` VALUES ('576', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c61b2a79-d7fe-4943-9fc2-0c4a33843f6d', '2', '120', '1458546608', '1458546608', '1458546609', '');
INSERT INTO `t_gamebillinfo` VALUES ('577', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ceb18eb3-5f29-459d-a60f-fb7c8076fd1c', '2', '120', '1458546610', '1458546611', '1458546611', '');
INSERT INTO `t_gamebillinfo` VALUES ('578', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '30f09df9-7fe9-4fb9-a1c1-6c7b88de3b3c', '2', '120', '1458546611', '1458546611', '1458546612', '');
INSERT INTO `t_gamebillinfo` VALUES ('579', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '10a72bc2-8720-4be1-b5fb-611523d65cf3', '2', '120', '1458546614', '1458546614', '1458546614', '');
INSERT INTO `t_gamebillinfo` VALUES ('580', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '34e4b1b0-94b8-4ef6-99fe-95c4458baa67', '2', '120', '1458546614', '1458546614', '1458546614', '');
INSERT INTO `t_gamebillinfo` VALUES ('581', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'd6b629c7-cfc6-4bc8-a52a-3bfad41f2ad2', '2', '120', '1458546614', '1458546615', '1458546615', '');
INSERT INTO `t_gamebillinfo` VALUES ('582', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'a02d67b0-edd6-4784-9ef4-eaaabdcb5941', '2', '120', '1458546615', '1458546615', '1458546615', '');
INSERT INTO `t_gamebillinfo` VALUES ('583', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2b4dd885-dd83-4b7d-ae73-198e01f9e4dc', '2', '120', '1458546615', '1458546615', '1458546615', '');
INSERT INTO `t_gamebillinfo` VALUES ('584', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'f32516e8-0794-4abb-8a2d-4f06029601db', '2', '120', '1458546616', '1458546616', '1458546616', '');
INSERT INTO `t_gamebillinfo` VALUES ('585', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '32be08fa-47da-4f68-a5e6-33bb87946a0b', '2', '120', '1458546616', '1458546616', '1458546616', '');
INSERT INTO `t_gamebillinfo` VALUES ('586', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c658e0e9-dc96-473d-8116-96dafa1b971c', '2', '120', '1458546616', '1458546616', '1458546617', '');
INSERT INTO `t_gamebillinfo` VALUES ('587', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '448b0c6b-c1cb-4dd1-a4bb-4dac3640a553', '2', '120', '1458546617', '1458546617', '1458546617', '');
INSERT INTO `t_gamebillinfo` VALUES ('588', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6f23b6be-6124-4b7f-aed3-baf5c2b800a8', '2', '120', '1458546617', '1458546617', '1458546617', '');
INSERT INTO `t_gamebillinfo` VALUES ('589', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '3db2fc83-3978-4c0a-a5cf-176dab63eef7', '2', '120', '1458546617', '1458546617', '1458546617', '');
INSERT INTO `t_gamebillinfo` VALUES ('590', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '4bbfcfd4-f437-4424-ad58-baa33b78bba1', '2', '120', '1458546617', '1458546617', '1458546618', '');
INSERT INTO `t_gamebillinfo` VALUES ('591', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'cece1aa3-5391-48d1-a435-b59061082ba2', '2', '120', '1458546618', '1458546618', '1458546618', '');
INSERT INTO `t_gamebillinfo` VALUES ('592', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '3ca2f39a-18c1-44e9-8b69-fe1ed2621f92', '2', '120', '1458546618', '1458546618', '1458546618', '');
INSERT INTO `t_gamebillinfo` VALUES ('593', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e0bf073f-e7b7-4b9e-95a8-8dae08feef16', '2', '120', '1458546618', '1458546618', '1458546619', '');
INSERT INTO `t_gamebillinfo` VALUES ('594', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '711eeee7-6b7c-40e7-852e-6cb178c72f0a', '2', '120', '1458546618', '1458546618', '1458546619', '');
INSERT INTO `t_gamebillinfo` VALUES ('595', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'a0dd418a-7dff-4440-8301-4970767b38b1', '2', '120', '1458546619', '1458546619', '1458546619', '');
INSERT INTO `t_gamebillinfo` VALUES ('596', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '1d642cf5-35e3-4f96-9c9e-e8a65a4b9a6b', '2', '120', '1458546619', '1458546619', '1458546619', '');
INSERT INTO `t_gamebillinfo` VALUES ('597', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '64d7722d-479a-4047-a8c2-dbf7254160e8', '2', '120', '1458546619', '1458546619', '1458546619', '');
INSERT INTO `t_gamebillinfo` VALUES ('598', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '5d3144ad-5af2-463f-9dac-6c6e2b5c183c', '2', '120', '1458546619', '1458546620', '1458546620', '');
INSERT INTO `t_gamebillinfo` VALUES ('599', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '988988d4-6fc6-4bb3-902e-814452d3514e', '2', '120', '1458546620', '1458546620', '1458546620', '');
INSERT INTO `t_gamebillinfo` VALUES ('600', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '1a8f222b-13bf-42f2-938b-2cddb55f73f9', '2', '120', '1458546620', '1458546620', '1458546620', '');
INSERT INTO `t_gamebillinfo` VALUES ('601', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '4967f895-0c1f-4a94-96f4-d03331b17873', '2', '120', '1458546624', '1458546624', '1458546625', '');
INSERT INTO `t_gamebillinfo` VALUES ('602', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '0004b10e-1398-4c80-9f3a-96e7dda2c632', '2', '120', '1458546625', '1458546625', '1458546625', '');
INSERT INTO `t_gamebillinfo` VALUES ('603', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '44821235-ea05-42da-bdf8-5fc8fddde30c', '2', '120', '1458546625', '1458546625', '1458546625', '');
INSERT INTO `t_gamebillinfo` VALUES ('604', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6c9511a5-cd80-42f7-b7e1-3a4ff5e14892', '2', '120', '1458546627', '1458546628', '1458546628', '');
INSERT INTO `t_gamebillinfo` VALUES ('605', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '65b456aa-57f5-4a64-b8a4-aec59810d107', '2', '120', '1458546629', '1458546629', '1458546629', '');
INSERT INTO `t_gamebillinfo` VALUES ('606', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '44f41d9d-7fc4-4a0d-9a6e-285ab9d1f16e', '2', '120', '1458546629', '1458546629', '1458546629', '');
INSERT INTO `t_gamebillinfo` VALUES ('607', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '0ff4a45c-dd0c-4895-817d-d70fdd60a766', '2', '120', '1458546633', '1458546633', '1458546633', '');
INSERT INTO `t_gamebillinfo` VALUES ('608', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '5399af68-a1a9-4cbb-b538-e1ac9bf8a19a', '2', '120', '1458546633', '1458546634', '1458546634', '');
INSERT INTO `t_gamebillinfo` VALUES ('609', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '17ace987-7171-4bb3-b3cc-ff51b1c2bc7d', '2', '120', '1458546634', '1458546634', '1458546634', '');
INSERT INTO `t_gamebillinfo` VALUES ('610', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'f4240a30-ec3e-4746-a20a-5afbff4a2334', '2', '120', '1458546636', '1458546636', '1458546636', '');
INSERT INTO `t_gamebillinfo` VALUES ('611', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'f71cefb8-c526-4334-87d2-c76fa49cc9fc', '2', '120', '1458546636', '1458546636', '1458546637', '');
INSERT INTO `t_gamebillinfo` VALUES ('612', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '676dba5c-2ed5-4700-888b-849d469b082d', '2', '120', '1458546637', '1458546637', '1458546637', '');
INSERT INTO `t_gamebillinfo` VALUES ('613', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '83b228a0-2e4e-4a90-9108-403a0cc8e729', '2', '120', '1458546637', '1458546637', '1458546637', '');
INSERT INTO `t_gamebillinfo` VALUES ('614', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '02c90e12-f3de-4865-b3c5-72fdc8da4bfd', '2', '120', '1458546637', '1458546637', '1458546638', '');
INSERT INTO `t_gamebillinfo` VALUES ('615', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '9c907568-ce3c-499f-8442-6d6ec9f5eaa3', '2', '120', '1458546638', '1458546638', '1458546638', '');
INSERT INTO `t_gamebillinfo` VALUES ('616', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ae17eb4a-218b-4e3f-8e53-cf80bb30ac59', '2', '120', '1458546638', '1458546638', '1458546638', '');
INSERT INTO `t_gamebillinfo` VALUES ('617', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'bd21a30a-e4ac-42d4-97bb-39230a07f627', '2', '120', '1458546638', '1458546638', '1458546639', '');
INSERT INTO `t_gamebillinfo` VALUES ('618', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c66304dc-3372-4b90-ad60-566f533a1cdc', '2', '120', '1458546639', '1458546639', '1458546639', '');
INSERT INTO `t_gamebillinfo` VALUES ('619', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b67a21ae-55cb-4f0a-b76f-690d82bf7f39', '2', '120', '1458546639', '1458546639', '1458546640', '');
INSERT INTO `t_gamebillinfo` VALUES ('620', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e7ff8ac4-fbb1-4802-9137-84c1a11b86fb', '2', '120', '1458546640', '1458546640', '1458546640', '');
INSERT INTO `t_gamebillinfo` VALUES ('621', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6aaa328c-45db-4971-8034-2bbdd65b5162', '2', '120', '1458546640', '1458546640', '1458546640', '');
INSERT INTO `t_gamebillinfo` VALUES ('622', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'a44f482e-92a9-40a4-8bab-9a5c18522696', '2', '120', '1458546641', '1458546641', '1458546641', '');
INSERT INTO `t_gamebillinfo` VALUES ('623', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '9830d276-9e02-4fd8-89c1-85a128cf7dbd', '2', '120', '1458546641', '1458546642', '1458546642', '');
INSERT INTO `t_gamebillinfo` VALUES ('624', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'dca8cc28-1da4-4347-83ba-0ec6878bfdc3', '2', '120', '1458546642', '1458546642', '1458546642', '');
INSERT INTO `t_gamebillinfo` VALUES ('625', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '34302ff5-cff1-4b68-af72-18dcd727cd9c', '2', '120', '1458546642', '1458546642', '1458546642', '');
INSERT INTO `t_gamebillinfo` VALUES ('626', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '0a9af4fe-3418-4e2f-b49c-9157e3e15a47', '2', '120', '1458546642', '1458546642', '1458546643', '');
INSERT INTO `t_gamebillinfo` VALUES ('627', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '95854ad1-2a45-45c6-8eb4-941f2d1f4578', '2', '120', '1458546643', '1458546643', '1458546643', '');
INSERT INTO `t_gamebillinfo` VALUES ('628', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'd1f291c4-740f-47fe-a2fb-84ccc651d468', '2', '120', '1458546643', '1458546643', '1458546643', '');
INSERT INTO `t_gamebillinfo` VALUES ('629', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '35dd3412-86e6-4ffb-9c2b-65a6dd681c65', '2', '120', '1458546651', '1458546651', '1458546651', '');
INSERT INTO `t_gamebillinfo` VALUES ('630', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'cdce8aa1-1730-4f1c-be04-9db884cbd328', '2', '120', '1458546651', '1458546652', '1458546652', '');
INSERT INTO `t_gamebillinfo` VALUES ('631', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'fc33bffe-4db3-490c-8713-e4cc6edac12e', '2', '120', '1458546652', '1458546652', '1458546652', '');
INSERT INTO `t_gamebillinfo` VALUES ('632', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '8e786fa3-1ed5-48c5-be97-aec3ac2c9f91', '2', '120', '1458546653', '1458546653', '1458546653', '');
INSERT INTO `t_gamebillinfo` VALUES ('633', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '966920fc-f6a5-4819-90c7-ef6bb14f6b8e', '2', '120', '1458546653', '1458546653', '1458546653', '');
INSERT INTO `t_gamebillinfo` VALUES ('634', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '8a2e27e9-d53b-4333-8ed4-481b362e3b2d', '2', '120', '1458546654', '1458546654', '1458546654', '');
INSERT INTO `t_gamebillinfo` VALUES ('635', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '1b230aed-4d1d-46c0-91ca-bc5b3ed0a852', '2', '120', '1458546654', '1458546654', '1458546654', '');
INSERT INTO `t_gamebillinfo` VALUES ('636', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '3392a00b-6d37-45a7-8c4c-ce2f23923992', '2', '120', '1458546654', '1458546654', '1458546654', '');
INSERT INTO `t_gamebillinfo` VALUES ('637', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b1538a32-f278-4ea6-9593-044c2c8c597d', '2', '120', '1458546656', '1458546656', '1458546656', '');
INSERT INTO `t_gamebillinfo` VALUES ('638', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '8349d017-7e40-48cc-8268-d5904249fde5', '2', '120', '1458546656', '1458546657', '1458546657', '');
INSERT INTO `t_gamebillinfo` VALUES ('639', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'f4ef3323-3bd3-44f2-9ed7-b822eab27450', '2', '120', '1458546669', '1458546669', '1458546669', '');
INSERT INTO `t_gamebillinfo` VALUES ('640', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b5e0f18e-0a44-4649-9194-5a8fca1fdee7', '2', '120', '1458546675', '1458546675', '1458546675', '');
INSERT INTO `t_gamebillinfo` VALUES ('641', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '047aebb9-0539-45e4-8bdf-12a359b2ecdd', '2', '120', '1458546675', '1458546676', '1458546676', '');
INSERT INTO `t_gamebillinfo` VALUES ('642', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2de16a86-9a9a-4553-91f6-5593145e5ad2', '2', '120', '1458546677', '1458546678', '1458546678', '');
INSERT INTO `t_gamebillinfo` VALUES ('643', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '70769d5c-9a03-4006-9cec-c987ae7fa737', '2', '120', '1458546678', '1458546678', '1458546678', '');
INSERT INTO `t_gamebillinfo` VALUES ('644', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'bee1973d-f2ef-4d0f-8c83-0824a5d4e17b', '2', '120', '1458546678', '1458546678', '1458546679', '');
INSERT INTO `t_gamebillinfo` VALUES ('645', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'dcd5eb46-c85f-469e-a07d-40045b4e5a3b', '2', '120', '1458546679', '1458546679', '1458546679', '');
INSERT INTO `t_gamebillinfo` VALUES ('646', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'cdb6acc2-718a-4af2-b06a-224cfc3b9e15', '2', '120', '1458546679', '1458546679', '1458546679', '');
INSERT INTO `t_gamebillinfo` VALUES ('647', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c4c6a31a-a50d-4f03-bee3-c5fb894cfa3c', '2', '120', '1458546679', '1458546679', '1458546679', '');
INSERT INTO `t_gamebillinfo` VALUES ('648', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '000c6855-1088-4ad3-9174-c4c539b64429', '2', '120', '1458546680', '1458546680', '1458546680', '');
INSERT INTO `t_gamebillinfo` VALUES ('649', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2ddcb176-d810-40fb-8333-f972b49ea40e', '2', '120', '1458546680', '1458546680', '1458546680', '');
INSERT INTO `t_gamebillinfo` VALUES ('650', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6d8fbef2-f541-4904-9557-02116f564e5d', '2', '120', '1458546680', '1458546680', '1458546680', '');
INSERT INTO `t_gamebillinfo` VALUES ('651', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '026a0ca1-a333-4050-9cbf-f452a94bb0d6', '2', '120', '1458546680', '1458546681', '1458546681', '');
INSERT INTO `t_gamebillinfo` VALUES ('652', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '83047d4b-dfa5-4f9e-92ac-ff2146aeb710', '2', '120', '1458546681', '1458546681', '1458546681', '');
INSERT INTO `t_gamebillinfo` VALUES ('653', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '4c69c298-d58c-4381-978f-db0c15dd9f1f', '2', '120', '1458546681', '1458546681', '1458546682', '');
INSERT INTO `t_gamebillinfo` VALUES ('654', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '58630dbe-f9b2-4ad9-b938-700266352440', '2', '120', '1458546682', '1458546682', '1458546682', '');
INSERT INTO `t_gamebillinfo` VALUES ('655', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2192ba5d-fff8-4f41-8618-802c8e5d9c72', '2', '120', '1458546684', '1458546684', '1458546685', '');
INSERT INTO `t_gamebillinfo` VALUES ('656', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6303cc04-5342-4327-918a-e5a3a9af7ae2', '2', '120', '1458546685', '1458546685', '1458546685', '');
INSERT INTO `t_gamebillinfo` VALUES ('657', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'f922b521-fa6c-42ed-9eab-4b83e88d7187', '2', '120', '1458546686', '1458546686', '1458546686', '');
INSERT INTO `t_gamebillinfo` VALUES ('658', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2b7f8a90-d54f-42fd-9dc4-aeab130883e3', '2', '120', '1458546686', '1458546687', '1458546687', '');
INSERT INTO `t_gamebillinfo` VALUES ('659', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'aef8bac5-6430-4ba4-9c06-c3ad579d74b7', '2', '120', '1458546687', '1458546688', '1458546688', '');
INSERT INTO `t_gamebillinfo` VALUES ('660', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '4677dc01-49ad-47d1-a15e-387850de84ad', '2', '120', '1458546688', '1458546688', '1458546688', '');
INSERT INTO `t_gamebillinfo` VALUES ('661', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'a9920356-056a-4d56-8e49-fb391a8cb1e6', '2', '120', '1458546689', '1458546689', '1458546689', '');
INSERT INTO `t_gamebillinfo` VALUES ('662', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '237c6c04-e9ac-4118-90ba-650192244039', '2', '120', '1458546689', '1458546689', '1458546689', '');
INSERT INTO `t_gamebillinfo` VALUES ('663', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e88f022f-4e92-45f3-8cbd-9912f5ef32cd', '2', '120', '1458546689', '1458546690', '1458546690', '');
INSERT INTO `t_gamebillinfo` VALUES ('664', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '8ec4b945-a3b7-4cb1-8b07-ebb84893bcdb', '2', '120', '1458546690', '1458546690', '1458546690', '');
INSERT INTO `t_gamebillinfo` VALUES ('665', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '1aff16b4-8898-4cbf-99ad-e3e6870e0c07', '2', '120', '1458546691', '1458546691', '1458546691', '');
INSERT INTO `t_gamebillinfo` VALUES ('666', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '7fa01c73-9eae-4707-83e2-3129131e3320', '2', '120', '1458546691', '1458546691', '1458546691', '');
INSERT INTO `t_gamebillinfo` VALUES ('667', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '7bdf5c01-7a8a-4bf2-82d2-dc8359ab2f8b', '2', '120', '1458546692', '1458546692', '1458546692', '');
INSERT INTO `t_gamebillinfo` VALUES ('668', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '00cb54c1-1b4f-4eaf-84c0-b07c3c9936b9', '2', '120', '1458546693', '1458546693', '1458546693', '');
INSERT INTO `t_gamebillinfo` VALUES ('669', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '1317ff72-9a22-4c25-bf20-e239803b63c0', '2', '120', '1458546693', '1458546693', '1458546694', '');
INSERT INTO `t_gamebillinfo` VALUES ('670', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '12d33e72-e718-4ab7-a35f-49fd9c920f28', '2', '120', '1458546693', '1458546694', '1458546694', '');
INSERT INTO `t_gamebillinfo` VALUES ('671', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '4e614f25-8a1b-4df2-9322-fffeeeb76269', '2', '120', '1458546694', '1458546694', '1458546694', '');
INSERT INTO `t_gamebillinfo` VALUES ('672', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'afacd9e8-08f9-4adb-84ad-9ed80ebf7d74', '2', '120', '1458546694', '1458546694', '1458546694', '');
INSERT INTO `t_gamebillinfo` VALUES ('673', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e729b155-9159-4283-b55a-8864970bf341', '2', '120', '1458546694', '1458546694', '1458546694', '');
INSERT INTO `t_gamebillinfo` VALUES ('674', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c6d9726d-9d68-4cb0-9479-9ab9f5bf8e73', '2', '120', '1458546694', '1458546694', '1458546695', '');
INSERT INTO `t_gamebillinfo` VALUES ('675', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e2b43dc8-c12e-4eb4-bf2a-324f21a27ba0', '2', '120', '1458546694', '1458546695', '1458546695', '');
INSERT INTO `t_gamebillinfo` VALUES ('676', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '49335a4a-83ab-41ac-b03c-2c0f96012feb', '2', '120', '1458546696', '1458546696', '1458546696', '');
INSERT INTO `t_gamebillinfo` VALUES ('677', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'a7a54d66-82a5-4d25-b14f-dc5b2206f854', '2', '120', '1458546697', '1458546697', '1458546697', '');
INSERT INTO `t_gamebillinfo` VALUES ('678', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'dff99137-da08-4100-a345-75e737541a01', '2', '120', '1458546697', '1458546697', '1458546697', '');
INSERT INTO `t_gamebillinfo` VALUES ('679', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '8a114523-5d5d-4945-b94d-c138f582f694', '2', '120', '1458546698', '1458546698', '1458546698', '');
INSERT INTO `t_gamebillinfo` VALUES ('680', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'd20124e2-0654-4cba-9528-cc4063d4ab36', '2', '120', '1458546698', '1458546699', '1458546699', '');
INSERT INTO `t_gamebillinfo` VALUES ('681', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '0926574d-029f-4460-b04e-d5e6b9d5e87e', '2', '120', '1458546699', '1458546699', '1458546699', '');
INSERT INTO `t_gamebillinfo` VALUES ('682', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2ca993af-d690-4721-828b-169556549b58', '2', '120', '1458546701', '1458546701', '1458546702', '');
INSERT INTO `t_gamebillinfo` VALUES ('683', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '9489a623-2c67-4376-93a7-9ae05cf78eb1', '2', '120', '1458546702', '1458546702', '1458546702', '');
INSERT INTO `t_gamebillinfo` VALUES ('684', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '9925cfc3-9bff-4af6-b197-7b6db42188db', '2', '120', '1458546702', '1458546703', '1458546703', '');
INSERT INTO `t_gamebillinfo` VALUES ('685', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '25e28f61-0633-4ed6-bd0b-2b9e6920d180', '2', '120', '1458546703', '1458546703', '1458546703', '');
INSERT INTO `t_gamebillinfo` VALUES ('686', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '20b76a94-289f-4940-b7e7-aa777459f3a5', '2', '120', '1458546704', '1458546704', '1458546704', '');
INSERT INTO `t_gamebillinfo` VALUES ('687', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c95b6b80-50cd-411c-a53f-1448a5cfe036', '2', '120', '1458546705', '1458546705', '1458546705', '');
INSERT INTO `t_gamebillinfo` VALUES ('688', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '48098039-24bc-439d-86cf-27f974cba29e', '2', '120', '1458546705', '1458546706', '1458546706', '');
INSERT INTO `t_gamebillinfo` VALUES ('689', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '3961e2e4-5e3d-48a4-9a1a-27cec4841b79', '2', '120', '1458546708', '1458546708', '1458546708', '');
INSERT INTO `t_gamebillinfo` VALUES ('690', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '4a309b74-301f-429c-bcbe-a197231783ae', '2', '120', '1458546735', '1458546735', '1458546735', '');
INSERT INTO `t_gamebillinfo` VALUES ('691', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e477b470-7aa7-4ad7-8fb3-c1c220f5fb17', '2', '120', '1458546736', '1458546736', '1458546736', '');
INSERT INTO `t_gamebillinfo` VALUES ('692', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '519225d8-0f35-4036-a59e-e7344f6d1442', '2', '120', '1458546736', '1458546736', '1458546736', '');
INSERT INTO `t_gamebillinfo` VALUES ('693', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b4c28111-435f-4a1b-8a02-9ce20058c2fa', '2', '120', '1458546737', '1458546737', '1458546737', '');
INSERT INTO `t_gamebillinfo` VALUES ('694', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2fd348e9-2b79-410c-8b32-b19540cd19e7', '2', '120', '1458546737', '1458546737', '1458546737', '');
INSERT INTO `t_gamebillinfo` VALUES ('695', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c44c5a45-a00a-4393-9f3a-7b37e95a4908', '2', '120', '1458546737', '1458546737', '1458546738', '');
INSERT INTO `t_gamebillinfo` VALUES ('696', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'deceaeda-b0a4-41c5-963b-09233577854d', '2', '120', '1458546738', '1458546738', '1458546738', '');
INSERT INTO `t_gamebillinfo` VALUES ('697', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'dab87687-7703-4b82-acff-99c96f917332', '2', '120', '1458546738', '1458546738', '1458546738', '');
INSERT INTO `t_gamebillinfo` VALUES ('698', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '780eac76-e9df-45bd-a601-aea66739e0a4', '2', '120', '1458546738', '1458546739', '1458546739', '');
INSERT INTO `t_gamebillinfo` VALUES ('699', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b8b1c09d-9fe3-41d5-8594-bf5f7edde2ff', '2', '120', '1458546739', '1458546739', '1458546739', '');
INSERT INTO `t_gamebillinfo` VALUES ('700', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ae113ea0-3744-4912-a9b4-47825d4f2dca', '2', '120', '1458546739', '1458546739', '1458546739', '');
INSERT INTO `t_gamebillinfo` VALUES ('701', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '97bac4b3-40c1-469a-9144-698a247c64c6', '2', '120', '1458546739', '1458546740', '1458546740', '');
INSERT INTO `t_gamebillinfo` VALUES ('702', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'a24d2dd5-4636-4068-82ca-1e84aa3a11e0', '2', '120', '1458546740', '1458546740', '1458546741', '');
INSERT INTO `t_gamebillinfo` VALUES ('703', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e86aa483-31cf-493c-8eaf-691f06582d73', '2', '120', '1458546741', '1458546741', '1458546741', '');
INSERT INTO `t_gamebillinfo` VALUES ('704', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6927864c-097b-4c84-931b-78d79ec851f3', '2', '120', '1458546741', '1458546742', '1458546742', '');
INSERT INTO `t_gamebillinfo` VALUES ('705', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '9882e3de-587a-4d5e-b4db-3ec1fe6aedd1', '2', '120', '1458546743', '1458546743', '1458546743', '');
INSERT INTO `t_gamebillinfo` VALUES ('706', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '00679981-1be1-4beb-b328-b97a04f1c748', '2', '120', '1458546743', '1458546743', '1458546743', '');
INSERT INTO `t_gamebillinfo` VALUES ('707', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '596ad751-2604-4070-8828-96c0b48698d1', '2', '120', '1458546743', '1458546743', '1458546743', '');
INSERT INTO `t_gamebillinfo` VALUES ('708', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'a501aae1-92e0-4fd7-8159-5a8de513fb33', '2', '120', '1458546744', '1458546744', '1458546744', '');
INSERT INTO `t_gamebillinfo` VALUES ('709', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '58812b81-5253-4a78-9716-f9707a763e6c', '2', '120', '1458546744', '1458546744', '1458546744', '');
INSERT INTO `t_gamebillinfo` VALUES ('710', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '8c6304e9-80c5-4f58-81b1-5fce0d7e3477', '2', '120', '1458546744', '1458546744', '1458546745', '');
INSERT INTO `t_gamebillinfo` VALUES ('711', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '4a759304-0e55-4c6b-a398-3219f3c1047c', '2', '120', '1458546745', '1458546746', '1458546746', '');
INSERT INTO `t_gamebillinfo` VALUES ('712', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'cc21bc9a-9913-49fe-923c-522284b5ea6f', '2', '120', '1458546746', '1458546746', '1458546746', '');
INSERT INTO `t_gamebillinfo` VALUES ('713', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e1cd3b1f-f0ff-4b39-ac2c-80b9e1295db1', '2', '120', '1458546746', '1458546746', '1458546747', '');
INSERT INTO `t_gamebillinfo` VALUES ('714', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'cb33b6f5-c918-462f-b256-cce11ff41726', '2', '120', '1458546747', '1458546747', '1458546747', '');
INSERT INTO `t_gamebillinfo` VALUES ('715', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '026cdd3b-1a6c-4a59-a5e8-8db1f1e529e7', '2', '120', '1458546747', '1458546747', '1458546747', '');
INSERT INTO `t_gamebillinfo` VALUES ('716', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ac1fcd88-d900-4e82-9356-8113bf7354a8', '2', '120', '1458546747', '1458546747', '1458546748', '');
INSERT INTO `t_gamebillinfo` VALUES ('717', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6e7c6236-4c11-496e-81f3-d72cc05dd222', '2', '120', '1458546747', '1458546748', '1458546748', '');
INSERT INTO `t_gamebillinfo` VALUES ('718', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6be2609b-350e-4dda-a0ad-948aea41b340', '2', '120', '1458546748', '1458546749', '1458546749', '');
INSERT INTO `t_gamebillinfo` VALUES ('719', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '15ac9c6b-bd06-42bf-9e53-5fbe4ab5588a', '2', '120', '1458546749', '1458546749', '1458546749', '');
INSERT INTO `t_gamebillinfo` VALUES ('720', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '37b383b9-70fa-4ed4-b1fc-f1c5f143d318', '2', '120', '1458546749', '1458546749', '1458546749', '');
INSERT INTO `t_gamebillinfo` VALUES ('721', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '27e94dff-3ffe-44a6-893d-08611f2936e1', '2', '120', '1458546749', '1458546749', '1458546750', '');
INSERT INTO `t_gamebillinfo` VALUES ('722', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '1b6fd735-90c3-4b1c-88b6-54aa124dd791', '2', '120', '1458546749', '1458546749', '1458546750', '');
INSERT INTO `t_gamebillinfo` VALUES ('723', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '449178a5-7cca-4a58-9232-13b08f355dd7', '2', '120', '1458546750', '1458546750', '1458546750', '');
INSERT INTO `t_gamebillinfo` VALUES ('724', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6c8bbb2b-c430-4706-a590-bad49bc7c66e', '2', '120', '1458546750', '1458546750', '1458546750', '');
INSERT INTO `t_gamebillinfo` VALUES ('725', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6bdbd452-b16a-4994-91b8-ed12ca73cf41', '2', '120', '1458546750', '1458546750', '1458546751', '');
INSERT INTO `t_gamebillinfo` VALUES ('726', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ff8c7ca1-74f6-490f-a1d9-610095d8b8eb', '2', '120', '1458546751', '1458546751', '1458546751', '');
INSERT INTO `t_gamebillinfo` VALUES ('727', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '1224b192-2e40-4b30-b223-2f356abf9c67', '2', '120', '1458546752', '1458546752', '1458546752', '');
INSERT INTO `t_gamebillinfo` VALUES ('728', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ca5e9699-8712-4d8c-a176-c2d404daed4d', '2', '120', '1458546752', '1458546752', '1458546753', '');
INSERT INTO `t_gamebillinfo` VALUES ('729', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ce36a053-c06f-44d3-b331-ddc91f489296', '2', '120', '1458546752', '1458546753', '1458546753', '');
INSERT INTO `t_gamebillinfo` VALUES ('730', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'fd4c7c1a-146a-4fe1-8204-9c5c7389587f', '2', '120', '1458546753', '1458546753', '1458546753', '');
INSERT INTO `t_gamebillinfo` VALUES ('731', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ef2722ea-dfa1-4687-90aa-944f903d3a85', '2', '120', '1458546753', '1458546753', '1458546754', '');
INSERT INTO `t_gamebillinfo` VALUES ('732', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'd8f6acc8-78b4-4a4c-97b3-e7a75006e051', '2', '120', '1458546753', '1458546754', '1458546754', '');
INSERT INTO `t_gamebillinfo` VALUES ('733', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'a3ea813b-e3c3-4614-8cc4-74cdfd287221', '2', '120', '1458546754', '1458546755', '1458546755', '');
INSERT INTO `t_gamebillinfo` VALUES ('734', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '08bbaf97-22e4-4f0c-984e-0ba0977e363c', '2', '120', '1458546755', '1458546755', '1458546755', '');
INSERT INTO `t_gamebillinfo` VALUES ('735', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'df06fd09-716c-432b-b2c7-983d133e8368', '2', '120', '1458546755', '1458546755', '1458546756', '');
INSERT INTO `t_gamebillinfo` VALUES ('736', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'fd339e0c-13fd-4f2c-91e8-4513331dd9c7', '2', '120', '1458546756', '1458546756', '1458546756', '');
INSERT INTO `t_gamebillinfo` VALUES ('737', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'bb330a04-5891-4b57-95c3-70000027b29c', '2', '120', '1458546757', '1458546757', '1458546757', '');
INSERT INTO `t_gamebillinfo` VALUES ('738', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '22554cfd-8aae-4e09-825f-e028e3516532', '2', '120', '1458546758', '1458546758', '1458546758', '');
INSERT INTO `t_gamebillinfo` VALUES ('739', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '58b142d4-66f2-4b7c-93a8-c0144fac1b39', '2', '120', '1458546758', '1458546758', '1458546758', '');
INSERT INTO `t_gamebillinfo` VALUES ('740', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '12502fdd-785b-4a13-a3ef-269cefe13420', '2', '120', '1458546760', '1458546760', '1458546760', '');
INSERT INTO `t_gamebillinfo` VALUES ('741', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '8ad6bd62-8b7f-4574-9874-ef9526c7087d', '2', '120', '1458546763', '1458546763', '1458546763', '');
INSERT INTO `t_gamebillinfo` VALUES ('742', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2fe7f9d3-8a9f-446e-b154-fc287b6003d0', '2', '120', '1458546763', '1458546764', '1458546764', '');
INSERT INTO `t_gamebillinfo` VALUES ('743', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '310238e4-f733-4ec5-856a-b0be71567418', '2', '120', '1458546764', '1458546764', '1458546764', '');
INSERT INTO `t_gamebillinfo` VALUES ('744', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '9b302f66-ce72-41b5-a80d-941f2e1cbe34', '2', '120', '1458546764', '1458546764', '1458546765', '');
INSERT INTO `t_gamebillinfo` VALUES ('745', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '59f950a0-8b38-4859-af46-c23989139cd4', '2', '120', '1458546765', '1458546765', '1458546765', '');
INSERT INTO `t_gamebillinfo` VALUES ('746', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '565f0b00-c20d-4496-ac63-be0c0ac7f328', '2', '120', '1458546765', '1458546765', '1458546765', '');
INSERT INTO `t_gamebillinfo` VALUES ('747', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '357e32eb-4613-48c5-a955-14ce0238c3a7', '2', '120', '1458546766', '1458546766', '1458546766', '');
INSERT INTO `t_gamebillinfo` VALUES ('748', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2aa9e9f4-3823-464c-816d-0e320e574dc3', '2', '120', '1458546766', '1458546766', '1458546766', '');
INSERT INTO `t_gamebillinfo` VALUES ('749', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '9f81411f-c6b7-4cdd-ae82-3588bab9b5ce', '2', '120', '1458546766', '1458546766', '1458546766', '');
INSERT INTO `t_gamebillinfo` VALUES ('750', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '11d74f4d-f982-449e-a76f-6b97f742f972', '2', '120', '1458546766', '1458546767', '1458546767', '');
INSERT INTO `t_gamebillinfo` VALUES ('751', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2dd87cc9-055e-48dd-9e59-68da7a34b826', '2', '120', '1458546767', '1458546767', '1458546767', '');
INSERT INTO `t_gamebillinfo` VALUES ('752', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'fadb18bf-ddce-4f2a-a454-90e6808fd516', '2', '120', '1458546767', '1458546767', '1458546767', '');
INSERT INTO `t_gamebillinfo` VALUES ('753', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '5e9ae5c3-7d1f-44bf-ac09-f712f40fd553', '2', '120', '1458546767', '1458546767', '1458546768', '');
INSERT INTO `t_gamebillinfo` VALUES ('754', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '706a9bab-a36e-4ead-b589-88e95222d55c', '2', '120', '1458546768', '1458546768', '1458546768', '');
INSERT INTO `t_gamebillinfo` VALUES ('755', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '5aed27d3-6a5a-495c-a82a-a4d0d21f5ebc', '2', '120', '1458546768', '1458546768', '1458546768', '');
INSERT INTO `t_gamebillinfo` VALUES ('756', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ce2d45da-39c2-4faf-91ee-6db4ec94c29e', '2', '120', '1458546768', '1458546769', '1458546769', '');
INSERT INTO `t_gamebillinfo` VALUES ('757', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '90b7b33c-a6a3-48e4-9b20-f7a653b937ac', '2', '120', '1458546769', '1458546769', '1458546769', '');
INSERT INTO `t_gamebillinfo` VALUES ('758', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e30cc4b9-4c6a-4d9c-b8e7-62f1ba000ce7', '2', '120', '1458546769', '1458546770', '1458546770', '');
INSERT INTO `t_gamebillinfo` VALUES ('759', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e6c1e1f4-9d72-4756-86d3-b674d492ac65', '2', '120', '1458546770', '1458546770', '1458546771', '');
INSERT INTO `t_gamebillinfo` VALUES ('760', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '034ae2b4-8aae-4233-8ee7-1517019e79cd', '2', '120', '1458546772', '1458546773', '1458546773', '');
INSERT INTO `t_gamebillinfo` VALUES ('761', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '551de5f0-f07f-4c63-84a3-6885206b9306', '2', '120', '1458546774', '1458546775', '1458546775', '');
INSERT INTO `t_gamebillinfo` VALUES ('762', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e7adebef-aab9-4382-b1a2-f5eaf7767358', '2', '120', '1458546776', '1458546776', '1458546777', '');
INSERT INTO `t_gamebillinfo` VALUES ('763', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'bd9a4553-91b7-4b05-af2e-672a71266013', '2', '120', '1458546777', '1458546777', '1458546777', '');
INSERT INTO `t_gamebillinfo` VALUES ('764', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '87fa015c-7c63-4193-93ff-83c61accd4db', '2', '120', '1458546777', '1458546777', '1458546777', '');
INSERT INTO `t_gamebillinfo` VALUES ('765', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'd8a47e7f-4c6c-43cd-8e7c-2e16ec313014', '2', '120', '1458546777', '1458546777', '1458546777', '');
INSERT INTO `t_gamebillinfo` VALUES ('766', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'cbc36adc-25e7-4450-b98c-0dd210f869d7', '2', '120', '1458546777', '1458546777', '1458546778', '');
INSERT INTO `t_gamebillinfo` VALUES ('767', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '206988bc-63b8-40c9-bf38-750a8c4ad9f4', '2', '120', '1458546778', '1458546778', '1458546778', '');
INSERT INTO `t_gamebillinfo` VALUES ('768', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'cfd71ed8-e603-47c6-861a-d089190dacb7', '2', '120', '1458546778', '1458546778', '1458546778', '');
INSERT INTO `t_gamebillinfo` VALUES ('769', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '250cd598-ee15-457b-a1b5-1aa0ec6bd78c', '2', '120', '1458546778', '1458546778', '1458546778', '');
INSERT INTO `t_gamebillinfo` VALUES ('770', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '16f28d31-8da6-4fc2-a60a-618a160dbf79', '2', '120', '1458546779', '1458546779', '1458546779', '');
INSERT INTO `t_gamebillinfo` VALUES ('771', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '3b39d55d-2334-4814-b86c-291b965a6305', '2', '120', '1458546779', '1458546779', '1458546779', '');
INSERT INTO `t_gamebillinfo` VALUES ('772', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'd3274f12-d70c-499c-a6b9-a1fc2645bba8', '2', '120', '1458546779', '1458546779', '1458546779', '');
INSERT INTO `t_gamebillinfo` VALUES ('773', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '90d30ff3-b5df-4db8-9794-78836f3952fe', '2', '120', '1458546780', '1458546780', '1458546780', '');
INSERT INTO `t_gamebillinfo` VALUES ('774', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '48f0187f-da4b-40c6-abce-2d203b2a5968', '2', '120', '1458546780', '1458546781', '1458546781', '');
INSERT INTO `t_gamebillinfo` VALUES ('775', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'fdbf61fd-066a-483e-9de5-22cbfc9d6062', '2', '120', '1458546781', '1458546782', '1458546782', '');
INSERT INTO `t_gamebillinfo` VALUES ('776', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '97e53cab-dc00-46c8-9bf2-47892109ef04', '2', '120', '1458546782', '1458546783', '1458546783', '');
INSERT INTO `t_gamebillinfo` VALUES ('777', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '0eaba902-4ffc-408f-a25e-e718c00e0205', '2', '120', '1458546783', '1458546783', '1458546784', '');
INSERT INTO `t_gamebillinfo` VALUES ('778', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6a894f07-2076-4a5c-a5e7-9a96d259370b', '2', '120', '1458546784', '1458546785', '1458546785', '');
INSERT INTO `t_gamebillinfo` VALUES ('779', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2921d2a0-4854-4561-84ce-a93f3b9ebf11', '2', '120', '1458546786', '1458546786', '1458546786', '');
INSERT INTO `t_gamebillinfo` VALUES ('780', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '7194d321-1930-4d8a-9bb7-6df5a0f32e64', '2', '120', '1458546786', '1458546786', '1458546786', '');
INSERT INTO `t_gamebillinfo` VALUES ('781', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '32a0f275-ccfe-453c-9e88-d445ffdf7bd5', '2', '120', '1458546786', '1458546787', '1458546787', '');
INSERT INTO `t_gamebillinfo` VALUES ('782', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'dbd6816a-8169-4bb1-b53a-6a9e498daf76', '2', '120', '1458546789', '1458546789', '1458546789', '');
INSERT INTO `t_gamebillinfo` VALUES ('783', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b776d85f-dd07-4e4e-8231-27d6dd76b565', '2', '120', '1458546789', '1458546789', '1458546789', '');
INSERT INTO `t_gamebillinfo` VALUES ('784', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2c102c95-ab6d-444e-b8c7-1e56f60b4577', '2', '120', '1458546789', '1458546789', '1458546790', '');
INSERT INTO `t_gamebillinfo` VALUES ('785', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '8adfe6ff-4acd-45a0-9ce7-1a6a5ceac8b9', '2', '120', '1458546790', '1458546790', '1458546790', '');
INSERT INTO `t_gamebillinfo` VALUES ('786', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '10b1686c-0cdb-44e4-9d48-489078d5ce5e', '2', '120', '1458546790', '1458546790', '1458546790', '');
INSERT INTO `t_gamebillinfo` VALUES ('787', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '3cf577c2-7c12-415d-8a35-0dc2d7fcc206', '2', '120', '1458546790', '1458546790', '1458546790', '');
INSERT INTO `t_gamebillinfo` VALUES ('788', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6a1e955e-c166-45b9-8cef-56eb06972cc5', '2', '120', '1458546790', '1458546791', '1458546791', '');
INSERT INTO `t_gamebillinfo` VALUES ('789', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '890a9d32-3739-4983-9905-1aabf97ebb63', '2', '120', '1458546791', '1458546791', '1458546791', '');
INSERT INTO `t_gamebillinfo` VALUES ('790', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'eaa58095-0642-4ef5-bcef-b776e169d2ea', '2', '120', '1458546791', '1458546791', '1458546791', '');
INSERT INTO `t_gamebillinfo` VALUES ('791', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2fcf5f96-6ef8-4650-8731-094c18e3f1c0', '2', '120', '1458546791', '1458546791', '1458546792', '');
INSERT INTO `t_gamebillinfo` VALUES ('792', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'fd92ca2f-fd57-48fa-9962-5ae342dcf43c', '2', '120', '1458546792', '1458546792', '1458546792', '');
INSERT INTO `t_gamebillinfo` VALUES ('793', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'df96a109-a02b-4f45-b476-6ffc1d87b9b4', '2', '120', '1458546792', '1458546792', '1458546793', '');
INSERT INTO `t_gamebillinfo` VALUES ('794', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'a846a6aa-b94d-4c0d-8477-beb1cac5b3b7', '2', '120', '1458546793', '1458546793', '1458546793', '');
INSERT INTO `t_gamebillinfo` VALUES ('795', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'f655b64f-2f97-4b6a-b73d-b9631edc1fd0', '2', '120', '1458546794', '1458546795', '1458546795', '');
INSERT INTO `t_gamebillinfo` VALUES ('796', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '8ccefe6f-0b81-491f-9775-55928979cb0f', '2', '120', '1458546795', '1458546795', '1458546795', '');
INSERT INTO `t_gamebillinfo` VALUES ('797', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '95da3db4-4a7c-4919-87c7-ec319b2c34c2', '2', '120', '1458546795', '1458546795', '1458546795', '');
INSERT INTO `t_gamebillinfo` VALUES ('798', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ab8c33bf-6ac8-4b05-a60b-4fed375ca582', '2', '120', '1458546796', '1458546796', '1458546796', '');
INSERT INTO `t_gamebillinfo` VALUES ('799', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c2ff488f-35e1-4493-96a0-786347baaa94', '2', '120', '1458546796', '1458546796', '1458546796', '');
INSERT INTO `t_gamebillinfo` VALUES ('800', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '7b8d3a88-affe-4674-9119-69355d354a31', '2', '120', '1458546797', '1458546797', '1458546797', '');
INSERT INTO `t_gamebillinfo` VALUES ('801', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '644c8168-d017-41b5-9a04-46980c22d19e', '2', '120', '1458546798', '1458546798', '1458546798', '');
INSERT INTO `t_gamebillinfo` VALUES ('802', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '23fe983a-2390-4af3-83c2-be56b7b4024c', '2', '120', '1458546799', '1458546799', '1458546799', '');
INSERT INTO `t_gamebillinfo` VALUES ('803', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'dfaebe12-f440-475f-abef-b30934722498', '2', '120', '1458546799', '1458546800', '1458546800', '');
INSERT INTO `t_gamebillinfo` VALUES ('804', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'd31dcfee-7a74-4007-b07d-afabe7c17b71', '2', '120', '1458546800', '1458546800', '1458546800', '');
INSERT INTO `t_gamebillinfo` VALUES ('805', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '53f12e44-ee23-4c60-8e04-a8741baad19f', '2', '120', '1458546800', '1458546801', '1458546801', '');
INSERT INTO `t_gamebillinfo` VALUES ('806', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '29bbf5c4-76a6-4452-8a97-19ee460fabe5', '2', '120', '1458546802', '1458546802', '1458546802', '');
INSERT INTO `t_gamebillinfo` VALUES ('807', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'fa37c2df-ba16-468c-a94f-fd65e1533fd0', '2', '120', '1458546803', '1458546804', '1458546804', '');
INSERT INTO `t_gamebillinfo` VALUES ('808', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6e3be55e-f8c0-4352-9ecb-c3f4d5a06998', '2', '120', '1458546804', '1458546804', '1458546804', '');
INSERT INTO `t_gamebillinfo` VALUES ('809', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '0b784d29-8e5b-41ee-a53b-27b59a38bc00', '2', '120', '1458546804', '1458546805', '1458546805', '');
INSERT INTO `t_gamebillinfo` VALUES ('810', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'da99a134-4d51-4221-9e5b-6370e7cca08a', '2', '120', '1458546805', '1458546805', '1458546805', '');
INSERT INTO `t_gamebillinfo` VALUES ('811', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b80dd929-c243-4649-816b-edb0d8ae69a0', '2', '120', '1458546805', '1458546805', '1458546806', '');
INSERT INTO `t_gamebillinfo` VALUES ('812', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'be1e9d7f-097d-436f-acf2-d4cf678b3534', '2', '120', '1458546806', '1458546806', '1458546806', '');
INSERT INTO `t_gamebillinfo` VALUES ('813', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ab0e18ef-068c-4a11-88a0-544b5c877f9a', '2', '120', '1458546806', '1458546806', '1458546807', '');
INSERT INTO `t_gamebillinfo` VALUES ('814', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '75828fab-51d5-4a78-9151-4dcd7732cffa', '2', '120', '1458546807', '1458546807', '1458546807', '');
INSERT INTO `t_gamebillinfo` VALUES ('815', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '5b32f23b-032f-421d-be1d-d0e9d27facb2', '2', '120', '1458546808', '1458546808', '1458546808', '');
INSERT INTO `t_gamebillinfo` VALUES ('816', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c4d55c39-7d9c-426c-930a-b339bdec9f64', '2', '120', '1458546808', '1458546808', '1458546808', '');
INSERT INTO `t_gamebillinfo` VALUES ('817', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '13e49e04-4b8c-4c70-8418-154a50d10a31', '2', '120', '1458546809', '1458546809', '1458546809', '');
INSERT INTO `t_gamebillinfo` VALUES ('818', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '51ea5a43-5a25-4c1b-858a-acdb8532437d', '2', '120', '1458546810', '1458546810', '1458546810', '');
INSERT INTO `t_gamebillinfo` VALUES ('819', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e0823bf5-d954-4f9a-b9bd-ef58fb47ce1b', '2', '120', '1458546811', '1458546811', '1458546811', '');
INSERT INTO `t_gamebillinfo` VALUES ('820', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '3c4bc577-3a2c-4930-9df2-d23605274d3d', '2', '120', '1458546811', '1458546812', '1458546812', '');
INSERT INTO `t_gamebillinfo` VALUES ('821', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '58a9a90d-54c9-4e31-a835-75ff58ccb7a1', '2', '120', '1458546812', '1458546812', '1458546812', '');
INSERT INTO `t_gamebillinfo` VALUES ('822', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '4801c98a-a3c7-4266-b7f0-a05037ef1ca5', '2', '120', '1458546812', '1458546812', '1458546812', '');
INSERT INTO `t_gamebillinfo` VALUES ('823', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '422af4c1-0a33-41df-bbd3-430b0bbc418c', '2', '120', '1458546812', '1458546812', '1458546812', '');
INSERT INTO `t_gamebillinfo` VALUES ('824', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '75150cb5-d6ef-4291-9b6d-80be402498d6', '2', '120', '1458546812', '1458546812', '1458546813', '');
INSERT INTO `t_gamebillinfo` VALUES ('825', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '3f74d154-be5e-4691-a07e-d3cb1d7fa566', '2', '120', '1458546812', '1458546813', '1458546813', '');
INSERT INTO `t_gamebillinfo` VALUES ('826', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '98d415e5-56d9-406a-803d-ee1f98d998a3', '2', '120', '1458546813', '1458546813', '1458546813', '');
INSERT INTO `t_gamebillinfo` VALUES ('827', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'd3256984-866d-4b96-8914-520d37e65f42', '2', '120', '1458546813', '1458546813', '1458546813', '');
INSERT INTO `t_gamebillinfo` VALUES ('828', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '63459066-b818-496b-881e-2e94e6ec9102', '2', '120', '1458546813', '1458546814', '1458546814', '');
INSERT INTO `t_gamebillinfo` VALUES ('829', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '21503c7e-6c56-4cea-b0df-8ab1716edf14', '2', '120', '1458546814', '1458546814', '1458546814', '');
INSERT INTO `t_gamebillinfo` VALUES ('830', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '4d033be6-ebe2-40b4-99e6-106e803b6a89', '2', '120', '1458546814', '1458546815', '1458546815', '');
INSERT INTO `t_gamebillinfo` VALUES ('831', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '29e7de70-c097-42a3-9ee3-5262012a7761', '2', '120', '1458546815', '1458546815', '1458546815', '');
INSERT INTO `t_gamebillinfo` VALUES ('832', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'd57d0998-3ce8-4c02-ace5-2f2926af0003', '2', '120', '1458546815', '1458546815', '1458546815', '');
INSERT INTO `t_gamebillinfo` VALUES ('833', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'db1e5bd2-6253-4c43-a5f9-e2812c8bc1f1', '2', '120', '1458546815', '1458546815', '1458546816', '');
INSERT INTO `t_gamebillinfo` VALUES ('834', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'f758aa1f-10f6-4181-8eb7-1329f8462324', '2', '120', '1458546816', '1458546816', '1458546816', '');
INSERT INTO `t_gamebillinfo` VALUES ('835', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'f2bf3ff5-bb64-49dc-9f5b-5b9d6347ec89', '2', '120', '1458546816', '1458546816', '1458546816', '');
INSERT INTO `t_gamebillinfo` VALUES ('836', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b5206ba9-2827-4fa2-9042-90029992aefe', '2', '120', '1458546824', '1458546825', '1458546825', '');
INSERT INTO `t_gamebillinfo` VALUES ('837', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '82a734da-835c-45da-9382-291e3e9c5b3f', '2', '120', '1458546825', '1458546825', '1458546825', '');
INSERT INTO `t_gamebillinfo` VALUES ('838', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '15aa20e0-15a7-4db8-9b1c-ce100f409450', '2', '120', '1458546829', '1458546829', '1458546829', '');
INSERT INTO `t_gamebillinfo` VALUES ('839', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'f1e7a657-1270-4cc7-85a2-0a6a3a7fa907', '2', '120', '1458546829', '1458546830', '1458546830', '');
INSERT INTO `t_gamebillinfo` VALUES ('840', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '418705fe-9625-44d1-bbba-d1ebf119fd9b', '2', '120', '1458546830', '1458546830', '1458546830', '');
INSERT INTO `t_gamebillinfo` VALUES ('841', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '55eab12c-f91e-442c-b642-48064fc7198b', '2', '120', '1458546831', '1458546831', '1458546831', '');
INSERT INTO `t_gamebillinfo` VALUES ('842', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '475d0de2-809f-4a81-9205-d041d1381b67', '2', '120', '1458546834', '1458546834', '1458546835', '');
INSERT INTO `t_gamebillinfo` VALUES ('843', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '94778b30-94f2-41a3-914a-a70dabc9cef4', '2', '120', '1458546835', '1458546835', '1458546835', '');
INSERT INTO `t_gamebillinfo` VALUES ('844', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2e9045eb-10f1-4707-87ab-cad8eb2055db', '2', '120', '1458546835', '1458546836', '1458546836', '');
INSERT INTO `t_gamebillinfo` VALUES ('845', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '84f344ee-1213-4b01-91bc-e6c98b58d7e9', '2', '120', '1458546836', '1458546837', '1458546837', '');
INSERT INTO `t_gamebillinfo` VALUES ('846', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '3e92a3ef-10c1-4d40-a211-17261caa62be', '2', '120', '1458546837', '1458546837', '1458546837', '');
INSERT INTO `t_gamebillinfo` VALUES ('847', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '15c6667e-a331-4c47-98f3-7de7031aceff', '2', '120', '1458546837', '1458546838', '1458546838', '');
INSERT INTO `t_gamebillinfo` VALUES ('848', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'f1e943b1-1340-4edc-a1e6-0000ce5a63e5', '2', '120', '1458546837', '1458546838', '1458546838', '');
INSERT INTO `t_gamebillinfo` VALUES ('849', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '0ae15a44-ce66-41c3-9e48-48ae214162f5', '2', '120', '1458546838', '1458546838', '1458546838', '');
INSERT INTO `t_gamebillinfo` VALUES ('850', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ae5872fa-5e6a-4aae-9e4a-d7640c4ca08b', '2', '120', '1458546838', '1458546838', '1458546838', '');
INSERT INTO `t_gamebillinfo` VALUES ('851', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '7d0695d0-010d-4287-8cbb-d23e420a78f2', '2', '120', '1458546839', '1458546839', '1458546839', '');
INSERT INTO `t_gamebillinfo` VALUES ('852', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6623d651-2a70-477c-8341-9ae573b78bf5', '2', '120', '1458546839', '1458546839', '1458546839', '');
INSERT INTO `t_gamebillinfo` VALUES ('853', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '9b435376-eef7-4f18-a64b-97e356a44126', '2', '120', '1458546839', '1458546839', '1458546839', '');
INSERT INTO `t_gamebillinfo` VALUES ('854', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'f87026f1-c532-48e0-96eb-9e350c00a1ba', '2', '120', '1458546839', '1458546839', '1458546840', '');
INSERT INTO `t_gamebillinfo` VALUES ('855', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '23e2e5a8-34d3-4a43-abf1-40133f48f97a', '2', '120', '1458546839', '1458546840', '1458546840', '');
INSERT INTO `t_gamebillinfo` VALUES ('856', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'a0be601a-6819-454d-a0dd-1c53acd03378', '2', '120', '1458546840', '1458546840', '1458546840', '');
INSERT INTO `t_gamebillinfo` VALUES ('857', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '90658400-cad6-43ab-983c-b433802e41c4', '2', '120', '1458546840', '1458546840', '1458546840', '');
INSERT INTO `t_gamebillinfo` VALUES ('858', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ab1a8982-ebc0-4573-9154-87422fecb23c', '2', '120', '1458546841', '1458546841', '1458546841', '');
INSERT INTO `t_gamebillinfo` VALUES ('859', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2ab26279-44f1-4da9-a45b-df725411e7cb', '2', '120', '1458546841', '1458546841', '1458546841', '');
INSERT INTO `t_gamebillinfo` VALUES ('860', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'a68e623b-c242-4fae-89da-021ae3b92e28', '2', '120', '1458546841', '1458546841', '1458546842', '');
INSERT INTO `t_gamebillinfo` VALUES ('861', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'd7ef4db6-4add-41b5-9b3a-548262f6f713', '2', '120', '1458546841', '1458546842', '1458546842', '');
INSERT INTO `t_gamebillinfo` VALUES ('862', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ea4b063a-035a-4d37-a1eb-a990f684e374', '2', '120', '1458546842', '1458546842', '1458546842', '');
INSERT INTO `t_gamebillinfo` VALUES ('863', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'bfab1b76-d777-4b5b-9f66-3f82b2eef429', '2', '120', '1458546842', '1458546842', '1458546842', '');
INSERT INTO `t_gamebillinfo` VALUES ('864', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '62d2d8e4-bbf1-4e0d-acee-09514edcd86b', '2', '120', '1458546843', '1458546843', '1458546843', '');
INSERT INTO `t_gamebillinfo` VALUES ('865', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '1f16f77a-b4d0-40d6-9cb7-3f35ec840695', '2', '120', '1458546843', '1458546843', '1458546843', '');
INSERT INTO `t_gamebillinfo` VALUES ('866', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'd0af461a-2c8c-423b-b8df-5f74bb10cf1e', '2', '120', '1458546843', '1458546843', '1458546843', '');
INSERT INTO `t_gamebillinfo` VALUES ('867', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '83b8c78a-2e6c-4d56-a063-701d9ff69e4d', '2', '120', '1458546843', '1458546844', '1458546844', '');
INSERT INTO `t_gamebillinfo` VALUES ('868', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c7914b5e-88f2-4c7f-88fd-5a28be7a7229', '2', '120', '1458546844', '1458546844', '1458546844', '');
INSERT INTO `t_gamebillinfo` VALUES ('869', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '5a8e16ac-c601-4af0-912b-54706e8bbf74', '2', '120', '1458546844', '1458546844', '1458546844', '');
INSERT INTO `t_gamebillinfo` VALUES ('870', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2e6aad40-506b-490c-8629-123724e59c25', '2', '120', '1458546844', '1458546844', '1458546845', '');
INSERT INTO `t_gamebillinfo` VALUES ('871', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b210995e-7302-403d-b5e2-cd415210ec6f', '2', '120', '1458546847', '1458546848', '1458546848', '');
INSERT INTO `t_gamebillinfo` VALUES ('872', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b42fb59d-2cee-4f2a-9416-0a1e275cb411', '2', '120', '1458546848', '1458546848', '1458546848', '');
INSERT INTO `t_gamebillinfo` VALUES ('873', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '64f4280b-310d-48e4-ad6a-86ced5c6104d', '2', '120', '1458546848', '1458546849', '1458546849', '');
INSERT INTO `t_gamebillinfo` VALUES ('874', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b7105e77-f917-44ac-b9be-7cb0889890f2', '2', '120', '1458546849', '1458546849', '1458546849', '');
INSERT INTO `t_gamebillinfo` VALUES ('875', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '83e9a3eb-82d2-4dca-bd11-ba5d73ff3f54', '2', '120', '1458546849', '1458546849', '1458546849', '');
INSERT INTO `t_gamebillinfo` VALUES ('876', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '74233d05-70c3-422a-ad7a-8111326a4c8b', '2', '120', '1458546849', '1458546849', '1458546850', '');
INSERT INTO `t_gamebillinfo` VALUES ('877', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'd16d8b98-a076-4848-ae5f-ac8abe4983a0', '2', '120', '1458546850', '1458546850', '1458546850', '');
INSERT INTO `t_gamebillinfo` VALUES ('878', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2010a01f-81c3-464c-9cce-bd9288cd3180', '2', '120', '1458546850', '1458546850', '1458546850', '');
INSERT INTO `t_gamebillinfo` VALUES ('879', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '66d2917f-c8e8-45bf-b579-6101837ea7c7', '2', '120', '1458546850', '1458546851', '1458546851', '');
INSERT INTO `t_gamebillinfo` VALUES ('880', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '38cf8cc8-f477-4470-9f84-2585f45de37d', '2', '120', '1458546851', '1458546851', '1458546851', '');
INSERT INTO `t_gamebillinfo` VALUES ('881', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'faa30660-1b87-4711-bbb9-218d69d1ab1a', '2', '120', '1458546851', '1458546851', '1458546852', '');
INSERT INTO `t_gamebillinfo` VALUES ('882', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '06f2b27e-048d-4405-812e-c115cf75d115', '2', '120', '1458546851', '1458546852', '1458546852', '');
INSERT INTO `t_gamebillinfo` VALUES ('883', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '77cee660-4409-4c49-9f49-8feaa413f028', '2', '120', '1458546852', '1458546852', '1458546852', '');
INSERT INTO `t_gamebillinfo` VALUES ('884', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '337ad8f7-c8bc-45b6-bf46-f425f49e0326', '2', '120', '1458546854', '1458546854', '1458546855', '');
INSERT INTO `t_gamebillinfo` VALUES ('885', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '3894839d-7443-42c2-84b1-3f08c316b1ff', '2', '120', '1458546855', '1458546855', '1458546855', '');
INSERT INTO `t_gamebillinfo` VALUES ('886', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '57cd5894-1bb7-44a6-8db7-ff320b3db24f', '2', '120', '1458546855', '1458546855', '1458546856', '');
INSERT INTO `t_gamebillinfo` VALUES ('887', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b6df31f0-d47b-4a5d-b37b-84f63abdbc81', '2', '120', '1458546856', '1458546856', '1458546856', '');
INSERT INTO `t_gamebillinfo` VALUES ('888', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ee1329b9-a316-438a-9d3d-e84e3bfc600d', '2', '120', '1458546857', '1458546857', '1458546857', '');
INSERT INTO `t_gamebillinfo` VALUES ('889', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b42a44a0-2837-45a7-8cad-67f069eecf73', '2', '120', '1458546858', '1458546858', '1458546859', '');
INSERT INTO `t_gamebillinfo` VALUES ('890', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6984deb7-51f1-4c02-81e3-2890b54da784', '2', '120', '1458546859', '1458546859', '1458546859', '');
INSERT INTO `t_gamebillinfo` VALUES ('891', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c62df828-5bf9-42de-a1db-c73679aca1be', '2', '120', '1458546859', '1458546859', '1458546859', '');
INSERT INTO `t_gamebillinfo` VALUES ('892', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '038bbe47-dd7c-484a-8ec2-76ee56006f47', '2', '120', '1458546859', '1458546859', '1458546860', '');
INSERT INTO `t_gamebillinfo` VALUES ('893', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'def61a8c-73c1-4bd5-80e7-c64b72fe65a5', '2', '120', '1458546859', '1458546859', '1458546860', '');
INSERT INTO `t_gamebillinfo` VALUES ('894', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'f45d8518-b937-4121-a547-759f5b616160', '2', '120', '1458546865', '1458546865', '1458546865', '');
INSERT INTO `t_gamebillinfo` VALUES ('895', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '4ad6ca52-28b2-4688-8c31-0fcf04042bbd', '2', '120', '1458546866', '1458546866', '1458546866', '');
INSERT INTO `t_gamebillinfo` VALUES ('896', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ecb15bb6-74b8-46ca-95c6-4934a3de5ae6', '2', '120', '1458546866', '1458546866', '1458546867', '');
INSERT INTO `t_gamebillinfo` VALUES ('897', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '56623ac2-76fe-4b46-af78-5a2a81e6c08d', '2', '120', '1458546866', '1458546867', '1458546867', '');
INSERT INTO `t_gamebillinfo` VALUES ('898', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '678f93b3-f44b-4ff1-aab1-ea529b2e765a', '2', '120', '1458546883', '1458546883', '1458546883', '');
INSERT INTO `t_gamebillinfo` VALUES ('899', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '4011b79b-f2a7-46db-9e61-10f87b640b59', '2', '120', '1458546883', '1458546883', '1458546883', '');
INSERT INTO `t_gamebillinfo` VALUES ('900', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'bbb7ba93-86c8-480e-92e5-9406aeac56d8', '2', '120', '1458546883', '1458546883', '1458546883', '');
INSERT INTO `t_gamebillinfo` VALUES ('901', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '9c5a53e7-3e46-4f26-bad2-07204060b90a', '2', '120', '1458546883', '1458546884', '1458546884', '');
INSERT INTO `t_gamebillinfo` VALUES ('902', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '0b9dd298-48ee-4bfe-bac3-abdf14f0bf36', '2', '120', '1458546884', '1458546884', '1458546884', '');
INSERT INTO `t_gamebillinfo` VALUES ('903', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '15363cf8-89c8-4e3b-81c7-47df35fe4349', '2', '120', '1458546884', '1458546884', '1458546884', '');
INSERT INTO `t_gamebillinfo` VALUES ('904', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '3da7cf8b-a958-45c3-9857-6328b9a9536d', '2', '120', '1458546884', '1458546884', '1458546884', '');
INSERT INTO `t_gamebillinfo` VALUES ('905', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b45e2b19-cb47-4d7d-89b8-06acc12e6175', '2', '120', '1458546884', '1458546885', '1458546885', '');
INSERT INTO `t_gamebillinfo` VALUES ('906', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ef4e118f-da64-4fe9-be0e-5e6977a48612', '2', '120', '1458546885', '1458546885', '1458546885', '');
INSERT INTO `t_gamebillinfo` VALUES ('907', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c35466eb-d535-4f6c-9208-f340ed898f8f', '2', '120', '1458546885', '1458546885', '1458546885', '');
INSERT INTO `t_gamebillinfo` VALUES ('908', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '5e82d825-ce64-4930-b04f-63cdfb6a8f90', '2', '120', '1458546885', '1458546885', '1458546885', '');
INSERT INTO `t_gamebillinfo` VALUES ('909', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '4558e3a8-16c0-4b9c-a097-eb62bd1d37b5', '2', '120', '1458546885', '1458546886', '1458546886', '');
INSERT INTO `t_gamebillinfo` VALUES ('910', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'baa5cd68-b7a4-494f-a520-1debf55f5168', '2', '120', '1458546886', '1458546886', '1458546886', '');
INSERT INTO `t_gamebillinfo` VALUES ('911', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'b14ff560-1fb0-462a-8d8c-c378297e189f', '2', '120', '1458546886', '1458546887', '1458546887', '');
INSERT INTO `t_gamebillinfo` VALUES ('912', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2403c041-235e-4e19-9b64-bb61366ed8b1', '2', '120', '1458546887', '1458546887', '1458546887', '');
INSERT INTO `t_gamebillinfo` VALUES ('913', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'd2fa31e5-2740-4aed-8c86-40825b7a4e65', '2', '120', '1458546887', '1458546887', '1458546887', '');
INSERT INTO `t_gamebillinfo` VALUES ('914', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '26ff90c0-d52a-4263-a4b2-3749ad9bd757', '2', '120', '1458546887', '1458546888', '1458546888', '');
INSERT INTO `t_gamebillinfo` VALUES ('915', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'a0ee2698-351f-424d-80f6-b083926c8ac3', '2', '120', '1458546888', '1458546888', '1458546888', '');
INSERT INTO `t_gamebillinfo` VALUES ('916', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '7561bd6d-933a-4c1f-8aa2-4b296e929c7c', '2', '120', '1458546888', '1458546888', '1458546889', '');
INSERT INTO `t_gamebillinfo` VALUES ('917', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '70098c8d-fcae-4516-8692-0823c1cf6f17', '2', '120', '1458546888', '1458546889', '1458546889', '');
INSERT INTO `t_gamebillinfo` VALUES ('918', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c686bb9e-014c-4f49-a076-601fb1b6594b', '2', '120', '1458546889', '1458546889', '1458546890', '');
INSERT INTO `t_gamebillinfo` VALUES ('919', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ce6d260f-7266-477d-8fb9-ab8d369948d3', '2', '120', '1458546889', '1458546890', '1458546890', '');
INSERT INTO `t_gamebillinfo` VALUES ('920', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6e38aae5-0400-450d-bb53-c88072cfa92a', '2', '120', '1458546890', '1458546890', '1458546890', '');
INSERT INTO `t_gamebillinfo` VALUES ('921', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'eeb349df-498b-4939-8501-aff54f6b67f2', '2', '120', '1458546890', '1458546890', '1458546890', '');
INSERT INTO `t_gamebillinfo` VALUES ('922', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '3985e185-d07a-4f2a-85fc-fea4110f0f5b', '2', '120', '1458546890', '1458546891', '1458546891', '');
INSERT INTO `t_gamebillinfo` VALUES ('923', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'a87b351a-3552-44e4-b011-2abb472b08a2', '2', '120', '1458546891', '1458546891', '1458546891', '');
INSERT INTO `t_gamebillinfo` VALUES ('924', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6ffb538b-07ec-4a81-a574-cbc2a5426e77', '2', '120', '1458546891', '1458546891', '1458546891', '');
INSERT INTO `t_gamebillinfo` VALUES ('925', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6f45d816-1551-4e6e-820d-43795f5b7a44', '2', '120', '1458546892', '1458546893', '1458546893', '');
INSERT INTO `t_gamebillinfo` VALUES ('926', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'ff3c8757-e0cd-4518-98b1-0ab94fbb39da', '2', '120', '1458546893', '1458546893', '1458546893', '');
INSERT INTO `t_gamebillinfo` VALUES ('927', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '037262fd-08fb-46e4-a45d-39330d69220a', '2', '120', '1458546893', '1458546894', '1458546894', '');
INSERT INTO `t_gamebillinfo` VALUES ('928', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '18eb3ae0-bf31-4b00-a2d6-1cbeaebfd97a', '2', '120', '1458546894', '1458546894', '1458546894', '');
INSERT INTO `t_gamebillinfo` VALUES ('929', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'cef1c586-b35b-4b9f-8db1-515acc816389', '2', '120', '1458546894', '1458546894', '1458546894', '');
INSERT INTO `t_gamebillinfo` VALUES ('930', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'cf0e9d7f-bb60-4c37-9f7e-5c04aae78746', '2', '120', '1458546906', '1458546906', '1458546906', '');
INSERT INTO `t_gamebillinfo` VALUES ('931', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'eeabf1c1-5031-462d-9c02-b9dfef9ac3d6', '2', '120', '1458546906', '1458546906', '1458546907', '');
INSERT INTO `t_gamebillinfo` VALUES ('932', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'd44c8978-b833-4298-a04f-90caea52b4b9', '2', '120', '1458546907', '1458546907', '1458546907', '');
INSERT INTO `t_gamebillinfo` VALUES ('933', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'a9052aca-6293-46c3-bb82-1efc80e3516a', '2', '120', '1458546907', '1458546907', '1458546907', '');
INSERT INTO `t_gamebillinfo` VALUES ('934', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c6a6a631-e596-4db4-b3c6-0a31b9c9fadf', '2', '120', '1458546907', '1458546907', '1458546908', '');
INSERT INTO `t_gamebillinfo` VALUES ('935', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6e550e1c-aa28-4f6f-8ee6-b59cdb0e1650', '2', '120', '1458546907', '1458546908', '1458546908', '');
INSERT INTO `t_gamebillinfo` VALUES ('936', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '010e5925-548f-4708-9b7e-995f733c9c2d', '2', '120', '1458546908', '1458546908', '1458546908', '');
INSERT INTO `t_gamebillinfo` VALUES ('937', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'da4f30c9-8b21-43dc-9be0-b450f75c9327', '2', '120', '1458546908', '1458546908', '1458546908', '');
INSERT INTO `t_gamebillinfo` VALUES ('938', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '56464c99-6bda-41d9-8e1d-b3fc82358c8b', '2', '120', '1458546908', '1458546909', '1458546909', '');
INSERT INTO `t_gamebillinfo` VALUES ('939', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '05d91dc9-225b-4e2e-bc46-8ee11def51e7', '2', '120', '1458546909', '1458546909', '1458546909', '');
INSERT INTO `t_gamebillinfo` VALUES ('940', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '825b5e7f-bcfe-45e6-bca9-d97b2481a6fb', '2', '120', '1458546909', '1458546909', '1458546909', '');
INSERT INTO `t_gamebillinfo` VALUES ('941', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '5ad2bfe2-5120-4941-b37a-cc26fc4d6eaf', '2', '120', '1458546910', '1458546910', '1458546910', '');
INSERT INTO `t_gamebillinfo` VALUES ('942', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '8ce7c04f-7295-40f9-bf56-295a06cb83e1', '2', '120', '1458546910', '1458546910', '1458546910', '');
INSERT INTO `t_gamebillinfo` VALUES ('943', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '2871d503-72cc-4094-b77a-e33cdef5099e', '2', '120', '1458546910', '1458546910', '1458546910', '');
INSERT INTO `t_gamebillinfo` VALUES ('944', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e7fad61b-d809-42ee-b6d7-cfc50084ad52', '2', '120', '1458546911', '1458546911', '1458546911', '');
INSERT INTO `t_gamebillinfo` VALUES ('945', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'f3153844-443b-492e-bed3-bf0d1256271e', '2', '120', '1458546911', '1458546911', '1458546911', '');
INSERT INTO `t_gamebillinfo` VALUES ('946', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c13373e7-1b6b-4012-86dd-b31ef811d8c3', '2', '120', '1458546912', '1458546913', '1458546913', '');
INSERT INTO `t_gamebillinfo` VALUES ('947', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'e2b0085c-9dec-4cc2-b302-b1519689604b', '2', '120', '1458546912', '1458546913', '1458546913', '');
INSERT INTO `t_gamebillinfo` VALUES ('948', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c6aeab14-a467-4a5e-a898-47f9ee40710c', '2', '120', '1458546913', '1458546913', '1458546913', '');
INSERT INTO `t_gamebillinfo` VALUES ('949', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c44373d5-667e-4aa7-af1f-13d471513b33', '2', '120', '1458546913', '1458546913', '1458546913', '');
INSERT INTO `t_gamebillinfo` VALUES ('950', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '41a9484c-fc89-41e6-b2b6-602b6c757507', '2', '120', '1458546913', '1458546914', '1458546914', '');
INSERT INTO `t_gamebillinfo` VALUES ('951', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '7556c9c3-91cf-4ff4-8cf3-9c6b69fb2c1f', '2', '120', '1458546914', '1458546914', '1458546914', '');
INSERT INTO `t_gamebillinfo` VALUES ('952', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '48b28098-7a05-4cd9-848c-567530897391', '2', '120', '1458546914', '1458546914', '1458546914', '');
INSERT INTO `t_gamebillinfo` VALUES ('953', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '6890e41b-e834-4b7c-9715-355288493a22', '2', '120', '1458546914', '1458546915', '1458546915', '');
INSERT INTO `t_gamebillinfo` VALUES ('954', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', '26f51058-75f3-45fb-8412-1d9fc475a1c5', '2', '120', '1458546915', '1458546915', '1458546915', '');
INSERT INTO `t_gamebillinfo` VALUES ('955', '1', 'qz_test_5', '1481', 'sib', 'sib', '10', '6', 'c60ab5cd-4259-4041-9979-a3cf77aee55b', '2', '120', '1458546915', '1458546915', '1458546915', '');
INSERT INTO `t_gamebillinfo` VALUES ('956', '1', 'qz_test_5', '1470', 'vv01', '繁俊哲', '10', '3', '2d1d684b-8c63-4aee-afed-05aa81c713b6', '2', '30', '1458639950', '1458639950', '1458639950', '');
INSERT INTO `t_gamebillinfo` VALUES ('957', '1', 'qz_test_5', '1470', 'vv01', '繁俊哲', '10', '3', 'ef56a166-29ae-4afb-8615-51dec761121a', '2', '30', '1458639950', '1458639951', '1458639951', '');
INSERT INTO `t_gamebillinfo` VALUES ('958', '1', 'qz_test_5', '1470', 'vv01', '繁俊哲', '10', '3', '69830815-b2e2-4c99-992a-50d47d57a00f', '2', '30', '1458639952', '1458639952', '1458639952', '');
INSERT INTO `t_gamebillinfo` VALUES ('959', '1', 'qz_test_5', '1470', 'vv01', '繁俊哲', '10', '3', '863aeb48-a158-4204-84ef-0fba1fa4b2f6', '2', '30', '1458639953', '1458639953', '1458639953', '');
INSERT INTO `t_gamebillinfo` VALUES ('960', '1', 'qz_test_5', '446', 'z2', '运泰初', '54', '1', 'dd16d2b5-7fa7-4c6e-af42-3e900213f913', '2', '6', '1459325457', '1459325457', '1459325459', '');
INSERT INTO `t_gamebillinfo` VALUES ('961', '1', 'qz_test_5', '446', 'z2', '运泰初', '54', '1', '1b6af987-2562-4ed0-9814-fd806b4398a2', '2', '6', '1459325462', '1459325462', '1459325462', '');
INSERT INTO `t_gamebillinfo` VALUES ('962', '1', 'qz_test_5', '446', 'z2', '运泰初', '54', '1', 'ff28cb5f-caec-4094-a1ef-389991145346', '2', '6', '1459325665', '1459325665', '1459325666', '');
INSERT INTO `t_gamebillinfo` VALUES ('963', '1', 'qz_test_5', '446', 'z2', '运泰初', '54', '1', '1de83fcb-dcbc-4883-a850-029f8cfa5bb8', '2', '6', '1459325667', '1459325668', '1459325668', '');
INSERT INTO `t_gamebillinfo` VALUES ('964', '1', 'qz_test_5', '446', 'z2', '运泰初', '54', '1', '1e947398-6f16-4aa3-adfe-abd5789dc695', '2', '6', '1460974932', '1460974932', '1460974933', '');
INSERT INTO `t_gamebillinfo` VALUES ('965', '1', 'qz_test_5', '446', 'z2', '运泰初', '54', '1', 'd8fba441-c74a-4602-8a33-fb0110f26b9f', '2', '6', '1460974934', '1460974935', '1460974935', '');
INSERT INTO `t_gamebillinfo` VALUES ('966', '1', 'qz_test_5', '446', 'z2', '运泰初', '54', '1', '506802d0-5e7c-4cba-bbd7-5d4bcc9e9ced', '2', '6', '1463035847', '1463035848', '1463035849', '');

-- ----------------------------
-- Table structure for t_gamecdkeyinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_gamecdkeyinfo`;
CREATE TABLE `t_gamecdkeyinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_type` int(11) NOT NULL COMMENT '生成类型',
  `n_name` varchar(50) NOT NULL COMMENT '名称',
  `n_code` varchar(50) NOT NULL COMMENT '生成码',
  `n_desc` varchar(255) NOT NULL COMMENT '奖励',
  `n_rewards` varchar(512) NOT NULL COMMENT '奖励',
  `n_cdkey` varchar(50) NOT NULL COMMENT 'cdkey',
  `n_creator` varchar(50) NOT NULL COMMENT '生成者',
  `n_createTime` int(11) NOT NULL COMMENT '生成时间',
  `n_activated` int(11) NOT NULL COMMENT '是否激活',
  `n_totalNum` int(11) NOT NULL COMMENT '可兑换数量',
  `n_convertNum` int(11) NOT NULL COMMENT '已兑换数量',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gamecdkeyinfo
-- ----------------------------

-- ----------------------------
-- Table structure for t_gamecdkeyrecordinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_gamecdkeyrecordinfo`;
CREATE TABLE `t_gamecdkeyrecordinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_cdkeyId` int(11) NOT NULL COMMENT '兑换码id',
  `n_cdkey` varchar(50) NOT NULL COMMENT '兑换码',
  `n_serverId` varchar(50) NOT NULL COMMENT '兑换区服id',
  `n_partner` int(11) NOT NULL COMMENT '所在渠道',
  `n_openid` varchar(50) NOT NULL COMMENT '兑换者帐号',
  `n_nickname` varchar(50) NOT NULL COMMENT '兑换者名称',
  `n_convertTime` int(11) NOT NULL COMMENT '兑换时间',
  PRIMARY KEY (`n_id`),
  KEY `n_convert` (`n_cdkey`,`n_serverId`,`n_partner`,`n_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gamecdkeyrecordinfo
-- ----------------------------

-- ----------------------------
-- Table structure for t_gamedailyrechargeinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_gamedailyrechargeinfo`;
CREATE TABLE `t_gamedailyrechargeinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_serverId` varchar(20) NOT NULL COMMENT '服务器id',
  `n_time` int(11) NOT NULL COMMENT '时间',
  `n_rechargeDatas` text NOT NULL COMMENT '充值数据',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gamedailyrechargeinfo
-- ----------------------------
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('10', 'qz_test_5', '1458748800', '1_1503_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('11', 'qz_test_5', '1458835200', '1_1505_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('12', 'qz_test_5', '1458921600', '1_1505_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('13', 'qz_test_5', '1459008000', '1_1505_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('14', 'qz_test_5', '1459094400', '1_1506_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('15', 'qz_test_5', '1459180800', '1_1506_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('16', 'qz_test_5', '1459267200', '1_1506_24');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('17', 'qz_test_5', '1460908800', '1_1511_12');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('18', 'qz_test_5', '1460995200', '1_1511_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('19', 'qz_test_5', '1461081600', '1_1511_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('20', 'qz_test_5', '1461168000', '1_1511_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('21', 'qz_test_5', '1461254400', '1_1511_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('22', 'qz_test_5', '1461340800', '1_1511_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('23', 'qz_test_5', '1461427200', '1_1511_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('24', 'qz_test_5', '1462377600', '1_1511_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('25', 'qz_test_5', '1462464000', '1_1511_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('26', 'qz_test_5', '1462550400', '1_1511_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('27', 'qz_test_5', '1462636800', '1_1511_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('28', 'qz_test_5', '1462723200', '1_1511_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('29', 'qz_test_5', '1462809600', '1_1511_0');
INSERT INTO `t_gamedailyrechargeinfo` VALUES ('30', 'qz_test_5', '1462896000', '1_1511_0');

-- ----------------------------
-- Table structure for t_gamedurationinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_gamedurationinfo`;
CREATE TABLE `t_gamedurationinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_serverId` varchar(50) NOT NULL COMMENT '服务器id',
  `n_durationNums` varchar(255) NOT NULL COMMENT '在线时长人数',
  `n_totalNum` int(11) NOT NULL COMMENT '总人数',
  `n_time` int(11) NOT NULL COMMENT '查询日期',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gamedurationinfo
-- ----------------------------
INSERT INTO `t_gamedurationinfo` VALUES ('3', 'qz_test_5', '0_3|1_1|3_1', '5', '1459267200');
INSERT INTO `t_gamedurationinfo` VALUES ('4', 'qz_test_5', '', '0', '1462896000');
INSERT INTO `t_gamedurationinfo` VALUES ('5', 'qz_test_5', '', '0', '1463241600');
INSERT INTO `t_gamedurationinfo` VALUES ('6', 'qz_test_5', '', '0', '1463328000');

-- ----------------------------
-- Table structure for t_gamefirstdurationinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_gamefirstdurationinfo`;
CREATE TABLE `t_gamefirstdurationinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_serverId` varchar(50) NOT NULL COMMENT '服务器id',
  `n_firstDurationNums` varchar(255) NOT NULL COMMENT '首登时长人数',
  `n_totalNum` int(11) NOT NULL COMMENT '总人数',
  `n_time` int(11) NOT NULL COMMENT '查询日期',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gamefirstdurationinfo
-- ----------------------------
INSERT INTO `t_gamefirstdurationinfo` VALUES ('4', 'qz_test_5', '', '0', '1459267200');
INSERT INTO `t_gamefirstdurationinfo` VALUES ('5', 'qz_test_5', '', '0', '1462896000');
INSERT INTO `t_gamefirstdurationinfo` VALUES ('6', 'qz_test_5', '', '0', '1463241600');
INSERT INTO `t_gamefirstdurationinfo` VALUES ('7', 'qz_test_5', '', '0', '1463328000');

-- ----------------------------
-- Table structure for t_gamekeepinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_gamekeepinfo`;
CREATE TABLE `t_gamekeepinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_serverId` varchar(20) NOT NULL COMMENT '服务器id',
  `n_regist` int(11) NOT NULL COMMENT '注册数量',
  `n_newAmount` int(11) NOT NULL COMMENT '新账号',
  `n_keep1` int(11) NOT NULL COMMENT '1日留存',
  `n_keep2` int(11) NOT NULL,
  `n_keep3` int(11) NOT NULL,
  `n_keep4` int(11) NOT NULL,
  `n_keep5` int(11) NOT NULL,
  `n_keep6` int(11) NOT NULL,
  `n_keep7` int(11) NOT NULL,
  `n_keep15` int(11) NOT NULL,
  `n_keep30` int(11) NOT NULL,
  `n_time` int(11) NOT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gamekeepinfo
-- ----------------------------
INSERT INTO `t_gamekeepinfo` VALUES ('24', 'qz_test_5', '2', '4', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '1456761600');
INSERT INTO `t_gamekeepinfo` VALUES ('25', 'qz_test_5', '1', '2', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '1456848000');
INSERT INTO `t_gamekeepinfo` VALUES ('26', 'qz_test_5', '14', '14', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '1456934400');
INSERT INTO `t_gamekeepinfo` VALUES ('27', 'qz_test_5', '37', '37', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '1457020800');
INSERT INTO `t_gamekeepinfo` VALUES ('28', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '1457107200');
INSERT INTO `t_gamekeepinfo` VALUES ('29', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '1457193600');
INSERT INTO `t_gamekeepinfo` VALUES ('30', 'qz_test_5', '19', '20', '0', '0', '1', '0', '0', '0', '0', '0', '-1', '1457280000');
INSERT INTO `t_gamekeepinfo` VALUES ('31', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '1457366400');
INSERT INTO `t_gamekeepinfo` VALUES ('32', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '1457452800');
INSERT INTO `t_gamekeepinfo` VALUES ('33', 'qz_test_5', '11', '11', '1', '0', '0', '0', '0', '0', '0', '0', '-1', '1457539200');
INSERT INTO `t_gamekeepinfo` VALUES ('34', 'qz_test_5', '13', '13', '0', '0', '3', '1', '0', '0', '0', '0', '-1', '1457625600');
INSERT INTO `t_gamekeepinfo` VALUES ('35', 'qz_test_5', '13', '13', '1', '0', '0', '0', '0', '0', '0', '0', '-1', '1457712000');
INSERT INTO `t_gamekeepinfo` VALUES ('36', 'qz_test_5', '3', '3', '1', '0', '0', '0', '0', '0', '0', '0', '-1', '1457798400');
INSERT INTO `t_gamekeepinfo` VALUES ('37', 'qz_test_5', '10', '12', '1', '0', '0', '0', '0', '0', '0', '0', '-1', '1457884800');
INSERT INTO `t_gamekeepinfo` VALUES ('38', 'qz_test_5', '12', '12', '1', '1', '0', '0', '0', '0', '0', '0', '-1', '1457971200');
INSERT INTO `t_gamekeepinfo` VALUES ('39', 'qz_test_5', '14', '14', '6', '0', '0', '0', '1', '0', '0', '-1', '-1', '1458057600');
INSERT INTO `t_gamekeepinfo` VALUES ('40', 'qz_test_5', '12', '14', '1', '0', '0', '0', '0', '0', '0', '-1', '-1', '1458144000');
INSERT INTO `t_gamekeepinfo` VALUES ('41', 'qz_test_5', '11', '11', '0', '0', '5', '1', '1', '1', '1', '-1', '-1', '1458230400');
INSERT INTO `t_gamekeepinfo` VALUES ('42', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '-1', '1458316800');
INSERT INTO `t_gamekeepinfo` VALUES ('43', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '-1', '1458403200');
INSERT INTO `t_gamekeepinfo` VALUES ('44', 'qz_test_5', '11', '11', '2', '1', '0', '0', '0', '0', '0', '-1', '-1', '1458489600');
INSERT INTO `t_gamekeepinfo` VALUES ('45', 'qz_test_5', '16', '16', '0', '0', '0', '0', '0', '0', '0', '-1', '-1', '1458576000');
INSERT INTO `t_gamekeepinfo` VALUES ('46', 'qz_test_5', '22', '22', '0', '0', '0', '0', '1', '1', '0', '-1', '-1', '1458662400');
INSERT INTO `t_gamekeepinfo` VALUES ('47', 'qz_test_5', '11', '11', '1', '0', '0', '0', '2', '0', '-1', '-1', '-1', '1458748800');
INSERT INTO `t_gamekeepinfo` VALUES ('48', 'qz_test_5', '2', '3', '0', '0', '0', '0', '0', '-1', '-1', '-1', '-1', '1458835200');
INSERT INTO `t_gamekeepinfo` VALUES ('49', 'qz_test_5', '0', '0', '0', '0', '0', '0', '-1', '-1', '-1', '-1', '-1', '1458921600');
INSERT INTO `t_gamekeepinfo` VALUES ('50', 'qz_test_5', '0', '0', '0', '0', '0', '-1', '-1', '-1', '-1', '-1', '-1', '1459008000');
INSERT INTO `t_gamekeepinfo` VALUES ('51', 'qz_test_5', '1', '1', '1', '1', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '1459094400');
INSERT INTO `t_gamekeepinfo` VALUES ('52', 'qz_test_5', '0', '0', '0', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '1459180800');
INSERT INTO `t_gamekeepinfo` VALUES ('53', 'qz_test_5', '0', '0', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '1459267200');
INSERT INTO `t_gamekeepinfo` VALUES ('54', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '1462032000');
INSERT INTO `t_gamekeepinfo` VALUES ('55', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '-1', '1462118400');
INSERT INTO `t_gamekeepinfo` VALUES ('56', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '-1', '1462204800');
INSERT INTO `t_gamekeepinfo` VALUES ('57', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '-1', '1462291200');
INSERT INTO `t_gamekeepinfo` VALUES ('58', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '-1', '1462377600');
INSERT INTO `t_gamekeepinfo` VALUES ('59', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '-1', '1462464000');
INSERT INTO `t_gamekeepinfo` VALUES ('60', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '-1', '1462550400');
INSERT INTO `t_gamekeepinfo` VALUES ('61', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '-1', '1462636800');
INSERT INTO `t_gamekeepinfo` VALUES ('62', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '-1', '1462723200');
INSERT INTO `t_gamekeepinfo` VALUES ('63', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '-1', '-1', '1462809600');
INSERT INTO `t_gamekeepinfo` VALUES ('64', 'qz_test_5', '0', '0', '0', '0', '0', '0', '0', '-1', '-1', '-1', '-1', '1462896000');
INSERT INTO `t_gamekeepinfo` VALUES ('65', 'qz_test_5', '0', '0', '0', '0', '0', '0', '-1', '-1', '-1', '-1', '-1', '1462982400');
INSERT INTO `t_gamekeepinfo` VALUES ('66', 'qz_test_5', '0', '0', '0', '0', '0', '-1', '-1', '-1', '-1', '-1', '-1', '1463068800');
INSERT INTO `t_gamekeepinfo` VALUES ('67', 'qz_test_5', '0', '0', '0', '0', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '1463155200');
INSERT INTO `t_gamekeepinfo` VALUES ('68', 'qz_test_5', '0', '0', '0', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '1463241600');
INSERT INTO `t_gamekeepinfo` VALUES ('69', 'qz_test_5', '0', '0', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '1463328000');

-- ----------------------------
-- Table structure for t_gamelevellossinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_gamelevellossinfo`;
CREATE TABLE `t_gamelevellossinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_time` int(11) NOT NULL COMMENT '时间',
  `n_serverId` varchar(20) NOT NULL COMMENT '服务器id',
  `n_level` int(11) NOT NULL COMMENT '等级',
  `n_levelAmount` int(11) NOT NULL COMMENT '等级人数',
  `n_reachLevelAmount` int(11) NOT NULL COMMENT '到达等级人数',
  `n_registAmount` int(11) NOT NULL COMMENT '注册人数',
  `n_lossAmount` int(11) NOT NULL COMMENT '流失人数',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gamelevellossinfo
-- ----------------------------
INSERT INTO `t_gamelevellossinfo` VALUES ('1', '1463470705', 'qz_test_5', '1', '656', '1511', '1511', '656');
INSERT INTO `t_gamelevellossinfo` VALUES ('2', '1463470705', 'qz_test_5', '2', '165', '855', '1511', '165');
INSERT INTO `t_gamelevellossinfo` VALUES ('3', '1463470705', 'qz_test_5', '3', '293', '690', '1511', '293');
INSERT INTO `t_gamelevellossinfo` VALUES ('4', '1463470705', 'qz_test_5', '4', '40', '397', '1511', '40');
INSERT INTO `t_gamelevellossinfo` VALUES ('5', '1463470705', 'qz_test_5', '5', '25', '357', '1511', '25');
INSERT INTO `t_gamelevellossinfo` VALUES ('6', '1463470705', 'qz_test_5', '6', '11', '332', '1511', '11');
INSERT INTO `t_gamelevellossinfo` VALUES ('7', '1463470705', 'qz_test_5', '7', '21', '321', '1511', '21');
INSERT INTO `t_gamelevellossinfo` VALUES ('8', '1463470705', 'qz_test_5', '8', '56', '300', '1511', '56');
INSERT INTO `t_gamelevellossinfo` VALUES ('9', '1463470705', 'qz_test_5', '9', '8', '244', '1511', '8');
INSERT INTO `t_gamelevellossinfo` VALUES ('10', '1463470705', 'qz_test_5', '10', '10', '236', '1511', '10');
INSERT INTO `t_gamelevellossinfo` VALUES ('11', '1463470705', 'qz_test_5', '11', '1', '226', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('12', '1463470705', 'qz_test_5', '12', '1', '225', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('13', '1463470705', 'qz_test_5', '13', '1', '224', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('14', '1463470705', 'qz_test_5', '14', '2', '223', '1511', '2');
INSERT INTO `t_gamelevellossinfo` VALUES ('15', '1463470705', 'qz_test_5', '15', '27', '221', '1511', '27');
INSERT INTO `t_gamelevellossinfo` VALUES ('16', '1463470705', 'qz_test_5', '16', '1', '194', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('17', '1463470705', 'qz_test_5', '18', '1', '193', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('18', '1463470705', 'qz_test_5', '19', '5', '192', '1511', '5');
INSERT INTO `t_gamelevellossinfo` VALUES ('19', '1463470705', 'qz_test_5', '20', '1', '187', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('20', '1463470705', 'qz_test_5', '21', '51', '186', '1511', '51');
INSERT INTO `t_gamelevellossinfo` VALUES ('21', '1463470705', 'qz_test_5', '23', '6', '135', '1511', '6');
INSERT INTO `t_gamelevellossinfo` VALUES ('22', '1463470705', 'qz_test_5', '25', '9', '129', '1511', '9');
INSERT INTO `t_gamelevellossinfo` VALUES ('23', '1463470705', 'qz_test_5', '26', '2', '120', '1511', '2');
INSERT INTO `t_gamelevellossinfo` VALUES ('24', '1463470705', 'qz_test_5', '27', '1', '118', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('25', '1463470705', 'qz_test_5', '29', '1', '117', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('26', '1463470705', 'qz_test_5', '30', '1', '116', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('27', '1463470705', 'qz_test_5', '31', '1', '115', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('28', '1463470705', 'qz_test_5', '33', '2', '114', '1511', '2');
INSERT INTO `t_gamelevellossinfo` VALUES ('29', '1463470705', 'qz_test_5', '34', '1', '112', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('30', '1463470705', 'qz_test_5', '35', '1', '111', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('31', '1463470705', 'qz_test_5', '36', '1', '110', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('32', '1463470705', 'qz_test_5', '37', '3', '109', '1511', '3');
INSERT INTO `t_gamelevellossinfo` VALUES ('33', '1463470705', 'qz_test_5', '38', '1', '106', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('34', '1463470705', 'qz_test_5', '39', '4', '105', '1511', '4');
INSERT INTO `t_gamelevellossinfo` VALUES ('35', '1463470705', 'qz_test_5', '47', '7', '101', '1511', '7');
INSERT INTO `t_gamelevellossinfo` VALUES ('36', '1463470705', 'qz_test_5', '48', '49', '94', '1511', '49');
INSERT INTO `t_gamelevellossinfo` VALUES ('37', '1463470705', 'qz_test_5', '49', '10', '45', '1511', '10');
INSERT INTO `t_gamelevellossinfo` VALUES ('38', '1463470705', 'qz_test_5', '50', '3', '35', '1511', '3');
INSERT INTO `t_gamelevellossinfo` VALUES ('39', '1463470705', 'qz_test_5', '52', '7', '32', '1511', '7');
INSERT INTO `t_gamelevellossinfo` VALUES ('40', '1463470705', 'qz_test_5', '54', '4', '25', '1511', '4');
INSERT INTO `t_gamelevellossinfo` VALUES ('41', '1463470705', 'qz_test_5', '56', '5', '21', '1511', '5');
INSERT INTO `t_gamelevellossinfo` VALUES ('42', '1463470705', 'qz_test_5', '59', '1', '16', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('43', '1463470705', 'qz_test_5', '61', '2', '15', '1511', '2');
INSERT INTO `t_gamelevellossinfo` VALUES ('44', '1463470705', 'qz_test_5', '63', '5', '13', '1511', '5');
INSERT INTO `t_gamelevellossinfo` VALUES ('45', '1463470705', 'qz_test_5', '65', '1', '8', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('46', '1463470705', 'qz_test_5', '67', '1', '7', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('47', '1463470705', 'qz_test_5', '87', '1', '6', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('48', '1463470705', 'qz_test_5', '92', '1', '5', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('49', '1463470705', 'qz_test_5', '95', '1', '4', '1511', '1');
INSERT INTO `t_gamelevellossinfo` VALUES ('50', '1463470705', 'qz_test_5', '100', '3', '3', '1511', '3');

-- ----------------------------
-- Table structure for t_gamemailinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_gamemailinfo`;
CREATE TABLE `t_gamemailinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_partner` int(11) NOT NULL,
  `n_title` varchar(50) NOT NULL COMMENT '标题',
  `n_content` varchar(512) NOT NULL COMMENT '内容',
  `n_items` varchar(1024) NOT NULL COMMENT '物品',
  `n_createTime` int(11) NOT NULL COMMENT '发送时间',
  `n_sendType` int(11) NOT NULL COMMENT '类型',
  `n_uids` text NOT NULL COMMENT '要发送的玩家id',
  `n_openids` text NOT NULL COMMENT '玩家账号',
  `n_state` int(11) NOT NULL COMMENT '状态(0为未审核,1为审核通过,2为拒绝)',
  `n_uid` int(11) NOT NULL,
  `n_username` varchar(50) NOT NULL,
  `n_serverId` varchar(50) NOT NULL,
  `n_send` tinyint(1) NOT NULL,
  `n_times` varchar(128) NOT NULL DEFAULT '' COMMENT '期限时间',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gamemailinfo
-- ----------------------------

-- ----------------------------
-- Table structure for t_gamepandectinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_gamepandectinfo`;
CREATE TABLE `t_gamepandectinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_serverId` varchar(50) NOT NULL COMMENT '服务器id',
  `n_dayCountRegisterNum` int(11) NOT NULL COMMENT '每日注册人数',
  `n_dayCountActiveNum` int(11) NOT NULL COMMENT '每日活跃人数',
  `n_dayCountRecharge` bigint(20) NOT NULL COMMENT '每日累计充值',
  `n_time` int(11) NOT NULL COMMENT '查询日期',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gamepandectinfo
-- ----------------------------
INSERT INTO `t_gamepandectinfo` VALUES ('14', 'qz_test_5', '4', '5', '0', '1458835200');
INSERT INTO `t_gamepandectinfo` VALUES ('15', 'qz_test_5', '0', '0', '0', '1458921600');
INSERT INTO `t_gamepandectinfo` VALUES ('16', 'qz_test_5', '0', '0', '0', '1459008000');
INSERT INTO `t_gamepandectinfo` VALUES ('17', 'qz_test_5', '1', '4', '0', '1459094400');
INSERT INTO `t_gamepandectinfo` VALUES ('18', 'qz_test_5', '0', '10', '0', '1459180800');
INSERT INTO `t_gamepandectinfo` VALUES ('19', 'qz_test_5', '0', '5', '24', '1459267200');
INSERT INTO `t_gamepandectinfo` VALUES ('20', 'qz_test_1', '0', '0', '0', '1458921600');
INSERT INTO `t_gamepandectinfo` VALUES ('21', 'qz_test_1', '0', '0', '0', '1459008000');
INSERT INTO `t_gamepandectinfo` VALUES ('22', 'qz_test_1', '1', '1', '0', '1459094400');
INSERT INTO `t_gamepandectinfo` VALUES ('23', 'qz_test_1', '3', '4', '0', '1459180800');
INSERT INTO `t_gamepandectinfo` VALUES ('24', 'qz_test_1', '1', '1', '0', '1459267200');
INSERT INTO `t_gamepandectinfo` VALUES ('25', 'qz_test_1', '5', '5', '0', '1459353600');
INSERT INTO `t_gamepandectinfo` VALUES ('26', 'qz_test_5', '0', '0', '0', '1460995200');
INSERT INTO `t_gamepandectinfo` VALUES ('27', 'qz_test_5', '0', '0', '0', '1461081600');
INSERT INTO `t_gamepandectinfo` VALUES ('28', 'qz_test_5', '0', '0', '0', '1461168000');
INSERT INTO `t_gamepandectinfo` VALUES ('29', 'qz_test_5', '0', '1', '0', '1461254400');
INSERT INTO `t_gamepandectinfo` VALUES ('30', 'qz_test_5', '0', '0', '0', '1461340800');
INSERT INTO `t_gamepandectinfo` VALUES ('31', 'qz_test_5', '0', '0', '0', '1461427200');
INSERT INTO `t_gamepandectinfo` VALUES ('32', 'qz_test_5', '0', '0', '0', '1462464000');
INSERT INTO `t_gamepandectinfo` VALUES ('33', 'qz_test_5', '0', '0', '0', '1462550400');
INSERT INTO `t_gamepandectinfo` VALUES ('34', 'qz_test_5', '0', '0', '0', '1462636800');
INSERT INTO `t_gamepandectinfo` VALUES ('35', 'qz_test_5', '0', '0', '0', '1462723200');
INSERT INTO `t_gamepandectinfo` VALUES ('36', 'qz_test_5', '0', '0', '0', '1462809600');
INSERT INTO `t_gamepandectinfo` VALUES ('37', 'qz_test_5', '0', '0', '0', '1462896000');
INSERT INTO `t_gamepandectinfo` VALUES ('38', 'qz_test_5', '0', '1', '6', '1462982400');
INSERT INTO `t_gamepandectinfo` VALUES ('39', 'qz_test_5', '0', '0', '0', '1463068800');
INSERT INTO `t_gamepandectinfo` VALUES ('40', 'qz_test_5', '0', '0', '0', '1463155200');
INSERT INTO `t_gamepandectinfo` VALUES ('41', 'qz_test_5', '0', '0', '0', '1463241600');
INSERT INTO `t_gamepandectinfo` VALUES ('42', 'qz_test_5', '0', '0', '0', '1463328000');

-- ----------------------------
-- Table structure for t_gamepartnerinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_gamepartnerinfo`;
CREATE TABLE `t_gamepartnerinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_name` varchar(50) NOT NULL COMMENT '名称',
  `n_payUrl` varchar(512) NOT NULL COMMENT '正式支付地址',
  `n_payDebugUrl` varchar(512) NOT NULL COMMENT '测试支付地址',
  `n_callbackUrl` varchar(512) NOT NULL COMMENT '回调地址',
  `n_privateKey` varchar(512) NOT NULL COMMENT '私钥',
  `n_publicKey` varchar(512) NOT NULL COMMENT '公钥',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gamepartnerinfo
-- ----------------------------
INSERT INTO `t_gamepartnerinfo` VALUES ('1', '苹果', 'https://buy.itunes.apple.com/verifyReceipt', 'https://sandbox.itunes.apple.com/verifyReceipt', '', '', '');

-- ----------------------------
-- Table structure for t_gamerefreshinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_gamerefreshinfo`;
CREATE TABLE `t_gamerefreshinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_name` varchar(50) NOT NULL COMMENT '名称',
  `n_type` int(11) NOT NULL COMMENT '类型',
  `n_refUrl` varchar(512) NOT NULL COMMENT '刷新地址',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gamerefreshinfo
-- ----------------------------
INSERT INTO `t_gamerefreshinfo` VALUES ('1', '本地区服缓存', '1', 'http://127.0.0.1:8888/ServerInfoHandler/loadServerCache.do');
INSERT INTO `t_gamerefreshinfo` VALUES ('2', '本地渠道缓存', '2', 'http://127.0.0.1:8888/PayHandler/loadPartnerCache.do');

-- ----------------------------
-- Table structure for t_gameregistlossinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_gameregistlossinfo`;
CREATE TABLE `t_gameregistlossinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_serverId` varchar(20) NOT NULL,
  `n_newAmount` int(11) NOT NULL COMMENT '新账号',
  `n_requestRegistAmount` int(11) NOT NULL COMMENT '请求注册人数',
  `n_registAmount` int(11) NOT NULL COMMENT '注册成功数',
  `n_enterAmount` int(11) NOT NULL COMMENT '进入游戏人数',
  `n_time` int(11) NOT NULL COMMENT '时间',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gameregistlossinfo
-- ----------------------------

-- ----------------------------
-- Table structure for t_gameregistreportinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_gameregistreportinfo`;
CREATE TABLE `t_gameregistreportinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_serverId` varchar(50) NOT NULL COMMENT '服务器id',
  `n_time` int(11) NOT NULL COMMENT '统计时间',
  `n_amount` int(11) NOT NULL COMMENT '注册数量',
  `n_addAmount` int(11) NOT NULL COMMENT '新增数量',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=193 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gameregistreportinfo
-- ----------------------------
INSERT INTO `t_gameregistreportinfo` VALUES ('73', 'qz_test_5', '1459270800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('74', 'qz_test_5', '1459274400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('75', 'qz_test_5', '1459278000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('76', 'qz_test_5', '1459281600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('77', 'qz_test_5', '1459285200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('78', 'qz_test_5', '1459288800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('79', 'qz_test_5', '1459292400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('80', 'qz_test_5', '1459296000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('81', 'qz_test_5', '1459299600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('82', 'qz_test_5', '1459303200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('83', 'qz_test_5', '1459306800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('84', 'qz_test_5', '1459310400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('85', 'qz_test_5', '1459314000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('86', 'qz_test_5', '1459317600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('87', 'qz_test_5', '1459321200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('88', 'qz_test_5', '1459324800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('89', 'qz_test_5', '1459328400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('90', 'qz_test_5', '1459332000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('91', 'qz_test_5', '1459335600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('92', 'qz_test_5', '1459339200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('93', 'qz_test_5', '1459342800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('94', 'qz_test_5', '1459346400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('95', 'qz_test_5', '1459350000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('96', 'qz_test_5', '1459353600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('97', 'qz_test_5', '1461430800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('98', 'qz_test_5', '1461434400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('99', 'qz_test_5', '1461438000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('100', 'qz_test_5', '1461441600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('101', 'qz_test_5', '1461445200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('102', 'qz_test_5', '1461448800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('103', 'qz_test_5', '1461452400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('104', 'qz_test_5', '1461456000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('105', 'qz_test_5', '1461459600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('106', 'qz_test_5', '1461463200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('107', 'qz_test_5', '1461466800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('108', 'qz_test_5', '1461470400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('109', 'qz_test_5', '1461474000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('110', 'qz_test_5', '1461477600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('111', 'qz_test_5', '1461481200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('112', 'qz_test_5', '1461484800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('113', 'qz_test_5', '1461488400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('114', 'qz_test_5', '1461492000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('115', 'qz_test_5', '1461495600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('116', 'qz_test_5', '1461499200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('117', 'qz_test_5', '1461502800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('118', 'qz_test_5', '1461506400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('119', 'qz_test_5', '1461510000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('120', 'qz_test_5', '1461513600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('121', 'qz_test_5', '1462899600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('122', 'qz_test_5', '1462903200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('123', 'qz_test_5', '1462906800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('124', 'qz_test_5', '1462910400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('125', 'qz_test_5', '1462914000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('126', 'qz_test_5', '1462917600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('127', 'qz_test_5', '1462921200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('128', 'qz_test_5', '1462924800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('129', 'qz_test_5', '1462928400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('130', 'qz_test_5', '1462932000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('131', 'qz_test_5', '1462935600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('132', 'qz_test_5', '1462939200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('133', 'qz_test_5', '1462942800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('134', 'qz_test_5', '1462946400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('135', 'qz_test_5', '1462950000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('136', 'qz_test_5', '1462953600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('137', 'qz_test_5', '1462957200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('138', 'qz_test_5', '1462960800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('139', 'qz_test_5', '1462964400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('140', 'qz_test_5', '1462968000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('141', 'qz_test_5', '1462971600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('142', 'qz_test_5', '1462975200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('143', 'qz_test_5', '1462978800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('144', 'qz_test_5', '1462982400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('145', 'qz_test_5', '1463245200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('146', 'qz_test_5', '1463248800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('147', 'qz_test_5', '1463252400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('148', 'qz_test_5', '1463256000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('149', 'qz_test_5', '1463259600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('150', 'qz_test_5', '1463263200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('151', 'qz_test_5', '1463266800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('152', 'qz_test_5', '1463270400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('153', 'qz_test_5', '1463274000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('154', 'qz_test_5', '1463277600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('155', 'qz_test_5', '1463281200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('156', 'qz_test_5', '1463284800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('157', 'qz_test_5', '1463288400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('158', 'qz_test_5', '1463292000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('159', 'qz_test_5', '1463295600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('160', 'qz_test_5', '1463299200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('161', 'qz_test_5', '1463302800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('162', 'qz_test_5', '1463306400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('163', 'qz_test_5', '1463310000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('164', 'qz_test_5', '1463313600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('165', 'qz_test_5', '1463317200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('166', 'qz_test_5', '1463320800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('167', 'qz_test_5', '1463324400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('168', 'qz_test_5', '1463328000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('169', 'qz_test_5', '1463331600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('170', 'qz_test_5', '1463335200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('171', 'qz_test_5', '1463338800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('172', 'qz_test_5', '1463342400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('173', 'qz_test_5', '1463346000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('174', 'qz_test_5', '1463349600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('175', 'qz_test_5', '1463353200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('176', 'qz_test_5', '1463356800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('177', 'qz_test_5', '1463360400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('178', 'qz_test_5', '1463364000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('179', 'qz_test_5', '1463367600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('180', 'qz_test_5', '1463371200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('181', 'qz_test_5', '1463374800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('182', 'qz_test_5', '1463378400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('183', 'qz_test_5', '1463382000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('184', 'qz_test_5', '1463385600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('185', 'qz_test_5', '1463389200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('186', 'qz_test_5', '1463392800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('187', 'qz_test_5', '1463396400', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('188', 'qz_test_5', '1463400000', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('189', 'qz_test_5', '1463403600', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('190', 'qz_test_5', '1463407200', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('191', 'qz_test_5', '1463410800', '0', '0');
INSERT INTO `t_gameregistreportinfo` VALUES ('192', 'qz_test_5', '1463414400', '0', '0');

-- ----------------------------
-- Table structure for t_gameserverinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_gameserverinfo`;
CREATE TABLE `t_gameserverinfo` (
  `n_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `n_serverId` varchar(20) NOT NULL COMMENT '服务器ID',
  `n_serverNo` int(11) DEFAULT '0' COMMENT '区服编号(数字1-N 依次叠加)',
  `n_serverName` varchar(50) DEFAULT NULL COMMENT '服务器名称',
  `n_version` int(4) NOT NULL DEFAULT '0' COMMENT '版本',
  `n_port` int(10) NOT NULL COMMENT '登录服端口',
  `n_ip` varchar(30) NOT NULL COMMENT '登录服地址',
  `n_worldPort` int(10) DEFAULT NULL,
  `n_worldIp` varchar(30) DEFAULT NULL,
  `n_desc` varchar(100) DEFAULT '' COMMENT '描述',
  `n_status` int(10) DEFAULT '0' COMMENT '状态(-1: 关闭， 0: 即将开区, 1: 维护，2: 正常, 3:推荐 4: 火爆)',
  `n_recommend` tinyint(4) DEFAULT '0' COMMENT '1: 推荐 ， 0: 不推荐',
  `n_mainServerId` int(11) DEFAULT '0' COMMENT '服务器主区ID(0: 表示主区， 其他参数表示所属哪个区服)',
  `n_startTime` datetime DEFAULT NULL COMMENT '开服时间',
  `n_maintainStartTime` datetime DEFAULT NULL COMMENT '维护开始时间',
  `n_maintainEndTime` datetime DEFAULT NULL COMMENT '维护结束时间',
  `n_maintainMsg` varchar(255) DEFAULT '' COMMENT '维护显示信息',
  `n_continueLoginCycle` int(11) DEFAULT '7' COMMENT '连续登陆周期，作为连续登陆活动使用',
  `n_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `n_mainDBUrl` varchar(128) DEFAULT NULL,
  `n_mainDBUsername` varchar(128) DEFAULT NULL,
  `n_mainDBPassword` varchar(128) DEFAULT NULL,
  `n_configDBUrl` varchar(128) DEFAULT NULL,
  `n_configDBUsername` varchar(128) DEFAULT NULL,
  `n_configDBPassword` varchar(128) DEFAULT NULL,
  `n_adminUrl` varchar(128) DEFAULT NULL,
  `n_adminCheck` varchar(128) DEFAULT NULL,
  `n_defaultSelect` tinyint(1) DEFAULT NULL,
  `n_type` int(11) DEFAULT NULL,
  `n_merge` int(11) DEFAULT NULL,
  `n_state` int(4) NOT NULL DEFAULT '0' COMMENT '连接状态',
  `n_stateTime` int(11) NOT NULL COMMENT '连接状态更新时间',
  `n_rechargeUrl` varchar(255) NOT NULL COMMENT '充值地址',
  PRIMARY KEY (`n_id`),
  UNIQUE KEY `server_id_unique` (`n_serverId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='服务器信息';

-- ----------------------------
-- Records of t_gameserverinfo
-- ----------------------------
INSERT INTO `t_gameserverinfo` VALUES ('1', 'qz_test_1', '1', '外网', '0', '16789', '182.254.147.65', '1234', '182.254.147.65', '', '-1', '1', '0', '2016-01-18 00:00:00', null, null, '', '0', '2015-06-01 19:12:33', 'jdbc:mysql://182.254.147.65:3306/qz_s1_data?useUnicode=true&characterEncoding=UTF-8', 'appadmin', 'a5229299', 'jdbc:mysql://182.254.147.65:3306/qz_s1_cfg?useUnicode=true&characterEncoding=UTF-8', 'root', 'a5229299', 'http://182.254.147.65:12222/', 'xxxx', '0', '0', '0', '1', '1464321510', 'http://182.254.147.65:18888');
INSERT INTO `t_gameserverinfo` VALUES ('2', 'qz_test_2', '2', '瘳汉杰', '0', '6789', '192.168.100.124', '1234', '192.168.100.124', '', '-1', '1', '0', '2015-10-30 00:00:00', '2016-01-20 00:00:00', '2016-01-20 10:00:00', '', '0', '2015-06-01 19:12:33', 'jdbc:mysql://192.168.100.124:3306/db_qz?useUnicode=true&characterEncoding=UTF-8', 'root', '123456', 'jdbc:mysql://192.168.100.124:3306/db_qz_cfg?useUnicode=true&characterEncoding=UTF-8', 'root', '123456', 'http://192.168.100.124:2222/', 'xxxx', '0', '0', '0', '0', '1464321510', '');
INSERT INTO `t_gameserverinfo` VALUES ('3', 'qz_test_3', '3', '黄剑武', '0', '6789', '192.168.100.103', '1234', '192.168.100.103', '', '-1', '1', '0', '2016-01-19 00:00:00', null, null, '', '0', '2015-06-01 19:12:33', 'jdbc:mysql://192.168.100.103:3306/develop_qz?useUnicode=true&characterEncoding=UTF-8', 'root', 'admin', 'jdbc:mysql://192.168.100.103:3306/develop_qz_cfg?useUnicode=true&characterEncoding=UTF-8', 'root', 'admin', 'http://192.168.100.103:2222/', 'xxxx', '0', '0', '0', '0', '1464321510', 'http://192.168.100.103:8888');
INSERT INTO `t_gameserverinfo` VALUES ('4', 'qz_test_4', '4', '郑创坤', '0', '6789', '192.168.100.117', '1234', '192.168.100.117', '', '-1', '1', '0', '2015-10-30 00:00:00', null, null, '', '0', '2015-06-01 19:12:33', 'jdbc:mysql://192.168.100.117:3306/db_qz?useUnicode=true&characterEncoding=UTF-8', 'root', '123456', 'jdbc:mysql://192.168.100.117:3306/db_qz_cfg?useUnicode=true&characterEncoding=UTF-8', 'root', '123456', 'http://192.168.100.117:2222/', 'xxxx', '0', '0', '0', '0', '1464321510', '');
INSERT INTO `t_gameserverinfo` VALUES ('5', 'qz_test_5', '5', '内网', '0', '6789', '192.168.100.10', '1234', '192.168.100.10', '', '-1', '1', '0', '2015-10-30 00:00:00', null, null, '', '0', '2015-06-01 19:12:33', 'jdbc:mysql://192.168.100.10:3306/db_qz?useUnicode=true&characterEncoding=UTF-8', 'appadmin', 'a5229299', 'jdbc:mysql://192.168.100.10:3306/db_qz_cfg?useUnicode=true&characterEncoding=UTF-8', 'appadmin', 'a5229299', 'http://192.168.100.10:2222/', 'xxxx', '1', '0', '0', '1', '1464321510', 'http://192.168.100.10:8888');

-- ----------------------------
-- Table structure for t_gametwicelogininfo
-- ----------------------------
DROP TABLE IF EXISTS `t_gametwicelogininfo`;
CREATE TABLE `t_gametwicelogininfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_serverId` varchar(50) NOT NULL COMMENT '服务器id',
  `n_twiceLoginNum` int(11) NOT NULL COMMENT '二次登录数',
  `n_newNum` int(11) NOT NULL COMMENT '新增人数',
  `n_time` int(11) NOT NULL COMMENT '查询时间',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gametwicelogininfo
-- ----------------------------
INSERT INTO `t_gametwicelogininfo` VALUES ('4', 'qz_test_5', '0', '0', '1459267200');
INSERT INTO `t_gametwicelogininfo` VALUES ('5', 'qz_test_5', '0', '0', '1462896000');
INSERT INTO `t_gametwicelogininfo` VALUES ('6', 'qz_test_5', '0', '0', '1463241600');
INSERT INTO `t_gametwicelogininfo` VALUES ('7', 'qz_test_5', '0', '0', '1463328000');

-- ----------------------------
-- Table structure for t_sysjurisdictioninfo
-- ----------------------------
DROP TABLE IF EXISTS `t_sysjurisdictioninfo`;
CREATE TABLE `t_sysjurisdictioninfo` (
  `n_id` int(11) NOT NULL,
  `n_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '权限名称',
  `n_desc` text CHARACTER SET utf8 NOT NULL COMMENT '功能描述',
  `n_parentId` int(11) NOT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_sysjurisdictioninfo
-- ----------------------------
INSERT INTO `t_sysjurisdictioninfo` VALUES ('100000', '系统管理', '', '0');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('101000', '菜单管理', '管理后台菜单', '100000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('101001', '添加/修改菜单项', '操作权限-添加菜单项', '101000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('101002', '停用菜单项', '操作权限-停用菜单项', '101000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('101003', '删除菜单项', '操作权限-删除菜单项', '101000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('102000', '用户管理', '管理后台登录帐号', '100000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('102001', '添加/修改用户', '操作权限-添加/修改后台用户', '102000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('102002', '删除用户', '操作权限-删除后台用户', '102000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('103000', '用户组管理', '管理后台用户帐号及权限', '100000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('103001', '添加/修改用户组', '操作权限-添加/修改用户组', '103000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('103002', '删除用户组', '操作权限-删除用户组', '103000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('104000', '权限管理', '分配后台帐号使用权限', '100000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('104001', '添加/修改权限', '操作权限-添加/修改权限', '104000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('104002', '删除权限', '操作权限-删除权限', '104000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('105000', '请求权限管理', '管理后台使用的URL权限', '100000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('105001', '添加/修改请求权限', '操作权限-添加/修改请求地址权限', '105000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('105002', '删除请求权限', '操作权限-删除请求地址权限', '105000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('200000', '后台管理', '', '0');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('201000', '服务器管理', '获取服务器信息', '200000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('201001', '添加服务器', '操作权限-添加游戏服务器', '201000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('201002', '删除服务器', '操作权限-删除游戏服务器', '201000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('201003', '修改服务器', '操作权限-修改游戏服务器', '201000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('201004', '停服', '操作权限-关闭游戏服务器', '201000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('201005', '重载缓存', '操作权限-重新加载服务器缓存', '201000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('202000', '渠道管理', '配置支付地址', '200000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('202001', '添加/修改渠道', '操作权限-添加/修改渠道', '202000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('202002', '删除渠道', '操作权限-删除渠道', '202000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('203000', 'Web管理', '刷新web缓存信息', '200000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('203001', '添加/修改Web刷新', '操作权限-添加/修改Web缓存刷新', '203000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('203002', '删除Web刷新', '操作权限-删除Web缓存刷新', '203000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('203003', '刷新Web缓存', '操作权限-刷新Web缓存', '203000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('300000', '游戏管理', '', '0');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('301000', '玩家管理', '获取玩家数据', '300000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('301001', '玩家禁言/封号', '操作权限-玩家禁言/封号', '301000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('302000', '伙伴管理', '查询玩家背包伙伴', '300000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('303000', '装备管理', '查询玩家背包装备', '300000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('304000', '武魂管理', '查询玩家背包武魂', '300000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('305000', '道具管理', '查询玩家背包道具', '300000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('306000', '聊天监控', '监控游戏公聊记录', '300000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('400000', '运营管理', '', '0');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('401000', 'GM管理', '直接修改玩家部分数据', '400000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('401001', '修改玩家信息', '操作权限-修改部分玩家信息', '401000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('402000', '邮件申请', '发送系统邮件申请', '400000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('402001', '提交邮件申请', '操作权限-提交邮件申请', '402000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('403000', '邮件审核', '审批已申请系统邮件', '400000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('403001', '审核邮件申请', '操作权限-审核邮件申请', '403000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('403002', '删除邮件申请', '操作权限-删除邮件申请', '403000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('403003', '刷新发放状态', '操作权限-刷新发放状态', '403000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('404000', '邮件管理', '管理已发送的系统邮件', '400000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('404001', '删除系统邮件', '操作权限-删除系统邮件', '404000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('405000', 'CDKEY生成', '生成CDKEY', '400000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('405001', '生成CDKEY', '操作权限-生成CDKEY', '405000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('406000', 'CDKEY管理', '管理已生成的CDKEY', '400000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('406001', '激活CDKEY', '权限操作-激活CDKEY', '406000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('406002', '删除CDKEY', '权限操作-删除CDKEY', '406000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('406003', '下载CDKEY', '操作权限-下载CDKEY', '406000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('407000', 'CDKEY记录', '搜索查看CDKEY兑换记录', '400000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('408000', '充值订单管理', '查看充值订单', '400000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('408001', '订单发货', '操作权限-订单发货/重新发货', '408000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('409000', '发送系统公告', '', '400000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('500000', '数据统计', '', '0');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('501000', '数据总览', '', '500000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('502000', '创角统计', '', '500000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('503000', '在线统计', '', '500000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('504000', '最高在线统计', '', '500000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('505000', '在线时长统计', '', '500000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('506000', '首登时长统计', '', '500000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('507000', '二次登录统计', '', '500000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('508000', '留存统计', '', '500000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('509000', '等级流失统计', '', '500000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('510000', '关卡流失统计', '', '500000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('511000', '充值总汇', '', '500000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('512000', '充值明细', '', '500000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('513000', '充值额度统计', '', '500000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('514000', '充值排名统计', '', '500000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('600000', '游戏日志', '', '0');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('601000', '登录日志', '', '600000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('602000', '钻石日志', '', '600000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('603000', '金币日志', '', '600000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('604000', '经验日志', '', '600000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('605000', '体力日志', '', '600000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('606000', '石板日志', '', '600000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('607000', '伙伴经验池经验', '', '600000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('608000', '灵气日志', '', '600000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('609000', '道具日志', '', '600000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('610000', '伙伴日志', '', '600000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('611000', '装备日志', '', '600000');
INSERT INTO `t_sysjurisdictioninfo` VALUES ('612000', '武魂日志', '', '600000');

-- ----------------------------
-- Table structure for t_sysmenuinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_sysmenuinfo`;
CREATE TABLE `t_sysmenuinfo` (
  `n_id` int(11) NOT NULL,
  `n_parentId` int(11) NOT NULL COMMENT '父id',
  `n_name` varchar(50) NOT NULL COMMENT '名称',
  `n_enable` int(11) NOT NULL COMMENT '是否启用',
  `n_url` varchar(256) NOT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sysmenuinfo
-- ----------------------------
INSERT INTO `t_sysmenuinfo` VALUES ('1000', '0', '系统管理', '1', '');
INSERT INTO `t_sysmenuinfo` VALUES ('1010', '1000', '菜单管理', '1', 'system_mgr/sys_menu_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('1020', '1000', '用户管理', '1', 'system_mgr/sys_user_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('1030', '1000', '用户组管理', '1', 'system_mgr/sys_user_group_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('1040', '1000', '权限管理', '1', 'system_mgr/sys_jurisdiction_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('1050', '1000', '请求权限管理', '1', 'system_mgr/sys_request_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('2000', '0', '后台管理', '1', '');
INSERT INTO `t_sysmenuinfo` VALUES ('2010', '2000', '服务器管理', '1', 'game_server_mgr/game_server_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('2020', '2000', '渠道管理', '1', 'game_server_mgr/game_partner_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('2030', '2000', 'Web管理', '1', 'game_server_mgr/game_web_refresh_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('3000', '0', '游戏管理', '1', '');
INSERT INTO `t_sysmenuinfo` VALUES ('3010', '3000', '玩家管理', '1', 'game_player_mgr/game_player_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('3020', '3000', '伙伴管理', '1', 'game_player_mgr/game_hero_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('3030', '3000', '装备管理', '1', 'game_player_mgr/game_equip_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('3040', '3000', '武魂管理', '1', 'game_player_mgr/game_eternal_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('3050', '3000', '道具管理', '1', 'game_player_mgr/game_prop_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('3060', '3000', '聊天监控', '1', 'game_player_mgr/game_chat_monitor_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('4000', '0', '运营管理', '1', '');
INSERT INTO `t_sysmenuinfo` VALUES ('4010', '4000', 'GM管理', '1', 'game_operate_mgr/game_gm_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('4020', '4000', '邮件申请', '1', 'game_operate_mgr/game_mail_apply_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('4030', '4000', '邮件审核', '1', 'game_operate_mgr/game_mail_auditing_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('4040', '4000', '邮件管理', '1', 'game_operate_mgr/game_mail_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('4050', '4000', 'CDKEY生成', '1', 'game_operate_mgr/game_cdkey_generate_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('4060', '4000', 'CDKEY管理', '1', 'game_operate_mgr/game_cdkey_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('4070', '4000', 'CDKEY记录', '1', 'game_operate_mgr/game_cdkey_record_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('4080', '4000', '充值订单管理', '1', 'game_operate_mgr/game_recharge_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('4090', '4000', '发送系统公告', '0', 'game_operate_mgr/game_send_notice_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('5000', '0', '数据统计', '1', '');
INSERT INTO `t_sysmenuinfo` VALUES ('5010', '5000', '数据总览', '1', 'game_stats_mgr/game_pandect_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('5020', '5000', '创角统计', '1', 'game_stats_mgr/game_register_report_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('5030', '5000', '在线统计', '1', 'game_stats_mgr/game_online_report_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('5040', '5000', '最高在数统计', '1', 'game_stats_mgr/game_max_online_report_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('5050', '5000', '在线时长统计', '1', 'game_stats_mgr/game_duration_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('5060', '5000', '首登时长统计', '1', 'game_stats_mgr/game_first_duration_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('5070', '5000', '二次登录统计', '1', 'game_stats_mgr/game_twice_login_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('5080', '5000', '留存统计', '1', 'game_stats_mgr/game_keep_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('5090', '5000', '等级流失统计', '1', 'game_stats_mgr/game_level_loss_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('5100', '5000', '关卡流失统计', '1', 'game_stats_mgr/game_battle_loss_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('5110', '5000', '充值总汇', '1', 'game_stats_mgr/game_recharge_summary_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('5120', '5000', '充值明细', '1', 'game_stats_mgr/game_recharge_details_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('5130', '5000', '充值额度统计', '1', 'game_stats_mgr/game_recharge_quota_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('5140', '5000', '充值排名统计', '1', 'game_stats_mgr/game_recharge_rank_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('6000', '0', '游戏日志', '1', '');
INSERT INTO `t_sysmenuinfo` VALUES ('6010', '6000', '登录日志', '1', 'game_log_mgr/game_login_log_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('6020', '6000', '钻石日志', '1', 'game_log_mgr/game_money_log_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('6030', '6000', '金币日志', '1', 'game_log_mgr/game_gold_log_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('6040', '6000', '经验日志', '1', 'game_log_mgr/game_exp_log_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('6050', '6000', '体力日志', '1', 'game_log_mgr/game_stamina_log_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('6060', '6000', '石板日志', '1', 'game_log_mgr/game_slate_log_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('6070', '6000', '伙伴经验池日志', '1', 'game_log_mgr/game_hero_exp_pool_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('6080', '6000', '灵气日志', '0', 'game_log_mgr/game_gp_log_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('6090', '6000', '道具日志', '1', 'game_log_mgr/game_prop_log_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('6100', '6000', '伙伴日志', '1', 'game_log_mgr/game_hero_log_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('6110', '6000', '装备日志', '1', 'game_log_mgr/game_equip_log_mgr.jsp');
INSERT INTO `t_sysmenuinfo` VALUES ('6120', '6000', '武魂日志', '1', 'game_log_mgr/game_eternal_log_mgr.jsp');

-- ----------------------------
-- Table structure for t_sysrequestinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_sysrequestinfo`;
CREATE TABLE `t_sysrequestinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_name` varchar(20) NOT NULL COMMENT '名称',
  `n_url` varchar(126) NOT NULL COMMENT '链接地址',
  `n_jurisdictionId` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=612001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sysrequestinfo
-- ----------------------------
INSERT INTO `t_sysrequestinfo` VALUES ('1', '首页', 'index.jsp', '-1');
INSERT INTO `t_sysrequestinfo` VALUES ('2', '登录', 'login.jsp', '-1');
INSERT INTO `t_sysrequestinfo` VALUES ('3', '退出', 'logout.jsp', '-1');
INSERT INTO `t_sysrequestinfo` VALUES ('4', '转向登录', 'redirect_login.jsp', '-1');
INSERT INTO `t_sysrequestinfo` VALUES ('5', '兑换CDKEY', 'game_cmd_mgr/cmd_convert_cdkey.jsp', '-1');
INSERT INTO `t_sysrequestinfo` VALUES ('101000', '菜单管理', 'system_mgr/sys_menu_mgr.jsp', '101000');
INSERT INTO `t_sysrequestinfo` VALUES ('101001', '添加/修改菜单项', 'system_mgr/url_menu_save.jsp', '101001');
INSERT INTO `t_sysrequestinfo` VALUES ('101002', '停用菜单项', 'system_mgr/url_menu_enable.jsp', '101002');
INSERT INTO `t_sysrequestinfo` VALUES ('101003', '删除菜单项', 'system_mgr/url_menu_delete.jsp', '101003');
INSERT INTO `t_sysrequestinfo` VALUES ('102000', '用户管理', 'system_mgr/sys_user_mgr.jsp', '102000');
INSERT INTO `t_sysrequestinfo` VALUES ('102001', '添加/修改用户', 'system_mgr/url_menu_save.jsp', '102001');
INSERT INTO `t_sysrequestinfo` VALUES ('102002', '删除用户', 'system_mgr/url_menu_delete.jsp', '102002');
INSERT INTO `t_sysrequestinfo` VALUES ('103000', '用户组管理', 'system_mgr/sys_user_group_mgr.jsp', '103000');
INSERT INTO `t_sysrequestinfo` VALUES ('103001', '添加/修改用户组', 'system_mgr/url_user_group_save.jsp', '103001');
INSERT INTO `t_sysrequestinfo` VALUES ('103002', '删除用户组', 'system_mgr/url_user_group_delete.jsp', '103002');
INSERT INTO `t_sysrequestinfo` VALUES ('104000', '权限管理', 'system_mgr/sys_jurisdiction_mgr.jsp', '104000');
INSERT INTO `t_sysrequestinfo` VALUES ('104001', '添加/修改权限', 'system_mgr/url_jurisdiction_save.jsp', '104001');
INSERT INTO `t_sysrequestinfo` VALUES ('104002', '删除权限', 'system_mgr/url_jurisdiction_delete.jsp', '104002');
INSERT INTO `t_sysrequestinfo` VALUES ('105000', '请求权限管理', 'system_mgr/sys_request_mgr.jsp', '105000');
INSERT INTO `t_sysrequestinfo` VALUES ('105001', '添加/修改请求权限', 'system_mgr/url_request_save.jsp', '105001');
INSERT INTO `t_sysrequestinfo` VALUES ('105002', '删除请求权限', 'system_mgr/url_request_delete.jsp', '105002');
INSERT INTO `t_sysrequestinfo` VALUES ('201000', '服务器管理', 'game_server_mgr/game_server_mgr.jsp', '201000');
INSERT INTO `t_sysrequestinfo` VALUES ('201001', '添加服务器', 'game_server_mgr/url_server_add.jsp', '201001');
INSERT INTO `t_sysrequestinfo` VALUES ('201002', '删除服务器', 'game_server_mgr/url_server_delete.jsp', '201002');
INSERT INTO `t_sysrequestinfo` VALUES ('201003', '修改服务器', 'game_server_mgr/url_server_modify.jsp', '201003');
INSERT INTO `t_sysrequestinfo` VALUES ('201004', '停服', 'game_server_mgr/url_server_stop.jsp', '201004');
INSERT INTO `t_sysrequestinfo` VALUES ('201005', '重载缓存', 'game_server_mgr/url_game_cache_load.jsp', '201005');
INSERT INTO `t_sysrequestinfo` VALUES ('202000', '渠道管理', 'game_server_mgr/game_partner_mgr.jsp', '202000');
INSERT INTO `t_sysrequestinfo` VALUES ('202001', '添加/修改渠道', 'game_server_mgr/url_partner_save.jsp', '202001');
INSERT INTO `t_sysrequestinfo` VALUES ('202002', '删除渠道', 'game_server_mgr/url_partner_delete.jsp', '202002');
INSERT INTO `t_sysrequestinfo` VALUES ('203000', 'Web管理', 'game_server_mgr/game_web_refresh_mgr.jsp', '203000');
INSERT INTO `t_sysrequestinfo` VALUES ('203001', '添加/修改Web刷新', 'game_server_mgr/url_web_refresh_save.jsp', '203001');
INSERT INTO `t_sysrequestinfo` VALUES ('203002', '删除Web刷新', 'game_server_mgr/url_web_refresh_delete.jsp', '203002');
INSERT INTO `t_sysrequestinfo` VALUES ('203003', '刷新Web缓存', 'game_server_mgr/url_web_refresh.jsp', '203003');
INSERT INTO `t_sysrequestinfo` VALUES ('301000', '玩家管理', 'game_player_mgr/game_player_mgr.jsp', '301000');
INSERT INTO `t_sysrequestinfo` VALUES ('301001', '玩家禁言/封号', 'game_player_mgr/url_ban_account.jsp', '301001');
INSERT INTO `t_sysrequestinfo` VALUES ('302000', '伙伴管理', 'game_player_mgr/game_hero_mgr.jsp', '302000');
INSERT INTO `t_sysrequestinfo` VALUES ('303000', '装备管理', 'game_player_mgr/game_equip_mgr.jsp', '303000');
INSERT INTO `t_sysrequestinfo` VALUES ('304000', '武魂管理', 'game_player_mgr/game_eternal_mgr.jsp', '304000');
INSERT INTO `t_sysrequestinfo` VALUES ('305000', '道具管理', 'game_player_mgr/game_prop_mgr.jsp', '305000');
INSERT INTO `t_sysrequestinfo` VALUES ('306000', '聊天监控', 'game_player_mgr/game_chat_monitor_mgr.jsp', '306000');
INSERT INTO `t_sysrequestinfo` VALUES ('401000', 'GM管理', 'game_operate_mgr/game_gm_mgr.jsp', '401000');
INSERT INTO `t_sysrequestinfo` VALUES ('401001', '修改玩家信息', 'game_operate_mgr/url_gm_modify.jsp', '401001');
INSERT INTO `t_sysrequestinfo` VALUES ('402000', '邮件申请', 'game_operate_mgr/game_mail_apply_mgr.jsp', '402000');
INSERT INTO `t_sysrequestinfo` VALUES ('402001', '提交邮件申请', 'game_operate_mgr/url_sysmail_apply.jsp', '402001');
INSERT INTO `t_sysrequestinfo` VALUES ('403000', '邮件审核', 'game_player_mgr/game_mail_auditing_mgr.jsp', '403000');
INSERT INTO `t_sysrequestinfo` VALUES ('403001', '审核邮件申请', 'game_operate_mgr/url_sysmail_auditing.jsp', '403001');
INSERT INTO `t_sysrequestinfo` VALUES ('403002', '删除邮件申请', 'game_operate_mgr/url_sysmail_delete.jsp', '403002');
INSERT INTO `t_sysrequestinfo` VALUES ('403003', '刷新发放状态', 'game_operate_mgr/url_sysmail_flush.jsp', '403003');
INSERT INTO `t_sysrequestinfo` VALUES ('404000', '邮件管理', 'game_operate_mgr/game_mail_mgr.jsp', '404000');
INSERT INTO `t_sysrequestinfo` VALUES ('404001', '删除系统邮件', 'game_operate_mgr/url_mail_delete.jsp', '404001');
INSERT INTO `t_sysrequestinfo` VALUES ('405000', 'CDKEY生成', 'game_operate_mgr/game_cdkey_generate_mgr.jsp', '405000');
INSERT INTO `t_sysrequestinfo` VALUES ('405001', '生成CDKEY', 'game_operate_mgr/url_cdkey_generate.jsp', '405001');
INSERT INTO `t_sysrequestinfo` VALUES ('406000', 'CDKEY管理', 'game_operate_mgr/game_cdkey_mgr.jsp', '406000');
INSERT INTO `t_sysrequestinfo` VALUES ('406001', '激活CDKEY', 'game_operate_mgr/url_cdkey_activated.jsp', '406001');
INSERT INTO `t_sysrequestinfo` VALUES ('406002', '删除CDKEY', 'game_operate_mgr/url_cdkey_delete.jsp', '406002');
INSERT INTO `t_sysrequestinfo` VALUES ('406003', '下载CDKEY', 'game_operate_mgr/download_game_cdkey.jsp', '406003');
INSERT INTO `t_sysrequestinfo` VALUES ('407000', 'CDKEY记录', 'game_operate_mgr/game_cdkey_record_mgr.jsp', '407000');
INSERT INTO `t_sysrequestinfo` VALUES ('408000', '充值订单管理', 'game_operate_mgr/game_recharge_mgr.jsp', '408000');
INSERT INTO `t_sysrequestinfo` VALUES ('408001', '订单发货', 'game_operate_mgr/url_bill_resend.jsp', '408001');
INSERT INTO `t_sysrequestinfo` VALUES ('409000', '发送系统公告', 'game_operate_mgr/game_send_notice_mgr.jsp', '409000');
INSERT INTO `t_sysrequestinfo` VALUES ('501000', '数据总览', 'game_stats_mgr/game_pandect_mgr.jsp', '501000');
INSERT INTO `t_sysrequestinfo` VALUES ('502000', '创角统计', 'game_stats_mgr/game_register_report_mgr.jsp', '502000');
INSERT INTO `t_sysrequestinfo` VALUES ('503000', '在线统计', 'game_stats_mgr/game_online_report_mgr.jsp', '503000');
INSERT INTO `t_sysrequestinfo` VALUES ('504000', '最高在线统计', 'game_stats_mgr/game_max_online_report_mgr.jsp', '504000');
INSERT INTO `t_sysrequestinfo` VALUES ('505000', '在线时长统计', 'game_stats_mgr/game_duration_mgr.jsp', '505000');
INSERT INTO `t_sysrequestinfo` VALUES ('506000', '首登时长统计', 'game_stats_mgr/game_first_duration_mgr.jsp', '506000');
INSERT INTO `t_sysrequestinfo` VALUES ('507000', '二次登录统计', 'game_stats_mgr/game_twice_login_mgr.jsp', '507000');
INSERT INTO `t_sysrequestinfo` VALUES ('508000', '留存统计', 'game_stats_mgr/game_keep_mgr.jsp', '508000');
INSERT INTO `t_sysrequestinfo` VALUES ('509000', '等级流失统计', 'game_stats_mgr/game_level_loss_mgr.jsp', '509000');
INSERT INTO `t_sysrequestinfo` VALUES ('510000', '关卡流失统计', 'game_stats_mgr/game_battle_loss_mgr.jsp', '510000');
INSERT INTO `t_sysrequestinfo` VALUES ('511000', '充值总汇', 'game_stats_mgr/game_recharge_summary_mgr.jsp', '511000');
INSERT INTO `t_sysrequestinfo` VALUES ('512000', '充值明细', 'game_stats_mgr/game_recharge_details_mgr.jsp', '512000');
INSERT INTO `t_sysrequestinfo` VALUES ('513000', '充值额度统计', 'game_stats_mgr/game_recharge_quota_mgr.jsp', '513000');
INSERT INTO `t_sysrequestinfo` VALUES ('514000', '充值排名统计', 'game_stats_mgr/game_recharge_rank_mgr.jsp', '514000');
INSERT INTO `t_sysrequestinfo` VALUES ('601000', '登录日志', 'game_log_mgr/game_login_log_mgr.jsp', '601000');
INSERT INTO `t_sysrequestinfo` VALUES ('602000', '钻石日志', 'game_log_mgr/game_money_log_mgr.jsp', '602000');
INSERT INTO `t_sysrequestinfo` VALUES ('603000', '金币日志', 'game_log_mgr/game_gold_log_mgr.jsp', '603000');
INSERT INTO `t_sysrequestinfo` VALUES ('604000', '经验日志', 'game_log_mgr/game_exp_log_mgr.jsp', '604000');
INSERT INTO `t_sysrequestinfo` VALUES ('605000', '体力日志', 'game_log_mgr/game_stamina_log_mgr.jsp', '605000');
INSERT INTO `t_sysrequestinfo` VALUES ('606000', '石板日志', 'game_log_mgr/game_slate_log_mgr.jsp', '606000');
INSERT INTO `t_sysrequestinfo` VALUES ('607000', '伙伴经验池经验', 'game_log_mgr/game_hero_exp_pool_mgr.jsp', '607000');
INSERT INTO `t_sysrequestinfo` VALUES ('608000', '灵气日志', 'game_log_mgr/game_gp_log_mgr.jsp', '608000');
INSERT INTO `t_sysrequestinfo` VALUES ('609000', '道具日志', 'game_log_mgr/game_prop_log_mgr.jsp', '609000');
INSERT INTO `t_sysrequestinfo` VALUES ('610000', '伙伴日志', 'game_log_mgr/game_hero_log_mgr.jsp', '610000');
INSERT INTO `t_sysrequestinfo` VALUES ('611000', '装备日志', 'game_log_mgr/game_equip_log_mgr.jsp', '611000');
INSERT INTO `t_sysrequestinfo` VALUES ('612000', '武魂日志', 'game_log_mgr/game_eternal_log_mgr.jsp', '612000');

-- ----------------------------
-- Table structure for t_sysusergroupinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_sysusergroupinfo`;
CREATE TABLE `t_sysusergroupinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `n_jurisdictions` text CHARACTER SET utf8 NOT NULL,
  `n_type` int(11) NOT NULL COMMENT '类型',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_sysusergroupinfo
-- ----------------------------
INSERT INTO `t_sysusergroupinfo` VALUES ('1', '超级管理员', '', '1');
INSERT INTO `t_sysusergroupinfo` VALUES ('2', '普通用户', '200000,201000,201005,202000,203000,203003,300000,301000,301001,302000,303000,304000,305000,306000,400000,402000,402001,404000,404001,405000,405001,406000,406003,407000,408000,500000,501000,502000,503000,504000,505000,506000,507000,508000,509000,510000,511000,512000,513000,514000,600000,601000,602000,603000,604000,605000,606000,607000,609000,610000,611000,612000', '2');

-- ----------------------------
-- Table structure for t_sysuserinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_sysuserinfo`;
CREATE TABLE `t_sysuserinfo` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_username` varchar(50) COLLATE utf8_bin NOT NULL,
  `n_password` varchar(50) COLLATE utf8_bin NOT NULL,
  `n_userGroupId` int(11) NOT NULL COMMENT '用户组id',
  `n_note` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '备注',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_sysuserinfo
-- ----------------------------
INSERT INTO `t_sysuserinfo` VALUES ('1', 'admin', '21232F297A57A5A743894A0E4A801FC3', '1', '');
INSERT INTO `t_sysuserinfo` VALUES ('2', 'qz01', '81DC9BDB52D04DC20036DBD8313ED055', '2', '密码：1234');
