package SpringFrameWorkAnnotationBasedConfigurationAdvanced;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Here we are informing spring that this class is configuration class.
@Configuration
//This will tell spring that, spring bean can be found in this below package, so that you can maintain those things.
@ComponentScan(basePackages = { "SpringFrameWorkAnnotationBasedConfigurationAdvanced" })
public class ApplicationConfigFile {

}
