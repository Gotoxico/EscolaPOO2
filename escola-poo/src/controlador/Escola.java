package controlador;

import Horario.Horario;
import java.util.ArrayList;
import java.util.UUID;
import modelo.*;
import modelo.Output.OutputFactory;

public class Escola{
	private ArrayList<Aluno> alunos;
	private ArrayList<Professor> professores;
	private ArrayList<Turma> turmas;
	private ArrayList<Disciplina> disciplinas;
	private BibliotecaEscolar biblioteca;
        private Notas notas;
        private final OutputFactory outputFactory;
        private String tipoOutput;

	public Escola(OutputFactory outputFactory, String tipoOutput){
		this.alunos = new ArrayList<>();
		this.professores = new ArrayList<>();
		this.turmas = new ArrayList<>();
		this.disciplinas = new ArrayList<>();
		this.biblioteca = new BibliotecaEscolar(outputFactory, tipoOutput);
                this.notas = new Notas();
                this.outputFactory = outputFactory;
                this.tipoOutput = tipoOutput;
	}

	public ArrayList<Turma> getTodasTurmas(){
		return this.turmas;
	}

	public ArrayList<Aluno> getTodosAlunos(){
		return this.alunos;
	}

	public ArrayList<Professor> getTodosProfessores(){
		return this.professores;
	}

	public ArrayList<Disciplina> getTodasDisciplinas(){
		return this.disciplinas;
	}

	public Disciplina getDisciplinaNome(String nome){
		Disciplina temp;
		for(int i=0; i < this.disciplinas.size(); i++){
			temp = this.disciplinas.get(i);
			if(temp.getNome().equals(nome)){
				return temp;
			}
		}
		return null;
	}

	public BibliotecaEscolar getBiblioteca(){
		return this.biblioteca;
	}

	public Turma getTurmaId(String idTurma){
		Turma temp;
		for(int i=0; i < this.turmas.size(); i++){
			temp = this.turmas.get(i);
			if(temp.getID().equals(idTurma)){
				return temp;
			}
		}
		return null;
	}

	public Aluno getAlunoMatricula(String matricula){
		Aluno temp;
		for(int i=0; i < this.alunos.size(); i++){
			temp = this.alunos.get(i);
			if(temp.getMatricula().equals(matricula)){
				return temp;
			}
		}
		return null;
	}

	public Professor getProfessorId(String idProfessor){
		Professor temp;
		for(int i=0; i < this.professores.size(); i++){
			temp = this.professores.get(i);
			if(temp.getID().equals(idProfessor)){
				return temp;
			}
		}
		return null;
	}


	public void addProfessor(String nome, String titulacao){
		UUID id = UUID.randomUUID();
		Logger logger = Logger.getInstance();

		Professor novo = new Professor();

		novo.setID(id.toString());
		novo.setNome(nome);
		novo.setTitulacao(titulacao);

		this.professores.add(novo);
		logger.gravaArquivo(String.format("Professor %s adicionado", nome), Logger.Level.INFO);
	}

	public void addDisciplina(String nome, String unidadeEscolar, String anoEscolar){
		Logger logger = Logger.getInstance();

		Disciplina nova = new Disciplina(outputFactory, nome, unidadeEscolar, anoEscolar, tipoOutput);
		this.disciplinas.add(nova);
		logger.gravaArquivo(String.format("Disciplina %s para o ano escolar '%s' adicionada", nome, anoEscolar), Logger.Level.INFO);
	}

	public void addTurma(String nome, int quantidadeVagas){
		UUID id = UUID.randomUUID();
		Logger logger = Logger.getInstance();

		Turma novo = new Turma(nome, id.toString(), quantidadeVagas);

		logger.gravaArquivo(String.format("Turma %s adicionado", nome), Logger.Level.INFO);
		this.turmas.add(novo);
	}

