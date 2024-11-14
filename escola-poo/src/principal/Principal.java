package principal;

import controlador.Escola;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Aluno;
import modelo.BibliotecaEscolar;
import modelo.Disciplina;
import modelo.Output.OutputFactory;
import modelo.Output.OutputInterface;
import modelo.Professor;
import modelo.Turma;

public class Principal {
	static String tipoOutput = "console";
	static OutputInterface output = OutputFactory.getInstance().getTipoOutput(tipoOutput);

	static Scanner sc = new Scanner(System.in);
	static Escola controlador = new Escola(OutputFactory.getInstance(), tipoOutput);

	public static void menuCadastro(){
		int opc = 0;
		String nome = "";
		String matricula = "";
		String turmaId = "";
		String titulacao = "";
		String disciplinaId = "";
		String unidadeEscolar = "";
		String anoEscolar = "";

		while(true){
			output.display("====== Cadastro =====");
			output.display("1 - Cadastrar aluno");
			output.display("2 - Cadastrar professor");
			output.display("3 - Cadastrar disciplina");
			output.display("4 - Cadastrar turma");
			output.display("5 - Adicionar disciplina a uma turma");
			output.display("6 - Criar horário para uma turma");
			output.display("7 - Cadastrar Provas");
			output.display("8 - Cadastrar Trabalhos");
			output.display("9 - Cadastrar Ponto Extra");
			output.display("10 - Cadastrar Atividades Extra Curriculares");
			output.display("0 - Voltar");
			output.display("==============================");
			output.display("Selecione sua opção: ");
			opc = sc.nextInt();
			sc.nextLine();

			switch(opc){
				case 1:
					output.display("Digite o nome do novo aluno: ");
					nome = sc.nextLine();
					turmaId = menuSelecionarTurma(controlador.getTodasTurmas());
					controlador.addAlunoTurma(nome, turmaId);
					break;

				case 2:
					output.display("Digite o nome do novo professor: ");
					nome = sc.nextLine();
					output.display("Digite a titulação do novo professor: ");
					titulacao = sc.nextLine();
					controlador.addProfessor(nome, titulacao);
					break;

				case 3:
					output.display("Digite o nome da nova disciplina: ");
					nome = sc.nextLine();
					output.display("Digite a unidade escolar: ");
					unidadeEscolar = sc.nextLine();
					output.display("Digite o ano escolar da disciplina: ");
					anoEscolar = sc.nextLine();
					controlador.addDisciplina(nome, unidadeEscolar, anoEscolar);
					break;

				case 4:
					output.display("Digite o nome da nova turma: ");
					nome = sc.nextLine();
					output.display("Digite tamanho da nova turma: ");
					Integer tamanho = sc.nextInt();
					controlador.addTurma(nome, tamanho);
					break;

				//Cadastrar provas, trabalhos, pontoExtra, atividades extra curriculares, horarioTurma

				case 0:
					return;

			}
		}
	}

	public static void menuRemover(){
		int opc = 0;
		String nome = "";
		String matricula = "";
		String turmaId = "";
		String titulacao = "";
		String disciplinaId = "";
		String unidadeEscolar = "";
		String anoEscolar = "";

		while(true){
			output.display("====== Remoção =====");
			output.display("1 - Expulsar aluno");
			output.display("2 - Demitir professor");
			output.display("3 - Remover disciplina");
			output.display("4 - Remover turma");
			output.display("5 - Remover disciplina de uma turma");
			output.display("6 - Remover horário para uma turma");
			output.display("7 - Remover Provas");
			output.display("8 - Remover Trabalhos");
			output.display("9 - Remover Ponto Extra");
			output.display("10 - Remover Atividades Extra Curriculares");
			output.display("0 - Voltar");
			output.display("==============================");
			output.display("Selecione sua opção: ");
			opc = sc.nextInt();
			sc.nextLine();

			switch(opc){
				case 1:
					output.display("Digite o nome do novo aluno: ");
					nome = sc.nextLine();
					turmaId = menuSelecionarTurma(controlador.getTodasTurmas());
					controlador.addAlunoTurma(nome, turmaId);
					break;

				case 2:
					output.display("Digite o nome do novo professor: ");
					nome = sc.nextLine();
					output.display("Digite a titulação do novo professor: ");
					titulacao = sc.nextLine();
					controlador.addProfessor(nome, titulacao);
					break;

				case 3:
					output.display("Digite o nome da nova disciplina: ");
					nome = sc.nextLine();
					output.display("Digite a unidade escolar: ");
					unidadeEscolar = sc.nextLine();
					output.display("Digite o ano escolar da disciplina: ");
					anoEscolar = sc.nextLine();
					controlador.addDisciplina(nome, unidadeEscolar, anoEscolar);
					break;

				case 4:
					output.display("Digite o nome da nova turma: ");
					nome = sc.nextLine();
					output.display("Digite tamanho da nova turma: ");
					Integer tamanho = sc.nextInt();
					controlador.addTurma(nome, tamanho);
					break;

				//Cadastrar provas, trabalhos, pontoExtra, atividades extra curriculares, horarioTurma

				case 0:
					return;

			}
		}
	}

