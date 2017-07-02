package compilador;

import java.util.Arrays;
import java.util.HashSet;
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
	public String getResult() {
		String result = this.definedFn;
		for(Node n:nodes) {
			result += n.getResult();
		}
		return result;
	}

}
