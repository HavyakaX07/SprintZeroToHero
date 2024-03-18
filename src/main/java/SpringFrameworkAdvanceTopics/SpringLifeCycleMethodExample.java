package SpringFrameworkAdvanceTopics;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/*
 * In this example we will look at life cycle method execution on the bean.
 * 
 * There might be case after bean is created before it is being used we might need to do some initialization work
 * that can be done after post-construct.
 * 
 * In same fashion before removing bean from application context or before application context closes we might need to do some clean up work 
 * that can be done in pre-destroy method.
 */

@Component
class UserDefinedBean {
	
	private DataBaseConnectionBean dataBaseConnectionBean;
	
	//Constructor will be called first.
	public UserDefinedBean(DataBaseConnectionBean dataBaseConnectionBean) {
		System.out.println("Constructing the UserDefinedbean and injecting the dependency");
		this.dataBaseConnectionBean = dataBaseConnectionBean;
	}
	
	@PostConstruct
	public void intializeBean() {
		//Some initialization logic.
		System.out.println("Intializing the bean.");
		dataBaseConnectionBean.checkDBConnection();
	}
	
	@PreDestroy
	public void cleanUp() {
		//Clean up resource
		System.out.println("Cleaning up the bean");
		dataBaseConnectionBean = null;
	}
	
}

@Component
class DataBaseConnectionBean {
	
	public void checkDBConnection() {
		System.out.println("DB is up");
	}
}


@ComponentScan("SpringFrameworkAdvanceTopics")
@Configuration
public class SpringLifeCycleMethodExample {

	public static void main(String[] args) {
		 try (var context = new AnnotationConfigApplicationContext(SpringLifeCycleMethodExample.class);){
		System.out.println("Context initialized");
	}

	}

}
