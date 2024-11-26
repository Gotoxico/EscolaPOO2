/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.ArrayList;

import horario.Horario;
import modelo.Professor;
import horario.Periodo;

import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Brief: Representa uma turma de alunos, incluindo suas disciplinas, professores e horários
 * @author juniortraj
 */
public class Turma {
    private String nomeTurma;
    private String ID;
    private int quantidadeVagas;
    private ArrayList<Aluno> alunos;
    private ArrayList<Disciplina> disciplinas;
    private Horario horario;
    private Map<Disciplina, Professor> professores;
    
    /**
     * @Brief: Construtor da classe Turma
     * @Parameter: nomeTurma Nome da turma
     * @Parameter: ID Identificador único da turma
     * @Parameter: quantidadeVagas Número total de vagas para a turma
     */
    public Turma(String nomeTurma, String ID, int quantidadeVagas) {
        this.nomeTurma = nomeTurma;
        this.ID = ID;
        this.quantidadeVagas = quantidadeVagas;
        this.alunos = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.horario = new Horario();
        this.professores = new LinkedHashMap<>();
    }

    /**
     * @Brief: Obtem o nome da turma
     * @Return: Nome da turma
     */
    public String getNomeTurma(){
        return nomeTurma;
    }
    
    /**
     * @Brief: Define o nome da turma
     * @Parameter: nomeTurma Nome da turma
     */
    public void setNomeTurma(String nomeTurma){
        this.nomeTurma = nomeTurma;
    }
    
    /**
     * @Brief: Obtem o identificador da turma
     * @Return: ID da turma
     */
    public String getID(){
        return ID;
    }
    
    /**
     * @Brief: Define o identificador da turma
     * @Parameter: ID Identificador da turma
     */
    public void setID(String ID){
        this.ID = ID;
    }
    
    /**
     * @Brief: Obtem a quantidade de vagas da turma
     * @Return: Quantidade de vagas
     */
    public int getQuantidadeVagas(){
        return quantidadeVagas;
    }
    
    /**
     * @Brief: Define a quantidade de vagas da turma
     * @Parameter: quantidadeVagas Quantidade de vagas
     */
    public void setQuantidadeVagas(int quantidadeVagas){
        this.quantidadeVagas = quantidadeVagas;
    }
    
    /**
     * @Brief: Obtem a lista de alunos da turma
     * @Return: Lista de alunos
     */
    public ArrayList<Aluno> getAlunos(){
        return alunos;
    }
    
    /**
     * @Brief: Define a lista de alunos da turma
     * @Parameter: alunos Lista de alunos
     */
    public void setAlunos(ArrayList<Aluno> alunos){
        this.alunos = alunos;
    }

    /**
     * @Brief: Obtem o horário da turma
     * @Return: Objeto Horario da turma
     */
    public Horario getHorario() {
        return horario;
    }
    
