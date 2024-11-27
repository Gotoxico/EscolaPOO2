/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import controlador.Escola;
import java.util.ArrayList;

/**
 * @Brief: Classe para gerenciamento de notas e atividades em disciplinas
 * @Details: Implementa um padrão Singleton para garantir uma única instância e fornece métodos para manipular provas, trabalhos, pontos extras e notas

 * @author rodri
 */
public class Notas {
    private static Notas instance;
    
    /**
     * @Brief: Obtem a instância única da classe
     * @Details: Cria a instância, caso ainda não exista, e retorna a existente
     * @Parameter: disciplinas Lista de disciplinas a ser associada a instância
     * @Return Instância única da classe Notas
     */
    public static Notas getInstance(ArrayList<Disciplina> disciplinas){
        if(instance == null){
            instance = new Notas(disciplinas);
        }
        return instance;
    }
    
    
    protected Escola escola;
    protected ArrayList<Disciplina> disciplinas;

    /**
     * @Brief: Construtor da classe
     * @Details: Inicializa a lista de disciplinas
     * @Parameter: disciplinas Lista de disciplinas associadas
     */
    public Notas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    /**
     * @Brief: Busca um professor pelo nome em uma disciplina
     * @Details: Itera sobre os professores da disciplina para encontrar o correspondente pelo nome
     * @Parameter: disciplina Disciplina onde o professor leciona
     * @Parameter: nomeProfessor Nome do professor a ser buscado
     * @Return Objeto Professor correspondente ou null se não encontrado
     */
    public Professor getNomeProfessor(Disciplina disciplina, String nomeProfessor){
        ArrayList<Professor> professores = disciplina.getProfessores();
        for(Professor professor : professores){
            if(professor.getNome().equals(nomeProfessor)){
                return professor;
            }
        }
        return null;
    }
    
    /**
     * @Brief: Busca uma turma pelo nome em uma disciplina
     * @Details: Verifica se a turma associada à disciplina tem o nome especificado
     * @Parameter: disciplina Disciplina onde a turma está associada
     * @Parameter: nomeTurma Nome da turma a ser buscada
     * @Return Objeto Turma correspondente ou `null` se não encontrado
     */
    public Turma getNomeTurma(Disciplina disciplina, String nomeTurma){
        Turma turma = disciplina.getTurma();
        if(turma.getNomeTurma().equals(nomeTurma)){
            return turma;
        }
        return null;
    }
    
    /**
     * @Brief: Busca uma prova pelo nome em uma disciplina
     * @Details: Intera sobre as provas da disciplina para encontrar a correspondente pelo nome
     * @Parameter: disciplina Disciplina associada à prova
     * @Parameter: nomeProva Nome da prova a ser buscada
     * @Return Objeto Prova correspondente ou `null` se não encontrado
     */
    public Prova getNomeProva(Disciplina disciplina, String nomeProva){
        ArrayList<Prova> provas = disciplina.getProvas();
        for(Prova prova : provas){
            if(prova.getNomeProva().equals(nomeProva)){
                return prova;
            }
        }
        return null;
    }
    
    /**
     * @Brief: Busca um trabalho pelo nome em uma disciplina
     * @Details: Intera sobre os trabalhos da disciplina para encontrar o correspondente pelo nome
     * @Parameter: disciplina Disciplina associada ao trabalho
     * @Parameter: nomeTrabalho Nome do trabalho a ser buscado
     * @Return Objeto Trabalho correspondente ou null se não encontrado
     */
    public Trabalho getNomeTrabalho(Disciplina disciplina, String nomeTrabalho){
        ArrayList<Trabalho> trabalhos = disciplina.getTrabalhos();
        for(Trabalho trabalho : trabalhos){
            if(trabalho.getNomeTrabalho().equals(nomeTrabalho)){
                return trabalho;
            }
        }
        return null;
    }
    
