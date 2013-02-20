package br.com.k19.futebol.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.k19.futebol.entities.Jogador;
import br.com.k19.futebol.entities.Time;

public class TimeRepository {

	private EntityManager manager;
	
	public TimeRepository(EntityManager manager) {
		this.manager = manager;
	}

	public void adiciona(Time time) {
		this.manager.persist(time);
	}
	
	public void altera(Time time) {
		this.manager.merge(time);
	}
	
	public Time procura(Long id) {
		return this.manager.find(Time.class, id);
	}
	
	public void remove(Long id) {
//		Query query = this.manager.createQuery("SELECT e FROM Jogador e WHERE e.time.id = :id");
//		query.setParameter("id", id);
//		List<Jogador> listaDeJogadores = query.getResultList();
		
		Time time = procura(id);
//		for (Jogador jogador : listaDeJogadores) {
//			jogador.setTime(null);
//		}
		this.manager.getTransaction().commit();
		this.manager.getTransaction().begin();
		this.manager.remove(time);
	}
	
	@SuppressWarnings("unchecked")
	public List<Time> getLista() {
		return this.manager.createQuery("SELECT e FROM Time e").getResultList();
	}
	
	
	
	
}
