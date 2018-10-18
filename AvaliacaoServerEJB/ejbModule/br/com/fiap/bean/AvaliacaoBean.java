package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fiap.Avaliacao;
import br.com.fiap.common.Questao;

//@CacheConfig(maxSize=50, idleTimeoutSeconds=60, removalTimeoutSeconds=360)
@Stateless
@WebService
@Remote
public class AvaliacaoBean implements Avaliacao {
	
	@PersistenceContext(unitName = "AvaliacaoDS")
    private EntityManager entityManager;
	
 
    public AvaliacaoBean() {
 
    }
    

    @WebMethod
	public List<Questao> obterQuestoes(int codigoAvaliacao) {
		Questao questao = new Questao();
		List<Questao> lista = new ArrayList<Questao>();
		
		
		questao = entityManager.find(Questao.class, codigoAvaliacao);
		
		System.out.println("Usuário conectado!");
		lista.add(questao);
		return lista;
	}

	public void removerEJB() {
		// TODO Auto-generated method stub
		
	}
	
	

}
