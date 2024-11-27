/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Output;

import modelo.Output.OutputConsole;

/**
 *
 * @author user
 */
public class OutputFactory {
    private static OutputFactory instance;
    
    /**
     * @Brief: Construtor privado para evitar a criação de objetos diretamente
     */
    private OutputFactory(){
        
    }
    
    /**
     * @Brief: Método para obter a instância única da fábrica (padrão Singleton)
     * @Return: A instância única da classe OutputFactory
     */
    public static OutputFactory getInstance(){
        if(instance == null){
            instance = new OutputFactory();
        }
        return instance;
    }
    
    /**
     * @Brief: Método para retornar um objeto do tipo OutputInterface baseado no tipo informado
     * @Parameter tipoOutput: O tipo de saída desejada 
     * @Return: Um objeto que implementa OutputInterface, como OutputConsole
     */
    public static OutputInterface getTipoOutput(String tipoOutput){
        if(tipoOutput.equals("console")){
            return new OutputConsole();
        }
        return null;
    }
}
