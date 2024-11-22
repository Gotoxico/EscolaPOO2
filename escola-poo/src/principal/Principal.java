
package principal;

import controlador.Escola;
import horario.Horario;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Aluno;
import modelo.BibliotecaEscolar;
import modelo.Disciplina;
import modelo.Output.OutputFactory;
import modelo.Output.OutputInterface;
import modelo.Professor;
import modelo.Turma;
import modelo.Prova;
import modelo.Palestra;
import modelo.IniciacaoCientifica;
import modelo.AtividadeExtra;
import modelo.CursoExtra;
import modelo.AtividadeExtraCurricular;
import modelo.BibliotecaEscolarConsole;
import modelo.RelatorioProfessores;
import modelo.Trabalho;

public class Principal {

    static String tipoOutput = "console";

    static OutputInterface output = OutputFactory.getInstance().getTipoOutput(tipoOutput);

    static Scanner sc = new Scanner(System.in);
    static Escola controlador = new Escola(OutputFactory.getInstance(), tipoOutput);

    public static void menuCadastro() {
        int opc = 0;
        String nome = "";
        String matricula = "";
        String turmaId = "";
        String titulacao = "";
        String disciplinaId = "";
        String unidadeEscolar = "";
        String anoEscolar = "";

        String professorId = "";

        float peso = 0.0f;

        Professor p = null;
        Turma t = null;
        Disciplina d = null;
        Horario h = null;

        while (true) {
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

            switch (opc) {
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

                case 5:
                    output.display("Digite o nome da disciplina: ");
                    disciplinaId = sc.nextLine();
                    turmaId = menuSelecionarTurma(controlador.getTodasTurmas());
                    controlador.addDisciplinaTurma(disciplinaId, turmaId);
                    break;
                case 6:
                    turmaId = menuSelecionarTurma(controlador.getTodasTurmas());

                    menuCriarHorario(turmaId);

                    break;

                // Cadastrar provas, trabalhos, pontoExtra, atividades extra curriculares,
                // horarioTurma
                // adicionando pontos extras
                case 7:
                    disciplinaId = menuSelecionarDisciplina(controlador.getTodasDisciplinas());

                    turmaId = menuSelecionarTurma(controlador.getTodasTurmas());

                    professorId = menuSelecionarProfessor(controlador.getProfessoresDisciplina(disciplinaId));

                    output.display("Digite o nome do trabalho: ");
                    nome = sc.nextLine();

                    output.display("Digite o peso do trabalho: ");
                    peso = sc.nextFloat();

                    p = controlador.getProfessorId(professorId);
                    t = controlador.getTurmaId(turmaId);

                    controlador.adicionarProvaDisciplina(disciplinaId, p.getNome(), t.getNomeTurma(), nome, peso);
                    break;

                case 8:
                    disciplinaId = menuSelecionarDisciplina(controlador.getTodasDisciplinas());

                    turmaId = menuSelecionarTurma(controlador.getTodasTurmas());

                    professorId = menuSelecionarProfessor(controlador.getProfessoresDisciplina(disciplinaId));

                    output.display("Digite o nome do trabalho: ");
                    nome = sc.nextLine();

                    output.display("Digite o peso do trabalho: ");
                    peso = sc.nextFloat();

                    p = controlador.getProfessorId(professorId);
                    t = controlador.getTurmaId(turmaId);

                    controlador.adicionarTrabalhoDisciplina(disciplinaId, p.getNome(), t.getNomeTurma(), nome, peso);
                    break;

                case 9:
                    output.display("====== Cadastrar Ponto Extra =====");
                    output.display("Digite o nome da Disciplina: ");
                    disciplinaId = sc.nextLine();

                    output.display("Digite o nome do professor: ");
                    String nomeProfessor = sc.nextLine();

                    output.display("Digite o nome do Ponto Extra: ");
                    String tituloPonto = sc.nextLine();

                    output.display("Digite o nome da Turma: ");
                    turmaId = sc.nextLine();

                    output.display("Digite o valor máximo do Ponto Extra: ");
                    float valorMaximo = sc.nextFloat();
                    output.display("==================================");

                    controlador.adicionarPontoExtraDisciplina(disciplinaId, nomeProfessor, tituloPonto, turmaId,
                            valorMaximo);

                    break;

                case 10:
                    output.display("\n\n====== Cadastrar Atividades Extra Curriculares =====");
                    output.display("1 - Palestra");
                    output.display("2 - Curso Extra");
                    output.display("3 - Iniciação Científica");
                    output.display("0 - Voltar");
                    output.display("==============================");
                    output.display("Selecione sua opção: ");
                    int opcAtividade = sc.nextInt();

                    output.display("\nDigite a matricula do Aluno: ");
                    matricula = sc.nextLine();

                    output.display("Digite o titulo da atividade: ");
                    String tituloAtividade = sc.nextLine();

                    output.display("Digite as horas totais da atividade: ");
                    double horasTotais = sc.nextDouble();

                    AtividadeExtra ic = null;

                    switch (opcAtividade) {
                        case 1:
                            output.display("Digite o nome do palestrante: ");
                            String palestrante = sc.nextLine();
                            output.display("Digite a descrição da palestra: ");
                            String descricao = sc.nextLine();
                            ic = new Palestra(horasTotais, tituloAtividade, palestrante, descricao);

                            break;

                        case 2:
                            output.display("Digite o nome do professor: ");
                            String professor = sc.nextLine();
                            output.display("Digite a descrição do curso extra: ");
                            String descricaoCurso = sc.nextLine();
                            ic = new CursoExtra(horasTotais, tituloAtividade, professor, descricaoCurso);
                            break;

                        case 3:
                            output.display("Digite o Id do professor orientador: ");
                            String Idorientador = sc.nextLine();
                            Professor orientador = controlador.getProfessorId(Idorientador);
                            ic = new IniciacaoCientifica(horasTotais, tituloAtividade, orientador);
                            break;

                        case 0:
                            return;
                    }

                    controlador.addAtividadeExtraCurricular(matricula, ic);
                    break;

                case 0:
                    return;

            }
        }
    }

