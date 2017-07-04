package first_level_class;

import java.util.ArrayList;

import compilador.Token;
import second_level_class.EClass;
import second_level_class.SeqClass;
import utils.FunctionCall;
import utils.ID;

public class EClassFunc extends EClass{

	public SeqClass seq;
	public String id;
	
	public EClassFunc(Token id, SeqClass seq) {
		
		this.id = id.value;
		this.seq = seq;
		
	}
	
	@Override
	public int numberOfFunctionCalls() {
		return 1;
	}

	@Override
	public ArrayList<FunctionCall> getFunctionCalls() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ID> getAllUsedIdentifiers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printTree() {
		// TODO Auto-generated method stub
		
	}
	
	

}
