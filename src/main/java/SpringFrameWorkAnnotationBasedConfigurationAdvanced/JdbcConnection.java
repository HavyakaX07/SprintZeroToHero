package SpringFrameWorkAnnotationBasedConfigurationAdvanced;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcConnection {

	private final JdbcTemplate jdbcTemplate;

	// Inject DataSourceConnection object to this constructor. Hence this is called
	// Constructor injection. Constructor injection does not required @Autowired annotation. It is optional.
	//@Autowired
	public JdbcConnection(DataSourceConnection myDataSource) {
		this.jdbcTemplate = new JdbcTemplate(myDataSource.getDataSource());
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

}
