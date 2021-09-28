-- PL/SQL
-- 선언부          DECLARE     변수, 상수 선언
-- 실행부          BEGIN       로직 기술
-- 예외처리부      EXCEPTION   예외 발생 시 해결 문장 기술
-- DECLARE나 EXCEPTION은 없어도 됨

/*
        // 변수 선언 없이 실행
        System.out.println(10);
        
        // 변수 선언 후 실행
        int a = 10
        System.out.println(a);
        
        1은 DECLARE가 없어도 됨
*/

SET SERVEROUTPUT ON; 
-- 출력을 화면에 보여주도록 하는 설정
-- 설정을 안 하면 DBMS_OUTPUT.PUT_LINE 해도 안 뜸

BEGIN 
    DBMS_OUTPUT.PUT_LINE('HELLO WORLD');
END;
/ 
-- 슬래시까지 있어야 함. END는 PL/SQL이 끝났다는 뜻. /는 구분을 위함

/*
        int empId;
        String empName;
        
        final int PI = 3.14;
        
        empId = 800;
        empName = "남나눔";
        
        System.out.println("empId : " + empId);
        System.out.println("empName : " + empName);
*/
-- PL/SQL로 옮기기

DECLARE -- 선언부 시작
    EMP_ID NUMBER; -- 변수명 자료형 순서
    EMP_NAME VARCHAR2(30);
    PI CONSTANT NUMBER := 3.14; -- 상수
    -- PL/SQL에서의 대입은 그냥 =이 아니라 :=을 사용해야 함
BEGIN
    EMP_ID := 800;
    EMP_NAME := '남나눔';
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
END;
/

DECLARE
    EMP_ID NUMBER;
    EMP_NAME VARCHAR2(30);
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO EMP_ID, EMP_NAME -- SELECT를 이용해 가져온 값 변수에 대입
    FROM EMPLOYEE
    WHERE EMP_ID = 200;
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
END;
/

DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE; 
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    -- 가져오는 컬럼의 타입과 동일하게 함
    -- 각각의 타입을 참조해서 쓰는 것이기 때문에 레퍼런스 변수라고 함
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO EMP_ID, EMP_NAME 
    FROM EMPLOYEE
    WHERE EMP_ID = 200;
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
END;
/

-- 사용자에게 값 입력받기
DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE; 
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO EMP_ID, EMP_NAME 
    FROM EMPLOYEE
--    WHERE EMP_ID = '&EMP_ID'; 
    WHERE EMP_ID = '&사번';
    -- & : 대체 변수 입력 (값 입력)
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
END;
/

-- 레퍼런스 변수로 EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY를 선언하고
-- EMPLOYEE 테이블에서 사번, 이름, 직급코드, 부서코드, 급여를 조회 후 선언한 레퍼런스 변수에 담아 출력
-- 단, 입력받은 이름과 일치하는 조건의 직원 조회
DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    DEPT_CODE EMPLOYEE.DEPT_CODE%TYPE;
    JOB_CODE EMPLOYEE.JOB_CODE%TYPE;
    SALARY EMPLOYEE.SALARY%TYPE;
BEGIN 
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY -- 이름이 같다고 알아서 대입되는 것이 아니기 때문에 순서를 맞춰줘야 함
    INTO EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
    FROM EMPLOYEE
    WHERE EMP_NAME = '&이름';
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('DEPT_CODE : ' || DEPT_CODE);
    DBMS_OUTPUT.PUT_LINE('JOB_CODE : ' || JOB_CODE);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || SALARY);
END;
/

-- 레퍼런스 변수를 많이 쓰면 번거로움 => 한 행에 대해서 가져오기
DECLARE
    E EMPLOYEE%ROWTYPE;
    -- %ROWTYPE : 행에 대한 테이터형, 크기, 속성을 모두 참조
BEGIN
    SELECT * 
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
--    DBMS_OUTPUT.PUT_LINE('E : ' || E); -- PLS-00306: '||' 호출 시 인수의 갯수나 유형이 잘못되었습니다 => E를 한 번에 찍을 수 없음
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || E.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('EMP_NO : ' || E.EMP_NO);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || E.SALARY);   
END;
/

