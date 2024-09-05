package modelo;
public class BibliotecaEscolar extends Biblioteca{ 

    //@Override
    public int addUsuario(Professor professor){
        if(contUsuarios < QUANT_MAX_USUARIOS){
            usuarios[contUsuarios] = professor;
            contUsuarios++;
            return 1;
        }
        return 0;
    }

    //@Override
    public int addUsuario(Aluno aluno){
        if(contUsuarios < QUANT_MAX_USUARIOS){
            usuarios[contUsuarios] = aluno;
            contUsuarios++;
            return 1;
        }
        return 0;
    }
    
}