
#2016.03.02
create table t_zone_battle_logger(id int(11) not null primary key auto_increment,
zoneId int(11) not null comment '章节id',
zoneBattleId int(11) not null comment '副本id',
userId int(11) not null comment '玩家id',
firstState int(11) not null comment '首次战斗状态',
state int(11) not null comment '当前战斗状态',
battleNum int(11) not null comment '通关次数',
createTime int(11) not null comment '创建时间',
updateTime int(11) not null comment '更新时间');
alter table t_zone_battle_logger add index selectZone(zoneBattleId, userId);

#2016.03.18
alter table t_diamond_logger add playername varchar(50) default '' not null comment '玩家昵称';
alter table t_equipment_logger add playername varchar(50) default '' not null comment '玩家昵称';
alter table t_eternal_logger add playername varchar(50) default '' not null comment '玩家昵称';
alter table t_exp_logger add playername varchar(50) default '' not null comment '玩家昵称';
alter table t_gold_logger add playername varchar(50) default '' not null comment '玩家昵称';
alter table t_gp_logger add playername varchar(50) default '' not null comment '玩家昵称';
alter table t_hero_exp_pool_logger add playername varchar(50) default '' not null comment '玩家昵称';
alter table t_hero_logger add playername varchar(50) default '' not null comment '玩家昵称';
alter table t_prop_logger add playername varchar(50) default '' not null comment '玩家昵称';
alter table t_slate_logger add playername varchar(50) default '' not null comment '玩家昵称';
alter table t_stamina_logger add playername varchar(50) default '' not null comment '玩家昵称';

#2016.03.18
truncate t_user_guide_step;
alter table t_user_guide_step drop user_id;
alter table t_user_guide_step change guide_id guide_ids varchar(1024) not null comment '引导';
alter table t_user_guide_step add update_time int(11) not null comment '引导更新时间';

#2016.03.29
alter table t_user add smelting_exp int(11) not null comment '熔炼池经验';
alter table t_user add add_smelting_val int(11) not null comment '熔炼池增加上限值';
drop table t_eternal_smelting;

#2016.03.31
alter table t_user_stat add last_black_refresh_time int(11) not null comment '上一次自动刷新黑市时间';