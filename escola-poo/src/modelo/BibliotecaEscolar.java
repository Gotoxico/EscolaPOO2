package modelo;

import java.util.ArrayList;

public class BibliotecaEscolar extends Biblioteca{ 

        public ArrayList<LivroDidatico> recomendacoes(String disciplina){     //gera um array que será impresso no Console com as indicações de livros de acordo com uma disciplina
                ArrayList<LivroDidatico> recomendacoes =  new ArrayList();  
                for(Livro livro : livros){
                        if(livro instanceof LivroDidatico){
                                if(((LivroDidatico)livro).getDisciplina().equals(disciplina)){
                                        recomendacoes.add((LivroDidatico)livro);
                                }
                        }
                }
                return recomendacoes;       
        }


}

