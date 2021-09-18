-- DML : 데이터 조작 언어
-- 테이블에 값 삽입(INSERT) / 수정(UPDATE) / 삭제(DELETE)

-- INSERT : 테이블에 데이터 추가 (행 개수 증가)
-- INSERT INTO 테이블 명(컬럼명1, 컬럼명2, ...) VALUES(값1, 값2, ...)
--INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE,
--                     SAL_LEVEL, SALARY, BONUS, MANAGER_ID, HIRE_DATE, ENT_DATE, ENT_YN)
--VALUES(500, '송성실', '990111-1223344', 'song_ss@kh.or.kr', '01023456789', 'D1', 'J7', 'S3',
--       3000000, 0.2, 200, SYSDATE, NULL, DEFAULT); 

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE,
                     SAL_LEVEL, SALARY, BONUS, HIRE_DATE, MANAGER_ID, ENT_DATE, ENT_YN)
VALUES(500, '송성실', '990111-1223344', 'song_ss@kh.or.kr', '01023456789', 'D1', 'J7', 'S3',
       3000000, 0.2, 200, SYSDATE, NULL, DEFAULT); -- 오류
       
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, SAL_LEVEL)
VALUES(500, '송성실', '990111-1223344', 'J7', 'S3');
-- 정석 INSERT
-- 장점 : 내가 나열한 컬럼 순서대로 값을 넣을 수 있음 (본 테이블의 컬럼 순서를 기억하지 않아도 됨)
--      : 내가 원하는 컬럼만 뽑아서 값을 넣을 수 있음
-- 단점 : 쓰는 게 너무 많음

ROLLBACK;

-- 어차피 모든 컬럼에 다 집어넣을 거라면 컬럼명 생략 가능
-- => 일부만 넣으면 오류가 남
-- 생략 INSERT
INSERT INTO EMPLOYEE
VALUES(500, '송성실', '990111-1223344', 'song_ss@kh.or.kr', '01023456789', 'D1', 'J7', 'S3',
       3000000, 0.2, 200, SYSDATE, NULL, DEFAULT);

INSERT INTO EMPLOYEE
VALUES(500, '송성실', '990111-1223344', 'J7', 'S3'); -- SQL 오류: ORA-00947: 값의 수가 충분하지 않습니다
-- 00947. 00000 -  "not enough values"
-- 장점 : 쓰는 게 적음
-- 단점 : 모든 컬럼에 값을 집어넣어야 함
--      : 본 테이블의 컬럼 순서를 알고 있어야 함

COMMIT;

CREATE TABLE EMP_01(
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(30),
    DEPT_TITLE VARCHAR2(20)
);

SELECT * FROM EMP_01;

INSERT INTO EMP_01(
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE
    FROM EMPLOYEE
         LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
); -- VALUES를 안 쓰고 소괄호로 여러 개의 행을 한 번에 삽입 가능

-- INSERT ALL : 여러 개 테이블을 한 번에 삽입할 때 사용
CREATE TABLE EMP_DEPT_D1
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
   FROM EMPLOYEE
   WHERE 1 = 0; -- 항상 FALSE
   -- 어떤 행을 대입해도 무조건 FALSE이기 때문에 모든 행을 가지고 올 수 없게 됨 => 틀만 뽑아오게 됨
-- WHERE 절이 1 = 0인 경우 모든 행에서 FALSE가 나와 아무 행도 조건을 충족시키지 못하므로 값은 삽입되지 않고 테이블 컬럼만 생성
   
SELECT * FROM EMP_DEPT_D1; -- 아무 값도 들어가지 않음 (틀만 생성)

CREATE TABLE EMP_MANAGER
AS SELECT EMP_ID, EMP_NAME, MANAGER_ID
   FROM EMPLOYEE
   WHERE 1 = 0;

SELECT * FROM EMP_MANAGER;

-- EMP_DEPT_D1 테이블에 EMPLOYEE 테이블에 있는 부서 코드가 D1인 직원을 조회해 사번, 이름, 소속 부서, 입사일 삽입
-- EMP_MANAGER 테이블에 EMPLOYEE 테이블에 있는 부서 코드가 D1인 직원을 조회해 사번, 이름, 관리자 사번 삽입
-- 각각 삽입
INSERT INTO EMP_DEPT_D1(
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
    FROM EMPLOYEE
    WHERE DEPT_CODE = 'D1'
);

