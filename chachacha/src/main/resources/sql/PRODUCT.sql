CREATE TABLE PRODUCT(


P_CODE NUMBER PRIMARY KEY,	--��ǰ ��ȣ
P_CATEGORY VARCHAR2(10) CHECK (P_CATEGORY IN('A','B','C','D')),	--��ǰ ī�װ�
P_PRICE NUMBER	DEFAULT 0 UNIQUE,	--��ǰ ����
P_GPRICE NUMBER	DEFAULT 0 UNIQUE,	--��ǰ ���ΰ�
P_LIMIT NUMBER	,		--��ǰ ��������
P_NAME	VARCHAR2(100) UNIQUE,	--��ǰ�̸�
P_SELLERNAME	VARCHAR2(30) ,	--�Ǹ����̸�
P_IMAGE VARCHAR2(50) UNIQUE		--��ǰ �̹���

)

DROP TABLE PRODUCT


SELECT * FROM PRODUCT

delete from product where p_code = 1

insert into product values(1,'A',10000,5000,10,'��ǳ��','������','wade.jpg');
insert into product values(2,'A',15000,10000,10,'������','������','giannis.jpg');
insert into product values(3,'A',20000,15000,10,'�鵵��','������','james.jpg');
insert into product values(4,'A',25000,20000,10,'�ٸ���','������','zion.jpg');
insert into product values(5,'A',30000,25000,10,'���ڷ�����','������','durant.jpg');
insert into product values(6,'A',35000,30000,10,'�����','������','brooks.jpg');
insert into product values(7,'A',40000,35000,10,'��ǻ��','������','curry.jpg');
insert into product values(8,'A',45000,40000,10,'������','������','leonard.jpg');













