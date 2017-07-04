package compilador;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IClass extends Node{
	
	public IClass(Node d, Node i) {
		this.nodes = Arrays.asList(d, i);
	}
	
	public IClass(Node n){
		this.nodes = Arrays.asList(n);
	}
	
	@Override
	public String getResult() throws Exception {
		String result = "";
		for(Node n:nodes) {
			result += n.getResult();
		}
		this.validateDefinition(result);
		return result;
	}
	
	private void validateDefinition(String defs) throws Exception {
		List<String> defList = Arrays.asList(defs.split(","));
		Set<String> defSet = new HashSet<String>(defList);
		if(defSet.size() < defList.size()) {
			throw new Exception("Multiplas funcoes declaradas com o mesmo nome.");
		}
	}
}
