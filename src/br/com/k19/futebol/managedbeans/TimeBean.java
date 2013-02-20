package br.com.k19.futebol.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;

import br.com.k19.futebol.entities.Time;
import br.com.k19.futebol.repositories.TimeRepository;
import br.com.k19.futebol.util.K19Utils;
import br.com.k19.futebol.util.ManagerFactory;

@ManagedBean
public class TimeBean {

	private Time time;
	private TimeRepository repo;
	
	public TimeBean() {
		this.time = new Time();
		this.repo = new TimeRepository(ManagerFactory.getManager());
	}

	public void adiciona() {
		repo.adiciona(time);
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public TimeRepository getRepo() {
		return repo;
	}

	public void setRepo(TimeRepository repo) {
		this.repo = repo;
	}

	public Time procura(Long id) {
		return repo.procura(id);
	}
	
	public void remove(AjaxBehaviorEvent event) {
		Long id = Long.parseLong(((String) K19Utils.getVariableOfParam("id")));
		repo.remove(procura(id).getId());
	}
	
	public void altera() {
		if (!(time.getNome() == null || time.getTecnico() == null)) {
			Long id = Long.parseLong(((String) K19Utils.getVariableOfParam("id")));
			time.setId(id);
			repo.altera(time);
		}
	}
	
	public List<Time> lista() {
		return repo.getLista();
	}
	
}
