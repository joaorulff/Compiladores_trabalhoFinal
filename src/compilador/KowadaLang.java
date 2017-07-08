package compilador;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import SemanticAnalysis.SemanticAnalysis;
import codeGeneration.CodeGenerator;
import second_level_class.EClass;
import second_level_class.PClass;
import utils.FunctionCall;
//import second_level_class.PClass;
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
            
            semanticAnalysis(program);
            
            List<String> code = CodeGenerator.generateCode(program);
            code.stream().forEach((line) -> { System.out.println(line); });
            writeToFile(code);
            
            System.out.println("Compilacao concluida com sucesso.");
            
        } catch (Exception e) {
        	
            e.printStackTrace();
        }

    }
    
    public static void writeToFile(List<String> code) throws IOException {
        Path path = Paths.get("mips.asm");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
        	code.stream().forEach((line) -> { 
        		try {
        			writer.write(line + "\n");
        		} catch (IOException e) {
					e.printStackTrace();
        		} 
        	});
        }
    }
    
    public static void semanticAnalysis(PClass program) throws Exception{
        SemanticAnalysis semantic = new SemanticAnalysis(program);
        semantic.checkRuleA();
        semantic.checkRuleB();
        semantic.checkRuleC();
        semantic.checkRuleD();
    }

}
