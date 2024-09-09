package modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Multa{
    private LocalDate diaAtual;
    private LocalDate inicioMulta;
    private LocalDate fimMulta;

    public Multa(){

    }

    public boolean verificaSeEDomingo(){
        if(diaEmprestimo.getDayOfWeek().equals(DayOfWeek.SUNDAY)){  
            return true;
        }
        return false;
    }

    public LocalDate getDiaAtual(){
        return diaAtual = LocalDate.now();
    }

    public LocalDate getInicioMulta(){
        return inicioMulta;
    }

    public LocalDate getFimMulta(){
        return fimMulta;
    }

    // a multa durará 10 dias
    public void aplicaMulta(){
        diaAtual = LocalDate.now();
        this.inicioMulta = diaAtual;
        this.fimMulta = diaAtual.plusDays(10);
    }

    //se retornar true a multa deve ser removida
    public boolean removeMulta(){
        diaAtual = LocalDate.now();
        if(diaAtual.compareTo(fimMulta) >= 0){
            return true;
        }
        return false;
    }
}