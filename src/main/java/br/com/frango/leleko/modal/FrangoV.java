package br.com.frango.leleko.modal;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "frango_vendido")
public class FrangoV {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
		
	@Column(name = "quantidade" )
	private Double quantidade;
	
	
	@Column(name = "valor")
	private Double valor;
	
	@Column(name = "vendidos")
	private Double vendido;
	
	@Column(name = "nao_vendidos")
	private Double naoVendido;
	
	@Column(name = "data")
	private String data;

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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
		return Objects.hash(data, id, naoVendido, quantidade, valor, vendido);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FrangoV other = (FrangoV) obj;
		return Objects.equals(data, other.data) && id == other.id && Objects.equals(naoVendido, other.naoVendido)
				&& Objects.equals(quantidade, other.quantidade) && Objects.equals(valor, other.valor)
				&& Objects.equals(vendido, other.vendido);
	}

}
