package br.com.map.service.rest;

import br.com.map.data.model.ComponenteModel;
import br.com.map.service.adapter.ComponenteAdapter;
import br.com.map.service.vo.ComponenteVO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/componente")
public class ComponenteRest {
	
	private ComponenteModel cModel;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void incluir(ComponenteVO vo){
		cModel = new ComponenteModel();
		
		try{
			cModel.incluir(ComponenteAdapter.VOToEntity(vo));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
