package RentOxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FontEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(FontEndApplication.class, args);
	}

}
