import java.util.ArrayList;

public class Biblioteca{
    protected ArrayList<Usuario> usuarios;
    protected ArrayList<Livro> livros;

    public Biblioteca(){
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    public int addUsuario(Usuario usuario){
        usuarios.add(usuario);
        return 1;
    }

    public int addLivro(Livro livro){
        livros.add(livro);
        return 1;
    }

    public int emprestimo(Livro livro, Usuario usuario){
        if(usuario.quantMulta == 0){
            for(int i=0; i<livros.size(); i++){
                if(livros[i].equals(livro) && livro.getEmprestado() == 0){
                    usuario.addLivro(livro);
                    livro.setEmprestado(1);
                    return 1;
                }
            }
        }
        return 0;
    }

    public int devolucao(Livro livro, Usuario usuario){
        if(usuario.removeLivro(livro) == 1){
            addLivro(livro);
            livro.setEmprestado(0);
        }
    }
}

