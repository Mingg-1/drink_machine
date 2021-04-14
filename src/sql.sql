/*Àç·á Å×ÀÌºí(ÄÚµå,Àç·á¸í,¼ö·®,´Ü°¡)*/
CREATE TABLE INGREDIENT(
in_code VARCHAR2(100) NOT NULL,
in_name VARCHAR2(100),
use_in_cnt NUMBER(10) NOT NULL,
in_prc NUMBER(10),
wrh_in_cnt NUMBER(10),

constraints ingredient_icode_pk primary key (in_code),
constraints in_name_uq UNIQUE (in_name));

create sequence In_incode_seq
increment by 10
start with 10
maxvalue 100
nocache;

insert into INGREDIENT (in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt)
values ('I10', '¹Ð°¡·ç', 100, 100, 2);
insert into INGREDIENT (in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt)
values ('I20', '¹öÅÍ', 100, 100, 5);
insert into INGREDIENT (in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt)
values ('I30', '¼³ÅÁ', 100, 100, 2);
insert into INGREDIENT (in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt)
values ('I40', '°è¶õ', 100, 100, 90);
insert into INGREDIENT (in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt)
values ('I50', 'ÆÏ¾Ó±Ý', 100, 100, 2);
insert into INGREDIENT (in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt)
values ('I60', '»ýÅ©¸²', 100, 100, 5);
insert into INGREDIENT (in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt)
values ('I70', '¿ìÀ¯', 100, 100, 10);

-----------------------------------------------------------------------

/*»§ Å×ÀÌºí(ÄÚµå,»§ÀÌ¸§,¼ö·®,°¡°Ý)*/
CREATE TABLE BREAD(
brd_code VARCHAR2(100),
brd_name VARCHAR2(100) NOT NULL,
brd_cnt NUMBER(10),
brd_prc NUMBER(10),

constraints BREAD_BCODE_pk primary key (brd_code),
constraints brd_name_uq UNIQUE (brd_name));

create sequence In_brdcode_seq
increment by 10
start with 110
maxvalue 1000
nocache;

insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B100', '½Ä»§', 10, 2000);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B110', '¿ìÀ¯½Ä»§', 10, 2200);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B120', '´ÜÆÏ»§', 10, 1400);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B130', 'Å©¸²»§', 10, 1500);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B140', '¹Ù°ÔÆ®»§', 10, 2000);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B150', 'º£ÀÌ±Û', 10, 2200);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B160', '´ÜÆÏµµ³Ó', 10, 1200);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B170', '²Ê¹è±âµµ³Ó', 10, 1100);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B180', '¸ð´×»§', 10, 2200);

-----------------------------------------------------------------------

/*¸ÅÃâ Å×ÀÌºí(¹øÈ£,»§ ÀÌ¸§,³¯Â¥,ÆÇ¸Å·®)*/
CREATE TABLE SALES(
sls_num NUMBER(10),
brd_name VARCHAR2(100),
reg_date DATE,
sls_cnt NUMBER(10),

constraints SALES_TN_pk primary key (sls_num),
constraints FK_PRICE foreign key(brd_name)
references BREAD(brd_name));

-----------------------------------------------------------------------

