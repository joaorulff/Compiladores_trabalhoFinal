package second_level_class;

import java.util.ArrayList;


import compilador.Node;
import utils.FunctionDeclaration;
import utils.ID;

public abstract class PClass extends Node{
	
	public abstract int numberOfGlobalVariablesDeclared();
	public abstract ArrayList<ID> globalIDsDeclared();
	public abstract ArrayList<FunctionDeclaration> globalFunctionsDeclared();
	
}
