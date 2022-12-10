package s.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import s.domain.entity.Produto;

public interface Produtos extends JpaRepository<Produto,Integer> {
}
