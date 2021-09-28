-- PL/SQL
-- �����          DECLARE     ����, ��� ����
-- �����          BEGIN       ���� ���
-- ����ó����      EXCEPTION   ���� �߻� �� �ذ� ���� ���
-- DECLARE�� EXCEPTION�� ��� ��

/*
        // ���� ���� ���� ����
        System.out.println(10);
        
        // ���� ���� �� ����
        int a = 10
        System.out.println(a);
        
        1�� DECLARE�� ��� ��
*/

SET SERVEROUTPUT ON; 
-- ����� ȭ�鿡 �����ֵ��� �ϴ� ����
-- ������ �� �ϸ� DBMS_OUTPUT.PUT_LINE �ص� �� ��

BEGIN 
    DBMS_OUTPUT.PUT_LINE('HELLO WORLD');
END;
/ 
-- �����ñ��� �־�� ��. END�� PL/SQL�� �����ٴ� ��. /�� ������ ����

/*
        int empId;
        String empName;
        
        final int PI = 3.14;
        
        empId = 800;
        empName = "������";
        
        System.out.println("empId : " + empId);
        System.out.println("empName : " + empName);
*/
-- PL/SQL�� �ű��

DECLARE -- ����� ����
    EMP_ID NUMBER; -- ������ �ڷ��� ����
    EMP_NAME VARCHAR2(30);
    PI CONSTANT NUMBER := 3.14; -- ���
    -- PL/SQL������ ������ �׳� =�� �ƴ϶� :=�� ����ؾ� ��
BEGIN
    EMP_ID := 800;
    EMP_NAME := '������';
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
END;
/

DECLARE
    EMP_ID NUMBER;
    EMP_NAME VARCHAR2(30);
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO EMP_ID, EMP_NAME -- SELECT�� �̿��� ������ �� ������ ����
    FROM EMPLOYEE
    WHERE EMP_ID = 200;
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
END;
/

DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE; 
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    -- �������� �÷��� Ÿ�԰� �����ϰ� ��
    -- ������ Ÿ���� �����ؼ� ���� ���̱� ������ ���۷��� ������� ��
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO EMP_ID, EMP_NAME 
    FROM EMPLOYEE
    WHERE EMP_ID = 200;
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
END;
/

-- ����ڿ��� �� �Է¹ޱ�
DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE; 
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO EMP_ID, EMP_NAME 
    FROM EMPLOYEE
--    WHERE EMP_ID = '&EMP_ID'; 
    WHERE EMP_ID = '&���';
    -- & : ��ü ���� �Է� (�� �Է�)
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
END;
/

-- ���۷��� ������ EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY�� �����ϰ�
-- EMPLOYEE ���̺��� ���, �̸�, �����ڵ�, �μ��ڵ�, �޿��� ��ȸ �� ������ ���۷��� ������ ��� ���
-- ��, �Է¹��� �̸��� ��ġ�ϴ� ������ ���� ��ȸ
DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    DEPT_CODE EMPLOYEE.DEPT_CODE%TYPE;
    JOB_CODE EMPLOYEE.JOB_CODE%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
BEGIN 
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY -- �̸��� ���ٰ� �˾Ƽ� ���ԵǴ� ���� �ƴϱ� ������ ������ ������� ��
    INTO EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
    FROM EMPLOYEE
    WHERE EMP_NAME = '&�̸�';
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('DEPT_CODE : ' || DEPT_CODE);
    DBMS_OUTPUT.PUT_LINE('JOB_CODE : ' || JOB_CODE);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || SALARY);
END;
/

-- ���۷��� ������ ���� ���� ���ŷο� => �� �࿡ ���ؼ� ��������
DECLARE
    E EMPLOYEE%ROWTYPE;
    -- %ROWTYPE : �࿡ ���� ��������, ũ��, �Ӽ��� ��� ����
BEGIN
    SELECT * 
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
--    DBMS_OUTPUT.PUT_LINE('E : ' || E); -- PLS-00306: '||' ȣ�� �� �μ��� ������ ������ �߸��Ǿ����ϴ� => E�� �� ���� ���� �� ����
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || E.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('EMP_NO : ' || E.EMP_NO);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || E.SALARY);   
END;
/

