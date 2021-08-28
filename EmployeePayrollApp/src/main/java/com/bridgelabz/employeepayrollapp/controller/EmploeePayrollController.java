package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.DTO.EmployeePayrollDTO;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmploeePayrollController 
{
	@RequestMapping(value = {"","/","/get"})
	public ResponseEntity<String> getEmployeePayrollData()
	{
		return new ResponseEntity<String> ("Get Call Success", HttpStatus.OK);
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId)
	{
		return new ResponseEntity<String> ("Get Call Success for id: "+empId, HttpStatus.OK);
	}
	
	@GetMapping("/create")
	public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO)
	{
		return new ResponseEntity<String> ("Created Employee payroll Data for: "+empPayrollDTO, HttpStatus.OK);
	}
	
	@GetMapping("/update")
	public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO)
	{
		return new ResponseEntity<String> ("Updated Employee payroll Data for: "+empPayrollDTO, HttpStatus.OK);
	}
	
	@GetMapping("/delette")
	public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId)
	{
		return new ResponseEntity<String> ("Delete Call Success for Id for: "+empId, HttpStatus.OK);
	}
}
