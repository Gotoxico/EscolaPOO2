package modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

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
        ArrayList<Livro> livros = biblioteca.getLivros();
        biblioteca.ordenaLivrosOrdemAlfabetica();
        System.out.println("\nCATÁLOGO: \n"); 
        for(Livro livro : livros){
            imprimirInformacoesLivroSemParametros(livro);
        }
    }

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

    public void imprimirRecomenadacoes(BibliotecaEscolar biblioteca, String disciplina){
        ArrayList<LivroDidatico> recomendacoes = biblioteca.recomendacoes(disciplina);
        for(LivroDidatico livro : recomendacoes){
            imprimirInformacoesLivroSemParametros(livro);
        }
    }

}