package com.harera.leetcode.leetcode185


/**
 * SELECT d.name as "Department", e.name as "Employee", e.salary as "Salary"
 * FROM Employee e
 *          join Department D on D.id = e.departmentId
 *     AND e.salary IN (SELECT em.salary
 *                      FROM Employee em
 *                      WHERE em.departmentId = d.id
 *                      GROUP BY em.salary
 *                      ORDER BY em.salary DESC
 *                      LIMIT 3);
 */
