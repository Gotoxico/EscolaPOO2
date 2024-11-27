/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 * @Brief: Classe que gera um relatório com a média dos professores
 * @author rodri
 */
public class RelatorioProfessores {
    private RelatorioProfessores(){
    
    }
    
    /**
     * @Brief: Gera um relatório com o nome e a média de todos os professores
     * @Parameter: professores Lista de objetos Professor
     * @Return: Relatório com os nomes dos professores e suas respectivas médias
     */
    public static String relatorioProfessores(ArrayList<Professor> professores){
        StringBuilder relatorio = new StringBuilder();
        for(Professor professor : professores){
            relatorio.append("Professor: ")
                    .append(professor.getNome())
                    .append("Media: ")
                    .append(professor.mediaProfessor());
        }
        return relatorio.toString();
    }
}
