package modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;
/**
 * @Brief: Classe que verifica se o dia atual é domingo
 */
public class VerificaSeEDomingo{
    private static LocalDate diaAtual;

    /**
     * @Brief: Metodo que verifica se o dia atual é domingo
     * @Return: Retorna true se o dia atual for domingo, caso contrário, retorna false
     */
    public static boolean verificaSeEDomingo(){
        diaAtual = LocalDate.now();
        if(diaAtual.getDayOfWeek().equals(DayOfWeek.SUNDAY)){  
            return true;
        }
        return false;
    }
}