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
		
		LexicalAnalyzer lexical = new LexicalAnalyzer(new FileReader(sourceCode));
        lexical.yylex();
		
	}

}
