package compilador;

public class OPARITClass extends Node {
	
	public Token sum;

	public OPARITClass(Token sum) {
		super();
		this.sum = sum;
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
