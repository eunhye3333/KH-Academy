-- [Basic SELECT]
-- 1. �� ������б��� �а� �̸��� �迭�� ǥ���Ͻÿ�. ��, ��� ����� "�а� ��", "�迭"
SELECT DEPARTMENT_NAME "�а� ��", CATEGORY "�迭"
FROM TB_DEPARTMENT;

-- 2. �а� ���� ���
SELECT DEPARTMENT_NAME || '�� ������ ' || CAPACITY || '���Դϴ�.' AS "�а��� ����"
FROM TB_DEPARTMENT;

-- 3. "������а�"�� �ٴϴ� ���� ���� ���л� ���
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE DEPARTMENT_NO = 1 AND ABSENCE_YN = 'Y';

-- 4. ���� ���� ��� ��ü�� ���
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO IN ('A513079', 'A513090', 'A513091', 'A513110', 'A513119');

-- 5. ���� ������ 20�� �̻� 30�� ������ �а��� �а� �̸�, �迭 ���
SELECT DEPARTMENT_NAME, CATEGORY
FROM TB_DEPARTMENT
WHERE CAPACITY BETWEEN 20 AND 30;

-- 6. ������ �Ҽ� �а��� ����. ������ �̸���?
SELECT PROFESSOR_NAME
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NULL;

-- 7. �а��� �����Ǿ� ���� ���� �л� ���
SELECT STUDENT_NAME
FROM TB_STUDENT
WHERE DEPARTMENT_NO IS NULL;

-- 8. ���������� �����ϴ� ���� ���
SELECT CLASS_NO
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;

-- 9. �� ���п� �ִ� �迭 ���
SELECT DISTINCT CATEGORY
FROM TB_DEPARTMENT;

-- 10. ���� ���� ���� ���� �л����� �й�, �̸�, �ֹι�ȣ ���
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE STUDENT_ADDRESS LIKE '%����%' AND ABSENCE_YN = 'N' 
       AND EXTRACT(YEAR FROM ENTRANCE_DATE) = '2002';

-- [Additional SELECT - �Լ�]
-- 1. ������а� �л����� �й�, �̸�, ���� �⵵�� ���� �⵵�� ���� ������ ���
SELECT STUDENT_NO �й�, STUDENT_NAME �̸�, TO_CHAR(ENTRANCE_DATE, 'YYYY-MM-DD') "���� �⵵"
FROM TB_STUDENT
WHERE DEPARTMENT_NO = '002'
ORDER BY ENTRANCE_DATE;

-- 2. �̸��� �� ���ڰ� �ƴ� ���� �̸��� �ֹι�ȣ ���
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR
WHERE PROFESSOR_NAME NOT LIKE '___';

-- 3. ���� �������� �̸��� ���� ���, ���� ������������ ���
SELECT PROFESSOR_NAME �����̸�, 
        TO_CHAR(SYSDATE, 'YYYY')
        - TO_CHAR(TO_DATE(SUBSTR(PROFESSOR_SSN, 1, 2), 'YY'), '"19"YY')
        "����"
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN, INSTR(PROFESSOR_SSN, '-') + 1, 1) = 1
ORDER BY ����;

-- 4. ������ �̹ɿ��� ���� ������ �̸��� ��� (��, ���� 2���� ���� ����)
SELECT SUBSTR(PROFESSOR_NAME, 2) �̸�
FROM TB_PROFESSOR;

-- 5. ����� ������ ���ϱ�
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE EXTRACT(YEAR FROM ENTRANCE_DATE) - ('19' || SUBSTR(STUDENT_SSN, 1, 2)) > '19';

-- 6. 2020�� ũ�������� ����
SELECT TO_CHAR(TO_DATE('20201225', 'YYYYMMDD'), 'DAY') "2020 ũ��������"
FROM DUAL;

-- 7. TO_DATE('99/10/11', 'YY/MM/DD'), TO_DATE('49/10/11', 'YY/MM/DD'),
--    TO_DATE('99/10/11', 'RR/MM/DD'), TO_DATE('49/10/11', 'RR/MM/DD')
--    ���� �� �� �� �� �� ���� �ǹ��ϴ°�?
SELECT TO_CHAR(TO_DATE('99/10/11', 'YY/MM/DD'), 'YYYY"�� "MM"�� "DD"��"') A,
        TO_CHAR(TO_DATE('49/10/11', 'YY/MM/DD'), 'YYYY"�� "MM"�� "DD"��"') B,
        TO_CHAR(TO_DATE('99/10/11', 'RR/MM/DD'), 'YYYY"�� "MM"�� "DD"��"') C,
        TO_CHAR(TO_DATE('49/10/11', 'RR/MM/DD'), 'YYYY"�� "MM"�� "DD"��"') D
FROM DUAL;

-- 8. 2000�⵵ ���� �й��� ���� �л����� �й��� �̸� ���
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO NOT LIKE 'A%';

SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE SUBSTR(STUDENT_NO, 1, 1) != 'A';

-- 9. �й��� A517178�� �ѾƸ� �л��� ���� �� ���� ���ϱ�
SELECT ROUND(AVG(POINT), 1) ����
FROM TB_GRADE
WHERE STUDENT_NO = 'A517178';

-- 10. �а��� �л� ���� ���Ͽ� �а� ��ȣ, �л� �� ���
SELECT DEPARTMENT_NO "�а� ��ȣ", COUNT(DEPARTMENT_NO) "�л� ��(��)"
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY "�а� ��ȣ";

-- 11. ���� ������ �������� ���� �л� �� ���
SELECT COUNT(*)
FROM TB_STUDENT
WHERE COACH_PROFESSOR_NO IS NULL;

-- 12. �й��� A112113�� ���� �л��� �⵵�� ����
SELECT SUBSTR(TERM_NO, 1, 4) "�⵵", ROUND(AVG(POINT), 1) "�⵵ �� ����"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO, 1, 4)
ORDER BY "�⵵";

-- 13. �а� �� ���л� �� ���
SELECT DEPARTMENT_NO �а��ڵ��, COUNT(DECODE(ABSENCE_YN, 'Y', 1)) "���л� ��"
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY "�а��ڵ��";

-- 14. �������� ã��
SELECT STUDENT_NAME �����̸�, COUNT(STUDENT_NAME) "������ ��"
FROM TB_STUDENT
GROUP BY STUDENT_NAME
HAVING COUNT(STUDENT_NAME) >= 2
ORDER BY "�����̸�";

-- 15. �й��� A112113�� ���� �л��� �⵵, �б� �� ������ �⵵�� ���� ����, �� ���� ���ϱ�
SELECT SUBSTR(TERM_NO, 1, 4) �⵵, SUBSTR(TERM_NO, 5, 2) �б�, 
        ROUND(AVG(POINT), 1) ����
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY ROLLUP(SUBSTR(TERM_NO, 1, 4), SUBSTR(TERM_NO, 5, 2))
ORDER BY "�⵵", "�б�";




