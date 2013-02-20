package br.com.k19.futebol.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;

import br.com.k19.futebol.entities.Jogador;
import br.com.k19.futebol.repositories.JogadorRepository;
import br.com.k19.futebol.util.K19Utils;
import br.com.k19.futebol.util.ManagerFactory;

@ManagedBean
public class JogadorBean {

	private Jogador jogador;
	
	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public JogadorRepository getRepo() {
		return repo;
	}

	public void setRepo(JogadorRepository repo) {
		this.repo = repo;
	}

	private JogadorRepository repo;

	public JogadorBean() {

		this.jogador = new Jogador();
		this.repo = new JogadorRepository(ManagerFactory.getManager());
	}

	public void adiciona() {
		repo.adiciona(jogador);
	}

	public Jogador procura(Long id) {
		return repo.procura(id);
	}

	public void remove(AjaxBehaviorEvent event) {
		Long id = Long.parseLong((String) K19Utils.getVariableOfParam("id"));
		repo.remove(id);
	}

	public void altera() {
		Long id = Long.parseLong((String) K19Utils.getVariableOfParam("id"));
		jogador.setId(id);
		repo.altera(jogador);
	}

	public List<Jogador> lista() {
		return repo.getLista();
	}

}