-- if / if~else / if~else if~else
-- IF ~ THEN ~ END IF (���� IF��)
-- EMP_ID�� �Է¹޾� ���, �̸�, �޿�, ���ʽ��� ���
-- ���ʽ��� ���� �ʴ� ����� ���ʽ��� ��� �� '���ʽ��� ���޹��� �ʴ� ����Դϴ�' ���
DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN 
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || E.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || E.SALARY);
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || E.BONUS);
END;
/

DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN 
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS, 0)
    INTO EMP_ID, EMP_NAME, SALARY, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || SALARY);
    
    IF(BONUS = 0)
        THEN DBMS_OUTPUT.PUT_LINE('���ʽ��� ���޹��� �ʴ� ����Դϴ�');
    END IF;
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || BONUS * 100 || '%');
END;
/

DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN 
    SELECT EMP_ID, EMP_NAME, SALARY, BONUS
    INTO EMP_ID, EMP_NAME, SALARY, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || SALARY);
    
    IF(BONUS IS NULL) -- NVL�� ������� ���� ���
        THEN DBMS_OUTPUT.PUT_LINE('���ʽ��� ���޹��� �ʴ� ����Դϴ�');
    END IF;
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || BONUS * 100 || '%');
END;
/

-- IF~THEN~ELSE~END IF(if ~ else��)
-- EMP_ID �� �Է¹޾� �ش� ����� ���, �̸�, �μ���, �Ҽ� ���
-- TEAM ������ ����� �Ҽ��� KO�� ������, �ƴϸ� �ؿ� ������ ����
DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    DEPT_TITLE DEPARTMENT.DEPT_TITLE%TYPE;
    TEAM VARCHAR2(30);
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE, DECODE(NATIONAL_CODE, 'KO', '���� ��', '�ؿ� ��')
    INTO EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE
    FROM EMPLOYEE
         LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
         LEFT JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID)
    WHERE EMP_ID = '&���';
END;
/

DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    DEPT_TITLE DEPARTMENT.DEPT_TITLE%TYPE;
    NATIONAL_CODE LOCATION.NATIONAL_CODE%TYPE;
    TEAM VARCHAR2(20);
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE
    INTO EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE
    FROM EMPLOYEE
         LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
         LEFT JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID)
    WHERE EMP_ID = '&���';
    
    IF(NATIONAL_CODE = 'KO')
        THEN TEAM := '������';
    ELSE
        TEAM := '�ؿ���';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('�μ� : ' || DEPT_TITLE);
    DBMS_OUTPUT.PUT_LINE('�Ҽ� : ' || TEAM);
END;
/

-- ����ڿ��� ����� �޾ƿ� �� ����� ��ü ������ VEMP�� ����
-- VEMP�� �̿��Ͽ� ���� ���(���ʽ��� ���� ��� ���ʽ� �����Ͽ� ���)
-- ���� ��� ���� YSALARY�� ����
-- �޿� �̸� ����(\1,000,000) ���� ���
CREATE OR REPLACE VIEW VEMP
AS
SELECT * FROM EMPLOYEE 
WHERE EMP_ID = '&���';

SELECT * FROM VEMP;

DECLARE
    SALARY EMPLOYEE.SALARY%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    YSALARY VARCHAR2(30);
BEGIN
    SELECT SALARY, EMP_NAME, TO_CHAR((SALARY + (SALARY * NVL(BONUS, 0))) * 12, 'FML999,999,999') ����
    INTO SALARY, EMP_NAME, YSALARY
    FROM VEMP;
        
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || SALARY);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('���� : ' || YSALARY);
    
END;
/

-- Ǯ��
DECLARE
    VEMP EMPLOYEE%ROWTYPE;
    YSALARY NUMBER;
BEGIN
    SELECT *
    INTO VEMP
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    IF(VEMP.BONUS IS NULL)
        THEN YSALARY := VEMP.SALARY * 12;
    ELSE
        YSALARY := VEMP.SALARY * (1 + VEMP.BONUS) * 12;
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(VEMP.SALARY || ' ' || VEMP.EMP_NAME || ' ' || 
                         TO_CHAR(YSALARY, 'FML999,999,999'));
    
END;
/

