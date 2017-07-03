package compilador;

import java.util.ArrayList;
import java.util.Arrays;

public class EClass extends Node{

	public String id;
	public Integer integer;

	public EClass(Token id, Token integer){
		this.id = id.value;
		try {
			this.integer = Integer.parseInt(integer.value);
		} catch (NumberFormatException e) {
			this.integer = null;
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
	
	
	@Override
	public String getResult() throws Exception {
		String result = this.id;
		
		if(result != null){
			SemanticAnalysis a = SemanticAnalysis.getInstance(null);
			if(!a.table.isInScope(id)){
				throw new Exception("Variavel não declarada");
			}
		}
		
		
		for(Node n:nodes) {
			result += ","+n.getResult();
		}
		return result;
	}

	@Override
	public String generateCode() {
		// TODO Auto-generated method stub
		return null;
	}
}
