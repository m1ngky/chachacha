DROP TABLE FMEMBER

SELECT * FROM FMEMBER

CREATE TABLE FMEMBER(
   id         VARCHAR2(15),
   password   VARCHAR2(10),
   name      VARCHAR2(15),
   nickname  VARCHAR2(15),
   birth   VARCHAR2(20),
   gender      VARCHAR2(5),
   email      VARCHAR2(30),
   address   VARCHAR2(30),
   phonenumber VARCHAR2(15),
   joindate VARCHAR2(10),
   mileage NUMBER(10),
   account VARCHAR(50),
   PRIMARY KEY(ID)
);

