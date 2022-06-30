package dondangkyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DonDangKyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonDangKyServiceApplication.class, args);
	}

}
