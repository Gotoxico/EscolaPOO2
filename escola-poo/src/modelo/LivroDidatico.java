package modelo;

public class LivroDidatico extends Livro{   //será usado para recomendar o uso aos professores
    private String disciplina;  // Mais específico que o genêro, para matérias cujo nome não é genérico ("Matemática", "Biologia"), como "Álgebra", "Geometria", "Botânica", etc 
    //A disciplina a qual o livro pertence pode ter o mesmo nome que seu gênero, caso não tenha especificidade de uma matéria

    public LivroDidatico(String titulo, String autor, String ISBN, String genero, String disciplina){
        super(titulo, autor, ISBN, genero);
        emprestado = false;
        this.disciplina = disciplina;
    }

    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }

    public String getDisciplina(){
        return disciplina;
    }
}
