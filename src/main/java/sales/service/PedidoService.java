package sales.service;

import sales.domain.entity.Pedido;
import sales.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );
}
