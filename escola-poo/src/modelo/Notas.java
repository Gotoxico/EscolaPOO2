/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;

/**
 *
 * @author rodri
 */
public class Notas {
    protected ArrayList<Disciplina> disciplinas;

    public Notas() {
    }

    public Notas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    
    //Metodos para obter um objeto baseado em seu nome
    public Professor getNomeProfessor(Disciplina disciplina, String nomeProfessor){
        ArrayList<Professor> professores = disciplina.getProfessores();
        for(Professor professor : professores){
            if(professor.getNome().equals(nomeProfessor)){
                return professor;
            }
        }
        return null;
    }
    
    public Turma getNomeTurma(Disciplina disciplina, String nomeTurma){
        ArrayList<Turma> turmas = disciplina.getTurmas();
        for(Turma turma : turmas){
            if(turma.getNomeTurma().equals(nomeTurma)){
                return turma;
            }
        }
        return null;
    }
    
    public Prova getNomeProva(Disciplina disciplina, String nomeProva){
        ArrayList<Prova> provas = disciplina.getProvas();
        for(Prova prova : provas){
            if(prova.getNomeProva().equals(nomeProva)){
                return prova;
            }
        }
        return null;
    }
    
    public Trabalho getNomeTrabalho(Disciplina disciplina, String nomeTrabalho){
        ArrayList<Trabalho> trabalhos = disciplina.getTrabalhos();
        for(Trabalho trabalho : trabalhos){
            if(trabalho.getNomeTrabalho().equals(nomeTrabalho)){
                return trabalho;
            }
        }
        return null;
    }
    
    public PontoExtra getNomePontoExtra(Disciplina disciplina, String nomePontoExtra){
        ArrayList<PontoExtra> pontosExtra = disciplina.getPontosExtra();
        for(PontoExtra pontoExtra : pontosExtra){
            if(pontoExtra.getNomePontoExtra().equals(nomePontoExtra)){
                return pontoExtra;
            }
        }
        return null;
    }
    
