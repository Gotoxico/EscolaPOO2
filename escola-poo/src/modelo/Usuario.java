package modelo;

import java.util.ArrayList;

/**
 * @Brief: Representa um usuário da biblioteca com informações sobre livros emprestados, multas e empréstimos
 * @author juniortraj
 */
public class Usuario{
    protected String nome;
    protected String ID;
    protected int quantMulta;
    protected ArrayList<Livro> livros;
    protected static final int QUANT_MAX_LIVROS = 10; //o máximo que um usuário pode emprestar de livros ao mesmo tempo é 10  
    protected int contLivros;
    protected ArrayList<Multa> multas;
    protected ArrayList<Emprestimo> emprestimos;

    /**
     * @Brief: Construtor padrão da classe Usuario
     * Inicializa as listas de livros, multas e empréstimos, e o contador de livros
     */
    public Usuario(){
        this.quantMulta = 0;
        this.livros = new ArrayList<>();
        this.multas = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        contLivros = 0;
    }

    /**
     * @Brief: Construtor da classe Usuario com nome e ID especificados
     * @Parameter: nome Nome do usuário
     * @Parameter: ID Identificador único do usuário
     */
    public Usuario(String nome, String ID){
        this.nome = nome;
        this.ID = ID;
        this.quantMulta = 0;
        this.livros = new ArrayList<>();
        this.multas = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        contLivros = 0;
    }

    /**
     * @Brief: Adiciona um livro ao usuário, juntamente com o empréstimo relacionado
     * @Parameter: livro Livro a ser adicionado
     * @Parameter: emprestimo Empréstimo relacionado ao livro
     * @Return: Retorna true se o livro foi adicionado com sucesso, ou false se o usuário já tiver o máximo de livros
     */
    public boolean addLivro(Livro livro, Emprestimo emprestimo){
        if(contLivros < QUANT_MAX_LIVROS){
            livros.add(livro);
            emprestimos.add(emprestimo); //sempre serão adicionados e removidos juntos (sempre estarão na mesma posição em vetores diferentes)
            contLivros++;
            return true;
        }
        return false;
    }

    /**
     * @Brief: Remove um livro emprestado e seu empréstimo correspondente
     * @Parameter: livro Livro a ser removido
     * @Return: Retorna true se o livro foi removido com sucesso, ou false caso o livro não esteja na lista
     */
    public boolean removeLivro(Livro livro){
        if(contLivros > 0){
            for(int i=0; i < contLivros; i++){
                if(livros.get(i).equals(livro)){   
                    livros.remove(i);
                    emprestimos.remove(i);
                    contLivros--;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @Brief: Busca um livro na lista de livros do usuário
     * @Parameter: livro Livro a ser buscado
     * @Return: Retorna true se o livro for encontrado, ou false caso contrário
     */
    public boolean buscaLivro(Livro livro){
        for(int i=0; i<contLivros; i++){
            if(livros.get(i).equals(livro)){
                return true;
            }
        }
        return false;
    }

    /**
     * @Brief: Obtem o empréstimo correspondente a um livro específico
     * @Parameter: livro Livro para o qual buscar o empréstimo
     * @Return: O empréstimo correspondente ao livro, ou null se não encontrado
     */
    public Emprestimo getEmprestimoDeAcordoComOLivro(Livro livro){
        for(int i=0; i<livros.size(); i++){
            if(livros.get(i).equals(livro)){
                return emprestimos.get(i);
            }
        }
        return null;
    }

    /**
     * @Brief: Define o nome do usuário
     * @Parameter: nome Nome do usuário
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * @Brief: Define o ID do usuário
     * @Parameter: ID Identificador único do usuário
     */
    public void setID(String ID){
        this.ID = ID;
    }

    /**
     * @Brief: Obtem o nome do usuário
     * @Return: Nome do usuário
     */
    public String getNome(){
        return nome;
    }

    /**
     * @Brief: Obtém o ID do usuário
     * @Return: ID do usuário
     */
    public String getID(){
        return ID;
    }

    /**
     * @Brief: Obtem a quantidade de multas do usuário
     * @Return: Quantidade de multas
     */
    public int getQuantMulta(){
        return quantMulta;
    }
    
    /**
     * @Brief: Obtem o número de livros emprestados
     * @Return: Número de livros emprestados
     */
    public int getContLivros(){
        return contLivros;
    }

    /**
     * @Brief: Obtem a lista de livros emprestados pelo usuário
     * @Return: Lista de livros emprestados
     */
    public ArrayList<Livro> getLivros(){
        return livros;
    }

    /**
     * @Brief: Obtem a lista de multas do usuário
     * @Return: Lista de multas
     */
    public ArrayList<Multa> getMultas(){
        return multas;
    }

    /**
     * @Brief: Obtem a lista de empréstimos do usuário
     * @Return: Lista de empréstimos
     */
    public ArrayList<Emprestimo> getEmprestimos(){
        return emprestimos;
    }
    
    /**
     * @Brief: Adiciona uma multa ao usuário
     * @Parameter: multa Multa a ser adicionada
     */
    public void addMulta(Multa multa){
        multas.add(multa);
        quantMulta++;
    }

    /**
     * @Brief: Remove uma multa do usuário
     * @Parameter: multa Multa a ser removida
     * @Return: Retorna true se a multa foi removida com sucesso, ou false caso não encontrada
     */
    public boolean removeMulta(Multa multa){
        for(int i=0; i<multas.size(); i++){
            if(multas.get(i).equals(multa)){
                multas.remove(i);
                return true;
            }
        }
        return false;
    }
}
