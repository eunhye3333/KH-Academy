-- VIEW(뷰) : SELECT 결과를 화면에 저장한 논리적인 가상 테이블
-- 실질적인 데이터를 갖고 있지 않지만 테이블과 동일하게 사용 가능

-- VIEW 생성문
-- CREATE [OR RELPACE] VIEW 뷰이름 AS 서브쿼리

-- 사번, 이름, 부서명, 근무지역의 조회 결과를 V_EMPLOYEE 뷰에 저장
CREATE OR REPLACE VIEW V_EMPLOYEE
AS
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_NAME
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
     LEFT JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
     LEFT JOIN NATIONAL USING(NATIONAL_CODE); -- 없는 두 명까지 출력하기 위해 다 LEFT JOIN

-- ORA-01031: 권한이 불충분합니다 : 뷰를 생성할 위치가 아님
-- 현재 계정에서 뷰를 생성하기 위한 권한이 없기 때문에 나는 오류
-- -> 권한을 부여하기 위해 SYSTEM계정(관리자계정)에 접속

-- 1) SYSTEM 계정 접속
-- 2) KH 계정에 뷰 생성 권한 부여
GRANT CREATE VIEW TO KH;
-- 3) KH 계정으로 돌아가기

SELECT * FROM V_EMPLOYEE;

UPDATE EMPLOYEE
SET EMP_NAME = '정중앙'
WHERE EMP_ID = 205;

SELECT * FROM EMPLOYEE WHERE EMP_ID = 205;
SELECT * FROM V_EMPLOYEE WHERE EMP_ID = 205; -- 뷰도 똑같이 이름이 정중앙으로 바뀜
-- 본 테이블과 VIEW가 연결되어 있음

ROLLBACK;

-- 사번, 이름, 직급, 성별(남/여), 근무년수를 V_EMP_JOB 뷰 저장
-- 서브쿼리의 SELECT 절에 함수가 사용된 경우 반드시 별칭을 지정해야 함
-- ORA-00998: 이 식은 열의 별명과 함께 지정해야 합니다
-- 00998. 00000 -  "must name this expression with a column alias"
CREATE OR REPLACE VIEW V_EMP_JOB AS
SELECT EMP_ID 사번, EMP_NAME "사원 명", JOB_NAME "직급 명", 
       DECODE(SUBSTR(EMP_NO, INSTR(EMP_NO, '-') + 1, 1), 1, '남', '여') 성별,
       EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) 근무년수 
FROM EMPLOYEE 
     JOIN JOB USING(JOB_CODE);

CREATE OR REPLACE VIEW V_EMP_JOB(사번, "사원 명", 직급, 성별, 근무년수) AS -- 꼭 SELECT문 안에서 별칭 설정하지 않고 이렇게 별칭 설정도 가능
SELECT EMP_ID, EMP_NAME, JOB_NAME, 
       DECODE(SUBSTR(EMP_NO, INSTR(EMP_NO, '-') + 1, 1), 1, '남', '여'),
       EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)  
FROM EMPLOYEE 
     JOIN JOB USING(JOB_CODE);

SELECT * FROM V_EMP_JOB;

CREATE OR REPLACE VIEW V_JOB
AS 
SELECT JOB_CODE, JOB_NAME
FROM JOB;

SELECT * FROM V_JOB;
SELECT * FROM JOB; -- V_JOB에 추가했는데 여기에도 인턴이 추가되어 있음

INSERT INTO V_JOB VALUES('J8', '인턴');
UPDATE V_JOB SET JOB_NAME='알바' WHERE JOB_CODE = 'J8';
DELETE V_JOB WHERE JOB_CODE = 'J8';
-- 본 테이블에도 INSERT, UPDATE, DELETE가 영향을 미침

SELECT * FROM USER_VIEWS;
-- 사용자 정의 뷰 확인 데이터 딕셔너리
-- 우리가 아까 적은 서브쿼리 텍스트가 그대로 TEXT라는 컬럼에 저장되어 있음

-- DML 명령어로 조작이 불가능한 경우
-- 1. 뷰 정의에 포함되지 않은 컬럼 조작
CREATE OR REPLACE VIEW V_JOB2
AS
SELECT JOB_CODE FROM JOB;

SELECT * FROM V_JOB2;

