package compilador;

public class SeqClass implements Node {
	
	public Token comma;
	public Node E, SEQ;
	
	public SeqClass(Node SEQ, Token comma, Node e) {
		this.comma = comma;
		E = e;
		this.SEQ = SEQ;
	}

	public SeqClass(Node e) {
		E = e;
	}
	
	
	

}
