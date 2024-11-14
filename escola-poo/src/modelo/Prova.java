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
public class Prova implements Avaliacao{
    private String nomeProva;
    private float nota;
    private float peso;

    public Prova() {
    }

    public Prova(String nomeProva, float peso) {
        this.peso = peso;
        this.nomeProva = nomeProva;
    }

    public String getNomeProva() {
        return nomeProva;
    }

    public void setNomeProva(String nomeProva) {
        this.nomeProva = nomeProva;
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
