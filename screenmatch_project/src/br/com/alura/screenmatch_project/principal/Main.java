package br.com.alura.screenmatch_project.principal;

import br.com.alura.screenmatch_project.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch_project.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch_project.modelos.Episodio;
import br.com.alura.screenmatch_project.modelos.Filme;
import br.com.alura.screenmatch_project.modelos.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        var meuFilme = new Filme("Operation Big Hero", 2015);
        meuFilme.setIncluidoNoPlano(true);
        meuFilme.exibeFichaTecnica();
        meuFilme.avaliar(8.5);
        meuFilme.avaliar(9.0);
        meuFilme.avaliar(3.0);

        System.out.println(String.format("Média de avaliações do filme: %.2f", meuFilme.calcularMediaAvaliacoes()));

        var novaSerie = new Serie("Ladybug", 2015);
        novaSerie.setIncluidoNoPlano(true);
        novaSerie.exibeFichaTecnica();
        novaSerie.setTotalTemporadas(6);
        novaSerie.setEpisodiosPorTemporada(25);
        novaSerie.setMinutosPorEpisodio(30);

        System.out.println("Tempo necessário para maratonar a série: " + novaSerie.getDuracaoEmMinutos());

        var outroFilme = new Filme("Shrek", 2001);

        var calc = new CalculadoraDeTempo();
        calc.adiciona(meuFilme);
        calc.adiciona(outroFilme);
        calc.adiciona(novaSerie);
        System.out.println(calc.getTempoTotal());

        var filtro = new FiltroRecomendacao();
        filtro.filtrar(meuFilme);

        var episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(novaSerie);
        episodio.setTotalVisualizacoes(300);
        filtro.filtrar(episodio);
        filtro.filtrar(episodio);

        var filmeDoCauan = new Filme("Legalmente loira", 2003);
        filmeDoCauan.setDuracaoEmMinutos(30);
        filmeDoCauan.avaliar(8.5);

         ArrayList<Filme> listaDeFilmes = new ArrayList<>();
         listaDeFilmes.add(filmeDoCauan);
         listaDeFilmes.add(meuFilme);
         listaDeFilmes.add(outroFilme);
        System.out.println("Tamanho da lista de filmes: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("to String Primeiro filme: " + listaDeFilmes.get(0).toString());

        
    }
}