
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vitor
 */
public class Professor {
    private String nome;
    private String ID;
    private String titulacao;
    private ArrayList<Disciplina> disciplina; // Mudar para tipo Disciplina
    private ArrayList<Turma> turmas; // Mudar para o tipo Turma
    
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
    
    public ArrayList<Disciplina> getDisciplina(){ // Alterar para tipo Disciplina
        return this.disciplina;
    }
    
    public void setDisciplina(ArrayList<Disciplina> disciplina){ // Alterar para tipo Disciplina
        this.disciplina = disciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
