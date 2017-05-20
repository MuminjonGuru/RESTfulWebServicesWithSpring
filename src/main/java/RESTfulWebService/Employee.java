package RESTfulWebService;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import lombok.Data;

@Data
@Entity
class Employee {

	@Id
	@GeneratedValue
	Long id;
	String firstName;
	String lastName;
	String role;

	/*The ManyToOne annotation may be used within an embeddable class
	 *  to specify a relationship from the embeddable class to an entity class.
	 */
	
	@ManyToOne
	Manager manager;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String role, Manager manager) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.manager = manager;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

/*
 *  RepositoryRestResource to also be able to customize the relation 
 *  type and description for the item resources exposed by the repository.
 */

@RepositoryRestResource	
interface EmployeeRepository extends CrudRepository<Employee, Long> {

	List<Employee> findByLastName(@Param("q") String lastName);
	List<Employee> findByRole(@Param("q") String role);
}
