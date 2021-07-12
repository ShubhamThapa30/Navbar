package navbar.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages=("navbar.Test"))
public class TestApp extends SpringBootServletInitializer {
	public static void main (String args[]) {
		SpringApplication.run(TestApp.class, args);
	}

protected SpringApplicationBuilder configuration(SpringApplicationBuilder application) {
 return application.sources(TestApp.class);
}
 String Category() {
	 return "Category";
 }
}
