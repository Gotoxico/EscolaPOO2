 
package horario;

import modelo.Turma;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import modelo.Disciplina;
/**
 * Classe que representa um horário de aulas
 * @author kauan
 */
public class Horario {
    
    /**
     * ATRIBUTOS
     * 
     * duracaoAulaMinutos: duração de uma aula em minutos
     * duracaoIntervaloMinutos: duração do intervalo entre aulas em minutos
     * horaInicio: horário de início das aulas
     * horaFinal: horário de fim das aulas
     * horaAlmocoInicio: horário de início do intervalo de almoço
     * horaAlmocoFinal: horário de fim do intervalo de almoço
     * contadorGeralDeAulas: contador geral de aulas
     * periodos: lista de períodos de aula
     * horario: mapeamento dos dias da semana para suas aulas
     * diasDaSemana: dias da semana
     * 
     */
      
    private static final int duracaoAulaMinutos = 50;
    private static final int duracaoIntervaloMinutos = 15;
    private static final LocalTime horaInicio = LocalTime.of(7, 0);
    private static final LocalTime horaFinal = LocalTime.of(15, 40);
    private static final LocalTime horaAlmocoInicio = LocalTime.of(12,15);
    private static final LocalTime horaAlmocoFinal = LocalTime.of(13,10);
    private int contadorGeralDeAulas =0;
    private ArrayList<Periodo> periodos;
    private Map<String, List<Periodo>> horario;
    String[] diasDaSemana = {"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira"};

    /**
     * Construtor da classe
     * Inicializa o horário
     */
    public Horario() {
        horario = new LinkedHashMap<>();
        inicializarHorario();
        
    }

    //Getters e Setters

    /**
     * Retorna a duração de uma aula em minutos
    * @return
     */
    public int getDuracaoAulaMinutos() {
        return duracaoAulaMinutos;
    }

    /**
     * Retorna a duração do intervalo entre aulas em minutos
     * @return
     */
    public int getDuracaoIntervaloMinutos() {
        return duracaoIntervaloMinutos;
    }

    /**
     * Retorna o horário de início das aulas
     * @return LocalTime
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * Retorna o horário de fim das aulas
     * @return LocalTime
     */
    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    /**
     * Retorna o horário de início do intervalo de almoço
     * @return {@code LocalTime}
     */
    public LocalTime getHoraAlmocoInicio() {
        return horaAlmocoInicio;
    }

    /**
     * Retorna o horário de fim do intervalo de almoço
     * @return LocalTime
     */
    public LocalTime getHoraAlmocoFinal() {
        return horaAlmocoFinal;
    }

    /**
     * Retorna o contador geral de aulas
     * @return int
     */
    public int getContadorGeralDeAulas() {
        return contadorGeralDeAulas;   
    }
    
    /**
     * Retorna a lista de períodos de aula
     * @return ArrayList
     */
    private void inicializarHorario() {
        
        for (String dia : diasDaSemana) {
            horario.put(dia, gerarPeriodosAula());
        }
    }

    /**
     * Retorna o mapeamento dos dias da semana para suas aulas
     * @return {@link List}
     */
    private List<Periodo> gerarPeriodosAula() {
        periodos = new ArrayList<>();
        LocalTime inicio = horaInicio;
        int contadorAulas = 0;
        while (inicio.isBefore(horaFinal)) {
            
            //Se o horario de inicio seja o horário do almoço, deve-se pular para o fim desse intervalo
            if((inicio.equals(horaAlmocoInicio))){
                inicio = horaAlmocoFinal;
                //contadorAulas = 0;
                continue;
            }

            contadorAulas++;
            LocalTime fim = inicio.plusMinutes(duracaoAulaMinutos);
            if (fim.isAfter(horaFinal)) break;
            
            
                periodos.add(new Periodo(inicio, fim));
            
            inicio = fim;
            
            //Verificar se é hora do intervalo
            if((inicio.isBefore(horaAlmocoInicio)||(inicio.isAfter(horaAlmocoFinal)))  && contadorAulas == 3){
                inicio = inicio.plusMinutes(duracaoIntervaloMinutos);
                contadorAulas = 0;
            }
            contadorGeralDeAulas++;
        }

        return periodos;
    }

