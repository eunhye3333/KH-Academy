-- SELECT : ������ ��ȸ(�˻�)
-- SELECT�� ���� �����͸� ��ȸ�ϸ� ������� Result Set ��ȯ

-- EMPLOYEE ���̺��� ���, �̸�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE; -- �����ݷ� ������ ���� ��. KH �������� �����Ͽ��� ��

-- EMPLOYEE ���̺��� ��� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SAL_LEVEL, SALARY, BONUS, MANAGER_ID,
           HIRE_DATE, ENT_DATE, ENT_YN
FROM EMPLOYEE;

SELECT * FROM EMPLOYEE; -- * : �ƽ�Ʈ��

-- JOB ���̺��� ��� ���� ��ȸ
SELECT * FROM JOB;
SELECT JOB_CODE, JOB_NAME FROM JOB;

-- JOB ���̺��� ���� �̸� ��ȸ
SELECT JOB_NAME FROM JOB;

-- DEPARTMENT ���̺��� ��� ���� ��ȸ
SELECT * FROM DEPARTMENT;
SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID FROM DEPARTMENT;
        

-- EMPLOYEE ���̺��� ���� ��, �̸���, ��ȭ��ȣ, ����� ��ȸ
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� �����, ��� �̸�, ���� ��ȸ
SELECT HIRE_DATE, EMP_NAME, SALARY
FROM EMPLOYEE;

-- �÷� �� �ȿ��� ���� ����
-- EMPLOYEE ���̺��� ������, ����(����*12) ��ȸ
SELECT EMP_NAME, SALARY*12 -- �÷����� SALARY*12�� ����(Result Set�� ���� �÷���)
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ���� ��, ����, ���ʽ��� �߰��� ���� ��ȸ
SELECT EMP_NAME, SALARY*12, (SALARY*(1+BONUS))*12
FROM EMPLOYEE;
SELECT EMP_NAME, SALARY*12, (SALARY+(SALARY*BONUS))*12
FROM EMPLOYEE;
-- ���ʽ����� NULL�� �κ��� ��갪�� NULL�̶�� ��

-- EMPLOYEE ���̺��� �̸�, ����, �Ѽ��ɾ�(���ʽ� ����), �Ǽ��ɾ�(�Ѽ��ɾ� - ����*����3%)) ��ȸ
SELECT EMP_NAME, SALARY*12, (SALARY*(1+BONUS))*12, ((SALARY*(1+BONUS))*12)*0.97
FROM EMPLOYEE;
SELECT EMP_NAME, SALARY*12, 
        (SALARY + (SALARY * BONUS))*12, 
        (SALARY + (SALARY * BONUS))*12 - (SALARY*12*0.03)
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� �̸�, �����, �ٹ� �ϼ�(���� ��¥(SYSDATE) - �����) ��ȸ
SELECT EMP_NAME, HIRE_DATE, SYSDATE-HIRE_DATE -- SYSDATE�� �ð����� �� �־ �Ҽ����� ����
FROM EMPLOYEE;

-- �÷��� ��Ī�� ���� �� ���� (�� ������ � ���������� �����ϱ� ����)
-- �÷��� AS ��Ī        �÷��� "��Ī"        �÷��� AS "��Ī"        �÷��� ��Ī
-- ��Ī�� "" ��� �ϴ� ��� : ��Ī�� Ư������(���� ����)�� �� ��� (�� "" ��� ��)
SELECT EMP_NAME AS �����, SALARY*12 ����, (SALARY*(1+BONUS))*12 AS "���ʽ� ���� ����"
FROM EMPLOYEE;

SELECT EMP_NAME "��� ��", SALARY*12 ����, 
        (SALARY + (SALARY * BONUS))*12 AS "�Ѽ��ɾ�(���ʽ� ����)", 
        (SALARY + (SALARY * BONUS))*12 - (SALARY*12*0.03) AS �Ǽ��ɾ�
FROM EMPLOYEE;

-- ���ͷ� : ���� �״���� ������
-- EMPLOYEE ���̺��� ���� ��ȣ, ��� ��, �޿�, ����(��) ��ȸ
-- ����(��)�� ���̺� ���� -> ���ͷ��� ����ϸ� ���̺��� ������ ��ó�� ������ �� ����
SELECT EMP_ID, EMP_NAME, SALARY, '��' ����
FROM EMPLOYEE;
-- Oracle������ ""�� ��Ī, ''�� ����(���ڿ�)

