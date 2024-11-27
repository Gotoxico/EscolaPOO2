package modelo;
import interfaces.CalculoMediaStrategy;
import java.util.ArrayList;
/**
 * @Brief: Implementação da estratégia de cálculo de média aritmética
 * @Details: Esta classe implementa a interface `CalculoMediaStrategy` para calcular a média aritmética com base nas notas de provas, trabalhos e pontos extras
 */
public class MediaAritmeticaStrategy implements CalculoMediaStrategy {
    /**
     * @Brief: Calcula a média aritmética de provas, trabalhos e pontos extras
     * @Details: Soma as notas de todas as provas, trabalhos e valores de pontos extras, e divide pelo número total de itens avaliados
     * @Parameter: provas Lista de provas com suas respectivas notas
     * @Parameter: trabalhos Lista de trabalhos com suas respectivas notas
     * @Parameter: pontosExtras Lista de pontos extras com seus respectivos valores
     * @Return: Média aritmética das notas ou 0 se não houver itens avaliados
     */
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
