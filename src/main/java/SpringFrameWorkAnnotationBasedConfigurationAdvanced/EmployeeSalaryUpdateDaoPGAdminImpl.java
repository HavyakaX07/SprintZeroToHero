package SpringFrameWorkAnnotationBasedConfigurationAdvanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
//This is to indicate spring that if you find ambiguity then give preference to this bean and inject this bean.
@Primary
public class EmployeeSalaryUpdateDaoPGAdminImpl implements EmployeeSalaryUpdateDao {

	private JdbcTemplate jdbcTemplate;

	// This is called Setter injection.
	@Autowired
	public void setJdbcTemplate(JdbcConnection jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate.getJdbcTemplate();
	}

	@Override
	public void updateSalary(long salary, long empId) {
		System.out.println("update salry via pgadmin implementation");

	}

}
