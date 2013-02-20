package br.com.k19.futebol.util;

import java.util.Map;

import javax.faces.context.FacesContext;

public class K19Utils {

	public static Object getVariableOfParam(String nameOfVariable) {
		Map<String, String> mapa = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		return mapa.get(nameOfVariable);
	}
	
}
