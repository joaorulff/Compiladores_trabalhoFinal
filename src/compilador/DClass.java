package compilador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DClass extends Node {

	public String definedFn;
	public Integer qttParams;
	
	public DClass(Token id, Node args, Node e) throws Exception{
		this.definedFn = id.value;
		this.nodes = Arrays.asList(args, e);
		this.qttParams = this.countParams(args);
	}
	
	private int countParams(Node args) throws Exception{
		int count = 0;
		Set<String> argSet = new HashSet<String>();
		Node currentNode = args;
		while(currentNode != null) {
			count++;
			if(!argSet.add(((ArgsClass) currentNode).id)) {
				throw new Exception("Parametros repetidos.");
			}
			if(currentNode.nodes.size() > 0) {
				currentNode = currentNode.nodes.get(0);
			} else {
				currentNode = null;
			}
		}
		return count;
	}
	
	@Override
	public String getResult() throws Exception {
		String result = this.definedFn;

//		for(Node n:nodes) {
//			result += n.getResult();
//		}

		
		String argsResult = nodes.get(0).getResult();
		List<String> args = Arrays.asList(argsResult.split(","));
		
		SemanticAnalysis semanticAnalysis = SemanticAnalysis.getInstance(null);
		semanticAnalysis.table.enterScope();
		
		semanticAnalysis.table.addSymbol(this.definedFn);
		for (String string : args) {
			semanticAnalysis.table.addSymbol(string);
		}
		
		String eResult = nodes.get(1).getResult();
		System.out.println("E: " + eResult);
		
		return result;
	}

	@Override
	public String generateCode() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
