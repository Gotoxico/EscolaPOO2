package modelo;

import interfaces.Avaliacao;

public class PontoExtraDecorator implements Avaliacao {
    private Avaliacao avaliacao;
    private PontoExtra pontoExtra;
    
    public PontoExtraDecorator(Avaliacao avaliacao, PontoExtra pontoExtra) {
        this.avaliacao = avaliacao;
        this.pontoExtra = pontoExtra;
    }

    @Override
    public double calcularNota() {
        return avaliacao.calcularNota() + pontoExtra.getValor();
    }
}
