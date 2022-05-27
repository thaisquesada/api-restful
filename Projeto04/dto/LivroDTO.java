package org.serratec.backend.java.projeto04.dto;

public class LivroDTO {

	private Integer idLivro;
	private String titulo;
	private String tipo;
	private String autor;
	private String dtPublicacao;
	
	public LivroDTO() {}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
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
