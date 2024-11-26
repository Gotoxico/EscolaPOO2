/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import horario.Horario;
import horario.Periodo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import modelo.Output.OutputConsole;
import modelo.Output.OutputFactory;
import modelo.Output.OutputInterface;
import interfaces.media;

/**
 * @Brief: Classe que representa uma Disciplina no sistema
 * @Details: Contém informações como nome, unidade escolar, objetivos, metodologia e funcionalidades relacionadas à gestão de professores, provas, trabalhos e alunos.
 * @author Daniel Servejeira
 */

public class Disciplina implements media {
    private String nome;
    private String unidadeEscolar;
    private String anoEscolar;
    private String ementa;
    private String objetivos;
    private String metodologia;
    private String calculoMedia;
    private int cargaHoraria;
    private Turma turma;
    private ArrayList<Professor> professores;
    private ArrayList<Prova> provas;
    private ArrayList<Trabalho> trabalhos;
    private ArrayList<PontoExtra> pontosExtra;
    private final OutputInterface output;
    
    /*
     * @Brief: Construtor da classe Disciplina
     * @Details: Inicializa os atributos principais da disciplina, associando-a a uma turma e configurando o tipo de saída para exibição
     * @Parameter: outputFactory Fábrica responsável por instanciar o tipo de saída
     * @Parameter: nome Nome da disciplina
     * @Parameter: unidadeEscolar Unidade escolar da disciplina
     * @Parameter: anoEscolar Ano escolar ao qual a disciplina pertence
     * @Parameter: tipoOutput Tipo de saída para exibição (ex.: console)
     * @Parameter: turma Turma associada à disciplina
     */
    public Disciplina(OutputFactory outputFactory, String nome, String unidadeEscolar, String anoEscolar, String tipoOutput, Turma turma) {
        this.nome = nome;
        this.unidadeEscolar = unidadeEscolar;
        this.anoEscolar = anoEscolar;
        this.turma = turma;
        cargaHoraria = 0;
        this.professores = new ArrayList<>();
        this.provas = new ArrayList<>();
        this.trabalhos = new ArrayList<>();
        this.pontosExtra = new ArrayList<>();
        
        this.output = OutputFactory.getInstance().getTipoOutput(tipoOutput);
    }

    /**
     * @Brief: Obtem o nome da disciplina
     * @Return: Nome da disciplina
     */
    public String getNome() {
        return nome;
    }

    /**
     * @Brief: Define o nome da disciplina
     * @Parameter: nome Nome da disciplina
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @Brief: Obtem a unidade escolar
     * @Return: Unidade escolar da disciplina
     */
    public String getUnidadeEscolar() {
        return unidadeEscolar;
    }

    /**
     * @Brief: Define a unidade escolar
     * @Parameter: unidadeEscolar Unidade escolar da disciplina
     */
    public void setUnidadeEscolar(String unidadeEscolar) {
        this.unidadeEscolar = unidadeEscolar;
    }

    /**
     * @Brief: Obtem o ano escolar da disciplina
     * @Return: Ano escolar da disciplina
     */
    public String getAnoEscolar() {
        return anoEscolar;
    }

