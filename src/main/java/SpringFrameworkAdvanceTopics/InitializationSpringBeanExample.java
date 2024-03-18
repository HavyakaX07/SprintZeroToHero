package SpringFrameworkAdvanceTopics;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/*
 * In this demo we will see what all are the types of spring initialization techniques.
 * 
 * By default beans are initialized when creation of context only. This is called Eager initialization.
 * 
 * We can also tell spring that only create the bean only when needed, this is called Lazy initialization.
 * This is not often used because there will be chance of runtime exception or significat delay in http request.
 * 
 * This is being used only when bean is used very rarely and that is resource heavy and that might consume time during start up.
 * In that case this Lazy initialization is being used.
 */


/*
 * Create class which is very rarely used and make use of resource heavy computation.
 */

//This bean will be initialized eagerly
@Component
class BigFileProcessor {
	
	public BigFileProcessor() {
		System.out.println("Initializing BigFile processor");
	}
	
}

//This bean will be initialized only when this is being requested first time by the application.
@Component
@Lazy
class RarelyUsedClass {
	private BigFileProcessor bigFileProcessor;
	public RarelyUsedClass(BigFileProcessor bigFileProcessor) {
		System.out.println("Initializing RarelyUsedClass and injecting dependency");
		this.bigFileProcessor = bigFileProcessor;
	}
}
@Configuration
@ComponentScan("SpringFrameworkAdvanceTopics")
public class InitializationSpringBeanExample {
	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(InitializationSpringBeanExample.class);){
			System.out.println("Context initialized");
			context.getBean("rarelyUsedClass");
		}
	}

}
