package SpringFrameWorkAnnotationBasedConfigurationAdvanced;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

//Tells spring framework that to manage this bean.
@Component
public class DataSourceConnection {

	public BasicDataSource getDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/test");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Hegde");
        // Configure other properties like maxTotal, maxIdle, etc.
        return dataSource;
	}
}
