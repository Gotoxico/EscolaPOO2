package modelo;

/**
 * @Brief: Classe que implementa Comparator e define como os Livros deverão ser comparados
 */
import java.util.Comparator;

public class LivroComparator implements Comparator<Livro> {
    @Override
    public int compare(Livro livro1, Livro livro2){
        return livro1.getTitulo().compareTo(livro2.getTitulo());
    }

    public LivroComparator(){

    }
}
