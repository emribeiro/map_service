package br.com.map.service.vo;

import java.util.Date;

public class ComponenteVO {
	private long id;
	private String nome;
	private String descricao;
	private int tipo;
	private Date inclusao;
	 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getInclusao() {
		return inclusao;
	}
	public void setInclusao(Date inclusao) {
		this.inclusao = inclusao;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