    /**
     * @Brief: Define o ano escolar da disciplina
     * @Parameter: anoEscolar Ano escolar ao qual a disciplina pertence
     */
    public void setAnoEscolar(String anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    /**
     * @Brief: Obtem a ementa da disciplina
     * @Return: Ementa da disciplina
     */
    public String getEmenta() {
        return ementa;
    }

    /**
     * @Brief: Define a ementa da disciplina
     * @Parameter: ementa Conteúdo descritivo da disciplina
     */
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    /**
     * @Brief: Obtem os objetivos da disciplina
     * @Return: Objetivos da disciplina
     */
    public String getObjetivos() {
        return objetivos;
    }

    /**
     * @Brief: Define os objetivos da disciplina
     * @Parameter: objetivos Objetivos educacionais da disciplina
     */
    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    /**
     * @Brief: Obtem a metodologia de ensino da disciplina
     * @Return: Metodologia da disciplina
     */
    public String getMetodologia() {
        return metodologia;
    }

    /**
     * @Brief: Define a metodologia de ensino da disciplina
     * @Parameter: metodologia Metodologia utilizada na disciplina
     */
    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    /**
     * @Brief: Obtem o cálculo da média da disciplina
     * @Return: Fórmula ou lógica para cálculo da média
     */
    public String getCalculoMedia() {
        return calculoMedia;
    }

    /**
     * @Brief: Define o cálculo da média da disciplina
     * @Parameter: calculoMedia Fórmula ou lógica para cálculo da média
     */
    public void setCalculoMedia(String calculoMedia) {
        this.calculoMedia = calculoMedia;
    }

    /**
     * @Brief: Obtem a carga horária da disciplina
     * @Return: Carga horária da disciplina
     */
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * @Brief: Define a carga horária da disciplina
     * @Parameter: cargaHoraria Quantidade de horas da disciplina
     */
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * @Brief: Obtem a turma associada à disciplina
     * @Return: Turma associada à disciplina
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     * @Brief: Define a turma associada à disciplina
     * @Parameter: turma Objeto Turma associado à disciplina
     */
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    /**
     * @Brief: Obtém os professores associados à disciplina
     * @Return: Lista de professores da disciplina
     */
    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    @Override
    /**
     * @Brief: Calcula a média geral da turma associada à disciplina.
     * @Details: Soma as médias dos alunos e calcula a média aritmética.
     * @Return: Média geral da turma ou 0 se não houver alunos.
     */
    public double calcularMedia(){
        return mediaGeral();
    }


    /**
     * @Brief: Define os professores associados a disciplina
     * @Parameter: professores Lista de professores que lecionam a disciplina
     */
    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    /**
     * @Brief: Obtém as provas associadas a disciplina
     * @Return: Lista de provas da disciplina
     */
    public ArrayList<Prova> getProvas() {
        return provas;
    }

    /**
     * @Brief: Define as provas associadas a disciplina
     * @Parameter: provas Lista de provas realizadas na disciplina
     */
    public void setProvas(ArrayList<Prova> provas) {
        this.provas = provas;
    }

    /**
     * @Brief: Obtem os trabalhos associados à disciplina
     * @Return: Lista de trabalhos da disciplina
     */
    public ArrayList<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    /**
     * @Brief: Define os trabalhos associados à disciplina
     * @Parameter: trabalhos Lista de trabalhos realizados na disciplina
     */
    public void setTrabalhos(ArrayList<Trabalho> trabalhos) {
        this.trabalhos = trabalhos;
    }

    /**
     * @Brief: Obtém os pontos extras associados à disciplina
     * @Return: Lista de pontos extras da disciplina
     */
    public ArrayList<PontoExtra> getPontosExtra() {
        return pontosExtra;
    }

    /**
     * @Brief: Define os pontos extras associados à disciplina
     * @Parameter: pontosExtra Lista de pontos extras concedidos na disciplina
     */
    public void setPontosExtra(ArrayList<PontoExtra> pontosExtra) {
        this.pontosExtra = pontosExtra;
    }
    
    /**
     * @Brief: Exibe o plano de ensino da disciplina
     * @Details: Mostra detalhes como nome, objetivos, metodologia e cálculo de média
     */
    public void exibirPlanoDeEnsino() {
        output.display("Plano de Ensino - Disciplina\n");
        output.display("Unidade Escolar: " + unidadeEscolar);
        output.display("Identificação: " + nome);
        output.display("Carga Horária: " + cargaHoraria);
        output.display("Ementa: ");
        output.display(ementa);
        output.display("Objetivos: ");
        output.display(objetivos);
        output.display("Metodologia do Ensino: ");
        output.display(metodologia);
        output.display("Cálculo da Média: ");
        output.display(calculoMedia);
    }

    
    private double mediaGeral() {
        if (turma.getAlunos().size() > 0) {
            int i;
            double media = 0;

            for(i = 0; i < turma.getAlunos().size(); i++) {
                media+=turma.getAlunos().get(i).calcularMedia();
            }

            media/=turma.getAlunos().size();
            
            return media;
        }
        else {
            return 0;
        }
    }

    /**
     * @Brief: Adiciona um professor a disciplina
     * @Parameter: professor Objeto Professor a ser adicionado
     */
    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }
    
    /**
     * @Brief: Remove um professor da disciplina
     * @Parameter: professor Objeto Professor a ser removido
     */
    public void removerProfessor(Professor professor) {
        professores.remove(professor);
    }
    
    /**
     * @Brief: Adiciona uma prova à disciplina
     * @Parameter: prova Objeto Prova a ser adicionado
     */
    public void adicionarProva(Prova prova) {
        provas.add(prova);
    }
    
    /**
     * @Brief: Remove uma prova da disciplina
     * @Parameter: prova Objeto Prova a ser removido
     */
    public void removerProva(Prova prova) {
        provas.remove(prova);
    }
    
    /**
     * @Brief: Adiciona um trabalho a disciplina
     * @Parameter: trabalho Objeto Trabalho a ser adicionado
     */
    public void adicionarTrabalho(Trabalho trabalho) {
        trabalhos.add(trabalho);
    }
    
    /**
     * @Brief: Remove um trabalho da disciplina
     * @Parameter: trabalho Objeto Trabalho a ser removido
     */
    public void removerTrabalho(Trabalho trabalho) {
        trabalhos.remove(trabalho);
    }
    
    /**
     * @Brief: Adiciona um ponto extra a disciplina
     * @Parameter: pontoExtra Objeto PontoExtra a ser adicionado
     */
    public void adicionarPontoExtra(PontoExtra pontoExtra) {
        pontosExtra.add(pontoExtra);
    }
    
    /**
     * @Brief: Remove um ponto extra da disciplina
     * @Parameter: pontoExtra Objeto PontoExtra a ser removido
     */
    public void removerPontoExtra(PontoExtra pontoExtra) {
        pontosExtra.remove(pontoExtra);
    }

    /**
     * @Brief: Exibe o horário da disciplina com base em um objeto Horário
     * @Parameter: horario Objeto contendo os horários organizados por períodos
     * @Return: String formatada com o horário da disciplina
     */
    public String exibirHorario(Horario horario) {
        Map<String, List<Periodo>> horarios = horario.getHorario();
        String string = "";

        for(Map.Entry<String, List<Periodo>> entrada : horarios.entrySet()) {
            string += entrada.getKey() + "\n";

            for(Periodo per : entrada.getValue()) {
                if(per.getDisciplina().getNome().equals(this.nome)) {
                    string += per + "\n";          
                }
            }

            string += "\n";
        }

        return string;
    }
  
    public void removerTrabalhos(){
        trabalhos.clear();
    }
}
