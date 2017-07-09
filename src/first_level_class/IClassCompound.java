package first_level_class;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public ArrayList<FunctionDeclaration> getGlobalFunctions() {
		ArrayList<FunctionDeclaration> thisFunction = new ArrayList<>();
		thisFunction.add(this.d.getFunction());
		
		ArrayList<FunctionDeclaration> temp = this.i.getGlobalFunctions();
		
		if(temp.size() > 0 && temp != null){
			thisFunction.addAll(temp);
		}
		
		return thisFunction;
	}

	@Override
	public List<String> generateCode() {
		List<String> result = new ArrayList<>(this.d.generateCode());
		result.addAll(this.i.generateCode());
		return result;
	}
	
}
