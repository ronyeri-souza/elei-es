package br.com.eleicoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_voto")
	private Integer idVoto;
	
	@Column(name = "total_Eleitores")
	private Integer totalEleitores = 200;
	
	@Column(name="total_votos")
	private Integer totalVotos = 0;
	
	private Double percentual = 0.0;
	
	public Integer getIdVoto() { 
		return idVoto;
	}

	public void setIdVoto(Integer idVoto) {
		this.idVoto = idVoto;
	}

	public Integer getTotalEleitores() {
		return totalEleitores;
	}

	public void setTotalEleitores(Integer totalEleitores) {
		this.totalEleitores = totalEleitores;
	}

	public Integer getTotalVotos() {
		return totalVotos;
	}

	public void setTotalVotos(Integer totalVotos) {
		this.totalVotos = totalVotos;
	}


	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Integer totalVotos, Integer totalEeitores) {
		this.percentual = (double) ((totalVotos + 1) *100/totalEleitores);
	}
	
	// MÉTODO PARA REALIZAR A CONTAGEM DE VOTOS
	public Integer contagemVotos() {
		this.totalVotos++;
		return totalVotos;
	} 
	
	

	@Override  
	public String toString() {
		return "Voto [idVoto=" + idVoto + ", totalEleitores=" + totalEleitores + ", totalVotos=" + totalVotos
				+ ", percentual=" + percentual + "]";
	}
		
}
