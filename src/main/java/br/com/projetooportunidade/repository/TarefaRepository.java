package br.com.projetooportunidade.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.projetooportunidade.entity.Tarefa;

public interface TarefaRepository extends CrudRepository<Tarefa, Long>{
	
}
