package com.aamir.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aamir.model.Employee;
import com.aamir.repository.EmployeeRepository;
import com.aamir.util.EMConstant;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		Double pfAmount = employee.getSalary() * 0.08;
		employee.setPfAmount(pfAmount);
		employee.setTaxAmount(calculateIncomeTax(employee.getSalary()));
		employee.setCreatedOn(Timestamp.valueOf(LocalDateTime.now(ZoneId.of(EMConstant.INDIA_TIMEZOME))));
		employee.setUpdatedOn(Timestamp.valueOf(LocalDateTime.now(ZoneId.of(EMConstant.INDIA_TIMEZOME))));
		this.employeeRepository.save(employee);
	}

	private Double calculateIncomeTax(Double salary) {
		double tax;
		if (salary <= 200000)
			tax = 0;
		else if (salary <= 300000)
			tax = 0.1 * (salary - 200000);
		else if (salary <= 500000)
			tax = (0.2 * (salary - 300000)) + 10000;
		else if (salary <= 1000000)
			tax = (0.3 * (salary - 500000)) + 50000;
		else
			tax = (0.4 * (salary - 1000000)) + 200000;
		return tax;
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.employeeRepository.findAll(pageable);
	}
}
