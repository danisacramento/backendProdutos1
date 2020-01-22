package br.com.sacramento.lojadeprodutos.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sacramento.lojadeprodutos.model.Produto;
import br.com.sacramento.lojadeprodutos.security.Autenticator;

@RestController
@CrossOrigin("*")
public class ProdutoController {
	
	@GetMapping("/produtos")
	public ResponseEntity<ArrayList<Produto>> listaTodosOsProdutos(@RequestParam String token) {
		/* qual a lógica? 
		 * para poder enviar a lista de produtos, vamos considerar esta funcionalidade
		 * como sendo uma funcionalidade só para usuarios autorizados (que tenham token)
		 */
		if (token != null && Autenticator.isValid(token)) {
			// vou fazer uma logica que simula cnsulta no banco
			// criei uma lista
			ArrayList<Produto> lista = new ArrayList<Produto>();
			// vou preencher a lista
			for (int i=0; i<25;i++) {
				Produto p = new Produto();
				p.setCodigo(100+i);
				p.setTitulo("Produto "+i);
				p.setDetalhes("Produto "+i+" top de linha");
				p.setPreco(1000+i);
				// adiciono na lista
				lista.add(p);
			}
			
			return ResponseEntity.ok(lista);
		}
		else {
			return ResponseEntity.status(403).build();
		}
		
	}

}
