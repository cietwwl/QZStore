
## 2015.10.23
ALTER TABLE t_eternal_smelting ADD COLUMN addEternalVal int(10) NOT NULL DEFAULT 0 AFTER val;

## 2015.10.23
DROP TABLE IF EXISTS t_achieve;
DROP TABLE IF EXISTS t_achieve_award;
DROP TABLE IF EXISTS t_activity_zone;
DROP TABLE IF EXISTS t_arena_award;
DROP TABLE IF EXISTS t_arena_buy;
DROP TABLE IF EXISTS t_arena_condition;
DROP TABLE IF EXISTS t_arena_exp;
DROP TABLE IF EXISTS t_blowing_rule;
DROP TABLE IF EXISTS t_call_hero;
DROP TABLE IF EXISTS t_call_hero_rule;
DROP TABLE IF EXISTS t_drop;
DROP TABLE IF EXISTS t_equipment;
DROP TABLE IF EXISTS t_equipment_property;
DROP TABLE IF EXISTS t_equipment_up;
DROP TABLE IF EXISTS t_equipment_up_rate;
DROP TABLE IF EXISTS t_eternal;
DROP TABLE IF EXISTS t_eternal_effect;
DROP TABLE IF EXISTS t_eternal_property;
DROP TABLE IF EXISTS t_explore_award;
DROP TABLE IF EXISTS t_fame;
DROP TABLE IF EXISTS t_fame_award;
DROP TABLE IF EXISTS t_fame_buff;
DROP TABLE IF EXISTS t_guild_rank_award;
DROP TABLE IF EXISTS t_hero;
DROP TABLE IF EXISTS t_hero_break_attr_setting;
DROP TABLE IF EXISTS t_hero_break_setting;
DROP TABLE IF EXISTS t_hero_evo;
DROP TABLE IF EXISTS t_hero_evo_material;
DROP TABLE IF EXISTS t_hero_ralation;
DROP TABLE IF EXISTS t_hero_rule;
DROP TABLE IF EXISTS t_mall;
DROP TABLE IF EXISTS t_mall_goods;
DROP TABLE IF EXISTS t_martial_way_award;
DROP TABLE IF EXISTS t_martial_exp;
DROP TABLE IF EXISTS t_monster;
DROP TABLE IF EXISTS t_monster_atk_mode;
DROP TABLE IF EXISTS t_passive_skill;
DROP TABLE IF EXISTS t_prop;
DROP TABLE IF EXISTS t_prop_effect;
DROP TABLE IF EXISTS t_signin;
DROP TABLE IF EXISTS t_skill;
DROP TABLE IF EXISTS t_skill_effect;
DROP TABLE IF EXISTS t_sum_signin;
DROP TABLE IF EXISTS t_task_action_setting;
DROP TABLE IF EXISTS t_task_box_reward;
DROP TABLE IF EXISTS t_task_reward;
DROP TABLE IF EXISTS t_task_setting;
DROP TABLE IF EXISTS t_user_rule;
DROP TABLE IF EXISTS t_vip_gifi;
DROP TABLE IF EXISTS t_vip_login_award;
DROP TABLE IF EXISTS t_vip_state;
DROP TABLE IF EXISTS t_zone;
DROP TABLE IF EXISTS t_zone_award;
DROP TABLE IF EXISTS t_zone_battle;
DROP TABLE IF EXISTS t_zone_battle_round;

#2015.10.26
DROP TABLE IF EXISTS t_martial_way_exp;

#2015.10.27
DROP TABLE IF EXISTS t_call_soul_rule;

#2015.10.30
#注册流失
create table t_regist_loss_logger (id int(11) not null primary key auto_increment,
type int(11) not null comment '类型',
username varchar(50) not null comment '用户名称',
partner int(11) not null comment '平台编号',
time int(11) not null comment '时间');
#在线统计
create table t_online_report_logger (id int(11) not null primary key auto_increment,
amount int(11) not null comment '在线人数',
time int(11) not null comment '时间');

alter table t_user add online int(11) not null comment '是否在线';
alter table t_user add firstOnlineTime int(11) not null comment '首次在线时长';
alter table t_user add dailyOnlineTime int(11) not null comment '每日在线时长';

#2015.11.02
DROP TABLE IF EXISTS t_arena_rival;

