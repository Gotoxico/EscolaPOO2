package modelo;

/**
 * @Brief: Representa uma palestra como uma atividade extra
 * @Details: A classe Palestra herda da classe AtividadeExtra e inclui informações específicas, como palestrante e descrição
 */
public class Palestra extends AtividadeExtra{
	private String palestrante;
	private String descricao;

        /**
        * @Brief: Construtor da classe Palestra
        * @Details: Inicializa uma palestra com horas totais, título, palestrante e descrição
        * @Parameter: horasTotais Quantidade de horas totais da palestra
        * @Parameter: titulo Título da palestra
        * @Parameter: palestrante Nome do palestrante
        * @Parameter: descricao Descrição da palestra
        */
	public Palestra(double horasTotais, String titulo, String palestrante, String descricao){
		super(horasTotais, titulo);
		this.palestrante = palestrante;
		this.descricao = descricao;
	}

        /**
        * @Brief: Retorna o nome do palestrante
        * @Return: Nome do palestrante
        */
	public String getPalestrante(){
		return this.palestrante;
	}

        /**
        * @Brief: Retorna a descrição da palestra
        * @Return: Descrição da palestra
        */
	public String getDescricao(){
		return this.descricao;
	}

        /**
        * @Brief: Define o nome do palestrante
        * @Parameter: palestrante Nome do palestrante
        */
	public void setPalestrante(String palestrante){
		this.palestrante = palestrante;
	}

        /**
        * @Brief: Define a descrição da palestra
        * @Parameter: descricao Descrição da palestra
        */
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
}
