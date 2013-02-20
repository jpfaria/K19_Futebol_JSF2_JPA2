package br.com.k19.futebol.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.k19.futebol.entities.Jogador;

public class JogadorRepository {

	private EntityManager manager;

	public JogadorRepository(EntityManager manager) {
		this.manager = manager;
	}
		
	public void adiciona(Jogador jogador) {
		this.manager.persist(jogador);
	}
	
	public void remove(Long id) {
		Jogador jogador = this.manager.find(Jogador.class, id);
		this.manager.getTransaction().commit();
		this.manager.getTransaction().begin();		
		this.manager.remove(jogador);
		this.manager.getTransaction().commit();
		this.manager.getTransaction().begin();	
	}
	
	public void altera(Jogador jogador) {
		this.manager.merge(jogador);
	}
		
	public void atualiza(Jogador jogador) {
		this.manager.merge(jogador);
	}
	
	public Jogador procura(Long id) {
		return this.manager.find(Jogador.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Jogador> getLista() {
		Query query = null;
		try {
			query = this.manager.createQuery("SELECT e FROM Jogador e");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
	
	
	
}
