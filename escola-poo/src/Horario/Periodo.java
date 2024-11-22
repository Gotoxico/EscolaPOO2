
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package horario;


/**
 *
 * @author kauan
 */
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.Disciplina;
import modelo.Professor;

  //Classe interna para representar um período de aula

public  class Periodo {
    /**
     * Atributos da classe
     * horaInicio: horário de início do período
     * horaFim: horário de fim do período
     * disciplina: disciplina associada ao período
     * 
     */
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private Disciplina disciplina;
    private Professor professor;
    
    /**
     * @Brief: Construtor da classe
     * @Parameter: horaInicio
     * @Parameter: horaFim
     * @Parameter: disciplina
     * @Parameter: professor
     */
    public Periodo(LocalTime horaInicio, LocalTime horaFim, Disciplina disciplina, Professor professor) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    /**
     * Brief: Construtor da classe 2
     * @Parameter: horaInicio
     * @Parameter: horaFim
     */
    public Periodo(LocalTime horaInicio, LocalTime horaFim) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }
         
    /**
     * Getters e Setters
     * 
     * Brief: Retorna a disciplina associada ao período
     * @return 
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * Brief: Retorna o horário de início do período
     * @return
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * Brief: Retorna o horário de fim do período
     * @Parameter: horaInicio
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Brief: Retorna o horário de fim do período
     * @return
     */
    public LocalTime getHoraFim() {
        return horaFim;
    }

    /**
     * Brief: Define o horário de fim do período
     * @Parameter: horaFim
     */
    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    /**
     * Brief: Define a disciplina associada ao período
     * @Parameter: disciplina
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
      
    /**
     * Retorna o professor associado ao período
     * @return 
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * Função para adicionar um professor ao perídio
     * @param professor 
     * 
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

 
    
    
    /**
     * Brief: Método de override para retornar os dados do período
     */
        @Override
        public String toString() {
            return horaInicio + " - " + horaFim + ": ";
        }
}

