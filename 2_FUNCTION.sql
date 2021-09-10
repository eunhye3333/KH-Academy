-- 함수 : 컬럼의 값을 읽어서 계산한 결과 리턴
-- 단일행 함수 : 컬럼에 기록된 n개의 값을 읽어 n개의 결과 리턴
-- 그룹 함수 : 컬럼에 기록된 n개의 값을 읽어 1개의 결과 리턴
-- 단일행함수 그룹함수는 함께 사용할 수 없다 : 결과 행의 개수가 다르기 때문

-- 단일행 함수
-- 1. 문자 관련 함수
-- LENGTH/LENGTHB
SELECT LENGTH('오라클'), LENGTHB('오라클')
FROM DUAL; -- DUAL은 가상 테이블을 말함
-- FROM EMPLOYEE로 해도 되는데 그러면 결과가 모든 행에 대해서 출력됨
-- LENGTH : 글자의 길이를 반환
-- LENGTHB : BYTE의 크기를 반환. 한글 한 글자는 3BYTE

SELECT LENGTH(EMAIL), LENGTHB(EMAIL)
FROM EMPLOYEE;
-- 문자, 숫자 특수문자는 1BYTE로 인식

-- INSTR : 해당 문자열의 위치를 반환. JAVA는 0부터 세는 게 기본이지만 Oracle는 1부터 셈
SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL;
-- 가장 먼저 나오는 B의 위치 반환
SELECT INSTR('AABAACAABBAA', 'Z') FROM DUAL;
-- 없는 문자를 넣는 경우 0이 나옴. JAVA에서는 위치니까 없으면 -1을 반환했는데 Oracle에서는 0이라는 위치가 없으므로 없는 경우 0 반환
SELECT INSTR('AABAACAABBAA', 'B', 1) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', 7) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', 1, 2) FROM DUAL;

-- EMPLOYEE 테이블에서 이메일의 @ 위치 반환
SELECT INSTR(EMAIL, '@') FROM EMPLOYEE;

-- LPAD/RPAD
-- 제시한 숫자만큼의 공간을 만들어 놓고 남는 공간은 임의의 문자로 왼쪽/오른쪽에 채워 넣음
SELECT LPAD(EMAIL, 20) FROM EMPLOYEE;
SELECT LPAD(EMAIL, 20, '#') FROM EMPLOYEE; -- 앞부분이 #으로 채워져서 나옴
SELECT RPAD(EMAIL, 20, '#') FROM EMPLOYEE;

-- LTRIM/RTRIM/TRIM : 해당 부분(왼쪽/오른쪽/전체)의 공백 또는 해당하는 문자를 제거해 줌
-- LTRIM : 왼쪽 부분 제거
SELECT LTRIM('   KH') FROM DUAL;
SELECT LTRIM('KH   ') A FROM DUAL;
SELECT LTRIM('   KH', ' ') FROM DUAL;
SELECT LTRIM('00012345', '0') FROM DUAL;
SELECT LTRIM('123123KH', '123') FROM DUAL;
SELECT LTRIM('123123KH123', '123') FROM DUAL;
SELECT LTRIM('ACBBAKH', 'ABC') FROM DUAL;

SELECT PHONE, LTRIM(PHONE, '010') FROM EMPLOYEE; 
-- 앞이 010인 번호들만 지우기 위해 사용했는데 0 또는 1을 지운다는 뜻이기 때문에 원하는 결과가 출력 안 됨

-- RTRIM : 오른쪽 부분 제거
SELECT RTRIM('KH   ') A FROM DUAL;
SELECT RTRIM('123123KH', '123') FROM DUAL;

SELECT EMAIL, RTRIM(EMAIL, '@kh.or.kr') FROM EMPLOYEE;
-- 뒤의 문자열을 하나의 문자열로 인식하지 않고 각각의 문자로 인식하여 지우기 때문에 원하지 않는 부분도 지워짐

