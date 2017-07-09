package first_level_class;

import java.util.ArrayList;
import java.util.List;

import second_level_class.EClass;
import second_level_class.OPRELClass;
import utils.FunctionCall;
import utils.ID;

public class EClassOprel extends EClass{
	
	////Corresponding rule: E ::= IF E1 OPREL E2 THEN E3 ELSE E4
	
	public EClass e1, e2, e3, e4;
	public OPRELClass oprel;
	
	public EClassOprel(EClass e1, OPRELClass oprel, EClass e2, EClass e3, EClass e4) {
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;
		this.e4 = e4;
		this.oprel = oprel;
	}

	@Override
	public int numberOfFunctionCalls() {
		return (this.e1.numberOfFunctionCalls() + this.e2.numberOfFunctionCalls() + this.e3.numberOfFunctionCalls() + this.e4.numberOfFunctionCalls());
	}

	@Override
	public ArrayList<FunctionCall> getFunctionCalls() {
		ArrayList<FunctionCall> functionCallsE1 = this.e1.getFunctionCalls();
		ArrayList<FunctionCall> functionCallsE2 = this.e2.getFunctionCalls();
		ArrayList<FunctionCall> functionCallsE3 = this.e3.getFunctionCalls();
		ArrayList<FunctionCall> functionCallsE4 = this.e4.getFunctionCalls();
		
		functionCallsE1.addAll(functionCallsE2);
		functionCallsE1.addAll(functionCallsE3);
		functionCallsE1.addAll(functionCallsE4);
		
		return functionCallsE1;
	}

	@Override
	public ArrayList<ID> getAllUsedIdentifiers() {
		ArrayList<ID> e1Ids = this.e1.getAllUsedIdentifiers();
		ArrayList<ID> e2Ids = this.e2.getAllUsedIdentifiers();
		ArrayList<ID> e3Ids = this.e3.getAllUsedIdentifiers();
		ArrayList<ID> e4Ids = this.e4.getAllUsedIdentifiers();
		
		e1Ids.addAll(e2Ids);
		e1Ids.addAll(e3Ids);
		e1Ids.addAll(e4Ids);
		
		return e1Ids;
	}

	@Override
	public void printTree() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ID getResult() {
		return null;
	}
	
	private List<String> generateOperationInstruction(){
		String op = this.oprel.operator.value;
		List<String> result = new ArrayList<>();
		switch(op) {
			case "=":
				result.add("beq $a0 $t1 true_branch"  + this.hashCode());
				break;
			case ">":
				result.add("sgt $t1 $t1 $a0");
				result.add("beq $t1 1 true_branch" + this.hashCode());
				break;
			case "<":
				result.add("slt $t1 $t1 $a0");
				result.add("beq $t1 1 true_branch"  + this.hashCode());
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
		result.add("addiu $sp $sp 4");
		result.addAll(generateOperationInstruction());
		result.add("false_branch" + this.hashCode() + ":");
		result.addAll(e4.generateCode());
		result.add("b end_if" + this.hashCode());
		result.add("true_branch" + this.hashCode() + ":");
		result.addAll(e3.generateCode());
		result.add("end_if" + this.hashCode() + ":");
		return result;
	}
	
	public void printType(){
		System.out.println("EClassOprel");
	}
	
}
