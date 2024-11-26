package modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class VerificaSeEDomingo{
    private static LocalDate diaAtual;
    
    public static boolean verificaSeEDomingo(){
        diaAtual = LocalDate.now();
        if(diaAtual.getDayOfWeek().equals(DayOfWeek.SUNDAY)){  
            return true;
        }
        return false;
    }
}