-- if / if~else / if~else if~else
-- IF ~ THEN ~ END IF (단일 IF문)
-- EMP_ID를 입력받아 사번, 이름, 급여, 보너스율 출력
-- 보너스를 받지 않는 사원은 보너스율 출력 전 '보너스를 지급받지 않는 사원입니다' 출력
DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN 
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
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
    WHERE EMP_ID = '&사번';
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || SALARY);
    
    IF(BONUS = 0)
        THEN DBMS_OUTPUT.PUT_LINE('보너스를 지급받지 않는 사원입니다');
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
    WHERE EMP_ID = '&사번';
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || SALARY);
    
    IF(BONUS IS NULL) -- NVL을 사용하지 않은 경우
        THEN DBMS_OUTPUT.PUT_LINE('보너스를 지급받지 않는 사원입니다');
    END IF;
    DBMS_OUTPUT.PUT_LINE('BONUS : ' || BONUS * 100 || '%');
END;
/

-- IF~THEN~ELSE~END IF(if ~ else문)
-- EMP_ID 를 입력받아 해당 사원의 사번, 이름, 부서명, 소속 출력
-- TEAM 변수를 만들어 소속이 KO면 국내팀, 아니면 해외 팀으로 저장
DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    DEPT_TITLE DEPARTMENT.DEPT_TITLE%TYPE;
    TEAM VARCHAR2(30);
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE, DECODE(NATIONAL_CODE, 'KO', '국내 팀', '해외 팀')
    INTO EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE
    FROM EMPLOYEE
         LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
         LEFT JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID)
    WHERE EMP_ID = '&사번';
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
    WHERE EMP_ID = '&사번';
    
    IF(NATIONAL_CODE = 'KO')
        THEN TEAM := '국내팀';
    ELSE
        TEAM := '해외팀';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('부서 : ' || DEPT_TITLE);
    DBMS_OUTPUT.PUT_LINE('소속 : ' || TEAM);
END;
/

-- 사용자에게 사번을 받아와 그 사원의 전체 정보를 VEMP에 저장
-- VEMP를 이용하여 연봉 계산(보너스가 있을 경우 보너스 포함하여 계산)
-- 연봉 결과 값은 YSALARY에 저장
-- 급여 이름 연봉(\1,000,000) 형식 출력
CREATE OR REPLACE VIEW VEMP
AS
SELECT * FROM EMPLOYEE 
WHERE EMP_ID = '&사번';

SELECT * FROM VEMP;

DECLARE
    SALARY EMPLOYEE.SALARY%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    YSALARY VARCHAR2(30);
BEGIN
    SELECT SALARY, EMP_NAME, TO_CHAR((SALARY + (SALARY * NVL(BONUS, 0))) * 12, 'FML999,999,999') 연봉
    INTO SALARY, EMP_NAME, YSALARY
    FROM VEMP;
        
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SALARY);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('연봉 : ' || YSALARY);
    
END;
/

-- 풀이
DECLARE
    VEMP EMPLOYEE%ROWTYPE;
    YSALARY NUMBER;
BEGIN
    SELECT *
    INTO VEMP
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    IF(VEMP.BONUS IS NULL)
        THEN YSALARY := VEMP.SALARY * 12;
    ELSE
        YSALARY := VEMP.SALARY * (1 + VEMP.BONUS) * 12;
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(VEMP.SALARY || ' ' || VEMP.EMP_NAME || ' ' || 
                         TO_CHAR(YSALARY, 'FML999,999,999'));
    
END;
/

-- IF ~ THEN ~ ELSIF ~ THEN ~ ELSE ~ END IF (IF ~ ELSE IF ~ ELSE문)
-- 점수를 입력받아 SCORE에 저장
-- 90점 이상이면 A, 80점 이상이면 B, 70점 이상이면 C, 60점 이상이면 D, 그 외 F
-- 등급은 GRADE 변수에 저장
-- 당신의 점수는 SOCRE점이고 학점은 GRADE학점입니다 출력
DECLARE
    SCORE NUMBER;
    GRADE CHAR(1);
