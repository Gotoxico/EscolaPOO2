package modelo;

import java.util.ArrayList;

public class AtividadeExtraCurricular{
	private ArrayList<AtividadeExtra> atividades;
	private double horasTotais;

        /**
        * @Brief: Construtor da classe AtividadeExtraCurricular que inicializa as listas de atividades e as horas totais
        */
	public AtividadeExtraCurricular(){
		this.atividades = new ArrayList<>();
		this.horasTotais = 0;
	}

        /**
        * @Brief: Adiciona uma atividade de iniciação científica
        * @Parameter: ic Instância de IniciacaoCientifica a ser adicionada
        */
	public void addIniciacaoCientifica(IniciacaoCientifica ic){
		horasTotais += ic.horasTotais;
		atividades.add(ic);
	}
        
        /**
        * @Brief: Adiciona uma atividade de palestra
        * @Parameter: p Instância de Palestra a ser adicionada
        */
	public void addPalestra(Palestra p){
		horasTotais += p.horasTotais;
		atividades.add(p);
	}

        /**
        * @Brief: Adiciona uma atividade de curso extra
        * @Parameter: ce Instância de CursoExtra a ser adicionada
        */
	public void addCursoExtra(CursoExtra ce){
		horasTotais += ce.horasTotais;
		atividades.add(ce);
	}

        /**
        * @Brief: Obtem a quantidade de atividades cadastradas
        * @Return: Quantidade de atividades
        */
	public int getQtdAtividades(){
		return atividades.size();
	}

        /**
        * @Brief: Obtem a lista de todas as atividades cadastradas
        * @Return: Lista de atividades
        */
	public ArrayList<AtividadeExtra> getAtividades(){
		return this.atividades;
	}

        /**
        * @Brief: Obtem a lista de atividades de iniciação científica
        * @Return: Lista de IniciacaoCientifica
        */
	public ArrayList<IniciacaoCientifica> getIniciacoesCientificas(){
		ArrayList<IniciacaoCientifica> ics = new ArrayList<>();
		for(int i=0; i < this.atividades.size(); i++){
			if(this.atividades.get(i) instanceof IniciacaoCientifica){
				ics.add((IniciacaoCientifica)this.atividades.get(i));
			}
		}
		return ics;
	}

        /**
        * @Brief: Obtem a lista de atividades de palestras
        * @Return: Lista de Palestra
        */
	public ArrayList<Palestra> getPalestras(){
		ArrayList<Palestra> ps = new ArrayList<>();
		for(int i=0; i < this.atividades.size(); i++){
			if(this.atividades.get(i) instanceof Palestra){
				ps.add((Palestra)this.atividades.get(i));
			}
		}
		return ps;
	}

        /**
        * @Brief: Obtem a lista de atividades de cursos extras
        * @Return: Lista de CursoExtra
        */
	public ArrayList<CursoExtra> getCursosExtras(){
		ArrayList<CursoExtra> ces = new ArrayList<>();
		for(int i=0; i < this.atividades.size(); i++){
			if(this.atividades.get(i) instanceof CursoExtra){
				ces.add((CursoExtra)this.atividades.get(i));
			}
		}
		return ces;
	}

        /**
        * @Brief: Obtem o total de horas acumuladas em atividades
        * @Return: Total de horas
        */
	public double getHorasTotais(){
		return this.horasTotais;
	}

}