-- IF ~ THEN ~ ELSIF ~ THEN ~ ELSE ~ END IF (IF ~ ELSE IF ~ ELSE��)
-- ������ �Է¹޾� SCORE�� ����
-- 90�� �̻��̸� A, 80�� �̻��̸� B, 70�� �̻��̸� C, 60�� �̻��̸� D, �� �� F
-- ����� GRADE ������ ����
-- ����� ������ SOCRE���̰� ������ GRADE�����Դϴ� ���
DECLARE
    SCORE NUMBER;
    GRADE CHAR(1);
BEGIN
    SCORE := '&����';

    IF(SCORE >= 90) -- �Ұ�ȣ�� ���� �ʾƵ� �� : IF SCORE >= 90
        THEN GRADE := 'A';
    ELSIF(SCORE >= 80)
        THEN GRADE := 'B';
    ELSIF(SCORE >= 70)
        THEN GRADE := 'C';
    ELSIF(SCORE >= 60)
        THEN GRADE := 'D';
    ELSE
        GRADE := 'F';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('����� ������ ' || SCORE || '���̰� ������ ' || GRADE || '�����Դϴ�');
END;
/
    
-- CASE ~ WHEN ~ THEN ~ END (SWITCH ~ CASE ��)
-- ����� �Է��Ͽ� �ش� ����� ���, �̸�, �μ� �� ���
-- D1 �λ������ / D2 ȸ������� / D3 �����ú� / D4 ���������� 
-- D5 �ؿܿ���1�� / D6 �ؿܿ���2�� / D7 �ؿܿ���3�� / D8 ��������� / D9 �ѹ���
-- IF ���
DECLARE 
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    DEPT_CODE EMPLOYEE.DEPT_CODE%TYPE;
    DEPT_TITLE VARCHAR2(30);
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
    INTO EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    IF DEPT_CODE = 'D1' THEN DEPT_TITLE := '�λ������';
    ELSIF DEPT_CODE = 'D2' THEN DEPT_TITLE := 'ȸ�������';
    ELSIF DEPT_CODE = 'D3' THEN DEPT_TITLE := '�����ú�';
    ELSIF DEPT_CODE = 'D4' THEN DEPT_TITLE := '����������';
    ELSIF DEPT_CODE = 'D5' THEN DEPT_TITLE := '�ؿܿ���1��';
    ELSIF DEPT_CODE = 'D6' THEN DEPT_TITLE := '�ؿܿ���2��';
    ELSIF DEPT_CODE = 'D7' THEN DEPT_TITLE := '�ؿܿ���3��';
    ELSIF DEPT_CODE = 'D8' THEN DEPT_TITLE := '���������';
    ELSE DEPT_TITLE := '�ѹ���';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('�μ� �� : ' || DEPT_TITLE);
END;
/

DECLARE 
    E EMPLOYEE%ROWTYPE;
    DNAME DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    IF E.DEPT_CODE = 'D1' THEN DNAME := '�λ������';
    ELSIF E.DEPT_CODE = 'D2' THEN DNAME := 'ȸ�������';
    ELSIF E.DEPT_CODE = 'D3' THEN DNAME := '�����ú�';
    ELSIF E.DEPT_CODE = 'D4' THEN DNAME := '����������';
    ELSIF E.DEPT_CODE = 'D5' THEN DNAME := '�ؿܿ���1��';
    ELSIF E.DEPT_CODE = 'D6' THEN DNAME := '�ؿܿ���2��';
    ELSIF E.DEPT_CODE = 'D7' THEN DNAME := '�ؿܿ���3��';
    ELSIF E.DEPT_CODE = 'D8' THEN DNAME := '���������';
    ELSIF E.DEPT_CODE = 'D9' THEN DNAME := '�ѹ���';
    ELSE DNAME := '����X';
    END IF;

    DBMS_OUTPUT.PUT_LINE(E.EMP_ID || ' ' || E.EMP_NAME || ' ' || DNAME);
END;
/

