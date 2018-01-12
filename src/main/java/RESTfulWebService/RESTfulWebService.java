package RESTfulWebService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RESTfulWebService {

	public static void main(String[] args) {
		SpringApplication.run(RESTfulWebService.class, args);
	}
	
	/* @Bean - indicates that a method produces a bean to be 
	 * 		     managed by the Spring container. */
	
	@Bean
	CommandLineRunner initData(EmployeeRepository employeeRepository, ManagerRepository managerRepository) {
		return args -> {
			// Manager object creating
			Manager m = managerRepository.save(new Manager("Steve"));
			Manager m2 = managerRepository.save(new Manager("Bill"));
			
			// Employee object creating
			employeeRepository.save(new Employee("John", "Jackson", "Software Tester", m));
			employeeRepository.save(new Employee("Alex", "Fury", "Web Developer", m));
			employeeRepository.save(new Employee("Lee", "Ronald", "Software Engineer", m));
			employeeRepository.save(new Employee("Harry", "Luis", "Business Analyst", m2));
			employeeRepository.save(new Employee("Justin", "Terry", "Technical Support", m2));
			employeeRepository.save(new Employee("Ron", "Little", "Technical Sales", m2));

		};
	
	}
	
}
