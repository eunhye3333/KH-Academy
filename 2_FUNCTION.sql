-- �Լ� : �÷��� ���� �о ����� ��� ����
-- ������ �Լ� : �÷��� ��ϵ� n���� ���� �о� n���� ��� ����
-- �׷� �Լ� : �÷��� ��ϵ� n���� ���� �о� 1���� ��� ����
-- �������Լ� �׷��Լ��� �Բ� ����� �� ���� : ��� ���� ������ �ٸ��� ����

-- ������ �Լ�
-- 1. ���� ���� �Լ�
-- LENGTH/LENGTHB
SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ')
FROM DUAL; -- DUAL�� ���� ���̺��� ����
-- FROM EMPLOYEE�� �ص� �Ǵµ� �׷��� ����� ��� �࿡ ���ؼ� ��µ�
-- LENGTH : ������ ���̸� ��ȯ
-- LENGTHB : BYTE�� ũ�⸦ ��ȯ. �ѱ� �� ���ڴ� 3BYTE

SELECT LENGTH(EMAIL), LENGTHB(EMAIL)
FROM EMPLOYEE;
-- ����, ���� Ư�����ڴ� 1BYTE�� �ν�

-- INSTR : �ش� ���ڿ��� ��ġ�� ��ȯ. JAVA�� 0���� ���� �� �⺻������ Oracle�� 1���� ��
SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL;
-- ���� ���� ������ B�� ��ġ ��ȯ
SELECT INSTR('AABAACAABBAA', 'Z') FROM DUAL;
-- ���� ���ڸ� �ִ� ��� 0�� ����. JAVA������ ��ġ�ϱ� ������ -1�� ��ȯ�ߴµ� Oracle������ 0�̶�� ��ġ�� �����Ƿ� ���� ��� 0 ��ȯ
SELECT INSTR('AABAACAABBAA', 'B', 1) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', 7) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', 1, 2) FROM DUAL;

-- EMPLOYEE ���̺��� �̸����� @ ��ġ ��ȯ
SELECT INSTR(EMAIL, '@') FROM EMPLOYEE;

-- LPAD/RPAD
-- ������ ���ڸ�ŭ�� ������ ����� ���� ���� ������ ������ ���ڷ� ����/�����ʿ� ä�� ����
SELECT LPAD(EMAIL, 20) FROM EMPLOYEE;
SELECT LPAD(EMAIL, 20, '#') FROM EMPLOYEE; -- �պκ��� #���� ä������ ����
SELECT RPAD(EMAIL, 20, '#') FROM EMPLOYEE;

-- LTRIM/RTRIM/TRIM : �ش� �κ�(����/������/��ü)�� ���� �Ǵ� �ش��ϴ� ���ڸ� ������ ��
-- LTRIM : ���� �κ� ����
SELECT LTRIM('   KH') FROM DUAL;
SELECT LTRIM('KH   ') A FROM DUAL;
SELECT LTRIM('   KH', ' ') FROM DUAL;
SELECT LTRIM('00012345', '0') FROM DUAL;
SELECT LTRIM('123123KH', '123') FROM DUAL;
SELECT LTRIM('123123KH123', '123') FROM DUAL;
SELECT LTRIM('ACBBAKH', 'ABC') FROM DUAL;

SELECT PHONE, LTRIM(PHONE, '010') FROM EMPLOYEE; 
-- ���� 010�� ��ȣ�鸸 ����� ���� ����ߴµ� 0 �Ǵ� 1�� ����ٴ� ���̱� ������ ���ϴ� ����� ��� �� ��

-- RTRIM : ������ �κ� ����
SELECT RTRIM('KH   ') A FROM DUAL;
SELECT RTRIM('123123KH', '123') FROM DUAL;

SELECT EMAIL, RTRIM(EMAIL, '@kh.or.kr') FROM EMPLOYEE;
-- ���� ���ڿ��� �ϳ��� ���ڿ��� �ν����� �ʰ� ������ ���ڷ� �ν��Ͽ� ����� ������ ������ �ʴ� �κе� ������

