/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author user
 */
public class Login implements LoginInterface{
    private UsuarioSistema usuarios[];
    
    public boolean verificacaoLogin(String nome, String senha){
        for(int i = 0; i < usuarios.length; i++){
            if(usuarios[i].getNome().equals(nome) && usuarios[i].getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
}