	public void addAlunoTurma(String nome, String idTurma){
		UUID id = UUID.randomUUID();
		UUID matricula = UUID.randomUUID();
		Logger logger = Logger.getInstance();

		Aluno novo = new Aluno(outputFactory, nome, id.toString(), matricula.toString(), "teste", 0.0f, tipoOutput);

		this.alunos.add(novo);

		System.out.print("ID: "+idTurma+"\n");
		Turma turma = this.getTurmaId(idTurma);

		if(turma != null){
			turma.adicionarAluno(novo);
			logger.gravaArquivo(String.format("Aluno '%s' adicionado na turma de id '%s'", nome, idTurma), Logger.Level.INFO);
		}else{
			logger.gravaArquivo(String.format("Aluno '%s' não adicionado, turma de id '%s' inexistente", nome, idTurma), Logger.Level.ERROR);
		}
	}

	public void trocaAlunoTurma(String matricula, String idTurma){
		Aluno aluno = this.getAlunoMatricula(matricula);
		Turma turma = this.getTurmaId(idTurma);
		Logger logger = Logger.getInstance();

		if(aluno != null && turma != null){
			turma.adicionarAluno(aluno);
			logger.gravaArquivo(String.format("Aluno de matricula %s trocou para a turma de id '%s'", matricula, idTurma), Logger.Level.INFO);
		}else{
			logger.gravaArquivo(String.format("Aluno de matricula '%s' não trocou para a turma de id '%s'", matricula, idTurma), Logger.Level.ERROR);
		}
	}

	public void addDisciplinaTurma(String nome, String idTurma){
		Disciplina disciplina = this.getDisciplinaNome(nome);
		Turma turma = this.getTurmaId(idTurma);
		Logger logger = Logger.getInstance();

		if(disciplina != null && turma != null){
			turma.adicionarDisciplinas(disciplina);
			logger.gravaArquivo(String.format("Disciplina %s adicionada à turma %s", nome, turma.getNomeTurma()), Logger.Level.INFO);
		}else{
			logger.gravaArquivo(String.format("Disciplina %s não adicionada à turma", nome, turma.getNomeTurma()), Logger.Level.ERROR);
		}
	}

	public void removerDisciplinaTurma(String nome, String idTurma){
		Disciplina disciplina = this.getDisciplinaNome(nome);
		Turma turma = this.getTurmaId(idTurma);

		if(disciplina != null && turma != null){
			turma.removerDisciplina(disciplina);
		}
	}

	public void addHorarioTurma(Horario h, String idTurma, Disciplina disciplina){
		Turma turma = this.getTurmaId(idTurma);

		if(turma != null){
                    turma.setHorario(h);
                }
	}

	public void removerHorarioTurma(Horario h, String idTurma){
		Turma turma = this.getTurmaId(idTurma);

		if(turma != null){
                     turma.setHorario(null);
		}
	}

	public void addLivroBiblioteca(String titulo, String autor, String isbn){
		Livro novo = new Livro(titulo, autor, isbn);
		Logger logger = Logger.getInstance();

		biblioteca.addLivro(novo);
		logger.gravaArquivo(String.format("Livro '%s' de '%s' foi adicionado à biblioteca", titulo, autor), Logger.Level.INFO);
	}

	public void addProfessorBiblioteca(String idProfessor){
		Professor temp = this.getProfessorId(idProfessor);
		if(temp != null){
			biblioteca.addUsuario(temp);
		}
	}

	public void addAlunoBiblioteca(String matricula){
		Aluno temp = this.getAlunoMatricula(matricula);
		if(temp != null){
			biblioteca.addUsuario(temp);
		}
	}

	/*
	public void emprestimoAluno(Livro livro, String matricula){
		Aluno temp = this.getAlunoMatricula(matricula);
		if(temp != null){
			biblioteca.emprestimo(livro, temp);
		}
	}

	public void emprestimoProfessor(Livro livro, String idProfessor){
		Professor temp = this.getProfessorId(idProfessor);
		if(temp != null){
			biblioteca.emprestimo(livro, temp);
		}
	}

	public void devolucaoAluno(Livro livro, String matricula){
		Aluno temp = this.getAlunoMatricula(matricula);
		if(temp != null){
			biblioteca.devolucao(livro, temp);
		}
	}

	public void devolucaoProfessor(Livro livro, String idProfessor){
		Professor temp = this.getProfessorId(idProfessor);
		if(temp != null){
			biblioteca.emprestimo(livro, temp);
		}
	}
	*/

