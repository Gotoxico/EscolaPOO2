package modelo;

import java.util.ArrayList;

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

    public boolean emprestimo(Livro livro, Usuario usuario){
        Emprestimo emprestimo = new Emprestimo();
        if(usuario.quantMulta == 0){
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
        Emprestimo emprestimo = new emprestimo;
        if(emprestimo.verificaSeEDomingo() == true){
            return false;
        }
        if(usuario.removeLivro(livro) == true){
            livro.setEmprestado(false);
        }
    }

    //funcao para verificar diariamente se usuario deve ser multado 
    public void verificaAddMultaDiariamente(){
        Multa multa = new Multa();
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        for(int i=0; i<usuarios.size(); i++){
            emprestimos = usuarios.get(i).getEmprestimos();
            //verificando se há algum emprestimo vencido no vetor emprestimos de cada usuario
            for(int j=0; j<emprestimos.size(); j++){
                if(emprestimos.get(j).verificaMulta() == true){
                    multa.aplicaMulta();
                    usuarios.get(i).addMulta(multa);
                }
            }
        }
    }

    //funcao para verificar diariamente se usuario deve ter multa retiradas
    public void verificaRemoveMultaDiariamente(){
        ArrayList<Multa> multas = new ArrayList<>();
        for(int i=0; i<usuarios.size(); i++){
            if(usuarios.get(i).getQuantMulta > 0){
                multas = usuarios.get(i).getMultas();
                for(int j=0; j<multas.size(); j++){
                    if(multas.get(j).removeMulta == true){
                        usuarios.get(i).removeMulta(multas.get(j));
                    }
                }
            }
        }
    }

    public void imprimirCatalogoDeLivros(){
        //System.out.println("CATALOGO: \n");
        Collections.sort(livros);
        for(Livro livro : livros){
            System.out.println("-" + livro);
        }
    }
}

