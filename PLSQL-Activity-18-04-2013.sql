
1. To write a  Cursor to display the list of employees who are Working as a Managers or Analyst.

declare
    emprec emp%rowtype;
    cursor mycur is select * from emp where job ='MANAGER' or job='ANALYST';
begin
    open mycur;
    loop
    fetch mycur into emprec;
    exit when mycur%NOTFOUND;    
    dbms_output.put_line(emprec.empno || '     ' || emprec.ename || '    ' || emprec.deptno || '  ' || emprec.job); 
    end loop;
    close mycur;
end;
/

2. Write PL/SQL code in Cursor to display employee names and salary:

set serveroutput on;
declare
    enam emp.ename%type;
    salry emp.sal%type;   
    cursor mycur is select ename,sal from emp;
begin    
    open mycur;
    loop
    fetch mycur into enam,salry;
    exit when mycur%NOTFOUND;    
    dbms_output.put_line(enam || '    ' ||salry); 
    end loop;
    close mycur;
end;
/

3.Write PL/SQL code to find the Reverse of the  number

DECLARE
num Number;
revnum number;
Begin
num:=&g;
revnum:= 0;
WHILE num>0 LOOP
revnum:=(revnum*10) + mod(num,10);
num:=floor(num/10);
END LOOP;
DBMS_OUTPUT.PUT_LINE('Reverse of the number is: ' || revnum);
END;
/