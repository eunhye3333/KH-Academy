/*
여러 줄 주석
*/
-- 한 줄 주석

-- 관리자 계정: 데이터베이스의 생성과 관리를 담당하는 슈퍼 유저 계정
--			   오브젝트 생성, 변경, 삭제 등의 작업 가능.
--			   데이터 베이스에 대한 모든 권한 및 책임을 가짐
-- 사용자 계정: 데이터베이스에 대한 질의(Query), 갱신, 보고서 작성 등의 작업을 수행할 수 있는 계정
--               일반 계정은 보안을 위해 업무에 필요한 최소한의 권한 가지는 것을 원칙으로 함

-- 11g 버전
--CREATE USER KH IDENTIFIED BY KH; -- 계정 생성 쿼리
--생성함   계정      비밀번호를 지정하겠다
--   생성할 계정의 이름       생성할 비밀번호

-- 18c 버전은 위처럼 불가 (12c부터 불가능)
-- 아래처럼 해야 됨
--CREATE USER c##KH IDENTIFIED BY KH; -- 앞에 c## 추가, c는 대소문자 상관없음

-- c##을 붙이는 일이 번거롭기 때문에 이전 버전처럼 안 붙이고도 계정 생성할 수 있는 세션 설정
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE; -- 드래그 후 재생 버튼 누르면 실행 가능
CREATE USER KH IDENTIFIED BY KH; -- 실행시키고 싶은 문장에 커서만 두고 실행해도 실행 가능
-- 실행 단축키 : CTRL + ENTER
GRANT CONNECT, RESOURCE TO KH; -- KH에게 CONNECT와 RESOURCE 권한을 주겠다(권한 부여 쿼리)

--  공용 동의어(DD: Data Dictionary): 데이터 사전, 데이터베이스의 실질적인 데이터를 제외한 DB 전반에 대한 모든 정보를 가지고 있는 것. 제공하는 것
--                                   System(관리자)이 DD에 대한 내용을 변경할 수 있는 권한을 가지고 있고
--								   	사용자 계정은 단순하게 읽어들어 올 수만 있음(단순 조회만 가능, 읽기 전용 형태로 제공됨)
--  탭 부분의 관리자는 해당 sql 파일의 이름임. 

-- 테이블 : 행(row)과 열(column)로 구성되는 가장 기본적인 데이터베이스 객체(여기에서는 사용되는 오브젝트들을 다 객체라고 함)
--         데이터베이스 내에서 모든 데이터는 테이블을 통해 저장
-- 인덱스 : 데이터를 조건에 맞는 데이터만 조회하고 싶을 때 원하는 정보를 빠르게 가져올 수 있도록 하는 객체
--         60만건에서도 인덱스가 있는 것과 없는 것의 유의미한 차이가 없음 프라이머리키 자체가 인덱스를 가지고 있는 키라서 아예 안 다루지는 않음
--         검색 연산을 최적화하기 위해 데이터베이스 상에 행들의 정보를 구성하는 데이터 구조
--         인덱스를 이용하면 전체 데이터를 검색하지 않고 데이터베이스에서 원하는 정보를 빠르게 검색 가능
alter user KH default tablespace system quota unlimited on system;
-- KH에 있는 tablespace의 system에 대한 용량을 제한을 두지 않도록 만들겠다
-- DB에서는 대소문자를 구분하지 않아도 되지만 이름이나 비밀번호, 리터럴 값은 대소문자를 구분해줘야 함(명령어는 대소문자 안 가림)

create user SCOTT identified by SCOTT;
grant resource, connect to SCOTT;
alter user SCOTT default tablespace system quota unlimited on system;