INSERT INTO V_JOB2 VALUES('J8', '인턴');
-- SQL 오류: ORA-00913: 값의 수가 너무 많습니다
-- V_JOB2에는 컬럼이 하나밖에 없는데 두 개를 넣으려고 해서 오류 발생
UPDATE V_JOB2 SET JOB_NAME = '인턴' WHERE JOB_CODE = 'J7'; -- SQL 오류: ORA-00904: "JOB_NAME": 부적합한 식별자
-- JOB_NAME이 없어서 바꿀 수 없음
-- 하지만 JOB_CODE = 'J7' WHERE JOB_NAME = '인턴'처럼 하면 변경 가능
DELETE FROM V_JOB2 WHERE JOB_NAME = '사원'; -- JOB_NAME이 V_JOB2에 없어서 변경 불가능

-- 2. 뷰에 포함되지 않은 컬럼 중 NOT NULL 제약조건이 지정된 경우
CREATE OR REPLACE VIEW V_JOB3
AS SELECT JOB_NAME FROM JOB;

INSERT INTO V_JOB3 VALUES('인턴');
-- ORA-01400: NULL을 ("KH"."JOB"."JOB_CODE") 안에 삽입할 수 없습니다
-- JOB_CODE에 NOT NULL 제약조건이 걸려 있는데 JOB_NAME에만 삽입하기 때문에 JOB_CODE가 비어있게 됨 따라서 삽입 불가능
UPDATE V_JOB3 SET JOB_CODE = NULL WHERE JOB_NAME = '사원'; -- ORA-00904: "JOB_CODE": 부적합한 식별자, JOB_CODE 자체가 뷰에 없어서 불가능

-- 3. 산술표현식으로 정의된 경우
CREATE OR REPLACE VIEW EMP_SAL
AS 
SELECT EMP_ID, EMP_NAME, SALARY, (SALARY + (SALARY*NVL(BONUS, 0)))*12 연봉
FROM EMPLOYEE;

SELECT * FROM EMP_SAL;

INSERT INTO EMP_SAL VALUES(600, '강건강', 3000000, 36000000); -- SQL 오류: ORA-01733: 가상 열은 사용할 수 없습니다
-- 연봉의 계산식은 SALARY와 BONUS를 가지고 계산을 한 것인데 이것을 무시하고 36000000을 넣으면 인식하지 못함
-- UPDATE도 동일
UPDATE EMP_SAL SET 연봉 = 80 WHERE EMP_ID = 200; -- SQL 오류: ORA-01733: 가상 열은 사용할 수 없습니다

-- 4. 그룹함수/GROUP BY 포함한 경우
-- V_GROUPDEPT 뷰에 부서 코드, 부서별 급여 합계 부서 별 급여 평균 저장
CREATE OR REPLACE VIEW V_GROUPDEPT
AS
SELECT DEPT_CODE, SUM(SALARY) 합계, AVG(SALARY) 평균
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT * FROM V_GROUPDEPT;

INSERT INTO V_GROUPDEPT VALUES('D10', 600, 400); -- SQL 오류: ORA-01733: 가상 열은 사용할 수 없습니다
-- 평균이나 합계를 고려한 것이 아니라 고정된 숫자를 넣으려고 해서 연결되지 않음
UPDATE V_GROUPDEPT SET DEPT_CODE = 'D10' WHERE DEPT_CODE = 'D3'; -- SQL 오류: ORA-01732: 뷰에 대한 데이터 조작이 부적합합니다
-- 이렇게 바꾸면 안에 있는 것들에 대한 SUM과 AVG가 달라지기 때문에 불가능
DELETE FROM V_GROUPDEPT WHERE DEPT_CODE = 'D1'; -- SQL 오류: ORA-01732: 뷰에 대한 데이터 조작이 부적합합니다

-- 5. DISTINCT를 포함한 경우
CREATE OR REPLACE VIEW V_DT_EMP
AS 
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

SELECT * FROM V_DT_EMP;

INSERT INTO V_DT_EMP VALUES('J9'); -- SQL 오류: ORA-01732: 뷰에 대한 데이터 조작이 부적합합니다
UPDATE V_DT_EMP SET JOB_CODE = 'J9' WHERE JOB_CODE = 'J7';
DELETE FROM V_DT_EMP WHERE JOB_CODE = 'J1';
-- 전체를 다 가져온 게 아니라 중복을 제거해서 개수만 세서 가져온 것이기 때문에 에러 발생

-- 6. JOIN을 이용해 여러 테이블을 연결한 경우
-- V_JOINEMP 뷰에 사번, 이름, 부서 명 저장
CREATE OR REPLACE VIEW V_JOINEMP
AS
SELECT EMP_ID, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

SELECT * FROM V_JOINEMP;

