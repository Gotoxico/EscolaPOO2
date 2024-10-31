package modelo;
import java.util.ArrayList;
import modelo.Output.OutputConsole;
import modelo.Output.OutputFactory;
import modelo.Output.OutputInterface;

public class Aluno extends Usuario{
    private OutputInterface output;
    private String matricula;
    private String curso;
    private ArrayList<Prova>provas;
    private ArrayList<Trabalho>trabalhos;
    private ArrayList<PontoExtra>pontosExtras;
    private float media;

    public Aluno(String nome, String id, String matricula, String curso, float media, String tipoOutput){
        super(nome, id);
        this.matricula = matricula;
        this.curso = curso;
        this.provas = new ArrayList<>();
        this.trabalhos = new ArrayList<>();
        this.pontosExtras = new ArrayList<>();
        this.media = media;
        this.output = OutputFactory.getTipoOutput(tipoOutput);
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

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
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
    
    

    public ArrayList<Prova> getProvas(){
        return provas;
    }

    public ArrayList<Trabalho> getTrabalhos(){
        return trabalhos;
    }

    public ArrayList<PontoExtra> getPontosExtras(){
        return pontosExtras;
    }

    /*
    public void adicionarProva(String nomeProva, double nota){
        if(nota >= 0 && nota <= 10){
            provas.add(nota);
        }else{
            if(output instanceof OutputConsole){
                System.out.println("Nota invalida, ela deve estar entre 0 e 10");
            }
        }
    }

    public void adicionarTrabalho(double nota){
        if(nota >= 0 && nota <= 10){
            trabalhos.add(nota);
        }else{
            if(output instanceof OutputConsole){
                System.out.println("Nota de trabalho invalida, ela deve estar entre 0 e 10");
            }
        }
    }

    public void adicionarPontoExtra(double nota){
        if(nota >= 0 && nota <= 10){
            pontosExtras.add(nota);
        }else{
            if(output instanceof OutputConsole){
                System.out.println("Nota de ponto extra invalida, ela deve estar entre 0 e 10");
            }
        }
    }*/

    public double calcularMedia(){
        double totalNotas = 0;
        int quantidadeNotas = 0;

        for(Prova prova : provas){
            totalNotas += prova.getNota();
            quantidadeNotas++;
        }

        for(Trabalho trabalho : trabalhos){
            totalNotas += trabalho.getNota();
            quantidadeNotas++;
        }

        for(PontoExtra pontoExtra : pontosExtras) {
            totalNotas += pontoExtra.getValor();
            quantidadeNotas++;
        }

        return quantidadeNotas > 0 ? totalNotas / quantidadeNotas : 0.0;
    }

    /*
    public void copiarNotasDisciplina(Disciplina disciplina){
        for(Prova prova : disciplina.getProvas()){
            adicionarProva(prova.getNota());
        }

        for(Trabalho trabalho : disciplina.getTrabalhos()){
            adicionarTrabalho(trabalho.getNota());
        }

        for(PontoExtra pontoExtra : disciplina.getPontosExtra()){
            adicionarPontoExtra(pontoExtra.getValor());
        }
    }*/

    public void exibirInfo(){
        if(output instanceof OutputConsole){
            System.out.println("Nome: " + getNome() + "\n" +
                "ID: " + getID()+ "\n" +
                "Matricula: " + matricula + "\n" +
                "Curso: " + curso + "\n" +
                "Provas: " + provas + "\n" +
                "Trabalhos: " + trabalhos + "\n" +
                "Pontos Extras: " + pontosExtras + "\n" +
                "Média: " + calcularMedia());
        }
    }
}
