package sales.services;

import java.util.List;

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
	
	public List<Client> saveAll(List<Client> list) {
		return repository.saveAll(list);
	}
}
