public class BibliotecaEscolar extends Biblioteca{ 

    @Override
    public int addUsuario(Professor professor){
            usuarios.add(professor);
            return 1;
    }

    @Override
    public int addUsuario(Aluno aluno){
            usuarios.add(aluno);
            return 1;
    }
}