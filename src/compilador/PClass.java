package compilador;

import java.util.Arrays;

public class PClass extends Node {
	
	public String definedVar;
	public Integer value;
	
	public PClass(Token definedVar, Token integer, Node p) {
		this.definedVar = definedVar.value;
		this.value = Integer.parseInt(integer.value);
		this.nodes = Arrays.asList(p);
	}
	
	public PClass(Node i){
		this.nodes = Arrays.asList(i);
	}
	
	@Override
	public String getResult() throws Exception{
		String result = this.definedVar;
		for(Node n:nodes) {
			result += n.getResult();
		}
		return result;
	}
}
