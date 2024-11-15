package modelo;

public class IniciacaoCientifica extends AtividadeExtra{
	private Professor orientador;

	public IniciacaoCientifica(double horasTotais, String titulo, Professor orientador){
		super(horasTotais, titulo);
		this.orientador = orientador;
	}

	public Professor getOrientador(){
		return this.orientador;
	}

	public void setOrientador(Professor orientador){
		this.orientador = orientador;
	}
}
