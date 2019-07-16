--파이널프로젝트
drop table Fboard;

create table Fboard(
   NUM      NUMBER,                     --글번호
   id      VARCHAR2(15),            --작성자
   password varchar2(30),         --비밀번호
   category varchar2(1) check(category in('B','S','G','C','N')), -- 종류(Buy,Sale,Group,Service,공지사항)
   Ccategory varchar2(1) check(Ccategory in('d','c','s','r','m','o')), --고객센터 종류
                           --(배달,교환/환불,주문/결제,영수증/증빙서류,기타)
   readcount number,               --조회수
   SUBJECT   VARCHAR2(300),            --제목
   CONTENT   VARCHAR2(4000),            --내용
   PRICE     varchar2(20),            --가격  (판매가격,사는가격,공동전원가 구매가격)
   GPRICE    varchar2(20),            --공동구매 가격
   FILEname      VARCHAR2(400),        --첨부될 파일 명(가공)
   OriginalFile  VARCHAR2(50),         --첨부될 파일 명
   InputDATE DATE,                  --글 작성 날짜 
   primary key(num),
   constraint fk_fboard_name foreign key(id) 
   references fmember(id) on delete cascade
)

select * from FBOARD;