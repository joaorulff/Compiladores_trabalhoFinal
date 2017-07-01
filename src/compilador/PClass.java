package compilador;

public class PClass implements Node {
	
	public Token id, equal, integer, endstmt;
	public Node P;
	public Node I;
	
	public PClass(Token id, Token equal, Token integer, Token endstmt, PClass p) {
		super();
		this.id = id;
		this.equal = equal;
		this.integer = integer;
		this.endstmt = endstmt;
		this.P = p;
	}
	
	public PClass(IClass i){
		
		this.I = i;
		
	}
	
	
	
	
	
	

}
