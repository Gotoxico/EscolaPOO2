/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Output;

/**
 *
 * @author user
 */
public class OutputConsole implements OutputInterface{
    /**
     * @Brief: Método responsável por exibir a mensagem no console
     * @Parameter message: A mensagem a ser exibida no console
     */
    @Override
    public void display(String message){
        System.out.println(message);
    }
}