	public static void menuImprimir(){
		output.display("====== Impressão =====");
		output.display("1 - Imprimir alunos");
		output.display("2 - Imprimir turmas");
		output.display("3 - Imprimir professores");
		output.display("4 - Imprimir disciplinas");
		output.display("5 - Imrpimir Dados Aluno");
		output.display("6 - Imprimir Dados Turma");
		output.display("7 - Imprimir Dados Professor");
		output.display("8 - Imprimir Dados Disciplina");
		output.display("9 - Imprimir Dados Prova");
		output.display("10 - Imprimir Dados Trabalho");
		output.display("11 - Imprimir Dados Ponto Extra");
		output.display("12 - Imprimir Dados Atividades Extra Curriculares");
		output.display("13 - Imprimir Horario Turma");
		output.display("0 - Voltar");
		output.display("==============================");
		output.display("Selecione sua opção: ");
		int opc = sc.nextInt();
		sc.nextLine();

		switch(opc){
			case 1:
				ArrayList<Aluno> alunos = controlador.getTodosAlunos();
				output.display("=========================");
				for(Aluno a : alunos) {
					output.display("ID: " + a.getID());
					output.display("Matricula: " + a.getMatricula());
					output.display("Nome: " + a.getNome());
					output.display("=========================");
				}
				break;

			case 2:
				ArrayList<Turma> turmas = controlador.getTodasTurmas();
				output.display("=========================");
				for(Turma t : turmas) {
					output.display("ID: " + t.getID());
					output.display("Nome: " + t.getNomeTurma());
					output.display("QTD vagas: " + t.getQuantidadeVagas());
					output.display("=========================");
				}
				break;

			case 3:
				ArrayList<Professor> professores = controlador.getTodosProfessores();
				output.display("=========================");
				for(Professor p : professores) {
					output.display("ID: " + p.getID());
					output.display("Nome: " + p.getNome());
					output.display("=========================");
				}
				break;

			case 4:
				ArrayList<Disciplina> disciplinas = controlador.getTodasDisciplinas();
				output.display("=========================");
				for(Disciplina d : disciplinas) {
					output.display("Nome: " + d.getNome());
					output.display("Unidade Escolar: " + d.getUnidadeEscolar());
					output.display("Ano Escolar: " + d.getAnoEscolar());
					output.display("=========================");
				}
				break;

			case 0:
				return;
		}
	}

	public static void menuAdicionarNotaParaAluno(){
		output.display("======Adicionar Notas Para Aluno======");
		output.display("1 - Adicionar Nota para prova");
		output.display("2 - Adicionar Nota para trabalho");
		output.display("3 - Adicionar Nota para ponto extra");
		output.display("0 - Voltar");
		output.display("==============================");


		output.display("Digite a matricula do aluno: ");
		String matricula = sc.nextLine();
		output.display("Digite a nota do aluno: ");
		Double nota = sc.nextDouble();
		sc.nextLine();
	}

