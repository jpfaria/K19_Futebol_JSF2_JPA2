package br.com.k19.futebol.managedbeans;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class AutenticadorBean {

	private static Map<String, String> mapa = new HashMap<String, String>();
	private String usuario;
	private String senha;
	
	static {
		AutenticadorBean.mapa.put("k19","k19");
		AutenticadorBean.mapa.put("jonas.hirata","jonatas.hirata");
		AutenticadorBean.mapa.put("marcelo.martins","marcelo.martins");
		AutenticadorBean.mapa.put("rafael.cosentino","rafael.cosentino");
	}
	
	public String autentica() {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		if (AutenticadorBean.mapa.containsKey(this.usuario) && 
				AutenticadorBean.mapa.get(this.usuario).equals(this.senha)) {
			
			ExternalContext ec = fc.getExternalContext();
			HttpSession session = (HttpSession) ec.getSession(false);
			session.setAttribute("usuario", this.usuario);
			
			return "/times";
			
		} else {
			
			FacesMessage message = new FacesMessage("Usuário ou senha inválidos");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(null, message);
			
			return "/login";		
			
		}
		
	}
	
	public String registraSaida() {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.removeAttribute("usuario");
		
		return "/login";
		
	}

	public static Map<String, String> getMapa() {
		return mapa;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public static void setMapa(Map<String, String> mapa) {
		AutenticadorBean.mapa = mapa;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
