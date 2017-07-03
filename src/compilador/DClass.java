package compilador;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DClass extends Node {

	public String definedFn;
	
	public DClass(Token id, Node args, Node e) throws Exception{
		this.definedFn = id.value;
		this.nodes = Arrays.asList(args, e);
	}
	
	@Override
	public String getResult() throws Exception {
		String argsResult = nodes.get(0).getResult();
		this.validateArgs(argsResult);
		
		String eResult = nodes.get(1).getResult();
		this.validateExpression(eResult);
		
		return this.definedFn;
	}
	
	public void validateArgs(String argsResult) throws Exception {
		//Validates the function definition
		List<String> args = Arrays.asList(argsResult.split(","));
		SemanticAnalysis semanticAnalysis = SemanticAnalysis.getInstance(null);
		Set<String> argSet = new HashSet<String>(args);
		if(argSet.size() < args.size()) {
			throw new Exception(
				"Parametro repetido na declaracao da funcao '"+ this.definedFn + "'."
			);
		}
		
		semanticAnalysis.enterScope();
		semanticAnalysis.addSymbol(this.definedFn);
		for (String string : args) {
			semanticAnalysis.addSymbol(string);
		}
	}
	
	public void validateExpression(String expr) {
		System.out.println(expr);
	}
	
}
