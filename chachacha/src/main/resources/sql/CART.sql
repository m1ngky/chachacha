DROP TABLE CART

CREATE TABLE CART(
C_NO NUMBER PRIMARY KEY,	--��ٱ��� ��ȣ
C_ID VARCHAR2(10) REFERENCES member(id),	--����� ���̵�
P_CODE	NUMBER 	REFERENCES PRODUCT(P_CODE),	--��ǰ ��ȣ
C_AMOUNT NUMBER	DEFAULT 0	--����
)

drop sequence seq_cart;

create sequence seq_cart;
SELECT * FROM CART;


CREATE TABLE CART_test(
C_ID VARCHAR2(10) REFERENCES member(id),	--����� ���̵�
C_CODE	NUMBER 	REFERENCES PRODUCT(P_CODE),	--��ǰ ��ȣ
C_AMOUNT NUMBER	DEFAULT 0	--����
)

insert into cart_test values('admin',1,0)

select * from cart_test c, product p where c.c_code = p.p_code;


