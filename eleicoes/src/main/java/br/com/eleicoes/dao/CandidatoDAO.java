package br.com.eleicoes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.eleicoes.model.Candidato;

@Repository
public interface CandidatoDAO extends JpaRepository<Candidato, Integer> {
	
	// BUSCANDO CANDIDATOS COM CARGO DE PRESIDENTE
	@Query("FROM Candidato c WHERE c.cargo = 1")
	public Candidato[] findByCargo();
	
	// BUSCANDO CANDIDATOS COM CARGO DE SENADOR
	@Query("FROM Candidato c WHERE c.cargo = 2")
	public Candidato[] findByCargoSenador();
	
	// BUSCANDO CANDIDATOS COM CARGO DE GOVERNADOR
	@Query("FROM Candidato c WHERE c.cargo = 3")
	public Candidato[] findByCargoGovernador();
	
	// BUSCANDO CANDIDATOS COM CARGO DE DEPUTADO ESTADUAL
	@Query("FROM Candidato c WHERE c.cargo = 4")
	public Candidato[] findByCargoDepEstadual();
	
	// BUSCANDO CANDIDATOS COM CARGO DE DEPUTADO FEDERAL
	@Query("FROM Candidato c WHERE c.cargo = 5")
	public Candidato[] findByCargoDepFederal();
	
	// BUSCANDO O CANDIDATO POR SEU ID
	@Query("FROM Candidato c WHERE c.id = :id")
	public Candidato findCandidatoById(Integer id);
	
	// ADICIONANDO VOTOS AO CANDIDATO
	@Query("UPDATE Candidato SET quantidadeVotos = :quantidadeVotos WHERE id = :id")
	public Candidato adicionaVoto(Integer quantidadeVotos, Integer id); 
}
