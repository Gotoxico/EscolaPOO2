package modelo;
import java.time.LocalTime;
import Horario.*;
import java.time.LocalDate;
import java.time.LocalTime;
public class Principal {
    public static void main(String[] args){
        Horario time = new Horario();

        time.exibirHorario();
        
        Disciplina dis = new Disciplina("Mat", "123'", "terceiro", "Obj");
        
        time.adicionarDisciplina("Segunda-feira", dis, LocalTime.of(7,50));
        time.adicionarDisciplina("Terça-feira", dis, LocalTime.of(8,40));
        time.adicionarDisciplina("Segunda-feira", dis, LocalTime.of(10,35));
        time.adicionarDisciplina("Sexta-feira", dis, LocalTime.of(11,25));
        time.adicionarDisciplina("Segunda-feira", dis, LocalTime.of(13,10));
        System.out.println(time.toString());
    }
}
