package modelo;

import java.util.ArrayList;
import java.util.*;

public class Biblioteca{
    protected ArrayList<Usuario> usuarios;
    protected ArrayList<Livro> livros;

    public Biblioteca(){
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    public boolean addUsuario(Usuario usuario){
        usuarios.add(usuario);
        return true;
    }

    public boolean addLivro(Livro livro){
        livros.add(livro);
        return true;
    }

    public boolean buscarLivroPorAutor(String autor){
        if(livros.isEmpty() == false){
            for(int i=0; i<livros.size(); i++){
                if(livros.get(i).getAutor().equals(autor)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean buscarLivroPorTitulo(String titulo){
        if(livros.isEmpty() == false){
            for(int i=0; i<livros.size(); i++){
                if(livros.get(i).getTitulo().equals(titulo)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean buscarLivroPorISBN(String ISBN){
        if(livros.isEmpty() == false){
            for(int i=0; i<livros.size(); i++){
                if(livros.get(i).getISBN().equals(ISBN)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean buscarUsuario(Usuario usuario){
        if(usuarios.isEmpty() == false){
            for(int i=0; i<usuarios.size(); i++){
                if(usuarios.get(i).equals(usuario)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removerUsuario(Usuario usuario){
        if(usuario.getContLivros() == 0){   //usuário não precisa devolver nenhum livro então pode ser removido
            for(int i=0; i<usuarios.size(); i++){   //preciso achar o índice da posição do usuário no vetor
                if(usuarios.get(i).equals(usuario)){
                    usuarios.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removerLivro(Livro livro){         
        for(int i=0; i<livros.size(); i++){
            if(livros.get(i).equals(livro) && livro.getEmprestado() == false){
                livros.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean fazerEmprestimo(Livro livro, Usuario usuario){
        Emprestimo emprestimo = new Emprestimo();
        if(usuario.getQuantMulta() == 0){
            for(int i=0; i<livros.size(); i++){
                if(livros.get(i).equals(livro) && livro.getEmprestado() == false){
                    if(emprestimo.calculaDataDevolucao() == null){ //nao pode emprestar no Domingo
                        return false;
                    }
                    usuario.addLivro(livro, emprestimo);
                    livro.setEmprestado(true);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean fazerDevolucao(Livro livro, Usuario usuario){
        if(VerificaSeEDomingo.verificaSeEDomingo() == true){    // nao pode devolver no Domingo
            return false;
        }
        if(usuario.removeLivro(livro) == true){
            livro.setEmprestado(false);
            return true;
        }
        return false;
    }

    //funcao para verificar diariamente se usuario deve ser multado 
    public void verificarAddMultaDiariamente(){
        Multa multa = new Multa();
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        ArrayList<Livro> livros = new ArrayList<>();
        for(int i=0; i<usuarios.size(); i++){
            emprestimos = usuarios.get(i).getEmprestimos();
            livros = usuarios.get(i).getLivros();
            //verificando se há algum emprestimo vencido no vetor emprestimos de cada usuario
            for(int j=0; j<emprestimos.size(); j++){
                if(emprestimos.get(j).verificaMulta() == true){
                    multa.aplicaMulta(livros.get(j));
                    usuarios.get(i).addMulta(multa);
                }
            }
        }
    }

    //funcao para verificar diariamente se usuario deve ter multa retiradas
    public void verificarRemoveMultaDiariamente(){
        ArrayList<Multa> multas = new ArrayList<>();
        for(int i=0; i<usuarios.size(); i++){
            if(usuarios.get(i).getQuantMulta() > 0){
                multas = usuarios.get(i).getMultas();
                for(int j=0; j<multas.size(); j++){
                    if(multas.get(j).removeMulta(usuarios.get(i)) == true){
                        usuarios.get(i).removeMulta(multas.get(j));
                    }
                }
            }
        }
    }

    public void ordenaLivrosOrdemAlfabetica(){
        LivroComparator comparator = new LivroComparator();
        Collections.sort(livros, comparator);
    }

    public ArrayList<Livro> getLivros(){
        return livros;
    }

    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    } 
}