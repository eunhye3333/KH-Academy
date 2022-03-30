-- 1. 70��� ��(1970~1979) �� �����̸鼭 ������ ����� �̸��� �ֹι�ȣ, �μ� ��, ���� ��ȸ
-- ����Ŭ
SELECT EMP_NAME, EMP_NO, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E, DEPARTMENT, JOB J
WHERE DEPT_CODE = DEPT_ID
      AND E.JOB_CODE = J.JOB_CODE
      AND SUBSTR(EMP_NO, 1, 2) BETWEEN 70 AND 79
      AND EMP_NAME LIKE '��%';

-- ANSI
SELECT EMP_NAME, EMP_NO, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
     JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE)
WHERE SUBSTR(EMP_NO, 1, 2) BETWEEN 70 AND 79
      AND EMP_NAME LIKE '��%';

-- 2. ���� �� ���� ������ ��� �ڵ�, ��� ��, ����, �μ� ��, ���� �� ��ȸ
-- ����Ŭ
SELECT EMP_ID, EMP_NAME, TO_CHAR(SYSDATE, '"1"YY') -  SUBSTR(EMP_NO, 1, 2) ����, 
       DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E, DEPARTMENT, JOB J
WHERE DEPT_CODE = DEPT_ID
      AND E.JOB_CODE = J.JOB_CODE
      AND SUBSTR(EMP_NO, 1, 2) = (SELECT MAX(SUBSTR(EMP_NO, 1, 2)) FROM EMPLOYEE);

-- ANSI
SELECT EMP_ID, EMP_NAME, TO_CHAR(SYSDATE, '"1"YY') -  SUBSTR(EMP_NO, 1, 2) ����, 
       DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
     JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE)
WHERE SUBSTR(EMP_NO, 1, 2) = (SELECT MAX(SUBSTR(EMP_NO, 1, 2)) FROM EMPLOYEE);

-- 3. �̸��� �������� ���� ����� ��� �ڵ�, ��� ��, ���� ��ȸ
-- ����Ŭ
SELECT EMP_ID, EMP_NAME, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J. JOB_CODE
      AND EMP_NAME LIKE '%��%';

-- ANSI
SELECT EMP_ID, EMP_NAME, JOB_NAME
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE EMP_NAME LIKE '%��%';

-- 4. �μ��ڵ尡 D5�̰ų� D6�� ����� ��� ��, ���� ��, �μ� �ڵ�, �μ� �� ��ȸ
-- ����Ŭ
SELECT EMP_NAME, JOB_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE E, JOB J, DEPARTMENT
WHERE E.JOB_CODE = J. JOB_CODE
      AND DEPT_CODE = DEPT_ID
      AND DEPT_CODE IN ('D5', 'D6');

-- ANSI
SELECT EMP_NAME, JOB_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
     JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE)
WHERE DEPT_CODE IN ('D5', 'D6');

-- 5. ���ʽ��� �޴� ����� ��� ��, �μ� ��, ���� �� ��ȸ
-- ����Ŭ
SELECT EMP_NAME, BONUS, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE, DEPARTMENT, LOCATION
WHERE DEPT_CODE = DEPT_ID
      AND LOCATION_ID = LOCAL_CODE
      AND BONUS IS NOT NULL;

-- ANSI
SELECT EMP_NAME, BONUS, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
     JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
     JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
WHERE BONUS IS NOT NULL;

-- 6. ��� ��, ���� ��, �μ� ��, ���� �� ��ȸ
-- ����Ŭ
SELECT EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE E, JOB J, DEPARTMENT, LOCATION
WHERE E.JOB_CODE = J.JOB_CODE
      AND DEPT_CODE = DEPT_ID
      AND LOCATION_ID = LOCAL_CODE;

-- ANSI
SELECT EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
     JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
     JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);

-- 7. �ѱ��̳� �Ϻ����� �ٹ� ���� ����� ��� ��, �μ� ��, ���� ��, ���� �� ��ȸ
-- ����Ŭ
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME,
       CASE WHEN NATIONAL_CODE = 'KO' THEN '�ѱ�'
            ELSE '�Ϻ�' 
       END "���� ��"