    /**
     * Retorna o HashMap dos dias da semana para suas aulas
     * @return Map
     */
    public Map<String, List<Periodo>> getHorario() {
        return horario;
    }

    
    /**
     * Adiciona uma disciplinas ao horário
     * @param dia
     * @param disciplina
     * @return {@code true} se a disciplina foi adicionada, {@code false} caso contrário
     */
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
    
  
    
    /**
     * Adiciona uma disciplina ao horário
     * @param dia
     * @param disciplina
     * @param inicio
     * @return {@code true} se a disciplina foi adicionada, {@code false} caso contrário
     */
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
    
    /**
     * Adiciona uma disciplina ao horário
     * @param dia
     * @param disciplinas
     * @param posicao
     * @return {@code true} se a disciplina foi adicionada, {@code false} caso contrário
     */
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

    /**
     * Remove todas as disciplinas de um dia
     * @param dia
     * @return {@code true} se as disciplinas foram removidas, {@code false} caso contrário
     */
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

    /**
     * Remove todas as disciplinas de todos os dias
     * @return {@code true} se as disciplinas foram removidas, {@code false} caso contrário
     */
    public boolean removerTudo(){
        for(Map.Entry<String, List<Periodo>> entrada : horario.entrySet()){
            for(Periodo per : entrada.getValue()){
                if(per.getDisciplina() != null){
                    per.setDisciplina(null);
                }
            }
        }
        
        return true;
    }
    
    /**
     * Remove uma disciplina de um dia
     * @param dia
     * @param disciplina
     * @return {@code true} se a disciplina foi removida, {@code false} caso contrário
     */
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

    /**
     * ToString em forma de tabela os dias da semana, com as semanas sendo as colunas e os horários sendo as linhas (coluna 1 - segunda, coluna 2 - terça, etc)
     * @return String
     * 
     */
    
     @Override
     public String toString() {
         StringBuilder tabela = new StringBuilder();
         int contador = 0;
         // Cabeçalho da tabela com os dias da semana
         tabela.append(String.format("%-18s", "     Horário"));
         for (String dia : diasDaSemana) {
             tabela.append(String.format("%-20s", dia));
         }
         tabela.append("\n");
         
         int maxPeriodos = 0;
         for (List<Periodo> periodosDia : horario.values()) {
             maxPeriodos = Math.max(maxPeriodos, periodosDia.size());
         }
         
         for (int i = 0; i < maxPeriodos; i++) {
             LocalTime horaInicio = null;
             LocalTime horaFim = null;
     
             for (Map.Entry<String, List<Periodo>> entrada : horario.entrySet()) {
                 List<Periodo> periodosDia = entrada.getValue();
                 if (i < periodosDia.size()) {
                     Periodo periodo = periodosDia.get(i);
                     horaInicio = periodo.getHoraInicio();
                     horaFim = periodo.getHoraFim();
                     break;
                 }
             }
             
             if (horaInicio != null && horaFim != null) {
                 tabela.append(String.format("%-18s", i+1 + ": " + horaInicio + " - " + horaFim));
             } else {
                 tabela.append(String.format("%-18s", ""));
             }
     
             for (Map.Entry<String, List<Periodo>> entrada : horario.entrySet()) {
                 List<Periodo> periodosDia = entrada.getValue();
                 if (i < periodosDia.size()) {
                     Periodo periodo = periodosDia.get(i);
                     Disciplina disciplina = periodo.getDisciplina();
                     if (disciplina != null) {
                         tabela.append(String.format("%-20s", disciplina.getNome()));
                     } else {
                         tabela.append(String.format("%-20s", ""));
                     }
                 } else {
                     tabela.append(String.format("%-20s", ""));
                 }
             }
             tabela.append("\n");
             contador++;
            
            if(contador == 3 && i < maxPeriodos-1){
                tabela.append(String.format("%-18s", "     Intervalo"));
                for (String dia : diasDaSemana) {
                    tabela.append(String.format("%-20s", ""));
                }
                tabela.append("\n");
                contador = 0;
            }
         }
         
         return tabela.toString();
     }

     //Outra função de exibir todos os horarios com println 
}


