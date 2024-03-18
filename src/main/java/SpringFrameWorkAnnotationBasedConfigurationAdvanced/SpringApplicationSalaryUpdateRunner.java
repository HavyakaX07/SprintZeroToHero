package SpringFrameWorkAnnotationBasedConfigurationAdvanced;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Previously we only creating the bean inside method and we are giving that to spring framework to manage it.
 * So, It was still programmers responsibility to create the bean.
 * 
 * Now in this example set we will go for more advanced things so that we dont need to create the beans.
 * 
 * 1. Create class which is responsible for Data base connection management.
 * 2. Create JdbcTemplate and auto-wire the connection Object.
 * 3. Create Dao Object and Inject Jdbc-Template into it.
 * 4. Create Service and calculate salary and update the salary into Db.
 */
public class SpringApplicationSalaryUpdateRunner {

	public static void main(String[] args) {
		// 5. Create the Context
		try (var context = new AnnotationConfigApplicationContext(ApplicationConfigFile.class);) {
			//6. Get the bean.
			//If bean does not have the name then camel case of class can be used.
			EmployeeSalaryUpdateService service = (EmployeeSalaryUpdateService) context
					.getBean("employeeSalaryUpdateServiceImpl");
			
			//7. Arrange the data.
			long empId = 1L;
			long empSalary = 10000L;
			
			service.computeSalary(empSalary, empId);
		}
	}

}
