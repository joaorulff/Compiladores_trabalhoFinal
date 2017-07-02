package compilador;

public class OPARITClass extends Node {
	
	public Token sum;

	public OPARITClass(Token sum) {
		super();
		this.sum = sum;
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
