package modelo;

public class AtividadeExtra{
	protected double horasTotais;
	protected String titulo;

        /**
        * @Brief: Construtor da classe AtividadeExtra que inicializa os dados básicos da atividade
        * @Parameter: horasTotais Quantidade total de horas da atividade
        * @Parameter: titulo Título da atividade
        */
	public AtividadeExtra(double horasTotais, String titulo){
		this.horasTotais = horasTotais;
		this.titulo = titulo;
	}

        /**
        * @Brief: Obtem o titulo da atividade
        * @Return: Título da atividade
        */
	public String getTitulo(){
		return this.titulo;
	}

        /**
        * @Brief: Obtem a quantidade total de horas da atividade
        * @Return: Horas totais da atividade
        */
	public double getHorasTotais(){
		return this.horasTotais;
	}

        /**
        * @Brief: Define o título da atividade
        * @Parameter: titulo Novo título da atividade
        */
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}

        /**
        * @Brief: Define a quantidade total de horas da atividade
        * @Parameter: horasTotais Nova quantidade total de horas
        */
	public void setHorasTotais(double horasTotais){
		this.horasTotais = horasTotais;
	}
}