-- TRIM : ���� ����(���������� �ʴ� ���), ������ ������ ������ ����
SELECT TRIM('   KH   ') A FROM DUAL;
SELECT TRIM('Z' FROM 'ZZZKHZZZ') FROM DUAL;
--SELECT TRIM('123' FROM '123123KH12') FROM DUAL; -- Ʈ�� ������ �ϳ��� ���ڸ� ����
SELECT TRIM(LEADING 'Z' FROM'ZZZKHZZZ') FROM DUAL; -- �տ�������
SELECT TRIM(TRAILING 'Z' FROM'ZZZKHZZZ') FROM DUAL; -- �ڿ�������
SELECT TRIM(BOTH 'Z' FROM'ZZZKHZZZ') FROM DUAL; -- ���� ���


-- SUBSTR = Strig.subString() ���� ���ϴ� ��ġ�� �ִ� ���ڿ� �Ϻ� ��ȯ
SELECT SUBSTR('SHOWMETHEMONEY', 7) FROM DUAL;
-- 7��° ���ں��� ������ ��ȯ
SELECT SUBSTR('SHOWMETHEMONEY', 5, 2) FROM DUAL;
-- 5��°���� 2���� ��ȯ
SELECT SUBSTR('SHOWMETHEMONEY', 5, 0) FROM DUAL; -- NULL ��ȯ��
SELECT SUBSTR('SHOWMETHEMONEY', -8, 3) FROM DUAL;
-- -8��°(�ڿ������� 8��°)���� 3���� ��ȯ��. �Ųٷ� ��ȯ���� ����. THE ��ȯ

-- EMPLOYEE ���̺��� �̸�, �̸���, @ ���ĸ� ������ ���̵� ��ȸ
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@') -1) ���̵�  FROM EMPLOYEE;

-- �ֹε�Ϲ�ȣ�� �̿��Ͽ� ��/�� �Ǵ��Ͽ� �̸�, ���� ��ȸ
SELECT EMP_NAME, SUBSTR(EMP_NO, 8, 1) ���� FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ���ڸ� ��ȸ(��� ��, '��')
SELECT EMP_NAME �����, '��' ����
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = 1;

-- EMPLOYEE ���̺��� ���ڸ� ��ȸ(��� ��, '��')
SELECT EMP_NAME �����, '��' ����
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = 2;

-- EMPLOYEE ���̺��� �������� �ֹι�ȣ�� �̿��Ͽ� �����, ����, ����, ���� ��ȸ
SELECT EMP_NAME �����, SUBSTR(EMP_NO, 1, 2) ����, SUBSTR(EMP_NO, 3, 2) ����, SUBSTR(EMP_NO, 5, 2) ����
FROM EMPLOYEE;

-- LOWER/UPPER/INITCAP
-- �� �ҹ��ڷ� / �� �빮�ڷ� / �ܾ��� ù ���ڸ� �빮�ڷ�
SELECT LOWER('Welcome To My World') LOWER, 
        UPPER('Welcome To My World') UPPER,
        INITCAP('Welcome To My World') INITCAP FROM DUAL;
SELECT INITCAP('WELCOME TO MY WORLD') INITCAP FROM DUAL;     

-- CONCAT : ���ڿ��� �ٿ� ��
SELECT CONCAT('�����ٶ�', '���ٻ�') FROM DUAL;
SELECT '�����ٶ�' || '���ٻ�' FROM DUAL; -- ����� ����

-- REPLACE : �ٲ� �ִ� ��
SELECT REPLACE('����� ������ ���ﵿ', '���ﵿ', '�Ｚ��') FROM DUAL;
SELECT REPLACE('�ڽſ찭����� G�����忡 �ֽ��ϴ�', '�����', '������') FROM DUAL;

-- EMPLOYEE ���̺��� �����, �ֹι�ȣ ��ȸ �ֹι�ȣ�� ������ϸ� ���̰� �ϰ� '-' ������ '*'�� ����
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 7), LENGTH(EMP_NO), '*') �ֹι�ȣ
FROM EMPLOYEE;

SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, INSTR(EMP_NO, '-')), LENGTH(EMP_NO), '*') �ֹι�ȣ
FROM EMPLOYEE;

SELECT EMP_NAME, REPLACE(EMP_NO, SUBSTR(EMP_NO, 8), '*******') �ֹι�ȣ
FROM EMPLOYEE;

SELECT EMP_NAME, REPLACE(EMP_NO, SUBSTR(EMP_NO, INSTR(EMP_NO, '-') + 1), '*******') �ֹι�ȣ
FROM EMPLOYEE;

