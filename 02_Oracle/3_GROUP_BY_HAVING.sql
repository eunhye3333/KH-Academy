/* 
5 : SELECT �÷��� AS ��Ī, ����, �Լ���
1 : FROM ������ ���̺� ��
2 : WHERE �÷���|�Լ��� �񱳿����� �񱳰�
3 : GROUP BY �׷����� ���� �÷���
4 : HAVING �׷��Լ��� �񱳿����� �񱳰�
6 : ORDER BY �÷Ÿ�|��Ī|�÷����� ���Ĺ�� (NULLS FIRST|LAST)
���������� ���������� ����Ǵ� ���� �ƴ�
*/

-- GROUP BY
SELECT DEPT_CODE, SUM(SALARY) -- ���� �׷��� �׷� �Լ��� �ƴմϴ� -> ���� ������ �ٸ� (GROUP BY ���� ���)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;
-- ���� ���� �׳� DEPT_CODE�� ���� �� ���� �ִ� ��

-- EMPLOYEE ���̺��� �μ� �ڵ庰 �׷��� �����Ͽ� �μ� �ڵ�, �׷캰 �޿� �հ�, �׷캰 �޿� ���(����ó��), �ο� �� ��ȸ
-- �μ��ڵ� ������ ����
SELECT NVL(DEPT_CODE,'�μ�����') �μ�, SUM(SALARY) "�޿� �հ�", FLOOR(AVG(SALARY)) "�޿� ���", COUNT(*) "�ο� ��"
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- EMPLOYEE ���̺��� �μ� �ڵ�� ���ʽ� �޴� ��� �� ��ȸ�ϰ� �μ� �ڵ� ������ ����
SELECT DEPT_CODE, COUNT(BONUS)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- EMPLOYEE ���̺��� ���� �ڵ�, ���ʽ��� �޴� ����� ���� ��ȸ�Ͽ� �����ڵ� ������ �������� ����
SELECT JOB_CODE, COUNT(BONUS)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE ASC;

SELECT JOB_CODE, COUNT(BONUS)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL -- 0�� ��츦 �����ϰ� ���� �ʹٸ� �߰����ָ� ��
GROUP BY JOB_CODE
ORDER BY JOB_CODE ASC;

-- EMPLOYEE ���̺��� ������ ���� �� �޿� ���(���� ó��), �޿� �հ�, �ο� ���� ��ȸ�ϰ� �ο� ���� �������� ����
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), 1, '��', '��') ����, 
        FLOOR(AVG(SALARY)) "�޿� ���", 
        SUM(SALARY) "�޿� �հ�", 
        COUNT(*) "�ο� ��"
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8, 1) -- �����̶�� �ϴ� ��Ī�� ����ϸ� ���� �� ��
-- DECODE ��ü�� �־ �� DECODE(SUBSTR(EMP_NO, 8, 1), 1, '��', '��') 
ORDER BY "�ο� ��" DESC;

-- EMPLOYEE ���̺��� �μ� �ڵ庰�� ���� ������ ����� �޿� �հ� ��ȸ
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE; -- ���� �μ�, ���� ������ ����鳢�� ����
-- ���� ���� �÷��� �ϳ��� ���� �� ����

-- HAVING 
-- �μ� �ڵ�� �޿� 300�� �̻��� ������ �׷캰 ��� �޿� ��ȸ
-- WHERE �ʿ�
SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
WHERE SALARY >= 3000000
GROUP BY DEPT_CODE;

-- �μ� �ڵ�� �޿� ��� 300�� �̻��� �׷� ��ȸ
-- HAVING �ʿ�
SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000;

-- �μ� �� �׷��� �޿� �հ� �� 900���� �ʰ��ϴ� �μ� �ڵ�� �޿� �հ�
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) > 9000000;

-- �����Լ� ROLLUP�� CUBE
-- �׷� �� ������ ��� ���� �����ϴ� �Լ�
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(JOB_CODE) -- ���� �ϳ��� �߰���
ORDER BY JOB_CODE;

SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(JOB_CODE) 
ORDER BY JOB_CODE;
-- ����� ���� ����

-- ROLLUP : �׷� ���� �߰� ����ó���� �ϴ� �Լ�
-- ���ڷ� ���޹��� �׷� �߿��� ���� ���� ������ �׷����� ���� ����
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE;

-- CUBE : �׷� ���� �߰� ����ó���� �ϴ� �Լ�
-- ���ڷ� ���޹��� ��� �׷쿡 ���� ���� ����
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE;

-- ���տ�����
-- UNION : ������ (=OR)
-- INTERSECT : ������ (=AND)
-- UNION ALL : ������ + ������ (OR + AND)
-- MINUS : ������

-- UNION
-- ����� 200���� ����� 201���� ��� ��ȸ
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_ID = 200;
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_ID = 201;

SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_ID = 200 OR EMP_ID = 201;

SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_ID = 200
UNION -- ��� ����
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_ID = 201;

-- DEPT_CODE�� D5�̰ų� �޿��� 300������ �ʰ��ϴ� ������ ���, �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR SALARY > 3000000;

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY > 3000000;

-- UNION ALL
-- �ߺ��� ����� ���� (INTERSECT + UNION)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;
-- D5�̸鼭(�� ��� �߿�) 300���� ���Ϸ� ���� ���
-- �Ʒ� �κ��� NOT�� �Ǳ� ����

-- �÷��� ������ �޶� ��� �� ����
--SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY, EMP_NO
--FROM EMPLOYEE
--WHERE DEPT_CODE = 'D5'
--UNION
--SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
--FROM EMPLOYEE
--WHERE SALARY > 3000000;

-- GROUPING SETS
-- �ߺ��� �͵鵵 ���� ���� UNION ALLó��
SELECT DEPT_CODE, JOB_CODE, MANAGER_ID, FLOOR(AVG(SALARY))
FROM EMPLOYEE
GROUP BY GROUPING SETS ((DEPT_CODE, JOB_CODE, MANAGER_ID),
                          (DEPT_CODE, MANAGER_ID),
                          (JOB_CODE, MANAGER_ID)); -- 53

-- �̰��� �� ��ģ ���� ���� �ڵ�
SELECT DEPT_CODE, JOB_CODE, MANAGER_ID, FLOOR(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE, MANAGER_ID; -- 19

SELECT DEPT_CODE, MANAGER_ID, FLOOR(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE, MANAGER_ID; -- 15

SELECT JOB_CODE, MANAGER_ID, FLOOR(AVG(SALARY))
FROM EMPLOYEE
GROUP BY JOB_CODE, MANAGER_ID; -- 19