    public static void relatorioHorario(Horario h) {
        output.display(h.toString());
    }

    public static void menuSelecionarProfessorDisciplinaTurma(String turmaId) {
        ArrayList<Disciplina> disciplinasTurma = controlador.getDisciplinasTurma(turmaId);
        String professorId;

        for (Disciplina d : disciplinasTurma) {
            output.display(String.format("Selecionando Professor da disciplina '%s':", d.getNome()));
            professorId = menuSelecionarProfessor(d.getProfessores());

            controlador.definirProfessorDisciplinaTurma(turmaId, d.getNome(), professorId);
        }

    }

    public static void menuCriarHorario(String turmaId) {
        if(controlador.getTurmaId(turmaId) == null){
            output.display("Turma inexistente");
            return;
        }
        
        String dia = "";
        String nomeDisciplina = "";
        LocalTime horario = null;
        int opc = 0;

        Disciplina disciplina = null;

        do {
            relatorioHorario(controlador.getHorarioTurmaId(turmaId));

            output.display("1 - Editar horário");
            output.display("0 - Sair");
            output.display("Escolha sua opção: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    dia = escolherDiaSemana();
                    horario = escolherHoraDoDia();
                    nomeDisciplina = menuSelecionarDisciplina(controlador.getDisciplinasTurma(turmaId));
                    disciplina = controlador.getDisciplinaNome(nomeDisciplina);

                    controlador.addDisciplinaHorarioTurma(dia, horario, turmaId, nomeDisciplina);
                    break;
                case 0:
                    break;
            }
        } while (opc != 0);
    }

    public static LocalTime escolherHoraDoDia() {
        LocalTime[] horarios = {
                LocalTime.of(7, 0),
                LocalTime.of(7, 50),
                LocalTime.of(8, 40),

                LocalTime.of(9, 45),
                LocalTime.of(10, 35),
                LocalTime.of(11, 25),

                LocalTime.of(13, 10),
                LocalTime.of(14, 0),
                LocalTime.of(14, 50)
        };

        int opc = 0;

        while (opc < 1 || opc > horarios.length) {
            for (int cont = 1; cont <= horarios.length; cont++) {
                int pos = cont - 1;
                System.out.println(String.format("%d - %s", cont, horarios[pos].toString()));
            }

            output.display("Escolha o horário: ");
            opc = sc.nextInt();
        }
        sc.nextLine();

        return horarios[opc - 1];
    }

    public static String escolherDiaSemana() {
        String[] diasDaSemana = {
                "Segunda-feira",
                "Terça-feira",
                "Quarta-feira",
                "Quinta-feira",
                "Sexta-feira"
        };

        int opc = 0;

        while (opc < 1 || opc > diasDaSemana.length) {
            for (int cont = 1; cont <= diasDaSemana.length; cont++) {
                int pos = cont - 1;
                System.out.println(String.format("%d - %s", cont, diasDaSemana[pos]));
            }

            output.display("Escolha o dia da semana: ");
            opc = sc.nextInt();
        }
        sc.nextLine();

        return diasDaSemana[opc - 1];
    }

    public static void menuRemover() {
        int opc = 0;
        String nome = "";
        String matricula = "";
        String turmaId = "";
        String titulacao = "";
        String disciplinaId = "";
        String unidadeEscolar = "";
        String anoEscolar = "";

        while (true) {
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

            switch (opc) {
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

                case 6:
                    output.display("Digite o ID da turma: ");
                    turmaId = sc.nextLine();
                    controlador.removerHorarioTurma(turmaId);
                    break;

                // Cadastrar provas, trabalhos, pontoExtra, atividades extra curriculares,
                // horarioTurma

                case 7:
                    menuRemoverProvas();
                    break;

                // Removendo Trabalhos
                case 8:
                    menuRemoverTrabalhos();
                    break;

                case 0:
                    return;
            }
        }
    }

    public static void menuRemoverTrabalhos() {
        String nomeDisciplina = "";
        String turmaId = "";
        String professorId = "";

        Turma t = null;
        Professor p = null;

        output.display("====== Remover Trabalhos =====");
        nomeDisciplina = menuSelecionarDisciplina(controlador.getTodasDisciplinas());

        professorId = menuSelecionarProfessor(controlador.getProfessoresDisciplina(nomeDisciplina));

        turmaId = menuSelecionarTurma(controlador.getTodasTurmas());

        p = controlador.getProfessorId(professorId);
        t = controlador.getTurmaId(turmaId);

        output.display("\n\n1 - Remover um trabalho");
        output.display("2 - Remover todos os trabalhos");
        output.display("0 - Voltar");
        output.display("==============================");
        output.display("Selecione sua opção: ");
        int opcTrabalho = sc.nextInt();

        switch (opcTrabalho) {
            case 1:
                /// //////////////////////////////////////
                //////////////// REAVALIAAR
                /// //////////////////////////////////////

                output.display("Digite o nome do trabalho: ");
                String nomeTrabalho = sc.nextLine();

                output.display("Digite o peso do Trabalho na nota: ");
                float peso = sc.nextFloat();

                controlador.removerTrabalhoDisciplina(nomeDisciplina, p.getNome(), nomeTrabalho, t.getNomeTurma(),
                        peso);
                break;

            case 2:
                controlador.removerTodosTrabalhosDisciplina(nomeDisciplina, p.getNome(), t.getNomeTurma());
                break;

            case 0:
                return;
        }
    }

