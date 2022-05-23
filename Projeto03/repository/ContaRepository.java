package org.serratec.backend.projeto03.repository;

import java.util.Optional;

import org.serratec.backend.projeto03.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{
	
	Optional<Conta> findById(Integer contaId);
	
}