package br.com.alura.screenmatch_project.principal;

import br.com.alura.screenmatch_project.api.OmdbClient;
import br.com.alura.screenmatch_project.config.GsonConfig;
import br.com.alura.screenmatch_project.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch_project.modelos.Titulo;
import br.com.alura.screenmatch_project.modelos.TituloOmdb;
import br.com.alura.screenmatch_project.repositorio.TituloRepositorio;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        Gson gson = GsonConfig.criar();
        OmdbClient omdbClient = new OmdbClient();
        TituloRepositorio repositorio = new TituloRepositorio();
        List<Titulo> listaDeTitulos = new ArrayList<>();

        String busca;
        do {
            System.out.print("Digite um filme para busca (ou 'sair'): ");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")) break;

            try {
                String json = omdbClient.buscar(busca);
                TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
                Titulo titulo = new Titulo(tituloOmdb);
                listaDeTitulos.add(titulo);
                System.out.println("Encontrado: " + titulo);
            } catch (NumberFormatException e) {
                System.out.println("Erro ao converter dado numérico: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Argumento inválido: " + e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println("Erro de conversão de ano: " + e.getMessage());
            }

        } while (true);

        System.out.println("Títulos encontrados: " + listaDeTitulos);
        repositorio.salvarComoJson(listaDeTitulos, "filmes.json");

        leitura.close();
    }
}