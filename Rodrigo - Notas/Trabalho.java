/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Escola;

/**
 *
 * @author rodri
 */
public class Trabalho extends Avaliacao{
    protected String nomeTrabalho;

    public Trabalho() {
    }

    public Trabalho(String nomeTrabalho, float peso) {
        super(peso);
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
    
}