SELECT EMP_NAME, SUBSTR(EMP_NO, 1, INSTR(EMP_NO, '-')) || '*******' �ֹι�ȣ
FROM EMPLOYEE;

-- 2. ���� ���� �Լ�
-- ABS : ���밪
SELECT ABS(10.9) FROM DUAL;
SELECT ABS(-10.9) FROM DUAL;

-- MOD : ������ ���
SELECT MOD(10, 3) FROM DUAL;
SELECT MOD(-10, 3) FROM DUAL;
SELECT MOD(10, -3) FROM DUAL; -- ��ȣ�� ���������� ���� ����

-- ROUND : �������� ������ ù��° �ڸ����� �ݿø�
SELECT ROUND(123.456) FROM DUAL;
SELECT ROUND(123.678) FROM DUAL;
SELECT ROUND(123.456, 0) FROM DUAL;
SELECT ROUND(123.456, 1) FROM DUAL; -- �Ҽ� ù ��° �ڸ����� ���
SELECT ROUND(123.456, 2) FROM DUAL;
SELECT ROUND(123.456, -1) FROM DUAL; -- ���� �ڸ����� �ݿø� : 120

-- FLOOR : ����, �ڸ��� ���� �Ұ��� -> ���������� ���ڸ� ������ ��
SELECT FLOOR(123.456) FROM DUAL;
SELECT FLOOR(123.678) FROM DUAL;

-- TRUNC : �Ҽ��� ������ ���ڸ� �����ϴ� ��, �ƿ� �ڸ��� ��
SELECT TRUNC(123.456) FROM DUAL;
SELECT TRUNC(123.678) FROM DUAL;

-- CEIL : �ø�
SELECT CEIL(123.456) FROM DUAL;
SELECT CEIL(123.678) FROM DUAL;

-- 3. ��¥ ���� �Լ�
-- SYSDATE : ���� ��¥�� ���� �Լ�
SELECT SYSDATE FROM DUAL;

-- MONTHS_BETWEEN : �������� ���̸� ���ڷ� ����
-- EMPLOYEE ���̺��� ����� �̸�, �Ի���, �ٹ� ������ ��ȸ
SELECT EMP_NAME, HIRE_DATE, MONTHS_BETWEEN(SYSDATE, HIRE_DATE)
FROM EMPLOYEE;

SELECT EMP_NAME, HIRE_DATE, MONTHS_BETWEEN(HIRE_DATE, SYSDATE)
FROM EMPLOYEE; -- ���� ��µ�

SELECT EMP_NAME, HIRE_DATE, ABS(MONTHS_BETWEEN(HIRE_DATE, SYSDATE))
FROM EMPLOYEE; -- ���밪�� �����ؾ� �Ǽ��ص� ������ �� ���� �� ����

SELECT EMP_NAME, HIRE_DATE, CEIL(ABS(MONTHS_BETWEEN(HIRE_DATE, SYSDATE))) || '������' ������
FROM EMPLOYEE; -- �ø� ó���� �ϸ� �������� ���� �� ����

-- ADD_MONTHS : ��¥�� ���ڸ�ŭ �������� ���Ͽ� ��¥ ����
SELECT ADD_MONTHS(SYSDATE, 2) FROM DUAL;
SELECT ADD_MONTHS(SYSDATE, 4) FROM DUAL; -- �⵵���� ����

-- NEXT_DAY : ���� ��¥���� ���Ϸ��� ���Ͽ� ���� ����� ��¥ ����
-- 1=�� / 2=�� / 3=ȭ / 4=�� / 5=�� / 6=�� / 7=��
SELECT SYSDATE, NEXT_DAY(SYSDATE, '�ݿ���') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 6) FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '��') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '������ �����ݾ�, ��ġ?') FROM DUAL;
-- ���� ����� �������� ��µ� => �� ���� ���̶�
--SELECT SYSDATE, NEXT_DAY(SYSDATE, '��ڿ� ���� �ڼ��� �����ּ���') FROM DUAL;
-- ���� ���� ���̱� ������ ������ ������ �������ϴٰ� ����
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'FRIDAY') FROM DUAL; -- ����� ������ �ٲ� ���� �ʴ� �̻� ���� �Ұ���
ALTER SESSION SET NLS_LANGUAGE = AMERICAN; -- ����� ���� �� ���� ����
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'FRI') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'FRISKJDLKSJLKD') FROM DUAL; -- ���� FRI�� ���� ����
ALTER SESSION SET NLS_LANGUAGE = KOREAN; -- �ѱ۷� ����

