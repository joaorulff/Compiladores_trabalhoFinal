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
		List<String> args = Arrays.asList(argsResult.split(","));
		this.validateArgs(args);
		
		String eResult = nodes.get(1).getResult();
		
		return this.definedFn + argsResult + eResult;
	}
	
	public void validateArgs(List<String> args) throws Exception {
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
	
}
