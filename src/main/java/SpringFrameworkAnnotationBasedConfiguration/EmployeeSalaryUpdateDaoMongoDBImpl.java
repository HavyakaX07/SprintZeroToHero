package SpringFrameworkAnnotationBasedConfiguration;

import org.springframework.jdbc.core.JdbcTemplate;


/*
 *  Mongo-DB way of updating salary into db
 */
public class EmployeeSalaryUpdateDaoMongoDBImpl implements EmployeeSalaryUpdateDao {

	private JdbcTemplate jdbcTemplate;

	public EmployeeSalaryUpdateDaoMongoDBImpl(JdbcTemplate jdbcTemplate2) {
		this.jdbcTemplate = jdbcTemplate2;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public void updateSalary(long salary, long empId) {
		//Lets assume this will update the salary in mongo-db way.
		System.out.println("Update done using mongo db approach!");

	}

}
