package controlador;

import java.util.ArrayList;
import java.util.UUID;

import horario.Horario;
import modelo.*;
import modelo.Output.OutputFactory;
import java.time.LocalTime;

/**
 * Classe principal que representa uma escola, contendo métodos para gerenciar alunos, professores, turmas, disciplinas e a biblioteca
 */

public class Escola{
    private ArrayList<Aluno> alunos;
    private ArrayList<Professor> professores;
    private ArrayList<Turma> turmas;
    private ArrayList<Disciplina> disciplinas;
    private BibliotecaEscolar biblioteca;
    private BibliotecaEscolarConsole bibliotecaConsole;
    private ArrayList<Horario> horarios;
    private Notas notas;
    private final OutputFactory outputFactory;
    private String tipoOutput;

  /**
  * Construtor da classe escola
  * @Parameter outputFactory Fábrica de saída para gerenciar o formato de exportação de dados
  * @Parameter tipoOutput Tipo de saída a ser utilizada
  */
    public Escola(OutputFactory outputFactory, String tipoOutput){
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.biblioteca = new BibliotecaEscolar();
        this.notas = Notas.getInstance(disciplinas);
        this.outputFactory = outputFactory;
        this.tipoOutput = tipoOutput;
        this.horarios = new ArrayList<>();    
    }

    /**
     * Obtem todas as turmas da escola
    * @Return Lista de todas as turmas cadastradas na escola
    */
    public ArrayList<Turma> getTodasTurmas(){
        return this.turmas;
    }

    /**
    * Obtem todos os alunos da escola
    * @Return Lista de todos os alunos matriculados na escola
    */
    public ArrayList<Aluno> getTodosAlunos(){
        return this.alunos;
    }
        
    /**
    * Obtem todos os professores da escola
    * @Return Lista de todos os professores cadastrados na escola
    */
    public ArrayList<Professor> getTodosProfessores(){
        return this.professores;
    }
    
    public ArrayList<PontoExtra> getPontosExtrasDisciplina(String nomeDisciplina){
        Disciplina d = this.getDisciplinaNome(nomeDisciplina);
        return d.getPontosExtra();
    }
        
  /**
  * Obtem a lista de professores associados a uma disciplina específica
  * @Parameter nomeDisciplina Nome da disciplina desejada
  * @Return Lista de professores da disciplina, ou `null` se a disciplina não existir
  */
  public ArrayList<Professor> getProfessoresDisciplina(String nomeDisciplina){
      Disciplina d = getDisciplinaNome(nomeDisciplina);

      if(d == null)
        return null;

      return d.getProfessores();
  }
        
    /**
     * Obtem todas as disciplinas oferecidas pela escola
    * @Return Lista de todas as disciplinas cadastradas
    */
    public ArrayList<Disciplina> getTodasDisciplinas(){
        return this.disciplinas;
    }

    /**
    * Busca uma disciplina pelo nome
    * @Parameter nome Nome da disciplina
    * @Return Objeto Disciplina correspondente, ou `null` se não for encontrada
    */
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

    /**
    * Obtem a biblioteca associada à escola
    * @Return Objeto da biblioteca escolar
    */
    public BibliotecaEscolar getBiblioteca(){
        return this.biblioteca;
    }

    /**
    * Retorna uma turma pelo ID
    * @Parameter: idTurma ID da turma a ser buscada
    * @Return: A turma correspondente ao ID, ou null se não encontrada
    */
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
    
    public ArrayList<Disciplina> getDisciplinasTurma(String turmaId){
        Turma t = getTurmaId(turmaId);
        return t.getDisciplinas();
    }

    /**
    * Retorna um aluno pela matrícula
    * @Parameter: matricula - Matrícula do aluno a ser buscado
    * @Return: O aluno correspondente à matrícula, ou null se não encontrado
    */
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

    /**
    * Retorna um professor pelo ID
    * @Parameter: idProfessor - ID do professor a ser buscado
    * @Return: O professor correspondente ao ID, ou null se não encontrado
    */
    public Professor getProfessorId(String idProfessor){
        
        for(Professor professor : professores){
            if(professor.getID().equals(idProfessor)){
                return professor;
            }
        }
        return null;
    }

