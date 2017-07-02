package compilador;

import java.util.ArrayList;
import java.util.Arrays;

public class ArgsClass extends Node{
	
	public String id;
	
	public ArgsClass(Token id, Node args) {
		this.id = id.value;
		this.nodes = Arrays.asList(args);
		System.out.println(this.getResult());
	}
	
	public ArgsClass(Token id){
		this.id = id.value;
		this.nodes = new ArrayList<Node>();
	}
	
	@Override
	public String getResult() {
		String result = this.id;
		for(Node n:nodes) {
			result += n.getResult();
		}
		return result;
	}
}
