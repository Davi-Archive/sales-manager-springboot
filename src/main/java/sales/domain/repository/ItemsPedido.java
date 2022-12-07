package sales.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sales.domain.entity.ItemPedido;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer> {
}
