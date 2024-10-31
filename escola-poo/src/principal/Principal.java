package principal;

import controlador.Escola;
import java.util.Scanner;
import java.util.ArrayList;
import modelo.*;
import modelo.Output.OutputConsole;
import modelo.Output.OutputFactory;
import modelo.Output.OutputInterface;

public class Principal {
        static String tipoOutput = "console";
        static OutputInterface output = OutputFactory.getInstance().getTipoOutput(tipoOutput);

	static Scanner sc = new Scanner(System.in);
	static Escola controlador = new Escola(tipoOutput);

	public static void menuPrincipal(){
            if(output instanceof OutputConsole){
                output.display("============ MENU ============");
		output.display("1 - Cadastrar aluno");
		output.display("2 - Cadastrar professor");
		output.display("3 - Cadastrar disciplina");
		output.display("4 - Cadastrar turma");
		output.display("5 - Imprimir alunos");
		output.display("6 - Imprimir turmas");
		output.display("7 - Trocar aluno de turma");
		output.display("8 - Imprimir professores");
		output.display("9 - Imprimir disciplinas");
		output.display("10 - Adicionar disciplina a uma turma");
		output.display("11 - Cadastrar livro na biblioteca");
		output.display("12 - Criar horário para uma turma");
		output.display("==============================");
		output.display("Selecione sua opção: ");                
            }
	}

	public static void menuSelecionarTurma(ArrayList<Turma> turmas){
            if(output instanceof OutputConsole){
                output.display("====== Selecione a turma =====");
		for(Turma t : turmas){
			output.display(t.getID() + " - " + t.getNomeTurma());
		}
		output.display("==============================");
		output.display("Selecione sua opção: ");
            }
	}

	public static void menuSelecionarAluno(ArrayList<Aluno> alunos){
            if(output instanceof OutputConsole){
                output.display("====== Selecione o aluno =====");
		for(Aluno a : alunos){
			output.display(a.getNome() + " - " + a.getMatricula());
		}
		output.display("==============================");
		output.display("Selecione sua opção: ");
            }
	}

	public static void menuAluno(){
            if(output instanceof OutputConsole){
                output.display("====== Página do aluno =====");
		output.display("1 - Exibir meus dados");
		output.display("2 - Exibir dados gerais das minhas disciplinas");
		output.display("3 - Exibir detalhes de uma determinada disciplina");
		output.display("4 - Exibir dados da minha turma");
            }
	}

	public static void menuProfessor(){
            int opc = 0;
            if(output instanceof OutputConsole){
                while(true){
                    output.display("====== Página do professor =====");
                    output.display("1 - Exibir meus dados");
                    output.display("2 - Exibir dados gerais das minhas disciplinas");
                    output.display("3 - Exibir detalhes de uma determinada disciplina");
                    output.display("4 - Exibir dados da minha turma");
                    output.display("5 - Atribuir nota de prova à um aluno");
                    output.display("6 - Atribuir nota de trabalho à um aluno");

                    output.display("Selecione sua opção: ");

                    opc = sc.nextInt();
                    sc.nextLine();
                }
            }
	}

	public static void menuUsuarioBiblioteca(){
            if(output instanceof OutputConsole){
                output.display("====== Página da biblioteca =====");
		output.display("1 - Catálogo de livros");
		output.display("2 - Buscar livros pelo título");
		output.display("3 - Buscar livros de um autor");
		output.display("4 - Buscar livro pelo ISBN");
		output.display("5 - Listar meus empréstimos");
            }
	}

	public static void menuAdminBiblioteca(){
		int opc = 0;
		String titulo = "";
		String autor = "";
		String isbn = "";
		BibliotecaEscolar biblioteca = controlador.getBiblioteca();
                
                if(output instanceof OutputConsole){
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
			output.display("Selecione sua opção: ");

			opc = sc.nextInt();
			sc.nextLine();

			switch (opc) {
				case 1:
					biblioteca.imprimirCatalogoDeLivros();
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

			}
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
                
                if(output instanceof OutputConsole){
                    while(true){
			menuPrincipal();
			opc = sc.nextInt();
			sc.nextLine();

			switch(opc){
				case 1:
					menuSelecionarTurma(controlador.getTodasTurmas());

					turmaId = sc.nextLine();

					output.display("Digite o nome do novo aluno: ");
					nome = sc.nextLine();

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

					output.display("Digite a quantidade de vagas na turma: ");
					qtd = sc.nextInt();
					sc.nextLine();

					controlador.addTurma(nome, qtd);
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
			}
                    }
                }
		

	}
}
