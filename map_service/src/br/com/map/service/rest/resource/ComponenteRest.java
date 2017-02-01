package br.com.map.service.rest.resource;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.map.data.model.ComponenteModel;
import br.com.map.service.adapter.ComponenteAdapter;
import br.com.map.service.vo.ComponenteVO;

@Path("/componente")
public class ComponenteRest {
	
	private ComponenteModel cModel;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response incluir(ComponenteVO cVO){
		Response r;
		cModel = new ComponenteModel();
		
		try{
			cModel.incluir(ComponenteAdapter.VOToEntity(cVO));
			r = Response.status(201).entity("Objeto Criado !!!").build();
		}catch(Exception e){
			r = Response.status(501).entity(e.getMessage()).build();
		}
		
		return r;
	}
	
	@GET
	@Path("/lista")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar(){
		Response r;
		List<ComponenteVO> componentes;
		cModel = new ComponenteModel();
		try{
			componentes = ComponenteAdapter.entityListToVOList(cModel.listarTodos());
			r = Response.status(200).entity(componentes).build();
		}catch(Exception e){
			r = Response.status(501).entity(e.getMessage()).build();
			e.printStackTrace();
		}
		
		return r;
	}
	
	@GET
	@Path("/teste")
	@Produces(MediaType.TEXT_PLAIN)
	public String teste(){
		return "Chamei Servico!!";
	}

}
