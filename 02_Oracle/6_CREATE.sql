-- DDL : 데이터 정의 언어
-- 객체 생성(CREATE)/수정(ALTER)/삭제(DROP)

-- 테이블 생성
-- CREATE TABLE 테이블명(컬럼명 자료형(크기),...);
CREATE TABLE MEMBER(
    MEMBER_ID VARCHAR2(10),
    MEMBER_PWD VARCHAR2(20),
    MEMBER_NAME VARCHAR2(30)
);

COMMENT ON COLUMN MEMBER.MEMBER_ID IS '회원 아이디';
COMMENT ON COLUMN MEMBER.MEMBER_PWD IS '회원 비밀번호';
COMMENT ON COLUMN MEMBER.MEMBER_NAME IS '회원 이름';

SELECT * FROM USER_TABLES; 
-- USER_TABLES : 사용자가 작성한 테이블을 확인하는 뷰
-- DB가 가지고 있는 것. 공용동의어에서 확인 가능

SELECT *
FROM USER_TAB_COLUMNS
WHERE TABLE_NAME = 'MEMBER';
-- USER_TAB_COLUMNS : 컬럼과 관련된 정보를 가지고 있는 뷰

DESC MEMBER;
-- DESC : 테이블 구조

-- 제약 조건(CONSTRAINTS)
-- 테이블 작성 시 각 컬럼에 대해 값 기록에 대한 제약 조건 설정 가능
-- 데이터 무결성 보장을 목적으로 함
-- 데이터 무결성 : 데이터의 정확성, 일관성, 유효성 보장
-- 제약조건은 테이블을 처음 생성할 때 지정해줘도 되고 만들고 나서 지정해줘도 됨

DESC USER_CONSTRAINTS; -- 구조 보기
-- USER_CONSTRAINTS : 사용자가 작성한 제약조건을 확인하는 뷰
SELECT * FROM USER_CONSTRAINTS;
-- 제약조건은 테이블뿐 아니라 계정에도 들어갈 수 있어서 제약조건의 이름이 중복되면 안 됨

SELECT * FROM USER_CONS_COLUMNS; 
-- USER_CONS_COLUMNS : 제약 조건이 걸려 있는 컬럼을 확인하는 뷰

-- NOT NULL : 컬럼에 반드시 값을 기록하게 하는 제약조건
CREATE TABLE USER_NOCONST(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(30),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);

