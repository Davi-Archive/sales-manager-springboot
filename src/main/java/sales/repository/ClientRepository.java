package sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sales.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	List<Client> findBynameIgnoreCase(String name);

	
}
