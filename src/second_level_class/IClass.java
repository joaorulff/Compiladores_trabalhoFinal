package second_level_class;

import java.util.ArrayList;


import compilador.Node;
import utils.FunctionDeclaration;

public abstract class IClass extends Node{
	
	public abstract ArrayList<FunctionDeclaration> getGlobalFunctions();

}
