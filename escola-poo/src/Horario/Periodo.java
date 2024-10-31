/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Horario;


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

  // Classe interna para representar um período de aula

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

    /**
     * Construtor da classe
     * @param horaInicio
     * @param horaFim
     * @param disciplina
     */
    public Periodo(LocalTime horaInicio, LocalTime horaFim, Disciplina disciplina) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.disciplina = disciplina;
    }

    /**
     * Construtor da classe 2
     * @param horaInicio
     * @param horaFim
     */
    public Periodo(LocalTime horaInicio, LocalTime horaFim) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }
         
    /**
     * Getters e Setters
     * 
     * Retorna a disciplina associada ao período
     * @return 
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * Retorna o horário de início do período
     * @return
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * Retorna o horário de fim do período
     * @param horaInicio
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Retorna o horário de fim do período
     * @return
     */
    public LocalTime getHoraFim() {
        return horaFim;
    }

    /**
     * Define o horário de fim do período
     * @param horaFim
     */
    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    /**
     * Define a disciplina associada ao período
     * @param disciplina
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    /**
     * Méto de override para imprimir o período
     */
        @Override
        public String toString() {
            return horaInicio + " - " + horaFim + ": ";
        }
}
