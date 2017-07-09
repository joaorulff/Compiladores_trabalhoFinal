package first_level_class;

import java.util.ArrayList;
import java.util.List;

import second_level_class.DClass;
import second_level_class.IClass;
import utils.FunctionDeclaration;

public class IClassSingle extends IClass{
	
	//Corresponding rule: I ::= D:d
	
	public DClass d;
	
	public IClassSingle(DClass d){
		this.d = d;
	}
	
	@Override
	public ArrayList<FunctionDeclaration> getGlobalFunctions() {
		ArrayList<FunctionDeclaration> thisFunction = new ArrayList<>();
		thisFunction.add(this.d.getFunction());
		
		return thisFunction;
	}

	@Override
	public List<String> generateCode() {
		return this.d.generateCode();
	}

}
