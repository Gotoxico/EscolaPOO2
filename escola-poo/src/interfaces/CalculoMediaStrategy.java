package interface;
//Classe Aluno: Classe base com atributos como matricula, curso.
import java.util.ArrayList;
import modelo.Prova;
import modelo.Trabalho;
import modelo.PontoExtra;

//Padrão de Projeto: Strategy
//Parametriza os algoritmos usado em um classe, ou seja, tem-se uma família de algoritmos usados por uma classe e o usuário escolhe o melhor para ele. (A estratégia que será usada é escolha do usuário.)
//Interface para a estratégia de cálculo de média
public interface CalculoMediaStrategy {
    float calcularMedia(ArrayList<Prova> provas, ArrayList<Trabalho> trabalhos, ArrayList<PontoExtra> pontosExtras);
}
