/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.ArrayList;

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
    
    public void Turma(String nomeTurma, String ID, int quantidadeVagas){
        this.nomeTurma = nomeTurma;
        this.ID = ID;
        this.quantidadeVagas = quantidadeVagas;
        this.alunos = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
    }
    
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
    
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }
    
    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }
    
    public void adicionarDisciplinas(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }
    
    public void removerDisciplina(Disciplina disciplina) {
        disciplina.remove(disciplina);
    }
}
