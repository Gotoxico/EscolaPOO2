public /*abstract*/ class Biblioteca{
    protected Usuario[] usuarios;
    protected Livro[] livros;
    protected int contLivros;
    protected int contUsuarios;
    protected static final int QUANT_MAX_USUARIOS = 100; //suponhamos que o máximo de usuários é 100 por enquanto
    protected static final int QUANT_MAX_LIVROS = 1000; //suponhamos que o máximo de livros na biblioteca é 1000 por enquanto
     

    public Biblioteca(){
        usuarios = new Usuario[QUANT_MAX_USUARIOS];
        livros = new Livro[QUANT_MAX_LIVROS];
        contUsuarios = 0;
        contLivros = 0;
    }

    public int addUsuario(Usuario usuario){
        if(contUsuarios < QUANT_MAX_USUARIOS){
            usuarios[contUsuarios] = usuario;
            contUsuarios++;
            return 1;
        }
        return 0;
    }

    public int addLivro(Livro livro){
        if(contLivros < QUANT_MAX_LIVROS){
            livros[contLivros] = livro;
            contLivros++;
            return 1;
        }
        return 0;
    }

    public int emprestimo(Livro livro, Usuario usuario){
        if(usuario.quantMulta == 0){
            for(int i=0; i<contLivros; i++){
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
        
    }
}

