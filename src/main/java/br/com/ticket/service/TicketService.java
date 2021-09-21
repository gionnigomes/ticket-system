package br.com.ticket.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ticket.model.DateManager;
import br.com.ticket.model.Employee;
import br.com.ticket.repository.TicketRepository;
import br.com.ticket.service.exception.FieldValidatorException;
import br.com.ticket.util.Util;
import br.com.ticket.service.exception.EmployeeNotFoundException;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	//TODO: atribuir nomes a uma data de dia de semana
	
	public ArrayList<String> findEmployeeAll() {
		Util util = new Util();
		DateManager date = new DateManager();
		ArrayList<String> dates = new ArrayList<String>();
		for(int i=0; i < date.getDates().size(); i++) {
			LocalDate dateTemp = date.convertToLocalDate(date.getDates().get(i));
			if(!util.checkWeekend(dateTemp)) {
				dates.add(date.getDates().get(i));
				
			} else {
				System.out.println("Weekend.");
			}
		}
		System.out.println("Service dates: " + dates);
		
		return dates;
		//return ticketRepository.findAll();
	}

	public Optional<Employee> findById(String id) {
		Optional<Employee> employees = ticketRepository.findById(id);
		return Optional
				.of(employees.orElseThrow(() -> new EmployeeNotFoundException("Employee id " + id + " not found.")));
	}
	
	@Transactional
	public Optional<Employee> saveEmployee(Employee employees) {
		Employee emp = ticketRepository.save(employees);
		Optional<Employee> empAux = Optional.ofNullable(emp);
		empAux.orElseThrow(() -> new FieldValidatorException("Employee not save. Verify Fields."));
		return empAux;
	}

	public List<Employee> findEmployeeByName(String name) {
		if (name == null) {
			return ticketRepository.findAll();
		} else {
			List<Employee> employees = ticketRepository.findByName(name);
			return employees;
		}
	}

	@Transactional
	public Employee updateEmployee(String id, Employee newEmployee) {
		Optional<Employee> oldEmp = findById(id);
		Employee employee = null;
		if (oldEmp.isPresent()) {
			employee = oldEmp.get();
			employee.setName(newEmployee.getName());
			this.ticketRepository.save(employee);
			return employee;
		}
		return employee;
	}

	@Transactional
	public Optional<Employee> deleteEmployee(String id) {
		Optional<Employee> employee = ticketRepository.findById(id);
		if (employee.isPresent()) {
			ticketRepository.deleteById(id);
		}
		return employee;
	}

}
