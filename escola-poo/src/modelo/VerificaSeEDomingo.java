package modelo;

import java.time.DayOfWeek;

public class VerificaSeEDomingo{
    
    public static boolean verificaSeEDomingo(){
        if(diaAtual.getDayOfWeek().equals(DayOfWeek.SUNDAY)){  
            return true;
        }
        return false;
    }
}