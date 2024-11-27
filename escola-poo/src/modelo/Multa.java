package modelo;

import java.time.LocalDate;

/**
 * @Brief: Classe que representa a multa aplicada por atraso na devolução de livros
 * @Details: Define o período de duração da multa, associa um livro à multa e fornece métodos para aplicar ou remover a multa
 */
public class Multa{
    private LocalDate diaAtual;
    private LocalDate inicioMulta;
    private LocalDate fimMulta;
    private Livro livro;    //Livro que não foi devolvido no prazo

    /**
     * @Brief: Construtor padrão da classe Multa
     * @Details: Inicializa a classe Multa sem configurar os atributos
     */
    public Multa(){

    }

    /**
     * @Brief: Obtem a data atual
     * @Details: Atualiza e retorna a data atual do sistema
     * @Return: Data atual
     */
    public LocalDate getDiaAtual(){
        return diaAtual = LocalDate.now();
    }

    /**
     * @Brief: Obtem a data de início da multa
     * @Details: Retorna a data em que a multa foi aplicada
     * @Return: Data de início da multa
     */
    public LocalDate getInicioMulta(){
        return inicioMulta;
    }

    /**
     * @Brief: Obtem a data de término da multa
     * @Details: Retorna a data em que a multa será finalizada
     * @Return: Data de término da multa
     */
    public LocalDate getFimMulta(){
        return fimMulta;
    }

    /**
     * @Brief: Obtem o livro associado a multa
     * @Details: Retorna o livro que não foi devolvido no prazo e gerou a multa
     * @Return: Livro associado à multa
     */
    public Livro getLivro(){
        return livro;
    }

    /**
     * @Brief: Aplica uma multa por atraso na devolução de um livro
     * @Details: Associa um livro a multa, define a data de início como o dia atual e calcula a data de término como 10 dias após o início
     * @Parameter: livro Livro que não foi devolvido no prazo
     */
    public void aplicaMulta(Livro livro){
        this.livro = livro;
        diaAtual = LocalDate.now();
        inicioMulta = diaAtual;
        fimMulta = diaAtual.plusDays(10);
    }

    /**
     * @Brief: Verifica se a multa deve ser removida
     * @Details: Avalia se o período da multa expirou e se o livro foi devolvido, se a multa expirou e o livo não foi devolvido, uma nova multa é aplicada
     * @Parameter: usuario Usuário associado a multa
     * @Return: true se a multa puder ser removida, false caso contrário
     */
    public boolean removeMulta(Usuario usuario){
        diaAtual = LocalDate.now();
        if(diaAtual.compareTo(fimMulta) >= 0 && usuario.buscaLivro(livro) == false){
            return true;
        }
        if(diaAtual.compareTo(fimMulta) >= 0 && usuario.buscaLivro(livro) == true){     //acabou a multa porém o livro ainda não foi devolvido, portanto reaplica multa
            fimMulta = diaAtual.plusDays(10); 
        }
        return false;
    }
}