    /**
     * @Brief: Define o horário da turma
     * @Parameter: horario Horário da turma
     */
    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    /**
     * @Brief: Adiciona um aluno a turma
     * @Parameter: aluno Aluno a ser adicionado
     */
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }
    
    /**
     * @Brief: Remove um aluno da turma
     * @Parameter: aluno Aluno a ser removido
     */
    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    /**
     * @Brief: Adiciona uma disciplina à turma
     * @Parameter: disciplina Disciplina a ser adicionada
     */
    public void adicionarDisciplinas(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }
    
    /**
     * @Brief: Remove uma disciplina da turma
     * @Parameter: disciplina Disciplina a ser removida
     */
    public void removerDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
    }

    /**
     * @Brief: Obtem a lista de disciplinas da turma
     * @Return: Lista de disciplinas
     */
    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    /**
     * @Brief: Define a lista de disciplinas da turma
     * @Parameter: disciplinas Lista de disciplinas
     */
    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    /**
     * @Brief: Obtem a duração da aula em minutos
     * @Return: Duração da aula em minutos
     */
    public int getDuracaoAulaMinutos() {
        return horario.getDuracaoAulaMinutos();
    }
    
    /**
     * @Brief: Obtem a duração do intervalo em minutos
     * @Return: Duração do intervalo em minutos
     */
    public int getDuracaoIntervaloMinutos() {
        return horario.getDuracaoIntervaloMinutos();
    }
    
    /**
     * @Brief: Obtem a hora de início do intervalo
     * @Return: Hora de início do intervalo
     */
    public LocalTime getHoraInicio() {
        return horario.getHoraInicio();
    }
    
    /**
     * @Brief: Obtem a hora final do intervalo
     * @Return: Hora final do intervalo
     */
    public LocalTime getHoraFinal() {
        return horario.getHoraFinal();
    }
    
    /**
     * @Brief: Obtem a hora final do intervalo
     * @Return: Hora final do intervalo
     */
    public LocalTime getHoraIntervaloInicio() {
        return horario.getHoraAlmocoInicio();
    }

    /**
     * @Brief: Obtem a hora final do intervalo
     * @Return: Hora final do intervalo
     */
    public LocalTime getHoraIntervaloFinal() {
        return horario.getHoraAlmocoFinal();
    }
    
    /**
     * @Brief: Adiciona uma disciplina no horário de um dia específico
     * @Parameter: dia Dia da semana
     * @Parameter: disciplinas Lista de disciplinas a ser adicionada
     * @Return: Retorna true se a operação foi bem-sucedida
     */
    public boolean adicionarDisciplinaHorario(String dia, ArrayList<Disciplina> disciplinas){
       return horario.adicionarDisciplina(dia, disciplinas);
    } 
    
    /**
     * @Brief: Adiciona uma disciplina no horário de um dia específico, com hora de início
     * @Parameter: dia Dia da semana
     * @Parameter: disciplina Disciplina a ser adicionada
     * @Parameter: inicio Hora de início da disciplina
     * @Return: Retorna true se a operação foi bem-sucedida
     */
    public boolean adicionarDisciplinaHorario(String dia, Disciplina disciplina, LocalTime inicio){
        return horario.adicionarDisciplina(dia, disciplina, inicio);
    }
    
    /**
     * @Brief: Adiciona uma lista de disciplinas no horário de um dia específico, em uma posição
     * @Parameter: dia Dia da semana
     * @Parameter: disciplinas Lista de disciplinas a ser adicionada
     * @Parameter: posicao Posição da disciplina no horário
     * @Return: Retorna true se a operação foi bem-sucedida
     */
    public boolean adicionarDisciplinaHorario(String dia, ArrayList<Disciplina> disciplinas, int posicao){
        return horario.adicionarDisciplina(dia, disciplinas, posicao);
    }
    
    /**
     * @Brief: Remove todas as disciplinas de um dia no horário
     * @Parameter: dia Dia da semana
     * @Return: Retorna true se a operação foi bem-sucedida
     */
    public boolean removerTodasDisciplinasHorario(String dia){
        return horario.removerTodasDisciplinas(dia);
    }
    
    /**
     * @Brief: Remove uma disciplina de um dia específico no horário
     * @Parameter: dia Dia da semana
     * @Parameter: inicio Hora de início da disciplina
     * @Return: Retorna true se a operação foi bem-sucedida
     */
    public boolean removerDisciplinaDiaHorario(String dia, LocalTime inicio){
        return horario.removerDisciplinaDia(dia, inicio);
    }

    /**
     * @Brief: Define o professor de uma disciplina
     * @Parameter: d Disciplina
     * @Parameter: p Professor a ser atribuído à disciplina
     */
    public void definirProfessorDisciplina(Disciplina d, Professor p){
        professores.put(d, p);
    }

    /**
     * @Brief: Obtem o professor de uma disciplina
     * @Parameter: d Disciplina
     * @Return: Professor da disciplina
     */
    public Professor getProfessorDisciplina(Disciplina d){
        return professores.get(d);
    }
}
