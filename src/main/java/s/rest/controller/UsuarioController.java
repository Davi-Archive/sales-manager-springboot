package s.rest.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;

import lombok.RequiredArgsConstructor;
import s.domain.entity.Usuario;
import s.exception.SenhaInvalidaException;
import s.rest.dto.CredencialDTO;
import s.rest.dto.TokenDTO;
import s.security.jwt.JwtService;
import s.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioServiceImpl usuarioService;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> salvar(@RequestBody @Valid Usuario usuario) {
		String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		return ResponseEntity.created(null).body(usuarioService.salvar(usuario));
	}

	public TokenDTO authenticar(@RequestBody CredencialDTO credenciais) {
		try {
			Usuario usuario = Usuario.builder().login(credenciais.getLogin()).senha(credenciais.getSenha()).build();
			UserDetails usuarioAuthenticado = usuarioService.autenticar(usuario);
			String token = jwtService.gerarToken(usuario);

			return new TokenDTO(usuario.getLogin(), token);

		} catch (UsernameNotFoundException | SenhaInvalidaException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getMessage());
		} 
	}
}
