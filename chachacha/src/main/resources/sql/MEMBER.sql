DROP TABLE FMEMBER

SELECT * FROM FMEMBER

CREATE TABLE FMEMBER(
   id         VARCHAR2(50),
   password   VARCHAR2(50),
   name      VARCHAR2(50),
   nickname  VARCHAR2(50),
   birth   VARCHAR2(50),
   gender      VARCHAR2(5),
   email      VARCHAR2(50),
   address   VARCHAR2(500),
   phonenumber VARCHAR2(50),
   joindate VARCHAR2(50),
   mileage NUMBER,
   account VARCHAR(50),
   PRIMARY KEY(ID)
);