FROM EMPLOYEE, DEPARTMENT, LOCATION
WHERE DEPT_CODE = DEPT_ID
      AND LOCATION_ID = LOCAL_CODE
      AND NATIONAL_CODE IN ('KO', 'JP');

-- ANSI
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME,
       CASE WHEN NATIONAL_CODE = 'KO' THEN '�ѱ�'
            ELSE '�Ϻ�' 
       END "���� ��"
FROM EMPLOYEE
     JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
     JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
WHERE NATIONAL_CODE IN ('KO', 'JP');

-- 8. �� ����� ���� �μ����� ���ϴ� ����� �̸� ��ȸ
SELECT E.EMP_NAME, E.DEPT_CODE, EE.EMP_NAME
FROM EMPLOYEE E, EMPLOYEE EE
WHERE E.DEPT_CODE = EE.DEPT_CODE
      AND E.EMP_NAME != EE.EMP_NAME
ORDER BY 1;

-- 9. ���ʽ��� ���� ���� �ڵ尡 J4�̰ų� J7�� ����� �̸�, ���� ��, �޿� ��ȸ(NVL �̿�)
-- ����Ŭ
SELECT EMP_NAME, JOB_NAME, NVL(BONUS, SALARY) �޿�
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE
      AND E.JOB_CODE IN ('J4', 'J7');
      
-- ANSI
SELECT EMP_NAME, JOB_NAME, NVL(BONUS, SALARY) �޿�
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_CODE IN ('J4', 'J7');

-- 10. ���ʽ� ������ ������ ���� 5���� ���, �̸�, �μ� ��, ����, �Ի���, ���� ��ȸ
-- ����Ŭ
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, HIRE_DATE, ROWNUM
FROM (SELECT *
      FROM EMPLOYEE E, JOB J, DEPARTMENT
      WHERE E.JOB_CODE = J.JOB_CODE
            AND DEPT_CODE = DEPT_ID
      ORDER BY SALARY * (1 + NVL2(BONUS, BONUS, 0)) DESC)
WHERE ROWNUM <= 5;

-- ANSI
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, HIRE_DATE, ROWNUM
FROM (SELECT *
      FROM EMPLOYEE
           JOIN JOB USING(JOB_CODE)
           JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
      ORDER BY SALARY * (1 + NVL2(BONUS, BONUS, 0)) DESC)
WHERE ROWNUM <= 5;

-- 11. �μ� �� �޿� �հ谡 ��ü �޿� �� ���� 20%���� ���� �μ��� �μ� ��, �μ� �� �޿� �հ� ��ȸ 
-- 11-1. JOIN�� HAVING ���
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
     JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) > (SELECT SUM(SALARY) * 0.2
                      FROM EMPLOYEE);

-- 11-2. �ζ��� �� ��� 
SELECT DEPT_TITLE, �޿�
FROM (SELECT DEPT_TITLE, SUM(SALARY) �޿�
      FROM EMPLOYEE, DEPARTMENT
      WHERE DEPT_CODE = DEPT_ID
      GROUP BY DEPT_TITLE)
WHERE �޿� > (SELECT SUM(SALARY) * 0.2
              FROM EMPLOYEE);

-- 11-3. WITH ���
WITH TB AS (SELECT DEPT_TITLE, SUM(SALARY) �޿�
              FROM EMPLOYEE, DEPARTMENT
              WHERE DEPT_CODE = DEPT_ID
              GROUP BY DEPT_TITLE)
SELECT DEPT_TITLE, �޿� FROM TB
WHERE �޿� > (SELECT SUM(SALARY) * 0.2
              FROM EMPLOYEE);

-- 12. �μ� ���� �μ� �� �޿� �հ� ��ȸ
-- ����Ŭ
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+)
GROUP BY DEPT_TITLE;

-- ANSI
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE;

-- 13. WITH�� �̿��Ͽ� �޿� �հ� �޿� ��� ��ȸ
-- 1)
WITH SAL AS (SELECT SUM(SALARY)
             FROM EMPLOYEE),
     SAL2 AS (SELECT AVG(SALARY)
              FROM EMPLOYEE)
SELECT *
FROM SAL
UNION 
SELECT *
FROM SAL2;

-- 2)
WITH SAL AS (SELECT SUM(SALARY), AVG(SALARY)
                    FROM EMPLOYEE)
SELECT *
FROM SAL;