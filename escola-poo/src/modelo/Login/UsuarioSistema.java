/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Login;

/**
 *
 * @author user
 */
public class UsuarioSistema {
    private String nome, senha;

    /**
     * @Brief: Construtor padrão da classe UsuarioSistema
     */
    public UsuarioSistema() {
    }

    /**
     * @Brief: Construtor da classe UsuarioSistema que inicializa os atributos nome e senha
     * @Parameter: nome Nome do usuário
     * @Parameter: senha Senha do usuário
     */
    public UsuarioSistema(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    /**
     * @Brief: Método que retorna o nome do usuário
     * @Return: O nome do usuário
     */
    public String getNome() {
        return nome;
    }

    /**
     * @Brief: Método que retorna a senha do usuário
     * @Return: A senha do usuário
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @Brief: Método para definir o nome do usuário
     * @Parameter: nome Nome do usuário a ser definido
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @Brief: Método para definir a senha do usuário
     * @Parameter: senha Senha do usuário a ser definida
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
