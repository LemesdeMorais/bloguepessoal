package com.generation.blogpessoal.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



@Entity
@Table(name = "tb_temas")
public class Tema {
	@Id // equivalente ao primary key(id)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // é o auto_increment
	private Long id;
	
	@Column(length = 1000)//precisa identificar q auntidade aqui, para não conflitar com o banco
	@NotBlank(message = "A Descrição é obrigatorio")// é o not null
	@Size(min = 5, max = 1000, message = "O atributo descrição deve contar no minimo 10 e no máximo 1000 caracteres.")
	private String descricao;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "tema", allowSetters = true)
	private List<Postagem> postagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
	
	
	
}