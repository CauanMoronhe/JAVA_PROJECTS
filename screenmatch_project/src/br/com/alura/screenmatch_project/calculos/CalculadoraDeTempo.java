package br.com.alura.screenmatch_project.calculos;
import br.com.alura.screenmatch_project.modelos.Titulo;

public class CalculadoraDeTempo{

    private int tempoTotal;

    public int getTempoTotal(){
        return this.tempoTotal;
    }

    public void adiciona(Titulo titulo){
        System.out.println("Adicionando duração em minutos de: " + titulo);
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
