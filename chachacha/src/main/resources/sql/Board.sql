--파이널프로젝트
drop table fboard;

create table fboard(
   num      number,                     --글번호
   id      varchar2(15),            --작성자
   password varchar2(30),			--비밀번호
   category varchar2(1) check(category in('b','s','g','c','n')), -- 종류(buy,sale,group,service,공지사항)
   ccategory varchar2(1) check(ccategory in('d','c','s','r','m','o')), --고객센터 종류
                           --(배달,교환/환불,주문/결제,영수증/증빙서류,기타)
   readcount number,               --조회수
   subject   varchar2(300),            --제목
   content   varchar2(4000),            --내용
   price     varchar2(20),            --가격  (판매가격,사는가격,공동전원가 구매가격)
   gprice    varchar2(20),            --공동구매 가격
   filename      varchar2(400),         --첨부될 파일 명(가공)
   originalfile  varchar2(50),			--첨부될 파일 명
   inputdate date,                  --글 작성 날짜 
   primary key(num),
   constraint fk_fboard_name foreign key(id) 
   references fmember(id) on delete cascade
)

select * from fboard;