    public static void menuRemoverProvas() {
        String nomeDisciplina = "";
        String turmaId = "";
        String professorId = "";

        Turma t = null;
        Professor p = null;

        output.display("====== Remover Provas =====");
        nomeDisciplina = menuSelecionarDisciplina(controlador.getTodasDisciplinas());

        professorId = menuSelecionarProfessor(controlador.getProfessoresDisciplina(nomeDisciplina));

        turmaId = menuSelecionarTurma(controlador.getTodasTurmas());

        p = controlador.getProfessorId(professorId);
        t = controlador.getTurmaId(turmaId);

        output.display("\n\n1 - Remover uma prova");
        output.display("2 - Remover todas as provas");
        output.display("0 - Voltar");
        output.display("==============================");
        output.display("Selecione sua opção: ");
        int opcTrabalho = sc.nextInt();

        switch (opcTrabalho) {
            case 1:
                /// //////////////////////////////////////
                //////////////// REAVALIAAR
                /// //////////////////////////////////////

                output.display("Digite o nome da prova: ");
                String nomeProva = sc.nextLine();

                output.display("Digite o peso da Prova na nota: ");
                float peso = sc.nextFloat();

                controlador.removerTrabalhoDisciplina(nomeDisciplina, p.getNome(), nomeProva, t.getNomeTurma(), peso);
                break;

            case 2:
                controlador.removerTodosTrabalhosDisciplina(nomeDisciplina, p.getNome(), t.getNomeTurma());
                break;

            case 0:
                return;
        }
    }

    public static void menuImprimir() {
        String matricula = "";
        String idProfessor = "";
        String nomeDisciplina = "";

        Disciplina disciplina = null;
        Professor prof = null;

        ArrayList<Aluno> alunos = null;
        ArrayList<Turma> turmas = null;
        ArrayList<Professor> professores = null;
        ArrayList<Disciplina> disciplinas = null;
        ArrayList<Prova> provas = null;
        ArrayList<Trabalho> trabalhos = null;

        output.display("====== Impressão =====");
        output.display("1 - Imprimir alunos");
        output.display("2 - Imprimir turmas");
        output.display("3 - Imprimir professores");
        output.display("4 - Imprimir disciplinas");
        output.display("5 - Imprimir Dados Aluno");
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

        switch (opc) {
            case 1:
                alunos = controlador.getTodosAlunos();
                output.display("=========================");
                for (Aluno a : alunos) {
                    output.display("ID: " + a.getID());
                    output.display("Matricula: " + a.getMatricula());
                    output.display("Nome: " + a.getNome());
                    output.display("=========================");
                }
                break;

            case 2:
                turmas = controlador.getTodasTurmas();
                output.display("=========================");
                for (Turma t : turmas) {
                    output.display("ID: " + t.getID());
                    output.display("Nome: " + t.getNomeTurma());
                    output.display("QTD vagas: " + t.getQuantidadeVagas());
                    output.display("=========================");
                }
                break;

            case 3:
                professores = controlador.getTodosProfessores();
                output.display("=========================");
                for (Professor p : professores) {
                    output.display("ID: " + p.getID());
                    output.display("Nome: " + p.getNome());
                    output.display("=========================");
                }
                break;

            case 4:
                disciplinas = controlador.getTodasDisciplinas();
                output.display("=========================");
                for (Disciplina d : disciplinas) {
                    output.display("Nome: " + d.getNome());
                    output.display("Unidade Escolar: " + d.getUnidadeEscolar());
                    output.display("Ano Escolar: " + d.getAnoEscolar());
                    output.display("=========================");
                }
                break;
            case 5:
                matricula = menuSelecionarAluno(controlador.getTodosAlunos());

                relatorioAluno(controlador.getAlunoMatricula(matricula));
                break;

            case 7:
                // Imprimir Dados Professor
                output.display("=========================");
                idProfessor = menuSelecionarProfessor(controlador.getTodosProfessores());

                prof = controlador.getProfessorId(idProfessor);

                output.display("Nome: " + prof.getNome());
                output.display("Titulação: " + prof.getTitulacao());
                output.display("Turmas: ");
                for (Turma t : prof.getTurmas()) {
                    output.display("\nNome: " + t.getNomeTurma());
                }

                output.display("\n=========================");
                break;
            case 8:
                nomeDisciplina = menuSelecionarDisciplina(controlador.getTodasDisciplinas());

                relatorioDisciplina(controlador.getDisciplinaNome(nomeDisciplina));

            case 9:
                // Imprimir Dados Prova
                output.display("=========================");
                nomeDisciplina = menuSelecionarDisciplina(controlador.getTodasDisciplinas());

                disciplina = controlador.getDisciplinaNome(nomeDisciplina);
                provas = disciplina.getProvas();

                for (Prova p : provas) {
                    output.display("Nome: " + p.getNomeProva());
                    output.display("Peso: " + p.getPeso());
                    output.display("Nota: " + p.getNota());
                }
                output.display("=========================");
                break;
            case 10:
                nomeDisciplina = menuSelecionarDisciplina(controlador.getTodasDisciplinas());

                disciplina = controlador.getDisciplinaNome(nomeDisciplina);
                trabalhos = disciplina.getTrabalhos();

                for (Trabalho t : trabalhos) {
                    relatorioTrabalho(t);
                }
                break;
            case 13:
                ArrayList<Turma> turmasHorario = controlador.getTodasTurmas();
                output.display("Digite o ID da turma: ");
                String turmaId = sc.nextLine();

                for (Turma t : turmasHorario) {
                    if (t.getID().equals(turmaId)) {
                        output.display("====== Horário da Turma =====");
                        output.display("ID: " + t.getID());
                        output.display("Nome: " + t.getNomeTurma());
                        output.display("Horário: \n" + t.getHorario().toString());
                        output.display("=========================");
                    }
                }
                output.display("0 - Voltar");
                output.display("==============================");
                int opcHorario = sc.nextInt();
                sc.nextLine();
                if (opcHorario == 0) {
                    break;
                }
                break;

            case 0:
                return;
        }
    }

