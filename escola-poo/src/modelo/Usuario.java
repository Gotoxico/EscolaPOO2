//Mudar o array para o formato ArrayList!!!

public class Usuario{
    protected String nome;
    protected String id;
    protected int quantMulta;
    protected Livro[] livros;
    protected static final int QUANT_MAX_LIVROS = 10; //suponhamos que o máximo que um usuário pode emprestar de livros ao mesmo tempo é 10  
    protected int contLivros;

    public Usuario(){
        this.quantMulta = 0;
        livros = new Livro[QUANT_MAX_LIVROS];
        contLivros = 0;
    }

    public Usuario(String nome, String id){
        this.nome = nome;
        this.id = id;
        this.quantMulta = 0;
        livros = new Livro[QUANT_MAX_LIVROS];
        contLivros = 0;
    }

    public int addLivro(Livro livro){
        if(contLivros < QUANT_MAX_LIVROS){
            livros[contLivros] = livro;
            contLivros++;
            return 1;
        }
        return 0;
    }

    public int removeLivro(Livro livro){
        if(contLivros > 0){
            for(int i=0; i<contLivros; i++){
                if(livros[i].equals(livro)){
                    return 1;
                }
            }
        }
        return 0;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setQuantMulta(int quantMulta){
        this.quantMulta = quantMulta;
    }

    public String getNome(){
        return nome;
    }

    public String getId(){
        return id;
    }

    public int getQuantMulta(){
        return quantMulta;
    }
     
}
