package compilador;

public class DClass implements Node {
	
	public Token def, id, open, close, equal, endstmt;
	public Node ARGS, E;
	
	
	public DClass(Token def, Token id, Token open, Node ARGS, Token close, Token equal,  Node E, Token endstmt) {
		super();
		this.def = def;
		this.id = id;
		this.open = open;
		this.close = close;
		this.equal = equal;
		this.endstmt = endstmt;
		this.ARGS = ARGS;
	}
	
	

}
