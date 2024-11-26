package modelo;

/**
 * @Brief: Classe que representa uma Iniciação Científica como uma atividade extra
 * @Details: A Iniciação Científica é uma atividade extra que envolve o acompanhamento de um orientador
 */
public class IniciacaoCientifica extends AtividadeExtra{
	private Professor orientador;

        /**
        * @Brief: Construtor da classe IniciacaoCientifica
        * @Details: Inicializa os atributos da Iniciação Científica, associando o título, as horas totais e o orientador
        * @Parameter: horasTotais Quantidade total de horas da atividade
        * @Parameter: titulo Título da atividade extra
        * @Parameter: orientador Professor responsável pela orientação na Iniciação Científica
        */
	public IniciacaoCientifica(double horasTotais, String titulo, Professor orientador){
		super(horasTotais, titulo);
		this.orientador = orientador;
	}

        /**
        * @Brief: Obtem o orientador da Iniciação Científica
        * @Return: O professor responsável pela orientação
        */
	public Professor getOrientador(){
		return this.orientador;
	}

        /**
        * @Brief: Define o orientador da Iniciação Científica
        * @Parameter: orientador Professor responsável pela orientação
        */
	public void setOrientador(Professor orientador){
		this.orientador = orientador;
	}
}
