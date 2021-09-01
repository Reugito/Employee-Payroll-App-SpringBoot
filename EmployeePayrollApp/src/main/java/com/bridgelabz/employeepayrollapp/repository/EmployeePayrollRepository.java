package com.bridgelabz.employeepayrollapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {

	@Query(value = "select * from employee_payroll, employee_department where employee_id and department = :department", nativeQuery = true)
	List<EmployeePayrollData> findEmployeeByDepartment(String department);
}
