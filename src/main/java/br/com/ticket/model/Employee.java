package br.com.ticket.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity(name = "employee")
public class Employee {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@NotBlank(message="The name field cannot be null. Please enter a name.")
	private String name;
	
	private LocalDate date;
	
	public Employee () {
		
	}
	
	public Employee (String name) {
		this.name = name;
	}
	
	public Employee(String id, String name) {
		this.id = id;
		this.name = name;
	}
		
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	
	
}
