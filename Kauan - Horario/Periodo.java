/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gerenciamento;

/**
 *
 * @author kauan
 */
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Classes.Disciplina;

  // Classe interna para representar um periodo de aula
    public  class Periodo {
        private LocalTime horaInicio;
        private LocalTime horaFim;
        private Disciplina disciplina;

        /**
        * @Brief: Construtor para inicializar o período de aula com hora de início, hora de fim e a disciplina
        * @Parameter: horaInicio - Hora de início do período
        * @Parameter: horaFim - Hora de fim do período
        * @Parameter: disciplina - Disciplina associada ao período
        */
        public Periodo(LocalTime horaInicio, LocalTime horaFim, Disciplina disciplina) {
            this.horaInicio = horaInicio;
            this.horaFim = horaFim;
            this.disciplina = disciplina;
        }
        
        /**
        * @Brief: Construtor para inicializar o período de aula com hora de início e hora de fim, mas sem disciplina
        * @Parameter: horaInicio - Hora de início do período
        * @Parameter: horaFim - Hora de fim do período
        */
         public Periodo(LocalTime horaInicio, LocalTime horaFim) {
            this.horaInicio = horaInicio;
            this.horaFim = horaFim;
        }

    /**
     * @Brief: Retorna a disciplina associada ao período
     * @Return: A disciplina associada ao período
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * @Brief: Retorna a hora de início do período
     * @Return: A hora de início do período
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * @Brief: Define a hora de início do período
     * @Parameter: horaInicio - Hora de início do período
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @Brief: Retorna a hora de fim do período
     * @Return: A hora de fim do período
     */
    public LocalTime getHoraFim() {
        return horaFim;
    }

    /**
     * @Brief: Define a hora de fim do período
     * @Parameter: horaFim - Hora de fim do período
     */
    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    /**
     * @Brief: Define a disciplina associada ao período
     * @Parameter: disciplina - Disciplina associada ao período
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
        /**
        * @Brief: Representação em formato String do período de aula
        * @Return: String com o horário e a disciplina do período
        */
        @Override
        public String toString() {
            return horaInicio + " - " + horaFim + ": ";
        }
    }