package first_level_class;

import java.util.ArrayList;

import second_level_class.EClass;
import second_level_class.OPARITClass;
import utils.FunctionCall;
import utils.ID;

public class EClassOparit extends EClass{
	
	public EClass e1, e2;
	public OPARITClass oparit;
	
	public EClassOparit(EClass e1, EClass e2, OPARITClass oparit) {
		
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
		
		e1IDs.addAll(e2IDs);
		
		return e1IDs;
	}

	@Override
	public void printTree() {
		// TODO Auto-generated method stub
		
	}
	
	

}
