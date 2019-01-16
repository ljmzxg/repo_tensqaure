#1������΢����
CREATE DATABASE IF NOT EXISTS tensquare_base DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS `tensquare_base`.`tb_label`(
   `id` VARCHAR(20) NOT NULL,
   `labelname` VARCHAR(100),
   `state` VARCHAR(1),
   `count` BIGINT(20),
   `recommend` VARCHAR(1),
   `fans` BIGINT(20),
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#2����Ƹ΢����
CREATE DATABASE IF NOT EXISTS tensquare_recruit DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
#2.1 ��ҵ��
CREATE TABLE IF NOT EXISTS `tensquare_recruit`.`tb_enterprise`(
   `id` VARCHAR(20) NOT NULL,
   `name` VARCHAR(100) COMMENT '��ҵ����',
   `summary` VARCHAR(100) COMMENT '��ҵ���' ,
   `address` VARCHAR(100) COMMENT '��ҵ��ַ',
   `labels` VARCHAR(200) COMMENT '��ǩ�б��� �ö��Ÿ���',
   `coordinate` VARCHAR(100) COMMENT '����',
   `ishot` VARCHAR(1) COMMENT '�Ƿ����� 0(������)��1(����)',
   `logo` VARCHAR(100) COMMENT 'LOGO',
   `jobcount` int(4) COMMENT 'ְλ��',
   `url` VARCHAR(200) COMMENT '��ҵ��ַ',
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#2.2 ��Ƹ��
CREATE TABLE IF NOT EXISTS `tensquare_recruit`.`tb_recruit`(
   `id` VARCHAR(20) NOT NULL,
   `jobname` VARCHAR(100) COMMENT 'ְλ����',
   `salary` VARCHAR(100) COMMENT 'н�ʷ�Χ' ,
   `condition` VARCHAR(100) COMMENT '����Ҫ��',
   `education` VARCHAR(100) COMMENT 'ѧ��Ҫ��',
   `type` VARCHAR(1) COMMENT '��ְ��ʽ',
   `address` VARCHAR(100) COMMENT '�칫��ַ',
   `eid` VARCHAR(20) COMMENT '��ҵid',
   `createtime` timestamp COMMENT '��������',
   `state` VARCHAR(1) COMMENT '״̬��0���رգ� 1�������� 2���Ƽ���',
   `url` VARCHAR(200) COMMENT 'ԭ��ַ',
   `label` VARCHAR(100) COMMENT '��ǩ',
   `content1` VARCHAR(1000) COMMENT 'ְλ����',
   `content2` VARCHAR(1000) COMMENT 'ְλҪ��',
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#3���ʴ�΢����
CREATE DATABASE IF NOT EXISTS tensquare_qa DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
#3.1 �м��tb_pl������problem & label
CREATE TABLE IF NOT EXISTS `tensquare_qa`.`tb_pl`(
   `problemid` VARCHAR(20) NOT NULL COMMENT '����ID',
   `labelid` VARCHAR(20) NOT NULL COMMENT '��ǩID',
   PRIMARY KEY (`problemid`,`labelid`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#3.2 problem ��
CREATE TABLE IF NOT EXISTS `tensquare_qa`.`tb_problem`(
   `id` VARCHAR(20) NOT NULL COMMENT '����ID',
   `title` VARCHAR(100) COMMENT '����',
   `content` TEXT COMMENT '����',
   `createtime` DATETIME COMMENT '��������',
   `updatetime` DATETIME COMMENT '�޸�����',
   `userid` VARCHAR(20) COMMENT '�û�ID',
   `nickname` VARCHAR(100) COMMENT '�ǳ�',
   `visits` BIGINT(20) COMMENT '�����',
   `thumbup` BIGINT(20) COMMENT '������',
   `reply` BIGINT(20) COMMENT '�ظ���',
   `solve` VARCHAR(1) COMMENT '�Ƿ���',
   `replyname` VARCHAR(100) COMMENT '�ظ����ǳ�',
   `replytime` DATETIME COMMENT '�ظ�����',
   PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#3.3 �ظ��� tb_reply
CREATE TABLE IF NOT EXISTS `tensquare_qa`.`tb_reply`(
   `id` VARCHAR(20) NOT NULL COMMENT '�ظ�ID',
   `problemid` VARCHAR(20) COMMENT '����ID',
   `content` TEXT COMMENT '�ظ�����',
   `createtime` DATETIME COMMENT '��������',
   `updatetime` DATETIME COMMENT '�޸�����',
   `userid` VARCHAR(20) COMMENT '�ظ���ID',
   `nickname` VARCHAR(100) COMMENT '�ǳ�',
   PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#4������΢����

#5�����洦��






