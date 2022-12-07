package sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sales.entity.Client;
import sales.entity.OrderProduct;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {

	
}
