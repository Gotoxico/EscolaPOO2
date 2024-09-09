package controlador;

import modelo.*;

public class Escola{
	private ArrayList<Aluno> alunos;
	private ArrayList<Professor> professores;
	private ArrayList<Turma> turmas;
	private ArrayList<Disciplina> disciplinas;
	private BibliotecaEscolar biblioteca;

	public Escola(){
		this.alunos = new ArrayList<>();
		this.professores = new ArrayList<>();
		this.turmas = new ArrayList<>();
		this.disciplinas = new ArrayList<>();
		this.biblioteca = new Biblioteca();
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

	public Turma getTurmaId(String idTurma){
		Turma temp;
		for(int i=0; i < this.turmas.size(); i++){
			temp = this.turmas.get(i);
			if(temp.getID.equals(idTurma)){
				return temp;
			}
		}
		return null;
	}

	public Aluno getAlunoMatricula(String matricula){
		Aluno temp;
		for(int i=0; i < this.alunos.size(); i++){
			temp = this.alunos.get(i);
			if(temp.getMatricula.equals(matricula)){
				return temp;
			}
		}
		return null;
	}

	public Professor getProfessorId(String idProfessor){
		Professor temp;
		for(int i=0; i < this.professores.size(); i++){
			temp = this.professores.get(i);
			if(temp.getId.equals(idProfessor)){
				return temp;
			}
		}
		return null;
	}

	public void addAluno(Aluno a){
		this.alunos.add(a);
	}

	public void addProfessor(Professor p){
		this.professores.add(p);
	}

	public void addDisciplina(Disciplina d){
		this.disciplinas.add(d);
	}

	public void addTurma(Turma t){
		this.turmas.add(t);
	}

	public void addAlunoTurma(String matricula, String idTurma){
		Aluno aluno = this.getAlunoMatricula(matricula);
		Turma turma = this.getTurmaId(idTurma);

		if(aluno != null && turma != null){
			turma.adicionarAluno(aluno);
		}
	}

	public void addDisciplinaTurma(String nome, String idTurma){
		Disciplina disciplina = this.getDisciplinaNome(nome);
		Turma turma = this.getTurmaId(idTurma);

		if(disciplina != null && turma != null){
			turma.adicionarDisciplinas(disciplina);
		}
	}

	public void removerDisciplinaTurma(String nome, String idTurma){
		Disciplina disciplina = this.getDisciplinaNome(nome);
		Turma turma = this.getTurmaId(idTurma);

		if(disciplina != null && turma != null){
			turma.removerDisciplina(disciplina);
		}
	}

	public void addHorarioTurma(Horario h, String idTurma){
		Turma turma = this.getTurmaId(idTurma);

		if(turma != null){
			//turma.addHorario(h);
		}
	}

	public void removerHorarioTurma(Horario h, String idTurma){
		Turma turma = this.getTurmaId(idTurma);

		if(turma != null){
			//turma.removerHorario(h);
		}
	}

	public void addLivroBiblioteca(Livro livro){
		biblioteca.addLivro(livro);
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


}
