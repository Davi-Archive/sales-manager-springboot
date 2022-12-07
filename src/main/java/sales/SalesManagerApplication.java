package sales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.weaver.patterns.ArgsAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sales.entity.Client;
import sales.services.ClientService;

@SpringBootApplication
public class SalesManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesManagerApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner init(@Autowired ClientService clientService) {
		return args -> {
			List<Client> clientList = new ArrayList();
			
			Client c1 = new Client("Davi");
			Client c2 = new Client("Daves");
			Client c3 = new Client("Jones");
			
			clientService.saveAll(Arrays.asList(c1,c2,c3));
		};
	}
}
