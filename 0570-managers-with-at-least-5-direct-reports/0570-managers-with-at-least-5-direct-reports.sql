# Write your MySQL query statement below
select
    manager.name
from
    employee as employee
join
    employee as manager on employee.managerid = manager.id
group by
    manager.id, manager.name
having
    count(employee.id) >= 5;