    public static void relatorioTrabalho(Trabalho t) {
        if (t == null) {
            output.display("Trabalho inexistente");
            return;
        }

        output.display("============= Trabalho ==============");
        output.display(String.format("Nome: %s", t.getNomeTrabalho()));
        output.display(String.format("Peso: %.2f", t.getPeso()));
        output.display(String.format("Nota: %s", t.getNota()));
        output.display("=====================================");
    }

    public static void relatorioAluno(Aluno a) {
        if (a == null) {
            output.display("Aluno inexistente");
            return;
        }

        output.display("=============== Aluno ===============");
        output.display(String.format("Matrícula: %s", a.getMatricula()));
        output.display(String.format("Nome: %s", a.getNome()));
        output.display(String.format("Média: %.2f", a.calcularMedia()));
        output.display("=====================================");
    }

    public static void relatorioDisciplina(Disciplina d) {
        if (d == null) {
            output.display("Disciplina inexistente");
            return;
        }

        output.display("============= Disciplina ============");
        output.display(String.format("Nome: %s", d.getNome()));
        output.display(String.format("Ano Escolar: %s", d.getAnoEscolar()));
        output.display(String.format("Unidade Escolar: %s", d.getUnidadeEscolar()));
        output.display(String.format("Ementa: %s", d.getEmenta()));
        output.display(String.format("Objetivos: %s", d.getObjetivos()));
        output.display(String.format("Metodologia: %s", d.getMetodologia()));
        output.display(String.format("Ementa: %s", d.getEmenta()));
        output.display(String.format("Média: %.2f", d.calcularMedia()));
        output.display(String.format("Carga Horária: %dh", d.getCargaHoraria()));
        output.display("=====================================");
    }

