drop table TB_ADDRESS_INFO;
create table TB_ADDRESS_INFO(
  	ID int primary key,
    PROVINCE_NAME VARCHAR2(100),
    PROVINCE_CODE VARCHAR2(2),
  	CITY_NAME VARCHAR2(100),
    CITY_CODE VARCHAR2(4),
  	COUNTY_NAME VARCHAR2(100),
    COUNTY_CODE VARCHAR2(6),
    LATITUDE number(7,4),
    LONGITUDE number(7,4),
    ADDRESS VARCHAR2(100),
  	CREATE_TIME DATE,
  	MODIFY_TIME DATE
);

insert into TB_ADDRESS_INFO(ID ,PROVINCE_NAME,PROVINCE_CODE,CITY_NAME,CITY_CODE,COUNTY_NAME,COUNTY_CODE,LATITUDE,LONGITUDE,ADDRESS,CREATE_TIME, MODIFY_TIME) values (1001, '湖南省','43','长沙市','4301','长沙县','430121',121.8950,56.4565,'华润凤凰城', SYSDATE, SYSDATE);
insert into TB_ADDRESS_INFO(ID ,PROVINCE_NAME,PROVINCE_CODE,CITY_NAME,CITY_CODE,COUNTY_NAME,COUNTY_CODE,LATITUDE,LONGITUDE,ADDRESS,CREATE_TIME, MODIFY_TIME) values (1002, '湖南省','43','长沙市','4301','长沙县','430121',121.5960,56.4575,'恒基凯旋门', SYSDATE, SYSDATE);
insert into TB_ADDRESS_INFO(ID ,PROVINCE_NAME,PROVINCE_CODE,CITY_NAME,CITY_CODE,COUNTY_NAME,COUNTY_CODE,LATITUDE,LONGITUDE,ADDRESS,CREATE_TIME, MODIFY_TIME) values (1003, '湖南省','43','长沙市','4301','长沙县','430121',121.8970,56.4485,'幸福里', SYSDATE, SYSDATE);
insert into TB_ADDRESS_INFO(ID ,PROVINCE_NAME,PROVINCE_CODE,CITY_NAME,CITY_CODE,COUNTY_NAME,COUNTY_CODE,LATITUDE,LONGITUDE,ADDRESS,CREATE_TIME, MODIFY_TIME) values (1004, '湖南省','43','长沙市','4301','长沙县','430121',121.8980,56.4395,'海德公园', SYSDATE, SYSDATE);
insert into TB_ADDRESS_INFO(ID ,PROVINCE_NAME,PROVINCE_CODE,CITY_NAME,CITY_CODE,COUNTY_NAME,COUNTY_CODE,LATITUDE,LONGITUDE,ADDRESS,CREATE_TIME, MODIFY_TIME) values (1005, '湖南省','43','长沙市','4301','长沙县','430121',121.8890,56.4605,'万科第一城', SYSDATE, SYSDATE);
insert into TB_ADDRESS_INFO(ID ,PROVINCE_NAME,PROVINCE_CODE,CITY_NAME,CITY_CODE,COUNTY_NAME,COUNTY_CODE,LATITUDE,LONGITUDE,ADDRESS,CREATE_TIME, MODIFY_TIME) values (1006, '湖南省','43','长沙市','4301','长沙县','430121',121.8995,56.4615,'华润凤凰城一期', SYSDATE, SYSDATE);
insert into TB_ADDRESS_INFO(ID ,PROVINCE_NAME,PROVINCE_CODE,CITY_NAME,CITY_CODE,COUNTY_NAME,COUNTY_CODE,LATITUDE,LONGITUDE,ADDRESS,CREATE_TIME, MODIFY_TIME) values (1011, '湖南省','43','长沙市','4301','岳麓区','430003',111.8950,55.4565,'华润橡树湾', SYSDATE, SYSDATE);
insert into TB_ADDRESS_INFO(ID ,PROVINCE_NAME,PROVINCE_CODE,CITY_NAME,CITY_CODE,COUNTY_NAME,COUNTY_CODE,LATITUDE,LONGITUDE,ADDRESS,CREATE_TIME, MODIFY_TIME) values (1012, '湖南省','43','长沙市','4301','岳麓区','430003',111.5950,55.2565,'阳光100', SYSDATE, SYSDATE);
insert into TB_ADDRESS_INFO(ID ,PROVINCE_NAME,PROVINCE_CODE,CITY_NAME,CITY_CODE,COUNTY_NAME,COUNTY_CODE,LATITUDE,LONGITUDE,ADDRESS,CREATE_TIME, MODIFY_TIME) values (1013, '湖南省','43','长沙市','4301','岳麓区','430003',110.8950,55.4565,'麓谷名苑', SYSDATE, SYSDATE);
insert into TB_ADDRESS_INFO(ID ,PROVINCE_NAME,PROVINCE_CODE,CITY_NAME,CITY_CODE,COUNTY_NAME,COUNTY_CODE,LATITUDE,LONGITUDE,ADDRESS,CREATE_TIME, MODIFY_TIME) values (1014, '湖南省','43','长沙市','4301','岳麓区','430003',109.8950,54.4565,'雷锋科院', SYSDATE, SYSDATE);
insert into TB_ADDRESS_INFO(ID ,PROVINCE_NAME,PROVINCE_CODE,CITY_NAME,CITY_CODE,COUNTY_NAME,COUNTY_CODE,LATITUDE,LONGITUDE,ADDRESS,CREATE_TIME, MODIFY_TIME) values (1015, '湖南省','43','长沙市','4301','岳麓区','430003',107.8850,55.4565,'万科金域国际', SYSDATE, SYSDATE);
insert into TB_ADDRESS_INFO(ID ,PROVINCE_NAME,PROVINCE_CODE,CITY_NAME,CITY_CODE,COUNTY_NAME,COUNTY_CODE,LATITUDE,LONGITUDE,ADDRESS,CREATE_TIME, MODIFY_TIME) values (1016, '湖南省','43','长沙市','4301','岳麓区','430003',110.8955,56.4565,'万科金域滨江', SYSDATE, SYSDATE);
         
SELECT tmp.*   
  FROM (SELECT ROWNUM AS rowno, t.*   
          FROM TB_ADDRESS_INFO t   
         WHERE ROWNUM <= 10) tmp   
 WHERE tmp.rowno >= 1 ;
 
 