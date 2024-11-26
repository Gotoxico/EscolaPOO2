package modelo;

/**
 * @Brief: Classe que representa um livro
 * @Details: Um livro possui título, autor, ISBN, gênero e um status de empréstimo
 */
public class Livro{
    private String titulo;
    private String autor;
    private String ISBN;
    protected boolean emprestado;
    private String genero;  //tanto gêneros como "Matemática", "Física", "História", "Computação", quanto "Terror", "Policial", "Romance", etc

    /**
     * @Brief: Construtor da classe Livro
     * @Details: Inicializa um livro com o status de empréstimo como falso
     */
    public Livro(){
        emprestado = false;
    }

    /**
     * @Brief: Construtor da classe Livro
     * @Details: Inicializa um livro com título, autor, ISBN, e gênero, além do status de empréstimo como falso
     * @Parameter: titulo Título do livro
     * @Parameter: autor Autor do livro
     * @Parameter: ISBN Código único de identificação do livro
     * @Parameter: genero Gênero do livro (ex: "Matemática", "Romance")
     */
    public Livro(String titulo, String autor, String ISBN, String genero){
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        emprestado = false;
        this.genero = genero;
    }

    /**
     * @Brief: Define o título do livro
     * @Parameter: titulo Título do livro
     */
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    /**
     * @Brief: Define o autor do livro
     * @Parameter: autor Autor do livro
     */
    public void setAutor(String autor){
        this.autor = autor;
    }

    /**
     * @Brief: Define o ISBN do livro
     * @Parameter: ISBN Código único de identificação do livro
     */
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    /**
     * @Brief: Define o status de empréstimo do livro
     * @Parameter: emprestado Status indicando se o livro está emprestado ou não
     */
    public void setEmprestado(boolean emprestado){
        this.emprestado = emprestado;
    }

    /**
     * @Brief: Define o gênero do livro
     * @Parameter: genero Gênero do livro (ex: "Terror", "Computação")
     */
    public void setGenero(String genero){
        this.genero = genero;
    }

    /**
     * @Brief: Obtem o título do livro
     * @Return: O título do livro
     */
    public String getTitulo(){
        return titulo;
    }

    /**
     * @Brief: Obtem o autor do livro
     * @Return: O autor do livro
     */
    public String getAutor(){
        return autor;
    }

    /**
     * @Brief: Obtem o ISBN do livro
     * @Return: O ISBN do livro
     */
    public String getISBN(){
        return ISBN;
    }

    /**
     * @Brief: Obtem o status de empréstimo do livro
     * @Return: Retorna true se o livro estiver emprestado, false caso contrário
     */
    public boolean getEmprestado(){
        return emprestado;
    }

    /**
     * @Brief: Obtem o gênero do livro
     * @Return: O gênero do livro
     */
    public String getGenero(){
        return genero;
    }
}