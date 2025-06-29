package arquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorDeArquivo {
    private static final String caminhoDoArquivo = "logger.txt";

    public static void writeFile(String msg) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoDoArquivo, true))) {
            writer.write(msg);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
