public class CursoExtra extends AtividadeExtra{
	private String professor;
	private String descricao;

	public CursoExtra(){
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
