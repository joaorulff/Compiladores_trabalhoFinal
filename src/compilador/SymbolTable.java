package compilador;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;
import java_cup.runtime.Symbol;

public class SymbolTable {
	
	//ArrayList<Symbol> is a scope
	private Stack<ArrayList<String>> table;
	
	public SymbolTable() {
		this.table = new Stack<ArrayList<String>>();
	}

	public void enterScope(){
		
		this.table.push(new ArrayList<String>());
	}
	
	public void addSymbol(String sym) {
		
		ArrayList<String> s = this.table.peek();
		s.add(sym);
	}
	
	
	public boolean isInScope(String sym) {
		ArrayList<String> s = this.table.peek();
		return s.contains(sym);
	}
	
	public void exitScope() {
		this.table.pop();
	}

}
