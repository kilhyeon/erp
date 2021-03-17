select * from title;
select * from department;
select * from employee;
select * from emp_detail;

-- 해당 직책을 가지고 있는 사원목록을 검색
select empname, empno from employee e join title t on e.title = t.tno where tno = 3;

-- 해당 부서에 소속된 사원목록을 검색
select empname, empno from employee e join department d on e.dept = d.deptno where deptno = 1;

select * from employee where empno = 1003;

-- passwd 길이 확인
-- 단방향 함수(Hash:MD5)
select password('aaa'), length(password('aaaasdfasfasfdsf@@@')) from dual;

select password('1234')


-- emp detail insert
INSERT INTO emp_detail(empno, pic, gender, hiredate, passwd) VALUES(?, ?, ?, ?, ?);


select empno, pic, gender, hiredate, passwd from emp_detail;
select empno, pic, gender, hiredate, passwd from emp_detail where empno = 1003;
select empno, pic, gender, hiredate, passwd from emp_detail where empno = 1365;
select empno, pic, gender, hiredate, passwd from emp_detail where empno = ?;


delete from emp_detail where empno = 1003;