    public static void menuAdicionarNotaParaAluno() {
        int opc;
        String nomeTurma = "";
        String IdTurma = "";
        String nomeAluno = "";
        String matriculaAluno = "";
        String nomeDisciplina = "";
        String nomeProfessor = "";
        String IdProfessor = "";
        String nomeAvalicao = "";
        float notaAvaliacao;

        while (true) {
            output.display("======Adicionar Notas Para Aluno======");
            output.display("1 - Adicionar Nota para prova");
            output.display("2 - Adicionar Nota para trabalho");
            output.display("3 - Adicionar Nota para ponto extra");
            output.display("0 - Voltar");
            output.display("==============================");
            output.display("Selecione sua opção: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    ArrayList<Turma> turmas = controlador.getTodasTurmas();
                    IdTurma = menuSelecionarTurma(turmas);

                    for (Turma turma : turmas) {
                        if (turma.getID().equals(IdTurma)) {
                            nomeTurma = turma.getNomeTurma();

                            ArrayList<Aluno> alunos = turma.getAlunos();
                            matriculaAluno = menuSelecionarAluno(alunos);

                            for (Aluno aluno : alunos) {
                                if (aluno.getMatricula().equals(matriculaAluno)) {
                                    nomeAluno = aluno.getNome();
                                }
                            }

                            ArrayList<Disciplina> disciplinas = turma.getDisciplinas();
                            nomeDisciplina = menuSelecionarDisciplina(disciplinas);

                            for (Disciplina disciplina : disciplinas) {
                                if (disciplina.getNome().equals(nomeDisciplina)) {
                                    ArrayList<Professor> professores = disciplina.getProfessores();
                                    IdProfessor = menuSelecionarProfessor(professores);

                                    for (Professor professor : professores) {
                                        if (professor.getID().equals(IdProfessor)) {
                                            nomeProfessor = professor.getNome();
                                        }
                                    }

                                    ArrayList<Prova> provas = disciplina.getProvas();
                                    for (Prova prova : provas) {
                                        output.display(prova.getNomeProva());
                                    }
                                    output.display("Digite nome Prova: ");
                                    nomeAvalicao = sc.nextLine();

                                    output.display("Digite nota Prova: ");
                                    notaAvaliacao = sc.nextInt();

                                    controlador.adicionarNotaProva(nomeAluno, nomeDisciplina, nomeProfessor,
                                            nomeAvalicao, notaAvaliacao, nomeTurma);

                                }
                            }
                        }
                    }
                    break;

                case 2:
                    ArrayList<Turma> turmasTrabalho = controlador.getTodasTurmas();
                    IdTurma = menuSelecionarTurma(turmasTrabalho);

                    for (Turma turma : turmasTrabalho) {
                        if (turma.getID().equals(IdTurma)) {
                            nomeTurma = turma.getNomeTurma();

                            ArrayList<Aluno> alunosTrabalho = turma.getAlunos();
                            matriculaAluno = menuSelecionarAluno(alunosTrabalho);

                            for (Aluno aluno : alunosTrabalho) {
                                if (aluno.getMatricula().equals(matriculaAluno)) {
                                    nomeAluno = aluno.getNome();
                                }
                            }

                            ArrayList<Disciplina> disciplinas = turma.getDisciplinas();
                            nomeDisciplina = menuSelecionarDisciplina(disciplinas);

                            for (Disciplina disciplina : disciplinas) {
                                if (disciplina.getNome().equals(nomeDisciplina)) {
                                    ArrayList<Professor> professoresTrabalho = disciplina.getProfessores();
                                    IdProfessor = menuSelecionarProfessor(professoresTrabalho);

                                    for (Professor professor : professoresTrabalho) {
                                        if (professor.getID().equals(IdProfessor)) {
                                            nomeProfessor = professor.getNome();
                                        }
                                    }

                                    ArrayList<Trabalho> trabalhos = disciplina.getTrabalhos();
                                    for (Trabalho trabalho : trabalhos) {
                                        output.display(trabalho.getNomeTrabalho());
                                    }
                                    output.display("Digite nome Trabalho: ");
                                    nomeAvalicao = sc.nextLine();

                                    output.display("Digite nota Trabalho: ");
                                    notaAvaliacao = sc.nextInt();

                                    controlador.adicionarNotaTrabalho(nomeAluno, nomeDisciplina, nomeProfessor,
                                            nomeAvalicao, notaAvaliacao, nomeTurma);
                                }
                            }
                        }
                    }
                    break;

                case 3:
                    ArrayList<Turma> turmasPontoExtra = controlador.getTodasTurmas();
                    IdTurma = menuSelecionarTurma(turmasPontoExtra);

                    for (Turma turma : turmasPontoExtra) {
                        if (turma.getID().equals(IdTurma)) {
                            nomeTurma = turma.getNomeTurma();

                            ArrayList<Aluno> alunosPontoExtra = turma.getAlunos();
                            matriculaAluno = menuSelecionarAluno(alunosPontoExtra);

                            for (Aluno aluno : alunosPontoExtra) {
                                if (aluno.getMatricula().equals(matriculaAluno)) {
                                    nomeAluno = aluno.getNome();
                                }
                            }

                            ArrayList<Disciplina> disciplinasPontoExtra = turma.getDisciplinas();
                            nomeDisciplina = menuSelecionarDisciplina(disciplinasPontoExtra);

                            for (Disciplina disciplina : disciplinasPontoExtra) {
                                if (disciplina.getNome().equals(nomeDisciplina)) {
                                    ArrayList<Professor> professoresPontoExtra = disciplina.getProfessores();
                                    IdProfessor = menuSelecionarProfessor(professoresPontoExtra);

                                    for (Professor professor : professoresPontoExtra) {
                                        if (professor.getID().equals(IdProfessor)) {
                                            nomeProfessor = professor.getNome();
                                        }
                                    }

                                    output.display("Digite nome Ponto Extra: ");
                                    nomeAvalicao = sc.nextLine();

                                    output.display("Digite valor Ponto Extra: ");
                                    notaAvaliacao = sc.nextInt();

                                    controlador.adicionarNotaPontoExtra(nomeAluno, nomeDisciplina, nomeProfessor,
                                            nomeAvalicao, nomeTurma, notaAvaliacao);
                                }
                            }
                        }
                    }
                    break;

                case 0:
                    return;
            }
        }
    }