DECLARE 
    E EMPLOYEE%ROWTYPE;
    DNAME DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
    SELECT * INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&EMP_ID';
    
        DNAME := CASE 
                WHEN E.DEPT_CODE = 'D1' THEN '�λ������'
                WHEN E.DEPT_CODE = 'D2' THEN 'ȸ�������'
                WHEN E.DEPT_CODE = 'D3' THEN '�����ú�'
                WHEN E.DEPT_CODE = 'D4' THEN '����������'
                WHEN E.DEPT_CODE = 'D5' THEN '�ؿܿ���1��'
                WHEN E.DEPT_CODE = 'D6' THEN '�ؿܿ���2��'
                WHEN E.DEPT_CODE = 'D7' THEN '�ؿܿ���3��'
                WHEN E.DEPT_CODE = 'D8' THEN '���������'
                WHEN E.DEPT_CODE = 'D9' THEN '�ѹ���'
                ELSE '����X'
            END;
        -- ���� ���� ���� ���� ��� ���ǽ����� �����൵ ��
    
--        DNAME := CASE E.DEPT_CODE
--                    WHEN 'D1' THEN '�λ������'
--                    WHEN 'D2' THEN 'ȸ�������'
--                    WHEN 'D3' THEN '�����ú�'
--                    WHEN 'D4' THEN '����������'
--                    WHEN 'D5' THEN '�ؿܿ���1��'
--                    WHEN 'D6' THEN '�ؿܿ���2��'
--                    WHEN 'D7' THEN '�ؿܿ���3��'
--                    WHEN 'D8' THEN '���������'
--                    WHEN 'D9' THEN '�ѹ���'
--                    ELSE '����X'
--                END;
    DBMS_OUTPUT.PUT_LINE(E.EMP_NAME || ' ' || E.EMP_ID || ' ' || DNAME);
END;
/

-- �ݺ���
-- BASIC LOOP : ���ο� ó���� �ۼ�, �������� LOOP�� ��� ���� ���
-- LOOP
--      ó����
--      ���ǹ�
-- END LOOP;

DECLARE 
    N NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N + 1;
        
        -- �ݺ��� ����
        -- 1. IF�� �̿�
--        IF N > 5
--            THEN EXIT;
--        END IF;
        
        -- 2.
        EXIT WHEN N > 5;
        
    END LOOP;
END;
/

-- FOR LOOP
-- FOR �ε��� IN �ʱⰪ..������
-- LOOP
--      ó����
-- END LOOP;
-- �ε����� ����ϱ� ������ ���� ���� ���� �� �ص� ��
BEGIN
    FOR N IN 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        END LOOP;
END;
/

-- 5���� 1���� ���
DECLARE 
    N NUMBER := 5;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N - 1;
        
        EXIT WHEN N < 1;
        
    END LOOP;
END;
/

BEGIN
--    FOR N IN 5..1 -- �ƹ��͵� �� ����
-- ���ǹ��� ���� �ʰ� ��
    FOR N IN 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(6-N);
        END LOOP;
END;
/

BEGIN
    FOR N IN REVERSE 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        END LOOP;
END;
/

-- ������ �߿� Ȧ���� ���
BEGIN 
    FOR N IN 2..9
    LOOP 
        IF MOD(N,2) = 1
        THEN
            DBMS_OUTPUT.PUT_LINE('------- ' || N || '�� -------');
            FOR M IN 1..9
            LOOP
                DBMS_OUTPUT.PUT_LINE(N || ' * ' || M || ' = ' || N * M);
            END LOOP;
        END IF;
    END LOOP;
END;
/

BEGIN
    FOR DAN IN 2..9
    LOOP
        IF MOD(DAN, 2) != 0
            THEN    
                FOR SU IN 1..9
                LOOP
                    DBMS_OUTPUT.PUT_LINE(DAN || '*' || SU || '=' || DAN * SU);
                END LOOP;
        END IF;
    END LOOP;
END;
/

-- WHILE LOOP
-- WHILE ����
-- LOOP
--      ó����
-- END LOOP;
DECLARE 
    N NUMBER := 1;
BEGIN
    WHILE N <= 5
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N+1;
    END LOOP;
END;
/

-- �Ųٷ� ���
DECLARE 
    N NUMBER := 5;
BEGIN
    WHILE N >= 1
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N-1;
    END LOOP;
END;
/

-- ������ ¦���� ���
DECLARE
    DAN NUMBER := 2;
    SU NUMBER;
BEGIN 
    WHILE DAN <= 9
    LOOP 
        IF MOD(DAN, 2) = 0
            THEN
                DBMS_OUTPUT.PUT_LINE('------- ' || DAN || '�� -------');
                SU := 1;
                WHILE SU <= 9
                LOOP
                    DBMS_OUTPUT.PUT_LINE(DAN || ' * ' || SU || ' = ' || DAN * SU);
                    SU := SU + 1;
                END LOOP;
        END IF;
        DAN := DAN + 1;
    END LOOP;
