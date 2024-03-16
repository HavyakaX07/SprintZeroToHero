package SpringFrameworkAnnotationBasedConfiguration;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ApplicationConfigFile {

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/test");
		dataSource.setUsername("postgres");
		dataSource.setPassword("Hegde");
		// Configure other properties like maxTotal, maxIdle, etc.
		return dataSource;
	}

	@Bean(name = "jdbcTemplate")
	// If you pass parameter to the the method then parameter name and bean name
	// should be the same. Here you can see method name is different and bean name is different.
	// In the below method I have used method param as "jdbcTemplate" and bean name is also same.
	public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	@Primary
	public EmployeeSalaryUpdateDao getPostgressDaoBean(JdbcTemplate jdbcTemplate) {
		EmployeeSalaryUpdateDao postGresBean = new EmployeeSalaryUpdateDaoPostGresImpl(jdbcTemplate);
		return postGresBean;
	}
	
	@Bean
	//Filter criteria for this bean in order to avoid confusion.
	@Qualifier("MongoDB")
	public EmployeeSalaryUpdateDao geMongoDaoBean(JdbcTemplate jdbcTemplate) {
		EmployeeSalaryUpdateDao mongoDbBean = new EmployeeSalaryUpdateDaoMongoDBImpl(jdbcTemplate);
		return mongoDbBean;
	}
	
	@Bean(name = "salaryService")
	//Now with this approach there is will be some confusions. 
	//Service layer needs one Dao implemented class but there is 2 then which one to pick. 
	//So if @Primary annotation is not there then spring will be in confusion to what to inject.
	//As there is @Primary annotation then it will take PostGress Bean. 
	public EmployeeSalaryUpdateService getSalaryService(EmployeeSalaryUpdateDao employeeSalaryUpdateDao) {
		EmployeeSalaryUpdateService empSalaryUpdateService = new EmployeeSalaryUpdateServiceImpl(employeeSalaryUpdateDao);
		return empSalaryUpdateService;
	}
	
	//Lets suppose there is requirement like application need to use Mongo-Implementation instead of Postgress
	@Bean(name = "salaryServiceMongo")
	public EmployeeSalaryUpdateService getSalaryServiceMongo(@Qualifier("MongoDB") EmployeeSalaryUpdateDao employeeSalaryUpdateDao) {
		EmployeeSalaryUpdateService empSalaryUpdateService = new EmployeeSalaryUpdateServiceImpl(employeeSalaryUpdateDao);
		return empSalaryUpdateService;
	}
	
	
}