BEGIN
    SCORE := '&점수';

    IF(SCORE >= 90) -- 소괄호로 묶지 않아도 됨 : IF SCORE >= 90
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
    
    DBMS_OUTPUT.PUT_LINE('당신의 점수는 ' || SCORE || '점이고 학점은 ' || GRADE || '학점입니다');
END;
/
    
-- CASE ~ WHEN ~ THEN ~ END (SWITCH ~ CASE 문)
-- 사번을 입력하여 해당 사원의 사번, 이름, 부서 명 출력
-- D1 인사관리부 / D2 회계관리부 / D3 마케팅부 / D4 국내영업부 
-- D5 해외영업1부 / D6 해외영업2부 / D7 해외영업3부 / D8 기술지원부 / D9 총무부
-- IF 사용
DECLARE 
    EMP_ID EMPLOYEE.EMP_ID%TYPE;
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
    DEPT_CODE EMPLOYEE.DEPT_CODE%TYPE;
    DEPT_TITLE VARCHAR2(30);
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
    INTO EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    IF DEPT_CODE = 'D1' THEN DEPT_TITLE := '인사관리부';
    ELSIF DEPT_CODE = 'D2' THEN DEPT_TITLE := '회계관리부';
    ELSIF DEPT_CODE = 'D3' THEN DEPT_TITLE := '마케팅부';
    ELSIF DEPT_CODE = 'D4' THEN DEPT_TITLE := '국내영업부';
    ELSIF DEPT_CODE = 'D5' THEN DEPT_TITLE := '해외영업1부';
    ELSIF DEPT_CODE = 'D6' THEN DEPT_TITLE := '해외영업2부';
    ELSIF DEPT_CODE = 'D7' THEN DEPT_TITLE := '해외영업3부';
    ELSIF DEPT_CODE = 'D8' THEN DEPT_TITLE := '기술지원부';
    ELSE DEPT_TITLE := '총무부';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('부서 명 : ' || DEPT_TITLE);
END;
/

DECLARE 
    E EMPLOYEE%ROWTYPE;
    DNAME DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    IF E.DEPT_CODE = 'D1' THEN DNAME := '인사관리부';
    ELSIF E.DEPT_CODE = 'D2' THEN DNAME := '회계관리부';
    ELSIF E.DEPT_CODE = 'D3' THEN DNAME := '마케팅부';
    ELSIF E.DEPT_CODE = 'D4' THEN DNAME := '국내영업부';
    ELSIF E.DEPT_CODE = 'D5' THEN DNAME := '해외영업1부';
    ELSIF E.DEPT_CODE = 'D6' THEN DNAME := '해외영업2부';
    ELSIF E.DEPT_CODE = 'D7' THEN DNAME := '해외영업3부';
    ELSIF E.DEPT_CODE = 'D8' THEN DNAME := '기술지원부';
    ELSIF E.DEPT_CODE = 'D9' THEN DNAME := '총무부';
    ELSE DNAME := '배정X';
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
                WHEN E.DEPT_CODE = 'D1' THEN '인사관리부'
                WHEN E.DEPT_CODE = 'D2' THEN '회계관리부'
                WHEN E.DEPT_CODE = 'D3' THEN '마케팅부'
                WHEN E.DEPT_CODE = 'D4' THEN '국내영업부'
                WHEN E.DEPT_CODE = 'D5' THEN '해외영업1부'
                WHEN E.DEPT_CODE = 'D6' THEN '해외영업2부'
                WHEN E.DEPT_CODE = 'D7' THEN '해외영업3부'
                WHEN E.DEPT_CODE = 'D8' THEN '기술지원부'
                WHEN E.DEPT_CODE = 'D9' THEN '총무부'
                ELSE '배정X'
            END;
        -- 비교할 것을 따로 빼도 디고 조건식으로 적어줘도 됨
    