-- TRIM : 양쪽 제거(지정해주지 않는 경우), 어디부터 지울지 지정도 가능
SELECT TRIM('   KH   ') A FROM DUAL;
SELECT TRIM('Z' FROM 'ZZZKHZZZ') FROM DUAL;
--SELECT TRIM('123' FROM '123123KH12') FROM DUAL; -- 트림 설정은 하나의 문자만 가능
SELECT TRIM(LEADING 'Z' FROM'ZZZKHZZZ') FROM DUAL; -- 앞에서부터
SELECT TRIM(TRAILING 'Z' FROM'ZZZKHZZZ') FROM DUAL; -- 뒤에서부터
SELECT TRIM(BOTH 'Z' FROM'ZZZKHZZZ') FROM DUAL; -- 양쪽 모두


-- SUBSTR = Strig.subString() 내가 원하는 위치에 있는 문자열 일부 반환
SELECT SUBSTR('SHOWMETHEMONEY', 7) FROM DUAL;
-- 7번째 문자부터 끝까지 반환
SELECT SUBSTR('SHOWMETHEMONEY', 5, 2) FROM DUAL;
-- 5번째부터 2개를 반환
SELECT SUBSTR('SHOWMETHEMONEY', 5, 0) FROM DUAL; -- NULL 반환됨
SELECT SUBSTR('SHOWMETHEMONEY', -8, 3) FROM DUAL;
-- -8번째(뒤에서부터 8번째)부터 3개가 반환됨. 거꾸로 반환되지 않음. THE 반환

-- EMPLOYEE 테이블의 이름, 이메일, @ 이후를 제외한 아이디 조회
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@') -1) 아이디  FROM EMPLOYEE;

-- 주민등록번호를 이용하여 남/여 판단하여 이름, 성별 조회
SELECT EMP_NAME, SUBSTR(EMP_NO, 8, 1) 성별 FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 남자만 조회(사원 명, '남')
SELECT EMP_NAME 사원명, '남' 성별
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = 1;

-- EMPLOYEE 테이블에서 여자만 조회(사원 명, '여')
SELECT EMP_NAME 사원명, '여' 성별
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = 2;

-- EMPLOYEE 테이블에서 직원들의 주민번호를 이용하여 사원명, 생년, 생월, 생일 조회
SELECT EMP_NAME 사원명, SUBSTR(EMP_NO, 1, 2) 생년, SUBSTR(EMP_NO, 3, 2) 생월, SUBSTR(EMP_NO, 5, 2) 생일
FROM EMPLOYEE;

-- LOWER/UPPER/INITCAP
-- 다 소문자로 / 다 대문자로 / 단어의 첫 글자만 대문자로
SELECT LOWER('Welcome To My World') LOWER, 
        UPPER('Welcome To My World') UPPER,
        INITCAP('Welcome To My World') INITCAP FROM DUAL;
SELECT INITCAP('WELCOME TO MY WORLD') INITCAP FROM DUAL;     

-- CONCAT : 문자열을 붙여 줌
SELECT CONCAT('가나다라', '마바사') FROM DUAL;
SELECT '가나다라' || '마바사' FROM DUAL; -- 결과가 같음

-- REPLACE : 바꿔 주는 것
SELECT REPLACE('서울시 강남구 역삼동', '역삼동', '삼성동') FROM DUAL;
SELECT REPLACE('박신우강사님은 G강의장에 있습니다', '강사님', '선생님') FROM DUAL;

-- EMPLOYEE 테이블에서 사원명, 주민번호 조회 주민번호는 생년월일만 보이게 하고 '-' 다음은 '*'로 변경
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 7), LENGTH(EMP_NO), '*') 주민번호
FROM EMPLOYEE;

SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, INSTR(EMP_NO, '-')), LENGTH(EMP_NO), '*') 주민번호
FROM EMPLOYEE;

SELECT EMP_NAME, REPLACE(EMP_NO, SUBSTR(EMP_NO, 8), '*******') 주민번호
FROM EMPLOYEE;

