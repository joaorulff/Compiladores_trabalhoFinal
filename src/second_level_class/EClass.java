package second_level_class;

import java.util.ArrayList;

import compilador.Node;
import utils.FunctionCall;
import utils.ID;

public abstract class EClass extends Node{
	private Integer index;
	
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public Integer getIndex() {
		return this.index;
	}
	
	public ArrayList<EClass> getAllUsedExpressions() {
		ArrayList<EClass> exp = new ArrayList<>();
		exp.add(this);
		return exp;
	}
	
	public abstract int numberOfFunctionCalls();
	public abstract ArrayList<FunctionCall> getFunctionCalls();
	public abstract ArrayList<ID> getAllUsedIdentifiers();
}
