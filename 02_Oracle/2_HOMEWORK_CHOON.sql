-- [Basic SELECT]
-- 1. 춘 기술대학교의 학과 이름과 계열을 표시하시오. 단, 출력 헤더는 "학과 명", "계열"
SELECT DEPARTMENT_NAME "학과 명", CATEGORY "계열"
FROM TB_DEPARTMENT;

-- 2. 학과 정원 출력
SELECT DEPARTMENT_NAME || '의 정원은 ' || CAPACITY || '명입니다.' AS "학과별 정원"
FROM TB_DEPARTMENT;

-- 3. "국어국문학과"에 다니는 휴학 중인 여학생 출력
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE SUBSTR(STUDENT_SSN, INSTR(STUDENT_SSN, '-') + 1, 1) = 2 
--       AND DEPARTMENT_NO = 1 
       AND DEPARTMENT_NO =
            (SELECT DEPARTMENT_NO
             FROM TB_DEPARTMENT
             WHERE DEPARTMENT_NAME = '국어국문학과')
       AND ABSENCE_YN = 'Y';

-- 4. 대출 도서 장기 연체자 출력
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO IN ('A513079', 'A513090', 'A513091', 'A513110', 'A513119');

-- 5. 입학 정원이 20명 이상 30명 이하인 학과의 학과 이름, 계열 출력
SELECT DEPARTMENT_NAME, CATEGORY
FROM TB_DEPARTMENT
WHERE CAPACITY BETWEEN 20 AND 30;

-- 6. 총장은 소속 학과가 없다. 총장의 이름은?
SELECT PROFESSOR_NAME
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NULL;

-- 7. 학과가 지정되어 있지 않은 학생 출력
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE DEPARTMENT_NO IS NULL;

-- 8. 선수과목이 존재하는 과목 출력
SELECT CLASS_NO
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;

-- 9. 춘 대학에 있는 계열 출력
SELECT DISTINCT CATEGORY
FROM TB_DEPARTMENT;

-- 10. 재학 중인 전주 거주 학생들의 학번, 이름, 주민번호 출력
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE STUDENT_ADDRESS LIKE '%전주%' AND ABSENCE_YN = 'N' 
       AND EXTRACT(YEAR FROM ENTRANCE_DATE) = '2002';

-- [Additional SELECT - 함수]
-- 1. 영어영문학과 학생들의 학번, 이름, 입학 년도를 입학 년도가 빠른 순으로 출력
SELECT STUDENT_NO 학번, STUDENT_NAME 이름, TO_CHAR(ENTRANCE_DATE, 'YYYY-MM-DD') "입학 년도"
FROM TB_STUDENT
WHERE DEPARTMENT_NO = '002'
ORDER BY ENTRANCE_DATE;

-- 2. 이름이 세 글자가 아닌 교수 이름과 주민번호 출력
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR
WHERE PROFESSOR_NAME NOT LIKE '___';

-- 3. 남자 교수들의 이름과 나이 출력, 나이 오름차순으로 출력
SELECT PROFESSOR_NAME 교수이름, 
        TO_CHAR(SYSDATE, 'YYYY')
        - TO_CHAR(TO_DATE(SUBSTR(PROFESSOR_SSN, 1, 2), 'YY'), '"19"YY')
        "나이"
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN, INSTR(PROFESSOR_SSN, '-') + 1, 1) = 1
ORDER BY 나이;

-- 4. 교수의 이믈에서 성을 제외한 이름만 출력 (단, 성이 2자인 경우는 없음)
SELECT SUBSTR(PROFESSOR_NAME, 2) 이름
FROM TB_PROFESSOR;

-- 5. 재수생 입학자 구하기
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE EXTRACT(YEAR FROM ENTRANCE_DATE) - ('19' || SUBSTR(STUDENT_SSN, 1, 2)) > '19';

-- 6. 2020년 크리스마스 요일
SELECT TO_CHAR(TO_DATE('20201225', 'YYYYMMDD'), 'DAY') "2020 크리스마스"
FROM DUAL;

-- 7. TO_DATE('99/10/11', 'YY/MM/DD'), TO_DATE('49/10/11', 'YY/MM/DD'),
--    TO_DATE('99/10/11', 'RR/MM/DD'), TO_DATE('49/10/11', 'RR/MM/DD')
--    각각 몇 년 몇 월 몇 일을 의미하는가?
SELECT TO_CHAR(TO_DATE('99/10/11', 'YY/MM/DD'), 'YYYY"년 "MM"월 "DD"일"') A,
        TO_CHAR(TO_DATE('49/10/11', 'YY/MM/DD'), 'YYYY"년 "MM"월 "DD"일"') B,
        TO_CHAR(TO_DATE('99/10/11', 'RR/MM/DD'), 'YYYY"년 "MM"월 "DD"일"') C,
        TO_CHAR(TO_DATE('49/10/11', 'RR/MM/DD'), 'YYYY"년 "MM"월 "DD"일"') D
FROM DUAL;

-- 8. 2000년도 이전 학번을 가진 학생들의 학번과 이름 출력
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO NOT LIKE 'A%';

SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE SUBSTR(STUDENT_NO, 1, 1) != 'A';

-- 9. 학번이 A517178인 한아름 학생의 학점 총 평점 구하기
SELECT ROUND(AVG(POINT), 1) 평점
FROM TB_GRADE
WHERE STUDENT_NO = 'A517178';

-- 10. 학과별 학생 수를 구하여 학과 번호, 학생 수 출력
--SELECT DEPARTMENT_NO "학과 번호", COUNT(DEPARTMENT_NO) "학생 수(명)"
SELECT DEPARTMENT_NO "학과 번호", COUNT(*) "학생 수(명)"
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY "학과 번호";

-- 11. 지도 교수를 배정받지 못한 학생 수 출력
SELECT COUNT(*)
FROM TB_STUDENT
WHERE COACH_PROFESSOR_NO IS NULL;

-- 12. 학번이 A112113인 김고운 학생의 년도별 평점
SELECT SUBSTR(TERM_NO, 1, 4) "년도", ROUND(AVG(POINT), 1) "년도 별 평점"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO, 1, 4)
ORDER BY "년도";

-- 13. 학과 별 휴학생 수 출력
SELECT DEPARTMENT_NO 학과코드명, COUNT(DECODE(ABSENCE_YN, 'Y', 1)) "휴학생 수"
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY "학과코드명";

-- 14. 동명이인 찾기
--SELECT STUDENT_NAME 동일이름, COUNT(STUDENT_NAME) "동명인 수"
SELECT STUDENT_NAME 동일이름, COUNT(*) "동명인 수"
FROM TB_STUDENT
GROUP BY STUDENT_NAME
--HAVING COUNT(STUDENT_NAME) >= 2
HAVING COUNT(*) >= 2
ORDER BY "동일이름";

-- 15. 학번이 A112113인 김고운 학생의 년도, 학기 별 평점과 년도별 누적 평점, 총 평점 구하기
SELECT SUBSTR(TERM_NO, 1, 4) 년도, SUBSTR(TERM_NO, 5, 2) 학기, 
        ROUND(AVG(POINT), 1) 평점
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY ROLLUP(SUBSTR(TERM_NO, 1, 4), SUBSTR(TERM_NO, 5, 2))
ORDER BY "년도", "학기";




