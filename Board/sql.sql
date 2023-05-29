create table testB( --게시판 테이블
  brdNo INT(11) NOT NULL AUTO_INCREMENT,                
  id VARCHAR(20) NOT NULL,                          
  brdName VARCHAR(50) NULL,
  brdContent VARCHAR(1000) NULL,
  brdIndate TIMESTAMP DEFAULT NOW(),                        
  PRIMARY KEY(brdNo)    
);

insert into testB
VALUES(1, "이진", "안녕하세요", "하이하이하이", DEFAULT);

select * from testB;

create table memberB( 
	id varchar(20) not null,
	pwd varchar(20) not null,
	name varchar(10) not null,
	phone varchar(20) not null,
	primary key(id)
);


insert into memberB
VALUES("hijin", "0000", "채이진", "010-1111-2222");

select * from memberB;



