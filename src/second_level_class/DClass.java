package second_level_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import compilador.Node;
import compilador.SemanticAnalysis;
import compilador.Token;
import utils.FunctionDeclaration;

public abstract class DClass extends Node {


	public abstract FunctionDeclaration getFunction();
	
}
