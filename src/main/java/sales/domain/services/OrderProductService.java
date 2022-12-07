package sales.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sales.domain.entity.OrderProduct;
import sales.domain.repository.OrderProductRepository;

@Service
public class OrderProductService {

	@Autowired
	private OrderProductRepository repository;
	
	public OrderProduct save(OrderProduct order) {
		return repository.save(order);
	}
	
}
