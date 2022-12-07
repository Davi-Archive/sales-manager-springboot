package sales.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sales.domain.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