    public static void menuAdicionarNotaParaTurma() {
        int opc;
        String nomeTurma = "";
        String IdTurma = "";
        String nomeAluno = "";
        String matriculaAluno = "";
        String nomeDisciplina = "";
        String nomeProfessor = "";
        String IdProfessor = "";
        String nomeAvalicao = "";
        float notaAvaliacao;

        while (true) {
            output.display("======Adicionar Notas Para Turma======");
            output.display("1 - Adicionar Notas de prova");
            output.display("2 - Adicionar Notas de trabalho");
            output.display("3 - Adicionar Notas de ponto extra");
            output.display("0 - Voltar");
            output.display("==============================");
            output.display("Selecione sua opção: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    ArrayList<Turma> turmas = controlador.getTodasTurmas();
                    IdTurma = menuSelecionarTurma(turmas);

                    for (Turma turma : turmas) {
                        if (turma.getID().equals(IdTurma)) {
                            nomeTurma = turma.getNomeTurma();

                            ArrayList<Disciplina> disciplinas = turma.getDisciplinas();
                            nomeDisciplina = menuSelecionarDisciplina(disciplinas);

                            for (Disciplina disciplina : disciplinas) {
                                if (disciplina.getNome().equals(nomeDisciplina)) {
                                    ArrayList<Professor> professores = disciplina.getProfessores();
                                    IdProfessor = menuSelecionarProfessor(professores);

                                    for (Professor professor : professores) {
                                        if (professor.getID().equals(IdProfessor)) {
                                            nomeProfessor = professor.getNome();
                                        }
                                    }

                                    ArrayList<Prova> provas = disciplina.getProvas();
                                    for (Prova prova : provas) {
                                        output.display(prova.getNomeProva());
                                    }
                                    output.display("Digite nome Prova: ");
                                    nomeAvalicao = sc.nextLine();
                                }
                            }

                            ArrayList<Aluno> alunos = turma.getAlunos();
                            for (Aluno aluno : alunos) {
                                output.display("Digite nota Prova aluno " + aluno.getNome() + ": ");
                                notaAvaliacao = sc.nextInt();
                                controlador.adicionarNotaProva(aluno.getNome(), nomeDisciplina, nomeProfessor,
                                        nomeTurma, notaAvaliacao, nomeTurma);
                            }

                        }
                    }
                    break;

                case 2:
                    ArrayList<Turma> turmasTrabalho = controlador.getTodasTurmas();
                    IdTurma = menuSelecionarTurma(turmasTrabalho);

                    for (Turma turma : turmasTrabalho) {
                        if (turma.getID().equals(IdTurma)) {
                            nomeTurma = turma.getNomeTurma();

                            ArrayList<Disciplina> disciplinas = turma.getDisciplinas();
                            nomeDisciplina = menuSelecionarDisciplina(disciplinas);

                            for (Disciplina disciplina : disciplinas) {
                                if (disciplina.getNome().equals(nomeDisciplina)) {
                                    ArrayList<Professor> professores = disciplina.getProfessores();
                                    IdProfessor = menuSelecionarProfessor(professores);

                                    for (Professor professor : professores) {
                                        if (professor.getID().equals(IdProfessor)) {
                                            nomeProfessor = professor.getNome();
                                        }
                                    }

                                    ArrayList<Trabalho> trabalhos = disciplina.getTrabalhos();
                                    for (Trabalho trabalho : trabalhos) {
                                        output.display(trabalho.getNomeTrabalho());
                                    }
                                    output.display("Digite nome Trabalho: ");
                                    nomeAvalicao = sc.nextLine();
                                }
                            }

                            ArrayList<Aluno> alunos = turma.getAlunos();
                            for (Aluno aluno : alunos) {
                                output.display("Digite nota Trabalho aluno " + aluno.getNome() + ": ");
                                notaAvaliacao = sc.nextInt();
                                controlador.adicionarNotaTrabalho(aluno.getNome(), nomeDisciplina, nomeProfessor,
                                        nomeAvalicao, notaAvaliacao, nomeTurma);
                            }
                        }
                    }
                    break;

                case 3:
                    ArrayList<Turma> turmasPontoExtra = controlador.getTodasTurmas();
                    IdTurma = menuSelecionarTurma(turmasPontoExtra);

                    for (Turma turma : turmasPontoExtra) {
                        if (turma.getID().equals(IdTurma)) {
                            nomeTurma = turma.getNomeTurma();

                            ArrayList<Disciplina> disciplinas = turma.getDisciplinas();
                            nomeDisciplina = menuSelecionarDisciplina(disciplinas);

                            for (Disciplina disciplina : disciplinas) {
                                if (disciplina.getNome().equals(nomeDisciplina)) {
                                    ArrayList<Professor> professores = disciplina.getProfessores();
                                    IdProfessor = menuSelecionarProfessor(professores);

                                    for (Professor professor : professores) {
                                        if (professor.getID().equals(IdProfessor)) {
                                            nomeProfessor = professor.getNome();
                                        }
                                    }

                                    output.display("Digite nome Ponto Extra: ");
                                    nomeAvalicao = sc.nextLine();
                                }
                            }

                            ArrayList<Aluno> alunos = turma.getAlunos();
                            for (Aluno aluno : alunos) {
                                output.display("Digite valor Ponto Extra aluno " + aluno.getNome() + ": ");
                                notaAvaliacao = sc.nextInt();
                                controlador.adicionarNotaPontoExtra(aluno.getNome(), nomeDisciplina, nomeProfessor,
                                        nomeAvalicao, nomeTurma, notaAvaliacao);
                            }
                        }
                    }
                    break;

                case 0:
                    return;
            }
        }
    }