END;
/

DECLARE
    DAN NUMBER := 2;
    SU NUMBER := 1;
BEGIN 
    WHILE DAN <= 9
    LOOP 
        DBMS_OUTPUT.PUT_LINE('------- ' || DAN || '�� -------');
        SU := 1;
        WHILE SU <= 9
        LOOP
            DBMS_OUTPUT.PUT_LINE(DAN || ' * ' || SU || ' = ' || DAN * SU);
            SU := SU + 1;
        END LOOP;
        
        DAN := DAN + 2;
    END LOOP;
END;
/

-- �̸� ���ǵǾ� �ִ� ����
-- NO_DATA_FOUND : SELECT���� �ƹ� �൵ ��ȯ���� ���� ��
-- DUP_VAL_ON_INDEX : UNIQUE ���� ������ �ִ� �÷��� �ߺ��Ǵ� �����Ͱ� �� ��
-- ZERO_DEVIDE : 0���� ���� ��

-- NO_DATA_FOUND
-- ���� ����� ������ ���� �߻� : ORA-01403: �����͸� ã�� �� �����ϴ�. => EXCEPTION ó��
DECLARE
    NAME VARCHAR2(30);
BEGIN
    SELECT EMP_NAME INTO NAME
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    DBMS_OUTPUT.PUT_LINE(NAME);
    
EXCEPTION
    WHEN NO_DATA_FOUND
        THEN DBMS_OUTPUT.PUT_LINE('���� ����Դϴ�.');
END;
/

-- DUP_VAL_ON_INDEX
-- �̹� ���� ����� ������ ���� �߻� : ORA-00001: ���Ἲ ���� ����(KH.EMPLOYEE_PK)�� ����˴ϴ� => EXCEPTION ó��
BEGIN
    UPDATE EMPLOYEE
    SET EMP_ID = '&���'
    WHERE EMP_ID = 200;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX
        THEN DBMS_OUTPUT.PUT_LINE('�̹� �����ϴ� ����Դϴ�');
END;
/

-- PROCEDURE(���ν���) : PL/SQL ������ �����ϴ� ��ü (����ó�� ���)
-- �����ϰ� ȣ���ؼ� ��� ����
-- CREATE OR REPLACE PROCEDURE ���ν�����[(�Ű�����, ...)]
-- IS
--      �����(DECLARE ��� ��)
-- BEGIN
--      �����
-- EXCEPTION
--      ����ó����
-- END;
-- /
-- ȣ��
-- EXECUTE ���ν�����;
-- EXEC ���ν�����;

SELECT * FROM EMP_01;

CREATE OR REPLACE PROCEDURE DEL_ALL_EMP
IS
BEGIN
    DELETE FROM EMP_01;
END;
/
-- ���ν����� �����ߴٰ� �ؼ� �������� ����. ���ν����� ȣ���ؾ� �����

-- DEL_ALL_EMP ���ν��� ȣ��
-- 1.
EXECUTE DEL_ALL_EMP;
-- 2.
EXEC DEL_ALL_EMP;

ROLLBACK;

-- ���ν����� �����ϴ� ������ ��ųʸ�
SELECT * FROM USER_SOURCE;

-- EMPLOYEE ���̺��� ����� �Է¹޾� �� ����� �ش�Ǵ� ����� ����
-- �Ű����� ����Ͽ� �����
CREATE OR REPLACE PROCEDURE DEL_EMP_ID
IS
BEGIN
    DELETE FROM EMPLOYEE WHERE EMP_ID = '&���';
END;
/
-- ���ν����� ������ �� ���� ���� �Է¹ް� �ش� ����� ������ (�ش� ������� ������)
-- ���ν����� ȣ���� ������ ����� �Է��ϰ� �ش� ����� �����Ϸ��� �ߴµ� �ǵ���� ���� ����

SELECT * FROM EMPLOYEE WHERE EMP_ID = 200;

EXEC DEL_EMP_ID;