    /**
     * @Brief: Busca um ponto extra pelo nome em uma disciplina
     * @Details: Intera sobre os pontos extras da disciplina para encontrar o correspondente pelo nome
     * @Parameter: disciplina Disciplina associada ao ponto extra
     * @Parameter: nomePontoExtra Nome do ponto extra a ser buscado
     * @Return Objeto PontoExtra correspondente ou null se não encontrado
     */
    public PontoExtra getNomePontoExtra(Disciplina disciplina, String nomePontoExtra){
        ArrayList<PontoExtra> pontosExtra = disciplina.getPontosExtra();
        for(PontoExtra pontoExtra : pontosExtra){
            if(pontoExtra.getNomePontoExtra().equals(nomePontoExtra)){
                return pontoExtra;
            }
        }
        return null;
    }
    
    /**
     * @Brief: Busca um aluno pelo nome em uma turma
     * @Details: Intera sobre os alunos da turma para encontrar o correspondente pelo nome
     * @Parameter: turma Turma associada ao aluno
     * @Parameter: nomeAluno Nome do aluno a ser buscado
     * @Return Objeto Aluno correspondente ou null se nao encontrado
     */
    public Aluno getNomeAluno(Turma turma, String nomeAluno){
        ArrayList<Aluno> alunos = turma.getAlunos();
        for(Aluno aluno : alunos){
            if(aluno.getNome().equals(nomeAluno)){
                return aluno;
            }
        }
        return null;
    }

