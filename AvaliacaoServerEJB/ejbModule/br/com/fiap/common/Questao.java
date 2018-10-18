package br.com.fiap.common;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "questao")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Questao implements Serializable {

	private static final long serialVersionUID = 112L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Integer id;
	
	private Integer codigoAvaliacao;
	
	@Column(name = "descricao")
	private String descricao;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Resposta.class, mappedBy = "questao", fetch=FetchType.EAGER)
	private Collection<Resposta> respostas;
	
	@Transient
	private Resposta respostaSelecionada;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String string) {
		descricao = string;
	}

	public Collection<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(Collection<Resposta> respostas) {
		this.respostas = respostas;
	}

	public Integer getCodigoAvaliacao() {
		return codigoAvaliacao;
	}

	public void setCodigoAvaliacao(Integer codigoAvaliacao) {
		this.codigoAvaliacao = codigoAvaliacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Resposta getRespostaSelecionada() {
		return respostaSelecionada;
	}

	public void setRespostaSelecionada(Resposta respostaSelecionada) {
		//this.respostaSelecionada = respostaSelecionada;
	}
	
}
