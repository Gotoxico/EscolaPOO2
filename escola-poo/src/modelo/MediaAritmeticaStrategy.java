package modelo;
//Classe Aluno: Classe base com atributos como matricula, curso.
import interface.CalculoMediaStrategy;
import java.util.ArrayList;
//Implementação da média aritmética como uma estratégia
public class MediaAritmeticaStrategy implements CalculoMediaStrategy {
    @Override
    public float calcularMedia(ArrayList<Prova> provas, ArrayList<Trabalho> trabalhos, ArrayList<PontoExtra> pontosExtras) {
        float soma = 0;
        int count = 0;
        for (Prova prova : provas) {
            soma += prova.getNota();
            count++;
        }
        for (Trabalho trabalho : trabalhos) {
            soma += trabalho.getNota();
            count++;
        }
        for (PontoExtra pontoExtra : pontosExtras) {
            soma += pontoExtra.getValor();
            count++;
        }
        return count > 0 ? soma / count : 0;
    }
}
