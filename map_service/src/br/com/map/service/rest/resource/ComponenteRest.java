package br.com.map.service.rest.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.map.data.model.ComponenteModel;
import br.com.map.service.adapter.ComponenteAdapter;
import br.com.map.service.vo.ComponenteVO;
import br.com.map.service.vo.TransporteVO;

@Path("/componente")
public class ComponenteRest {
	
	private ComponenteModel cModel;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response incluir(ComponenteVO cVO){
		Response r;
		TransporteVO tVO;
		cModel = new ComponenteModel();
		
		try{
			cModel.incluir(ComponenteAdapter.VOToEntity(cVO));
			tVO = new TransporteVO(201, "Componente inclu�do com sucesso");
		}catch(Exception e){
			tVO = new TransporteVO(501, e.getMessage());
		}
		
		r = Response.status(tVO.getStatus()).entity(tVO).build();
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
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterar(ComponenteVO cVO){
		Response r;
		TransporteVO tVO;
		cModel = new ComponenteModel();
		
		try {
			cModel.alterar(ComponenteAdapter.VOToEntity(cVO));
			tVO = new TransporteVO(200, "Altera��o Realizada Com Sucesso");
		} catch (Exception e) {
			tVO = new TransporteVO(500, e.getMessage());
		}
		
		r = Response.status(tVO.getStatus()).entity(tVO).build();
		return r;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarPorId(@QueryParam("id") long id){
		TransporteVO tVO;
		ComponenteVO cVO;
		Response r = null;
		
		cModel = new ComponenteModel();
		
		try{
			cVO = ComponenteAdapter.EntityToVO(cModel.pesquisarPorId(id));
			r = Response.status(200).entity(cVO).build();
		}catch(Exception e){
			tVO = new TransporteVO();
			tVO.setStatus(501);
			tVO.setMensagem(e.getMessage());
			
			r = Response.status(tVO.getStatus()).entity(tVO).build();
		}
		
		return r;
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@QueryParam("id") long id){
		TransporteVO tVO = new TransporteVO();
		ComponenteVO cVO = new ComponenteVO();
		cVO.setId(id);
		
		Response r = null;
		
		cModel = new ComponenteModel();
		
		try{
			cModel.excluir(ComponenteAdapter.VOToEntity(cVO));
			tVO.setStatus(201);
			tVO.setMensagem("Componente Exclu�do com sucesso");
		}catch(Exception e){
			tVO.setStatus(501);
			tVO.setMensagem(e.getMessage());
		}
		
		r = Response.status(tVO.getStatus()).entity(tVO).build();
		
		return r;
	}
}
