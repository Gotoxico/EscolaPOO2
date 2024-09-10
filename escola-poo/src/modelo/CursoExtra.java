package modelo;

public class CursoExtra extends AtividadeExtra{
	private String professor;
	private String descricao;

	public CursoExtra(double horasTotais, String titulo, String professor, String descricao){
		super(horasTotais, titulo);
		this.professor = professor;
		this.descricao = descricao;
	}

	public String getProfessor(){
		return this.professor;
	}

	public String getDescricao(){
		return this.descricao;
	}

	public void setProfessor(String professor){
		this.professor = professor;
	}

	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
}
