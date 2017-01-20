package br.com.map.service.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.map.service.rest.resource.ComponenteRest;

@ApplicationPath("rest")
public class RESTApplication extends Application{
	private Set<Object> singletons = new HashSet<Object>();
	
	public RESTApplication(){
		singletons.add(new ComponenteRest());
	}
	
	@Override
	public Set<Object> getSingletons(){
		return singletons;
	}
}
