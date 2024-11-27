package controlador;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Classe responsável por registrar logs em um arquivo
 */
public class Logger {
    /**
     * @Brief: Enum que representa os níveis de log
     */
	enum Level {
		INFO,
		ERROR,
	}

	private Logger() {}

	private static Logger instance;
	private static final String filename = "log.txt";

        /**
        * @Brief: Retorna a instancia unica da classe Logger (Singleton)
        * @Return: Instancia unica da classe Logger
        */
	public static Logger getInstance() {
		if(instance == null)
			instance = new Logger();
		return instance;
	}

        /**
        * @Brief: Registra uma mensagem no arquivo de log
        * @Parameter: msg A mensagem a ser registrada
        * @Parameter: tipo O nível do log (INFO ou ERROR)
        */
	public void gravaArquivo(String msg, Level tipo) {
		LocalDateTime atual = LocalDateTime.now();
		try(FileWriter fileWriter = new FileWriter("./log.txt", true)) {
			String dataHoraFormatada = atual.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));

			switch(tipo){
				case INFO:
					fileWriter.write("INFO");
					break;
				case ERROR:
					fileWriter.write("ERROR");
					break;
			}

			fileWriter.write(" ["+dataHoraFormatada+"] ");

			fileWriter.write(msg+"\n");

			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
