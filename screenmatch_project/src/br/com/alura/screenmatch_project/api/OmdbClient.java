package br.com.alura.screenmatch_project.api;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class OmdbClient {
    private static final String API_KEY = "ebe38e13";
    private static final String BASE_URL = "https://www.omdbapi.com/?t=";

    private final HttpClient client = HttpClient.newHttpClient();

    public String buscar(String titulo) throws IOException, InterruptedException {
        String tituloCodificado = URLEncoder.encode(titulo, StandardCharsets.UTF_8);
        String endereco = BASE_URL + tituloCodificado + "&apikey=" + API_KEY;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
}
