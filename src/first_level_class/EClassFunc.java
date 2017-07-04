package first_level_class;

import java.util.ArrayList;
import java.util.Set;

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
		
		ArrayList<ID> params = this.seq.getAllSeqIds();
		FunctionCall functionCall = new FunctionCall(this.id, params, this.seq);
		
		ArrayList<FunctionCall> thisCall = new ArrayList<>();
		thisCall.add(functionCall);
		
		return thisCall;
	}

	@Override
	public ArrayList<ID> getAllUsedIdentifiers() {
		
		ArrayList<ID> usedIds = this.seq.getAllSeqIds();
		
		return usedIds;
	}

	@Override
	public void printTree() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ID getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateCode() {
		// TODO Auto-generated method stub
	}
	
	

}
