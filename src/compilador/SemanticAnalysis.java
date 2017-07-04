package compilador;

public class SemanticAnalysis {
	
/*
	Verificar se:
		a) os identificadores que aparecem em cada funcao sao passados como parametros. OK
		b) as funcoes chamadas foram definidas e com a quantidade de parametros compativel.
		c) nao ha parametros repetidos (na declaracao de uma funcao). OK
		d) nao ha funcoes declaradas mais de uma vez. OK
*/
	public Node parseTree;
	private SymbolTable table;
	
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
		String result = this.parseTree.getResult();
	}
	
	public void enterScope() {
		this.table.enterScope();
	}
	
	public void addSymbol(String sym) {
		this.table.addSymbol(sym);
	}
	
	public boolean isInScope(String sym) {
		return this.table.isInScope(sym);
	}
	
	public void exitScope() {
		this.table.exitScope();
	}
	
}
