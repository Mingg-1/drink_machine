/*재료 테이블(코드,재료명,수량,단가)*/
CREATE TABLE INGREDIENT(
in_code VARCHAR2(100) NOT NULL,
in_name VARCHAR2(100),
in_cnt NUMBER(10) NOT NULL,
in_prc NUMBER(10),

constraints ingredient_icode_pk primary key (in_code));

create sequence In_incode_seq
increment by 10
start with 10
maxvalue 100
nocache;

insert into INGREDIENT (in_code, in_name, in_cnt, in_prc)
values ('I10', '밀가루', 100, 100);
insert into INGREDIENT (in_code, in_name, in_cnt, in_prc)
values ('I20', '버터', 100, 100);
insert into INGREDIENT (in_code, in_name, in_cnt, in_prc)
values ('I30', '설탕', 100, 100);
insert into INGREDIENT (in_code, in_name, in_cnt, in_prc)
values ('I40', '계란', 100, 100);
insert into INGREDIENT (in_code, in_name, in_cnt, in_prc)
values ('I50', '팥앙금', 100, 100);
insert into INGREDIENT (in_code, in_name, in_cnt, in_prc)
values ('I60', '생크림', 100, 100);
insert into INGREDIENT (in_code, in_name, in_cnt, in_prc)
values ('I70', '우유', 100, 100);

/*빵 테이블(코드,빵이름,수량,가격)*/
CREATE TABLE BREAD(
brd_code VARCHAR2(100) NOT NULL,
brd_name VARCHAR2(100) NOT NULL,
brd_cnt NUMBER(10),
brd_prc NUMBER(10),

constraints BREAD_BCODE_pk primary key (brd_code));

create sequence In_brdcode_seq
increment by 10
start with 110
maxvalue 1000
nocache;

insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B100', '식빵', 10, 2000);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B110', '우유식빵', 10, 2200);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B120', '단팥빵', 10, 1400);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B130', '크림빵', 10, 1500);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B140', '바게트빵', 10, 2000);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B150', '베이글', 10, 2200);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B160', '단팥도넛', 10, 1200);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B170', '꽈배기도넛', 10, 1100);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B180', '모닝빵', 10, 2200);

/*매출 테이블(번호,빵 코드,날짜,판매량)*/
CREATE TABLE SALES(
sls_num NUMBER(10) NOT NULL,
brd_code VARCHAR2(100),
reg_date DATE,
sls_cnt NUMBER(10),

constraints SALES_TN_pk primary key (sls_num),
constraints FK_PRICE foreign key(brd_code)
references BREAD(brd_code));

/*레시피 테이블(재료코드,빵코드,수량)*/
CREATE TABLE RECIPE(
in_code VARCHAR2(100) NOT NULL,
brd_code VARCHAR2(100),
rcp_cnt NUMBER(10) NOT NULL,

constraints FK_CODE foreign key(in_code)
references INGREDIENT(in_code),
constraints FK_NAME foreign key(brd_code)
references BREAD(brd_code));

insert into RECIPE (in_code, brd_code, rcp_cnt)
values ('I10', 'B100', 5);
insert into RECIPE (in_code, brd_code, rcp_cnt)
values ('I20', 'B100', 2);
insert into RECIPE (in_code, brd_code, rcp_cnt)
values ('I30', 'B100', 2);
insert into RECIPE (in_code, brd_code, rcp_cnt)
values ('I40', 'B100', 2);
insert into RECIPE (in_code, brd_code, rcp_cnt)
values ('I70', 'B100', 3);


/*발주 테이블(번호,재료코드,발주날짜,발주개수,수령날짜)*/
CREATE TABLE DELIVERY(
in_code VARCHAR2(100),
dvr_date DATE,
dvr_cnt NUMBER(10),
rcv_date DATE,

constraints DELIVERY_NUM_pk primary key (dvr_num),
constraints FK_CODE2 foreign key(in_code)
references INGREDIENT(in_code));

select * from INGREDIENT;
select * from BREAD;
select * from SALES;
select * from RECIPE;
select * from DELIVERY;

/*
 테이블 삭제
 drop table INGREDIENT cascade constraints;
 drop table BREAD cascade constraints;
 drop table SALES cascade constraints;
 drop table RECIPE cascade constraints;
 drop table DELIVERY cascade constraints;
 */