    public static void menuPrincipal() {

        int opc = 0;
        String turmaId = "";
        String alunoMatricula = "";
        String nome = "";
        String titulacao = "";
        String unidadeEscolar = "";
        String disciplinaId = "";
        String anoEscolar = "";
        int qtd = 0;
        String professorId = "";

        ArrayList<Aluno> alunos;
        ArrayList<Turma> turmas;
        ArrayList<Professor> professores;
        ArrayList<Disciplina> disciplinas;

        while (true) {
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
            output.display("11 - Atribuir Professores a Disciplinas de uma Turma");
            output.display("12 - Atribuir professor a uma disciplina");   
            output.display("0 - Sair");
            output.display("==============================");
            output.display("Selecione sua opção: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
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
                    menuSelecionarTurma(controlador.getTodasTurmas());
                    turmaId = sc.nextLine();
                    menuSelecionarAluno(controlador.getTodosAlunos());
                    alunoMatricula = sc.nextLine();
                    controlador.trocaAlunoTurma(alunoMatricula, turmaId);
                    break;

                case 5:
                    output.display("Digite o nome da disciplina: ");
                    disciplinaId = sc.nextLine();
                    turmaId = menuSelecionarTurma(controlador.getTodasTurmas());
                    controlador.addDisciplinaTurma(disciplinaId, turmaId);

                    break;

                case 6:
                    // Não mexer
                    menuAdicionarNotaParaAluno();
                    break;

                case 7:
                    // Não mexer
                    menuAdicionarNotaParaTurma();
                    break;

                case 8:
                    professores = controlador.getTodosProfessores();
                    output.display("=========================");
                    for (Professor p : professores) {
                        output.display("ID: " + p.getID());
                        output.display("Nome: " + p.getNome());
                        turmas = p.getTurmas();
                        output.display("Turmas: ");
                        output.display("-------------------------");
                        for (Turma t : turmas) {
                            output.display("Nome: " + t.getNomeTurma());
                            output.display("-------------------------");
                        }
                        output.display("=========================");
                    }
                    break;

                case 9:
                    output.display(RelatorioProfessores.relatorioProfessores(controlador.getTodosProfessores()));
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
                    turmaId = menuSelecionarTurma(controlador.getTodasTurmas());
                    menuSelecionarProfessorDisciplinaTurma(turmaId);
                    break;

                case 12:
                    professorId = menuSelecionarProfessor(controlador.getTodosProfessores());
                    disciplinaId = menuSelecionarDisciplina(controlador.getTodasDisciplinas());
                    controlador.atribuirProfessorDisciplina(disciplinaId, professorId);
                    break;

                case 13:
                    menuAdminBiblioteca();
                    break;
                
                case 0:
                    return;
            }
        }
    }

    public static String menuSelecionarTurma(ArrayList<Turma> turmas) {
        String turmaId = "";
        output.display("====== Selecione a turma =====");

        for (Turma t : turmas) {
            output.display(t.getID() + " - " + t.getNomeTurma());
        }

        output.display("==============================");
        output.display("Selecione sua opção: ");

        turmaId = sc.nextLine();
        return turmaId;
    }

    public static String menuSelecionarAluno(ArrayList<Aluno> alunos) {
        String alunoMatricula = "";
        output.display("====== Selecione o aluno =====");

        for (Aluno a : alunos) {
            output.display(a.getMatricula() + " - " + a.getNome());
        }

        output.display("==============================");
        output.display("Selecione sua opção: ");
        alunoMatricula = sc.nextLine();

        return alunoMatricula;
    }

    public static String menuSelecionarProfessor(ArrayList<Professor> professores) {
        String professorId = "";
        output.display("====== Selecione o professor =====");

        for (Professor p : professores) {
            output.display(p.getID() + " - " + p.getNome());
        }

        output.display("==============================");
        output.display("Selecione sua opção: ");
        
        professorId = sc.nextLine();

        return professorId;
    }

    public static String menuSelecionarDisciplina(ArrayList<Disciplina> disciplinas) {
        String nomeDisciplina = "";
        output.display("====== Selecione a disciplina =====");

        for (Disciplina d : disciplinas) {
            output.display(d.getNome());
        }

        output.display("==============================");
        output.display("Digite o nome da disciplina: ");
        nomeDisciplina = sc.nextLine();

        return nomeDisciplina;
    }