-- public void method(int inputEmpId)ó�� �Ű������� ���
-- ó������ ����� �Է��϶�� �������� ����
CREATE OR REPLACE PROCEDURE DEL_EMP_ID(INPUT_EMP_ID EMPLOYEE.EMP_ID%TYPE)
IS
BEGIN
    DELETE FROM EMPLOYEE WHERE EMP_ID = INPUT_EMP_ID;
END;
/

EXEC DEL_EMP_ID('&���'); -- ȣ���� �� �Է��� ����

-- FUNCTION : ���ν����� ����, ��ȯ���� ����
-- CREATE OR REPLACE FUNCTION �Լ���[(�Ű�����, ...)]
-- RETURN ������Ÿ��
-- IS
--      �����
-- BEGIN
--      �����
--      RETURN ��ȯ��;
-- EXCEPTION
--      ����ó����
-- END;
-- /
-- ����
-- EXECUTE �Լ���;
-- EXEC �Լ���;

-- 212�� ��� �̸� ����ϱ�
CREATE OR REPLACE FUNCTION SELECT212
-- RETURN VARCHAR2
RETURN EMPLOYEE.EMP_NAME%TYPE -- �̷��� �ᵵ ��
IS
    NAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    SELECT EMP_NAME
    INTO NAME
    FROM EMPLOYEE
    WHERE EMP_ID = 212;
    
    RETURN NAME;
END;
/

EXEC SELECT212; -- 'SELECT212'�� ���ν����� �ƴϰų� ���ǵ��� �ʾҽ��ϴ�
-- FUNCTION�� ������µ� PROCEDUREó�� �����ؼ� ���� �߻�
-- ��ȯ���� �޾��� ������ �ʿ���
-- ������ �� �ִ� ���ε� ���� ����, ���� ���� �ÿ��� �ƹ��͵� ���� ����
VARIABLE EX_NAME VARCHAR2(20); 
-- ���۷��� ���� ��� �Ұ���
EXEC :EX_NAME := SELECT212;
PRINT EX_NAME;

-- ����� �Է¹޾� �ش� ����� ������ ����ϰ� �����ϴ� �Լ� ����
CREATE OR REPLACE FUNCTION YSALARY_CALC
RETURN NUMBER
IS
    V_SAL EMPLOYEE.SALARY%TYPE;
    V_BON EMPLOYEE.BONUS%TYPE;
    YSALARY NUMBER;
BEGIN
    SELECT SALARY, NVL(BONUS, 0)
    INTO V_SAL, V_BON
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    
    YSALARY := (V_SAL + (V_SAL * V_BON)) * 12;
    
    RETURN YSALARY;
END;
/
-- FUNCTION�� ������ ��쿡 �Է¹ް� �� ������ ������

CREATE OR REPLACE FUNCTION YSALARY_CALC(V_ID EMPLOYEE.EMP_ID%TYPE)
RETURN NUMBER
IS
    V_SAL EMPLOYEE.SALARY%TYPE;
    V_BON EMPLOYEE.BONUS%TYPE;
    YSALARY NUMBER;
BEGIN
    SELECT SALARY, NVL(BONUS, 0)
    INTO V_SAL, V_BON
    FROM EMPLOYEE
    WHERE EMP_ID = V_ID;
    
    YSALARY := (V_SAL + (V_SAL * V_BON)) * 12;
    
    RETURN YSALARY;
END;
/

VARIABLE EX_YSAL NUMBER;
EXEC :EX_YSAL := YSALARY_CALC('&���'); -- EX_YSAL ������ �� ����
PRINT EX_YSAL; -- ���

-- TRIGGER (Ʈ����) : �ڵ����� DML���� ����� �� �ֵ��� ������ִ� ��ü
-- ���̺�/�䰡 DML���� ���� ������ ���� ��� �ڵ����� ������ ������ �����صδ� ��ü
-- Ʈ���� ����
-- SQL���� ���� �ñ⿡ ���� �з�
--      BEFORE TRIGGER : SQL���� �����ϱ� �� Ʈ���� ����
--      AFTER TRIGGER : SQL���� ���� �� Ʈ���� ����
-- SQL���� ���� ������ �޴� ROW�� ���� �з�
--      ROW TRIGGER : SQL�� �� ROW�� ���� �� ���� ����(FOR EACH ROW �ɼ� �ۼ��Ͽ��� ��� ����)
--      ROW TRIGGER���� ��� ����
--                      :OLD : ���� �� ���� �� 
--                             (INSERT : X, UPDATE : ���� �� �ڷ�, DELETE : ������ �ڷ�)
--                      :NEW : ���� �� ���� ��
--                             (INSERT : �Է��� �ڷ�, UPDATE : ���� �� �ڷ�, DELETE : X)
--      STATEMENT TRIGGER : SQL���� ���� �� ���� ����(DEFAULT Ʈ����)

