CREATE TABLE PRODUCT(


P_CODE NUMBER PRIMARY KEY,	--상품 번호
P_CATEGORY VARCHAR2(10) CHECK (P_CATEGORY IN('A','B','C','D')),	--상품 카테고리
P_PRICE NUMBER	DEFAULT 0 UNIQUE,	--상품 정가
P_GPRICE NUMBER	DEFAULT 0 UNIQUE,	--상품 할인가
P_LIMIT NUMBER	,		--상품 구매제한
P_NAME	VARCHAR2(100) UNIQUE,	--상품이름
P_SELLERNAME	VARCHAR2(30) ,	--판매자이름
P_IMAGE VARCHAR2(50) UNIQUE		--상품 이미지

)

DROP TABLE PRODUCT


SELECT * FROM PRODUCT

delete from product where p_code = 1

insert into product values(1,'A',10000,5000,10,'선풍기','최현재','wade.jpg');
insert into product values(2,'A',15000,10000,10,'에어컨','최현재','giannis.jpg');
insert into product values(3,'A',20000,15000,10,'면도기','최현재','james.jpg');
insert into product values(4,'A',25000,20000,10,'다리미','최현재','zion.jpg');
insert into product values(5,'A',30000,25000,10,'전자레인지','최현재','durant.jpg');
insert into product values(6,'A',35000,30000,10,'냉장고','최현재','brooks.jpg');
insert into product values(7,'A',40000,35000,10,'컴퓨터','최현재','curry.jpg');
insert into product values(8,'A',45000,40000,10,'아이폰','최현재','leonard.jpg');













