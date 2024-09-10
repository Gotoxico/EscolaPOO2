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
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private Disciplina disciplina;

    public Periodo(LocalTime horaInicio, LocalTime horaFim, Disciplina disciplina) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.disciplina = disciplina;
    }

     public Periodo(LocalTime horaInicio, LocalTime horaFim) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }
         
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
        
        @Override
        public String toString() {
            return horaInicio + " - " + horaFim + ": ";
        }
}
