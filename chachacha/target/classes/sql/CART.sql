DROP TABLE CART

CREATE TABLE CART(
C_NO NUMBER PRIMARY KEY,	--장바구니 번호
C_ID VARCHAR2(10) REFERENCES member(id),	--사용자 아이디
P_CODE	NUMBER 	REFERENCES PRODUCT(P_CODE),	--상품 번호
C_AMOUNT NUMBER	DEFAULT 0	--수량
)

drop sequence seq_cart;

create sequence seq_cart;
SELECT * FROM CART;


CREATE TABLE CART_test(
C_ID VARCHAR2(10) REFERENCES member(id),	--사용자 아이디
C_CODE	NUMBER 	REFERENCES PRODUCT(P_CODE),	--상품 번호
C_AMOUNT NUMBER	DEFAULT 0	--수량
)

insert into cart_test values('admin',1,0)

select * from cart_test c, product p where c.c_code = p.p_code;


