package compilador;

public class ArgsClass implements Node{
	
	public Token id, comma;
	public Node ARGS;
	
	public ArgsClass(Token id, Token comma, Node aRGS) {
		super();
		this.id = id;
		this.comma = comma;
		ARGS = aRGS;
	}
	
	public ArgsClass(Token id){
		this.id = id;
	}
	
	
	
	
}
