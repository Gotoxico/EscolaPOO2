package interface;
//Classe Aluno: Classe base com atributos como matricula, curso.
//Interface para observar desempenho do aluno
public interface ObservadorDesempenho {
    void notificarDesempenho(String nomeAluno, float media);
}
