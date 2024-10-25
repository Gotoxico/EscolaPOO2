/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Daniel Servejeira
 */
public class Disciplina {
    private String nome;
    private String unidadeEscolar;
    private String anoEscolar;
    private String ementa;
    private String objetivos;
    private String metodologia;
    private String calculoMedia;
    private int cargaHoraria;
    private ArrayList<Notas> notas;
    private ArrayList<Turma> turmas;
    private ArrayList<Professor> professores;
    private ArrayList<Prova> provas;
    private ArrayList<Trabalho> trabalhos;
    private ArrayList<PontoExtra> pontosExtra;
    
    public Disciplina(String nome, String unidadeEscolar, String anoEscolar) {
        this.nome = nome;
        this.unidadeEscolar = unidadeEscolar;
        this.anoEscolar = anoEscolar;
        cargaHoraria = 0;

        this.notas = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.provas = new ArrayList<>();
        this.trabalhos = new ArrayList<>();
        this.pontosExtra = new ArrayList<>();
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

    public ArrayList<Notas> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Notas> notas) {
        this.notas = notas;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

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
        System.out.println("Plano de Ensino - Disciplina\n");
        System.out.println("Unidade Escolar: " + unidadeEscolar);
        System.out.println("Identificação: " + nome);
        System.out.println("Carga Horária: " + cargaHoraria);
        System.out.println("Ementa: ");
        System.out.println(ementa);
        System.out.println("Objetivos: ");
        System.out.println(objetivos);
        System.out.println("Metodologia do Ensino: ");
        System.out.println(metodologia);
        System.out.println("Cálculo da Média: ");
        System.out.println(calculoMedia);
    }
    
    public double mediaTurma(Turma turma) {
    	if(turma.getAlunos().size() > 0) {
            double media = 0;

            for(Aluno aluno : turma.getAlunos()) {
            	media+=aluno.getMedia();
            }

            return media/turma.getAlunos().size();
    	}
    	else {
            return 0;
    	}
    }
    
    public double mediaGeral() {
        if (turmas.size() > 0) {
            double media = 0;

            for(Turma i : turmas) {
                media+=mediaTurma(i);
            }

            media/=turmas.size();
            
            return media;
        }
        else {
            return 0;
        }
    }
    
    public void adicionarNota(Notas nota) {
        notas.add(nota);
    }
    
    public void removerNota(Notas nota) {
        notas.remove(nota);
    }
    
    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }
    
    public void removerTurma(Turma turma) {
        turmas.remove(turma);
    }
    
    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }
    
    public void removerProfessor(Professor professor) {
        professores.remove(professor);
    }
    
    public void adicionarProva(Prova prova) {
        provas.add(prova);
    }
    
    public void removerProva(Prova prova) {
        provas.remove(prova);
    }
    
    public void adicionarTrabalho(Trabalho trabalho) {
        trabalhos.add(trabalho);
    }
    
    public void removerTrabalho(Trabalho trabalho) {
        trabalhos.remove(trabalho);
    }
    
    public void adicionarPontoExtra(PontoExtra pontoExtra) {
        pontosExtra.add(pontoExtra);
    }
    
    public void removerPontoExtra(PontoExtra pontoExtra) {
        pontosExtra.remove(pontoExtra);
    }
}
