-- SEQUENCE : �ڵ� ��ȣ �߻���
CREATE SEQUENCE SEQ_EMPID
START WITH 300 -- ���� ����
INCREMENT BY 5 -- ���� ����
MAXVALUE 310 -- �ִ밪
NOCYCLE -- ����Ŭ�� ���� ����
NOCACHE; -- �޸� �󿡼� �������� ����

SELECT * FROM USER_SEQUENCES;
-- ����� ���� ������ ���� Ȯ��

-- ������ ���
-- ��������.CURRVAL : ���� ������ ������ �� (NEXTVAL�� ���� ���������� ���ϵ� ��)
-- ��������.NEXTVAL : �������� ������Ŵ �Ǵ� ���ʷ� �������� �����Ű�� ����

SELECT SEQ_EMPID.CURRVAL FROM DUAL; 
-- ORA-08002: ������ SEQ_EMPID.CURRVAL�� �� ���ǿ����� ���� �Ǿ� ���� �ʽ��ϴ�

SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- 300
SELECT SEQ_EMPID.CURRVAL FROM DUAL; -- NEXTVAL�� ���� �����߱� ������ ����� : 300
SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- 305
SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- 310
SELECT SEQ_EMPID.CURRVAL FROM DUAL; -- 310

SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- ORA-08004: ������ SEQ_EMPID.NEXTVAL exceeds MAXVALUE�� ��ʷ� �� �� �����ϴ�
-- 310�� MAXVALUE�̱� ������ �� ������Ű���� �ϸ� ���� �߻�

CREATE SEQUENCE SEQ_EID
START WITH 300
NOCYCLE
NOCACHE;

INSERT INTO EMPLOYEE
VALUES(SEQ_EID.NEXTVAL, '���ǰ�', '111111-1111111', 'kang_kk@kh.or.kr', '01011112222',
       'D2', 'J3', 'S1', 5000000, 0.1, 200, SYSDATE, NULL, DEFAULT);

SELECT * FROM EMPLOYEE;

ROLLBACK;

-- ������ ���� : ALTER
-- START WITH�� ���� �Ұ��� => DROP �� �����
ALTER SEQUENCE SEQ_EMPID
INCREMENT BY 10
MAXVALUE 400
CYCLE
NOCACHE;

SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- CYCLE�� �ٲ㼭 ���� �Ѿ�� �ٽ� 1�� ���ư�
