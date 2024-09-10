package modelo;
import java.util.ArrayList;


public class Usuario{
    protected String nome;
    protected String ID;
    protected int quantMulta;
    protected ArrayList<Livro> livros;
    protected static final int QUANT_MAX_LIVROS = 10; //suponhamos que o máximo que um usuário pode emprestar de livros ao mesmo tempo é 10  
    protected int contLivros;
    protected ArrayList<Multa> multas;
    protected ArrayList<Emprestimo> emprestimos;

    public Usuario(){
        this.quantMulta = 0;
        this.livros = new ArrayList<>();
        this.multas = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        contLivros = 0;
    }

    public Usuario(String nome, String ID){
        this.nome = nome;
        this.ID = ID;
        this.quantMulta = 0;
        this.livros = new ArrayList<>();
        this.multas = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        contLivros = 0;
    }

    public boolean addLivro(Livro livro, Emprestimo emprestimo){
        if(contLivros < QUANT_MAX_LIVROS){
            livros.add(livro);
            emprestimos.add(emprestimo); //sempre serão adicionados e removidos juntos (sempre estarão na mesma posição em vetores diferentes)
            contLivros++;
            return true;
        }
        return false;
    }

    public boolean removeLivro(Livro livro){
        if(contLivros > 0){
            for(int i=0; i < contLivros; i++){
                if(livros.get(i).equals(livro)){   //perguntar!!!
                    livros.remove(i);
                    emprestimos.remove(i);
                    contLivros--;
                    return true;
                }
            }
        }
        return false;
    }

    public Emprestimo getEmprestimoDeAcordoComOLivro(Livro livro){
        for(int i=0; i<livros.size(); i++){
            if(livros.get(i).equals(livro)){
                return emprestimos.get(i);
            }
        }
        return null;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setID(String ID){
        this.ID = ID;
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

    public ArrayList<Livro> getLivros(){
        return livros;
    }

    public ArrayList<Multa> getMultas(){
        return multas;
    }

    public ArrayList<Emprestimo> getEmprestimos(){
        return emprestimos;
    }
     
    public void addMulta(Multa multa){
        multas.add(multa);
        quantMulta++;
    }

    public boolean removeMulta(Multa multa){
        for(int i=0; i<multas.size(); i++){
            if(multas.get(i).equals(multa)){
                multas.remove(i);
                return true;
            }
        }
        return false;
    }
}
