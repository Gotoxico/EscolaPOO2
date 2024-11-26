/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo.Login;

/**
 *
 * @author user
 */
public interface LoginInterface {
    /**
     * @Brief: Metodo responsável por verificar se o login e a senha fornecidos são válidos
     * @Parameter nome O nome do usuário a ser verificado
     * @Parameter senha A senha do usuário a ser verificada
     * @Return: Retorna true se o nome e a senha coincidirem com um usuário registrado, caso contrário, retorna false
     */
    boolean verificacaoLogin(String nome, String senha);
}