    public static void menuAdminBiblioteca() {
        int opc = 0;
        String titulo = "";
        String autor = "";
        String isbn = "";
        BibliotecaEscolar biblioteca = controlador.getBiblioteca();
        BibliotecaEscolarConsole bibliotecaConsole = new BibliotecaEscolarConsole();

        while (true) {
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
                    bibliotecaConsole.imprimirCatalogoDeLivros(biblioteca);
                    break;

                case 2:
                    output.display("Digite o título do livro: ");
                    titulo = sc.nextLine();
                    // bibliotecaConsole.buscarLivroPorTitulo(biblioteca, titulo);
                    break;

                case 3:
                    output.display("Digite o autor do livro: ");
                    autor = sc.nextLine();
                    // biblioteca.buscarLivroPorAutor(autor);
                    break;

                case 4:
                    output.display("Digite o ISBN do livro: ");
                    isbn = sc.nextLine();
                    // biblioteca.buscarLivroPorISBN(isbn);
                    break;

                case 5:
                    output.display("Digite o ID do usuário: ");
                    String usuarioId = sc.nextLine();
                    output.display("Digite o ISBN do livro: ");
                    isbn = sc.nextLine();
                    // biblioteca.fazerEmprestimo(usuarioId, isbn);
                    break;

                case 6:
                    output.display("Digite o ID do usuário: ");
                    usuarioId = sc.nextLine();
                    output.display("Digite o ISBN do livro: ");
                    isbn = sc.nextLine();
                    // biblioteca.fazerDevolucao(usuarioId, isbn);
                    break;

                case 7:
                    // biblioteca.relatorioGeralLivros();
                    break;

                case 8:
                    output.display("Digite o nome do livro: ");
                    titulo = sc.nextLine();

                    output.display("Digite o autor do livro: ");
                    autor = sc.nextLine();

                    output.display("Digite o isbn do livro: ");
                    isbn = sc.nextLine();

                    // controlador.addLivroBiblioteca(titulo, autor, isbn);
                    break;

                case 9:
                    // biblioteca.relatorioMultas();
                    break;

            }
        }
    }

    public static void seed() {
        // Gerando turmas para testes
        controlador.addTurma("6A", 33);
        controlador.addTurma("6B", 30);
        controlador.addTurma("7A", 28);
        controlador.addTurma("7B", 32);
        controlador.addTurma("8A", 29);
        controlador.addTurma("8B", 31);
        controlador.addTurma("9A", 27);
        controlador.addTurma("9B", 26);

        // Gerando professores para testes
        controlador.addProfessor("João", "Doutorado");
        controlador.addProfessor("Maria", "Mestrado");
        controlador.addProfessor("José", "Doutorado");
        controlador.addProfessor("Ana", "Mestrado");
        controlador.addProfessor("Carlos", "Doutorado");

        //Gerando disciplinas para testes (nome, unidade escolar, ano escolar)
        controlador.addDisciplina("Matemática", "Escola Estadual", "6º ano");
        controlador.addDisciplina("Português", "Escola Estadual", "6º ano");
        controlador.addDisciplina("História", "Escola Estadual", "6º ano");
        controlador.addDisciplina("Geografia", "Escola Estadual", "6º ano");
        
        int cont=0;
        ArrayList<Professor> professores = controlador.getTodosProfessores();
        for(Professor p : professores){
            switch(cont % 4){
                case 0:
                    controlador.atribuirProfessorDisciplina("Matemática", p.getID());
                    break;
                case 1:
                    controlador.atribuirProfessorDisciplina("Português", p.getID());
                    break;
                case 2:
                    controlador.atribuirProfessorDisciplina("História", p.getID());
                    break;
                case 3:
                    controlador.atribuirProfessorDisciplina("Geografia", p.getID());
                    break;
            }
            cont++;
        }
        

        // Gerando 30 livros para simular um banco de dados
        controlador.addLivroBiblioteca("Dom Casmurro", "Machado de Assis", "978-8525054182", "Romance");
        controlador.addLivroBiblioteca("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "978-8535931962", "Infantil");
        controlador.addLivroBiblioteca("1984", "George Orwell", "978-8535930859", "Distopia");
        controlador.addLivroBiblioteca("A Moreninha", "Joaquim Manuel de Macedo", "978-8575030211", "Romance");
        controlador.addLivroBiblioteca("O Alquimista", "Paulo Coelho", "978-8580417994", "Ficção");
        controlador.addLivroBiblioteca("Cem Anos de Solidão", "Gabriel García Márquez", "978-8535932396",
                "Realismo Mágico");
        controlador.addLivroBiblioteca("Moby Dick", "Herman Melville", "978-8535924698", "Aventura");
        controlador.addLivroBiblioteca("A Revolução dos Bichos", "George Orwell", "978-8573022861", "Satírica");
        controlador.addLivroBiblioteca("O Senhor dos Anéis", "J.R.R. Tolkien", "978-8576607164", "Fantasia");
        controlador.addLivroBiblioteca("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "978-8532530191",
                "Fantasia");
        controlador.addLivroBiblioteca("A Metamorfose", "Franz Kafka", "978-8535923981", "Ficção");
        controlador.addLivroBiblioteca("O Cortiço", "Aluísio Azevedo", "978-8535923165", "Naturalismo");
        controlador.addLivroBiblioteca("A Cabana", "William P. Young", "978-8573025135", "Ficção");
        controlador.addLivroBiblioteca("Orgulho e Preconceito", "Jane Austen", "978-8532511794", "Romance");
        controlador.addLivroBiblioteca("O Morro dos Ventos Uivantes", "Emily Brontë", "978-8573024794", "Romance");
        controlador.addLivroBiblioteca("Fahrenheit 451", "Ray Bradbury", "978-8535926852", "Distopia");
        controlador.addLivroBiblioteca("O Guarani", "José de Alencar", "978-8525054090", "Romance");
        controlador.addLivroBiblioteca("O Primo Basílio", "José Maria de Eça de Queirós", "978-8525065607", "Romance");
        controlador.addLivroBiblioteca("Iracema", "José de Alencar", "978-8525052430", "Romance");
        controlador.addLivroBiblioteca("O Filho de Mil Homens", "Valter Hugo Mãe", "978-8535925688", "Ficção");
        controlador.addLivroBiblioteca("A Menina que Roubava Livros", "Markus Zusak", "978-8580570569", "Ficção");
        controlador.addLivroBiblioteca("O Lobo da Estepe", "Hermann Hesse", "978-8573026415", "Ficção");
        controlador.addLivroBiblioteca("Os Miseráveis", "Victor Hugo", "978-8535925680", "Romance");
        controlador.addLivroBiblioteca("A Ilha do Tesouro", "Robert Louis Stevenson", "978-8535911768", "Aventura");
        controlador.addLivroBiblioteca("A Dama das Camélias", "Alexandre Dumas Filho", "978-8576351611", "Romance");
        controlador.addLivroBiblioteca("O Processo", "Franz Kafka", "978-8575028811", "Ficção");
        controlador.addLivroBiblioteca("A Peste", "Albert Camus", "978-8535923945", "Ficção");
        controlador.addLivroBiblioteca("O Sol é Para Todos", "Harper Lee", "978-8535922528", "Ficção");
        controlador.addLivroBiblioteca("O Fim da Eternidade", "Isaac Asimov", "978-8535923181", "Ficção Científica");
        controlador.addLivroBiblioteca("O Nome da Rosa", "Umberto Eco", "978-8535923150", "Mistério");
        controlador.addLivroBiblioteca("A Cor Púrpura", "Alice Walker", "978-8535923853", "Ficção");
        controlador.addLivroBiblioteca("O Livro dos Espíritos", "Allan Kardec", "978-8573023148", "Religião");

    }

    public static void main(String[] args) {
        seed();
        menuPrincipal();

    }
}
