package SpringFrameworkAnnotationBasedConfiguration;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;

/*
 * Lets assume this class implements update dao and this will update the salary in PostGresSql way.
 */

public class EmployeeSalaryUpdateDaoPostGresImpl implements EmployeeSalaryUpdateDao {

	private JdbcTemplate jdbcTemplate;

	public EmployeeSalaryUpdateDaoPostGresImpl(JdbcTemplate jdbcTemplate2) {
		this.jdbcTemplate = jdbcTemplate2;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void updateSalary(long salary, long empId) {
		String sqlQuery = "UPDATE public.\"emplyoeeSalary\" SET \"empSalary\"=? WHERE \"empId\"=?;";
		Object[] params = {salary,empId};
		int[] types = {Types.BIGINT,Types.BIGINT};
		int affectedRows = jdbcTemplate.update(sqlQuery, params, types);
		System.out.println("Affected Rows after update "+affectedRows);
		System.out.println("Postgres way of updating salary info");
		
	}

}
