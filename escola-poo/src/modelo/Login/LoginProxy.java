/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Login;

import modelo.Login.LoginInterface;

/**
 *
 * @author user
 */
public class LoginProxy implements LoginInterface{
    private LoginInterface base;

    /**
     * @Brief: Construtor do LoginProxy que recebe um objeto LoginInterface
     * @Parameter base: O objeto que implementa a interface LoginInterface, que será utilizado para fazer a verificação de login
     */
    public LoginProxy(LoginInterface base) {
        this.base = base;
    }
    
    /**
     * @Brief: Metodo responsável por verificar se o login e a senha fornecidos são válidos
     * @Parameter nome O nome do usuário a ser verificado
     * @Parameter senha A senha do usuário a ser verificada
     * @Return: Retorna true se o nome e a senha coincidirem com os valores predeterminados ou com a verificação feita pelo base LoginInterface
     */
    public boolean verificacaoLogin(String nome, String senha){
        UsuarioSistema usuario;
        
        if((nome.equals("diretora") && senha.equals("123")) || (nome.equals("vice-diretora") && senha.equals("123")) || (nome.equals("coordenadora") && senha.equals("123")) || nome.equals("professor") && senha.equals("123")){
            return true;
        }
        base.verificacaoLogin(nome, senha);
        return false;
    }
}
