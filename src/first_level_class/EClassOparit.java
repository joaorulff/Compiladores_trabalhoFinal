package first_level_class;

import java.util.ArrayList;
import java.util.List;

import second_level_class.EClass;
import second_level_class.OPARITClass;
import utils.FunctionCall;
import utils.ID;

public class EClassOparit extends EClass{
	
	public EClass e1, e2;
	public OPARITClass oparit;
	
	public EClassOparit(EClass e1, OPARITClass oparit, EClass e2) {
		this.e1 = e1;
		this.e2 = e2;
		this.oparit = oparit;
	}

	@Override
	public int numberOfFunctionCalls() {
		return (this.e1.numberOfFunctionCalls() + e2.numberOfFunctionCalls());
	}

	@Override
	public ArrayList<FunctionCall> getFunctionCalls() {
		ArrayList<FunctionCall> functionCallsE1 = this.e1.getFunctionCalls();
		ArrayList<FunctionCall> functionCallsE2 = this.e2.getFunctionCalls();
		
		functionCallsE1.addAll(functionCallsE2);
		
		return functionCallsE1;
	}

	@Override
	public ArrayList<ID> getAllUsedIdentifiers() {
		ArrayList<ID> e1IDs = this.e1.getAllUsedIdentifiers();
		ArrayList<ID> e2IDs = this.e2.getAllUsedIdentifiers();
		if( (e1IDs.size() > 0 && e1IDs != null) && (e2IDs.size() > 0 && e2IDs != null)){
			e1IDs.addAll(e2IDs);
		}
		return e1IDs;
	}
	
	private List<String> generateOperationInstruction(){
		String op = this.oparit.operator.value;
		List<String> result = new ArrayList<>();
		switch(op) {
			case "+":
				result.add("add $a0 $t1 $a0");
				break;
			case "-":
				result.add("sub $a0 $t1 $a0");
				break;
			case "*":
				//resultado 32bits
				result.add("mult $t1 $a0");
				result.add("mflo $a0");
				break;
			case "/":
				result.add("div $a0 $t1 $a0");
				break;
		}
		return result;
	}

	@Override
	public List<String> generateCode() {
		List<String> result = new ArrayList<>();
		result.addAll(e1.generateCode());
		result.add("sw $a0 0($sp)");
		result.add("addiu $sp $sp -4");
		result.addAll(e2.generateCode());
		result.add("lw $t1 4($sp)");
		result.addAll(this.generateOperationInstruction());
		result.add("addiu $sp $sp 4");
		return result;
	}
	
}