    /**
    * Adiciona um novo professor na lista de professores
    * @Parameter: nome - Nome do professor
    * @Parameter: titulacao - Titulação do professor
    */
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

    public void atribuirProfessorDisciplina(String nomeDisciplina, String nomeProfessor){
        Disciplina disciplina = getDisciplinaNome(nomeDisciplina);
        Professor professor = getProfessorId(nomeProfessor);
        Logger logger = Logger.getInstance();
        if(professor == null){
            System.out.println("Professor não encontrado");
        } 
        if(disciplina == null){
            System.out.println("Disciplina não encontrada");
        }

        if(disciplina != null && professor != null){
            disciplina.adicionarProfessor(professor);
            logger.gravaArquivo(String.format("Professor %s atribuído à disciplina %s", nomeProfessor, nomeDisciplina), Logger.Level.INFO);
        }else{
            logger.gravaArquivo(String.format("Falha na atribuição de professor à disciplina %s", nomeDisciplina), Logger.Level.ERROR);
        }
    }


    /**
    * Adiciona uma nova disciplina na lista de disciplinas
    * @Parameter: nome - Nome da disciplina
    * @Parameter: unidadeEscolar - Unidade escolar da disciplina
    * @Parameter: anoEscolar - Ano escolar da disciplina
    */
    public void addDisciplina(String nome, String unidadeEscolar, String anoEscolar){
        Logger logger = Logger.getInstance();

        Disciplina nova = new Disciplina(outputFactory, nome, unidadeEscolar, anoEscolar, tipoOutput, null);
        this.disciplinas.add(nova);
        logger.gravaArquivo(String.format("Disciplina %s para o ano escolar '%s' adicionada", nome, anoEscolar), Logger.Level.INFO);
    }
        
    /**
    * Adiciona uma nova turma na lista de turmas
    * @Parameter: nome - Nome da turma
    * @Parameter: quantidadeVagas - Quantidade de vagas disponíveis na turma
    */
    public void addTurma(String nome, int quantidadeVagas){
        UUID id = UUID.randomUUID();
        Logger logger = Logger.getInstance();

        Turma novo = new Turma(nome, id.toString(), quantidadeVagas);

        logger.gravaArquivo(String.format("Turma %s adicionado", nome), Logger.Level.INFO);
        this.turmas.add(novo);
    }
        
