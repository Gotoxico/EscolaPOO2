package modelo;
import java.util.ArrayList;

/**
 * @Brief: Representa um professor no sistema acadêmico
 * @Details: Extende a classe Usuario, adicionando atributos e métodos específicos para um professor
 */
public class Professor extends Usuario {

    private String titulacao;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Turma> turmas;
    private Notas notas;

    /**
     * @Brief: Construtor padrão da classe Professor
     * @Details: Inicializa os atributos com valores padrão
     */
    public Professor(){
        super();
        this.titulacao = "";
        this.disciplinas = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.notas = null;
    }

    /**
     * @Brief: Construtor da classe Professor com parâmetros
     * @Parameter: nome Nome do professor
     * @Parameter: ID Identificador único do professor
     * @Parameter: titulacao Titulação do professor
     * @Parameter: disciplinas Lista de disciplinas associadas ao professor
     * @Parameter: turmas Lista de turmas associadas ao professor
     * @Parameter: notas Objeto de controle de notas do professor
     */
    public Professor(String nome, String ID, String titulacao, ArrayList<Disciplina> disciplinas, ArrayList<Turma> turmas, Notas notas){
        super(nome, ID);
        this.titulacao = titulacao;
        this.disciplinas = disciplinas;
        this.turmas = turmas;
        this.notas = notas;
    }

    /**
     * @Brief: Obtem a titulação do professor
     * @Return: Titulação do professor
     */
    public String getTitulacao(){
        return this.titulacao;
    }

    /**
     * @Brief: Define a titulação do professor
     * @Parameter: titulacao Nova titulação do professor
     */
    public void setTitulacao(String titulacao){
        this.titulacao = titulacao;
    }

    /**
     * @Brief: Obtem a lista de turmas associadas ao professor
     * @Return: Lista de turmas
     */
    public ArrayList<Turma> getTurmas(){
        return this.turmas;
    }

    /**
     * @Brief: Define a lista de turmas associadas ao professor
     * @Parameter: turmas Nova lista de turmas
     */
    public void setTurmas(ArrayList<Turma> turmas){
        this.turmas = turmas;
    }

    /**
     * @Brief: Obtem a lista de disciplinas associadas ao professor
     * @Return: Lista de disciplinas
     */
    public ArrayList<Disciplina> getDisciplina(){
        return this.disciplinas;
    }

    /**
     * @Brief: Define a lista de disciplinas associadas ao professor
     * @Parameter: disciplinas Nova lista de disciplinas
     */
    public void setDisciplina(ArrayList<Disciplina> disciplinas){
        this.disciplinas = disciplinas;
    }

    /**
    * @Brief: Obtem o nome do usuário
    * @Return: Nome do usuário
    */
    public String getNome() {
        return super.getNome();
    }

    /**
    * @Brief: Define o nome do usuário
    * @Parameter: nome Novo nome do usuário
    */
    public void setNome(String nome) {
        super.setNome(nome);
    }

    /**
    * @Brief: Obtem o identificador (ID) do usuário
    * @Return: Identificador único do usuário
    */
    public String getID() {
        return super.getID();
    }

    /**
    * @Brief: Define o identificador (ID) do usuário
    * @Parameter: ID Novo identificador único do usuário
    */
    public void setID(String ID) {
        super.setID(ID);
    }

    /**
     * @Brief: Obtem o objeto de notas associado ao professor
     * @Return: Objeto Notas
     */
    public Notas getNotas() {
        return notas;
    }

    /**
     * @Brief: Define o objeto de notas associado ao professor
     * @Parameter: notas Novo objeto Notas
     */
    public void setNotas(Notas notas) {
        this.notas = notas;
    }

    /**
     * @Brief: Adiciona uma disciplina a lista de disciplinas do professor
     * @Parameter: d Disciplina a ser adicionada
     */
    public void adicionarDisciplina(Disciplina d){
        this.disciplinas.add(d);
    }

    /**
     * @Brief: Adiciona uma prova a uma disciplina
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeProva Nome da prova
     * @Parameter: nomeTurma Nome da turma
     * @Parameter: peso Peso da prova
     */
    public void adicionarProvaDisciplina(String nomeDisciplina, String nomeProva, String nomeTurma, float peso){
	notas.adicionarProvaDisciplina(nomeDisciplina, this.nome, nomeProva, nomeTurma, peso);
    }

    /**
     * @Brief: Adiciona um trabalho a uma disciplina
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeTurma Nome da turma
     * @Parameter: nomeTrabalho Nome do trabalho
     * @Parameter: peso Peso do trabalho
     */
    public void adicionarTrabalhoDisciplina(String nomeDisciplina, String nomeTurma, String nomeTrabalho, float peso){
	notas.adicionarTrabalhoDisciplina(nomeDisciplina, this.nome, nomeTurma, nomeTrabalho, peso);
    }

    /**
     * @Brief: Adiciona um ponto extra a uma disciplina
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomePontoExtra Nome do ponto extra
     * @Parameter: nomeTurma Nome da turma
     * @Parameter: valorMaximo Valor máximo do ponto extra
     */
    public void adicionarPontoExtraDisciplina(String nomeDisciplina, String nomePontoExtra, String nomeTurma, float valorMaximo){
	notas.adicionarPontoExtraDisciplina(nomeDisciplina, this.nome, nomePontoExtra, nomeTurma, valorMaximo);
    }

    /**
     * @Brief: Adiciona uma nota de prova a um aluno
     * @Parameter: nomeAluno Nome do aluno
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeProva Nome da prova
     * @Parameter: notaProva Nota da prova
     * @Parameter: nomeTurma Nome da turma
     */
    public void adicionarNotaProva(String nomeAluno, String nomeDisciplina, String nomeProva, float notaProva, String nomeTurma){
	notas.adicionarNotaProva(nomeAluno, nomeDisciplina, this.nome, nomeProva, notaProva, nomeTurma);
    }

    /**
     * @Brief: Adiciona uma nota de trabalho a um aluno
     * @Parameter: nomeAluno Nome do aluno
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeTrabalho Nome do trabalho
     * @Parameter: notaTrabalho Nota do trabalho
     * @Parameter: nomeTurma Nome da turma
     */
    public void adicionarNotaTrabalho(String nomeAluno, String nomeDisciplina, String nomeTrabalho, float notaTrabalho, String nomeTurma){
	notas.adicionarNotaTrabalho(nomeAluno, nomeDisciplina, this.nome, nomeTrabalho, notaTrabalho, nomeTurma);
    }

    /**
     * @Brief: Adiciona um ponto extra a um aluno
     * @Parameter: nomeAluno Nome do aluno
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomePontoExtra Nome do ponto extra
     * @Parameter: nomeTurma Nome da turma
     * @Parameter: valor Valor do ponto extra
     */
    public void adicionarNotaPontoExtra(String nomeAluno, String nomeDisciplina, String nomePontoExtra, String nomeTurma, float valor){
	notas.adicionarNotaPontoExtra(nomeAluno, nomeDisciplina, this.nome, nomePontoExtra, nomeTurma, valor);
    }
    
    /**
     * @Brief: Calcula a média geral das disciplinas do professor
     * @Return: Média geral
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