package br.com.frango.leleko.data.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonPropertyOrder({"id", "quantidade", "valor"})
public class FrangoVO extends RepresentationModel<FrangoVO> implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long key;
	
	private Double quantidade;
	
	
	private Double valor;

	private Double vendido;
	
	private Double naoVendido;

	private String data;
	
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

	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}

	public Double getVendido() {
		return vendido;
	}

	public void setVendido(Double vendido) {
		this.vendido = vendido;
	}

	public Double getNaoVendido() {
		return naoVendido;
	}

	public void setNaoVendido(Double naoVendido) {
		this.naoVendido = naoVendido;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(data, key, naoVendido, quantidade, valor, vendido);
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
		FrangoVO other = (FrangoVO) obj;
		return Objects.equals(data, other.data) && key == other.key && Objects.equals(naoVendido, other.naoVendido)
				&& Objects.equals(quantidade, other.quantidade) && Objects.equals(valor, other.valor)
				&& Objects.equals(vendido, other.vendido);
	}

	
}
