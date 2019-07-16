DROP TABLE FMEMBER

SELECT * FROM FMEMBER

CREATE TABLE FMEMBER(
   id         VARCHAR2(30),
   password   VARCHAR2(30),
   name      VARCHAR2(30),
   nickname  VARCHAR2(30),
   birth   VARCHAR2(20),
   gender      VARCHAR2(10),
   email      VARCHAR2(30),
   address   VARCHAR2(30),
   phonenumber VARCHAR2(20),
   joindate VARCHAR2(20),
   mileage NUMBER(10),
   account VARCHAR2(50),
   grade VARCHAR2(20),
   PRIMARY KEY(ID)
);

