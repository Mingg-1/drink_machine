/*��� ���̺�(�ڵ�,����,����,�ܰ�)*/
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
values ('I10', '�а���', 100, 100);
insert into INGREDIENT (in_code, in_name, in_cnt, in_prc)
values ('I20', '����', 100, 100);
insert into INGREDIENT (in_code, in_name, in_cnt, in_prc)
values ('I30', '����', 100, 100);
insert into INGREDIENT (in_code, in_name, in_cnt, in_prc)
values ('I40', '���', 100, 100);
insert into INGREDIENT (in_code, in_name, in_cnt, in_prc)
values ('I50', '�Ͼӱ�', 100, 100);
insert into INGREDIENT (in_code, in_name, in_cnt, in_prc)
values ('I60', '��ũ��', 100, 100);
insert into INGREDIENT (in_code, in_name, in_cnt, in_prc)
values ('I70', '����', 100, 100);

/*�� ���̺�(�ڵ�,���̸�,����,����)*/
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

/*���� ���̺�(��ȣ,�� �ڵ�,��¥,�Ǹŷ�)*/
CREATE TABLE SALES(
sls_num NUMBER(10) NOT NULL,
brd_code VARCHAR2(100),
reg_date DATE,
sls_cnt NUMBER(10),

constraints SALES_TN_pk primary key (sls_num),
constraints FK_PRICE foreign key(brd_code)
references BREAD(brd_code));

/*������ ���̺�(����ڵ�,���ڵ�,����)*/
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


/*���� ���̺�(��ȣ,����ڵ�,���ֳ�¥,���ְ���,���ɳ�¥)*/
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
 ���̺� ����
 drop table INGREDIENT cascade constraints;
 drop table BREAD cascade constraints;
 drop table SALES cascade constraints;
 drop table RECIPE cascade constraints;
 drop table DELIVERY cascade constraints;
 */