SELECT EMP_NAME, REPLACE(EMP_NO, SUBSTR(EMP_NO, INSTR(EMP_NO, '-') + 1), '*******') 주민번호
FROM EMPLOYEE;

SELECT EMP_NAME, SUBSTR(EMP_NO, 1, INSTR(EMP_NO, '-')) || '*******' 주민번호
FROM EMPLOYEE;

-- 2. 숫자 관련 함수
-- ABS : 절대값
SELECT ABS(10.9) FROM DUAL;
SELECT ABS(-10.9) FROM DUAL;

-- MOD : 나머지 계산
SELECT MOD(10, 3) FROM DUAL;
SELECT MOD(-10, 3) FROM DUAL;
SELECT MOD(10, -3) FROM DUAL; -- 부호는 나누어지는 수를 따라감

-- ROUND : 지정하지 않으면 첫번째 자리에서 반올림
SELECT ROUND(123.456) FROM DUAL;
SELECT ROUND(123.678) FROM DUAL;
SELECT ROUND(123.456, 0) FROM DUAL;
SELECT ROUND(123.456, 1) FROM DUAL; -- 소수 첫 번째 자리까지 출력
SELECT ROUND(123.456, 2) FROM DUAL;
SELECT ROUND(123.456, -1) FROM DUAL; -- 일의 자리에서 반올림 : 120

-- FLOOR : 내림, 자리수 지정 불가능 -> 수학적으로 숫자를 내리는 것
SELECT FLOOR(123.456) FROM DUAL;
SELECT FLOOR(123.678) FROM DUAL;

-- TRUNC : 소수점 이하의 숫자를 절삭하는 것, 아예 자르는 것
SELECT TRUNC(123.456) FROM DUAL;
SELECT TRUNC(123.678) FROM DUAL;

-- CEIL : 올림
SELECT CEIL(123.456) FROM DUAL;
SELECT CEIL(123.678) FROM DUAL;

-- 3. 날짜 관련 함수
-- SYSDATE : 오늘 날짜를 가진 함수
SELECT SYSDATE FROM DUAL;

-- MONTHS_BETWEEN : 개월수의 차이를 숫자로 리턴
-- EMPLOYEE 테이블에서 사원의 이름, 입사일, 근무 개월수 조회
SELECT EMP_NAME, HIRE_DATE, MONTHS_BETWEEN(SYSDATE, HIRE_DATE)
FROM EMPLOYEE;

SELECT EMP_NAME, HIRE_DATE, MONTHS_BETWEEN(HIRE_DATE, SYSDATE)
FROM EMPLOYEE; -- 음수 출력됨

SELECT EMP_NAME, HIRE_DATE, ABS(MONTHS_BETWEEN(HIRE_DATE, SYSDATE))
FROM EMPLOYEE; -- 절대값을 리턴해야 실수해도 음수가 안 나올 수 있음

SELECT EMP_NAME, HIRE_DATE, CEIL(ABS(MONTHS_BETWEEN(HIRE_DATE, SYSDATE))) || '개월차' 개월차
FROM EMPLOYEE; -- 올림 처리를 하면 개월차도 구할 수 있음

-- ADD_MONTHS : 날짜에 숫자만큼 개월수를 더하여 날짜 리턴
SELECT ADD_MONTHS(SYSDATE, 2) FROM DUAL;
SELECT ADD_MONTHS(SYSDATE, 4) FROM DUAL; -- 년도까지 변함

