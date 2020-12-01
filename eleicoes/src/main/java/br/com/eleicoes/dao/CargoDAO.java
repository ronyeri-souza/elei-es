package br.com.eleicoes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eleicoes.model.Cargo;

@Repository
public interface CargoDAO extends JpaRepository<Cargo, Integer> {

}
