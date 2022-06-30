package oxyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OxyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OxyServiceApplication.class, args);
	}

}