-- DISTINCT : �ߺ��� ������. �÷��� ���Ե� �ߺ� ���� �� ������ ǥ���ϰ��� �� ��
-- ������ ���Ƿ� ����
-- EMPLOYEE ���̺��� ������ ���� �ڵ� ��ȸ
SELECT JOB_CODE FROM EMPLOYEE;
SELECT DISTINCT JOB_CODE FROM EMPLOYEE;

-- EMPLOYEE ���̺��� �μ� �ڵ�� ���� �ڵ� ��ȸ
SELECT DEPT_CODE, JOB_CODE
FROM EMPLOYEE;
--SELECT DISTINCT DEPT_CODE, DISTINCT JOB_CODE
--FROM EMPLOYEE;
-- DISTINCT�� SELECT���� �� �� ���� �� �� ����
SELECT DISTINCT DEPT_CODE, JOB_CODE -- ���� �տ� ���� ������ ��� �ߺ� ���Ű� ��
FROM EMPLOYEE;

--SELECT EMP_NAME, DISTINCT DEPT_CODE, JOB_CODE -- ���� ���� �÷��� �ҷ��� �� �ϳ��� �÷������� �ߺ� ���� �Ұ���
--FROM EMPLOYEE;

-- WHERE�� : ��ȸ�� ������ ����ϴ� �κ�
-- ���ǿ��� �� ������ ���
-- = ����, > ũ��, < �۳�, >= ũ�ų� ����, <= �۰ų� ����
-- !=, ^=, <> ���� �ʳ�

-- EMPLOYEE ���̺��� �μ� �ڵ尡 D9�� ������ �̸�, �μ��ڵ� ��ȸ
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- EMPLOYEE ���̺��� �޿��� 4000000 �̻��� ������ �̸�, �޿� ��ȸ
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;

-- EMPLOYEE ���̺��� �μ��ڵ尡 D9�� �ƴ� ����� ���, �̸�, �μ��ڵ� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
--WHERE DEPT_CODE != 'D9';
--WHERE DEPT_CODE ^= 'D9';
WHERE DEPT_CODE <> 'D9';

-- EMPLOYEE ���̺��� ��� ���ΰ� N�� ������ ��ȸȭ�� �ٹ� ���θ� ���� ������ ǥ���Ͽ�
-- ���, �̸�, �����, �ٹ� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE, '���� ��' "�ٹ� ����"
FROM EMPLOYEE
WHERE ENT_YN = 'N';

-- EMPLOYEE ���̺��� ������ 3000000 �̻��� ����� �̸�, ����, ����� ��ȸ
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- EMPLOYEE ���̺��� SAL_LEVEL�� S1�� ����� �̸�, ����, �����, ����ó ��ȸ
SELECT EMP_NAME, SALARY, HIRE_DATE, PHONE
FROM EMPLOYEE
WHERE SAL_LEVEL = 'S1';

-- EMPLOYEE ���̺��� �Ǽ��ɾ�(�Ѽ��ɾ�-(����*����3%))�� 5õ���� �̻��� ����� �̸�, ����, �Ǽ��ɾ�, ����� ��ȸ
SELECT EMP_NAME, SALARY, 
        (SALARY + (SALARY * BONUS))*12 - (SALARY*12*0.03) AS �Ǽ��ɾ�,HIRE_DATE
FROM EMPLOYEE
WHERE (SALARY + (SALARY * BONUS))*12 - (SALARY*12*0.03) >= 50000000;

-- �� ������ : AND / OR
-- AND : ~��, ���ÿ� (&&)
-- OR : �Ǵ�, �̰ų� (||)
-- EMPLOYEE ���̺��� �μ��ڵ尡 D6�̰� �޿��� 3�鸸���� ���� �޴� ������ �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' AND SALARY > 3000000;

-- EMPLOYEE ���̺��� �μ��ڵ尡 D6�̰ų� �޿��� 3�鸸���� ���� �޴� ������ �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' OR SALARY > 3000000;

-- EMPLOYEE ���̺��� �޿��� 350�� �̻� 600�� ���ϸ� �޴� ������ ���, �̸�, �޿�, �μ� �ڵ�, �����ڵ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE SALARY >= 3500000 AND SALARY <= 6000000;

