package s.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import s.validation.NotEmptyList;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

	@NotNull(message = "Informe o código do cliente.")
	private Integer cliente;

	@NotNull(message = "Campo Total do pedido é obrigatório.")
	private BigDecimal total;

	@NotEmptyList(message = "Pedido não pode ser realizado sem itens.")
	private List<ItemPedidoDTO> items;
}
