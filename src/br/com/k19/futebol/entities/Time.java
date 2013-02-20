package br.com.k19.futebol.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Time {

	@Id @GeneratedValue 
	private Long id;
	
	private String nome;
	
	private String tecnico;
	
	@OneToMany(cascade={CascadeType.ALL} ,orphanRemoval=true)
	private List<Jogador> listaDeJogadores = new ArrayList<Jogador>();

	// Getters and Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public List<Jogador> getListaDeJogadores() {
		return listaDeJogadores;
	}

	public void setListaDeJogadores(List<Jogador> listaDeJogadores) {
		this.listaDeJogadores = listaDeJogadores;
	}
	
	
}
