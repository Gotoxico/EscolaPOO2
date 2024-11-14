package modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Multa{
    private LocalDate diaAtual;
    private LocalDate inicioMulta;
    private LocalDate fimMulta;
    private Livro livro;    //Livro que não foi devolvido no prazo

    public Multa(){

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

    public Livro getLivro(){
        return livro;
    }

    // a multa durará 10 dias
    public void aplicaMulta(Livro livro){
        this.livro = livro;
        diaAtual = LocalDate.now();
        inicioMulta = diaAtual;
        fimMulta = diaAtual.plusDays(10);
    }

    //se retornar true a multa deve ser removida
    public boolean removeMulta(Usuario usuario){
        diaAtual = LocalDate.now();
        if(diaAtual.compareTo(fimMulta) >= 0 && usuario.buscaLivro(livro) == false){
            return true;
        }
        if(diaAtual.compareTo(fimMulta) >= 0 && usuario.buscaLivro(livro) == true){     //acabou a multa porém o livro ainda não foi devolvido, portanto reaplica multa
            fimMulta = diaAtual.plusDays(10); 
        }
        return false;
    }
}