-- LAST_DAY : �ش� ���� ������ ��¥�� ���Ͽ� ����
SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL;

-- EMPLOYEE ���̺��� ��� ��, �Ի���-����, ����-�Ի��� ��ȸ �� ��Ī�� �ٹ��ϼ�1, �ٹ��ϼ�2�� �ϰ� ��� ����ó��(����)
SELECT EMP_NAME, FLOOR(HIRE_DATE - SYSDATE) �ٹ��ϼ�1, FLOOR(SYSDATE - HIRE_DATE) �ٹ��ϼ�2
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ����� Ȧ���� �������� ���� ��� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2) = 1;

-- EMPLOYEE ���̺��� �ٹ� ����� 20�� �̻��� ���� ���� ��ȸ
SELECT *
FROM EMPLOYEE
--WHERE (SYSDATE- HIRE_DATE) / 365 >= 20;
--WHERE MONTHS_BETWEEN(SYSDATE, HIRE_DATE) >= 240;
WHERE ADD_MONTHS(HIRE_DATE, 240) <= SYSDATE;

-- EMPLOYEE ���̺��� ��� ��, �Ի���, �Ի��� ���� �ٹ� �ϼ� ��ȸ
SELECT EMP_NAME, HIRE_DATE, LAST_DAY(HIRE_DATE) - HIRE_DATE + 1 �ٹ��ϼ�
FROM EMPLOYEE;

-- EXTRACT : ��, ��, �� ������ �����Ͽ� ������
-- EMPLOYEE ���̺��� ����� �̸�, �Ի� �⵵, �Ի� ��, �Ի���
SELECT EMP_NAME �̸�,
        EXTRACT(YEAR FROM HIRE_DATE) �Ի�⵵,
        EXTRACT(MONTH FROM HIRE_DATE) "�Ի� ��",
        EXTRACT(DAY FROM HIRE_DATE) "�Ի� ��"
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ����� �̸�, �Ի���, �ٹ� ��� ��ȸ
--      �� �ٹ������ ���� �⵵ - �Ի� �⵵�� ��ȸ
SELECT EMP_NAME, HIRE_DATE, EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) "�ٹ� ���"
FROM EMPLOYEE;

-- 4. ����ȯ �Լ�
-- TO_CHAR : ��¥��/������ �����͸� ������ �����ͷ� ����
SELECT TO_CHAR(1234), 1234 AAAAAAA FROM DUAL; -- ���ڴ� ���� ����, ���ڴ� ������ ����
SELECT TO_CHAR(1234, '99999') A FROM DUAL; -- 5�ڸ��� ���� �տ� ������ ��
SELECT TO_CHAR(1234, '00000') A FROM DUAL; -- �� �ڸ��� 0���� ä���δ� ��
SELECT TO_CHAR(1234, 'L99999') A FROM DUAL; -- ��ȭ ǥ�� ����
SELECT TO_CHAR(1234, 'FML99999') A FROM DUAL; -- ��ȭ ǥ���ε� �տ� ���� �����
SELECT TO_CHAR(1234, '$99999') A FROM DUAL;
SELECT TO_CHAR(1234, 'FM$99999') A FROM DUAL;
SELECT TO_CHAR(1234, '99,999') A FROM DUAL; -- �ڸ��� ����
SELECT TO_CHAR(1234, 'FM99,999') A FROM DUAL;
SELECT TO_CHAR(1234, '999') A FROM DUAL; -- �ڸ����� ǥ���� ���ں��� ������ ǥ���� �� ���� ������ ####���� ���

-- EMPLOYEE ���̺��� �����, �޿� ǥ��
-- �޿�'\9,000,000' �������� ǥ��
SELECT EMP_NAME, TO_CHAR(SALARY, 'FML999,999,999') �޿�
FROM EMPLOYEE;