INSERT INTO V_JOINEMP VALUES(700, '강건강', '총무부'); -- SQL 오류: ORA-01776: 조인 뷰에 의하여 하나 이상의 기본 테이블을 수정할 수 없습니다.
-- 여러 개의 테이블을 한 번에 수정 불가능
-- INSERT/UPDATE 불가능, DELETE는 가능

-- VIEW 옵션
-- CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰이름[(alias[, alias]...)]
-- AS subquery
-- [WITH CHECK OPTION]
-- [WITH READ ONLY];


-- OR REPLACE : 기존에 동일한 뷰 이름이 존재하는 경우 덮어쓰고, 존재하지 않으면 새로 생성
-- 테이블의 경우 한 번 만들고 다시 CREATE 하려고 하면 기본 객체가 이름을 사용하고 있다고 에러가 남 (이름 중복)

-- FORCE/NOFORCE
--      FORCE : 서브쿼리에 사용된 테이블이 존재하지 않아도 뷰 생성
--      NOFORCE : 서브쿼리에 사용된 테이블이 존재해야만 뷰 생성 (기본 값) => 지정하지 않는 경우 NOFORCE
-- WITH CHECK OPTION : 옵션을 설정한 컬럼 수정 불가능
-- WITH READ ONLY : 조회만 가능하게 만듦

CREATE OR REPLACE VIEW V_EMP1
AS 
SELECT EMP_NO, EMP_NAME
FROM EMPLOYEE;

SELECT * FROM V_EMP1;

CREATE OR REPLACE VIEW V_EMP1
AS 
SELECT EMP_NO, EMP_NAME, SALARY
FROM EMPLOYEE;
-- OR REPLACE 옵션 때문에 다시 생성됨

CREATE VIEW V_EMP1
AS 
SELECT EMP_NAME, SALARY
FROM EMPLOYEE; -- ORA-00955: 기존의 객체가 이름을 사용하고 있습니다.
-- OR REPLACE를 빼서 해당 에러 발생

CREATE OR REPLACE /*NOFORCE*/ VIEW V_EMP2 -- ORA-00942: 테이블 또는 뷰가 존재하지 않습니다 => NOFORCE 적용
AS
SELECT T_CODE, T_NAME, TCONTENT
FROM TT;

CREATE OR REPLACE FORCE VIEW V_EMP2 -- 경고: 컴파일 오류와 함께 뷰가 생성되었습니다.
AS
SELECT T_CODE, T_NAME, TCONTENT
FROM TT;
-- 일단 뷰를 만들었지만 오류가 났다 : 테이블 또는 뷰가 존재하지 않음
-- 아직 테이블이 만들어져 있지 않지만 뷰를 먼저 생성해야 할 경우 사용 (해당 뷰가 필요할 것 같을 때)

CREATE OR REPLACE VIEW V_EMP3
AS
SELECT * FROM EMPLOYEE
WHERE DEPT_CODE = 'D9'
WITH CHECK OPTION; 

SELECT * FROM V_EMP3;

UPDATE V_EMP3
SET DEPT_CODE = 'D1'
WHERE EMP_ID = 200; -- ORA-01402: 뷰의 WITH CHECK OPTION의 조건에 위배 됩니다
-- WITH CHECK OPTION에 DEPT_CODE가 들어가 있어서

UPDATE V_EMP3
SET EMP_NAME = '성동일'
WHERE EMP_ID = 200; -- 수정 가능

ROLLBACK;

INSERT INTO V_EMP3
VALUES(999, '강건강', '111111-1111111', 'kang_kk@kh.or.kr', '01011112222', 'D1', 'J3', 'S3', 3000000, 0.2, 200, SYSDATE, NULL, 'N');
-- ORA-01402: 뷰의 WITH CHECK OPTION의 조건에 위배 됩니다
-- D9만 넣었기 때문에

INSERT INTO V_EMP3
VALUES(999, '강건강', '111111-1111111', 'kang_kk@kh.or.kr', '01011112222', 'D9', 'J3', 'S3', 3000000, 0.2, 200, SYSDATE, NULL, 'N');
-- 삽입 가능

ROLLBACK;

CREATE OR REPLACE VIEW V_DEPT
AS
SELECT * FROM DEPARTMENT
WITH READ ONLY;

INSERT INTO V_DEPT
VALUES('D10', '해외영업부', 'L1'); -- SQL 오류: ORA-42399: 읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다.

UPDATE V_DEPT
SET LOCATION_ID = 'L2'
WHERE DEPT_ID = 'D1';

DELETE FROM V_DEPT;
-- 읽기 전용이기 때문에 다 불가능

COMMIT;