--        DNAME := CASE E.DEPT_CODE
--                    WHEN 'D1' THEN '인사관리부'
--                    WHEN 'D2' THEN '회계관리부'
--                    WHEN 'D3' THEN '마케팅부'
--                    WHEN 'D4' THEN '국내영업부'
--                    WHEN 'D5' THEN '해외영업1부'
--                    WHEN 'D6' THEN '해외영업2부'
--                    WHEN 'D7' THEN '해외영업3부'
--                    WHEN 'D8' THEN '기술지원부'
--                    WHEN 'D9' THEN '총무부'
--                    ELSE '배정X'
--                END;
    DBMS_OUTPUT.PUT_LINE(E.EMP_NAME || ' ' || E.EMP_ID || ' ' || DNAME);
END;
/

-- 반복문
-- BASIC LOOP : 내부에 처리문 작성, 마지막에 LOOP를 벗어날 조건 명시
-- LOOP
--      처리문
--      조건문
-- END LOOP;

DECLARE 
    N NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N + 1;
        
        -- 반복문 종료
        -- 1. IF문 이용
--        IF N > 5
--            THEN EXIT;
--        END IF;
        
        -- 2.
        EXIT WHEN N > 5;
        
    END LOOP;
END;
/

-- FOR LOOP
-- FOR 인덱스 IN 초기값..최종값
-- LOOP
--      처리문
-- END LOOP;
-- 인덱스를 사용하기 때문에 따로 변수 선언 안 해도 됨
BEGIN
    FOR N IN 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        END LOOP;
END;
/

-- 5부터 1까지 출력
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
--    FOR N IN 5..1 -- 아무것도 안 나옴
-- 조건문에 들어가지 않게 됨
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

-- 구구단 중에 홀수단 출력
BEGIN 
    FOR N IN 2..9
    LOOP 
        IF MOD(N,2) = 1
        THEN
            DBMS_OUTPUT.PUT_LINE('------- ' || N || '단 -------');
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
-- WHILE 조건
-- LOOP
--      처리문
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

-- 거꾸로 출력
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

-- 구구단 짝수단 출력
DECLARE
    DAN NUMBER := 2;
    SU NUMBER;
BEGIN 
    WHILE DAN <= 9
    LOOP 
        IF MOD(DAN, 2) = 0
            THEN
                DBMS_OUTPUT.PUT_LINE('------- ' || DAN || '단 -------');
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
        DBMS_OUTPUT.PUT_LINE('------- ' || DAN || '단 -------');
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

-- 미리 정의되어 있는 예외
-- NO_DATA_FOUND : SELECT문이 아무 행도 반환하지 못할 때
-- DUP_VAL_ON_INDEX : UNIQUE 제약 조건이 있는 컬럼에 중복되는 데이터가 들어갈 때
-- ZERO_DEVIDE : 0으로 나눌 때

-- NO_DATA_FOUND
-- 없는 사번을 넣으면 오류 발생 : ORA-01403: 데이터를 찾을 수 없습니다. => EXCEPTION 처리
DECLARE
    NAME VARCHAR2(30);
BEGIN
    SELECT EMP_NAME INTO NAME
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    DBMS_OUTPUT.PUT_LINE(NAME);
    
EXCEPTION
    WHEN NO_DATA_FOUND
        THEN DBMS_OUTPUT.PUT_LINE('없는 사번입니다.');
END;
/

-- DUP_VAL_ON_INDEX
-- 이미 가진 사번을 넣으면 오류 발생 : ORA-00001: 무결성 제약 조건(KH.EMPLOYEE_PK)에 위배됩니다 => EXCEPTION 처리
BEGIN
    UPDATE EMPLOYEE
    SET EMP_ID = '&사번'
    WHERE EMP_ID = 200;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX
        THEN DBMS_OUTPUT.PUT_LINE('이미 존재하는 사번입니다');
END;
/

-- PROCEDURE(프로시저) : PL/SQL 문장을 저장하는 객체 (변수처럼 사용)
-- 간단하게 호출해서 사용 가능
-- CREATE OR REPLACE PROCEDURE 프로시저명[(매개변수, ...)]
-- IS
--      선언부(DECLARE 없어도 됨)
-- BEGIN
--      실행부
-- EXCEPTION
--      예외처리부
-- END;
-- /
-- 호출
-- EXECUTE 프로시저명;
-- EXEC 프로시저명;

SELECT * FROM EMP_01;

CREATE OR REPLACE PROCEDURE DEL_ALL_EMP
IS
BEGIN
    DELETE FROM EMP_01;