SELECT TO_CHAR(SYSDATE, 'PM HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'AM HH:MI:SS') FROM DUAL; -- ���簡 ���Ķ� AM �ص� �����̶�� ������ ����
SELECT TO_CHAR(SYSDATE, 'AM HH24:MI:SS') FROM DUAL; -- 24�ð� ����
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-FMMM-DD DAY') FROM DUAL; -- FM�� ������ �տ� 0�� ���� 
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-FMDD DAY') FROM DUAL; -- �Ͽ��� 0�� ���� �޿��� 0�� �����Դ� �� ��
SELECT TO_CHAR(SYSDATE, 'YYYY"��" MM"��" DD"��" DAY') FROM DUAL; -- ��, ��, ���� �������̱� ������ ""�� ���� ��� ��

SELECT TO_CHAR(SYSDATE, 'YYYY'), 
        TO_CHAR(SYSDATE, 'YY'), 
        TO_CHAR(SYSDATE, 'YEAR')
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'MM'), 
        TO_CHAR(SYSDATE, 'MONTH'), 
        TO_CHAR(SYSDATE, 'MON'),
        TO_CHAR(SYSDATE, 'RM')
FROM DUAL;

SELECT TO_CHAR(HIRE_DATE, 'MM'), 
        TO_CHAR(HIRE_DATE, 'MONTH'), 
        TO_CHAR(HIRE_DATE, 'MON'),
        TO_CHAR(HIRE_DATE, 'RM')
FROM EMPLOYEE;

SELECT TO_CHAR(SYSDATE, 'DDD') "1�� ����", 
        TO_CHAR(SYSDATE, 'DD') "�� ����", 
        TO_CHAR(SYSDATE, 'D') "�� ����" -- �� �������� 5��°
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'Q'), -- �б�
        TO_CHAR(SYSDATE, 'DAY'),
        TO_CHAR(SYSDATE, 'DY')
FROM DUAL;

-- EMPLOYEE ���̺��� �̸�, �Ի��� ��ȸ
--    �Ի��� : 0000�� 00�� 00�� (0)
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY"��" MM"��" DD"�� ("DY")"') �Ի���
FROM EMPLOYEE;

-- TO_DATE : ���ڻ� �ƴ϶� ���ڱ��� ��¥�� �����ͷ� ����
SELECT TO_DATE('20200202', 'YYYYMMDD') FROM DUAL;
SELECT TO_DATE(20200202, 'YYYYMMDD') FROM DUAL;

SELECT TO_CHAR(TO_DATE('20200202 153824', 'YYYYMMDD HH24MISS'), 'YYYY-MM-DD HH:MI:SS') FROM DUAL;

-- TO_DATE���� �� �ڸ� ������ YY�� �����Ű�� ������ ���� ����(21����, 2000���)�� ����
--                          RR�� �����Ű�� �� �ڸ� ���� ���� 50 �̻��� ���� ���� ����(20����, 1900���),
--                                                        50 �̸��� ���� ���� ����(21����, 2000���) ���� 
-- ���ڸ� ��¥�� �ٲ� ���� R�� ����ϴ� �� ���� �� ����
SELECT TO_CHAR(TO_DATE('990311', 'YYMMDD'), 'YYYYMMDD') "99YY", -- 20990311
        TO_CHAR(TO_DATE('070108', 'YYMMDD'), 'YYYYMMDD') "07YY", -- 20070108
        TO_CHAR(TO_DATE('990311', 'RRMMDD'), 'YYYYMMDD') "99RR", -- 19990311
        TO_CHAR(TO_DATE('070108', 'RRMMDD'), 'YYYYMMDD') "07RR" -- 20070108
FROM DUAL;

-- TO_NUMBER : ������ �����͸� ������ �����ͷ� ���� (��¥�� �Ұ���)
SELECT TO_NUMBER('12345') FROM DUAL;
SELECT 1111 + 2222 FROM DUAL;
SELECT '1111' + '2222' FROM DUAL; -- ���ڵ� �˾Ƽ� ���ڷ� ����� ��
--SELECT '1,111' + '2,222' FROM DUAL; -- ������ �̷��Դ� �� �� �߰��� ���ڰ� ����
SELECT TO_NUMBER('1,111', '999,999') + TO_NUMBER('2,222', '9,999')
FROM DUAL;

