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
    
    private OutputFactory(){
        
    }
    
    public static OutputFactory getInstance(){
        if(instance == null){
            instance = new OutputFactory();
        }
        return instance;
    }
    
    public static OutputInterface getTipoOutput(String tipoOutput){
        if(tipoOutput.equals("console")){
            return new OutputConsole();
        }
        return null;
    }
}
