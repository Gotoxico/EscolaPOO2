package modelo;

import java.time.LocalDate;
import java.util.ArrayList;


public class BibliotecaEscolarConsole{    //classe com funções de impressão relacionada apenas às classes de Biblioteca

    /**
     * @Brief: Imprime as datas de empréstimo e devolução de um livro
     * @Parameter: emprestimo Objeto do tipo Emprestimo contendo as informações das datas
     */
    public void imprimeDatasEmprestimo(Emprestimo emprestimo){
        LocalDate diaEmprestimo = emprestimo.getDiaEmprestimo();
        LocalDate diaDevolucao = emprestimo.getDiaDevolucao();
        System.out.println("Data do Emprestimo: " + diaEmprestimo.getDayOfMonth() + "/" 
        + diaEmprestimo.getMonth() + "/" + diaEmprestimo.getYear() + "\nData da Devolucao: " 
        + diaDevolucao.getDayOfMonth() + "/" + diaDevolucao.getMonth() + "/" + diaDevolucao.getYear() + "\n");
    } 
    
    /**
     * @Brief: Imprime as datas de início e fim de uma multa
     * @Parameter: multa Objeto do tipo Multa contendo as informações das datas
     */
    public void imprimeDatasMulta(Multa multa){
        LocalDate inicioMulta = multa.getInicioMulta();
        LocalDate fimMulta = multa.getFimMulta();
        System.out.println("Multa: inicio: " + inicioMulta.getDayOfMonth() + "/" 
        + inicioMulta.getMonth() + "/" + inicioMulta.getYear() + " fim: " 
        + fimMulta.getDayOfMonth() + "/" + fimMulta.getMonth() + "/" + fimMulta.getYear() + "\n");
    }

    /**
     * @Brief: Imprime informações detalhadas de um livro (título, autor, gênero, ISBN)
     * @Parameter: livro Objeto do tipo Livro contendo as informações
     */
    public void imprimirInformacoesLivroComParametros(Livro livro){
        System.out.println("Titulo: " + livro.getTitulo() + "\nAutor: " + livro.getAutor() + "\nGenero: " + livro.getGenero() + "\nISBN: " + livro.getISBN() + "\nStatus: " + livro.getEmprestado());
    }

    /**
     * @Brief: Imprime informações básicas de um livro (título, autor, ISBN)
     * @Parameter: livro Objeto do tipo Livro contendo as informações
     */
    public void imprimirInformacoesLivroSemParametros(Livro livro){
        System.out.println(livro.getTitulo() + " - " + livro.getAutor() + ", " + livro.getISBN());
    }

    /**
     * @Brief: Imprime o catálogo completo de livros de uma biblioteca em ordem alfabética
     * @Parameter: biblioteca Objeto do tipo Biblioteca contendo o catálogo de livros
     */
    public void imprimirCatalogoDeLivros(Biblioteca biblioteca){
        ArrayList<Livro> livros = new ArrayList<>();
        livros = biblioteca.getLivros();
        biblioteca.ordenaLivrosOrdemAlfabetica();
        System.out.println("\nCATÁLOGO: \n"); 
        for(Livro livro : livros){
            System.out.println("--");
            imprimirInformacoesLivroSemParametros(livro);
            System.out.println("\n");
        }
    }

    /**
     * @Brief: Imprime os livros de um gênero específico disponíveis em uma biblioteca
     * @Parameter: biblioteca Objeto do tipo Biblioteca contendo o catálogo de livros
     * @Parameter: genero Gênero desejado para filtrar os livros
     */
    public void imprimirLivrosDeGeneroEspecifico(Biblioteca biblioteca, String genero){
        ArrayList<Livro> livros = new ArrayList<>();
        livros = biblioteca.getLivros();
        biblioteca.ordenaLivrosOrdemAlfabetica();
        System.out.println("\nLIVROS DE " + genero.toUpperCase() + ":\n");
        for(Livro livro : livros){
            if(livro.getGenero().equals(genero)){
                System.out.println("--");
                imprimirInformacoesLivroSemParametros(livro);
                System.out.println("\n");
            }
        }
    }

    /**
     * @Brief: Imprime recomendações de livros didáticos para uma disciplina específica
     * @Parameter: biblioteca Objeto do tipo BibliotecaEscolar contendo o catálogo de livros didáticos
     * @Parameter: disciplina Disciplina para a qual os livros serão recomendados
     */
    public void imprimirRecomenadacoes(BibliotecaEscolar biblioteca, String disciplina){
        ArrayList<LivroDidatico> recomendacoes = biblioteca.recomendacoes(disciplina);
        for(LivroDidatico livro : recomendacoes){
            System.out.println("--");
            imprimirInformacoesLivroSemParametros(livro);
            System.out.println("\n");
        }
    }

    /**
     * @Brief: Imprime relatório geral de livros da biblioteca
     * @Parameter: biblioteca Objeto do tipo Biblioteca contendo o vetor de livros
     */
    public void relatorioGeralLivros(Biblioteca biblioteca){
        ArrayList<Livro> livros = biblioteca.getLivros();
        System.out.println("\nRELATORIO GERAL: \n\n"); 
        for(Livro livro : livros){
            System.out.println("- ");
            imprimirInformacoesLivroComParametros(livro);
            System.out.println("\n");
        }
    }

