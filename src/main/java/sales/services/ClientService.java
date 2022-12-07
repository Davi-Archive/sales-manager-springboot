package sales.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	
}
