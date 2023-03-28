package br.com.frango.leleko.data.vo;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;


@JsonPropertyOrder({"id", "nome", "quantidade", "valor"})
public class ItemVO extends RepresentationModel<ItemVO> implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@Mapping("id")
	private Long key;
	private String nome;
	private Double quantidade;
	private Double valor;
	private String medida;
	
	public ItemVO() {
		super();
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(key, medida, nome, quantidade, valor);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemVO other = (ItemVO) obj;
		return Objects.equals(key, other.key) && Objects.equals(medida, other.medida)
				&& Objects.equals(nome, other.nome) && Objects.equals(quantidade, other.quantidade)
				&& Objects.equals(valor, other.valor);
	}

	
	
	
}
