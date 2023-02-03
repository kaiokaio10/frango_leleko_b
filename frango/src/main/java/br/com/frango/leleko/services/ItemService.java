package br.com.frango.leleko.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.frango.leleko.controller.ItemController;
import br.com.frango.leleko.data.vo.ItemVO;
import br.com.frango.leleko.exceptions.RequiredObjectIsNullException;
import br.com.frango.leleko.exceptions.ResourceNotFoundException;
import br.com.frango.leleko.mapper.DozerMapper;
import br.com.frango.leleko.modal.Item;
import br.com.frango.leleko.repositories.ItemRepository;

@Service
public class ItemService {
	
	private Logger logger = Logger.getLogger(Service.class.getName());
	
	@Autowired
	ItemRepository repository;
	
	public List<ItemVO> findAll() {

		logger.info("Finding all item!");

		var item = DozerMapper.parseListObjects(repository.findAll(), ItemVO.class);
		item
			.stream()
			.forEach(p -> p.add(linkTo(methodOn(ItemController.class).findById(p.getKey())).withSelfRel()));
		return item;
	}

	public ItemVO findById(Long id) {
		
		logger.info("Finding one item!");
		
		var entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		var vo = DozerMapper.parseObject(entity, ItemVO.class);
		vo.add(linkTo(methodOn(ItemController.class).findById(id)).withSelfRel());
		return vo;
	}
	
	public ItemVO create(ItemVO item) {

		if (item == null) throw new RequiredObjectIsNullException();
		
		logger.info("Creating one item!");
		var entity = DozerMapper.parseObject(item, Item.class);
		var vo =  DozerMapper.parseObject(repository.save(entity), ItemVO.class);
		vo.add(linkTo(methodOn(ItemController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public ItemVO update(ItemVO item) {

		if (item == null) throw new RequiredObjectIsNullException();
		
		logger.info("Updating one item!");
		
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
		
		logger.info("Deleting one item!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}

}