    /**
     * @Brief: Imprime relatório geral de usuários multados e suas multas da biblioteca
     * @Parameter: biblioteca Objeto do tipo Biblioteca contendo o vetor de usuários
     */
    public void relatorioMultas(Biblioteca biblioteca){
        ArrayList<Usuario> usuarios = biblioteca.getUsuarios();
        System.out.println("\nRELATORIO DE MULTAS: \n\n");
        for(Usuario usuario : usuarios){
            ArrayList<Multa> multas = usuario.getMultas();
            if(multas.isEmpty() == false)
                System.out.println("- " + usuario.getNome());
                for(Multa multa : multas){
                    imprimeDatasMulta(multa);
                    System.out.println("\n");
                }
        }
    }
    
    /**
     * @Brief: Imprime resultado da busca de um livro da biblioteca pelo autor
     * @Parameter: biblioteca Objeto do tipo Biblioteca contendo o vetor de livros
     * @Parameter: autor Objeto do tipo String que indica o autor do livro que se deseja buscar
     */
    public void buscarLivroPorAutor(Biblioteca biblioteca, String autor){
        if(biblioteca.buscarLivroPorAutor(autor) == true){
            System.out.println("\nEste livro está na biblioteca!\n");
        } else {
            System.out.println("\nEste livro não está na biblioteca\n");
        }
    }

    /**
     * @Brief: Imprime resultado da busca de um livro da biblioteca pelo título
     * @Parameter: biblioteca Objeto do tipo Biblioteca contendo o vetor de livros
     * @Parameter: titulo Objeto do tipo String que indica o titulo do livro que se deseja buscar
     */
    public void buscarLivroPorTitulo(Biblioteca biblioteca, String titulo){
        if(biblioteca.buscarLivroPorTitulo(titulo) == true){
            System.out.println("\nEste livro está na biblioteca!\n");
        } else {
            System.out.println("\nEste livro não está na biblioteca\n");
        }
    }

    /**
     * @Brief: Imprime resultado da busca de um livro da biblioteca pelo ISBN
     * @Parameter: biblioteca Objeto do tipo Biblioteca contendo o vetor de livros
     * @Parameter: ISBN Objeto do tipo String que indica o ISBN do livro que se deseja buscar
     */
    public void buscarLivroPorISBN(Biblioteca biblioteca, String ISBN){
        if(biblioteca.buscarLivroPorISBN(ISBN) == true){
            System.out.println("\nEste livro está na biblioteca!\n");
        } else {
            System.out.println("\nEste livro não está na biblioteca\n");
        }
    }

    /**
     * @Brief: Imprime resultado da busca de um usuário da biblioteca 
     * @Parameter: biblioteca Objeto do tipo Biblioteca contendo o vetor de usuários
     * @Parameter: usuarioId Objeto do tipo String que indica o ID do usuário que se deseja buscar
     */
    public void buscarUsuario(Biblioteca biblioteca, String usuarioId){
        if(biblioteca.buscarUsuario(usuarioId) == true){
            System.out.println("\nEste usuário está cadastrado na biblioteca!\n");
        } else {
            System.out.println("\nEste usuário não está cadastrado na biblioteca\n");
        }
    }

    /**
     * @Brief: Informa se foi possível realizar o emprestimo 
     * @Parameter: biblioteca Objeto do tipo Biblioteca 
     * @Parameter: usuario Objeto do tipo Usuario que indica o usuário que fará o empréstimo
     * @Parameter: livro Objeto do tipo Livro que indica o livro que o usuário deseja emprestar
     */
    public void fazerEmprestimo(Biblioteca biblioteca, Usuario usuario, Livro livro){
        if(biblioteca.fazerEmprestimo(livro, usuario) == true){
            System.out.println("\nEmpréstimo realizado com sucesso!\n");
        } else {
            System.out.println("\nNão foi possível realizar o empréstimo\n");
        }
    }

    /**
     * @Brief: Informa se foi possível realizar a devolução 
     * @Parameter: biblioteca Objeto do tipo Biblioteca 
     * @Parameter: usuario Objeto do tipo Usuario que indica o usuário que fará a devolução
     * @Parameter: livro Objeto do tipo Livro que indica o livro que o usuário deseja devolver
     */
    public void fazerDevolucao(Biblioteca biblioteca, Usuario usuario, Livro livro){
        if(biblioteca.fazerDevolucao(livro, usuario) == true){
            System.out.println("\nDevolução realizada com sucesso!\n");
        } else {
            System.out.println("\nNão foi possível realizar a devolução\n");
        }
    }

    /**
     * @Brief: Informa se foi possível remover um usuário
     * @Parameter: biblioteca Objeto do tipo Biblioteca 
     * @Parameter: usuario Objeto do tipo Usuario que indica o usuário que se deseja remover
     */
    public void removerUsuario(Biblioteca biblioteca, Usuario usuario){
        if(biblioteca.removerUsuario(usuario) == true){
            System.out.println("\nUsuário removido\n");
        } else {
            System.out.println("\nNão foi possível remover o usuário\n");
        }
    }

    /**
     * @Brief: Informa se foi possível remover um livro 
     * @Parameter: biblioteca Objeto do tipo Biblioteca 
     * @Parameter: livro Objeto do tipo Livro que indica o livro que se deseja remover
     */
    public void removerLivro(Biblioteca biblioteca, Livro livro){
        if(biblioteca.removerLivro(livro) == true){
            System.out.println("\nLivro removido\n");
        } else {
            System.out.println("\nNão foi possível remover o livro\n");
        }
    }
}