/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.17-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `TB_TAGS` (
	`ID` int (11),
	`TAG_NAME` varchar (600),
	`TYPE` int (11),
	`STATUS` int (11),
	`RANK` int (11),
	`CREATE_TIME` datetime ,
	`CREATE_USER` varchar (90),
	`MODIFY_TIME` datetime ,
	`MODIFY_USER` varchar (90)
); 
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1','找个女票回家过年','2','1','0','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('2','找个女票去丽江','2','2','100','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('3','去丽江旅游过年','2','2','200','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('4','去云南旅游','1','2','10000','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('5','开车去西藏','1','2','10001','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('6','回家陪父母过年','2','2','20000','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('7','去日本过年','2','3','0','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('8','去美国过圣诞节','2','3','0','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('9','找个女票过圣诞节','2','3','0','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('16','深圳政通有限公司','2','1','0','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('17','深圳政通科技有限公司','2','2','100','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('18','深圳政新通科技有限公司','2','2','200','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('19','政通科技深圳有限公司','1','2','10000','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('20','政通贸易有限公司','1','2','10001','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('21','深圳政通人力资源有限公司','2','2','20000','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('22','农业银行福','2','3','0','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('23','中国','2','3','1','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('24','美国人民','2','3','1','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1121','约好友去深圳市政府上班','2','1','0','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1122','约好友去鹏城律师事务所','2','2','100','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1123','来了就是深圳人简直是废话','2','2','200','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1131','长沙市人民政府办公厅','2','1','0','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1132','长沙县公共关系科','2','2','100','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1133','新长沙强南富北','2','2','200','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1134','星城闪耀于湘湖大地','2','2','200','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1135','回老家开一家培训机构','2','2','200','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1136','浏阳烟花爆竹生产基地','2','2','200','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1141','南京市出入境办公室','2','1','0','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1142','金陵十三衩','2','2','100','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1143','建康是宋朝的','2','2','200','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1144','天京是太平天国时期的都城','2','2','200','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1151','pixima 金陵十三衩','2','2','100','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1152','建康 pixma 是宋朝的','2','2','200','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1161','中国民生银行金陵支行','2','2','100','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1162','中国民生银行建康支行','2','2','200','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1171','深圳鹏元征信有限公司','2','2','100','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1172','深圳市鹏元征信有限公司','2','2','200','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1173','鹏城鹏元征信有限公司','2','2','200','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1181','鹏元征信有限公司长沙分公司','2','2','100','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1182','鹏元征信有限公司长沙市办事处','2','2','200','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');
insert into `TB_TAGS` (`ID`, `TAG_NAME`, `TYPE`, `STATUS`, `RANK`, `CREATE_TIME`, `CREATE_USER`, `MODIFY_TIME`, `MODIFY_USER`) values('1183','鹏元征信有限公司长沙市分公司','2','2','200','2017-03-11 00:00:00','admin','2017-03-11 00:00:00','admin');


/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.17-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `TB_NEWS` (
	`ID` int (10),
	`TITLE` varchar (300),
	`CONTENT` varchar (12000),
	`AUTHER` varchar (300),
	`TYPE` int (2),
	`PUBLISH_TIME` datetime ,
	`CREATE_TIME` datetime ,
	`UPDATE_TIME` datetime 
); 
insert into `TB_NEWS` (`ID`, `TITLE`, `CONTENT`, `AUTHER`, `TYPE`, `PUBLISH_TIME`, `CREATE_TIME`, `UPDATE_TIME`) values('1','上将“军老虎”落马，他究竟向谁行贿？','本周，最重要的消息是十九届中央纪委二次全会11日在北京开幕，中共中央总书记、国家主席、中央军委主席习近平发出了新号召，“重整行装再出发，以永远在路上的执着把全面从严治党引向深入，开创全面从严治党新局面。”\n1月12日，广东省委原常委、珠海市委原书记李嘉受贿案公开宣判，李嘉受贿2058万余元，获刑13年，罚金200万元。他是十九大之后第一个获刑的原省部级官员。\n本周最令人震惊的消息莫过于一位重磅“军老虎”的倒下。房峰辉，这位中央军事委员会委员因涉嫌行贿、受贿犯罪，被移送军事检察机关依法处理。军中反腐，大刀阔斧。','幸福西饼','1','2018-01-13 16:22:46','2018-01-13 16:22:46','2018-01-13 16:22:46');
insert into `TB_NEWS` (`ID`, `TITLE`, `CONTENT`, `AUTHER`, `TYPE`, `PUBLISH_TIME`, `CREATE_TIME`, `UPDATE_TIME`) values('2','“夜宿门”后李小璐首现身，与甜馨同行，专注手机，心情大好','李小璐夜宿pgone事件已经过去十多天。随着李小璐的“消失”，贾乃亮的声明，pgone回到老家，该事件的主要角色来了个大换身，成了马苏和黄毅清。而马苏起诉黄毅清，而且还是刑事自诉黄毅清，更是将两人的关系推上了风口浪尖。\n马苏与黄毅清的官司如火如荼，李小璐一家三口则悠然自得，心情大好。黄毅清不愧是贾乃亮的好兄弟，马苏也不愧是李小璐的好姐妹。挡枪眼，最终成为主角。','幸福西饼','2','2018-01-13 16:25:47','2018-01-13 16:25:47','2018-01-13 16:25:47');
insert into `TB_NEWS` (`ID`, `TITLE`, `CONTENT`, `AUTHER`, `TYPE`, `PUBLISH_TIME`, `CREATE_TIME`, `UPDATE_TIME`) values('3','专心治疗不安排训练 邹市明的拳击生涯会就此终结吗','原标题：专心治疗不安排训练，邹市明的拳击生涯会就此终结吗\n“好久不见，我还是我……”昨日，备受关注的奥运冠军、前世界拳王邹市明通过其官方微博发声，透露自己已经离开医院。\n此时，距离他上月21日被曝出因眼疾入院已经过去了23天。\n澎湃新闻记者通过邹市明团队获悉，邹市明在接受了治疗后，病情相对稳定，接下来将在家中静养，但院方还将会诊评估邹市明的病情，并确定下一步治疗方案。\n简而言之，邹市明一段时间内依然会以治疗康复为主，不会有训练和比赛安排。而这是否会就此成为他职业生涯的终结，只能等待邹市明自己的决定。','凤凰新闻','3','2018-01-13 16:25:48','2018-01-13 16:25:48','2018-01-13 16:25:48');
insert into `TB_NEWS` (`ID`, `TITLE`, `CONTENT`, `AUTHER`, `TYPE`, `PUBLISH_TIME`, `CREATE_TIME`, `UPDATE_TIME`) values('4','捷克选总统可能需要第二轮投票','（原标题：捷克选总统可能需要第二轮投票）\n新华社北京1月13日电（记者沈敏）捷克共和国1月12日至13日直接选举总统，选举可能需要第二轮投票。\n多项选前民意调查显示，9名候选人中，现任总统米洛什·泽曼所获支持率领先，有望在首轮投票中“出线”。\n但是，民意分裂以及民意支持率分散所致，泽曼如果拿不到50%选票，则需要进入第二轮，可能与捷克科学院前院长伊日·德拉霍什对决。','网易新闻','4','2018-01-13 16:25:48','2018-01-13 16:25:48','2018-01-13 16:25:48');