-- NEXT_DAY : 기준 날짜에서 구하려는 요일에 가장 가까운 날짜 리턴
-- 1=일 / 2=월 / 3=화 / 4=수 / 5=목 / 6=금 / 7=토
SELECT SYSDATE, NEXT_DAY(SYSDATE, '금요일') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 6) FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '금') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '월남쌈 맛있잖아, 그치?') FROM DUAL;
-- 제일 가까운 월요일이 출력됨 => 맨 앞이 월이라서
--SELECT SYSDATE, NEXT_DAY(SYSDATE, '우뢰와 같은 박수를 보내주세요') FROM DUAL;
-- 제일 앞이 우이기 때문에 지정한 요일이 부적합하다고 나옴
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'FRIDAY') FROM DUAL; -- 영어는 설정을 바꿔 주지 않는 이상 인지 불가능
ALTER SESSION SET NLS_LANGUAGE = AMERICAN; -- 영어로 변경 시 인지 가능
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'FRI') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'FRISKJDLKSJLKD') FROM DUAL; -- 앞이 FRI라서 인지 가능
ALTER SESSION SET NLS_LANGUAGE = KOREAN; -- 한글로 변경

-- LAST_DAY : 해당 월의 마지막 날짜를 구하여 리턴
SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL;

-- EMPLOYEE 테이블에서 사원 명, 입사일-오늘, 오늘-입사일 조회 단 별칭은 근무일수1, 근무일수2로 하고 모두 정수처리(내림)
SELECT EMP_NAME, FLOOR(HIRE_DATE - SYSDATE) 근무일수1, FLOOR(SYSDATE - HIRE_DATE) 근무일수2
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 사번이 홀수인 직원들의 정보 모두 조회
SELECT *
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2) = 1;

-- EMPLOYEE 테이블에서 근무 년수가 20년 이상인 직원 정보 조회
SELECT *
FROM EMPLOYEE
--WHERE (SYSDATE- HIRE_DATE) / 365 >= 20;
--WHERE MONTHS_BETWEEN(SYSDATE, HIRE_DATE) >= 240;
WHERE ADD_MONTHS(HIRE_DATE, 240) <= SYSDATE;

-- EMPLOYEE 테이블에서 사원 명, 입사일, 입사한 달의 근무 일수 조회
SELECT EMP_NAME, HIRE_DATE, LAST_DAY(HIRE_DATE) - HIRE_DATE + 1 근무일수
FROM EMPLOYEE;

-- EXTRACT : 년, 월, 일 정보를 추출하여 리턴함
-- EMPLOYEE 테이블에서 사원의 이름, 입사 년도, 입사 월, 입사일
SELECT EMP_NAME 이름,
        EXTRACT(YEAR FROM HIRE_DATE) 입사년도,
        EXTRACT(MONTH FROM HIRE_DATE) "입사 월",
        EXTRACT(DAY FROM HIRE_DATE) "입사 일"
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 사원의 이름, 입사일, 근무 년수 조회
--      단 근무년수는 현재 년도 - 입사 년도로 조회
SELECT EMP_NAME, HIRE_DATE, EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) "근무 년수"
FROM EMPLOYEE;

-- 4. 형변환 함수
-- TO_CHAR : 날짜형/숫자형 데이터를 문자형 데이터로 변경
SELECT TO_CHAR(1234), 1234 AAAAAAA FROM DUAL; -- 문자는 왼쪽 정렬, 숫자는 오른쪽 정렬
SELECT TO_CHAR(1234, '99999') A FROM DUAL; -- 5자리로 만들어서 앞에 공백이 들어감
SELECT TO_CHAR(1234, '00000') A FROM DUAL; -- 빈 자리를 0으로 채워두는 것
SELECT TO_CHAR(1234, 'L99999') A FROM DUAL; -- 원화 표시 가능
SELECT TO_CHAR(1234, 'FML99999') A FROM DUAL; -- 원화 표시인데 앞에 공백 지우기
SELECT TO_CHAR(1234, '$99999') A FROM DUAL;
SELECT TO_CHAR(1234, 'FM$99999') A FROM DUAL;
SELECT TO_CHAR(1234, '99,999') A FROM DUAL; -- 자리수 구분
SELECT TO_CHAR(1234, 'FM99,999') A FROM DUAL;
SELECT TO_CHAR(1234, '999') A FROM DUAL; -- 자리수가 표시할 숫자보다 적으면 표시할 수 없기 때문에 ####으로 출력