/*·¹½ÃÇÇ Å×ÀÌºí(Àç·áÀÌ¸§,»§ÀÌ¸§,¼ö·®)*/
CREATE TABLE RECIPE(
in_name VARCHAR2(100) NOT NULL,
brd_name VARCHAR2(100),
rcp_cnt NUMBER(10) NOT NULL,

constraints FK_CODE foreign key(in_name)
references INGREDIENT(in_name),
constraints FK_NAME foreign key(brd_name)
references BREAD(brd_name));

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹Ð°¡·ç', '½Ä»§', 5);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹öÅÍ', '½Ä»§', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¼³ÅÁ', '½Ä»§', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('°è¶õ', '½Ä»§', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¿ìÀ¯', '½Ä»§', 3);

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹Ð°¡·ç', '¿ìÀ¯½Ä»§', 5);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹öÅÍ', '¿ìÀ¯½Ä»§', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¼³ÅÁ', '¿ìÀ¯½Ä»§', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('°è¶õ', '¿ìÀ¯½Ä»§', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¿ìÀ¯', '¿ìÀ¯½Ä»§', 5);

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹Ð°¡·ç', '´ÜÆÏ»§', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹öÅÍ', '´ÜÆÏ»§', 1);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¼³ÅÁ', '´ÜÆÏ»§', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('°è¶õ', '´ÜÆÏ»§', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('ÆÏ¾Ó±Ý', '´ÜÆÏ»§', 3);

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹Ð°¡·ç', 'Å©¸²»§', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹öÅÍ', 'Å©¸²»§', 3);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¼³ÅÁ', 'Å©¸²»§', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('°è¶õ', 'Å©¸²»§', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('»ýÅ©¸²', 'Å©¸²»§', 3);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¿ìÀ¯', 'Å©¸²»§', 2);

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹Ð°¡·ç', '¹Ù°ÔÆ®»§', 5);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹öÅÍ', '¹Ù°ÔÆ®»§', 3);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¼³ÅÁ', '¹Ù°ÔÆ®»§', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('°è¶õ', '¹Ù°ÔÆ®»§', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¿ìÀ¯', '¹Ù°ÔÆ®»§', 2);

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹Ð°¡·ç', 'º£ÀÌ±Û', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹öÅÍ', 'º£ÀÌ±Û', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¼³ÅÁ', 'º£ÀÌ±Û', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('°è¶õ', 'º£ÀÌ±Û', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¿ìÀ¯', 'º£ÀÌ±Û', 3);

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹Ð°¡·ç', '´ÜÆÏµµ³Ó', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹öÅÍ', '´ÜÆÏµµ³Ó', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¼³ÅÁ', '´ÜÆÏµµ³Ó', 3);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('°è¶õ', '´ÜÆÏµµ³Ó', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('ÆÏ¾Ó±Ý', '´ÜÆÏµµ³Ó', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¿ìÀ¯', '´ÜÆÏµµ³Ó', 3);

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹Ð°¡·ç', '²Ê¹è±âµµ³Ó', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹öÅÍ', '²Ê¹è±âµµ³Ó', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¼³ÅÁ', '²Ê¹è±âµµ³Ó', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('°è¶õ', '²Ê¹è±âµµ³Ó', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¿ìÀ¯', '²Ê¹è±âµµ³Ó', 3);

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹Ð°¡·ç', '¸ð´×»§', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¹öÅÍ', '¸ð´×»§', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¼³ÅÁ', '¸ð´×»§', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('°è¶õ', '¸ð´×»§', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('¿ìÀ¯', '¸ð´×»§', 4);

-----------------------------------------------------------------------

/*¹ßÁÖ Å×ÀÌºí(¹øÈ£,Àç·áÀÌ¸§,¹ßÁÖ³¯Â¥,¹ßÁÖ°³¼ö,¼ö·É³¯Â¥)*/
CREATE TABLE DELIVERY(
dvr_num NUMBER(10),
in_name VARCHAR2(100),
dvr_date DATE,
dvr_cnt NUMBER(10),
rcv_date DATE,

constraints DELIVERY_NUM_pk primary key (dvr_num),
constraints FK_CODE2 foreign key(in_name)
references INGREDIENT(in_name));

select * from INGREDIENT;
select * from BREAD;
select * from SALES;
select * from RECIPE;
select * from DELIVERY;

-----------------------------------------------------------------------

/*
 Å×ÀÌºí »èÁ¦
 drop table INGREDIENT cascade constraint;
 drop table BREAD cascade constraint;
 drop table SALES cascade constraint;
 drop table RECIPE cascade constraint;
 drop table DELIVERY cascade constraint;
 */

/*½ÃÄö½º »èÁ¦
drop sequence In_incode_seq;
drop sequence In_brdcode_seq;
*/