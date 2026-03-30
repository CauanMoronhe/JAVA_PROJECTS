import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class terceiro_projeto_labAedII extends JFrame {

    FileInputStream arquivo;
    DataInputStream leitor;
    int caractere;
    String linha;

    ArrayList<String[]> dados = new ArrayList<>();
    int indice = 0;

    JTextField campoPais, campoCapital, campoFundacao;
    JButton botaoAnterior, botaoProximo;

    public terceiro_projeto_labAedII() {
        this.setLayout(null);
        this.setBounds(500, 300, 640, 300);
        this.setTitle("Navegador de Países");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        campoPais = new JTextField("");
        campoPais.setBounds(50, 50, 300, 25);

        campoCapital = new JTextField("");
        campoCapital.setBounds(50, 80, 300, 25);

        campoFundacao = new JTextField("");
        campoFundacao.setBounds(50, 110, 300, 25);

        botaoAnterior = new JButton("Anterior");
        botaoAnterior.setBounds(50, 160, 100, 30);

        botaoProximo = new JButton("Próximo");
        botaoProximo.setBounds(160, 160, 100, 30);

        this.add(campoPais);
        this.add(campoCapital);
        this.add(campoFundacao);
        this.add(botaoAnterior);
        this.add(botaoProximo);

        lerArquivo();
        mostrarRegistro(0);

        botaoAnterior.addActionListener(e -> {
            if (!dados.isEmpty()) {
                indice--;
                if (indice < 0) {
                    indice = dados.size() - 1; // circular
                }
                mostrarRegistro(indice);
            }
        });

        botaoProximo.addActionListener(e -> {
            if (!dados.isEmpty()) {
                indice++;
                if (indice >= dados.size()) {
                    indice = 0; // circular
                }
                mostrarRegistro(indice);
            }
        });
    }

    public void lerArquivo() {
        try {
            arquivo = new FileInputStream("C:/Users/Cauan Moronhe/Documents/GitHub/JAVA_PROJECTS/terceiro_projeto_labAedII/Paises.txt");
            leitor = new DataInputStream(arquivo);

            caractere = 0;
            linha = "";

            while (caractere != -1) {
                caractere = leitor.read();

                if (caractere != -1 && caractere != 10)
                    linha += (char) caractere;

                if (caractere == 10) {
                    String[] lista = linha.split(";");
                    dados.add(lista);
                    linha = "";
                }
            }

            arquivo.close();

        } catch (IOException erro) {
            System.out.println("Erro ao abrir arquivo...");
        }
    }

    public void mostrarRegistro(int i) {
        if (!dados.isEmpty()) {
            String[] reg = dados.get(i);

            campoPais.setText(reg[0]);
            campoCapital.setText(reg[1]);
            campoFundacao.setText(reg[2]);
        }
    }

    public static void main(String args[]) {
        terceiro_projeto_labAedII app = new terceiro_projeto_labAedII();
        app.setVisible(true);
    }
}