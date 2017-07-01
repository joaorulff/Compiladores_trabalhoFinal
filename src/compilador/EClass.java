package compilador;

public class EClass implements Node{
	
	public Token id, integer, _if, then, _else, open, close;
	public Node E1, E2, E3, E4, OPREL, OPARIT, SEQ, test;
	
	public EClass(Token id, Token open, Node SEQ, Token close) {
		super();
		this.id = id;
		this.open = open;
		this.close = close;
		this.SEQ = SEQ;
	}

	

	
	public EClass(Token integer){
		this.integer = integer;
	}
	
	public EClass(Node e1, Node oparit, Node e2){
		this.E1 = e1;
		this.OPARIT = oparit;
		this.E2 = e2;
	}
	
	public EClass(Token _if, Node e1, Node oprel, Node e2, Token then, Node e3, Token _else, Node e4){
		this._if = _if;
		this.E1 = e1;
		this.E2 = e2;
		this.E3 = e3;
		this.E4 = e4;
		this.OPREL = oprel;
		this.then = then;
		this._else = _else;
	} 
	
	
	
}
