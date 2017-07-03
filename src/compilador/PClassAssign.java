package compilador;

import java.util.Arrays;

public class PClassAssign extends Node {
	
	public String definedVar;
	public Integer value;
	
	public PClassAssign(Token definedVar, Token integer, Node p) {
		this.definedVar = definedVar.value;
		this.value = Integer.parseInt(integer.value);
		this.nodes = Arrays.asList(p);
	}
	
	public PClassAssign(Node i){
		this.nodes = Arrays.asList(i);
	}
	
	@Override
	public String getResult() {
		String result = this.definedVar;
		for(Node n:nodes) {
			try {
				result += n.getResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public String generateCode() {
		
		
		
		return null;
	}
}
