package modelo;

import java.util.ArrayList;
import java.util.Collections;

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

    public boolean buscaLivro(Livro livro){
        if(livros.isEmpty() == false){
            for(int i=0; i<livros.size(); i++){
                if(livros.get(i).equals(livro)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean buscaUsuario(Usuario usuario){
        if(usuarios.isEmpty() == false){
            for(int i=0; i<usuarios.size(); i++){
                if(usuarios.get(i).equals(usuario)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeUsuario(Usuario usuario){
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

    public boolean removeLivro(Livro livro){         
        for(int i=0; i<livros.size(); i++){
            if(livros.get(i).equals(livro)){
                livros.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean emprestimo(Livro livro, Usuario usuario){
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

    public boolean devolucao(Livro livro, Usuario usuario){
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
    public void verificaAddMultaDiariamente(){
        Multa multa = new Multa();
        ArrayList<Emprestimo> emprestimos = new ArrayList();
        ArrayList<Livro> livros = new ArrayList();
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
    public void verificaRemoveMultaDiariamente(){
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
        Collections.sort(livros, (Livro l1, Livro l2) -> l1.getTitulo()
                .compareToIgnoreCase(l2.getTitulo()));
    }

    public ArrayList<Livro> getLivros(){
        return livros;
    }

    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    } 
}