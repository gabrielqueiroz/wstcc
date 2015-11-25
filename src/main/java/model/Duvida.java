package model;

import java.util.Arrays;
import java.util.Date;

/**
 * Entity Duvida responsável pelo gerenciamento de atributos de dúvidas.
 * 
 * @author Bruno Henrique Calil, Gabriel Queiroz e Victor Hugo.
 *
 */

public class Duvida {
	private int idDuvida;
	private String titulo;
	private String conteudo;
	private Date dataCriacao;
	private String criador;
	private int idUsuario;
	private int usuarioLogado;
	private int[] materias;
	private int qtdRespostas;
	private String[] tags;

	public int getIdDuvida() {
		return idDuvida;
	}

	public void setIdDuvida(int idDuvida) {
		this.idDuvida = idDuvida;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getCriador() {
		return criador;
	}

	public void setCriador(String criador) {
		this.criador = criador;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int[] getMaterias() {
		return materias;
	}

	public void setMaterias(int[] materias) {
		this.materias = materias;
	}

	public int getQtdRespostas() {
		return qtdRespostas;
	}

	public void setQtdRespostas(int qtdRespostas) {
		this.qtdRespostas = qtdRespostas;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Duvida [idDuvida=" + idDuvida + ", titulo=" + titulo + ", conteudo=" + conteudo + ", dataCriacao="
				+ dataCriacao + ", criador=" + criador + ", idUsuario=" + idUsuario + ", materias="
				+ Arrays.toString(materias) + ", qtdRespostas=" + qtdRespostas + ", tags=" + Arrays.toString(tags)
				+ "]";
	}

	public int getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(int usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
