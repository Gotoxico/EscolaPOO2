package modelo;

public class Livro{
    private String titulo;
    private String autor;
    private int isbn;
    private int emprestado;

    public Livro(){
        emprestado = 0;
    }

    public Livro(String titulo, String autor, int isbn){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        emprestado = 0;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setIsbn(int isbn){
        this.isbn = isbn;
    }

    public void setEmprestado(int emprestado){
        this.emprestado = emprestado;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public int getIsbn(){
        return isbn;
    }

    public int getEmprestado(){
        return emprestado;
    }
}