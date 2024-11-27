package modelo;

/**
 * @Brief: Classe representando um curso extra como uma atividade extracurricular
 * @Details: Esta classe herda de AtividadeExtra e adiciona informações específicas como professor e descrição do curso
 */
public class CursoExtra extends AtividadeExtra{
	private String professor;
	private String descricao;

        /**
        * @Brief: Construtor para inicializar os atributos do CursoExtra
        * @Parameter: horasTotais Número total de horas do curso
        * @Parameter: titulo Título do curso
        * @Parameter: professor Nome do professor responsável
        * @Parameter: descricao Breve descrição do curso
        */
	public CursoExtra(double horasTotais, String titulo, String professor, String descricao){
		super(horasTotais, titulo);
		this.professor = professor;
		this.descricao = descricao;
	}

        /**
        * @Brief: Obtem o nome do professor responsável pelo curso
        * @Return: Nome do professor
        */
	public String getProfessor(){
		return this.professor;
	}

        /**
        * @Brief: Obtem a descrição do curso
        * @Return: Descrição do curso
        */
	public String getDescricao(){
		return this.descricao;
	}

        /**
        * @Brief: Define o nome do professor responsável pelo curso
        * @Parameter: professor Nome do professor
        */
	public void setProfessor(String professor){
		this.professor = professor;
	}

        /**
        * @Brief: Define a descrição do curso
        * @Parameter: descricao Descrição do curso
        */
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
}
