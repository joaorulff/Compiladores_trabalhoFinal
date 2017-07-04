package second_level_class;

import java.util.ArrayList;
import java.util.Arrays;

import compilador.Node;
import compilador.SemanticAnalysis;
import compilador.Token;
import utils.FunctionCall;
import utils.ID;

public abstract class EClass extends Node{
	
	
	public abstract int numberOfFunctionCalls();
	public abstract ArrayList<FunctionCall> getFunctionCalls();
	public abstract ArrayList<ID> getAllUsedIdentifiers();
	
	
}
