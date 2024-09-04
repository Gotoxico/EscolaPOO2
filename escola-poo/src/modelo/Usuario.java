import java.util.ArrayList;

public class Usuario{
    protected String nome;
    protected String ID;
    protected int quantMulta;
    protected ArrayList<Livro> livros;
    protected static final int QUANT_MAX_LIVROS = 10; //suponhamos que o máximo que um usuário pode emprestar de livros ao mesmo tempo é 10  
    protected int contLivros;

    public Usuario(){
        this.quantMulta = 0;
        this.livros = new ArrayList<>();
        contLivros = 0;
    }

    public Usuario(String nome, String ID){
        this.nome = nome;
        this.ID = ID;
        this.quantMulta = 0;
        this.livros = new ArrayList<>();
        contLivros = 0;
    }

    public int addLivro(Livro livro){
        if(contLivros < QUANT_MAX_LIVROS){
            livros.add(livro);
            contLivros++;
            return 1;
        }
        return 0;
    }

    public int removeLivro(Livro livro){
        if(contLivros > 0){
            for(int i=0; i < contLivros; i++){
                if(livros[i].equals(livro)){
                    livros.remove(i);
                    contLivros--;
                    return 1;
                }
            }
        }
        return 0;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public void setQuantMulta(int quantMulta){
        this.quantMulta = quantMulta;
    }

    public String getNome(){
        return nome;
    }

    public String getID(){
        return ID;
    }

    public int getQuantMulta(){
        return quantMulta;
    }
     
}
