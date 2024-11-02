package modelo;

import modelo.Output.OutputFactory;

public class BibliotecaEscolar extends Biblioteca{

    public BibliotecaEscolar(OutputFactory outputFactory, String tipoOutput) {
        super(outputFactory, tipoOutput);
    }

    //@Override
    public boolean addUsuario(Professor professor){
            usuarios.add(professor);
            return true;
    }

    //@Override
    public boolean addUsuario(Aluno aluno){
            usuarios.add(aluno);
            return true;

    }
}