#2015.11.02
create table t_sys_mail(id int(11) not null primary key auto_increment,
partner int(11) not null comment '平台编号',
sendType int(11) not null comment '发送类型',
endId int(11) not null comment '结束id',
uids text not null comment '可领取ids',
title varchar(50) not null comment '标题',
content varchar(512) not null comment '内容',
items varchar(225) not null comment '物品',
startTime int(11) not null comment '开始时间',
endTime int(11) not null comment '结束时间',
time int(11) not null comment '发送时间');

create table t_user_record(id int(11) not null comment '玩家id' primary key,
sysMailIds text not null comment '已领取系统邮件ids');

alter table t_user add banChatTime int(11) not null comment '禁言结束时间';
alter table t_user add banLoginTime int(11) not null comment '封号结束时间';
alter table t_user add accessTime int(11) not null comment '访问时间';

#2015.11.06
alter table t_user_stat change draw_vip_gifis draw_vip_gifis varchar(255) default '';
update t_user_stat set draw_vip_gifis='';

#2015.11.10
alter table t_user change renamed renamed tinyint(1) default '0';

#2015.11.12
alter table t_diamond_logger add originalAmount int not null comment '原有数量';
alter table t_diamond_logger add surplusAmount int not null comment '剩余数量';
alter table t_equipment_logger add originalAmount int not null comment '原有数量';
alter table t_equipment_logger add surplusAmount int not null comment '剩余数量';
alter table t_eternal_logger add originalAmount int not null comment '原有数量';
alter table t_eternal_logger add surplusAmount int not null comment '剩余数量';
alter table t_exp_logger add originalAmount int not null comment '原有数量';
alter table t_exp_logger add surplusAmount int not null comment '剩余数量';
alter table t_gold_logger add originalAmount int not null comment '原有数量';
alter table t_gold_logger add surplusAmount int not null comment '剩余数量';
alter table t_gp_logger add originalAmount int not null comment '原有数量';
alter table t_gp_logger add surplusAmount int not null comment '剩余数量';
alter table t_hero_exp_pool_logger add originalAmount int not null comment '原有数量';
alter table t_hero_exp_pool_logger add surplusAmount int not null comment '剩余数量';
alter table t_hero_logger add originalAmount int not null comment '原有数量';
alter table t_hero_logger add surplusAmount int not null comment '剩余数量';
alter table t_prop_logger add originalAmount int not null comment '原有数量';
alter table t_prop_logger add surplusAmount int not null comment '剩余数量';
alter table t_slate_logger add originalAmount int not null comment '原有数量';
alter table t_slate_logger add surplusAmount int not null comment '剩余数量';
alter table t_stamina_logger add originalAmount int not null comment '原有数量';
alter table t_stamina_logger add surplusAmount int not null comment '剩余数量';

#2015.11.16
create table t_login_logger(id int(11) not null primary key auto_increment,
userId int(11) not null comment '玩家id',
playername varchar(50) not null comment '玩家昵称',
type int(11) not null comment '登录类型',
time int(11) not null comment '产生时间');

alter table t_user add vip int(11) default 0 not null comment 'vip等级';

#配置表
alter table t_prop change sell sell tinyint(1) default 0;
alter table t_prop change `use` `use` tinyint(1) default 0;

#2015.11.17
alter table t_user_stat add breadStoreCount int(11) not null comment '包子铺已参加次数';
alter table t_user_stat add godWealthCount int(11) not null comment '财神殿已参加次数';
alter table t_user_stat add animaTempleCount int(11) not null comment '灵气殿已参加次数';

#2015.11.17
alter table t_user add fighting int(11) not null default 0 comment '战斗力';
	
#2015.11.26
alter table t_user_stat add breadStoreFreeRefreshCount int(11) not null comment '已使用包子铺免费刷新次数';
alter table t_user_stat add breadStoreDiamondRefreshCount int(11) not null comment '已使用包子铺钻石刷新次数';
alter table t_user_stat add breadStoreZones varchar(128) default '' not null comment '包子铺副本';
alter table t_user_record add commonRewards text not null comment '通用奖励';
#cfg
drop table t_vip_gifi;
drop table t_vip_login_award;
drop table t_vip_state;
alter table t_prop add expendItems varchar(255) default '' not null;
alter table t_prop add gainItems varchar(255) default '' not null;

