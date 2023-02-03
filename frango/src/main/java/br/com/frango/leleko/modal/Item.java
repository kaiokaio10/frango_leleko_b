package br.com.frango.leleko.modal;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class Item implements Serializable {
	

		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name = "nome", length = 80)
		private String nome;
		
		
		@Column(name = "quantidade" )
		private Double quantidade;
		
		
		@Column(name = "valor")
		private Double valor;

		public Item() {
			super();
		}


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
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


		@Override
		public int hashCode() {
			return Objects.hash(id, nome, quantidade, valor);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Item other = (Item) obj;
			return id == other.id && Objects.equals(nome, other.nome) && Objects.equals(quantidade, other.quantidade)
					&& Objects.equals(valor, other.valor);
		}
		
		
		
}
