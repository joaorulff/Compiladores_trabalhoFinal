package first_level_class;

import java.util.ArrayList;

import compilador.Token;
import second_level_class.EClass;
import utils.FunctionCall;
import utils.ID;

public class EClassSingleInt extends EClass{
	
	public Integer integer;
	
	public EClassSingleInt(Token integer) {
		this.integer = Integer.parseInt(integer.value);
	}


	@Override
	public int numberOfFunctionCalls() {
		return 0;
	}

	@Override
	public ArrayList<FunctionCall> getFunctionCalls() {
		ArrayList<FunctionCall> functionCalls = new ArrayList<>();
		return functionCalls;
	}

	@Override
	public ArrayList<ID> getAllUsedIdentifiers() {
		ArrayList<ID> usedIds = new ArrayList<>();
		return usedIds;
	}
	
	@Override
	public void printTree() {
		System.out.println(this.integer);
	}

}
