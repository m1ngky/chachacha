CREATE TABLE PRODUCT(
P_CODE VARCHAR2(20) PRIMARY KEY,
P_COUNT NUMBER,
P_PRICE NUMBER,
P_GPRICE NUMBER,
P_LIMIT NUMBER,
P_NAME	VARCHAR2(100), --제목
P_SELLERNAME	VARCHAR2(30),
p_savefile varchar2(50),
p_originalfile varchar2(30),
p_description varchar2(100) -- 제품설명

)

desc product

insert into product
values('1','1','1','1','1','1','1')

alter table product
add p_description varchar2(100);

DROP TABLE PRODUCT   CASCADE CONSTRAINTS;
SELECT * FROM PRODUCT















