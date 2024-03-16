package SpringFrameworkAnnotationBasedConfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * In this class we will do annotation based configuration
 * 
 * 1. First we will create Configuration class 
 * 2. Create all necessary beans required for the application.
 * 3. Give it to Spring Framework so that it will maintain the beans
 */
public class BeanConfigurationViaAnnotationBasedConfiguration {

	public static void main(String[] args) {

		// Create application context through config file
		try (var context = new AnnotationConfigApplicationContext(ApplicationConfigFile.class);) {

			// Arrange mock data
			long empId = 1L;
			long salary = 10000L;

			// This is for Mongo service.
			EmployeeSalaryUpdateService service_Mongo = (EmployeeSalaryUpdateService) context
					.getBean("salaryServiceMongo");
			service_Mongo.computeSalary(salary, empId);

			// This is for PostGres Service.
			EmployeeSalaryUpdateService service_PG = (EmployeeSalaryUpdateService) context.getBean("salaryService");
			service_PG.computeSalary(salary, empId);
		}

	}

}
