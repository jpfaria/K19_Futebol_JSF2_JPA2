package br.com.k19.futebol.filters;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns="/*")
public class JPAFilter implements Filter {

	private EntityManagerFactory factory;

	@Override
	public void destroy() {		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		EntityManager manager = factory.createEntityManager();
		request.setAttribute("manager", manager);
		
		manager.getTransaction().begin();
		
		chain.doFilter(request, response);
		
		try {
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			
		} finally {
			manager.close();
		}
						
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		factory = Persistence.createEntityManagerFactory("K19-Futebol-PU");		
	}
	
	
	
}
