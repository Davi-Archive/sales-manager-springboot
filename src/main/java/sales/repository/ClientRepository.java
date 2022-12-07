package sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sales.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	
}
