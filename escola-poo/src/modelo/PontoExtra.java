/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author rodri
 */
public class PontoExtra {
    protected String nomePontoExtra;
    protected float valorMaximo, valor;

    public PontoExtra() {
    }

    public PontoExtra(String nomePontoExtra, float valorMaximo) {
        this.nomePontoExtra = nomePontoExtra;
        this.valorMaximo = valorMaximo;
    }

    public String getNomePontoExtra() {
        return nomePontoExtra;
    }

    public void setNomePontoExtra(String nomePontoExtra) {
        this.nomePontoExtra = nomePontoExtra;
    }

    public float getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(float valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
