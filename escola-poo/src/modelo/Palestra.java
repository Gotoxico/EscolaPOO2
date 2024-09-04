package modelo;

public class Palestra extends AtividadeExtra{
	private String palestrante;
	private String descricao;

	public Palestra(double horasTotais, String titulo, String palestrante, String descricao){
		super(horasTotais, titulo);
		this.palestrante = palestrante;
		this.descricao = descricao;
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
