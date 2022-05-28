package org.serratec.backend.projeto06.repository;

import org.serratec.backend.projeto06.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}