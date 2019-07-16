DROP TABLE FMEMBER

SELECT * FROM FMEMBER

delete FMEMBER

CREATE TABLE FMEMBER(
   id         VARCHAR2(50),
   password   VARCHAR2(50),
   name      VARCHAR2(50),
   nickname  VARCHAR2(50),
   birth   VARCHAR2(50),
   gender      VARCHAR2(5),

   email      VARCHAR2(30),
   address   VARCHAR2(30),
   phonenumber VARCHAR2(15),
   joindate VARCHAR2(10),
   mileage NUMBER(10),


  


   account VARCHAR(50),
   PRIMARY KEY(ID)

);

insert into fmember(id, password) values('meoun12', '1234');


