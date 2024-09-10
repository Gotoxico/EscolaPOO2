package modelo;
import java.util.ArrayList;

public class Aluno extends Usuario{
    private String matricula;
    private String curso;
    private ArrayList<Double>provas;
    private ArrayList<Double>trabalhos;
    private ArrayList<Double>pontosExtras;

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

    public ArrayList<Double> getProvas(){
        return provas;
    }

    public ArrayList<Double> getTrabalhos(){
        return trabalhos;
    }

    public ArrayList<Double> getPontosExtras(){
        return pontosExtras;
    }

    public void adicionarProva(double nota){
        if(nota >= 0 && nota <= 10){
            provas.add(nota);
        }else{
            System.out.println("Nota invalida, ela deve estar entre 0 e 10");
        }
    }

    public void adicionarTrabalho(double nota){
        if(nota >= 0 && nota <= 10){
            trabalhos.add(nota);
        }else{
            System.out.println("Nota de trabalho invalida, ela deve estar entre 0 e 10");
        }
    }

    public void adicionarPontoExtra(double nota){
        if(nota >= 0 && nota <= 10){
            pontosExtras.add(nota);
        }else{
            System.out.println("Nota de ponto extra invalida, ela deve estar entre 0 e 10");
        }
    }

    public double calcularMedia(){
        double totalNotas = 0;
        int quantidadeNotas = 0;

        for(double nota : provas){
            totalNotas += nota;
            quantidadeNotas++;
        }

        for(double nota : trabalhos){
            totalNotas += nota;
            quantidadeNotas++;
        }

        for(double nota : pontosExtras) {
            totalNotas += nota;
            quantidadeNotas++;
        }

        return quantidadeNotas > 0 ? totalNotas / quantidadeNotas : 0.0;
    }

    public void copiarNotasDisciplina(Disciplina disciplina){
        for(Prova prova : disciplina.getProvas()){
            adicionarProva(prova.getNota());
        }

        for(Trabalho trabalho : disciplina.getTrabalhos()){
            adicionarTrabalho(trabalho.getNota());
        }

        for(PontoExtra pontoExtra : disciplina.getPontosExtra()){
            adicionarPontoExtra(pontoExtra.getNota());
        }
    }

    public void exibirInfo(){
        System.out.println("Nome: " + getNome() + "\n" +
            "ID: " + getId() + "\n" +
            "Matricula: " + matricula + "\n" +
            "Curso: " + curso + "\n" +
            "Provas: " + provas + "\n" +
            "Trabalhos: " + trabalhos + "\n" +
            "Pontos Extras: " + pontosExtras + "\n" +
            "Média: " + calcularMedia());
    }
}
