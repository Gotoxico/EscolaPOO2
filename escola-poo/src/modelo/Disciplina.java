/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import modelo.Output.OutputConsole;
import modelo.Output.OutputFactory;
import modelo.Output.OutputInterface;
import interfaces.media;

/**
 *
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
    
    public Disciplina(OutputFactory outputFactory, String nome, String unidadeEscolar, String anoEscolar, 
                        String tipoOutput, String nomeTurma, String IDTurma, int quantidadeVagas) {
        this.nome = nome;
        this.unidadeEscolar = unidadeEscolar;
        this.anoEscolar = anoEscolar;
        this.turma = new Turma(nomeTurma, IDTurma, quantidadeVagas);
        cargaHoraria = 0;
        
        this.professores = new ArrayList<>();
        this.provas = new ArrayList<>();
        this.trabalhos = new ArrayList<>();
        this.pontosExtra = new ArrayList<>();
        
        this.output = OutputFactory.getInstance().getTipoOutput(tipoOutput);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidadeEscolar() {
        return unidadeEscolar;
    }

    public void setUnidadeEscolar(String unidadeEscolar) {
        this.unidadeEscolar = unidadeEscolar;
    }

    public String getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(String anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getCalculoMedia() {
        return calculoMedia;
    }

    public void setCalculoMedia(String calculoMedia) {
        this.calculoMedia = calculoMedia;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    @Override
    public double calcularMedia(){
        return mediaGeral();
    }


    /**
     * 
     * @param professores 
     */
    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    /**
     * 
     * @return 
     */
    public ArrayList<Prova> getProvas() {
        return provas;
    }

    public void setProvas(ArrayList<Prova> provas) {
        this.provas = provas;
    }

    public ArrayList<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(ArrayList<Trabalho> trabalhos) {
        this.trabalhos = trabalhos;
    }

    public ArrayList<PontoExtra> getPontosExtra() {
        return pontosExtra;
    }

    public void setPontosExtra(ArrayList<PontoExtra> pontosExtra) {
        this.pontosExtra = pontosExtra;
    }
    
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
                media+=turma.getAlunos().get(i).getMedia();
            }

            media/=turma.getAlunos().size();
            
            return media;
        }
        else {
            return 0;
        }
    }
    
    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }
    
    public void removerProfessor(Professor professor) {
        professores.remove(professor);
    }
    
    public void adicionarProva(Prova prova, float nota) {
        prova.setNota(nota);
        provas.add(prova);
    }
    
    public void removerProva(Prova prova) {
        provas.remove(prova);
    }
    
    public void adicionarTrabalho(Trabalho trabalho, float nota) {
        trabalho.setNota(nota);
        trabalhos.add(trabalho);
    }
    
    public void removerTrabalho(Trabalho trabalho) {
        trabalhos.remove(trabalho);
    }
    
    public void adicionarPontoExtra(PontoExtra pontoExtra, float valor) {
        pontoExtra.setValor(valor);
        pontosExtra.add(pontoExtra);
    }
    
    public void removerPontoExtra(PontoExtra pontoExtra) {
        pontosExtra.remove(pontoExtra);
    }
}
