package compilador;

import java.util.ArrayList;
import java.util.Stack;
import java_cup.runtime.Symbol;

public class SymbolTable {
	
	//ArrayList<Symbol> is a scope
	private Stack<ArrayList<Symbol>> table;
	
	public SymbolTable() {
		this.table = new Stack<ArrayList<Symbol>>();
	}

	public void enterScope(){
		this.table.push(new ArrayList<Symbol>());
	}
	
	public void addSymbol(Symbol sym) {
		ArrayList<Symbol> s = this.table.peek();
		s.add(sym);
	}
	
	public boolean isInScope(Symbol sym) {
		ArrayList<Symbol> s = this.table.peek();
		return s.contains(sym);
	}
	
	public void exitScope() {
		this.table.pop();
	}

}