	public void addIniciacaoCientificaAluno(String matricula, IniciacaoCientifica ic){
		Aluno temp = this.getAlunoMatricula(matricula);
		if(temp != null){
			//aluno.addIniciacaoCientifica(temp);
		}
	}

	public void addPalestraAluno(String matricula, Palestra p){
		Aluno temp = this.getAlunoMatricula(matricula);
		if(temp != null){
			//aluno.addPalestra(temp);
		}
	}
	
	public void addCursoExtraAluno(String matricula, CursoExtra ce){
		Aluno temp = this.getAlunoMatricula(matricula);
		if(temp != null){
			//aluno.addCursoExtra(temp);
		}
	}
        
        //Chamadas metodos classe gerenciadora Notas
        
        public void removerProvaDisciplina(String nomeDisciplina, String nomeProfessor, String nomeProva, String nomeTurma, float peso){
            notas.removerProvaDisciplina(nomeDisciplina, nomeProfessor, nomeProva, nomeTurma, peso);
        }
        
        public void removerTrabalhoDisciplina(String nomeDisciplina, String nomeProfessor, String nomeTrabalho, String nomeTurma, float peso){
            notas.removerTrabalhoDisciplina(nomeDisciplina, nomeProfessor, nomeTrabalho, nomeTurma, peso);
        }
        
        public void removerPontoExtraDisciplina(String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma, float valorMaximo){
            notas.removerPontoExtraDisciplina(nomeDisciplina, nomeProfessor, nomePontoExtra, nomeTurma, valorMaximo);
        }
        
        public void adicionarProvaDisciplina(String nomeDisciplina, String nomeProfessor, String nomeProva, String nomeTurma, float peso){
            notas.adicionarProvaDisciplina(nomeDisciplina, nomeProfessor, nomeProva, nomeTurma, peso);
        }
        
        public void adicionarTrabalhoDisciplina(String nomeDisciplina, String nomeProfessor, String nomeTurma, String nomeTrabalho, float peso) {
            notas.adicionarTrabalhoDisciplina(nomeDisciplina, nomeProfessor, nomeTurma, nomeTrabalho, peso);
        }
        
        public void adicionarPontoExtraDisciplina(String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma, float valorMaximo) {
            notas.adicionarPontoExtraDisciplina(nomeDisciplina, nomeProfessor, nomePontoExtra, nomeTurma, valorMaximo);
        }
        
        public void adicionarNotaProva(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeProva, float notaProva, String nomeTurma) {
            notas.adicionarNotaProva(nomeAluno, nomeDisciplina, nomeProfessor, nomeProva, notaProva, nomeTurma);
        }
        
        public void adicionarNotaTrabalho(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeTrabalho, float notaTrabalho, String nomeTurma) {
            notas.adicionarNotaTrabalho(nomeAluno, nomeDisciplina, nomeProfessor, nomeTrabalho, notaTrabalho, nomeTurma);
        }
        
        public void adicionarNotaPontoExtra(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma, float valor) {
            notas.adicionarNotaPontoExtra(nomeAluno, nomeDisciplina, nomeProfessor, nomePontoExtra, nomeTurma, valor);
        }
        
        public void removerNotaProva(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeProva, float notaProva, String nomeTurma) {
            notas.removerNotaProva(nomeAluno, nomeDisciplina, nomeProfessor, nomeProva, notaProva, nomeTurma);
        }
        
        public void removerNotaTrabalho(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeTrabalho, float notaTrabalho, String nomeTurma) {
            notas.removerNotaTrabalho(nomeAluno, nomeDisciplina, nomeProfessor, nomeTrabalho, notaTrabalho, nomeTurma);
        }
        
        public void removerNotaPontoExtra(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma, float valor) {
            notas.removerNotaPontoExtra(nomeAluno, nomeDisciplina, nomeProfessor, nomePontoExtra, nomeTurma, valor);
        }
        
        
        
}
