public class Principal{
	public static void main(String[] args){
		Logger l = Logger.getInstance();

		l.gravaArquivo("Alterou a nota do aluno x", Logger.Level.INFO);
	}
}
