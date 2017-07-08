package first_level_class;

import java.util.ArrayList;
import java.util.List;

import second_level_class.IClass;
import second_level_class.PClass;
import utils.FunctionDeclaration;
import utils.ID;

public class PClassDef extends PClass{
	
	//Corresponding Rule: P ::= I:i
	
	public IClass i;
	
	public PClassDef(IClass i) {
		this.i = i;
	}

	@Override
	public int numberOfGlobalVariablesDeclared() {
		return 0;
	}

	@Override
	public void printTree() {
		System.out.println();
		System.out.print("I: ");
		this.i.printTree();
	}

	@Override
	public ArrayList<ID> globalIDsDeclared() {
		return null;
	}

	@Override
	public ArrayList<FunctionDeclaration> globalFunctionsDeclared() {
		ArrayList<FunctionDeclaration> result = this.i.getGlobalFunctions();
		return result;
	}

	@Override
	public List<String> generateCode() {
		return this.i.generateCode();
	}
	
}
