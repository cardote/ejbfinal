package br.com.fiap;

import java.util.List;

import br.com.fiap.common.Questao;

public interface Avaliacao {

   public List<Questao> obterQuestoes(int codigoAvaliacao);
   public void removerEJB();
}
