import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        String jsonPessoa = """
                {
                    "nome": "Rodrigo",
                    "idade": 20,
                    "cidade": "Brasília",
                    "País": "Brasil"
                }
                """;

        Gson gson = new GsonBuilder().setLenient().create();
        Pessoa pessoa = gson.fromJson(jsonPessoa, Pessoa.class);

        System.out.println(pessoa);

        String jsonLivro = """
                {
                    "titulo": "Aventuras do Java",
                    "autor": "Akemi",
                    "editora": {
                        "nome": "TechBooks",
                        "cidade": "São Paulo"
                    }
                }
                """;

        Gson gsonLivro = new Gson();
        Livro livro = gsonLivro.fromJson(jsonLivro, Livro.class);

        System.out.println(livro);

        String jsonProduto = """
                {
                "numeroPedido": 1042,
                "cliente": "Carlos",
                "entregaExpressa": true,
                "produto": {
                    "nome": "Teclado Mecânico",
                    "preco": 349.90,
                    "categoria": "Periféricos",
                    "emEstoque": true,
                    "codigoPromocional": "TECH20"
                    }
                }""";

        Gson gsonPedido = new Gson();
        Pedido produto1 = gsonPedido.fromJson(jsonProduto, Pedido.class);

        System.out.println(produto1);
    }
}