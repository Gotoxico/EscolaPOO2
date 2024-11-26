package modelo;

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

    public void imprimeDatasMulta(Multa multa){
        LocalDate inicioMulta = multa.getInicioMulta();
        LocalDate fimMulta = multa.getFimMulta();
        System.out.println("Multa: inicio: " + inicioMulta.getDayOfMonth() + "/" 
        + inicioMulta.getMonth() + "/" + inicioMulta.getYear() + " fim: " 
        + fimMulta.getDayOfMonth() + "/" + fimMulta.getMonth() + "/" + fimMulta.getYear() + "\n");
    } 

    public void imprimirInformacoesLivroComParametros(Livro livro){
        System.out.println("Titulo: " + livro.getTitulo() + "\nAutor: " + livro.getAutor() + "\nGenero: " + livro.getGenero() + "\nISBN: " + livro.getISBN() + "\nStatus: " + livro.getEmprestado());
    }

    public void imprimirInformacoesLivroSemParametros(Livro livro){
        System.out.println(livro.getTitulo() + " - " + livro.getAutor() + ", " + livro.getISBN());
    }

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

    public void imprimirRecomenadacoes(BibliotecaEscolar biblioteca, String disciplina){
        ArrayList<LivroDidatico> recomendacoes = biblioteca.recomendacoes(disciplina);
        for(LivroDidatico livro : recomendacoes){
            System.out.println("--");
            imprimirInformacoesLivroSemParametros(livro);
            System.out.println("\n");
        }
    }

    public void relatorioGeralLivros(Biblioteca biblioteca){
        ArrayList<Livro> livros = biblioteca.getLivros();
        System.out.println("\nRELATORIO GERAL: \n\n"); 
        for(Livro livro : livros){
            System.out.println("- ");
            imprimirInformacoesLivroComParametros(livro);
            System.out.println("\n");
        }
    }

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

}