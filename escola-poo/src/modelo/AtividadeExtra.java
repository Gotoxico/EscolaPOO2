package modelo;

public class AtividadeExtra{
	protected double horasTotais;
	protected String titulo;

	public AtividadeExtra(double horasTotais, String titulo){
		this.horasTotais = horasTotais;
		this.titulo = titulo;
	}

	public String getTitulo(){
		return this.titulo;
	}

	public double getHorasTotais(){
		return this.horasTotais;
	}

	public void setTitulo(String titulo){
		this.titulo = titulo;
	}

	public void setHorasTotais(double horasTotais){
		this.horasTotais = horasTotais;
	}
}
