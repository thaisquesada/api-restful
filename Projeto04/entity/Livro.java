package org.serratec.backend.java.projeto04.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="livro_cd_id")
	private Integer idLivro;
	
	@Column(name="livro_tx_nome")
	@NotNull
	@Size(min=5, max=30)
	private String titulo;
	
	@Column(name="livro_tx_tipo")
	@NotNull
	@Size(min=3, max=20)
	private String tipo;
	
	@Column(name="livro_tx_autor")
	@NotNull
	@Size(min=10, max=40)
	private String autor;
	
	@Column(name="livro_num_dtPublicacao")
	@NotNull
	@Size(max=10)
	private String dtPublicacao;
	
	public Livro() {}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer livroId) {
		this.idLivro = livroId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDtPublicacao() {
		return dtPublicacao;
	}

	public void setDtPublicacao(String dtPublicacao) {
		this.dtPublicacao = dtPublicacao;
	}
	
}