-- 5. NULL ó�� �Լ�
-- NVL : ���� �Ϳ��� ����
SELECT EMP_NAME, BONUS, NVL(BONUS, 0), -- NULL�� ��� �� 0�� ����
        NVL(DEPT_CODE, '�μ�X') -- ���ڸ� �ִ� �� �ƴ϶� ���ڸ� ���� ���� ����
FROM EMPLOYEE;

-- NVL2 : �ִ� �Ͱ� ���� �� ���
SELECT EMP_NAME, BONUS, NVL2(BONUS, 0.7, 0.5) -- ���ʽ��� ���� ������ 0.7, NULL�̸� 0.5
FROM EMPLOYEE;

-- NULLIF : ���Ͽ� ���ٰ� ���� �� ����, �ٸ� �� ����
SELECT NULLIF(123, 123), NULLIF(123, 132) FROM DUAL;
-- ���� ������ NULL ��ȯ, �ٸ��� ���� �� ��ȯ

-- 6. ���� �Լ�
-- ���� ���� ��찡 ���� �� �����ϴ� ���
-- DECODE : DECODE(����|�÷���, ���ǰ�1, ���ð�1, ���ǰ�2, ���ð�2, ...)
-- ���ϰ��� �ϴ� ��/�÷��� ���ǽİ� ������ �� �ڿ� �ִ� ���ð� ��ȯ
SELECT EMP_ID, EMP_NAME, EMP_NO,
        DECODE(SUBSTR(EMP_NO, 8, 1), 1, '��', 2, '��') ���� -- 1�̸� ��, 2�� ��
FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, EMP_NO,
        DECODE(SUBSTR(EMP_NO, 8, 1), 1, '��', '��') ���� -- 1�̸� ��, �������� �� �� => ����� 1 �ƴϸ� 2�̱� ������ �̷��� �ᵵ ��
FROM EMPLOYEE;

-- ���� �ڵ尡 J7�̸� ������ �޿��� 10% �λ�
-- ���� �ڵ尡 J6�̸� ������ �޿��� 15% �λ�
-- ���� �ڵ尡 J5�̸� ������ �޿��� 20% �λ�
-- �� �� ������ �޿��� 5% �λ�
-- ������, ���� �ڵ�, �޿�, �λ� �޿�
SELECT EMP_NAME, JOB_CODE, SALARY, 
        DECODE(JOB_CODE, 'J7', SALARY * 1.1, 
                         'J6', SALARY * 1.15, 
                         'J5', SALARY * 1.2, SALARY * 1.05) "�λ� �޿�"
FROM EMPLOYEE;

SELECT EMP_NAME, JOB_CODE, SALARY, 
        SALARY * (1 + DECODE(JOB_CODE, 'J7', 0.1, 
                                       'J6', 0.15, 
                                       'J5', 0.2, 0.05)) "�λ� �޿�"
FROM EMPLOYEE;

-- CASE WHEN
-- CASE WHEN ���ǽ� THEN �����
--      WHEN ���ǽ� THEN �����
--      ELSE �����
-- END
-- DECODE�� ������ �Ұ����ߴµ� CASE WHEN�� ���������� ����
-- ���ϰ��� �ϴ� �� �Ǵ� �÷��� ���ǽİ� ������ ����� ��ȯ
-- ������ ������ ����
SELECT EMP_ID, EMP_NAME, EMP_NO, 
        CASE WHEN SUBSTR(EMP_NO, 8, 1) = 1 THEN '����'
              WHEN SUBSTR(EMP_NO, 8, 1) = 2 THEN '����'
        END ����
FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, EMP_NO, 
        CASE WHEN SUBSTR(EMP_NO, 8, 1) = 1 THEN '����'
              ELSE '����' -- 1 �ƴϸ� 2�� 
        END ����
FROM EMPLOYEE;

-- ���� �ڵ尡 J7�̸� ������ �޿��� 10% �λ�
-- ���� �ڵ尡 J6�̸� ������ �޿��� 15% �λ�
-- ���� �ڵ尡 J5�̸� ������ �޿��� 20% �λ�
-- �� �� ������ �޿��� 5% �λ�
-- ������, ���� �ڵ�, �޿�, �λ� �޿�
SELECT EMP_NAME, JOB_CODE, SALARY, 
        CASE WHEN JOB_CODE = 'J7' THEN SALARY * 1.1
             WHEN JOB_CODE = 'J6' THEN SALARY * 1.15
             WHEN JOB_CODE = 'J5' THEN SALARY * 1.2
             ELSE SALARY * 1.05
        END �λ�޿�
FROM EMPLOYEE;

SELECT EMP_NAME, JOB_CODE, SALARY, 
        CASE JOB_CODE WHEN 'J7' THEN SALARY * 1.1
                       WHEN 'J6' THEN SALARY * 1.15
                       WHEN 'J5' THEN SALARY * 1.2
                       ELSE SALARY * 1.05
        END �λ�޿�
FROM EMPLOYEE;

-- ���, ��� ��, �޿�, ��� ��ȸ
-- ��� ���� : �޿��� 500������ ũ�� 1���, 350������ ũ�� 2���, 200������ ũ�� 3��� �������� 4���
SELECT EMP_ID, EMP_NAME, SALARY,
        CASE WHEN SALARY > 5000000 THEN '1���'
              WHEN SALARY > 3500000 THEN '2���'
              WHEN SALARY > 2000000 THEN '3���'
              ELSE '4���'
        END ���
FROM EMPLOYEE;

-- ���, �����, �޿�
-- �޿��� 500���� �̻��̸� '���'
-- �޿��� 300~500�����̸� '�߱�'
-- �� ���ϴ� �ʱ����� ���ó���ϰ� ��Ī�� '����'���� �Ѵ�.
SELECT EMP_ID, EMP_NAME, SALARY,
        CASE WHEN SALARY >= 5000000 THEN '���'
             WHEN SALARY >= 3000000 THEN '�߱�'
             ELSE '�ʱ�'
        END ���
FROM EMPLOYEE;

-- �׷��Լ�
-- SUM
-- EMPLOYEE ���̺��� �� ����� �޿� ����
SELECT SUM(SALARY)
FROM EMPLOYEE; -- ��� 1���� ���

--SELECT SUM(SALARY), SALARY
--FROM EMPLOYEE; -- ��� �� ��. ���� ������ �޶�

-- EMPLOYEE ���̺��� ���� ����� �޿� ���� ��ȸ
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = 1;

-- EMPLOYEE ���̺��� �μ� �ڵ尡 D5�� ������ ���ʽ� ���Ե� ���� �հ� ��ȸ
SELECT SUM((SALARY + (SALARY * NVL(BONUS, 0))) *12)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- AVG
-- EMPLOYEE ���̺��� �� ����� �޿� ��� ���ϱ�
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� �� ����� ���ʽ� ����� �Ҽ� ��°�ڸ����� �ݿø�
SELECT AVG(BONUS)
FROM EMPLOYEE; -- 0.2166666666666666666666666666666666666667

SELECT ROUND(AVG(BONUS), 2) -- null�� ���� ���� ��տ��� ���ܵ� ���� ��Ȯ���� �ʴ�
FROM EMPLOYEE; -- 0.22

SELECT ROUND(AVG(NVL(BONUS, 0)), 2) 
FROM EMPLOYEE; -- 0.08

SELECT AVG(BONUS), AVG(DISTINCT BONUS), AVG(NVL(BONUS, 0))
FROM EMPLOYEE;

-- MIN/MAX : ���� ����/ū ��, ���� ����, ��¥ ���� ����
-- EMPLOYEE ���̺��� ���� ���� �޿�, ���ĺ� ������ ���� ���� �̸���, ���� ���� �Ի��� ��ȸ
SELECT MIN(SALARY), MIN(EMAIL), MIN(HIRE_DATE)
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ���� ���� �޿�, ���ĺ� ������ ���� ���� �̸���, ���� �ֱ� �Ի��� ��ȸ
SELECT MAX(SALARY), MAX(EMAIL), MAX(HIRE_DATE)
FROM EMPLOYEE;

-- COUNT 
-- COUNT(�÷���) : NULL�� ���ܵ� �ش� �÷��� ���� ���� ����
-- COUNT(DISTINCT �÷���) : �ߺ��� ���ŵ� �� ���� ����
-- COUNT(*) : NULL�� ������ ��ü �� ���� ����
-- ��ü ��� ��, �μ� �ڵ尡 �ִ� ��� ��, ������� ���� �ִ� �μ��� ��
SELECT COUNT(*), COUNT(DEPT_CODE), COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE;