-- EMPLOYEE 테이블에서 사원명, 급여 표시
-- 급여'\9,000,000' 형식으로 표시
SELECT EMP_NAME, TO_CHAR(SALARY, 'FML999,999,999') 급여
FROM EMPLOYEE;

SELECT TO_CHAR(SYSDATE, 'PM HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'AM HH:MI:SS') FROM DUAL; -- 현재가 오후라서 AM 해도 오전이라고 나오지 않음
SELECT TO_CHAR(SYSDATE, 'AM HH24:MI:SS') FROM DUAL; -- 24시간 기준
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-FMMM-DD DAY') FROM DUAL; -- FM을 넣으면 앞에 0이 빠짐 
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-FMDD DAY') FROM DUAL; -- 일에만 0이 빠짐 달에만 0이 빠지게는 못 함
SELECT TO_CHAR(SYSDATE, 'YYYY"년" MM"월" DD"일" DAY') FROM DUAL; -- 년, 월, 일은 데이터이기 때문에 ""로 묶어 줘야 됨

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

SELECT TO_CHAR(SYSDATE, 'DDD') "1년 기준", 
        TO_CHAR(SYSDATE, 'DD') "달 기준", 
        TO_CHAR(SYSDATE, 'D') "주 기준" -- 주 기준으로 5일째
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'Q'), -- 분기
        TO_CHAR(SYSDATE, 'DAY'),
        TO_CHAR(SYSDATE, 'DY')
FROM DUAL;

-- EMPLOYEE 테이블에서 이름, 입사일 조회
--    입사일 : 0000년 00월 00일 (0)
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일 ("DY")"') 입사일
FROM EMPLOYEE;

-- TO_DATE : 숫자뿐 아니라 문자까지 날짜형 데이터로 변경
SELECT TO_DATE('20200202', 'YYYYMMDD') FROM DUAL;
SELECT TO_DATE(20200202, 'YYYYMMDD') FROM DUAL;

SELECT TO_CHAR(TO_DATE('20200202 153824', 'YYYYMMDD HH24MISS'), 'YYYY-MM-DD HH:MI:SS') FROM DUAL;

-- TO_DATE에서 두 자리 연도에 YY를 적용시키면 무조건 현재 세기(21세기, 2000년대)가 적용
--                          RR을 적용시키면 두 자리 연도 수가 50 이상일 때는 이전 세기(20세기, 1900년대),
--                                                        50 미만일 때는 현재 세기(21세기, 2000년대) 적용 
-- 문자를 날짜로 바꿀 때는 R을 사용하는 게 조금 더 좋다
SELECT TO_CHAR(TO_DATE('990311', 'YYMMDD'), 'YYYYMMDD') "99YY", -- 20990311
        TO_CHAR(TO_DATE('070108', 'YYMMDD'), 'YYYYMMDD') "07YY", -- 20070108
        TO_CHAR(TO_DATE('990311', 'RRMMDD'), 'YYYYMMDD') "99RR", -- 19990311
        TO_CHAR(TO_DATE('070108', 'RRMMDD'), 'YYYYMMDD') "07RR" -- 20070108
FROM DUAL;

-- TO_NUMBER : 문자형 데이터를 숫자형 테이터로 변경 (날짜는 불가능)
SELECT TO_NUMBER('12345') FROM DUAL;
SELECT 1111 + 2222 FROM DUAL;
SELECT '1111' + '2222' FROM DUAL; -- 문자도 알아서 숫자로 계산해 줌
--SELECT '1,111' + '2,222' FROM DUAL; -- 하지만 이렇게는 안 됨 중간에 문자가 들어가서
SELECT TO_NUMBER('1,111', '999,999') + TO_NUMBER('2,222', '9,999')
FROM DUAL;

-- 5. NULL 처리 함수
-- NVL : 없는 것에만 대해
SELECT EMP_NAME, BONUS, NVL(BONUS, 0), -- NULL인 경우 다 0이 들어가짐
        NVL(DEPT_CODE, '부서X') -- 숫자를 넣는 게 아니라 문자를 넣을 수도 있음
