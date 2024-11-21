package modelo;
//Classe Aluno: Classe base com atributos como matricula, curso.
import interfaces.ObservadorDesempenho;
//Padrão de Projeto: Observador
//Enxerga as outras classes e notifica mudança de estado ("Big Brother").
// Implementação de um observador que monitora e notifica o desempenho do aluno
public class DesempenhoMonitor implements ObservadorDesempenho {
    @Override
    public void notificarDesempenho(String nomeAluno, float media) {
        if (media >= 5) {
            System.out.println("Parabéns, " + nomeAluno + "! Você está com bom desempenho.");
        } else {
            System.out.println("Atenção, " + nomeAluno + ". Seu desempenho está abaixo do esperado.");
        }
    }
}
