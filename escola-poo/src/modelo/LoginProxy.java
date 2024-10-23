/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author user
 */
public class LoginProxy implements LoginInterface{
    private LoginInterface base;

    public LoginProxy(LoginInterface base) {
        this.base = base;
    }
    
    public boolean verificacaoLogin(String nome, String senha){
        UsuarioSistema usuario;
        
        if((nome.equals("diretora") && senha.equals("123")) || (nome.equals("vice-diretora") && senha.equals("123")) || (nome.equals("coordenadora") && senha.equals("123")) || nome.equals("professor") && senha.equals("123")){
            return true;
        }
        base.verificacaoLogin(nome, senha);
        return false;
    }
}
