package compilador;

public class OPRELClass extends Node{
	
	public Token equal;

	public OPRELClass(Token equal) {
		super();
		this.equal = equal;
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
