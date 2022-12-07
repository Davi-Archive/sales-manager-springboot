package sales.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import sales.entity.Client;
import sales.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	public List<Client> findAll() {
		return repository.findAll();
	}

	public Optional<Client> findById(Integer id) {
		return repository.findById(id);
	}

	public List<Client> findByName(String name) {
		return repository.findBynameIgnoreCase(name);
	}

	public List<Client> saveAll(List<Client> list) {
		return repository.saveAll(list);
	}

	public void deleteClientById(Integer id) {
		repository.deleteById(id);
	}

	public Client postOne(Client reqClient) {
		return repository.save(reqClient);
	}

	public Client updateOneById(Client reqClient, Integer id) {
		try {
			reqClient.setId(id);
			if (repository.findById(id).isEmpty()) {
				throw new Exception();
			}
			return repository.save(reqClient);
		} catch (Exception e) {
			throw new ResponseStatusException(404, "Client to be edited was not founded.", e);
		}
	}

}
