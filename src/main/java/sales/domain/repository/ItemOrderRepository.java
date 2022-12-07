package sales.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sales.domain.entity.ItemBuy;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemBuy, Integer> {

	
}