	public static void menuAdicionarNotaParaTurma(){
		output.display("======Adicionar Notas Para Turma======");
		output.display("1 - Adicionar Notas de prova");
		output.display("2 - Adicionar Notas de trabalho");
		output.display("3 - Adicionar Notas de ponto extra");
		output.display("0 - Voltar");
		output.display("==============================");

		output.display("Digite o nome da disciplina: ");
		output.display("Digite o ID da turma: ");
		String turmaId = sc.nextLine();
		output.display("Digite a nota do aluno: ");
		Double nota = sc.nextDouble();
		sc.nextLine();
	}

	public static void menuPrincipal(){
            

			int opc=0;
			String turmaId = "";
			String alunoMatricula = "";
			String nome = "";
			String titulacao = "";
			String unidadeEscolar = "";
			String anoEscolar = "";
			int qtd = 0;

			ArrayList<Aluno> alunos;
			ArrayList<Turma> turmas;
			ArrayList<Professor> professores;
			ArrayList<Disciplina> disciplinas;

			while(true){
				output.display("============ MENU ============");
				output.display("1 - Cadastrar ");
				output.display("2 - Remover");
				output.display("3 - Imprimir");
				output.display("4 - Trocar aluno de turma");
				output.display("5 - Adicionar disciplina a uma turma");
				output.display("6 - Adicionar Nota para um aluno");
				output.display("7 - Adicionar Notas para a turma");
				output.display("8 - Relatório Universidade");
				output.display("9 - Relatório Média das Médias Professor");
				output.display("10 - Acessar biblioteca");
				output.display("0 - Sair");
				output.display("==============================");
				output.display("Selecione sua opção: ");            
				opc = sc.nextInt();
				sc.nextLine();

				switch(opc){
					case 1:
						menuCadastro();
						break;
					
					case 2:
						menuRemover();
						break;
					
					case 3:
						menuImprimir();
						break;
					
					case 4:
						output.display("Digite o nome da nova turma: ");
						nome = sc.nextLine();
						output.display("Digite a quantidade de vagas na turma: ");
						qtd = sc.nextInt();
						sc.nextLine();
						controlador.addTurma(nome, qtd);
						break;
					
					case 5:
						alunos = controlador.getTodosAlunos();
						output.display("=========================");
						for(Aluno a : alunos) {
							output.display("ID: " + a.getID());
							output.display("Matricula: " + a.getMatricula());
							output.display("Nome: " + a.getNome());
							output.display("=========================");
						}
						break;
					
					case 6:
						turmas = controlador.getTodasTurmas();
						output.display("=========================");
						for(Turma t : turmas) {
							alunos = t.getAlunos();
							disciplinas = t.getDisciplinas();
							output.display("ID: " + t.getID());
							output.display("Nome: " + t.getNomeTurma());
							output.display("QTD vagas: " + t.getQuantidadeVagas());
							output.display("Alunos da turma:");
							output.display("-------------------------");
							for(Aluno a : alunos){
								output.display("Nome: " + a.getNome());
								output.display("-------------------------");
							}
							output.display("Disciplinas da turma:");
							output.display("-------------------------");
							for(Disciplina d : disciplinas){
								output.display("Nome: " + d.getNome());
								output.display("-------------------------");
							}
							output.display("=========================");
						}
						break;
					
					case 7:
						menuSelecionarTurma(controlador.getTodasTurmas());
						turmaId = sc.nextLine();
						menuSelecionarAluno(controlador.getTodosAlunos());
						alunoMatricula = sc.nextLine();
						controlador.trocaAlunoTurma(alunoMatricula, turmaId);
						break;
					
					case 8:
						professores = controlador.getTodosProfessores();
						output.display("=========================");
						for(Professor p : professores) {
							output.display("ID: " + p.getID());
							output.display("Nome: " + p.getNome());
							turmas = p.getTurmas();
							output.display("Turmas: ");
							output.display("-------------------------");
							for(Turma t : turmas){
								output.display("Nome: " + t.getNomeTurma());
								output.display("-------------------------");
							}
							output.display("=========================");
						}
						break;
					
					case 9:
						disciplinas = controlador.getTodasDisciplinas();
						output.display("=========================");
						for(Disciplina d : disciplinas) {
							output.display("Nome: " + d.getNome());
							output.display("Unidade Escolar: " + d.getUnidadeEscolar());
							output.display("Ano Escolar: " + d.getAnoEscolar());
							professores = d.getProfessores();
							output.display("Professores: ");
							output.display("-------------------------");
							for(Professor p : professores){
								output.display("Nome: " + p.getNome());
								output.display("-------------------------");
							}
							output.display("=========================");
							turmas = d.getTurmas();
							output.display("Turmas: ");
							output.display("-------------------------");
							for(Turma t : turmas){
								output.display("Nome: " + t.getNomeTurma());
								output.display("-------------------------");
							}
							output.display("=========================");
						}
						break;
					
					case 10:
						System.out.print("Digite o nome da disciplina: ");
						nome = sc.nextLine();
						turmas = controlador.getTodasTurmas();
						menuSelecionarTurma(turmas);
						turmaId = sc.nextLine();
						controlador.addDisciplinaTurma(nome, turmaId);
						break;
					
					case 11:
						output.display("Cadastrar livro na biblioteca");
						break;
					
					case 12:
						output.display("Criar horário para uma turma");
						break;

					case 13:
						menuAdminBiblioteca();
						break;
				}
			}    	
	}