-- CREATE OR REPLACE TRIGGER Ʈ���Ÿ�
-- BEFORE | AFTER
-- INSERT | UPDATE | DELETE (� DML�� �۵����� �� ���ð�����)
-- ON ���̺�� (� ���̺��� DML�� ������� �� ���� ������)
-- [FOR EACH ROW]
-- [WHEN ����]
-- DECLARE �����
-- BEGIN �����
-- EXCEPTION ����ó����
-- END;
-- /

-- EMPLOYEE ���̺� ����� �߰��Ǹ� '���Ի���� �Ի��߽��ϴ�; ���� ��� : TRG_01 Ʈ���� ����
CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT -- �߰��Ǹ� ������ ���� �ϱ� ������ ���Ŀ� ����Ǿ�� �� : AFTER
ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('���Ի���� �Ի��߽��ϴ�.');
END;
/

INSERT INTO EMPLOYEE VALUES (888, '�����', '222222-2222222', 'do_dd@kh.or.kr', '01012344321',
                             'D5', 'J3', 'S3', 3000000, 0.1, 200, SYSDATE, NULL, DEFAULT);

COMMIT;

-- ��ǰ ���� ���̺�
CREATE TABLE PRODUCT(
    PCODE NUMBER PRIMARY KEY,
    PNAME VARCHAR2(30),
    BRAND VARCHAR2(30),
    PRICE NUMBER,
    STOCK NUMBER DEFAULT 0
);

-- ��ǰ ����� �̷� ���̺�
CREATE TABLE PRO_DETAIL(
    DCODE NUMBER PRIMARY KEY,
    PCODE NUMBER,
    PDATE DATE,
    AMOUNT NUMBER,
    STATUS VARCHAR2(10) CHECK(STATUS IN('�԰�', '���')), -- ����� ����
    FOREIGN KEY(PCODE) REFERENCES PRODUCT(PCODE)
);

CREATE SEQUENCE SEQ_PCODE;
CREATE SEQUENCE SEQ_DCODE;

INSERT INTO PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '�����', '�ְ�', 100, DEFAULT);
INSERT INTO PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '���콺', '����', 50, DEFAULT);
INSERT INTO PRODUCT VALUES(SEQ_PCODE.NEXTVAL, 'Ű����', 'Ÿ��', 80, DEFAULT);

SELECT * FROM PRODUCT;
SELECT * FROM PRO_DETAIL;

-- TRIGGER�� ����Ͽ� STOCK�� �ڵ����� ������Ʈ�ϱ�
-- TRIGGER�� ���ٸ� �ϳ��ϳ� �������� �Է��� �־�� ��
CREATE OR REPLACE TRIGGER TRG_02
AFTER INSERT ON PRO_DETAIL
FOR EACH ROW
BEGIN
    -- ��ǰ�� �԰�� ���
    IF :NEW.STATUS = '�԰�' -- NEW : ���� ��� �Է��� �ڷ�
        THEN
            UPDATE PRODUCT
            SET STOCK = STOCK + :NEW.AMOUNT
            WHERE PCODE = :NEW.PCODE;
    END IF;
    -- ��ǰ�� ���� ���
    IF :NEW.STATUS = '���'
        THEN
            UPDATE PRODUCT
            SET STOCK = STOCK - :NEW.AMOUNT
            WHERE PCODE = :NEW.PCODE;
    END IF;
END;
/

INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 2, SYSDATE, 10, '�԰�');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 3, SYSDATE, 5, '�԰�');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 2, SYSDATE, 7, '�԰�');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 1, SYSDATE, 12, '�԰�');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 1, SYSDATE, 8, '���');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 2, SYSDATE, 1, '���');
-- �˾Ƽ� PRODUCT ���̺��� AMOUNT�� ������Ʈ ��

COMMIT;
