package br.com.map.service.adapter;

import br.com.map.data.entity.Componente;
import br.com.map.service.vo.ComponenteVO;

public class ComponenteAdapter {
	
	public static Componente VOToEntity(ComponenteVO vo){
		Componente retorno = new Componente();
		retorno.setId(vo.getId());
		retorno.setNome(vo.getNome());
		retorno.setDescricao(vo.getDescricao());
		retorno.setTipo(vo.getTipo());
		retorno.setInclusao(vo.getInclusao());
		
		return retorno;
	}
	
	public static ComponenteVO EntityToVO(Componente c){
		ComponenteVO retorno = new ComponenteVO();
		retorno.setId(c.getId());
		retorno.setNome(c.getNome());
		retorno.setDescricao(c.getDescricao());
		retorno.setTipo(c.getTipo());
		retorno.setInclusao(c.getInclusao());
		
		return retorno;
	}

}
