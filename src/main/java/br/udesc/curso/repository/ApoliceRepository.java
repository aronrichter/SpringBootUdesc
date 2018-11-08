package br.udesc.curso.repository;

import br.udesc.curso.model.Apolice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ApoliceRepository extends JpaRepository<Apolice, Long>{

}
