/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.ArrayList;
import Horario.Horario;
import java.time.LocalTime;
import Horario.Periodo;

/**
 *
 * @author juniortraj
 */
public class Turma {
    private String nomeTurma;
    private String ID;
    private int quantidadeVagas;
    private ArrayList<Aluno> alunos;
    private ArrayList<Disciplina> disciplinas;
    private Horario horario;

    //Construtor
    public Turma(String nomeTurma, String ID, int quantidadeVagas){
        this.nomeTurma = nomeTurma;
        this.ID = ID;
        this.quantidadeVagas = quantidadeVagas;
        this.alunos = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.horario = horario;
    }

    //Métodos getters e setters
    public String getNomeTurma(){
        return nomeTurma;
    }
    
    public void setNomeTurma(String nomeTurma){
        this.nomeTurma = nomeTurma;
    }
    
    public String getID(){
        return ID;
    }
    
    public void setID(String ID){
        this.ID = ID;
    }
    
    public int getQuantidadeVagas(){
        return quantidadeVagas;
    }
    
    public void setQuantidadeVagas(int quantidadeVagas){
        this.quantidadeVagas = quantidadeVagas;
    }
    
    public ArrayList<Aluno> getAlunos(){
        return alunos;
    }
    
    public void setAlunos(ArrayList<Aluno> alunos){
        this.alunos = alunos;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    //Métodos relacionados à alunos
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }
    
    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    //Métodos relacionados à disciplina
    public void adicionarDisciplinas(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }
    
    public void removerDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    //Métodos relacionados à gerência de horário
    public int getDURACAO_AULA_MINUTOS() {
        return horario.getDURACAO_AULA_MINUTOS();
    }
    
    public int getDURACAO_INTERVALO_MINUTOS() {
        return horario.getDURACAO_INTERVALO_MINUTOS();
    }
    
    public LocalTime getHORA_INICIO() {
        return horario.getHORA_ALMOCO_INICIO();
    }

    public LocalTime getHORA_FINAL() {
        return horario.getHORA_FINAL();
    }
    
    public LocalTime getHORA_ALMOCO_INICIO() {
        return horario.getHORA_ALMOCO_INICIO();
    }

    public LocalTime getHORA_ALMOCO_FINAL() {
        return horario.getHORA_ALMOCO_FINAL();
    }
    
    
    
    public boolean adicionarDisciplinaHorario(String dia, ArrayList<Disciplina> disciplinas){
       return horario.adicionarDisciplina(dia, disciplinas);
    } 
    
    
    public boolean adicionarDisciplinaHorario(String dia, Disciplina disciplina, LocalTime inicio){
        return horario.adicionarDisciplina(dia, disciplina, inicio);
    }
    
    public boolean adicionarDisciplinaHorario(String dia, ArrayList<Disciplina> disciplinas, int posicao){
        return horario.adicionarDisciplina(dia, disciplinas, posicao);
    }
    
    public boolean removerTodasDisciplinasHorario(String dia){
        return horario.removerTodasDisciplinas(dia);
    }
    
    public boolean removerDisciplinaDiaHorario(String dia, LocalTime inicio){
        return horario.removerDisciplinaDia(dia, inicio);
    }
}
