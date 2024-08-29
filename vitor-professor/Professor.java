// Adicionar imports para Disciplina e Turma
import java.util.ArrayList;

public class Professor extends Usuario {
    // Nao necessita mais do nome e ID por extender Usuario
    // private String nome;
    // private String ID;
    private String titulacao;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Turma> turmas;

    public Professor(){
        super();
        this.titulacao = "";
        this.disciplinas = new ArrayList<>;
        this.turmas = new ArrayList<>;
    }

    public Professor(String nome, String ID, String titulacao, ArrayList<Disciplina> disciplinas, ArrayList<Turma> turmas){
        super(nome, ID);
        this.titulacao = titulacao;
        this.disciplinas = disciplinas;
        this.turmas = turmas;
    }
    
    public String getTitulacao(){
        return this.titulacao;
    }
    
    public void setTitulacao(String titulacao){
        this.titulacao = titulacao;
    }
    
    public ArrayList<Turma> getTurmas(){
        return this.turmas;
    }
    
    public void setTurmas(ArrayList<Turma> turmas){
        this.turmas = turmas;
    }
    
    public ArrayList<Disciplina> getDisciplina(){
        return this.disciplinas;
    }
    
    public void setDisciplina(ArrayList<Disciplina> disciplinas){
        this.disciplinas = disciplinas;
    }

    public String getNome() {
        return super.getNome();
    }

    public void setNome(String nome) {
        super.setNome(nome);
    }

    public String getID() {
        return super.getID();
    }

    public void setID(String ID) {
        super.setID(ID);
    }

    public void adicionarDisciplina(Disciplina d){
        this.disciplinas.add(d);
    }
}
