package modelo;

import java.util.ArrayList;

public class AtividadeExtraCurricular{
	private ArrayList<AtividadeExtra> atividades;
	private double horasTotais;

	public AtividadeExtraCurricular(){
		this.atividades = new ArrayList<>();
		this.horasTotais = 0;
	}

	public void addIniciacaoCientifica(IniciacaoCientifica ic){
		horasTotais += ic.horasTotais;
		atividades.add(ic);
	}

	public void addPalestra(Palestra p){
		horasTotais += p.horasTotais;
		atividades.add(p);
	}

	public void addCursoExtra(CursoExtra ce){
		horasTotais += ce.horasTotais;
		atividades.add(ce);
	}

	public int getQtdAtividades(){
		return atividades.size();
	}

	public ArrayList<AtividadeExtra> getAtividades(){
		return this.atividades;
	}

	public ArrayList<IniciacaoCientifica> getIniciacoesCientificas(){
		ArrayList<IniciacaoCientifica> ics = new ArrayList<>();
		for(int i=0; i < this.atividades.size(); i++){
			if(this.atividades.get(i) instanceof IniciacaoCientifica){
				ics.add((IniciacaoCientifica)this.atividades.get(i));
			}
		}
		return ics;
	}

	public ArrayList<Palestra> getPalestras(){
		ArrayList<Palestra> ps = new ArrayList<>();
		for(int i=0; i < this.atividades.size(); i++){
			if(this.atividades.get(i) instanceof Palestra){
				ps.add((Palestra)this.atividades.get(i));
			}
		}
		return ps;
	}

	public ArrayList<CursoExtra> getCursosExtras(){
		ArrayList<CursoExtra> ces = new ArrayList<>();
		for(int i=0; i < this.atividades.size(); i++){
			if(this.atividades.get(i) instanceof CursoExtra){
				ces.add((CursoExtra)this.atividades.get(i));
			}
		}
		return ces;
	}

	public double getHorasTotais(){
		return this.horasTotais;
	}

}
