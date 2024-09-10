 
package Horario;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import modelo.Disciplina;
/**
 *
 * @author kauan
 */
public class Horario {
    
    private static final int DURACAO_AULA_MINUTOS = 50;
    private static final int DURACAO_INTERVALO_MINUTOS = 15;
    private static final LocalTime HORA_INICIO = LocalTime.of(7, 0);
    private static final LocalTime HORA_FINAL = LocalTime.of(15, 40);
    private static final LocalTime HORA_ALMOCO_INICIO = LocalTime.of(12,15);
    private static final LocalTime HORA_ALMOCO_FINAL = LocalTime.of(13,10);
    private int contadorGeralDeAulas =0;
    private ArrayList<Periodo> periodos;
    private boolean intervalo = false;

     // Mapeia os dias da semana para suas aulas
    private Map<String, List<Periodo>> horario;
    String[] diasDaSemana = {"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira"};

    public Horario() {
        horario = new LinkedHashMap<>();
        inicializarHorario();
        
    }

    public static int getDURACAO_AULA_MINUTOS() {
        return DURACAO_AULA_MINUTOS;
    }

    public static int getDURACAO_INTERVALO_MINUTOS() {
        return DURACAO_INTERVALO_MINUTOS;
    }

    public static LocalTime getHORA_INICIO() {
        return HORA_INICIO;
    }

    public static LocalTime getHORA_FINAL() {
        return HORA_FINAL;
    }

    public static LocalTime getHORA_ALMOCO_INICIO() {
        return HORA_ALMOCO_INICIO;
    }

    public static LocalTime getHORA_ALMOCO_FINAL() {
        return HORA_ALMOCO_FINAL;
    }

    public int getContadorGeralDeAulas() {
        return contadorGeralDeAulas;   
    }
    
    
    

    // Inicializa o calendário para todos os dias da semana
    private void inicializarHorario() {
        
        for (String dia : diasDaSemana) {
            horario.put(dia, gerarPeriodosAula());
        }
    }

    // Gera a lista de períodos para um dia
    private List<Periodo> gerarPeriodosAula() {
        periodos = new ArrayList<>();
        LocalTime inicio = HORA_INICIO;
        int contadorAulas = 0;
        while (inicio.isBefore(HORA_FINAL)) {
            
            //Se o horario de inicio seja o horário do almoço, deve-se pular para o fim desse intervalo
            if((inicio.equals(HORA_ALMOCO_INICIO))){
                inicio = HORA_ALMOCO_FINAL;
                //contadorAulas = 0;
                continue;
            }

            contadorAulas++;
            LocalTime fim = inicio.plusMinutes(DURACAO_AULA_MINUTOS);
            if (fim.isAfter(HORA_FINAL)) break;
            
            
                periodos.add(new Periodo(inicio, fim));
            
            inicio = fim;
            
            //Verificar se é hora do intervalo
            if((inicio.isBefore(HORA_ALMOCO_INICIO)||(inicio.isAfter(HORA_ALMOCO_FINAL)))  && contadorAulas == 3){
                inicio = inicio.plusMinutes(DURACAO_INTERVALO_MINUTOS);
                contadorAulas = 0;
            }
            contadorGeralDeAulas++;
        }

        return periodos;
    }

    // Exibe o calendário completo
    public void exibirHorario() {
        int conferidor = 0;
        LocalTime horasAux = HORA_INICIO;
        for (Map.Entry<String, List<Periodo>> entrada : horario.entrySet()) {
            System.out.println(entrada.getKey() + ":");
            for (Periodo periodo : entrada.getValue()) {
               
                
                if(periodo.getDisciplina() == null){
                    if(periodo.getHoraInicio() != horasAux){
                        System.out.println("\tIntervalo\n\t" + periodo);
                    }else System.out.println("\t" + periodo);
                }
                else{
                    if(periodo.getHoraInicio() != horasAux){
                        System.out.println("\tIntervalo\n\t" + periodo + periodo.getDisciplina().getNome());
                    }else System.out.println("\t" + periodo + periodo.getDisciplina().getNome());
                }
                horasAux = periodo.getHoraFim();
            }
            horasAux = HORA_INICIO;
        }
    }
    
    public boolean adicionarDisciplina(String dia, ArrayList<Disciplina> disciplinas){
        if(disciplinas.size() > contadorGeralDeAulas/5) return false;
        int i = 0;
        for (Map.Entry<String, List<Periodo>> entrada : horario.entrySet()) {
            if(entrada.getKey().equals(dia)){
                for (Periodo per : entrada.getValue()) {
                    per.setDisciplina(disciplinas.get(i++));
                    if(i == disciplinas.size()) break;
                }
            }
        }
        
        return true;
    }
    
    public boolean adicionarDisciplina(Disciplina disciplina, Periodo periodo){
        if(periodo == null) return false;
        if(disciplina == null) return false;
        
        for(int i = 0; i < contadorGeralDeAulas/5; i++){
           if(this.periodos.get(i).equals(periodo)){
               this.periodos.get(i).setDisciplina(disciplina);
           }
        }
        return true;
    }
    
    public boolean adicionarDisciplina(String dia, Disciplina disciplina, LocalTime inicio){
        if(inicio == null) return false;
        if(disciplina == null) return false;
        
        for (Map.Entry<String, List<Periodo>> entrada : horario.entrySet()) {
            if(entrada.getKey().equals(dia)){
                for (Periodo per : entrada.getValue()) {
                    if(per.getHoraInicio().equals(inicio)){
                        per.setDisciplina(disciplina);
                    }
                }
            }
        }
        
        return true;
    }
    
    public boolean adicionarDisciplina(String dia, ArrayList<Disciplina> disciplinas, int posicao){
        if(disciplinas.size()+ posicao-1 > contadorGeralDeAulas/5) return false;
        int i = 0, j = 0;
        
        for (Map.Entry<String, List<Periodo>> entrada : horario.entrySet()) {
            if(entrada.getKey().equals(dia)){
                for (Periodo per : entrada.getValue()) {
                    if(i >= posicao-1){
                        per.setDisciplina(disciplinas.get(j++));
                        if(i == disciplinas.size()+1) break;
                    }
                    i++;
                }
            }
            i = 0;
            j = 0;
        }
        
        return true;
    }
    
    public boolean removerTodasDisciplinas(String dia){
        for(Map.Entry<String, List<Periodo>> entrada : horario.entrySet()){
            if(entrada.getKey().equals(dia)){
                for(Periodo per : entrada.getValue()){
                    if(per.getDisciplina() != null){
                        per.setDisciplina(null);
                    }
                }
            }
        }
        
        return true;
    }
    
    public boolean removerDisciplinaDia(String dia, LocalTime inicio){
        for(Map.Entry<String, List<Periodo>> entrada: horario.entrySet()){
            if(entrada.getKey().equals(dia)){
                for(Periodo per : entrada.getValue()){
                    if(per.getHoraInicio().equals(inicio)){
                        per.setDisciplina(null);
                    }
                }
            }
        }
        return true;
    }
    
    
}


