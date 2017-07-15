package br.com.projetooportunidade.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.projetooportunidade.entity.Usuario;
import br.com.projetooportunidade.repository.UsuarioRepository;

@Controller
@RequestMapping(path="/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;

	@GetMapping()
	public @ResponseBody Iterable<Usuario> all() {
		return repository.findAll();
	}
	
	@PostMapping()
	public @ResponseBody String add(@RequestBody Usuario usuario) {
		repository.save(usuario);
		return "Saved";
	}
	
	@DeleteMapping(path="/{id}")
	public @ResponseBody String remove(@PathVariable long id) {
		repository.delete(id);
		return "Removed";
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable long id) {
		Usuario usuario = repository.findOne(id);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
		repository.save(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.ACCEPTED);
	}
}
