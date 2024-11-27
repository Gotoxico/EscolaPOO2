package modelo;

import constantes.Constantes;
import java.util.ArrayList;

public class RelatorioAlunos {
    
    private RelatorioAlunos() {}
    
    /**
     * @Brief: Gera um relatório sobre os alunos, indicando se passariam ou não com base em uma nota de corte
     * @Parameter: alunos Lista de objetos Aluno
     * @Parameter: opcao Código da universidade que define a nota de corte
     * @Return: Relatório com os alunos e seu status (Passaria/Não Passaria)
     */
    public static String relatorio(ArrayList<Aluno> alunos, int opcao){
        float notaCorte = opcoes(opcao);
        StringBuilder relatorio = new StringBuilder();
        for(Aluno aluno : alunos){
            relatorio.append(aluno.getNome())
                     .append(aluno.calcularMedia()>= notaCorte ? " Passaria\n" : " Não Passaria\n");
        }
        
        return relatorio.toString();
    }
    
    /**
     * @Brief: Retorna a nota de corte dependendo da universidade selecionada
     * @Parameter: opcao Código da universidade (1-13)
     * @Return: Nota de corte correspondente à universidade
     */
    private static float opcoes(int opcao){
        switch(opcao){
            case 1:
                // USP
                return Constantes.USP;
            case 2:
                // UNICAMP
                return Constantes.UNICAMP;
            case 3:
                // UFRJ
                return Constantes.UFRJ;
            case 4:
                // UNIFESP
                return Constantes.UNIFESP;
            case 5:
                // UNESP
                return Constantes.UNESP;
            case 6:
                // UFMG
                return Constantes.UFMG;
            case 7:
                // UFRGS
                return Constantes.UFRGS;
            case 8:
                // UFSC
                return Constantes.UFSC;
            case 9:
                // PUC
                return Constantes.PUC;
            case 10:
                // Mackenzie
                return Constantes.MACKENZIE;
            case 11:
                // FGV
                return Constantes.FGV;
            case 12:
                // UNOESTE
                return Constantes.UNOESTE;
            case 13:
                // Unimar
                return Constantes.UNIMAR;
        }
        return 0f;
    }
}
