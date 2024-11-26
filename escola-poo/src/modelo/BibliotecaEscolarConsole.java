package modelo;

import java.time.DayOfWeek;
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
     * @Brief: Imprime informações detalhadas de um livro (título, autor, gênero, ISBN)
     * @Parameter: livro Objeto do tipo Livro contendo as informações
     */
    public void imprimirInformacoesLivroComParametros(Livro livro){
        System.out.println("\nTitulo: " + livro.getTitulo() + "\nAutor: " + livro.getAutor() + "\nGenero: " + livro.getGenero() + "\nISBN: " + livro.getISBN());
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
        ArrayList<Livro> livros = biblioteca.getLivros();
        biblioteca.ordenaLivrosOrdemAlfabetica();
        System.out.println("\nCATÁLOGO: \n"); 
        for(Livro livro : livros){
            imprimirInformacoesLivroSemParametros(livro);
        }
    }

    /**
     * @Brief: Imprime os livros de um gênero específico disponíveis em uma biblioteca
     * @Parameter: biblioteca Objeto do tipo Biblioteca contendo o catálogo de livros
     * @Parameter: genero Gênero desejado para filtrar os livros
     */
    public void imprimirLivrosDeGeneroEspecifico(Biblioteca biblioteca, String genero){
        ArrayList<Livro> livros = biblioteca.getLivros();
        biblioteca.ordenaLivrosOrdemAlfabetica();
        System.out.println("\nLIVROS DE " + genero.toUpperCase() + ":\n");
        for(Livro livro : livros){
            if(livro.getGenero().equals(genero)){
                imprimirInformacoesLivroSemParametros(livro);
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
            imprimirInformacoesLivroSemParametros(livro);
        }
    }

}