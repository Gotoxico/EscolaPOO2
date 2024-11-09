/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import interfaces.Avaliacao;

/**
 *
 * @author rodri
 */
public class Trabalho implements Avaliacao{
    private String nomeTrabalho;
    private float nota;
    private float peso;

    public Trabalho() {
    }

    public Trabalho(String nomeTrabalho, float peso) {
        this.peso = peso;
        this.nomeTrabalho = nomeTrabalho;
    }

    public String getNomeTrabalho() {
        return nomeTrabalho;
    }

    public void setNomeTrabalho(String nomeTrabalho) {
        this.nomeTrabalho = nomeTrabalho;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public double calcularNota() {
        return nota;
    }
    
}
