package br.com.eleicoes.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Candidato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 255)
	private String nome;
	
	@OneToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "id_cargo")
	private Cargo cargo;
	
	@Column(length = 8, columnDefinition = "INT(8)")
	private Integer numeroCandidato;
	
	@Column(length = 6, columnDefinition = "INT(6)")
	private Integer quantidadeVotos = 0; 
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Integer getNumeroCandidato() {
		return numeroCandidato;
	}

	public void setNumeroCandidato(Integer numeroCandidato) {
		this.numeroCandidato = numeroCandidato;
	}

	public Integer getQuantidadeVotos() {
		return quantidadeVotos;
	}

	public void setQuantidadeVotos(Integer quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos++;
	}
	
	// MÉTODO PARA ADICIONAR OS VOTOS AO CANDIDATO
	public Integer addVoto() {
		this.quantidadeVotos++;
		return quantidadeVotos;
	}

	@Override
	public String toString() {
		return "Presidente [id=" + id + ", nome=" + nome + ", numeroCandidato=" + numeroCandidato + ", quantidadeVotos="
				+ quantidadeVotos + "]";
	}
	
	
	
}
