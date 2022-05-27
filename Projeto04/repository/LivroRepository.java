package org.serratec.backend.java.projeto04.repository;

import org.serratec.backend.java.projeto04.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}