package first_level_class;

import java.util.ArrayList;

import second_level_class.EClass;
import second_level_class.OPRELClass;
import utils.FunctionCall;
import utils.ID;

public class EClassOprel extends EClass{
	
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

	@Override
	public void generateCode() {
		// TODO Auto-generated method stub
	}
	
	

}
