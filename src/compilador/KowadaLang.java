package compilador;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class KowadaLang {

    public static void main(String[] args) throws IOException {

        String rootPath = Paths.get("").toAbsolutePath().toString();
        String subPath = "/src/compilador/";

        String sourceCode = rootPath + subPath + "program.txt";

        try {
        	Parser p = new Parser(new Lexer(new FileReader(sourceCode)));
            Node result = (Node) p.parse().value;
            
            SemanticAnalysis sem = new SemanticAnalysis(result);
            sem.analyze();

            System.out.println("Compilacao concluida com sucesso...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