END;
/
-- 프로시저를 생성했다고 해서 지워지지 않음. 프로시저를 호출해야 실행됨

-- DEL_ALL_EMP 프로시저 호출
-- 1.
EXECUTE DEL_ALL_EMP;
-- 2.
EXEC DEL_ALL_EMP;

ROLLBACK;

-- 프로시저를 관리하는 데이터 딕셔너리
SELECT * FROM USER_SOURCE;

-- EMPLOYEE 테이블에서 사번을 입력받아 그 사번에 해당되는 사람을 지움
-- 매개변수 사용하여 만들기
CREATE OR REPLACE PROCEDURE DEL_EMP_ID
IS
BEGIN
    DELETE FROM EMPLOYEE WHERE EMP_ID = '&사번';
END;
/
-- 프로시저를 생성할 때 값을 먼저 입력받고 해당 사번만 지워짐 (해당 사번으로 고정됨)
-- 프로시저를 호출할 때마다 사번을 입력하고 해당 사번을 삭제하려고 했는데 의도대로 되지 않음

SELECT * FROM EMPLOYEE WHERE EMP_ID = 200;

EXEC DEL_EMP_ID;

-- public void method(int inputEmpId)처럼 매개변수로 사용
-- 처음부터 사번을 입력하라고 나오지는 않음
CREATE OR REPLACE PROCEDURE DEL_EMP_ID(INPUT_EMP_ID EMPLOYEE.EMP_ID%TYPE)
IS
BEGIN
    DELETE FROM EMPLOYEE WHERE EMP_ID = INPUT_EMP_ID;
END;
/

EXEC DEL_EMP_ID('&사번'); -- 호출할 때 입력을 받음

-- FUNCTION : 프로시저와 동일, 반환값이 존재
-- CREATE OR REPLACE FUNCTION 함수명[(매개변수, ...)]
-- RETURN 데이터타입
-- IS
--      선언부
-- BEGIN
--      실행부
--      RETURN 반환값;
-- EXCEPTION
--      예외처리부
-- END;
-- /
-- 실행
-- EXECUTE 함수명;
-- EXEC 함수명;

-- 212번 사원 이름 출력하기
CREATE OR REPLACE FUNCTION SELECT212
-- RETURN VARCHAR2
RETURN EMPLOYEE.EMP_NAME%TYPE -- 이렇게 써도 됨
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

EXEC SELECT212; -- 'SELECT212'는 프로시저가 아니거나 정의되지 않았습니다
-- FUNCTION을 만들었는데 PROCEDURE처럼 실행해서 오류 발생
-- 반환값을 받아줄 변수가 필요함
-- 저장할 수 있는 바인드 변수 생성, 변수 생성 시에는 아무것도 뜨지 않음
VARIABLE EX_NAME VARCHAR2(20); 
-- 레퍼런스 변수 사용 불가능
EXEC :EX_NAME := SELECT212;
PRINT EX_NAME;

-- 사번을 입력받아 해당 사원의 연봉을 계산하고 리턴하는 함수 생성
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
    WHERE EMP_ID = '&사번';
    
    YSALARY := (V_SAL + (V_SAL * V_BON)) * 12;
    
    RETURN YSALARY;
END;
/
-- FUNCTION을 생성할 경우에 입력받고 그 값으로 고정됨

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
EXEC :EX_YSAL := YSALARY_CALC('&사번'); -- EX_YSAL 변수에 값 저장
PRINT EX_YSAL; -- 출력

-- TRIGGER (트리거) : 자동으로 DML문이 실행될 수 있도록 만들어주는 객체
-- 테이블/뷰가 DML문에 의해 변경이 됐을 경우 자동으로 실행할 내용을 저장해두는 객체
-- 트리거 종류
-- SQL문의 실행 시기에 따른 분류
--      BEFORE TRIGGER : SQL문을 실행하기 전 트리거 실행
--      AFTER TRIGGER : SQL문을 실행 후 트리거 실행
-- SQL문에 의해 영향을 받는 ROW에 따른 분류
--      ROW TRIGGER : SQL문 각 ROW에 대해 한 번씩 실행(FOR EACH ROW 옵션 작성하여야 사용 가능)
--      ROW TRIGGER에서 사용 가능
--                      :OLD : 참조 전 열의 값 
--                             (INSERT : X, UPDATE : 수정 전 자료, DELETE : 삭제할 자료)
--                      :NEW : 참조 후 열의 값
--                             (INSERT : 입력한 자료, UPDATE : 수정 후 자료, DELETE : X)
--      STATEMENT TRIGGER : SQL문에 의해 한 번만 실행(DEFAULT 트리거)

