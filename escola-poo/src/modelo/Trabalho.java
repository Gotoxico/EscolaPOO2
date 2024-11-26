/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import interfaces.Avaliacao;

/**
 * @Brief: Representa um trabalho acadêmico 
 * @author rodri
 */
public class Trabalho implements Avaliacao{
    private String nomeTrabalho;
    private float nota;
    private float peso;

    public Trabalho() {
    }

    /**
     * @Brief: Construtor que cria um trabalho com nome e peso especificados
     * @Parameter: nomeTrabalho Nome do trabalho
     * @Parameter: peso Peso do trabalho na avaliação
     */
    public Trabalho(String nomeTrabalho, float peso) {
        this.peso = peso;
        this.nomeTrabalho = nomeTrabalho;
    }

    /**
     * @Brief: Obtem o nome do trabalho
     * @Return: Nome do trabalho
     */
    public String getNomeTrabalho() {
        return nomeTrabalho;
    }

    /**
     * @Brief: Define o nome do trabalho
     * @Parameter: nomeTrabalho Nome do trabalho
     */
    public void setNomeTrabalho(String nomeTrabalho) {
        this.nomeTrabalho = nomeTrabalho;
    }

    /**
     * @Brief: Obtem o peso do trabalho
     * @Return: Peso do trabalho
     */
    public float getPeso() {
        return peso;
    }

    /**
     * @Brief: Define o peso do trabalho
     * @Parameter: peso Peso do trabalho
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * @Brief: Obtem a nota do trabalho
     * @Return: Nota do trabalho
     */
    public float getNota() {
        return nota;
    }

    /**
     * @Brief: Define a nota do trabalho
     * @Parameter: nota Nota do trabalho
     */
    public void setNota(float nota) {
        this.nota = nota;
    }

    /**
     * @Brief: Calcula a nota do trabalho com base no valor atribuído
     * @Return: Nota final do trabalho
     */
    @Override
    public double calcularNota() {
        return nota;
    }
    
}