    /**
    * Adiciona um aluno a uma turma específica
    * @Parameter: nome - Nome do aluno
    * @Parameter: idTurma - ID da turma onde o aluno será adicionado
    */
    public void addAlunoTurma(String nome, String idTurma){
        UUID id = UUID.randomUUID();
        UUID matricula = UUID.randomUUID();
        Logger logger = Logger.getInstance();

        Aluno novo = new Aluno(outputFactory, nome, id.toString(), matricula.toString(), "teste", tipoOutput);

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


    /**
    * Troca um aluno de uma turma para outra
    * @Parameter: matricula - Matrícula do aluno
    * @Parameter: idTurma - ID da nova turma
    */
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

    /**
    * Adiciona uma disciplina a uma turma
    * @Parameter: nome - Nome da disciplina
    * @Parameter: idTurma - ID da turma onde a disciplina será adicionada
    */
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

    /**
    * Remove uma disciplina de uma turma
    * @Parameter: nome - Nome da disciplina
    * @Parameter: idTurma - ID da turma de onde a disciplina será removida
    */
    public void removerDisciplinaTurma(String nome, String idTurma){
        Disciplina disciplina = this.getDisciplinaNome(nome);
        Turma turma = this.getTurmaId(idTurma);

        if(disciplina != null && turma != null){
            turma.removerDisciplina(disciplina);
        }
    }

    /**
    * Remove uma turma da lista de turmas
    * @Parameter: idTurma - ID da turma a ser removida
    */
    public void removerTurma(String idTurma) {
        Logger logger = Logger.getInstance();
        int i;

        for(Turma turma : turmas) {
            if(turma.getID().equals(idTurma)) {
                i=0;

                while(!turma.getDisciplinas().isEmpty()) {
                    turma.removerDisciplina(turma.getDisciplinas().get(i));
                    i++;
                }
                
                turma.setAlunos(null);
                turma.getHorario().removerTudo();
                turmas.remove(turma);
                logger.gravaArquivo(String.format("Turma %s removida", turma.getNomeTurma()), Logger.Level.INFO);

                break;
            }
        }
    }
        
    /**
    * Adiciona um horário a uma turma
    * @Parameter: h - Objeto de horário
    * @Parameter: idTurma - ID da turma onde o horário será associado
    */    
    public void definirProfessorDisciplinaTurma(String turmaId, String nomeDisciplina, String professorId){
        Turma t = getTurmaId(turmaId);
        Professor p = getProfessorId(professorId);
        Disciplina d = getDisciplinaNome(nomeDisciplina);
        Logger logger = Logger.getInstance();

        if(t != null && d != null && p != null){
            t.definirProfessorDisciplina(d, p);
            logger.gravaArquivo(String.format("Disciplina '%s' atribuída para o professor '%s', na Turma '%s' ", professorId, nomeDisciplina, turmaId), Logger.Level.INFO);
        }else{
            logger.gravaArquivo(String.format("Falha na atribuição de Disciplinas na turma '%s", turmaId), Logger.Level.ERROR);
        }
    }
    
    /**
     * Método para adicionar um horário a uma turma
     * @parameter turmaId
     * @return {@link Horario}
     */
    public Horario getHorarioTurmaId(String turmaId){
        Turma t = getTurmaId(turmaId);
        Horario h = t.getHorario();
        return h;
    }


    /**
     * Método para adicionar um horário a uma turma
     * @parameter dia
     * @parameter inicio
     * @parameter turmaId
     * @parameter nomeDisciplina
     */
    public void addDisciplinaHorarioTurma(String dia, LocalTime inicio, String turmaId, String nomeDisciplina){
        Turma t = getTurmaId(turmaId);
        Disciplina d = getDisciplinaNome(nomeDisciplina);
        Professor p = t.getProfessorDisciplina(d);
        Logger logger = Logger.getInstance();

        if(t != null && d != null && p != null){
            Horario h = t.getHorario();
            h.adicionarDisciplina(dia, d, inicio);
            h.adicionarProfessorDisciplina(dia, d, p);
            logger.gravaArquivo(String.format("Nova Disciplina '%s' lecionada pelo professor '%s' adicionada com sucesso no Horário da turma '%s'", nomeDisciplina, p.getNome(), turmaId ), Logger.Level.INFO);
        }else{
            logger.gravaArquivo(String.format("Falha ao adicionar Horário na turma '%s", turmaId), Logger.Level.ERROR);
        }
    }

    public void addHorarioTurma(Horario h, String idTurma){
        Turma turma = this.getTurmaId(idTurma);

        if(turma != null){
            turma.setHorario(h);
        }
        this.horarios.add(h);
    }

    /**
    * Remove o horário de uma turma
    * @Parameter: idTurma - ID da turma de onde o horário será removido
    */
    public void removerHorarioTurma(String idTurma){
        Turma turma = this.getTurmaId(idTurma);

        if(turma != null){
            turma.getHorario().removerTudo();
            turma.setHorario(null);
        }
    }
        
    /**
    * Adiciona um novo livro na biblioteca
    * @Parameter: titulo - Título do livro
    * @Parameter: autor - Autor do livro
    * @Parameter: isbn - ISBN do livro
    * @Parameter: genero - Gênero do livro
    */
    public void addLivroBiblioteca(String titulo, String autor, String isbn, String genero){
        Livro novo = new Livro(titulo, autor, isbn, genero);
        Logger logger = Logger.getInstance();

        biblioteca.addLivro(novo);
        logger.gravaArquivo(String.format("Livro '%s' de '%s' foi adicionado à biblioteca", titulo, autor), Logger.Level.INFO);
    }

    /**
    * Adiciona um professor como usuário da biblioteca
    * @Parameter: idProfessor - String do Id do professor
    */
    public void addProfessorBiblioteca(String idProfessor){
        Professor temp = this.getProfessorId(idProfessor);
        if(temp != null){
            biblioteca.addUsuario(temp);
        }
    }

    /**
    * Adiciona um aluno como usuário da biblioteca
    * @Parameter: matricula - String da matrícula do aluno
    */
    public void addAlunoBiblioteca(String matricula){
        Aluno temp = this.getAlunoMatricula(matricula);
        if(temp != null){
            biblioteca.addUsuario(temp);
        }
    }

    /**
    * Remove um aluno da biblioteca
    * @Parameter: idProfessor - String do Id do professor
    */
    public void removerProfessorBiblioteca(String idProfessor){
        Professor temp = this.getProfessorId(idProfessor);
        if(temp != null){
            biblioteca.removerUsuario(temp);
        }
    }

    /**
    * Remove um professor da biblioteca
    * @Parameter: matricula - String da matrícula do aluno
    */
    public void removerAlunoBiblioteca(String matricula){
        Aluno temp = this.getAlunoMatricula(matricula);
        if(temp != null){
            biblioteca.removerUsuario(temp);
        }
    }

    /**
    * Remove um livro da biblioteca
    * @Parameter: livro - Livro que se deseja remover
    */
    public void removerLivro(Livro livro){
        biblioteca.removerLivro(livro);
    }

    /**
    * Faz um emprestimo em nome de um aluno 
    * @Parameter: livro - Livro que se deseja emprestar
    * @Parameter: matricula - String da matrícula do aluno
    */
    public void emprestimoAluno(Livro livro, String matricula){
        Aluno temp = this.getAlunoMatricula(matricula);
        if(temp != null){
            biblioteca.fazerEmprestimo(livro, temp);
        }
    }

    /**
    * Faz um emprestimo em nome de um professor 
    * @Parameter: livro - Livro que se deseja emprestar
    * @Parameter: idProfessor - String do Id do professor
    */
    public void emprestimoProfessor(Livro livro, String idProfessor){
        Professor temp = this.getProfessorId(idProfessor);
        if(temp != null){
            biblioteca.fazerEmprestimo(livro, temp);
        }
    }

    /**
    * Faz uma devolução em nome de um aluno 
    * @Parameter: livro - Livro que se deseja devolver
    * @Parameter: matricula - String da matrícula do aluno
    */
    public void devolucaoAluno(Livro livro, String matricula){
        Aluno temp = this.getAlunoMatricula(matricula);
        if(temp != null){
            biblioteca.fazerDevolucao(livro, temp);
        }
    }

    /**
    * Faz uma devolução em nome de um professor 
    * @Parameter: livro - Livro que se deseja devolver
    * @Parameter: idProfessor - String do Id do professor
    */
    public void devolucaoProfessor(Livro livro, String idProfessor){
        Professor temp = this.getProfessorId(idProfessor);
        if(temp != null){
            biblioteca.fazerDevolucao(livro, temp);
        }
    }

    /**
    * Faz a busca de um livro por autor 
    * @Parameter: autor - String do autor do livro que se deseja buscar
    */
    public void buscarLivroPorAutor(String autor){
        bibliotecaConsole.buscarLivroPorAutor(biblioteca, autor);
    }

    /**
    * Faz a busca de um livro por titulo 
    * @Parameter: titulo - String do titulo do livro que se deseja buscar
    */
    public void buscarLivroPorTitulo(String titulo){
        bibliotecaConsole.buscarLivroPorTitulo(biblioteca, titulo);
    }
    
    /**
    * Faz a busca de um livro por isbn 
    * @Parameter: isbn - String do isbn do livro que se deseja buscar
    */
    public void buscarLivroPorISBN(String isbn){
        bibliotecaConsole.buscarLivroPorAutor(biblioteca, isbn);
    }

    /**
    * Faz a busca de um usuario por ID 
    * @Parameter: usuarioId - String do ID do usuario que se deseja buscar
    */
    public void buscarUsuario(String usuarioId){
        bibliotecaConsole.buscarUsuario(biblioteca, usuarioId);
    }

    /**
    * Imprime o catálogo de livros da Biblioteca
    */
    public void imprimirCatalogoDeLivros(){
        bibliotecaConsole.imprimirCatalogoDeLivros(biblioteca);
    }

    /**
    * Faz o relatório geral dos livros de Biblioteca Escolar
    */
    public void relatorioGeralLivros(){
        bibliotecaConsole.relatorioGeralLivros(biblioteca);
    }

    /**
    * Faz o relatório geral dos usuarios multados e de suas multas 
    */
    public void relatorioMultas(){
        bibliotecaConsole.relatorioMultas(biblioteca);
    }

    /**
    * Imprime recomendações de livros baseados em uma disciplina
    * @Parameter: disciplina - String de uma disciplina 
    */
    public void imprimirRecomenadacoes(String disciplina){
        bibliotecaConsole.imprimirRecomenadacoes(biblioteca, disciplina);
    }

    /**
    * Imprime livros de um genero específico
    * @Parameter: genero - String de um genero de livro 
    */
    public void imprimirLivrosDeGeneroEspecifico(String genero){
        bibliotecaConsole.imprimirLivrosDeGeneroEspecifico(biblioteca, genero);
    }

    /**
     * Método para adicionar uma atividade extra curricular a um aluno
     * @Parameter: matricula - String da matricula do aluno
     * @Parameter: ic - Atividade extra
     * 
     */
    public void addAtividadeExtraCurricular(String matricula, AtividadeExtra ic){
        Aluno temp = this.getAlunoMatricula(matricula);
        if(temp != null){
            temp.addAtividadeExtra(ic);
        }
    }
        
    //Chamadas metodos classe gerenciadora Notas
    
    public void removerProvaDisciplina(String nomeDisciplina, String nomeProfessor, String nomeProva, String nomeTurma, float peso){
        notas.removerProvaDisciplina(nomeDisciplina, nomeProfessor, nomeProva, nomeTurma, peso);
    }
       
    /**
     * Método para remover um trabalho de uma disciplina    
     * @Parameter: nomeDisciplina - Nome da disciplina
     * @Parameter: nomeProfessor - Nome do professor
     * @Parameter: nomeTrabalho - Nome do trabalho
     * @Parameter: nomeTurma - Nome da turma
     * @Parameter: peso - Peso da nota
     */
    public void removerTrabalhoDisciplina(String nomeDisciplina, String nomeProfessor, String nomeTrabalho, String nomeTurma, float peso){
        notas.removerTrabalhoDisciplina(nomeDisciplina, nomeProfessor, nomeTrabalho, nomeTurma, peso);
    }

    /**
     * Método para remover todos os trabalhos de uma disciplina
     * @Parameter: nomeDisciplina - Nome da disciplina
     * @Parameter: nomeProfessor - Nome do professor
     * @Parameter: nomeTurma - Nome da turma
     */
    public void removerTodosTrabalhosDisciplina(String nomeDisciplina, String nomeProfessor, String nomeTurma){
        notas.removerTrabalhos(nomeDisciplina, nomeProfessor, nomeTurma);
    }
    
    public void removerAtividadeExtraCurricular(String matricula, AtividadeExtra ic){
        Aluno temp = this.getAlunoMatricula(matricula);
        if(temp != null){
            temp.removerAtividadeExtra(ic);
        }
    }
         

        
    public void removerPontoExtraDisciplina(String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma){
        notas.removerPontoExtraDisciplina(nomeDisciplina, nomeProfessor, nomePontoExtra, nomeTurma);
    }
        
    public void adicionarProvaDisciplina(String nomeDisciplina, String nomeProfessor, String nomeTurma, String nomeProva,  float peso){
        notas.adicionarProvaDisciplina(nomeDisciplina, nomeProfessor, nomeProva, nomeTurma, peso);
    }
        
    public void adicionarTrabalhoDisciplina(String nomeDisciplina, String nomeProfessor, String nomeTurma, String nomeTrabalho, float peso) {
        notas.adicionarTrabalhoDisciplina(nomeDisciplina, nomeProfessor, nomeTurma, nomeTrabalho, peso);
    }
        
    /**
     * Método para adicionar um ponto extra a uma disciplina
     * @Parameter: nomeDisciplina - Nome da disciplina
     * @Parameter: nomeProfessor - Nome do professor
     * @Parameter: nomePontoExtra - Ponto extra
     * @Parameter: nomeTurma - Nome da turma
     * @Parameter: valorMaximo - Valor extra máximo 
     */
    public void adicionarPontoExtraDisciplina(String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma, float valorMaximo) {
        notas.adicionarPontoExtraDisciplina(nomeDisciplina, nomeProfessor, nomePontoExtra, nomeTurma, valorMaximo);
    }
    
    /**
    * @Brief: Adiciona a nota de uma prova para um aluno
    * @Parameter: nomeAluno Nome do aluno
    * @Parameter: nomeDisciplina Nome da disciplina
    * @Parameter: nomeProfessor Nome do professor
    * @Parameter: nomeProva Nome da prova
    * @Parameter: notaProva Nota da prova
    * @Parameter: nomeTurma Nome da turma
    */
    public void adicionarNotaProva(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeProva, float notaProva, String nomeTurma) {
        notas.adicionarNotaProva(nomeAluno, nomeDisciplina, nomeProfessor, nomeProva, notaProva, nomeTurma);
    }
    
    /**
    * @Brief: Adiciona a nota de um trabalho para um aluno
    * @Parameter: nomeAluno Nome do aluno
    * @Parameter: nomeDisciplina Nome da disciplina
    * @Parameter: nomeProfessor Nome do professor
    * @Parameter: nomeTrabalho Nome do trabalho
    * @Parameter: notaTrabalho Nota do trabalho
    * @Parameter: nomeTurma Nome da turma
    */
    public void adicionarNotaTrabalho(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeTrabalho, float notaTrabalho, String nomeTurma) {
        notas.adicionarNotaTrabalho(nomeAluno, nomeDisciplina, nomeProfessor, nomeTrabalho, notaTrabalho, nomeTurma);
    }
    
    /**
    * @Brief: Adiciona uma nota de ponto extra para um aluno 
    * @Parameter: nomeAluno Nome do aluno
    * @Parameter: nomeDisciplina Nome da disciplina
    * @Parameter: nomeProfessor Nome do professor
    * @Parameter: nomePontoExtra Nome do ponto extra
    * @Parameter: nomeTurma Nome da turma
    * @Parameter: valor Valor do ponto extra
    */
    public void adicionarNotaPontoExtra(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma, float valor) {
        notas.adicionarNotaPontoExtra(nomeAluno, nomeDisciplina, nomeProfessor, nomePontoExtra, nomeTurma, valor);
    }
    
    /**
    * @Brief: Remove a nota de uma prova de um aluno
    * @Parameter: nomeAluno Nome do aluno
    * @Parameter: nomeDisciplina Nome da disciplina
    * @Parameter: nomeProfessor Nome do professor
    * @Parameter: nomeProva Nome da prova
    * @Parameter: notaProva Nota da prova
    * @Parameter: nomeTurma Nome da turma
    */
    public void removerNotaProva(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeProva, float notaProva, String nomeTurma) {
        notas.removerNotaProva(nomeAluno, nomeDisciplina, nomeProfessor, nomeProva, notaProva, nomeTurma);
    }
    
    /**
    * @Brief: Remove a nota de um trabalho de um aluno
    * @Parameter: nomeAluno Nome do aluno
    * @Parameter: nomeDisciplina Nome da disciplina
    * @Parameter: nomeProfessor Nome do professor
    * @Parameter: nomeTrabalho Nome do trabalho
    * @Parameter: notaTrabalho Nota do trabalho
    * @Parameter: nomeTurma Nome da turma
    */
    public void removerNotaTrabalho(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomeTrabalho, float notaTrabalho, String nomeTurma) {
        notas.removerNotaTrabalho(nomeAluno, nomeDisciplina, nomeProfessor, nomeTrabalho, notaTrabalho, nomeTurma);
    }
    /**
    * @Brief: Remove uma nota de ponto extra de um aluno
    * @Parameter: nomeAluno Nome do aluno
    * @Parameter: nomeDisciplina Nome da disciplina
    * @Parameter: nomeProfessor Nome do professor
    * @Parameter: nomePontoExtra Nome do ponto extra
    * @Parameter: nomeTurma Nome da turma
    * @Parameter: valor Valor do ponto extra
    */
    public void removerNotaPontoExtra(String nomeAluno, String nomeDisciplina, String nomeProfessor, String nomePontoExtra, String nomeTurma, float valor) {
        notas.removerNotaPontoExtra(nomeAluno, nomeDisciplina, nomeProfessor, nomePontoExtra, nomeTurma, valor);
    }
    
    /**
    * @Brief: Gera um relatorio com informações sobre os professores
    * @Return: Relatorio dos professores 
    */
    public String relatorioProfessores(){
        return RelatorioProfessores.relatorioProfessores(professores);
    }
    
    /**
    * @Brief: Gera um relatório com informações dos alunos de uma turma
    * @Parameter: t Objeto da turma
    * @Parameter: opcao Opção de exibição do relatório
    */
    public void relatorioAlunosTurma(Turma t, int opcao){
        RelatorioAlunos.relatorio(t.getAlunos(), opcao);
    }
    
    /**
     * Ao demitir um professor, será removido de todas as disciplinas que ministrava
     * @Parameter: nomeProfessor - Nome do professor
     * @Parameter: ID - Id do usuario
     */
    public void demitirProfessor(String nomeProfessor, String ID){
        for(Disciplina disciplina : disciplinas){
            ArrayList<Professor> professoresDisciplina = disciplina.getProfessores();
            for(Professor professor : professoresDisciplina){
                if(professor.getNome().equals(nomeProfessor) && professor.getID().equals(ID)){
                    disciplina.removerProfessor(professor);
                    professores.remove(professor);
                }
            }
        }
    }
    
    /**
     * Ao expulsar um aluno, será removido da turma que pertencia
     * @Parameter: nomeAluno - Nome aluno
     * @Parameter: ID - Id do aluno
     */
    public void expulsarAluno(String nomeAluno, String ID){
        for(Turma turma : turmas){
            ArrayList<Aluno> alunosTurma = turma.getAlunos();
            for(Aluno aluno : alunosTurma){
                if(aluno.getNome().equals(nomeAluno) && aluno.getID().equals(ID)){
                    turma.removerAluno(aluno);
                    return;
                }
            }
        }
    }

    /**
    * @Brief: Adiciona as notas de uma prova para todos os alunos de uma turma
    * @Parameter: turma Objeto representando a turma
    * @Parameter: disciplina Disciplina associada a prova
    * @Parameter: nomeProva Nome da prova
    * @Parameter: nota Nota atribuída à prova
    * @Parameter: peso Peso da prova
    */
    public void addNotasProvaTurma(Turma turma, Disciplina disciplina, String nomeProva, float nota, float peso){
        int i=0;
        for(Aluno aluno : turma.getAlunos()){
            notas.adicionarNotaProva(aluno.getNome(), disciplina.getNome(), disciplina.getProfessores().get(i).getNome(), nomeProva, nota, turma.getNomeTurma());
            i++;
        }
    }

    /**
    * @Brief: Adiciona as notas de um trabalho para todos os alunos de uma turma
    * @Parameter: turma Objeto representando a turma
    * @Parameter: disciplina Disciplina associada ao trabalho
    * @Parameter: nomeTrabalho Nome do trabalho
    * @Parameter: nota Nota atribuída ao trabalho
    * @Parameter: peso Peso do trabalho
    */
    public void addNotasTrabalhoTurma(Turma turma, Disciplina disciplina, String nomeTrabalho, float nota, float peso){
        int i=0;
        for(Aluno aluno : turma.getAlunos()){
            notas.adicionarNotaTrabalho(aluno.getNome(), disciplina.getNome(), disciplina.getProfessores().get(i).getNome(), nomeTrabalho, nota, turma.getNomeTurma());
            i++;
        }
    }

    /**
    * @Brief: Adiciona notas de ponto extra para todos os alunos de uma turma
    * @Parameter: turma Objeto representando a turma
    * @Parameter: disciplina Disciplina associada ao ponto extra
    * @Parameter: nomePontoExtra Nome do ponto extra
    * @Parameter: valor Valor do ponto extra
    */
    public void addNotasPontoExtraTurma(Turma turma, Disciplina disciplina, String nomePontoExtra, float valor){
        int i=0;
        for(Aluno aluno : turma.getAlunos()){
            notas.adicionarNotaPontoExtra(aluno.getNome(), disciplina.getNome(), disciplina.getProfessores().get(i).getNome(), nomePontoExtra, turma.getNomeTurma(), valor);
            i++;
        }
    }
    
}

