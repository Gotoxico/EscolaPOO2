package modelo;

public class BibliotecaEscolar extends Biblioteca{

    public BibliotecaEscolar(String tipoOutput) {
        super(tipoOutput);
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