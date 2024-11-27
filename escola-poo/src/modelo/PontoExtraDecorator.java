package modelo;

import interfaces.Avaliacao;
/**
 * @Brief: Decorador para adicionar pontos extras a uma avaliação
 * @Details: Implementa o padrão de projeto Decorator para permitir a adição de valores extras a uma avaliação existente
 */
public class PontoExtraDecorator implements Avaliacao {
    private Avaliacao avaliacao;
    private PontoExtra pontoExtra;
    /**
     * @Brief: Construtor da classe PontoExtraDecorator
     * @Details: Inicializa o decorador com uma avaliação e um ponto extra
     * @Parameter: avaliacao Avaliação original que será decorada
     * @Parameter: pontoExtra Objeto contendo o valor do ponto extra
     */
    public PontoExtraDecorator(Avaliacao avaliacao, PontoExtra pontoExtra) {
        this.avaliacao = avaliacao;
        this.pontoExtra = pontoExtra;
    }

    /**
     * @Brief: Calcula a nota total da avaliação incluindo o ponto extra
     * @Details: Soma a nota da avaliação original ao valor do ponto extra
     * @Return: Nota total da avaliação após a aplicação do ponto extra
     */
    @Override
    public double calcularNota() {
        return avaliacao.calcularNota() + pontoExtra.getValor();
    }
}
