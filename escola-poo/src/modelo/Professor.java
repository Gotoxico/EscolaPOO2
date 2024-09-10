package modelo;
import java.util.ArrayList;

public class Professor extends Usuario {

    private String titulacao;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Turma> turmas;

    public Professor(){
        super();
        this.titulacao = "";
        this.disciplinas = new ArrayList<>();
        this.turmas = new ArrayList<>();
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
        return super.getId();
    }

    public void setID(String ID) {
        super.setId(ID);
    }

    public void adicionarDisciplina(Disciplina d){
        this.disciplinas.add(d);
    }

    public void adicionarProvaDisciplina(String nomeDisciplina, String nomeProva, String nomeTurma, float peso){
	Notas n = new Notas();
	n.adicionarProvaDisciplina(nomeDisciplina, this.nome, nomeProva, nomeTurma, peso);
    }

    public void adicionarTrabalhoDisciplina(String nomeDisciplina, String nomeTurma, String nomeTrabalho, float peso){
	Notas n = new Notas();
	n.adicionarTrabalhoDisciplina(nomeDisciplina, this.nome, nomeTurma, nomeTrabalho, peso);
    }

    public void adicionarPontoExtraDisciplina(String nomeDisciplina, String nomePontoExtra, String nomeTurma, float valorMaximo){
	Notas n = new Notas();
	n.adicionarPontoExtraDisciplina(nomeDisciplina, this.nome, nomePontoExtra, nomeTurma, valorMaximo);
    }

    public void adicionarNotaProva(String nomeAluno, String nomeDisciplina, String nomeProva, float notaProva, String nomeTurma){
	Notas n = new Notas();
	n.adicionarNotaProva(nomeAluno, nomeDisciplina, this.nome, nomeProva, notaProva, nomeTurma);
    }

    public void adicionarNotaTrabalho(String nomeAluno, String nomeDisciplina, String nomeTrabalho, float notaTrabalho, String nomeTurma){
	Notas n = new Notas();
	n.adicionarNotaTrabalho(nomeAluno, nomeDisciplina, this.nome, nomeTrabalho, notaTrabalho, nomeTurma);
    }

    public void adicionarNotaPontoExtra(String nomeAluno, String nomeDisciplina, String nomePontoExtra, String nomeTurma, float valor){
	Notas n = new Notas();
	n.adicionarNotaPontoExtra(nomeAluno, nomeDisciplina, this.nome, nomePontoExtra, nomeTurma, valor);
    }
    
    public void removerNotaProva(String nomeAluno, String nomeDisciplina, String nomeProva, float notaProva, String nomeTurma) {
        Notas n = new Notas();
        n.removerNotaProva(nomeAluno, nomeDisciplina, this.nome, nomeProva, notaProva, nomeTurma);
    }
    
    public void removerNotaTrabalho(String nomeAluno, String nomeDisciplina, String nomeTrabalho, float notaTrabalho, String nomeTurma){
        Notas n = new Notas();
        n.removerNotaTrabalho(nomeAluno, nomeDisciplina, this.nome, nomeTrabalho, notaTrabalho, nomeTurma);
    }
    
    public void removerNotaPontoExtra(String nomeAluno, String nomeDisciplina, String nomePontoExtra, String nomeTurma, float valor){
        Notas n = new Notas();
        n.removerNotaPontoExtra(nomeAluno, nomeDisciplina, this.nome, nomePontoExtra, nomeTurma, valor);
    }
}