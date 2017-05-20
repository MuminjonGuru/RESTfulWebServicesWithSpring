package RESTfulWebService;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import lombok.Data;

@Data
@Entity
class Manager {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	/*If the relationship is bidirectional, the non-owning OneToMany entity side 
	 * must use the mappedBy element of the OneToMany annotation to specify the relationship field or property of the embeddable field or property on the owning side of the relationship. 
	 */
	
	@OneToMany(mappedBy = "manager")
	List<Employee> employees;

	public Manager() {
	}
	
	public Manager(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Long getId() {
		return id;
	}

	void setId(Long id) {
		this.id = id;
	}

}

/*
 *  RepositoryRestResource to also be able to customize the relation 
 *  type and description for the item resources exposed by the repository.
 */

@RepositoryRestResource
interface ManagerRepository extends CrudRepository<Manager, Long> {

	List<Manager> findByEmployeesRoleContains(@Param("q") String role);
	List<Manager> findByEmployeesLastName(@Param("q") String lastName);
	List<Manager> findDistinctByEmployeesLastName(@Param("q") String lastName);

}

