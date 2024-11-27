package modelo;

import java.time.LocalDate;

/**
 * @Brief: Classe que representa o empréstimo de um livro
 * @Details: Gerencia informações como a data do empréstimo, data de devolução e validações relacionadas a prazos e multas
 */
public class Emprestimo{
    private LocalDate diaEmprestimo;
    private LocalDate diaDevolucao;
    private LocalDate diaAtual;
    
    /**
     * @Brief: Construtor padrão da classe Emprestimo
     */
    public Emprestimo(){
        
    }

    /**
     * @Brief: Calcula a data de devolução do livro
     * @Details: Define a data de devolução como 10 dias após a data do empréstimo, considerando que não pode ser um domingo
     * @Return: Data de devolução do livro ou null se cair em um domingo
     */
    public LocalDate calculaDataDevolucao(){
        if(VerificaSeEDomingo.verificaSeEDomingo() == true){  //nao pode devolver no domingo
            return null;
        }
        this.diaEmprestimo = LocalDate.now();
        this.diaDevolucao = diaEmprestimo.plusDays(10);
        return diaDevolucao;
    }

    /**
     * @Brief: Obtem a data do empréstimo
     * @Return: Data do empréstimo
     */
    public LocalDate getDiaEmprestimo(){
        return diaEmprestimo;
    }

    /**
     * @Brief: Obtem a data de devolução
     * @Return: Data de devolução
     */
    public LocalDate getDiaDevolucao(){
        return diaDevolucao;
    }

    /**
     * @Brief: Obtem a data atual
     * @Details: Atualiza o valor da data atual para o dia em que o método é chamado
     * @Return: Data atual
     */
    public LocalDate getDiaAtual(){
        return diaAtual = LocalDate.now();
    }

    /**
     * @Brief: Verifica se há multa para o usuário
     * @Details: Compara a data de devolução com a data atual para verificar atraso
     * @Return: True se houver atraso, indicando que deve ser aplicada multa, ou false caso contrário
     */
    public boolean verificaMulta(){
        diaAtual = LocalDate.now();
        if(diaDevolucao.compareTo(diaAtual) >= 0){
            return false;
        }
        return true;
    }

}