FROM EMPLOYEE;

-- NVL2 : 있는 것과 없는 것 모두
SELECT EMP_NAME, BONUS, NVL2(BONUS, 0.7, 0.5) -- 보너스에 값이 있으면 0.7, NULL이면 0.5
FROM EMPLOYEE;

-- NULLIF : 비교하여 같다고 했을 때 조건, 다를 때 조건
SELECT NULLIF(123, 123), NULLIF(123, 132) FROM DUAL;
-- 값이 같으면 NULL 반환, 다르면 앞의 값 반환

-- 6. 선택 함수
-- 여러 개의 경우가 있을 때 선택하는 경우
-- DECODE : DECODE(계산식|컬럼명, 조건값1, 선택값1, 조건값2, 선택값2, ...)
-- 비교하고자 하는 값/컬럼이 조건식과 같으면 그 뒤에 있는 선택값 반환
SELECT EMP_ID, EMP_NAME, EMP_NO,
        DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', 2, '여') 성별 -- 1이면 남, 2면 여
FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, EMP_NO,
        DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', '여') 성별 -- 1이면 남, 나머지는 다 여 => 결과가 1 아니면 2이기 때문에 이렇게 써도 됨
FROM EMPLOYEE;

-- 직급 코드가 J7이면 직원의 급여를 10% 인상
-- 직급 코드가 J6이면 직원의 급여를 15% 인상
-- 직급 코드가 J5이면 직원의 급여를 20% 인상
-- 그 외 직급은 급여를 5% 인상
-- 직원명, 직급 코드, 급여, 인상 급여
SELECT EMP_NAME, JOB_CODE, SALARY, 
        DECODE(JOB_CODE, 'J7', SALARY * 1.1, 
                         'J6', SALARY * 1.15, 
                         'J5', SALARY * 1.2, SALARY * 1.05) "인상 급여"
FROM EMPLOYEE;

SELECT EMP_NAME, JOB_CODE, SALARY, 
        SALARY * (1 + DECODE(JOB_CODE, 'J7', 0.1, 
                                       'J6', 0.15, 
                                       'J5', 0.2, 0.05)) "인상 급여"
FROM EMPLOYEE;

-- CASE WHEN
-- CASE WHEN 조건식 THEN 결과값
--      WHEN 조건식 THEN 결과값
--      ELSE 결과값
-- END
-- DECODE는 범위는 불가능했는데 CASE WHEN은 범위값까지 가능
-- 비교하고자 하는 값 또는 컬럼이 조건식과 같으면 결과값 반환
-- 조건은 범위값 가능
SELECT EMP_ID, EMP_NAME, EMP_NO, 
        CASE WHEN SUBSTR(EMP_NO, 8, 1) = 1 THEN '남자'
              WHEN SUBSTR(EMP_NO, 8, 1) = 2 THEN '여자'
        END 성별
FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, EMP_NO, 
        CASE WHEN SUBSTR(EMP_NO, 8, 1) = 1 THEN '남자'
              ELSE '여자' -- 1 아니면 2라서 
        END 성별
FROM EMPLOYEE;

-- 직급 코드가 J7이면 직원의 급여를 10% 인상
-- 직급 코드가 J6이면 직원의 급여를 15% 인상
-- 직급 코드가 J5이면 직원의 급여를 20% 인상
-- 그 외 직급은 급여를 5% 인상
-- 직원명, 직급 코드, 급여, 인상 급여
SELECT EMP_NAME, JOB_CODE, SALARY, 
        CASE WHEN JOB_CODE = 'J7' THEN SALARY * 1.1
             WHEN JOB_CODE = 'J6' THEN SALARY * 1.15
             WHEN JOB_CODE = 'J5' THEN SALARY * 1.2
             ELSE SALARY * 1.05
        END 인상급여
