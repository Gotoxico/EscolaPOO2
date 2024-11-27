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
    /**
     * @Brief: Construtor da classe Prova
     * @Parameter: nomeProva Nome da prova
     * @Parameter: peso Peso da prova
     */
    public Prova(String nomeProva, float peso) {
        this.peso = peso;
        this.nomeProva = nomeProva;
    }

    /**
     * @Brief: Obtem o nome da prova
     * @Return: Nome da prova
     */
    public String getNomeProva() {
        return nomeProva;
    }

    /**
     * @Brief: Define o nome da prova
     * @Parameter: nomeProva Nome da prova
     */
    public void setNomeProva(String nomeProva) {
        this.nomeProva = nomeProva;
    }

    /**
     * @Brief: Obtem o peso da prova
     * @Return: Peso da prova
     */
    public float getPeso() {
        return peso;
    }

    /**
     * @Brief: Define o peso da prova
     * @Parameter: peso Peso da prova
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * @Brief: Obtem a nota atribuída a prova
     * @Return: Nota da prova
     */
    public float getNota() {
        return nota;
    }

    /**
     * @Brief: Define a nota da prova
     * @Parameter: nota Nota a ser atribuída à prova
     */
    public void setNota(float nota) {
        this.nota = nota;
    }

    /**
     * @Brief: Calcula a nota da prova
     * @Return: Nota da prova
     */
    @Override
    public double calcularNota() {
        return nota;
    }
    
}
