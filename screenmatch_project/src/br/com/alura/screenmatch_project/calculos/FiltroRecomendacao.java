package br.com.alura.screenmatch_project.calculos;

public class FiltroRecomendacao {

    public void filtrar(Classificacao classficacao) {
        if (classficacao.getClassificacao() >= 4) {
            System.out.println("Está entre os preferidos do momento!");
        } else if (classficacao.getClassificacao() >= 2) {
            System.out.println("Muito bem avaliado no momento!");
        } else {
            System.out.println("Coloque na sua lista para assistir mais tarde");
        }
    }
}
