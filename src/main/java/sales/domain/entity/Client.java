package sales.domain.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false, length = 100)
	private String name;

	@OneToMany(mappedBy = "client")
	private Set<OrderProduct> orders;
	
	public Client() {
	}

	public Client(String name) {
		this.name = name;
	}
	
	

	public Set<OrderProduct> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderProduct> orders) {
		this.orders = orders;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", orders=" + orders + "]";
	}
	
	

}
