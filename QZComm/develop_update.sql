
create table t_pay_bill(id int(11) not null primary key auto_increment,
partner int(11) not null comment '平台编号',
serverId varchar(50) not null comment '服务器id',
userId int(11) not null comment '玩家id',
username varchar(50) not null comment '帐号',
playername varchar(50) not null comment '玩家昵称',
level int(11) not null comment '玩家等级',
payGoodsId int(11) not null comment '支付商品编号',
bill varchar(50) not null comment '订单编号',
state int(11) not null comment '发货状态',
time int(11) not null comment '订单创建时间',
lastTime int(11) not null comment '最后一次操作时间');