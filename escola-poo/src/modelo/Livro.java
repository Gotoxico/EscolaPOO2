package modelo;

public class Livro{
    private String titulo;
    private String autor;
    private String isbn;
    private boolean emprestado;

    public Livro(){
        emprestado = false;
    }

    public Livro(String titulo, String autor, String isbn){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        emprestado = false;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public void setEmprestado(boolean emprestado){
        this.emprestado = emprestado;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public String getIsbn(){
        return isbn;
    }

    public boolean getEmprestado(){
        return emprestado;
    }
}