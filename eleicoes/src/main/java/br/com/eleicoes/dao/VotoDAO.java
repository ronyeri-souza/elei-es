package br.com.eleicoes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.eleicoes.model.Voto;

@Repository
public interface VotoDAO extends JpaRepository<Voto, Integer> {

	// BUSCANDO O PERCENTUAL DE VOTOS
	@Query("SELECT v.percentual FROM Voto v WHERE v.id = 1")
	public Double findPercentual();
	
	// BUSCANDO O PERCENTUAL DE VOTOS
	@Query("SELECT v.totalEleitores FROM Voto v WHERE v.id = 1")
	public Integer findTotalEleitores();
	
	// BUSCANDO O PERCENTUAL DE VOTOS
	@Query("SELECT v.totalVotos FROM Voto v WHERE v.id = 1")
	public Integer findTotalVotos();
}
