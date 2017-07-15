package br.com.projetooportunidade.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.projetooportunidade.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
}
