/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author rodri
 */
public class RelatorioProfessores {
    private RelatorioProfessores(){
    
    }
    
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
