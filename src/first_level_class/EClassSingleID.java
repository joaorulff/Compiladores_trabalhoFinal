package first_level_class;

import java.util.ArrayList;
import java.util.List;

import compilador.Token;
import second_level_class.EClass;
import utils.FunctionCall;
import utils.ID;

public class EClassSingleID extends EClass {
	
	////Corresponding rule: E ::= ID
	
	public String id;
	
	public EClassSingleID(Token id) {
		this.id = id.value;
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
		ID thisID = new ID(this.id, this);
		
		ArrayList<ID> usedIds = new ArrayList<>();
		usedIds.add(thisID);
		
		return usedIds;
	}

	@Override
	public List<String> generateCode() {
		List<String> result = new ArrayList<>();
		result.add("lw $a0 " + 4 * this.getIndex() + "($fp)");
		return result;

	}

}
