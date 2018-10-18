package br.com.fiap.ejb3.cliente;

import java.net.UnknownHostException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.Avaliacao;
import br.com.fiap.common.Questao;
import br.com.fiap.common.Resposta;

public class AvaliacaoCliente {

	private static Properties props;
	private static Context context;
	private static Avaliacao avaliacao;

	public static void main(String[] args) throws NamingException, UnknownHostException {

		props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");

		context = new InitialContext(props);

		avaliacao = (Avaliacao) context.lookup("AvaliacaoBean/remote");

		mostraQuestao(1);
		mostraQuestao(2);

	}

	private static void mostraQuestao(int codigo) {
		Questao questao = new Questao();

		questao = (Questao) avaliacao.obterQuestoes(codigo).get(0);
		System.out.println(codigo + " - " + questao.getDescricao());
		System.out.println();

		Collection<Resposta> myCollection = new HashSet<Resposta>();

		myCollection = questao.getRespostas();

		int i = 1;
		for (Resposta elem : myCollection) {
			System.out.println(i + " - " + elem.getDescricao());
			i++;
		}
		System.out.println();
		System.out.println();
	}

}
