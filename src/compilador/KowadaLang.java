package compilador;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;

public class KowadaLang {

    public static void main(String[] args) throws IOException {

        String rootPath = Paths.get("").toAbsolutePath().toString();
        String subPath = "/src/compilador/";

        String sourceCode = rootPath + subPath + "program.txt";

        try {
            Parser p = new Parser(new Lexer(new FileReader(sourceCode)));
            Object result = p.parse().value;
            System.out.println("Compilacao concluida com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
