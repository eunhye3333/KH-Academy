-- DDL (ALTER, DROP)
-- ALTER : ��ü ���� / DROP : ��ü ����
-- �÷� �߰�/����/����
SELECT * FROM DEPT_COPY;

-- �÷� �߰�
ALTER TABLE DEPT_COPY 
ADD (CNAME VARCHAR2(20)); -- ���� NULL�� ��

ALTER TABLE DEPT_COPY 
ADD (LNAME VARCHAR2(40) DEFAULT '�ѱ�'); -- DEFAULT �� ���� ����

-- �÷� ����
/*
DEPT_ID	CHAR(2 BYTE)
DEPT_TITLE	VARCHAR2(35 BYTE)
LOCATION_ID	CHAR(2 BYTE)
CNAME	VARCHAR2(20 BYTE)
LNAME	VARCHAR2(40 BYTE)
*/

ALTER TABLE DEPT_COPY
MODIFY DEPT_ID CHAR(3);

ALTER TABLE DEPT_COPY
MODIFY DEPT_TITLE VARCHAR2(30)
MODIFY LOCATION_ID VARCHAR2(2)
MODIFY CNAME CHAR(20)
MODIFY LNAME DEFAULT '�̱�';
-- ũ��, �ڷ���, DEFAULT �� ��� ���� ����

INSERT INTO DEPT_COPY
VALUES('D10', '�Ѱ���', 'L1', NULL, DEFAULT);

ALTER TABLE DEPT_COPY
MODIFY DEPT_TITLE VARCHAR2(10); -- ORA-01441: �Ϻ� ���� �ʹ� Ŀ�� �� ���̸� ���� �� ����
-- �÷��� ũ�⸦ ���� �� �� �ȿ� �ִ� ������ �� �� �ϳ��� ũ�⸦ �Ѵ� ��� �پ���� ����

-- �÷� ����
-- �����Ͱ� �÷� �ȿ� �����ص� ���� ����
CREATE TABLE DEPT_COPY2
AS SELECT * FROM DEPT_COPY;

SELECT * FROM DEPT_COPY2;

ALTER TABLE DEPT_COPY2
DROP COLUMN CNAME;

ALTER TABLE DEPT_COPY2
DROP COLUMN LOCATION_ID;

ALTER TABLE DEPT_COPY2
DROP COLUMN LNAME;

ALTER TABLE DEPT_COPY2
DROP COLUMN DEPT_ID;

ALTER TABLE DEPT_COPY2
DROP COLUMN DEPT_TITLE; -- ORA-12983: ���̺��� ��� ������ ������ �� �����ϴ�
-- ���̺��� �ּ� �� �� �̻��� �÷��� ���� �־�� �ؼ� ���̻� ���� ������

ROLLBACK; -- ������ �� ��
-- COMMIT, ROLLBACK�� DML�� ���õ� �ֵ鸸 ����

CREATE TABLE TB1(
    PK1 NUMBER PRIMARY KEY,
    COL1 NUMBER,
    CHECK(PK1 > 0 AND COL1 > 0)
);

CREATE TABLE TB2(
    PK2 NUMBER PRIMARY KEY,
    COL2 NUMBER,
    FK2 NUMBER REFERENCES TB1,
    CHECK(PK2 > 0 AND COL2 > 0)
);

ALTER TABLE TB1 DROP COLUMN PK1; -- ORA-12992: �θ� Ű ���� ������ �� �����ϴ�
-- ���� ������ �ɷ� ����
ALTER TABLE TB2 DROP COLUMN PK2; -- ORA-12991: ���� ����-�� ���� ���Ͽ� �����Ǿ����ϴ�

-- ���� ���Ǳ��� ���� ����
ALTER TABLE TB1
DROP COLUMN PK1 CASCADE CONSTRAINTS; -- ���� ����

SELECT * FROM TB1; 

-- �������� �߰�
-- DEPT_COPY ���̺��� �������� �߰�
-- PRIMARY KEY�� DEPT_ID�� �߰� (PK_DCOPY_DID)
-- UNIQUE�� DEPT_TITLE�� �߰� (UQ_DCOPY_DTITLE)
-- NOT NULL�� LNAME�� �߰� (NN_DCOPY_LNAME)
ALTER TABLE DEPT_COPY ADD CONSTRAINT PK_DCOPY_DID PRIMARY KEY(DEPT_ID);
ALTER TABLE DEPT_COPY ADD CONSTRAINT UQ_DCOPY_DTITLE UNIQUE(DEPT_TITLE);
ALTER TABLE DEPT_COPY MODIFY LNAME CONSTRAINT NN_DCOPY_LNAME NOT NULL;

-- �� ���� �� �� ����
ALTER TABLE DEPT_COPY 
ADD CONSTRAINT PK_DCOPY_DID PRIMARY KEY(DEPT_ID)
ADD CONSTRAINT UQ_DCOPY_DTITLE UNIQUE(DEPT_TITLE) -- ���� �� ������ ����
MODIFY LNAME CONSTRAINT NN_DCOPY_LNAME NOT NULL;

-- ���� ���� ����
ALTER TABLE DEPT_COPY
DROP CONSTRAINT PK_DCOPY_DID;

-- �� ���� ����
ALTER TABLE DEPT_COPY
DROP CONSTRAINT UQ_DCOPY_DTITLE
DROP CONSTRAINT SYS_C007695
MODIFY LNAME NULL;
-- DROP�� MODIFY �Ʒ��� ���� ���� �߻�
-- ORA-00933: SQL ���ɾ �ùٸ��� ������� �ʾҽ��ϴ�

-- �̸� ����
SELECT * FROM DEPT_COPY;

ALTER TABLE DEPT_COPY
RENAME COLUMN DEPT_TITLE TO DEPT_NAME;

COMMIT;
-- �������� �̸� ����
ALTER TABLE DEPT_COPY
RENAME CONSTRAINT SYS_C007696 TO NN_DCOPY_LID;
--             ���� ���� RENAME ����

ALTER TABLE DEPT_COPY
RENAME TABLE DEPT_COPY TO DEPT_TEST; -- ����

ALTER TABLE DEPT_COPY
RENAME TO DEPT_TEST; -- �̹� ���� TABLE DEPT_COPY�� ���� ��� ������ �� ���� �� �ص� ��
-- ���̺� �̸� ���� ����

-- ���̺� ����
DROP TABLE DEPT_TEST;

-- ���� ���� ����
DROP TABLE DEPT_TEST 
CASCADE CONSTRAINTS;