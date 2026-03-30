package br.com.alura.screenmatch_project.modelos;

import br.com.alura.screenmatch_project.calculos.Classificacao;

public class Filme extends Titulo implements Classificacao {

    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    @Override
    public int getClassificacao() {
        return (int) calcularMediaAvaliacoes() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + "(" + this.getAnoDeLancamento() + ")";
    }
}
