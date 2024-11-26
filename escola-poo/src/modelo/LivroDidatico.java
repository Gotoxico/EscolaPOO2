package modelo;
/**
 * @Brief: Classe que representa um livro didático
 * @Details: Esta classe é uma especialização da classe Livro, com a adição de uma disciplina específica, usada para recomendar o livro a professores
 */

public class LivroDidatico extends Livro{   //será usado para recomendar o uso aos professores
    private String disciplina;  // Mais específico que o genêro, para matérias cujo nome não é genérico ("Matemática", "Biologia"), como "Álgebra", "Geometria", "Botânica", etc 
    /**
     * @Brief: Construtor da classe LivroDidatico
     * @Details: Inicializa um livro didático com título, autor, ISBN, gênero e disciplina, além do status de empréstimo como falso
     * @Parameter: titulo Título do livro didático
     * @Parameter: autor Autor do livro didático
     * @Parameter: ISBN Código único de identificação do livro
     * @Parameter: genero Gênero do livro (ex: "Matemática", "Geometria")
     * @Parameter: disciplina Disciplina associada ao livro (ex: "Álgebra", "Botânica")
     */
    public LivroDidatico(String titulo, String autor, String ISBN, String genero, String disciplina){
        super(titulo, autor, ISBN, genero);
        emprestado = false;
        this.disciplina = disciplina;
    }

    /**
     * @Brief: Define a disciplina do livro didático
     * @Parameter: disciplina Disciplina associada ao livro (ex: "Álgebra", "Botânica")
     */
    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }

    /**
     * @Brief: Obtem a disciplina do livro didático
     * @Return: A disciplina associada ao livro (ex: "Álgebra", "Botânica")
     */
    public String getDisciplina(){
        return disciplina;
    }
}
