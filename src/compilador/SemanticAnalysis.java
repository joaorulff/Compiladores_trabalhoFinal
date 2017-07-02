package compilador;

import java.util.List;

public class SemanticAnalysis {
	
/*
	a) os identificadores que aparecem em cada função são passados como parâmetros.
	b) as funções chamadas foram definidas e com a quantidade de parâmetros compatível.
	c) não há parâmetros repetidos (na declaração de uma função). OK
	d) não há funções declaradas mais de uma vez.
*/
	private Node parseTree;
	private SymbolTable table;
	
	public SemanticAnalysis(Node parseTree) {
		this.parseTree = parseTree;
		this.table = new SymbolTable();
	}
	
	public void analyze() {
		System.out.println(this.parseTree.getResult());
	}
		
	private void paramsValid(List<Token> tokens) {
		//should check if the amount of params passed is correct
		//should check if the params passed are valid
	}
	
	private void isValid(Token t) {
		//should check if the param has been defined in the context
	}
	
	private void isDefined(Token t) {
		//should check if the token was already declared
	}
	
	
}
