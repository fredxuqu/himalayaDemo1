--------------------------------------------------------
--  文件已创建 - 星期四-十一月-30-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TB_TAGS
--------------------------------------------------------

  CREATE TABLE "SCOTT"."TB_TAGS" 
   (	"ID" NUMBER(10,0), 
	"TAG_NAME" VARCHAR2(200 BYTE), 
	"TYPE" NUMBER(10,0), 
	"STATUS" NUMBER(10,0), 
	"RANK" NUMBER(10,0), 
	"CREATE_TIME" DATE DEFAULT sysdate, 
	"CREATE_USER" VARCHAR2(30 BYTE), 
	"MODIFY_TIME" DATE, 
	"MODIFY_USER" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into SCOTT.TB_TAGS
SET DEFINE OFF;
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1111,'fooaaa want to lijiang and visit lijiang hotel',2,1,0,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1112,'baraaa want to lijiang and visit lijiang hotel',2,2,100,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1113,'bazaaa want to lijiang and visit lijiang hotel',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1114,'bazzsaa want to lijiang and visit lijiang hotel',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1121,'约好友去深圳市政府上班',2,1,0,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1122,'约好友去鹏城律师事务所',2,2,100,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1123,'来了就是深圳人简直是废话',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1131,'长沙市人民政府办公厅',2,1,0,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1132,'长沙县公共关系科',2,2,100,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1133,'新长沙强南富北',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1141,'南京市出入境办公室',2,1,0,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1142,'金陵十三衩',2,2,100,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1143,'建康是宋朝的',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1151,'pixima 金陵十三衩',2,2,100,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1152,'建康 pixma 是宋朝的',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1134,'星城闪耀于湘湖大地',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1144,'天京是太平天国时期的都城',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1161,'中国民生银行金陵支行',2,2,100,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1162,'中国民生银行建康支行',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1171,'深圳鹏元征信有限公司',2,2,100,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1172,'深圳市鹏元征信有限公司',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1173,'鹏城鹏元征信有限公司',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1135,'回老家开一家培训机构',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1136,'浏阳烟花爆竹生产基地',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1181,'鹏元征信有限公司长沙分公司',2,2,100,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1182,'鹏元征信有限公司长沙市办事处',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1183,'鹏元征信有限公司长沙市分公司',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (45,'长沙市开福区中联重科股份有限公司长沙开福分公司',1,1,2,to_date('16-5月 -17','DD-MON-RR'),null,to_date('16-5月 -17','DD-MON-RR'),null);
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (46,'长沙开福中联重科股份有限公司',1,1,2,to_date('16-5月 -17','DD-MON-RR'),null,to_date('16-5月 -17','DD-MON-RR'),null);
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (47,'长沙市开福区中联重科股份有限公司',1,1,2,to_date('16-5月 -17','DD-MON-RR'),null,to_date('16-5月 -17','DD-MON-RR'),null);
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (1,'找个女票回家过年',2,1,0,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (2,'找个女票去丽江',2,2,100,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (3,'去丽江旅游过年',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (4,'去云南旅游',1,2,10000,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (5,'开车去西藏',1,2,10001,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (6,'回家陪父母过年',2,2,20000,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (7,'去日本过年',2,3,0,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (8,'去美国过圣诞节',2,3,0,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (9,'找个女票过圣诞节',2,3,0,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (10,'开一家咖啡馆',2,2,100,to_date('06-3月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (11,'开一家培训机构',2,2,100,to_date('06-3月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (12,'当一名java老师',2,2,100,to_date('06-3月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (13,'当一名导游',2,2,101,to_date('06-3月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (14,'开一家咖啡馆',2,2,100,to_date('06-3月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (15,'开一家培训机构',2,2,100,to_date('06-3月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (16,'深圳政通有限公司',2,1,0,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (17,'深圳政通科技有限公司',2,2,100,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (18,'深圳政新通科技有限公司',2,2,200,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (19,'政通科技深圳有限公司',1,2,10000,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (20,'政通贸易有限公司',1,2,10001,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (21,'深圳政通人力资源有限公司',2,2,20000,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (22,'农业银行福',2,3,0,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (23,'中国',2,3,1,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (24,'美国人民',2,3,1,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (25,'中国农业银行舟山支行',2,2,100,to_date('06-3月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (26,'中国农业银行',2,2,100,to_date('06-3月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (27,'中国农业银行广东总行',2,2,100,to_date('06-3月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (28,'深圳政通通讯有限公司',2,2,101,to_date('06-3月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (29,'中国农业银行总行',2,2,100,to_date('06-3月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (30,'农业银行福田支行',2,2,100,to_date('06-3月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (31,'中国很好，美国也不错',2,3,10,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (32,'chinese people',2,3,1,to_date('03-1月 -17','DD-MON-RR'),'admin',to_date('24-3月 -17','DD-MON-RR'),'admin');
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (33,'my god, you are chinese',1,1,1,to_date('16-5月 -17','DD-MON-RR'),null,to_date('16-5月 -17','DD-MON-RR'),null);
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (34,'you are chinese people',1,1,1,to_date('16-5月 -17','DD-MON-RR'),null,to_date('16-5月 -17','DD-MON-RR'),null);
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (35,'中国中国',1,1,1,to_date('16-5月 -17','DD-MON-RR'),null,to_date('16-5月 -17','DD-MON-RR'),null);
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (36,'美女美女美女',1,1,1,to_date('16-5月 -17','DD-MON-RR'),null,to_date('16-5月 -17','DD-MON-RR'),null);
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (37,'美女美女',1,1,1,to_date('16-5月 -17','DD-MON-RR'),null,to_date('16-5月 -17','DD-MON-RR'),null);
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (38,'美女',1,1,1,to_date('16-5月 -17','DD-MON-RR'),null,to_date('16-5月 -17','DD-MON-RR'),null);
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (39,'qu4 ba1 li2 dao3 lv3 you2',1,1,1,to_date('16-5月 -17','DD-MON-RR'),null,to_date('16-5月 -17','DD-MON-RR'),null);
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (40,'qu4 ba1 li2 lv3 you2',1,1,1,to_date('16-5月 -17','DD-MON-RR'),null,to_date('16-5月 -17','DD-MON-RR'),null);
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (41,'qu4 hai3 li2 dao3 lv3 you2',1,1,1,to_date('16-5月 -17','DD-MON-RR'),null,to_date('16-5月 -17','DD-MON-RR'),null);
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (42,'人民群众',1,1,1,to_date('16-5月 -17','DD-MON-RR'),null,to_date('16-5月 -17','DD-MON-RR'),null);
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (43,'美国人民',1,1,1,to_date('16-5月 -17','DD-MON-RR'),null,to_date('16-5月 -17','DD-MON-RR'),null);
Insert into SCOTT.TB_TAGS (ID,TAG_NAME,TYPE,STATUS,RANK,CREATE_TIME,CREATE_USER,MODIFY_TIME,MODIFY_USER) values (44,'中国人民解放军',1,1,2,to_date('16-5月 -17','DD-MON-RR'),null,to_date('16-5月 -17','DD-MON-RR'),null);
--------------------------------------------------------
--  DDL for Index SYS_C0016576
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."SYS_C0016576" ON "SCOTT"."TB_TAGS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table TB_TAGS
--------------------------------------------------------

  ALTER TABLE "SCOTT"."TB_TAGS" MODIFY ("TAG_NAME" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."TB_TAGS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
