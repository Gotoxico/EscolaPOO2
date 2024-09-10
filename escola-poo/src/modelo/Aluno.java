package modelo;
import java.util.ArrayList;

public class Aluno extends Usuario{
    private String matricula;
    private String curso;
    private ArrayList<String> provas;
    private ArrayList<String> trabalhos;
    private ArrayList<String> pontosExtras;

    public Aluno(String nome, String id, String matricula, String curso){
        super(nome, id);
        this.matricula = matricula;
        this.curso = curso;
        this.provas = new ArrayList<>();
        this.trabalhos = new ArrayList<>();
        this.pontosExtras = new ArrayList<>();
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getCurso(){
        return curso;
    }

    public void setCurso(String curso){
        this.curso = curso;
    }

    public ArrayList<String> getProvas(){
        return provas;
    }

    public ArrayList<String> getTrabalhos(){
        return trabalhos;
    }

    public ArrayList<String> getPontosExtras(){
        return pontosExtras;
    }

    public void adicionarProva(String prova){
        provas.add(prova);
    }

    public void adicionarTrabalho(String trabalho){
        trabalhos.add(trabalho);
    }

    public void adicionarPontoExtra(String pontoExtra){
        pontosExtras.add(pontoExtra);
    }

    public void exibirInfo(){
        System.out.println("Nome: " + getNome());
        System.out.println("ID: " + getId());
        System.out.println("Matricula: " + matricula);
        System.out.println("Curso: " + curso);
        System.out.println("Provas: " + provas);
        System.out.println("Trabalhos: " + trabalhos);
        System.out.println("Pontos Extras: " + pontosExtras);
    }
}
