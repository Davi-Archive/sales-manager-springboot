package sales.rest;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

	private List<String> errors;

	public ApiErrors(String mensagemErro) {
		this.errors = Arrays.asList(mensagemErro);
	}
}
