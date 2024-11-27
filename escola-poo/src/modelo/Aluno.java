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

    /**
     * @Brief: Construtor da classe Aluno que inicializa os dados básicos do aluno e configura o tipo de saída desejado
     * @Parameter: outputFactory Fábrica para criar tipos de saída
     * @Parameter: nome Nome do aluno
     * @Parameter: id Identificador do aluno
     * @Parameter: matricula Matrícula do aluno
     * @Parameter: curso Curso em que o aluno está matriculado
     * @Parameter: tipoOutput Tipo de saída desejada
     */
    public Aluno(OutputFactory outputFactory, String nome, String id, String matricula, String curso, String tipoOutput) {
        super(nome, id); 
        this.matricula = matricula; 
        this.curso = curso; 
        this.provas = new ArrayList<>();
        this.trabalhos = new ArrayList<>();
        this.pontosExtras = new ArrayList<>();
        this.output = outputFactory.getTipoOutput(tipoOutput); 
        this.calculoMediaStrategy = new MediaAritmeticaStrategy(); 
        this.monitor = new DesempenhoMonitor(); 
        this.atividadesExtrasCurriculares = new ArrayList<>();
    }

    /**
     * @Brief: Obtém a matrícula do aluno
     * @Return: Matrícula do aluno
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @Brief: Define a matrícula do aluno
     * @Parameter: matricula Matrícula do aluno
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @Brief: Obtém o curso do aluno
     * @Return: Nome do curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @Brief: Define o curso do aluno
     * @Parameter: curso Nome do curso
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    /**
     * @Brief: Obtém as atividades extracurriculares do aluno
     * @Return: Lista de atividades extracurriculares
     */
    public ArrayList<AtividadeExtra> getAtividadesExtra(){
        return atividadesExtrasCurriculares;
    }

    /**
     * @Brief: Adiciona uma prova ao aluno
     * @Parameter: prova Objeto representando a prova
     */
    public void setNotaProva(Prova prova) {
        provas.add(prova);
    }

    /**
     * @Brief: Adiciona um trabalho ao aluno
     * @Parameter: trabalho Objeto representando o trabalho
     */
    public void setNotaTrabalho(Trabalho trabalho) {
        trabalhos.add(trabalho);
    }

    /**
     * @Brief: Adiciona um ponto extra ao aluno
     * @Parameter: pontoExtra Objeto representando o ponto extra
     */
    public void setNotaPontoExtra(PontoExtra pontoExtra) {
        pontosExtras.add(pontoExtra);
    }

    /**
     * @Brief: Remove uma prova do aluno
     * @Parameter: prova Objeto representando a prova
     */
    public void removerNotaProva(Prova prova) {
        provas.remove(prova);
    }

    /**
     * @Brief: Remove um trabalho do aluno
     * @Parameter: trabalho Objeto representando o trabalho
     */
    public void removerNotaTrabalho(Trabalho trabalho) {
        trabalhos.remove(trabalho);
    }

    /**
     * @Brief: Remove um ponto extra do aluno
     * @Parameter: pontoExtra Objeto representando o ponto extra
     */
    public void removerNotaPontoExtra(PontoExtra pontoExtra) {
        pontosExtras.remove(pontoExtra);
    }

    /**
     * @Brief: Define a estratégia de cálculo de média para o aluno
     * @Parameter: calculoMediaStrategy Objeto implementando a interface de cálculo de média
     */
    public void setCalculoMediaStrategy(CalculoMediaStrategy calculoMediaStrategy) {
        this.calculoMediaStrategy = calculoMediaStrategy;
    }

    /**
     * @Brief: Calcula a média com base na estratégia definida
     * @Return: Média calculada
     */
    public float calcularMedia() {
        float media = calculoMediaStrategy.calcularMedia(provas, trabalhos, pontosExtras);
        monitor.notificarDesempenho(getNome(), media);
        return media;
    }

    /**
     * @Brief: Adiciona uma atividade extracurricular ao aluno
     * @Parameter: atividadeExtra Objeto representando a atividade extracurricular
     */
    public void addAtividadeExtra(AtividadeExtra atividadeExtra) {
        atividadesExtrasCurriculares.add(atividadeExtra);
    }
    
    /**
     * @Brief: Remove uma atividade extracurricular do aluno
     * @Parameter: atividadeExtra Objeto representando a atividade extracurricular
     */
    public void removerAtividadeExtra(AtividadeExtra atividadeExtra) {
        atividadesExtrasCurriculares.remove(atividadeExtra);
    }

    /**
     * @Brief: Exibe as informações completas do aluno
     */
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
