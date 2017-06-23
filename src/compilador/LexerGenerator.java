package compilador;

import java.io.File;
import java.nio.file.Paths;

public class LexerGenerator {
	
	
	public static void main(String[] args) {
		
		String rootPath = Paths.get("").toAbsolutePath().toString();
		String subPath = "/src/compilador/";
		
		String file = rootPath + subPath + "language.jflex";
		
		File sourceCode = new File(file);
		
		jflex.Main.generate(sourceCode);
		
	}

}