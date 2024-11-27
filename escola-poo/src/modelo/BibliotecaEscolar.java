package modelo;

import java.util.ArrayList;

public class BibliotecaEscolar extends Biblioteca{ 

        /**
        * @Brief: Gera uma lista de livros didáticos recomendados com base em uma disciplina
        * @Parameter: disciplina Disciplina para a qual os livros serão recomendados
        * @Return: Lista de livros didáticos recomendados
        */
        public ArrayList<LivroDidatico> recomendacoes(String disciplina){     //gera um array que será impresso no Console com as indicações de livros de acordo com uma disciplina
                ArrayList<LivroDidatico> recomendacoes =  new ArrayList<>();  
                for(Livro livro : livros){
                        if(livro instanceof LivroDidatico){
                                LivroDidatico livroDidatico = (LivroDidatico) livro;
                                if(livroDidatico.getDisciplina().equals(disciplina)){
                                        recomendacoes.add(livroDidatico);
                                }
                        }
                }
                return recomendacoes;       
        }


}

