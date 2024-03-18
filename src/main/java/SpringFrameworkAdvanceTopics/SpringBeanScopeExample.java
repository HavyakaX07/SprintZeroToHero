package SpringFrameworkAdvanceTopics;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * In this example we will look at what all are types of Bean.
 * If you want same bean for every method call then this will be called Singleton (use case when no need to hold of state of object)
 * If you want different bean for every method call the this will be called prototype. (use case when need to hold of state of object statefullness like user data )
 * 
 * This things are called scope of the bean.
 * 
 * There are different types of scope also 
 * 1. Request -> new Object per each Http request
 * 2. Session -> new Object per each user session
 * 3. Application -> new  Object  per each application Context
 */


/*
 * Singleton class
 */
@Component
class BaseLocation {
	
}

/*
 * Current location might change as time passes.
 * Hence make that as prototype.
 */
@Component
@Scope("prototype")
class CurrentLocation {
	
}

@Configuration
@ComponentScan("SpringFrameworkAdvanceTopics")
public class SpringBeanScopeExample {

	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(SpringBeanScopeExample.class);){
			//Check the Hash it will be same for all three objects.
			System.out.println(context.getBean("baseLocation"));
			System.out.println(context.getBean("baseLocation"));
			System.out.println(context.getBean("baseLocation"));
			
			//Check the Hash it will be different fro all three objects.
			System.out.println(context.getBean("currentLocation"));
			System.out.println(context.getBean("currentLocation"));
			System.out.println(context.getBean("currentLocation"));
		}

	}

}

/*
 * Now there is difference between Java singleton vs Spring singleton
 * Java singleton -> one object for one JVM
 * Spring singleton -> one object for one spring IoC container
 */
