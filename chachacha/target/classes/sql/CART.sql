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

select
			p.p_image,
			c.c_no,	
			c.c_id,
			p.p_code,
			p.p_name,
			c.c_amount,
			p.p_gprice,
			p.p_category,
			(p_gprice * c_amount) money
		from
			member m, product p, cart c
		where m.id = c.c_id
			and p.p_code = c.p_code
			and c.c_id = 'admin'
		order by
			c.c_no
