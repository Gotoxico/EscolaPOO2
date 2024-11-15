package modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class BibliotecaEscolarConsole{    //classe com funções de impressão relacionada apenas às classes de Biblioteca

    public void imprimeDatasEmprestimo(Emprestimo emprestimo){
        LocalDate diaEmprestimo = emprestimo.getDiaEmprestimo();
        LocalDate diaDevolucao = emprestimo.getDiaDevolucao();
        System.out.println("Data do Emprestimo: " + diaEmprestimo.getDayOfMonth() + "/" 
        + diaEmprestimo.getMonth() + "/" + diaEmprestimo.getYear() + "\nData da Devolucao: " 
        + diaDevolucao.getDayOfMonth() + "/" + diaDevolucao.getMonth() + "/" + diaDevolucao.getYear() + "\n");
    } 

    public void imprimirInformacoesLivroComParametros(Livro livro){
        System.out.println("\nTitulo: " + livro.getTitulo() + "\nAutor: " + livro.getAutor() + "\nGenero: " + livro.getGenero() + "\nISBN: " + livro.getISBN());
    }

    public void imprimirInformacoesLivroSemParametros(Livro livro){
        System.out.println(livro.getTitulo() + " - " + livro.getAutor() + ", " + livro.getISBN());
    }

    public void imprimirCatalogoDeLivros(Biblioteca biblioteca){
        ArrayList<Livro> livros = ArrayList();
        livros = bibliotca.getLivros();
        bibliotca.ordenaLivrosOrdemAlfabetica();
        System.out.pritnln("\nCATÁLOGO: \n"); 
        for(Livro livro : livros){
            System.out.println("--" + imprimirInformacoesLivroSemParametros(livro));
        }
    }

    public void imprimirLivrosDeGeneroEspecifico(Biblioteca biblioteca, String genero){
        ArrayList<Livro> livros = ArrayList();
        livros = bibliotca.getLivros();
        bibliotca.ordenaLivrosOrdemAlfabetica();
        System.out.println("\nLIVROS DE " + genero.toUpperCase() + ":\n");
        for(Livro livro : livros){
            if(livro.getGenero().equals(genero)){
                System.out.println("--" + imprimirInformacoesLivroSemParametros(livro));
            }
        }
    }

    public void imprimirRecomenadacoes(BibliotecaEscolar bibliotca){
        ArrayList<LivroDidatico> recomendacoes = bibliotca.recomendacoes();
        for(LivroDidatico livro : recomendacoes){
            System.out.println("--" + imprimirInformacoesLivroSemParametros(livro));
        }
    }

}