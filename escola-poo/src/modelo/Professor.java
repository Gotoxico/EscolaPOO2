package modelo;
import java.util.ArrayList;

public class Professor extends Usuario {

    private String titulacao;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Turma> turmas;
    private Notas notas;

    public Professor(){
        super();
        this.titulacao = "";
        this.disciplinas = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.notas = null;
    }

    public Professor(String nome, String ID, String titulacao, ArrayList<Disciplina> disciplinas, ArrayList<Turma> turmas, Notas notas){
        super(nome, ID);
        this.titulacao = titulacao;
        this.disciplinas = disciplinas;
        this.turmas = turmas;
        this.notas = notas;
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

    public Notas getNotas() {
        return notas;
    }

    public void setNotas(Notas notas) {
        this.notas = notas;
    }

    public void adicionarDisciplina(Disciplina d){
        this.disciplinas.add(d);
    }

    public void adicionarProvaDisciplina(String nomeDisciplina, String nomeProva, String nomeTurma, float peso){
	notas.adicionarProvaDisciplina(nomeDisciplina, this.nome, nomeProva, nomeTurma, peso);
    }

    public void adicionarTrabalhoDisciplina(String nomeDisciplina, String nomeTurma, String nomeTrabalho, float peso){
	notas.adicionarTrabalhoDisciplina(nomeDisciplina, this.nome, nomeTurma, nomeTrabalho, peso);
    }

    public void adicionarPontoExtraDisciplina(String nomeDisciplina, String nomePontoExtra, String nomeTurma, float valorMaximo){
	notas.adicionarPontoExtraDisciplina(nomeDisciplina, this.nome, nomePontoExtra, nomeTurma, valorMaximo);
    }

    public void adicionarNotaProva(String nomeAluno, String nomeDisciplina, String nomeProva, float notaProva, String nomeTurma){
	notas.adicionarNotaProva(nomeAluno, nomeDisciplina, this.nome, nomeProva, notaProva, nomeTurma);
    }

    public void adicionarNotaTrabalho(String nomeAluno, String nomeDisciplina, String nomeTrabalho, float notaTrabalho, String nomeTurma){
	notas.adicionarNotaTrabalho(nomeAluno, nomeDisciplina, this.nome, nomeTrabalho, notaTrabalho, nomeTurma);
    }

    public void adicionarNotaPontoExtra(String nomeAluno, String nomeDisciplina, String nomePontoExtra, String nomeTurma, float valor){
	notas.adicionarNotaPontoExtra(nomeAluno, nomeDisciplina, this.nome, nomePontoExtra, nomeTurma, valor);
    }
    
    /**
     * 
     * @return 
     */
    public float mediaProfessor(){
        int totalDisciplinas = disciplinas.size();
        float somaMedias = 0;
        
        for(Disciplina disciplina : disciplinas){
            somaMedias += disciplina.calcularMedia();
        }
        return somaMedias/totalDisciplinas;
    }
}