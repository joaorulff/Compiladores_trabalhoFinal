package compilador;

import java.util.Arrays;

public class EClass extends Node{

	public String id;
	public Integer integer;

	public EClass(Token id, Token integer){
		this.id = id.value;
		try {
			this.integer = Integer.parseInt(integer.value);
			System.out.println(this.integer);
		} catch (NumberFormatException e) {
			this.integer = null;
			System.out.println("what");
		}
	}

	public EClass(Node e1, Node opArit, Node e2) {
		this.nodes = Arrays.asList(e1, opArit, e2);
	}
	
	public EClass(Node e1, Node opRel, Node e2, Node e3, Node e4) {
		this.nodes = Arrays.asList(e1, opRel, e2, e3, e4);
	}
	
	public EClass(Node args) {
		this.nodes = Arrays.asList(args);
	}
	
	public EClass(Token id, Node seq) {
		this.id = id.value;
		this.nodes = Arrays.asList(seq);
	}
	
	private boolean isNumeric(String n) {
		try {
			Integer.parseInt(n);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	@Override
	public String getResult() throws Exception {
		String result = "";
		if(this.id != null && !this.id.isEmpty()) {
			result = this.id;
		} else if(this.integer != null) {
			result = this.integer.toString();
		}

		if(result != null && !isNumeric(result)){
			SemanticAnalysis sem = SemanticAnalysis.getInstance(null);
			if(!sem.isInScope(result)){
				throw new Exception("Variavel nao declarada: " + result);
			}
		}
		
		for(Node n:nodes) {
			result += n.getResult();
		}

		return result;
	}
}
