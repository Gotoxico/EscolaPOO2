/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Escola;
import Disciplina;
import java.util.ArrayList;

/**
 *
 * @author rodri
 */
public class Notas {
    protected ArrayList<Disciplina> disciplinas;

    public Notas() {
    }

    public Notas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    
    public void adicionarProvaDisciplina(String nomeDisciplina, String nomeProfessor, String nomeProva, String nomeTurma, float peso) {
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getNomeDisciplina.equals(nomeDisciplina) && disciplina.getNomeProfessor.equals(nomeProfessor) && disciplina.getNomeTurma.equals(nomeTurma)){
                disciplina.adicionarProva(nomeDisciplina, nomeProfessor, nomeProva, nomeTurma, peso);
            }
        }
    }
    
    public void adicionarTrabalhoDisciplina(String nomeDisciplina, String nomeProfessor, String nomeTurma, String nomeTrabalho, float peso) {
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getNomeDisciplina.equals(nomeDisciplina) && disciplina.getNomeProfessor.equals(nomeProfessor) && disciplina.getNomeTurma.equals(nomeTurma)){
                disciplina.adicionarProva(nomeDisciplina, nomeProfessor, nomeTurma, nomeTrabalho, peso);
            }
        }
    }
    
    public void adicionarPontoExtraDisciplina(String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma, float valorMaximo) {
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getNomeDisciplina.equals(nomeDisciplina) && disciplina.getNomeProfessor.equals(nomeProfessor) && disciplina.getNomeTurma.equals(nomeTurma)){
                disciplina.adicionarProva(nomeDisciplina, nomeProfessor, nomePontoExtra, nomeTurma, valorMaximo);
            }
        }
    }
    
    public void adicionarNotaProva(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeProva, float notaProva, String nomeTurma) {
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getNomeAluno.equals(nomeAluno) && disciplina.getNomeDisciplina.equals(nomeDisciplina) && disciplina.getNomeProfessor.equals(nomeProfessor) && disciplina.getNomeTurma.equals(nomeTurma) && disciplina.getNomeProva.equals(nomeProva)){
                disciplina.setNotaAluno(nomeAluno, nomeProva, notaProva);
            }
        }
    }
    
    public void adicionarNotaTrabalho(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeTrabalho, float notaTrabalho, String nomeTurma) {
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getNomeAluno.equals(nomeAluno) && disciplina.getNomeDisciplina.equals(nomeDisciplina) && disciplina.getNomeProfessor.equals(nomeProfessor) && disciplina.getNomeTurma.equals(nomeTurma) && disciplina.getNomeTrabalho.equals(nomeTrabalho)){
                disciplina.setNotaAluno(nomeAluno, nomeTrabalho, notaTrabalho);
            }
        }
    }
    
    public void adicionarNotaPontoExtra(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma, float valor) {
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getNomeAluno.equals(nomeAluno) && disciplina.getNomeDisciplina.equals(nomeDisciplina) && disciplina.getNomeProfessor.equals(nomeProfessor) && disciplina.getNomeTurma.equals(nomeTurma) && disciplina.getNomePontoExtra.equals(nomePontoExtra)){
                disciplina.setNotaAluno(nomeAluno, nomePontoExtra, nomePontoExtra);
            }
        }
    }
    
}
