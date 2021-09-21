package br.com.ticket.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ticket.model.Employee;
import br.com.ticket.repository.TicketRepository;
import br.com.ticket.service.TicketService;
import br.com.ticket.service.exception.FieldValidatorException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/analysts")
@Api(value = "Ticket System API")
@CrossOrigin(origins = "*")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@SuppressWarnings("unused")
	@Autowired
	private TicketRepository ticketRepository;

	public TicketController() {

	}

	@GetMapping
	@ApiOperation(value = "Returns full list of analysts")
	public ResponseEntity<ArrayList<String>> findByAll() {
		return ResponseEntity.ok(ticketService.findEmployeeAll());
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Returns list of analyst by id")
	public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable String id) {
		return ResponseEntity.ok(ticketService.findById(id));
	}

	
	@PostMapping
	@ApiOperation(value = "Register employee")
	public ResponseEntity<Optional<Employee>> saveEmployee(@RequestBody @Valid Employee employees) {
		Optional<Employee> employee = ticketService.saveEmployee(employees);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update employee")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") String id,
			@Valid @RequestBody Employee newEmployee) {
		Employee employee = ticketService.updateEmployee(id, newEmployee);
		return ResponseEntity.ok().body(employee);
	}

	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete employee by id")
	public void deleteEmployee(@PathVariable(value = "id") String id) {
		Optional<Employee> delete = ticketService.deleteEmployee(id);
		delete.orElseThrow(() -> new FieldValidatorException("Unable to delete. Employee id not found."));
	}


}