-- CREATE OR REPLACE TRIGGER 트리거명
-- BEFORE | AFTER
-- INSERT | UPDATE | DELETE (어떤 DML이 작동했을 때 나올것인지)
-- ON 테이블명 (어떤 테이블에서 DML을 사용했을 때 나올 것인지)
-- [FOR EACH ROW]
-- [WHEN 조건]
-- DECLARE 선언부
-- BEGIN 실행부
-- EXCEPTION 예외처리부
-- END;
-- /

-- EMPLOYEE 테이블에 사원이 추가되면 '신입사원이 입사했습니다; 문구 출력 : TRG_01 트리거 생성
CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT -- 추가되면 문구가 떠야 하기 때문에 이후에 실행되어야 함 : AFTER
ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('신입사원이 입사했습니다.');
END;
/

INSERT INTO EMPLOYEE VALUES (888, '도대담', '222222-2222222', 'do_dd@kh.or.kr', '01012344321',
                             'D5', 'J3', 'S3', 3000000, 0.1, 200, SYSDATE, NULL, DEFAULT);

COMMIT;

-- 상품 정보 테이블
CREATE TABLE PRODUCT(
    PCODE NUMBER PRIMARY KEY,
    PNAME VARCHAR2(30),
    BRAND VARCHAR2(30),
    PRICE NUMBER,
    STOCK NUMBER DEFAULT 0
);

-- 상품 입출고 이력 테이블
CREATE TABLE PRO_DETAIL(
    DCODE NUMBER PRIMARY KEY,
    PCODE NUMBER,
    PDATE DATE,
    AMOUNT NUMBER,
    STATUS VARCHAR2(10) CHECK(STATUS IN('입고', '출고')), -- 입출고 상태
    FOREIGN KEY(PCODE) REFERENCES PRODUCT(PCODE)
);

CREATE SEQUENCE SEQ_PCODE;
CREATE SEQUENCE SEQ_DCODE;

INSERT INTO PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '모니터', '최고', 100, DEFAULT);
INSERT INTO PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '마우스', '찍찍', 50, DEFAULT);
INSERT INTO PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '키보드', '타닥', 80, DEFAULT);

SELECT * FROM PRODUCT;
SELECT * FROM PRO_DETAIL;

-- TRIGGER를 사용하여 STOCK를 자동으로 업데이트하기
-- TRIGGER가 없다면 하나하나 수동으로 입력해 주어야 함
CREATE OR REPLACE TRIGGER TRG_02
AFTER INSERT ON PRO_DETAIL
FOR EACH ROW
BEGIN
    -- 상품이 입고된 경우
    IF :NEW.STATUS = '입고' -- NEW : 내가 방금 입력한 자료
        THEN
            UPDATE PRODUCT
            SET STOCK = STOCK + :NEW.AMOUNT
            WHERE PCODE = :NEW.PCODE;
    END IF;
    -- 상품이 출고된 경우
    IF :NEW.STATUS = '출고'
        THEN
            UPDATE PRODUCT
            SET STOCK = STOCK - :NEW.AMOUNT
            WHERE PCODE = :NEW.PCODE;
    END IF;
END;
/

INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 2, SYSDATE, 10, '입고');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 3, SYSDATE, 5, '입고');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 2, SYSDATE, 7, '입고');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 1, SYSDATE, 12, '입고');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 1, SYSDATE, 8, '출고');
INSERT INTO PRO_DETAIL VALUES(SEQ_DCODE.NEXTVAL, 2, SYSDATE, 1, '출고');
-- 알아서 PRODUCT 테이블의 AMOUNT가 업데이트 됨

COMMIT;
