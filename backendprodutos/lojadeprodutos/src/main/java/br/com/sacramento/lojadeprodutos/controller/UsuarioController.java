package br.com.sacramento.lojadeprodutos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sacramento.lojadeprodutos.model.Usuario;
import br.com.sacramento.lojadeprodutos.security.Autenticator;
import br.com.sacramento.lojadeprodutos.security.Token;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	
	
	@PostMapping("/login")
	public ResponseEntity<Token> autenticarUsuario(@RequestBody Usuario usuario){
		// aqui vem a lógica
		/* qual a idéia? verificar se no atributo EMAIL veio o conteúdo user@user.com
		 * e no atributo SENHA o conteudo 12345
		 */
		if (usuario.getEmail().equals("user@user.com") && usuario.getSenha().equals("12345")) {
			usuario.setId(1);
			usuario.setNome("Danielle Sacramento");
			// agora crio um token para mandar de volta (indicando que meu usuário recebeu um "cracha")
			Token t = new Token();
			t.setStrToken(Autenticator.generateToken(usuario));
			return ResponseEntity.ok(t);
		}
		else {
			return ResponseEntity.status(403).build();
		}
		
		
	}

}
