DROP TABLE PRODUCTS;
CREATE TABLE PRODUCTS(
PRODUCT_ID INT PRIMARY KEY,
PRODUCT_NAME VARCHAR2(100),
MADEIN VARCHAR2(10),
PRODUCT_VERSION VARCHAR2(20),
PRODUCT_DESC VARCHAR2(1000),
PRODUCT_TYPE VARCHAR2(2),
MODIFY_TIME DATE
);

Insert into PRODUCTS (PRODUCT_ID,PRODUCT_NAME,MADEIN,PRODUCT_VERSION,PRODUCT_DESC,PRODUCT_TYPE,MODIFY_TIME) 
values (1,'JAVA编程思想第四版','USA','1.0.0.113','JAVA编程思想第四版','1',SYSDATE);
Insert into PRODUCTS (PRODUCT_ID,PRODUCT_NAME,MADEIN,PRODUCT_VERSION,PRODUCT_DESC,PRODUCT_TYPE,MODIFY_TIME) 
values (2,'机器学习实践','USA','sdkf.2.009.12','机器学习实践 2 ','1',SYSDATE);
Insert into PRODUCTS (PRODUCT_ID,PRODUCT_NAME,MADEIN,PRODUCT_VERSION,PRODUCT_DESC,PRODUCT_TYPE,MODIFY_TIME) 
values (3,'比亚迪新能源车','CHINA','TANG','比亚迪新能源车','2',SYSDATE);
Insert into PRODUCTS (PRODUCT_ID,PRODUCT_NAME,MADEIN,PRODUCT_VERSION,PRODUCT_DESC,PRODUCT_TYPE,MODIFY_TIME) 
values (4,'Macbook Pro 13','USA','Macbook.0.113','苹果笔记本电脑，retina显示屏，13英寸','2',SYSDATE);
Insert into PRODUCTS (PRODUCT_ID,PRODUCT_NAME,MADEIN,PRODUCT_VERSION,PRODUCT_DESC,PRODUCT_TYPE,MODIFY_TIME) 
values (5,'Oracle企业开发指南','CHINA','4','最全的oracle开发指南','1',SYSDATE);
Insert into PRODUCTS (PRODUCT_ID,PRODUCT_NAME,MADEIN,PRODUCT_VERSION,PRODUCT_DESC,PRODUCT_TYPE,MODIFY_TIME) 
values (6,'LENOVO LAPTOP','CHINA','LS410','Lenovo, lowest price, best quality','2',SYSDATE);
Insert into PRODUCTS (PRODUCT_ID,PRODUCT_NAME,MADEIN,PRODUCT_VERSION,PRODUCT_DESC,PRODUCT_TYPE,MODIFY_TIME) 
values (7,'SUMSING','SKOREA','GALAXY S5','tips will help you connect with your customers.','2',SYSDATE);

DROP TABLE PRODUCT_TYPE;
CREATE TABLE PRODUCT_TYPE(
TYPE_ID INT PRIMARY KEY,
TYPE_NAME VARCHAR2(20),
MODIFY_TIME DATE
);
INSERT INTO PRODUCT_TYPE(TYPE_ID, TYPE_NAME, MODIFY_TIME) VALUES (1, 'Books', SYSDATE);
INSERT INTO PRODUCT_TYPE(TYPE_ID, TYPE_NAME, MODIFY_TIME) VALUES (2, 'Tools', SYSDATE);

UPDATE PRODUCT_TYPE SET TYPE_NAME = 'Books1', MODIFY_TIME=SYSDATE WHERE TYPE_ID=1;

UPDATE PRODUCTS SET PRODUCT_DESC = '机器学习实践 2 2 UPDATED', MODIFY_TIME=SYSDATE WHERE PRODUCT_ID = 2;

Insert into PRODUCTS (PRODUCT_ID,PRODUCT_NAME,MADEIN,PRODUCT_VERSION,PRODUCT_DESC,PRODUCT_TYPE,MODIFY_TIME) 
values (8,'Iphone6 Plus','USA','Iphone6 Plus','Iphone6 Plus.','2',SYSDATE);