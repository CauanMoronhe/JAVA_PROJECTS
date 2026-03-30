package br.com.alura.screenmatch_project.principal;

import br.com.alura.screenmatch_project.modelos.Filme;
import br.com.alura.screenmatch_project.modelos.Serie;
import br.com.alura.screenmatch_project.modelos.Titulo;

import java.util.*;

public class MainListas {
    public static void main(String[] args) {
        var meuFilme = new Filme("Operation Big Hero", 2015);
        meuFilme.avaliar(10);
        var outroFilme = new Filme("Shrek", 2001);
        outroFilme.avaliar(7);
        var filmeDoCauan = new Filme("Legalmente loira", 2003);
        filmeDoCauan.avaliar(8);
        var novaSerie = new Serie("Ladybug", 2015);

        List<Titulo> listaDeAssistidos = new LinkedList<>();
        listaDeAssistidos.add(filmeDoCauan);
        listaDeAssistidos.add(meuFilme);
        listaDeAssistidos.add(outroFilme);
        listaDeAssistidos.add(novaSerie);

        for (Titulo item : listaDeAssistidos) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Thiago Ventura");
        buscaPorArtista.add("Jake Peralta");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        Collections.sort(listaDeAssistidos);
        System.out.println("Lista de titulos ordenados");
        System.out.println(listaDeAssistidos);
        listaDeAssistidos.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Lista de titulos ordenados por ano");
        System.out.println(listaDeAssistidos);
    }
}
