package compilador;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import second_level_class.PClass;
import utils.FunctionDeclaration;
import utils.ID;

public class KowadaLang {

    public static void main(String[] args) throws IOException {

        String rootPath = Paths.get("").toAbsolutePath().toString();
        String subPath = "/src/compilador/";

        String sourceCode = rootPath + subPath + "program.txt";

        try {
        	
        	Parser p = new Parser(new Lexer(new FileReader(sourceCode)));
            Node result = (Node) p.parse().value;
            
            PClass program = (PClass)result;
            ArrayList<FunctionDeclaration> functions = program.globalFunctionsDeclared();
            
            for (FunctionDeclaration function : functions) {
				if(function.checkForRepeatedParamenters()){
					System.out.println("INVALIDO!");
				}
			}
            
            result.printTree();
            
//            SemanticAnalysis sem = SemanticAnalysis.getInstance(result);
//            sem.analyze();
            
 //           CodeGenerator cg = new CodeGenerator();

            System.out.println("Compilacao concluida com sucesso...");
            
        } catch (Exception e) {
        	
            e.printStackTrace();
        }

    }

}
