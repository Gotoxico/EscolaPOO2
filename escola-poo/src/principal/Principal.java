package principal;

import controlador.Escola;
import java.util.Scanner;
import java.util.ArrayList;
import modelo.*;

public class Principal {

	static Scanner sc = new Scanner(System.in);
	static Escola controlador = new Escola();

	public static void menuPrincipal(){
		System.out.println("============ MENU ============");
		System.out.println("1 - Cadastrar aluno");
		System.out.println("2 - Cadastrar professor");
		System.out.println("3 - Cadastrar disciplina");
		System.out.println("4 - Cadastrar turma");
		System.out.println("5 - Imprimir alunos");
		System.out.println("6 - Imprimir turmas");
		System.out.println("7 - Trocar aluno de turma");
		System.out.println("8 - Imprimir professores");
		System.out.println("9 - Imprimir disciplinas");
		System.out.println("10 - Adicionar disciplina a uma turma");
		System.out.println("11 - Cadastrar livro na biblioteca");
		System.out.println("12 - Criar horário para uma turma");
		System.out.println("==============================");
		System.out.print("Selecione sua opção: ");
	}

	public static void menuSelecionarTurma(ArrayList<Turma> turmas){
		System.out.println("====== Selecione a turma =====");
		for(Turma t : turmas){
			System.out.println(t.getID() + " - " + t.getNomeTurma());
		}
		System.out.println("==============================");
		System.out.print("Selecione sua opção: ");
	}

	public static void menuSelecionarAluno(ArrayList<Aluno> alunos){
		System.out.println("====== Selecione o aluno =====");
		for(Aluno a : alunos){
			System.out.println(a.getNome() + " - " + a.getMatricula());
		}
		System.out.println("==============================");
		System.out.print("Selecione sua opção: ");
	}

	public static void menuAluno(){
		System.out.println("====== Página do aluno =====");
		System.out.println("1 - Exibir meus dados");
		System.out.println("2 - Exibir dados gerais das minhas disciplinas");
		System.out.println("3 - Exibir detalhes de uma determinada disciplina");
		System.out.println("4 - Exibir dados da minha turma");
	}

	public static void menuProfessor(){
		int opc = 0;

		while(true){
			System.out.println("====== Página do professor =====");
			System.out.println("1 - Exibir meus dados");
			System.out.println("2 - Exibir dados gerais das minhas disciplinas");
			System.out.println("3 - Exibir detalhes de uma determinada disciplina");
			System.out.println("4 - Exibir dados da minha turma");
			System.out.println("5 - Atribuir nota de prova à um aluno");
			System.out.println("6 - Atribuir nota de trabalho à um aluno");

			System.out.print("Selecione sua opção: ");

			opc = sc.nextInt();
			sc.nextLine();
		}
	}

	public static void menuUsuarioBiblioteca(){
		System.out.println("====== Página da biblioteca =====");
		System.out.println("1 - Catálogo de livros");
		System.out.println("2 - Buscar livros pelo título");
		System.out.println("3 - Buscar livros de um autor");
		System.out.println("4 - Buscar livro pelo ISBN");
		System.out.println("5 - Listar meus empréstimos");
	}

