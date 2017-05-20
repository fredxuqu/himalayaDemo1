
DROP DATABASE IF EXISTS mysql;
CREATE DATABASE mysql DEFAULT CHARACTER SET utf8;
USE mysql;
/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015-4-17 10:41:45                           */
/*==============================================================*/


drop table if exists tb_forum;

drop table if exists tb_post;

drop table if exists tb_topic;

/*==============================================================*/
/* Table: tb_forum                                               */
/*==============================================================*/
create table tb_forum
(
   forum_id             int(11) not null ,
   forum_name           varchar(150) not null default 'forum',
   forum_desc           varchar(255) default NULL,
   primary key (forum_id)
)
;

/*==============================================================*/
/* Table: tb_post                                                */
/*==============================================================*/
create table tb_post
(
   postb_id              int(11) not null ,
   topic_id             int(11) not null default 0,
   user_id              int(11) not null default 0,
   postb_text            text,
   postb_attach          blob,
   postb_time            datetime default NULL,
   primary key (postb_id)
);

/*==============================================================*/
/* Index: IDX_POStb_TOPIC_ID                                     */
/*==============================================================*/
create index IDX_POStb_TOPIC_ID on tb_post
(
   topic_id
);

/*==============================================================*/
/* Table: tb_topic                                               */
/*==============================================================*/
create table tb_topic
(
   topic_id             int(11) not null ,
   forum_id             int(11) not null default 0,
   topic_title          varchar(100) not null default '',
   user_id              int(11) not null default 0,
   topic_time           datetime default NULL,
   topic_views          int(11) default 1,
   topic_replies        int(11) default 0,
   primary key (topic_id)
);

/*==============================================================*/
/* Index: IDX_TOPIC_USER_ID                                     */
/*==============================================================*/
create index IDX_TOPIC_USER_ID on tb_topic
(
   user_id
);

/*==============================================================*/
/* Index: IDX_TOPIC_TITLE                                       */
/*==============================================================*/
create index IDX_TOPIC_TITLE on tb_topic
(
   topic_title
);

insert into tb_forum(forum_id,forum_name,forum_desc) values(1,'forum1','desc1');
insert into tb_forum(forum_id,forum_name,forum_desc) values(2,'forum2','desc2');

insert into tb_topic (topic_id,forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (1,1, '主题1', 1, '1-1-1 0:0:1', 166, 1);
insert into tb_topic (topic_id,forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (2,1, '主题2', 1, '1-1-1 0:0:0', 100, 49);
insert into tb_topic (topic_id,forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (3,2, '主题3', 1, '1-1-1 0:0:1', 130, 70);
insert into tb_topic (topic_id,forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (4,2, '主题4', 2, '1-1-1 0:0:2', 166, 22);
commit;
