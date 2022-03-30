/*
���� �� �ּ�
*/
-- �� �� �ּ�

-- ������ ����: �����ͺ��̽��� ������ ������ ����ϴ� ���� ���� ����
--			   ������Ʈ ����, ����, ���� ���� �۾� ����.
--			   ������ ���̽��� ���� ��� ���� �� å���� ����
-- ����� ����: �����ͺ��̽��� ���� ����(Query), ����, ������ �ۼ� ���� �۾��� ������ �� �ִ� ����
--               �Ϲ� ������ ������ ���� ������ �ʿ��� �ּ����� ���� ������ ���� ��Ģ���� ��

-- 11g ����
--CREATE USER KH IDENTIFIED BY KH; -- ���� ���� ����
--������   ����      ��й�ȣ�� �����ϰڴ�
--   ������ ������ �̸�       ������ ��й�ȣ

-- 18c ������ ��ó�� �Ұ� (12c���� �Ұ���)
-- �Ʒ�ó�� �ؾ� ��
--CREATE USER c##KH IDENTIFIED BY KH; -- �տ� c## �߰�, c�� ��ҹ��� �������

-- c##�� ���̴� ���� ���ŷӱ� ������ ���� ����ó�� �� ���̰��� ���� ������ �� �ִ� ���� ����
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE; -- �巡�� �� ��� ��ư ������ ���� ����
CREATE USER KH IDENTIFIED BY KH; -- �����Ű�� ���� ���忡 Ŀ���� �ΰ� �����ص� ���� ����
-- ���� ����Ű : CTRL + ENTER
GRANT CONNECT, RESOURCE TO KH; -- KH���� CONNECT�� RESOURCE ������ �ְڴ�(���� �ο� ����)

--  ���� ���Ǿ�(DD: Data Dictionary): ������ ����, �����ͺ��̽��� �������� �����͸� ������ DB ���ݿ� ���� ��� ������ ������ �ִ� ��. �����ϴ� ��
--                                   System(������)�� DD�� ���� ������ ������ �� �ִ� ������ ������ �ְ�
--								   	����� ������ �ܼ��ϰ� �о��� �� ���� ����(�ܼ� ��ȸ�� ����, �б� ���� ���·� ������)
--  �� �κ��� �����ڴ� �ش� sql ������ �̸���. 

-- ���̺� : ��(row)�� ��(column)�� �����Ǵ� ���� �⺻���� �����ͺ��̽� ��ü(���⿡���� ���Ǵ� ������Ʈ���� �� ��ü��� ��)
--         �����ͺ��̽� ������ ��� �����ʹ� ���̺��� ���� ����
-- �ε��� : �����͸� ���ǿ� �´� �����͸� ��ȸ�ϰ� ���� �� ���ϴ� ������ ������ ������ �� �ֵ��� �ϴ� ��ü
--         60���ǿ����� �ε����� �ִ� �Ͱ� ���� ���� ���ǹ��� ���̰� ���� �����̸Ӹ�Ű ��ü�� �ε����� ������ �ִ� Ű�� �ƿ� �� �ٷ����� ����
--         �˻� ������ ����ȭ�ϱ� ���� �����ͺ��̽� �� ����� ������ �����ϴ� ������ ����
--         �ε����� �̿��ϸ� ��ü �����͸� �˻����� �ʰ� �����ͺ��̽����� ���ϴ� ������ ������ �˻� ����
alter user KH default tablespace system quota unlimited on system;
-- KH�� �ִ� tablespace�� system�� ���� �뷮�� ������ ���� �ʵ��� ����ڴ�
-- DB������ ��ҹ��ڸ� �������� �ʾƵ� ������ �̸��̳� ��й�ȣ, ���ͷ� ���� ��ҹ��ڸ� ��������� ��(���ɾ�� ��ҹ��� �� ����)

create user SCOTT identified by SCOTT;
grant resource, connect to SCOTT;
alter user SCOTT default tablespace system quota unlimited on system;

CREATE USER CHOON IDENTIFIED BY CHOON;
GRANT RESOURCE, CONNECT TO CHOON;
ALTER USER CHOON DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;