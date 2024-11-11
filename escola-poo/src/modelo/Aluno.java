package modelo;
//Classe Aluno: Classe base com atributos como matricula, curso.
import java.util.ArrayList;
import modelo.Output.OutputConsole;
import modelo.Output.OutputFactory;
import modelo.Output.OutputInterface;
import interfaces.media;


//Padrão de Projeto: Strategy
//Parametriza os algoritmos usado em um classe, ou seja, tem-se uma família de algoritmos usados por uma classe e o usuário escolhe o melhor para ele. (A estratégia que será usada é escolha do usuário.)
//Interface para a estratégia de cálculo de média
interface CalculoMediaStrategy {
    float calcularMedia(ArrayList<Prova> provas, ArrayList<Trabalho> trabalhos, ArrayList<PontoExtra> pontosExtras);
}

//Implementação da média aritmética como uma estratégia
class MediaAritmeticaStrategy implements CalculoMediaStrategy {
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
            soma += pontoExtra.getNota();
            count++;
        }
        return count > 0 ? soma / count : 0;
    }
}

// Interface para observar desempenho do aluno
interface ObservadorDesempenho {
    void notificarDesempenho(String nomeAluno, float media);
}

//Padrão de Projeto: Observador
//Enxerga as outras classes e notifica mudança de estado. ("Big Brother").
// Implementação de um observador que monitora e notifica o desempenho do aluno
class DesempenhoMonitor implements ObservadorDesempenho {
    @Override
    public void notificarDesempenho(String nomeAluno, float media) {
        if (media >= 5) {
            System.out.println("Parabéns, " + nomeAluno + "! Você está com bom desempenho.");
        } else {
            System.out.println("Atenção, " + nomeAluno + ". Seu desempenho está abaixo do esperado.");
        }
    }
}

public class Aluno extends Usuario implements media {
    private final OutputInterface output;
    private String matricula;
    private String curso;
    private ArrayList<Prova> provas;
    private ArrayList<Trabalho> trabalhos;
    private ArrayList<PontoExtra> pontosExtras;
    private CalculoMediaStrategy calculoMediaStrategy;
    private ObservadorDesempenho monitor;

    //Construtor da classe Aluno que recebe uma fábrica de saída, dados do aluno e tipo de saída
    //Fábrica pra criação de tipos de saída
    public Aluno(OutputFactory outputFactory, String nome, String id, String matricula, String curso, String tipoOutput) {
        super(nome, id); //Nome e id do aluno
        this.matricula = matricula; //matrícula do aluno
        this.curso = curso; //Curso em que o aluno está matriculado
        this.provas = new ArrayList<>();
        this.trabalhos = new ArrayList<>();
        this.pontosExtras = new ArrayList<>();
        this.output = outputFactory.getTipoOutput(tipoOutput); //Tipo de saída desejada
        this.calculoMediaStrategy = new MediaAritmeticaStrategy(); // Estratégia padrão
        this.monitor = new DesempenhoMonitor(); // Inicializa o monitor de desempenho
    }

    //Encapsulamento para matrícula e curso
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public void setNotaProva(Prova prova){
        provas.add(prova);
    }
    
    public void setNotaTrabalho(Trabalho trabalho){
        trabalhos.add(trabalho);
    }
    
    public void setNotaPontoExtra(PontoExtra pontoExtra){
        pontosExtras.add(pontoExtra);
    }
    
    public void removerNotaProva(Prova prova){
        provas.remove(prova);
    }
    
    public void removerNotaTrabalho(Trabalho trabalho){
        trabalhos.remove(trabalho);
    }
    
    public void removerNotaPontoExtra(PontoExtra pontoExtra){
        pontosExtras.remove(pontoExtra);
    }

    //Estratégia de cálculo de média
    public void setCalculoMediaStrategy(CalculoMediaStrategy calculoMediaStrategy) {
        this.calculoMediaStrategy = calculoMediaStrategy;
    }

    //Calcula a média com base na estratégia atual
    public float calcularMedia() {
        float media = calculoMediaStrategy.calcularMedia(provas, trabalhos, pontosExtras);
        //Notifica sempre que a média é recalculada
        monitor.notificarDesempenho(getNome(), media);
        return media;
    }

    //Apresenta as informações do aluno
    //Usa output configurado
    public void mostrarAluno() {
        output.exibirInfo("\nNome do aluno: " + getNome() +
                          "\nCurso: " + curso +
                          "\nMatricula: " + matricula +
                          "\nCurso: " + curso + "\n" +
                          "\nProvas: " + provas + "\n" +
                          "\nTrabalhos: " + trabalhos + "\n" +
                          "\nPontos Extras: " + pontosExtras + "\n" +
                          "\nMedia: " + calcularMedia());
    }
}
