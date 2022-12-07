package sales.service;

import java.util.Optional;

import sales.domain.entity.Pedido;
import sales.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );
    
    Optional<Pedido> obterPedidoCompleto(Integer id);
}
