package modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Biblioteca{
    protected ArrayList<Usuario> usuarios;
    protected ArrayList<Livro> livros;

    /**
     * @Brief: Construtor da classe Biblioteca que inicializa as listas de usuários e livros
     */
    public Biblioteca(){
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    /**
     * @Brief: Adiciona um novo usuário a biblioteca
     * @Parameter: usuario Usuário a ser adicionado
     * @Return: True se o usuário foi adicionado com sucesso
     */
    public boolean addUsuario(Usuario usuario){
        usuarios.add(usuario);
        return true;
    }

    /**
     * @Brief: Adiciona um novo livro a biblioteca
     * @Parameter: livro Livro a ser adicionado
     * @Return: True se o livro foi adicionado com sucesso
     */
    public boolean addLivro(Livro livro){
        livros.add(livro);
        return true;
    }

    /**
     * @Brief: Busca um livro na biblioteca
     * @Parameter: livro Livro a ser buscado
     * @Return: True se o livro foi encontrado
     */
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

    /**
     * @Brief: Busca um usuário na biblioteca
     * @Parameter: usuario Usuário a ser buscado
     * @Return: True se o usuário foi encontrado
     */
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

    /**
     * @Brief: Remove um usuário da biblioteca, caso não possua livros emprestados
     * @Parameter: usuario Usuário a ser removido
     * @Return: True se o usuário foi removido com sucesso
     */
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

    /**
     * @Brief: Remove um livro da biblioteca
     * @Parameter: livro Livro a ser removido
     * @Return: True se o livro foi removido com sucesso
     */
    public boolean removeLivro(Livro livro){         
        for(int i=0; i<livros.size(); i++){
            if(livros.get(i).equals(livro)){
                livros.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * @Brief: Realiza o empréstimo de um livro para um usuário
     * @Parameter: livro Livro a ser emprestado
     * @Parameter: usuario Usuário que receberá o livro
     * @Return: True se o empréstimo foi realizado com sucesso
     */
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

    /**
     * @Brief: Realiza a devolução de um livro pelo usuário
     * @Parameter: livro Livro a ser devolvido
     * @Parameter: usuario Usuário que está devolvendo o livro
     * @Return: True se a devolução foi realizada com sucesso
     */
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

    /**
     * @Brief: Verifica diariamente se algum usuário deve ser multado por atraso
     */
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

    /**
     * @Brief: Verifica diariamente se algum usuário pode ter multas retiradas
     */
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

    /**
     * @Brief: Ordena a lista de livros em ordem alfabética pelo título
     */
    public void ordenaLivrosOrdemAlfabetica(){
        Collections.sort(livros, (Livro l1, Livro l2) -> l1.getTitulo()
                .compareToIgnoreCase(l2.getTitulo()));
    }

    /**
     * @Brief: Obtem a lista de livros cadastrados na biblioteca
     * @Return: Lista de livros
     */
    public ArrayList<Livro> getLivros(){
        return livros;
    }

    /**
     * @Brief: Obtem a lista de usuários cadastrados na biblioteca
     * @Return: Lista de usuários
     */
    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    } 
}