drop table if exists `test`;
drop table if exists `ebook`;
create table `test` (
                        `id` bigint not null comment 'id',
                        `name` varchar(50) comment '名称',
                        `password` varchar(50) comment '密码',
                        primary key (`id`)
) engine = innodb default charset = utf8mb4 comment '测试';
create table `ebook` (
                         `id` bigint not null comment 'id',
                         `name` varchar(50) comment '名称',
                         `category1_id` bigint comment '分类1',
                         `category2_id` bigint comment '分类2',
                         `description` varchar(200) comment '描述',
                         `cover` varchar(200) comment '封面',
                         `doc_count` int comment '文档数',
                         `view_count` int comment '阅读数',
                         `vote_count` int comment '点赞数',
                         primary key (`id`)
) engine = innodb default charset = utf8mb4 comment '电子书';
insert into `test` (id , name , password ) values (1,'xugy','123456');
insert into `test` (id , name , password ) values (2,'whuan','123456');
insert into `ebook`(id,name,description) values (1,'Springboot入门教程','0基础入门Java开发,企业级应用首选开发框架');
insert into `ebook`(id,name,description) values (2,'Vue入门教程','0基础入门Vue开发,企业级应用首选开发框架');