package sales.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sales.domain.entity.Cliente;
import sales.domain.entity.Pedido;

import java.util.List;
import java.util.Set;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);
}