-- EMPLOYEE ���̺� ������ 4000000�̻��̰� JOB_CODE�� J2�� ����� ��ü ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE SALARY >= 4000000 AND JOB_CODE ='J2';

-- EMPLOYEE ���̺� DEPT_CODE�� D9�̰ų� D5�� ��� �� ������� 02�� 1�� 1�Ϻ��� ���� ����� �̸�, �μ��ڵ�, ����� ��ȸ
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
--WHERE DEPT_CODE = 'D9' OR DEPT_CODE = 'D5' AND HIRE_DATE < '02/01/01';
-- AND�� OR �߿����� AND�� �켱 ������ ���� 
-- ���� ��ó�� �ϸ� DEPT_CODE�� D5�̸鼭 ������� 02�� 1�� 1�Ϻ��� ���� ����̰ų� DEPT_CODE�� D9�� ����� ��
-- �׷��� �Ұ�ȣ�� �� �ٿ� ��� �Ѵ�
WHERE (DEPT_CODE = 'D9' OR DEPT_CODE = 'D5') AND HIRE_DATE < '02/1/1';

-- BETWEEN AND : ���Ѱ� �̻�, ���Ѱ� ���ϸ� BETWEEN AND�� ��� ����
-- �÷��� BETWEEN ���Ѱ� AND ���Ѱ�
-- EMPLOYEE ���̺��� �޿��� 350�� �̻� 600�� ���ϸ� �޴� ������ ���, �̸�, �޿�, �μ� �ڵ�, �����ڵ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE SALARY >= 3500000 AND SALARY <= 6000000;
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

-- 350�� �̸� �Ǵ� 600�� �ʰ��ϴ� ������ ���, �̸�, �޿�, �μ��ڵ�, �����ڵ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE SALARY < 3500000 OR SALARY > 6000000;

SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
--WHERE NOT SALARY BETWEEN 3500000 AND 6000000; -- ����� ������ �� NOT�� �ٿ��� ���
WHERE SALARY NOT BETWEEN 3500000 AND 6000000; -- BETWEEN �տ� NOT�� �ٿ��� ��

-- EMPLOYEE ���̺��� ������� 90/1/1 ~ 01/1/1�� ����� ��ü ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

-- LIKE : Ư�� ������ ������Ű���� ��ȸ
-- % _
-- % : 0���� �̻� 
-- => '����%' : ���ڷ� �����ϴ� �� EX. ����, ���ڹ��� ��..
-- => '%����%' : ���ڰ� ���Ե� �� EX. ����, ���ڹ���, ������ ��..
-- => '%����' : ���ڷ� ������ �� EX. ����, ������ ��..
-- => '��%��' : �۷� �����ؼ� �ڷ� ������ �� EX. ����, ���ǳ��� ��..
-- _ : �� 1����
-- => '_' : �� ����
-- => '__' : �� ����
-- => '___' : �� ����

-- EMPLOYEE ���̺��� ���� ������ ����� ���, �̸�, ����� ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%';
-- '��__'�� �ϸ� �̸��� ������ �� ������ ����� ����

-- EMPLOYEE ���̺��� �̸��� '��'�� ���Ե� ������ �̸�, �ֹι�ȣ, �μ��ڵ� ��ȸ
SELECT EMP_NAME, EMP_NO, DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%';

-- EMPLOYEE ���̺��� ��ȭ��ȣ 4��° �ڸ��� 9�� �����ϴ� ����� ���, �̸�, ��ȭ��ȣ ��ȸ
SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';

-- EMPLOYEE ���̺��� �达 ���� �ƴ� ����� ���, �̸�, ����� ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
--WHERE EMP_NAME NOT LIKE '��%';
WHERE NOT EMP_NAME LIKE '��%'; -- �� �� �������

-- EMPLOYEE ���̺��� �̸��� �� _�� �� ���ڰ� 3�ڸ��� �̸��� �ּҸ� ���� ����� ���, �̸�, �̸��� �ּ� ��ȸ
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '____%'; -- ���ϴ� ����� ��µ��� ����
-- ���ϵ�ī�� ���ڿ� ������ Ư�� ���ڰ� ������ ��� � ���� ���ϵ�ī��� � ���� Ư���������� ������ �� ����
-- Ư�� ���� ��ü�� �����ͷ� ó���ϱ� ���� ������ �� �ִ� ��ġ �ʿ� => ESCAPE OPTION
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___ _%' ESCAPE ' ';

