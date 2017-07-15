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

import br.com.projetooportunidade.entity.Tarefa;
import br.com.projetooportunidade.repository.TarefaRepository;

@Controller
@RequestMapping(path="/tarefas")
public class TarefaController {
	
	@Autowired
	private TarefaRepository repository;

	@GetMapping()
	public @ResponseBody Iterable<Tarefa> all() {
		return repository.findAll();
	}
	
	@PostMapping()
	public @ResponseBody String add(@RequestBody Tarefa tarefa) {
		repository.save(tarefa);
		return "Saved";
	}
	
	@DeleteMapping(path="/{id}")
	public @ResponseBody String remove(@PathVariable long id) {
		repository.delete(id);
		return "Removed";
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Tarefa> findById(@PathVariable long id) {
		Tarefa tarefa = repository.findOne(id);
		return new ResponseEntity<Tarefa>(tarefa, HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<Tarefa> update(@RequestBody Tarefa tarefa) {
		repository.save(tarefa);
		return new ResponseEntity<Tarefa>(tarefa, HttpStatus.ACCEPTED);
	}
}
