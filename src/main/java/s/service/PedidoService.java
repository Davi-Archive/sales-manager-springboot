package s.service;

import java.util.Optional;

import s.domain.entity.Pedido;
import s.domain.enums.StatusPedido;
import s.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
