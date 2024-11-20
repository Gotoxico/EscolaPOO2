package modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class VerificaSeEDomingo{
    
    public static boolean verificaSeEDomingo(){
        LocalDate diaAtual = LocalDate.now();
        if(diaAtual.getDayOfWeek().equals(DayOfWeek.SUNDAY)){  
            return true;
        }
        return false;
    }
}