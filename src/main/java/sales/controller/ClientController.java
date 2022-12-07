package sales.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import sales.entity.Client;
import sales.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<List<Client>> getAllClients() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{name}")
	public ResponseEntity<List<Client>> findClientByName(@PathVariable String name) {
		return ResponseEntity.ok().body(service.findByName(name));
	}

	@PostMapping
	public ResponseEntity<Client> addOneClient(@RequestBody Client reqClient) {
		return ResponseEntity.ok().body(service.postOne(reqClient));

	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> updateOneClient(@RequestBody Client reqClient, @PathVariable Integer id) {
		return ResponseEntity.ok().body(service.updateOneById(reqClient, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Client> deleteClientById(@PathVariable Integer id) {
		Client client = null;
		try {
			client = service.findById(id).get();
			service.deleteClientById(id);
			return ResponseEntity.status(200).body(client);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(404, "Unable to find resource", e);
		}
	}
}