INSERT INTO USER_NOCONST
VALUES(1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.ok.kr');

INSERT INTO USER_NOCONST
VALUES(2, NULL, NULL, NULL, NULL, NULL, NULL); -- 제약 조건이 없어서 들어감

CREATE TABLE USER_NOTNULL(
    USER_NO NUMBER NOT NULL, -- NOT NULL 제약 조건 넣어줌
    -- 이렇게 컬럼 옆에 넣는 것을 컬럼 레벨에서 제약 조건을 설정했다고 함
    USER_ID VARCHAR2(20) NOT NULL,
    USER_PWD VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(30) NOT NULL,
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);

INSERT INTO USER_NOTNULL
VALUES(1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');
-- 잘 들어감

INSERT INTO USER_NOTNULL
VALUES(2, NULL, NULL, NULL, NULL, NULL, NULL);
-- ORA-01400: NULL을 ("KH"."USER_NOTNULL"."USER_ID") 안에 삽입할 수 없습니다

INSERT INTO USER_NOTNULL
VALUES(3, 'user03', 'pass03', '도대담', NULL, NULL, NULL); -- 뒤에 3개는 NOT NULL 제약 조건이 없어서 NULL이 들어갈 수 있음

COMMIT;
-- NOT NULL : 컬럼 레벨에서만 설정할 수 있고 테이블 레벨에서는 불가능

-- UNIQUE : 컬럼 값에 중복을 제한하는 제약 조건
SELECT * FROM USER_NOCONST;

INSERT INTO USER_NOCONST
VALUES(1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr'); -- 중복된 값인데 잘 들어감 => 아이디에 중복값이 들어가면 안 됨

CREATE TABLE USER_UNIQUE(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20) UNIQUE, -- 컬럼 레벨에서의 UNIQUE 제약 조건 설정
    USER_PWD VARCHAR2(30),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    UNIQUE(USER_NO) -- 테이블 레벨에서의 UNIQUE 제약조건 설정
);

INSERT INTO USER_UNIQUE
VALUES(1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');
-- 2번 실행하는 경우 다음 오류 발생 : ORA-00001: 무결성 제약 조건(KH.SYS_C007631)에 위배됩니다
-- SYS_C007631 : UNIQUE 제약조건 => 이미 데이터가 있는데 넣으려고 했다

INSERT INTO USER_UNIQUE
VALUES(2, 'user02', 'pass02', '남나눔', '남', '010-2222-3333', 'nam123@kh.or.kr');

INSERT INTO USER_UNIQUE
VALUES(3, 'user02', 'pass02', '남나눔', '남', '010-2222-3333', 'nam123@kh.or.kr'); -- USER_ID가 같아서 안 됨

INSERT INTO USER_UNIQUE
VALUES(2, 'user03', 'pass02', '남나눔', '남', '010-2222-3333', 'nam123@kh.or.kr'); -- USER_NO가 같아서 안 됨

CREATE TABLE USER_UNIQUE2(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20), 
    USER_PWD VARCHAR2(30),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    UNIQUE(USER_NO, USER_ID) -- UNIQUE 한 번에 넣기 (한 번에 넣을 수 있지 않을까)
);
-- 여러 컬럼을 묶어둔 경우 두 컬럼이 모두 중복됐을 때 오류 발생

INSERT INTO USER_UNIQUE2
VALUES(1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_UNIQUE2
VALUES(1, 'user02', 'pass02', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr'); -- USER_NO가 겹치는데 데이터 삽입 가능

INSERT INTO USER_UNIQUE2
VALUES(2, 'user01', 'pass02', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr'); -- USER_ID가 겹치는데 데이터 삽입 가능

INSERT INTO USER_UNIQUE2
VALUES(2, 'user02', 'pass02', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr'); -- USER_NO, USER_ID가 겹치는데 데이터 삽입 가능
-- UNIQUE(USER_NO, USER_ID)는 묶어서 보는 것이므로 USER_NO, USER_ID가 통으로 완벽하게 같아야 데이터 삽입 불가능
-- 따라서 이미 실행한 문장을 한 번 더 실행하는 경우에는 오류 발생

-- 제약조건 이름 설정
CREATE TABLE CONS_NAME(
    TEST_DATA1 VARCHAR2(20) CONSTRAINT NN_CN_TD1 NOT NULL,
    --                  제약조건이 들어간다 
    --                                이런 이름의 
    --                                     그것은 NOT NULL 제약조건임
    TEST_DATA2 VARCHAR2(20) CONSTRAINT UQ_CN_TD2 UNIQUE,
    TEST_DATA3 VARCHAR2(20),
    CONSTRAINT UK_CN_TD3 UNIQUE(TEST_DATA3) 
);

INSERT INTO CONS_NAME VALUES('TEST1', 'TEST2', 'TEST3');
-- 2번 실행 시 : ORA-00001: 무결성 제약 조건(KH.UQ_CN_TD2)에 위배됩니다 => 이름이 보여서 더 빨리 파악 가능

-- PRIMARY KEY : NOT NULL + UNIQUE
-- 데이터의 값이 중복되지 않는 값으로 존재해야 함 : 행을 구분할 수 있는 식별자 역할
-- 한 테이블 당 한 개만 설정 가능, 컬럼 레벨, 테이블 레벨 둘 다 가능
CREATE TABLE USER_PRIMARYKEY(
    USER_NO NUMBER CONSTRAINT PK_UP_UNO PRIMARY KEY,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(30),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);

INSERT INTO USER_PRIMARYKEY
VALUES(1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_PRIMARYKEY
VALUES(1, 'user02', 'pass02', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr'); -- 1이 중복돼서 안 들어감 
-- ORA-00001: 무결성 제약 조건(KH.PK_UP_UNO)에 위배됩니다 : UNIQUE 제약조건 위배 에러

INSERT INTO USER_PRIMARYKEY
VALUES(NULL, 'user02', 'pass02', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr'); -- NULL을 넣어서 안 들어감
-- ORA-01400: NULL을 ("KH"."USER_PRIMARYKEY"."USER_NO") 안에 삽입할 수 없습니다 : NOT NULL 제약조건 위배 에러
-- 에러 내용이 다름

CREATE TABLE USER_PRIMARYKEY2(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(30),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    CONSTRAINT PK_UP2_UNI_UID PRIMARY KEY(USER_NO, USER_ID)
);

INSERT INTO USER_PRIMARYKEY2
VALUES(1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_PRIMARYKEY2
VALUES(1, 'user02', 'pass02', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr'); 

INSERT INTO USER_PRIMARYKEY2
VALUES(2, 'user01', 'pass02', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');
-- PRIMARY KEY도 테이블로 묶어서 만들 경우 두 개를 한꺼번에 봄, 따라서 중복되어도 무결성 제약조건 오류가 발생하지 않음

INSERT INTO USER_PRIMARYKEY2
VALUES(NULL, 'user03', 'pass02', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');
-- NULL은 하나만 있어도 오류 발생

-- FOREIGN KEY : 참조된 테이블이 제공하는 값만 사용이 가능한 제약 조건
-- 참조할 테이블이 존재해야 함
-- FOREIGN KEY 제약조건으로 테이블과 테이블 간의 관계 형성(다리 역할) 
-- 컬럼 레벨, 테이블 레벨 둘 다 적용 가능

-- 참조할 테이블
CREATE TABLE USER_GRADE(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);

INSERT INTO USER_GRADE VALUES(10, '일반회원');
INSERT INTO USER_GRADE VALUES(20, '우수회원');
INSERT INTO USER_GRADE VALUES(30, '특별회원');

CREATE TABLE USER_FOREIGNKEY(
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20) UNIQUE,
    USER_PWD VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    GRADE_CODE NUMBER CONSTRAINT FK_UF_GC REFERENCES USER_GRADE(GRADE_CODE)
    -- USER_GRADE에 있는 컬럼과 같음 하지만 FOREIGN KEY로 사용할 때 꼭 이름이 같아야 하는 것은 아님. 달라도 됨
);

INSERT INTO USER_FOREIGNKEY
VALUES(1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr', 10);
-- 10을 이용해 USER_GRADE에 있는 '일반회원'까지 연결 가능 - JOIN 이용
SELECT *
FROM USER_FOREIGNKEY
     JOIN USER_GRADE USING(GRADE_CODE);

INSERT INTO USER_FOREIGNKEY
VALUES(2, 'user02', 'pass02', '남나눔', '남', '010-2222-3333', 'nam123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY
VALUES(3, 'user03', 'pass03', '도대담', '남', '010-3333-4444', 'doh123@kh.or.kr', 30);

INSERT INTO USER_FOREIGNKEY
VALUES(4, 'user04', 'pass04', '류라라', '여', '010-4444-5555', 'ryu123@kh.or.kr', NULL); -- 참조를 하지 않겠다

INSERT INTO USER_FOREIGNKEY
VALUES(5, 'user05', 'pass05', '문미미', '여', '010-5555-6666', 'moon123@kh.or.kr', 50); -- 안 들어가짐
-- ORA-02291: 무결성 제약조건(KH.FK_UF_GC)이 위배되었습니다- 부모 키가 없습니다
-- 없는 키를 참조함

COMMIT;

DELETE FROM USER_GRADE -- 지우기
WHERE GRADE_CODE = 10; -- 안 지워짐
-- ORA-02292: 무결성 제약조건(KH.FK_UF_GC)이 위배되었습니다- 자식 레코드가 발견되었습니다
-- 10을 참조하고 있는 데이터가 존재한다, 10을 참조하고 있는 데이터가 존재하기 때문에 삭제 불가능

DELETE FROM USER_GRADE 
WHERE GRADE_CODE = 20; -- 삭제 가능, 20번은 참조하고 있는 데이터가 아무도 없어서

SELECT * FROM USER_GRADE;

ROLLBACK;

-- 삭제 옵션 : 부모 테이블에 있는 데이터를 삭제 시 자식 테이블의 데이터는 어떻게 처리할지 설정하는 것
CREATE TABLE USER_GRADE2(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);

INSERT INTO USER_GRADE2 VALUES(10, '일반회원');
INSERT INTO USER_GRADE2 VALUES(20, '우수회원');
INSERT INTO USER_GRADE2 VALUES(30, '특별회원');

CREATE TABLE USER_FOREIGNKEY2(
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20) UNIQUE,
    USER_PWD VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    GRADE_CODE NUMBER,
    CONSTRAINT FK_UF2_GC FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE2(GRADE_CODE) ON DELETE SET NULL
    --                                                                                 삭제 옵션
    -- ON DELETE SET NULL : 부모 키 삭제 시 자식 키를 NULL로 변경하는 옵션
);

INSERT INTO USER_FOREIGNKEY2
VALUES(1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY2
VALUES(2, 'user02', 'pass02', '남나눔', '남', '010-2222-3333', 'nam123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY2
VALUES(3, 'user03', 'pass03', '도대담', '남', '010-3333-4444', 'doh123@kh.or.kr', 30);

INSERT INTO USER_FOREIGNKEY2
VALUES(4, 'user04', 'pass04', '류라라', '여', '010-4444-5555', 'ryu123@kh.or.kr', NULL); 

COMMIT;

SELECT * FROM USER_GRADE2;
SELECT * FROM USER_FOREIGNKEY2;

DELETE FROM USER_GRADE2
WHERE GRADE_CODE = 10; -- 삭제됨, 10을 참조하고 있던 USER_FOREIGNKEY2 컬럼값이 NULL이 됨

CREATE TABLE USER_GRADE3(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);

INSERT INTO USER_GRADE3 VALUES(10, '일반회원');
INSERT INTO USER_GRADE3 VALUES(20, '우수회원');
INSERT INTO USER_GRADE3 VALUES(30, '특별회원');

CREATE TABLE USER_FOREIGNKEY3(
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20) UNIQUE,
    USER_PWD VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    GRADE_CODE NUMBER,
    CONSTRAINT FK_UF3_GC FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE3(GRADE_CODE) ON DELETE CASCADE
    --                                                                                 삭제 옵션
    -- ON DELETE CASCADE : 부모 키 삭제 시 자식 키도 함께 삭제
);

INSERT INTO USER_FOREIGNKEY3
VALUES(1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY3
VALUES(2, 'user02', 'pass02', '남나눔', '남', '010-2222-3333', 'nam123@kh.or.kr', 10);

INSERT INTO USER_FOREIGNKEY3
VALUES(3, 'user03', 'pass03', '도대담', '남', '010-3333-4444', 'doh123@kh.or.kr', 30);

INSERT INTO USER_FOREIGNKEY3
VALUES(4, 'user04', 'pass04', '류라라', '여', '010-4444-5555', 'ryu123@kh.or.kr', NULL); 

COMMIT;

SELECT * FROM USER_GRADE3;
SELECT * FROM USER_FOREIGNKEY3;

DELETE FROM USER_GRADE3
WHERE GRADE_CODE = 10;

-- CHECK : 컬럼에 기록되는 값에 조건을 설정하는 제약 조건
CREATE TABLE USER_CHECK(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(30),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10) CHECK(GENDER IN('남', '여')),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);

INSERT INTO USER_CHECK
VALUES(1, 'user01', 'pass01', '강건강', '남', '010-1111-2222', 'kang123@kh.or.kr');

INSERT INTO USER_CHECK
VALUES(1, 'user01', 'pass01', '강건강', '남자', '010-1111-2222', 'kang123@kh.or.kr'); -- ORA-02290: 체크 제약조건(KH.SYS_C007657)이 위배되었습니다

CREATE TABLE USER_CHECK2(
    TEST_NUMBER NUMBER,
    CONSTRAINT CK_UC2_TNUM CHECK(TEST_NUMBER > 0)
);

INSERT INTO USER_CHECK2 VALUES(10);
INSERT INTO USER_CHECK2 VALUES(-10); -- 안 들어감

CREATE TABLE USER_CHECK3(
    c_NAME VARCHAR2(15 CHAR),
    C_PRICE NUMBER,
    C_LEVEL CHAR(1),
    C_DATE DATE,
    CONSTRAINT PK_UC3_NAME PRIMARY KEY(C_NAME),
    CONSTRAINT CH_UC3_PRICE CHECK(C_PRICE >= 1 AND C_PRICE <= 99999),
    CONSTRAINT CH_UC3_LEVEL CHECK(C_LEVEL = 'A' OR C_LEVEL = 'B' OR C_LEVEL = 'C'),
    CONSTRAINT CK_UC3_DATE CHECK(C_DATE >= TO_DATE('2021/09/15', 'YYYY/MM/DD'))
);

-- 실습 문제 : 회원 가입용 테이블 생성
CREATE TABLE USER_TEST(
    USER_NO NUMBER CONSTRAINT PK_UT_USERNO PRIMARY KEY,
    USER_ID VARCHAR2(20) CONSTRAINT UQ_UT_USERID UNIQUE,
    USER_PWD VARCHAR2(20) CONSTRAINT NN_UT_USERPWD NOT NULL,
    PNO VARCHAR2(20) CONSTRAINT UQ_UT_PNO UNIQUE CONSTRAINT NN_UT_PNO NOT NULL,
    GENDER VARCHAR2(3) CONSTRAINT CK_UT_GENDER CHECK(GENDER IN ('남', '여')),
    PHONE VARCHAR2(20),
    ADDRESS VARCHAR2(100),
    STATUS VARCHAR2(3) CONSTRAINT NN_UT_STATUS NOT NULL CONSTRAINT CK_UT_STATUS CHECK(STATUS IN ('Y', 'N'))
);
    
-- 테이블 레벨 가능한 제약 조건은 아래에 묶어서 써 주는 게 좋음
CREATE TABLE USER_TEST(
    USER_NO NUMBER,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(20) CONSTRAINT NN_UT_USERPWD NOT NULL,
    PNO VARCHAR2(20) CONSTRAINT NN_UT_PNO NOT NULL,
    GENDER VARCHAR2(3),
    PHONE VARCHAR2(20),
    ADDRESS VARCHAR2(100),
    STATUS VARCHAR2(3) CONSTRAINT NN_UT_STATUS NOT NULL,
    CONSTRAINT PK_UT_USERNO PRIMARY KEY(USER_NO),
    CONSTRAINT UQ_UT_USERID UNIQUE(USER_ID),
    CONSTRAINT UQ_UT_PNO UNIQUE(PNO),
    CONSTRAINT CK_UT_GENDER CHECK(GENDER IN ('남', '여')),
    CONSTRAINT CK_UT_STATUS CHECK(STATUS IN ('Y', 'N'))    
);

-- SUBQUERY를 이용한 테이블 생성
CREATE TABLE EMPLOYEE_COPY
AS SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE_COPY;

CREATE TABLE EMPLOYEE_COPY2
AS SELECT EMP_ID, EMP_NAME, SALARY, DEPT_TITLE, JOB_NAME
   FROM EMPLOYEE
        JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
        JOIN JOB USING(JOB_CODE);
        
SELECT * FROM EMPLOYEE_COPY2;
-- 카피를 할 때 컬럼명, 데이터 타입, 데이터, NOT NULL 제약조건만 복사가 됨
-- 모든 게 다 복사가 되는 것은 아님

CREATE TABLE USER_GRADE4(
    GRADE_CODE NUMBER,
    GRADE_NAME VARCHAR2(30)
);
-- 테이블을 만든 후 제약 조건을 넣어도 됨
-- 테이블을 수정하는 것이기 때문에 객체 수정 ALTER 사용
--ALTER TABLE USER_GRADE4 ADD PRIMARY KEY(GRADE_CODE);
ALTER TABLE USER_GRADE4 ADD CONSTRAINT PK_UG4_GC PRIMARY KEY(GRADE_CODE);

CREATE TABLE USER_FOREIGNKEY4(
    USER_NO NUMBER, -- PRIMARY KEY
    USER_ID VARCHAR2(20), -- UNIQUE
    USER_PWD VARCHAR2(30), -- NOT NULL
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10), -- CHECK
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    GRADE_CODE NUMBER --FOREIGN KEY
);

ALTER TABLE USER_FOREIGNKEY4 ADD PRIMARY KEY(USER_NO);
ALTER TABLE USER_FOREIGNKEY4 ADD UNIQUE(USER_ID);
ALTER TABLE USER_FOREIGNKEY4 ADD CHECK(GENDER IN('남', '여'));
ALTER TABLE USER_FOREIGNKEY4 ADD FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE4/*(GRADE_CODE)*/;
-- 부모 테이블에 참조할 컬럼을 생략할 경우, 부모 테이블의 기본키를 디폴트로 연결
--ALTER TABLE USER_FOREIGNKEY4 ADD NOT NULL(USER_PWD); -- 빨간 줄이 뜸
ALTER TABLE USER_FOREIGNKEY4 MODIFY USER_PWD NOT NULL; -- NOT NULL만 MODIFY

-- 미니 실습
-- DEPARTMENT 테이블의 LOCATION_ID에 외래키 제약조건 추가
-- 참조 테이블은 LOCATION, 참조 컬럼은 LOCATION의 기본값
ALTER TABLE DEPARTMENT ADD FOREIGN KEY(LOCATION_ID) REFERENCES LOCATION/*(LOCAL_CODE)*/;

