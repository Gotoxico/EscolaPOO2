package modelo;
//Classe Aluno: Classe base com atributos como matricula, curso.
import java.util.ArrayList;
import modelo.Output.OutputConsole;
import modelo.Output.OutputFactory;
import modelo.Output.OutputInterface;
import interfaces.media;
import interfaces.CalculoMediaStrategy;
import interfaces.ObservadorDesempenho;

public class Aluno extends Usuario {
    private final OutputInterface output;
    private String matricula;
    private String curso;
    private ArrayList<Prova> provas;
    private ArrayList<Trabalho> trabalhos;
    private ArrayList<PontoExtra> pontosExtras;
    private CalculoMediaStrategy calculoMediaStrategy;
    private ObservadorDesempenho monitor;
    private ArrayList<AtividadeExtra> atividadesExtrasCurriculares;

    //Construtor da classe Aluno que recebe uma fábrica de saída, dados do aluno e tipo de saída
    //Fábrica pra criação de tipos de saída
    public Aluno(OutputFactory outputFactory, String nome, String id, String matricula, String curso, String tipoOutput) {
        super(nome, id); //Nome e id do aluno
        this.matricula = matricula; //Matrícula do aluno
        this.curso = curso; //Curso em que o aluno está matriculado
        this.provas = new ArrayList<>();
        this.trabalhos = new ArrayList<>();
        this.pontosExtras = new ArrayList<>();
        this.output = outputFactory.getTipoOutput(tipoOutput); //Tipo de saída desejada
        this.calculoMediaStrategy = new MediaAritmeticaStrategy(); //Estratégia padrão
        this.monitor = new DesempenhoMonitor(); //Inicializa o monitor de desempenho
        this.atividadesExtrasCurriculares = new ArrayList<>();
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
    
    public ArrayList<AtividadeExtra> getAtividadesExtra(){
        return atividadesExtrasCurriculares;
    }

    public void setNotaProva(Prova prova) {
        provas.add(prova);
    }

    public void setNotaTrabalho(Trabalho trabalho) {
        trabalhos.add(trabalho);
    }

    public void setNotaPontoExtra(PontoExtra pontoExtra) {
        pontosExtras.add(pontoExtra);
    }

    public void removerNotaProva(Prova prova) {
        provas.remove(prova);
    }

    public void removerNotaTrabalho(Trabalho trabalho) {
        trabalhos.remove(trabalho);
    }

    public void removerNotaPontoExtra(PontoExtra pontoExtra) {
        pontosExtras.remove(pontoExtra);
    }

    //Estratégia de cálculo de média
    public void setCalculoMediaStrategy(CalculoMediaStrategy calculoMediaStrategy) {
        this.calculoMediaStrategy = calculoMediaStrategy;
    }

    //Calcula a média com base na estratégia atual
    public float calcularMedia() {
        float media = calculoMediaStrategy.calcularMedia(provas, trabalhos, pontosExtras);
        monitor.notificarDesempenho(getNome(), media);
        return media;
    }

    /**
     * Adiciona uma atividade extra ao aluno
     * @param atividadeExtra
     */
    public void addAtividadeExtra(AtividadeExtra atividadeExtra) {
        atividadesExtrasCurriculares.add(atividadeExtra);
    }
    
    public void removerAtividadeExtra(AtividadeExtra atividadeExtra) {
        atividadesExtrasCurriculares.remove(atividadeExtra);
    }

    //Apresenta as informações do aluno
    public void mostrarAluno() {
        output.display("\nNome do aluno: " + getNome() +
                          "\nCurso: " + curso +
                          "\nMatricula: " + matricula +
                          "\nCurso: " + curso + "\n" +
                          "\nProvas: " + provas + "\n" +
                          "\nTrabalhos: " + trabalhos + "\n" +
                          "\nPontos Extras: " + pontosExtras + "\n" +
                          "\nMedia: " + calcularMedia());
    }
}