    /**
     * @Brief: Remove uma prova de uma disciplina
     * @Details: Busca a prova pelo nome e remove-a da lista de provas da disciplina
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeProfessor Nome do professor responsável
     * @Parameter: nomeProva Nome da prova a ser removida
     * @Parameter: nomeTurma Nome da turma onde a prova foi aplicada
     * @Parameter: peso Peso da prova (usado para verificar consistência)
     */
    public void removerProvaDisciplina(String nomeDisciplina, String nomeProfessor, String nomeProva, String nomeTurma, float peso){
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getNome().equals(nomeDisciplina) && getNomeProfessor(disciplina, nomeProfessor) != null && getNomeTurma(disciplina, nomeTurma) != null){
                Prova p = getNomeProva(disciplina, nomeProva);
                disciplina.removerProva(p);
            }
        }
    }
    
    /**
     * @Brief: Remove um trabalho de uma disciplina
     * @Details: Busca o trabalho pelo nome e remove-o da lista de trabalhos da disciplina
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeProfessor Nome do professor responsável
     * @Parameter: nomeTrabalho Nome do trabalho a ser removido
     * @Parameter: nomeTurma Nome da turma onde o trabalho foi atribuído
     * @Parameter: peso Peso do trabalho (usado para verificar consistência)
     */
    public void removerTrabalhoDisciplina(String nomeDisciplina, String nomeProfessor, String nomeTrabalho, String nomeTurma, float peso){
        for(Disciplina disciplina : disciplinas){
            if(disciplina.getNome().equals(nomeDisciplina) && getNomeProfessor(disciplina, nomeProfessor) != null && getNomeTurma(disciplina, nomeTurma) != null){
                Trabalho t = getNomeTrabalho(disciplina, nomeTrabalho);
                disciplina.removerTrabalho(t);
            }
        }
    }
    
    /**
     * @Brief: Remove um ponto extra de uma disciplina
     * @Details: Busca o ponto extra pelo nome e remove-o da lista de pontos extras da disciplina
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeProfessor Nome do professor responsável
     * @Parameter: nomePontoExtra Nome do ponto extra a ser removido
     * @Parameter: nomeTurma Nome da turma onde o ponto extra foi aplicado
     */
    public void removerPontoExtraDisciplina(String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma){
        for(Disciplina disciplina : disciplinas){
            if(disciplina.getNome().equals(nomeDisciplina) && getNomeProfessor(disciplina, nomeProfessor) != null && getNomeTurma(disciplina, nomeTurma) != null){
                PontoExtra pe = getNomePontoExtra(disciplina, nomePontoExtra);
                disciplina.removerPontoExtra(pe);
            }
        }
    }
    
    /**
     * @Brief: Adiciona uma nova prova a uma disciplina
     * @Details: Verifica as condições necessárias (disciplina, professor, turma) antes de criar e adicionar a prova
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeProfessor Nome do professor responsável
     * @Parameter: nomeProva Nome da nova prova
     * @Parameter: nomeTurma Nome da turma onde a prova será aplicada
     * @Parameter: peso Peso da prova
     */
    public void adicionarProvaDisciplina(String nomeDisciplina, String nomeProfessor, String nomeProva, String nomeTurma, float peso) {
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getNome().equals(nomeDisciplina) && getNomeProfessor(disciplina, nomeProfessor) != null && getNomeTurma(disciplina, nomeTurma) != null){
                Prova p = new Prova(nomeProva, peso);
                disciplina.adicionarProva(p);
            }
        }
    }
    
    /**
     * @Brief: Adiciona um novo trabalho a uma disciplina
     * @Details: Verifica as condições necessárias antes de criar e adicionar o trabalho
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeProfessor Nome do professor responsável
     * @Parameter: nomeTurma Nome da turma onde o trabalho será atribuído
     * @Parameter: nomeTrabalho Nome do novo trabalho
     * @Parameter: peso Peso do trabalho
     */
    public void adicionarTrabalhoDisciplina(String nomeDisciplina, String nomeProfessor, String nomeTurma, String nomeTrabalho, float peso) {
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getNome().equals(nomeDisciplina) && getNomeProfessor(disciplina, nomeProfessor) != null && getNomeTurma(disciplina, nomeTurma) != null){
                Trabalho t = new Trabalho(nomeTrabalho, peso);
                disciplina.adicionarTrabalho(t);
            }
        }
    }
    
    /**
     * @Brief: Adiciona um ponto extra a uma disciplina
     * @Details: Verifica as condições necessárias antes de criar e adicionar o ponto extra
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeProfessor Nome do professor responsável
     * @Parameter: nomePontoExtra Nome do ponto extra
     * @Parameter: nomeTurma Nome da turma onde o ponto extra será aplicado
     * @Parameter: valorMaximo Valor máximo do ponto extra
     */
    public void adicionarPontoExtraDisciplina(String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma, float valorMaximo) {
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getNome().equals(nomeDisciplina) && getNomeProfessor(disciplina, nomeProfessor) != null && getNomeTurma(disciplina, nomeTurma) != null){
                PontoExtra pe = new PontoExtra(nomePontoExtra, valorMaximo);
                disciplina.adicionarPontoExtra(pe);
            }
        }
    }
    
    /**
     * @Brief: Adiciona uma nota de prova a um aluno
     * @Details: Localiza o aluno na turma, a prova na disciplina e atribui a nota especificada
     * @Parameter: nomeAluno Nome do aluno
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeProfessor Nome do professor responsável
     * @Parameter: nomeProva Nome da prova
     * @Parameter: notaProva Nota a ser atribuída
     * @Parameter: nomeTurma Nome da turma
     */
    public void adicionarNotaProva(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeProva, float notaProva, String nomeTurma) {
        for (Disciplina disciplina : disciplinas){
            Turma t = getNomeTurma(disciplina, nomeTurma);
            Aluno a = getNomeAluno(t, nomeAluno);
            if(a != null){
                Prova prova = getNomeProva(disciplina, nomeProva);
                if(prova != null){
                    prova.setNota(notaProva);
                    a.setNotaProva(prova);
                }
            }
        }
    }
    
    /**
     * @Brief: Adiciona uma nota de trabalho a um aluno
     * @Details: Localiza o aluno na turma, o trabalho na disciplina e atribui a nota especificada
     * @Parameter: nomeAluno Nome do aluno
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeProfessor Nome do professor responsável
     * @Parameter: nomeTrabalho Nome do trabalho
     * @Parameter: notaTrabalho Nota a ser atribuída
     * @Parameter: nomeTurma Nome da turma
     */
    public void adicionarNotaTrabalho(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeTrabalho, float notaTrabalho, String nomeTurma) {
        for (Disciplina disciplina : disciplinas){
            Turma t = getNomeTurma(disciplina, nomeTurma);
            Aluno a = getNomeAluno(t, nomeAluno);
            if(a != null){
                Trabalho trabalho = getNomeTrabalho(disciplina, nomeTrabalho);
                if(trabalho != null){
                    trabalho.setNota(notaTrabalho);
                    a.setNotaTrabalho(trabalho);
                }
            }
        }
    }
    
    /**
     * @Brief: Adiciona um ponto extra a um aluno
     * @Details: Localiza o aluno na turma, o ponto extra na disciplina e atribui o valor especificado
     * @Parameter: nomeAluno Nome do aluno
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeProfessor Nome do professor responsável
     * @Parameter: nomePontoExtra Nome do ponto extra
     * @Parameter: nomeTurma Nome da turma
     * @Parameter: valor Valor do ponto extra a ser atribuído
     */
    public void adicionarNotaPontoExtra(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma, float valor) {
        for (Disciplina disciplina : disciplinas){
            Turma t = getNomeTurma(disciplina, nomeTurma);
            Aluno a = getNomeAluno(t, nomeAluno);
            if(a != null){
                PontoExtra pontoExtra = getNomePontoExtra(disciplina, nomePontoExtra);
                if(pontoExtra != null){
                    pontoExtra.setValor(valor);
                    a.setNotaPontoExtra(pontoExtra);
                }
            }
        }
    }
    
    /**
     * @Brief: Remove a nota de uma prova atribuída a um aluno
     * @Details: Localiza o aluno e a prova na disciplina, removendo a nota associada
     * @Parameter: nomeAluno Nome do aluno
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeProfessor Nome do professor responsável
     * @Parameter: nomeProva Nome da prova
     * @Parameter: notaProva Nota a ser removida
     * @Parameter: nomeTurma Nome da turma
     */
    public void removerNotaProva(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeProva, float notaProva, String nomeTurma) {
        for(Disciplina disciplina : disciplinas){
            Turma t = getNomeTurma(disciplina, nomeTurma);
            Aluno a = getNomeAluno(t, nomeAluno);
            if(a != null){
                Prova prova = getNomeProva(disciplina, nomeProva);
                if(prova != null){
                    a.removerNotaProva(prova);
                }
            }
        }
    }
    
    /**
     * @Brief: Remove a nota de um trabalho atribuída a um aluno
     * @Details: Localiza o aluno e o trabalho na disciplina, removendo a nota associada
     * @Parameter: nomeAluno Nome do aluno
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeProfessor Nome do professor responsável
     * @Parameter: nomeTrabalho Nome do trabalho
     * @Parameter: notaTrabalho Nota a ser removida
     * @Parameter: nomeTurma Nome da turma
     */
    public void removerNotaTrabalho(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeTrabalho, float notaTrabalho, String nomeTurma) {
        for (Disciplina disciplina : disciplinas){
            Turma t = getNomeTurma(disciplina, nomeTurma);
            Aluno a = getNomeAluno(t, nomeAluno);
            if(a != null){
                Trabalho trabalho = getNomeTrabalho(disciplina, nomeTrabalho);
                if(trabalho != null){
                    a.removerNotaTrabalho(trabalho);
                }
            }
        }
    }
    
    /**
     * @Brief: Remove um ponto extra atribuído a um aluno
     * @Details: Localiza o aluno e o ponto extra na disciplina, removendo o valor associado
     * @Parameter: nomeAluno Nome do aluno
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeProfessor Nome do professor responsável
     * @Parameter: nomePontoExtra Nome do ponto extra
     * @Parameter: nomeTurma Nome da turma
     * @Parameter: valor Valor do ponto extra a ser removido
     */
    public void removerNotaPontoExtra(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma, float valor) {
        for (Disciplina disciplina : disciplinas){
            Turma t = getNomeTurma(disciplina, nomeTurma);
            Aluno a = getNomeAluno(t, nomeAluno);
            if(a != null){
                PontoExtra pontoExtra = getNomePontoExtra(disciplina, nomePontoExtra);
                if(pontoExtra != null){
                    a.removerNotaPontoExtra(pontoExtra);
                }
            }
        }
    }

    /**
     * @Brief: Remove todos os trabalhos de uma disciplina
     * @Details: Verifica a disciplina, professor e turma antes de remover todos os trabalhos associados
     * @Parameter: nomeDisciplina Nome da disciplina
     * @Parameter: nomeProfessor Nome do professor responsável
     * @Parameter: nomeTurma Nome da turma
     */
    public void removerTrabalhos(String nomeDisciplina, String nomeProfessor, String nomeTurma) {
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getNome().equals(nomeDisciplina) && getNomeProfessor(disciplina, nomeProfessor) != null && getNomeTurma(disciplina, nomeTurma) != null){
                disciplina.removerTrabalhos();
            }
            
        }
        
    }
    
}
