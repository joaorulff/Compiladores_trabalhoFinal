package compilador;

import java.util.Arrays;

public class SeqClass extends Node {
	
	public SeqClass(Node seq, Node e) {
		this.nodes = Arrays.asList(seq, e);
	}

	public SeqClass(Node e) {
		this.nodes = Arrays.asList(e);
	}
	
	@Override
	public String getResult() throws Exception {
		String result = "";
		for(Node n:nodes) {
			result += n.getResult();
		}
		return result;
	}
}
