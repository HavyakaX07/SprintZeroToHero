package com.example.SpringFrameWorkXmlBasedConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;

public class EmployeeSalaryDaoImpl implements EmployeeSalaryDao {

	private JdbcTemplate jdbcTemplate;

    // Setter method for JdbcTemplate dependency
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public void updateSalary(long salary,long empId) {
		// update salary info to DB
		String sqlQuery = "UPDATE public.\"emplyoeeSalary\" SET \"empSalary\"=? WHERE \"empId\"=?;";
		Object[] params = {salary,empId};
		int[] types = {Types.BIGINT,Types.BIGINT};
		int affectedRows = jdbcTemplate.update(sqlQuery, params, types);
		System.out.println("Affected Rows after update "+affectedRows);
		

	}

}
