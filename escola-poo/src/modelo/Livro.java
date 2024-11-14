package modelo;

public class Livro{
    private String titulo;
    private String autor;
    private String ISBN;
    private boolean emprestado;
    private String gênero;  //tanto gêneros como "Matemática", "Física", "História", "Computação", quanto "Terror", "Policial", "Romance", etc

    public Livro(){
        emprestado = false;
    }

    public Livro(String titulo, String autor, String ISBN, String genero){
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        emprestado = false;
        this.genero = genero;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    public void setEmprestado(boolean emprestado){
        this.emprestado = emprestado;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public String getISBN(){
        return ISBN;
    }

    public boolean getEmprestado(){
        return emprestado;
    }

    public String getGenero(){
        return genero;
    }
}