FROM EMPLOYEE;

SELECT EMP_NAME, JOB_CODE, SALARY, 
        CASE JOB_CODE WHEN 'J7' THEN SALARY * 1.1
                       WHEN 'J6' THEN SALARY * 1.15
                       WHEN 'J5' THEN SALARY * 1.2
                       ELSE SALARY * 1.05
        END 인상급여
FROM EMPLOYEE;

-- 사번, 사원 명, 급여, 등급 조회
-- 등급 조건 : 급여가 500만보다 크면 1등금, 350만보다 크면 2등급, 200만보다 크면 3등급 나머지는 4등급
SELECT EMP_ID, EMP_NAME, SALARY,
        CASE WHEN SALARY > 5000000 THEN '1등급'
              WHEN SALARY > 3500000 THEN '2등급'
              WHEN SALARY > 2000000 THEN '3등급'
              ELSE '4등급'
        END 등급
FROM EMPLOYEE;

-- 사번, 사원명, 급여
-- 급여가 500만원 이상이면 '고급'
-- 급여가 300~500만원이면 '중급'
-- 그 이하는 초급으로 출력처리하고 별칭은 '구분'으로 한다.
SELECT EMP_ID, EMP_NAME, SALARY,
        CASE WHEN SALARY >= 5000000 THEN '고급'
             WHEN SALARY >= 3000000 THEN '중급'
             ELSE '초급'
        END 등급
FROM EMPLOYEE;

-- 그룹함수
-- SUM
-- EMPLOYEE 테이블에서 전 사원의 급여 총합
SELECT SUM(SALARY)
FROM EMPLOYEE; -- 결과 1개만 출력

--SELECT SUM(SALARY), SALARY
--FROM EMPLOYEE; -- 출력 안 됨. 행의 개수가 달라서

-- EMPLOYEE 테이블에서 남자 사원의 급여 총합 조회
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = 1;

-- EMPLOYEE 테이블에서 부서 코드가 D5인 직원의 보너스 포함된 연봉 합계 조회
SELECT SUM((SALARY + (SALARY * NVL(BONUS, 0))) *12)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- AVG
-- EMPLOYEE 테이블에서 전 사원의 급여 평균 구하기
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 전 사원의 보너스 평균을 소수 셋째자리에서 반올림
SELECT AVG(BONUS)
FROM EMPLOYEE; -- 0.2166666666666666666666666666666666666667

SELECT ROUND(AVG(BONUS), 2) -- null을 가진 행은 평균에서 제외됨 따라서 정확하지 않다
FROM EMPLOYEE; -- 0.22

SELECT ROUND(AVG(NVL(BONUS, 0)), 2) 
FROM EMPLOYEE; -- 0.08

SELECT AVG(BONUS), AVG(DISTINCT BONUS), AVG(NVL(BONUS, 0))
FROM EMPLOYEE;

-- MIN/MAX : 가장 작은/큰 값, 숫자 문자, 날짜 적용 가능
-- EMPLOYEE 테이블에서 가장 적은 급여, 알파벳 순서가 가장 빠른 이메일, 가장 빠른 입사일 조회
SELECT MIN(SALARY), MIN(EMAIL), MIN(HIRE_DATE)
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 가장 많은 급여, 알파벳 순서가 가장 늦은 이메일, 가장 최근 입사일 조회
SELECT MAX(SALARY), MAX(EMAIL), MAX(HIRE_DATE)
FROM EMPLOYEE;

-- COUNT 
-- COUNT(컬럼명) : NULL이 제외된 해당 컬럼에 대한 개수 리턴
-- COUNT(DISTINCT 컬럼명) : 중복이 제거된 행 개수 리턴
-- COUNT(*) : NULL을 포함한 전체 행 개수 리턴
-- 전체 사원 수, 부서 코드가 있는 사원 수, 사원들이 속해 있는 부서의 수
SELECT COUNT(*), COUNT(DEPT_CODE), COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE;

