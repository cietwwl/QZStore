alter table t_gamebillinfo add n_receiptDatas varchar(1024) default '' not null comment '支付凭证';
create table t_gamepartnerinfo(n_id int(11) not null primary key auto_increment,
n_name varchar(50) not null comment '名称',
n_payUrl varchar(512) not null comment '正式支付地址',
n_payDebugUrl varchar(512) not null comment '测试支付地址',
n_callbackUrl varchar(512) not null comment '回调地址',
n_privateKey varchar(512) not null comment '私钥',
n_publicKey varchar(512) not null comment '公钥');
drop table t_gamerechargeserverinfo;
create table t_gamerefreshinfo(n_id int(11) not null primary key auto_increment, 
n_name varchar(50) not null comment '名称',
n_type int(11) not null comment '类型',
n_refUrl varchar(512) not null comment '刷新地址');