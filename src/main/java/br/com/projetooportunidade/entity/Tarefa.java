package br.com.projetooportunidade.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tarefa")
public class Tarefa implements Serializable {

	@Transient
	private static final long serialVersionUID = 6708794541850235518L;

	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private String tituloDaTarefa;
	@Column(nullable = true)
	private String descricao;

	@Column(nullable = false)
	private String criador;

	@ManyToOne
    @JoinColumn(name = "executor_id")
	private Usuario executor;
	
	private Status status;

	public Tarefa() {
		// TODO Auto-generated constructor stub
	}
	
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

	public Status getEvento() {
		return status;
	}

	public void setEvento(Status status) {
		this.status = status;
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

	public enum Status {
		PENDENTE, EXECUTANDO, CONCLUIDO
	}
}
