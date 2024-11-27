package modelo;
import interfaces.ObservadorDesempenho;

/**
 * @Brief: Classe responsável por monitorar e notificar mudanças no desempenho do aluno
 * @Details: Implementa o padrão de projeto Observador, permitindo a observação do desempenho dos alunos e a emissão de notificações com base na média calculada
 */
public class DesempenhoMonitor implements ObservadorDesempenho {
    /**
     * @Brief: Método que notifica o desempenho de um aluno com base na sua média
     * @Details: Exibe uma mensagem no console para parabenizar ou alertar o aluno sobre sua situação acadêmica, dependendo de sua média
     * @Parameter: nomeAluno Nome do aluno que teve o desempenho avaliado
     * @Parameter: media Média de desempenho do aluno
     */
    @Override
    public void notificarDesempenho(String nomeAluno, float media) {
        if (media >= 5) {
            System.out.println("Parabéns, " + nomeAluno + "! Você está com bom desempenho.");
        } else {
            System.out.println("Atenção, " + nomeAluno + ". Seu desempenho está abaixo do esperado.");
        }
    }
}
