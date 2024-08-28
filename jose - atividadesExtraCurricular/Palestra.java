public class Palestra extends AtividadeExtra{
	private String palestrante;
	private String descricao;

	public Palestra(){
	}

	public String getPalestrante(){
		return this.palestrante;
	}

	public String getDescricao(){
		return this.descricao;
	}

	public void setPalestrante(String palestrante){
		this.palestrante = palestrante;
	}

	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
}
