package br.com.frango.leleko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.frango.leleko.modal.FrangoV;

@Repository
public interface FrangoRepository extends JpaRepository<FrangoV, Long> {

}