	public static String menuSelecionarTurma(ArrayList<Turma> turmas){
		String turmaId = "";
            output.display("====== Selecione a turma =====");
            for(Turma t : turmas){
				output.display(t.getID() + " - " + t.getNomeTurma());
            }
            output.display("==============================");
            output.display("Selecione sua opção: ");
			turmaId = sc.nextLine();
			return turmaId;
	}

	public static String menuSelecionarAluno(ArrayList<Aluno> alunos){	
		String alunoMatricula = "";
            output.display("====== Selecione o aluno =====");
            for(Aluno a : alunos){
				output.display(a.getNome() + " - " + a.getMatricula());
            }
            output.display("==============================");
            output.display("Selecione sua opção: ");
			alunoMatricula = sc.nextLine();
			return alunoMatricula;
	}

	public static void menuAdminBiblioteca(){
		int opc = 0;
		String titulo = "";
		String autor = "";
		String isbn = "";
		BibliotecaEscolar biblioteca = controlador.getBiblioteca();

			while(true){
				output.display("====== Página da biblioteca =====");
				output.display("1 - Catálogo de livros");
				output.display("2 - Buscar livros pelo título");
				output.display("3 - Buscar livros de um autor");
				output.display("4 - Buscar livro pelo ISBN");
				output.display("5 - Fazer o empréstimo de um livro para um usuário");
				output.display("6 - Fazer a devolução de um livro para um usuário");
				output.display("7 - Relatório geral dos livros cadastrados");
				output.display("8 - Cadastrar livro");
				output.display("9 - Relatório de multas");
				output.display("10 - Remover livro");
				output.display("0 - Voltar");
				output.display("Selecione sua opção: ");

				opc = sc.nextInt();
				sc.nextLine();

				switch (opc) {
					case 1:
					biblioteca.imprimirCatalogoDeLivros();
					break;

					case 2:
					output.display("Digite o título do livro: ");
					titulo = sc.nextLine();
					biblioteca.buscarLivroPorTitulo(titulo);
					break;

					case 3:
					output.display("Digite o autor do livro: ");
					autor = sc.nextLine();
					biblioteca.buscarLivroPorAutor(autor);
					break;

					case 4:
					output.display("Digite o ISBN do livro: ");
					isbn = sc.nextLine();
					biblioteca.buscarLivroPorISBN(isbn);
					break;

					case 5:
					output.display("Digite o ID do usuário: ");
					String usuarioId = sc.nextLine();
					output.display("Digite o ISBN do livro: ");
					isbn = sc.nextLine();
					biblioteca.fazerEmprestimo(usuarioId, isbn);
					break;

					case 6:
					output.display("Digite o ID do usuário: ");
					usuarioId = sc.nextLine();
					output.display("Digite o ISBN do livro: ");
					isbn = sc.nextLine();
					biblioteca.fazerDevolucao(usuarioId, isbn);
					break;

					case 7:
					biblioteca.relatorioGeralLivros();
					break;

					case 8:
					output.display("Digite o nome do livro: ");
					titulo = sc.nextLine();

					output.display("Digite o autor do livro: ");
					autor = sc.nextLine();

					output.display("Digite o isbn do livro: ");
					isbn = sc.nextLine();

					controlador.addLivroBiblioteca(titulo, autor, isbn);
					break;

					case 9:
					biblioteca.relatorioMultas();
					break;

				}
			}
	}

