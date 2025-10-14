package com.generation.bloguepessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.bloguepessoal.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
	//select * from tb_postagens where titulo like "%?%";
	public List <Postagem> findAllByTituloContainingIgnoreCase(String titulo);
	
	
	
}
