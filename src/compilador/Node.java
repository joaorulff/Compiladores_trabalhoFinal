package compilador;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {
	
	public List<Node> nodes;
	
	public Node() {
		nodes = new ArrayList<Node>();
	}
	
//	public abstract String getResult() throws Exception;
	public abstract List<String> generateCode();
	
	public abstract void printTree();
}
