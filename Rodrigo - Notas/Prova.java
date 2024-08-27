/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Escola;

/**
 *
 * @author rodri
 */
public class Prova extends Avaliacao{
    protected String nomeProva;

    public Prova() {
    }

    public Prova(String nomeProva, float peso) {
        super(peso);
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
    
}
