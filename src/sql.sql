/*��� ���̺�(�ڵ�,����,����,�ܰ�)*/
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
values ('I10', '�а���', 100, 100, 2);
insert into INGREDIENT (in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt)
values ('I20', '����', 100, 100, 5);
insert into INGREDIENT (in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt)
values ('I30', '����', 100, 100, 2);
insert into INGREDIENT (in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt)
values ('I40', '���', 100, 100, 90);
insert into INGREDIENT (in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt)
values ('I50', '�Ͼӱ�', 100, 100, 2);
insert into INGREDIENT (in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt)
values ('I60', '��ũ��', 100, 100, 5);
insert into INGREDIENT (in_code, in_name, use_in_cnt, in_prc, wrh_in_cnt)
values ('I70', '����', 100, 100, 10);

-----------------------------------------------------------------------

/*�� ���̺�(�ڵ�,���̸�,����,����)*/
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
values ('B100', '�Ļ�', 10, 2000);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B110', '�����Ļ�', 10, 2200);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B120', '���ϻ�', 10, 1400);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B130', 'ũ����', 10, 1500);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B140', '�ٰ�Ʈ��', 10, 2000);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B150', '���̱�', 10, 2200);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B160', '���ϵ���', 10, 1200);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B170', '�ʹ�⵵��', 10, 1100);
insert into BREAD (brd_code, brd_name, brd_cnt, brd_prc)
values ('B180', '��׻�', 10, 2200);

-----------------------------------------------------------------------

/*���� ���̺�(��ȣ,�� �̸�,��¥,�Ǹŷ�)*/
CREATE TABLE SALES(
sls_num NUMBER(10),
brd_name VARCHAR2(100),
reg_date DATE,
sls_cnt NUMBER(10),

constraints SALES_TN_pk primary key (sls_num),
constraints FK_PRICE foreign key(brd_name)
references BREAD(brd_name));

-----------------------------------------------------------------------

/*������ ���̺�(����̸�,���̸�,����)*/
CREATE TABLE RECIPE(
in_name VARCHAR2(100) NOT NULL,
brd_name VARCHAR2(100),
rcp_cnt NUMBER(10) NOT NULL,

constraints FK_CODE foreign key(in_name)
references INGREDIENT(in_name),
constraints FK_NAME foreign key(brd_name)
references BREAD(brd_name));

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('�а���', '�Ļ�', 5);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '�Ļ�', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '�Ļ�', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('���', '�Ļ�', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '�Ļ�', 3);

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('�а���', '�����Ļ�', 5);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '�����Ļ�', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '�����Ļ�', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('���', '�����Ļ�', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '�����Ļ�', 5);

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('�а���', '���ϻ�', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '���ϻ�', 1);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '���ϻ�', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('���', '���ϻ�', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('�Ͼӱ�', '���ϻ�', 3);

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('�а���', 'ũ����', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', 'ũ����', 3);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', 'ũ����', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('���', 'ũ����', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('��ũ��', 'ũ����', 3);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', 'ũ����', 2);

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('�а���', '�ٰ�Ʈ��', 5);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '�ٰ�Ʈ��', 3);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '�ٰ�Ʈ��', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('���', '�ٰ�Ʈ��', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '�ٰ�Ʈ��', 2);

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('�а���', '���̱�', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '���̱�', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '���̱�', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('���', '���̱�', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '���̱�', 3);

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('�а���', '���ϵ���', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '���ϵ���', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '���ϵ���', 3);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('���', '���ϵ���', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('�Ͼӱ�', '���ϵ���', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '���ϵ���', 3);

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('�а���', '�ʹ�⵵��', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '�ʹ�⵵��', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '�ʹ�⵵��', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('���', '�ʹ�⵵��', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '�ʹ�⵵��', 3);

insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('�а���', '��׻�', 4);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '��׻�', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '��׻�', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('���', '��׻�', 2);
insert into RECIPE (in_name, brd_name, rcp_cnt)
values ('����', '��׻�', 4);

-----------------------------------------------------------------------

/*���� ���̺�(��ȣ,����̸�,���ֳ�¥,���ְ���,���ɳ�¥)*/
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
 ���̺� ����
 drop table INGREDIENT cascade constraint;
 drop table BREAD cascade constraint;
 drop table SALES cascade constraint;
 drop table RECIPE cascade constraint;
 drop table DELIVERY cascade constraint;
 */

/*������ ����
drop sequence In_incode_seq;
drop sequence In_brdcode_seq;
*/