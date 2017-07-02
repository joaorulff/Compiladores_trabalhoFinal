package compilador;

import java.util.Arrays;

public class IClass extends Node{
	
	public IClass(Node d, Node i) {
		this.nodes = Arrays.asList(d, i);
	}
	
	public IClass(Node n){
		this.nodes = Arrays.asList(n);
	}
	
	@Override
	public String getResult() {
		String result = "";
		for(Node n:nodes) {
			result += n.getResult();
		}
		return result;
	}
}