	public static void menuAdminBiblioteca(){
		int opc = 0;
		String titulo = "";
		String autor = "";
		String isbn = "";
		BibliotecaEscolar biblioteca = controlador.getBiblioteca();

		while(true){
			System.out.println("====== Página da biblioteca =====");
			System.out.println("1 - Catálogo de livros");
			System.out.println("2 - Buscar livros pelo título");
			System.out.println("3 - Buscar livros de um autor");
			System.out.println("4 - Buscar livro pelo ISBN");
			System.out.println("5 - Fazer o empréstimo de um livro para um usuário");
			System.out.println("6 - Fazer a devolução de um livro para um usuário");
			System.out.println("7 - Relatório geral dos livros cadastrados");
			System.out.println("8 - Cadastrar livro");
			System.out.println("9 - Relatório de multas");
			System.out.print("Selecione sua opção: ");

			opc = sc.nextInt();
			sc.nextLine();

			switch (opc) {
				case 1:
					biblioteca.imprimirCatalogoDeLivros();
					break;
					
				case 8:
					System.out.print("Digite o nome do livro: ");
					titulo = sc.nextLine();

					System.out.print("Digite o autor do livro: ");
					autor = sc.nextLine();

					System.out.print("Digite o isbn do livro: ");
					isbn = sc.nextLine();
					
					controlador.addLivroBiblioteca(titulo, autor, isbn);
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
		menuAdminBiblioteca();
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

		controlador.addTurma("6A", 33);
		controlador.addTurma("6B", 35);

		while(true){
			menuPrincipal();
			opc = sc.nextInt();
			sc.nextLine();

			switch(opc){
				case 1:
					menuSelecionarTurma(controlador.getTodasTurmas());

					turmaId = sc.nextLine();

					System.out.print("Digite o nome do novo aluno: ");
					nome = sc.nextLine();

					controlador.addAlunoTurma(nome, turmaId);

					break;
				case 2:
					System.out.print("Digite o nome do novo professor: ");
					nome = sc.nextLine();
					
					System.out.print("Digite a titulação do novo professor: ");
					titulacao = sc.nextLine();

					controlador.addProfessor(nome, titulacao);
					break;
				case 3:
					System.out.print("Digite o nome da nova disciplina: ");
					nome = sc.nextLine();

					System.out.print("Digite a unidade escolar: ");
					unidadeEscolar = sc.nextLine();

					System.out.print("Digite o ano escolar da disciplina: ");
					anoEscolar = sc.nextLine();

					controlador.addDisciplina(nome, unidadeEscolar, anoEscolar);
					break;
				case 4:
					System.out.print("Digite o nome da nova turma: ");
					nome = sc.nextLine();

					System.out.print("Digite a quantidade de vagas na turma: ");
					qtd = sc.nextInt();
					sc.nextLine();

					controlador.addTurma(nome, qtd);
				case 5:
					alunos = controlador.getTodosAlunos();
					System.out.println("=========================");
					for(Aluno a : alunos) {
						System.out.println("ID: " + a.getID());
						System.out.println("Matricula: " + a.getMatricula());
						System.out.println("Nome: " + a.getNome());
						System.out.println("=========================");
					}
					break;
				case 6:
					turmas = controlador.getTodasTurmas();
					System.out.println("=========================");
					for(Turma t : turmas) {
						alunos = t.getAlunos();
						disciplinas = t.getDisciplinas();

						System.out.println("ID: " + t.getID());
						System.out.println("Nome: " + t.getNomeTurma());
						System.out.println("QTD vagas: " + t.getQuantidadeVagas());

						System.out.println("Alunos da turma:");
						System.out.println("-------------------------");
						for(Aluno a : alunos){
							System.out.println("Nome: " + a.getNome());
							System.out.println("-------------------------");
						}

						System.out.println("Disciplinas da turma:");
						System.out.println("-------------------------");
						for(Disciplina d : disciplinas){
							System.out.println("Nome: " + d.getNome());
							System.out.println("-------------------------");
						}
						System.out.println("=========================");
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
					System.out.println("=========================");
					for(Professor p : professores) {
						System.out.println("ID: " + p.getID());
						System.out.println("Nome: " + p.getNome());
						turmas = p.getTurmas();

						System.out.println("Turmas: ");
						System.out.println("-------------------------");
						for(Turma t : turmas){
							System.out.println("Nome: " + t.getNomeTurma());
							System.out.println("-------------------------");
						}
						System.out.println("=========================");
					}
					break;

				case 9:
					disciplinas = controlador.getTodasDisciplinas();
					System.out.println("=========================");
					for(Disciplina d : disciplinas) {
						System.out.println("Nome: " + d.getNome());
						System.out.println("Unidade Escolar: " + d.getUnidadeEscolar());
						System.out.println("Ano Escolar: " + d.getAnoEscolar());

						professores = d.getProfessores();
						System.out.println("Professores: ");
						System.out.println("-------------------------");
						for(Professor p : professores){
							System.out.println("Nome: " + p.getNome());
							System.out.println("-------------------------");
						}
						System.out.println("=========================");

						turmas = d.getTurmas();
						System.out.println("Turmas: ");
						System.out.println("-------------------------");
						for(Turma t : turmas){
							System.out.println("Nome: " + t.getNomeTurma());
							System.out.println("-------------------------");
						}
						System.out.println("=========================");
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
					System.out.println("Cadastrar livro na biblioteca");
			}
		}

	}
}
