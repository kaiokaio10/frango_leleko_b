package br.com.frango.leleko.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.AccessOptions.SetOptions.Propagation;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.Mapping;

import br.com.frango.leleko.controller.ItemController;
import br.com.frango.leleko.data.vo.ItemVO;
import br.com.frango.leleko.exceptions.RequiredObjectIsNullException;
import br.com.frango.leleko.exceptions.ResourceNotFoundException;
import br.com.frango.leleko.mapper.DozerMapper;
import br.com.frango.leleko.modal.Item;
import br.com.frango.leleko.repositories.ItemRepository;
import jakarta.transaction.Transactional;

@Service
public class ItemService {
	
	
	@Autowired
	ItemRepository repository;
	
	@Autowired
	private DozerMapper mapper;
	
	public List<ItemVO> findAll() {

		var item = DozerMapper.parseListObjects(repository.findAll(), ItemVO.class);
		item
			.stream()
			.forEach(p -> p.add(linkTo(methodOn(ItemController.class).findById(p.getKey())).withSelfRel()));
		return item;
	}

	public ItemVO findById(Long id) {
		
		var entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		var vo = DozerMapper.parseObject(entity, ItemVO.class);
		vo.add(linkTo(methodOn(ItemController.class).findById(id)).withSelfRel());
		return vo;
	}
	
	public ItemVO create(ItemVO item) {

		if (item == null) throw new RequiredObjectIsNullException();
		
		var entity = DozerMapper.parseObject(item, Item.class);
		var vo =  DozerMapper.parseObject(repository.save(entity), ItemVO.class);
		vo.add(linkTo(methodOn(ItemController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public ItemVO update(ItemVO item) {

		if (item == null) throw new RequiredObjectIsNullException();
		
		
		var entity = repository.findById(item.getKey())
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setNome(item.getNome());
		entity.setQuantidade(item.getQuantidade());
		entity.setValor(item.getValor());
		
		var vo =  DozerMapper.parseObject(repository.save(entity), ItemVO.class);
		vo.add(linkTo(methodOn(ItemController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public void delete(Long id) {
		
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}
	public List<ItemVO> pesquisarItem(String nome) {
		
		var item = DozerMapper.parseListObjects(repository.findByNome(nome), ItemVO.class);
		item
			.stream()
			.forEach(p -> p.add(linkTo(methodOn(ItemController.class).findById(p.getKey())).withSelfRel()));
		return item;
	}

}