SELECT * FROM EMP_DEPT_D1;

INSERT INTO EMP_MANAGER(
    SELECT EMP_ID, EMP_NAME, MANAGER_ID
    FROM EMPLOYEE
    WHERE DEPT_CODE = 'D1'
);

SELECT * FROM EMP_MANAGER;

-- 한 번에 삽입
INSERT ALL
INTO EMP_DEPT_D1 VALUES(EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE)
INTO EMP_MANAGER VALUES(EMP_ID, EMP_NAME, MANAGER_ID)
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID -- 가져올 컬럼이 서로 달라도 한 번에 SELECT하면 됨
    FROM EMPLOYEE
    WHERE DEPT_CODE = 'D1'; -- 서브쿼리의 조건절이 같을 때 사용

SELECT * FROM EMP_DEPT_D1;
SELECT * FROM EMP_MANAGER;

-- 서브쿼리의 조건절이 같지 않아도 사용 가능
-- EMPLOYEE 테이블의 구조를 복사하여 사번, 이름, 입사일, 급여를 기록할 수 있는 EMP_OLD, EMP_NEW 테이블 생성
CREATE TABLE EMP_OLD
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
   FROM EMPLOYEE
   WHERE 1 = 0;
   
CREATE TABLE EMP_NEW
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
   FROM EMPLOYEE
   WHERE 1 = 0;
   
-- EMPLOYEE 테이블의 입사일 기준으로 2000년 1월 1일 이전에 입사한 사원은 EMP_OLD로
-- 2000년 1월 1일 이후에 입사한 사원은 EMP_NEW로 사번, 이름, 입사일, 급여 삽입
-- 각각 삽입
INSERT INTO EMP_OLD(
    SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
    FROM EMPLOYEE
    WHERE HIRE_DATE < '2000/01/01'
);

INSERT INTO EMP_NEW(
    SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
    FROM EMPLOYEE
    WHERE HIRE_DATE >= '2000/01/01'
);

SELECT * FROM EMP_OLD;
SELECT * FROM EMP_NEW;

ROLLBACK;

