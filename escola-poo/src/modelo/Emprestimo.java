package modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Emprestimo{
    private LocalDate diaEmprestimo;
    private LocalDate diaDevolucao;
    private LocalDate diaAtual;
    
    public Emprestimo(){
        
    }

    //o usuário tem um prazo de 10 dias para devolver o livro
    public LocalDate calculaDataDevolucao(){
        if(VerificaSeEDomingo.verificaSeEDomingo() == true){  //nao pode devolver no domingo
            return null;
        }
        this.diaEmprestimo = LocalDate.now();
        this.diaDevolucao = diaEmprestimo.plusDays(10);
        return diaDevolucao;
    }

    public LocalDate getDiaEmprestimo(){
        return diaEmprestimo;
    }

    public LocalDate getDiaDevolucao(){
        return diaDevolucao;
    }

    public LocalDate getDiaAtual(){
        return diaAtual = LocalDate.now();
    }

    // se retornar true deve adicionar uma multa no Usuario
    public boolean verificaMulta(){
        diaAtual = LocalDate.now();
        if(diaDevolucao.compareTo(diaAtual) >= 0){
            return false;
        }
        return true;
    }

}