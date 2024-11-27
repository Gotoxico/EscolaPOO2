/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * @Brief: Representa um ponto extra atribuído a uma disciplina ou aluno
 * @Details: Inclui informações como o nome do ponto extra, valor máximo e valor atual
 * @author rodrigo
 */
public class PontoExtra {
    protected String nomePontoExtra;
    protected float valorMaximo, valor;

    /**
     * @Brief: Construtor padrão da classe PontoExtra
     * @Details: Inicializa um objeto sem parâmetros
     */
    public PontoExtra() {
    }

    /**
     * @Brief: Construtor da classe PontoExtra
     * @Details: Inicializa um ponto extra com nome e valor maximo
     * @Parameter: nomePontoExtra Nome do ponto extra
     * @Parameter: valorMaximo Valor máximo do ponto extra
     */
    public PontoExtra(String nomePontoExtra, float valorMaximo) {
        this.nomePontoExtra = nomePontoExtra;
        this.valorMaximo = valorMaximo;
    }

    /**
     * @Brief: Retorna o nome do ponto extra
     * @Return: Nome do ponto extra
     */
    public String getNomePontoExtra() {
        return nomePontoExtra;
    }

    /**
     * @Brief: Define o nome do ponto extra
     * @Parameter: nomePontoExtra Nome do ponto extra
     */
    public void setNomePontoExtra(String nomePontoExtra) {
        this.nomePontoExtra = nomePontoExtra;
    }
 
    /**
     * @Brief: Retorna o valor máximo do ponto extra
     * @Return: Valor máximo do ponto extra
     */
    public float getValorMaximo() {
        return valorMaximo;
    }

    /**
     * @Brief: Define o valor máximo do ponto extra
     * @Parameter: valorMaximo Valor maximo do ponto extra
     */
    public void setValorMaximo(float valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    /**
     * @Brief: Retorna o valor atual do ponto extra
     * @Return: Valor atual do ponto extra
     */
    public float getValor() {
        return valor;
    }

    /**
     * @Brief: Define o valor atual do ponto extra
     * @Parameter: valor Valor atual do ponto extra
     */
    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