-- 한번에 삽입
INSERT ALL
WHEN HIRE_DATE < '2000/01/01' THEN -- WHEN으로 각자 다른 조건을 나눠 줌
    INTO EMP_OLD VALUES(EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
WHEN HIRE_DATE >= '2000/01/01' THEN
    INTO EMP_NEW VALUES(EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE; -- 나눠져서 행이 삽입됨(8개/16개)

-- UPDATE : 테이블에 기록된 값 수정(행 개수 변화 X)
CREATE TABLE DEPT_COPY
AS SELECT * FROM DEPARTMENT;

SELECT * FROM DEPT_COPY;
   
-- DEPT_COPY 테이블에서 DEPT_ID가 D9인 행의 DEPT_TITLE을 전략기획팀으로 수정
UPDATE DEPT_COPY
SET DEPT_TITLE = '전략기획팀'
WHERE DEPT_ID = 'D9'; -- WHERE를 쓰지 않으면 모든 행을 수정함
-- 조건 절을 설정하지 않을 시 모든 행에 대해 UPDATE 진행
   
-- 서브쿼리를 사용한 UPDATE
CREATE TABLE EMP_SALARY
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY, BONUS
   FROM EMPLOYEE;

SELECT * FROM EMP_SALARY
WHERE EMP_NAME IN('방명수', '유재식');

--UPDATE EMP_SALARY
--SET SALARY = 2000000, BONUS = 0.2; -- 이렇게 하면 모든 사원의 SALARY, BONUS 변경됨

-- 방명수 사원의 SALARY, BONUS를 유재식과 같게 변경
UPDATE EMP_SALARY
SET SALARY = (SELECT SALARY
              FROM EMP_SALARY
              WHERE EMP_NAME = '유재식'),
    BONUS = (SELECT BONUS
             FROM EMP_SALARY
             WHERE EMP_NAME = '유재식')
WHERE EMP_NAME = '방명수';

SELECT * FROM EMP_SALARY
WHERE EMP_NAME IN('방명수', '유재식', '노옹철', '전형돈', '정중하', '하동운');


UPDATE EMP_SALARY
SET (SALARY, BONUS) = (SELECT SALARY, BONUS -- 묶어서 쓰기
                       FROM EMP_SALARY
                       WHERE EMP_NAME = '유재식')
WHERE EMP_NAME IN('노옹철', '전형돈', '정중하', '하동운');

-- EMP_SALARY 테이블에서 아시아 지역에 근무하는 직원의 보너스를 0.3으로 변경
UPDATE EMP_SALARY
SET BONUS = 0.3
WHERE DEPT_CODE IN (SELECT DEPT_ID
                    FROM DEPARTMENT
                         JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
                    WHERE LOCAL_NAME LIKE 'ASIA%');
                    
UPDATE EMP_SALARY
SET BONUS = 0.3
WHERE EMP_ID IN (SELECT EMP_ID
                 FROM EMP_SALARY
                      JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
                      JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
                 WHERE LOCAL_NAME LIKE 'ASIA%');

SELECT EMP_ID, EMP_NAME, SALARY, BONUS, LOCAL_NAME
FROM EMP_SALARY
     JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
     JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE);

COMMIT;

-- UPDATE를 할 때 주의할 사항
UPDATE DEPARTMENT
SET LOCATION_ID = '112'
WHERE LOCATION_ID = 'L2'; -- ORA-12899: "KH"."DEPARTMENT"."LOCATION_ID" 열에 대한 값이 너무 큼(실제: 3, 최대값: 2)
-- 내가 지정한 데이터 크기보다 큰 값을 입력함

UPDATE DEPARTMENT
SET LOCATION_ID = '77'
WHERE LOCATION_ID = 'L2'; -- ORA-02291: 무결성 제약조건(KH.SYS_C007684)이 위배되었습니다- 부모 키가 없습니다
-- LOCATION 테이블에서 LOCATION_ID를 FOREIGN KEY로 받아오고 있는데 LOCATION 테이블에는 77이라는 값이 없음
-- UPDATE 시 제약조건에 위배되지 않게 변경해야 한다

UPDATE EMPLOYEE
SET DEPT_CODE = '66'
WHERE DEPT_CODE = 'D6'; -- 수행 가능
-- 제약 조건이 걸려 있지 않아서 업데이트 가능(EMPLOYEE가 DEPARTMENT와 연결되어 있지 않음)

ROLLBACK;

-- 외래키 조건 추가하기
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT(DEPT_ID); 
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT; 

UPDATE EMPLOYEE
SET EMP_NAME = NULL; -- ORA-01407: NULL로 ("KH"."EMPLOYEE"."EMP_NAME")을 업데이트할 수 없습니다
-- NOT NULL 제약조건

-- DELETE : 테이블에 있는 행 삭제(행의 개수 줄어듦)
COMMIT;

SELECT * FROM EMPLOYEE;

DELETE FROM EMPLOYEE
WHERE EMP_NAME = '송성실';

DELETE FROM EMPLOYEE; -- WHERE절이 없으면 전부 삭제됨

ROLLBACK;

DELETE FROM DEPARTMENT
WHERE DEPT_ID = 'D1'; -- ORA-02292: 무결성 제약조건(KH.SYS_C007699)이 위배되었습니다- 자식 레코드가 발견되었습니다
-- FOREIGN KEY 제약 조건 때문에 참조되고 있는 값은 삭제 불가능

ALTER TABLE EMPLOYEE
DISABLE CONSTRAINT SYS_C007699 CASCADE; -- 제약조건 비활성화

SELECT * FROM DEPARTMENT;
SELECT * FROM EMPLOYEE WHERE DEPT_CODE = 'D1';

ALTER TABLE EMPLOYEE
ENABLE CONSTRAINT SYS_C007699; -- 제약조건 활성화

COMMIT;

-- TRUNCATE : 테이블의 전체 행 삭제
-- DELETE보다 수행 속도가 빠름, ROLLBACK 통해 복구 불가능
-- DELETE는 ROLLBACK을 할 수 있기 때문에 지우고도 계속 가지고 있어서 수행 속도가 TRUNCATE보다 느림
SELECT * FROM EMP_SALARY;

DELETE FROM EMP_SALARY;

ROLLBACK;

TRUNCATE TABLE EMP_SALARY; -- Table EMP_SALARY이(가) 잘렸습니다.
-- ROLLBACK을 해도 돌려지지 않음
