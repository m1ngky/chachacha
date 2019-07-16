--���̳�������Ʈ
drop table fboard;

create table fboard(
   num      number,                     --�۹�ȣ
   id      varchar2(15),            --�ۼ���
   password varchar2(30),			--��й�ȣ
   category varchar2(1) check(category in('b','s','g','c','n')), -- ����(buy,sale,group,service,��������)
   ccategory varchar2(1) check(ccategory in('d','c','s','r','m','o')), --������ ����
                           --(���,��ȯ/ȯ��,�ֹ�/����,������/��������,��Ÿ)
   readcount number,               --��ȸ��
   subject   varchar2(300),            --����
   content   varchar2(4000),            --����
   price     varchar2(20),            --����  (�ǸŰ���,��°���,���������� ���Ű���)
   gprice    varchar2(20),            --�������� ����
   filename      varchar2(400),         --÷�ε� ���� ��(����)
   originalfile  varchar2(50),			--÷�ε� ���� ��
   inputdate date,                  --�� �ۼ� ��¥ 
   primary key(num),
   constraint fk_fboard_name foreign key(id) 
   references fmember(id) on delete cascade
)

select * from fboard;