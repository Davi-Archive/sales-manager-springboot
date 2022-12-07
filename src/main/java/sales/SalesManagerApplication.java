package sales;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sales.domain.entity.Client;
import sales.domain.entity.OrderProduct;
import sales.domain.services.ClientService;
import sales.domain.services.OrderProductService;

@SpringBootApplication
public class SalesManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesManagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(
			@Autowired ClientService clientService,
			@Autowired OrderProductService order
			) {
		return args -> {
			List<Client> clientList = new ArrayList();

			Client c1 = new Client("Davi");
			Client c2 = new Client("Daves");
			Client c3 = new Client("Jones");

			OrderProduct p1 = new OrderProduct();
			p1.setClient(c1);
			p1.setOrderDate(LocalDate.now());
			p1.setTotal(BigDecimal.valueOf(100));
			
			clientService.saveAll(Arrays.asList(c1, c2, c3));
			
			order.save(p1);
			
			Client client = clientService.findClientFetchOrders(p1.getId());
			System.out.println(client);
			System.out.println(client.getOrders());
		
			
		};
	}
}
