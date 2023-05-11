alter session set "_ORACLE_SCRIPT" = true;

create user MEMBER identified by MEMBER;
grant connect, resource to MEMBER;

alter user MEMBER default tablespace system quota unlimited on system;