package sales.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sales.domain.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	List<Client> findByNameLikeIgnoreCase(String name);

	@Query(" select c from Client c left join fetch c.orders where c.id = :id ")
	Client findClientFetchOrderProduct(@Param("id") Integer id);

}
