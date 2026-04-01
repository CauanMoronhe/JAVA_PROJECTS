package br.com.alura.screenmatch_project.repositorio;

import br.com.alura.screenmatch_project.config.GsonConfig;
import br.com.alura.screenmatch_project.modelos.Titulo;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TituloRepositorio {
    private final Gson gson = GsonConfig.criar();

    public void salvarComoJson(List<Titulo> titulos, String arquivo) throws IOException {
        try(FileWriter escrita = new FileWriter(arquivo)) {
            escrita.write(gson.toJson(titulos));
        }
    }
}
