package br.com.projetooportunidade.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TUsuario")
public class Tarefa {

	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String tituloDaTarefa;
	@Column(nullable=true)
	private String descricao;
	@Column(nullable=false)
	private String criador;
	@Column(nullable=false)
	private Usuario executor;
	private Evento evento;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTituloDaTarefa() {
		return tituloDaTarefa;
	}
	public void setTituloDaTarefa(String tituloDaTarefa) {
		this.tituloDaTarefa = tituloDaTarefa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCriador() {
		return criador;
	}
	public void setCriador(String criador) {
		this.criador = criador;
	}
	public Usuario getExecutor() {
		return executor;
	}
	public void setExecutor(Usuario executor) {
		this.executor = executor;
	}
	
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public enum Evento {
		PENDENTE, EXECUTANDO, CONCLUIDO
	}
}
