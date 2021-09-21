package br.com.ticket.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ticket.model.Employee;

public interface TicketRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByName(String employeeName);
	List<Employee> findByNameContains (String name);
	Optional<Employee> findById (String id);
	List<Employee> findAll();
	void deleteById(String id);
	Optional<Employee> save(Optional<Employee> emp);

}
