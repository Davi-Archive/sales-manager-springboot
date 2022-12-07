package sales.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sales.domain.entity.Produto;

public interface Produtos extends JpaRepository<Produto,Integer> {
}
