/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Login;

/**
 *
 * @author user
 */
public class Login implements LoginInterface{
    private UsuarioSistema usuarios[];
    /**
     * @Brief: Metodo responsável por verificar se o login e a senha fornecidos são válidos
     * @Parameter: nome O nome do usuário a ser verificado
     * @Parameter: senha A senha do usuário a ser verificada
     * @Return: Retorna true se o nome e a senha coincidirem com algum usuário registrado, caso contrário, retorna false
     */
    public boolean verificacaoLogin(String nome, String senha){
        for(int i = 0; i < usuarios.length; i++){
            if(usuarios[i].getNome().equals(nome) && usuarios[i].getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
}
