package br.com.frango.leleko.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.frango.leleko.controller.FrangoController;
import br.com.frango.leleko.controller.ItemController;
import br.com.frango.leleko.data.vo.FrangoVO;
import br.com.frango.leleko.exceptions.RequiredObjectIsNullException;
import br.com.frango.leleko.exceptions.ResourceNotFoundException;
import br.com.frango.leleko.mapper.DozerMapper;
import br.com.frango.leleko.modal.FrangoV;
import br.com.frango.leleko.repositories.FrangoRepository;

@Service
public class FrangoService {

	@Autowired
	FrangoRepository repository;

	@Autowired
	private DozerMapper mapper;

	public List<FrangoVO> findAll() {

		var item = DozerMapper.parseListObjects(repository.findAll(), FrangoVO.class);
		item.stream().forEach(p -> p.add(linkTo(methodOn(FrangoController.class).findById(p.getKey())).withSelfRel()));
		return item;
	}

	public FrangoVO findById(Long id) {

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		var vo = DozerMapper.parseObject(entity, FrangoVO.class);
		vo.add(linkTo(methodOn(FrangoController.class).findById(id)).withSelfRel());
		return vo;
	}

	public FrangoVO create(FrangoVO frango) {

		if (frango == null)
			throw new RequiredObjectIsNullException();
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		var entity = DozerMapper.parseObject(frango, FrangoV.class);
		entity.setData(data);
		var vo = DozerMapper.parseObject(repository.save(entity), FrangoVO.class);
		vo.add(linkTo(methodOn(FrangoController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public FrangoVO update(FrangoVO frango) {

		if (frango == null)
			throw new RequiredObjectIsNullException();

		var entity = repository.findById(frango.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setQuantidade(frango.getQuantidade());
		entity.setValor(frango.getValor());
		entity.setVendido(frango.getVendido());
		entity.setNaoVendido(frango.getNaoVendido());

		var vo = DozerMapper.parseObject(repository.save(entity), FrangoVO.class);
		vo.add(linkTo(methodOn(FrangoController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	public void delete(Long id) {

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}

}
