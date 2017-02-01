package br.com.map.service.adapter;

import java.util.ArrayList;
import java.util.List;

import br.com.map.data.entity.Componente;
import br.com.map.service.vo.ComponenteVO;

public class ComponenteAdapter {
	
	public static Componente VOToEntity(ComponenteVO vo){
		Componente c = new Componente();
		c.setId(vo.getId());
		c.setNome(vo.getNome());
		c.setDescricao(vo.getDescricao());
		c.setTipo(vo.getTipo());
		c.setInclusao(vo.getInclusao());
		
		return c;
	}
	
	
	public static ComponenteVO EntityToVO(Componente c){
		ComponenteVO vo = new ComponenteVO();
		vo.setId(c.getId());
		vo.setNome(c.getNome());
		vo.setDescricao(c.getDescricao());
		vo.setTipo(c.getTipo());
		vo.setInclusao(c.getInclusao());
		
		return vo;
	}
	
	public static List<ComponenteVO> entityListToVOList(List<Componente> lista){
		List<ComponenteVO> componentesVO = new ArrayList<ComponenteVO>();
		
		for(Componente c : lista){
			componentesVO.add(EntityToVO(c));
		}
		
		return componentesVO;
	}

}