#2015.12.01
alter table t_user_stat add firstCallHero tinyint(1) not null comment '是否已首次钻石召唤';

#2015.12.03
alter table t_hero_logger modify description varchar(255) default '' not null comment '描述';

#2015.12.07
#qz
alter table t_user_stat add cycleCards varchar(255) default '' not null comment '周期卡';
alter table t_user_record add firstRecharges varchar(255) default '' not null comment '首次充值';

#2015.12.08
#qz
alter table t_user_prop_0 drop primary key;
alter table t_user_prop_1 drop primary key;
alter table t_user_prop_2 drop primary key;
alter table t_user_prop_3 drop primary key;
alter table t_user_prop_4 drop primary key;
alter table t_user_prop_5 drop primary key;
alter table t_user_prop_6 drop primary key;
alter table t_user_prop_7 drop primary key;
alter table t_user_prop_8 drop primary key;
alter table t_user_prop_9 drop primary key;
alter table t_user_prop_0 add id int(11) AUTO_INCREMENT PRIMARY KEY comment '主键id';
alter table t_user_prop_1 add id int(11) AUTO_INCREMENT PRIMARY KEY comment '主键id';
alter table t_user_prop_2 add id int(11) AUTO_INCREMENT PRIMARY KEY comment '主键id';
alter table t_user_prop_3 add id int(11) AUTO_INCREMENT PRIMARY KEY comment '主键id';
alter table t_user_prop_4 add id int(11) AUTO_INCREMENT PRIMARY KEY comment '主键id';
alter table t_user_prop_5 add id int(11) AUTO_INCREMENT PRIMARY KEY comment '主键id';
alter table t_user_prop_6 add id int(11) AUTO_INCREMENT PRIMARY KEY comment '主键id';
alter table t_user_prop_7 add id int(11) AUTO_INCREMENT PRIMARY KEY comment '主键id';
alter table t_user_prop_8 add id int(11) AUTO_INCREMENT PRIMARY KEY comment '主键id';
alter table t_user_prop_9 add id int(11) AUTO_INCREMENT PRIMARY KEY comment '主键id';

#2015.12.09
delete from t_user_prop_1 where num = 0;
delete from t_user_prop_2 where num = 0;
delete from t_user_prop_3 where num = 0;
delete from t_user_prop_4 where num = 0;
delete from t_user_prop_5 where num = 0;
delete from t_user_prop_6 where num = 0;
delete from t_user_prop_7 where num = 0;
delete from t_user_prop_8 where num = 0;
delete from t_user_prop_9 where num = 0;
delete from t_user_prop_0 where num = 0;

## 2015.12.10
ALTER TABLE t_user_daily_task ADD COLUMN hasDisTinctIds VARCHAR(100) NOT NULL DEFAULT '' AFTER rewardedTaskIds;
ALTER TABLE t_user_renown_task ADD COLUMN hasDisTinctIds VARCHAR(100) NOT NULL DEFAULT '' AFTER rewardedTaskIds;

#2015.12.11
alter table t_user_stat drop signin_month;
alter table t_user_stat drop last_ref_time;
alter table t_user_stat change today_euqip_level_up_count today_equip_count_level int(11) not null comment '今日装备累计提升等级';
alter table t_user_stat change today_hero_level_up_count today_hero_count_level int(11) not null comment '今日伙伴累计提升等级';
alter table t_user_stat change euqip_level_up_count equip_count_level int(11) not null comment '装备累计提升等级';
alter table t_user_stat change hero_level_up_count hero_count_level int(11) not null comment '伙伴累计提升等级';

#2015.12.14
alter table t_user modify username varchar(50) binary not null comment '用户名';
alter table t_user modify player_name varchar(50) binary not null comment '玩家名';

#2015.12.16
alter table t_user_record add trialsIds varchar(255) default'' not null comment '试练记录';

#2016.01.11
alter table t_user_stat add arena_refresh_count int(11) not null comment '刷新商店次数';
update t_user_stat set arena_count = 5;
alter table t_arena drop challenge_count;
alter table t_arena drop buy_count;
alter table t_arena drop refresh_count;
alter table t_arena add index(win_count);
alter table t_arena add index(max_win_streak);