	public static void seed(){
		//Gerando turmas para testes
		controlador.addTurma("6A", 33);
		controlador.addTurma("6B", 30);
		controlador.addTurma("7A", 28);
		controlador.addTurma("7B", 32);
		controlador.addTurma("8A", 29);
		controlador.addTurma("8B", 31);
		controlador.addTurma("9A", 27);
		controlador.addTurma("9B", 26);

		//Gerando 30 livros para simular um banco de dados
		controlador.addLivroBiblioteca("Dom Casmurro", "Machado de Assis", "978-8525054182");
		controlador.addLivroBiblioteca("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "978-8535931962");
		controlador.addLivroBiblioteca("1984", "George Orwell", "978-8535930859");
		controlador.addLivroBiblioteca("A Moreninha", "Joaquim Manuel de Macedo", "978-8575030211");
		controlador.addLivroBiblioteca("O Alquimista", "Paulo Coelho", "978-8580417994");
		controlador.addLivroBiblioteca("Cem Anos de Solidão", "Gabriel García Márquez", "978-8535932396");
		controlador.addLivroBiblioteca("Moby Dick", "Herman Melville", "978-8535924698");
		controlador.addLivroBiblioteca("A Revolução dos Bichos", "George Orwell", "978-8573022861");
		controlador.addLivroBiblioteca("O Senhor dos Anéis", "J.R.R. Tolkien", "978-8576607164");
		controlador.addLivroBiblioteca("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "978-8532530191");
		controlador.addLivroBiblioteca("A Metamorfose", "Franz Kafka", "978-8535923981");
		controlador.addLivroBiblioteca("O Cortiço", "Aluísio Azevedo", "978-8535923165");
		controlador.addLivroBiblioteca("A Cabana", "William P. Young", "978-8573025135");
		controlador.addLivroBiblioteca("Orgulho e Preconceito", "Jane Austen", "978-8532511794");
		controlador.addLivroBiblioteca("O Morro dos Ventos Uivantes", "Emily Brontë", "978-8573024794");
		controlador.addLivroBiblioteca("Fahrenheit 451", "Ray Bradbury", "978-8535926852");
		controlador.addLivroBiblioteca("O Guarani", "José de Alencar", "978-8525054090");
		controlador.addLivroBiblioteca("O Primo Basílio", "José Maria de Eça de Queirós", "978-8525065607");
		controlador.addLivroBiblioteca("Iracema", "José de Alencar", "978-8525052430");
		controlador.addLivroBiblioteca("O Filho de Mil Homens", "Valter Hugo Mãe", "978-8535925688");
		controlador.addLivroBiblioteca("A Menina que Roubava Livros", "Markus Zusak", "978-8580570569");
		controlador.addLivroBiblioteca("O Lobo da Estepe", "Hermann Hesse", "978-8573026415");
		controlador.addLivroBiblioteca("Os Miseráveis", "Victor Hugo", "978-8535925680");
		controlador.addLivroBiblioteca("A Ilha do Tesouro", "Robert Louis Stevenson", "978-8535911768");
		controlador.addLivroBiblioteca("A Dama das Camélias", "Alexandre Dumas Filho", "978-8576351611");
		controlador.addLivroBiblioteca("O Processo", "Franz Kafka", "978-8575028811");
		controlador.addLivroBiblioteca("A Peste", "Albert Camus", "978-8535923945");
		controlador.addLivroBiblioteca("O Sol é Para Todos", "Harper Lee", "978-8535922528");
		controlador.addLivroBiblioteca("O Fim da Eternidade", "Isaac Asimov", "978-8535923181");
		controlador.addLivroBiblioteca("O Nome da Rosa", "Umberto Eco", "978-8535923150");
		controlador.addLivroBiblioteca("A Cor Púrpura", "Alice Walker", "978-8535923853");
		controlador.addLivroBiblioteca("O Livro dos Espíritos", "Allan Kardec", "978-8573023148");
	}

	public static void main(String[] args){
		seed();
		menuPrincipal();

	}
}