-- EMPLOYEE ���̺��� �̸� ���� '��'���� ������ ��� �̸� ��ȸ
SELECT EMP_NAME
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��';

-- EMPLOYEE ���̺��� ��ȭ��ȣ ó�� 3�ڸ��� 010�� �ƴ� ����� �̸�, ��ȭ��ȣ ��ȸ
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';

-- EMPLOYEE ���̺��� ���� �ּ� _���� 4�����̸鼭 DEPT_CODE�� D9 �Ǵ� D6�̰�, 
--    ������� 90/01/01~00/12/01�̰�, �޿��� 270�� �̻��� ��� ��ü ��ȸ
SELECT *
FROM EMPLOYEE
WHERE EMAIL LIKE '____!_%' ESCAPE '!'
       AND (DEPT_CODE = 'D9' OR DEPT_CODE = 'D6') 
       AND HIRE_DATE BETWEEN '90/01/01' AND '00/12/01'
       AND SALARY >= 2700000;

-- IS NULL/IS NOT NULL : �÷����� NULL ���� �� �ִ��� �ƴ��� �Ǻ�����
-- EMPLOYEE ���̺��� ���ʽ��� ���� �ʴ� ����� ���, �̸�, �޿�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NULL;


-- EMPLOYEE ���̺��� ���ʽ��� �޴� ����� ���, �̸�, �޿�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
--WHERE BONUS IS NOT NULL;
WHERE NOT BONUS IS NULL; -- �� �� ����

-- EMPLOYEE ���̺��� �����ڵ� ���� �μ� ��ġ�� ���� ���� ������ �̸�, ������, �μ� �ڵ� ��ȸ
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

-- EMPLOYEE ���̺��� �μ� ��ġ�� ���� �ʾ����� ���ʽ��� ���� �޴� ������ �̸�, ���ʽ�, �μ��ڵ� ��ȸ
SELECT EMP_NAME, BONUS, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL AND BONUS IS NOT NULL;

-- IN : ��Ͽ� ��ġ�ϴ� ���� ������ TRUE ��ȯ
-- D6 �μ��� D9 �μ������� �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
--WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D9';
WHERE DEPT_CODE IN ('D6', 'D9');

-- �����ڵ尡 J1, J2, J3, J4�� ������� �̸�, �����ڵ�, �޿� ��ȸ
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
--WHERE JOB_CODE = 'J1' OR JOB_CODE = 'J2' OR JOB_CODE = 'J3' OR JOB_CODE = 'J4';
WHERE JOB_CODE IN ('J1', 'J2', 'J3', 'J4'); -- OR �� ����Ǵ� ���� �ִٸ� IN���� ���� �� ����

-- ���� ������ ||
-- EMPLOYEE ���̺��� ���, �̸�, �޿��� �����Ͽ� ��ȸ
SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, SALARY || '��' "�޿�" -- ���ͷ����� ���� ����
FROM EMPLOYEE;

-- ORDER BY : ������ �� �ۼ��ϴ� ����
-- SELECT�� ���� �������� �ۼ�, ���� ������ ���� �������� �����
-- �÷���/��Ī/�÷����� ���� ��� NULLS FIRST/NULLS LAST
-- �������� : ASC(���� ����) / �������� : DESC(������ ���) -> ���������� �⺻
SELECT EMP_ID ���, EMP_NAME �̸�, SALARY �޿�, BONUS ���ʽ�
FROM EMPLOYEE
--ORDER BY EMP_ID; -- ��������
--ORDER BY EMP_ID DESC; -- ��������
--ORDER BY EMP_ID ASC; -- ��������
--ORDER BY EMP_NAME ASC;
--ORDER BY EMP_NAME;
--ORDER BY EMP_NAME DESC;
--ORDER BY �̸� DESC; -- ���� �������� ����Ǳ� ������ SELECT�� �� ��Ī�� ���� ����
--ORDER BY 3 DESC; -- �������ε� ���� SELECT������ ������ �̾߱���
--ORDER BY BONUS DESC; -- NULL�� ���� ����
ORDER BY BONUS DESC NULLS LAST; -- NULL�� �ڷ� ������ ����






