package s.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import s.domain.entity.ItemPedido;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer> {
}
