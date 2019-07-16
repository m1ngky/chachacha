--���̳�������Ʈ
drop table Fboard;

create table Fboard(
   NUM      NUMBER,                     --�۹�ȣ
   id      VARCHAR2(15),            --�ۼ���
   password varchar2(30),         --��й�ȣ
   category varchar2(1) check(category in('B','S','G','C','N')), -- ����(Buy,Sale,Group,Service,��������)
   Ccategory varchar2(1) check(Ccategory in('d','c','s','r','m','o')), --������ ����
                           --(���,��ȯ/ȯ��,�ֹ�/����,������/��������,��Ÿ)
   readcount number,               --��ȸ��
   SUBJECT   VARCHAR2(300),            --����
   CONTENT   VARCHAR2(4000),            --����
   PRICE     varchar2(20),            --����  (�ǸŰ���,��°���,���������� ���Ű���)
   GPRICE    varchar2(20),            --�������� ����
   FILEname      VARCHAR2(400),        --÷�ε� ���� ��(����)
   OriginalFile  VARCHAR2(50),         --÷�ε� ���� ��
   InputDATE DATE,                  --�� �ۼ� ��¥ 
   primary key(num),
   constraint fk_fboard_name foreign key(id) 
   references fmember(id) on delete cascade
)

select * from FBOARD;