    public Aluno getNomeAluno(Turma turma, String nomeAluno){
        ArrayList<Aluno> alunos = turma.getAlunos();
        for(Aluno aluno : alunos){
            if(aluno.getNome().equals(nomeAluno)){
                return aluno;
            }
        }
        return null;
    }

    
    //Metodos para remover e adicionar Provas, Trabalhos e PontosExtra
    public void removerProvaDisciplina(String nomeDisciplina, String nomeProfessor, String nomeProva, String nomeTurma, float peso){
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getNome().equals(nomeDisciplina) && getNomeProfessor(disciplina, nomeProfessor) != null && getNomeTurma(disciplina, nomeTurma) != null){
                Prova p = getNomeProva(disciplina, nomeProva);
                disciplina.removerProva(p);
            }
        }
    }
    
    public void removerTrabalhoDisciplina(String nomeDisciplina, String nomeProfessor, String nomeTrabalho, String nomeTurma, float peso){
        for(Disciplina disciplina : disciplinas){
            if(disciplina.getNome().equals(nomeDisciplina) && getNomeProfessor(disciplina, nomeProfessor) != null && getNomeTurma(disciplina, nomeTurma) != null){
                Trabalho t = getNomeTrabalho(disciplina, nomeTrabalho);
                disciplina.removerTrabalho(t);
            }
        }
    }
    
    public void removerPontoExtraDisciplina(String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma, float valorMaximo){
        for(Disciplina disciplina : disciplinas){
            if(disciplina.getNome().equals(nomeDisciplina) && getNomeProfessor(disciplina, nomeProfessor) != null && getNomeTurma(disciplina, nomeTurma) != null){
                PontoExtra pe = getNomePontoExtra(disciplina, nomePontoExtra);
                disciplina.removerPontoExtra(pe);
            }
        }
    }
    
    public void adicionarProvaDisciplina(String nomeDisciplina, String nomeProfessor, String nomeProva, String nomeTurma, float peso) {
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getNome().equals(nomeDisciplina) && getNomeProfessor(disciplina, nomeProfessor) != null && getNomeTurma(disciplina, nomeTurma) != null){
                Prova p = new Prova(nomeProva, peso);
                disciplina.adicionarProva(p);
            }
        }
    }
    
    public void adicionarTrabalhoDisciplina(String nomeDisciplina, String nomeProfessor, String nomeTurma, String nomeTrabalho, float peso) {
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getNome().equals(nomeDisciplina) && getNomeProfessor(disciplina, nomeProfessor) != null && getNomeTurma(disciplina, nomeTurma) != null){
                Trabalho t = new Trabalho(nomeTrabalho, peso);
                disciplina.adicionarTrabalho(t);
            }
        }
    }
    
    public void adicionarPontoExtraDisciplina(String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma, float valorMaximo) {
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getNome().equals(nomeDisciplina) && getNomeProfessor(disciplina, nomeProfessor) != null && getNomeTurma(disciplina, nomeTurma) != null){
                PontoExtra pe = new PontoExtra(nomePontoExtra, valorMaximo);
                disciplina.adicionarPontoExtra(pe);
            }
        }
    }
    
    //Metodos para adicionar e remover NotasProvas, Trabalhos e PontosExtra
    public void adicionarNotaProva(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeProva, float notaProva, String nomeTurma) {
        for (Disciplina disciplina : disciplinas){
            Turma t = getNomeTurma(disciplina, nomeTurma);
            Aluno a = getNomeAluno(t, nomeAluno);
            if(a != null){
                if(getNomeProva(disciplina, nomeProva) != null){
                    a.setNotaProva(nomeProva, notaProva);
                }
            }
        }
    }
    
    public void adicionarNotaTrabalho(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeTrabalho, float notaTrabalho, String nomeTurma) {
        for (Disciplina disciplina : disciplinas){
            Turma t = getNomeTurma(disciplina, nomeTurma);
            Aluno a = getNomeAluno(t, nomeAluno);
            if(a != null){
                if(getNomeTrabalho(disciplina, nomeTrabalho) != null){
                    a.setNotaTrabalho(nomeTrabalho, notaTrabalho);
                }
            }
        }
    }
    
    public void adicionarNotaPontoExtra(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma, float valor) {
        for (Disciplina disciplina : disciplinas){
            Turma t = getNomeTurma(disciplina, nomeTurma);
            Aluno a = getNomeAluno(t, nomeAluno);
            if(a != null){
                if(getNomePontoExtra(disciplina, nomePontoExtra) != null){
                    a.setNotaPontoExtra(nomePontoExtra, valor);
                }
            }
        }
    }
    
    public void removerNotaProva(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeProva, float notaProva, String nomeTurma) {
        for(Disciplina disciplina : disciplinas){
            Turma t = getNomeTurma(disciplina, nomeTurma);
            Aluno a = getNomeAluno(t, nomeAluno);
            if(a != null){
                if(getNomeProva(disciplina, nomeProva) != null){
                    a.setNotaProva(nomeProva, null);
                }
            }
        }
    }
    
    public void removerNotaTrabalho(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeTrabalho, float notaTrabalho, String nomeTurma) {
        for (Disciplina disciplina : disciplinas){
            Turma t = getNomeTurma(disciplina, nomeTurma);
            Aluno a = getNomeAluno(t, nomeAluno);
            if(a != null){
                if(getNomeTrabalho(disciplina, nomeTrabalho) != null){
                    a.setNotaTrabalho(nomeTrabalho, null);
                }
            }
        }
    }
    
    public void removerNotaPontoExtra(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma, float valor) {
        for (Disciplina disciplina : disciplinas){
            Turma t = getNomeTurma(disciplina, nomeTurma);
            Aluno a = getNomeAluno(t, nomeAluno);
            if(a != null){
                if(getNomePontoExtra(disciplina, nomePontoExtra) != null){
                    a.setNotaPontoExtra(nomePontoExtra, null);
                }
            }
        }
    }
    
}
