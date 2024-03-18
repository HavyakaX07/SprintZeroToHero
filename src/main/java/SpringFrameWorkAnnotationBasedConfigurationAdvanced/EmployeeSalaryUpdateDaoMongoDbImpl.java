package SpringFrameWorkAnnotationBasedConfigurationAdvanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mongoDb")
public class EmployeeSalaryUpdateDaoMongoDbImpl implements EmployeeSalaryUpdateDao {

	private JdbcTemplate jdbcTemplate;

	// This is called Setter injection.
	//This template might be different for MongoDb connection. This is only for example.
	@Autowired
	public void setJdbcTemplate(JdbcConnection jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate.getJdbcTemplate();
	}

	@Override
	public void updateSalary(long salary, long empId) {
		System.out.println("Updating salary via Mongo-DB execution");

	}

}
