package first_level_class;

import java.util.ArrayList;


import second_level_class.DClass;
import second_level_class.IClass;
import utils.FunctionDeclaration;

public class IClassCompound extends IClass{
	
	////Corresponding rule: I ::= D:d I:i
	
	public DClass d;
	public IClass i;
	
	public IClassCompound(DClass d, IClass i){
		
		this.d = d;
		this.i = i;
		
	}
	
	
	public void printTree() {
		
		System.out.println("-------------");
		d.printTree();  i.printTree();
		
	}


	@Override
	public ArrayList<FunctionDeclaration> getGlobalFunctions() {
		
		ArrayList<FunctionDeclaration> thisFunction = new ArrayList<>();
		thisFunction.add(this.d.getFunction());
		
		ArrayList<FunctionDeclaration> temp = this.i.getGlobalFunctions();
		thisFunction.addAll(temp);
		
		return thisFunction;
	}
	
	
}