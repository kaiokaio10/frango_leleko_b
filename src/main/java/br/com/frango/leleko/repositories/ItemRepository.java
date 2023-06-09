package br.com.frango.leleko.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.frango.leleko.modal.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	List<Item> findByNome(String nome);

}
