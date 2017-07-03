package compilador;

import java.util.List;

public class SemanticAnalysis {
	
/*
	a) os identificadores que aparecem em cada fun��o s�o passados como par�metros. OK
	b) as fun��es chamadas foram definidas e com a quantidade de par�metros compat�vel.
	c) n�o h� par�metros repetidos (na declara��o de uma fun��o). OK
	d) n�o h� fun��es declaradas mais de uma vez.
*/
	public Node parseTree;
	public SymbolTable table;
	
	private static SemanticAnalysis instance = null;
	
	private SemanticAnalysis(Node parseTree){
		this.parseTree = parseTree;
		this.table = new SymbolTable();
	}
	
	public static SemanticAnalysis getInstance(Node parseTree){
		
		if (instance == null){
			instance = new SemanticAnalysis(parseTree);
		}
		
		return instance;
	}
	
	
	public void analyze() throws Exception {
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
