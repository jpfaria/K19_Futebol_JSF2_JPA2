package br.com.k19.futebol.util;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

public class ManagerFactory {
	
	public static EntityManager getManager() {
		Map<String, Object> mapa = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
		return (EntityManager) mapa.get("manager");
	}
	
}
