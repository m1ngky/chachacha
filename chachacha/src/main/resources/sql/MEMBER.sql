DROP TABLE FMEMBER

SELECT * FROM FMEMBER

delete FMEMBER

CREATE TABLE FMEMBER(

   id         VARCHAR2(30),
   password   VARCHAR2(30),
   name      VARCHAR2(30),
   nickname  VARCHAR2(30),
   birth   VARCHAR2(20),
   gender      VARCHAR2(10),

   id         VARCHAR2(50),
   password   VARCHAR2(50),
   name      VARCHAR2(50),
   nickname  VARCHAR2(50),
   birth   VARCHAR2(50),
   gender      VARCHAR2(5),


   email      VARCHAR2(30),
   address   VARCHAR2(30),
   phonenumber VARCHAR2(20),
   joindate VARCHAR2(20),
   mileage NUMBER(10),

   account VARCHAR2(50),
   grade VARCHAR2(20),


 



   PRIMARY KEY(ID)

);


insert into fmember(id, password, name, email, grade) values ('admin', '1234', 'kim', 'kim@naver.com', '판매자');
insert into fmember(id, password, name, email, grade) values ('a3', '1234', 'kim', 'kim@naver.com', '판매자');
insert into fmember(id, password, name, email, grade) values ('a4', '1234', 'kim', 'kim@naver.com', '판매자');
insert into fmember(id, password, name, email, grade) values ('a5', '1234', 'kim', 'kim@naver.com', '판매자');
insert into fmember(id, password, name, email, grade) values ('a6', '1234', 'kim', 'kim@naver.com', '판매자');
insert into fmember(id, password, name, email, grade) values ('a7', '1234', 'kim', 'kim@naver.com', '판매자');
insert into fmember(id, password, name, email, grade) values ('a8', '1234', 'kim', 'kim@naver.com', '판매자');
insert into fmember(id, password, name, email, grade) values ('a9', '1234', 'kim', 'kim@naver.com', '판매자');
insert into fmember(id, password, name, email, grade) values ('a10', '1234', 'kim', 'kim@naver.com', '판매자');
insert into fmember(id, password, name, email, grade) values ('a11', '1234', 'kim', 'kim@naver.com', '판매자');
insert into fmember(id, password, name, email, grade) values ('a12', '1234', 'kim', 'kim@naver.com', '판매자');
insert into fmember(id, password, name, email, grade) values ('a13', '1234', 'kim', 'kim@naver.com', '판매자');
insert into fmember(id, password, name, email, grade) values ('a14', '1234', 'kim', 'kim@naver.com', '판매자');
insert into fmember(id, password, name, email, grade) values ('a15', '1234', 'kim', 'kim@naver.com', '판매자');
insert into fmember(id, password, name, email, grade) values ('a16', '1234', 'kim', 'kim@naver.com', '판매자');
insert into fmember(id, password, name, email, grade) values ('a17', '1234', 'kim', 'kim@naver.com', '판매자');

insert into fmember(id, password) values('meoun12', '1234');

