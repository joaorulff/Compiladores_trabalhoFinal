package compilador;

public class OPRELClass extends Node{
	
	public Token equal;

	public OPRELClass(Token equal) {
		super();
		this.equal = equal;
	}
	
	@Override
	public String getResult() throws Exception {
		String result = "";
		for(Node n:nodes) {
			result += n.getResult();
		}
		return result;
	}

	@Override
	public String generateCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
