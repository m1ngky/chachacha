CREATE TABLE CART(
C_ID VARCHAR2(10) ,
C_COUNT NUMBER	,
C_CODE	VARCHAR2(10) ,
C_PRICE	NUMBER,
C_GPRICE	NUMBER	,
C_NAME	VARCHAR2(100) 
)



SELECT * FROM CART;

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

